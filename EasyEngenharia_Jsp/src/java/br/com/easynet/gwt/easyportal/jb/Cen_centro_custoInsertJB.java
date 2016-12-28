package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easylog.jb.INotLog;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Cen_centro_custoDAO;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cen_centro_custoInsertJB extends SystemBase implements INotSecurity, INotLog{

  // Atributos e propriedades
    private Cen_centro_custoT cen_centro_custoT = new Cen_centro_custoT();

  public void setCen_centro_custoT(Cen_centro_custoT cen_centro_custoT) {
    this.cen_centro_custoT = cen_centro_custoT;
  }

  public Cen_centro_custoT getCen_centro_custoT() {	
    return cen_centro_custoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    try {
      Cen_centro_custoDAO cen_centro_custoDAO =  getCen_centro_custoDAO();
      cen_centro_custoDAO.insert(cen_centro_custoT);
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
    
      cen_centro_custoT = new Cen_centro_custoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cen_centro_custoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
