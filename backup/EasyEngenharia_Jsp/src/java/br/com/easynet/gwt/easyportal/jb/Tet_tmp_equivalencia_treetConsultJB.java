package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Tet_tmp_equivalencia_treetConsultJB extends SystemBase {

    // Atributos e propriedades
    private Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT = new Tet_tmp_equivalencia_treetT();
    private String tipo;

    public void setTet_tmp_equivalencia_treetT(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) {
        this.tet_tmp_equivalencia_treetT = tet_tmp_equivalencia_treetT;
    }

    public Tet_tmp_equivalencia_treetT getTet_tmp_equivalencia_treetT() {
        return tet_tmp_equivalencia_treetT;
    }
    private List<Tet_tmp_equivalencia_treetT> list;

    public List<Tet_tmp_equivalencia_treetT> getList() {
        return list;
    }

    public void setList(List<Tet_tmp_equivalencia_treetT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        try {
            Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
            if ("plco".equalsIgnoreCase(tipo)) {
                list = tet_tmp_equivalencia_treetDAO.getAllPlco();
            } else if ("plc".equalsIgnoreCase(tipo)) {
                list = tet_tmp_equivalencia_treetDAO.getAllPlc();
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
            Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
            tet_tmp_equivalencia_treetDAO.delete(tet_tmp_equivalencia_treetT);
            setMsg("Exclus�o efetuada com sucesso!");
            tet_tmp_equivalencia_treetT = new Tet_tmp_equivalencia_treetT();
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
            String page = "tet_tmp_equivalencia_treetInsert.jsp";// defina aqui a p�gina que deve ser chamada
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
