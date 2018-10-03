package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Flr_fluxo_receitaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Flr_fluxo_receitaT flr_fluxo_receitaT = new Flr_fluxo_receitaT();

  public void setFlr_fluxo_receitaT(Flr_fluxo_receitaT flr_fluxo_receitaT) {
    this.flr_fluxo_receitaT = flr_fluxo_receitaT;
  }

  public Flr_fluxo_receitaT getFlr_fluxo_receitaT() {	
    return flr_fluxo_receitaT;
  }


	
  private List<Flr_fluxo_receitaT> list;

  public List<Flr_fluxo_receitaT> getList() {
    return list;
  }
  
  public void setList(List<Flr_fluxo_receitaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
//        consult();
  }

  public void consult() throws Exception {
    try {
      Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
      list = flr_fluxo_receitaDAO.getAll(flr_fluxo_receitaT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
      flr_fluxo_receitaDAO.delete(flr_fluxo_receitaT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      flr_fluxo_receitaT = new Flr_fluxo_receitaT();
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
	  String page = "flr_fluxo_receitaInsert.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
