package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Emp_empreendimentoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Emp_empreendimentoT emp_empreendimentoT = new Emp_empreendimentoT();
    private DataSet ds = new DataSet();

  public void setEmp_empreendimentoT(Emp_empreendimentoT emp_empreendimentoT) {
    this.emp_empreendimentoT = emp_empreendimentoT;
  }

  public Emp_empreendimentoT getEmp_empreendimentoT() {	
    return emp_empreendimentoT;
  }


	
  private List<Emp_empreendimentoT> list;

  public List<Emp_empreendimentoT> getList() {
    return list;
  }
  
  public void setList(List<Emp_empreendimentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
      ds = emp_empreendimentoDAO.getAllDataSet();

    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");
    } finally {
	close();
    }
  }

  public void delete() throws Exception {
    try {
      Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
      emp_empreendimentoDAO.delete(emp_empreendimentoT);	 
      setMsg("Exclusão efetuada com sucesso!");
      emp_empreendimentoT = new Emp_empreendimentoT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "emp_empreendimentoInsert.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the ds
     */
    public DataSet getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DataSet ds) {
        this.ds = ds;
    }

}
