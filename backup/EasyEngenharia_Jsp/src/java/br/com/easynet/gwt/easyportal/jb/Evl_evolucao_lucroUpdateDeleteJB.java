package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Evl_evolucao_lucroUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Evl_evolucao_lucroT evl_evolucao_lucroT = new Evl_evolucao_lucroT();

  public void setEvl_evolucao_lucroT(Evl_evolucao_lucroT evl_evolucao_lucroT) {
    this.evl_evolucao_lucroT = evl_evolucao_lucroT;
  }

  public Evl_evolucao_lucroT getEvl_evolucao_lucroT() {	
    return evl_evolucao_lucroT;
  }

	
  private List<Evl_evolucao_lucroT> list;

  public List<Evl_evolucao_lucroT> getList() {
    return list;
  }
  
  public void setList(List<Evl_evolucao_lucroT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultObr_obras();

  }

  public void clear() throws Exception {
    
      evl_evolucao_lucroT = new Evl_evolucao_lucroT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Evl_evolucao_lucroDAO evl_evolucao_lucroDAO = getEvl_evolucao_lucroDAO();
        evl_evolucao_lucroDAO.delete(evl_evolucao_lucroT);	 
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
      Evl_evolucao_lucroDAO evl_evolucao_lucroDAO = getEvl_evolucao_lucroDAO();
      List<Evl_evolucao_lucroT> listTemp  = evl_evolucao_lucroDAO.getByPK( evl_evolucao_lucroT);	 

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
        Evl_evolucao_lucroDAO evl_evolucao_lucroDAO = getEvl_evolucao_lucroDAO();
        evl_evolucao_lucroDAO.update(evl_evolucao_lucroT);	 
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
//			listobr_obras=obr_obrasDAO.getAll();
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
      Evl_evolucao_lucroDAO evl_evolucao_lucroDAO = getEvl_evolucao_lucroDAO();
      List<Evl_evolucao_lucroT> listTemp  = evl_evolucao_lucroDAO.getByPK( evl_evolucao_lucroT);	 

      evl_evolucao_lucroT= listTemp.size()>0?listTemp.get(0):new Evl_evolucao_lucroT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
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
	  String page = "evl_evolucao_lucroConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "evl_evolucao_lucroConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
