package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.menu.dao.Men_menuDAO;
import br.com.easynet.easyportal.menu.transfer.Men_menuT;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Men_menuInsertJB extends SystemBase {

  // Atributos e propriedades
    private Men_menuT men_menuT = new Men_menuT();

  public void setMen_menuT(Men_menuT men_menuT) {
    this.men_menuT = men_menuT;
  }

  public Men_menuT getMen_menuT() {	
    return men_menuT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    Men_menuDAO men_menuDAO = null;
    try {
      men_menuDAO =  getMen_menuDAO();
      men_menuDAO.insert(men_menuT);	 
      setMsg("Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar cadastro!");	
    } finally {
	men_menuDAO.close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      men_menuT = new Men_menuT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "men_menuConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
