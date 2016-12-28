/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.con_composicao_nova.Con_composicao_novaConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Con_composicao_novaTGWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class ListConGWT implements IListenetResponse{
    public boolean povoado;
    public List<Con_composicao_novaTGWT> list;

    public void povoa(String descricao){
        try {
            list = null;
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("con_composicao_novaT.con_tx_descricao", descricao);
            eaurl.accessJSonMap(Constantes.URL + Con_composicao_novaConsultGWT.PAGE, param);
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        povoado = false;
        try {

            list = new Vector<Con_composicao_novaTGWT>();
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                for (int i = 1; i < resultado.size(); i++) {
                    Con_composicao_novaTGWT obj = new Con_composicao_novaTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("con_nr_id").toString()));
                    obj.setCon_nr_id(id);

                    String dispaly = EasyContainer.clearAspas(registro.get("con_tx_descricao").toString());
                    obj.setCon_tx_descricao(dispaly);

                    String con_tx_codigo = EasyContainer.clearAspas(registro.get("con_tx_codigo").toString());
                    obj.setCon_tx_codigo(con_tx_codigo);

                    String con_tx_unidade = EasyContainer.clearAspas(registro.get("con_tx_unidade").toString());
                    obj.setCon_tx_unidade(con_tx_unidade);
                    list.add(obj);
                }
            }

        } catch (Exception e) {
        } finally {
            povoado = true;
        }
    }
}
