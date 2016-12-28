package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ort_orcamento_temporarioBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO =  getOrt_orcamento_temporarioDAO();
      ort_orcamento_temporarioDAO.insert(ort_orcamento_temporarioT);	 
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
  public List<Ort_orcamento_temporarioT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
      return ort_orcamento_temporarioDAO.getAll();	 
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
  public boolean delete(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ort_orcamento_temporarioT)) {
        Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
        ort_orcamento_temporarioDAO.delete(ort_orcamento_temporarioT);	 
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
  public boolean exist(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
   try {
	
      Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
      List<Ort_orcamento_temporarioT> listTemp  = ort_orcamento_temporarioDAO.getByPK(ort_orcamento_temporarioT);	 

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
  public boolean update(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ort_orcamento_temporarioT)) {
        Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
        ort_orcamento_temporarioDAO.update(ort_orcamento_temporarioT);	 
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
  public Ort_orcamento_temporarioT findbyid(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
    try {
      Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
      List<Ort_orcamento_temporarioT> listTemp  = ort_orcamento_temporarioDAO.getByPK( ort_orcamento_temporarioT);	 

      return listTemp.size()>0?listTemp.get(0):new Ort_orcamento_temporarioT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
