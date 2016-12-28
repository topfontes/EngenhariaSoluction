package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cffo_cronograma_fisico_financeiro_origenalUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();

  public void setCffo_cronograma_fisico_financeiro_origenalT(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) {
    this.cffo_cronograma_fisico_financeiro_origenalT = cffo_cronograma_fisico_financeiro_origenalT;
  }

  public Cffo_cronograma_fisico_financeiro_origenalT getCffo_cronograma_fisico_financeiro_origenalT() {	
    return cffo_cronograma_fisico_financeiro_origenalT;
  }

	
  private List<Cffo_cronograma_fisico_financeiro_origenalT> list;

  public List<Cffo_cronograma_fisico_financeiro_origenalT> getList() {
    return list;
  }
  
  public void setList(List<Cffo_cronograma_fisico_financeiro_origenalT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void clear() throws Exception {
    
      cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Cffo_cronograma_fisico_financeiro_origenalDAO cffo_cronograma_fisico_financeiro_origenalDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
        cffo_cronograma_fisico_financeiro_origenalDAO.delete(cffo_cronograma_fisico_financeiro_origenalT);	 
        setMsg("Exclus�o efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus�o!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Cffo_cronograma_fisico_financeiro_origenalDAO cffo_cronograma_fisico_financeiro_origenalDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
      List<Cffo_cronograma_fisico_financeiro_origenalT> listTemp  = cffo_cronograma_fisico_financeiro_origenalDAO.getByPK( cffo_cronograma_fisico_financeiro_origenalT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Cffo_cronograma_fisico_financeiro_origenalDAO cffo_cronograma_fisico_financeiro_origenalDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
        cffo_cronograma_fisico_financeiro_origenalDAO.update(cffo_cronograma_fisico_financeiro_origenalT);	 
        setMsg("alteração efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar alteração!");	
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

	private List<Obr_obrasT> listobr_obras;
	public List<Obr_obrasT> getListobr_obras() {
		return listobr_obras;
	}

	 public void setListobr_obras(List<Obr_obrasT> list) {
		this.listobr_obras=list;
	}

  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Cffo_cronograma_fisico_financeiro_origenalDAO cffo_cronograma_fisico_financeiro_origenalDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
      List<Cffo_cronograma_fisico_financeiro_origenalT> listTemp  = cffo_cronograma_fisico_financeiro_origenalDAO.getByPK( cffo_cronograma_fisico_financeiro_origenalT);	 

      cffo_cronograma_fisico_financeiro_origenalT= listTemp.size()>0?listTemp.get(0):new Cffo_cronograma_fisico_financeiro_origenalT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a página de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "cffo_cronograma_fisico_financeiro_origenalConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cffo_cronograma_fisico_financeiro_origenalConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
