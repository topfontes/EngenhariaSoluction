package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Frd_faturamento_rec_devolucaoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT = new Frd_faturamento_rec_devolucaoT();

  public void setFrd_faturamento_rec_devolucaoT(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) {
    this.frd_faturamento_rec_devolucaoT = frd_faturamento_rec_devolucaoT;
  }

  public Frd_faturamento_rec_devolucaoT getFrd_faturamento_rec_devolucaoT() {	
    return frd_faturamento_rec_devolucaoT;
  }

	
  private List<Frd_faturamento_rec_devolucaoT> list;

  public List<Frd_faturamento_rec_devolucaoT> getList() {
    return list;
  }
  
  public void setList(List<Frd_faturamento_rec_devolucaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      frd_faturamento_rec_devolucaoT = new Frd_faturamento_rec_devolucaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Frd_faturamento_rec_devolucaoDAO frd_faturamento_rec_devolucaoDAO = getFrd_faturamento_rec_devolucaoDAO();
        frd_faturamento_rec_devolucaoDAO.delete(frd_faturamento_rec_devolucaoT);	 
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
      Frd_faturamento_rec_devolucaoDAO frd_faturamento_rec_devolucaoDAO = getFrd_faturamento_rec_devolucaoDAO();
      List<Frd_faturamento_rec_devolucaoT> listTemp  = frd_faturamento_rec_devolucaoDAO.getByPK( frd_faturamento_rec_devolucaoT);	 

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
        Frd_faturamento_rec_devolucaoDAO frd_faturamento_rec_devolucaoDAO = getFrd_faturamento_rec_devolucaoDAO();
        frd_faturamento_rec_devolucaoDAO.update(frd_faturamento_rec_devolucaoT);	 
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
      Frd_faturamento_rec_devolucaoDAO frd_faturamento_rec_devolucaoDAO = getFrd_faturamento_rec_devolucaoDAO();
      List<Frd_faturamento_rec_devolucaoT> listTemp  = frd_faturamento_rec_devolucaoDAO.getByPK( frd_faturamento_rec_devolucaoT);	 

      frd_faturamento_rec_devolucaoT= listTemp.size()>0?listTemp.get(0):new Frd_faturamento_rec_devolucaoT();
      
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
	  String page = "frd_faturamento_rec_devolucaoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "frd_faturamento_rec_devolucaoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
