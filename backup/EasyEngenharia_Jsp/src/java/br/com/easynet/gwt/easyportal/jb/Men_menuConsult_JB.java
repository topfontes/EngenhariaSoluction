package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.menu.dao.Men_menuDAO;
import br.com.easynet.easyportal.menu.transfer.Men_menuT;
import br.com.easynet.easyportal.transfer.Per_perfilT;
import java.util.List;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Men_menuConsult_JB extends SystemBase {

    // Atributos e propriedades
    private Men_menuT men_menuT = new Men_menuT();
    private Per_perfilT per_perfilT = new Per_perfilT();

    public void setMen_menuT(Men_menuT men_menuT) {
        this.men_menuT = men_menuT;
    }

    public Men_menuT getMen_menuT() {
        return men_menuT;
    }
    private List<Men_menuT> list;

    public List<Men_menuT> getList() {
        return list;
    }

    public void setList(List<Men_menuT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        Men_menuDAO men_menuDAO = null;
        try {
            men_menuDAO = getMen_menuDAO();
            list = men_menuDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            men_menuDAO.close();
        }
    }

    public void delete() throws Exception {
        Men_menuDAO men_menuDAO = null;
        try {
            men_menuDAO = getMen_menuDAO();
            men_menuDAO.delete(men_menuT);
            setMsg("Exclus�o efetuada com sucesso!");
            men_menuT = new Men_menuT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            men_menuDAO.close();
        }
    }

    public void consultMenuPerfil() {
        Men_menuDAO men_menuDAO = null;
        try {
            men_menuDAO = getMen_menuDAO();
            list = men_menuDAO.getMenuPerfil(per_perfilT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            men_menuDAO.close();
        }
    }

    public void consultMenuNaoPerfil() {
        Men_menuDAO men_menuDAO = null;
        try {
            men_menuDAO = getMen_menuDAO();
            list = men_menuDAO.getMenuNaoPerfil(per_perfilT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            men_menuDAO.close();
        }
    }
    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "men_menuInsert.jsp";// defina aqui a p�gina que deve ser chamada
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
     * @return the per_perfilT
     */
    public Per_perfilT getPer_perfilT() {
        return per_perfilT;
    }

    /**
     * @param per_perfilT the per_perfilT to set
     */
    public void setPer_perfilT(Per_perfilT per_perfilT) {
        this.per_perfilT = per_perfilT;
    }
}
