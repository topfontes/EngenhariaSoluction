/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.analiseCustosObraRegimeCompetencia;

import br.com.easynet.gwt.easyportal.dao.Com_comprometimentoDAO;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
import br.com.easynet.gwt.easyportal.dao.Flr_fluxo_receitaDAO;
import br.com.easynet.gwt.easyportal.dao.Fol_folha_pagamentoDAO;
import br.com.easynet.gwt.easyportal.dao.Frd_faturamento_rec_devolucaoDAO;
import br.com.easynet.gwt.easyportal.dao.Ipo_item_plano_contas_obraDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.dao.Pms_planilha_medicao_servicoDAO;
import br.com.easynet.gwt.easyportal.jb.Cronograma_fisico_fin_originalJB;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.jb.ObjetosCronoRegimeCaixaProjJB;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.relatorios.custo_classe_regime_competencia.CustoClasseRegimeCompetencia;
import br.com.easynet.gwt.easyportal.relatorios.fluxo_caixa_consolidado.FluxoCaixa_ConsolidadoJB;
import br.com.easynet.gwt.easyportal.temp.AnaliseCcustosRegimeCompetenciaTMP;
import br.com.easynet.gwt.easyportal.temp.Ficha_ResumoTMP;
import br.com.easynet.gwt.easyportal.temp.FluxoCaixaTMP;
import br.com.easynet.gwt.easyportal.temp.ResultadoCustoRegCompetenciaTMP;
import br.com.easynet.gwt.easyportal.temp.Sub_ResultadoCustoRegCompetenciaTMP;
import br.com.easynet.gwt.easyportal.transfer.Flr_fluxo_receitaT;
import br.com.easynet.gwt.easyportal.transfer.Frd_faturamento_rec_devolucaoT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.gwt.easyportal.transfer.Tes_temporaria_servicoT;
import br.com.easynet.gwt.easyportal.util.MatematicaFinanceira;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */

public class AnaliseCustosRegimeCompetencia extends RelatorioBase {

    private List<AnaliseCcustosRegimeCompetenciaTMP> list = new ArrayList<AnaliseCcustosRegimeCompetenciaTMP>();
    private int mesAnterior;
    private int anoAnt;
    private ObjetosCronoRegimeCaixaProjJB objetosCronoRegimeCaixaProjJB;
    private List<Flr_fluxo_receitaT> listFluxoReceita;
    private List<Frd_faturamento_rec_devolucaoT> listFrdAcumulado;
    private List<Frd_faturamento_rec_devolucaoT> listFrdMesAnt;
    private double totOrcorig;
    private double totOrcorigAtual;
    private boolean fichaResumo;
    private double originalpermulta;
    private double atulizadoPermulta;
    private double vgvOriginal;
    private double vgvAtualizado;
    private double valorfaturamentoPeriodo;
    private FluxoCaixa_ConsolidadoJB fluxoCaixaJB = new FluxoCaixa_ConsolidadoJB();
    private List<FluxoCaixaTMP> listFluxocaixa = new ArrayList<FluxoCaixaTMP>();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void CalcularMesAnterior() {

        if (getMeo_meses_obraT().getMes() == 1) {
            anoAnt = getMeo_meses_obraT().getAno() - 1;
            mesAnterior = 12;
        } else {
            mesAnterior = getMeo_meses_obraT().getMes() - 1;
            anoAnt = getMeo_meses_obraT().getAno();
        }
    }

    public void instanciarObjetosCronoRegimeCaixaProjJB() throws Exception {
        try {
            objetosCronoRegimeCaixaProjJB = new ObjetosCronoRegimeCaixaProjJB(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno());
            objetosCronoRegimeCaixaProjJB.setPage(page);
            objetosCronoRegimeCaixaProjJB.povoarObjetos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimir() {
        try {
            instanciarObjetosCronoRegimeCaixaProjJB();
            CalcularMesAnterior();
            custosDiretos();//s
            custosIndiretos();//s
            corretagem();//s
            publicidade();//s
            licencaseTaxas();//s
            impostos();//s
            outros();//s
            calcularRealizadoPrevisto();
            addParametroTabelaVGV();

            JRBeanCollectionDataSource dsResultado = new JRBeanCollectionDataSource(getlistResultado());
            jRDataSource = new JRBeanCollectionDataSource(list);
            getParameters().put("resultado", dsResultado);
            
            String path = application.getRealPath("jasper/Resultados.jasper");
            path = path.substring(0, path.indexOf("Resultados.jasper"));
            System.out.println("path ="+path);
            getParameters().put("pathSub", path);
            getParameters().put("SUBREPORT_DIR", path);

            JRBeanCollectionDataSource dsSub_Resultado = new JRBeanCollectionDataSource(getlistSubResultado());
            getParameters().put("sub_resultado", dsSub_Resultado);

            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = AnaliseCustosRegimeCompetencia.class.getResourceAsStream("AnaliseCustosRegimeCompetencia.jasper");
            } else {
                url = AnaliseCcustosRegimeCompetenciaTMP.class.getResource("AnaliseCustosRegimeCompetencia.jasper");
            }
            print("AnaliseCustoObrasReg_Competencia", "ANÁLISE DOS CUSTOS DA OBRA POR REGIME DE COMPETÊNCIA");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

//    public static void main(String[] arg) {
//        AnaliseCustosRegimeCompetencia acrc = new AnaliseCustosRegimeCompetencia();
//        double[] vet = new double[10];
//        vet[0] = 0;
//        vet[1] = 0;
//        vet[2] = 4939267.25;
//        vet[3] = 7051779.34;
//        vet[4] = -146941.78;
//        vet[5] = -2509733.98;
//        vet[6] = -2822995.21;
//        vet[7] = -1811587.85;
//        vet[8] = -1335269.28;
//        vet[9] = -4514503.21;
//
//        //acrc.getVPL(0.89, vet);
//        double taxa = acrc.getTIR(vet);
//    }
//
//    public double getTIR(double[] vet) {
//        double inicio = 0.0001;
//        double resultado = 0;
//        int cont = 0;
//        int tt = 0;
//        boolean op_sinal = true;
//        boolean opVpl;
//        while (inicio <= 100) {
//            double vlVPL = getVPL(inicio, vet);
//            if (inicio == 0.0001) {
//                op_sinal = vlVPL < 0;
//            } else {
//                opVpl = vlVPL < 0;
//                if (op_sinal != opVpl) {
//                    op_sinal = opVpl;
//                    resultado = inicio;
//                    cont++;
//                    //System.out.println("taxa =  " + inicio);
//                }
//            }
//            inicio += 0.0001;
//            tt++;
//        }
//        if (cont != 1) {
//            resultado = 0;
//        }
//        return resultado;
//    }
//
//    public double getVPL(double fator, double[] array) {
//        double valor = 0;
//        double newFator = fator / 100;
//        newFator += 1;
//        for (int i = 0; i < array.length; i++) {
//            double elev = valorElevado(newFator, i + 1);
//            double vlr = array[i];
//            valor += vlr / elev;
//        }
//        return valor;
//    }
//
//    public double valorElevado(double valor, int elevacao) {
//        double vl = valor;
//        for (double i = 1; i < elevacao; i++) {
//            double e = i;
//            vl = vl * valor;
//        }
//        return vl;
//    }
    public double povoaListFluxoReceita() throws Exception {
        double valor = 0;
        try {
            Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
            Flr_fluxo_receitaT flr_fluxo_receitaT = new Flr_fluxo_receitaT();
            flr_fluxo_receitaT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            flr_fluxo_receitaT.setFlr_nr_mes_ref(getMeo_meses_obraT().getMes());
            flr_fluxo_receitaT.setFlr_nr_ano_ref(getMeo_meses_obraT().getAno());
            listFluxoReceita = flr_fluxo_receitaDAO.getAll(flr_fluxo_receitaT);

        } catch (Exception e) {
            throw e;
        }
        return valor;
    }

    public double getVGV(String tipo) throws Exception {
        double valor = 0;
        try {
            for (Flr_fluxo_receitaT flr_fluxo : listFluxoReceita) {
                if (tipo.equalsIgnoreCase("O")) {
                    valor += flr_fluxo.getFlr_nr_original();
                } else {
                    valor += flr_fluxo.getFlr_nr_atual();
                }
            }
        } catch (Exception e) {
        }
        return valor;
    }

    public double getValorFluxoReceitaNoPeriodo() {
        double valor = 0;
        try {
            for (Flr_fluxo_receitaT flr_fluxo_receitaT : listFluxoReceita) {
                if (flr_fluxo_receitaT.getFlr_nr_ano() == getMeo_meses_obraT().getAno() & flr_fluxo_receitaT.getFlr_nr_mes() == getMeo_meses_obraT().getMes()) {
                    valor = flr_fluxo_receitaT.getFlr_nr_atual();
                }
            }
        } catch (Exception e) {
        }
        return valor;
    }
 
    public double getValorFluxoReceitaAtePeriodo() {
        double valor = 0;
        try {
            for (Flr_fluxo_receitaT flr_fluxo_receitaT : listFluxoReceita) {
                if (flr_fluxo_receitaT.getFlr_nr_ano() <= getMeo_meses_obraT().getAno()) {
                    if (flr_fluxo_receitaT.getFlr_nr_mes() <= getMeo_meses_obraT().getMes()) {
                        valor += flr_fluxo_receitaT.getFlr_nr_atual();
                    }
                }
            }
        } catch (Exception e) {
        }
        return valor;
    }

    public void povoaFrdAtePeriodo() throws Exception {
        try {
            Frd_faturamento_rec_devolucaoDAO fdao = getFrd_faturamento_rec_devolucaoDAO();
            Frd_faturamento_rec_devolucaoT ft = new Frd_faturamento_rec_devolucaoT();
            ft.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            ft.setFrd_nr_mes(getMeo_meses_obraT().getMes());
            ft.setFrd_nr_ano(getMeo_meses_obraT().getAno());
            listFrdAcumulado = fdao.getObraMesAno(ft);
        } catch (Exception e) {
        }
    }

    public void povoaFrdNoPeriodo() throws Exception {
        try {
            Frd_faturamento_rec_devolucaoDAO fdao = getFrd_faturamento_rec_devolucaoDAO();
            Frd_faturamento_rec_devolucaoT ft = new Frd_faturamento_rec_devolucaoT();
            ft.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            ft.setFrd_nr_mes(mesAnterior);
            ft.setFrd_nr_ano(anoAnt);
            listFrdMesAnt = fdao.getObraMesAno(ft);
        } catch (Exception e) {
        }
    }

    public double getTotalFluxoReceita() throws Exception {
        double valor = 0;
        try {
            for (Flr_fluxo_receitaT flr_fluxo_receitaT : listFluxoReceita) {
                valor += flr_fluxo_receitaT.getFlr_nr_atual();
            }
        } catch (Exception e) {
            throw e;
        }

        return valor;
    }

    public double getTotalMesesCronograma() {
        double valor = 0;
        Set<String> key = objetosCronoRegimeCaixaProjJB.getTreeTotalMes().keySet();
        for (Iterator<String> it = key.iterator(); it.hasNext();) {
            String kk = it.next();
            valor += objetosCronoRegimeCaixaProjJB.getTreeTotalMes().get(kk).getTotalMes();
        }
        return valor;
    }

    public void addParametroTabelaVGV() throws Exception {
        try {
            originalpermulta = getObr_obrasT().getObr_nr_valor_permutado();
            getParameters().put("original_permuta", getOriginalpermulta());
            povoaListFluxoReceita();
            povoaFrdAtePeriodo();
            povoaFrdNoPeriodo();

            vgvOriginal = getVGV("O");
            getParameters().put("original_vgv", vgvOriginal);

            Frd_faturamento_rec_devolucaoT frdAculado = new Frd_faturamento_rec_devolucaoT();

            if (listFrdAcumulado != null & listFrdAcumulado.size() > 0) {
                frdAculado = listFrdAcumulado.get(0);
            }
            Frd_faturamento_rec_devolucaoT frdMesAnt = new Frd_faturamento_rec_devolucaoT();
            if (listFrdMesAnt != null & listFrdMesAnt.size() > 0) {
                frdMesAnt = listFrdMesAnt.get(0);
            }

            double valorPermulta = frdAculado.getFrd_nr_valor_permutas();
            atulizadoPermulta = valorPermulta;
            getParameters().put("atualizado_permuta", valorPermulta);
            vgvAtualizado = getVGV("A");
            getParameters().put("atualizado_vgv", vgvAtualizado);
            double noperiodo = frdAculado.getFrd_nr_valor_permutas() - frdMesAnt.getFrd_nr_valor_permutas();
            getParameters().put("no_periodo_permuta", noperiodo);

            double devolucoes = frdAculado.getFrd_nr_valor_devolucao() - frdMesAnt.getFrd_nr_valor_devolucao();
            getParameters().put("no_periodo_devolucao", devolucoes);

            double faturamento = frdAculado.getFrd_nr_valor_faturamento() - frdMesAnt.getFrd_nr_valor_faturamento();
            getParameters().put("no_periodo_faturamento", faturamento);

            getParameters().put("ate_periodo_permuta", noperiodo);
            double devolucao = frdAculado.getFrd_nr_valor_devolucao();
            getParameters().put("ate_periodo_devolucao", devolucao);
            setValorfaturamentoPeriodo(frdAculado.getFrd_nr_valor_faturamento());
            getParameters().put("ate_periodo_faturamento", getValorfaturamentoPeriodo());

            getParameters().put("no_periodo_recebimento", getValorFluxoReceitaNoPeriodo());
            getParameters().put("ate_periodo_recebimento", getValorFluxoReceitaAtePeriodo());
            getParameters().put("saldo_faturamento", getVGV("A") - getValorfaturamentoPeriodo());
            getParameters().put("saldo_recebimento", getVGV("A") - getValorFluxoReceitaAtePeriodo());
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ResultadoCustoRegCompetenciaTMP> getlistResultado() throws Exception {
        List<ResultadoCustoRegCompetenciaTMP> listRes = new ArrayList<ResultadoCustoRegCompetenciaTMP>();
        try {
            ResultadoCustoRegCompetenciaTMP res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.1");
            res.setDescricao("LL(Resultado) c/ Encargos Financeiros / Juros de Aplicações (R$)");
            double res10_1 = getVGV("O") - totOrcorig;
            double fluxoConsolidado = getValorFluxoConsolidado();
            double res10_1a = fluxoConsolidado * -1;
            res.setValor_original(res10_1);
            res.setValor_atualizado(res10_1a);
            listRes.add(res);

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.2");
            res.setDescricao("LL(Resultado) s/ Encargos Financeiros / Juros de Aplicações (R$)");
            res.setValor_original(getVGV("O") - totOrcorig);
            double valorReceita = getTotalFluxoReceita() - getTotalMesesCronograma();
            res.setValor_atualizado(valorReceita);
            listRes.add(res);

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.3");
            res.setDescricao("LL c/ Enc. Fin. / Juros de Aplic. sobre Venda ((10.1)/(9.2)) (%)");
            res.setValor_original((res10_1 / getVGV("O")) * 100);
            res.setValor_atualizado((res10_1a / getVGV("A")) * 100);
            listRes.add(res);

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.4");
            res.setDescricao("LL c/ Enc. Fin. / Juros de Aplic. sobre Custos ((10.1)/(8)) (%)");
            res.setValor_original((res10_1 / totOrcorig) * 100);
            res.setValor_atualizado((res10_1a / totOrcorigAtual) * 100);
            listRes.add(res);

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.5");
            res.setDescricao("LL c/ Enc. Fin. / Juros de Aplic. sobre Custos Diretos ((10.1)/(1)) (%)");
            double orcorig = list.get(0).getOrRcamentoOrignal();
            double orcorigatual = list.get(0).getOrcamentoAtualizado();
            res.setValor_original((res10_1 / list.get(0).getOrRcamentoOrignal()) * 100);
            res.setValor_atualizado((res10_1a / list.get(0).getOrcamentoAtualizado()) * 100);
            listRes.add(res);

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.6");
            res.setDescricao("LL c/ Enc. Fin. / Juros de Aplic. sobre Custos Indiretos ((10.1)/(2)) (%)");
            res.setValor_original((res10_1 / list.get(6).getOrRcamentoOrignal()) * 100);
            res.setValor_atualizado((res10_1a / list.get(6).getOrcamentoAtualizado()) * 100);
            listRes.add(res);

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.7");
            res.setDescricao("Fator ID (Custos Ind. / Custos Diretos) [(2)/(1)] (%)");
            res.setValor_original((list.get(6).getOrRcamentoOrignal() / list.get(0).getOrRcamentoOrignal()) * 100);
            res.setValor_atualizado((list.get(6).getOrcamentoAtualizado() / list.get(0).getOrcamentoAtualizado()) * 100);
            listRes.add(res);

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.8");
            res.setDescricao("TMA(a.m.) (%)");
            res.setValor_original(0);
            res.setValor_atualizado(getObr_obrasT().getObr_nr_encarcos_juros_aplicacao());
            listRes.add(res);

            double tir = getTir();
            double fator_10_12 = getVplInvestimentos();
            double fator_10_13 = getVplRetorno() * -1;
            double payback = 0;//getPayBack();

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.9");
            res.setDescricao("TIR (a.m) (%)");
            res.setValor_original(0);
            res.setValor_atualizado(tir);

            listRes.add(res);
            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.10");
            res.setDescricao("IBC");
            res.setValor_original(0);
            res.setValor_atualizado(fator_10_13 / fator_10_12);
            listRes.add(res);

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.11");
            res.setDescricao("PAYBACK");
            res.setValor_original(0);
            res.setValor_atualizado(payback);
            listRes.add(res);

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.12");
            res.setDescricao("VPL Investimentos (R$)");
            res.setValor_original(0);
            res.setValor_atualizado(fator_10_12);
            listRes.add(res);

            res = new ResultadoCustoRegCompetenciaTMP();
            res.setItem("10.13");
            res.setDescricao("VPL Retorno (R$)");
            res.setValor_original(0);
            res.setValor_atualizado(fator_10_13);
            listRes.add(res);

        } catch (Exception e) {
            throw e;
        }
        return listRes;
    }

    public List<Sub_ResultadoCustoRegCompetenciaTMP> getlistSubResultado() throws Exception {
        List<Sub_ResultadoCustoRegCompetenciaTMP> listSub = new ArrayList<Sub_ResultadoCustoRegCompetenciaTMP>();

        Sub_ResultadoCustoRegCompetenciaTMP res = new Sub_ResultadoCustoRegCompetenciaTMP();
        res.setItem("11.1");
        res.setDescricao("INICIO DA OBRA");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        res.setPlanejamento(sdf.format(getObr_obrasT().getObr_dt_inicio()));
        res.setAcompanhamento(sdf.format(getObr_obrasT().getObr_dt_inicio_controle()));
        listSub.add(res);

        res = new Sub_ResultadoCustoRegCompetenciaTMP();
        res.setItem("11.2");
        res.setDescricao("TERMINO DA OBRA");
        res.setPlanejamento(sdf.format(getObr_obrasT().getObr_dt_fim()));
        res.setAcompanhamento(sdf.format(getObr_obrasT().getObr_dt_termino_controle()));
        listSub.add(res);

        Cronograma_fisico_fin_originalJB jB = new Cronograma_fisico_fin_originalJB();
        jB.setPage(page);
        jB.getVw_importacao_orcamentoT().setObr_nr_id(getObr_obrasT().getObr_nr_id());
        double percAcumuladoCronograma = jB.getPercTotalAcumuladoPeriodo(getMeo_meses_obraT());
        percAcumuladoCronograma = percAcumuladoCronograma;

        CustoClasseRegimeCompetencia competencia = new CustoClasseRegimeCompetencia();
        competencia.setPage(page);
        competencia.setMeo_meses_obraT(getMeo_meses_obraT());
        competencia.setObr_obrasT(getObr_obrasT());
        double acumuladoPrevisto = competencia.getTotalAcumuladoPrevisto();

        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("2", "2");
        map.put("3", "3");
        map.put("6", "6");
        map.put("7", "7");
        double acprev = competencia.getoutros(map);
        double totalOrcado = list.get(list.size() - 1).getOrRcamentoOrignal();

        res = new Sub_ResultadoCustoRegCompetenciaTMP();
        res.setItem("11.3");
        res.setDescricao("CURVA 'S' FÍSICA FINANCEIRA - GERAL");
        res.setPlanejamento(Funcoes.FormatoMoedaBR_Double(percAcumuladoCronograma * 100) + "%");
        double acompanhamento = (acumuladoPrevisto / totOrcorig);
        res.setAcompanhamento(Funcoes.FormatoMoedaBR_Double(acompanhamento * 100) + "%");

        double vlPlan_Acomp = percAcumuladoCronograma - acompanhamento;
        res.setPlanejamento_acompanhamento(Funcoes.FormatoMoedaBR_Double(vlPlan_Acomp * 100) + "%");
        listSub.add(res);

        res = new Sub_ResultadoCustoRegCompetenciaTMP();
        res.setItem("11.4");
        res.setDescricao("CURVA 'S' FÍSICA FINANCEIRA - CUSTOS DIRETOS");

        double[] vet = objetosCronoRegimeCaixaProjJB.getCustosDiretos();
        double vlPlan = vet[0] / vet[1];
        res.setPlanejamento(Funcoes.FormatoMoedaBR_Double(vlPlan * 100) + "%");
        acompanhamento = acprev / totOrcorig;
        res.setAcompanhamento(Funcoes.FormatoMoedaBR_Double(acompanhamento * 100) + "%");
        vlPlan_Acomp = vlPlan - acompanhamento;
        res.setPlanejamento_acompanhamento(Funcoes.FormatoMoedaBR_Double(vlPlan_Acomp * 100) + "%");
        listSub.add(res);

        return listSub;
    }

    public double getValorFluxoConsolidado() throws Exception {
        double valor = 0;
        try {
            fluxoCaixaJB.setPage(page);
            fluxoCaixaJB.setObr_obrasT(getObr_obrasT());
            fluxoCaixaJB.setMeo_meses_obraT(getMeo_meses_obraT());
            fluxoCaixaJB.consultResultado(objetosCronoRegimeCaixaProjJB.getTreeTotalMes());
            valor = fluxoCaixaJB.getSaldoIxR(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno());
            listFluxocaixa = fluxoCaixaJB.getListFluxocaixa();
        } catch (Exception e) {
            throw e;
        }
        return valor;
    }

    public double[] custosDiretos() throws Exception {
        double original = 0;
        double atualizado = 0;
        AnaliseCcustosRegimeCompetenciaTMP analise = new AnaliseCcustosRegimeCompetenciaTMP();
        analise.setGrupo(0);
        analise.setItem("1");
        analise.setDescricao("CUSTOS DIRETOS");
        list.add(analise);

        int[] id_Materias = {65};
        addItemMateriais("1.1", 1, id_Materias, "MATERIAIS", false);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        int[] id_MaoObra = {204};

        addItemMDO("1.2", 1, id_MaoObra, "MÃO DE OBRA", false);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        int[] id_ServTerc = {38};
        addItem("1.3", 1, id_ServTerc, "SERVIÇOS TERCEIRIZADO", true);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        int[] id_CustosDireto = {82};
        addItem("1.4", 1, id_CustosDireto, "EQUIPAMENTOS DOS CUSTOS DIRETOS", true);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        finalizarGrupo();
        double[] lis = new double[2];
        lis[0] = original;
        lis[1] = atualizado;
        return lis;
    }

    public double[] custosIndiretos() throws Exception {
        double original = 0;
        double atualizado = 0;

        AnaliseCcustosRegimeCompetenciaTMP analise = new AnaliseCcustosRegimeCompetenciaTMP();
        analise.setGrupo(0);
        analise.setItem("2");
        analise.setDescricao("CUSTOS INDIRETOS");
        list.add(analise);

        int[] id_MaodeObra = {191};
        addItemMDO("2.1", 1, id_MaodeObra, "MÃO DE OBRA", false);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        int[] id_Rateio = {249};
        addItem("2.2", 1, id_Rateio, "RATEIO DO ESCRITÓRIO CENTRAL", false);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        int[] id_DemaisCustos = {37};//falta
        addItem("2.3", 1, id_DemaisCustos, "DEMAIS CUSTOS INDIRETOS", true);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        finalizarGrupo();
        double[] lis = new double[2];
        lis[0] = original;
        lis[1] = atualizado;
        return lis;
    }

    public double[] corretagem() throws Exception {
        double original = 0;
        double atualizado = 0;
        AnaliseCcustosRegimeCompetenciaTMP analise = new AnaliseCcustosRegimeCompetenciaTMP();
        analise.setGrupo(0);
        analise.setItem("3");
        analise.setDescricao("CORRETAGEM");
        list.add(analise);
        int[] id_Corretagem = {55};
        addItem("3.1", 1, id_Corretagem, "CORRETAGEM", true);

        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();
        double[] lis = new double[2];
        lis[0] = original;
        lis[1] = atualizado;
        finalizarGrupo();
        return lis;
    }

    public double[] publicidade() throws Exception {
        double original = 0;
        double atualizado = 0;
        AnaliseCcustosRegimeCompetenciaTMP analise = new AnaliseCcustosRegimeCompetenciaTMP();
        analise.setGrupo(0);
        analise.setItem("4");
        analise.setDescricao("PUBLICIDADE");
        list.add(analise);
        int[] id_Publicidade = {56};
        addItem("4.1", 1, id_Publicidade, "PUBLICIDADE", true);

        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();
        double[] lis = new double[2];
        lis[0] = original;
        lis[1] = atualizado;
        finalizarGrupo();
        return lis;
    }

    public double[] licencaseTaxas() throws Exception {
        double original = 0;
        double atualizado = 0;
        AnaliseCcustosRegimeCompetenciaTMP analise = new AnaliseCcustosRegimeCompetenciaTMP();
        analise.setGrupo(0);
        analise.setItem("5");
        analise.setDescricao("LICENÇAS E TAXAS");
        list.add(analise);
        int[] id_Taxas = {57};
        addItem("5.1", 1, id_Taxas, "LICENÇAS E TAXAS", true);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();
        double[] lis = new double[2];
        lis[0] = original;
        lis[1] = atualizado;
        finalizarGrupo();

        finalizarGrupo();
        return lis;

    }

    public double[] impostos() throws Exception {
        double original = 0;
        double atualizado = 0;
        AnaliseCcustosRegimeCompetenciaTMP analise = new AnaliseCcustosRegimeCompetenciaTMP();
        analise.setGrupo(0);
        analise.setItem("6");
        analise.setDescricao("IMPOSTOS");
        list.add(analise);

        int[] id_Pis = {41};
        addItem("6.1", 1, id_Pis, "PIS", false);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        int[] id_Cofins = {42};
        addItem("6.2", 1, id_Cofins, "COFINS", false);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        int[] id_Irpj = {43};
        addItem("6.3", 1, id_Irpj, "IRPJ", false);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        int[] id_CSLL = {44};
        addItem("6.4", 1, id_CSLL, "CSLL", false);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        int[] id_ISS = {45};
        addItem("6.5", 1, id_ISS, "ISS", false);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();


        int[] id_ImpostosUnificado = {46};
        addItem("6.6", 1, id_ImpostosUnificado, "IMPOSTOS UNIFICADOS", false);
        //dados serve para o relatório FICHA RESUMO
        original += list.get(list.size() - 1).getOrRcamentoOrignal();
        atualizado += list.get(list.size() - 1).getOrcamentoAtualizado();

        int[] id_CompImportos = {42, 44, 43, 45, 46, 41};

        double valorPeriodo = getcomprometimentoMes(id_CompImportos);
        double valorAcumulado = getcomprometimentoAcumulados(id_CompImportos);
        analise = new AnaliseCcustosRegimeCompetenciaTMP();
        analise.setGrupo(1);
        analise.setItem("6.7");
        analise.setDescricao("COMPROMETIMENTO DOS IMPOSTOS");
        analise.setRealizadoPeriodo(valorPeriodo);
        analise.setRealizadoAtePeriodo(valorAcumulado);

        //analise.setAcrescimoEconomiaProjetado(getvalorProjetado(id_CompImportos));

        list.add(analise);
//        addItem("6.7", 1, id_CompImportos, "COMPROMETIMENTO DOS IMPOSTOS", false);

        finalizarGrupo();

        double[] lis = new double[2];
        lis[0] = original;
        lis[1] = atualizado;
        return lis;
    }

    public TreeMap<Integer, Ficha_ResumoTMP> outros() throws Exception {

        Ficha_ResumoTMP ficha_ResumoTMP = null;
        //a chave do treeMap é o código do do item no relatório ficha resumo.
        TreeMap<Integer, Ficha_ResumoTMP> tree = new TreeMap<Integer, Ficha_ResumoTMP>();
        AnaliseCcustosRegimeCompetenciaTMP analise = new AnaliseCcustosRegimeCompetenciaTMP();
        analise.setGrupo(0);
        analise.setItem("7");
        analise.setDescricao("OUTROS");
        list.add(analise);

        int[] id_Terreno = {39};
        addItem("7.1", 1, id_Terreno, "TERRENO", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(4, ficha_ResumoTMP);


        int[] id_projetosManu = {49};
        addItem("7.2", 1, id_projetosManu, "PROJETOS MANUAIS, CONSULTORIA E SONDAGEM", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(5, ficha_ResumoTMP);

        int[] id_tao = {50};
        addItem("7.3", 1, id_tao, "TAO-TAXA P/ACOMPANHAMENTO DA OBRA", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(6, ficha_ResumoTMP);

        int[] id_produtos = {51};
        addItem("7.4", 1, id_produtos, "PRODUTOS DA CEF", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(7, ficha_ResumoTMP);


        int[] id_juros = {52};
        addItem("7.5", 1, id_juros, "JUROS DO FINANCIAMENTO", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(8, ficha_ResumoTMP);

        int[] id_SegEng = {256};
        addItem("7.6", 1, id_SegEng, "SEGUROS(RISCO DO ENGENHEIRO)", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());


        int[] id_SegConstru = {53};
        addItem("7.7", 1, id_SegConstru, "SEGUROS(GARANTIA DO CONSTRUTOR/OUTROS SEGUROS)", true);
        ficha_ResumoTMP.setValor_original(ficha_ResumoTMP.getValor_original() + list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(ficha_ResumoTMP.getValor_atualizado() + list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(9, ficha_ResumoTMP);

        int[] id_despCart = {58};
        addItem("7.8", 1, id_despCart, "DESPESAS CARTORIAS/AVERBAÇÃO/REGISTRO", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(10, ficha_ResumoTMP);

        int[] id_TrabSoci = {59};
        addItem("7.9", 1, id_TrabSoci, "TRABALHO SOCIAL", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(11, ficha_ResumoTMP);


        int[] id_ImpIndireto = {60};
        addItem("7.10", 1, id_ImpIndireto, "STAND DE VENDAS / OUTRAS DESPESAS", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(12, ficha_ResumoTMP);


        int[] id_EncargosFin = {61};
        addItem("7.11", 1, id_EncargosFin, "ENCARGOS FINANCEIROS/TARIFAS BANCARIAS", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(13, ficha_ResumoTMP);



        int[] id_Emprevistos = {62};
        addItem("7.12", 1, id_Emprevistos, "IMPREVISTOS E CONTINGÊNCIA", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(14, ficha_ResumoTMP);


        int[] id_Manutencao = {63};
        addItem("7.13", 1, id_Manutencao, "MANUTENÇÃO PREDIAL /PÓS ENTREGA)", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(15, ficha_ResumoTMP);


        int[] id_AdmCentral = {40};
        addItem("7.14", 1, id_AdmCentral, "ADMINISTRAÇÃO CENTRAL", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(16, ficha_ResumoTMP);


        int[] id_rateio = {255};
        addItem("7.15", 1, id_rateio, "RATEIO DO ESCRITÓRIO CENTRAL(COMERCIAL)", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(17, ficha_ResumoTMP);

        int[] id_valorFinaciamento = {260};
        addItem("7.16", 1, id_rateio, "VALOR DO FINANCEAMENTO", true);
        //dados serve para o relatório FICHA RESUMO
        ficha_ResumoTMP = new Ficha_ResumoTMP();
        ficha_ResumoTMP.setValor_original(list.get(list.size() - 1).getOrRcamentoOrignal());
        ficha_ResumoTMP.setValor_atualizado(list.get(list.size() - 1).getOrcamentoAtualizado());
        tree.put(18, ficha_ResumoTMP);

        return tree;
    }

    public void addItemMateriais(String item, int grupo, int[] id_Classe, String descricao, boolean calcComprometimento) throws Exception {
        try {

            Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
            double valorOrcado = idao.getValorOrcadoClasses(getObr_obrasT().getObr_nr_id(), id_Classe);
            AnaliseCcustosRegimeCompetenciaTMP analise = new AnaliseCcustosRegimeCompetenciaTMP();
            analise.setGrupo(grupo);
            analise.setItem(item);
            analise.setDescricao(descricao);
            analise.setOrcamentoOrignal(valorOrcado);

            double valorCompPeriodo = getcomprometimentoMes(id_Classe);
            double valorCompAtePeriodo = getcomprometimentoAcumulados(id_Classe);

            Est_estoqueDAO edao = getEst_estoqueDAO();
            double valorEstoque = edao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
            double calc_vl_mes_ant = edao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_Classe);
            double valorprevistoEst = valorEstoque - calc_vl_mes_ant;

            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();

            double valorRealizadoPeriodo = cdao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
            double valorRealizadoAcumulado = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);

            analise.setRealizadoPeriodo((valorRealizadoPeriodo - valorprevistoEst) + valorCompPeriodo);
            analise.setRealizadoAtePeriodo((valorRealizadoAcumulado - valorEstoque) + valorCompAtePeriodo);

            Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
            double valorAcrescimoEco = pdao.getCustoPrevistoAcmulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
            analise.setAcrescimoEconomia(valorAcrescimoEco);

            analise.setAcrescimoEconomiaProjetado(getvalorProjetado(id_Classe));

            calculo(analise);

            list.add(analise);
        } catch (Exception e) {
            throw e;
        }
    }

    public void addItem(String item, int grupo, int[] id_Classe, String descricao, boolean calcComprometimento) throws Exception {

        Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
        double valorOrcado = idao.getValorOrcadoClasses(getObr_obrasT().getObr_nr_id(), id_Classe);
        AnaliseCcustosRegimeCompetenciaTMP analise = new AnaliseCcustosRegimeCompetenciaTMP();
        analise.setGrupo(grupo);
        analise.setItem(item);
        analise.setDescricao(descricao);
        analise.setOrcamentoOrignal(valorOrcado);

        double valorCompPeriodo = 0;
        double valorCompAtePeriodo = 0;
        if (calcComprometimento) {
            valorCompPeriodo = getcomprometimentoMes(id_Classe);
            valorCompAtePeriodo = getcomprometimentoAcumulados(id_Classe);
        }

        Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
//        double valorRealizadoPeriodo = cdao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);

        double realizadoAc = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
        double realizadoMesAnterior = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_Classe);
        double saldo = realizadoAc - realizadoMesAnterior;

        analise.setRealizadoPeriodo(saldo + valorCompPeriodo);



        double valorRealizadoAcumulado = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
        analise.setRealizadoAtePeriodo(valorRealizadoAcumulado + valorCompAtePeriodo);

        Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
        double valorAcrescimoEco = pdao.getCustoPrevistoAcmulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
        analise.setAcrescimoEconomia(valorAcrescimoEco);

        analise.setAcrescimoEconomiaProjetado(getvalorProjetado(id_Classe));
        calculo(analise);
        list.add(analise);
    }

    public void addItemMDO(String item, int grupo, int[] id_Classe, String descricao, boolean calcComprometimento) throws Exception {

        Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
        double valorOrcado = idao.getValorOrcadoClasses(getObr_obrasT().getObr_nr_id(), id_Classe);
        AnaliseCcustosRegimeCompetenciaTMP analise = new AnaliseCcustosRegimeCompetenciaTMP();
        analise.setGrupo(grupo);
        analise.setItem(item);
        analise.setDescricao(descricao);
        analise.setOrcamentoOrignal(valorOrcado);

        Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
        double valorRealizadoPeriodo = cdao.getCustoRealizadoPeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
        analise.setRealizadoPeriodo(getMDOMes(id_Classe));

        double valorRealizadoAcumulado = cdao.getCustoRealizadoAcumulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
        analise.setRealizadoAtePeriodo(getMDOAcumulado(id_Classe));


        Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
        double valorAcrescimoEco = pdao.getCustoPrevistoAcmulado(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_Classe);
        analise.setAcrescimoEconomia(valorAcrescimoEco);
        analise.setAcrescimoEconomiaProjetado(getvalorProjetado(id_Classe));

        calculo(analise);

        list.add(analise);
    }

    public double getMDOMes(int[] id_classeMDOD) throws Exception {
        try {

            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = obr_obrasDAO.getByPK(getObr_obrasT()).get(0);

            Fol_folha_pagamentoDAO fdao = getFol_folha_pagamentoDAO();
            double vl_salarioRealizadoOficial = fdao.getCustoRealizadoMesOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);
            double vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoMesNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);
            double basecalc = (obr_obrasT.getObr_nr_percent_mdo_direta() / 100);
            double valorSalarioRealizado = vl_salarioRealizadoOficial + vl_salariodRealizadoNaoOficial;

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoMesOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoMesNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);

            double valorEncargos = vl_salarioRealizadoOficial * basecalc;
            double valorComprometimento = getcomprometimentoMes(id_classeMDOD);
            return valorSalarioRealizado + valorEncargos + valorComprometimento;

        } catch (Exception e) {
            throw e;
        }
    }

    public double getMDOAcumulado(int[] id_classeMDOD) throws Exception {
        try {

            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = obr_obrasDAO.getByPK(getObr_obrasT()).get(0);

            Fol_folha_pagamentoDAO fdao = getFol_folha_pagamentoDAO();
            double vl_salarioRealizadoOficial = fdao.getCustoRealizadoAcumuladoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);
            double vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoAcumuladoNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);
            double basecalc = (obr_obrasT.getObr_nr_percent_mdo_direta() / 100);
            double valorSalarioRealizado = vl_salarioRealizadoOficial + vl_salariodRealizadoNaoOficial;

            vl_salarioRealizadoOficial = fdao.getCustoRealizadoAcumuladoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);
            vl_salariodRealizadoNaoOficial = fdao.getCustoRealizadoAcumuladoNaoOficial(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classeMDOD);

            double valorEncargos = vl_salarioRealizadoOficial * basecalc;
            double valorComprometimento = getcomprometimentoAcumulados(id_classeMDOD);
            return valorSalarioRealizado + valorEncargos + valorComprometimento;

        } catch (Exception e) {
            throw e;
        }
    }

    private double getcomprometimentoMes(int[] id_classes) throws Exception {
        try {
            Com_comprometimentoDAO cdao = getCom_comprometimentoDAO();
            double valorMes = cdao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classes, false);
            double valorMesAnterior = cdao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), mesAnterior, anoAnt, id_classes, false);
            return valorMes - valorMesAnterior;
        } catch (Exception e) {
            throw e;
        }
    }

    private double getcomprometimentoAcumulados(int[] id_classes) throws Exception {
        try {
            Com_comprometimentoDAO cdao = getCom_comprometimentoDAO();
            double valorMes = cdao.getValorClassePeriodo(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), id_classes, false);
            return valorMes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void finalizarGrupo() {
        AnaliseCcustosRegimeCompetenciaTMP custo = new AnaliseCcustosRegimeCompetenciaTMP();
        custo.setDescricao("fim");
        custo.setGrupo(1);
        list.add(custo);
    }

    public void calcularRealizadoPrevisto() {
        totOrcorig = 0;
        totOrcorigAtual = 0;
        double totPeriodo = 0;
        double totAtePeriodo = 0;
        double totAcrescimoEco = 0;
        double totAcrecimoProjetado = 0;
        double totArealizar = 0;

        double totOrcorigGrup = 0;
        double totOrcorigAtualGrup = 0;
        double totPeriodoGrup = 0;
        double totAtePeriodoGrup = 0;
        double totAcrescimoEcoGrup = 0;
        double totAcrecimoProjetadoGrup = 0;
        double totArealizarGrup = 0;

        List<Integer> lisdel = new ArrayList();
        for (int i = list.size() - 1; i > -1; i--) {
            if(i == 15){
                int a = 1;
            }

            list.get(i).setAcrescimoEconomiaProjetado(list.get(i).getAcrescimoEconomiaProjetado() - list.get(i).getOrRcamentoOrignal());
            calculo(list.get(i));
            if (i > 0) {
                totOrcorig += list.get(i).getOrRcamentoOrignal();
                totOrcorigAtual += list.get(i).getOrcamentoAtualizado();
                totPeriodo += list.get(i).getRealizadoPeriodo();
                totAtePeriodo += list.get(i).getRealizadoAtePeriodo();
                totAcrescimoEco += list.get(i).getAcrescimoEconomia();
                totAcrecimoProjetado += list.get(i).getAcrescimoEconomiaProjetado();
                totArealizar += list.get(i).getArealizar();
            }


            totOrcorigGrup += list.get(i).getOrRcamentoOrignal();
            totOrcorigAtualGrup += list.get(i).getOrcamentoAtualizado();
            totPeriodoGrup += list.get(i).getRealizadoPeriodo();
            totAtePeriodoGrup += list.get(i).getRealizadoAtePeriodo();
            totAcrescimoEcoGrup += list.get(i).getAcrescimoEconomia();
            totAcrecimoProjetadoGrup += list.get(i).getAcrescimoEconomiaProjetado();
            totArealizarGrup += list.get(i).getArealizar();
            String nm = list.get(i).getItem();
            if (list.get(i).getDescricao().equalsIgnoreCase("fim") & i != list.size() - 1) {
                list.get(i).setDescricao("");
                list.get(i + 1).setOrcamentoOrignal(totOrcorigGrup);
                list.get(i + 1).setOrcamentoAtualizado(totOrcorigAtualGrup);
                list.get(i + 1).setRealizadoPeriodo(totPeriodoGrup);
                list.get(i + 1).setRealizadoAtePeriodo(totAtePeriodoGrup);
                list.get(i + 1).setAcrescimoEconomia(totAcrescimoEcoGrup);
                list.get(i + 1).setAcrescimoEconomiaProjetado(totAcrecimoProjetadoGrup);
                list.get(i + 1).setArealizar(totArealizarGrup);
                totOrcorigGrup = 0;
                totOrcorigAtualGrup = 0;
                totPeriodoGrup = 0;
                totAtePeriodoGrup = 0;
                totAcrescimoEcoGrup = 0;
                totAcrecimoProjetadoGrup = 0;
                totArealizarGrup = 0;
                int posicao = i;
                lisdel.add(posicao);
            } else if (i == 0) {
                list.get(i).setOrcamentoOrignal(totOrcorigGrup);
                list.get(i).setOrcamentoAtualizado(totOrcorigAtualGrup);
                list.get(i).setRealizadoPeriodo(totPeriodoGrup);
                list.get(i).setRealizadoAtePeriodo(totAtePeriodoGrup);
                list.get(i).setAcrescimoEconomia(totAcrescimoEcoGrup);
                list.get(i).setAcrescimoEconomiaProjetado(totAcrecimoProjetadoGrup);
                list.get(i).setArealizar(totArealizarGrup);
            }

        }

        AnaliseCcustosRegimeCompetenciaTMP custo = new AnaliseCcustosRegimeCompetenciaTMP();
        custo.setDescricao("TOTAL DOS CUSTOS");
        custo.setGrupo(0);
        custo.setItem("8");
        custo.setOrcamentoOrignal(totOrcorig);
        custo.setOrcamentoAtualizado(totOrcorigAtual);
        custo.setRealizadoPeriodo(totPeriodo);
        custo.setRealizadoAtePeriodo(totAtePeriodo);
        custo.setAcrescimoEconomia(totAcrescimoEco);
        custo.setAcrescimoEconomiaProjetado(totAcrecimoProjetado);
        custo.setArealizar(totArealizar);
        list.add(custo);
    }

    public void calculo(AnaliseCcustosRegimeCompetenciaTMP analise) {
        double acrescEcoProj = analise.getAcrescimoEconomiaProjetado();
        if (isFichaResumo()) {
            analise.setAcrescimoEconomiaProjetado(analise.getAcrescimoEconomiaProjetado() - analise.getOrRcamentoOrignal());
        }

        double acrecimoeco = analise.getAcrescimoEconomia();
        analise.setAcrescimoEconomia(analise.getRealizadoAtePeriodo() - acrecimoeco);
        analise.setArealizar((analise.getOrRcamentoOrignal() - analise.getRealizadoAtePeriodo()) + analise.getAcrescimoEconomiaProjetado());
        analise.setOrcamentoAtualizado(analise.getRealizadoAtePeriodo() + analise.getArealizar());

    }

    public double getvalorProjetado(int[] ids) {
        double valor = 0;
        if (objetosCronoRegimeCaixaProjJB != null) {
            int id;
            for (int i = 0; i < ids.length; i++) {
                Tes_temporaria_servicoT servico = objetosCronoRegimeCaixaProjJB.getTreeValorServicoProjetado().get(ids[i]);

                if (servico != null) {
                    valor += servico.getSoma_valor_copia();
                }
            }
        }
        return valor;
    }

    /**
     * @return the fichaResumo
     */
    public boolean isFichaResumo() {
        return fichaResumo;
    }

    /**
     * @param fichaResumo the fichaResumo to set
     */
    public void setFichaResumo(boolean fichaResumo) {
        this.fichaResumo = fichaResumo;
    }

    /**
     * @return the originalpermulta
     */
    public double getOriginalpermulta() {
        return originalpermulta;
    }

    /**
     * @param originalpermulta the originalpermulta to set
     */
    public void setOriginalpermulta(double originalpermulta) {
        this.originalpermulta = originalpermulta;
    }

    /**
     * @return the atulizadoPermulta
     */
    public double getAtulizadoPermulta() {
        return atulizadoPermulta;
    }

    /**
     * @param atulizadoPermulta the atulizadoPermulta to set
     */
    public void setAtulizadoPermulta(double atulizadoPermulta) {
        this.atulizadoPermulta = atulizadoPermulta;
    }

    /**
     * @return the vgvOriginal
     */
    public double getVgvOriginal() {
        return vgvOriginal;
    }

    /**
     * @param vgvOriginal the vgvOriginal to set
     */
    public void setVgvOriginal(double vgvOriginal) {
        this.vgvOriginal = vgvOriginal;
    }

    /**
     * @return the vgvAtualizado
     */
    public double getVgvAtualizado() {
        return vgvAtualizado;
    }

    /**
     * @param vgvAtualizado the vgvAtualizado to set
     */
    public void setVgvAtualizado(double vgvAtualizado) {
        this.vgvAtualizado = vgvAtualizado;
    }

    /**
     * @return the valorfaturamentoPeriodo
     */
    public double getValorfaturamentoPeriodo() {
        return valorfaturamentoPeriodo;
    }

    /**
     * @param valorfaturamentoPeriodo the valorfaturamentoPeriodo to set
     */
    public void setValorfaturamentoPeriodo(double valorfaturamentoPeriodo) {
        this.valorfaturamentoPeriodo = valorfaturamentoPeriodo;
    }

    public double getTir() {
        return MatematicaFinanceira.getTIR(getFluxo_I_X_R());
    }

    public double getVplInvestimentos() {
        return MatematicaFinanceira.getVPL(getObr_obrasT().getObr_nr_encarcos_juros_aplicacao(), getFluxo_Investimento());
    }

    public double getVplRetorno() {
        return MatematicaFinanceira.getVPL(getObr_obrasT().getObr_nr_encarcos_juros_aplicacao(), getFluxo_Retorno());
    }

    public double[] getFluxo_I_X_R() {
        double[] vl = new double[listFluxocaixa.size()];
        int i = 0;
        for (FluxoCaixaTMP fluxoT : listFluxocaixa) {
            vl[i] = fluxoT.getFluxoIxR();
            i++;
        }
        return vl;
    }

    public double[] getFluxo_Retorno() {
        double[] vl = new double[listFluxocaixa.size()];
        int i = 0;
        for (FluxoCaixaTMP fluxoT : listFluxocaixa) {
            vl[i] = fluxoT.getRetornos();
            i++;
        }
        return vl;
    }

    public double[] getFluxo_Investimento() {
        double[] vl = new double[listFluxocaixa.size()];
        int i = 0;
        for (FluxoCaixaTMP fluxoT : listFluxocaixa) {
            vl[i] = fluxoT.getInvestimento();
            i++;
        }
        return vl;
    }

    public String getPayBack() {
        String mes = "";
        double retorno = 0;
        double investimentos = 0;
        for (FluxoCaixaTMP fluxoT : listFluxocaixa) {
            retorno += fluxoT.getRetornos();
            investimentos += fluxoT.getInvestimento();
            if (retorno / investimentos > 1) {
                mes = fluxoT.getMes_ano();
                break;
            }
        }
        return mes;
    }

    public void clearList() {
        list.clear();
    }

    public void setTotalOrcamentoOriginal(double vl) {
        totOrcorig = vl;
    }

    public void setTotalOrcamentoOriginalAtual(double vl) {
        totOrcorigAtual = vl;
    }

    public List<AnaliseCcustosRegimeCompetenciaTMP> getList() {
        return list;
    }
}
