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
import br.com.easynet.gwt.easyportal.transfer.SubClasseParcelamentoT;
import br.com.easynet.gwt.easyportal.transfer.Tes_temporaria_servicoT;
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
public class Cronograma_desembolsoJB extends SystemBase {

    private TreeMap<Integer, List<Ipo_item_plano_contas_obraT>> treeInsumos = new TreeMap<Integer, List<Ipo_item_plano_contas_obraT>>();
    private TreeMap<Integer, SubClasseParcelamentoT> treeSubClasseParcela = new TreeMap<Integer, SubClasseParcelamentoT>();
    private TreeMap<Integer, Pao_parcelamento_obraT> treeParcelaObra = new TreeMap<Integer, Pao_parcelamento_obraT>();
    private TreeMap<Integer, List<Inp_intervalo_parcelaT>> treeInter = new TreeMap<Integer, List<Inp_intervalo_parcelaT>>();
    private TreeMap<Integer, Vw_maximo_dias_parcela_plcT> treeMaxDiasPar = new TreeMap<Integer, Vw_maximo_dias_parcela_plcT>();
    private TreeMap<String, Vw_maximo_mes_ccff_digitadoT> treeMaxMesCFFO = new TreeMap<String, Vw_maximo_mes_ccff_digitadoT>();
    private TreeMap<String, Vw_maximo_mes_ccff_digitadoT> treeMaxMesCCFF = new TreeMap<String, Vw_maximo_mes_ccff_digitadoT>();
    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();
    private List<Tes_temporaria_servicoT> listServico = new ArrayList<Tes_temporaria_servicoT>();
    private TreeMap<String, Ccff_copia_cronograma_fisico_financeiroT> treeCCff;
    private TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalT> treeCffo;
    private Obr_obrasT obr_obrasT = new Obr_obrasT();
    private Cli_clienteT cli_clienteT = new Cli_clienteT();
    private int obra;
    private final static String DIA_BASE = "28/";
    private List<Meo_meses_obraT> listTotalMeses;
    private TreeMap<String, Meo_meses_obraT> treeTotalMeses;
    private String tipo;// "R" para reprogramavél e "O" para original;
    private List<Vw_importacao_orcamentoT> listNotEquivalencia;
    private boolean equiv_OK;
    private TreeMap<String, Ctp_ValorMesesSubClasseT> treeCtp_ValorMesSubClasse = new TreeMap<String, Ctp_ValorMesesSubClasseT>();
    private TreeMap<Integer, Vw_curva_abc_equivalenciaT> treeTotalPlc = new TreeMap<Integer, Vw_curva_abc_equivalenciaT>();
    private double totalGeral;

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void povoaTreeCCffo() {
        try {
            if (tipo.equalsIgnoreCase("R")) {
                Ccff_copia_cronograma_fisico_financeiroDAO cdao = getCcff_copia_cronograma_fisico_financeiroDAO();
                Ccff_copia_cronograma_fisico_financeiroT ccffT = new Ccff_copia_cronograma_fisico_financeiroT();
                ccffT.setObr_nr_id(vw_importacao_orcamentoT.getObr_nr_id());
                treeCCff = cdao.getByObr_nr_idTree(ccffT);
            } else {
                Cffo_cronograma_fisico_financeiro_origenalDAO cdao = getCffo_cronograma_fisico_financeiro_origenalDAO();
                Cffo_cronograma_fisico_financeiro_origenalT cffoT = new Cffo_cronograma_fisico_financeiro_origenalT();
                cffoT.setObr_nr_id(vw_importacao_orcamentoT.getObr_nr_id());
                treeCffo = cdao.getByObr_nr_idTree(cffoT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close();
        }
    }

    public void povoaTreeIntervalo() throws Exception {
        Inp_intervalo_parcelaDAO idao = getInp_intervalo_parcelaDAO();
        treeInter = idao.getAllTree();
    }

    public void povoaInsumos() throws Exception {
        Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
        treeInsumos = idao.getInsumos(vw_importacao_orcamentoT.getObr_nr_id());
    }

    public void povoaParcelamentoObra() throws Exception {
        Pao_parcelamento_obraDAO pdao = getPao_parcelamento_obraDAO();
        treeParcelaObra = pdao.getByObr_nr_idTree(vw_importacao_orcamentoT.getObr_nr_id());
    }

    public void povoaSubClasseParcelamento() throws Exception {
        Plc_plano_contasDAO dAO = getPlc_plano_contasDAO();
        treeSubClasseParcela = dAO.getSubClasseParcelamento(vw_importacao_orcamentoT.getObr_nr_id(), treeParcelaObra);
    }

    public void locateCliente() throws Exception {
        LocateObr_obrasT();
        Emp_empreendimentoT emp_empreendimentoT = new Emp_empreendimentoT();
        Emp_empreendimentoDAO edao = getEmp_empreendimentoDAO();
        emp_empreendimentoT.setEmp_nr_id(obr_obrasT.getEmp_nr_id());
        emp_empreendimentoT = edao.getByEmp_nr_id(emp_empreendimentoT).get(0);
        cli_clienteT.setCli_nr_id(emp_empreendimentoT.getCli_nr_id());
        Cli_clienteDAO cdao = getCli_clienteDAO();
        cli_clienteT = cdao.getByCli_nr_id(cli_clienteT).get(0);
        getSession().setAttribute("clienteT", cli_clienteT);
    }

    public void povoaMax_Mes_CCFF_nr_id() throws Exception {
        //tipo informa se o cronograma é o original o reprogramado
        Vw_maximo_mes_ccff_digitadoDAO vdao = getVw_maximo_mes_ccff_digitadoDAO();
        treeMaxMesCCFF = vdao.getByObr_nr_idTree(vw_importacao_orcamentoT.getObr_nr_id(), tipo);
    }

    public void povoaMax_Dias_Parcelas_Plc() throws Exception {
        Vw_maximo_dias_parcela_plcDAO vdao = getVw_maximo_dias_parcela_plcDAO();
        treeMaxDiasPar = vdao.getByObr_nr_idTree(vw_importacao_orcamentoT.getObr_nr_id());
    }

    public List<Tes_temporaria_servicoT> consult() throws Exception {
        try {

            TreeMap<Integer,Cffo_cronograma_fisico_financeiro_origenalT> treeMaxMesIpo = new TreeMap<Integer, Cffo_cronograma_fisico_financeiro_origenalT>();
            
            equiv_OK = true;
            listNotEquivalencia = new Vector();
            List<Meo_meses_obraT> listMesesParcela = new Vector();
            
            obra = vw_importacao_orcamentoT.getObr_nr_id();

            setListTotalMeses((List<Meo_meses_obraT>) new Vector());
            treeTotalMeses = new TreeMap<String, Meo_meses_obraT>();

            povoaTreeCCffo();

            povoaInsumos();

            povoaParcelamentoObra();

            povoaSubClasseParcelamento();

            povoaTreeIntervalo();

            povoaMax_Dias_Parcelas_Plc();

            povoaMax_Mes_CCFF_nr_id();

            povoaCtpValorSubClasse();

            addTotalPlc();


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
            //por isso verificamos qual o ultimo mes em relação aos insumos relacionados com a condição de pagamento.
            for (Vw_importacao_orcamentoT vw_importacaoT : listImportacao) {
                String key = vw_importacaoT.getPlco_nr_id() + "." + vw_importacaoT.getIpo_nr_id_super();
                Vw_maximo_mes_ccff_digitadoT vw_maxMes = treeMaxMesCCFF.get(key);
                Vw_maximo_dias_parcela_plcT vw_maxPar = treeMaxDiasPar.get(vw_importacaoT.getIpo_nr_id());
                if(vw_importacaoT.getIpo_nr_id() == 28677){
                    int o = 0;
                }
                if (vw_maxMes != null & vw_maxPar != null) {
                    int mesCCFF = vw_maxMes.getCcff_nr_mes();
                    int anoCCFF = vw_maxMes.getCcff_nr_ano();
                    int mesAddPar = getMes(mesCCFF, anoCCFF, vw_maxPar.getDias());
                    int anoAddPar = getAno(mesCCFF, anoCCFF, vw_maxPar.getDias());
                    String chave = anoAddPar +""+ mesAddPar+"";
                    Cffo_cronograma_fisico_financeiro_origenalT cffo = treeMaxMesIpo.get(Integer.parseInt(chave));
                    if(cffo == null){
                        cffo = new Cffo_cronograma_fisico_financeiro_origenalT();
                        cffo.setCffo_nr_mes(mesAddPar);
                        cffo.setCffo_nr_ano(anoAddPar);
                        treeMaxMesIpo.put(Integer.parseInt(chave), cffo);
                    }
                }
            }


            int valor = 0;
            Set<Integer> kset = treeMaxMesIpo.keySet();
            for (Iterator<Integer> it = kset.iterator(); it.hasNext();) {
                Integer k = it.next();
                if(valor < k){
                    valor = k;
                }
            }
            Cffo_cronograma_fisico_financeiro_origenalT cffo =treeMaxMesIpo.get(valor);


            //apos descubrir o ultimo mes e ano da condição de pagamento vamos add os meses no intervalo entre o ultimo mes e ano da obra
            //com o máximo mes e ano encontrado no inter-relacionamento dos insumos dos serviços com a condição de pagamento.
            int mesIni = listMObra.get(listMObra.size() - 1).getMes();
            int anoIni = listMObra.get(listMObra.size() - 1).getAno();
            mesIni++;
            if (mesIni == 13) {
                anoIni++;
                mesIni = 1;
            }

            //preencherMesesParcela(listMObra, mesIni, anoIni, mesFimObra, anoFimObra);
            preencherMesesParcela(listMObra, mesIni, anoIni, cffo.getCffo_nr_mes(), cffo.getCffo_nr_ano());

            for (Vw_importacao_orcamentoT vw_importacaoT : listImportacao) {
                //povoando o objeto temporario
                Tes_temporaria_servicoT tes_temporaria_servicoT = addTemporaria(vw_importacaoT);

                // add uma nova lista de meses já atualizada com os meses do parcelamento para cada serviços
                List<Meo_meses_obraT> listMesesObra = getListMesesObraParcelas(listMObra);
                if (tes_temporaria_servicoT.getPlco_tx_unidade() != null) {
                    //criado para receber o acumulo dos valores calculados entre o percentual do mes com as condiçoes de pagamento dos insumos
                    TreeMap<String, Meo_meses_obraT> treeMes = new TreeMap<String, Meo_meses_obraT>();

                    listInsumos = treeInsumos.get(vw_importacaoT.getIpo_nr_id());
                    if (listInsumos != null) {
                        for (Meo_meses_obraT meo_meses_obraT : listMesesObra) {
                            keyCodido = vw_importacaoT.getObr_nr_id() + "." + vw_importacaoT.getIpo_nr_id_super() + "." + vw_importacaoT.getPlco_nr_id() + "." + meo_meses_obraT.getMes() + "." + meo_meses_obraT.getAno();
                            double qtde = qtdeMesLancadoTree(keyCodido);

                            for (Ipo_item_plano_contas_obraT ipoT : listInsumos) {
                                //recebe o insumo já relacionado com o id do parcelamento
                                SubClasseParcelamentoT subClasseParT = treeSubClasseParcela.get(ipoT.getPlc_nr_id());
                                //recebi a lista dos intervalos referente ao item do insumo
                                List<Inp_intervalo_parcelaT> listInter = treeInter.get(subClasseParT.getPar_nr_id());

                                for (Inp_intervalo_parcelaT inpT : listInter) {
                                    //formatar a chave referente ao intervalo de dias.
                                    double somaMes = 0;
                                    String keymes = formatkey(meo_meses_obraT, inpT.getInp_nr_dias(), vw_importacaoT);
                                    String keyPlc =  subClasseParT.getPlc_nr_id()+"."+formatkeyTotal(meo_meses_obraT, inpT.getInp_nr_dias());
                                    Ctp_ValorMesesSubClasseT ctpMesT = null;//treeCtp_ValorMesSubClasse.get(keyPlc);
                                    Vw_curva_abc_equivalenciaT vtPlcGeral = null;
                                    if (ctpMesT != null) {
                                        vtPlcGeral = treeTotalPlc.get(ipoT.getPlc_nr_id());
                                        //somaMes = vtPlcGeral.getTotal();
                                    }

                                    int nparcela = listInter.size();
                                    double vl_nparcela = ipoT.getIpo_nr_vl_total() / nparcela;

                                    double novoAtual = 0;
                                    if (vtPlcGeral != null) {
                                        double diferenca = vtPlcGeral.getTotal() - ctpMesT.getValor();
                                        double perc = 100 - (diferenca * 100 / vtPlcGeral.getTotal());
                                        novoAtual = perc * ctpMesT.getValor();
                                        somaMes = novoAtual;
                                    } else {
                                        novoAtual = (qtde * vl_nparcela / 100);
                                        somaMes = novoAtual;
                                    }
                                    if (treeMes.get(keymes) != null) {
                                        double vlAtual = treeMes.get(keymes).getCalc_valor_copia();
                                        treeMes.get(keymes).setCalc_valor_copia(vlAtual + novoAtual);
                                    } else {
                                        Meo_meses_obraT mt = new Meo_meses_obraT();
                                        mt.setAno(getMes(meo_meses_obraT, inpT.getInp_nr_dias()));
                                        mt.setMes(getAno(meo_meses_obraT, inpT.getInp_nr_dias()));
                                        mt.setMes_ano(odao.getStrMesAno(mt.getMes(), mt.getAno()));
                                        mt.setCalc_valor_copia(novoAtual);
                                        treeMes.put(keymes, mt);
                                        listMesesParcela.add(mt);
                                    }
                                    //soma dos meses
                                    String keyTotal = formatkeyTotal(meo_meses_obraT, inpT.getInp_nr_dias());
                                    Meo_meses_obraT meo = treeTotalMeses.get(keyTotal);
                                    if (meo == null) {
                                        Meo_meses_obraT mt = new Meo_meses_obraT();
                                        mt.setMes_ano(keyTotal);
                                        mt.setTotalMes(somaMes);
                                        treeTotalMeses.put(keyTotal, mt);
                                    } else {
                                        meo.setTotalMes(meo.getTotalMes() + somaMes);
                                    }
                                }
                            }
                            meo_meses_obraT.setQuantidade(qtde);
                        }
                    } else {
                        listNotEquivalencia.add(vw_importacaoT);
                        equiv_OK = false;
                    }

                    for (Meo_meses_obraT meo_meses_obraT : listMesesObra) {
                        keyCodido = vw_importacaoT.getObr_nr_id() + "." + vw_importacaoT.getIpo_nr_id_super() + "." + vw_importacaoT.getPlco_nr_id() + "." + meo_meses_obraT.getMes() + "." + meo_meses_obraT.getAno();
                        Meo_meses_obraT mt = treeMes.get(keyCodido);
                        if (mt != null) {
                            meo_meses_obraT.setCalc_valor_copia(mt.getCalc_valor_copia());
                        }
                    }
                }

                tes_temporaria_servicoT.setListMesesObra(listMesesObra);
                listServico.add(tes_temporaria_servicoT);
            }


            //povoa lista total de meses
            setTotalGeral(0);
            listTotalMeses.clear();
            for (Meo_meses_obraT mesT : listMObra) {
                String chave = mesT.getMes() + "." + mesT.getAno();
                Meo_meses_obraT mt = treeTotalMeses.get(chave);
                if (mt == null) {
                    listTotalMeses.add(mesT);
                    setTotalGeral(getTotalGeral() + mesT.getTotalMes());
                } else {
                    listTotalMeses.add(mt);
                    setTotalGeral(getTotalGeral() + mt.getTotalMes());
                }
            }

            return listServico;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return null;
    }

    public void povoaCtpValorSubClasse() throws Exception {
        try {
            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
            treeCtp_ValorMesSubClasse = cdao.getValorMesesSubClasseAll(vw_importacao_orcamentoT.getObr_nr_id());
            Set<String> key = treeCtp_ValorMesSubClasse.keySet();
            float total =0;
            for (Iterator<String> it = key.iterator(); it.hasNext();) {
                String kk = it.next();
                //System.out.println(treeCtp_ValorMesSubClasse.get(kk).getValor());
                total += treeCtp_ValorMesSubClasse.get(kk).getValor();
                
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public TreeMap<String, Meo_meses_obraT> getTreeTotalMes(int obr_nr_id) throws Exception {
        try {
            vw_importacao_orcamentoT.setObr_nr_id(obr_nr_id);
            consult();
        } catch (Exception e) {
            throw e;
        }
        return treeTotalMeses;
    }

    public void addTotalPlc() throws Exception {
        Vw_curva_abc_equivalenciaDAO vdao = getVw_curva_abc_equivalenciaDAO();
        Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT = new Vw_curva_abc_equivalenciaT();
        vw_importacao_orcamentoT.setObr_nr_id(obra);
        List<Vw_curva_abc_equivalenciaT> list = vdao.getByObr_nr_id(vw_curva_abc_equivalenciaT);
        for (Vw_curva_abc_equivalenciaT vw_curvaT : list) {
            treeTotalPlc.put(vw_curvaT.getPlc_nr_id(), vw_curvaT);
        }
    }

    public void ordenarListaTotais() {
        Collections.sort(listTotalMeses, new Comparator() {
            public int compare(Object o1, Object o2) {
                Meo_meses_obraT p1 = (Meo_meses_obraT) o1;
                Meo_meses_obraT p2 = (Meo_meses_obraT) o2;
                String atividade1 = (p1 != null) ? p1.getMes_ano() : "";
                String atividade2 = (p2 != null) ? p2.getMes_ano() : "";
                return atividade1.compareTo(atividade2);
            }
        });
    }

    public List<Meo_meses_obraT> getListMesesObraParcelas(List<Meo_meses_obraT> listMT) {
        List<Meo_meses_obraT> listTemp = new Vector();
        for (Meo_meses_obraT meo_obraT : listMT) {
            Meo_meses_obraT mt = new Meo_meses_obraT();
            mt.setAno(meo_obraT.getAno());
            mt.setMes(meo_obraT.getMes());
            mt.setQuantidade(meo_obraT.getQuantidade());
            mt.setMes_ano(meo_obraT.getMes_ano());
            listTemp.add(mt);
        }
        return listTemp;

    }

    public void preencherMesesParcela(List<Meo_meses_obraT> listMesesObra, int mesIni, int anoIni, int mesfim, int anofim) throws Exception {
        Obr_obrasDAO odao = getObr_obrasDAO();
        List<Meo_meses_obraT> listNovosMeses = odao.getAddMeses(mesIni, anoIni, mesfim, anofim);
        for (Meo_meses_obraT meoT : listNovosMeses) {
            listMesesObra.add(meoT);
        }
    }

    public String formatkey(Meo_meses_obraT meo_meses_obraT, int dias, Vw_importacao_orcamentoT vw_importacaoT) throws ParseException {
        String data = DIA_BASE + meo_meses_obraT.getMes() + "/" + meo_meses_obraT.getAno();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date novadate = sdf.parse(data);
        novadate = addDias(novadate, dias);
        sdf = new SimpleDateFormat("MM");
        int mes = Integer.parseInt(sdf.format(novadate));
        sdf = new SimpleDateFormat("yyyy");
        int ano = Integer.parseInt(sdf.format(novadate));
        String keymes = vw_importacaoT.getObr_nr_id() + "." + vw_importacaoT.getIpo_nr_id_super() + "." + vw_importacaoT.getPlco_nr_id() + "." + mes + "." + ano;
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
        //ano na frente para poder ordenar a lista
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

    public Tes_temporaria_servicoT addTemporaria(Vw_importacao_orcamentoT vw_importacaoT) {
        Tes_temporaria_servicoT tes_temporaria_servicoT = new Tes_temporaria_servicoT();
        tes_temporaria_servicoT.setObr_nr_id(vw_importacaoT.getObr_nr_id());
        tes_temporaria_servicoT.setPlco_nr_id(vw_importacaoT.getPlco_nr_id());
        tes_temporaria_servicoT.setPlco_nr_nivel(vw_importacaoT.getPlco_nr_nivel());
        tes_temporaria_servicoT.setPlco_tx_nome(vw_importacaoT.getPlco_tx_nome());
        tes_temporaria_servicoT.setPlco_tx_unidade(vw_importacaoT.getPlco_tx_unidade());
        tes_temporaria_servicoT.setPlco_tx_cod_externo(vw_importacaoT.getPlco_tx_cod_externo());
        tes_temporaria_servicoT.setPlco_nr_quantidade(vw_importacaoT.getIpo_nr_quantidade());
        tes_temporaria_servicoT.setPlco_nr_vl_unitario(vw_importacaoT.getIpo_nr_vl_unitario());
        tes_temporaria_servicoT.setPlco_nr_vl_total(vw_importacaoT.getIpo_nr_vl_total());
        tes_temporaria_servicoT.setIpo_nr_id_super(vw_importacaoT.getIpo_nr_id_super());
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
        //tipo informa se o cronograma é o riginal ou reprogramavél
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
        return obr_obrasT;
    }

    public Obr_obrasT LocateObr_obrasT() throws Exception {
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

    /**
     * @return the listTotalMeses
     */
    public List<Meo_meses_obraT> getListTotalMeses() {
        return listTotalMeses;
    }

    /**
     * @param listTotalMeses the listTotalMeses to set
     */
    public void setListTotalMeses(List<Meo_meses_obraT> listTotalMeses) {
        this.listTotalMeses = listTotalMeses;
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

    /**
     * @return the listNotEquivalencia
     */
    public List<Vw_importacao_orcamentoT> getListNotEquivalencia() {
        return listNotEquivalencia;
    }

    /**
     * @param listNotEquivalencia the listNotEquivalencia to set
     */
    public void setListNotEquivalencia(List<Vw_importacao_orcamentoT> listNotEquivalencia) {
        this.listNotEquivalencia = listNotEquivalencia;
    }

    /**
     * @return the equiv_OK
     */
    public boolean isEquiv_OK() {
        return equiv_OK;
    }

    /**
     * @param equiv_OK the equiv_OK to set
     */
    public void setEquiv_OK(boolean equiv_OK) {
        this.equiv_OK = equiv_OK;
    }

    /**
     * @return the totalGeral
     */
    public double getTotalGeral() {
        return totalGeral;
    }

    /**
     * @param totalGeral the totalGeral to set
     */
    public void setTotalGeral(double totalGeral) {
        this.totalGeral = totalGeral;
    }
}
