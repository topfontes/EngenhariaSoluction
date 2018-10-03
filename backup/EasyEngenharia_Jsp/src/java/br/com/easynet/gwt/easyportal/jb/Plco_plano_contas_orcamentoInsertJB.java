package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plco_plano_contas_orcamentoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT = new Plco_plano_contas_orcamentoT();
    private int subClasse;
    private int id;

  public void setPlco_plano_contas_orcamentoT(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) {
    this.plco_plano_contas_orcamentoT = plco_plano_contas_orcamentoT;
  }

  public Plco_plano_contas_orcamentoT getPlco_plano_contas_orcamentoT() {	
    return plco_plano_contas_orcamentoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
      DAOFactory dao = null;
    try {

      Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO =  getPlco_plano_contas_orcamentoDAO();
      dao = plco_plano_contas_orcamentoDAO.getDAOFactory();
      dao.beginTransaction();
      //plco_plano_contas_orcamentoT.setPlco_tx_cod_externo("Fun.");
            setId(plco_plano_contas_orcamentoDAO.insert(plco_plano_contas_orcamentoT));
      //inserir Equivalencia
      Eplc_equivalencia_plano_contasT et = new Eplc_equivalencia_plano_contasT();
      et.setPlc_nr_id(subClasse);
      et.setPlco_nr_id(getId());
      Eplc_equivalencia_plano_contasDAO edao = getEplc_equivalencia_plano_contasDAO();
      edao.insert(et);
      dao.commitTransaction();
      setMsg("Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar cadastro!");
      dao.rollbackTransaction();
    } finally {
	close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      plco_plano_contas_orcamentoT = new Plco_plano_contas_orcamentoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "plco_plano_contas_orcamentoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the subClasse
     */
    public int getSubClasse() {
        return subClasse;
    }

    /**
     * @param subClasse the subClasse to set
     */
    public void setSubClasse(int subClasse) {
        this.subClasse = subClasse;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
