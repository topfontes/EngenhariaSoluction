package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Nfe_nota_fiscal_entradaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT = new Nfe_nota_fiscal_entradaT();

  public void setNfe_nota_fiscal_entradaT(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) {
    this.nfe_nota_fiscal_entradaT = nfe_nota_fiscal_entradaT;
  }

  public Nfe_nota_fiscal_entradaT getNfe_nota_fiscal_entradaT() {	
    return nfe_nota_fiscal_entradaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO =  getNfe_nota_fiscal_entradaDAO();
      nfe_nota_fiscal_entradaDAO.insert(nfe_nota_fiscal_entradaT);	 
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
    
      nfe_nota_fiscal_entradaT = new Nfe_nota_fiscal_entradaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "nfe_nota_fiscal_entradaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
