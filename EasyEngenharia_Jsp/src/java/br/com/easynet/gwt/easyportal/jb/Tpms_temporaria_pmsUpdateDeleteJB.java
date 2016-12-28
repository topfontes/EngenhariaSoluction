package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tpms_temporaria_pmsUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Tpms_temporaria_pmsT tpms_temporaria_pmsT = new Tpms_temporaria_pmsT();

  public void setTpms_temporaria_pmsT(Tpms_temporaria_pmsT tpms_temporaria_pmsT) {
    this.tpms_temporaria_pmsT = tpms_temporaria_pmsT;
  }

  public Tpms_temporaria_pmsT getTpms_temporaria_pmsT() {	
    return tpms_temporaria_pmsT;
  }

	
  private List<Tpms_temporaria_pmsT> list;

  public List<Tpms_temporaria_pmsT> getList() {
    return list;
  }
  
  public void setList(List<Tpms_temporaria_pmsT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPlco_plano_contas_orcamento();

  }

  public void clear() throws Exception {
    
      tpms_temporaria_pmsT = new Tpms_temporaria_pmsT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Tpms_temporaria_pmsDAO tpms_temporaria_pmsDAO = getTpms_temporaria_pmsDAO();
        tpms_temporaria_pmsDAO.delete(tpms_temporaria_pmsT);	 
        setMsg("Exclusção efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Tpms_temporaria_pmsDAO tpms_temporaria_pmsDAO = getTpms_temporaria_pmsDAO();
      List<Tpms_temporaria_pmsT> listTemp  = tpms_temporaria_pmsDAO.getByPK( tpms_temporaria_pmsT);	 

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
        Tpms_temporaria_pmsDAO tpms_temporaria_pmsDAO = getTpms_temporaria_pmsDAO();
        tpms_temporaria_pmsDAO.update(tpms_temporaria_pmsT);	 
        setMsg("Alteração efetuada com sucesso!");
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



  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Tpms_temporaria_pmsDAO tpms_temporaria_pmsDAO = getTpms_temporaria_pmsDAO();
      List<Tpms_temporaria_pmsT> listTemp  = tpms_temporaria_pmsDAO.getByPK( tpms_temporaria_pmsT);	 

      tpms_temporaria_pmsT= listTemp.size()>0?listTemp.get(0):new Tpms_temporaria_pmsT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a pagina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "tpms_temporaria_pmsConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tpms_temporaria_pmsConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
