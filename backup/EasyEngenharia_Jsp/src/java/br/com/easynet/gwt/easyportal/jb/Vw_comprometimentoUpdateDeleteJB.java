package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_comprometimentoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_comprometimentoT vw_comprometimentoT = new Vw_comprometimentoT();

  public void setVw_comprometimentoT(Vw_comprometimentoT vw_comprometimentoT) {
    this.vw_comprometimentoT = vw_comprometimentoT;
  }

  public Vw_comprometimentoT getVw_comprometimentoT() {	
    return vw_comprometimentoT;
  }

	
  private List<Vw_comprometimentoT> list;

  public List<Vw_comprometimentoT> getList() {
    return list;
  }
  
  public void setList(List<Vw_comprometimentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_comprometimentoT = new Vw_comprometimentoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_comprometimentoDAO vw_comprometimentoDAO = getVw_comprometimentoDAO();
        vw_comprometimentoDAO.delete(vw_comprometimentoT);	 
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
      Vw_comprometimentoDAO vw_comprometimentoDAO = getVw_comprometimentoDAO();
      List<Vw_comprometimentoT> listTemp  = vw_comprometimentoDAO.getByPK( vw_comprometimentoT);	 

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
        Vw_comprometimentoDAO vw_comprometimentoDAO = getVw_comprometimentoDAO();
        vw_comprometimentoDAO.update(vw_comprometimentoT);	 
        setMsg("Altera��o efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar altera��o!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Vw_comprometimentoDAO vw_comprometimentoDAO = getVw_comprometimentoDAO();
      List<Vw_comprometimentoT> listTemp  = vw_comprometimentoDAO.getByPK( vw_comprometimentoT);	 

      vw_comprometimentoT= listTemp.size()>0?listTemp.get(0):new Vw_comprometimentoT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p�gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "vw_comprometimentoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_comprometimentoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
