/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inn_insumo_novo.Inn_insumo_novoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Inn_insumo_novoTGWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class ListInnGWT implements IListenetResponse{


    public boolean povoado;
    public List<Inn_insumo_novoTGWT> list;

    public void povoa(String descricao){
        try {
            list = null;
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("inn_insumo_novoT.inn_tx_descricao", descricao);
            eaurl.accessJSonMap(Constantes.URL + Inn_insumo_novoConsultGWT.PAGE, param);
        } catch (Exception e) {
        }
    }
    
    public void read(JSONValue jsonValue) {
        povoado = false;
        try {
            //com.google.gwt.user.client.Window.alert(jsonValue.toString());
            list = new Vector<Inn_insumo_novoTGWT>();
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                for (int i = 1; i < resultado.size(); i++) {
                    Inn_insumo_novoTGWT obj = new Inn_insumo_novoTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("inn_nr_id").toString()));
                    obj.setInn_nr_id(id);

                    String dispaly = EasyContainer.clearAspas(registro.get("inn_tx_descricao").toString());
                    obj.setInn_tx_descricao(dispaly);

                    String inn_tx_codigo = EasyContainer.clearAspas(registro.get("inn_tx_codigo").toString());
                    obj.setInn_tx_codigo(inn_tx_codigo);

                    String inn_tx_unidade = EasyContainer.clearAspas(registro.get("inn_tx_unidade").toString());
                    obj.setInn_tx_unidade(inn_tx_unidade);
                    list.add(obj);
                }
            }

        } catch (Exception e) {
        } finally {
            povoado = true;
        }
    }

}
