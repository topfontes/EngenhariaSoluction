package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ipo_item_plano_contas_obraUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();

  public void setIpo_item_plano_contas_obraT(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) {
    this.ipo_item_plano_contas_obraT = ipo_item_plano_contas_obraT;
  }

  public Ipo_item_plano_contas_obraT getIpo_item_plano_contas_obraT() {	
    return ipo_item_plano_contas_obraT;
  }

	
  private List<Ipo_item_plano_contas_obraT> list;

  public List<Ipo_item_plano_contas_obraT> getList() {
    return list;
  }
  
  public void setList(List<Ipo_item_plano_contas_obraT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultObr_obras();

		consultPlco_plano_contas_orcamento();

  }

  public void clear() throws Exception {
    
      ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
        ipo_item_plano_contas_obraDAO.delete(ipo_item_plano_contas_obraT);	 
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
      Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
      List<Ipo_item_plano_contas_obraT> listTemp  = ipo_item_plano_contas_obraDAO.getByPK( ipo_item_plano_contas_obraT);	 

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
        Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
        ipo_item_plano_contas_obraDAO.update(ipo_item_plano_contas_obraT);	 
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
	private List<Obr_obrasT> listobr_obras;
	public List<Obr_obrasT> getListobr_obras() {
		return listobr_obras;
	}

	 public void setListobr_obras(List<Obr_obrasT> list) {
		this.listobr_obras=list;
	}
	public void consultObr_obras() throws Exception {
		try {
			Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
//			listobr_obras=obr_obrasDAO.getAll();
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
      Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
      List<Ipo_item_plano_contas_obraT> listTemp  = ipo_item_plano_contas_obraDAO.getByPK( ipo_item_plano_contas_obraT);	 

      ipo_item_plano_contas_obraT= listTemp.size()>0?listTemp.get(0):new Ipo_item_plano_contas_obraT();
      
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
	  String page = "ipo_item_plano_contas_obraConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ipo_item_plano_contas_obraConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
