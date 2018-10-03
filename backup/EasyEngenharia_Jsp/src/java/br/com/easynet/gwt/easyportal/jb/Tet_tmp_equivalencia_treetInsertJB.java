package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tet_tmp_equivalencia_treetInsertJB extends SystemBase {

  // Atributos e propriedades
    private Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT = new Tet_tmp_equivalencia_treetT();

  public void setTet_tmp_equivalencia_treetT(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) {
    this.tet_tmp_equivalencia_treetT = tet_tmp_equivalencia_treetT;
  }

  public Tet_tmp_equivalencia_treetT getTet_tmp_equivalencia_treetT() {	
    return tet_tmp_equivalencia_treetT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO =  getTet_tmp_equivalencia_treetDAO();
      tet_tmp_equivalencia_treetDAO.insert(tet_tmp_equivalencia_treetT);	 
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
    
      tet_tmp_equivalencia_treetT = new Tet_tmp_equivalencia_treetT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tet_tmp_equivalencia_treetConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
