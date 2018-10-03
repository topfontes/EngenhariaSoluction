package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tet_tmp_equivalencia_treetUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT = new Tet_tmp_equivalencia_treetT();

  public void setTet_tmp_equivalencia_treetT(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) {
    this.tet_tmp_equivalencia_treetT = tet_tmp_equivalencia_treetT;
  }

  public Tet_tmp_equivalencia_treetT getTet_tmp_equivalencia_treetT() {	
    return tet_tmp_equivalencia_treetT;
  }

	
  private List<Tet_tmp_equivalencia_treetT> list;

  public List<Tet_tmp_equivalencia_treetT> getList() {
    return list;
  }
  
  public void setList(List<Tet_tmp_equivalencia_treetT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      tet_tmp_equivalencia_treetT = new Tet_tmp_equivalencia_treetT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
        tet_tmp_equivalencia_treetDAO.delete(tet_tmp_equivalencia_treetT);	 
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
      Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
      List<Tet_tmp_equivalencia_treetT> listTemp  = tet_tmp_equivalencia_treetDAO.getByPK( tet_tmp_equivalencia_treetT);	 

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
        Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
        tet_tmp_equivalencia_treetDAO.update(tet_tmp_equivalencia_treetT);	 
        setMsg("Alteração efetuada com sucesso!");
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar alteraçao!");
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
      Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();
      List<Tet_tmp_equivalencia_treetT> listTemp  = tet_tmp_equivalencia_treetDAO.getByPK( tet_tmp_equivalencia_treetT);	 

      tet_tmp_equivalencia_treetT= listTemp.size()>0?listTemp.get(0):new Tet_tmp_equivalencia_treetT();
      
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
	  String page = "tet_tmp_equivalencia_treetConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tet_tmp_equivalencia_treetConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
