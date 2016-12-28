package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Uni_unidadeBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Uni_unidadeT uni_unidadeT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Uni_unidadeDAO uni_unidadeDAO =  getUni_unidadeDAO();
      uni_unidadeDAO.insert(uni_unidadeT);	 
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
  public List<Uni_unidadeT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
      return uni_unidadeDAO.getAll();	 
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
  public boolean delete(Uni_unidadeT uni_unidadeT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(uni_unidadeT)) {
        Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
        uni_unidadeDAO.delete(uni_unidadeT);	 
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
  public boolean exist(Uni_unidadeT uni_unidadeT) throws Exception {
   try {
	
      Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
      List<Uni_unidadeT> listTemp  = uni_unidadeDAO.getByPK(uni_unidadeT);	 

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
  public boolean update(Uni_unidadeT uni_unidadeT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(uni_unidadeT)) {
        Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
        uni_unidadeDAO.update(uni_unidadeT);	 
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
  public Uni_unidadeT findbyid(Uni_unidadeT uni_unidadeT) throws Exception {
    try {
      Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
      List<Uni_unidadeT> listTemp  = uni_unidadeDAO.getByPK( uni_unidadeT);	 

      return listTemp.size()>0?listTemp.get(0):new Uni_unidadeT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
