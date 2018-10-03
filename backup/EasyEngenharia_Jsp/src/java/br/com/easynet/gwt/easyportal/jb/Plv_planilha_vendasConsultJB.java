package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plv_planilha_vendasConsultJB extends SystemBase {

  // Atributos e propriedades
    private Plv_planilha_vendasT plv_planilha_vendasT = new Plv_planilha_vendasT();

  public void setPlv_planilha_vendasT(Plv_planilha_vendasT plv_planilha_vendasT) {
    this.plv_planilha_vendasT = plv_planilha_vendasT;
  }

  public Plv_planilha_vendasT getPlv_planilha_vendasT() {	
    return plv_planilha_vendasT;
  }


	
  private List<Plv_planilha_vendasT> list;

  public List<Plv_planilha_vendasT> getList() {
    return list;
  }
  
  public void setList(List<Plv_planilha_vendasT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void consult() throws Exception {
    try {
      Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();
      list = plv_planilha_vendasDAO.getAll(plv_planilha_vendasT);
      //int  q = plv_planilha_vendasDAO.getQteVendaAteperiodoRealizada(plv_planilha_vendasT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();
      plv_planilha_vendasDAO.delete(plv_planilha_vendasT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      plv_planilha_vendasT = new Plv_planilha_vendasT();
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
	  String page = "plv_planilha_vendasInsert.jsp";// defina aqui a p�gina que deve ser chamada  
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
