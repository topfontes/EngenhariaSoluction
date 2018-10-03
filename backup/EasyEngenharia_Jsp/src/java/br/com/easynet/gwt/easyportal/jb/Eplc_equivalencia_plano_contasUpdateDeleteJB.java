package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eplc_equivalencia_plano_contasUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT = new Eplc_equivalencia_plano_contasT();

  public void setEplc_equivalencia_plano_contasT(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) {
    this.eplc_equivalencia_plano_contasT = eplc_equivalencia_plano_contasT;
  }

  public Eplc_equivalencia_plano_contasT getEplc_equivalencia_plano_contasT() {	
    return eplc_equivalencia_plano_contasT;
  }

	
  private List<Eplc_equivalencia_plano_contasT> list;

  public List<Eplc_equivalencia_plano_contasT> getList() {
    return list;
  }
  
  public void setList(List<Eplc_equivalencia_plano_contasT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPlc_plano_contas();

		consultPlco_plano_contas_orcamento();

  }

  public void clear() throws Exception {
    
      eplc_equivalencia_plano_contasT = new Eplc_equivalencia_plano_contasT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
        eplc_equivalencia_plano_contasDAO.delete(eplc_equivalencia_plano_contasT);	 
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
      Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
      List<Eplc_equivalencia_plano_contasT> listTemp  = eplc_equivalencia_plano_contasDAO.getByPK( eplc_equivalencia_plano_contasT);	 

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
        Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
        eplc_equivalencia_plano_contasDAO.update(eplc_equivalencia_plano_contasT);	 
        setMsg("Altera��o efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar altera��o!");	
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
	public void consultPlc_plano_contas() throws Exception {
		try {
			Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
//			listplc_plano_contas=plc_plano_contasDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
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



  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();
      List<Eplc_equivalencia_plano_contasT> listTemp  = eplc_equivalencia_plano_contasDAO.getByPK( eplc_equivalencia_plano_contasT);	 

      eplc_equivalencia_plano_contasT= listTemp.size()>0?listTemp.get(0):new Eplc_equivalencia_plano_contasT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p�gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "eplc_equivalencia_plano_contasConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "eplc_equivalencia_plano_contasConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
