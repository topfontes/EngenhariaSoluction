package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cli_clienteConsultJB extends SystemBase {

  // Atributos e propriedades
    private Cli_clienteT cli_clienteT = new Cli_clienteT();

  public void setCli_clienteT(Cli_clienteT cli_clienteT) {
    this.cli_clienteT = cli_clienteT;
  }

  public Cli_clienteT getCli_clienteT() {	
    return cli_clienteT;
  }


	
  private List<Cli_clienteT> list;

  public List<Cli_clienteT> getList() {
    return list;
  }
  
  public void setList(List<Cli_clienteT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
      list = cli_clienteDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
      cli_clienteDAO.delete(cli_clienteT);	 
      setMsg("Exclusão efetuada com sucesso!");
      cli_clienteT = new Cli_clienteT();
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
	  String page = "cli_clienteInsert.jsp";// defina aqui pagina que deve ser chamada
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
