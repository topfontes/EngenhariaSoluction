/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.custo_classe_regime_competencia;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.easyportal.dao.Com_comprometimentoDAO;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
import br.com.easynet.gwt.easyportal.dao.Fol_folha_pagamentoDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.dao.Pms_planilha_medicao_servicoDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.Custo_classe_regime_competenciaTMP;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class CustoClasseRegimeCompetencia extends RelatorioBase {

    private List<Custo_classe_regime_competenciaTMP> list = new Vector();
    private DataSet dsCtpEstoqueMat;
    private int mesAnterior;
    private int anoAnt;
    private double vlCompReallizadoMes;
    private double vlCompReallizadoAcumulado;
    private double valorEstoque = 0;
    private double valorprevistoEst = 0;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    //novo metodo para ser realizadoo tambem pelo relatório analise custos por regime competencia
    public void povoarLista() throws Exception {
        try {
            CalcularMesAnterior();
            addEstoqueCTP();
            addMateriaisSemEstoque();
            addMDOD();
            addMDOI();
            addCustosIndiretos();
            addServicosTerceirizados();
            addEquipamentos();
            addCorretagem();
            addPublicidade();
            addLicenca();
            addTributos();
            addOutros();
            calcularRealizadoPrevisto();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public void imprimir() {
        try {
            povoarLista();
//            CalcularMesAnterior();
//            addEstoqueCTP();
//            addMateriaisSemEstoque();
//            addMDOD();
//            addMDOI();
//            addCustosIndiretos();
//            addServicosTerceirizados();
//            addEquipamentos();
//            addCorretagem();
//            addPublicidade();
//            addLicenca();
//            addTributos();
//            addOutros();
//            calcularRealizadoPrevisto();

            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = CustoClasseRegimeCompetencia.class.getResourceAsStream("CustoClasseRegimeCompetencia.jasper");
            } else {
                url = CustoClasseRegimeCompetencia.class.getResource("CustoClasseRegimeCompetencia.jasper");
            }

            print("CUSTO_CLASSE_REG_COMPET", "CUSTOS POR CLASSE POR REGIME DE COMPETÊNCIA");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }


    }

    private void CalcularMesAnterior() {

        if (getMeo_meses_obraT().getMes() == 1) {
            anoAnt = getMeo_meses_obraT().getAno() - 1;
            mesAnterior = 12;
        } else {
            mesAnterior = getMeo_meses_obraT().getMes() - 1;
            anoAnt = getMeo_meses_obraT().getAno();
        }
    }

    private void addEstoqueCTP() {
        Est_estoqueDAO edao = null;
        try {
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            int[] id_Materias = {65};
            edao = getEst_estoqueDAO();

            custo.setItem("1");
            custo.setGrupo(0);
            custo.setDescricao("ESTOQUE");
            custo.setCusto_realizado(0);
            list.add(custo);

            custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("1.1");
            custo.setGrupo(1);
            custo.setDescricao("MATERIAIS");

            valorEstoque = edao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Materias);
            custo.setAcum_realizado(valorEstoque);

            double calc_vl_mes_ant = edao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_Materias);
            valorprevistoEst = valorEstoque - calc_vl_mes_ant;

            custo.setCusto_realizado(valorprevistoEst);

            list.add(custo);
            finalizarGrupo();

        } catch (Exception e) {
        }
    }

    private void addcomprometimento(String codigo, int[] id_classes, int grupo) throws Exception {
        try {
            vlCompReallizadoMes = 0;
            vlCompReallizadoAcumulado = 0;

            Com_comprometimentoDAO cdao = getCom_comprometimentoDAO();
            double valorMes = cdao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classes, false);
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem(codigo);
            custo.setGrupo(grupo);
            custo.setDescricao("COMPROMETIMENTO");
            vlCompReallizadoMes = valorMes;

            //o valor acumulado é pego do item informado mensalmente e o valor no periodo é uma formula.
            double valorAcumuladoMesAtual = cdao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classes, false);
            double valorAcumuladoMesAnterior = cdao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_classes, false);

            custo.setAcum_realizado(valorAcumuladoMesAtual);

            custo.setCusto_realizado(valorAcumuladoMesAtual - valorAcumuladoMesAnterior);

            //vlCompReallizadoAcumulado = valorAcumuladoMesAtual - valorAcumuladoMesAnterior;
            list.add(custo);

        } catch (Exception e) {
            throw e;
        }
    }

    public void addMateriaisSemEstoque() throws Exception {
        try {
            Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
            double pms_previsto_mes;
            double pms_previsto_acumulado;
            double ctp_mes_realizado;
            double ctp_acumulado_realizado;

            int[] mat_sem_estoque = {65};
            pms_previsto_mes = pdao.getCustoPrevistoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), mat_sem_estoque);
            pms_previsto_acumulado = pdao.getCustoPrevistoAcmulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), mat_sem_estoque);

            ctp_mes_realizado = cdao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), mat_sem_estoque);
            ctp_acumulado_realizado = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), mat_sem_estoque);

            Custo_classe_regime_competenciaTMP TotalGrupo = new Custo_classe_regime_competenciaTMP();
            TotalGrupo.setItem("2");
            TotalGrupo.setGrupo(0);
            TotalGrupo.setDescricao("MATERIAIS SEM ESTOQUE");
            list.add(TotalGrupo);

            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("2.1");
            custo.setGrupo(1);
            custo.setDescricao("MATERIAIS SEM ESTOQUE");
            custo.setCustos_previsto(pms_previsto_mes);
            custo.setCusto_realizado(ctp_mes_realizado - valorprevistoEst);

            custo.setCustos_prev_realiz(0);

            custo.setAcum_previsto(pms_previsto_acumulado);
            custo.setAcum_realizado(ctp_acumulado_realizado - valorEstoque);
            custo.setCustos_prev_realiz(0);
            list.add(custo);
            addcomprometimento("2.2", mat_sem_estoque, 1);

            finalizarGrupo();

        } catch (Exception e) {
            throw e;
        }
    }

    public void addMDOD() throws Exception {
        try {
            int[] id_classeMDOD = {204};
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = obr_obrasDAO.getByPK(getObr_obrasT()).get(0);
            Custo_classe_regime_competenciaTMP totalGrupo = new Custo_classe_regime_competenciaTMP();
            totalGrupo.setItem("3");
            totalGrupo.setGrupo(0);
            totalGrupo.setDescricao("MÃO DE OBRA DIRETA");
            list.add(totalGrupo);

            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("3.1");
            custo.setGrupo(1);
            custo.setDescricao("SALÁRIOS BRUTOS");
            Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
            double vl_salarioPrevistoMes = pdao.getCustoPrevistoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);

            Fol_folha_pagamentoDAO fdao = getFol_folha_pagamentoDAO();
            double vl_salarioRealizadoOficial = fdao.getCustoRealizadoMesOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);
            double vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoMesNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);

            double basecalc = (obr_obrasT.getObr_nr_percent_mdo_direta() / 100);
            double valor_previsto = vl_salarioPrevistoMes / (basecalc + 1);
            //System.out.println("valor "+va);
            custo.setCustos_previsto(valor_previsto);//OK

            custo.setCusto_realizado(vl_salarioRealizadoOficial + vl_salariodRealizadoNaoOficial);

//--------------------------------------------------------------------------------------------------------------------------------------------
            double vl_salarioPrevistoAcumulado = pdao.getCustoPrevistoAcmulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoAcumuladoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoAcumuladoNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);

            double valor_previstoAcumulado = vl_salarioPrevistoAcumulado / (basecalc + 1);
            custo.setAcum_previsto(valor_previstoAcumulado);
            custo.setAcum_realizado(vl_salarioRealizadoOficial + vl_salariodRealizadoNaoOficial);
            list.add(custo);

            custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("3.2");
            custo.setGrupo(1);
            custo.setDescricao("ENCARGOS SOCIAIS");

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoMesOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoMesNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);

            double vlEncargosRealizadoMes = vl_salarioRealizadoOficial / basecalc;

            custo.setCustos_previsto(valor_previsto * basecalc);
            custo.setCusto_realizado(vl_salarioRealizadoOficial * basecalc);

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoAcumuladoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoAcumuladoNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);

            double vlEncargosRealizadoAC = vl_salarioRealizadoOficial / basecalc;

            custo.setAcum_previsto(valor_previstoAcumulado * basecalc);
            double encargos = vl_salarioRealizadoOficial * basecalc;
            custo.setAcum_realizado(encargos);
            list.add(custo);

            addcomprometimento("3.3", id_classeMDOD, 1);

            finalizarGrupo();


        } catch (Exception e) {
            throw e;
        }

    }

    public void addMDOI() throws Exception {
        try {
            int[] id_classeMDOI = {191};
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = obr_obrasDAO.getByPK(getObr_obrasT()).get(0);
            Custo_classe_regime_competenciaTMP totalGrupo = new Custo_classe_regime_competenciaTMP();
            totalGrupo.setItem("4");
            totalGrupo.setGrupo(0);
            totalGrupo.setDescricao("MÃO DE OBRA INDIRETA");
            list.add(totalGrupo);

            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("4.1");
            custo.setGrupo(1);
            custo.setDescricao("SALÁRIOS BRUTOS");
            Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
            double vl_salarioPrevistoMes = pdao.getCustoPrevistoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOI);

            Fol_folha_pagamentoDAO fdao = getFol_folha_pagamentoDAO();
            double vl_salarioRealizadoOficial = fdao.getCustoRealizadoMesOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOI);
            double vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoMesNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOI);

            double basecalc = (obr_obrasT.getObr_nr_percent_mdo_direta() / 100);
            double valor_previsto = vl_salarioPrevistoMes / (basecalc + 1);
            custo.setCustos_previsto(valor_previsto);//OK

            custo.setCusto_realizado(vl_salarioRealizadoOficial + vl_salariodRealizadoNaoOficial);

//--------------------------------------------------------------------------------------------------------------------------------------------
            double vl_salarioPrevistoAcumulado = pdao.getCustoPrevistoAcmulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOI);

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoAcumuladoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOI);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoAcumuladoNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOI);

            double valor_previstoAcumulado = vl_salarioPrevistoAcumulado / (basecalc + 1);
            custo.setAcum_previsto(valor_previstoAcumulado);
            custo.setAcum_realizado(vl_salarioRealizadoOficial + vl_salariodRealizadoNaoOficial);
            list.add(custo);


            custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("4.2");
            custo.setGrupo(1);
            custo.setDescricao("ENCARGOS SOCIAIS");

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoMesOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOI);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoMesNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOI);


            double vlEncargosRealizadoMes = vl_salarioRealizadoOficial / basecalc;
//            double vlEncargosPrevistoAcumulado = vl_salarioPrevistoAcumulado / (obr_obrasT.getObr_nr_percent_mdo_direta() / 100);

            custo.setCustos_previsto(valor_previsto * basecalc);
            double encargos = vl_salarioRealizadoOficial * basecalc;
            custo.setCusto_realizado(encargos);

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoAcumuladoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOI);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoAcumuladoNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOI);

            double vlEncargosRealizadoAC = vl_salarioRealizadoOficial / basecalc;

            custo.setAcum_previsto(valor_previstoAcumulado * basecalc);
            encargos = vl_salarioRealizadoOficial * basecalc;
            custo.setAcum_realizado(encargos);
            list.add(custo);
            addcomprometimento("4.3", id_classeMDOI, 1);

            finalizarGrupo();


        } catch (Exception e) {
            throw e;
        }

    }

    public void addCustosIndiretos() throws Exception {
        try {
            int[] id_custosIndiretos = {37};
            int[] id_Rat_esc_central = {249};
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("5");
            custo.setGrupo(0);
            custo.setDescricao("CUSTOS INDIRETOS(s/ mão-de-obra indireta)");
            list.add(custo);

            custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("5.1");
            custo.setGrupo(1);
            custo.setDescricao("CUSTOS INDIRETOS(s/ mão-de-obra indireta)");

            Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
            double vlPrevistoMes = pdao.getCustoPrevistoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_custosIndiretos);
            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
            double vlRealizadoMes = cdao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_custosIndiretos);

            double vlPrevistoAcumulado = pdao.getCustoPrevistoAcmulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_custosIndiretos);
            double vlRealizadoAcumulado = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_custosIndiretos);

            //nova formula para calcular a diferençã dos meses acumulado
            double valorRealizAcumuladoMesAnt = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_custosIndiretos);
            custo.setCustos_previsto(vlPrevistoMes);
            //custo.setCusto_realizado(vlRealizadoMes);
            double saldo = vlRealizadoAcumulado - valorRealizAcumuladoMesAnt;
            custo.setCusto_realizado(saldo);

            custo.setAcum_previsto(vlPrevistoAcumulado);
            custo.setAcum_realizado(vlRealizadoAcumulado);
            list.add(custo);

            custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("5.2");
            custo.setGrupo(1);
            custo.setDescricao("COMPROMETIMENTO DOS CUSTOS INDIRETOS");
            Com_comprometimentoDAO compDao = getCom_comprometimentoDAO();


            double vl_comp_prev_AC = compDao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_custosIndiretos, true);
            custo.setAcum_previsto(vl_comp_prev_AC);

            double vl_compRealiAC = compDao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_custosIndiretos, false);
            custo.setAcum_realizado(vl_compRealiAC);


            double vl_compPrevistoMesAnt = compDao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_custosIndiretos, true);
            double vl_compRealizMesAnt = compDao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_custosIndiretos, false);

            custo.setCustos_previsto(vl_comp_prev_AC - vl_compPrevistoMesAnt);
            custo.setCusto_realizado(vl_compRealiAC - vl_compRealizMesAnt);

            list.add(custo);

            custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("5.3");
            custo.setGrupo(1);
            custo.setDescricao("RATEIO DO ESCRITÓRIO CENTRAL");

            double vlRateioPrevistoMes = pdao.getCustoPrevistoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Rat_esc_central);
            double vlRateioRealizadoMes = cdao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Rat_esc_central);
            double vlRateioPrevistoAcumulado = pdao.getCustoPrevistoAcmulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Rat_esc_central);
            double vlRateioRealizadoAcumulado = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Rat_esc_central);
            custo.setCustos_previsto(vlRateioPrevistoMes);
            valorRealizAcumuladoMesAnt = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_Rat_esc_central);
            saldo = vlRateioRealizadoAcumulado - valorRealizAcumuladoMesAnt;
            custo.setCusto_realizado(saldo);

            custo.setAcum_previsto(vlRateioPrevistoAcumulado);
            custo.setAcum_realizado(vlRateioRealizadoAcumulado);
            list.add(custo);

            custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("5.4");
            custo.setGrupo(1);
            custo.setDescricao("COMPROM. RATEIO DO ESC. CENTRAL");
            double vl_compRateioRealizadoMes = compDao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Rat_esc_central, false);

            double valorMes = compDao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Rat_esc_central, true);
            double valorMesAnterior = compDao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_Rat_esc_central, true);
            saldo = valorMes - valorMesAnterior;
            custo.setCustos_previsto(saldo);
            custo.setAcum_previsto(valorMes);

            valorMes = compDao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Rat_esc_central, false);
            valorMesAnterior = compDao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_Rat_esc_central, false);
            saldo = valorMes - valorMesAnterior;
            custo.setCusto_realizado(saldo);
            custo.setAcum_realizado(valorMes);

            list.add(custo);
            finalizarGrupo();

        } catch (Exception e) {
            throw e;
        }
    }

    public void addServicosTerceirizados() {
        try {
            int[] id_servico_terceirizado = {38};
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("6");
            custo.setGrupo(0);
            custo.setDescricao("SERVIÇOS TERCEIRIZADOS");
            list.add(custo);
            addItem("6.1", 1, id_servico_terceirizado, "SERVIÇOS TERCEIRIZADOS", false);
            addcomprometimento("6.2", id_servico_terceirizado, 1);
            finalizarGrupo();
        } catch (Exception e) {
        }

    }

    public void addEquipamentos() throws Exception {
        try {
            int[] id_Equipamentos = {82};
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("7");
            custo.setGrupo(0);
            custo.setDescricao("EQUIPAMENTOS DOS CUSTOS DIRETOS");
            list.add(custo);
            addItem("7.1", 1, id_Equipamentos, "EQUIPAMENTOS DOS CUSTOS DIRETOS", false);
            addcomprometimento("7.2", id_Equipamentos, 1);
            finalizarGrupo();
        } catch (Exception e) {
            throw e;
        }

    }

    public void addCorretagem() throws Exception {
        try {

            int[] id_comissoes = {55};
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("8");
            custo.setGrupo(0);
            custo.setDescricao("CORRETAGEM");
            list.add(custo);
            addItem("8.1", 1, id_comissoes, "COMISSÕES", false);
            addcomprometimento("8.2", id_comissoes, 1);
            finalizarGrupo();
        } catch (Exception e) {
        }

    }

    public void addPublicidade() throws Exception {
        try {
            int[] id_publicidade = {56};
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("9");
            custo.setGrupo(0);
            custo.setDescricao("PUBLICIDADE");
            list.add(custo);
            addItem("9.1", 1, id_publicidade, "PUBLICIDADE", false);
            addcomprometimento("9.2", id_publicidade, 1);
            finalizarGrupo();
        } catch (Exception e) {
        }
    }

    public void addLicenca() throws Exception {
        try {
            int[] id_licenca = {57};
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("10");
            custo.setGrupo(0);
            custo.setDescricao("LICENÇAS E TAXAS");
            list.add(custo);
            addItem("10.1", 1, id_licenca, "LICENÇAS E TAXAS", false);
            addcomprometimento("10.2", id_licenca, 1);
            finalizarGrupo();
        } catch (Exception e) {
        }
    }

    public void addTributos() throws Exception {
        try {
            int[] id_tributos = {42, 44, 43, 45, 46, 41};
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("11");
            custo.setGrupo(0);
            custo.setDescricao("TRIBUTOS SOBRE RECEITAS");
            list.add(custo);
            addItem("11.1", 1, id_tributos, "TRIBUTOS SOBRE RECEITAS", false);
            addcomprometimento("11.2", id_tributos, 1);
            finalizarGrupo();
        } catch (Exception e) {
        }
    }

    public void addOutros() throws Exception {
        try {
            int[] id_terreno = {39};
            int[] id_projetosManuais = {49};
            int[] id_TAO = {50};
            int[] id_produtos_cef = {51};
            int[] id_juros = {52};
            int[] id_segurosEng = {256};
            int[] id_segurosGarantia = {53};
            int[] id_DespesasCart = {58};
            int[] id_trabSocial = {59};
            int[] id_Standes = {60};
            int[] id_Encargos = {61};
            int[] id_imprevistos = {62};
            int[] id_manutencaoObra = {63};
            int[] id_taxaAdm = {40};
            int[] id_rateio_esc_Central = {255};
            int[] id_valorFinaciamento = {260};
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem("12");
            custo.setGrupo(0);
            custo.setDescricao("OUTROS");
            list.add(custo);
            addItem("12.1", 1, id_terreno, "TERRENO", true);
            addItem("12.2", 1, id_projetosManuais, "PROJETOS, MANUAIS, CONSULTORIA E SONDAGEM", true);
            addItem("12.3", 1, id_TAO, "TAO - TAXA P/ ACOMPANHAMENTO DE OBRA", true);
            addItem("12.4", 1, id_produtos_cef, "PRODUTOS DA CEF", true);
            addItem("12.5", 1, id_juros, "JUROS DO FINANCIAMENTO", true);
            addItem("12.6", 1, id_segurosEng, "SEGUROS(RISCOS DO ENG.)", true);
            addItem("12.7", 1, id_segurosGarantia, "SEGUROS(GARANTIA CONST. / OUTROS SEG.)", true);
            addItem("12.8", 1, id_DespesasCart, "DESPESAS CARTORIAIS/VERBAÇÃO/REGISTROS", true);
            addItem("12.9", 1, id_trabSocial, "TRABALHO SOCIAL", true);
            addItem("12.10", 1, id_Standes, "STAND DE VENDAS / OUTRAS DESPESAS", true);
            addItem("12.11", 1, id_Encargos, "ENCARGOS FINANC./TARIFAS BANCARIAS", true);
            addItem("12.12", 1, id_imprevistos, "EMPRÉSTIMOS", true);
            addItem("12.13", 1, id_manutencaoObra, "MANUTENÇÃO DA OBRA", true);
            addItem("12.14", 1, id_taxaAdm, "TAXA ADMINISTRATIVA", true);
            addItem("12.15", 1, id_rateio_esc_Central, "RATEIO DO ESCRITÓRIO CENTRAL", true);
            addItem("12.16", 1, id_valorFinaciamento, "VALOR DO FINANCIAMENTO", true);

        } catch (Exception e) {
        }
    }

    private void finalizarGrupo() {
        Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
        custo.setDescricao("fim");
        custo.setGrupo(1);

        list.add(custo);
    }

    private void calcularRealizadoPrevisto() {
        double totPrevistoMes = 0;
        double totRealizadoMes = 0;
        double totPrevistoAcum = 0;
        double totRealizadoAcum = 0;
        double totPrevistoMesGrupo = 0;
        double totRealizadoMesGrupo = 0;
        double totPrevistoAcumGrupo = 0;
        double totRealizadoAcumGrupo = 0;

        List<Integer> lisdel = new ArrayList();
        //ULTIMA LINHA DA LISTA NÃO ENTRA NA SOMA POR ISSO É LIST.SIZE() -2
        for (int i = list.size() - 2; i > -1; i--) {
            if (i > 1) {
                totPrevistoMes += list.get(i).getCustos_previsto();
                totRealizadoMes += list.get(i).getCusto_realizado();
                totPrevistoAcum += list.get(i).getAcum_previsto();
                totRealizadoAcum += list.get(i).getAcum_realizado();
            }
            totPrevistoMesGrupo += list.get(i).getCustos_previsto();
            totRealizadoMesGrupo += list.get(i).getCusto_realizado();
            totPrevistoAcumGrupo += list.get(i).getAcum_previsto();
            totRealizadoAcumGrupo += list.get(i).getAcum_realizado();
            String nm = list.get(i).getItem();


            if (list.get(i).getDescricao().equalsIgnoreCase("fim") & i != list.size() - 1) {
                list.get(i).setDescricao("");
                list.get(i + 1).setCustos_previsto(totPrevistoMesGrupo);
                list.get(i + 1).setCusto_realizado(totRealizadoMesGrupo);
                list.get(i + 1).setAcum_previsto(totPrevistoAcumGrupo);
                list.get(i + 1).setAcum_realizado(totRealizadoAcumGrupo);
                list.get(i + 1).setCustos_prev_realiz(((totRealizadoMesGrupo / totPrevistoMesGrupo) - 1) * 100);
                list.get(i + 1).setAcum_prev_realiz(((totRealizadoAcumGrupo / totPrevistoAcumGrupo) - 1) * 100);
                totPrevistoMesGrupo = 0;
                totRealizadoMesGrupo = 0;
                totPrevistoAcumGrupo = 0;
                totRealizadoAcumGrupo = 0;
                int posicao = i;
                lisdel.add(posicao);
            } else if (i == 0) {
                list.get(i).setCustos_previsto(totPrevistoMesGrupo);
                list.get(i).setCusto_realizado(totRealizadoMesGrupo);
                list.get(i).setAcum_previsto(totPrevistoAcumGrupo);
                list.get(i).setAcum_realizado(totRealizadoAcumGrupo);
                list.get(i).setCustos_prev_realiz(((totRealizadoMesGrupo / totPrevistoMesGrupo) - 1) * 100);
                list.get(i).setAcum_prev_realiz(((totRealizadoAcumGrupo / totPrevistoAcumGrupo) - 1) * 100);
            }
        }

        Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
        custo.setDescricao("TOTAL DOS CUSTOS");
        custo.setGrupo(0);
        custo.setCustos_previsto(totPrevistoMes);
        custo.setCusto_realizado(totRealizadoMes);
        custo.setAcum_previsto(totPrevistoAcum);
        custo.setAcum_realizado(totRealizadoAcum);
        custo.setCustos_prev_realiz(((totRealizadoMes / totPrevistoMes) - 1) * 100);
        custo.setAcum_prev_realiz(((totRealizadoAcum / totPrevistoAcum) - 1) * 100);
        list.add(custo);
    }

    public void addItem(String item, int grupo, int[] id_Classe, String descricao, boolean calcComprometimento) throws Exception {
        try {
            Custo_classe_regime_competenciaTMP custo = new Custo_classe_regime_competenciaTMP();
            custo.setItem(item);
            custo.setGrupo(grupo);
            custo.setDescricao(descricao);
            Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();

            double previstoMes = pdao.getCustoPrevistoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
            double realizadoMes = cdao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);

            double previstoAc = pdao.getCustoPrevistoAcmulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
            double realizadoAc = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
            double realizadoMesAnterior = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_Classe);

            double saldo = realizadoAc - realizadoMesAnterior;

            double compPrevMesCalc = 0;
            double compRealizMesCalc = 0;
            double compPrevMes = 0;
            double compRealizMes = 0;
            double compRealizMesAnterior = 0;
            double compPrevMesAnterior = 0;

            if (calcComprometimento) {
                Com_comprometimentoDAO com_comprometimentoDAO = getCom_comprometimentoDAO();
                compPrevMes = com_comprometimentoDAO.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe, true);
                compRealizMes = com_comprometimentoDAO.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe, false);

                compPrevMesAnterior = com_comprometimentoDAO.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_Classe, true);
                compRealizMesAnterior = com_comprometimentoDAO.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_Classe, false);

                compPrevMesCalc = compPrevMes - compPrevMesAnterior;
                compRealizMesCalc = compRealizMes - compRealizMesAnterior;

            }

            custo.setCustos_previsto(previstoMes + compPrevMesCalc);
            custo.setCusto_realizado(saldo + compRealizMesCalc);

            custo.setAcum_previsto(previstoAc + compPrevMes);
            custo.setAcum_realizado(realizadoAc + compRealizMes);
            list.add(custo);

        } catch (Exception e) {
            throw e;
        }
    }

    public double getTotalAcumuladoPrevisto() throws Exception {
        try {
            povoarLista();

            return list.get(list.size() - 1).getAcum_previsto();
        } catch (Exception e) {
        }
        return 0;
    }

    public double getoutros(TreeMap<String, String> map) {
        double valor = 0;
        for (Custo_classe_regime_competenciaTMP custoClass : list) {
            String a = custoClass.getItem();
            if (custoClass.getItem() != null) {
                boolean valido = map.get(custoClass.getItem()) == null ? false : true;
                if (valido) {
                    valor += custoClass.getAcum_previsto();
                }
            }
        }

        return valor;
    }

    public Custo_classe_regime_competenciaTMP getItemRealizadoPrevisto(String codItem) throws Exception {
        CalcularMesAnterior();
        if (codItem.equalsIgnoreCase("2")) {
            addEstoqueCTP();
            addMateriaisSemEstoque();
        } else if (codItem.equalsIgnoreCase("3")) {
            addMDOD();
        } else if (codItem.equalsIgnoreCase("4")) {
            addMDOI();
        } else if (codItem.equalsIgnoreCase("5")) {
            addCustosIndiretos();
        } else if (codItem.equalsIgnoreCase("6")) {
            addServicosTerceirizados();
        } else if (codItem.equalsIgnoreCase("7")) {
            addEquipamentos();
        } else if (codItem.equalsIgnoreCase("8")) {
            addCorretagem();
        } else if (codItem.equalsIgnoreCase("9")) {
            addPublicidade();
        } else if (codItem.equalsIgnoreCase("10")) {
            addLicenca();
        } else if (codItem.equalsIgnoreCase("11")) {
            addTributos();
        } else if (codItem.equalsIgnoreCase("12")) {
            addOutros();
        }

        double vlrAcPrevisto = 0;
        double vlrAcRealizado = 0;
        double vlrPrevisto = 0;
        double vlrRealizado = 0;
        for (Custo_classe_regime_competenciaTMP custoTMP : list) {
//            if (custoTMP.getGrupo() != 1) {//31/10/2011
            if (custoTMP.getItem() != null) {
                if (custoTMP.getItem().indexOf(codItem) > -1) {
                    vlrAcPrevisto += custoTMP.getAcum_previsto();
                    vlrAcRealizado += custoTMP.getAcum_realizado();
                    vlrPrevisto += custoTMP.getCustos_previsto();
                    vlrRealizado += custoTMP.getCusto_realizado();
                }
            }
        }
        
        double indeceAc = (vlrAcRealizado / vlrAcPrevisto) - 1;
        double indecePeri = (vlrRealizado / vlrPrevisto) - 1;
        Custo_classe_regime_competenciaTMP temp = new Custo_classe_regime_competenciaTMP();
        temp.setAcum_previsto(vlrAcPrevisto);
        temp.setAcum_realizado(vlrAcRealizado);
        temp.setCusto_realizado(vlrRealizado);
        temp.setCustos_previsto(vlrPrevisto);
        temp.setAcum_prev_realiz(indeceAc * 100);
        temp.setCustos_prev_realiz(indecePeri * 100);
        
        return temp;
    }

    public List<Custo_classe_regime_competenciaTMP> getList() {
        return list;
    }
}
