package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Dso_descricao_servico_obraUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Dso_descricao_servico_obraT dso_descricao_servico_obraT = new Dso_descricao_servico_obraT();

  public void setDso_descricao_servico_obraT(Dso_descricao_servico_obraT dso_descricao_servico_obraT) {
    this.dso_descricao_servico_obraT = dso_descricao_servico_obraT;
  }

  public Dso_descricao_servico_obraT getDso_descricao_servico_obraT() {	
    return dso_descricao_servico_obraT;
  }

	
  private List<Dso_descricao_servico_obraT> list;

  public List<Dso_descricao_servico_obraT> getList() {
    return list;
  }
  
  public void setList(List<Dso_descricao_servico_obraT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPlco_plano_contas_orcamento();

  }

  public void clear() throws Exception {
    
      dso_descricao_servico_obraT = new Dso_descricao_servico_obraT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO = getDso_descricao_servico_obraDAO();
        dso_descricao_servico_obraDAO.delete(dso_descricao_servico_obraT);	 
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
      Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO = getDso_descricao_servico_obraDAO();
      List<Dso_descricao_servico_obraT> listTemp  = dso_descricao_servico_obraDAO.getByPK( dso_descricao_servico_obraT);	 

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
        Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO = getDso_descricao_servico_obraDAO();
        dso_descricao_servico_obraDAO.update(dso_descricao_servico_obraT);	 
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



  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO = getDso_descricao_servico_obraDAO();
      List<Dso_descricao_servico_obraT> listTemp  = dso_descricao_servico_obraDAO.getByPK( dso_descricao_servico_obraT);	 

      dso_descricao_servico_obraT= listTemp.size()>0?listTemp.get(0):new Dso_descricao_servico_obraT();
      
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
	  String page = "dso_descricao_servico_obraConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "dso_descricao_servico_obraConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
