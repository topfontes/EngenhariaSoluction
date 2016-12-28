package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Htf_horas_trabalha_folhaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT = new Htf_horas_trabalha_folhaT();

  public void setHtf_horas_trabalha_folhaT(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) {
    this.htf_horas_trabalha_folhaT = htf_horas_trabalha_folhaT;
  }

  public Htf_horas_trabalha_folhaT getHtf_horas_trabalha_folhaT() {	
    return htf_horas_trabalha_folhaT;
  }

	
  private List<Htf_horas_trabalha_folhaT> list;

  public List<Htf_horas_trabalha_folhaT> getList() {
    return list;
  }
  
  public void setList(List<Htf_horas_trabalha_folhaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();

  }

  public void clear() throws Exception {
    
      htf_horas_trabalha_folhaT = new Htf_horas_trabalha_folhaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Htf_horas_trabalha_folhaDAO htf_horas_trabalha_folhaDAO = getHtf_horas_trabalha_folhaDAO();
        htf_horas_trabalha_folhaDAO.delete(htf_horas_trabalha_folhaT);	 
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
      Htf_horas_trabalha_folhaDAO htf_horas_trabalha_folhaDAO = getHtf_horas_trabalha_folhaDAO();
      List<Htf_horas_trabalha_folhaT> listTemp  = htf_horas_trabalha_folhaDAO.getByPK( htf_horas_trabalha_folhaT);	 

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
        Htf_horas_trabalha_folhaDAO htf_horas_trabalha_folhaDAO = getHtf_horas_trabalha_folhaDAO();
        htf_horas_trabalha_folhaDAO.update(htf_horas_trabalha_folhaT);	 
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




  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Htf_horas_trabalha_folhaDAO htf_horas_trabalha_folhaDAO = getHtf_horas_trabalha_folhaDAO();
      List<Htf_horas_trabalha_folhaT> listTemp  = htf_horas_trabalha_folhaDAO.getByPK( htf_horas_trabalha_folhaT);	 

      htf_horas_trabalha_folhaT= listTemp.size()>0?listTemp.get(0):new Htf_horas_trabalha_folhaT();
      
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
	  String page = "htf_horas_trabalha_folhaConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "htf_horas_trabalha_folhaConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
