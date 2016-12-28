package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_produtoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Pro_produtoT pro_produtoT = new Pro_produtoT();

  public void setPro_produtoT(Pro_produtoT pro_produtoT) {
    this.pro_produtoT = pro_produtoT;
  }

  public Pro_produtoT getPro_produtoT() {	
    return pro_produtoT;
  }

	
  private List<Pro_produtoT> list;

  public List<Pro_produtoT> getList() {
    return list;
  }
  
  public void setList(List<Pro_produtoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultGrp_grupo_produto();

  }

  public void clear() throws Exception {
    
      pro_produtoT = new Pro_produtoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
        pro_produtoDAO.delete(pro_produtoT);	 
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
      Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
      List<Pro_produtoT> listTemp  = pro_produtoDAO.getByPK( pro_produtoT);	 

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
        Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
        pro_produtoDAO.update(pro_produtoT);	 
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
	private List<Grp_grupo_produtoT> listgrp_grupo_produto;
	public List<Grp_grupo_produtoT> getListgrp_grupo_produto() {
		return listgrp_grupo_produto;
	}

	 public void setListgrp_grupo_produto(List<Grp_grupo_produtoT> list) {
		this.listgrp_grupo_produto=list;
	}
	public void consultGrp_grupo_produto() throws Exception {
		try {
			Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
			listgrp_grupo_produto=grp_grupo_produtoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}



  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
      List<Pro_produtoT> listTemp  = pro_produtoDAO.getByPK( pro_produtoT);	 

      pro_produtoT= listTemp.size()>0?listTemp.get(0):new Pro_produtoT();
      
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
	  String page = "pro_produtoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "pro_produtoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
