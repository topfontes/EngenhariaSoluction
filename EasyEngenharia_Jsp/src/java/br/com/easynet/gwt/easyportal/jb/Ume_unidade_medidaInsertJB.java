package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ume_unidade_medidaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Ume_unidade_medidaT ume_unidade_medidaT = new Ume_unidade_medidaT();

  public void setUme_unidade_medidaT(Ume_unidade_medidaT ume_unidade_medidaT) {
    this.ume_unidade_medidaT = ume_unidade_medidaT;
  }

  public Ume_unidade_medidaT getUme_unidade_medidaT() {	
    return ume_unidade_medidaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Ume_unidade_medidaDAO ume_unidade_medidaDAO =  getUme_unidade_medidaDAO();
      ume_unidade_medidaDAO.insert(ume_unidade_medidaT);	 
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
    
      ume_unidade_medidaT = new Ume_unidade_medidaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ume_unidade_medidaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
