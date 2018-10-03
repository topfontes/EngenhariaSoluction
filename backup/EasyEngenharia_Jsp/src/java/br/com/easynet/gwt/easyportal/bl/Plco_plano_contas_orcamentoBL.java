package br.com.easynet.gwt.easyportal.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plco_plano_contas_orcamentoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO =  getPlco_plano_contas_orcamentoDAO();
      plco_plano_contas_orcamentoDAO.insert(plco_plano_contas_orcamentoT);	 
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
  public List<Plco_plano_contas_orcamentoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
      return plco_plano_contas_orcamentoDAO.getAll();	 
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
  public boolean delete(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(plco_plano_contas_orcamentoT)) {
        Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
        plco_plano_contas_orcamentoDAO.delete(plco_plano_contas_orcamentoT);	 
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
  public boolean exist(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
   try {
	
      Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
      List<Plco_plano_contas_orcamentoT> listTemp  = plco_plano_contas_orcamentoDAO.getByPK(plco_plano_contas_orcamentoT);	 

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
  public boolean update(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(plco_plano_contas_orcamentoT)) {
        Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
        plco_plano_contas_orcamentoDAO.update(plco_plano_contas_orcamentoT);	 
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
  public Plco_plano_contas_orcamentoT findbyid(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
    try {
      Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
      List<Plco_plano_contas_orcamentoT> listTemp  = plco_plano_contas_orcamentoDAO.getByPK( plco_plano_contas_orcamentoT);	 

      return listTemp.size()>0?listTemp.get(0):new Plco_plano_contas_orcamentoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
