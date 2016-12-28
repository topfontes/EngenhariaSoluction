package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.client.dao.*;
import br.com.easynet.gwt.easyportal.client.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_cffo_mesInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_cffo_mesT vw_cffo_mesT = new Vw_cffo_mesT();

  public void setVw_cffo_mesT(Vw_cffo_mesT vw_cffo_mesT) {
    this.vw_cffo_mesT = vw_cffo_mesT;
  }

  public Vw_cffo_mesT getVw_cffo_mesT() {	
    return vw_cffo_mesT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_cffo_mesDAO vw_cffo_mesDAO =  getVw_cffo_mesDAO();
      vw_cffo_mesDAO.insert(vw_cffo_mesT);	 
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
    
      vw_cffo_mesT = new Vw_cffo_mesT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_cffo_mesConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
