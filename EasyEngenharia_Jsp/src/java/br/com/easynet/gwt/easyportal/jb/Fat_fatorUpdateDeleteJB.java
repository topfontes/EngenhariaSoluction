package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fat_fatorUpdateDeleteJB extends SystemBase {

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
  }

  public void clear() throws Exception {
    
      fat_fatorT = new Fat_fatorT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Fat_fatorDAO fat_fatorDAO = getFat_fatorDAO();
        fat_fatorDAO.delete(fat_fatorT);	 
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
      Fat_fatorDAO fat_fatorDAO = getFat_fatorDAO();
      List<Fat_fatorT> listTemp  = fat_fatorDAO.getByPK( fat_fatorT);	 

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
        Fat_fatorDAO fat_fatorDAO = getFat_fatorDAO();
        fat_fatorDAO.update(fat_fatorT);	 
        setMsg("alteração efetuada com sucesso!");	
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
	private List<Plc_plano_contasT> listplc_plano_contas;
	public List<Plc_plano_contasT> getListplc_plano_contas() {
		return listplc_plano_contas;
	}

	 public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
		this.listplc_plano_contas=list;
	}

	private List<Obr_obrasT> listobr_obras;
	public List<Obr_obrasT> getListobr_obras() {
		return listobr_obras;
	}

	 public void setListobr_obras(List<Obr_obrasT> list) {
		this.listobr_obras=list;
	}

  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Fat_fatorDAO fat_fatorDAO = getFat_fatorDAO();
      List<Fat_fatorT> listTemp  = fat_fatorDAO.getByPK( fat_fatorT);	 

      fat_fatorT= listTemp.size()>0?listTemp.get(0):new Fat_fatorT();
      
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
	  String page = "fat_fatorConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "fat_fatorConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
