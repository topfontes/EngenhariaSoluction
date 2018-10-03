package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqi_equivalencia_insumoInsertJB extends SystemBase implements INotSecurity{

    private String[] idsIna;
    private String idInn;
    private boolean imprimir;

  // Atributos e propriedades
    private Eqi_equivalencia_insumoT eqi_equivalencia_insumoT = new Eqi_equivalencia_insumoT();

  public void setEqi_equivalencia_insumoT(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) {
    this.eqi_equivalencia_insumoT = eqi_equivalencia_insumoT;
  }

  public Eqi_equivalencia_insumoT getEqi_equivalencia_insumoT() {	
    return eqi_equivalencia_insumoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }
  public void addEquivalencia() throws Exception{
      DAOFactory factory = null;
      Eplc_equivalencia_plano_contasDAO edao = null;
      try {
          edao = getEplc_equivalencia_plano_contasDAO();
          factory = edao.getDAOFactory();
          factory.beginTransaction();
          for (int i = 0; i < idsIna.length; i++) {
              Eqi_equivalencia_insumoT eqi = new Eqi_equivalencia_insumoT();
              eqi.setInn_nr_id(Integer.parseInt(idInn));
              eqi.setIna_nr_id(Integer.parseInt(idsIna[i]));
              getEqi_equivalencia_insumoDAO().insert(eqi);
          }
          factory.commitTransaction();
          //consult();
      } catch (Exception e) {
          e.printStackTrace();
          factory.rollbackTransaction();
      }finally{
          close();
      }
  }
  // M�todos de Eventos
  public void insert() throws Exception {
    
    try {
      Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO =  getEqi_equivalencia_insumoDAO();
      eqi_equivalencia_insumoDAO.insert(getEqi_equivalencia_insumoT());
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
    
        setEqi_equivalencia_insumoT(new Eqi_equivalencia_insumoT());
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "eqi_equivalencia_insumoConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the idsIna
     */
    public String[] getIdsIna() {
        return idsIna;
    }

    /**
     * @param idsIna the idsIna to set
     */
    public void setIdsIna(String[] idsIna) {
        this.idsIna = idsIna;
    }

    /**
     * @return the idInn
     */
    public String getIdInn() {
        return idInn;
    }

    /**
     * @param idInn the idInn to set
     */
    public void setIdInn(String idInn) {
        this.idInn = idInn;
    }

    /**
     * @return the imprimir
     */
    public boolean isImprimir() {
        return imprimir;
    }

    /**
     * @param imprimir the imprimir to set
     */
    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }

}
