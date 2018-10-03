package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.jdragon.dao.DAOFactory;
import java.util.ArrayList;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Consult_PMS_JB extends SystemBase {

    // Atributos e propriedades
    private Tpms_temporaria_pmsT tpms_temporaria_pmsT = new Tpms_temporaria_pmsT();
    private Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT = new Pms_planilha_medicao_servicoT();
    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();
    private double percentual = 0;
    private DAOFactory dao;
    private static final String ASPAS = "\"";

    public void setTpms_temporaria_pmsT(Tpms_temporaria_pmsT tpms_temporaria_pmsT) {
        this.tpms_temporaria_pmsT = tpms_temporaria_pmsT;
    }

    public Tpms_temporaria_pmsT getTpms_temporaria_pmsT() {
        return tpms_temporaria_pmsT;
    }

    public Consult_PMS_JB(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT, DAOFactory dao) {
        this.pms_planilha_medicao_servicoT = pms_planilha_medicao_servicoT;

        this.dao = dao;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public List<Tpms_temporaria_pmsT> consult() throws Exception {
        List<Tpms_temporaria_pmsT> list = new ArrayList<Tpms_temporaria_pmsT>();
        try {
            List<Vw_importacao_orcamentoT> listImportacao = new ArrayList<Vw_importacao_orcamentoT>();
            Vw_importacao_orcamentoDAO vdao = new Vw_importacao_orcamentoDAO(dao);
            vw_importacao_orcamentoT.setObr_nr_id(pms_planilha_medicao_servicoT.getObr_nr_id());
            listImportacao = vdao.getAllServico(getVw_importacao_orcamentoT());
            list = new ArrayList<Tpms_temporaria_pmsT>();
            for (Vw_importacao_orcamentoT vw_importacaoT : listImportacao) {


                tpms_temporaria_pmsT = new Tpms_temporaria_pmsT();
                tpms_temporaria_pmsT.setObr_nr_id(vw_importacaoT.getObr_nr_id());
                tpms_temporaria_pmsT.setPlco_nr_id(vw_importacaoT.getPlco_nr_id());
                tpms_temporaria_pmsT.setTpms_bl_servico(vw_importacaoT.isIpo_bl_cronograma());
                String nome = vw_importacaoT.getPlco_tx_nome();
                nome = nome.replace(ASPAS, "''");
                nome = nome.replace("\r", " ");
                nome = nome.replace("\n", " ");
                tpms_temporaria_pmsT.setTpms_tx_conta(nome);
                //tpms_temporaria_pmsT.setTpms_tx_conta(vw_importacaoT.getPlco_tx_nome());
                tpms_temporaria_pmsT.setTpms_tx_unidade(vw_importacaoT.getPlco_tx_unidade());
                tpms_temporaria_pmsT.setTpms_tx_codigo_externo(vw_importacaoT.getPlco_tx_cod_externo());
                tpms_temporaria_pmsT.setTpms_nr_quantidade_total(vw_importacaoT.getIpo_nr_quantidade());
                tpms_temporaria_pmsT.setTpms_nr_valor_total(vw_importacaoT.getIpo_nr_vl_total());
                tpms_temporaria_pmsT.setTpms_nr_valor_unit(vw_importacaoT.getIpo_nr_vl_unitario());
                tpms_temporaria_pmsT.setIpo_nr_id_super(vw_importacaoT.getIpo_nr_id_super());
                tpms_temporaria_pmsT.setIpo_nr_id(vw_importacaoT.getIpo_nr_id());


                pms_planilha_medicao_servicoT.setPlco_nr_id(vw_importacaoT.getPlco_nr_id());
                pms_planilha_medicao_servicoT.setIpo_nr_id_super(vw_importacaoT.getIpo_nr_id_super());
                pms_planilha_medicao_servicoT.setIpo_nr_id(vw_importacaoT.getIpo_nr_id());
                //verificar a quantidade executada do serviço no mês de referencia
                double qtde = getQtdeDigitadoMesAno();
                double percMes = 0;
                double percAcumulado = 0;
                float percSaldo = 0;

                if (vw_importacaoT.getPlco_tx_cod_externo().equalsIgnoreCase("02940.6.10.18")) {
                    int a = 10;
                }
                if (qtde != 0) {
                    tpms_temporaria_pmsT.setTmps_nr_quantidade(qtde);
                    double dif = vw_importacaoT.getIpo_nr_quantidade() - qtde;
                    percMes = 100 - (dif * 100 / vw_importacaoT.getIpo_nr_quantidade());
                    tpms_temporaria_pmsT.setTpms_nr_percentAcumuladoMes(percMes);
                    tpms_temporaria_pmsT.setTpms_nr_percentual(percMes);
                }
                //verificar a quantidade executada do Acumulada até o periodo de referencia
                double acumulado = getQtdeAcumulada();
                if (acumulado > 0) {
                    tpms_temporaria_pmsT.setTpms_nr_quantidade_acumulada_ant(acumulado);
                }
                double qdteAcumuladoAtual = acumulado + qtde;
                if (qdteAcumuladoAtual > 0) {
                    double dif = vw_importacaoT.getIpo_nr_quantidade() - qdteAcumuladoAtual;
                    percAcumulado = 100 - (dif * 100 / vw_importacaoT.getIpo_nr_quantidade());
                    tpms_temporaria_pmsT.setTpms_nr_quantidade_acumulada_atual(qdteAcumuladoAtual);
                    tpms_temporaria_pmsT.setTpms_nr_percentAcumuladoPeriodo(percAcumulado);
                }

                tpms_temporaria_pmsT.setTpms_nr_saldo(tpms_temporaria_pmsT.getTpms_nr_quantidade_total() - qdteAcumuladoAtual);
                tpms_temporaria_pmsT.setTpms_nr_percentSaldo(100 - percAcumulado);

                list.add(tpms_temporaria_pmsT);
            }

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return list;
    }

    /**
     * pegar a quantidade caso o já tenha sido digitado no mes e ano
     * @return
     */
    public double getQtdeAcumulada() {
        try {
            Pms_planilha_medicao_servicoDAO dAO = new Pms_planilha_medicao_servicoDAO(dao);
            DataSet ds = dAO.getByQtdeAcumulada(pms_planilha_medicao_servicoT);
            if (ds.getList().get(0).getColumn(0) != null) {
                return Double.parseDouble(ds.getList().get(0).getColumn(0).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getQtdeDigitadoMesAno() throws Exception {
        try {
            Pms_planilha_medicao_servicoDAO dAO = new Pms_planilha_medicao_servicoDAO(dao);
            List<Pms_planilha_medicao_servicoT> listTemp = dAO.getByQtdeDigitado(pms_planilha_medicao_servicoT);
            if (listTemp.size() > 0) {
                percentual = listTemp.get(0).getPms_nr_percentual();
                return listTemp.get(0).getPms_nr_quantidade_servico();
            }

        } catch (Exception e) {
            throw e;
        }

        return 0;
    }

    public void delete() throws Exception {
        try {
            Tpms_temporaria_pmsDAO tpms_temporaria_pmsDAO = new Tpms_temporaria_pmsDAO(dao);
            tpms_temporaria_pmsDAO.delete(tpms_temporaria_pmsT);
            setMsg("Exclus�o efetuada com sucesso!");
            tpms_temporaria_pmsT = new Tpms_temporaria_pmsT();
            consult();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
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
