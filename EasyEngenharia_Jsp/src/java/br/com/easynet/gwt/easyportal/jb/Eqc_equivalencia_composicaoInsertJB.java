package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Eqc_equivalencia_composicaoInsertJB extends SystemBase implements INotSecurity {

    private String[] idsCoa;
    private String idCon;
    private boolean imprimir;
    // Atributos e propriedades
    private Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT = new Eqc_equivalencia_composicaoT();

    public void setEqc_equivalencia_composicaoT(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) {
        this.eqc_equivalencia_composicaoT = eqc_equivalencia_composicaoT;
    }

    public Eqc_equivalencia_composicaoT getEqc_equivalencia_composicaoT() {
        return eqc_equivalencia_composicaoT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    public void addEquivalencia() throws Exception {
        DAOFactory factory = null;
        Eqc_equivalencia_composicaoDAO edao = null;
        try {
            edao = getEqc_equivalencia_composicaoDAO();
            factory = edao.getDAOFactory();
            factory.beginTransaction();
            for (int i = 0; i < idsCoa.length; i++) {
                Eqc_equivalencia_composicaoT eqc = new Eqc_equivalencia_composicaoT();
                eqc.setCon_nr_id(Integer.parseInt(idCon));
                eqc.setCoa_nr_id(Integer.parseInt(idsCoa[i]));
                edao.insert(eqc);
            }
            factory.commitTransaction();
            //consult();
        } catch (Exception e) {
            e.printStackTrace();
            factory.rollbackTransaction();
        } finally {
            close();
        }
    }
    // M�todos de Eventos

    public void insert() throws Exception {
    }

// Method de lookup
// 
    public void clear() throws Exception {

        eqc_equivalencia_composicaoT = new Eqc_equivalencia_composicaoT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "eqc_equivalencia_composicaoConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the idsCoa
     */
    public String[] getIdsCoa() {
        return idsCoa;
    }

    /**
     * @param idsCoa the idsCoa to set
     */
    public void setIdsCoa(String[] idsCoa) {
        this.idsCoa = idsCoa;
    }

    /**
     * @return the idCon
     */
    public String getIdCon() {
        return idCon;
    }

    /**
     * @param idCon the idCon to set
     */
    public void setIdCon(String idCon) {
        this.idCon = idCon;
    }

    /**
     * @return the imprimir
     */
    public boolean isImprimir() {
        return imprimir;
    }

    /**
     * @param imprimir the imprimir to set
     */
    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }
}
