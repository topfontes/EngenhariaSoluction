package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_equivalenciaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_equivalenciaT vw_equivalenciaT = new Vw_equivalenciaT();

  public void setVw_equivalenciaT(Vw_equivalenciaT vw_equivalenciaT) {
    this.vw_equivalenciaT = vw_equivalenciaT;
  }

  public Vw_equivalenciaT getVw_equivalenciaT() {	
    return vw_equivalenciaT;
  }

	
  private List<Vw_equivalenciaT> list;

  public List<Vw_equivalenciaT> getList() {
    return list;
  }
  
  public void setList(List<Vw_equivalenciaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_equivalenciaT = new Vw_equivalenciaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
        vw_equivalenciaDAO.delete(vw_equivalenciaT);	 
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
      Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
      List<Vw_equivalenciaT> listTemp  = vw_equivalenciaDAO.getByPK( vw_equivalenciaT);	 

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
        Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
        vw_equivalenciaDAO.update(vw_equivalenciaT);	 
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


  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
      List<Vw_equivalenciaT> listTemp  = vw_equivalenciaDAO.getByPK( vw_equivalenciaT);	 

      vw_equivalenciaT= listTemp.size()>0?listTemp.get(0):new Vw_equivalenciaT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a pagina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "vw_equivalenciaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_equivalenciaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
