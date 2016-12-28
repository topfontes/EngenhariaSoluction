/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.relatorios.cronograma_competencia;


import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.gwt.easyportal.transfer.crc_cronograna_regime_competenciaT;
import br.com.easynet.jb.EasyDownloadJB;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//br.com.easynet.gwt.easyportal.relatorios.cronograma_competencia.Rel_crono_regime_competencia
 
/**
 *
 * @author marcos
 */
public class Rel_crono_regime_competencia extends SystemBase {
    private Obr_obrasT obr_obrasT = new Obr_obrasT();
    private int mes;
    private int ano;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }
     
    public void imprimir(){
        try {
            List<crc_cronograna_regime_competenciaT>list = new Vector<crc_cronograna_regime_competenciaT>();
            crc_cronograna_regime_competenciaT t = new crc_cronograna_regime_competenciaT();
            t.setCodigo("0101");
            t.setServico("nova teste");
            list.add(t);
            JRDataSource jrds = new JRBeanCollectionDataSource(list);
            Map parameters = new HashMap();

            // Dados da Nota
            parameters.put("referencia", "Novembro/2010");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            InputStream is = Rel_crono_regime_competencia.class.getResourceAsStream("novo.jasper");
            JasperFillManager.fillReportToStream(is, baos, parameters, jrds);
 
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(bais, baos);
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/pdf");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "pdf.pdf");
            getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
            getPage().forward("/portal/easydownload.jsp");            
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("erro");
        }finally{
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

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

}
