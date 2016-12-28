package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_conta_pagar_alteradaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT = new Vw_conta_pagar_alteradaT();

  public void setVw_conta_pagar_alteradaT(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) {
    this.vw_conta_pagar_alteradaT = vw_conta_pagar_alteradaT;
  }

  public Vw_conta_pagar_alteradaT getVw_conta_pagar_alteradaT() {	
    return vw_conta_pagar_alteradaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO =  getVw_conta_pagar_alteradaDAO();
      vw_conta_pagar_alteradaDAO.insert(vw_conta_pagar_alteradaT);	 
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
    
      vw_conta_pagar_alteradaT = new Vw_conta_pagar_alteradaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_conta_pagar_alteradaConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
