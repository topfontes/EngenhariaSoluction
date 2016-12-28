/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cen_centro_custo;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Cen_centro_custoTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */
public class ListCentroCustoGWT implements IListenetResponse {

    private ListStore<Cen_centro_custoTGWT> store;
    private ComboBox<Cen_centro_custoTGWT> combo;
    private List<Cen_centro_custoTGWT> list;
    private ListBox listBox;
    private boolean povoado;
    private TreeMap<Integer,Cen_centro_custoTGWT> treecentro = new TreeMap<Integer, Cen_centro_custoTGWT>();

    public void povoa() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSon(Constantes.URL + Cen_centro_custoConsultGWT.PAGE);

        } catch (Exception e) {
        }

    }

    public void read(JSONValue jsonValue) {
        setPovoado(false);
        store = new ListStore<Cen_centro_custoTGWT>();
        setList(new ArrayList<Cen_centro_custoTGWT>());
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            for (int i = 1; i < resultado.size(); i++) {
                Cen_centro_custoTGWT obj = new Cen_centro_custoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cen_nr_id").toString()));
                obj.setCen_nr_id(id);
                String dispaly = EasyContainer.clearAspas(registro.get("cen_tx_nome").toString());
                obj.setCen_tx_nome(dispaly);
                getStore().add(obj);
                getList().add(obj);
                getTreecentro().put(id, obj);
            }

            if (getListBox() != null) {
                int count = getStore().getCount();
                getListBox().addItem("", 0 + "");
                for (int i = 0; i < count; i++) {
                    getListBox().addItem(store.getAt(i).getCen_tx_nome(), store.getAt(i).getCen_nr_id() + "");
                }
            } else if (combo != null) {
                combo.setStore(store);
            }
        }
        setPovoado(true);
    }

    /**
     * @return the store
     */
    public ListStore<Cen_centro_custoTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Cen_centro_custoTGWT> store) {
        this.store = store;
    }

    /**
     * @return the combo
     */
    public ComboBox<Cen_centro_custoTGWT> getCombo() {
        return combo;
    }

    /**
     * @param combo the combo to set
     */
    public void setCombo(ComboBox<Cen_centro_custoTGWT> combo) {
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
     * @return the povoado
     */
    public boolean isPovoado() {
        return povoado;
    }

    /**
     * @param povoado the povoado to set
     */
    public void setPovoado(boolean povoado) {
        this.povoado = povoado;
    }

    /**
     * @return the list
     */
    public List<Cen_centro_custoTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Cen_centro_custoTGWT> list) {
        this.list = list;
    }

    /**
     * @return the treecentro
     */
    public TreeMap<Integer, Cen_centro_custoTGWT> getTreecentro() {
        return treecentro;
    }

    /**
     * @param treecentro the treecentro to set
     */
    public void setTreecentro(TreeMap<Integer, Cen_centro_custoTGWT> treecentro) {
        this.treecentro = treecentro;
    }
}

