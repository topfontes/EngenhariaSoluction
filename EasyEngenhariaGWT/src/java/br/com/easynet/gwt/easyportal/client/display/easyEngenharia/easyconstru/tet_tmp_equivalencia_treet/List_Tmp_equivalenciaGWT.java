/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.tet_tmp_equivalencia_treet;

import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Tet_tmp_equivalencia_treetTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;
import java.util.List;

/**
 *
 * @author marcos
 */
public class List_Tmp_equivalenciaGWT implements IListenetResponse {

    private List<Tet_tmp_equivalencia_treetTGWT> list;

    public void read(JSONValue jsonValue) {
        try {

            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                //Window.alert(resultado.toString());
                
                for (int i = 1; i < resultado.size(); i++) {
                    Tet_tmp_equivalencia_treetTGWT obj = new Tet_tmp_equivalencia_treetTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                    obj.setPlc_nr_id(id);
                    String dispaly = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                    obj.setPlc_tx_nome(dispaly);

                    id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                    obj.setPlco_nr_id(id);
                    dispaly = EasyContainer.clearAspas(registro.get("plco_tx_nome").toString());
                    obj.setPlco_tx_nome(dispaly);
                    list.add(obj);

                }
                
            }
        } catch (Exception e) {
            Window.alert("não foi possível localizar as classes");
        }

    }

    /**
     * @return the list
     */
    public List<Tet_tmp_equivalencia_treetTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Tet_tmp_equivalencia_treetTGWT> list) {
        this.list = list;
    }
}
