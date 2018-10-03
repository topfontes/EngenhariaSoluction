package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ort_orcamento_temporarioUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Ort_orcamento_temporarioT ort_orcamento_temporarioT = new Ort_orcamento_temporarioT();

  public void setOrt_orcamento_temporarioT(Ort_orcamento_temporarioT ort_orcamento_temporarioT) {
    this.ort_orcamento_temporarioT = ort_orcamento_temporarioT;
  }

  public Ort_orcamento_temporarioT getOrt_orcamento_temporarioT() {	
    return ort_orcamento_temporarioT;
  }

	
  private List<Ort_orcamento_temporarioT> list;

  public List<Ort_orcamento_temporarioT> getList() {
    return list;
  }
  
  public void setList(List<Ort_orcamento_temporarioT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      ort_orcamento_temporarioT = new Ort_orcamento_temporarioT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
        ort_orcamento_temporarioDAO.delete(ort_orcamento_temporarioT);	 
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
      Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
      List<Ort_orcamento_temporarioT> listTemp  = ort_orcamento_temporarioDAO.getByPK( ort_orcamento_temporarioT);	 

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
        Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
        ort_orcamento_temporarioDAO.update(ort_orcamento_temporarioT);	 
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
      Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();
      List<Ort_orcamento_temporarioT> listTemp  = ort_orcamento_temporarioDAO.getByPK( ort_orcamento_temporarioT);	 

      ort_orcamento_temporarioT= listTemp.size()>0?listTemp.get(0):new Ort_orcamento_temporarioT();
      
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
	  String page = "ort_orcamento_temporarioConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ort_orcamento_temporarioConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
