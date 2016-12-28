package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Infe_item_nota_entradaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Infe_item_nota_entradaT infe_item_nota_entradaT = new Infe_item_nota_entradaT();

  public void setInfe_item_nota_entradaT(Infe_item_nota_entradaT infe_item_nota_entradaT) {
    this.infe_item_nota_entradaT = infe_item_nota_entradaT;
  }

  public Infe_item_nota_entradaT getInfe_item_nota_entradaT() {	
    return infe_item_nota_entradaT;
  }


	
  private List<Infe_item_nota_entradaT> list;

  public List<Infe_item_nota_entradaT> getList() {
    return list;
  }
  
  public void setList(List<Infe_item_nota_entradaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Infe_item_nota_entradaDAO infe_item_nota_entradaDAO = getInfe_item_nota_entradaDAO();
      list = infe_item_nota_entradaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Infe_item_nota_entradaDAO infe_item_nota_entradaDAO = getInfe_item_nota_entradaDAO();
      infe_item_nota_entradaDAO.delete(infe_item_nota_entradaT);	 
      setMsg("Exclusão efetuada com sucesso!");
      infe_item_nota_entradaT = new Infe_item_nota_entradaT();
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
	  String page = "infe_item_nota_entradaInsert.jsp";// defina aqui a pagina que deve ser chamada
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
