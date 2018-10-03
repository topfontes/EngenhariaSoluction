package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fol_folha_pagamentoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Fol_folha_pagamentoT fol_folha_pagamentoT = new Fol_folha_pagamentoT();

  public void setFol_folha_pagamentoT(Fol_folha_pagamentoT fol_folha_pagamentoT) {
    this.fol_folha_pagamentoT = fol_folha_pagamentoT;
  }

  public Fol_folha_pagamentoT getFol_folha_pagamentoT() {	
    return fol_folha_pagamentoT;
  }

	
  private List<Fol_folha_pagamentoT> list;

  public List<Fol_folha_pagamentoT> getList() {
    return list;
  }
  
  public void setList(List<Fol_folha_pagamentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();

  }

  public void clear() throws Exception {
    
      fol_folha_pagamentoT = new Fol_folha_pagamentoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Fol_folha_pagamentoDAO fol_folha_pagamentoDAO = getFol_folha_pagamentoDAO();
        fol_folha_pagamentoDAO.delete(fol_folha_pagamentoT);	 
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
      Fol_folha_pagamentoDAO fol_folha_pagamentoDAO = getFol_folha_pagamentoDAO();
      List<Fol_folha_pagamentoT> listTemp  = fol_folha_pagamentoDAO.getByPK( fol_folha_pagamentoT);	 

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
        Fol_folha_pagamentoDAO fol_folha_pagamentoDAO = getFol_folha_pagamentoDAO();
        fol_folha_pagamentoDAO.update(fol_folha_pagamentoT);	 
        setMsg("Altera��o efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar altera��o!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 
	private List<Obr_obrasT> listobr_obras;
	public List<Obr_obrasT> getListobr_obras() {
		return listobr_obras;
	}

	 public void setListobr_obras(List<Obr_obrasT> list) {
		this.listobr_obras=list;
	}

	private List<Plc_plano_contasT> listplc_plano_contas;
	public List<Plc_plano_contasT> getListplc_plano_contas() {
		return listplc_plano_contas;
	}

	 public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
		this.listplc_plano_contas=list;
	}




  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 

  public void findbyid() throws Exception {
    try {
      Fol_folha_pagamentoDAO fol_folha_pagamentoDAO = getFol_folha_pagamentoDAO();
      List<Fol_folha_pagamentoT> listTemp  = fol_folha_pagamentoDAO.getByPK( fol_folha_pagamentoT);	 

      fol_folha_pagamentoT= listTemp.size()>0?listTemp.get(0):new Fol_folha_pagamentoT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p�gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "fol_folha_pagamentoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "fol_folha_pagamentoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
