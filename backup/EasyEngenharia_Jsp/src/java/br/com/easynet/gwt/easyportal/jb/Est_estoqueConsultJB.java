package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Est_estoqueConsultJB extends SystemBase {

    // Atributos e propriedades
    private Est_estoqueT est_estoqueT = new Est_estoqueT();
    private boolean classificar;

    public void setEst_estoqueT(Est_estoqueT est_estoqueT) {
        this.est_estoqueT = est_estoqueT;
    }

    public Est_estoqueT getEst_estoqueT() {
        return est_estoqueT;
    }
    private List<Est_estoqueT> list;
    private DataSet ds;

    public List<Est_estoqueT> getList() {
        return list;
    }

    public void setList(List<Est_estoqueT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
//        consult();
    }


    public void consult() throws Exception {
        try {
            Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
            if (!isClassificar()) {
                setDs(est_estoqueDAO.getAllDs(est_estoqueT));
            } else {
                setDs(est_estoqueDAO.getAllDsClassificar(est_estoqueT));

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
            Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
            est_estoqueDAO.delete(est_estoqueT);
            setMsg("Exclusão efetuada com sucesso!");
            est_estoqueT = new Est_estoqueT();
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
            String page = "est_estoqueInsert.jsp";// defina aqui a p�gina que deve ser chamada
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
     * @return the classificar
     */
    public boolean isClassificar() {
        return classificar;
    }

    /**
     * @param classificar the classificar to set
     */
    public void setClassificar(boolean classificar) {
        this.classificar = classificar;
    }
}
