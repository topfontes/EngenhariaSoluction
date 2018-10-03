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
public class Download extends SystemBase {

    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private String fileName = "";
    private String contentType = "arquivo/xls";

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        download();
    }

    private void readFile() {

            setBaos((ByteArrayOutputStream) getSession().getAttribute("baos"));
            fileName = (String) getSession().getAttribute("filename");
            getSession().removeAttribute("baos");
    }

    public void download() throws Exception {
        try {
            readFile();
            if (getBaos() != null) {
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, getContentType());
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, fileName);
                getRequest().setAttribute(EasyDownloadJB.DATA, getBaos().toByteArray());
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
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the baos
     */
    public ByteArrayOutputStream getBaos() {
        return baos;
    }

    /**
     * @param baos the baos to set
     */
    public void setBaos(ByteArrayOutputStream baos) {
        this.baos = baos;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
