package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

 

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Inc_informacoes_custoInsertJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Inc_informacoes_custoT inc_informacoes_custoT = new Inc_informacoes_custoT();

  public void setInc_informacoes_custoT(Inc_informacoes_custoT inc_informacoes_custoT) {
    this.inc_informacoes_custoT = inc_informacoes_custoT;
  }

  public Inc_informacoes_custoT getInc_informacoes_custoT() {	
    return inc_informacoes_custoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultObr_obras();

		consultPlc_plano_contas();

  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Inc_informacoes_custoDAO inc_informacoes_custoDAO =  getInc_informacoes_custoDAO();
      inc_informacoes_custoDAO.insert(inc_informacoes_custoT);	 
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


  
  public void clear() throws Exception {
    
      inc_informacoes_custoT = new Inc_informacoes_custoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "inc_informacoes_custoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
