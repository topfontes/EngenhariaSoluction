package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pao_parcelamento_obraConsultJB extends SystemBase {

  // Atributos e propriedades
    private Pao_parcelamento_obraT pao_parcelamento_obraT = new Pao_parcelamento_obraT();

  public void setPao_parcelamento_obraT(Pao_parcelamento_obraT pao_parcelamento_obraT) {
    this.pao_parcelamento_obraT = pao_parcelamento_obraT;
  }

  public Pao_parcelamento_obraT getPao_parcelamento_obraT() {	
    return pao_parcelamento_obraT;
  }


	
  private List<Pao_parcelamento_obraT> list;

  public List<Pao_parcelamento_obraT> getList() {
    return list;
  }
  
  public void setList(List<Pao_parcelamento_obraT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Pao_parcelamento_obraDAO pao_parcelamento_obraDAO = getPao_parcelamento_obraDAO();
      list = pao_parcelamento_obraDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Pao_parcelamento_obraDAO pao_parcelamento_obraDAO = getPao_parcelamento_obraDAO();
      pao_parcelamento_obraDAO.delete(pao_parcelamento_obraT);	 
      setMsg("Exclusão efetuada com sucesso!");
      pao_parcelamento_obraT = new Pao_parcelamento_obraT();
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
	  String page = "pao_parcelamento_obraInsert.jsp";// defina aqui a pagina que deve ser chamada
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
