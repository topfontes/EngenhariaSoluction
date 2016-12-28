package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Uni_unidadeInsertJB extends SystemBase {

  // Atributos e propriedades
    private Uni_unidadeT uni_unidadeT = new Uni_unidadeT();

  public void setUni_unidadeT(Uni_unidadeT uni_unidadeT) {
    this.uni_unidadeT = uni_unidadeT;
  }

  public Uni_unidadeT getUni_unidadeT() {	
    return uni_unidadeT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Uni_unidadeDAO uni_unidadeDAO =  getUni_unidadeDAO();
      uni_unidadeDAO.insert(uni_unidadeT);	 
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
    
      uni_unidadeT = new Uni_unidadeT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "uni_unidadeConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
