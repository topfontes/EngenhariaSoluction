package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_insumo_plc_pmsUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_insumo_plc_pmsT vw_insumo_plc_pmsT = new Vw_insumo_plc_pmsT();

  public void setVw_insumo_plc_pmsT(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) {
    this.vw_insumo_plc_pmsT = vw_insumo_plc_pmsT;
  }

  public Vw_insumo_plc_pmsT getVw_insumo_plc_pmsT() {	
    return vw_insumo_plc_pmsT;
  }

	
  private List<Vw_insumo_plc_pmsT> list;

  public List<Vw_insumo_plc_pmsT> getList() {
    return list;
  }
  
  public void setList(List<Vw_insumo_plc_pmsT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_insumo_plc_pmsT = new Vw_insumo_plc_pmsT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_insumo_plc_pmsDAO vw_insumo_plc_pmsDAO = getVw_insumo_plc_pmsDAO();
        vw_insumo_plc_pmsDAO.delete(vw_insumo_plc_pmsT);	 
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
      Vw_insumo_plc_pmsDAO vw_insumo_plc_pmsDAO = getVw_insumo_plc_pmsDAO();
      List<Vw_insumo_plc_pmsT> listTemp  = vw_insumo_plc_pmsDAO.getByPK( vw_insumo_plc_pmsT);	 

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
        Vw_insumo_plc_pmsDAO vw_insumo_plc_pmsDAO = getVw_insumo_plc_pmsDAO();
        vw_insumo_plc_pmsDAO.update(vw_insumo_plc_pmsT);	 
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
      Vw_insumo_plc_pmsDAO vw_insumo_plc_pmsDAO = getVw_insumo_plc_pmsDAO();
      List<Vw_insumo_plc_pmsT> listTemp  = vw_insumo_plc_pmsDAO.getByPK( vw_insumo_plc_pmsT);	 

      vw_insumo_plc_pmsT= listTemp.size()>0?listTemp.get(0):new Vw_insumo_plc_pmsT();
      
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
	  String page = "vw_insumo_plc_pmsConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_insumo_plc_pmsConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
