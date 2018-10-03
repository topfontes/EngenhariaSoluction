package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Coa_composicao_anteriorBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Coa_composicao_anteriorDAO coa_composicao_anteriorDAO =  getCoa_composicao_anteriorDAO();
      coa_composicao_anteriorDAO.insert(coa_composicao_anteriorT);	 
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
  public List<Coa_composicao_anteriorT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
      return coa_composicao_anteriorDAO.getAll();	 
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
  public boolean delete(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(coa_composicao_anteriorT)) {
        Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
        coa_composicao_anteriorDAO.delete(coa_composicao_anteriorT);	 
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
  public boolean exist(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
   try {
	
      Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
      List<Coa_composicao_anteriorT> listTemp  = coa_composicao_anteriorDAO.getByPK(coa_composicao_anteriorT);	 

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
  public boolean update(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(coa_composicao_anteriorT)) {
        Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
        coa_composicao_anteriorDAO.update(coa_composicao_anteriorT);	 
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
  public Coa_composicao_anteriorT findbyid(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
    try {
      Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
      List<Coa_composicao_anteriorT> listTemp  = coa_composicao_anteriorDAO.getByPK( coa_composicao_anteriorT);	 

      return listTemp.size()>0?listTemp.get(0):new Coa_composicao_anteriorT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
