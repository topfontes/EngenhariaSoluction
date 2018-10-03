package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Con_composicao_novaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Con_composicao_novaT con_composicao_novaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Con_composicao_novaDAO con_composicao_novaDAO =  getCon_composicao_novaDAO();
      con_composicao_novaDAO.insert(con_composicao_novaT);	 
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
  public List<Con_composicao_novaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
      return con_composicao_novaDAO.getAll();	 
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
  public boolean delete(Con_composicao_novaT con_composicao_novaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(con_composicao_novaT)) {
        Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
        con_composicao_novaDAO.delete(con_composicao_novaT);	 
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
  public boolean exist(Con_composicao_novaT con_composicao_novaT) throws Exception {
   try {
	
      Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
      List<Con_composicao_novaT> listTemp  = con_composicao_novaDAO.getByPK(con_composicao_novaT);	 

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
  public boolean update(Con_composicao_novaT con_composicao_novaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(con_composicao_novaT)) {
        Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
        con_composicao_novaDAO.update(con_composicao_novaT);	 
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
  public Con_composicao_novaT findbyid(Con_composicao_novaT con_composicao_novaT) throws Exception {
    try {
      Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
      List<Con_composicao_novaT> listTemp  = con_composicao_novaDAO.getByPK( con_composicao_novaT);	 

      return listTemp.size()>0?listTemp.get(0):new Con_composicao_novaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
