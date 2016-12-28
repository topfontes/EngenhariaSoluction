package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Con_composicao_novaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Con_composicao_novaT con_composicao_novaT = new Con_composicao_novaT();

  public void setCon_composicao_novaT(Con_composicao_novaT con_composicao_novaT) {
    this.con_composicao_novaT = con_composicao_novaT;
  }

  public Con_composicao_novaT getCon_composicao_novaT() {	
    return con_composicao_novaT;
  }

	
  private List<Con_composicao_novaT> list;

  public List<Con_composicao_novaT> getList() {
    return list;
  }
  
  public void setList(List<Con_composicao_novaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      con_composicao_novaT = new Con_composicao_novaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
        con_composicao_novaDAO.delete(con_composicao_novaT);	 
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
      Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
      List<Con_composicao_novaT> listTemp  = con_composicao_novaDAO.getByPK( con_composicao_novaT);	 

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
        Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
        con_composicao_novaDAO.update(con_composicao_novaT);	 
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


  //Method Download Image e montando se houver algum campo do tipo binário
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
      List<Con_composicao_novaT> listTemp  = con_composicao_novaDAO.getByPK( con_composicao_novaT);	 

      con_composicao_novaT= listTemp.size()>0?listTemp.get(0):new Con_composicao_novaT();
      
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
	  String page = "con_composicao_novaConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "con_composicao_novaConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
