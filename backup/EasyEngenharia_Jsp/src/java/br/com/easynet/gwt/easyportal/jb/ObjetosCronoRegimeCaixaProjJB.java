/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.Plc_plano_contasDAO;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import br.com.easynet.gwt.easyportal.transfer.Plc_plano_contasT;
import br.com.easynet.gwt.easyportal.transfer.Tes_temporaria_servicoT;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */
public class ObjetosCronoRegimeCaixaProjJB extends SystemBase {

    private int obr_nr_id;
    private int ano;
    private int mes;
    private TreeMap<String, Meo_meses_obraT> treeTotalMes = new TreeMap<String, Meo_meses_obraT>();
    private List<Tes_temporaria_servicoT> listServico = new ArrayList<Tes_temporaria_servicoT>();
    private TreeMap<Integer, Tes_temporaria_servicoT> treeValorServicoProjetado = new TreeMap<Integer, Tes_temporaria_servicoT>();

    public ObjetosCronoRegimeCaixaProjJB(int obr_nr_id, int mes, int ano) {
        this.obr_nr_id = obr_nr_id;
        this.ano = ano;
        this.mes = mes;
    }

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void povoarObjetos() throws Exception {
        try {
            CronogramaDesembolsoSubClasseReprogJB classeReprogJB = new CronogramaDesembolsoSubClasseReprogJB();
            classeReprogJB.setPage(page);
            classeReprogJB.getVw_importacao_orcamentoT().setObr_nr_id(obr_nr_id);
            classeReprogJB.setTipo("R");
            classeReprogJB.setMesRef(mes);
            classeReprogJB.setAnoRef(ano);
            listServico = classeReprogJB.consult();
            treeTotalMes = classeReprogJB.getTreeTotalMes();
            addTreeValorServicoProjetado();

        } catch (Exception e) {
            throw e;
        }
    }

    public double[] getCustosDiretos() throws Exception {
        try {
            Plc_plano_contasDAO dAO = getPlc_plano_contasDAO();
            Plc_plano_contasT plc_plano_contasT = new Plc_plano_contasT();
            plc_plano_contasT.setCen_nr_id(1);
            List<Plc_plano_contasT> list = dAO.getByCen_nr_id(plc_plano_contasT);
            TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
            for (Plc_plano_contasT plcT : list) {
                treeMap.put(plcT.getPlc_nr_id(), plcT.getPlc_nr_id());
            }
            double valor_periodo = 0;
            double valor_total = 0;
            for (Tes_temporaria_servicoT servicoT : listServico) {
                if (treeMap.get(servicoT.getPlc_nr_id_super()) != null) {
                    for (Meo_meses_obraT mesT : servicoT.getListMesesObra()) {
                        valor_total += mesT.getCalc_valor_copia();
                        if (mesT.getMes() <= mes && mesT.getAno() == ano || mesT.getAno() < ano) {
                            valor_periodo += mesT.getCalc_valor_copia();
                        }
                    }
                }
            }
            double[] vet = new double[2];
            vet[0] = valor_periodo;
            vet[1] = valor_total;
            return vet;
        } catch (Exception e) {
            throw e;
        }

    }

    public void addTreeValorServicoProjetado() {
        Tes_temporaria_servicoT tempT = null;
        for (Tes_temporaria_servicoT servicoT : listServico) {
            double total_meses = 0;
            if (servicoT.getPlc_nr_id_super() == 56) {
                int id = servicoT.getPlc_nr_id_super();
            }
            for (Meo_meses_obraT mesT : servicoT.getListMesesObra()) {
                total_meses += mesT.getCalc_valor_copia();
            }

            if (servicoT.getPlco_nr_id() == 56) {
                int id = servicoT.getPlc_nr_id_super();
            }
            if (servicoT.getPlc_nr_id_super() == 56) {
                int id = servicoT.getPlc_nr_id_super();
            }
            tempT = treeValorServicoProjetado.get(servicoT.getPlc_nr_id_super());
            if (tempT == null) {
                Tes_temporaria_servicoT newTemp = new Tes_temporaria_servicoT();
                newTemp.setSoma_valor_copia(total_meses);
                treeValorServicoProjetado.put(servicoT.getPlc_nr_id_super(), newTemp);
            } else {
                tempT.setSoma_valor_copia(tempT.getSoma_valor_copia() + total_meses);
            }
        }
    }

    /**
     * @return the obr_nr_id
     */
    public int getObr_nr_id() {
        return obr_nr_id;
    }

    /**
     * @param obr_nr_id the obr_nr_id to set
     */
    public void setObr_nr_id(int obr_nr_id) {
        this.obr_nr_id = obr_nr_id;
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
     * @return the treeTotalMes
     */
    public TreeMap<String, Meo_meses_obraT> getTreeTotalMes() {
        return treeTotalMes;
    }

    /**
     * @param treeTotalMes the treeTotalMes to set
     */
    public void setTreeTotalMes(TreeMap<String, Meo_meses_obraT> treeTotalMes) {
        this.treeTotalMes = treeTotalMes;
    }

    /**
     * @return the listServico
     */
    public List<Tes_temporaria_servicoT> getListServico() {
        return listServico;
    }

    /**
     * @param listServico the listServico to set
     */
    public void setListServico(List<Tes_temporaria_servicoT> listServico) {
        this.listServico = listServico;
    }

    /**
     * @return the treeValorServicoProjetado
     */
    public TreeMap<Integer, Tes_temporaria_servicoT> getTreeValorServicoProjetado() {
        return treeValorServicoProjetado;
    }

    /**
     * @param treeValorServicoProjetado the treeValorServicoProjetado to set
     */
    public void setTreeValorServicoProjetado(TreeMap<Integer, Tes_temporaria_servicoT> treeValorServicoProjetado) {
        this.treeValorServicoProjetado = treeValorServicoProjetado;
    }
}
