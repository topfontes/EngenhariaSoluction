package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_importacao_orcamentoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();

  public void setVw_importacao_orcamentoT(Vw_importacao_orcamentoT vw_importacao_orcamentoT) {
    this.vw_importacao_orcamentoT = vw_importacao_orcamentoT;
  }

  public Vw_importacao_orcamentoT getVw_importacao_orcamentoT() {	
    return vw_importacao_orcamentoT;
  }


	
  private List<Vw_importacao_orcamentoT> list;

  public List<Vw_importacao_orcamentoT> getList() {
    return list;
  }
  
  public void setList(List<Vw_importacao_orcamentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();

  }

  public void consult() throws Exception {
    try {
      Vw_importacao_orcamentoDAO vw_importacao_orcamentoDAO = getVw_importacao_orcamentoDAO();
      list = vw_importacao_orcamentoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }
  
    public void consultServico() throws Exception {
        try {
            Vw_importacao_orcamentoDAO vw_importacao_orcamentoDAO = getVw_importacao_orcamentoDAO();
            list = vw_importacao_orcamentoDAO.getAllServico(vw_importacao_orcamentoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultNivel() throws Exception {
        try {
            Vw_importacao_orcamentoDAO vw_importacao_orcamentoDAO = getVw_importacao_orcamentoDAO();
            list = vw_importacao_orcamentoDAO.getAllNivel(vw_importacao_orcamentoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

  public void delete() throws Exception {
    try {
      Vw_importacao_orcamentoDAO vw_importacao_orcamentoDAO = getVw_importacao_orcamentoDAO();
      vw_importacao_orcamentoDAO.delete(vw_importacao_orcamentoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "vw_importacao_orcamentoInsert.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }


}
