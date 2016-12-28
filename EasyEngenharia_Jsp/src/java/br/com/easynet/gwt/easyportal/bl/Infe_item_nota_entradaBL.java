package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Infe_item_nota_entradaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Infe_item_nota_entradaDAO infe_item_nota_entradaDAO =  getInfe_item_nota_entradaDAO();
      infe_item_nota_entradaDAO.insert(infe_item_nota_entradaT);	 
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
  public List<Infe_item_nota_entradaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Infe_item_nota_entradaDAO infe_item_nota_entradaDAO = getInfe_item_nota_entradaDAO();
      return infe_item_nota_entradaDAO.getAll();	 
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
  public boolean delete(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(infe_item_nota_entradaT)) {
        Infe_item_nota_entradaDAO infe_item_nota_entradaDAO = getInfe_item_nota_entradaDAO();
        infe_item_nota_entradaDAO.delete(infe_item_nota_entradaT);	 
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
  public boolean exist(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception {
   try {
	
      Infe_item_nota_entradaDAO infe_item_nota_entradaDAO = getInfe_item_nota_entradaDAO();
      List<Infe_item_nota_entradaT> listTemp  = infe_item_nota_entradaDAO.getByPK(infe_item_nota_entradaT);	 

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
  public boolean update(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(infe_item_nota_entradaT)) {
        Infe_item_nota_entradaDAO infe_item_nota_entradaDAO = getInfe_item_nota_entradaDAO();
        infe_item_nota_entradaDAO.update(infe_item_nota_entradaT);	 
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
  public Infe_item_nota_entradaT findbyid(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception {
    try {
      Infe_item_nota_entradaDAO infe_item_nota_entradaDAO = getInfe_item_nota_entradaDAO();
      List<Infe_item_nota_entradaT> listTemp  = infe_item_nota_entradaDAO.getByPK( infe_item_nota_entradaT);	 

      return listTemp.size()>0?listTemp.get(0):new Infe_item_nota_entradaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
