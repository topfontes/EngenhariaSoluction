package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Inc_informacoes_custoConsultJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Inc_informacoes_custoT inc_informacoes_custoT = new Inc_informacoes_custoT();

  public void setInc_informacoes_custoT(Inc_informacoes_custoT inc_informacoes_custoT) {
    this.inc_informacoes_custoT = inc_informacoes_custoT;
  }

  public Inc_informacoes_custoT getInc_informacoes_custoT() {	
    return inc_informacoes_custoT;
  }


	
  private List<Inc_informacoes_custoT> list;

  public List<Inc_informacoes_custoT> getList() {
    return list;
  }
  
  public void setList(List<Inc_informacoes_custoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Inc_informacoes_custoDAO inc_informacoes_custoDAO = getInc_informacoes_custoDAO();
      list = inc_informacoes_custoDAO.getByInformacaoCusto(inc_informacoes_custoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Inc_informacoes_custoDAO inc_informacoes_custoDAO = getInc_informacoes_custoDAO();
      inc_informacoes_custoDAO.delete(inc_informacoes_custoT);	 
      setMsg("Exclus�o efetuada com sucesso!");
      inc_informacoes_custoT = new Inc_informacoes_custoT();
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
	  String page = "inc_informacoes_custoInsert.jsp";// defina aqui a p�gina que deve ser chamada  
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
