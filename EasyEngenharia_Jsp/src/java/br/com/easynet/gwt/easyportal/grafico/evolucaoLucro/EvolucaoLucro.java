/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.grafico.evolucaoLucro;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Evl_evolucao_lucroDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.transfer.Evl_evolucao_lucroT;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class EvolucaoLucro extends RelatorioBase implements INotSecurity {

    private List<Meo_meses_obraT> list = new Vector();
    private TreeMap<String,Float> treeOrig = new TreeMap<String, Float>();
    private TreeMap<String,Float> treeMetas = new TreeMap<String, Float>();

    public void imprimir() {
        try {

            povoaObjeto();
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = EvolucaoLucro.class.getResourceAsStream("evolucaoLucro.jasper");
            } else {
                url = EvolucaoLucro.class.getResource("evolucaoLucro.jasper");
            }
            jRDataSource = new JRBeanCollectionDataSource(list);
            String filename = "evolucaoLucro" + getMeo_meses_obraT().getMes() + "." + getMeo_meses_obraT().getAno();
            print(filename, "GRÁFICO - EVOLUÇÃO DOS LUCROS");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void povoaObjeto() throws Exception {
        try {
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            list = obr_obrasDAO.getAllMeses(getObr_obrasT());

            Evl_evolucao_lucroDAO edao = getEvl_evolucao_lucroDAO();
            Evl_evolucao_lucroT evl_evolucao_lucroT = new Evl_evolucao_lucroT();
            evl_evolucao_lucroT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            evl_evolucao_lucroT.setEvl_nr_mes_ref(getMeo_meses_obraT().getMes());
            evl_evolucao_lucroT.setEvl_nr_ano_ref(getMeo_meses_obraT().getAno());
            List<Evl_evolucao_lucroT> listEvl = edao.getAllObraMesAnoRef(evl_evolucao_lucroT);

            for (Evl_evolucao_lucroT evl_evolucao_lucroT1 : listEvl) {
                String key = evl_evolucao_lucroT1.getEvl_nr_mes()+"."+evl_evolucao_lucroT1.getEvl_nr_ano();
                float valor = evl_evolucao_lucroT1.getEvl_nr_valor();
                if(evl_evolucao_lucroT1.getEvl_tx_tipo().equalsIgnoreCase("O")){
                    treeOrig.put(key, valor);
                }else{
                    treeMetas.put(key, valor);
                }
            }

            for (Meo_meses_obraT meo_meses_obraT : list) {
                String key = meo_meses_obraT.getMes()+"."+meo_meses_obraT.getAno();
                if(treeMetas.get(key) != null){
                    meo_meses_obraT.setCalc_quantidade_copia(treeMetas.get(key));
                }
                if(treeOrig.get(key) != null){
                    meo_meses_obraT.setCalc_quantidade_original(treeOrig.get(key));
                }
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
