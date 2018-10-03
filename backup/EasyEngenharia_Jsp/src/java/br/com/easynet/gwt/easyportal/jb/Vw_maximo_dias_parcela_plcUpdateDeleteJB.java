package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_maximo_dias_parcela_plcUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT = new Vw_maximo_dias_parcela_plcT();

  public void setVw_maximo_dias_parcela_plcT(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) {
    this.vw_maximo_dias_parcela_plcT = vw_maximo_dias_parcela_plcT;
  }

  public Vw_maximo_dias_parcela_plcT getVw_maximo_dias_parcela_plcT() {	
    return vw_maximo_dias_parcela_plcT;
  }

	
  private List<Vw_maximo_dias_parcela_plcT> list;

  public List<Vw_maximo_dias_parcela_plcT> getList() {
    return list;
  }
  
  public void setList(List<Vw_maximo_dias_parcela_plcT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_maximo_dias_parcela_plcT = new Vw_maximo_dias_parcela_plcT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_maximo_dias_parcela_plcDAO vw_maximo_dias_parcela_plcDAO = getVw_maximo_dias_parcela_plcDAO();
        vw_maximo_dias_parcela_plcDAO.delete(vw_maximo_dias_parcela_plcT);	 
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
      Vw_maximo_dias_parcela_plcDAO vw_maximo_dias_parcela_plcDAO = getVw_maximo_dias_parcela_plcDAO();
      List<Vw_maximo_dias_parcela_plcT> listTemp  = vw_maximo_dias_parcela_plcDAO.getByPK( vw_maximo_dias_parcela_plcT);	 

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
        Vw_maximo_dias_parcela_plcDAO vw_maximo_dias_parcela_plcDAO = getVw_maximo_dias_parcela_plcDAO();
        vw_maximo_dias_parcela_plcDAO.update(vw_maximo_dias_parcela_plcT);	 
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
      Vw_maximo_dias_parcela_plcDAO vw_maximo_dias_parcela_plcDAO = getVw_maximo_dias_parcela_plcDAO();
      List<Vw_maximo_dias_parcela_plcT> listTemp  = vw_maximo_dias_parcela_plcDAO.getByPK( vw_maximo_dias_parcela_plcT);	 

      vw_maximo_dias_parcela_plcT= listTemp.size()>0?listTemp.get(0):new Vw_maximo_dias_parcela_plcT();
      
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
	  String page = "vw_maximo_dias_parcela_plcConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_maximo_dias_parcela_plcConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
