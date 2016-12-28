package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Grp_grupo_produtoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Grp_grupo_produtoT grp_grupo_produtoT = new Grp_grupo_produtoT();

  public void setGrp_grupo_produtoT(Grp_grupo_produtoT grp_grupo_produtoT) {
    this.grp_grupo_produtoT = grp_grupo_produtoT;
  }

  public Grp_grupo_produtoT getGrp_grupo_produtoT() {	
    return grp_grupo_produtoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Grp_grupo_produtoDAO grp_grupo_produtoDAO =  getGrp_grupo_produtoDAO();
      grp_grupo_produtoDAO.insert(grp_grupo_produtoT);	 
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
    
      grp_grupo_produtoT = new Grp_grupo_produtoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "grp_grupo_produtoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
