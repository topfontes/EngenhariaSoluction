/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.Ccff_copia_cronograma_fisico_financeiroDAO;
import br.com.easynet.gwt.easyportal.dao.Cffo_cronograma_fisico_financeiro_origenalDAO;
import br.com.easynet.gwt.easyportal.dao.Cli_clienteDAO;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.dao.Emp_empreendimentoDAO;
import br.com.easynet.gwt.easyportal.dao.Fat_fatorDAO;
import br.com.easynet.gwt.easyportal.dao.Inp_intervalo_parcelaDAO;
import br.com.easynet.gwt.easyportal.dao.Ipo_item_plano_contas_obraDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.dao.Pao_parcelamento_obraDAO;
import br.com.easynet.gwt.easyportal.dao.Plc_plano_contasDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_curva_abc_equivalenciaDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_importacao_orcamentoDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_maximo_dias_parcela_plcDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_maximo_mes_ccff_digitadoDAO;
import br.com.easynet.gwt.easyportal.transfer.Ccff_copia_cronograma_fisico_financeiroT;
import br.com.easynet.gwt.easyportal.transfer.Cffo_cronograma_fisico_financeiro_origenalT;
import br.com.easynet.gwt.easyportal.transfer.Cli_clienteT;
import br.com.easynet.gwt.easyportal.transfer.Ctp_ValorMesesSubClasseT;
import br.com.easynet.gwt.easyportal.transfer.Emp_empreendimentoT;
import br.com.easynet.gwt.easyportal.transfer.Inp_intervalo_parcelaT;
import br.com.easynet.gwt.easyportal.transfer.Ipo_item_plano_contas_obraT;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.gwt.easyportal.transfer.Pao_parcelamento_obraT;
import br.com.easynet.gwt.easyportal.transfer.Plc_plano_contasT;
import br.com.easynet.gwt.easyportal.transfer.SubClasseParcelamentoT;
import br.com.easynet.gwt.easyportal.transfer.Tes_temporaria_servicoT;
import br.com.easynet.gwt.easyportal.transfer.Valores_calculo_fatorT;
import br.com.easynet.gwt.easyportal.transfer.Vw_curva_abc_equivalenciaT;
import br.com.easynet.gwt.easyportal.transfer.Vw_importacao_orcamentoT;
import br.com.easynet.gwt.easyportal.transfer.Vw_maximo_dias_parcela_plcT;
import br.com.easynet.gwt.easyportal.transfer.Vw_maximo_mes_ccff_digitadoT;
import br.com.easynet.jb.EasyDownloadJB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class CronogramaDesembolsoSubClasseReprogJB extends SystemBase {

    private TreeMap<Integer, List<Ipo_item_plano_contas_obraT>> treeInsumos = new TreeMap<Integer, List<Ipo_item_plano_contas_obraT>>();
    private TreeMap<Integer, SubClasseParcelamentoT> treeSubClasseParcela = new TreeMap<Integer, SubClasseParcelamentoT>();
    private TreeMap<Integer, Pao_parcelamento_obraT> treeParcelaObra = new TreeMap<Integer, Pao_parcelamento_obraT>();
    private TreeMap<Integer, List<Inp_intervalo_parcelaT>> treeInter = new TreeMap<Integer, List<Inp_intervalo_parcelaT>>();
    private TreeMap<Integer, Vw_maximo_dias_parcela_plcT> treeMaxDiasPar = new TreeMap<Integer, Vw_maximo_dias_parcela_plcT>();
    //private TreeMap<String, Vw_maximo_mes_ccff_digitadoT> treeMaxMesCCFF = new TreeMap<String, Vw_maximo_mes_ccff_digitadoT>();
    private TreeMap<String, Vw_maximo_mes_ccff_digitadoT> treeMaxMesCCFF = new TreeMap<String, Vw_maximo_mes_ccff_digitadoT>();
    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();
    private List<Tes_temporaria_servicoT> listServico = new ArrayList<Tes_temporaria_servicoT>();
    private TreeMap<String, Ccff_copia_cronograma_fisico_financeiroT> treeCCff;
    private TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalT> treeCffo;
    private TreeMap<Integer, List<Plc_plano_contasT>> treeInsumoSubClasse = new TreeMap<Integer, List<Plc_plano_contasT>>();
    private Obr_obrasT obr_obrasT = new Obr_obrasT();
    private Cli_clienteT cli_clienteT = new Cli_clienteT();
    private int obra;
    private final static String DIA_BASE = "28/";
    private TreeMap<Integer, Plc_plano_contasT> treePlc = new TreeMap<Integer, Plc_plano_contasT>();
    private TreeMap<Integer, Tes_temporaria_servicoT> treeTesAdicionado = new TreeMap<Integer, Tes_temporaria_servicoT>();
    private TreeMap<String, Ctp_ValorMesesSubClasseT> treeCtp_ValorMesSubClasse = new TreeMap<String, Ctp_ValorMesesSubClasseT>();
    private TreeMap<Integer, Valores_calculo_fatorT> treeFator = new TreeMap<Integer, Valores_calculo_fatorT>();
    private boolean plc_add;
    private int mesRef;
    private int anoRef;
    private String erro;
    private List<Meo_meses_obraT> listMesesTotal;
    private float totalGeral;
    private List<Valores_calculo_fatorT> listfatorPlc = new Vector();
    private List<Vw_importacao_orcamentoT> listImpoNotEquiv = new Vector();
    private String tipo;
    private TreeMap<String, Meo_meses_obraT> treeTotalMes = new TreeMap<String, Meo_meses_obraT>();
    private boolean verificarSessao = true;
    private TreeMap<Integer, Vw_curva_abc_equivalenciaT> treeCurvaAbc = new TreeMap<Integer, Vw_curva_abc_equivalenciaT>();

    public void pageLoad() throws Exception {
        super.pageLoad();
        verificarSessao = true;
    }

    public void povoaTreeCronograma() {
        try {
            if (tipo.equalsIgnoreCase("R")) {
                Ccff_copia_cronograma_fisico_financeiroDAO cdao = getCcff_copia_cronograma_fisico_financeiroDAO();
                Ccff_copia_cronograma_fisico_financeiroT ccffT = new Ccff_copia_cronograma_fisico_financeiroT();
                ccffT.setObr_nr_id(vw_importacao_orcamentoT.getObr_nr_id());
                treeCCff = cdao.getByObr_nr_idTree(ccffT);
            } else {
                Cffo_cronograma_fisico_financeiro_origenalDAO cdao = getCffo_cronograma_fisico_financeiro_origenalDAO();
                Cffo_cronograma_fisico_financeiro_origenalT ct = new Cffo_cronograma_fisico_financeiro_origenalT();
                ct.setObr_nr_id(vw_importacao_orcamentoT.getObr_nr_id());
                treeCffo = cdao.getByObr_nr_idTree(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close();
        }
    }

    public void povoaTreeIntervalo() throws Exception {
        try {
            Inp_intervalo_parcelaDAO idao = getInp_intervalo_parcelaDAO();
            treeInter = idao.getAllTree();
        } catch (Exception e) {
            throw e;
        }
    }

    public void povoaInsumos() throws Exception {
        try {
            Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
            treeInsumos = idao.getInsumos(vw_importacao_orcamentoT.getObr_nr_id());
        } catch (Exception e) {
            throw e;
        }

    }

    public void povoaParcelamentoObra() throws Exception {
        try {
            Pao_parcelamento_obraDAO pdao = getPao_parcelamento_obraDAO();
            treeParcelaObra = pdao.getByObr_nr_idTree(vw_importacao_orcamentoT.getObr_nr_id());
        } catch (Exception e) {
            throw e;
        }

    }

    public void povoaSubClasseParcelamento() throws Exception {
        try {
            Plc_plano_contasDAO dAO = getPlc_plano_contasDAO();
            treeSubClasseParcela = dAO.getSubClasseParcelamento(vw_importacao_orcamentoT.getObr_nr_id(), treeParcelaObra);
        } catch (Exception e) {
            throw e;
        }

    }

    public void povoaCtpValorSubClasse() throws Exception {
        try {
            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
            treeCtp_ValorMesSubClasse = cdao.getValorMesesSubClasse(vw_importacao_orcamentoT.getObr_nr_id(), "P", mesRef, anoRef);

            Set<String> key = treeCtp_ValorMesSubClasse.keySet();
            float total = 0;
            for (Iterator<String> it = key.iterator(); it.hasNext();) {
                String kk = it.next();

//                if (treeCtp_ValorMesSubClasse.get(kk).getMes() == 2) {
//                    System.out.println(treeCtp_ValorMesSubClasse.get(kk).getValor());
//                    total += treeCtp_ValorMesSubClasse.get(kk).getValor();
//                }

            }
//            System.out.println("total " + total);

        } catch (Exception e) {
            throw e;
        }
    }

    public void povoaFatorAtual() throws Exception {
        try {
            Fat_fatorDAO fdao = getFat_fatorDAO();
            Vw_importacao_orcamentoDAO vdao = getVw_importacao_orcamentoDAO();
            treeFator = fdao.getTreefator(vw_importacao_orcamentoT.getObr_nr_id(), mesRef, anoRef);
            Vw_importacao_orcamentoDAO vdao2 = getVw_importacao_orcamentoDAO();
        } catch (Exception e) {
            throw e;
        }
    }

    public void locateCliente() throws Exception {
        try {
            getObr_obrasT();
            Emp_empreendimentoT emp_empreendimentoT = new Emp_empreendimentoT();
            Emp_empreendimentoDAO edao = getEmp_empreendimentoDAO();
            emp_empreendimentoT.setEmp_nr_id(obr_obrasT.getEmp_nr_id());
            emp_empreendimentoT = edao.getByEmp_nr_id(emp_empreendimentoT).get(0);
            cli_clienteT.setCli_nr_id(emp_empreendimentoT.getCli_nr_id());
            Cli_clienteDAO cdao = getCli_clienteDAO();
            cli_clienteT = cdao.getByCli_nr_id(cli_clienteT).get(0);
            getSession().setAttribute("clienteT", cli_clienteT);
        } catch (Exception e) {
            throw e;
        }

    }

    public void povoaMax_Mes_CCFF_nr_id() throws Exception {
        try {
            Vw_maximo_mes_ccff_digitadoDAO vdao = getVw_maximo_mes_ccff_digitadoDAO();
            //tipo informa se o cronograma é original ou reprogramavél
            //treeMaxMesCCFF = vdao.getByObr_nr_idTree(vw_importacao_orcamentoT.getObr_nr_id(), tipo);
            treeMaxMesCCFF = vdao.getByObr_nr_idTree(obra, tipo);
        } catch (Exception e) {
            throw e;
        }

    }

    public void povoaMax_Dias_Parcelas_Plc() throws Exception {
        try {
            Vw_maximo_dias_parcela_plcDAO vdao = getVw_maximo_dias_parcela_plcDAO();
            treeMaxDiasPar = vdao.getByObr_nr_idTree(vw_importacao_orcamentoT.getObr_nr_id());
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Tes_temporaria_servicoT> consult() throws Exception {
        try {
            setMsg("0");//serve para identificar se possui erro ou nao
            listImpoNotEquiv.clear();
            //destruir o objeto da sessão caso o usuário faça mais de uma consulta em sequência...
            if (verificarSessao) {
                if (getSession().getAttribute("listfatorPlc") != null) {
                    getSession().removeAttribute("listfatorPlc");
                }
            }

            List<Meo_meses_obraT> listMesesParcela = new Vector();
            obra = vw_importacao_orcamentoT.getObr_nr_id();
            povoaTreePlc();
            povoaTreeCronograma();

            povoaInsumos();

            povoaParcelamentoObra();

            povoaSubClasseParcelamento();

            povoaTreeIntervalo();

            povoaMax_Dias_Parcelas_Plc();

            povoaMax_Mes_CCFF_nr_id();

            povoaInsumoSubClasse();
            povoaCtpValorSubClasse();
            povoaFatorAtual();

            getTotalServicoOrcamento();

            listfatorPlc.clear();

            List<Vw_importacao_orcamentoT> listImportacao = new ArrayList<Vw_importacao_orcamentoT>();
            Vw_importacao_orcamentoDAO vdao = getVw_importacao_orcamentoDAO();
            listImportacao = vdao.getAllServico(vw_importacao_orcamentoT);
            Obr_obrasDAO odao = getObr_obrasDAO();
            obr_obrasT.setObr_nr_id(vw_importacao_orcamentoT.getObr_nr_id());
            locateCliente();
            List<Meo_meses_obraT> listMObra = odao.getAllMeses(obr_obrasT);

            //pegar o ultimo mês e ano da obra
            int mesFimObra = listMObra.get(listMObra.size() - 1).getMes();
            int anoFimObra = listMObra.get(listMObra.size() - 1).getAno();


            String keyCodido;
            List<Ipo_item_plano_contas_obraT> listInsumos;
            //Vericar quais os meses ques serão add a mais, referente a condição de pagamento, uma vez que:
            //exemplo, se o ultimo mês da obra for 08/2010 e se na lista de insumos o parcelamento for iqual a 30/60/90 o sistema
            //terá que os demais meses na lista de meses da obra que são: 09/2010,10/2010 e 11/2010.
            //por isso vericamos qual o ultimo mes em relação aos insumos inter-relacionados com a condição de pagamento.
            for (Vw_importacao_orcamentoT vw_importacaoT : listImportacao) {
                String key = vw_importacaoT.getPlco_nr_id() + "." + vw_importacaoT.getIpo_nr_id_super();
                Vw_maximo_mes_ccff_digitadoT vw_maxMes = treeMaxMesCCFF.get(key);
                Vw_maximo_dias_parcela_plcT vw_maxPar = treeMaxDiasPar.get(vw_importacaoT.getIpo_nr_id());
                if (vw_maxMes != null & vw_maxPar != null) {
                    int mesCCFF = vw_maxMes.getCcff_nr_mes();
                    int anoCCFF = vw_maxMes.getCcff_nr_ano();
                    int mesAddPar = getMes(mesCCFF, anoCCFF, vw_maxPar.getDias());
                    int anoAddPar = getAno(mesCCFF, anoCCFF, vw_maxPar.getDias());
                    if (anoAddPar > anoFimObra) {
                        mesFimObra = mesAddPar;
                        anoFimObra = anoAddPar;
                    } else if (mesAddPar > mesFimObra) {
                        mesFimObra = mesAddPar;
                    }
                }
            }
            //adiciona os itens q não tem equivalencia
            addItemSemEquivalencia(listImportacao);
            //apos descubrir o ultimo mês e ano da condição de pagamento vamos add os meses no intervalo entre o ultimo mes e ano da obra
            //com o máximo mes e ano encontrado no inter-relacionamento dos insumos dos serviços com a condição de pagamento.
            int mesIni = listMObra.get(listMObra.size() - 1).getMes();
            int anoIni = listMObra.get(listMObra.size() - 1).getAno();

            mesIni++;
            if (mesIni == 13) {
                anoIni++;
                mesIni = 1;
            }

            Ctp_ValorMesesSubClasseT valorMesesSubClasseT = new Ctp_ValorMesesSubClasseT();
            //atribuir os meses que ultrapassão o mes final da obra, por conta do parcelamento
            mesFimObra += 2;
            if (mesFimObra > 12) {
                mesFimObra = mesFimObra - 12;
                anoFimObra += 1;
            }
            preencherMesesParcela(listMObra, mesIni, anoIni, mesFimObra, anoFimObra);

            listMesesTotal = getListMesesObraParcelas(listMObra);
            TreeMap<String, Meo_meses_obraT> treeMes = new TreeMap<String, Meo_meses_obraT>();
            totalGeral = 0;
            for (Vw_importacao_orcamentoT vw_importacaoT : listImportacao) {
                // add uma nova lista de meses já atualizada com os meses do parcelamento para cada serviços
                List<Meo_meses_obraT> listMesesObra = getListMesesObraParcelas(listMObra);
                Plc_plano_contasT plc_plano_contasT = new Plc_plano_contasT();
                String tx_plc = "";
                String tx_plc_super = "";
                int plc_nr_id = 0;
                int mes_parcelamento = 0;
                int ano_parcelamento = 0;
                if (vw_importacaoT.getPlco_nr_id() == 899) {
                    int a = 5;
                }
                if (vw_importacaoT.getPlco_tx_unidade() != null) {
                    //criado para receber o acumulo dos valores calculados entre o percentual do mes com as condiçoes de pagamento dos insumos
                    Tes_temporaria_servicoT tes_temporaria_servicoT = null;

                    listInsumos = treeInsumos.get(vw_importacaoT.getIpo_nr_id());
                    if (listInsumos != null) {
                        //o objeto listInsumos já esta trazendo os ids inter-relacionados na equivalencia que é plco_nr_id com plc_nr_id
                        for (Ipo_item_plano_contas_obraT ipoT : listInsumos) {
                            listMesesObra = getListMesesObraParcelas(listMObra);
                            //localizo o parcelamento da Sub Classe
                            if (ipoT.getPlc_nr_id() == 147) {
                                int a = 6;
                            }
                            SubClasseParcelamentoT subClasseParT = treeSubClasseParcela.get(ipoT.getPlc_nr_id());
                            //pego o objeto do Treemap
                            plc_plano_contasT = treePlc.get(ipoT.getPlc_nr_id());
                            tx_plc = plc_plano_contasT.getPlc_tx_nome();
                            plc_nr_id = ipoT.getPlc_nr_id();
                            plc_plano_contasT = treePlc.get(plc_plano_contasT.getPlc_nr_id_super());
                            tx_plc_super = plc_plano_contasT.getPlc_tx_nome();
                            tes_temporaria_servicoT = addTemporaria(vw_importacaoT, tx_plc, tx_plc_super, plc_nr_id, plc_plano_contasT.getPlc_nr_id());
                            tes_temporaria_servicoT.setValorTotalCTP(0);

                            //Pegar os fatores das respectivas subclasse
                            Valores_calculo_fatorT valores_calculo_fatorT = getFatores(ipoT.getPlc_nr_id());
                            valores_calculo_fatorT.setPlc_tx_super(tx_plc_super);
                            valores_calculo_fatorT.setObr_nr_id(vw_importacaoT.getObr_nr_id());
                            valores_calculo_fatorT.setMes(mesRef);
                            valores_calculo_fatorT.setAno(anoRef);
                            if (valores_calculo_fatorT != null) {
                                tes_temporaria_servicoT.setFator_Atual(valores_calculo_fatorT.getFator_Atual());
                                tes_temporaria_servicoT.setFator_projetado(valores_calculo_fatorT.getFator_projetado());
                            }

                            for (Meo_meses_obraT meo_meses_obraT : listMesesObra) {
                                keyCodido = vw_importacaoT.getObr_nr_id() + "." + vw_importacaoT.getIpo_nr_id_super() + "." + vw_importacaoT.getPlco_nr_id() + "." + meo_meses_obraT.getMes() + "." + meo_meses_obraT.getAno();
                                double qtde = qtdeMesLancadoTree(keyCodido);
                                double totalMes = 0;
                                if (qtde > 0) {
                                    //pegar os intervalo referente ao parcelamento da subClasse
                                    List<Inp_intervalo_parcelaT> listInter = treeInter.get(subClasseParT.getPar_nr_id());
                                    for (Inp_intervalo_parcelaT inpT : listInter) {
                                        String keymes = formatkey(meo_meses_obraT, inpT.getInp_nr_dias(), subClasseParT.getPlc_nr_id());
                                        int nparcela = listInter.size();
                                        float vl_nparcela = ipoT.getIpo_nr_vl_total() / nparcela;
                                        mes_parcelamento = getMes(meo_meses_obraT, inpT.getInp_nr_dias());
                                        ano_parcelamento = getAno(meo_meses_obraT, inpT.getInp_nr_dias());

                                        if (treeMes.get(keymes) != null) {
                                            double vlAtual = treeMes.get(keymes).getCalc_valor_copia();
                                            treeMes.get(keymes).setCalc_valor_copia(vlAtual + (qtde * vl_nparcela / 100));
                                        } else {
                                            Meo_meses_obraT mt = new Meo_meses_obraT();
                                            mt.setMes(mes_parcelamento);
                                            mt.setAno(ano_parcelamento);
                                            mt.setMes_ano(odao.getStrMesAno(mt.getMes(), mt.getAno()));
                                            mt.setCalc_valor_copia(qtde * vl_nparcela / 100);
                                            treeMes.put(keymes, mt);
                                            listMesesParcela.add(mt);
                                        }

                                        //atribuir total por mês!!********************************************************************************
                                        double total_real = qtde * vl_nparcela / 100;
                                        double valor_calculado_mes = 0;
                                        //verifica se o mes é menor ou igual que o Mes e ano de referencia,
                                        // sendo maior se aplicar o percentual do fator projetado;

                                        //desabilitar depois
                                        if (!mesMenorIgual_MesReferencia(meo_meses_obraT.getMes(), meo_meses_obraT.getAno())) {
                                            valor_calculado_mes = total_real;//15/07
                                        }
                                        totalGeral += total_real + valor_calculado_mes;
                                    }
                                    meo_meses_obraT.setQuantidade(qtde);
                                }
                            }

                            //Adcionar os valores que estar contido no Treemap de meses.
                            float valorPago = 0;
                            for (Meo_meses_obraT mesT : listMesesObra) {

                                keyCodido = subClasseParT.getPlc_nr_id() + "." + mesT.getMes() + "." + mesT.getAno();
                                Meo_meses_obraT mt = treeMes.get(keyCodido);
                                if (mt != null) {
                                    mesT.setCalc_valor_copia(mt.getCalc_valor_copia());
                                    if (!mesMenorIgual_MesReferencia(mesT.getMes(), mesT.getAno())) {
                                        tes_temporaria_servicoT.setTotalMesesRestante(tes_temporaria_servicoT.getTotalMesesRestante() + mesT.getCalc_valor_copia());
                                    }
                                }
                                //verifica se o mes atual e menor que o mês de Referencia, assim add o valor do contas pagas
                                if (mesMenorIgual_MesReferencia(mesT.getMes(), mesT.getAno())) {
                                    valorMesesSubClasseT = treeCtp_ValorMesSubClasse.get(keyCodido);
                                    if (valorMesesSubClasseT != null) {
                                        mesT.setCalc_valor_copia(valorMesesSubClasseT.getValor());
                                        tes_temporaria_servicoT.setValorTotalCTP(tes_temporaria_servicoT.getValorTotalCTP() + valorMesesSubClasseT.getValor());
                                    } else {
                                        mesT.setCalc_valor_copia(0);
                                    }
                                }
                            }

                            //***********************************************************************************************************

                            tes_temporaria_servicoT.setListMesesObra(listMesesObra);
                            if (!plc_add) {
                                listServico.add(tes_temporaria_servicoT);
                                //adicionar a lista apenas as sub classes pertencentes ao relatório para que liste todos os dados do banco
                                listfatorPlc.add(valores_calculo_fatorT);
                                //*********************************************************************************************************
                            }
                        }
                    } else {
                        listImpoNotEquiv.add(vw_importacaoT);
                        setMsg("lista de insumos a serem realizado a equivalência!!");
                    }
                }
            }

            ordenarListafator();
            ordenarLista();

            //calcular valores dos meses com base no fator
            double valorPago = 0;
            treeTotalMes.clear();
            Meo_meses_obraT valorMes = null;
            for (Tes_temporaria_servicoT servico : listServico) {
                servico.setFatorDistribuido(0);
                servico.setRepassarMesesSubsequentes(false);
                if (servico.getPlc_nr_id() == 126) {
                    int a = 2;
                }
                double totalServico = 0;
                Vw_curva_abc_equivalenciaT vt = treeCurvaAbc.get(servico.getPlc_nr_id());
                if (vt != null) {
                    totalServico = vt.getTotal();
                }
                for (Meo_meses_obraT mesT : servico.getListMesesObra()) {
                    String key = mesT.getMes() + "." + mesT.getAno();
                    if (!mesMenorIgual_MesReferencia(mesT.getMes(), mesT.getAno())) {
                        if (mesT.getCalc_valor_copia() != 0) {
                            double diferenca = servico.getFator_projetado() - servico.getFator_Atual();

                            if (diferenca != 0) {
                                double fatorDistribuicao = diferenca * totalServico / servico.getTotalMesesRestante();
                                servico.setFatorDistribuido(fatorDistribuicao);
                                mesT.setCalc_valor_copia(mesT.getCalc_valor_copia() + (fatorDistribuicao * mesT.getCalc_valor_copia()));
                            }
                        }
                    } else {
                        if (mesT.getCalc_valor_copia() == 0) {
                            keyCodido = servico.getPlc_nr_id() + "." + key;
                            valorMes = treeMes.get(keyCodido);
                            if (valorMes != null) {
                                if (valorMes.getCalc_valor_copia() != 0) {
                                    servico.setRepassarMesesSubsequentes(true);
                                }
                            }
                        }
                    }
                    if (mesT.getCalc_valor_copia() != 0) {
                        servico.setUltimoMesComValor(mesT.getMes());
                        servico.setUltimoAnoComValor(mesT.getAno());
                    }
//                    SomaTotalTreeMes(key, mesT.getCalc_valor_copia());
                }
            }

            for (Tes_temporaria_servicoT servico : listServico) {
                //if(servico.isRepassarMesesSubsequentes()){
                double fator = 0;
                double totalOrcado = 0;
                double valorCtp = 0;
                double valorRestante = 0;
                double somaMeses = 0;
                for (int i = 0; i < servico.getListMesesObra().size(); i++) {
                    Meo_meses_obraT mesT = servico.getListMesesObra().get(i);
                    String key = mesT.getMes() + "." + mesT.getAno();
                    somaMeses += mesT.getCalc_valor_copia();
                    SomaTotalTreeMes(key, mesT.getCalc_valor_copia(), mesT);
                    Vw_curva_abc_equivalenciaT vt = treeCurvaAbc.get(servico.getPlc_nr_id());
                    if (vt != null) {
                        if (mesT.getMes() == servico.getUltimoMesComValor() & mesT.getAno() == servico.getUltimoAnoComValor()) {
                            //Vw_curva_abc_equivalenciaT vt = treeCurvaAbc.get(servico.getPlc_nr_id());
                            //if (vt != null) {
                            totalOrcado = vt.getTotal();
                            valorCtp = servico.getValorTotalCTP();
                            valorRestante = servico.getTotalMesesRestante();
                            //}
                            double fatorP = servico.getFator_projetado();
                            double valorRateio = (fatorP * totalOrcado);
                            valorRateio = valorRateio - somaMeses;
//                            double valorRateio = (servico.getFator_projetado() * servico.getPlco_nr_vl_total()) - (servico.getValorTotalCTP() + servico.getTotalMesesRestante()) ;
                            mesT = servico.getListMesesObra().get(i + 1);
                            mesT.setCalc_valor_copia(valorRateio);
                            key = mesT.getMes() + "." + mesT.getAno();
                            SomaTotalTreeMes(key, mesT.getCalc_valor_copia(), mesT);
                            //}
                            break;
                        }
                    }
                }
                //}
            }

            totalGeral = 0;
            //atribuir o total de cada mes
            for (Meo_meses_obraT moT : listMesesTotal) {
                keyCodido = moT.getMes() + "." + moT.getAno();
                Meo_meses_obraT mt = treeTotalMes.get(keyCodido);
                if (mt != null) {
                    double valor = mt.getTotalMes();
                    moT.setTotalMes(valor);
                    totalGeral += valor;
                }
            }

//            ordenarListafator();
//            ordenarLista();
            return listServico;

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha na leitura dos dados para montar Relatório!");
            setErro(e.toString());
        } finally {
            close();
            if (!getMsg().equalsIgnoreCase("0")) {
                listfatorPlc.clear();
            }
            getSession().setAttribute("listfatorPlc", listfatorPlc);
        }
        return null;
    }

    public void getTotalServicoOrcamento() throws Exception {
        try {

            Vw_curva_abc_equivalenciaDAO vw_curva_abc_equivalenciaDAO = getVw_curva_abc_equivalenciaDAO();
            Vw_curva_abc_equivalenciaT vt = new Vw_curva_abc_equivalenciaT();
            vt.setObr_nr_id(obra);
            List<Vw_curva_abc_equivalenciaT> list = vw_curva_abc_equivalenciaDAO.getByObr_nr_id(vt);
            for (Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT : list) {
                Vw_curva_abc_equivalenciaT curva = vw_curva_abc_equivalenciaT;
                treeCurvaAbc.put(curva.getPlc_nr_id(), curva);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public void addItemSemEquivalencia(List<Vw_importacao_orcamentoT> list) throws Exception {
        try {

            Plc_plano_contasDAO pdao = getPlc_plano_contasDAO();
            List<Plc_plano_contasT> listPlc = pdao.getPlc_Sem_Equivalencia(obra);

            Vw_importacao_orcamentoT vt = new Vw_importacao_orcamentoT();
            vt.setIpo_nr_id(0);
            vt.setPlco_tx_unidade("equiv");
            vt.setObr_nr_id(obra);
            list.add(vt);
            List<Ipo_item_plano_contas_obraT> listItem = new ArrayList<Ipo_item_plano_contas_obraT>();
            for (Plc_plano_contasT plc_plano_contasT : listPlc) {
                Ipo_item_plano_contas_obraT item = new Ipo_item_plano_contas_obraT();
                item.setPlc_nr_id(plc_plano_contasT.getPlc_nr_id());
                item.setObr_nr_id(obra);
                listItem.add(item);
            }
            treeInsumos.put(0, listItem);
        } catch (Exception e) {
            throw e;
        }

    }

    private void SomaTotalTreeMes(String key, double valor, Meo_meses_obraT mesT) {
        Meo_meses_obraT mes = treeTotalMes.get(key);
        if (mes == null) {
            Meo_meses_obraT mt = new Meo_meses_obraT();
            mt.setMes_ano(key);
            mt.setMes(mesT.getMes());
            mt.setAno(mesT.getAno());
            mt.setTotalMes(valor);
            treeTotalMes.put(key, mt);
        } else {
            mes.setTotalMes(mes.getTotalMes() + valor);
        }
    }

    //primeiro execultar o método consult
    public TreeMap<String, Meo_meses_obraT> getTreeTotalMes() throws Exception {
        try {
            verificarSessao = false;
            //consult();
        } catch (Exception e) {
            throw e;
        }

        return treeTotalMes;
    }

    public void ordenarListafator() {
        Collections.sort(listfatorPlc, new Comparator() {

            public int compare(Object o1, Object o2) {
                Valores_calculo_fatorT p1 = (Valores_calculo_fatorT) o1;
                Valores_calculo_fatorT p2 = (Valores_calculo_fatorT) o2;
                String atividade1 = (p1 != null) ? p1.getPlc_tx_super() : "";
                String atividade2 = (p2 != null) ? p2.getPlc_tx_super() : "";
                return atividade1.compareTo(atividade2);
            }
        });
    }

    public void ordenarLista() {
        Collections.sort(listServico, new Comparator() {

            public int compare(Object o1, Object o2) {
                Tes_temporaria_servicoT p1 = (Tes_temporaria_servicoT) o1;
                Tes_temporaria_servicoT p2 = (Tes_temporaria_servicoT) o2;
                String atividade1 = (p1 != null) ? p1.getPlc_tx_nome_super() : "";
                String atividade2 = (p2 != null) ? p2.getPlc_tx_nome_super() : "";
                return atividade1.compareTo(atividade2);
            }
        });
    }

    public boolean mesMenorIgual_MesReferencia(int mes, int ano) {
        boolean res = true;
        try {
            String str_dataRef = "01/" + mesRef + "/" + anoRef;
            String str_dataatual = "01/" + mes + "/" + ano;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dataRef = format.parse(str_dataRef);
            Date dataAtual = format.parse(str_dataatual);
            if (dataAtual.getTime() > dataRef.getTime()) {
                res = false;
            }

        } catch (Exception e) {
        }
        return res;
    }

    public Valores_calculo_fatorT getFatores(int plc_nr_id) {
        Valores_calculo_fatorT vt = treeFator.get(plc_nr_id);
        return vt;
    }

    public List<Meo_meses_obraT> getListMesesObraParcelas(List<Meo_meses_obraT> listMT) {
        List<Meo_meses_obraT> listTemp = new Vector();
        for (Meo_meses_obraT meo_obraT : listMT) {
            Meo_meses_obraT mt = new Meo_meses_obraT();
            mt.setAno(meo_obraT.getAno());
            mt.setMes(meo_obraT.getMes());
            mt.setQuantidade(meo_obraT.getQuantidade());
            mt.setMes_ano(meo_obraT.getMes_ano());
            mt.setCalc_valor_copia(0);
            listTemp.add(mt);
        }
        return listTemp;
    }

    /**
     *
     * @param listMesesObra sera atribuido os meses onde estão fora do inicio e final da obra, por conta do parcelamento
     * @param mesIni = mes inicial que ultrapassa o mes final da obra de acordo com as condições de pagamento da Sub Classe(Plc)
     * @param anoIni = anos inicial que ultrapassa o mes final da obra de acordo com as condições de pagamento da Sub Classe(Plc)
     * @param mesfim = mes final que ultrapassa o mes final da obra de acordo com as condições de pagamento da Sub Classe(Plc)
     * @param anofim = mes final que ultrapassa o mes final da obra de acordo com as condições de pagamento da Sub Classe(Plc)
     * @throws Exception
     */
    public void preencherMesesParcela(List<Meo_meses_obraT> listMesesObra, int mesIni, int anoIni, int mesfim, int anofim) throws Exception {
        Obr_obrasDAO odao = getObr_obrasDAO();
        List<Meo_meses_obraT> listNovosMeses = odao.getAddMeses(mesIni, anoIni, mesfim, anofim);
        for (Meo_meses_obraT meoT : listNovosMeses) {
            listMesesObra.add(meoT);
        }
    }

    public String formatkey(Meo_meses_obraT meo_meses_obraT, int dias, int plc_nr_id) throws ParseException {
        String data = DIA_BASE + meo_meses_obraT.getMes() + "/" + meo_meses_obraT.getAno();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date novadate = sdf.parse(data);
        novadate = addDias(novadate, dias);
        sdf = new SimpleDateFormat("MM");
        int mes = Integer.parseInt(sdf.format(novadate));
        sdf = new SimpleDateFormat("yyyy");
        int ano = Integer.parseInt(sdf.format(novadate));
        String keymes = plc_nr_id + "." + mes + "." + ano;
        return keymes;
    }

    public String formatkeyTotal(Meo_meses_obraT meo_meses_obraT, int dias) throws ParseException {
        String data = DIA_BASE + meo_meses_obraT.getMes() + "/" + meo_meses_obraT.getAno();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date novadate = sdf.parse(data);
        novadate = addDias(novadate, dias);
        sdf = new SimpleDateFormat("MM");
        int mes = Integer.parseInt(sdf.format(novadate));
        sdf = new SimpleDateFormat("yyyy");
        int ano = Integer.parseInt(sdf.format(novadate));
        String keymes = mes + "." + ano;
        return keymes;
    }

    public int getAno(Meo_meses_obraT meo_meses_obraT, int dias) throws ParseException {
        String data = DIA_BASE + meo_meses_obraT.getMes() + "/" + meo_meses_obraT.getAno();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date novadate = sdf.parse(data);
        novadate = addDias(novadate, dias);
        sdf = new SimpleDateFormat("yyyy");
        int ano = Integer.parseInt(sdf.format(novadate));
        return ano;
    }

    public int getAno(int mes, int ano, int dias) throws ParseException {
        String data = DIA_BASE + mes + "/" + ano;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date novadate = sdf.parse(data);
        novadate = addDias(novadate, dias);
        sdf = new SimpleDateFormat("yyyy");
        int novoAno = Integer.parseInt(sdf.format(novadate));
        String aa = sdf.format(novadate);
        return novoAno;
    }

    public int getMes(Meo_meses_obraT meo_meses_obraT, int dias) throws ParseException {
        String data = DIA_BASE + meo_meses_obraT.getMes() + "/" + meo_meses_obraT.getAno();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date novadate = sdf.parse(data);
        novadate = addDias(novadate, dias);
        sdf = new SimpleDateFormat("MM");
        int mes = Integer.parseInt(sdf.format(novadate));
        return mes;
    }

    public int getMes(int mes, int ano, int dias) throws ParseException {
        String data = DIA_BASE + mes + "/" + ano;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date novadate = sdf.parse(data);
        novadate = addDias(novadate, dias);
        sdf = new SimpleDateFormat("MM");
        int novoMes = Integer.parseInt(sdf.format(novadate));
        String aaa = sdf.format(novadate);
        return novoMes;
    }

    public Tes_temporaria_servicoT addTemporaria(Vw_importacao_orcamentoT vw_importacaoT, String tx_plc, String tx_plc_super, int plc_nr_id, int plc_nr_id_super) {
        if (plc_nr_id == 77) {
            int a = 0;
        }
        Tes_temporaria_servicoT tes_temporaria_servicoT;
        if (treeTesAdicionado.get(plc_nr_id) == null) {
            tes_temporaria_servicoT = new Tes_temporaria_servicoT();
            tes_temporaria_servicoT.setPlc_nr_id(plc_nr_id);
            tes_temporaria_servicoT.setPlc_nr_id_super(plc_nr_id_super);
            tes_temporaria_servicoT.setObr_nr_id(vw_importacaoT.getObr_nr_id());
            tes_temporaria_servicoT.setPlco_nr_id(vw_importacaoT.getPlco_nr_id());
            tes_temporaria_servicoT.setPlco_nr_nivel(vw_importacaoT.getPlco_nr_nivel());
            tes_temporaria_servicoT.setPlco_tx_nome(tx_plc);
            tes_temporaria_servicoT.setPlc_tx_nome_super(tx_plc_super);
            tes_temporaria_servicoT.setPlco_tx_unidade(vw_importacaoT.getPlco_tx_unidade());
            tes_temporaria_servicoT.setPlco_tx_cod_externo(vw_importacaoT.getPlco_tx_cod_externo());
            tes_temporaria_servicoT.setPlco_nr_quantidade(vw_importacaoT.getIpo_nr_quantidade());
            tes_temporaria_servicoT.setPlco_nr_vl_unitario(vw_importacaoT.getIpo_nr_vl_unitario());
            tes_temporaria_servicoT.setPlco_nr_vl_total(vw_importacaoT.getIpo_nr_vl_total());
            tes_temporaria_servicoT.setIpo_nr_id_super(vw_importacaoT.getIpo_nr_id_super());
            treeTesAdicionado.put(plc_nr_id, tes_temporaria_servicoT);
            plc_add = false;
        } else {
            tes_temporaria_servicoT = treeTesAdicionado.get(plc_nr_id);
            plc_add = true;
        }
        return tes_temporaria_servicoT;
    }

    public Date addDias(Date date, int dias) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, dias);
        return c.getTime();


    }

    /**
     *
     * @param codigo é a key para localizar o objeto(id_obra,ipo_nr_id_super,plco_nr_id,mes,ano)
     * @return retorna o valor do percentual digitado no mes/ano
     * @throws Exception
     */
    public double qtdeMesLancadoTree(String codigo) throws Exception {
        double qtde = 0;
        if (tipo.equalsIgnoreCase("R")) {
            if (treeCCff != null) {
                Ccff_copia_cronograma_fisico_financeiroT ct = treeCCff.get(codigo);
                if (ct != null) {
                    qtde = ct.getCcff_nr_peso();
                }
            }
        } else {
            if (treeCffo != null) {
                Cffo_cronograma_fisico_financeiro_origenalT ct = treeCffo.get(codigo);
                if (ct != null) {
                    qtde = ct.getCffo_nr_peso();
                }
            }
        }
        return qtde;
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
     * @return the obr_obrasT
     */
    public Obr_obrasT getObr_obrasT() throws Exception {
        Obr_obrasDAO odao = getObr_obrasDAO();
        obr_obrasT = odao.getByObr_nr_id(obr_obrasT).get(0);
        return obr_obrasT;
    }

    /**
     * @param obr_obrasT the obr_obrasT to set
     */
    public void setObr_obrasT(Obr_obrasT obr_obrasT) {
        this.obr_obrasT = obr_obrasT;
    }

    /**
     * @return the cli_clienteT
     */
    public Cli_clienteT getCli_clienteT() {
        return cli_clienteT;
    }

    /**
     * @param cli_clienteT the cli_clienteT to set
     */
    public void setCli_clienteT(Cli_clienteT cli_clienteT) {
        this.cli_clienteT = cli_clienteT;
    }

    public void downloadImage() throws Exception {
        try {
            cli_clienteT = (Cli_clienteT) getSession().getAttribute("clienteT");
            if (cli_clienteT.getCli_by_logomarca() != null) {
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "cli_clienteT.jpg");
                getRequest().setAttribute(EasyDownloadJB.DATA, cli_clienteT.getCli_by_logomarca());
                getPage().forward("/portal/easydownload.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    private void povoaInsumoSubClasse() {
    }

    private void povoaTreePlc() throws Exception {
        Plc_plano_contasDAO pdao = getPlc_plano_contasDAO();
        treePlc = pdao.getAllPlc();
    }

    /**
     * @return the mes
     */
    public int getMesRef() {
        return mesRef;
    }

    /**
     * @param mes the mes to set
     */
    public void setMesRef(int mesRef) {
        this.mesRef = mesRef;
    }

    /**
     * @return the ano
     */
    public int getAnoRef() {
        return anoRef;
    }

    /**
     * @param ano the ano to set
     */
    public void setAnoRef(int anoRef) {
        this.anoRef = anoRef;
    }

    /**
     * @return the erro
     */
    public String getErro() {
        return erro;
    }

    /**
     * @param erro the erro to set
     */
    public void setErro(String erro) {
        this.erro = erro;
    }

    /**
     * @return the listMesesTotal
     */
    public List<Meo_meses_obraT> getListMesesTotal() {
        return listMesesTotal;
    }

    /**
     * @param listMesesTotal the listMesesTotal to set
     */
    public void setListMesesTotal(List<Meo_meses_obraT> listMesesTotal) {
        this.listMesesTotal = listMesesTotal;
    }

    /**
     * @return the totalGeral
     */
    public float getTotalGeral() {
        return totalGeral;
    }

    /**
     * @param totalGeral the totalGeral to set
     */
    public void setTotalGeral(float totalGeral) {
        this.totalGeral = totalGeral;
    }

    /**
     * @return the listImpoEquiv
     */
    public List<Vw_importacao_orcamentoT> getListImpoNotEquiv() {
        return listImpoNotEquiv;
    }

    /**
     * @param listImpoEquiv the listImpoEquiv to set
     */
    public void setListImpoEquiv(List<Vw_importacao_orcamentoT> listImpoNotEquiv) {
        this.listImpoNotEquiv = listImpoNotEquiv;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
