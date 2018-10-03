package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_conta_pagar_alteradaConsultJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT = new Vw_conta_pagar_alteradaT();

  public void setVw_conta_pagar_alteradaT(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) {
    this.vw_conta_pagar_alteradaT = vw_conta_pagar_alteradaT;
  }

  public Vw_conta_pagar_alteradaT getVw_conta_pagar_alteradaT() {	
    return vw_conta_pagar_alteradaT;
  }


	
  private List<Vw_conta_pagar_alteradaT> list;

  public List<Vw_conta_pagar_alteradaT> getList() {
    return list;
  }
  
  public void setList(List<Vw_conta_pagar_alteradaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void consult() throws Exception {
    try {
      Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
      list = vw_conta_pagar_alteradaDAO.getAll(vw_conta_pagar_alteradaT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
      vw_conta_pagar_alteradaDAO.delete(vw_conta_pagar_alteradaT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      vw_conta_pagar_alteradaT = new Vw_conta_pagar_alteradaT();
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
	  String page = "vw_conta_pagar_alteradaInsert.jsp";// defina aqui a p�gina que deve ser chamada  
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
