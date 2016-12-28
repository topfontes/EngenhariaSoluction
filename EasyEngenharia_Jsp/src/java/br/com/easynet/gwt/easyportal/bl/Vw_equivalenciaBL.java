package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_equivalenciaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Vw_equivalenciaT vw_equivalenciaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Vw_equivalenciaDAO vw_equivalenciaDAO =  getVw_equivalenciaDAO();
      vw_equivalenciaDAO.insert(vw_equivalenciaT);	 
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
  public List<Vw_equivalenciaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
      return vw_equivalenciaDAO.getAll();	 
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
  public boolean delete(Vw_equivalenciaT vw_equivalenciaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(vw_equivalenciaT)) {
        Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
        vw_equivalenciaDAO.delete(vw_equivalenciaT);	 
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
  public boolean exist(Vw_equivalenciaT vw_equivalenciaT) throws Exception {
   try {
	
      Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
      List<Vw_equivalenciaT> listTemp  = vw_equivalenciaDAO.getByPK(vw_equivalenciaT);	 

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
  public boolean update(Vw_equivalenciaT vw_equivalenciaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(vw_equivalenciaT)) {
        Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
        vw_equivalenciaDAO.update(vw_equivalenciaT);	 
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
  public Vw_equivalenciaT findbyid(Vw_equivalenciaT vw_equivalenciaT) throws Exception {
    try {
      Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
      List<Vw_equivalenciaT> listTemp  = vw_equivalenciaDAO.getByPK( vw_equivalenciaT);	 

      return listTemp.size()>0?listTemp.get(0):new Vw_equivalenciaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
