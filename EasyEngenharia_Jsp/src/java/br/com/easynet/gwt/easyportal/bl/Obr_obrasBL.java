package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.database.DataSet;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Obr_obrasBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Obr_obrasT obr_obrasT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Obr_obrasDAO obr_obrasDAO =  getObr_obrasDAO();
      obr_obrasDAO.insert(obr_obrasT);	 
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
      Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
      return obr_obrasDAO.getAll();	 
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
  public boolean delete(Obr_obrasT obr_obrasT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(obr_obrasT)) {
        Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
        obr_obrasDAO.delete(obr_obrasT);	 
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
  public boolean exist(Obr_obrasT obr_obrasT) throws Exception {
   try {
	
      Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
      List<Obr_obrasT> listTemp  = obr_obrasDAO.getByPK(obr_obrasT);	 

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
  public boolean update(Obr_obrasT obr_obrasT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(obr_obrasT)) {
        Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
        obr_obrasDAO.update(obr_obrasT);	 
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
  public Obr_obrasT findbyid(Obr_obrasT obr_obrasT) throws Exception {
    try {
      Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
      List<Obr_obrasT> listTemp  = obr_obrasDAO.getByPK( obr_obrasT);	 

      return listTemp.size()>0?listTemp.get(0):new Obr_obrasT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
