package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_insumo_plc_pmsInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_insumo_plc_pmsT vw_insumo_plc_pmsT = new Vw_insumo_plc_pmsT();

  public void setVw_insumo_plc_pmsT(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) {
    this.vw_insumo_plc_pmsT = vw_insumo_plc_pmsT;
  }

  public Vw_insumo_plc_pmsT getVw_insumo_plc_pmsT() {	
    return vw_insumo_plc_pmsT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_insumo_plc_pmsDAO vw_insumo_plc_pmsDAO =  getVw_insumo_plc_pmsDAO();
      vw_insumo_plc_pmsDAO.insert(vw_insumo_plc_pmsT);	 
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
    
      vw_insumo_plc_pmsT = new Vw_insumo_plc_pmsT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_insumo_plc_pmsConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
