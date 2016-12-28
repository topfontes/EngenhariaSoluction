package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_maximo_dias_parcela_plcConsultJB extends SystemBase {

  // Atributos e propriedades
    private Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT = new Vw_maximo_dias_parcela_plcT();

  public void setVw_maximo_dias_parcela_plcT(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) {
    this.vw_maximo_dias_parcela_plcT = vw_maximo_dias_parcela_plcT;
  }

  public Vw_maximo_dias_parcela_plcT getVw_maximo_dias_parcela_plcT() {	
    return vw_maximo_dias_parcela_plcT;
  }


	
  private List<Vw_maximo_dias_parcela_plcT> list;

  public List<Vw_maximo_dias_parcela_plcT> getList() {
    return list;
  }
  
  public void setList(List<Vw_maximo_dias_parcela_plcT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Vw_maximo_dias_parcela_plcDAO vw_maximo_dias_parcela_plcDAO = getVw_maximo_dias_parcela_plcDAO();
      list = vw_maximo_dias_parcela_plcDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Vw_maximo_dias_parcela_plcDAO vw_maximo_dias_parcela_plcDAO = getVw_maximo_dias_parcela_plcDAO();
      vw_maximo_dias_parcela_plcDAO.delete(vw_maximo_dias_parcela_plcT);	 
      setMsg("Exclusão efetuada com sucesso!");
      vw_maximo_dias_parcela_plcT = new Vw_maximo_dias_parcela_plcT();
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
	  String page = "vw_maximo_dias_parcela_plcInsert.jsp";// defina aqui a pagina que deve ser chamada
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
