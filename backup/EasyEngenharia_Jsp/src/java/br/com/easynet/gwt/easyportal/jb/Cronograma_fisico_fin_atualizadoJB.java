/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.Ccff_copia_cronograma_fisico_financeiroDAO;
import br.com.easynet.gwt.easyportal.dao.Cli_clienteDAO;
import br.com.easynet.gwt.easyportal.dao.Emp_empreendimentoDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_importacao_orcamentoDAO;
import br.com.easynet.gwt.easyportal.transfer.Ccff_copia_cronograma_fisico_financeiroT;
import br.com.easynet.gwt.easyportal.transfer.Cffo_cronograma_fisico_financeiro_origenalT;
import br.com.easynet.gwt.easyportal.transfer.Cli_clienteT;
import br.com.easynet.gwt.easyportal.transfer.Emp_empreendimentoT;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.gwt.easyportal.transfer.Tes_temporaria_servicoT;
import br.com.easynet.gwt.easyportal.transfer.Vw_importacao_orcamentoT;
import br.com.easynet.jb.EasyDownloadJB;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class Cronograma_fisico_fin_atualizadoJB extends SystemBase {

    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();
    private List<Tes_temporaria_servicoT> listServico = new ArrayList<Tes_temporaria_servicoT>();
    TreeMap<String, Ccff_copia_cronograma_fisico_financeiroT> treeCCff;
    private Obr_obrasT obr_obrasT = new Obr_obrasT();
    private Cli_clienteT cli_clienteT = new Cli_clienteT();
    private int obra;
    private List<Meo_meses_obraT> listTotalMeses;
    private TreeMap<String, Meo_meses_obraT> treeTotalMeses;
    private double TotalOrcamento = 0;

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void povaTreeCffo() {
        try {
            Ccff_copia_cronograma_fisico_financeiroDAO cdao = getCcff_copia_cronograma_fisico_financeiroDAO();
            Ccff_copia_cronograma_fisico_financeiroT ccffT = new Ccff_copia_cronograma_fisico_financeiroT();
            ccffT.setObr_nr_id(vw_importacao_orcamentoT.getObr_nr_id());
            treeCCff = cdao.getByObr_nr_idTree(ccffT);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close();
        }
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

    public void locateCliente() throws Exception {
        getObr_obrasT();
        Emp_empreendimentoT emp_empreendimentoT = new Emp_empreendimentoT();
        Emp_empreendimentoDAO edao = getEmp_empreendimentoDAO();
        emp_empreendimentoT.setEmp_nr_id(obr_obrasT.getEmp_nr_id());
        emp_empreendimentoT = edao.getByEmp_nr_id(emp_empreendimentoT).get(0);
        cli_clienteT.setCli_nr_id(emp_empreendimentoT.getCli_nr_id());
        Cli_clienteDAO cdao = getCli_clienteDAO();
        cli_clienteT = cdao.getByCli_nr_id(cli_clienteT).get(0);
        getSession().setAttribute("clienteT", cli_clienteT);

    }

    public void consult() throws Exception {
        try {

            setListTotalMeses((List<Meo_meses_obraT>) new Vector());
            treeTotalMeses = new TreeMap<String, Meo_meses_obraT>();

            obra = vw_importacao_orcamentoT.getObr_nr_id();
            povaTreeCffo();
            List<Vw_importacao_orcamentoT> listImportacao = new ArrayList<Vw_importacao_orcamentoT>();
            Vw_importacao_orcamentoDAO vdao = getVw_importacao_orcamentoDAO();
            listImportacao = vdao.getAllServico(vw_importacao_orcamentoT);
            Obr_obrasDAO odao = getObr_obrasDAO();
            obr_obrasT.setObr_nr_id(vw_importacao_orcamentoT.getObr_nr_id());
            locateCliente();
            //getSession().setAttribute("obraT", obr_obrasT);

            String keyCodido;
            List<Meo_meses_obraT> listMesesObra = odao.getAllMeses(obr_obrasT);
            for (Vw_importacao_orcamentoT vw_importacaoT : listImportacao) {
                setTotalOrcamento(getTotalOrcamento() + vw_importacaoT.getIpo_nr_vl_total());
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
                //identificar o número de meses da obra

                List<Meo_meses_obraT> listMesesObraTmp = new ArrayList<Meo_meses_obraT>();
                //rolar os meses setando os valores respectivos aos meses trasido do banco!
                for (Meo_meses_obraT meo_meses_obraT : listMesesObra) {

                    Meo_meses_obraT mesObraServ = new Meo_meses_obraT();
                    mesObraServ.setAno(meo_meses_obraT.getAno());
                    mesObraServ.setMes(meo_meses_obraT.getMes());
                    mesObraServ.setMes_ano(meo_meses_obraT.getMes_ano());
                    
                    //trazer a quantidade digitada no mês/ano/conta/id_super da conta
                    keyCodido = vw_importacaoT.getObr_nr_id() + "." + vw_importacaoT.getIpo_nr_id_super() + "." + vw_importacaoT.getPlco_nr_id() + "." + meo_meses_obraT.getMes() + "." + meo_meses_obraT.getAno();
                    double qtde = qtdeMesLancadoTree(keyCodido);
                    mesObraServ.setQuantidade(qtde);

                    double calc_qtde = qtde * tes_temporaria_servicoT.getPlco_nr_quantidade() / 100;
                    double calc_valor = qtde * tes_temporaria_servicoT.getPlco_nr_vl_total() / 100;

                    mesObraServ.setCalc_quantidade_original(calc_qtde);
                    mesObraServ.setCalc_valor_original(calc_valor);

                    tes_temporaria_servicoT.setSoma_qtde_original(tes_temporaria_servicoT.getSoma_qtde_original() + calc_qtde);
                    tes_temporaria_servicoT.setSoma_valor_original(tes_temporaria_servicoT.getSoma_valor_original() + calc_valor);

                    //soma dos meses
                    Meo_meses_obraT meo = treeTotalMeses.get(meo_meses_obraT.getMes_ano());
                    if (meo == null) {
                        Meo_meses_obraT mt = new Meo_meses_obraT();
                        mt.setMes(meo_meses_obraT.getMes());
                        mt.setAno(meo_meses_obraT.getAno());
                        mt.setMes_ano(meo_meses_obraT.getMes_ano());
                        mt.setCalc_valor_original(calc_valor);
                        treeTotalMeses.put(meo_meses_obraT.getMes_ano(), mt);
                    } else {
                        meo.setCalc_valor_original(meo.getCalc_valor_original() + calc_valor);
                    }
                    listMesesObraTmp.add(mesObraServ);
                }
                tes_temporaria_servicoT.setListMesesObra(listMesesObraTmp);
                listServico.add(tes_temporaria_servicoT);
            }


            double acumulado = 0;
            for (Meo_meses_obraT mt : listMesesObra) {
                Meo_meses_obraT mes = treeTotalMeses.get(mt.getMes_ano());
                mes.setQuantidade(mes.getCalc_valor_original() / getTotalOrcamento());
                acumulado += mes.getCalc_valor_original();
                mes.setCalc_quantidade_original((acumulado / getTotalOrcamento()));
                getListTotalMeses().add(mes);
            }

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public double qtdeMesLancadoTree(String codigo) throws Exception {
        double qtde = 0;
        if (treeCCff != null) {
            Ccff_copia_cronograma_fisico_financeiroT ct = treeCCff.get(codigo);
            if (ct != null) {
                qtde = ct.getCcff_nr_peso();
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
     * @return the TotalOrcamento
     */
    public double getTotalOrcamento() {
        return TotalOrcamento;
    }

    /**
     * @param TotalOrcamento the TotalOrcamento to set
     */
    public void setTotalOrcamento(double TotalOrcamento) {
        this.TotalOrcamento = TotalOrcamento;
    }
}
