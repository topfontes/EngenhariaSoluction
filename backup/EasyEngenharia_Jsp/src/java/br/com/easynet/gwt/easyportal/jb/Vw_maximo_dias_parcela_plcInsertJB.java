package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_maximo_dias_parcela_plcInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT = new Vw_maximo_dias_parcela_plcT();

  public void setVw_maximo_dias_parcela_plcT(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) {
    this.vw_maximo_dias_parcela_plcT = vw_maximo_dias_parcela_plcT;
  }

  public Vw_maximo_dias_parcela_plcT getVw_maximo_dias_parcela_plcT() {	
    return vw_maximo_dias_parcela_plcT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_maximo_dias_parcela_plcDAO vw_maximo_dias_parcela_plcDAO =  getVw_maximo_dias_parcela_plcDAO();
      vw_maximo_dias_parcela_plcDAO.insert(vw_maximo_dias_parcela_plcT);	 
      setMsg("Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      vw_maximo_dias_parcela_plcT = new Vw_maximo_dias_parcela_plcT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_maximo_dias_parcela_plcConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
