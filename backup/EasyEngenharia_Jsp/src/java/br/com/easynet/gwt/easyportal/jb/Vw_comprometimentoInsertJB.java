package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_comprometimentoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_comprometimentoT vw_comprometimentoT = new Vw_comprometimentoT();

  public void setVw_comprometimentoT(Vw_comprometimentoT vw_comprometimentoT) {
    this.vw_comprometimentoT = vw_comprometimentoT;
  }

  public Vw_comprometimentoT getVw_comprometimentoT() {	
    return vw_comprometimentoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    try {
      Vw_comprometimentoDAO vw_comprometimentoDAO =  getVw_comprometimentoDAO();
      vw_comprometimentoDAO.insert(vw_comprometimentoT);	 
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
    
      vw_comprometimentoT = new Vw_comprometimentoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_comprometimentoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
