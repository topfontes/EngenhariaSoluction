package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_maximo_mes_ccff_digitadoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT = new Vw_maximo_mes_ccff_digitadoT();

  public void setVw_maximo_mes_ccff_digitadoT(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) {
    this.vw_maximo_mes_ccff_digitadoT = vw_maximo_mes_ccff_digitadoT;
  }

  public Vw_maximo_mes_ccff_digitadoT getVw_maximo_mes_ccff_digitadoT() {	
    return vw_maximo_mes_ccff_digitadoT;
  }


	
  private List<Vw_maximo_mes_ccff_digitadoT> list;

  public List<Vw_maximo_mes_ccff_digitadoT> getList() {
    return list;
  }
  
  public void setList(List<Vw_maximo_mes_ccff_digitadoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Vw_maximo_mes_ccff_digitadoDAO vw_maximo_mes_ccff_digitadoDAO = getVw_maximo_mes_ccff_digitadoDAO();
      list = vw_maximo_mes_ccff_digitadoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Vw_maximo_mes_ccff_digitadoDAO vw_maximo_mes_ccff_digitadoDAO = getVw_maximo_mes_ccff_digitadoDAO();
      vw_maximo_mes_ccff_digitadoDAO.delete(vw_maximo_mes_ccff_digitadoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      vw_maximo_mes_ccff_digitadoT = new Vw_maximo_mes_ccff_digitadoT();
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
	  String page = "vw_maximo_mes_ccff_digitadoInsert.jsp";// defina aqui a pagina que deve ser chamada
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
