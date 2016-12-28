package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_produtoConsultJB extends SystemBase {

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
  }

  public void consult() throws Exception {
    try {
      Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
      list = pro_produtoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
      pro_produtoDAO.delete(pro_produtoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      pro_produtoT = new Pro_produtoT();
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
	  String page = "pro_produtoInsert.jsp";// defina aqui a pagina que deve ser chamada
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
