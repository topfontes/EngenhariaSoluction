package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Grp_grupo_produtoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Grp_grupo_produtoT grp_grupo_produtoT = new Grp_grupo_produtoT();

  public void setGrp_grupo_produtoT(Grp_grupo_produtoT grp_grupo_produtoT) {
    this.grp_grupo_produtoT = grp_grupo_produtoT;
  }

  public Grp_grupo_produtoT getGrp_grupo_produtoT() {	
    return grp_grupo_produtoT;
  }

	
  private List<Grp_grupo_produtoT> list;

  public List<Grp_grupo_produtoT> getList() {
    return list;
  }
  
  public void setList(List<Grp_grupo_produtoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      grp_grupo_produtoT = new Grp_grupo_produtoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
        grp_grupo_produtoDAO.delete(grp_grupo_produtoT);	 
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
      Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
      List<Grp_grupo_produtoT> listTemp  = grp_grupo_produtoDAO.getByPK( grp_grupo_produtoT);	 

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
        Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
        grp_grupo_produtoDAO.update(grp_grupo_produtoT);	 
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
      Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
      List<Grp_grupo_produtoT> listTemp  = grp_grupo_produtoDAO.getByPK( grp_grupo_produtoT);	 

      grp_grupo_produtoT= listTemp.size()>0?listTemp.get(0):new Grp_grupo_produtoT();
      
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
	  String page = "grp_grupo_produtoConsult.jsp";// defina aqui a paina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "grp_grupo_produtoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
