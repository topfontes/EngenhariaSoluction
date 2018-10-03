package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Con_contatosBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Con_contatosT con_contatosT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Con_contatosDAO con_contatosDAO =  getCon_contatosDAO();
      con_contatosDAO.insert(con_contatosT);	 
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
  public List<Con_contatosT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Con_contatosDAO con_contatosDAO = getCon_contatosDAO();
      return con_contatosDAO.getAll();	 
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
  public boolean delete(Con_contatosT con_contatosT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(con_contatosT)) {
        Con_contatosDAO con_contatosDAO = getCon_contatosDAO();
        con_contatosDAO.delete(con_contatosT);	 
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
  public boolean exist(Con_contatosT con_contatosT) throws Exception {
   try {
	
      Con_contatosDAO con_contatosDAO = getCon_contatosDAO();
      List<Con_contatosT> listTemp  = con_contatosDAO.getByPK(con_contatosT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alteraçao na tabela
   */	
  public boolean update(Con_contatosT con_contatosT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(con_contatosT)) {
        Con_contatosDAO con_contatosDAO = getCon_contatosDAO();
        con_contatosDAO.update(con_contatosT);	 
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
  public Con_contatosT findbyid(Con_contatosT con_contatosT) throws Exception {
    try {
      Con_contatosDAO con_contatosDAO = getCon_contatosDAO();
      List<Con_contatosT> listTemp  = con_contatosDAO.getByPK( con_contatosT);	 

      return listTemp.size()>0?listTemp.get(0):new Con_contatosT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
