package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ccff_copia_cronograma_fisico_financeiroInsertJB extends SystemBase {

    // Atributos e propriedades
    private Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT = new Ccff_copia_cronograma_fisico_financeiroT();

    public void setCcff_copia_cronograma_fisico_financeiroT(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) {
        this.ccff_copia_cronograma_fisico_financeiroT = ccff_copia_cronograma_fisico_financeiroT;
    }

    public Ccff_copia_cronograma_fisico_financeiroT getCcff_copia_cronograma_fisico_financeiroT() {
        return ccff_copia_cronograma_fisico_financeiroT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public boolean valido() throws Exception {
        boolean res = true;
        try {
            Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
            Pms_planilha_medicao_servicoT pmsT = new Pms_planilha_medicao_servicoT();
            pmsT.setObr_nr_id(ccff_copia_cronograma_fisico_financeiroT.getObr_nr_id());
            pmsT.setPlco_nr_id(ccff_copia_cronograma_fisico_financeiroT.getPlco_nr_id());
            pmsT.setPms_nr_mes(ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_mes());
            pmsT.setPms_nr_ano(ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_ano());
            pmsT.setIpo_nr_id(ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id());
            pmsT.setIpo_nr_id_super(ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id_super());
            List<Pms_planilha_medicao_servicoT> listPms = pdao.getByQtdeDigitado(pmsT);
            if (listPms != null) {
                if (listPms.size() > 0) {
                    res = false;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return res;
    }
    // M�todos de Eventos

    public void insert() throws Exception {
        DAOFactory dAOFactory = null;
        try { 
            if (valido()) {
                Ccff_copia_cronograma_fisico_financeiroDAO copiaDao = getCcff_copia_cronograma_fisico_financeiroDAO();
                dAOFactory = getDAO();

                dAOFactory.beginTransaction();
                //verifica se o valor já foi lançado para mês e ano na Obra
                mesLancado(ccff_copia_cronograma_fisico_financeiroT);

                if (ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_id() == 0) {
                    copiaDao.insert(ccff_copia_cronograma_fisico_financeiroT);
                } else {
                    copiaDao.update(ccff_copia_cronograma_fisico_financeiroT);
                }
                dAOFactory.commitTransaction();
                setMsg(ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_mes() + "/" + ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_ano() + " = " + ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_peso());
                clear();
            }else{
                setMsg("FALHA, existe PMS lançadas para este mês!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
            dAOFactory.rollbackTransaction();
        } finally {
            close();
        }
    }

    public void mesLancado(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        Ccff_copia_cronograma_fisico_financeiroDAO ccdao = getCcff_copia_cronograma_fisico_financeiroDAO();
        List<Ccff_copia_cronograma_fisico_financeiroT> listCcff = ccdao.locateRegistro(ccff_copia_cronograma_fisico_financeiroT);
        if (listCcff.size() > 0) {
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_id(listCcff.get(0).getCcff_nr_id());
        }
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

        ccff_copia_cronograma_fisico_financeiroT = new Ccff_copia_cronograma_fisico_financeiroT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "ccff_copia_cronograma_fisico_financeiroConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
