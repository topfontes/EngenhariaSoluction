package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Nfe_nota_fiscal_entradaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT = new Nfe_nota_fiscal_entradaT();

  public void setNfe_nota_fiscal_entradaT(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) {
    this.nfe_nota_fiscal_entradaT = nfe_nota_fiscal_entradaT;
  }

  public Nfe_nota_fiscal_entradaT getNfe_nota_fiscal_entradaT() {	
    return nfe_nota_fiscal_entradaT;
  }


	
  private List<Nfe_nota_fiscal_entradaT> list;

  public List<Nfe_nota_fiscal_entradaT> getList() {
    return list;
  }
  
  public void setList(List<Nfe_nota_fiscal_entradaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
      list = nfe_nota_fiscal_entradaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
      nfe_nota_fiscal_entradaDAO.delete(nfe_nota_fiscal_entradaT);	 
      setMsg("Exclusão efetuada com sucesso!");
      nfe_nota_fiscal_entradaT = new Nfe_nota_fiscal_entradaT();
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
	  String page = "nfe_nota_fiscal_entradaInsert.jsp";// defina aqui a pagina que deve ser chamada
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
