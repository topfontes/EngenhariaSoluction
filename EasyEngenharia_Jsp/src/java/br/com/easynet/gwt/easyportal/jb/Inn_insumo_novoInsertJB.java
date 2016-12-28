package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Inn_insumo_novoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Inn_insumo_novoT inn_insumo_novoT = new Inn_insumo_novoT();

  public void setInn_insumo_novoT(Inn_insumo_novoT inn_insumo_novoT) {
    this.inn_insumo_novoT = inn_insumo_novoT;
  }

  public Inn_insumo_novoT getInn_insumo_novoT() {	
    return inn_insumo_novoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Inn_insumo_novoDAO inn_insumo_novoDAO =  getInn_insumo_novoDAO();
      inn_insumo_novoDAO.insert(inn_insumo_novoT);	 
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
    
      inn_insumo_novoT = new Inn_insumo_novoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "inn_insumo_novoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
