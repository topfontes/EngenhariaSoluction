package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Frd_faturamento_rec_devolucaoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT = new Frd_faturamento_rec_devolucaoT();

  public void setFrd_faturamento_rec_devolucaoT(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) {
    this.frd_faturamento_rec_devolucaoT = frd_faturamento_rec_devolucaoT;
  }

  public Frd_faturamento_rec_devolucaoT getFrd_faturamento_rec_devolucaoT() {	
    return frd_faturamento_rec_devolucaoT;
  }


	
  private List<Frd_faturamento_rec_devolucaoT> list;

  public List<Frd_faturamento_rec_devolucaoT> getList() {
    return list;
  }
  
  public void setList(List<Frd_faturamento_rec_devolucaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        //consult();
  }

  public void consult() throws Exception {
    try {
      Frd_faturamento_rec_devolucaoDAO frd_faturamento_rec_devolucaoDAO = getFrd_faturamento_rec_devolucaoDAO();
      list = frd_faturamento_rec_devolucaoDAO.getObraMesAno(frd_faturamento_rec_devolucaoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Frd_faturamento_rec_devolucaoDAO frd_faturamento_rec_devolucaoDAO = getFrd_faturamento_rec_devolucaoDAO();
      frd_faturamento_rec_devolucaoDAO.delete(frd_faturamento_rec_devolucaoT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      frd_faturamento_rec_devolucaoT = new Frd_faturamento_rec_devolucaoT();
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
	  String page = "frd_faturamento_rec_devolucaoInsert.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
