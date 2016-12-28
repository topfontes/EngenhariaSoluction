package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cffo_cronograma_fisico_financeiro_origenalConsultJB extends SystemBase {

  // Atributos e propriedades
    private Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();
    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();

  public void setCffo_cronograma_fisico_financeiro_origenalT(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) {
    this.cffo_cronograma_fisico_financeiro_origenalT = cffo_cronograma_fisico_financeiro_origenalT;
  }

  public Cffo_cronograma_fisico_financeiro_origenalT getCffo_cronograma_fisico_financeiro_origenalT() {	
    return cffo_cronograma_fisico_financeiro_origenalT;
  }


	
  private List<Cffo_cronograma_fisico_financeiro_origenalT> list;

  public List<Cffo_cronograma_fisico_financeiro_origenalT> getList() {
    return list;
  }
  
  public void setList(List<Cffo_cronograma_fisico_financeiro_origenalT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        
  }

  public void consult() throws Exception {
    try {

      Cffo_cronograma_fisico_financeiro_origenalDAO cffo_cronograma_fisico_financeiro_origenalDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
      list = cffo_cronograma_fisico_financeiro_origenalDAO.getAll();

    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void consultSuperConta() throws Exception {
    try {

      Cffo_cronograma_fisico_financeiro_origenalDAO cffo_cronograma_fisico_financeiro_origenalDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
      list = cffo_cronograma_fisico_financeiro_origenalDAO.getAllSuperConta(vw_importacao_orcamentoT);

    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }

  public void delete() throws Exception {
    try {
      Cffo_cronograma_fisico_financeiro_origenalDAO cffo_cronograma_fisico_financeiro_origenalDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
      cffo_cronograma_fisico_financeiro_origenalDAO.delete(cffo_cronograma_fisico_financeiro_origenalT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();
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
	  String page = "cffo_cronograma_fisico_financeiro_origenalInsert.jsp";// defina aqui a página que deve ser chamada  
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
     * @return the vw_importacao_orcamentoT
     */
    public Vw_importacao_orcamentoT getVw_importacao_orcamentoT() {
        return vw_importacao_orcamentoT;
    }

    /**
     * @param vw_importacao_orcamentoT the vw_importacao_orcamentoT to set
     */
    public void setVw_importacao_orcamentoT(Vw_importacao_orcamentoT vw_importacao_orcamentoT) {
        this.vw_importacao_orcamentoT = vw_importacao_orcamentoT;
    }


}
