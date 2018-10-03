package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.database.DataSet;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plc_plano_contasBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Plc_plano_contasT plc_plano_contasT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Plc_plano_contasDAO plc_plano_contasDAO =  getPlc_plano_contasDAO();
      plc_plano_contasDAO.insert(plc_plano_contasT);	 
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
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      return plc_plano_contasDAO.getAll();	 
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
  public boolean delete(Plc_plano_contasT plc_plano_contasT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(plc_plano_contasT)) {
        Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
        plc_plano_contasDAO.delete(plc_plano_contasT);	 
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
  public boolean exist(Plc_plano_contasT plc_plano_contasT) throws Exception {
   try {
	
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      List<Plc_plano_contasT> listTemp  = plc_plano_contasDAO.getByPK(plc_plano_contasT);	 

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
  public boolean update(Plc_plano_contasT plc_plano_contasT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(plc_plano_contasT)) {
        Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
        plc_plano_contasDAO.update(plc_plano_contasT);	 
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
  public Plc_plano_contasT findbyid(Plc_plano_contasT plc_plano_contasT) throws Exception {
    try {
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      List<Plc_plano_contasT> listTemp  = plc_plano_contasDAO.getByPK( plc_plano_contasT);	 

      return listTemp.size()>0?listTemp.get(0):new Plc_plano_contasT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
