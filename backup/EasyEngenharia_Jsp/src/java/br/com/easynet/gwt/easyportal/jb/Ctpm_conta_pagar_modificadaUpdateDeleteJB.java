package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ctpm_conta_pagar_modificadaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT = new Ctpm_conta_pagar_modificadaT();

  public void setCtpm_conta_pagar_modificadaT(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) {
    this.ctpm_conta_pagar_modificadaT = ctpm_conta_pagar_modificadaT;
  }

  public Ctpm_conta_pagar_modificadaT getCtpm_conta_pagar_modificadaT() {	
    return ctpm_conta_pagar_modificadaT;
  }

	
  private List<Ctpm_conta_pagar_modificadaT> list;

  public List<Ctpm_conta_pagar_modificadaT> getList() {
    return list;
  }
  
  public void setList(List<Ctpm_conta_pagar_modificadaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
 }

  public void clear() throws Exception {
    
      ctpm_conta_pagar_modificadaT = new Ctpm_conta_pagar_modificadaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
        ctpm_conta_pagar_modificadaDAO.delete(ctpm_conta_pagar_modificadaT);	 
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
      Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
      List<Ctpm_conta_pagar_modificadaT> listTemp  = ctpm_conta_pagar_modificadaDAO.getByPK( ctpm_conta_pagar_modificadaT);	 

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
        Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
        ctpm_conta_pagar_modificadaDAO.update(ctpm_conta_pagar_modificadaT);	 
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
			//listobr_obras=obr_obrasDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	private List<Ctp_conta_pagarT> listctp_conta_pagar;
	public List<Ctp_conta_pagarT> getListctp_conta_pagar() {
		return listctp_conta_pagar;
	}

	 public void setListctp_conta_pagar(List<Ctp_conta_pagarT> list) {
		this.listctp_conta_pagar=list;
	}
	public void consultCtp_conta_pagar() throws Exception {
		try {
			Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
			//listctp_conta_pagar=ctp_conta_pagarDAO.getAll();
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
      Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
      List<Ctpm_conta_pagar_modificadaT> listTemp  = ctpm_conta_pagar_modificadaDAO.getByPK( ctpm_conta_pagar_modificadaT);	 

      ctpm_conta_pagar_modificadaT= listTemp.size()>0?listTemp.get(0):new Ctpm_conta_pagar_modificadaT();
      
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
	  String page = "ctpm_conta_pagar_modificadaConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ctpm_conta_pagar_modificadaConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
