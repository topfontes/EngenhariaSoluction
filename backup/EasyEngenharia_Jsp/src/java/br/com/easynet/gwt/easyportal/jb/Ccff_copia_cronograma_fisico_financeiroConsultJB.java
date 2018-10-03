package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
 


/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ccff_copia_cronograma_fisico_financeiroConsultJB extends SystemBase {

  // Atributos e propriedades
    private Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT = new Ccff_copia_cronograma_fisico_financeiroT();
    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();

  public void setCcff_copia_cronograma_fisico_financeiroT(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) {
    this.ccff_copia_cronograma_fisico_financeiroT = ccff_copia_cronograma_fisico_financeiroT;
  }

  public Ccff_copia_cronograma_fisico_financeiroT getCcff_copia_cronograma_fisico_financeiroT() {	
    return ccff_copia_cronograma_fisico_financeiroT;
  }


	
  private List<Ccff_copia_cronograma_fisico_financeiroT> list;

  public List<Ccff_copia_cronograma_fisico_financeiroT> getList() {
    return list;
  }
  
  public void setList(List<Ccff_copia_cronograma_fisico_financeiroT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Ccff_copia_cronograma_fisico_financeiroDAO ccff_copia_cronograma_fisico_financeiroDAO = getCcff_copia_cronograma_fisico_financeiroDAO();
      list = ccff_copia_cronograma_fisico_financeiroDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }

  public void consultSuperConta() throws Exception {
    try {
      Ccff_copia_cronograma_fisico_financeiroDAO cdao = getCcff_copia_cronograma_fisico_financeiroDAO();
      list = cdao.getAllSuperConta(getVw_importacao_orcamentoT());

    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");
    } finally {
	close();
    }
  }

  public void delete() throws Exception {
    try {
      Ccff_copia_cronograma_fisico_financeiroDAO ccff_copia_cronograma_fisico_financeiroDAO = getCcff_copia_cronograma_fisico_financeiroDAO();
      ccff_copia_cronograma_fisico_financeiroDAO.delete(ccff_copia_cronograma_fisico_financeiroT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      ccff_copia_cronograma_fisico_financeiroT = new Ccff_copia_cronograma_fisico_financeiroT();
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
	  String page = "ccff_copia_cronograma_fisico_financeiroInsert.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p�gina que deve ser chamada  
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
