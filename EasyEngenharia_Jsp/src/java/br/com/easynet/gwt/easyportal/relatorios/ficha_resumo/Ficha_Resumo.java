/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.ficha_resumo;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.dao.Plp_planilha_permutaDAO;
import br.com.easynet.gwt.easyportal.dao.Plr_planilha_recebimentoDAO;
import br.com.easynet.gwt.easyportal.dao.Plv_planilha_vendasDAO;
import br.com.easynet.gwt.easyportal.dao.Uno_unidade_obraDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.relatorios.analiseCustosObraRegimeCompetencia.AnaliseCustosRegimeCompetencia;
import br.com.easynet.gwt.easyportal.temp.Ficha_ResumoTMP;
import br.com.easynet.gwt.easyportal.temp.Ficha_Resumo_ComplementoTMP;
import br.com.easynet.gwt.easyportal.temp.ResultadoCustoRegCompetenciaTMP;
import br.com.easynet.gwt.easyportal.temp.Sub_ResultadoCustoRegCompetenciaTMP;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.easynet.gwt.easyportal.transfer.Plp_planilha_permutaT;
import br.com.easynet.gwt.easyportal.transfer.Plr_planilha_recebimentoT;
import br.com.easynet.gwt.easyportal.transfer.Plv_planilha_vendasT;
import br.com.easynet.gwt.easyportal.transfer.Uno_unidade_obraT;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Ficha_Resumo extends RelatorioBase implements INotSecurity {

    private List<Ficha_ResumoTMP> list = new ArrayList();
    private List<Ficha_Resumo_ComplementoTMP> listVenda = new ArrayList<Ficha_Resumo_ComplementoTMP>();
    private List<Ficha_Resumo_ComplementoTMP> listRecebimento = new ArrayList<Ficha_Resumo_ComplementoTMP>();
    private List<ResultadoCustoRegCompetenciaTMP> listLucro = new ArrayList<ResultadoCustoRegCompetenciaTMP>();
    private List<Sub_ResultadoCustoRegCompetenciaTMP> listCronograma = new ArrayList<Sub_ResultadoCustoRegCompetenciaTMP>();
    private AnaliseCustosRegimeCompetencia analiseCustos = new AnaliseCustosRegimeCompetencia();
    private double[] TotalListaCusto = new double[2];
    int totalUnidades = 500;
    private double custoTotalOrcamento = 0;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() throws Exception {
        try {
            setParm();
            getTotalUnidades();
            povoaListaCustos();
            povoaListaVenda();
            povoaListaRecebimento();
            povoaListaLucro();
            povoaListaCronograma();

            JRBeanCollectionDataSource dsVenda = new JRBeanCollectionDataSource(listVenda);
            JRBeanCollectionDataSource dsRecebimento = new JRBeanCollectionDataSource(listRecebimento);
            JRBeanCollectionDataSource dsLucro = new JRBeanCollectionDataSource(listLucro);
            JRBeanCollectionDataSource dsCronograma = new JRBeanCollectionDataSource(listCronograma);

            getParameters().put("list_venda", dsVenda);
            getParameters().put("list_recebimento", dsRecebimento);
            getParameters().put("list_lucro", dsLucro);
            getParameters().put("list_cronograma", dsCronograma);

            String path = application.getRealPath("jasper/ficha_resumo.jasper");
            path = path.substring(0, path.indexOf("ficha_resumo.jasper"));
            getParameters().put("SUBREPORT_DIR", path);

            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Ficha_Resumo.class.getResourceAsStream("ficha_resumo.jasper");
            } else {
                url = Ficha_Resumo.class.getResource("ficha_resumo.jasper");
            }
            print("FichaResumo", "FICHA RESUMO");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

                close();
        }

    }

    public void getTotalUnidades() {
        try {
            Uno_unidade_obraDAO udao = getUno_unidade_obraDAO();
            Uno_unidade_obraT unoT = new Uno_unidade_obraT();
            unoT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            totalUnidades = udao.getQuantidadeUnidadesObra(unoT);
        } catch (Exception e) {
        }
    }

    public void setParm() {
        getParameters().put("unidade_construtiva", "APARTAMENTO");
        getParameters().put("total_unidades", totalUnidades + "");
        getParameters().put("area_total", getObr_obrasT().getObr_nr_area_privativa_total() + "");
        getParameters().put("area_geral", getObr_obrasT().getObr_nr_area_construida_total() + "");
    }

    public void povoaListaCustos() throws Exception {
        try {

            analiseCustos.setPage(page);
            analiseCustos.setObr_obrasT(getObr_obrasT());
            analiseCustos.setMeo_meses_obraT(getMeo_meses_obraT());
            analiseCustos.CalcularMesAnterior();
            analiseCustos.setFichaResumo(true);
            analiseCustos.instanciarObjetosCronoRegimeCaixaProjJB();

            Ficha_ResumoTMP resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("1");
            resumoTMP.setDescricao("CUSTOS DIRETOS:");
            double[] valores = analiseCustos.custosDiretos();
            resumoTMP.setValor_original(valores[0]);
            resumoTMP.setValor_atualizado(valores[1]);
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(1);
            resumoTMP.setItem("1.1");
            resumoTMP.setDescricao("CUSTOS DIRETOS/ÁREA CONST.TOTAL DAS UND. CONSTRUTIVAS (R$/M²)");
            resumoTMP.setValor_original(valores[0] / getObr_obrasT().getObr_nr_area_privativa_total());
            resumoTMP.setValor_atualizado(valores[1] / getObr_obrasT().getObr_nr_area_privativa_total());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(1);
            resumoTMP.setItem("1.2");
            resumoTMP.setDescricao("CUSTOS DIRETOS/ÁREA CONST.TOTAL GERAL (R$/M²)");
            resumoTMP.setValor_original(valores[0] / getObr_obrasT().getObr_nr_area_construida_total());
            resumoTMP.setValor_atualizado(valores[1] / getObr_obrasT().getObr_nr_area_construida_total());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);
            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("2");
            resumoTMP.setDescricao("CUSTOS INDIRETOS:");
            valores = analiseCustos.custosIndiretos();
            resumoTMP.setValor_original(valores[0]);
            resumoTMP.setValor_atualizado(valores[1]);
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(1);
            resumoTMP.setItem("2.1");
            resumoTMP.setDescricao("CUSTOS INDIRETOS/ÁREA CONST.TOTAL DAS UND. CONSTRUTIVAS (R$/M²)");
            resumoTMP.setValor_original(valores[0] / getObr_obrasT().getObr_nr_area_privativa_total());
            resumoTMP.setValor_atualizado(valores[1] / getObr_obrasT().getObr_nr_area_privativa_total());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(1);
            resumoTMP.setItem("2.2");
            resumoTMP.setDescricao("CUSTOS INDIRETOS/ÁREA CONST.TOTAL GERAL (R$/M²)");
            resumoTMP.setValor_original(valores[0] / getObr_obrasT().getObr_nr_area_construida_total());
            resumoTMP.setValor_atualizado(valores[1] / getObr_obrasT().getObr_nr_area_construida_total());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);
            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("3");
            resumoTMP.setDescricao("IMPOSTOS:");

            valores = analiseCustos.impostos();
            resumoTMP.setValor_original(valores[0]);
            resumoTMP.setValor_atualizado(valores[1]);
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);
            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("4");
            resumoTMP.setDescricao("TERRENO:");
            TreeMap<Integer, Ficha_ResumoTMP> tree = analiseCustos.outros();
            Ficha_ResumoTMP ficha = tree.get(4);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);
            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("5");
            resumoTMP.setDescricao("PROJETOS, MANUAIS, CONSULTORIA E SONDAGEM:");
            //tree = analiseCustos.outros();
            ficha = tree.get(5);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);
            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("6");
            resumoTMP.setDescricao("TAO:");
            //tree = analiseCustos.outros();
            ficha = tree.get(6);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);
            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("7");
            resumoTMP.setDescricao("PRODUTOS DA CEF:");
            //tree = analiseCustos.outros();
            ficha = tree.get(7);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("8");
            resumoTMP.setDescricao("JUROS DO FINANCIAMENTO:");
            //tree = analiseCustos.outros();
            ficha = tree.get(8);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("9");
            resumoTMP.setDescricao("SEGUROS:");
            //tree = analiseCustos.outros();
            ficha = tree.get(9);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("10");
            resumoTMP.setDescricao("DESPESAS CARTORIAS/AVERBAÇÃO/REGISTRO:");
            //tree = analiseCustos.outros();
            ficha = tree.get(10);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("11");
            resumoTMP.setDescricao("TRABALHO SOCIAL:");
            //tree = analiseCustos.outros();
            ficha = tree.get(11);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("12");
            resumoTMP.setDescricao("STAND DE VENDAS / OUTRAS DESPESAS:");
            //tree = analiseCustos.outros();
            ficha = tree.get(12);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("13");
            resumoTMP.setDescricao("ENCARGOS FINANCEIROS /TARIFAS BANCÁRIAS:");
            //tree = analiseCustos.outros();
            ficha = tree.get(13);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("14");
            resumoTMP.setDescricao("EMPRÉSTIMOS E CONTIGÊNCIA:");
            //tree = analiseCustos.outros();
            ficha = tree.get(14);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("15");
            resumoTMP.setDescricao("MANUTENÇÃO DA OBRA (PÓS-ENTREGA):");
            //tree = analiseCustos.outros();
            ficha = tree.get(15);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("16");
            resumoTMP.setDescricao("TAXA ADMINISTRATIVA:");
            //tree = analiseCustos.outros();
            ficha = tree.get(16);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("17");
            resumoTMP.setDescricao("RATEIO DO ESCRITÓRIO CENTRAL (COMERCIAL):");
            //tree = analiseCustos.outros();
            ficha = tree.get(17);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("18");
            resumoTMP.setDescricao("VALOR DO FINANCIAMENTO:");
            //tree = analiseCustos.outros();
            ficha = tree.get(18);
            resumoTMP.setValor_original(ficha.getValor_original());
            resumoTMP.setValor_atualizado(ficha.getValor_atualizado());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("19");
            resumoTMP.setDescricao("CORRETAGEM:");
            valores = analiseCustos.corretagem();
            resumoTMP.setValor_original(valores[0]);
            resumoTMP.setValor_atualizado(valores[1]);
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);
            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("20");
            resumoTMP.setDescricao("PUBLICIDADE:");
            valores = analiseCustos.publicidade();
            resumoTMP.setValor_original(valores[0]);
            resumoTMP.setValor_atualizado(valores[1]);
            list.add(resumoTMP);
            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("21");
            resumoTMP.setDescricao("LICENÇAS E TAXAS:");
            valores = analiseCustos.licencaseTaxas();
            resumoTMP.setValor_original(valores[0]);
            resumoTMP.setValor_atualizado(valores[1]);
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);
            finalizarGrupo();

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(0);
            resumoTMP.setItem("22");
            resumoTMP.setDescricao("TOTAL DOS CUSTOS:");
            TotalListaCusto = somarLista();
            resumoTMP.setValor_original(TotalListaCusto[0]);
            resumoTMP.setValor_atualizado(TotalListaCusto[1]);
            custoTotalOrcamento = valores[1];
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(1);
            resumoTMP.setItem("22.1");
            resumoTMP.setDescricao("CUSTOS DIRETOS/ÁREA CONST.TOTAL DAS UND. CONSTRUTIVAS (R$/M²)");
            resumoTMP.setValor_original(TotalListaCusto[0] / getObr_obrasT().getObr_nr_area_privativa_total());
            resumoTMP.setValor_atualizado(TotalListaCusto[1] / getObr_obrasT().getObr_nr_area_privativa_total());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);

            resumoTMP = new Ficha_ResumoTMP();
            resumoTMP.setGrupo(1);
            resumoTMP.setItem("22.2");
            resumoTMP.setDescricao("CUSTOS DIRETOS/ÁREA CONST.TOTAL GERAL (R$/M²)");
            resumoTMP.setValor_original(TotalListaCusto[0] / getObr_obrasT().getObr_nr_area_construida_total());
            resumoTMP.setValor_atualizado(TotalListaCusto[1] / getObr_obrasT().getObr_nr_area_construida_total());
            resumoTMP.setValor_orig_valorAtual(resumoTMP.getValor_atualizado() - resumoTMP.getValor_original());
            list.add(resumoTMP);
        } catch (Exception e) {
            throw e;
        }

    }

    public double[] somarLista() {
        double original = 0;
        double atualizado = 0;
        for (Ficha_ResumoTMP ficha_ResumoTMP : list) {
            if (ficha_ResumoTMP.getItem() != null) {
                if (ficha_ResumoTMP.getItem().indexOf(".") < 0) {
                    original += ficha_ResumoTMP.getValor_original();
                    atualizado += ficha_ResumoTMP.getValor_atualizado();
                }
            }
        }
        double[] valores = new double[2];
        valores[0] = original;
        valores[1] = atualizado;
        return valores;
    }

    public void finalizarGrupo() {
        Ficha_ResumoTMP resumoTMP = new Ficha_ResumoTMP();
        resumoTMP.setGrupo(1);
        list.add(resumoTMP);
    }

    private void povoaListaVenda() throws Exception {

        analiseCustos.addParametroTabelaVGV();

        int totalpermuta = 0;
        Ficha_Resumo_ComplementoTMP resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("1");
        resumoTMP.setDescricao("TOTAL DE UNID. CONSTRUTIVAS PERMUTADAS");
        resumoTMP.setColumn1("");
        Plp_planilha_permutaDAO pdao = getPlp_planilha_permutaDAO();
        Plp_planilha_permutaT plp_planilha_permutaT = new Plp_planilha_permutaT();
        plp_planilha_permutaT.setPlp_nr_mes_ref(getMeo_meses_obraT().getMes());
        plp_planilha_permutaT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
        plp_planilha_permutaT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
        totalpermuta = pdao.getQtePermutadaAteperiodo(plp_planilha_permutaT);
        resumoTMP.setColumn2(totalpermuta + "");
        resumoTMP.setColumn3("");
        listVenda.add(resumoTMP);

        int totalVendidas = 0;
        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("2");
        resumoTMP.setDescricao("TOTAL DE UNID. CONSTRUTIVAS VENDIDAS");
        resumoTMP.setColumn1("");
        Plv_planilha_vendasT plv_planilha_vendasT = new Plv_planilha_vendasT();
        plv_planilha_vendasT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
        plv_planilha_vendasT.setPlv_nr_mes_ref(getMeo_meses_obraT().getMes());
        plv_planilha_vendasT.setPlv_nr_ano_ref(getMeo_meses_obraT().getAno());
        Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();
        totalVendidas = plv_planilha_vendasDAO.getQteVendaAteperiodoRealizada(plv_planilha_vendasT);
        resumoTMP.setColumn2(totalVendidas + "");
        resumoTMP.setColumn3("");
        listVenda.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("3");
        resumoTMP.setDescricao("VGV UNIDADES CONSTRUTIVAS PERMUTADAS (R$)");
        double column1 = analiseCustos.getOriginalpermulta();
        double column2 = analiseCustos.getAtulizadoPermulta();
        resumoTMP.setColumn1(Funcoes.FormatoMoedaBR_Double(column1));
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(column2));
        resumoTMP.setColumn3(Funcoes.FormatoMoedaBR_Double(column2 - column1));
        listVenda.add(resumoTMP);

        double column1vgv = analiseCustos.getVgvOriginal();
        double column2vgv = analiseCustos.getVgvAtualizado();

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("4");
        resumoTMP.setDescricao("VGV UNIDADES CONST. VENDIDAS + A VENDER (R$)");
        resumoTMP.setColumn1(Funcoes.FormatoMoedaBR_Double(column1vgv - column1));
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(column2vgv - column2));
        resumoTMP.setColumn3(Funcoes.FormatoMoedaBR_Double((column1vgv - column1) - (column2vgv - column2)));
        listVenda.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("5");
        resumoTMP.setDescricao("VGV TOTAL DAS UNIDADES CONSTRUTIVAS (R$)");
        column1 = analiseCustos.getVgvOriginal();
        column2 = analiseCustos.getVgvAtualizado();
        resumoTMP.setColumn1(Funcoes.FormatoMoedaBR_Double(column1));
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(column2));
        resumoTMP.setColumn3(Funcoes.FormatoMoedaBR_Double(column2 - column1));
        listVenda.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("6");
        resumoTMP.setDescricao("VGV TOTAL ATUALIZADO/ORIGINAL (%)");
        resumoTMP.setColumn1("");
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(((column2vgv / column1vgv) - 1) * 100));
        resumoTMP.setColumn3("");
        listVenda.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("7");
        resumoTMP.setDescricao("N°. UND. CONST. PERMUTADAS + VENDAS /TOTAL (%)");
        resumoTMP.setColumn1("");
        double somaPermuta_vendas = totalpermuta + totalVendidas;
        double percPermultas_vendidas = (somaPermuta_vendas / totalUnidades);
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(percPermultas_vendidas * 100));
        resumoTMP.setColumn3(Funcoes.FormatoMoedaBR_Double(0));
        listVenda.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("8");
        resumoTMP.setDescricao("PREÇO MÉDIO DAS UNID. CONSTRUTIVAS (R$)");
        resumoTMP.setColumn1(Funcoes.FormatoMoedaBR_Double(column1vgv / totalUnidades));
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(column2vgv / totalUnidades));
        resumoTMP.setColumn3(Funcoes.FormatoMoedaBR_Double((column2vgv / totalUnidades) - (column1vgv / totalUnidades)));
        listVenda.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("9");
        resumoTMP.setDescricao("PREÇO MÉDIO DAS UND. CONST./ÁREA CONST. TOTAL DAS UND. CONST.(R$/M²)");
        resumoTMP.setColumn1(Funcoes.FormatoMoedaBR_Double(column1vgv / getObr_obrasT().getObr_nr_area_privativa_total()));
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(column2vgv / getObr_obrasT().getObr_nr_area_privativa_total()));
        resumoTMP.setColumn3(Funcoes.FormatoMoedaBR_Double((column2vgv / getObr_obrasT().getObr_nr_area_privativa_total()) - (column1vgv / getObr_obrasT().getObr_nr_area_privativa_total())));
        listVenda.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("10");
        resumoTMP.setDescricao("PREÇO MÉDIO DAS UND. CONST./ÁREA CONST. TOTAL GERAL.(R$/M²)");
        resumoTMP.setColumn1(Funcoes.FormatoMoedaBR_Double(column1vgv / getObr_obrasT().getObr_nr_area_construida_total()));
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(column2vgv / getObr_obrasT().getObr_nr_area_construida_total()));
        resumoTMP.setColumn3(Funcoes.FormatoMoedaBR_Double((column2vgv / getObr_obrasT().getObr_nr_area_construida_total()) - (column1vgv / getObr_obrasT().getObr_nr_area_construida_total())));
        listVenda.add(resumoTMP);

    }

    private void povoaListaRecebimento() throws Exception {

        Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
        Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
        ctp_conta_pagarT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
        ctp_conta_pagarT.setCtp_nr_mes(getMeo_meses_obraT().getMes());
        ctp_conta_pagarT.setCtp_nr_ano(getMeo_meses_obraT().getAno());
        double valor_periodo = cdao.getCustoRealizadoNoPeriodoPagas(ctp_conta_pagarT);
        double valor_ateperiodo = cdao.getCustoRealizadoAcumuladoPagas(ctp_conta_pagarT);

        getParameters().put("item_pagamento", "1");
        getParameters().put("descricao_pagamento", "PAGAMENTOS EFETUADOS");
        getParameters().put("no_periodo_pagamento", Funcoes.FormatoMoedaBR_Double(valor_periodo));
        getParameters().put("ate_periodo_pagamento", Funcoes.FormatoMoedaBR_Double(valor_ateperiodo));
        getParameters().put("a_realizar_pagamento", Funcoes.FormatoMoedaBR_Double(TotalListaCusto[1] - valor_ateperiodo));


        Ficha_Resumo_ComplementoTMP resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("1");
        resumoTMP.setDescricao("RECEBIMENTOS EFETUADOS ACUMULADOS (PJ) (R$)");
        resumoTMP.setColumn1("");

        Plr_planilha_recebimentoDAO plrDao = getPlr_planilha_permutaDAO();
        Plr_planilha_recebimentoT plrT = new Plr_planilha_recebimentoT();
        plrT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
        plrT.setPlr_nr_mes_ref(getMeo_meses_obraT().getMes());
        plrT.setPlr_nr_ano_ref(getMeo_meses_obraT().getAno());
        plrDao.getTotalAtePeriodo(plrT);
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(plrT.getPlr_nr_efetuado_pj()));
        resumoTMP.setColumn3(Funcoes.FormatoMoedaBR_Double(plrT.getPlr_nr_efetuado_pj()));
        listRecebimento.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("2");
        resumoTMP.setDescricao("RECEBIMENTOS EFETUADOS ACUMULADOS (PF)(R$)");
        resumoTMP.setColumn1(Funcoes.FormatoMoedaBR_Double(plrT.getPlr_nr_realizado_pf()));
        resumoTMP.setColumn2("");
        resumoTMP.setColumn3(Funcoes.FormatoMoedaBR_Double(plrT.getPlr_nr_realizado_pf()));
        listRecebimento.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("3");
        resumoTMP.setDescricao("RECEBIMENTOS EFETUADOS ACUMULADOS (POUPANÇA) (R$)");
        resumoTMP.setColumn1(Funcoes.FormatoMoedaBR_Double(plrT.getPlr_nr_realizado_pou()));
        resumoTMP.setColumn2("");
        resumoTMP.setColumn3(Funcoes.FormatoMoedaBR_Double(plrT.getPlr_nr_realizado_pou()));
        listRecebimento.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("4");
        resumoTMP.setDescricao("FATURAMENTO TOTAL (R$)");
        resumoTMP.setColumn1("");
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(analiseCustos.getValorfaturamentoPeriodo()));
        resumoTMP.setColumn3("");
        listRecebimento.add(resumoTMP);

        resumoTMP = new Ficha_Resumo_ComplementoTMP();
        resumoTMP.setItem("5");
        resumoTMP.setDescricao("RECEBIMENTO/FATURAMENTO (%)");
        resumoTMP.setColumn1("");
        resumoTMP.setColumn2(Funcoes.FormatoMoedaBR_Double(((plrT.getPlr_nr_realizado_pf() + plrT.getPlr_nr_efetuado_pj() + plrT.getPlr_nr_realizado_pou()) / analiseCustos.getValorfaturamentoPeriodo()) * 100));
        resumoTMP.setColumn3("");
        listRecebimento.add(resumoTMP);
    }

    private void povoaListaLucro() throws Exception {
        try {
//            analiseCustos.clearList();
//            analiseCustos.CalcularMesAnterior();
//            analiseCustos.custosDiretos();
//            analiseCustos.custosIndiretos();
//            analiseCustos.corretagem();
//            analiseCustos.publicidade();
//            analiseCustos.licencaseTaxas();
//            analiseCustos.impostos();
//            analiseCustos.outros();
//            analiseCustos.calcularRealizadoPrevisto();
            analiseCustos.calcularRealizadoPrevisto();
            analiseCustos.setTotalOrcamentoOriginal(TotalListaCusto[0]);
            analiseCustos.setTotalOrcamentoOriginalAtual(TotalListaCusto[1]);
            double valorOriginal = list.get(0).getValor_original();
            analiseCustos.getList().get(0).setOrcamentoOrignal(valorOriginal);
            analiseCustos.getList().get(0).setOrcamentoAtualizado(list.get(0).getValor_atualizado());
            
            analiseCustos.getList().get(6).setOrcamentoOrignal(list.get(4).getValor_original());
            analiseCustos.getList().get(6).setOrcamentoAtualizado(list.get(4).getValor_atualizado());
            listLucro = analiseCustos.getlistResultado();
        } catch (Exception e) {
            throw e;
        }
    }

    private void povoaListaCronograma() throws Exception {
        try {
            int o = 78;
            listCronograma = analiseCustos.getlistSubResultado();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * @return the custoTotalOrcamento
     */
    public double getCustoTotalOrcamento() {
        return custoTotalOrcamento;
    }

    /**
     * @param custoTotalOrcamento the custoTotalOrcamento to set
     */
    public void setCustoTotalOrcamento(double custoTotalOrcamento) {
        this.custoTotalOrcamento = custoTotalOrcamento;
    }
}
