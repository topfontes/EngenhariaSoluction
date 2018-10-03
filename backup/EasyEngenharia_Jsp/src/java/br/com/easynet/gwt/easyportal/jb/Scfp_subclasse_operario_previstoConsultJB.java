package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Scfp_subclasse_operario_previstoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT = new Scfp_subclasse_operario_previstoT();

  public void setScfp_subclasse_operario_previstoT(Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT) {
    this.scfp_subclasse_operario_previstoT = scfp_subclasse_operario_previstoT;
  }

  public Scfp_subclasse_operario_previstoT getScfp_subclasse_operario_previstoT() {	
    return scfp_subclasse_operario_previstoT;
  }


  private DataSet ds ;
	
  private List<Scfp_subclasse_operario_previstoT> list;

  public List<Scfp_subclasse_operario_previstoT> getList() {
    return list;
  }
  
  public void setList(List<Scfp_subclasse_operario_previstoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void consult() throws Exception {
    try {
      Scfp_subclasse_operario_previstoDAO scfp_subclasse_operario_previstoDAO = getScfp_subclasse_operario_previstoDAO();
      ds = scfp_subclasse_operario_previstoDAO.getAll();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Scfp_subclasse_operario_previstoDAO scfp_subclasse_operario_previstoDAO = getScfp_subclasse_operario_previstoDAO();
      scfp_subclasse_operario_previstoDAO.delete(scfp_subclasse_operario_previstoT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      scfp_subclasse_operario_previstoT = new Scfp_subclasse_operario_previstoT();
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
	  String page = "scfp_subclasse_operario_previstoInsert.jsp";// defina aqui a p�gina que deve ser chamada  
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

}
