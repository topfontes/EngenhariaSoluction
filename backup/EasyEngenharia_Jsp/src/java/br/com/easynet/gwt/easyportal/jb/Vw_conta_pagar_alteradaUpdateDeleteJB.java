package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_conta_pagar_alteradaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT = new Vw_conta_pagar_alteradaT();

  public void setVw_conta_pagar_alteradaT(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) {
    this.vw_conta_pagar_alteradaT = vw_conta_pagar_alteradaT;
  }

  public Vw_conta_pagar_alteradaT getVw_conta_pagar_alteradaT() {	
    return vw_conta_pagar_alteradaT;
  }

	
  private List<Vw_conta_pagar_alteradaT> list;

  public List<Vw_conta_pagar_alteradaT> getList() {
    return list;
  }
  
  public void setList(List<Vw_conta_pagar_alteradaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_conta_pagar_alteradaT = new Vw_conta_pagar_alteradaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
        vw_conta_pagar_alteradaDAO.delete(vw_conta_pagar_alteradaT);	 
        setMsg("Exclusão efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
      List<Vw_conta_pagar_alteradaT> listTemp  = vw_conta_pagar_alteradaDAO.getByPK( vw_conta_pagar_alteradaT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
        vw_conta_pagar_alteradaDAO.update(vw_conta_pagar_alteradaT);	 
        setMsg("Alteração efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar alteração!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image é montando se houver algum campo do tipo binário
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
      List<Vw_conta_pagar_alteradaT> listTemp  = vw_conta_pagar_alteradaDAO.getByPK( vw_conta_pagar_alteradaT);	 

      vw_conta_pagar_alteradaT= listTemp.size()>0?listTemp.get(0):new Vw_conta_pagar_alteradaT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a página de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "vw_conta_pagar_alteradaConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_conta_pagar_alteradaConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
