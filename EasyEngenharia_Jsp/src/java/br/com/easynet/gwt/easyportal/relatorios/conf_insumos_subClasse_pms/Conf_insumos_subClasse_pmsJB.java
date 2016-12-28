/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.conf_insumos_subClasse_pms;

import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_equiv_insumo_pmsDAO;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.gwt.easyportal.transfer.Vw_equiv_insumo_pmsT;
import br.com.easynet.jb.EasyDownloadJB;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author marcos
 */
public class Conf_insumos_subClasse_pmsJB extends SystemBase {

    private Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT = new Vw_equiv_insumo_pmsT();
    private boolean acumulado;
    private String subClasse;

  public void setVw_equiv_insumo_pmsT(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) {
    this.vw_equiv_insumo_pmsT = vw_equiv_insumo_pmsT;
  }

  public Vw_equiv_insumo_pmsT getVw_equiv_insumo_pmsT() {
    return vw_equiv_insumo_pmsT;
  }



  private List<Vw_equiv_insumo_pmsT> list;

  public List<Vw_equiv_insumo_pmsT> getList() {
    return list;
  }

  public void setList(List<Vw_equiv_insumo_pmsT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        //consult();
  }

  public void consult() throws Exception {
    try {
      Vw_equiv_insumo_pmsDAO vw_equiv_insumo_pmsDAO = getVw_equiv_insumo_pmsDAO();
      list = vw_equiv_insumo_pmsDAO.getByPlc_nr_id(vw_equiv_insumo_pmsT, isAcumulado());
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");
    } finally {
	close();
    }
  }

    public void imprimir() {
        Vw_equiv_insumo_pmsDAO vdao =null;
        try {
            vdao  = getVw_equiv_insumo_pmsDAO();

            list = vdao.getByPlc_nr_id(vw_equiv_insumo_pmsT, isAcumulado());
            float total=0;
            for (Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT : list) {
                total +=  vw_equiv_insumo_pmsT.getVl_executado();
            }
            Obr_obrasDAO odao = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = new Obr_obrasT();
            obr_obrasT.setObr_nr_id(vw_equiv_insumo_pmsT.getObr_nr_id());
            obr_obrasT = odao.getByObr_nr_id(obr_obrasT).get(0);

            JRDataSource jrds = new JRBeanCollectionDataSource(list);
            Map parameters = new HashMap();
            
            String ref = odao.getStrMesAno(vw_equiv_insumo_pmsT.getPms_nr_mes(), vw_equiv_insumo_pmsT.getPms_nr_ano());
            parameters.put("paramTotal", total);
            parameters.put("paramObra", obr_obrasT.getObr_tx_nome());
            parameters.put("paramReferencia", ref);
            parameters.put("paramSubClasse", subClasse);

            URL url  = Conf_insumos_subClasse_pmsJB.class.getResource("Conf_insumos_subClasse_pmsJB.jasper") ;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            JasperReport jasper = (JasperReport)JRLoader.loadObject(url);
            JasperPrint jasperPrint =  JasperFillManager.fillReport(jasper, parameters, jrds);

            JRXlsExporter xls = new JRXlsExporter();
            xls.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            xls.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,baos);
            xls.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,Boolean.TRUE);
            xls.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
            xls.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET,Integer.decode("65000"));
            xls.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,   Boolean.FALSE);
            xls.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);

            xls.exportReport();

            String filename = "insumo_pms_subClasse-" + obr_obrasT.getObr_tx_nome() + "_" + ref + ".xls";
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/xls");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, filename);
            getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
            getPage().forward("/portal/easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("erro");
        }finally{
            //vdao.close();
            close();
        }
    }

    /**
     * @return the acumulado
     */
    public boolean isAcumulado() {
        return acumulado;
    }

    /**
     * @param acumulado the acumulado to set
     */
    public void setAcumulado(boolean acumulado) {
        this.acumulado = acumulado;
    }

    /**
     * @return the subClasse
     */
    public String getSubClasse() {
        return subClasse;
    }

    /**
     * @param subClasse the subClasse to set
     */
    public void setSubClasse(String subClasse) {
        this.subClasse = subClasse;
    }


}
