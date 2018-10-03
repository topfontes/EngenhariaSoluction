package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import org.jfree.data.general.Dataset;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Uno_unidade_obraUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Uno_unidade_obraT uno_unidade_obraT = new Uno_unidade_obraT();

  public void setUno_unidade_obraT(Uno_unidade_obraT uno_unidade_obraT) {
    this.uno_unidade_obraT = uno_unidade_obraT;
  }

  public Uno_unidade_obraT getUno_unidade_obraT() {	
    return uno_unidade_obraT;
  }

	
  private List<Uno_unidade_obraT> list;

  public List<Uno_unidade_obraT> getList() {
    return list;
  }
  
  public void setList(List<Uno_unidade_obraT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultObr_obras();

  }

  public void clear() throws Exception {
    
      uno_unidade_obraT = new Uno_unidade_obraT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
        uno_unidade_obraDAO.delete(uno_unidade_obraT);	 
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
      Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
      List<Uno_unidade_obraT> listTemp  = uno_unidade_obraDAO.getByPK( uno_unidade_obraT);	 

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
        Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
        uno_unidade_obraDAO.update(uno_unidade_obraT);	 
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
	private List<Obr_obrasT> listobr_obras;
	public List<Obr_obrasT> getListobr_obras() {
		return listobr_obras;
	}

	 public void setListobr_obras(List<Obr_obrasT> list) {
		this.listobr_obras=list;
	}
	public void consultObr_obras() throws Exception {
		try {
			Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
			DataSet ds =obr_obrasDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}



  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();
      List<Uno_unidade_obraT> listTemp  = uno_unidade_obraDAO.getByPK( uno_unidade_obraT);	 

      uno_unidade_obraT= listTemp.size()>0?listTemp.get(0):new Uno_unidade_obraT();
      
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
	  String page = "uno_unidade_obraConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "uno_unidade_obraConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
