package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Est_estoqueInsertJB extends SystemBase {

  // Atributos e propriedades
    private Est_estoqueT est_estoqueT = new Est_estoqueT();

  public void setEst_estoqueT(Est_estoqueT est_estoqueT) {
    this.est_estoqueT = est_estoqueT;
  }

  public Est_estoqueT getEst_estoqueT() {	
    return est_estoqueT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPlc_plano_contas();

		consultObr_obras();

  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Est_estoqueDAO est_estoqueDAO =  getEst_estoqueDAO();
      est_estoqueDAO.insert(est_estoqueT);	 
      setMsg("Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar cadastro!");	
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
			Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
			DataSet listplc_plano_contas=plc_plano_contasDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

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
			DataSet listobr_obras=obr_obrasDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      est_estoqueT = new Est_estoqueT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "est_estoqueConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
