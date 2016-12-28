/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.Cffo_cronograma_fisico_financeiro_origenalDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_importacao_orcamentoDAO;
import br.com.easynet.gwt.easyportal.transfer.Cffo_cronograma_fisico_financeiro_origenalT;
import br.com.easynet.gwt.easyportal.transfer.Vw_importacao_orcamentoT;
import br.com.jdragon.dao.DAOFactory;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class Cffo_digitadoJB extends SystemBase {

    private Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();

    public List<Vw_importacao_orcamentoT> getCffo_digitado(DAOFactory daof) throws Exception {

        List<Vw_importacao_orcamentoT> listErro = new Vector();
        try {
            Cffo_cronograma_fisico_financeiro_origenalDAO cdao = new Cffo_cronograma_fisico_financeiro_origenalDAO(daof);
            TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalT> tree = cdao.somaPercetServico(cffo_cronograma_fisico_financeiro_origenalT);
            Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();
            vw_importacao_orcamentoT.setObr_nr_id(cffo_cronograma_fisico_financeiro_origenalT.getObr_nr_id());
            Vw_importacao_orcamentoDAO vdao = new Vw_importacao_orcamentoDAO(daof);
            List<Vw_importacao_orcamentoT> list = vdao.getAllServico(vw_importacao_orcamentoT);
            String key = "";
            for (Vw_importacao_orcamentoT vw_importacaoT : list) {
                if (vw_importacaoT.getIpo_nr_quantidade() > 0) {
                    key = vw_importacaoT.getObr_nr_id() + "." + vw_importacaoT.getIpo_nr_id() + "." + vw_importacaoT.getPlco_nr_id();
                    cffo_cronograma_fisico_financeiro_origenalT = tree.get(key);
                    if (cffo_cronograma_fisico_financeiro_origenalT != null) {
                        String percent = Funcoes.formatoMoedaDouble(cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_peso());
                        if (percent.equalsIgnoreCase("100,00")) {
                            listErro.add(vw_importacaoT);
                        }
                    }else{
                        listErro.add(vw_importacaoT);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return listErro;
    }

    /**
     * @return the cffo_cronograma_fisico_financeiro_origenalT
     */
    public Cffo_cronograma_fisico_financeiro_origenalT getCffo_cronograma_fisico_financeiro_origenalT() {
        return cffo_cronograma_fisico_financeiro_origenalT;
    }

    /**
     * @param cffo_cronograma_fisico_financeiro_origenalT the cffo_cronograma_fisico_financeiro_origenalT to set
     */
    public void setCffo_cronograma_fisico_financeiro_origenalT(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) {
        this.cffo_cronograma_fisico_financeiro_origenalT = cffo_cronograma_fisico_financeiro_origenalT;
    }
}
