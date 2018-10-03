package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ctpm_conta_pagar_modificadaInsertJB extends SystemBase {

    // Atributos e propriedades
    private Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT = new Ctpm_conta_pagar_modificadaT();

    public void setCtpm_conta_pagar_modificadaT(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) {
        this.ctpm_conta_pagar_modificadaT = ctpm_conta_pagar_modificadaT;
    }

    public Ctpm_conta_pagar_modificadaT getCtpm_conta_pagar_modificadaT() {
        return ctpm_conta_pagar_modificadaT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M�todos de Eventos
    public void insert() throws Exception {

        try {
            Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
            ctpm_conta_pagar_modificadaDAO.insert(ctpm_conta_pagar_modificadaT);
            setMsg("Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
        } finally {
            close();
        }
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

    public void consultObr_obras() throws Exception {
        try {
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Ctp_conta_pagarT> listctp_conta_pagar;

    public List<Ctp_conta_pagarT> getListctp_conta_pagar() {
        return listctp_conta_pagar;
    }

    public void setListctp_conta_pagar(List<Ctp_conta_pagarT> list) {
        this.listctp_conta_pagar = list;
    }

    public void consultCtp_conta_pagar() throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            //listctp_conta_pagar = ctp_conta_pagarDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        ctpm_conta_pagar_modificadaT = new Ctpm_conta_pagar_modificadaT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "ctpm_conta_pagar_modificadaConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
