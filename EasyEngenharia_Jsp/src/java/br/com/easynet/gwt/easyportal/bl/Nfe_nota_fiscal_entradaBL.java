package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Nfe_nota_fiscal_entradaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO =  getNfe_nota_fiscal_entradaDAO();
      nfe_nota_fiscal_entradaDAO.insert(nfe_nota_fiscal_entradaT);	 
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
  public List<Nfe_nota_fiscal_entradaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
      return nfe_nota_fiscal_entradaDAO.getAll();	 
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
  public boolean delete(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(nfe_nota_fiscal_entradaT)) {
        Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
        nfe_nota_fiscal_entradaDAO.delete(nfe_nota_fiscal_entradaT);	 
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
  public boolean exist(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception {
   try {
	
      Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
      List<Nfe_nota_fiscal_entradaT> listTemp  = nfe_nota_fiscal_entradaDAO.getByPK(nfe_nota_fiscal_entradaT);	 

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
  public boolean update(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(nfe_nota_fiscal_entradaT)) {
        Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
        nfe_nota_fiscal_entradaDAO.update(nfe_nota_fiscal_entradaT);	 
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
  public Nfe_nota_fiscal_entradaT findbyid(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception {
    try {
      Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
      List<Nfe_nota_fiscal_entradaT> listTemp  = nfe_nota_fiscal_entradaDAO.getByPK( nfe_nota_fiscal_entradaT);	 

      return listTemp.size()>0?listTemp.get(0):new Nfe_nota_fiscal_entradaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
