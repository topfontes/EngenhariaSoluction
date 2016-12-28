/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ina_insumo_antigo.Ina_insumo_antigoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Ina_insumo_antigoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
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
public class listInaGWT implements IListenetResponse{

    public boolean povoado;
    public List<Ina_insumo_antigoTGWT> list;

    public void povoa(){
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("op", "consult");
            eaurl.accessJSonMap(Constantes.URL + Ina_insumo_antigoConsultGWT.PAGE,param);
            //com.google.gwt.user.client.Window.alert(Constantes.URL + Ina_insumo_antigoConsultGWT.PAGE);
        } catch (Exception e) {
        }
    }

        public void povoaEquiv(int inn_nr_id){
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("op", "consultEquiv");
            param.put("inn_nr_id", inn_nr_id+"");
            eaurl.accessJSonMap(Constantes.URL + Ina_insumo_antigoConsultGWT.PAGE,param);
            //com.google.gwt.user.client.Window.alert(Constantes.URL + Ina_insumo_antigoConsultGWT.PAGE);
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        povoado = false;
        list = new Vector<Ina_insumo_antigoTGWT>();
        
        try {
            
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                for (int i = 1; i < resultado.size(); i++) {
                    Ina_insumo_antigoTGWT obj = new Ina_insumo_antigoTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ina_nr_id").toString()));
                    obj.setIna_nr_id(id);
                    
                    String dispaly = EasyContainer.clearAspas(registro.get("ina_tx_descricao").toString());
                    obj.setIna_tx_descricao(dispaly);

                    String ina_tx_codigo = EasyContainer.clearAspas(registro.get("ina_tx_codigo").toString());
                    obj.setIna_tx_codigo(ina_tx_codigo);

                    String ina_tx_unidade = EasyContainer.clearAspas(registro.get("ina_tx_unidade").toString());
                    obj.setIna_tx_unidade(ina_tx_unidade);
                    list.add(obj);
                }
            }
        } catch (Exception e) {
        } finally {
            povoado = true;
        }
    }

}
