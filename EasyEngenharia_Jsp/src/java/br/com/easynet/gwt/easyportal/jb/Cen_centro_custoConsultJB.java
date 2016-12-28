package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cen_centro_custoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Cen_centro_custoT cen_centro_custoT = new Cen_centro_custoT();

    public void setCen_centro_custoT(Cen_centro_custoT cen_centro_custoT) {
        this.cen_centro_custoT = cen_centro_custoT;
    }

    public Cen_centro_custoT getCen_centro_custoT() {
        return cen_centro_custoT;
    }
    private List<Cen_centro_custoT> list;

    public List<Cen_centro_custoT> getList() {
        return list;
    }

    public void setList(List<Cen_centro_custoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }
    public void consult() throws Exception {
        try {
            Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
            list = cen_centro_custoDAO.getAll();
            



        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
            cen_centro_custoDAO.delete(cen_centro_custoT);
            setMsg("Exclusão efetuada com sucesso!");
            cen_centro_custoT = new Cen_centro_custoT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "cen_centro_custoInsert.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
