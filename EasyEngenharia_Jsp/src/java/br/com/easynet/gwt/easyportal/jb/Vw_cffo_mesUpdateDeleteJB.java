package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.client.dao.*;
import br.com.easynet.gwt.easyportal.client.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_cffo_mesUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_cffo_mesT vw_cffo_mesT = new Vw_cffo_mesT();

  public void setVw_cffo_mesT(Vw_cffo_mesT vw_cffo_mesT) {
    this.vw_cffo_mesT = vw_cffo_mesT;
  }

  public Vw_cffo_mesT getVw_cffo_mesT() {	
    return vw_cffo_mesT;
  }

	
  private List<Vw_cffo_mesT> list;

  public List<Vw_cffo_mesT> getList() {
    return list;
  }
  
  public void setList(List<Vw_cffo_mesT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_cffo_mesT = new Vw_cffo_mesT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_cffo_mesDAO vw_cffo_mesDAO = getVw_cffo_mesDAO();
        vw_cffo_mesDAO.delete(vw_cffo_mesT);	 
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
      Vw_cffo_mesDAO vw_cffo_mesDAO = getVw_cffo_mesDAO();
      List<Vw_cffo_mesT> listTemp  = vw_cffo_mesDAO.getByPK( vw_cffo_mesT);	 

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
        Vw_cffo_mesDAO vw_cffo_mesDAO = getVw_cffo_mesDAO();
        vw_cffo_mesDAO.update(vw_cffo_mesT);	 
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


  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Vw_cffo_mesDAO vw_cffo_mesDAO = getVw_cffo_mesDAO();
      List<Vw_cffo_mesT> listTemp  = vw_cffo_mesDAO.getByPK( vw_cffo_mesT);	 

      vw_cffo_mesT= listTemp.size()>0?listTemp.get(0):new Vw_cffo_mesT();
      
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
	  String page = "vw_cffo_mesConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_cffo_mesConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
