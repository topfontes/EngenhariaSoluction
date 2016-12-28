package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plc_plano_contasConsultJB extends SystemBase {

  // Atributos e propriedades
    private Plc_plano_contasT plc_plano_contasT = new Plc_plano_contasT();
    private DataSet ds;

  public void setPlc_plano_contasT(Plc_plano_contasT plc_plano_contasT) {
    this.plc_plano_contasT = plc_plano_contasT;
  }

  public Plc_plano_contasT getPlc_plano_contasT() {	
    return plc_plano_contasT;
  }


	
  private List<Plc_plano_contasT> list;

  public List<Plc_plano_contasT> getList() {
    return list;
  }
  
  public void setList(List<Plc_plano_contasT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        //consult();
  }

  public void consult() throws Exception {
    try {
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      ds = plc_plano_contasDAO.getAll();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }

  }  
  public void consultSuper(){
       try {
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      ds = plc_plano_contasDAO.getByContaSuper();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");
    } finally {
	close();
    }
  }
  public void consultSubClasse(){
       try {
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      ds = plc_plano_contasDAO.getByContaSubClasse();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");
    } finally {
	close();
    }
  }
  public void delete() throws Exception {
    try {
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      plc_plano_contasDAO.delete(plc_plano_contasT);	 
      setMsg("Exclusão efetuada com sucesso!");
      plc_plano_contasT = new Plc_plano_contasT();
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
	  String page = "plc_plano_contasInsert.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
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
