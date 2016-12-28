package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Par_parcelamentoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Par_parcelamentoT par_parcelamentoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Par_parcelamentoDAO par_parcelamentoDAO =  getPar_parcelamentoDAO();
      par_parcelamentoDAO.insert(par_parcelamentoT);	 
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
  public List<Par_parcelamentoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
      return par_parcelamentoDAO.getAll();	 
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
  public boolean delete(Par_parcelamentoT par_parcelamentoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(par_parcelamentoT)) {
        Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
        par_parcelamentoDAO.delete(par_parcelamentoT);	 
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
  public boolean exist(Par_parcelamentoT par_parcelamentoT) throws Exception {
   try {
	
      Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
      List<Par_parcelamentoT> listTemp  = par_parcelamentoDAO.getByPK(par_parcelamentoT);	 

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
  public boolean update(Par_parcelamentoT par_parcelamentoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(par_parcelamentoT)) {
        Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
        par_parcelamentoDAO.update(par_parcelamentoT);	 
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
  public Par_parcelamentoT findbyid(Par_parcelamentoT par_parcelamentoT) throws Exception {
    try {
      Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
      List<Par_parcelamentoT> listTemp  = par_parcelamentoDAO.getByPK( par_parcelamentoT);	 

      return listTemp.size()>0?listTemp.get(0):new Par_parcelamentoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
