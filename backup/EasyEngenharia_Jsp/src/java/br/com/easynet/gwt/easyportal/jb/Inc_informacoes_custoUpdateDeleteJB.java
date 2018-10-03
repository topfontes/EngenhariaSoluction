package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Inc_informacoes_custoUpdateDeleteJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Inc_informacoes_custoT inc_informacoes_custoT = new Inc_informacoes_custoT();

  public void setInc_informacoes_custoT(Inc_informacoes_custoT inc_informacoes_custoT) {
    this.inc_informacoes_custoT = inc_informacoes_custoT;
  }

  public Inc_informacoes_custoT getInc_informacoes_custoT() {	
    return inc_informacoes_custoT;
  }

	
  private List<Inc_informacoes_custoT> list;

  public List<Inc_informacoes_custoT> getList() {
    return list;
  }
  
  public void setList(List<Inc_informacoes_custoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultObr_obras();

		consultPlc_plano_contas();

  }

  public void clear() throws Exception {
    
      inc_informacoes_custoT = new Inc_informacoes_custoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Inc_informacoes_custoDAO inc_informacoes_custoDAO = getInc_informacoes_custoDAO();
        inc_informacoes_custoDAO.delete(inc_informacoes_custoT);	 
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
      Inc_informacoes_custoDAO inc_informacoes_custoDAO = getInc_informacoes_custoDAO();
      List<Inc_informacoes_custoT> listTemp  = inc_informacoes_custoDAO.getByPK( inc_informacoes_custoT);	 

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
        Inc_informacoes_custoDAO inc_informacoes_custoDAO = getInc_informacoes_custoDAO();
        inc_informacoes_custoDAO.update(inc_informacoes_custoT);	 
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
//			listobr_obras=obr_obrasDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	private List<Plc_plano_contasT> listplc_plano_contas;
	public List<Plc_plano_contasT> getListplc_plano_contas() {
		return listplc_plano_contas;
	}

	 public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
		this.listplc_plano_contas=list;
	}
	public void consultPlc_plano_contas() throws Exception {
		try {
			Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
//			listplc_plano_contas=plc_plano_contasDAO.getAll();
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
      Inc_informacoes_custoDAO inc_informacoes_custoDAO = getInc_informacoes_custoDAO();
      List<Inc_informacoes_custoT> listTemp  = inc_informacoes_custoDAO.getByPK( inc_informacoes_custoT);	 

      inc_informacoes_custoT= listTemp.size()>0?listTemp.get(0):new Inc_informacoes_custoT();
      
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
	  String page = "inc_informacoes_custoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "inc_informacoes_custoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
