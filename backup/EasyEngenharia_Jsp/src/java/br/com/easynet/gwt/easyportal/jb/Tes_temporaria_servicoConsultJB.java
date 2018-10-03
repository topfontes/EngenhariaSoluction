/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.Vw_importacao_orcamentoDAO;
import br.com.easynet.gwt.easyportal.transfer.Tes_temporaria_servicoT;
import br.com.easynet.gwt.easyportal.transfer.Vw_importacao_orcamentoT;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Tes_temporaria_servicoConsultJB extends SystemBase {

    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();
    private Tes_temporaria_servicoT tes_temporaria_servicoT = new Tes_temporaria_servicoT();
    private List<Tes_temporaria_servicoT> list;
    private static final String ASPAS = "\"";

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
     * @return the tes_temporaria_servicoT
     */
    public Tes_temporaria_servicoT getTes_temporaria_servicoT() {
        return tes_temporaria_servicoT;
    }

    /**
     * @param tes_temporaria_servicoT the tes_temporaria_servicoT to set
     */
    public void setTes_temporaria_servicoT(Tes_temporaria_servicoT tes_temporaria_servicoT) {
        this.tes_temporaria_servicoT = tes_temporaria_servicoT;
    }

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() {
        try {
            List<Vw_importacao_orcamentoT> listImportacao = new ArrayList<Vw_importacao_orcamentoT>();
            Vw_importacao_orcamentoDAO vdao = getVw_importacao_orcamentoDAO();
            if (vw_importacao_orcamentoT.getIpo_nr_id_nivel_1() > 0) {
                listImportacao = vdao.getById_Nivel1(vw_importacao_orcamentoT);
            } else if (vw_importacao_orcamentoT.getIpo_nr_id_nivel_2() > 0) {
                listImportacao = vdao.getById_Nivel1(vw_importacao_orcamentoT);
            } else if (vw_importacao_orcamentoT.getIpo_nr_id_nivel_3() > 0) {
                listImportacao = vdao.getById_Nivel3(vw_importacao_orcamentoT);
            } else {
                listImportacao = vdao.getAllServico(vw_importacao_orcamentoT);
            }

            list = new ArrayList<Tes_temporaria_servicoT>();

            for (Vw_importacao_orcamentoT vw_importacaoT : listImportacao) {
                Tes_temporaria_servicoT tes_temporaria_servicoT = new Tes_temporaria_servicoT();
                tes_temporaria_servicoT.setObr_nr_id(vw_importacaoT.getObr_nr_id());
                tes_temporaria_servicoT.setPlco_nr_id(vw_importacaoT.getPlco_nr_id());
                tes_temporaria_servicoT.setPlco_nr_nivel(vw_importacaoT.getPlco_nr_nivel());
                tes_temporaria_servicoT.setPlco_tx_nome(vw_importacaoT.getPlco_tx_nome());
                tes_temporaria_servicoT.setPlco_tx_unidade(vw_importacaoT.getPlco_tx_unidade());
                tes_temporaria_servicoT.setPlco_tx_cod_externo(vw_importacaoT.getPlco_tx_cod_externo());
                tes_temporaria_servicoT.setPlco_nr_quantidade(vw_importacaoT.getIpo_nr_quantidade());
                tes_temporaria_servicoT.setPlco_nr_vl_unitario(vw_importacaoT.getIpo_nr_vl_unitario());
                tes_temporaria_servicoT.setPlco_nr_vl_total(vw_importacaoT.getIpo_nr_vl_total());
                tes_temporaria_servicoT.setIpo_nr_id_super(vw_importacaoT.getIpo_nr_id_super());
                tes_temporaria_servicoT.setIpo_nr_id(vw_importacaoT.getIpo_nr_id());
                getList().add(tes_temporaria_servicoT);
            }

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * @return the list
     */
    public List<Tes_temporaria_servicoT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Tes_temporaria_servicoT> list) {
        this.list = list;
    }
}
