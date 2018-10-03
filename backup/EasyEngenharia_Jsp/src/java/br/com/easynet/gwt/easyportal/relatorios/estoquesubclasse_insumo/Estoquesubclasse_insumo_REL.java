/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.estoquesubclasse_insumo;

import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
import br.com.easynet.gwt.easyportal.dao.Plc_plano_contasDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.EstoqueTMP;
import br.com.easynet.gwt.easyportal.transfer.Est_estoqueT;
import br.com.easynet.gwt.easyportal.transfer.Plc_plano_contasT;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Estoquesubclasse_insumo_REL extends RelatorioBase implements INotSecurity{

    private int plc_nr_id;
    private String subClasse;
    private List<Est_estoqueT> list = new Vector();
    private float total;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        Est_estoqueDAO edao = null;
        try {

            Plc_plano_contasDAO pdao = getPlc_plano_contasDAO();
            TreeMap<Integer,Plc_plano_contasT> tree = pdao.getAllPlc();
            edao = getEst_estoqueDAO();
            Est_estoqueT est_estoqueT = new Est_estoqueT();
            est_estoqueT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            est_estoqueT.setEst_nr_ano(getMeo_meses_obraT().getAno());
            est_estoqueT.setEst_nr_mes(getMeo_meses_obraT().getMes());
            est_estoqueT.setPlc_nr_id(plc_nr_id);
            list = edao.getByObr_nr_idMesAno(est_estoqueT);


            setValueAgrupamento(tree);
            getParameters().put("subClasse", subClasse);

            jRDataSource = new JRBeanCollectionDataSource(list);
            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Estoquesubclasse_insumo_REL.class.getResource("EstoqueSubClasseInsumo_REL.jasper");
            } else {
                is = Estoquesubclasse_insumo_REL.class.getResourceAsStream("EstoqueSubClasseInsumo_REL.jasper");
            }
            print("EstoqueSubClasseInsumo", "ESTOQUE POR SUB-CLASSE /INSUMO");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }


    public void setValueAgrupamento(TreeMap<Integer,Plc_plano_contasT> tree){
        for (Est_estoqueT est_estoqueT : list) {
            est_estoqueT.setEst_tx_key(tree.get(est_estoqueT.getPlc_nr_id()).getPlc_tx_nome());
        }
    }
    /**
     * @return the plc_nr_id_super
     */
    public int getPlc_nr_id() {
        return plc_nr_id;
    }

    /**
     * @param plc_nr_id_super the plc_nr_id_super to set
     */
    public void setPlc_nr_id(int plc_nr_id) {
        this.plc_nr_id = plc_nr_id;
    }

    /**
     * @return the subClasse
     */
    public String getSubClasse() {
        return subClasse;
    }

    /**
     * @param subClasse the subClasse to set
     */
    public void setSubClasse(String subClasse) {
        this.subClasse = subClasse;
    }
}
