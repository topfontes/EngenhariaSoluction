package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Est_estoqueBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Est_estoqueT est_estoqueT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Est_estoqueDAO est_estoqueDAO =  getEst_estoqueDAO();
      est_estoqueDAO.insert(est_estoqueT);	 
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
  public List<Est_estoqueT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
      return est_estoqueDAO.getAll();	 
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
  public boolean delete(Est_estoqueT est_estoqueT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(est_estoqueT)) {
        Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
        est_estoqueDAO.delete(est_estoqueT);	 
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
  public boolean exist(Est_estoqueT est_estoqueT) throws Exception {
   try {
	
      Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
      List<Est_estoqueT> listTemp  = est_estoqueDAO.getByPK(est_estoqueT);	 

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
  public boolean update(Est_estoqueT est_estoqueT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(est_estoqueT)) {
        Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
        est_estoqueDAO.update(est_estoqueT);	 
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
  public Est_estoqueT findbyid(Est_estoqueT est_estoqueT) throws Exception {
    try {
      Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
      List<Est_estoqueT> listTemp  = est_estoqueDAO.getByPK( est_estoqueT);	 

      return listTemp.size()>0?listTemp.get(0):new Est_estoqueT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
