package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plc_plano_contasUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Plc_plano_contasT plc_plano_contasT = new Plc_plano_contasT();

  public void setPlc_plano_contasT(Plc_plano_contasT plc_plano_contasT) {
    this.plc_plano_contasT = plc_plano_contasT;
  }

  public Plc_plano_contasT getPlc_plano_contasT() {	
    return plc_plano_contasT;
  }

	
  private List<Plc_plano_contasT> list;

  public List<Plc_plano_contasT> getList() {
    return list;
  }
  
  public void setList(List<Plc_plano_contasT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      plc_plano_contasT = new Plc_plano_contasT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
        plc_plano_contasDAO.delete(plc_plano_contasT);	 
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
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      List<Plc_plano_contasT> listTemp  = plc_plano_contasDAO.getByPK( plc_plano_contasT);	 

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
        Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
        plc_plano_contasDAO.update(plc_plano_contasT);	 
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
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      List<Plc_plano_contasT> listTemp  = plc_plano_contasDAO.getByPK( plc_plano_contasT);	 

      plc_plano_contasT= listTemp.size()>0?listTemp.get(0):new Plc_plano_contasT();
      
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
	  String page = "plc_plano_contasConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "plc_plano_contasConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
