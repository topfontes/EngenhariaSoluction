package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class For_fornecedorConsultJB extends SystemBase {

    // Atributos e propriedades
    private For_fornecedorT for_fornecedorT = new For_fornecedorT();

    public void setFor_fornecedorT(For_fornecedorT for_fornecedorT) {
        this.for_fornecedorT = for_fornecedorT;
    }

    public For_fornecedorT getFor_fornecedorT() {
        return for_fornecedorT;
    }
    private List<For_fornecedorT> list;

    public List<For_fornecedorT> getList() {
        return list;
    }

    public void setList(List<For_fornecedorT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
//        consult();
    }

    public void consult() throws Exception {
        try {
            //for_fornecedorT.setFor_tx_nome("ELE");
            For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
            if (for_fornecedorT.getFor_tx_nome() == null) {
                list = for_fornecedorDAO.getAll();
            } else {
                list = for_fornecedorDAO.getByFor_tx_nome(for_fornecedorT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
            for_fornecedorDAO.delete(for_fornecedorT);
            setMsg("Exclusão efetuada com sucesso!");
            for_fornecedorT = new For_fornecedorT();
//      consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "for_fornecedorInsert.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
