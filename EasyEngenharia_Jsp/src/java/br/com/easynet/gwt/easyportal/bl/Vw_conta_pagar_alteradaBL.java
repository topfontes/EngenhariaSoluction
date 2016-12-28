package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_conta_pagar_alteradaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO =  getVw_conta_pagar_alteradaDAO();
      vw_conta_pagar_alteradaDAO.insert(vw_conta_pagar_alteradaT);	 
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
  public List<Vw_conta_pagar_alteradaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
      return vw_conta_pagar_alteradaDAO.getAll(new Vw_conta_pagar_alteradaT());
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
  public boolean delete(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(vw_conta_pagar_alteradaT)) {
        Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
        vw_conta_pagar_alteradaDAO.delete(vw_conta_pagar_alteradaT);	 
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
  public boolean exist(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
   try {
	
      Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
      List<Vw_conta_pagar_alteradaT> listTemp  = vw_conta_pagar_alteradaDAO.getByPK(vw_conta_pagar_alteradaT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alteração na tabela
   */	
  public boolean update(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(vw_conta_pagar_alteradaT)) {
        Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
        vw_conta_pagar_alteradaDAO.update(vw_conta_pagar_alteradaT);	 
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
  public Vw_conta_pagar_alteradaT findbyid(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
    try {
      Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
      List<Vw_conta_pagar_alteradaT> listTemp  = vw_conta_pagar_alteradaDAO.getByPK( vw_conta_pagar_alteradaT);	 

      return listTemp.size()>0?listTemp.get(0):new Vw_conta_pagar_alteradaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
