package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Uni_unidadeUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Uni_unidadeT uni_unidadeT = new Uni_unidadeT();

  public void setUni_unidadeT(Uni_unidadeT uni_unidadeT) {
    this.uni_unidadeT = uni_unidadeT;
  }

  public Uni_unidadeT getUni_unidadeT() {	
    return uni_unidadeT;
  }

	
  private List<Uni_unidadeT> list;

  public List<Uni_unidadeT> getList() {
    return list;
  }
  
  public void setList(List<Uni_unidadeT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      uni_unidadeT = new Uni_unidadeT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
        uni_unidadeDAO.delete(uni_unidadeT);	 
        setMsg("Exclus�o efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus�o!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
      List<Uni_unidadeT> listTemp  = uni_unidadeDAO.getByPK( uni_unidadeT);	 

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
        Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
        uni_unidadeDAO.update(uni_unidadeT);	 
        setMsg("Altera��o efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar altera��o!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();
      List<Uni_unidadeT> listTemp  = uni_unidadeDAO.getByPK( uni_unidadeT);	 

      uni_unidadeT = listTemp.size()>0?listTemp.get(0):new Uni_unidadeT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p�gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "uni_unidadeConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "uni_unidadeConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
