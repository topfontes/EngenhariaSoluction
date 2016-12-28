package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.util.ArrayList;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Tpms_temporaria_pmsConsultJB extends SystemBase {

    // Atributos e propriedades
    private Tpms_temporaria_pmsT tpms_temporaria_pmsT = new Tpms_temporaria_pmsT();
    private Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT = new Pms_planilha_medicao_servicoT();
    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();
    private double percentual = 0;

    public void setTpms_temporaria_pmsT(Tpms_temporaria_pmsT tpms_temporaria_pmsT) {
        this.tpms_temporaria_pmsT = tpms_temporaria_pmsT;
    }

    public Tpms_temporaria_pmsT getTpms_temporaria_pmsT() {
        return tpms_temporaria_pmsT;
    }
    private List<Tpms_temporaria_pmsT> list;

    public List<Tpms_temporaria_pmsT> getList() {
        return list;
    }

    public void setList(List<Tpms_temporaria_pmsT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    public void consult() throws Exception {
        try { 
            Consult_PMS_JB consultPMS = new Consult_PMS_JB(pms_planilha_medicao_servicoT,getDAO());
            list = consultPMS.consult();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * pegar a quantidade caso o já tenha sido digitado no mes e ano
     * @return
     */
    public float getQtdeAcumulada() {
        try {
            Pms_planilha_medicao_servicoDAO dAO = getPms_planilha_medicao_servicoDAO();
            DataSet ds = dAO.getByQtdeAcumulada(pms_planilha_medicao_servicoT);
            if (ds.getList().get(0).getColumn(0) != null) {
                return Float.parseFloat(ds.getList().get(0).getColumn(0).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getQtdeDigitadoMesAno() {
        try {
            Pms_planilha_medicao_servicoDAO dAO = getPms_planilha_medicao_servicoDAO();
            List<Pms_planilha_medicao_servicoT> listTemp = dAO.getByQtdeDigitado(pms_planilha_medicao_servicoT);
            if (listTemp.size() > 0) {
                percentual = listTemp.get(0).getPms_nr_percentual();
                return listTemp.get(0).getPms_nr_quantidade_servico();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void delete() throws Exception {
        try {
            Tpms_temporaria_pmsDAO tpms_temporaria_pmsDAO = getTpms_temporaria_pmsDAO();
            tpms_temporaria_pmsDAO.delete(tpms_temporaria_pmsT);
            setMsg("Exclus�o efetuada com sucesso!");
            tpms_temporaria_pmsT = new Tpms_temporaria_pmsT();
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
            String page = "tpms_temporaria_pmsInsert.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the vw_importacao_orcamentoT
     */
    public Vw_importacao_orcamentoT getVw_importacao_orcamentoT() {
        return vw_importacao_orcamentoT;
    }

    /**
     * @param vw_importacao_orcamentoT the vw_importacao_orcamentoT to set
     */
    public void setVw_importacao_orcamentoT(Vw_importacao_orcamentoT vw_importacao_orcamentoT) {
        this.vw_importacao_orcamentoT = vw_importacao_orcamentoT;
    }

    /**
     * @return the pms_planilha_medicao_servicoT
     */
    public Pms_planilha_medicao_servicoT getPms_planilha_medicao_servicoT() {
        return pms_planilha_medicao_servicoT;
    }

    /**
     * @param pms_planilha_medicao_servicoT the pms_planilha_medicao_servicoT to set
     */
    public void setPms_planilha_medicao_servicoT(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) {
        this.pms_planilha_medicao_servicoT = pms_planilha_medicao_servicoT;
    }
}
