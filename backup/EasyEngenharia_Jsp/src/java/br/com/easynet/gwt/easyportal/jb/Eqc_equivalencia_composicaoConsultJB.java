package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqc_equivalencia_composicaoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT = new Eqc_equivalencia_composicaoT();

  public void setEqc_equivalencia_composicaoT(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) {
    this.eqc_equivalencia_composicaoT = eqc_equivalencia_composicaoT;
  }

  public Eqc_equivalencia_composicaoT getEqc_equivalencia_composicaoT() {	
    return eqc_equivalencia_composicaoT;
  }


	
  private List<Eqc_equivalencia_composicaoT> list;

  public List<Eqc_equivalencia_composicaoT> getList() {
    return list;
  }
  
  public void setList(List<Eqc_equivalencia_composicaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
      list = eqc_equivalencia_composicaoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
      eqc_equivalencia_composicaoDAO.delete(eqc_equivalencia_composicaoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      eqc_equivalencia_composicaoT = new Eqc_equivalencia_composicaoT();
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
	  String page = "eqc_equivalencia_composicaoInsert.jsp";// defina aqui a página que deve ser chamada  
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
