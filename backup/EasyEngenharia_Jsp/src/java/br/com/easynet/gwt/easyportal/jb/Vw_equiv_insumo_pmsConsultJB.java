package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_equiv_insumo_pmsConsultJB extends SystemBase {

  // Atributos e propriedades
    private Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT = new Vw_equiv_insumo_pmsT();
    private boolean acumulado;
    private DataSet ds;

  public void setVw_equiv_insumo_pmsT(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) {
    this.vw_equiv_insumo_pmsT = vw_equiv_insumo_pmsT;
  }

  public Vw_equiv_insumo_pmsT getVw_equiv_insumo_pmsT() {	
    return vw_equiv_insumo_pmsT;
  }

	
  private List<Vw_equiv_insumo_pmsT> list;

  public List<Vw_equiv_insumo_pmsT> getList() {
    return list;
  }
  
  public void setList(List<Vw_equiv_insumo_pmsT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        //consult();
  }

  public void consult() throws Exception {
    try {
      Vw_equiv_insumo_pmsDAO vw_equiv_insumo_pmsDAO = getVw_equiv_insumo_pmsDAO();
      list = vw_equiv_insumo_pmsDAO.getByPlc_nr_id(vw_equiv_insumo_pmsT,acumulado);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Vw_equiv_insumo_pmsDAO vw_equiv_insumo_pmsDAO = getVw_equiv_insumo_pmsDAO();
      vw_equiv_insumo_pmsDAO.delete(vw_equiv_insumo_pmsT);	 
      setMsg("Exclusao efetuada com sucesso!");
      vw_equiv_insumo_pmsT = new Vw_equiv_insumo_pmsT();
      consult();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "vw_equiv_insumo_pmsInsert.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
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
