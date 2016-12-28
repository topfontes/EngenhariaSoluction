package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class For_fornecedorUpdateDeleteJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private For_fornecedorT for_fornecedorT = new For_fornecedorT();
    private String ids;

  public void setFor_fornecedorT(For_fornecedorT for_fornecedorT) {
    this.for_fornecedorT = for_fornecedorT;
  }

  public For_fornecedorT getFor_fornecedorT() {	
    return for_fornecedorT;
  }

	
  private List<For_fornecedorT> list;

  public List<For_fornecedorT> getList() {
    return list;
  }
  
  public void setList(List<For_fornecedorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      for_fornecedorT = new For_fornecedorT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
        for_fornecedorDAO.delete(for_fornecedorT);	 
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
  
    public void deleteAll() throws Exception {
    try {
      
        For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
        for_fornecedorDAO.deleteAll(ids);	 
        setMsg("Exclusão efetuada com sucesso!");
        clear();
 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
      List<For_fornecedorT> listTemp  = for_fornecedorDAO.getByPK( for_fornecedorT);	 

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
        For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
        for_fornecedorDAO.update(for_fornecedorT);	 
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
      For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
      List<For_fornecedorT> listTemp  = for_fornecedorDAO.getByPK( for_fornecedorT);	 

      for_fornecedorT= listTemp.size()>0?listTemp.get(0):new For_fornecedorT();
      
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
	  String page = "for_fornecedorConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "for_fornecedorConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

    /**
     * @return the ids
     */
    public String getIds() {
        return ids;
    }

    /**
     * @param ids the ids to set
     */
    public void setIds(String ids) {
        this.ids = ids;
    }

}
