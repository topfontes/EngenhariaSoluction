/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios;

import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Emp_empreendimentoDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author marcos
 */
public class RelatorioBase extends SystemBase implements INotSecurity{

    private Obr_obrasT obr_obrasT = new Obr_obrasT();
    private Meo_meses_obraT meo_meses_obraT = new Meo_meses_obraT();
    private DataSet ds;
    protected JRDataSource jRDataSource;
    private Map parameters = new HashMap();
    protected ByteArrayOutputStream baos = new ByteArrayOutputStream();
    protected JasperReport jasperReport;
    protected JasperPrint jasperPrint;
    protected JasperExportManager jasperExportManager;
    protected JRXlsExporter jRXlsExporter;
    protected ByteArrayInputStream bais;
    protected EasyDownloadJB easyDownloadJB;
    protected InputStream is;
    protected URL url;
    private String fileName;
    private String empreendimento;
    private String cliente;
    private String localizacao;
    private byte[] logoCliente;
    private String tipo;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        getbyEmpreendimento();
    }

    public void print(String nameRel, String tituloRel) throws Exception {
        parameters.put("titulo", tituloRel);
        DAOFactory df = getCli_clienteDAO().getDAOFactory();
        try {
            if (tipo.equalsIgnoreCase("HTML")) {
                baos = new ByteArrayOutputStream();
                JasperFillManager.fillReportToStream(is, baos, getParameters(), jRDataSource);
                bais = new ByteArrayInputStream(baos.toByteArray());
                setFileName(nameRel + "_" + getObr_obrasT().getObr_tx_nome() + "_" + getReferencia());
                getRequest().setAttribute(easyDownloadJB.FILE_NAME, getFileName());
                getRequest().setAttribute(easyDownloadJB.DATA, baos.toByteArray());
                getPage().forward("/portal/easydownload.jsp");

            } else if (tipo.equalsIgnoreCase("PDF")) {
                baos = new ByteArrayOutputStream();
                JasperFillManager.fillReportToStream(is, baos, getParameters(), jRDataSource);
                bais = new ByteArrayInputStream(baos.toByteArray());
                baos = new ByteArrayOutputStream();
                jasperExportManager.exportReportToPdfStream(bais, baos);

                if (getObr_obrasT() != null) {
                    setFileName(nameRel + "_" + getObr_obrasT().getObr_tx_nome() + "_" + getReferencia() + ".pdf");
                } else {
                    setFileName(nameRel + ".pdf");
                }
                setFileName(nameRel + "_" + getObr_obrasT().getObr_tx_nome() + "_" + getReferencia() + ".pdf");
                getRequest().setAttribute(easyDownloadJB.CONTENT_TYPE, "application/pdf");
                getRequest().setAttribute(easyDownloadJB.FILE_NAME, getFileName());
                getRequest().setAttribute(easyDownloadJB.DATA, baos.toByteArray());
                getPage().forward("/portal/easydownload.jsp");

            } else if (tipo.equalsIgnoreCase("XLS")) {
                jasperReport = (JasperReport) JRLoader.loadObject(url);
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jRDataSource);
                JRXlsExporter xls = new JRXlsExporter();
                baos = new ByteArrayOutputStream();
                xls.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                xls.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                xls.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                xls.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                xls.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET, Integer.decode("65000"));
                xls.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                xls.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                xls.exportReport();
                String filename = nameRel + "_" + obr_obrasT.getObr_tx_nome() + "_" + getReferencia() + ".xls";
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/xls");
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, filename);
                getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
                getPage().forward("/portal/easydownload.jsp");
            }

        } catch (Exception e) {
            
            throw e;
        }

    }
    public void print(String nameRel, String tituloRel,Connection connection) throws Exception {
        parameters.put("titulo", tituloRel);
        DAOFactory df = getCli_clienteDAO().getDAOFactory();
        try {
            if (tipo.equalsIgnoreCase("HTML")) {
                baos = new ByteArrayOutputStream();
                JasperFillManager.fillReportToStream(is, baos, getParameters(), connection);
                bais = new ByteArrayInputStream(baos.toByteArray());
                setFileName(nameRel + "_" + getObr_obrasT().getObr_tx_nome() + "_" + getReferencia());
                getRequest().setAttribute(easyDownloadJB.FILE_NAME, getFileName());
                getRequest().setAttribute(easyDownloadJB.DATA, baos.toByteArray());
                getPage().forward("/portal/easydownload.jsp");

            } else if (tipo.equalsIgnoreCase("PDF")) {
                baos = new ByteArrayOutputStream();
                JasperFillManager.fillReportToStream(is, baos, getParameters(), jRDataSource);
                bais = new ByteArrayInputStream(baos.toByteArray());
                baos = new ByteArrayOutputStream();
                jasperExportManager.exportReportToPdfStream(bais, baos);

                if (getObr_obrasT() != null) {
                    setFileName(nameRel + "_" + getObr_obrasT().getObr_tx_nome() + "_" + getReferencia() + ".pdf");
                } else {
                    setFileName(nameRel + ".pdf");
                }
                setFileName(nameRel + "_" + getObr_obrasT().getObr_tx_nome() + "_" + getReferencia() + ".pdf");
                getRequest().setAttribute(easyDownloadJB.CONTENT_TYPE, "application/pdf");
                getRequest().setAttribute(easyDownloadJB.FILE_NAME, getFileName());
                getRequest().setAttribute(easyDownloadJB.DATA, baos.toByteArray());
                getPage().forward("/portal/easydownload.jsp");

            } else if (tipo.equalsIgnoreCase("XLS")) {
                jasperReport = (JasperReport) JRLoader.loadObject(url);
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jRDataSource);
                JRXlsExporter xls = new JRXlsExporter();
                baos = new ByteArrayOutputStream();
                xls.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                xls.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                xls.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                xls.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                xls.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET, Integer.decode("65000"));
                xls.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                xls.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                xls.exportReport();

                String filename = nameRel + "_" + obr_obrasT.getObr_tx_nome() + "_" + getReferencia() + ".xls";
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/xls");
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, filename);
                getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
                getPage().forward("/portal/easydownload.jsp");
            }

        } catch (Exception e) {

            throw e;
        }

    }

    public String getReferencia() throws Exception {
        Obr_obrasDAO odao = null;
        try {
            odao = getObr_obrasDAO();
            return odao.getStrMesAno(meo_meses_obraT.getMes(), meo_meses_obraT.getAno());
        } catch (Exception e) {
        } finally {
            close();
        }
        return "";
    }

    public String getSequenciaMesAno() {
        Obr_obrasDAO odao = null;
        try {
            odao = getObr_obrasDAO();
            int seq = odao.getSequenciaMesAno(obr_obrasT, meo_meses_obraT.getMes(), meo_meses_obraT.getAno());
            return "Relatório n°." + Funcoes.formatarFloat("00", seq);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public void getbyEmpreendimento() {
        Emp_empreendimentoDAO edao = null;
        try {
            parameters = new HashMap();
            edao = getEmp_empreendimentoDAO();
            DataSet dsEmp = edao.getByEmpreendimentoObra(obr_obrasT.getObr_nr_id());
            empreendimento = dsEmp.getList().get(0).getColumn("emp_tx_nome").toString();
            cliente = dsEmp.getList().get(0).getColumn("cli_tx_nome").toString();
            localizacao = dsEmp.getList().get(0).getColumn("emp_tx_cidade").toString() + "-" + dsEmp.getList().get(0).getColumn("emp_tx_uf").toString();
            if (dsEmp.getList().get(0).getColumn("cli_by_logomarca") != null) {
                logoCliente = (byte[]) dsEmp.getList().get(0).getColumn("cli_by_logomarca");
                //ByteArrayInputStream stream = new ByteArrayInputStream(logoCliente);
                parameters.put("logoCliente", logoCliente);
                //System.out.println(logoCliente.toString());
            }

            Obr_obrasDAO odao = getObr_obrasDAO();
            obr_obrasT = odao.getByObr_nr_id(obr_obrasT).get(0);

            parameters.put("empreendimento", empreendimento);
            parameters.put("cliente", cliente);
            parameters.put("localizacao", localizacao);

            parameters.put("sequencia", getSequenciaMesAno());
            String referencia = getReferencia();
            parameters.put("referencia1", referencia);
            parameters.put("referencia2", referencia);
            parameters.put("pathlogoSistema", application.getRealPath("images/bc.jpg"));

        } catch (Exception e) {
            e.printStackTrace();
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

    /**
     * @return the meo_meses_obraT
     */
    public Meo_meses_obraT getMeo_meses_obraT() {
        return meo_meses_obraT;
    }

    /**
     * @param meo_meses_obraT the meo_meses_obraT to set
     */
    public void setMeo_meses_obraT(Meo_meses_obraT meo_meses_obraT) {
        this.meo_meses_obraT = meo_meses_obraT;
    }

    /**
     * @return the ds
     */
    public DataSet getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DataSet ds) {
        this.ds = ds;
    }

    /**
     * @return the parameters
     */
    public Map getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(Map parameters) {
        this.parameters = parameters;
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
     * @return the empreendimento
     */
    public String getEmpreendimento() {
        return empreendimento;
    }

    /**
     * @param empreendimento the empreendimento to set
     */
    public void setEmpreendimento(String empreendimento) {
        this.empreendimento = empreendimento;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @return the logoEmprendimento
     */
    public byte[] getLogoCliente() {
        return logoCliente;
    }

    /**
     * @param logoEmprendimento the logoEmprendimento to set
     */
    public void setLogoCliente(byte[] logoCliente) {
        this.logoCliente = logoCliente;
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
