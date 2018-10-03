package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cen_centro_custoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Cen_centro_custoT cen_centro_custoT = new Cen_centro_custoT();

  public void setCen_centro_custoT(Cen_centro_custoT cen_centro_custoT) {
    this.cen_centro_custoT = cen_centro_custoT;
  }

  public Cen_centro_custoT getCen_centro_custoT() {	
    return cen_centro_custoT;
  }

	
  private List<Cen_centro_custoT> list;

  public List<Cen_centro_custoT> getList() {
    return list;
  }
  
  public void setList(List<Cen_centro_custoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      cen_centro_custoT = new Cen_centro_custoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
        cen_centro_custoDAO.delete(cen_centro_custoT);	 
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
      Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
      List<Cen_centro_custoT> listTemp  = cen_centro_custoDAO.getByPK( cen_centro_custoT);	 

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
        Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
        cen_centro_custoDAO.update(cen_centro_custoT);	 
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


  //Method Download Image  montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();
      List<Cen_centro_custoT> listTemp  = cen_centro_custoDAO.getByPK( cen_centro_custoT);	 

      cen_centro_custoT= listTemp.size()>0?listTemp.get(0):new Cen_centro_custoT();
      
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
	  String page = "cen_centro_custoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cen_centro_custoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
