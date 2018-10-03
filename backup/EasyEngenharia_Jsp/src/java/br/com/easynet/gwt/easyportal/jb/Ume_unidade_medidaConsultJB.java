package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ume_unidade_medidaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Ume_unidade_medidaT ume_unidade_medidaT = new Ume_unidade_medidaT();

  public void setUme_unidade_medidaT(Ume_unidade_medidaT ume_unidade_medidaT) {
    this.ume_unidade_medidaT = ume_unidade_medidaT;
  }

  public Ume_unidade_medidaT getUme_unidade_medidaT() {	
    return ume_unidade_medidaT;
  }


	
  private List<Ume_unidade_medidaT> list;

  public List<Ume_unidade_medidaT> getList() {
    return list;
  }
  
  public void setList(List<Ume_unidade_medidaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Ume_unidade_medidaDAO ume_unidade_medidaDAO = getUme_unidade_medidaDAO();
      list = ume_unidade_medidaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Ume_unidade_medidaDAO ume_unidade_medidaDAO = getUme_unidade_medidaDAO();
      ume_unidade_medidaDAO.delete(ume_unidade_medidaT);	 
      setMsg("Exclusão efetuada com sucesso!");
      ume_unidade_medidaT = new Ume_unidade_medidaT();
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
	  String page = "ume_unidade_medidaInsert.jsp";// defina aqui a pagina que deve ser chamada
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
