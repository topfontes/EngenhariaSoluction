package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqi_equivalencia_insumoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO =  getEqi_equivalencia_insumoDAO();
      eqi_equivalencia_insumoDAO.insert(eqi_equivalencia_insumoT);	 
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
  public List<Eqi_equivalencia_insumoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
      return eqi_equivalencia_insumoDAO.getAll();	 
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
  public boolean delete(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(eqi_equivalencia_insumoT)) {
        Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
        eqi_equivalencia_insumoDAO.delete(eqi_equivalencia_insumoT);	 
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
  public boolean exist(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
   try {
	
      Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
      List<Eqi_equivalencia_insumoT> listTemp  = eqi_equivalencia_insumoDAO.getByPK(eqi_equivalencia_insumoT);	 

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
  public boolean update(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(eqi_equivalencia_insumoT)) {
        Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
        eqi_equivalencia_insumoDAO.update(eqi_equivalencia_insumoT);	 
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
  public Eqi_equivalencia_insumoT findbyid(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
    try {
      Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
      List<Eqi_equivalencia_insumoT> listTemp  = eqi_equivalencia_insumoDAO.getByPK( eqi_equivalencia_insumoT);	 

      return listTemp.size()>0?listTemp.get(0):new Eqi_equivalencia_insumoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
