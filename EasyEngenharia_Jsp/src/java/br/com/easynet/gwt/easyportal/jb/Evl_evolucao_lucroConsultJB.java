package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Evl_evolucao_lucroConsultJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Evl_evolucao_lucroT evl_evolucao_lucroT = new Evl_evolucao_lucroT();

  public void setEvl_evolucao_lucroT(Evl_evolucao_lucroT evl_evolucao_lucroT) {
    this.evl_evolucao_lucroT = evl_evolucao_lucroT;
  }

  public Evl_evolucao_lucroT getEvl_evolucao_lucroT() {	
    return evl_evolucao_lucroT;
  }


	
  private List<Evl_evolucao_lucroT> list;

  public List<Evl_evolucao_lucroT> getList() {
    return list;
  }
  
  public void setList(List<Evl_evolucao_lucroT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void consult() throws Exception {
    try {
      Evl_evolucao_lucroDAO evl_evolucao_lucroDAO = getEvl_evolucao_lucroDAO();
      list = evl_evolucao_lucroDAO.getAllObraMesAnoRef(evl_evolucao_lucroT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Evl_evolucao_lucroDAO evl_evolucao_lucroDAO = getEvl_evolucao_lucroDAO();
      evl_evolucao_lucroDAO.delete(evl_evolucao_lucroT);	 
      setMsg("Exclusao efetuada com sucesso!");
      evl_evolucao_lucroT = new Evl_evolucao_lucroT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "evl_evolucao_lucroInsert.jsp";// defina aqui a página que deve ser chamada  
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
