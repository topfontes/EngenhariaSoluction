/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.coa_composicao_anterior.Coa_composicao_anteriorConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Coa_composicao_anteriorTGWT;
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
public class ListCoaGWT implements IListenetResponse{
    public boolean povoado;
    public List<Coa_composicao_anteriorTGWT> list;

    public void povoa(){
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("op", "consult");
            eaurl.accessJSonMap(Constantes.URL + Coa_composicao_anteriorConsultGWT.PAGE,param);
            //com.google.gwt.user.client.Window.alert(Constantes.URL + Ina_insumo_antigoConsultGWT.PAGE);
        } catch (Exception e) {
        }
    }

        public void povoaEquiv(int inn_nr_id){
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("op", "consultEquiv");
            param.put("con_nr_id", inn_nr_id+"");
            eaurl.accessJSonMap(Constantes.URL + Coa_composicao_anteriorConsultGWT.PAGE,param);
            //com.google.gwt.user.client.Window.alert(Constantes.URL + Ina_insumo_antigoConsultGWT.PAGE);
        } catch (Exception e) {
        }
    }
    public void read(JSONValue jsonValue) {
        povoado = false;
        try {

            list = new Vector<Coa_composicao_anteriorTGWT>();
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                for (int i = 1; i < resultado.size(); i++) {
                    Coa_composicao_anteriorTGWT obj = new Coa_composicao_anteriorTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("coa_nr_id").toString()));
                    obj.setCoa_nr_id(id);

                    String dispaly = EasyContainer.clearAspas(registro.get("coa_tx_descricao").toString());
                    obj.setCoa_tx_descricao(dispaly);

                    String coa_tx_codigo = EasyContainer.clearAspas(registro.get("coa_tx_codigo").toString());
                    obj.setCoa_tx_codigo(coa_tx_codigo);

                    String coa_tx_unidade = EasyContainer.clearAspas(registro.get("coa_tx_unidade").toString());
                    obj.setCoa_tx_unidade(coa_tx_unidade);
                    list.add(obj);
                }
            }

        } catch (Exception e) {
        } finally {
            povoado = true;
        }
    }

}
