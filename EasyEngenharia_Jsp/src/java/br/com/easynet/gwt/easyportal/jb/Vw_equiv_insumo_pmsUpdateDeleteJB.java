package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_equiv_insumo_pmsUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT = new Vw_equiv_insumo_pmsT();

  public void setVw_equiv_insumo_pmsT(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) {
    this.vw_equiv_insumo_pmsT = vw_equiv_insumo_pmsT;
  }

  public Vw_equiv_insumo_pmsT getVw_equiv_insumo_pmsT() {	
    return vw_equiv_insumo_pmsT;
  }

	
  private List<Vw_equiv_insumo_pmsT> list;

  public List<Vw_equiv_insumo_pmsT> getList() {
    return list;
  }
  
  public void setList(List<Vw_equiv_insumo_pmsT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_equiv_insumo_pmsT = new Vw_equiv_insumo_pmsT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_equiv_insumo_pmsDAO vw_equiv_insumo_pmsDAO = getVw_equiv_insumo_pmsDAO();
        vw_equiv_insumo_pmsDAO.delete(vw_equiv_insumo_pmsT);	 
        setMsg("Exclusao efetuada com sucesso!");
        clear();
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Vw_equiv_insumo_pmsDAO vw_equiv_insumo_pmsDAO = getVw_equiv_insumo_pmsDAO();
      List<Vw_equiv_insumo_pmsT> listTemp  = vw_equiv_insumo_pmsDAO.getByPK( vw_equiv_insumo_pmsT);	 

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
        Vw_equiv_insumo_pmsDAO vw_equiv_insumo_pmsDAO = getVw_equiv_insumo_pmsDAO();
        vw_equiv_insumo_pmsDAO.update(vw_equiv_insumo_pmsT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Vw_equiv_insumo_pmsDAO vw_equiv_insumo_pmsDAO = getVw_equiv_insumo_pmsDAO();
      List<Vw_equiv_insumo_pmsT> listTemp  = vw_equiv_insumo_pmsDAO.getByPK( vw_equiv_insumo_pmsT);	 

      vw_equiv_insumo_pmsT= listTemp.size()>0?listTemp.get(0):new Vw_equiv_insumo_pmsT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
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
	  String page = "vw_equiv_insumo_pmsConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_equiv_insumo_pmsConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
