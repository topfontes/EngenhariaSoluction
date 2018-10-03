package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Obr_obrasConsultJB extends SystemBase {

    // Atributos e propriedades
    private Obr_obrasT obr_obrasT = new Obr_obrasT();
    private DataSet ds;

    public void setObr_obrasT(Obr_obrasT obr_obrasT) {
        this.obr_obrasT = obr_obrasT;
    }

    public Obr_obrasT getObr_obrasT() {
        return obr_obrasT;
    }
    private List<Obr_obrasT> list;

    public List<Obr_obrasT> getList() {
        return list;
    }

    public void setList(List<Obr_obrasT> list) {
        this.list = list;
    }
    private boolean consultou;

    public void pageLoad() throws Exception {
        super.pageLoad();
        consultou = false;
        if (!getOp().equalsIgnoreCase("delete")) {
            consult();
            consultou = true;
        }
    }

    public void consult() throws Exception {
        try {
            if (!consultou) {
                Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
                ds = obr_obrasDAO.getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        DAOFactory factory = null;
        try {
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            factory = obr_obrasDAO.getDAOFactory();
            factory.beginTransaction();
            Uno_unidade_obraDAO udao = getUno_unidade_obraDAO();
            udao.deleteAllObra(obr_obrasT.getObr_nr_id());
            obr_obrasDAO.delete(obr_obrasT);
            factory.commitTransaction();
            setMsg("Exclusão efetuada com sucesso!");
            obr_obrasT = new Obr_obrasT();
            consult();
        } catch (Exception e) {
            factory.rollbackTransaction();
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "obr_obrasInsert.jsp";// defina aqui a p�gina que deve ser chamada
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
}
