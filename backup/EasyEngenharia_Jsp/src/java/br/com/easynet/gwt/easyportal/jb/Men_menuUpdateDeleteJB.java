package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.menu.dao.Men_menuDAO;
import br.com.easynet.easyportal.menu.transfer.Men_menuT;
import java.util.List;




/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Men_menuUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Men_menuT men_menuT = new Men_menuT();

  public void setMen_menuT(Men_menuT men_menuT) {
    this.men_menuT = men_menuT;
  }

  public Men_menuT getMen_menuT() {	
    return men_menuT;
  }

	
  private List<Men_menuT> list;

  public List<Men_menuT> getList() {
    return list;
  }
  
  public void setList(List<Men_menuT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      men_menuT = new Men_menuT();	
  } 

  public void delete() throws Exception {
      Men_menuDAO men_menuDAO = null;
    try {
      if (exist()) {
        men_menuDAO = getMen_menuDAO();
        men_menuDAO.delete(men_menuT);	 
        setMsg("Exclus�o efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus�o!");	
    } finally {
	men_menuDAO.close();
    }
  } 
  public boolean exist() throws Exception {
      Men_menuDAO men_menuDAO = null;
   try {
      men_menuDAO = getMen_menuDAO();
      List<Men_menuT> listTemp  = men_menuDAO.getById( men_menuT);

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	men_menuDAO.close();
    }
    return false;
	
  }

  public void update() throws Exception {
      Men_menuDAO men_menuDAO = null;
    try {
      if (exist()) {
        men_menuDAO = getMen_menuDAO();
        men_menuDAO.update(men_menuT);	 
        setMsg("Altera��o efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar altera��o!");	
    } finally {
	men_menuDAO.close();
    }
  }   

// Method de lookup
// 


  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
      Men_menuDAO men_menuDAO = null;
    try {
      men_menuDAO = getMen_menuDAO();
      List<Men_menuT> listTemp  = men_menuDAO.getById( men_menuT);

      men_menuT= listTemp.size()>0?listTemp.get(0):new Men_menuT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	men_menuDAO.close();
    }
  }  

  /**
   * Volta para a p�gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "men_menuConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "men_menuConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
