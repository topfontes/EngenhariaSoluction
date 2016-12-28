package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_maximo_mes_ccff_digitadoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT = new Vw_maximo_mes_ccff_digitadoT();

  public void setVw_maximo_mes_ccff_digitadoT(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) {
    this.vw_maximo_mes_ccff_digitadoT = vw_maximo_mes_ccff_digitadoT;
  }

  public Vw_maximo_mes_ccff_digitadoT getVw_maximo_mes_ccff_digitadoT() {	
    return vw_maximo_mes_ccff_digitadoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_maximo_mes_ccff_digitadoDAO vw_maximo_mes_ccff_digitadoDAO =  getVw_maximo_mes_ccff_digitadoDAO();
      vw_maximo_mes_ccff_digitadoDAO.insert(vw_maximo_mes_ccff_digitadoT);	 
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
    
      vw_maximo_mes_ccff_digitadoT = new Vw_maximo_mes_ccff_digitadoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_maximo_mes_ccff_digitadoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
