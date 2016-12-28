/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento;

import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plco_plano_contas_orcamentoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class List_plco_plano_contas_orcamentoGWT implements IListenetResponse {

    private ListStore<Plco_plano_contas_orcamentoTGWT> store;
    private ComboBox<Plco_plano_contas_orcamentoTGWT> combo;
    private List<Plco_plano_contas_orcamentoTGWT> list;
    private ListBox listBox;
    private boolean povoado;





    public void read(JSONValue jsonValue) {

        store = new ListStore<Plco_plano_contas_orcamentoTGWT>();
        list = new ArrayList<Plco_plano_contas_orcamentoTGWT>();
        JSONObject jsonObject;

        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
           // Window.alert(resultado.toString());

            for (int i = 1; i < resultado.size(); i++) {
                Plco_plano_contas_orcamentoTGWT obj = new Plco_plano_contas_orcamentoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                obj.setPlco_nr_id(id);//9996 0537 -
                String dispaly = EasyContainer.clearAspas(registro.get("plco_tx_nome").toString());
                String cod_externo = EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString());
                obj.setPlco_tx_cod_externo(cod_externo);
                obj.setPlco_tx_nome(dispaly);
                store.add(obj);
                list.add(obj);
            }
        }

    }

    /**
     * @return the store
     */
    public ListStore<Plco_plano_contas_orcamentoTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Plco_plano_contas_orcamentoTGWT> store) {
        this.store = store;
    }

    /**
     * @return the combo
     */
    public ComboBox<Plco_plano_contas_orcamentoTGWT> getCombo() {
        return combo;
    }

    /**
     * @param combo the combo to set
     */
    public void setCombo(ComboBox<Plco_plano_contas_orcamentoTGWT> combo) {
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
    public List<Plco_plano_contas_orcamentoTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Plco_plano_contas_orcamentoTGWT> list) {
        this.list = list;
    }
}
