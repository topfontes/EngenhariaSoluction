package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe Criada Automaticamente pelo "EasyNet Generate JDragon"
 */
public class Ctp_conta_pagarInsertJB extends SystemBase {

    // Atributos e propriedades
    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();

    public void setCtp_conta_pagarT(Ctp_conta_pagarT ctp_conta_pagarT) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
    }

    public Ctp_conta_pagarT getCtp_conta_pagarT() {
        return ctp_conta_pagarT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M�todos de Eventos
    public void insert() throws Exception {

        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            ctp_conta_pagarDAO.insert(ctp_conta_pagarT);
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
    private List<For_fornecedorT> listfor_fornecedor;

    public List<For_fornecedorT> getListfor_fornecedor() {
        return listfor_fornecedor;
    }

    public void setListfor_fornecedor(List<For_fornecedorT> list) {
        this.listfor_fornecedor = list;
    }

    public void consultFor_fornecedor() throws Exception {
        try {
            For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
            listfor_fornecedor = for_fornecedorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Plc_plano_contasT> listplc_plano_contas;

    public List<Plc_plano_contasT> getListplc_plano_contas() {
        return listplc_plano_contas;
    }

    public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
        this.listplc_plano_contas = list;
    }

    public void consultPlc_plano_contas() throws Exception {
        try {
            Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
            DataSet ds = plc_plano_contasDAO.getAll();
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

    public void consultObr_obras() throws Exception {
        try {
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            DataSet listobr_obras = obr_obrasDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        ctp_conta_pagarT = new Ctp_conta_pagarT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "ctp_conta_pagarConsult.jsp";// defina aqui a p�gina que deve ser chamada  
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
