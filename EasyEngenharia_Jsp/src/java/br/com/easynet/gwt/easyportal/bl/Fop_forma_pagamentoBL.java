package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fop_forma_pagamentoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Fop_forma_pagamentoDAO fop_forma_pagamentoDAO =  getFop_forma_pagamentoDAO();
      fop_forma_pagamentoDAO.insert(fop_forma_pagamentoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Fop_forma_pagamentoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
      return fop_forma_pagamentoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }

  }  

  /**
   * Deletar um registro
   */	
  public boolean delete(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(fop_forma_pagamentoT)) {
        Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
        fop_forma_pagamentoDAO.delete(fop_forma_pagamentoT);	 
        return true;
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Verifica se o objeto existe na base
   */
  public boolean exist(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
   try {
	
      Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
      List<Fop_forma_pagamentoT> listTemp  = fop_forma_pagamentoDAO.getByPK(fop_forma_pagamentoT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alteracao na tabela
   */	
  public boolean update(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(fop_forma_pagamentoT)) {
        Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
        fop_forma_pagamentoDAO.update(fop_forma_pagamentoT);	 
	return true;        
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }   

  /**
   * Obtem os dados de um registro
   */	
  public Fop_forma_pagamentoT findbyid(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
    try {
      Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
      List<Fop_forma_pagamentoT> listTemp  = fop_forma_pagamentoDAO.getByPK( fop_forma_pagamentoT);	 

      return listTemp.size()>0?listTemp.get(0):new Fop_forma_pagamentoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
