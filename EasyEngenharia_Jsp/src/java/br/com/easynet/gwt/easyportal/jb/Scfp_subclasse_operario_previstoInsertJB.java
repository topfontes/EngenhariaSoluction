package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Scfp_subclasse_operario_previstoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT = new Scfp_subclasse_operario_previstoT();

  public void setScfp_subclasse_operario_previstoT(Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT) {
    this.scfp_subclasse_operario_previstoT = scfp_subclasse_operario_previstoT;
  }

  public Scfp_subclasse_operario_previstoT getScfp_subclasse_operario_previstoT() {	
    return scfp_subclasse_operario_previstoT;
  }
  private int id;

	
  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Scfp_subclasse_operario_previstoDAO scfp_subclasse_operario_previstoDAO =  getScfp_subclasse_operario_previstoDAO();
      scfp_subclasse_operario_previstoDAO.insert(scfp_subclasse_operario_previstoT);
      setId(scfp_subclasse_operario_previstoT.getScfp_nr_id());
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
	private List<Plc_plano_contasT> listplc_plano_contas;
	public List<Plc_plano_contasT> getListplc_plano_contas() {
		return listplc_plano_contas;
	}

	 public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
		this.listplc_plano_contas=list;
	}
	public void consultPlc_plano_contas() throws Exception {
		try {

		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      scfp_subclasse_operario_previstoT = new Scfp_subclasse_operario_previstoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "scfp_subclasse_operario_previstoConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
