/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.for_fornecedor;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.For_fornecedorTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;
import java.util.HashMap;

/**
 *
 * @author marcos
 */
public class ListFornecedorGWT implements IListenetResponse {

    private ListStore<For_fornecedorTGWT> store = new ListStore<For_fornecedorTGWT>();
    private ComboBox<For_fornecedorTGWT> combo;
    private ListBox listBox;
    public boolean inserido;

    public void povoa() {
        try {
            inserido = false;
            EasyAccessURL accessURL = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("op", "consult");
            accessURL.accessJSonMapNoProgress(Constantes.URL + For_fornecedorConsultGWT.PAGE,param);
        } catch (Exception e) {
        }
    }

    public void consultbyName(String for_tx_nome) {
        try {
            inserido = false;
            EasyAccessURL accessURL = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("for_fornecedorT.for_tx_nome", for_tx_nome);
            accessURL.accessJSonMapNoProgress(Constantes.URL + For_fornecedorConsultGWT.PAGE,param);
        } catch (Exception e) {
        }
    }
    
    public void read(JSONValue jsonValue) {
        inserido = false;
        try {
            store = new ListStore<For_fornecedorTGWT>();
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                //Window.alert(resultado.toString());
                for (int i = 1; i < resultado.size(); i++) {
                    For_fornecedorTGWT obj = new For_fornecedorTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("for_nr_id").toString()));
                    obj.setFor_nr_id(id);
                    String dispaly = EasyContainer.clearAspas(registro.get("for_tx_nome").toString());
                    obj.setFor_tx_nome(dispaly);
                    getStore().add(obj);
                    //Window.alert(""+i);
                }
                //Window.alert("passou");
            }

        } catch (Exception e) {
        } finally {
            inserido = true;
        }
    }

    /**
     * @return the store
     */
    public ListStore<For_fornecedorTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<For_fornecedorTGWT> store) {
        this.store = store;
    }

    /**
     * @return the combo
     */
    public ComboBox<For_fornecedorTGWT> getCombo() {
        return combo;
    }

    /**
     * @param combo the combo to set
     */
    public void setCombo(ComboBox<For_fornecedorTGWT> combo) {
        this.combo = combo;
    }

    /**
     * @return the listBox
     */
    public ListBox getListBox() {
        return listBox;
    }

    /**
     * @param listBox the listBox to set
     */
    public void setListBox(ListBox listBox) {
        this.listBox = listBox;
    }
}
