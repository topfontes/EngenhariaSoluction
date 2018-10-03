package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Grp_grupo_produtoConsultJB extends SystemBase {

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
        consult();
  }

  public void consult() throws Exception {
    try {
      Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
      list = grp_grupo_produtoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();
      grp_grupo_produtoDAO.delete(grp_grupo_produtoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      grp_grupo_produtoT = new Grp_grupo_produtoT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "grp_grupo_produtoInsert.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
