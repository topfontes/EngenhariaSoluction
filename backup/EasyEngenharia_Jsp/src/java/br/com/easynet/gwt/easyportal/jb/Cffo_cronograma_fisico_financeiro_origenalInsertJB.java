package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.util.ArrayList;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cffo_cronograma_fisico_financeiro_origenalInsertJB extends SystemBase {

    // Atributos e propriedades
    private Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();
    private Ccff_copia_cronograma_fisico_financeiroT copiaCcff = new Ccff_copia_cronograma_fisico_financeiroT();

    public void setCffo_cronograma_fisico_financeiro_origenalT(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) {
        this.cffo_cronograma_fisico_financeiro_origenalT = cffo_cronograma_fisico_financeiro_origenalT;
    }

    public Cffo_cronograma_fisico_financeiro_origenalT getCffo_cronograma_fisico_financeiro_origenalT() {
        return cffo_cronograma_fisico_financeiro_origenalT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }


    // M�todos de Eventos

    public void insert() throws Exception {
        DAOFactory dAOFactory = null;
        try {
            Cffo_cronograma_fisico_financeiro_origenalDAO cffo_cronograma_fisico_financeiro_origenalDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
            dAOFactory = getDAO();

            dAOFactory.beginTransaction();
            Ccff_copia_cronograma_fisico_financeiroDAO copiaDao = getCcff_copia_cronograma_fisico_financeiroDAO();

            //setar os campo para a cópia do cronograma.
            getCopiaCcff().setObr_nr_id(cffo_cronograma_fisico_financeiro_origenalT.getObr_nr_id());
            getCopiaCcff().setPlco_nr_id(cffo_cronograma_fisico_financeiro_origenalT.getPlco_nr_id());
            getCopiaCcff().setCcff_nr_mes(cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_mes());
            getCopiaCcff().setCcff_nr_ano(cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_ano());
            getCopiaCcff().setCcff_nr_peso(cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_peso());
            getCopiaCcff().setIpo_nr_id_super(cffo_cronograma_fisico_financeiro_origenalT.getIpo_nr_id_super());
            getCopiaCcff().setIpo_nr_id(cffo_cronograma_fisico_financeiro_origenalT.getIpo_nr_id());
            //verifica se o valor já foi lançado para mês e ano na Obra
            mesLancado(cffo_cronograma_fisico_financeiro_origenalT);

            if (cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_id() == 0) {
                cffo_cronograma_fisico_financeiro_origenalDAO.insert(cffo_cronograma_fisico_financeiro_origenalT);
            } else {
                cffo_cronograma_fisico_financeiro_origenalDAO.update(cffo_cronograma_fisico_financeiro_origenalT);
            }
            mesLancadoCopia();
            if (copiaCcff.getCcff_nr_id() == 0) {
                copiaDao.insert(getCopiaCcff());
            } else {
                copiaDao.update(copiaCcff);
            }


            dAOFactory.commitTransaction();
            setMsg(cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_mes() + "/" + cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_ano() + " = " + cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_peso());
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
            dAOFactory.rollbackTransaction();
        } finally {
            close();
        }
    }

    public void mesLancado(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        Cffo_cronograma_fisico_financeiro_origenalDAO cdao = getCffo_cronograma_fisico_financeiro_origenalDAO();
        List<Cffo_cronograma_fisico_financeiro_origenalT> listTemp = cdao.locateRegistro(cffo_cronograma_fisico_financeiro_origenalT);
        if (listTemp.size() > 0) {
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_id(listTemp.get(0).getCffo_nr_id());
            //localizar o id na tabela de cópia cronograma fisico financeiro
            Ccff_copia_cronograma_fisico_financeiroDAO ccdao = getCcff_copia_cronograma_fisico_financeiroDAO();
            List<Ccff_copia_cronograma_fisico_financeiroT> listCcff = ccdao.locateRegistro(copiaCcff);
            copiaCcff.setCcff_nr_id(listCcff.get(0).getCcff_nr_id());
        }
    }

    public void mesLancadoCopia() throws Exception {
        Ccff_copia_cronograma_fisico_financeiroDAO ccdao = getCcff_copia_cronograma_fisico_financeiroDAO();
        List<Ccff_copia_cronograma_fisico_financeiroT> listTemp = ccdao.locateRegistro(copiaCcff);
        if (listTemp.size() > 0) {
            copiaCcff.setCcff_nr_id(listTemp.get(0).getCcff_nr_id());
        }
    }
// Method de lookup
// 
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
    private List<Obr_obrasT> listobr_obras;

    public List<Obr_obrasT> getListobr_obras() {
        return listobr_obras;
    }

    public void setListobr_obras(List<Obr_obrasT> list) {
        this.listobr_obras = list;
    }

    public void clear() throws Exception {

        cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "cffo_cronograma_fisico_financeiro_origenalConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the copiaCcff
     */
    public Ccff_copia_cronograma_fisico_financeiroT getCopiaCcff() {
        return copiaCcff;
    }

    /**
     * @param copiaCcff the copiaCcff to set
     */
    public void setCopiaCcff(Ccff_copia_cronograma_fisico_financeiroT copiaCcff) {
        this.copiaCcff = copiaCcff;
    }
}
