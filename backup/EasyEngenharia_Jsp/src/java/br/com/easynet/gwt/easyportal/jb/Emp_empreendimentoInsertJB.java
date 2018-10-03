package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Emp_empreendimentoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Emp_empreendimentoT emp_empreendimentoT = new Emp_empreendimentoT();

  public void setEmp_empreendimentoT(Emp_empreendimentoT emp_empreendimentoT) {
    this.emp_empreendimentoT = emp_empreendimentoT;
  }

  public Emp_empreendimentoT getEmp_empreendimentoT() {	
    return emp_empreendimentoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
      try {
      Emp_empreendimentoDAO emp_empreendimentoDAO =  getEmp_empreendimentoDAO();
      emp_empreendimentoDAO.insert(emp_empreendimentoT);	 
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


  
  public void clear() throws Exception {
    
      emp_empreendimentoT = new Emp_empreendimentoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "emp_empreendimentoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
