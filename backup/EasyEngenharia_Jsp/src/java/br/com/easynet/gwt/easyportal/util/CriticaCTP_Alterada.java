/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.util;

import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.dao.Ctpm_conta_pagar_modificadaDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.easynet.gwt.easyportal.transfer.Ctpm_conta_pagar_modificadaT;
import br.com.jdragon.dao.DAOFactory;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */
public class CriticaCTP_Alterada extends SystemBase {

    private Ctp_conta_pagarDAO ctp_conta_pagarDAO;
    private Ctp_conta_pagarT ctp_conta_pagarT;
    private TreeMap<String, Ctp_conta_pagarT> treeMesAtual;
    private DAOFactory dao ;

    public CriticaCTP_Alterada(Ctp_conta_pagarT ctp_conta_pagarT, DAOFactory dao,TreeMap<String, Ctp_conta_pagarT> treeMesAtual) {
        this.dao = dao;
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.treeMesAtual = treeMesAtual;
    }

    public void criticaItens_and_value() throws Exception {
//        4880-1820/1.10/10/2008
//    BOL.4880-1820/1.10/10/2008
//2818-1886/1.13/10/2008
//21/10/08-1992/1.22/10/2008
//3032-1931/1.26/10/2008
//03/010/08-1797/1.11/11/2008
//3202-2253/1.26/11/2008
//NF.5139-5085/1.26/10/2009
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
//            treeMesAtual = getTree();
            Ctpm_conta_pagar_modificadaDAO ctpmDao = new Ctpm_conta_pagar_modificadaDAO(dao);
            Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT = new Ctpm_conta_pagar_modificadaT();
            Ctp_conta_pagarDAO cdao = new Ctp_conta_pagarDAO(dao);

            List<Ctp_conta_pagarT> listAte = cdao.getAllMesAte(ctp_conta_pagarT);
            for (Ctp_conta_pagarT ctpT : listAte) {
                String key = ctpT.getCtp_nr_documento().trim() + "." + sdf.format(ctpT.getCtp_dt_vencimento());

                if(ctpT.getCtp_nr_documento().equalsIgnoreCase("NF.5139-5085/1")){
                    System.out.println(key);

                }

                Ctp_conta_pagarT ct = treeMesAtual.get(key);
                if (ct == null) {
                    ctpm_conta_pagar_modificadaT.setObr_nr_id(ctp_conta_pagarT.getObr_nr_id());
                    ctpm_conta_pagar_modificadaT.setCtpm_nr_mes(ctp_conta_pagarT.getCtp_nr_mes());
                    ctpm_conta_pagar_modificadaT.setCtpm_nr_ano(ctp_conta_pagarT.getCtp_nr_ano());
                    ctpm_conta_pagar_modificadaT.setCtpm_tx_tipo("Excluisão");
                    ctpm_conta_pagar_modificadaT.setCtp_nr_id(ctpT.getCtp_nr_id());
                    ctpmDao.insert(ctpm_conta_pagar_modificadaT);
                } else {
                    String value_old = Funcoes.FormatoMoedaBR_Double(ctpT.getCtp_nr_valor());
                    String new_value = Funcoes.FormatoMoedaBR_Double(ct.getCtp_nr_valor());
                    if (!value_old.equalsIgnoreCase(new_value)) {
                        ctpm_conta_pagar_modificadaT.setObr_nr_id(ctp_conta_pagarT.getObr_nr_id());
                        ctpm_conta_pagar_modificadaT.setCtpm_nr_mes(ctp_conta_pagarT.getCtp_nr_mes());
                        ctpm_conta_pagar_modificadaT.setCtpm_nr_ano(ctp_conta_pagarT.getCtp_nr_ano());
                        ctpm_conta_pagar_modificadaT.setCtpm_tx_tipo("Alteração");
                        ctpm_conta_pagar_modificadaT.setCtp_nr_id(ctpT.getCtp_nr_id());
                        ctpmDao.insert(ctpm_conta_pagar_modificadaT);
                    }
                }
            }
            String a = "n";
        } catch (Exception e) {
            throw e;
        }
    }
    public void criticaItens_and_valueEngeb() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
//            treeMesAtual = getTree();
            Ctpm_conta_pagar_modificadaDAO ctpmDao = new Ctpm_conta_pagar_modificadaDAO(dao);
            Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT = new Ctpm_conta_pagar_modificadaT();
            Ctp_conta_pagarDAO cdao = new Ctp_conta_pagarDAO(dao);
            List<Ctp_conta_pagarT> listAte = cdao.getAllMesAte(ctp_conta_pagarT);
            for (Ctp_conta_pagarT ctpT : listAte) {
                String key = ctpT.getCtp_tx_obs();
                Ctp_conta_pagarT ct = treeMesAtual.get(key);
                if (ct == null) {
                    ctpm_conta_pagar_modificadaT.setObr_nr_id(ctp_conta_pagarT.getObr_nr_id());
                    ctpm_conta_pagar_modificadaT.setCtpm_nr_mes(ctp_conta_pagarT.getCtp_nr_mes());
                    ctpm_conta_pagar_modificadaT.setCtpm_nr_ano(ctp_conta_pagarT.getCtp_nr_ano());
                    ctpm_conta_pagar_modificadaT.setCtpm_tx_tipo("Excluisão");
                    ctpm_conta_pagar_modificadaT.setCtp_nr_id(ctpT.getCtp_nr_id());
                    ctpmDao.insert(ctpm_conta_pagar_modificadaT);
                } else {
                    String value_old = Funcoes.FormatoMoedaBR_Double(ctpT.getCtp_nr_valor());
                    String new_value = Funcoes.FormatoMoedaBR_Double(ct.getCtp_nr_valor());
                    if (!value_old.equalsIgnoreCase(new_value)) {
                        ctpm_conta_pagar_modificadaT.setObr_nr_id(ctp_conta_pagarT.getObr_nr_id());
                        ctpm_conta_pagar_modificadaT.setCtpm_nr_mes(ctp_conta_pagarT.getCtp_nr_mes());
                        ctpm_conta_pagar_modificadaT.setCtpm_nr_ano(ctp_conta_pagarT.getCtp_nr_ano());
                        ctpm_conta_pagar_modificadaT.setCtpm_tx_tipo("Excluisão");
                        ctpm_conta_pagar_modificadaT.setCtp_nr_id(ctpT.getCtp_nr_id());
                        ctpmDao.insert(ctpm_conta_pagar_modificadaT);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
