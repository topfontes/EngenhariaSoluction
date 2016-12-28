/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cffo_cronograma_fisico_financeiro_origenal;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Cffo_cronograma_fisico_financeiro_origenalTGWT;
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
public class List_Cronograma_fisico_financeiroGWT implements IListenetResponse {

    private List<Cffo_cronograma_fisico_financeiro_origenalTGWT> list;
    private boolean mostrar;
    private  TreeMap<String,Cffo_cronograma_fisico_financeiro_origenalTGWT> treeCffo = new TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalTGWT>();

    public void povoaSuper(int obr_nr_id, int id_super) throws Exception {
        mostrar = false;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("op", "consultSuperConta");
        map.put("vw_importacao_orcamentoT.obr_nr_id", obr_nr_id + "");
        map.put("vw_importacao_orcamentoT.ipo_nr_id_nivel_1", id_super + "");
        //Window.alert(Constantes.URL + Cffo_cronograma_fisico_financeiro_origenalConsultGWT.PAGE+"?op=consultSuperConta&vw_importacao_orcamentoT.obr_nr_id="+obr_nr_id+"&vw_importacao_orcamentoT.ipo_nr_id_nivel_1 ="+id_super);
        eaurl.accessJSonMap(Constantes.URL + Cffo_cronograma_fisico_financeiro_origenalConsultGWT.PAGE, map);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;

        treeCffo = new TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalTGWT>();
        list = new ArrayList<Cffo_cronograma_fisico_financeiro_origenalTGWT>();
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            //Window.alert(resultado.toString());
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Cffo_cronograma_fisico_financeiro_origenalTGWT obj = new Cffo_cronograma_fisico_financeiro_origenalTGWT();
                Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cffo_nr_id").toString()));
                obj.setCffo_nr_id(id);
                Integer ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("cffo_nr_ano").toString()));
                obj.setCffo_nr_ano(ano);
                Integer mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("cffo_nr_mes").toString()));
                obj.setCffo_nr_mes(mes);
                float peso = Float.parseFloat(EasyContainer.clearAspas(registro.get("cffo_nr_peso").toString()));
                obj.setCffo_nr_peso(peso);
                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                obj.setObr_nr_id(obr_nr_id);
                Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                obj.setPlco_nr_id(plco_nr_id);

                Integer ipo_nr_id_super = Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id_super").toString()));
                obj.setIpo_nr_id_super(ipo_nr_id_super);

                Integer ipo_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id").toString()));
                obj.setIpo_nr_id(ipo_nr_id);
                list.add(obj);
                String key = obr_nr_id + "." + plco_nr_id + "." + mes + "." + ano + "." + ipo_nr_id_super + "." + ipo_nr_id;

                getTreeCffo().put(key, obj);

            }
//            for (Cffo_cronograma_fisico_financeiro_origenalTGWT cffoT : list) {
//                Window.alert("mes = "+cffoT.getCffo_nr_mes()+" ano = "+cffoT.getCffo_nr_ano()+" obra ="+cffoT.getObr_nr_id()+" plco_nr_id="+cffoT.getPlco_nr_id()+" peso = "+cffoT.getCffo_nr_peso()+" id_super ="+cffoT.getIpo_nr_id_super());
//            }

        }
        mostrar = true;
    }

    /**
     * @return the store

    /**
     * @return the mostrar
     */
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
    public List<Cffo_cronograma_fisico_financeiro_origenalTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Cffo_cronograma_fisico_financeiro_origenalTGWT> list) {
        this.list = list;
    }

    /**
     * @return the treeCffo
     */
    public TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalTGWT> getTreeCffo() {
        return treeCffo;
    }

    /**
     * @param treeCffo the treeCffo to set
     */
    public void setTreeCffo(TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalTGWT> treeCffo) {
        this.treeCffo = treeCffo;
    }
}
