package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_programacaoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Pro_programacaoT pro_programacaoT = new Pro_programacaoT();

  public void setPro_programacaoT(Pro_programacaoT pro_programacaoT) {
    this.pro_programacaoT = pro_programacaoT;
  }

  public Pro_programacaoT getPro_programacaoT() {	
    return pro_programacaoT;
  }


	
  private List<Pro_programacaoT> list;

  public List<Pro_programacaoT> getList() {
    return list;
  }
  
  public void setList(List<Pro_programacaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        //consult();
  }

  public void consult() throws Exception {
    try {
      Pro_programacaoDAO pro_programacaoDAO = getPro_programacaoDAO();
      list = pro_programacaoDAO.getByObr_nr_id(pro_programacaoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Pro_programacaoDAO pro_programacaoDAO = getPro_programacaoDAO();
      pro_programacaoDAO.delete(pro_programacaoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      pro_programacaoT = new Pro_programacaoT();
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
	  String page = "pro_programacaoInsert.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
