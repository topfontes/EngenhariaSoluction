package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Inn_insumo_novoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Inn_insumo_novoDAO inn_insumo_novoDAO =  getInn_insumo_novoDAO();
      inn_insumo_novoDAO.insert(inn_insumo_novoT);	 
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
  public List<Inn_insumo_novoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
      return inn_insumo_novoDAO.getAll();	 
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
  public boolean delete(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(inn_insumo_novoT)) {
        Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
        inn_insumo_novoDAO.delete(inn_insumo_novoT);	 
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
  public boolean exist(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
   try {
	
      Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
      List<Inn_insumo_novoT> listTemp  = inn_insumo_novoDAO.getByPK(inn_insumo_novoT);	 

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
  public boolean update(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(inn_insumo_novoT)) {
        Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
        inn_insumo_novoDAO.update(inn_insumo_novoT);	 
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
  public Inn_insumo_novoT findbyid(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
    try {
      Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
      List<Inn_insumo_novoT> listTemp  = inn_insumo_novoDAO.getByPK( inn_insumo_novoT);	 

      return listTemp.size()>0?listTemp.get(0):new Inn_insumo_novoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
