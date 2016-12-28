/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ume_unidade_medida;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Ume_unidade_medidaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */
public class ListUnidadeMedidaGWT implements IListenetResponse {

    private ListStore<Ume_unidade_medidaTGWT> store;
    private ComboBox<Ume_unidade_medidaTGWT> combo;
    private ListBox listBox;
    private TreeMap<Integer,Ume_unidade_medidaTGWT> tree = new TreeMap<Integer, Ume_unidade_medidaTGWT>();
    private boolean inserido;

    public void povoa(){
        try {
            setInserido(false);
            EasyAccessURL accessURL = new EasyAccessURL(this);
            accessURL.accessJSon(Constantes.URL + Ume_unidade_medidaConsultGWT.PAGE);

        } catch (Exception e) {
        }

    }

    public void read(JSONValue jsonValue) {
        setInserido(false);
        try{
        setTree(new TreeMap<Integer, Ume_unidade_medidaTGWT>());
        store = new ListStore<Ume_unidade_medidaTGWT>();
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            for (int i = 1; i < resultado.size(); i++) {
                Ume_unidade_medidaTGWT obj = new Ume_unidade_medidaTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ume_nr_id").toString()));
                obj.setUme_nr_id(id);
                String dispaly = EasyContainer.clearAspas(registro.get("ume_tx_nome").toString());
                obj.setUme_tx_nome(dispaly);
                store.add(obj);
                getTree().put(id, obj);
            }
        }
        }catch(Exception e){

        }finally{
            setInserido(true);
        }
    }

    /**
     * @return the store
     */
    public ListStore<Ume_unidade_medidaTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Ume_unidade_medidaTGWT> store) {
        this.store = store;
    }

    /**
     * @return the combo
     */
    public ComboBox<Ume_unidade_medidaTGWT> getCombo() {
        return combo;
    }

    /**
     * @param combo the combo to set
     */
    public void setCombo(ComboBox<Ume_unidade_medidaTGWT> combo) {
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
     * @return the tree
     */
    public TreeMap<Integer, Ume_unidade_medidaTGWT> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<Integer, Ume_unidade_medidaTGWT> tree) {
        this.tree = tree;
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
}
