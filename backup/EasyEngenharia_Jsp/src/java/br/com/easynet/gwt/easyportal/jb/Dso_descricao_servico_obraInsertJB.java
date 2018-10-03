package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Dso_descricao_servico_obraInsertJB extends SystemBase {

  // Atributos e propriedades
    private Dso_descricao_servico_obraT dso_descricao_servico_obraT = new Dso_descricao_servico_obraT();

  public void setDso_descricao_servico_obraT(Dso_descricao_servico_obraT dso_descricao_servico_obraT) {
    this.dso_descricao_servico_obraT = dso_descricao_servico_obraT;
  }

  public Dso_descricao_servico_obraT getDso_descricao_servico_obraT() {	
    return dso_descricao_servico_obraT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPlco_plano_contas_orcamento();

  }

  // Métodos de Eventos
  public void insert() throws Exception {
    
    try {
      Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO =  getDso_descricao_servico_obraDAO();
      dso_descricao_servico_obraDAO.insert(dso_descricao_servico_obraT);	 
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
	private List<Plco_plano_contas_orcamentoT> listplco_plano_contas_orcamento;
	public List<Plco_plano_contas_orcamentoT> getListplco_plano_contas_orcamento() {
		return listplco_plano_contas_orcamento;
	}

	 public void setListplco_plano_contas_orcamento(List<Plco_plano_contas_orcamentoT> list) {
		this.listplco_plano_contas_orcamento=list;
	}
	public void consultPlco_plano_contas_orcamento() throws Exception {
		try {
			Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
			listplco_plano_contas_orcamento=plco_plano_contas_orcamentoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      dso_descricao_servico_obraT = new Dso_descricao_servico_obraT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "dso_descricao_servico_obraConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
