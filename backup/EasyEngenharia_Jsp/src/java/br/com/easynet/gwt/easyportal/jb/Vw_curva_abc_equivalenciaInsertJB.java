package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_curva_abc_equivalenciaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT = new Vw_curva_abc_equivalenciaT();

  public void setVw_curva_abc_equivalenciaT(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT) {
    this.vw_curva_abc_equivalenciaT = vw_curva_abc_equivalenciaT;
  }

  public Vw_curva_abc_equivalenciaT getVw_curva_abc_equivalenciaT() {	
    return vw_curva_abc_equivalenciaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_curva_abc_equivalenciaDAO vw_curva_abc_equivalenciaDAO =  getVw_curva_abc_equivalenciaDAO();
      vw_curva_abc_equivalenciaDAO.insert(vw_curva_abc_equivalenciaT);	 
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
    
      vw_curva_abc_equivalenciaT = new Vw_curva_abc_equivalenciaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_curva_abc_equivalenciaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
