package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ccff_copia_cronograma_fisico_financeiroUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT = new Ccff_copia_cronograma_fisico_financeiroT();

  public void setCcff_copia_cronograma_fisico_financeiroT(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) {
    this.ccff_copia_cronograma_fisico_financeiroT = ccff_copia_cronograma_fisico_financeiroT;
  }

  public Ccff_copia_cronograma_fisico_financeiroT getCcff_copia_cronograma_fisico_financeiroT() {	
    return ccff_copia_cronograma_fisico_financeiroT;
  }

	
  private List<Ccff_copia_cronograma_fisico_financeiroT> list;

  public List<Ccff_copia_cronograma_fisico_financeiroT> getList() {
    return list;
  }
  
  public void setList(List<Ccff_copia_cronograma_fisico_financeiroT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultObr_obras();

		consultPlco_plano_contas_orcamento();

  }

  public void clear() throws Exception {
    
      ccff_copia_cronograma_fisico_financeiroT = new Ccff_copia_cronograma_fisico_financeiroT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Ccff_copia_cronograma_fisico_financeiroDAO ccff_copia_cronograma_fisico_financeiroDAO = getCcff_copia_cronograma_fisico_financeiroDAO();
        ccff_copia_cronograma_fisico_financeiroDAO.delete(ccff_copia_cronograma_fisico_financeiroT);	 
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
      Ccff_copia_cronograma_fisico_financeiroDAO ccff_copia_cronograma_fisico_financeiroDAO = getCcff_copia_cronograma_fisico_financeiroDAO();
      List<Ccff_copia_cronograma_fisico_financeiroT> listTemp  = ccff_copia_cronograma_fisico_financeiroDAO.getByPK( ccff_copia_cronograma_fisico_financeiroT);	 

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
        Ccff_copia_cronograma_fisico_financeiroDAO ccff_copia_cronograma_fisico_financeiroDAO = getCcff_copia_cronograma_fisico_financeiroDAO();
        ccff_copia_cronograma_fisico_financeiroDAO.update(ccff_copia_cronograma_fisico_financeiroT);	 
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



  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Ccff_copia_cronograma_fisico_financeiroDAO ccff_copia_cronograma_fisico_financeiroDAO = getCcff_copia_cronograma_fisico_financeiroDAO();
      List<Ccff_copia_cronograma_fisico_financeiroT> listTemp  = ccff_copia_cronograma_fisico_financeiroDAO.getByPK( ccff_copia_cronograma_fisico_financeiroT);	 

      ccff_copia_cronograma_fisico_financeiroT= listTemp.size()>0?listTemp.get(0):new Ccff_copia_cronograma_fisico_financeiroT();
      
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
	  String page = "ccff_copia_cronograma_fisico_financeiroConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ccff_copia_cronograma_fisico_financeiroConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
