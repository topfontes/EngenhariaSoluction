package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plc_plano_contasInsertJB extends SystemBase {

  // Atributos e propriedades
    private Plc_plano_contasT plc_plano_contasT = new Plc_plano_contasT();

  public void setPlc_plano_contasT(Plc_plano_contasT plc_plano_contasT) {
    this.plc_plano_contasT = plc_plano_contasT;
  }

  public Plc_plano_contasT getPlc_plano_contasT() {	
    return plc_plano_contasT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Plc_plano_contasDAO plc_plano_contasDAO =  getPlc_plano_contasDAO();
      plc_plano_contasDAO.insert(plc_plano_contasT);	 
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
    
      plc_plano_contasT = new Plc_plano_contasT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "plc_plano_contasConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
