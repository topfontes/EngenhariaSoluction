package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.jdragon.dao.DAOFactory;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_equivalenciaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Vw_equivalenciaT vw_equivalenciaT = new Vw_equivalenciaT();
    private Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT = new Eplc_equivalencia_plano_contasT();
    
    private String[] idsPlco;
    private String idPlc;
    private boolean imprimir;

  public void setVw_equivalenciaT(Vw_equivalenciaT vw_equivalenciaT) {
    this.vw_equivalenciaT = vw_equivalenciaT;
  }

  public Vw_equivalenciaT getVw_equivalenciaT() {	
    return vw_equivalenciaT;
  }
	
  private List<Vw_equivalenciaT> list;

  public List<Vw_equivalenciaT> getList() {
    return list;
  }
  
  public void setList(List<Vw_equivalenciaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
//        consult();
  }

  public void consult() throws Exception {
    try {
      Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();
      if (vw_equivalenciaT.getPlc_nr_id() > 0 ){
        list = vw_equivalenciaDAO.getByPlc_nr_id(vw_equivalenciaT);
      }else{
        list = vw_equivalenciaDAO.getAll();
      }
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Eplc_equivalencia_plano_contasDAO dAO = getEplc_equivalencia_plano_contasDAO();
      dAO.delete(eplc_equivalencia_plano_contasT);
      setMsg("Exclusãoo efetuada com sucesso!");
      vw_equivalenciaT = new Vw_equivalenciaT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");	
    } finally {
	close();
    }
  }

  public void addEquivalencia() throws Exception{
      DAOFactory factory = null;
      Eplc_equivalencia_plano_contasDAO edao = null;
      try {
          edao = getEplc_equivalencia_plano_contasDAO();
          factory = edao.getDAOFactory();
          factory.beginTransaction();
          for (int i = 0; i < idsPlco.length; i++) {
              Eplc_equivalencia_plano_contasT eplco = new Eplc_equivalencia_plano_contasT();
              eplco.setPlc_nr_id(Integer.parseInt(idPlc));
              eplco.setPlco_nr_id(Integer.parseInt(idsPlco[i]));
              edao.insert(eplco);
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

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "vw_equivalenciaInsert.jsp";// defina aqui a página que deve ser chamada  
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
     * @return the idsplco
     */
    public String[] getIdsPlco() {
        return idsPlco;
    }

    /**
     * @param idsplco the idsplco to set
     */
    public void setIdsPlco(String[] idsPlco) {
        this.idsPlco = idsPlco;
    }

    /**
     * @return the idPlc
     */
    public String getIdPlc() {
        return idPlc;
    }

    public void setIdPlc(String idPlc) {
        this.idPlc = idPlc;
    }

    public Eplc_equivalencia_plano_contasT getEplc_equivalencia_plano_contasT() {
        return eplc_equivalencia_plano_contasT;
    }

    public void setEplc_equivalencia_plano_contasT(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) {
        this.eplc_equivalencia_plano_contasT = eplc_equivalencia_plano_contasT;
    }

}
