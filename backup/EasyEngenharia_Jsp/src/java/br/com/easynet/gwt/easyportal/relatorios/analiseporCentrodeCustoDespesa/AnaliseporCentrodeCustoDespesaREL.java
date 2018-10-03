/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.analiseporCentrodeCustoDespesa;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.easyportal.dao.Com_comprometimentoDAO;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
import br.com.easynet.gwt.easyportal.dao.Fol_folha_pagamentoDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_insumo_plc_pmsDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.CentroCustoDespesasTMP;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.gwt.easyportal.transfer.Vw_insumo_plc_pmsT;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class AnaliseporCentrodeCustoDespesaREL extends RelatorioBase {

    private DataSet dsCtpPagas;
    private DataSet dsCtpAPagar;
    private DataSet dsPMS;
    private DataSet dsEstoque;
    private DataSet dsComp;
    private List<CentroCustoDespesasTMP> list = new ArrayList();
    private TreeMap<Integer, CentroCustoDespesasTMP> tree;
    private boolean acumulado;
    private float maior = 0;
    private float menor = 0;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        Ctp_conta_pagarDAO ctpDao = null;
        Vw_insumo_plc_pmsDAO vPmsDao = null;
        Est_estoqueDAO eDao = null;
        Com_comprometimentoDAO cDao = null;
        try {
            ctpDao = getCtp_conta_pagarDAO();
            vPmsDao = getVw_insumo_plc_pmsDAO();
            eDao = getEst_estoqueDAO();
            cDao = getCom_comprometimentoDAO();

            dsCtpPagas = ctpDao.getAllContas(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), acumulado, "P");
            dsCtpAPagar = ctpDao.getAllContas(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), acumulado, "A");
            dsPMS = vPmsDao.getResumoPmsPlc(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), acumulado);
            dsEstoque = eDao.estoqueMesSubClasse(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno());
            dsComp = cDao.CompSubClasseMes(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), false);
            povoaPms(dsPMS);
            povoaCtp(dsCtpPagas);
            povoaCtp(dsCtpAPagar);
            povoaEstoque(dsEstoque);
            povoaCompro(dsComp);

            calcularResultado();
            ordenarList();
            aplicarFiltro();

            is = AnaliseporCentrodeCustoDespesaREL.class.getResourceAsStream("analiseporCentrodeCustoDespesa.jasper");
            jRDataSource = new JRBeanCollectionDataSource(list);
            print("CustosPorCentroDespesa", "CUSTOS POR CENTRO DE DESPESAS");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void aplicarFiltro(){
        List<CentroCustoDespesasTMP> listtemp = new ArrayList();
        for (CentroCustoDespesasTMP centroCustoDespesasTMP : list) {
            if(centroCustoDespesasTMP.getSaldo() < menor || centroCustoDespesasTMP.getSaldo() > maior){
                listtemp.add(centroCustoDespesasTMP);
            }
        }
        list.clear();
        list = listtemp;

    }

    public void ordenarList() {

        Collections.sort(list, new Comparator() {

            public int compare(Object o1, Object o2) {
                CentroCustoDespesasTMP p1 = (CentroCustoDespesasTMP) o1;
                CentroCustoDespesasTMP p2 = (CentroCustoDespesasTMP) o2;
                return p1.getSaldo() < p2.getSaldo() ? -1 : (p1.getSaldo() > p2.getSaldo() ? +1 : 0);
            }
        });
    }

    private void povoaPms(DataSet ds) {
        try {
            tree = new TreeMap<Integer, CentroCustoDespesasTMP>();
            for (int i = 0; i < ds.getList().size(); i++) {
                if (Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()) != 251) {
                    CentroCustoDespesasTMP despesasTMP = new CentroCustoDespesasTMP();
                    despesasTMP.setPlc_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
                    despesasTMP.setPlc_tx_nome(ds.getList().get(i).getColumn("plc_tx_nome").toString());
                    despesasTMP.setVl_pms(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
                    
                    if (Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()) == 123) {
                        despesasTMP.setVl_contasPagar(addMDO(191));
                    } else if (Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()) == 105) {
                        despesasTMP.setVl_contasPagar(addMDO(204));
                    }
                    tree.put(despesasTMP.getPlc_nr_id(), despesasTMP);
                    list.add(despesasTMP);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void povoaCtp(DataSet ds) throws Exception {
        float total = 0;
        try {
            for (int i = 0; i < ds.getList().size(); i++) {
                if (Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()) != 251) {
                    CentroCustoDespesasTMP despesasTMP = tree.get(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
                    if (despesasTMP == null) {
                        despesasTMP = new CentroCustoDespesasTMP();
                        despesasTMP.setPlc_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
                        despesasTMP.setPlc_tx_nome(ds.getList().get(i).getColumn("plc_tx_nome").toString());

                        despesasTMP.setVl_contasPagar(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));

                        tree.put(despesasTMP.getPlc_nr_id(), despesasTMP);
                        list.add(despesasTMP);
                    } else {
                        despesasTMP.setVl_contasPagar(despesasTMP.getVl_contasPagar() + Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
                    }
                    total += Float.parseFloat(ds.getList().get(i).getColumn("valor").toString());
                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public float addMDO(int id) throws Exception {
        try {
            int[] id_classe = {id};
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = obr_obrasDAO.getByPK(getObr_obrasT()).get(0);

            Fol_folha_pagamentoDAO fdao = getFol_folha_pagamentoDAO();
            double vl_salarioRealizadoOficial = fdao.getCustoRealizadoMesOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classe);
            double vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoMesNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classe);

            double basecalc = (obr_obrasT.getObr_nr_percent_mdo_direta() / 100);

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoAcumuladoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classe);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoAcumuladoNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classe);

            double salarioBruto = (vl_salarioRealizadoOficial + vl_salariodRealizadoNaoOficial);

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoMesOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classe);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoMesNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classe);

            double vlEncargosRealizadoMes = vl_salarioRealizadoOficial / basecalc;

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoAcumuladoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classe);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoAcumuladoNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classe);

            double vlEncargosRealizadoAC = vl_salarioRealizadoOficial / basecalc;
            double encargos = vl_salarioRealizadoOficial * basecalc;

            String s = String.valueOf(salarioBruto + encargos);
            float f = Float.parseFloat(s);
            return f;

        } catch (Exception e) {
            throw e;
        }

    }

    private void povoaEstoque(DataSet ds) {
        for (int i = 0; i < ds.getList().size(); i++) {
            if (Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()) != 251) {
                CentroCustoDespesasTMP despesasTMP = tree.get(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
                if (despesasTMP == null) {
                    despesasTMP = new CentroCustoDespesasTMP();
                    despesasTMP.setPlc_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
                    despesasTMP.setPlc_tx_nome(ds.getList().get(i).getColumn("plc_tx_nome").toString());
                    despesasTMP.setVl_estoque(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
                    tree.put(despesasTMP.getPlc_nr_id(), despesasTMP);
                    list.add(despesasTMP);
                } else {
                    despesasTMP.setVl_estoque(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
                }
            }
        }
    }

    private void povoaCompro(DataSet ds) {
        for (int i = 0; i < ds.getList().size(); i++) {
            if (Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()) != 251) {
                CentroCustoDespesasTMP despesasTMP = tree.get(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
                if (despesasTMP == null) {
                    despesasTMP = new CentroCustoDespesasTMP();
                    despesasTMP.setPlc_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
                    despesasTMP.setPlc_tx_nome(ds.getList().get(i).getColumn("plc_tx_nome").toString());
                    despesasTMP.setVl_compro(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
                    tree.put(despesasTMP.getPlc_nr_id(), despesasTMP);
                    list.add(despesasTMP);

                } else {
                    despesasTMP.setVl_compro(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
                }
            }
        }
    }

    public void calcularResultado() {
        for (CentroCustoDespesasTMP centroTMP : list) {
            centroTMP.setVl_realizado((centroTMP.getVl_contasPagar() - centroTMP.getVl_estoque()) + centroTMP.getVl_compro());
//            float subtracao = centroTMP.getVl_pms() - centroTMP.getVl_contasPagar() - centroTMP.getVl_estoque();
            centroTMP.setSaldo(centroTMP.getVl_pms() - centroTMP.getVl_realizado());
        }

    }

    /**
     * @return the acumulado
     */
    public boolean isAcumulado() {
        return acumulado;
    }

    /**
     * @param acumulado the acumulado to set
     */
    public void setAcumulado(boolean acumulado) {
        this.acumulado = acumulado;
    }

    /**
     * @return the maior
     */
    public float getMaior() {
        return maior;
    }

    /**
     * @param maior the maior to set
     */
    public void setMaior(float maior) {
        this.maior = maior;
    }

    /**
     * @return the menor
     */
    public float getMenor() {
        return menor;
    }

    /**
     * @param menor the menor to set
     */
    public void setMenor(float menor) {
        this.menor = menor;
    }



}
