package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.text.SimpleDateFormat;
import java.util.TreeMap;
import java.util.Vector;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Pms_planilha_medicao_servicoInsertJB extends SystemBase implements INotSecurity {

    // Atributos e propriedades
    private Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT = new Pms_planilha_medicao_servicoT();
    private int[] ids_plco;
    private float[] qtde_plco;
    private float percentualMes;
    private int ultimoAnoPms;
    private int ultimoMesPms;
    private int ultimoAnoServPms;
    private int ultimoMesServPms;

    public void setPms_planilha_medicao_servicoT(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) {
        this.pms_planilha_medicao_servicoT = pms_planilha_medicao_servicoT;
    }

    public Pms_planilha_medicao_servicoT getPms_planilha_medicao_servicoT() {
        return pms_planilha_medicao_servicoT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    // M�todos de Eventos
    public void insert() throws Exception {
        DAOFactory daof = null;
        try {
            Pms_planilha_medicao_servicoDAO pms_planilha_medicao_servicoDAO = getPms_planilha_medicao_servicoDAO();
            daof = pms_planilha_medicao_servicoDAO.getDAOFactory();
            daof.beginTransaction();

            pms_planilha_medicao_servicoT.setPms_nr_id(inserir());

            if (pms_planilha_medicao_servicoT.getPms_nr_id() == 0) {
                pms_planilha_medicao_servicoDAO.insert(pms_planilha_medicao_servicoT);
            } else {
                pms_planilha_medicao_servicoDAO.update(pms_planilha_medicao_servicoT);
            }
            //lançar automaticamente o percentual informado na pms
            AtualizarCopiaCronograma();

            daof.commitTransaction();

            setMsg(pms_planilha_medicao_servicoT.getPms_nr_quantidade_servico() + "");
            clear();
        } catch (Exception e) {
            daof.rollbackTransaction();
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

    public void atulaizarCronoPms() {
//        DAOFactory factory = null;
        int cont = 0;
        int ipo_nr_id = 0;
        Pms_planilha_medicao_servicoT pmsT_old = null;
        double somaPerc = 0;
        try {

            ultimoAnoPms = getPms_planilha_medicao_servicoDAO().maiorAnoLancado(pms_planilha_medicao_servicoT.getObr_nr_id());
            ultimoMesPms = getPms_planilha_medicao_servicoDAO().maiorMesLancado(pms_planilha_medicao_servicoT.getObr_nr_id(), ultimoAnoPms);

            Ccff_copia_cronograma_fisico_financeiroDAO cdao = getCcff_copia_cronograma_fisico_financeiroDAO();
            cdao.deleteObraMesesMenor(pms_planilha_medicao_servicoT.getObr_nr_id(), ultimoMesPms, ultimoAnoPms);


            List<Pms_planilha_medicao_servicoT> listPms = getPms_planilha_medicao_servicoDAO().getByIpoObr_nr_id(pms_planilha_medicao_servicoT);
            if (listPms.size() > 0) {
                for (Pms_planilha_medicao_servicoT pmsT : listPms) {
                    cont++;

                    if (cont == 315) {
                        int f = 8;
                    }

                    if (pmsT.getIpo_nr_id() == 29560) {
                        int o = 0;
                    }


                    if (ipo_nr_id != pmsT.getIpo_nr_id()) {
                        Ccff_copia_cronograma_fisico_financeiroT ct = new Ccff_copia_cronograma_fisico_financeiroT();
                        ct.setCcff_nr_mes(pmsT.getPms_nr_mes());
                        ct.setCcff_nr_ano(pmsT.getPms_nr_ano());
                        ct.setIpo_nr_id(pmsT.getIpo_nr_id());
                        String vl = Funcoes.formatoMoedaDouble(somaPerc);
                        if (ipo_nr_id > 0 & Double.parseDouble(vl) != 100) {
                            ultimoAnoServPms = getPms_planilha_medicao_servicoDAO().maiorAnoLancadoServ(pms_planilha_medicao_servicoT.getObr_nr_id(), pmsT_old.getIpo_nr_id());
                            ultimoMesServPms = getPms_planilha_medicao_servicoDAO().maiorMesLancadoServ(pms_planilha_medicao_servicoT.getObr_nr_id(), ultimoAnoServPms, pmsT_old.getIpo_nr_id());

                            atualizar(pmsT.getObr_nr_id(), ultimoMesServPms, ultimoAnoServPms, somaPerc, pmsT_old);
                        }

                        somaPerc = pmsT.getPms_nr_percentual();
                        ipo_nr_id = pmsT.getIpo_nr_id();
                        pmsT_old = pmsT;

                    } else {
                        somaPerc += pmsT.getPms_nr_percentual();
                    }
                    Ipo_item_plano_contas_obraT ipo = new Ipo_item_plano_contas_obraT();
                    ipo.setIpo_nr_id(pmsT.getIpo_nr_id());
                    ipo = getIpo_item_plano_contas_obraDAO().getByIpo_nr_id(ipo).get(0);
                    if (pmsT.getPms_nr_percentual() != 0) {
                        double saldo = ipo.getIpo_nr_quantidade() - pmsT.getPms_nr_quantidade_servico();

                        double per = saldo * 100 / ipo.getIpo_nr_quantidade();
                        pmsT.setPms_nr_percentual(100 - per);
                        getPms_planilha_medicao_servicoDAO().update(pmsT);
                        pms_planilha_medicao_servicoT = pmsT;
                        List<Ccff_copia_cronograma_fisico_financeiroT> ls = cdao.locateRegistroIpo(ipo_nr_id, pmsT.getPms_nr_mes(), pmsT.getPms_nr_ano());
                        Ccff_copia_cronograma_fisico_financeiroT ct = new Ccff_copia_cronograma_fisico_financeiroT();
                        if (ls.size() > 0) {
                            ct = ls.get(0);
                            ct.setCcff_nr_peso(pmsT.getPms_nr_percentual());
                            cdao.update(ct);
                        } else {
                            ct.setCcff_nr_ano(pmsT.getPms_nr_ano());
                            ct.setCcff_nr_mes(pmsT.getPms_nr_mes());
                            ct.setCcff_nr_peso(pmsT.getPms_nr_percentual());
                            ct.setIpo_nr_id(ipo_nr_id);
                            ct.setIpo_nr_id_super(pmsT.getIpo_nr_id_super());
                            ct.setObr_nr_id(pmsT.getObr_nr_id());
                            ct.setPlco_nr_id(pmsT.getPlco_nr_id());
                            cdao.insert(ct);
                        }

                    }
//                    AtualizarCopiaCronograma();
                }



//*****************************************************************************************************************************************************
//
//                TreeMap<Integer, List<Ccff_copia_cronograma_fisico_financeiroT>> tree = cdao.getByItemSemPms(pms_planilha_medicao_servicoT.getObr_nr_id());
                Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();
                ipo_item_plano_contas_obraT.setObr_nr_id(pms_planilha_medicao_servicoT.getObr_nr_id());
                List<Ipo_item_plano_contas_obraT> listIpo = getIpo_item_plano_contas_obraDAO().getByObr_nr_id(ipo_item_plano_contas_obraT);
//
//                for (Ipo_item_plano_contas_obraT ipT : listIpo) {
//                    List<Ccff_copia_cronograma_fisico_financeiroT> list = tree.get(ipT.getIpo_nr_id());
//                    if (list != null) {
//                        int qtde = 0;
//                        for (int i = 0; i < list.size(); i++) {
//                            Ccff_copia_cronograma_fisico_financeiroT ccffT = list.get(i);
//                            if (ccffT.getCcff_nr_ano() == ultimoAnoPms & ccffT.getCcff_nr_mes() < ultimoMesPms || ccffT.getCcff_nr_ano() < ultimoAnoPms) {
//                                ccffT.setCcff_nr_peso(0);
//                                qtde++;
//                            } else if (ccffT.getCcff_nr_ano() == ultimoAnoPms & ccffT.getCcff_nr_mes() > ultimoMesPms || ccffT.getCcff_nr_ano() > ultimoAnoPms) {
//                                int saldo = list.size() - qtde;
//                                ccffT.setCcff_nr_peso(100 / saldo);
//                            }
//                            cdao.update(ccffT);
//                        }
//                    }
//                }
////*****************************************************************************************************************************************************
//
                int mes = 0;
                int ano = 0;
                int id_super = 0;
                int plco_nr_id = 0;
                cont = 0;
                Cffo_cronograma_fisico_financeiro_origenalDAO cdao1 = getCffo_cronograma_fisico_financeiro_origenalDAO();
                TreeMap<Integer, List<Cffo_cronograma_fisico_financeiro_origenalT>> treeCffo = cdao1.ItensSemPMS(pms_planilha_medicao_servicoT.getObr_nr_id());
                for (Ipo_item_plano_contas_obraT ipT : listIpo) {
                    List<Cffo_cronograma_fisico_financeiro_origenalT> listCfo = treeCffo.get(ipT.getIpo_nr_id());
                    ipo_nr_id = ipT.getIpo_nr_id();
                    plco_nr_id = ipT.getPlco_nr_id();
                    cont++;
                    if (ipo_nr_id == 29560) {
                        int s = 0;
                    }
                    if (ipo_nr_id == 29531) {
                        int a = 0;
                    }

                    double total = 0;
                    if (listCfo != null && listCfo.size() > 0) {
                        for (Cffo_cronograma_fisico_financeiro_origenalT cffoT : listCfo) {
                            ano = cffoT.getCffo_nr_ano();
                            mes = cffoT.getCffo_nr_mes();
                            id_super = cffoT.getIpo_nr_id_super();
                            if ((cffoT.getCffo_nr_mes() > ultimoMesPms & cffoT.getCffo_nr_ano() == ultimoAnoPms) || cffoT.getCffo_nr_ano() > ultimoAnoPms) {
                                Ccff_copia_cronograma_fisico_financeiroT ccffT = new Ccff_copia_cronograma_fisico_financeiroT();
                                ccffT.setObr_nr_id(cffoT.getObr_nr_id());
                                ccffT.setCcff_nr_mes(cffoT.getCffo_nr_mes());
                                ccffT.setCcff_nr_ano(cffoT.getCffo_nr_ano());
                                ccffT.setCcff_nr_peso(cffoT.getCffo_nr_peso());
                                ccffT.setIpo_nr_id(cffoT.getIpo_nr_id());
                                ccffT.setIpo_nr_id_super(cffoT.getIpo_nr_id_super());
                                ccffT.setPlco_nr_id(cffoT.getPlco_nr_id());
                                if (!existCCff(ipT.getIpo_nr_id(), mes, ano)) {
                                    total += cffoT.getCffo_nr_peso();
                                    cdao.insert(ccffT);
                                } else {
                                    cdao.update(ccffT);
                                    total += cffoT.getCffo_nr_peso();
                                }
                            }
                        }

                        double cem = 100d;
                        String strTot = Funcoes.formatoMoedaDouble(total);
                        total = Double.parseDouble(strTot);
                        if (total < cem) {
                            if (mes == 12) {
                                ano++;
                                mes = 0;
                            }
                            //cdao.recalcularMesesRestante(pms_planilha_medicao_servicoT.getObr_nr_id(), ipo_nr_id, id_super, plco_nr_id, mes, ano, 0);
                            mes++;

                            List<Ccff_copia_cronograma_fisico_financeiroT> listCc = cdao.getMesesRestante(pms_planilha_medicao_servicoT.getObr_nr_id(), ipo_nr_id, mes, ano);
                            if (listCc != null && listCc.size() > 0) {
                                double fatia = 0;
                                if (total == 0) {
                                    fatia = 100 / listCc.size();
                                } else {
                                    fatia = total / listCc.size();
                                }
                                for (Ccff_copia_cronograma_fisico_financeiroT ccffT : listCc) {
                                    ccffT.setCcff_nr_peso(fatia);
                                    cdao.update(ccffT);
                                }
                            } else {
//                                if ((ultimoMesPms >= mes & ultimoAnoPms == ano) || (ultimoAnoPms > ano)) {
                                    Ccff_copia_cronograma_fisico_financeiroT ccffT = new Ccff_copia_cronograma_fisico_financeiroT();
                                    ccffT.setObr_nr_id(pms_planilha_medicao_servicoT.getObr_nr_id());
                                    mes = ultimoMesPms;
                                    ano = ultimoAnoPms;
                                    if(mes == 12){
                                        ano ++;
                                        mes = 0;
                                    }
                                    mes ++;
                                    ccffT.setCcff_nr_mes(mes);
                                    ccffT.setCcff_nr_ano(ano);
                                    ccffT.setCcff_nr_peso(cem - total);
                                    ccffT.setIpo_nr_id(ipo_nr_id);
                                    ccffT.setIpo_nr_id_super(id_super);
                                    ccffT.setPlco_nr_id(ipT.getPlco_nr_id());
                                    if (existCCff(ipo_nr_id, mes, ano)) {
                                        cdao.update(ccffT);
                                    } else {
                                        cdao.insert(ccffT);
                                    }
                                //}
                            }
                        }

                    }
                }
                //cdao1.
                setMsg("operação realizada com sucesso!");
            } else {
//            factory.commitTransaction();
                setMsg("Não foi lançada PMS para esta obra");
            }
        } catch (Exception e) {
            System.out.println("erro no contador " + cont + " - ipo_nr_id" + ipo_nr_id);
            setMsg("Erro na tentativa da atualização");
            int a = 2;
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void atualizar(int obr_nr_id, int mes, int ano, double valor, Pms_planilha_medicao_servicoT pms) throws Exception {
        try {
            int px_mes = mes;
            int px_ano = ano;
            if (px_mes == 12) {
                px_mes = 0;
                ano = ano + 1;
            }
            px_mes += 1;
            double saldo = 100 - valor;
            Ccff_copia_cronograma_fisico_financeiroDAO cdao = getCcff_copia_cronograma_fisico_financeiroDAO();
            TreeMap<Integer, List<Ccff_copia_cronograma_fisico_financeiroT>> tree = cdao.getMesesRestanteTree(obr_nr_id, pms.getIpo_nr_id(), px_mes, px_ano);
            if (tree.size() > 0) {
                Ipo_item_plano_contas_obraT ipoT = new Ipo_item_plano_contas_obraT();
                ipoT.setObr_nr_id(obr_nr_id);
                ipoT.setIpo_nr_id(pms.getIpo_nr_id());

                List<Ccff_copia_cronograma_fisico_financeiroT> listcf = tree.get(ipoT.getIpo_nr_id());
                for (Ccff_copia_cronograma_fisico_financeiroT ccffT : listcf) {
                    ccffT.setCcff_nr_peso(saldo / listcf.size());
                    cdao.update(ccffT);
                    px_mes = ccffT.getCcff_nr_mes();
                    px_ano = ccffT.getCcff_nr_ano();
                }
                cdao.deleteObraMesesMaior(obr_nr_id, pms.getIpo_nr_id(), px_mes, px_ano);
            } else {

                for (int i = 0; i < 2; i++) {
                    Ccff_copia_cronograma_fisico_financeiroT ct = new Ccff_copia_cronograma_fisico_financeiroT();
                    if (px_mes == 12) {
                        px_mes = 1;
                        px_ano = px_ano + 1;
                    }

                    ct.setObr_nr_id(obr_nr_id);
                    ct.setCcff_nr_ano(px_ano);
                    ct.setCcff_nr_mes(px_mes);
                    ct.setCcff_nr_peso(saldo / 2);
                    ct.setIpo_nr_id(pms.getIpo_nr_id());
                    ct.setIpo_nr_id_super(pms.getIpo_nr_id_super());
                    ct.setPlco_nr_id(pms.getPlco_nr_id());
                    cdao.insert(ct);
                    px_mes ++;
                }
                cdao.deleteObraMesesMaior(obr_nr_id, pms.getIpo_nr_id(), px_mes, px_ano);
            }


        } catch (Exception e) {
            throw e;
        }


    }

    public boolean existCCff(int ipo_nr_id, int mes, int ano) {
        try {
            Ccff_copia_cronograma_fisico_financeiroDAO cdao = getCcff_copia_cronograma_fisico_financeiroDAO();
            return cdao.locateRegistroIpo(ipo_nr_id, mes, ano).size() > 0;
        } catch (Exception e) {
        }
        return false;

    }

    public void AtualizarCopiaCronograma() throws Exception {
        try {

            Ccff_copia_cronograma_fisico_financeiroT copiaCcff = new Ccff_copia_cronograma_fisico_financeiroT();
            if (pms_planilha_medicao_servicoT.getIpo_nr_id() == 28138) {
                int e = 0;
            }
            copiaCcff.setObr_nr_id(pms_planilha_medicao_servicoT.getObr_nr_id());
            copiaCcff.setPlco_nr_id(pms_planilha_medicao_servicoT.getPlco_nr_id());
            copiaCcff.setCcff_nr_mes(pms_planilha_medicao_servicoT.getPms_nr_mes());
            copiaCcff.setCcff_nr_ano(pms_planilha_medicao_servicoT.getPms_nr_ano());
            copiaCcff.setCcff_nr_peso(pms_planilha_medicao_servicoT.getPms_nr_percentual());
            copiaCcff.setIpo_nr_id_super(pms_planilha_medicao_servicoT.getIpo_nr_id_super());
            copiaCcff.setIpo_nr_id(pms_planilha_medicao_servicoT.getIpo_nr_id());
            Ccff_copia_cronograma_fisico_financeiroDAO cdao = getCcff_copia_cronograma_fisico_financeiroDAO();
            List<Ccff_copia_cronograma_fisico_financeiroT> list;
            List<Ccff_copia_cronograma_fisico_financeiroT> listGeral;
            list = cdao.locateRegistro(copiaCcff);
            //inserir no mes corrente

            if (list.size() > 0) {
                copiaCcff.setCcff_nr_id(list.get(0).getCcff_nr_id());
                cdao.update(copiaCcff);
            } else {
                cdao.insert(copiaCcff);
            }

            listGeral = cdao.getAllServico(copiaCcff);
            if (pms_planilha_medicao_servicoT.getIpo_nr_id() == 28334) {
                listGeral = cdao.getAllServico(copiaCcff);
            }
            int mes = 0;
            int ano = 0;

            double total = 0;
            boolean calcular = false;
            double newvalue = 0;
            double cem = 100d;

            if (pms_planilha_medicao_servicoT.getIpo_nr_id() == 28468) {
                int w = 0;
            }
            for (int i = 0; i < listGeral.size(); i++) {
                Ccff_copia_cronograma_fisico_financeiroT ccffT = listGeral.get(i);
                mes = ccffT.getCcff_nr_mes();
                ano = ccffT.getCcff_nr_ano();
                if ((mes < pms_planilha_medicao_servicoT.getPms_nr_mes() & ano == pms_planilha_medicao_servicoT.getPms_nr_ano()) || ano < pms_planilha_medicao_servicoT.getPms_nr_ano()) {
                    total += ccffT.getCcff_nr_peso();
                } else if (ccffT.getCcff_nr_ano() == pms_planilha_medicao_servicoT.getPms_nr_ano() & ccffT.getCcff_nr_mes() == pms_planilha_medicao_servicoT.getPms_nr_mes()) {
                    ccffT.setCcff_nr_peso(pms_planilha_medicao_servicoT.getPms_nr_percentual());
                    total += ccffT.getCcff_nr_peso();
                    if (total > 100) {
                        double saldo = total - ccffT.getCcff_nr_peso();
                        double vl = cem - saldo;
                        ccffT.setCcff_nr_peso(vl);
                        total = 100;
                    }

//                System.out.println(ccffT.getCcff_nr_peso() + " " + ccffT.getCcff_nr_mes() + " - " + ccffT.getCcff_nr_ano() + " ");
                    cdao.update(ccffT);

                    calcular = true;
                    int mesesRestantes = listGeral.size() - i;
                    newvalue = cem - total;
                    newvalue = newvalue / (mesesRestantes - 1);
                    if (newvalue < 0) {
                        newvalue = 0;
                    }
                } else if (calcular) {
                    total += newvalue;
                    ccffT.setCcff_nr_peso(newvalue);
                    cdao.update(ccffT);

                } else {
                    total += ccffT.getCcff_nr_peso();
                }
            }

            String strtot = Funcoes.formatoMoedaDouble(total);
            total = Double.parseDouble(strtot);
            double dif = 0.01d;
            if (total < cem & ultimoAnoServPms == ano & ultimoMesServPms == mes) {
                copiaCcff.setCcff_nr_peso(cem - total);
                if (mes == 12) {
                    mes = 1;
                    ano++;
                } else {
                    mes++;
                }
                copiaCcff.setCcff_nr_mes(mes);
                copiaCcff.setCcff_nr_ano(ano);
                cdao.insert(copiaCcff);
            } else if (total == cem) {
                cdao.deleteObraMesesMaior(pms_planilha_medicao_servicoT.getObr_nr_id(), pms_planilha_medicao_servicoT.getIpo_nr_id(), mes, ano);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public boolean peridoValido(int mes, int ano) {
        try {


            String data = "01" + Funcoes.formatarFloat("00", mes) + "/" + ano;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dt = sdf.parse(data);
            Obr_obrasDAO dAO = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = new Obr_obrasT();
            obr_obrasT.setObr_nr_id(pms_planilha_medicao_servicoT.getObr_nr_id());

            obr_obrasT = dAO.getByPK(obr_obrasT).get(0);
            if (obr_obrasT.getObr_dt_inicio_controle().getTime() < dt.getTime() & obr_obrasT.getObr_dt_termino_controle().getTime() > dt.getTime()) {
                return true;
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public void AtualizarCopiaCronogramaCorrecao() throws Exception {
        Ccff_copia_cronograma_fisico_financeiroT copiaCcff = new Ccff_copia_cronograma_fisico_financeiroT();
        copiaCcff.setObr_nr_id(pms_planilha_medicao_servicoT.getObr_nr_id());
        copiaCcff.setPlco_nr_id(pms_planilha_medicao_servicoT.getPlco_nr_id());
        copiaCcff.setCcff_nr_mes(pms_planilha_medicao_servicoT.getPms_nr_mes());
        copiaCcff.setCcff_nr_ano(pms_planilha_medicao_servicoT.getPms_nr_ano());
        copiaCcff.setCcff_nr_peso(pms_planilha_medicao_servicoT.getPms_nr_percentual());
        copiaCcff.setIpo_nr_id_super(pms_planilha_medicao_servicoT.getIpo_nr_id_super());
        copiaCcff.setIpo_nr_id(pms_planilha_medicao_servicoT.getIpo_nr_id());
        Ccff_copia_cronograma_fisico_financeiroDAO cdao = getCcff_copia_cronograma_fisico_financeiroDAO();
        List<Ccff_copia_cronograma_fisico_financeiroT> list;
        List<Ccff_copia_cronograma_fisico_financeiroT> listGeral;
        list = cdao.locateRegistro(copiaCcff);
        //inserir no mes corrente

        list = cdao.locateRegistro(copiaCcff);
        //inserir no mes corrente

        if (list.size() > 0) {
            copiaCcff.setCcff_nr_id(list.get(0).getCcff_nr_id());
            cdao.update(copiaCcff);
        } else {
            cdao.insert(copiaCcff);
        }

        listGeral = cdao.getAllServico(copiaCcff);
        int mesAtual = pms_planilha_medicao_servicoT.getPms_nr_ano();
        int anoAtual = pms_planilha_medicao_servicoT.getPms_nr_mes();
        int mes;
        int ano;

        double total = 0;
        boolean calcular = false;
        double newvalue = 0;
        double cem = 100d;

        if (pms_planilha_medicao_servicoT.getIpo_nr_id() == 28138) {
            int w = 0;
        }
        for (int i = 0; i < listGeral.size(); i++) {
            Ccff_copia_cronograma_fisico_financeiroT ccffT = listGeral.get(i);
            mes = ccffT.getCcff_nr_mes();
            ano = ccffT.getCcff_nr_ano();
            if ((mes < pms_planilha_medicao_servicoT.getPms_nr_mes() & ano == pms_planilha_medicao_servicoT.getPms_nr_ano()) || ano < pms_planilha_medicao_servicoT.getPms_nr_ano()) {
                total += ccffT.getCcff_nr_peso();
            } else if (ccffT.getCcff_nr_ano() == pms_planilha_medicao_servicoT.getPms_nr_ano() & ccffT.getCcff_nr_mes() == pms_planilha_medicao_servicoT.getPms_nr_mes()) {
                ccffT.setCcff_nr_peso(pms_planilha_medicao_servicoT.getPms_nr_percentual());
                total += ccffT.getCcff_nr_peso();
                if (total > 100) {
                    double saldo = total - ccffT.getCcff_nr_peso();
                    double vl = cem - saldo;
                    ccffT.setCcff_nr_peso(vl);
                    total = 100;
                }

                System.out.println(ccffT.getCcff_nr_peso() + " " + ccffT.getCcff_nr_mes() + " - " + ccffT.getCcff_nr_ano() + " ");
                cdao.update(ccffT);

                calcular = true;
                int mesesRestantes = listGeral.size() - i;
                newvalue = cem - total;
                newvalue = newvalue / (mesesRestantes - 1);
                if (newvalue < 0) {
                    newvalue = 0;
                }
            } else if (calcular) {
                ccffT.setCcff_nr_peso(newvalue);
                cdao.update(ccffT);
                System.out.println(ccffT.getCcff_nr_peso() + " " + ccffT.getCcff_nr_mes() + " - " + ccffT.getCcff_nr_ano() + " ");
            } else {
                total += ccffT.getCcff_nr_peso();
            }

        }
    }

    public int inserir() throws Exception {
        int id = 0;
        Pms_planilha_medicao_servicoDAO dAO = getPms_planilha_medicao_servicoDAO();
        id = dAO.insertValido(pms_planilha_medicao_servicoT);
        return id;
    }
// Method de lookup
// 
    private List<Obr_obrasT> listobr_obras;

    public List<Obr_obrasT> getListobr_obras() {
        return listobr_obras;
    }

    public void setListobr_obras(List<Obr_obrasT> list) {
        this.listobr_obras = list;
    }
    private List<Plco_plano_contas_orcamentoT> listplco_plano_contas_orcamento;

    public List<Plco_plano_contas_orcamentoT> getListplco_plano_contas_orcamento() {
        return listplco_plano_contas_orcamento;
    }

    public void setListplco_plano_contas_orcamento(List<Plco_plano_contas_orcamentoT> list) {
        this.listplco_plano_contas_orcamento = list;
    }

    public void consultPlco_plano_contas_orcamento() throws Exception {
        try {
            Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
            listplco_plano_contas_orcamento = plco_plano_contas_orcamentoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        pms_planilha_medicao_servicoT = new Pms_planilha_medicao_servicoT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "pms_planilha_medicao_servicoConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the ids_plco
     */
    public int[] getIds_plco() {
        return ids_plco;
    }

    /**
     * @param ids_plco the ids_plco to set
     */
    public void setIds_plco(int[] ids_plco) {
        this.ids_plco = ids_plco;
    }

    /**
     * @return the qtde_plco
     */
    public float[] getQtde_plco() {
        return qtde_plco;
    }

    /**
     * @param qtde_plco the qtde_plco to set
     */
    public void setQtde_plco(float[] qtde_plco) {
        this.qtde_plco = qtde_plco;
    }

    /**
     * @return the percentualMes
     */
    public float getPercentualMes() {
        return percentualMes;
    }

    /**
     * @param percentualMes the percentualMes to set
     */
    public void setPercentualMes(float percentualMes) {
        this.percentualMes = percentualMes;
    }
}
