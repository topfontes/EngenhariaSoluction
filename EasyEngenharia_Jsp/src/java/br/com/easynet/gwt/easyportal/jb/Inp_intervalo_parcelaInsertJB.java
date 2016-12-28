package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Inp_intervalo_parcelaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Inp_intervalo_parcelaT inp_intervalo_parcelaT = new Inp_intervalo_parcelaT();

  public void setInp_intervalo_parcelaT(Inp_intervalo_parcelaT inp_intervalo_parcelaT) {
    this.inp_intervalo_parcelaT = inp_intervalo_parcelaT;
  }

  public Inp_intervalo_parcelaT getInp_intervalo_parcelaT() {	
    return inp_intervalo_parcelaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPar_parcelamento();

  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Inp_intervalo_parcelaDAO inp_intervalo_parcelaDAO =  getInp_intervalo_parcelaDAO();
      inp_intervalo_parcelaDAO.insert(inp_intervalo_parcelaT);	 
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
	private List<Par_parcelamentoT> listpar_parcelamento;
	public List<Par_parcelamentoT> getListpar_parcelamento() {
		return listpar_parcelamento;
	}

	 public void setListpar_parcelamento(List<Par_parcelamentoT> list) {
		this.listpar_parcelamento=list;
	}
	public void consultPar_parcelamento() throws Exception {
		try {
			Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
			listpar_parcelamento=par_parcelamentoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      inp_intervalo_parcelaT = new Inp_intervalo_parcelaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "inp_intervalo_parcelaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
