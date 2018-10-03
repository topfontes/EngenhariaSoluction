package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Con_contatosConsultJB extends SystemBase {

  // Atributos e propriedades
    private Con_contatosT con_contatosT = new Con_contatosT();

  public void setCon_contatosT(Con_contatosT con_contatosT) {
    this.con_contatosT = con_contatosT;
  }

  public Con_contatosT getCon_contatosT() {	
    return con_contatosT;
  }


	
  private List<Con_contatosT> list;

  public List<Con_contatosT> getList() {
    return list;
  }
  
  public void setList(List<Con_contatosT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Con_contatosDAO con_contatosDAO = getCon_contatosDAO();
      list = con_contatosDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Con_contatosDAO con_contatosDAO = getCon_contatosDAO();
      con_contatosDAO.delete(con_contatosT);	 
      setMsg("Exclusão efetuada com sucesso!");
      con_contatosT = new Con_contatosT();
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
	  String page = "con_contatosInsert.jsp";// defina aqui a pagina que deve ser chamada
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
