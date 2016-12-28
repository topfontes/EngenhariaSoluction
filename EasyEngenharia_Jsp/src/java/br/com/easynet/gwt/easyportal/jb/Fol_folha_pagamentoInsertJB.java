package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;


/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fol_folha_pagamentoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Fol_folha_pagamentoT fol_folha_pagamentoT = new Fol_folha_pagamentoT();

  public void setFol_folha_pagamentoT(Fol_folha_pagamentoT fol_folha_pagamentoT) {
    this.fol_folha_pagamentoT = fol_folha_pagamentoT;
  }

  public Fol_folha_pagamentoT getFol_folha_pagamentoT() {	
    return fol_folha_pagamentoT;
  }

  private int fol_nr_id;
	
  public void pageLoad() throws Exception {
	super.pageLoad();

  }

  // M�todos de Eventos
  public void insert() throws Exception {
    try {
      Fol_folha_pagamentoDAO fol_folha_pagamentoDAO =  getFol_folha_pagamentoDAO();
      fol_folha_pagamentoDAO.insert(fol_folha_pagamentoT);	 
      setMsg("Cadastro efetuado com sucesso!");
      fol_nr_id = fol_folha_pagamentoT.getFol_nr_id();
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

	private List<Plc_plano_contasT> listplc_plano_contas;
	public List<Plc_plano_contasT> getListplc_plano_contas() {
		return listplc_plano_contas;
	}

	 public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
		this.listplc_plano_contas=list;
	}



  
  public void clear() throws Exception {
    
      fol_folha_pagamentoT = new Fol_folha_pagamentoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "fol_folha_pagamentoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the fol_nr_id
     */
    public int getFol_nr_id() {
        return fol_nr_id;
    }

    /**
     * @param fol_nr_id the fol_nr_id to set
     */
    public void setFol_nr_id(int fol_nr_id) {
        this.fol_nr_id = fol_nr_id;
    }

}
