package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqi_equivalencia_insumoUpdateDeleteJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Eqi_equivalencia_insumoT eqi_equivalencia_insumoT = new Eqi_equivalencia_insumoT();

  public void setEqi_equivalencia_insumoT(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) {
    this.eqi_equivalencia_insumoT = eqi_equivalencia_insumoT;
  }

  public Eqi_equivalencia_insumoT getEqi_equivalencia_insumoT() {	
    return eqi_equivalencia_insumoT;
  }

	
  private List<Eqi_equivalencia_insumoT> list;

  public List<Eqi_equivalencia_insumoT> getList() {
    return list;
  }
  
  public void setList(List<Eqi_equivalencia_insumoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      eqi_equivalencia_insumoT = new Eqi_equivalencia_insumoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
        eqi_equivalencia_insumoDAO.delete(eqi_equivalencia_insumoT);	 
        setMsg("Exclus�o efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus�o!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
//      Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
//      List<Eqi_equivalencia_insumoT> listTemp  = eqi_equivalencia_insumoDAO.getByPK( eqi_equivalencia_insumoT);

      return true;
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
        Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
        eqi_equivalencia_insumoDAO.update(eqi_equivalencia_insumoT);	 
        setMsg("alteração efetuada com sucesso!");	
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
      Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
      List<Eqi_equivalencia_insumoT> listTemp  = eqi_equivalencia_insumoDAO.getByPK( eqi_equivalencia_insumoT);	 

      eqi_equivalencia_insumoT= listTemp.size()>0?listTemp.get(0):new Eqi_equivalencia_insumoT();
      
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
	  String page = "eqi_equivalencia_insumoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "eqi_equivalencia_insumoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
