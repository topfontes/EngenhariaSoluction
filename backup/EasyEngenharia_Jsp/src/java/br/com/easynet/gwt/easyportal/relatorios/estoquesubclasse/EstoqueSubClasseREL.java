/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.relatorios.estoquesubclasse;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.EstoqueTMP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class EstoqueSubClasseREL extends RelatorioBase{
    private DataSet ds;
    private int plc_nr_id;
                
    private String subClasse;
    private List<EstoqueTMP> list ;
    private float total;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir(){
        Est_estoqueDAO edao = null;
        try {
            edao = getEst_estoqueDAO();
            ds = edao.estoqueMesSubClasse(getObr_obrasT().getObr_nr_id(), getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), plc_nr_id);
            povoaDs();
            calcularPeso();
            OrdenarList();
            ordenarListDecrecente();
            getParameters().put("subClasse", subClasse);
            jRDataSource = new JRBeanCollectionDataSource(list);
            if(getTipo().equalsIgnoreCase("XLS")){
                url = EstoqueSubClasseREL.class.getResource("estoqueSubClasse.jasper");
            }else{
                is = EstoqueSubClasseREL.class.getResourceAsStream("estoqueSubClasse.jasper");
            }
            
            print("EstoqueSubClasse", "ESTOQUE POR SUB-CLASSE");

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close();
        }
        
    }
    public void povoaDs(){
        total = 0;
        list = new Vector();
        for (int i = 0; i < ds.getList().size(); i++) {
            EstoqueTMP estoqueTMP = new EstoqueTMP();
            estoqueTMP.setPlc_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
            estoqueTMP.setPlc_tx_nome(ds.getList().get(i).getColumn("plc_tx_nome").toString());
            estoqueTMP.setEst_nr_vl_total(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
            total += estoqueTMP.getEst_nr_vl_total();
            list.add(estoqueTMP);
        }
        
    }
    public void calcularPeso(){
        for (EstoqueTMP estoqueTMP : list) {
            estoqueTMP.setEst_nr_vl_unitario(estoqueTMP.getEst_nr_vl_total() * 100/total);
        }
    }

    public void OrdenarList(){
        Collections.sort(list, new Comparator(){
            public int compare(Object o1, Object o2) {
                EstoqueTMP classeTMP = (EstoqueTMP) o1;
                EstoqueTMP classeTMP2 = (EstoqueTMP) o2;
                Float valor1 = classeTMP != null? classeTMP.getEst_nr_vl_total():0;
                Float valor2 = classeTMP2 != null? classeTMP2.getEst_nr_vl_total():0;
                return valor1.compareTo(valor2);
            }
        });
    }

    public void ordenarListDecrecente(){
        List<EstoqueTMP> listTemp = new ArrayList<EstoqueTMP>();
        for (int i = (list.size()-1); i > -1 ; i--) {
            EstoqueTMP classeTMP = list.get(i);
            listTemp.add(classeTMP);
        }
        list.clear();
        list = listTemp;
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
