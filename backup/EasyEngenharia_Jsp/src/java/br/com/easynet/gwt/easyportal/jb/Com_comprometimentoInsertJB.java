package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Com_comprometimentoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Com_comprometimentoT com_comprometimentoT = new Com_comprometimentoT();

  public void setCom_comprometimentoT(Com_comprometimentoT com_comprometimentoT) {
    this.com_comprometimentoT = com_comprometimentoT;
  }

  public Com_comprometimentoT getCom_comprometimentoT() {	
    return com_comprometimentoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//

  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Com_comprometimentoDAO com_comprometimentoDAO =  getCom_comprometimentoDAO();
      com_comprometimentoDAO.insert(com_comprometimentoT);	 
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
	private List<Obr_obrasT> listobr_obras;
	public List<Obr_obrasT> getListobr_obras() {
		return listobr_obras;
	}

	 public void setListobr_obras(List<Obr_obrasT> list) {
		this.listobr_obras=list;
	}



  
  public void clear() throws Exception {
    
      com_comprometimentoT = new Com_comprometimentoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "com_comprometimentoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
