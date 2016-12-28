package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ipo_item_plano_contas_obraBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO =  getIpo_item_plano_contas_obraDAO();
      ipo_item_plano_contas_obraDAO.insert(ipo_item_plano_contas_obraT);	 
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
  public List<Ipo_item_plano_contas_obraT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
      return ipo_item_plano_contas_obraDAO.getAll();	 
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
  public boolean delete(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ipo_item_plano_contas_obraT)) {
        Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
        ipo_item_plano_contas_obraDAO.delete(ipo_item_plano_contas_obraT);	 
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
  public boolean exist(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
   try {
	
      Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
      List<Ipo_item_plano_contas_obraT> listTemp  = ipo_item_plano_contas_obraDAO.getByPK(ipo_item_plano_contas_obraT);	 

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
  public boolean update(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ipo_item_plano_contas_obraT)) {
        Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
        ipo_item_plano_contas_obraDAO.update(ipo_item_plano_contas_obraT);	 
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
  public Ipo_item_plano_contas_obraT findbyid(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
    try {
      Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
      List<Ipo_item_plano_contas_obraT> listTemp  = ipo_item_plano_contas_obraDAO.getByPK( ipo_item_plano_contas_obraT);	 

      return listTemp.size()>0?listTemp.get(0):new Ipo_item_plano_contas_obraT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
