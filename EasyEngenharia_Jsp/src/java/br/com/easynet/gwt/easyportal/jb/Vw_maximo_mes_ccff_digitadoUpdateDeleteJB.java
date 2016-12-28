package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_maximo_mes_ccff_digitadoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT = new Vw_maximo_mes_ccff_digitadoT();

  public void setVw_maximo_mes_ccff_digitadoT(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) {
    this.vw_maximo_mes_ccff_digitadoT = vw_maximo_mes_ccff_digitadoT;
  }

  public Vw_maximo_mes_ccff_digitadoT getVw_maximo_mes_ccff_digitadoT() {	
    return vw_maximo_mes_ccff_digitadoT;
  }

	
  private List<Vw_maximo_mes_ccff_digitadoT> list;

  public List<Vw_maximo_mes_ccff_digitadoT> getList() {
    return list;
  }
  
  public void setList(List<Vw_maximo_mes_ccff_digitadoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_maximo_mes_ccff_digitadoT = new Vw_maximo_mes_ccff_digitadoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_maximo_mes_ccff_digitadoDAO vw_maximo_mes_ccff_digitadoDAO = getVw_maximo_mes_ccff_digitadoDAO();
        vw_maximo_mes_ccff_digitadoDAO.delete(vw_maximo_mes_ccff_digitadoT);	 
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
      Vw_maximo_mes_ccff_digitadoDAO vw_maximo_mes_ccff_digitadoDAO = getVw_maximo_mes_ccff_digitadoDAO();
      List<Vw_maximo_mes_ccff_digitadoT> listTemp  = vw_maximo_mes_ccff_digitadoDAO.getByPK( vw_maximo_mes_ccff_digitadoT);	 

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
        Vw_maximo_mes_ccff_digitadoDAO vw_maximo_mes_ccff_digitadoDAO = getVw_maximo_mes_ccff_digitadoDAO();
        vw_maximo_mes_ccff_digitadoDAO.update(vw_maximo_mes_ccff_digitadoT);	 
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
      Vw_maximo_mes_ccff_digitadoDAO vw_maximo_mes_ccff_digitadoDAO = getVw_maximo_mes_ccff_digitadoDAO();
      List<Vw_maximo_mes_ccff_digitadoT> listTemp  = vw_maximo_mes_ccff_digitadoDAO.getByPK( vw_maximo_mes_ccff_digitadoT);	 

      vw_maximo_mes_ccff_digitadoT= listTemp.size()>0?listTemp.get(0):new Vw_maximo_mes_ccff_digitadoT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a página de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "vw_maximo_mes_ccff_digitadoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_maximo_mes_ccff_digitadoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
