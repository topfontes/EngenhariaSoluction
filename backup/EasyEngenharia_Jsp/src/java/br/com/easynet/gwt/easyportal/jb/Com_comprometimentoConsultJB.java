package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Com_comprometimentoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Com_comprometimentoT com_comprometimentoT = new Com_comprometimentoT();
    

  public void setCom_comprometimentoT(Com_comprometimentoT com_comprometimentoT) {
    this.com_comprometimentoT = com_comprometimentoT;
  }

  public Com_comprometimentoT getCom_comprometimentoT() {	
    return com_comprometimentoT;
  }


	
  private List<Com_comprometimentoT> list;

  public List<Com_comprometimentoT> getList() {
    return list;
  }
  
  public void setList(List<Com_comprometimentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Com_comprometimentoDAO com_comprometimentoDAO = getCom_comprometimentoDAO();
      list = com_comprometimentoDAO.getAll(com_comprometimentoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Com_comprometimentoDAO com_comprometimentoDAO = getCom_comprometimentoDAO();
      com_comprometimentoDAO.delete(com_comprometimentoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      com_comprometimentoT = new Com_comprometimentoT();
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
	  String page = "com_comprometimentoInsert.jsp";// defina aqui a pagina que deve ser chamada
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
