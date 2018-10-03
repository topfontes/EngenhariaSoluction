package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tet_tmp_equivalencia_treetBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO =  getTet_tmp_equivalencia_treetDAO();
      tet_tmp_equivalencia_treetDAO.insert(tet_tmp_equivalencia_treetT);	 
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
  public List<Tet_tmp_equivalencia_treetT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
      return tet_tmp_equivalencia_treetDAO.getAllPlco();
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
  public boolean delete(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tet_tmp_equivalencia_treetT)) {
        Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
        tet_tmp_equivalencia_treetDAO.delete(tet_tmp_equivalencia_treetT);	 
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
  public boolean exist(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception {
   try {
	
      Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
      List<Tet_tmp_equivalencia_treetT> listTemp  = tet_tmp_equivalencia_treetDAO.getByPK(tet_tmp_equivalencia_treetT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alterac�o na tabela
   */	
  public boolean update(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tet_tmp_equivalencia_treetT)) {
        Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
        tet_tmp_equivalencia_treetDAO.update(tet_tmp_equivalencia_treetT);	 
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
   * Obt�m os dados de um registro
   */	
  public Tet_tmp_equivalencia_treetT findbyid(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception {
    try {
      Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
      List<Tet_tmp_equivalencia_treetT> listTemp  = tet_tmp_equivalencia_treetDAO.getByPK( tet_tmp_equivalencia_treetT);	 

      return listTemp.size()>0?listTemp.get(0):new Tet_tmp_equivalencia_treetT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
