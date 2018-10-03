package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_produtoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Pro_produtoT pro_produtoT = new Pro_produtoT();

  public void setPro_produtoT(Pro_produtoT pro_produtoT) {
    this.pro_produtoT = pro_produtoT;
  }

  public Pro_produtoT getPro_produtoT() {	
    return pro_produtoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultGrp_grupo_produto();

  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Pro_produtoDAO pro_produtoDAO =  getPro_produtoDAO();
      pro_produtoDAO.insert(pro_produtoT);	 
      setMsg("Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar cadastro!");	
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


  
  public void clear() throws Exception {
    
      pro_produtoT = new Pro_produtoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "pro_produtoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
