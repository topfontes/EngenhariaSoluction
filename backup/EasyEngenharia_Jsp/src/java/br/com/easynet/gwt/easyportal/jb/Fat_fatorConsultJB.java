package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fat_fatorConsultJB extends SystemBase {

  // Atributos e propriedades
    private Fat_fatorT fat_fatorT = new Fat_fatorT();

  public void setFat_fatorT(Fat_fatorT fat_fatorT) {
    this.fat_fatorT = fat_fatorT;
  }

  public Fat_fatorT getFat_fatorT() {	
    return fat_fatorT;
  }


	
  private List<Fat_fatorT> list;

  public List<Fat_fatorT> getList() {
    return list;
  }
  
  public void setList(List<Fat_fatorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Fat_fatorDAO fat_fatorDAO = getFat_fatorDAO();
      list = fat_fatorDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Fat_fatorDAO fat_fatorDAO = getFat_fatorDAO();
      fat_fatorDAO.delete(fat_fatorT);	 
      setMsg("Exclusão efetuada com sucesso!");
      fat_fatorT = new Fat_fatorT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "fat_fatorInsert.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
