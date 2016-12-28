package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cli_clienteBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Cli_clienteT cli_clienteT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cli_clienteDAO cli_clienteDAO =  getCli_clienteDAO();
      cli_clienteDAO.insert(cli_clienteT);	 
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
  public List<Cli_clienteT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
      return cli_clienteDAO.getAll();	 
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
  public boolean delete(Cli_clienteT cli_clienteT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cli_clienteT)) {
        Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
        cli_clienteDAO.delete(cli_clienteT);	 
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
  public boolean exist(Cli_clienteT cli_clienteT) throws Exception {
   try {
	
      Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
      List<Cli_clienteT> listTemp  = cli_clienteDAO.getByPK(cli_clienteT);	 

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
  public boolean update(Cli_clienteT cli_clienteT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cli_clienteT)) {
        Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
        cli_clienteDAO.update(cli_clienteT);	 
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
  public Cli_clienteT findbyid(Cli_clienteT cli_clienteT) throws Exception {
    try {
      Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
      List<Cli_clienteT> listTemp  = cli_clienteDAO.getByPK( cli_clienteT);	 

      return listTemp.size()>0?listTemp.get(0):new Cli_clienteT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
