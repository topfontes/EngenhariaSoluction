package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ina_insumo_antigoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ina_insumo_antigoDAO ina_insumo_antigoDAO =  getIna_insumo_antigoDAO();
      ina_insumo_antigoDAO.insert(ina_insumo_antigoT);	 
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
  public List<Ina_insumo_antigoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
      return ina_insumo_antigoDAO.getAll();	 
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
  public boolean delete(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ina_insumo_antigoT)) {
        Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
        ina_insumo_antigoDAO.delete(ina_insumo_antigoT);	 
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
  public boolean exist(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
   try {
	
      Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
      List<Ina_insumo_antigoT> listTemp  = ina_insumo_antigoDAO.getByPK(ina_insumo_antigoT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alteracão na tabela
   */	
  public boolean update(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ina_insumo_antigoT)) {
        Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
        ina_insumo_antigoDAO.update(ina_insumo_antigoT);	 
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
   * Obtém os dados de um registro
   */	
  public Ina_insumo_antigoT findbyid(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
    try {
      Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
      List<Ina_insumo_antigoT> listTemp  = ina_insumo_antigoDAO.getByPK( ina_insumo_antigoT);	 

      return listTemp.size()>0?listTemp.get(0):new Ina_insumo_antigoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
