package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Inn_insumo_novoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Inn_insumo_novoT inn_insumo_novoT = new Inn_insumo_novoT();

  public void setInn_insumo_novoT(Inn_insumo_novoT inn_insumo_novoT) {
    this.inn_insumo_novoT = inn_insumo_novoT;
  }

  public Inn_insumo_novoT getInn_insumo_novoT() {	
    return inn_insumo_novoT;
  }

	
  private List<Inn_insumo_novoT> list;

  public List<Inn_insumo_novoT> getList() {
    return list;
  }
  
  public void setList(List<Inn_insumo_novoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      inn_insumo_novoT = new Inn_insumo_novoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
        inn_insumo_novoDAO.delete(inn_insumo_novoT);	 
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
      Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
      List<Inn_insumo_novoT> listTemp  = inn_insumo_novoDAO.getByPK( inn_insumo_novoT);	 

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
        Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
        inn_insumo_novoDAO.update(inn_insumo_novoT);	 
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


  //Method Download Image é montando se houver algum campo do tipo binário
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
      List<Inn_insumo_novoT> listTemp  = inn_insumo_novoDAO.getByPK( inn_insumo_novoT);	 

      inn_insumo_novoT= listTemp.size()>0?listTemp.get(0):new Inn_insumo_novoT();
      
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
	  String page = "inn_insumo_novoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "inn_insumo_novoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
