package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eplc_equivalencia_plano_contasBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO =  getEplc_equivalencia_plano_contasDAO();
      eplc_equivalencia_plano_contasDAO.insert(eplc_equivalencia_plano_contasT);	 
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
  public List<Eplc_equivalencia_plano_contasT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
      return eplc_equivalencia_plano_contasDAO.getAll();	 
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
  public boolean delete(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(eplc_equivalencia_plano_contasT)) {
        Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
        eplc_equivalencia_plano_contasDAO.delete(eplc_equivalencia_plano_contasT);	 
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
  public boolean exist(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception {
   try {
	
      Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
      List<Eplc_equivalencia_plano_contasT> listTemp  = eplc_equivalencia_plano_contasDAO.getByPK(eplc_equivalencia_plano_contasT);	 

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
  public boolean update(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(eplc_equivalencia_plano_contasT)) {
        Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
        eplc_equivalencia_plano_contasDAO.update(eplc_equivalencia_plano_contasT);	 
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
  public Eplc_equivalencia_plano_contasT findbyid(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception {
    try {
      Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
      List<Eplc_equivalencia_plano_contasT> listTemp  = eplc_equivalencia_plano_contasDAO.getByPK( eplc_equivalencia_plano_contasT);	 

      return listTemp.size()>0?listTemp.get(0):new Eplc_equivalencia_plano_contasT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
