/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.planilhahh;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.easyportal.dao.Fol_folha_pagamentoDAO;
import br.com.easynet.gwt.easyportal.dao.Htf_horas_trabalha_folhaDAO;
import br.com.easynet.gwt.easyportal.dao.Scfp_subclasse_operario_previstoDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_equiv_insumo_pmsDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.PlanilhahhTMP;
import br.com.easynet.gwt.easyportal.transfer.Vw_equiv_insumo_pmsT;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class PlanilhahhREL extends RelatorioBase {

    private float horasTrabalhasMes;
    private TreeMap<Integer, PlanilhahhTMP> tree = new TreeMap<Integer, PlanilhahhTMP>();
    List<PlanilhahhTMP> list = new Vector();//
    TreeMap<Integer, String> treeScfp = new TreeMap<Integer, String>();
    List<Vw_equiv_insumo_pmsT> listTemp;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        povoatree();
    }

    public void povoatree() {
        try {
            Scfp_subclasse_operario_previstoDAO sdao = getScfp_subclasse_operario_previstoDAO();
            DataSet dsSc = sdao.getAll();
            for (int i = 0; i < dsSc.getList().size(); i++) {
                treeScfp.put(Integer.parseInt(dsSc.getList().get(i).getColumn("plco_nr_id").toString()), "sim");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void imprimir() {
        Htf_horas_trabalha_folhaDAO hdao = null;
        try {

            hdao = getHtf_horas_trabalha_folhaDAO();
            horasTrabalhasMes = hdao.getHohrasMes(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno());
            Vw_equiv_insumo_pmsDAO vdao = getVw_equiv_insumo_pmsDAO();
            listTemp = new ArrayList<Vw_equiv_insumo_pmsT>();
            Vw_equiv_insumo_pmsT vt = new Vw_equiv_insumo_pmsT();
            vt.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            vt.setPlc_nr_id(getObr_obrasT().getObr_nr_id_plc_mdo_direta());
            vt.setPms_nr_mes(getMeo_meses_obraT().getMes());
            vt.setPms_nr_ano(getMeo_meses_obraT().getAno());
            listTemp = vdao.getByPlc_nr_id(vt, false);
//            DataSet ds_vw = vdao.getQtdePms(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno());

            povoaPMSDireta();
            calcular();

            listTemp = new ArrayList<Vw_equiv_insumo_pmsT>();
            vt.setPlc_nr_id(getObr_obrasT().getObr_nr_id_plc_mdo_indireta());
            listTemp = vdao.getByPlc_nr_id(vt, false);

            povoaPMSIndireta();

            Fol_folha_pagamentoDAO fdao = getFol_folha_pagamentoDAO();
            DataSet ds_fol = fdao.getAllHH(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(),getObr_obrasT().getObr_nr_id_plc_mdo_direta());
            povoaFolha(ds_fol);

            ds_fol = fdao.getAllHH(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(),getObr_obrasT().getObr_nr_id_plc_mdo_indireta());
            povoaFolha(ds_fol);

            ordenarList();
            calcular();

//            arredondarValor();
            
            jRDataSource = new JRBeanCollectionDataSource(list);

            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = PlanilhahhREL.class.getResourceAsStream("planilhaHH.jasper");
            } else {
                url = PlanilhahhREL.class.getResource("planilhaHH.jasper");
            }

            print("PlanilhaHH", "PLANILHA DE HH");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //hdao.close();
            close();
        }
    }

    public void povoaPMSDireta() {
        for (int i = 0; i < listTemp.size(); i++) {
            PlanilhahhTMP prel = new PlanilhahhTMP();
            prel.setPlc_nr_id(listTemp.get(i).getPlc_nr_id());
            prel.setPlc_tx_nome(listTemp.get(i).getPlc_tx_nome());
            prel.setPlco_nr_id(listTemp.get(i).getPlco_nr_id());
            prel.setPlco_tx_nome(listTemp.get(i).getInsumo());
            if (treeScfp.get(prel.getPlco_nr_id()) == null) {
                prel.setHhprevisto(listTemp.get(i).getVl_executado() / listTemp.get(i).getIpo_nr_vl_unitario());
                prel.setFucionariosPrevisto(prel.getHhprevisto() /horasTrabalhasMes );
            } else {
                prel.setFucionariosPrevisto(listTemp.get(i).getVl_executado() / listTemp.get(i).getIpo_nr_vl_unitario());
            }
            prel.setFuncionariosReais(0);
            prel.setSaldo(0);
            list.add(prel);
            tree.put(prel.getPlco_nr_id(), prel);
        }
    }

    public void povoaPMSIndireta() {
        for (int i = 0; i < listTemp.size(); i++) {
            PlanilhahhTMP prel = new PlanilhahhTMP();
            prel.setPlc_nr_id(listTemp.get(i).getPlc_nr_id());
            prel.setPlc_tx_nome(listTemp.get(i).getPlc_tx_nome());
            prel.setPlco_nr_id(listTemp.get(i).getPlco_nr_id());
            prel.setPlco_tx_nome(listTemp.get(i).getInsumo());
            prel.setFucionariosPrevisto(listTemp.get(i).getVl_executado() / listTemp.get(i).getIpo_nr_vl_unitario());
            prel.setFuncionariosReais(0);
            prel.setSaldo(0);
            list.add(prel);
            tree.put(prel.getPlco_nr_id(), prel);
        }
    }
    
    public void povoaFolha(DataSet ds) {
        for (int i = 0; i < ds.getList().size(); i++) {
            PlanilhahhTMP prel = tree.get(Integer.parseInt(ds.getList().get(i).getColumn("plco_nr_id").toString()));
            if (prel == null) {
                prel = new PlanilhahhTMP();
                prel.setPlc_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
                prel.setPlc_tx_nome(ds.getList().get(i).getColumn("subclasse").toString());
                prel.setPlco_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("plco_nr_id").toString()));
                prel.setPlco_tx_nome(ds.getList().get(i).getColumn("insumo").toString());
                prel.setFuncionariosReais(Float.parseFloat(ds.getList().get(i).getColumn("qtde").toString()));
                prel.setSaldo(Float.parseFloat(ds.getList().get(i).getColumn("qtde").toString()) * -1);
                list.add(prel);
            } else {
                prel.setFuncionariosReais(Float.parseFloat(ds.getList().get(i).getColumn("qtde").toString()));
                prel.setSaldo(prel.getFucionariosPrevisto() - prel.getFuncionariosReais());
            }
        }
    }

    public void calcular(){
        for (PlanilhahhTMP planilhahhTMP : list) {
            planilhahhTMP.setSaldo(planilhahhTMP.getFucionariosPrevisto() - planilhahhTMP.getFuncionariosReais());
        }
    }
    
    public void arredondarValor(){
        for (PlanilhahhTMP planilhahhTMP : list) {

            int valor = Math.round(planilhahhTMP.getFuncionariosReais());
            planilhahhTMP.setFuncionariosReais(valor);

            valor = Math.round(planilhahhTMP.getFucionariosPrevisto());
            planilhahhTMP.setFucionariosPrevisto(valor);

            valor = Math.round(planilhahhTMP.getSaldo());
            planilhahhTMP.setSaldo(valor);

        }
    }
    
    public void ordenarList() {
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                PlanilhahhTMP p1 = (PlanilhahhTMP) o1;
                PlanilhahhTMP p2 = (PlanilhahhTMP) o2;
                String atividade1 = (p1 != null) ? p1.getPlc_tx_nome() : "";
                String atividade2 = (p2 != null) ? p2.getPlc_tx_nome() : "";
                return atividade1.compareTo(atividade2);
            }
        });
    }
}
