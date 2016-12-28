package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pms_planilha_medicao_servicoConsultJB extends SystemBase {

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
        consult();
  }

  public void consult() throws Exception {
    try {
      Pms_planilha_medicao_servicoDAO pms_planilha_medicao_servicoDAO = getPms_planilha_medicao_servicoDAO();
      list = pms_planilha_medicao_servicoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Pms_planilha_medicao_servicoDAO pms_planilha_medicao_servicoDAO = getPms_planilha_medicao_servicoDAO();
      pms_planilha_medicao_servicoDAO.delete(pms_planilha_medicao_servicoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      pms_planilha_medicao_servicoT = new Pms_planilha_medicao_servicoT();
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
	  String page = "pms_planilha_medicao_servicoInsert.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
