package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_curva_abcUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_curva_abcT vw_curva_abcT = new Vw_curva_abcT();

  public void setVw_curva_abcT(Vw_curva_abcT vw_curva_abcT) {
    this.vw_curva_abcT = vw_curva_abcT;
  }

  public Vw_curva_abcT getVw_curva_abcT() {	
    return vw_curva_abcT;
  }

	
  private List<Vw_curva_abcT> list;

  public List<Vw_curva_abcT> getList() {
    return list;
  }
  
  public void setList(List<Vw_curva_abcT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_curva_abcT = new Vw_curva_abcT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_curva_abcDAO vw_curva_abcDAO = getVw_curva_abcDAO();
        vw_curva_abcDAO.delete(vw_curva_abcT);	 
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
      Vw_curva_abcDAO vw_curva_abcDAO = getVw_curva_abcDAO();
      List<Vw_curva_abcT> listTemp  = vw_curva_abcDAO.getByPK( vw_curva_abcT);	 

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
        Vw_curva_abcDAO vw_curva_abcDAO = getVw_curva_abcDAO();
        vw_curva_abcDAO.update(vw_curva_abcT);	 
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
      Vw_curva_abcDAO vw_curva_abcDAO = getVw_curva_abcDAO();
      List<Vw_curva_abcT> listTemp  = vw_curva_abcDAO.getByPK( vw_curva_abcT);	 

      vw_curva_abcT= listTemp.size()>0?listTemp.get(0):new Vw_curva_abcT();
      
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
	  String page = "vw_curva_abcConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_curva_abcConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
