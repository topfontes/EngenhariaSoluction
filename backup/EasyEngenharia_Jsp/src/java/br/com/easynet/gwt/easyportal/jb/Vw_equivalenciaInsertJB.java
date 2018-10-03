package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_equivalenciaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_equivalenciaT vw_equivalenciaT = new Vw_equivalenciaT();

  public void setVw_equivalenciaT(Vw_equivalenciaT vw_equivalenciaT) {
    this.vw_equivalenciaT = vw_equivalenciaT;
  }

  public Vw_equivalenciaT getVw_equivalenciaT() {	
    return vw_equivalenciaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_equivalenciaDAO vw_equivalenciaDAO =  getVw_equivalenciaDAO();
      vw_equivalenciaDAO.insert(vw_equivalenciaT);	 
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
    
      vw_equivalenciaT = new Vw_equivalenciaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_equivalenciaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
