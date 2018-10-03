package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fop_forma_pagamentoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Fop_forma_pagamentoT fop_forma_pagamentoT = new Fop_forma_pagamentoT();

  public void setFop_forma_pagamentoT(Fop_forma_pagamentoT fop_forma_pagamentoT) {
    this.fop_forma_pagamentoT = fop_forma_pagamentoT;
  }

  public Fop_forma_pagamentoT getFop_forma_pagamentoT() {	
    return fop_forma_pagamentoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Fop_forma_pagamentoDAO fop_forma_pagamentoDAO =  getFop_forma_pagamentoDAO();
      fop_forma_pagamentoDAO.insert(fop_forma_pagamentoT);	 
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
    
      fop_forma_pagamentoT = new Fop_forma_pagamentoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "fop_forma_pagamentoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
