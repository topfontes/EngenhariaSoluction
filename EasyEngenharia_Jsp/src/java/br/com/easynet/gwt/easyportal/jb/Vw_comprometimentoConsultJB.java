package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_comprometimentoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Vw_comprometimentoT vw_comprometimentoT = new Vw_comprometimentoT();
    private boolean previsto;
    private Com_comprometimentoT com_comprometimentoT = new Com_comprometimentoT();

  public void setVw_comprometimentoT(Vw_comprometimentoT vw_comprometimentoT) {
    this.vw_comprometimentoT = vw_comprometimentoT;
  }

  public Vw_comprometimentoT getVw_comprometimentoT() {	
    return vw_comprometimentoT;
  }
	
  private List<Vw_comprometimentoT> list;

  public List<Vw_comprometimentoT> getList() {
    return list;
  }
  
  public void setList(List<Vw_comprometimentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        
  }

  public void consult() throws Exception {
    try {
      Vw_comprometimentoDAO vw_comprometimentoDAO = getVw_comprometimentoDAO();
      list = vw_comprometimentoDAO.getAll(vw_comprometimentoT, previsto);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Com_comprometimentoDAO comprometimentoDAO = getCom_comprometimentoDAO();
      comprometimentoDAO.delete(com_comprometimentoT);
      setMsg("Exclusão efetuada com sucesso!");
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
	  String page = "vw_comprometimentoInsert.jsp";// defina aqui a página que deve ser chamada  
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
     * @return the previsto
     */
    public boolean isPrevisto() {
        return previsto;
    }

    /**
     * @param previsto the previsto to set
     */
    public void setPrevisto(boolean previsto) {
        this.previsto = previsto;
    }

    /**
     * @return the com_comprometimentoT
     */
    public Com_comprometimentoT getCom_comprometimentoT() {
        return com_comprometimentoT;
    }

    /**
     * @param com_comprometimentoT the com_comprometimentoT to set
     */
    public void setCom_comprometimentoT(Com_comprometimentoT com_comprometimentoT) {
        this.com_comprometimentoT = com_comprometimentoT;
    }

}
