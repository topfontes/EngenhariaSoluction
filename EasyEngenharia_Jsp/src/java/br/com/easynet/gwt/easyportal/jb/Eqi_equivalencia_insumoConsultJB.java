package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqi_equivalencia_insumoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Eqi_equivalencia_insumoT eqi_equivalencia_insumoT = new Eqi_equivalencia_insumoT();

  public void setEqi_equivalencia_insumoT(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) {
    this.eqi_equivalencia_insumoT = eqi_equivalencia_insumoT;
  }

  public Eqi_equivalencia_insumoT getEqi_equivalencia_insumoT() {	
    return eqi_equivalencia_insumoT;
  }


	
  private List<Eqi_equivalencia_insumoT> list;

  public List<Eqi_equivalencia_insumoT> getList() {
    return list;
  }
  
  public void setList(List<Eqi_equivalencia_insumoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
      list = eqi_equivalencia_insumoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();
      eqi_equivalencia_insumoDAO.delete(eqi_equivalencia_insumoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      eqi_equivalencia_insumoT = new Eqi_equivalencia_insumoT();
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
	  String page = "eqi_equivalencia_insumoInsert.jsp";// defina aqui a página que deve ser chamada  
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
