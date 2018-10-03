package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Emp_empreendimentoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Emp_empreendimentoDAO emp_empreendimentoDAO =  getEmp_empreendimentoDAO();
      emp_empreendimentoDAO.insert(emp_empreendimentoT);	 
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
  public List<Emp_empreendimentoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
      return emp_empreendimentoDAO.getAll();	 
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
  public boolean delete(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(emp_empreendimentoT)) {
        Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
        emp_empreendimentoDAO.delete(emp_empreendimentoT);	 
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
  public boolean exist(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
   try {
	
      Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
      List<Emp_empreendimentoT> listTemp  = emp_empreendimentoDAO.getByPK(emp_empreendimentoT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alteracao na tabela
   */	
  public boolean update(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(emp_empreendimentoT)) {
        Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
        emp_empreendimentoDAO.update(emp_empreendimentoT);	 
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
  public Emp_empreendimentoT findbyid(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
    try {
      Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
      List<Emp_empreendimentoT> listTemp  = emp_empreendimentoDAO.getByPK( emp_empreendimentoT);	 

      return listTemp.size()>0?listTemp.get(0):new Emp_empreendimentoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
