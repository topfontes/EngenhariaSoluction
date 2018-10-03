package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Coa_composicao_anteriorConsultJB extends SystemBase implements INotSecurity{

    private int con_nr_id;
  // Atributos e propriedades
    private Coa_composicao_anteriorT coa_composicao_anteriorT = new Coa_composicao_anteriorT();

  public void setCoa_composicao_anteriorT(Coa_composicao_anteriorT coa_composicao_anteriorT) {
    this.coa_composicao_anteriorT = coa_composicao_anteriorT;
  }

  public Coa_composicao_anteriorT getCoa_composicao_anteriorT() {	
    return coa_composicao_anteriorT;
  }


	
  private List<Coa_composicao_anteriorT> list;

  public List<Coa_composicao_anteriorT> getList() {
    return list;
  }
   
  public void setList(List<Coa_composicao_anteriorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }
 
  public void consultEquiv() throws Exception {
    try {
      Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
      list = coa_composicao_anteriorDAO.getAllEquiv(con_nr_id);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");
    } finally {
	close();
    }
  }

  public void consult() throws Exception {
    try {
      Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
      list = coa_composicao_anteriorDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();
      coa_composicao_anteriorDAO.delete(coa_composicao_anteriorT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      coa_composicao_anteriorT = new Coa_composicao_anteriorT();
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
	  String page = "coa_composicao_anteriorInsert.jsp";// defina aqui a p�gina que deve ser chamada  
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
     * @return the coa_nr_id
     */
    public int getCon_nr_id() {
        return con_nr_id;
    }

    /**
     * @param coa_nr_id the coa_nr_id to set
     */
    public void setCon_nr_id(int con_nr_id) {
        this.con_nr_id = con_nr_id;
    }

}
