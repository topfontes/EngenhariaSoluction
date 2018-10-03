package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cen_centro_custoBL  extends SystemBusinessBase {

  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Cen_centro_custoT cen_centro_custoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cen_centro_custoDAO cen_centro_custoDAO =  getCen_centro_custoDAO();
      cen_centro_custoDAO.insert(cen_centro_custoT);	 
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
  public List<Cen_centro_custoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
      return cen_centro_custoDAO.getAll();	 
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
  public boolean delete(Cen_centro_custoT cen_centro_custoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cen_centro_custoT)) {
        Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
        cen_centro_custoDAO.delete(cen_centro_custoT);	 
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
  public boolean exist(Cen_centro_custoT cen_centro_custoT) throws Exception {
   try {
	
      Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
      List<Cen_centro_custoT> listTemp  = cen_centro_custoDAO.getByPK(cen_centro_custoT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alterac�o na tabela
   */	
  public boolean update(Cen_centro_custoT cen_centro_custoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cen_centro_custoT)) {
        Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
        cen_centro_custoDAO.update(cen_centro_custoT);	 
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
  public Cen_centro_custoT findbyid(Cen_centro_custoT cen_centro_custoT) throws Exception {
    try {
      Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
      List<Cen_centro_custoT> listTemp  = cen_centro_custoDAO.getByPK( cen_centro_custoT);	 

      return listTemp.size()>0?listTemp.get(0):new Cen_centro_custoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
