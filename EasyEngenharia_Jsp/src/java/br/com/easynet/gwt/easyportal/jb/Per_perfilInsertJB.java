package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.dao.Per_perfilDAO;
import br.com.easynet.easyportal.transfer.Per_perfilT;




/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Per_perfilInsertJB extends SystemBase {

  // Atributos e propriedades
    private Per_perfilT per_perfilT = new Per_perfilT();

  public void setPer_perfilT(Per_perfilT per_perfilT) {
    this.per_perfilT = per_perfilT;
  }

  public Per_perfilT getPer_perfilT() {	
    return per_perfilT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    Per_perfilDAO per_perfilDAO = null;
    try {
        per_perfilT.setPer_tx_status("A");
        per_perfilDAO =  getPer_perfilDAO();
        per_perfilDAO.insert(per_perfilT);
        setMsg("Cadastro efetuado com sucesso!");
          clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar cadastro!");	
    } finally {
	per_perfilDAO.close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      per_perfilT = new Per_perfilT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "per_perfilConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
