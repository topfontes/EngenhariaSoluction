package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Inp_intervalo_parcelaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Inp_intervalo_parcelaT inp_intervalo_parcelaT = new Inp_intervalo_parcelaT();

  public void setInp_intervalo_parcelaT(Inp_intervalo_parcelaT inp_intervalo_parcelaT) {
    this.inp_intervalo_parcelaT = inp_intervalo_parcelaT;
  }

  public Inp_intervalo_parcelaT getInp_intervalo_parcelaT() {	
    return inp_intervalo_parcelaT;
  }


	
  private List<Inp_intervalo_parcelaT> list;

  public List<Inp_intervalo_parcelaT> getList() {
    return list;
  }
  
  public void setList(List<Inp_intervalo_parcelaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }
    public void consult_IdParcela() {
        try {
            Inp_intervalo_parcelaDAO idao = getInp_intervalo_parcelaDAO();
            list = idao.getByPar_nr_id(inp_intervalo_parcelaT);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
  public void consult() throws Exception {
    try {
      Inp_intervalo_parcelaDAO inp_intervalo_parcelaDAO = getInp_intervalo_parcelaDAO();
      list = inp_intervalo_parcelaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Inp_intervalo_parcelaDAO inp_intervalo_parcelaDAO = getInp_intervalo_parcelaDAO();
      inp_intervalo_parcelaDAO.delete(inp_intervalo_parcelaT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      inp_intervalo_parcelaT = new Inp_intervalo_parcelaT();
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
	  String page = "inp_intervalo_parcelaInsert.jsp";// defina aqui a p�gina que deve ser chamada  
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
