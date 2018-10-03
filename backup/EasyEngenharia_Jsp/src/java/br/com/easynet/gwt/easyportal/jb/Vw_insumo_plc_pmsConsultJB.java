package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Vw_insumo_plc_pmsConsultJB extends SystemBase {

    // Atributos e propriedades
    private Vw_insumo_plc_pmsT vw_insumo_plc_pmsT = new Vw_insumo_plc_pmsT();
    private DataSet ds;
    private boolean acumulado;
    private String tipo;

    public void setVw_insumo_plc_pmsT(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) {
        this.vw_insumo_plc_pmsT = vw_insumo_plc_pmsT;
    }

    public Vw_insumo_plc_pmsT getVw_insumo_plc_pmsT() {
        return vw_insumo_plc_pmsT;
    }
    private List<Vw_insumo_plc_pmsT> list;

    public List<Vw_insumo_plc_pmsT> getList() {
        return list;
    }

    public void setList(List<Vw_insumo_plc_pmsT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        try {
            Vw_insumo_plc_pmsDAO vw_insumo_plc_pmsDAO = getVw_insumo_plc_pmsDAO();
            ds = vw_insumo_plc_pmsDAO.getResumoPmsPlc(vw_insumo_plc_pmsT, acumulado,tipo);
            
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Vw_insumo_plc_pmsDAO vw_insumo_plc_pmsDAO = getVw_insumo_plc_pmsDAO();
            vw_insumo_plc_pmsDAO.delete(vw_insumo_plc_pmsT);
            setMsg("Exclusão efetuada com sucesso!");
            vw_insumo_plc_pmsT = new Vw_insumo_plc_pmsT();
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
            String page = "vw_insumo_plc_pmsInsert.jsp";// defina aqui a pagina que deve ser chamada
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
     * @return the acumulado
     */
    public boolean isAcumulado() {
        return acumulado;
    }

    /**
     * @param acumulado the acumulado to set
     */
    public void setAcumulado(boolean acumulado) {
        this.acumulado = acumulado;
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
