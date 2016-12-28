package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Uno_unidade_obraConsultJB extends SystemBase {

    // Atributos e propriedades
    private Uno_unidade_obraT uno_unidade_obraT = new Uno_unidade_obraT();
    private DataSet ds;

    public void setUno_unidade_obraT(Uno_unidade_obraT uno_unidade_obraT) {
        this.uno_unidade_obraT = uno_unidade_obraT;
    }

    public Uno_unidade_obraT getUno_unidade_obraT() {
        return uno_unidade_obraT;
    }
    private List<Uno_unidade_obraT> list;

    public List<Uno_unidade_obraT> getList() {
        return list;
    }

    public void setList(List<Uno_unidade_obraT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

            consult();
    }

    public void consult() throws Exception {
        try {
            Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
            ds = uno_unidade_obraDAO.getAll(uno_unidade_obraT);

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
            uno_unidade_obraDAO.delete(uno_unidade_obraT);
            setMsg("Exclusão efetuada com sucesso!");
            uno_unidade_obraT = new Uno_unidade_obraT();
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
            String page = "uno_unidade_obraInsert.jsp";// defina aqui a página que deve ser chamada
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
}
