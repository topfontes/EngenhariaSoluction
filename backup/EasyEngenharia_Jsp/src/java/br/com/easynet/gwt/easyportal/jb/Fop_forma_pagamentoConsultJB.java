package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fop_forma_pagamentoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Fop_forma_pagamentoT fop_forma_pagamentoT = new Fop_forma_pagamentoT();

  public void setFop_forma_pagamentoT(Fop_forma_pagamentoT fop_forma_pagamentoT) {
    this.fop_forma_pagamentoT = fop_forma_pagamentoT;
  }

  public Fop_forma_pagamentoT getFop_forma_pagamentoT() {	
    return fop_forma_pagamentoT;
  }


	
  private List<Fop_forma_pagamentoT> list;

  public List<Fop_forma_pagamentoT> getList() {
    return list;
  }
  
  public void setList(List<Fop_forma_pagamentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
      list = fop_forma_pagamentoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
      fop_forma_pagamentoDAO.delete(fop_forma_pagamentoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      fop_forma_pagamentoT = new Fop_forma_pagamentoT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "fop_forma_pagamentoInsert.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
