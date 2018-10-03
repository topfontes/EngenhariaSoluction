package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Scfp_subclasse_operario_previstoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT = new Scfp_subclasse_operario_previstoT();

  public void setScfp_subclasse_operario_previstoT(Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT) {
    this.scfp_subclasse_operario_previstoT = scfp_subclasse_operario_previstoT;
  }

  public Scfp_subclasse_operario_previstoT getScfp_subclasse_operario_previstoT() {	
    return scfp_subclasse_operario_previstoT;
  }

	
  private List<Scfp_subclasse_operario_previstoT> list;

  public List<Scfp_subclasse_operario_previstoT> getList() {
    return list;
  }
  
  public void setList(List<Scfp_subclasse_operario_previstoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPlc_plano_contas();

  }

  public void clear() throws Exception {
    
      scfp_subclasse_operario_previstoT = new Scfp_subclasse_operario_previstoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Scfp_subclasse_operario_previstoDAO scfp_subclasse_operario_previstoDAO = getScfp_subclasse_operario_previstoDAO();
        scfp_subclasse_operario_previstoDAO.delete(scfp_subclasse_operario_previstoT);	 
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
      Scfp_subclasse_operario_previstoDAO scfp_subclasse_operario_previstoDAO = getScfp_subclasse_operario_previstoDAO();
      List<Scfp_subclasse_operario_previstoT> listTemp  = scfp_subclasse_operario_previstoDAO.getByPK( scfp_subclasse_operario_previstoT);	 

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
        Scfp_subclasse_operario_previstoDAO scfp_subclasse_operario_previstoDAO = getScfp_subclasse_operario_previstoDAO();
        scfp_subclasse_operario_previstoDAO.update(scfp_subclasse_operario_previstoT);	 
        setMsg("Altera��o efetuada com sucesso!");	
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
	private List<Plc_plano_contasT> listplc_plano_contas;
	public List<Plc_plano_contasT> getListplc_plano_contas() {
		return listplc_plano_contas;
	}

	 public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
		this.listplc_plano_contas=list;
	}
	public void consultPlc_plano_contas() throws Exception {
		try {

		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}



  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Scfp_subclasse_operario_previstoDAO scfp_subclasse_operario_previstoDAO = getScfp_subclasse_operario_previstoDAO();
      List<Scfp_subclasse_operario_previstoT> listTemp  = scfp_subclasse_operario_previstoDAO.getByPK( scfp_subclasse_operario_previstoT);	 

      scfp_subclasse_operario_previstoT= listTemp.size()>0?listTemp.get(0):new Scfp_subclasse_operario_previstoT();
      
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
	  String page = "scfp_subclasse_operario_previstoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "scfp_subclasse_operario_previstoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
