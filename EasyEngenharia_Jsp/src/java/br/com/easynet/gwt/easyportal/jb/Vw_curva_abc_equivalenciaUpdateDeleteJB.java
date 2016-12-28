package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_curva_abc_equivalenciaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT = new Vw_curva_abc_equivalenciaT();

  public void setVw_curva_abc_equivalenciaT(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT) {
    this.vw_curva_abc_equivalenciaT = vw_curva_abc_equivalenciaT;
  }

  public Vw_curva_abc_equivalenciaT getVw_curva_abc_equivalenciaT() {	
    return vw_curva_abc_equivalenciaT;
  }

	
  private List<Vw_curva_abc_equivalenciaT> list;

  public List<Vw_curva_abc_equivalenciaT> getList() {
    return list;
  }
  
  public void setList(List<Vw_curva_abc_equivalenciaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_curva_abc_equivalenciaT = new Vw_curva_abc_equivalenciaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_curva_abc_equivalenciaDAO vw_curva_abc_equivalenciaDAO = getVw_curva_abc_equivalenciaDAO();
        vw_curva_abc_equivalenciaDAO.delete(vw_curva_abc_equivalenciaT);	 
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
      Vw_curva_abc_equivalenciaDAO vw_curva_abc_equivalenciaDAO = getVw_curva_abc_equivalenciaDAO();
      List<Vw_curva_abc_equivalenciaT> listTemp  = vw_curva_abc_equivalenciaDAO.getByPK( vw_curva_abc_equivalenciaT);	 

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
        Vw_curva_abc_equivalenciaDAO vw_curva_abc_equivalenciaDAO = getVw_curva_abc_equivalenciaDAO();
        vw_curva_abc_equivalenciaDAO.update(vw_curva_abc_equivalenciaT);	 
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
      Vw_curva_abc_equivalenciaDAO vw_curva_abc_equivalenciaDAO = getVw_curva_abc_equivalenciaDAO();
      List<Vw_curva_abc_equivalenciaT> listTemp  = vw_curva_abc_equivalenciaDAO.getByPK( vw_curva_abc_equivalenciaT);	 

      vw_curva_abc_equivalenciaT= listTemp.size()>0?listTemp.get(0):new Vw_curva_abc_equivalenciaT();
      
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
	  String page = "vw_curva_abc_equivalenciaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_curva_abc_equivalenciaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
