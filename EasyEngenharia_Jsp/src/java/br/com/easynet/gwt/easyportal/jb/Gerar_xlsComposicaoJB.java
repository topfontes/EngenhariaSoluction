/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.transfer.Coa_composicao_anteriorT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.jb.EasyDownloadJB;
import java.io.ByteArrayOutputStream;
import java.util.List;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author marcos
 */
public class Gerar_xlsComposicaoJB extends SystemBase implements INotSecurity{

    private Obr_obrasT obr_obrasT = new Obr_obrasT();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    

    public void gerarArquivoXls() {
        try {

            List<Coa_composicao_anteriorT> list = getCoa_composicao_anteriorDAO().getAll();


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableWorkbook workbook = Workbook.createWorkbook(baos);
            WritableSheet sheet = workbook.createSheet("PMS", 0);
            WritableFont arial12font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            WritableFont arial12fontWidth = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            arial12fontWidth.setPointSize(500);
            WritableCellFormat arial12format = new WritableCellFormat(arial12font);
            WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10);
            WritableCellFormat arial10format = new WritableCellFormat(arial10font);

            //titulo
            Label label = new Label(0, 1, "Obra: " + getObr_obrasT().getObr_tx_nome(), arial10format);
            sheet.addCell(label);

            String[] cabecalhoColunas = {"Código", "Composição"};
            WritableCellFormat formatTitile = new WritableCellFormat(NumberFormats.FLOAT);
            formatTitile.setBackground(Colour.GOLD);

            WritableCellFormat formatkey = new WritableCellFormat(NumberFormats.FLOAT);
            formatkey.setBackground(Colour.GOLD);

            for (int i = 0; i < cabecalhoColunas.length; i++) {
                String title = cabecalhoColunas[i];
                label = new Label(i, 1, title, formatTitile);
                sheet.addCell(label);
            }

            WritableCellFormat wt = new WritableCellFormat(NumberFormats.FLOAT);
            wt.setBackground(Colour.GOLD);
            wt.setAlignment(Alignment.RIGHT);
            wt.setFont(arial10font);

            int y = 5;
            for (int i = 0; i < list.size(); i++) {
                int x = 0;
                label = new Label(x++, y, list.get(i).getCoa_tx_codigo() + "", arial10format);
                sheet.addCell(label);

                label = new Label(x++, y++, list.get(i).getCoa_tx_descricao() + "", arial10format);
                sheet.addCell(label);
            }

            String filename = "Composição.xls";
            getSession().setAttribute("baos", baos);
            getSession().setAttribute("filename", filename);
            workbook.write();
            workbook.close();
            download(baos, filename);
            setMsg("Arquivo gerado com sucesso!");

        } catch (Exception e) {
        }

    }
    public void download(ByteArrayOutputStream baos, String filename) throws Exception {
        try {
            if (baos != null) {
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "arquivo/xls");
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, filename);
                getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
                getPage().forward("/portal/easydownload.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }
    /**
     * @return the obr_obrasT
     */
    public Obr_obrasT getObr_obrasT() {
        return obr_obrasT;
    }

    /**
     * @param obr_obrasT the obr_obrasT to set
     */
    public void setObr_obrasT(Obr_obrasT obr_obrasT) {
        this.obr_obrasT = obr_obrasT;
    }


}
