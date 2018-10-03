package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Com_comprometimentoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Com_comprometimentoT com_comprometimentoT = new Com_comprometimentoT();

  public void setCom_comprometimentoT(Com_comprometimentoT com_comprometimentoT) {
    this.com_comprometimentoT = com_comprometimentoT;
  }

  public Com_comprometimentoT getCom_comprometimentoT() {	
    return com_comprometimentoT;
  }

	
  private List<Com_comprometimentoT> list;

  public List<Com_comprometimentoT> getList() {
    return list;
  }
  
  public void setList(List<Com_comprometimentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();

  }

  public void clear() throws Exception {
    
      com_comprometimentoT = new Com_comprometimentoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Com_comprometimentoDAO com_comprometimentoDAO = getCom_comprometimentoDAO();
        com_comprometimentoDAO.delete(com_comprometimentoT);	 
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
      Com_comprometimentoDAO com_comprometimentoDAO = getCom_comprometimentoDAO();
      List<Com_comprometimentoT> listTemp  = com_comprometimentoDAO.getByPK( com_comprometimentoT);	 

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
        Com_comprometimentoDAO com_comprometimentoDAO = getCom_comprometimentoDAO();
        com_comprometimentoDAO.update(com_comprometimentoT);	 
        setMsg("Alteração efetuada com sucesso!");
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




  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Com_comprometimentoDAO com_comprometimentoDAO = getCom_comprometimentoDAO();
      List<Com_comprometimentoT> listTemp  = com_comprometimentoDAO.getByPK( com_comprometimentoT);	 

      com_comprometimentoT= listTemp.size()>0?listTemp.get(0):new Com_comprometimentoT();
      
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
	  String page = "com_comprometimentoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "com_comprometimentoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
