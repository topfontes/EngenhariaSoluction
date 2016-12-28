package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fop_forma_pagamentoUpdateDeleteJB extends SystemBase {

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
	//
  }

  public void clear() throws Exception {
    
      fop_forma_pagamentoT = new Fop_forma_pagamentoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
        fop_forma_pagamentoDAO.delete(fop_forma_pagamentoT);	 
        setMsg("Exclus�o efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus�o!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
      List<Fop_forma_pagamentoT> listTemp  = fop_forma_pagamentoDAO.getByPK( fop_forma_pagamentoT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
        fop_forma_pagamentoDAO.update(fop_forma_pagamentoT);	 
        setMsg("alteração efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar alteração!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
      List<Fop_forma_pagamentoT> listTemp  = fop_forma_pagamentoDAO.getByPK( fop_forma_pagamentoT);	 

      fop_forma_pagamentoT= listTemp.size()>0?listTemp.get(0):new Fop_forma_pagamentoT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a página de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "fop_forma_pagamentoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "fop_forma_pagamentoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
