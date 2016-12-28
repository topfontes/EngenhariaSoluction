package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pao_parcelamento_obraUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Pao_parcelamento_obraT pao_parcelamento_obraT = new Pao_parcelamento_obraT();

  public void setPao_parcelamento_obraT(Pao_parcelamento_obraT pao_parcelamento_obraT) {
    this.pao_parcelamento_obraT = pao_parcelamento_obraT;
  }

  public Pao_parcelamento_obraT getPao_parcelamento_obraT() {	
    return pao_parcelamento_obraT;
  }

	
  private List<Pao_parcelamento_obraT> list;

  public List<Pao_parcelamento_obraT> getList() {
    return list;
  }
  
  public void setList(List<Pao_parcelamento_obraT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//

  }

  public void clear() throws Exception {
    
      pao_parcelamento_obraT = new Pao_parcelamento_obraT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Pao_parcelamento_obraDAO pao_parcelamento_obraDAO = getPao_parcelamento_obraDAO();
        pao_parcelamento_obraDAO.delete(pao_parcelamento_obraT);	 
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
      Pao_parcelamento_obraDAO pao_parcelamento_obraDAO = getPao_parcelamento_obraDAO();
      List<Pao_parcelamento_obraT> listTemp  = pao_parcelamento_obraDAO.getByPK( pao_parcelamento_obraT);	 

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
        Pao_parcelamento_obraDAO pao_parcelamento_obraDAO = getPao_parcelamento_obraDAO();
        pao_parcelamento_obraDAO.update(pao_parcelamento_obraT);	 
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


	private List<Par_parcelamentoT> listpar_parcelamento;
	public List<Par_parcelamentoT> getListpar_parcelamento() {
		return listpar_parcelamento;
	}

	 public void setListpar_parcelamento(List<Par_parcelamentoT> list) {
		this.listpar_parcelamento=list;
	}
	public void consultPar_parcelamento() throws Exception {
		try {
			Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
			listpar_parcelamento=par_parcelamentoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	private List<Plc_plano_contasT> listplc_plano_contas;
	public List<Plc_plano_contasT> getListplc_plano_contas() {
		return listplc_plano_contas;
	}

	 public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
		this.listplc_plano_contas=list;
	}




  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Pao_parcelamento_obraDAO pao_parcelamento_obraDAO = getPao_parcelamento_obraDAO();
      List<Pao_parcelamento_obraT> listTemp  = pao_parcelamento_obraDAO.getByPK( pao_parcelamento_obraT);	 

      pao_parcelamento_obraT= listTemp.size()>0?listTemp.get(0):new Pao_parcelamento_obraT();
      
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
	  String page = "pao_parcelamento_obraConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "pao_parcelamento_obraConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
