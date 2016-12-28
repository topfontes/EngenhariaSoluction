package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_programacaoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Pro_programacaoT pro_programacaoT = new Pro_programacaoT();

  public void setPro_programacaoT(Pro_programacaoT pro_programacaoT) {
    this.pro_programacaoT = pro_programacaoT;
  }

  public Pro_programacaoT getPro_programacaoT() {	
    return pro_programacaoT;
  }

	
  private List<Pro_programacaoT> list;

  public List<Pro_programacaoT> getList() {
    return list;
  }
  
  public void setList(List<Pro_programacaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      pro_programacaoT = new Pro_programacaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Pro_programacaoDAO pro_programacaoDAO = getPro_programacaoDAO();
        pro_programacaoDAO.delete(pro_programacaoT);	 
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
      Pro_programacaoDAO pro_programacaoDAO = getPro_programacaoDAO();
      List<Pro_programacaoT> listTemp  = pro_programacaoDAO.getByPK( pro_programacaoT);	 

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
        Pro_programacaoDAO pro_programacaoDAO = getPro_programacaoDAO();
        pro_programacaoDAO.update(pro_programacaoT);	 
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


  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Pro_programacaoDAO pro_programacaoDAO = getPro_programacaoDAO();
      List<Pro_programacaoT> listTemp  = pro_programacaoDAO.getByPK( pro_programacaoT);	 

      pro_programacaoT= listTemp.size()>0?listTemp.get(0):new Pro_programacaoT();
      
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
	  String page = "pro_programacaoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "pro_programacaoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
