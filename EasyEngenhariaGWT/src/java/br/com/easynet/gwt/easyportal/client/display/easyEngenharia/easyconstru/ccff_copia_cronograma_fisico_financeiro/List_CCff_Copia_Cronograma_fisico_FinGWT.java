/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ccff_copia_cronograma_fisico_financeiro;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Ccff_copia_cronograma_fisico_financeiroTGWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */

public class List_CCff_Copia_Cronograma_fisico_FinGWT implements IListenetResponse {
     private List<Ccff_copia_cronograma_fisico_financeiroTGWT> list;
     private TreeMap<String,Ccff_copia_cronograma_fisico_financeiroTGWT> treeCCff = new TreeMap<String, Ccff_copia_cronograma_fisico_financeiroTGWT>();
    private boolean mostrar;

    public void povoaSuper(int obr_nr_id, int id_super) throws Exception{
            //Window.alert(Constantes.URL + Ccff_copia_cronograma_fisico_financeiroConsultGWT.PAGE+"?op=consultSuperConta&vw_importacao_orcamentoT.obr_nr_id="+obr_nr_id+"&vw_importacao_orcamentoT.ipo_nr_id_nivel_1="+id_super);
            mostrar = false;
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("op", "consultSuperConta");
            map.put("vw_importacao_orcamentoT.obr_nr_id", obr_nr_id + "");
            map.put("vw_importacao_orcamentoT.ipo_nr_id_nivel_1", id_super + "");
            eaurl.accessJSonMap(Constantes.URL + Ccff_copia_cronograma_fisico_financeiroConsultGWT.PAGE, map);

    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;

        list = new ArrayList<Ccff_copia_cronograma_fisico_financeiroTGWT>();
        treeCCff = new TreeMap<String, Ccff_copia_cronograma_fisico_financeiroTGWT>();
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            //Window.alert(resultado.toString());
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Ccff_copia_cronograma_fisico_financeiroTGWT obj = new Ccff_copia_cronograma_fisico_financeiroTGWT();

                Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ccff_nr_id").toString()));
                obj.setCcff_nr_id(id);

                Integer ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("ccff_nr_ano").toString()));
                obj.setCcff_nr_ano(ano);

                Integer mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("ccff_nr_mes").toString()));
                obj.setCcff_nr_mes(mes);

                float peso = Float.parseFloat(EasyContainer.clearAspas(registro.get("ccff_nr_peso").toString()));
                obj.setCcff_nr_peso(peso);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                obj.setObr_nr_id(obr_nr_id);

                Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                obj.setPlco_nr_id(plco_nr_id);

                Integer id_super = Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id_super").toString()));
                obj.setIpo_nr_id_super(id_super);

                Integer ipo_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id").toString()));
                obj.setIpo_nr_id(ipo_nr_id);
                String key = obr_nr_id + "." + plco_nr_id + "." + mes + "." + ano + "." + id_super + "." + ipo_nr_id;
                
                treeCCff.put(key, obj);


                list.add(obj);
            }

    }
        mostrar = true;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    /**
     * @param mostrar the mostrar to set
     */
    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    /**
     * @return the list
     */
    public List<Ccff_copia_cronograma_fisico_financeiroTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Ccff_copia_cronograma_fisico_financeiroTGWT> list) {
        this.list = list;
    }

    /**
     * @return the treeCCff
     */
    public TreeMap<String, Ccff_copia_cronograma_fisico_financeiroTGWT> getTreeCCff() {
        return treeCCff;
    }

    /**
     * @param treeCCff the treeCCff to set
     */
    public void setTreeCCff(TreeMap<String, Ccff_copia_cronograma_fisico_financeiroTGWT> treeCCff) {
        this.treeCCff = treeCCff;
    }
}
