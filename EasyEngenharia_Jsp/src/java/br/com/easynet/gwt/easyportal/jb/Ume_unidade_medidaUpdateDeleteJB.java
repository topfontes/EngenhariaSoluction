package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ume_unidade_medidaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Ume_unidade_medidaT ume_unidade_medidaT = new Ume_unidade_medidaT();

  public void setUme_unidade_medidaT(Ume_unidade_medidaT ume_unidade_medidaT) {
    this.ume_unidade_medidaT = ume_unidade_medidaT;
  }

  public Ume_unidade_medidaT getUme_unidade_medidaT() {	
    return ume_unidade_medidaT;
  }

	
  private List<Ume_unidade_medidaT> list;

  public List<Ume_unidade_medidaT> getList() {
    return list;
  }
  
  public void setList(List<Ume_unidade_medidaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      ume_unidade_medidaT = new Ume_unidade_medidaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Ume_unidade_medidaDAO ume_unidade_medidaDAO = getUme_unidade_medidaDAO();
        ume_unidade_medidaDAO.delete(ume_unidade_medidaT);	 
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
      Ume_unidade_medidaDAO ume_unidade_medidaDAO = getUme_unidade_medidaDAO();
      List<Ume_unidade_medidaT> listTemp  = ume_unidade_medidaDAO.getByPK( ume_unidade_medidaT);	 

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
        Ume_unidade_medidaDAO ume_unidade_medidaDAO = getUme_unidade_medidaDAO();
        ume_unidade_medidaDAO.update(ume_unidade_medidaT);	 
        setMsg("Alteraçao efetuada com sucesso!");
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
      Ume_unidade_medidaDAO ume_unidade_medidaDAO = getUme_unidade_medidaDAO();
      List<Ume_unidade_medidaT> listTemp  = ume_unidade_medidaDAO.getByPK( ume_unidade_medidaT);	 

      ume_unidade_medidaT= listTemp.size()>0?listTemp.get(0):new Ume_unidade_medidaT();
      
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
	  String page = "ume_unidade_medidaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ume_unidade_medidaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
