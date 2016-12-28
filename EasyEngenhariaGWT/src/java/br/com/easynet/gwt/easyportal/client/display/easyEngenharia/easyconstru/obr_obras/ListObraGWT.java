/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
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
public class ListObraGWT implements IListenetResponse {

    private ListStore<Obr_obrasTGWT> store;
    private ComboBox<Obr_obrasTGWT> combo;
    private TreeMap<Integer, Obr_obrasTGWT> treeObra = new TreeMap<Integer, Obr_obrasTGWT>();
    private ListBox listBox;
    private boolean mostrar;

    public void povoar() {
        try {
            listBox = null;
            setMostrar(false);
            EasyAccessURL access = new EasyAccessURL(this);
            String url = Constantes.URL + Obr_obrasConsultGWT.PAGE;
            access.accessJSon(url);
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        
        store = new ListStore<Obr_obrasTGWT>();
        try {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                JSONArray resultado = jsonObject.get("resultado").isArray();
                for (int i = 1; i < resultado.size(); i++) {
                    Obr_obrasTGWT obj = new Obr_obrasTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                    obj.setObr_nr_id(id);
                    String dispaly = EasyContainer.clearAspas(registro.get("obr_tx_nome").toString());
                    obj.setObr_tx_nome(dispaly);

                    String obr_nr_encarcos_juros_aplicacao = EasyContainer.clearAspas(registro.get("obr_nr_encarcos_juros_aplicacao").toString());
                    if (obr_nr_encarcos_juros_aplicacao.trim().length() > 0) {
                        obj.setObr_nr_encarcos_juros_aplicacao(Float.parseFloat(obr_nr_encarcos_juros_aplicacao));
                    }else{
                      obj.setObr_nr_encarcos_juros_aplicacao(0);
                    }
                    store.add(obj);
                    getTreeObra().put(id, obj);
                }
            }
        } catch (Exception e) {
        } finally {
            mostrar = true;
        }
    }

    /**
     * @return the store
     */
    public ListStore<Obr_obrasTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Obr_obrasTGWT> store) {
        this.store = store;
    }

    /**
     * @return the combo
     */
    public ComboBox<Obr_obrasTGWT> getCombo() {
        return combo;
    }

    /**
     * @param combo the combo to set
     */
    public void setCombo(ComboBox<Obr_obrasTGWT> combo) {
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
     * @return the treeObra
     */
    public TreeMap<Integer, Obr_obrasTGWT> getTreeObra() {
        return treeObra;
    }

    /**
     * @param treeObra the treeObra to set
     */
    public void setTreeObra(TreeMap<Integer, Obr_obrasTGWT> treeObra) {
        this.treeObra = treeObra;
    }
}
