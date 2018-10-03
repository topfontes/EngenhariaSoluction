package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.database.DataSet;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ctp_conta_pagarBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ctp_conta_pagarDAO ctp_conta_pagarDAO =  getCtp_conta_pagarDAO();
      ctp_conta_pagarDAO.insert(ctp_conta_pagarT);	 
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
  public DataSet consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
      return null;
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
  public boolean delete(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ctp_conta_pagarT)) {
        Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
        ctp_conta_pagarDAO.delete(ctp_conta_pagarT);	 
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
  public boolean exist(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
   try {
	
      Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
      List<Ctp_conta_pagarT> listTemp  = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);	 

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
  public boolean update(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ctp_conta_pagarT)) {
        Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
        ctp_conta_pagarDAO.update(ctp_conta_pagarT);	 
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
   * Obt�m os dados de um registro
   */	
  public Ctp_conta_pagarT findbyid(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
    try {
      Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
      List<Ctp_conta_pagarT> listTemp  = ctp_conta_pagarDAO.getByPK( ctp_conta_pagarT);	 

      return listTemp.size()>0?listTemp.get(0):new Ctp_conta_pagarT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
