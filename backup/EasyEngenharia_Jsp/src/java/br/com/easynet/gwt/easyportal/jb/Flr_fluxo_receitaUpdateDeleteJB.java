package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Flr_fluxo_receitaUpdateDeleteJB extends SystemBase {

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
	//
  }

  public void clear() throws Exception {
    
      flr_fluxo_receitaT = new Flr_fluxo_receitaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
        flr_fluxo_receitaDAO.delete(flr_fluxo_receitaT);	 
        setMsg("Exclus�o efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus�o!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
      List<Flr_fluxo_receitaT> listTemp  = flr_fluxo_receitaDAO.getByPK( flr_fluxo_receitaT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
        flr_fluxo_receitaDAO.update(flr_fluxo_receitaT);	 
        setMsg("Altera��o efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar altera��o!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
      List<Flr_fluxo_receitaT> listTemp  = flr_fluxo_receitaDAO.getByPK( flr_fluxo_receitaT);	 

      flr_fluxo_receitaT= listTemp.size()>0?listTemp.get(0):new Flr_fluxo_receitaT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p�gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "flr_fluxo_receitaConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "flr_fluxo_receitaConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
