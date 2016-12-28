package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fol_folha_pagamentoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Fol_folha_pagamentoT fol_folha_pagamentoT = new Fol_folha_pagamentoT();
    private float horasTrab;

  public void setFol_folha_pagamentoT(Fol_folha_pagamentoT fol_folha_pagamentoT) {
    this.fol_folha_pagamentoT = fol_folha_pagamentoT;
  }

  public Fol_folha_pagamentoT getFol_folha_pagamentoT() {	
    return fol_folha_pagamentoT;
  }

  private DataSet ds = new DataSet();

	
  private List<Fol_folha_pagamentoT> list;

  public List<Fol_folha_pagamentoT> getList() {
    return list;
  }
  
  public void setList(List<Fol_folha_pagamentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void consult() throws Exception {
    try {
      Fol_folha_pagamentoDAO fol_folha_pagamentoDAO = getFol_folha_pagamentoDAO();
      ds = fol_folha_pagamentoDAO.getAll(fol_folha_pagamentoT);
      Htf_horas_trabalha_folhaDAO hdao = getHtf_horas_trabalha_folhaDAO();
      horasTrab = hdao.getHohrasMes(fol_folha_pagamentoT.getObr_nr_id(), fol_folha_pagamentoT.getFol_nr_mes(), fol_folha_pagamentoT.getFol_nr_ano());
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Fol_folha_pagamentoDAO fol_folha_pagamentoDAO = getFol_folha_pagamentoDAO();
      fol_folha_pagamentoDAO.delete(fol_folha_pagamentoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      fol_folha_pagamentoT = new Fol_folha_pagamentoT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus�o!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "fol_folha_pagamentoInsert.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the ds
     */
    public DataSet getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DataSet ds) {
        this.ds = ds;
    }

    /**
     * @return the horasTrab
     */
    public float getHorasTrab() {
        return horasTrab;
    }

    /**
     * @param horasTrab the horasTrab to set
     */
    public void setHorasTrab(float horasTrab) {
        this.horasTrab = horasTrab;
    }

}
