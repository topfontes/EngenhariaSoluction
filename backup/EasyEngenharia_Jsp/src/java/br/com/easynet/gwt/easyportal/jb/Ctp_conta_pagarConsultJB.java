package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import br.com.easynet.database.ItemDS;
import br.com.easynet.database.RowDS;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ctp_conta_pagarConsultJB extends SystemBase {

    // Atributos e propriedades
    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
    private DataSet ds;
    private boolean acumulado;

    public void setCtp_conta_pagarT(Ctp_conta_pagarT ctp_conta_pagarT) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
    }

    public Ctp_conta_pagarT getCtp_conta_pagarT() {
        return ctp_conta_pagarT;
    }
    private List<Ctp_conta_pagarT> list;
    private int id_super_classe;
// 88035652
    public List<Ctp_conta_pagarT> getList() {
        return list;
    }

    public void setList(List<Ctp_conta_pagarT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            ds = ctp_conta_pagarDAO.getAll(ctp_conta_pagarT, id_super_classe,acumulado);
            getSession().setAttribute("ds",ds);
            
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            ctp_conta_pagarDAO.delete(ctp_conta_pagarT);
            setMsg("Exclusão efetuada com sucesso!");
            ctp_conta_pagarT = new Ctp_conta_pagarT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            close();
        }
    }

    public void delconta() {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            ctp_conta_pagarDAO.deleteAll(ctp_conta_pagarT);
            setMsg("Exclusão das contas da obra efetuada com sucesso!");
            consult();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "ctp_conta_pagarInsert.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the ds
     */
    public DataSet getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DataSet ds) {
        this.ds = ds;
    }

    /**
     * @return the id_super_classe
     */
    public int getId_super_classe() {
        return id_super_classe;
    }

    /**
     * @param id_super_classe the id_super_classe to set
     */
    public void setId_super_classe(int id_super_classe) {
        this.id_super_classe = id_super_classe;
    }

    /**
     * @return the acumulado
     */
    public boolean isAcumulado() {
        return acumulado;
    }

    /**
     * @param acumulado the acumulado to set
     */
    public void setAcumulado(boolean acumulado) {
        this.acumulado = acumulado;
    }
}
