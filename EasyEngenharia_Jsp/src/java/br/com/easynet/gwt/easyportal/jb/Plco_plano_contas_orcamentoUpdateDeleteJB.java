package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plco_plano_contas_orcamentoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT = new Plco_plano_contas_orcamentoT();
    private int subClasse;

  public void setPlco_plano_contas_orcamentoT(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) {
    this.plco_plano_contas_orcamentoT = plco_plano_contas_orcamentoT;
  }

  public Plco_plano_contas_orcamentoT getPlco_plano_contas_orcamentoT() {	
    return plco_plano_contas_orcamentoT;
  }

	
  private List<Plco_plano_contas_orcamentoT> list;

  public List<Plco_plano_contas_orcamentoT> getList() {
    return list;
  }
  
  public void setList(List<Plco_plano_contas_orcamentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      plco_plano_contas_orcamentoT = new Plco_plano_contas_orcamentoT();	
  }



  public void delete() throws Exception {
    try {
      if (exist()) {
        Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
        plco_plano_contas_orcamentoDAO.delete(plco_plano_contas_orcamentoT);	 
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
      Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
      List<Plco_plano_contas_orcamentoT> listTemp  = plco_plano_contas_orcamentoDAO.getByPK( plco_plano_contas_orcamentoT);	 

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
        Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
        plco_plano_contas_orcamentoDAO.update(plco_plano_contas_orcamentoT);

        Eplc_equivalencia_plano_contasDAO edao = getEplc_equivalencia_plano_contasDAO();
        Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT = new Eplc_equivalencia_plano_contasT();
        eplc_equivalencia_plano_contasT.setPlco_nr_id(plco_plano_contas_orcamentoT.getPlco_nr_id());
        eplc_equivalencia_plano_contasT.setPlc_nr_id(subClasse);
        edao.updateSubClasse(eplc_equivalencia_plano_contasT);
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


  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
      List<Plco_plano_contas_orcamentoT> listTemp  = plco_plano_contas_orcamentoDAO.getByPK( plco_plano_contas_orcamentoT);	 

      plco_plano_contas_orcamentoT= listTemp.size()>0?listTemp.get(0):new Plco_plano_contas_orcamentoT();
      
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
	  String page = "plco_plano_contas_orcamentoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
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

}
