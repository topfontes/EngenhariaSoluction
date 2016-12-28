package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Htf_horas_trabalha_folhaConsultJB extends SystemBase {

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
        consult();
  }

  public void consult() throws Exception {
    try {
      Htf_horas_trabalha_folhaDAO htf_horas_trabalha_folhaDAO = getHtf_horas_trabalha_folhaDAO();
      list = htf_horas_trabalha_folhaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Htf_horas_trabalha_folhaDAO htf_horas_trabalha_folhaDAO = getHtf_horas_trabalha_folhaDAO();
      htf_horas_trabalha_folhaDAO.delete(htf_horas_trabalha_folhaT);	 
      setMsg("Exclusão efetuada com sucesso!");
      htf_horas_trabalha_folhaT = new Htf_horas_trabalha_folhaT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "htf_horas_trabalha_folhaInsert.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
