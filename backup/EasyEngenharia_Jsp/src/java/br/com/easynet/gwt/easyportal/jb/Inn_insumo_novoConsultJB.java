package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Inn_insumo_novoConsultJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Inn_insumo_novoT inn_insumo_novoT = new Inn_insumo_novoT();

  public void setInn_insumo_novoT(Inn_insumo_novoT inn_insumo_novoT) {
    this.inn_insumo_novoT = inn_insumo_novoT;
  }

  public Inn_insumo_novoT getInn_insumo_novoT() {	
    return inn_insumo_novoT;
  }


	
  private List<Inn_insumo_novoT> list;

  public List<Inn_insumo_novoT> getList() {
    return list;
  }
  
  public void setList(List<Inn_insumo_novoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
      list = inn_insumo_novoDAO.getByInn_tx_descricao(inn_insumo_novoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
      inn_insumo_novoDAO.delete(inn_insumo_novoT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      inn_insumo_novoT = new Inn_insumo_novoT();
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
	  String page = "inn_insumo_novoInsert.jsp";// defina aqui a p�gina que deve ser chamada  
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
