package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plp_planilha_permutaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Plp_planilha_permutaT plp_planilha_permutaT = new Plp_planilha_permutaT();

  public void setPlp_planilha_permutaT(Plp_planilha_permutaT plp_planilha_permutaT) {
    this.plp_planilha_permutaT = plp_planilha_permutaT;
  }

  public Plp_planilha_permutaT getPlp_planilha_permutaT() {	
    return plp_planilha_permutaT;
  }


	
  private List<Plp_planilha_permutaT> list;

  public List<Plp_planilha_permutaT> getList() {
    return list;
  }
  
  public void setList(List<Plp_planilha_permutaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void consult() throws Exception {
    try {
      Plp_planilha_permutaDAO plp_planilha_permutaDAO = getPlp_planilha_permutaDAO();
      list = plp_planilha_permutaDAO.getAll(plp_planilha_permutaT);
      int qtde = plp_planilha_permutaDAO.getQtePermutadaAteperiodo(plp_planilha_permutaT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Plp_planilha_permutaDAO plp_planilha_permutaDAO = getPlp_planilha_permutaDAO();
      plp_planilha_permutaDAO.delete(plp_planilha_permutaT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      plp_planilha_permutaT = new Plp_planilha_permutaT();
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
	  String page = "plp_planilha_permutaInsert.jsp";// defina aqui a p�gina que deve ser chamada  
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
