package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ctpm_conta_pagar_modificadaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT = new Ctpm_conta_pagar_modificadaT();

  public void setCtpm_conta_pagar_modificadaT(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) {
    this.ctpm_conta_pagar_modificadaT = ctpm_conta_pagar_modificadaT;
  }

  public Ctpm_conta_pagar_modificadaT getCtpm_conta_pagar_modificadaT() {	
    return ctpm_conta_pagar_modificadaT;
  }


	
  private List<Ctpm_conta_pagar_modificadaT> list;

  public List<Ctpm_conta_pagar_modificadaT> getList() {
    return list;
  }
  
  public void setList(List<Ctpm_conta_pagar_modificadaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
      list = ctpm_conta_pagar_modificadaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
      ctpm_conta_pagar_modificadaDAO.delete(ctpm_conta_pagar_modificadaT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      ctpm_conta_pagar_modificadaT = new Ctpm_conta_pagar_modificadaT();
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
	  String page = "ctpm_conta_pagar_modificadaInsert.jsp";// defina aqui a página que deve ser chamada  
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
