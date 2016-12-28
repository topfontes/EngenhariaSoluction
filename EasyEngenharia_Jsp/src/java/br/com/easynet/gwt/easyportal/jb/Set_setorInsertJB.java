package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Set_setorInsertJB extends SystemBase {

  // Atributos e propriedades
    private Set_setorT set_setorT = new Set_setorT();

  public void setSet_setorT(Set_setorT set_setorT) {
    this.set_setorT = set_setorT;
  }

  public Set_setorT getSet_setorT() {	
    return set_setorT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    try {
      Set_setorDAO set_setorDAO =  getSet_setorDAO();
      set_setorDAO.insert(set_setorT);	 
      setMsg("Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      set_setorT = new Set_setorT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "set_setorConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
