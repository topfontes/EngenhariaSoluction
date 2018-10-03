package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ort_orcamento_temporarioConsultJB extends SystemBase {

  // Atributos e propriedades
    private Ort_orcamento_temporarioT ort_orcamento_temporarioT = new Ort_orcamento_temporarioT();

  public void setOrt_orcamento_temporarioT(Ort_orcamento_temporarioT ort_orcamento_temporarioT) {
    this.ort_orcamento_temporarioT = ort_orcamento_temporarioT;
  }

  public Ort_orcamento_temporarioT getOrt_orcamento_temporarioT() {	
    return ort_orcamento_temporarioT;
  }


	
  private List<Ort_orcamento_temporarioT> list;

  public List<Ort_orcamento_temporarioT> getList() {
    return list;
  }
  
  public void setList(List<Ort_orcamento_temporarioT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
      list = ort_orcamento_temporarioDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
      ort_orcamento_temporarioDAO.delete(ort_orcamento_temporarioT);	 
      setMsg("Exclusão efetuada com sucesso!");
      ort_orcamento_temporarioT = new Ort_orcamento_temporarioT();
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
	  String page = "ort_orcamento_temporarioInsert.jsp";// defina aqui a página que deve ser chamada  
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
