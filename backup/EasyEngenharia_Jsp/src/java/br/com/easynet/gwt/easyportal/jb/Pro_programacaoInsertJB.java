package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_programacaoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Pro_programacaoT pro_programacaoT = new Pro_programacaoT();

  public void setPro_programacaoT(Pro_programacaoT pro_programacaoT) {
    this.pro_programacaoT = pro_programacaoT;
  }

  public Pro_programacaoT getPro_programacaoT() {	
    return pro_programacaoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Métodos de Eventos
  public void insert() throws Exception {
    
    try {
      Pro_programacaoDAO pro_programacaoDAO =  getPro_programacaoDAO();
      pro_programacaoDAO.insert(pro_programacaoT);	 
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
    
      pro_programacaoT = new Pro_programacaoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "pro_programacaoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
