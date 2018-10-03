package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.dao.Per_perfilDAO;
import br.com.easynet.easyportal.transfer.Per_perfilT;
import java.util.List;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Per_perfilConsultJB extends SystemBase {

    // Atributos e propriedades
    private Per_perfilT per_perfilT = new Per_perfilT();

    public void setPer_perfilT(Per_perfilT per_perfilT) {
        this.per_perfilT = per_perfilT;
    }

    public Per_perfilT getPer_perfilT() {
        return per_perfilT;
    }
    private List<Per_perfilT> list;

    public List<Per_perfilT> getList() {
        return list;
    }

    public void setList(List<Per_perfilT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        Per_perfilDAO per_perfilDAO = null;
        try {
            per_perfilDAO = getPer_perfilDAO();
            list = per_perfilDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            per_perfilDAO.close();
        }
    }

    public void delete() throws Exception {
        Per_perfilDAO per_perfilDAO = null;
        try {
            per_perfilDAO = getPer_perfilDAO();
            per_perfilDAO.delete(per_perfilT);
            setMsg("Exclusão efetuada com sucesso!");
            per_perfilT = new Per_perfilT();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            per_perfilDAO.close();
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
}
