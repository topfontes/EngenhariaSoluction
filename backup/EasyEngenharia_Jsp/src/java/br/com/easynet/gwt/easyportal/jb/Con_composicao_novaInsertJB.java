package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Con_composicao_novaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Con_composicao_novaT con_composicao_novaT = new Con_composicao_novaT();

  public void setCon_composicao_novaT(Con_composicao_novaT con_composicao_novaT) {
    this.con_composicao_novaT = con_composicao_novaT;
  }

  public Con_composicao_novaT getCon_composicao_novaT() {	
    return con_composicao_novaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Métodos de Eventos
  public void insert() throws Exception {
    
    try {
      Con_composicao_novaDAO con_composicao_novaDAO =  getCon_composicao_novaDAO();
      con_composicao_novaDAO.insert(con_composicao_novaT);	 
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
    
      con_composicao_novaT = new Con_composicao_novaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "con_composicao_novaConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
