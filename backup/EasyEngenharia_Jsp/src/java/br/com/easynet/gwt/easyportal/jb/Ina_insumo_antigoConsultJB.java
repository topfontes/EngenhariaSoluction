package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ina_insumo_antigoConsultJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Ina_insumo_antigoT ina_insumo_antigoT = new Ina_insumo_antigoT();
    private int inn_nr_id;

  public void setIna_insumo_antigoT(Ina_insumo_antigoT ina_insumo_antigoT) {
    this.ina_insumo_antigoT = ina_insumo_antigoT;
  }

  public Ina_insumo_antigoT getIna_insumo_antigoT() {	
    return ina_insumo_antigoT;
  }


	
  private List<Ina_insumo_antigoT> list;

  public List<Ina_insumo_antigoT> getList() {
    return list;
  }
  
  public void setList(List<Ina_insumo_antigoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void consultEquiv() throws Exception {
    try {
      Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
      list = ina_insumo_antigoDAO.getAllEquiv(inn_nr_id);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");
    } finally {
	close();
    }
  }

  public void consult() throws Exception {
    try {
      Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
      list = ina_insumo_antigoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();
      ina_insumo_antigoDAO.delete(ina_insumo_antigoT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      ina_insumo_antigoT = new Ina_insumo_antigoT();
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
	  String page = "ina_insumo_antigoInsert.jsp";// defina aqui a p�gina que deve ser chamada  
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
     * @return the inn_nr_id
     */
    public int getInn_nr_id() {
        return inn_nr_id;
    }

    /**
     * @param inn_nr_id the inn_nr_id to set
     */
    public void setInn_nr_id(int inn_nr_id) {
        this.inn_nr_id = inn_nr_id;
    }

}
