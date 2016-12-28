package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ina_insumo_antigoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Ina_insumo_antigoT ina_insumo_antigoT = new Ina_insumo_antigoT();

  public void setIna_insumo_antigoT(Ina_insumo_antigoT ina_insumo_antigoT) {
    this.ina_insumo_antigoT = ina_insumo_antigoT;
  }

  public Ina_insumo_antigoT getIna_insumo_antigoT() {	
    return ina_insumo_antigoT;
  }

	
  private List<Ina_insumo_antigoT> list;

  public List<Ina_insumo_antigoT> getList() {
    return list;
  }
  
  public void setList(List<Ina_insumo_antigoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      ina_insumo_antigoT = new Ina_insumo_antigoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
        ina_insumo_antigoDAO.delete(ina_insumo_antigoT);	 
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
      Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
      List<Ina_insumo_antigoT> listTemp  = ina_insumo_antigoDAO.getByPK( ina_insumo_antigoT);	 

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
        Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
        ina_insumo_antigoDAO.update(ina_insumo_antigoT);	 
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
      Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
      List<Ina_insumo_antigoT> listTemp  = ina_insumo_antigoDAO.getByPK( ina_insumo_antigoT);	 

      ina_insumo_antigoT= listTemp.size()>0?listTemp.get(0):new Ina_insumo_antigoT();
      
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
	  String page = "ina_insumo_antigoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ina_insumo_antigoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
