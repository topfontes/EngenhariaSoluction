package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_curva_abcInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_curva_abcT vw_curva_abcT = new Vw_curva_abcT();

  public void setVw_curva_abcT(Vw_curva_abcT vw_curva_abcT) {
    this.vw_curva_abcT = vw_curva_abcT;
  }

  public Vw_curva_abcT getVw_curva_abcT() {	
    return vw_curva_abcT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_curva_abcDAO vw_curva_abcDAO =  getVw_curva_abcDAO();
      vw_curva_abcDAO.insert(vw_curva_abcT);	 
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
    
      vw_curva_abcT = new Vw_curva_abcT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_curva_abcConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
