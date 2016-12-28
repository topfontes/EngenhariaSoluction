/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.relatorios.cronograma_desembolso;

import br.com.easynet.gwt.easyportal.dao.Vw_importacao_orcamentoDAO;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Cronograma_desembolsoT;
import br.com.easynet.gwt.easyportal.transfer.Vw_importacao_orcamentoT;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Rel_cronograma_desembolso extends SystemBase{
    private List<Cronograma_desembolsoT> list;
    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();

    public Rel_cronograma_desembolso() {
        
    }

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult(){
        try {

            List<Vw_importacao_orcamentoT> listImportacao = new ArrayList<Vw_importacao_orcamentoT>();
            Vw_importacao_orcamentoDAO vdao = getVw_importacao_orcamentoDAO();
            
            listImportacao = vdao.getAllServico(getVw_importacao_orcamentoT());
            list = new ArrayList<Cronograma_desembolsoT>();
            for (Vw_importacao_orcamentoT vw_importacaoT : listImportacao) {
                Cronograma_desembolsoT cronogramaT = new Cronograma_desembolsoT();
                cronogramaT.setCodigo(vw_importacaoT.getPlco_tx_cod_externo());
                cronogramaT.setServico(vw_importacaoT.getPlco_tx_nome());
                cronogramaT.setUnidade(vw_importacaoT.getPlco_tx_unidade());
                cronogramaT.setQuantidade_orcada(vw_importacaoT.getIpo_nr_quantidade());

                cronogramaT.setQuantidade_prevista(1);
                cronogramaT.setQuantidade_reealizada(2);
                cronogramaT.setDiferenca_quantidade(1);

                cronogramaT.setValor_previsto(2);
                cronogramaT.setValor_realizado(4);
                cronogramaT.setDiferenca_valor(2);

                cronogramaT.setPerc_previsto(10);
                cronogramaT.setPerc_realizado(20);
                cronogramaT.setDiferenca_perc(10);
                list.add(cronogramaT);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close();
        }
        
    }

    /**
     * @return the list
     */
    public List<Cronograma_desembolsoT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Cronograma_desembolsoT> list) {
        this.list = list;
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


    

}
