package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.jb.EasyDownloadJB;
import java.io.ByteArrayOutputStream;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_curva_abcConsultJB extends SystemBase {

  // Atributos e propriedades
    private Vw_curva_abcT vw_curva_abcT = new Vw_curva_abcT();
    private boolean exportar;

  public void setVw_curva_abcT(Vw_curva_abcT vw_curva_abcT) {
    this.vw_curva_abcT = vw_curva_abcT;
  }

  public Vw_curva_abcT getVw_curva_abcT() {	
    return vw_curva_abcT;
  }


	
  private List<Vw_curva_abcT> list;

  public List<Vw_curva_abcT> getList() {
    return list;
  }
  
  public void setList(List<Vw_curva_abcT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        
  }

  public void consult() throws Exception {
    try {
      Vw_curva_abcDAO vw_curva_abcDAO = getVw_curva_abcDAO();
      list = vw_curva_abcDAO.getByObr_nr_id(vw_curva_abcT);
      if(exportar){
          gerarArquivoXls();
      }
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }

    public void gerarArquivoXls() {
        try {

            Obr_obrasDAO odao = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = new Obr_obrasT();
            obr_obrasT.setObr_nr_id(vw_curva_abcT.getObr_nr_id());

            obr_obrasT = odao.getByObr_nr_id(obr_obrasT).get(0);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableWorkbook workbook = Workbook.createWorkbook(baos);
            WritableSheet sheet = workbook.createSheet("CurvaABC", 0);
            WritableFont arial12font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            WritableFont arial12fontWidth = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            arial12fontWidth.setPointSize(500);
            WritableCellFormat arial12format = new WritableCellFormat(arial12font);
            WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10);
            WritableCellFormat arial10format = new WritableCellFormat(arial10font);

            //titulo
            Label label = new Label(0, 1, "Obra: " + obr_obrasT.getObr_tx_nome(), arial10format);
            sheet.addCell(label);

            String[] cabecalhoColunas = {"Sub Classe", "Valor"};
            WritableCellFormat formatTitile = new WritableCellFormat(NumberFormats.FLOAT);
            formatTitile.setBackground(Colour.GOLD);

            WritableCellFormat formatkey = new WritableCellFormat(NumberFormats.FLOAT);
//            formatkey.setBackground(Colour.GOLD);

            for (int i = 0; i < cabecalhoColunas.length; i++) {
                String title = cabecalhoColunas[i];
                label = new Label(i, 4, title, formatTitile);
                sheet.addCell(label);
            }

            WritableCellFormat wt = new WritableCellFormat(NumberFormats.FLOAT);
            wt.setBackground(Colour.GOLD);
            wt.setAlignment(Alignment.RIGHT);
            wt.setFont(arial10font);

            NumberFormat numberFormat = new NumberFormat("#,##0.00");
            WritableCellFormat format = new WritableCellFormat(numberFormat);

            int y = 5;
            for (int i = 0; i < list.size(); i++) {
                int x = 0;
                label = new Label(x++, y, list.get(i).getPlco_tx_nome() + "", formatkey);
                sheet.addCell(label);
                float saldo = list.get(i).getTotal();
                jxl.write.Number number = new jxl.write.Number(x++, y++, saldo, format);
                sheet.addCell(number);
            }

            String filename = "CurvaABC_Insumos";
            filename += "-" + obr_obrasT.getObr_tx_nome() + ".xls";
            workbook.write();
            workbook.close();
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/xls");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, filename);
            getRequest().setAttribute(EasyDownloadJB.DATA,baos.toByteArray());
            getPage().forward("/portal/easydownload.jsp");
//            setMsg("Arquivo gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


  public void delete() throws Exception {
    try {
      Vw_curva_abcDAO vw_curva_abcDAO = getVw_curva_abcDAO();
      vw_curva_abcDAO.delete(vw_curva_abcT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      vw_curva_abcT = new Vw_curva_abcT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus�o!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "vw_curva_abcInsert.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the exportar
     */
    public boolean isExportar() {
        return exportar;
    }

    /**
     * @param exportar the exportar to set
     */
    public void setExportar(boolean exportar) {
        this.exportar = exportar;
    }

}
