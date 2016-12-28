package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class For_fornecedorInsertJB extends SystemBase {

  // Atributos e propriedades
    private For_fornecedorT for_fornecedorT = new For_fornecedorT();

  public void setFor_fornecedorT(For_fornecedorT for_fornecedorT) {
    this.for_fornecedorT = for_fornecedorT;
  }

  public For_fornecedorT getFor_fornecedorT() {	
    return for_fornecedorT;
  }

  private int for_nr_id;
	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      For_fornecedorDAO for_fornecedorDAO =  getFor_fornecedorDAO();
      for_fornecedorDAO.insert(for_fornecedorT);
      for_nr_id = for_fornecedorT.getFor_nr_id();
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
    
      for_fornecedorT = new For_fornecedorT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "for_fornecedorConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the for_nr_id
     */
    public int getFor_nr_id() {
        return for_nr_id;
    }

    /**
     * @param for_nr_id the for_nr_id to set
     */
    public void setFor_nr_id(int for_nr_id) {
        this.for_nr_id = for_nr_id;
    }

}
