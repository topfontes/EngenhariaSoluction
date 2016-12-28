package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tpms_temporaria_pmsInsertJB extends SystemBase {

  // Atributos e propriedades
    private Tpms_temporaria_pmsT tpms_temporaria_pmsT = new Tpms_temporaria_pmsT();

  public void setTpms_temporaria_pmsT(Tpms_temporaria_pmsT tpms_temporaria_pmsT) {
    this.tpms_temporaria_pmsT = tpms_temporaria_pmsT;
  }
  private float percentualMes;

  public Tpms_temporaria_pmsT getTpms_temporaria_pmsT() {	
    return tpms_temporaria_pmsT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPlco_plano_contas_orcamento();

  }

  // M�todos de Eventos
  public void insert() throws Exception {
      DAOFactory dAOFactory = null;
    try {
      Tpms_temporaria_pmsDAO tpms_temporaria_pmsDAO =  getTpms_temporaria_pmsDAO();
      dAOFactory = tpms_temporaria_pmsDAO.getDAOFactory();
      dAOFactory.beginTransaction();
      tpms_temporaria_pmsDAO.insert(tpms_temporaria_pmsT);
      addCopiaCronograma();
      setMsg("Cadastro efetuado com sucesso!");
      dAOFactory.commitTransaction();
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      dAOFactory.rollbackTransaction();
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
    
      tpms_temporaria_pmsT = new Tpms_temporaria_pmsT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tpms_temporaria_pmsConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    private void addCopiaCronograma() {
       
        
    }

    /**
     * @return the percentualMes
     */
    public float getPercentualMes() {
        return percentualMes;
    }

    /**
     * @param percentualMes the percentualMes to set
     */


}
