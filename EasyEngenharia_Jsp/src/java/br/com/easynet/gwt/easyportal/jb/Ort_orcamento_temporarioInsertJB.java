package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ort_orcamento_temporarioInsertJB extends SystemBase {

  // Atributos e propriedades
    private Ort_orcamento_temporarioT ort_orcamento_temporarioT = new Ort_orcamento_temporarioT();

  public void setOrt_orcamento_temporarioT(Ort_orcamento_temporarioT ort_orcamento_temporarioT) {
    this.ort_orcamento_temporarioT = ort_orcamento_temporarioT;
  }

  public Ort_orcamento_temporarioT getOrt_orcamento_temporarioT() {	
    return ort_orcamento_temporarioT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO =  getOrt_orcamento_temporarioDAO();
      ort_orcamento_temporarioDAO.insert(ort_orcamento_temporarioT);	 
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
    
      ort_orcamento_temporarioT = new Ort_orcamento_temporarioT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ort_orcamento_temporarioConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
