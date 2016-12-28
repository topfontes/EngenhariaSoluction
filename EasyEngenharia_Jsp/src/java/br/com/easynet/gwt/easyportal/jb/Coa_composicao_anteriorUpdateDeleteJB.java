package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Coa_composicao_anteriorUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Coa_composicao_anteriorT coa_composicao_anteriorT = new Coa_composicao_anteriorT();

  public void setCoa_composicao_anteriorT(Coa_composicao_anteriorT coa_composicao_anteriorT) {
    this.coa_composicao_anteriorT = coa_composicao_anteriorT;
  }

  public Coa_composicao_anteriorT getCoa_composicao_anteriorT() {	
    return coa_composicao_anteriorT;
  }

	
  private List<Coa_composicao_anteriorT> list;

  public List<Coa_composicao_anteriorT> getList() {
    return list;
  }
  
  public void setList(List<Coa_composicao_anteriorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      coa_composicao_anteriorT = new Coa_composicao_anteriorT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
        coa_composicao_anteriorDAO.delete(coa_composicao_anteriorT);	 
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
      Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
      List<Coa_composicao_anteriorT> listTemp  = coa_composicao_anteriorDAO.getByPK( coa_composicao_anteriorT);	 

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
        Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
        coa_composicao_anteriorDAO.update(coa_composicao_anteriorT);	 
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


  //Method Download Image  montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
      List<Coa_composicao_anteriorT> listTemp  = coa_composicao_anteriorDAO.getByPK( coa_composicao_anteriorT);	 

      coa_composicao_anteriorT= listTemp.size()>0?listTemp.get(0):new Coa_composicao_anteriorT();
      
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
	  String page = "coa_composicao_anteriorConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "coa_composicao_anteriorConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
