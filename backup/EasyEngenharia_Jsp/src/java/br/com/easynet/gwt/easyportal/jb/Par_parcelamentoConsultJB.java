package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Par_parcelamentoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Par_parcelamentoT par_parcelamentoT = new Par_parcelamentoT();

  public void setPar_parcelamentoT(Par_parcelamentoT par_parcelamentoT) {
    this.par_parcelamentoT = par_parcelamentoT;
  }

  public Par_parcelamentoT getPar_parcelamentoT() {	
    return par_parcelamentoT;
  }


	
  private List<Par_parcelamentoT> list;

  public List<Par_parcelamentoT> getList() {
    return list;
  }
  
  public void setList(List<Par_parcelamentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        //consult();
  }

  public void consult() throws Exception {
    try {
      Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
      list = par_parcelamentoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
      par_parcelamentoDAO.delete(par_parcelamentoT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      par_parcelamentoT = new Par_parcelamentoT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus�o!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "par_parcelamentoInsert.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
