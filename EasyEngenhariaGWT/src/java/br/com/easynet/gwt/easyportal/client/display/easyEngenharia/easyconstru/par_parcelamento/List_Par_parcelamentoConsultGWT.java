/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.par_parcelamento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Par_parcelamentoTGWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */
public class List_Par_parcelamentoConsultGWT implements IListenetResponse {

    private List<Par_parcelamentoTGWT> list;
    public boolean povoado;
    private TreeMap<Integer, Par_parcelamentoTGWT> treeParcela = new TreeMap<Integer, Par_parcelamentoTGWT>();
//1

    public void povoa() {
        try {
            povoado = false;
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            eaurl.accessJSonMap(Constantes.URL + Par_parcelamentoConsultGWT.PAGE, param);
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {

        povoado = false;
        list = new ArrayList<Par_parcelamentoTGWT>();
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
//            com.google.gwt.user.client.Window.alert(resultado.toString());
            for (int i = 1; i < resultado.size(); i++) {
                Par_parcelamentoTGWT obj = new Par_parcelamentoTGWT();
                JSONObject registro = resultado.get(i).isObject();
//                com.google.gwt.user.client.Window.alert("1");
                Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("par_nr_id").toString()));
//                com.google.gwt.user.client.Window.alert("2");

                obj.setPar_nr_id(id);
//                com.google.gwt.user.client.Window.alert("3");
                String dispaly = EasyContainer.clearAspas(registro.get("par_tx_nome").toString());
//                com.google.gwt.user.client.Window.alert("4");
                obj.setPar_tx_nome(dispaly);
                getList().add(obj);
                getTreeParcela().put(id, obj);
            }
        }
        povoado = true;
    }

    /**
     * @return the list
     */
    public List<Par_parcelamentoTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Par_parcelamentoTGWT> list) {
        this.list = list;
    }

    /**
     * @return the treeParcela
     */
    public TreeMap<Integer, Par_parcelamentoTGWT> getTreeParcela() {
        return treeParcela;
    }
}
