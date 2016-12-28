package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.dao.Per_perfilDAO;
import br.com.easynet.easyportal.transfer.Per_perfilT;
import java.util.List;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Per_perfilUpdateDeleteJB extends SystemBase {

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
        //
    }

    public void clear() throws Exception {

        per_perfilT = new Per_perfilT();
    }

    public void delete() throws Exception {
        Per_perfilDAO per_perfilDAO = null;
        try {
            if (exist()) {
                per_perfilDAO = getPer_perfilDAO();
                per_perfilDAO.delete(per_perfilT);
                setMsg("Exclusão efetuada com sucesso!");
                clear();
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão!");
        } finally {
            per_perfilDAO.close();
        }
    }

    public boolean exist() throws Exception {
        Per_perfilDAO per_perfilDAO = null;
        try {
            per_perfilDAO = getPer_perfilDAO();
            List<Per_perfilT> listTemp = per_perfilDAO.getByPer_nr_id(per_perfilT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            per_perfilDAO.close();
        }
        return false;

    }

    public void update() throws Exception {
        Per_perfilDAO per_perfilDAO = null;
        try {
            if (exist()) {
                per_perfilDAO = getPer_perfilDAO();
                per_perfilDAO.update(per_perfilT);
                setMsg("Alteração efetuada com sucesso!");
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar alteração!");
        } finally {
           per_perfilDAO.close();
        }
    }

// Method de lookup
// 
    //Method Download Image � montando se houver algum campo do tipo binario
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        Per_perfilDAO per_perfilDAO = null;
        try {
            per_perfilDAO = getPer_perfilDAO();
            List<Per_perfilT> listTemp = per_perfilDAO.getByPer_nr_id(per_perfilT);

            per_perfilT = listTemp.size() > 0 ? listTemp.get(0) : new Per_perfilT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            per_perfilDAO.close();
        }
    }

    /**
     * Volta para a página de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "per_perfilConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        } finally {
            close();
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "per_perfilConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
