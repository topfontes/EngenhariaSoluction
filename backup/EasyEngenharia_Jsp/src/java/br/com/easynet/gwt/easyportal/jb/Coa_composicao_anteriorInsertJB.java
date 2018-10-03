package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Coa_composicao_anteriorInsertJB extends SystemBase {

  // Atributos e propriedades
    private Coa_composicao_anteriorT coa_composicao_anteriorT = new Coa_composicao_anteriorT();

  public void setCoa_composicao_anteriorT(Coa_composicao_anteriorT coa_composicao_anteriorT) {
    this.coa_composicao_anteriorT = coa_composicao_anteriorT;
  }

  public Coa_composicao_anteriorT getCoa_composicao_anteriorT() {	
    return coa_composicao_anteriorT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Métodos de Eventos
  public void insert() throws Exception {
    
    try {
      Coa_composicao_anteriorDAO coa_composicao_anteriorDAO =  getCoa_composicao_anteriorDAO();
      coa_composicao_anteriorDAO.insert(coa_composicao_anteriorT);	 
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
    
      coa_composicao_anteriorT = new Coa_composicao_anteriorT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "coa_composicao_anteriorConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
