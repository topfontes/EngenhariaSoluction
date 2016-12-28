package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_equiv_insumo_pmsInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT = new Vw_equiv_insumo_pmsT();

  public void setVw_equiv_insumo_pmsT(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) {
    this.vw_equiv_insumo_pmsT = vw_equiv_insumo_pmsT;
  }

  public Vw_equiv_insumo_pmsT getVw_equiv_insumo_pmsT() {	
    return vw_equiv_insumo_pmsT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_equiv_insumo_pmsDAO vw_equiv_insumo_pmsDAO =  getVw_equiv_insumo_pmsDAO();
      vw_equiv_insumo_pmsDAO.insert(vw_equiv_insumo_pmsT);	 
      setMsg(INFO,"Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      vw_equiv_insumo_pmsT = new Vw_equiv_insumo_pmsT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_equiv_insumo_pmsConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
