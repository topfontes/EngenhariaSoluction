/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.ListBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */
public class ListPlc_planoContasGWT implements IListenetResponse {

    private ListStore<Plc_plano_contasTGWT> store;
    private ComboBox<Plc_plano_contasTGWT> combo;
    private ListBox listBox;
    private List<Plc_plano_contasTGWT> list;
    private boolean inserido;
    private TreeMap<Integer, Plc_plano_contasTGWT> treePlc = new TreeMap<Integer, Plc_plano_contasTGWT>();

    public void povoa() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultSubClasse");
            eaurl.accessJSonMap(Constantes.URL + Plc_plano_contasConsultGWT.PAGE, param);

        } catch (Exception e) {
        }
    }

    public void povoaSuperClasse() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultSuper");
            eaurl.accessJSonMap(Constantes.URL + Plc_plano_contasConsultGWT.PAGE, param);

        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        try {
            
            setInserido(false);
            store = new ListStore<Plc_plano_contasTGWT>();
            list = new ArrayList<Plc_plano_contasTGWT>();
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                //Window.alert(resultado.toString());
                for (int i = 1; i < resultado.size(); i++) {
                    Plc_plano_contasTGWT obj = new Plc_plano_contasTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                    obj.setPlc_nr_id(id);
                    String dispaly = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                    obj.setPlc_tx_nome(dispaly);
                    //com.google.gwt.user.client.Window.alert(dispaly);
                    store.add(obj);
                    list.add(obj);
                    getTreePlc().put(id, obj);
                }
            }
        } catch (Exception e) {
        } finally {
            setInserido(true);
        }

    }

    /**
     * @return the store
     */
    public ListStore<Plc_plano_contasTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Plc_plano_contasTGWT> store) {
        this.store = store;
    }

    /**
     * @return the combo
     */
    public ComboBox<Plc_plano_contasTGWT> getCombo() {
        return combo;
    }

    /**
     * @param combo the combo to set
     */
    public void setCombo(ComboBox<Plc_plano_contasTGWT> combo) {
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

    /**
     * @return the list
     */
    public List<Plc_plano_contasTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Plc_plano_contasTGWT> list) {
        this.list = list;
    }

    /**
     * @return the inserido
     */
    public boolean isInserido() {
        return inserido;
    }

    /**
     * @param inserido the inserido to set
     */
    public void setInserido(boolean inserido) {
        this.inserido = inserido;
    }

    /**
     * @return the treePlc
     */
    public TreeMap<Integer, Plc_plano_contasTGWT> getTreePlc() {
        return treePlc;
    }

    /**
     * @param treePlc the treePlc to set
     */
    public void setTreePlc(TreeMap<Integer, Plc_plano_contasTGWT> treePlc) {
        this.treePlc = treePlc;
    }
}
