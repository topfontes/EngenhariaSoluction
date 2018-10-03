package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eplc_equivalencia_plano_contasInsertJB extends SystemBase {

  // Atributos e propriedades
    private Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT = new Eplc_equivalencia_plano_contasT();

  public void setEplc_equivalencia_plano_contasT(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) {
    this.eplc_equivalencia_plano_contasT = eplc_equivalencia_plano_contasT;
  }

  public Eplc_equivalencia_plano_contasT getEplc_equivalencia_plano_contasT() {	
    return eplc_equivalencia_plano_contasT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//

  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO =  getEplc_equivalencia_plano_contasDAO();
      eplc_equivalencia_plano_contasDAO.insert(eplc_equivalencia_plano_contasT);	 
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
	private List<Plc_plano_contasT> listplc_plano_contas;
	public List<Plc_plano_contasT> getListplc_plano_contas() {
		return listplc_plano_contas;
	}

	 public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
		this.listplc_plano_contas=list;
	}

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
    
      eplc_equivalencia_plano_contasT = new Eplc_equivalencia_plano_contasT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "eplc_equivalencia_plano_contasConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
