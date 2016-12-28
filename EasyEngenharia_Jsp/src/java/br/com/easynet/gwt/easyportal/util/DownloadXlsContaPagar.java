/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.util;

import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.jb.EasyDownloadJB;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author marcos
 */
public class DownloadXlsContaPagar extends SystemBase{
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private Obr_obrasT obr_obrasT;
    private String status;
    private String nm_arquivo="";

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        download();
    }

    private void readFile() {
         baos = (ByteArrayOutputStream) getSession().getAttribute("baos");
         obr_obrasT = (Obr_obrasT) getSession().getAttribute("obr_obrasT");
         status = (String) getSession().getAttribute("status");
         String referencia =(String) getSession().getAttribute("referencia");
         String desStatus = status.equalsIgnoreCase("A")?"apagar_":"pagas_";
         nm_arquivo = obr_obrasT.getObr_tx_nome()+"_"+desStatus+"_"+referencia+".xls";
    }

    public void download() throws Exception {
        try {
            readFile();
            if (baos != null) {
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "arquivo/xls");
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, nm_arquivo);
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
}
