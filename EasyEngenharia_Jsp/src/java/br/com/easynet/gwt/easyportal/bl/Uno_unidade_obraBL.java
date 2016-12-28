package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.database.DataSet;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Uno_unidade_obraBL  extends SystemBusinessBase {
 private Uno_unidade_obraT uno_unidade_obraT = new Uno_unidade_obraT();

  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Uno_unidade_obraDAO uno_unidade_obraDAO =  getUno_unidade_obraDAO();
      uno_unidade_obraDAO.insert(uno_unidade_obraT);	 
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
  public DataSet consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
      return uno_unidade_obraDAO.getAll(uno_unidade_obraT);
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
  public boolean delete(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(uno_unidade_obraT)) {
        Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
        uno_unidade_obraDAO.delete(uno_unidade_obraT);	 
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
  public boolean exist(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
   try {
	
      Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
      List<Uno_unidade_obraT> listTemp  = uno_unidade_obraDAO.getByPK(uno_unidade_obraT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alteração na tabela
   */	
  public boolean update(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(uno_unidade_obraT)) {
        Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
        uno_unidade_obraDAO.update(uno_unidade_obraT);	 
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
  public Uno_unidade_obraT findbyid(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
    try {
      Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
      List<Uno_unidade_obraT> listTemp  = uno_unidade_obraDAO.getByPK( uno_unidade_obraT);	 

      return listTemp.size()>0?listTemp.get(0):new Uno_unidade_obraT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }

    /**
     * @return the uno_unidade_obraT
     */
    public Uno_unidade_obraT getUno_unidade_obraT() {
        return uno_unidade_obraT;
    }

    /**
     * @param uno_unidade_obraT the uno_unidade_obraT to set
     */
    public void setUno_unidade_obraT(Uno_unidade_obraT uno_unidade_obraT) {
        this.uno_unidade_obraT = uno_unidade_obraT;
    }

}
