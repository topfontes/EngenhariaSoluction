package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqc_equivalencia_composicaoUpdateDeleteJB extends SystemBase implements INotSecurity {

  // Atributos e propriedades
    private Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT = new Eqc_equivalencia_composicaoT();

  public void setEqc_equivalencia_composicaoT(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) {
    this.eqc_equivalencia_composicaoT = eqc_equivalencia_composicaoT;
  }

  public Eqc_equivalencia_composicaoT getEqc_equivalencia_composicaoT() {	
    return eqc_equivalencia_composicaoT;
  }

	
  private List<Eqc_equivalencia_composicaoT> list;

  public List<Eqc_equivalencia_composicaoT> getList() {
    return list;
  }
  
  public void setList(List<Eqc_equivalencia_composicaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      eqc_equivalencia_composicaoT = new Eqc_equivalencia_composicaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
        eqc_equivalencia_composicaoDAO.delete(eqc_equivalencia_composicaoT);	 
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
//      Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
//      List<Eqc_equivalencia_composicaoT> listTemp  = eqc_equivalencia_composicaoDAO.getByPK( eqc_equivalencia_composicaoT);

      return true;
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
        Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
        eqc_equivalencia_composicaoDAO.update(eqc_equivalencia_composicaoT);	 
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
      Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();
      List<Eqc_equivalencia_composicaoT> listTemp  = eqc_equivalencia_composicaoDAO.getByPK( eqc_equivalencia_composicaoT);	 

      eqc_equivalencia_composicaoT= listTemp.size()>0?listTemp.get(0):new Eqc_equivalencia_composicaoT();
      
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
	  String page = "eqc_equivalencia_composicaoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "eqc_equivalencia_composicaoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
