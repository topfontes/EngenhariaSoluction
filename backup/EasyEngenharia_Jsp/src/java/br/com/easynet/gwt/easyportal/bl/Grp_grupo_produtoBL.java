package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Grp_grupo_produtoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Grp_grupo_produtoT grp_grupo_produtoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Grp_grupo_produtoDAO grp_grupo_produtoDAO =  getGrp_grupo_produtoDAO();
      grp_grupo_produtoDAO.insert(grp_grupo_produtoT);	 
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
  public List<Grp_grupo_produtoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
      return grp_grupo_produtoDAO.getAll();	 
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
  public boolean delete(Grp_grupo_produtoT grp_grupo_produtoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(grp_grupo_produtoT)) {
        Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
        grp_grupo_produtoDAO.delete(grp_grupo_produtoT);	 
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
  public boolean exist(Grp_grupo_produtoT grp_grupo_produtoT) throws Exception {
   try {
	
      Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
      List<Grp_grupo_produtoT> listTemp  = grp_grupo_produtoDAO.getByPK(grp_grupo_produtoT);	 

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
  public boolean update(Grp_grupo_produtoT grp_grupo_produtoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(grp_grupo_produtoT)) {
        Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
        grp_grupo_produtoDAO.update(grp_grupo_produtoT);	 
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
  public Grp_grupo_produtoT findbyid(Grp_grupo_produtoT grp_grupo_produtoT) throws Exception {
    try {
      Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
      List<Grp_grupo_produtoT> listTemp  = grp_grupo_produtoDAO.getByPK( grp_grupo_produtoT);	 

      return listTemp.size()>0?listTemp.get(0):new Grp_grupo_produtoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
