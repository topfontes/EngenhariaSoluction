package br.com.easynet.gwt.easyportal.jb;

import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Par_parcelamentoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Par_parcelamentoT par_parcelamentoT = new Par_parcelamentoT();
    private int[] intervalo;

  public void setPar_parcelamentoT(Par_parcelamentoT par_parcelamentoT) {
    this.par_parcelamentoT = par_parcelamentoT;
  }

  public Par_parcelamentoT getPar_parcelamentoT() {	
    return par_parcelamentoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    DAOFactory dAOFactory = null;
    try {
      Par_parcelamentoDAO par_parcelamentoDAO =  getPar_parcelamentoDAO();
      dAOFactory = getDAO();
      dAOFactory.beginTransaction();
      Inp_intervalo_parcelaDAO idao = getInp_intervalo_parcelaDAO();
      par_parcelamentoDAO.insert(par_parcelamentoT);
        for (int i = 0; i < intervalo.length; i++) {
            Inp_intervalo_parcelaT it = new Inp_intervalo_parcelaT();
            it.setPar_nr_id(par_parcelamentoT.getPar_nr_id());
            it.setInp_nr_sequencia((i+1));
            it.setInp_nr_dias(intervalo[i]);
            idao.insert(it);
        }

      dAOFactory.commitTransaction();
      setMsg("Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
        dAOFactory.rollbackTransaction();
      e.printStackTrace();
      setMsg("Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      par_parcelamentoT = new Par_parcelamentoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "par_parcelamentoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the intervalo
     */
    public int[] getIntervalo() {
        return intervalo;
    }

    /**
     * @param intervalo the intervalo to set
     */
    public void setIntervalo(int[] intervalo) {
        this.intervalo = intervalo;
    }

}
