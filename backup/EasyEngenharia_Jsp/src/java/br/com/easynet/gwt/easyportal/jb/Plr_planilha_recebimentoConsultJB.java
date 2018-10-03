package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plr_planilha_recebimentoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Plr_planilha_recebimentoT plr_planilha_recebimentoT = new Plr_planilha_recebimentoT();
                                      
  public void setPlr_planilha_permutaT(Plr_planilha_recebimentoT plr_planilha_recebimentoT) {
    this.plr_planilha_recebimentoT = plr_planilha_recebimentoT;
  }

  public Plr_planilha_recebimentoT getPlr_planilha_recebimentoT() {
    return plr_planilha_recebimentoT;
  }


	
  private List<Plr_planilha_recebimentoT> list;

  public List<Plr_planilha_recebimentoT> getList() {
    return list;
  }
  
  public void setList(List<Plr_planilha_recebimentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void consult() throws Exception {
    try {
      Plr_planilha_recebimentoDAO plr_planilha_permutaDAO = getPlr_planilha_permutaDAO();
      list = plr_planilha_permutaDAO.getAll(plr_planilha_recebimentoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Plr_planilha_recebimentoDAO plr_planilha_permutaDAO = getPlr_planilha_permutaDAO();
      plr_planilha_permutaDAO.delete(plr_planilha_recebimentoT);
      setMsg("Exclus�o efetuada com sucesso!");
      plr_planilha_recebimentoT = new Plr_planilha_recebimentoT();
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
	  String page = "plr_planilha_permutaInsert.jsp";// defina aqui a p�gina que deve ser chamada  
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
