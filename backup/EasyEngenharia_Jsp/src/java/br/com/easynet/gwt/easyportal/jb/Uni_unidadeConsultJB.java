package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Uni_unidadeConsultJB extends SystemBase {

  // Atributos e propriedades
    private Uni_unidadeT uni_unidadeT = new Uni_unidadeT();

  public void setUni_unidadeT(Uni_unidadeT uni_unidadeT) {
    this.uni_unidadeT = uni_unidadeT;
  }

  public Uni_unidadeT getUni_unidadeT() {	
    return uni_unidadeT;
  }


	
  private List<Uni_unidadeT> list;

  public List<Uni_unidadeT> getList() {
    return list;
  }
  
  public void setList(List<Uni_unidadeT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
      list = uni_unidadeDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
      uni_unidadeDAO.delete(uni_unidadeT);	 
      setMsg("Exclusão efetuada com sucesso!");
      uni_unidadeT = new Uni_unidadeT();
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
	  String page = "uni_unidadeInsert.jsp";// defina aqui a pagina que deve ser chamada
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
