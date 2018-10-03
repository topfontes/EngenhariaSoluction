package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Con_contatosInsertJB extends SystemBase {

  // Atributos e propriedades
    private Con_contatosT con_contatosT = new Con_contatosT();

  public void setCon_contatosT(Con_contatosT con_contatosT) {
    this.con_contatosT = con_contatosT;
  }

  public Con_contatosT getCon_contatosT() {	
    return con_contatosT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultCli_cliente();

		consultSet_setor();

  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Con_contatosDAO con_contatosDAO =  getCon_contatosDAO();
      con_contatosDAO.insert(con_contatosT);	 
      setMsg("Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 
	private List<Cli_clienteT> listcli_cliente;
	public List<Cli_clienteT> getListcli_cliente() {
		return listcli_cliente;
	}

	 public void setListcli_cliente(List<Cli_clienteT> list) {
		this.listcli_cliente=list;
	}
	public void consultCli_cliente() throws Exception {
		try {
			Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
			listcli_cliente=cli_clienteDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	private List<Set_setorT> listset_setor;
	public List<Set_setorT> getListset_setor() {
		return listset_setor;
	}

	 public void setListset_setor(List<Set_setorT> list) {
		this.listset_setor=list;
	}
	public void consultSet_setor() throws Exception {
		try {
			Set_setorDAO set_setorDAO = getSet_setorDAO();
			listset_setor=set_setorDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      con_contatosT = new Con_contatosT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "con_contatosConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
