package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Con_composicao_novaConsultJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Con_composicao_novaT con_composicao_novaT = new Con_composicao_novaT();

  public void setCon_composicao_novaT(Con_composicao_novaT con_composicao_novaT) {
    this.con_composicao_novaT = con_composicao_novaT;
  }

  public Con_composicao_novaT getCon_composicao_novaT() {	
    return con_composicao_novaT;
  }


	
  private List<Con_composicao_novaT> list;

  public List<Con_composicao_novaT> getList() {
    return list;
  }
  
  public void setList(List<Con_composicao_novaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
      list = con_composicao_novaDAO.getByCon_tx_descricao(con_composicao_novaT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();
      con_composicao_novaDAO.delete(con_composicao_novaT);	 
      setMsg("Exclusão efetuada com sucesso!");
      con_composicao_novaT = new Con_composicao_novaT();
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
	  String page = "con_composicao_novaInsert.jsp";// defina aqui a página que deve ser chamada  
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
