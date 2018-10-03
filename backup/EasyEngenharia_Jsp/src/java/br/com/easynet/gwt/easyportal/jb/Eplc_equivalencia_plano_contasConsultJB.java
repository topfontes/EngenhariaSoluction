package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Eplc_equivalencia_plano_contasConsultJB extends SystemBase {

    // Atributos e propriedades
    private Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT = new Eplc_equivalencia_plano_contasT();

    public void setEplc_equivalencia_plano_contasT(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) {
        this.eplc_equivalencia_plano_contasT = eplc_equivalencia_plano_contasT;
    }

    public Eplc_equivalencia_plano_contasT getEplc_equivalencia_plano_contasT() {
        return eplc_equivalencia_plano_contasT;
    }
    private List<Eplc_equivalencia_plano_contasT> list;

    public List<Eplc_equivalencia_plano_contasT> getList() {
        return list;
    }

    public void setList(List<Eplc_equivalencia_plano_contasT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
//        consult();
    }

    public void consult() throws Exception {
        try {
            Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
            list = eplc_equivalencia_plano_contasDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consult_equiv() {
        try {
            Eplc_equivalencia_plano_contasDAO aO = getEplc_equivalencia_plano_contasDAO();
            list = aO.getByPlco_nr_id(eplc_equivalencia_plano_contasT);
        } catch (Exception e) {
        } finally {
            close();
        }

    }

    public void delete() throws Exception {
        try {
            Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
            eplc_equivalencia_plano_contasDAO.delete(eplc_equivalencia_plano_contasT);
            setMsg("Exclusão efetuada com sucesso!");
            eplc_equivalencia_plano_contasT = new Eplc_equivalencia_plano_contasT();
            consult();
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
            String page = "eplc_equivalencia_plano_contasInsert.jsp";// defina aqui a pagina que deve ser chamada
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
