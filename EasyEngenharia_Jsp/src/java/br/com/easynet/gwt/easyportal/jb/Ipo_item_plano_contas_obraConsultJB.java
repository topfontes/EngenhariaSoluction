package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ipo_item_plano_contas_obraConsultJB extends SystemBase {

  // Atributos e propriedades
    private Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();

  public void setIpo_item_plano_contas_obraT(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) {
    this.ipo_item_plano_contas_obraT = ipo_item_plano_contas_obraT;
  }

  public Ipo_item_plano_contas_obraT getIpo_item_plano_contas_obraT() {	
    return ipo_item_plano_contas_obraT;
  }


	
  private List<Ipo_item_plano_contas_obraT> list;

  public List<Ipo_item_plano_contas_obraT> getList() {
    return list;
  }
  
  public void setList(List<Ipo_item_plano_contas_obraT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
      list = ipo_item_plano_contas_obraDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();
      ipo_item_plano_contas_obraDAO.delete(ipo_item_plano_contas_obraT);	 
      setMsg("Exclusão efetuada com sucesso!");
      ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();
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
	  String page = "ipo_item_plano_contas_obraInsert.jsp";// defina aqui a pagina que deve ser chamada
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
