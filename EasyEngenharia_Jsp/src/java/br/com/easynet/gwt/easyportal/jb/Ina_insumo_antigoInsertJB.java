package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ina_insumo_antigoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Ina_insumo_antigoT ina_insumo_antigoT = new Ina_insumo_antigoT();

  public void setIna_insumo_antigoT(Ina_insumo_antigoT ina_insumo_antigoT) {
    this.ina_insumo_antigoT = ina_insumo_antigoT;
  }

  public Ina_insumo_antigoT getIna_insumo_antigoT() {	
    return ina_insumo_antigoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Ina_insumo_antigoDAO ina_insumo_antigoDAO =  getIna_insumo_antigoDAO();
      ina_insumo_antigoDAO.insert(ina_insumo_antigoT);	 
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
    
      ina_insumo_antigoT = new Ina_insumo_antigoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ina_insumo_antigoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
