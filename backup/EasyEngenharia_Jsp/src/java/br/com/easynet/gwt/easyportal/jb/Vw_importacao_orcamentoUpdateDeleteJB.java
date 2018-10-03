package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_importacao_orcamentoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();

  public void setVw_importacao_orcamentoT(Vw_importacao_orcamentoT vw_importacao_orcamentoT) {
    this.vw_importacao_orcamentoT = vw_importacao_orcamentoT;
  }

  public Vw_importacao_orcamentoT getVw_importacao_orcamentoT() {	
    return vw_importacao_orcamentoT;
  }

	
  private List<Vw_importacao_orcamentoT> list;

  public List<Vw_importacao_orcamentoT> getList() {
    return list;
  }
  
  public void setList(List<Vw_importacao_orcamentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_importacao_orcamentoDAO vw_importacao_orcamentoDAO = getVw_importacao_orcamentoDAO();
        vw_importacao_orcamentoDAO.delete(vw_importacao_orcamentoT);	 
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
      Vw_importacao_orcamentoDAO vw_importacao_orcamentoDAO = getVw_importacao_orcamentoDAO();
      List<Vw_importacao_orcamentoT> listTemp  = vw_importacao_orcamentoDAO.getByPK( vw_importacao_orcamentoT);	 

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
        Vw_importacao_orcamentoDAO vw_importacao_orcamentoDAO = getVw_importacao_orcamentoDAO();
        vw_importacao_orcamentoDAO.update(vw_importacao_orcamentoT);	 
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
      Vw_importacao_orcamentoDAO vw_importacao_orcamentoDAO = getVw_importacao_orcamentoDAO();
      List<Vw_importacao_orcamentoT> listTemp  = vw_importacao_orcamentoDAO.getByPK( vw_importacao_orcamentoT);	 

      vw_importacao_orcamentoT= listTemp.size()>0?listTemp.get(0):new Vw_importacao_orcamentoT();
      
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
	  String page = "vw_importacao_orcamentoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_importacao_orcamentoConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
