package br.com.easynet.gwt.easyportal.relatorios.custo_plc_pms;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_insumo_plc_pmsDAO;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.gwt.easyportal.transfer.Vw_insumo_plc_pmsT;
import br.com.easynet.jb.EasyDownloadJB;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
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
public class Custo_Plc_pmsJB extends SystemBase {

    private Vw_insumo_plc_pmsT vw_insumo_plc_pmsT = new Vw_insumo_plc_pmsT();
    private boolean acumulado;
    private String tipo;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        Obr_obrasDAO odao = null;
        try {
            DataSet ds = null;
            odao = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = new Obr_obrasT();
            obr_obrasT.setObr_nr_id(vw_insumo_plc_pmsT.getObr_nr_id());
            obr_obrasT = odao.getByObr_nr_id(obr_obrasT).get(0);
            Vw_insumo_plc_pmsDAO vdao = getVw_insumo_plc_pmsDAO();
            ds = vdao.getResumoPmsPlc(vw_insumo_plc_pmsT, acumulado, tipo);
            List<Vw_insumo_plc_pmsT> list = new Vector();
            float total = 0;
            for (int i = 0; i < ds.getList().size(); i++) {
                Vw_insumo_plc_pmsT vt = new Vw_insumo_plc_pmsT();
                vt.setPlc_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("id").toString()));
                vt.setPlc_tx_nome(ds.getList().get(i).getColumn("conta").toString());
                vt.setVl_total(Float.parseFloat(ds.getList().get(i).getColumn("vl_total").toString()));
                total += vt.getVl_total();
                list.add(vt);
            }

            JRDataSource jrds = new JRBeanCollectionDataSource(list);
            Map parameters = new HashMap();

/*  exportar para PDF
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
            java.io.InputStream is = Custo_Plc_pmsJB.class.getResourceAsStream("custo_plc_pms.jasper");
            JasperFillManager.fillReportToStream(is, baos, parameters, jrds);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(bais, baos);
 */
            String ref = odao.getStrMesAno(vw_insumo_plc_pmsT.getPms_nr_mes(), vw_insumo_plc_pmsT.getPms_nr_ano());
            parameters.put("paramTotal", total);
            parameters.put("paramObra", obr_obrasT.getObr_tx_nome());
            parameters.put("paramReferencia", ref);
            
            URL url  = Custo_Plc_pmsJB.class.getResource("custo_plc_pms.jasper") ;
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

            String filename = "custo_" + obr_obrasT.getObr_tx_nome() + "_" + ref + ".xls";
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/xls");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, filename);
            getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
            getPage().forward("/portal/easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("erro");
        }finally{
            //odao.close();
            close();
        }
    }

    /**
     * @return the vw_insumo_plc_pmsT
     */
    public Vw_insumo_plc_pmsT getVw_insumo_plc_pmsT() {
        return vw_insumo_plc_pmsT;
    }

    /**
     * @param vw_insumo_plc_pmsT the vw_insumo_plc_pmsT to set
     */
    public void setVw_insumo_plc_pmsT(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) {
        this.vw_insumo_plc_pmsT = vw_insumo_plc_pmsT;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
