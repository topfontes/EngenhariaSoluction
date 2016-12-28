package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqc_equivalencia_composicaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO =  getEqc_equivalencia_composicaoDAO();
      eqc_equivalencia_composicaoDAO.insert(eqc_equivalencia_composicaoT);	 
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
  public List<Eqc_equivalencia_composicaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
      return eqc_equivalencia_composicaoDAO.getAll();	 
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
  public boolean delete(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(eqc_equivalencia_composicaoT)) {
        Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
        eqc_equivalencia_composicaoDAO.delete(eqc_equivalencia_composicaoT);	 
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
  public boolean exist(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
   try {
	
      Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
      List<Eqc_equivalencia_composicaoT> listTemp  = eqc_equivalencia_composicaoDAO.getByPK(eqc_equivalencia_composicaoT);	 

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
  public boolean update(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(eqc_equivalencia_composicaoT)) {
        Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
        eqc_equivalencia_composicaoDAO.update(eqc_equivalencia_composicaoT);	 
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
  public Eqc_equivalencia_composicaoT findbyid(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
    try {
      Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
      List<Eqc_equivalencia_composicaoT> listTemp  = eqc_equivalencia_composicaoDAO.getByPK( eqc_equivalencia_composicaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Eqc_equivalencia_composicaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
