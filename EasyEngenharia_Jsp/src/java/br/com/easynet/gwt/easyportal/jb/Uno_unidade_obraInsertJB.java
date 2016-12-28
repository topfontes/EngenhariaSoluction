package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Uno_unidade_obraInsertJB extends SystemBase {

    // Atributos e propriedades
    private Uno_unidade_obraT uno_unidade_obraT = new Uno_unidade_obraT();
    private int[] vet_uni_nr_id;
    private int[] vet_quant;
    private double[] vet_area;

    public void setUno_unidade_obraT(Uno_unidade_obraT uno_unidade_obraT) {
        this.uno_unidade_obraT = uno_unidade_obraT;
    }

    public Uno_unidade_obraT getUno_unidade_obraT() {
        return uno_unidade_obraT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    // M�todos de Eventos
    public void insert() throws Exception {
      DAOFactory factory = null;
      try {
      Uno_unidade_obraDAO uno_unidade_obraDAO =  getUno_unidade_obraDAO();
      if (vet_area.length > 0){
          factory = uno_unidade_obraDAO.getDAOFactory();
          factory.beginTransaction();
          uno_unidade_obraDAO.deleteAllObra(uno_unidade_obraT);
            for (int i = 0; i < vet_uni_nr_id.length; i++) {
                uno_unidade_obraT.setUni_nr_id(vet_uni_nr_id[i]);
                uno_unidade_obraT.setUno_nr_quantidade(vet_quant[i]);
                uno_unidade_obraT.setUno_nr_area_construida(vet_area[i]); 
                uno_unidade_obraDAO.insert(uno_unidade_obraT);
            }
            setMsg("Cadastro efetuado com sucesso!");
            clear();
            factory.commitTransaction();
      }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
            factory.rollbackTransaction();
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
        this.listobr_obras = list;
    }

    public void consultObr_obras() throws Exception {
        try {
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            DataSet ds = obr_obrasDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        uno_unidade_obraT = new Uno_unidade_obraT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "uno_unidade_obraConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the vet_uni_nr_id
     */
    public int[] getVet_uni_nr_id() {
        return vet_uni_nr_id;
    }

    /**
     * @param vet_uni_nr_id the vet_uni_nr_id to set
     */
    public void setVet_uni_nr_id(int[] vet_uni_nr_id) {
        this.vet_uni_nr_id = vet_uni_nr_id;
    }

    /**
     * @return the vet_quant
     */
    public int[] getVet_quant() {
        return vet_quant;
    }

    /**
     * @param vet_quant the vet_quant to set
     */
    public void setVet_quant(int[] vet_quant) {
        this.vet_quant = vet_quant;
    }

    /**
     * @return the vet_area
     */
    public double[] getVet_area() {
        return vet_area;
    }

    /**
     * @param vet_area the vet_area to set
     */
    public void setVet_area(double[] vet_area) {
        this.vet_area = vet_area;
    }
}
