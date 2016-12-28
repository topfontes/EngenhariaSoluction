package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plr_planilha_recebimentoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Plr_planilha_recebimentoT plr_planilha_permutaT = new Plr_planilha_recebimentoT();

  public void setPlr_planilha_permutaT(Plr_planilha_recebimentoT plr_planilha_permutaT) {
    this.plr_planilha_permutaT = plr_planilha_permutaT;
  }

  public Plr_planilha_recebimentoT getPlr_planilha_permutaT() {
    return plr_planilha_permutaT;
  }

	
  private List<Plr_planilha_recebimentoT> list;

  public List<Plr_planilha_recebimentoT> getList() {
    return list;
  }
  
  public void setList(List<Plr_planilha_recebimentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultObr_obras();

  }

  public void clear() throws Exception {
    
      plr_planilha_permutaT = new Plr_planilha_recebimentoT();
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Plr_planilha_recebimentoDAO plr_planilha_permutaDAO = getPlr_planilha_permutaDAO();
        plr_planilha_permutaDAO.delete(plr_planilha_permutaT);	 
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
      Plr_planilha_recebimentoDAO plr_planilha_permutaDAO = getPlr_planilha_permutaDAO();
      List<Plr_planilha_recebimentoT> listTemp  = plr_planilha_permutaDAO.getByPK( plr_planilha_permutaT);

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
        Plr_planilha_recebimentoDAO plr_planilha_permutaDAO = getPlr_planilha_permutaDAO();
        plr_planilha_permutaDAO.update(plr_planilha_permutaT);	 
        setMsg("Alteraçãoo efetuada com sucesso!");	
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
	private List<Obr_obrasT> listobr_obras;
	public List<Obr_obrasT> getListobr_obras() {
		return listobr_obras;
	}

	 public void setListobr_obras(List<Obr_obrasT> list) {
		this.listobr_obras=list;
	}
	public void consultObr_obras() throws Exception {
		try {
			Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();

		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}



  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Plr_planilha_recebimentoDAO plr_planilha_permutaDAO = getPlr_planilha_permutaDAO();
      List<Plr_planilha_recebimentoT> listTemp  = plr_planilha_permutaDAO.getByPK( plr_planilha_permutaT);

      plr_planilha_permutaT= listTemp.size()>0?listTemp.get(0):new Plr_planilha_recebimentoT();
      
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
	  String page = "plr_planilha_permutaConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "plr_planilha_permutaConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
