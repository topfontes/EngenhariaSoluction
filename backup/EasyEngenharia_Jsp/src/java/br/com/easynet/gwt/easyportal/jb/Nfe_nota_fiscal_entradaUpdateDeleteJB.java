package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Nfe_nota_fiscal_entradaUpdateDeleteJB extends SystemBase {

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
	//
  }

  public void clear() throws Exception {
    
      nfe_nota_fiscal_entradaT = new Nfe_nota_fiscal_entradaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
        nfe_nota_fiscal_entradaDAO.delete(nfe_nota_fiscal_entradaT);	 
        setMsg("Exclusão efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
      List<Nfe_nota_fiscal_entradaT> listTemp  = nfe_nota_fiscal_entradaDAO.getByPK( nfe_nota_fiscal_entradaT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
        nfe_nota_fiscal_entradaDAO.update(nfe_nota_fiscal_entradaT);	 
        setMsg("Alteração efetuada com sucesso!");
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar alteração!");
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
      List<Nfe_nota_fiscal_entradaT> listTemp  = nfe_nota_fiscal_entradaDAO.getByPK( nfe_nota_fiscal_entradaT);	 

      nfe_nota_fiscal_entradaT= listTemp.size()>0?listTemp.get(0):new Nfe_nota_fiscal_entradaT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a pagina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "nfe_nota_fiscal_entradaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "nfe_nota_fiscal_entradaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
