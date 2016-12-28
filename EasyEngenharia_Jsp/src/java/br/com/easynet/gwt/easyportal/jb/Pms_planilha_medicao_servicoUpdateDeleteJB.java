package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pms_planilha_medicao_servicoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT = new Pms_planilha_medicao_servicoT();

  public void setPms_planilha_medicao_servicoT(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) {
    this.pms_planilha_medicao_servicoT = pms_planilha_medicao_servicoT;
  }

  public Pms_planilha_medicao_servicoT getPms_planilha_medicao_servicoT() {	
    return pms_planilha_medicao_servicoT;
  }

	
  private List<Pms_planilha_medicao_servicoT> list;

  public List<Pms_planilha_medicao_servicoT> getList() {
    return list;
  }
  
  public void setList(List<Pms_planilha_medicao_servicoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();

  }

  public void clear() throws Exception {
    
      pms_planilha_medicao_servicoT = new Pms_planilha_medicao_servicoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Pms_planilha_medicao_servicoDAO pms_planilha_medicao_servicoDAO = getPms_planilha_medicao_servicoDAO();
        pms_planilha_medicao_servicoDAO.delete(pms_planilha_medicao_servicoT);	 
        setMsg("Exclusão efetuada com sucesso!");
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
      Pms_planilha_medicao_servicoDAO pms_planilha_medicao_servicoDAO = getPms_planilha_medicao_servicoDAO();
      List<Pms_planilha_medicao_servicoT> listTemp  = pms_planilha_medicao_servicoDAO.getByPK( pms_planilha_medicao_servicoT);	 

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
        Pms_planilha_medicao_servicoDAO pms_planilha_medicao_servicoDAO = getPms_planilha_medicao_servicoDAO();
        pms_planilha_medicao_servicoDAO.update(pms_planilha_medicao_servicoT);	 
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
	private List<Obr_obrasT> listobr_obras;
	public List<Obr_obrasT> getListobr_obras() {
		return listobr_obras;
	}

	 public void setListobr_obras(List<Obr_obrasT> list) {
		this.listobr_obras=list;
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



  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Pms_planilha_medicao_servicoDAO pms_planilha_medicao_servicoDAO = getPms_planilha_medicao_servicoDAO();
      List<Pms_planilha_medicao_servicoT> listTemp  = pms_planilha_medicao_servicoDAO.getByPK( pms_planilha_medicao_servicoT);	 

      pms_planilha_medicao_servicoT= listTemp.size()>0?listTemp.get(0):new Pms_planilha_medicao_servicoT();
      
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
	  String page = "pms_planilha_medicao_servicoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "pms_planilha_medicao_servicoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
