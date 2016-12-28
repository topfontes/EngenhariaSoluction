 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia;

import br.com.easynet.gwt.easyportal.client.AMenuDesktop;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ccff_copia_cronograma_fisico_financeiro.Ccff_copia_cronograma_fisico_financeiroConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cen_centro_custo.Cen_centro_custoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cffo_cronograma_fisico_financeiro_origenal.Cffo_cronograma_fisico_financeiro_origenalConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.importacao.ImportacaoOrcamentoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cli_cliente.Cli_clienteConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar.Ctp_conta_pagarConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar.Ctp_conta_pagar_GerarXLS_GWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar.Ctp_conta_pagar_addClasseGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar.OperacoesCtpGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.emp_empreendimento.Emp_empreendimentoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eqc_equivalencia_composicao.imprimirEqcCompGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia.Arquivo_XLS_TempGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia.EquivalenciaComGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia.EquivalenciaGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia.EquivalenciaInsumoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.est_estoque.Est_Estoque_addClasseGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.est_estoque.Est_estoqueConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.est_estoque.OperacoesEstoqueGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.evl_evolucao_lucro.Evl_evolucao_lucroConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.flr_fluxo_receita.Flr_fluxo_receitaConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fluxo_caixa.FluxoCaixa;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fol_folha_pagamento.Fol_folha_pagamentoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fop_forma_pagamento.Fop_forma_pagamentoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.for_fornecedor.For_fornecedorConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.frd_faturamento_rec_devolucao.Frd_faturamento_rec_devolucaoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fto_fotos.Fto_fotosConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.graficos.Curva_S_GWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.graficos.CustosMateriasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.graficos.EvolucaoLucroGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.grp_grupo_produto.Grp_grupo_produtoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.importacao.ImportacaoContaPagarGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.importacao.ImportacaoOrcamentoDiconGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.importacao.ImportacaoOrcamentoTemp;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.importacao.ImportacaoXML_Matriz;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.Obr_obrasConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.par_parcelamento.Par_parcelamentoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.per_perfil.Per_perfilConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.Plc_plano_contasConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento.Plco_plano_contas_orcamentoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plp_planilha_permuta.Plp_planilha_permutaConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plr_planilha_recebimento.Plr_planilha_recebimentoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plv_planilha_vendas.Plv_planilha_vendasConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pro_produto.Pro_produtoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pro_programacao.Pro_programacaoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.AnaliseCentroCustoDespesasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.AnaliseCustoObraRegCompetencia;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.AnaliseCustosMateriaisGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.AnaliticoFinanceiroContasPagasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.ClasseSubClasseGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.ComprometimentoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.CustoClasseRegimeCompetenciaGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.Equivalencia;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.EstoqueSubClasseGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.EstoqueSubClasseInsumoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.Ficha_ResumoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.Fluxo_caixa_consolidadoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.PlanilhaHHGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.Rel_cronograma_desemb_regime_competenciaGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.RelatorioCTPGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.FolhaPagamentoAnaliticaGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.FotosGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.PmsGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.scfp_subclasse_operario_previsto.Scfp_subclasse_operario_previstoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.set_setor.Set_setorConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.tpms_temporaria_pms.Tpms_GerarXLS_GWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.tpms_temporaria_pms.Tpms_ImportarXLS_GWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.tpms_temporaria_pms.Tpms_temporaria_pmsConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ume_unidade_medida.Ume_unidade_medidaConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uni_unidade.Uni_unidadeConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uno_unidade_obra.Uno_unidade_obraConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.usuario_sistema.Usuario_sistemaConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_comprometimento.Vw_comprometimentoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_conta_pagar_alterada.Vw_conta_pagar_alteradaConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_curva_abc.Vw_curva_abcConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_curva_abc_equivalencia.Vw_curva_abc_equivalenciaConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_equiv_insumo_pms.Vw_equiv_insumo_pmsConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_insumo_plc_pms.Vw_insumo_plc_pmsConsultGWT;


import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;

public class ActionMenu extends AMenuDesktop {

    public Window getWindowAcao(String acao) {
        // Constroi a tela e Coloca a janela no item.setData;
        com.extjs.gxt.ui.client.widget.Window win = null;
        //com.google.gwt.user.client.Window.alert(acao);
        if (janelas.containsKey(acao)) {
            win = janelas.get(acao);
        } else if (acao.equalsIgnoreCase("con.cliente")) {
            win = new Cli_clienteConsultGWT();
        } else if (acao.equalsIgnoreCase("con.comprometimento")) {
            win = new Vw_comprometimentoConsultGWT(false); 
        } else if (acao.equalsIgnoreCase("con.comprometimentoPrev")) {
            win = new Vw_comprometimentoConsultGWT(true);
        }else if (acao.equalsIgnoreCase("con.produtos")) {
            win = new Pro_produtoConsultGWT();
        } else if (acao.equalsIgnoreCase("con.fornecedor")) {
            win = new For_fornecedorConsultGWT();
        } else if (acao.equalsIgnoreCase("con.empreendimentos")) {
            win = new Emp_empreendimentoConsultGWT();
        } else if (acao.equalsIgnoreCase("con.entradaMercadoria")) {
            win = new Est_estoqueConsultGWT();
        } else if (acao.equals("con.classes")) {
            win = new Plc_plano_contasConsultGWT(1);
        } else if (acao.equals("con.subclasses")) {
            win = new Plc_plano_contasConsultGWT(2);
        } else if (acao.equalsIgnoreCase("con.formaPagamento")) {
            win = new Fop_forma_pagamentoConsultGWT();
        } else if (acao.equalsIgnoreCase("con.setores")) {
            win = new Set_setorConsultGWT();
        } else if (acao.equalsIgnoreCase("con.estoque")) {
            win = new Est_estoqueConsultGWT();
        } else if (acao.equalsIgnoreCase("con.centroCusto")) {
            win = new Cen_centro_custoConsultGWT();
        } else if (acao.equalsIgnoreCase("con.unidadesObra")) {
            win = new Uno_unidade_obraConsultGWT();
        } else if (acao.equalsIgnoreCase("con.unidades")) {
            win = new Uni_unidadeConsultGWT();
        } else if (acao.equalsIgnoreCase("con.grupoProduto")) {
            win = new Grp_grupo_produtoConsultGWT();
        } else if (acao.equalsIgnoreCase("con.obras")) {
            win = new Obr_obrasConsultGWT();
        } else if (acao.equalsIgnoreCase("con.unidadesMedida")) {
            win = new Ume_unidade_medidaConsultGWT();
        } else if (acao.equalsIgnoreCase("con.contaspagas")) {
            win = new Ctp_conta_pagarConsultGWT("P");
        } else if (acao.equalsIgnoreCase("con.contasapagar")) {
            win = new Ctp_conta_pagarConsultGWT("A");
        } else if (acao.equalsIgnoreCase("import.orcamento")) {
            win = new ImportacaoOrcamentoGWT();
        } else if (acao.equalsIgnoreCase("equivalencia")) {
            win = new EquivalenciaGWT();
        } else if (acao.equalsIgnoreCase("consult.curvaabc")) {
            win = new Vw_curva_abcConsultGWT(0);
        } else if (acao.equalsIgnoreCase("insert.pms")) {
            win = new Tpms_temporaria_pmsConsultGWT();
        } else if (acao.equalsIgnoreCase("consult.cffo")) {
            win = new Cffo_cronograma_fisico_financeiro_origenalConsultGWT();
        }else if (acao.equalsIgnoreCase("consult.ccff")) {
            win = new Ccff_copia_cronograma_fisico_financeiroConsultGWT();
        }else if (acao.equalsIgnoreCase("consult.curva_abc_eq")) {
            win = new Vw_curva_abc_equivalenciaConsultGWT();
        }else if (acao.equalsIgnoreCase("consult.parcelas")) {
            win = new Par_parcelamentoConsultGWT();
        }else if (acao.equalsIgnoreCase("rel.cff")) {
            win = new br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.Rel_CronogramaFisicoFinanceiroGWT("CFF");
        }else if (acao.equalsIgnoreCase("rel.cdrcp")) {
            win = new br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.Rel_CronogramaFisicoFinanceiroGWT("CDRCP");
        }else if (acao.equalsIgnoreCase("rel.cdrca")){
            win = new br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.Rel_CronogramaFisicoFinanceiroGWT("CDRCA");
        }else if (acao.equalsIgnoreCase("import.contapagar")) {
            win = new ImportacaoContaPagarGWT("CTP");
        }else if (acao.equalsIgnoreCase("import.estoque")) {
            win = new ImportacaoContaPagarGWT("EST");
        }else if (acao.equalsIgnoreCase("vinc.estoque")) {
            win = new Est_Estoque_addClasseGWT();
        }else if (acao.equalsIgnoreCase("con.plco")) {
            win = new Plco_plano_contas_orcamentoConsultGWT();
        }else if (acao.equalsIgnoreCase("vinculo_classe.conta_pagar")) {
            win = new Ctp_conta_pagar_addClasseGWT();
        }else if (acao.equalsIgnoreCase("gerar.xls_ctp")) {
            win = new Ctp_conta_pagar_GerarXLS_GWT();
        }else if (acao.equalsIgnoreCase("con.usuario")) {
            win = new Usuario_sistemaConsultGWT();
        }else if (acao.equalsIgnoreCase("con.perfil")) {
            win = new Per_perfilConsultGWT();
        }else if(acao.equalsIgnoreCase("rel.regime_competencia")){
            win = new Rel_cronograma_desemb_regime_competenciaGWT();
        }else if(acao.equalsIgnoreCase("gerar.xls_pms")){
            win = new Tpms_GerarXLS_GWT();
        }else if(acao.equalsIgnoreCase("importar.xls_pms")){
            win = new Tpms_ImportarXLS_GWT();
        }else if(acao.equalsIgnoreCase("custo.plc_pms")){
            win = new Vw_insumo_plc_pmsConsultGWT("plc");
        }else if(acao.equalsIgnoreCase("custo.plco_pms")){
            win = new Vw_insumo_plc_pmsConsultGWT("plco");
        }else if(acao.equalsIgnoreCase("conf.insumos_subClasse")){
            win = new Vw_equiv_insumo_pmsConsultGWT();
        }else if(acao.equalsIgnoreCase("con.folha_pag")){
            win = new Fol_folha_pagamentoConsultGWT();//analiticoFin.ctp
        }else if(acao.equalsIgnoreCase("despCtp.subClasse")){
            win = new RelatorioCTPGWT();
        }else if(acao.equalsIgnoreCase("analiticoFin.ctp")){
            win = new AnaliticoFinanceiroContasPagasGWT();
        }else if(acao.equalsIgnoreCase("folhaPag.analitica")){
            win = new FolhaPagamentoAnaliticaGWT();
        }else if(acao.equalsIgnoreCase("planilha.HH")){
            win = new PlanilhaHHGWT();
        }else if(acao.equalsIgnoreCase("manut.ctp")){
            win = new OperacoesCtpGWT();
        }else if(acao.equalsIgnoreCase("estoq.subclasse")){
            win = new EstoqueSubClasseGWT();
        }else if(acao.equalsIgnoreCase("manut.estoque")){
            win = new OperacoesEstoqueGWT();
        }else if(acao.equalsIgnoreCase("subcalsse.planilhahh")){
            win = new Scfp_subclasse_operario_previstoConsultGWT();
        }else if(acao.equalsIgnoreCase("panel.centroDespesas")){
            win = new AnaliseCentroCustoDespesasGWT();
        }else if(acao.equalsIgnoreCase("rel.equivalencia")){
            win = new Equivalencia();
        }else if(acao.equalsIgnoreCase("rel.pms")){
            win = new PmsGWT();
        }else if(acao.equalsIgnoreCase("rel.custo.classe.reg.compe")){
            win = new CustoClasseRegimeCompetenciaGWT();
        }else if(acao.equalsIgnoreCase("rel.classesubclasse")){
            win = new ClasseSubClasseGWT();
        }else if(acao.equalsIgnoreCase("rel.comprometimento")){
            win = new ComprometimentoGWT();
        }else if(acao.equalsIgnoreCase("rel.analisecusto_obra_reg_comp")){
            win = new AnaliseCustoObraRegCompetencia();
        }else if(acao.equalsIgnoreCase("con.fluxo_receita")){
            win = new Flr_fluxo_receitaConsultGWT();
        }else if(acao.equalsIgnoreCase("fluxo_caixa")){
            win = new FluxoCaixa();
        }else if(acao.equalsIgnoreCase("con.fat_rec_dev")){
            win = new Frd_faturamento_rec_devolucaoConsultGWT();
        }else if(acao.equalsIgnoreCase("rel.fluxo_caixa_consolidado")){
            win = new Fluxo_caixa_consolidadoGWT();
        }else if(acao.equalsIgnoreCase("rel.ficha_resumo")){
            win = new Ficha_ResumoGWT();
        }else if(acao.equalsIgnoreCase("rel.custos_materias")){
            win = new AnaliseCustosMateriaisGWT();
        }else if(acao.equalsIgnoreCase("con.programacao")){
            win = new Pro_programacaoConsultGWT();
        }else if(acao.equalsIgnoreCase("con.evolucao")){
            win = new Evl_evolucao_lucroConsultGWT();
        }else if(acao.equalsIgnoreCase("con.pl_vendas")){
            win = new Plv_planilha_vendasConsultGWT();
        }else if(acao.equalsIgnoreCase("con.pl_permuta")){
            win = new Plp_planilha_permutaConsultGWT();
        }else if(acao.equalsIgnoreCase("con.pl_recebimento")){
            win = new Plr_planilha_recebimentoConsultGWT();
        }else if(acao.equalsIgnoreCase("chart.custo_materias")){
            win = new CustosMateriasGWT();
        }else if(acao.equalsIgnoreCase("chart.curva_s")){
            win = new Curva_S_GWT();
        }else if(acao.equalsIgnoreCase("chart.evolucao_lucro")){
            win = new EvolucaoLucroGWT();
        }else if(acao.equalsIgnoreCase("con.fotos")){
            win = new Fto_fotosConsultGWT();
        }else if(acao.equalsIgnoreCase("con.imp_nassal")){
            win = new ImportacaoOrcamentoDiconGWT();
        }else if(acao.equalsIgnoreCase("est.subclasseinsumo")){
            win = new EstoqueSubClasseInsumoGWT();
        }else if(acao.equalsIgnoreCase("rel.fotos")){
            win = new FotosGWT();
        }else if(acao.equalsIgnoreCase("rel.programacao")){
            win = new Pro_programacaoConsultGWT(false);
        }else if(acao.equalsIgnoreCase("imp.orcTemp")){
            win = new ImportacaoOrcamentoTemp();
        }else if(acao.equalsIgnoreCase("eqi.eqi")){
            win = new EquivalenciaInsumoGWT();
        }else if(acao.equalsIgnoreCase("eqc.eqc")){
            win = new EquivalenciaComGWT();
        }else if(acao.equalsIgnoreCase("xls.temp")){
            win = new Arquivo_XLS_TempGWT();
        }else if(acao.equalsIgnoreCase("rel.comp")){
            win = new imprimirEqcCompGWT();
        }else if(acao.equalsIgnoreCase("con.ctpm_alterada")){
            win = new Vw_conta_pagar_alteradaConsultGWT();
        }else if(acao.equalsIgnoreCase("con.import_matriz")){
           win = new ImportacaoXML_Matriz();
        }else{
            win = null;
            MessageBox.alert("Falha", "Opção ainda não implementada! "+acao, null);
        }
        //xls.temp
//EstoqueSubClasseInsumoGWT
        if (win != null) {
            janelas.put(acao, win);
        }
        return win;
    }

}
 
