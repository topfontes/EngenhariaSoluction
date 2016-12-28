/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.grp_grupo_produto;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Grp_grupo_produtoTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;
/**
 *
 * @author marcos
 */
public class ListGrupoProdutoGWT implements IListenetResponse{
    private ListStore<Grp_grupo_produtoTGWT> store;
    private ComboBox<Grp_grupo_produtoTGWT> combo;
    private ListBox listBox;

    public void read(JSONValue jsonValue) {
        //setStore(new ListStore<Grp_grupo_produtoTGWT>());
        setStore(new ListStore<Grp_grupo_produtoTGWT>());
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            for (int i = 1; i < resultado.size(); i++) {
                Grp_grupo_produtoTGWT obj = new Grp_grupo_produtoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("grp_nr_id").toString()));
                obj.setGrp_nr_id(id);
                String dispaly = EasyContainer.clearAspas(registro.get("grp_tx_nome").toString());
                obj.setGrp_tx_nome(dispaly);
                getStore().add(obj);
            }

            if (listBox != null) {
                int count = getStore().getCount();
                listBox.addItem("",0+"");
                for (int i=0 ; i < count; i++) {
                    listBox.addItem(getStore().getAt(i).getGrp_tx_nome(), getStore().getAt(i).getGrp_nr_id() + "");
                }
            }else
            if (getCombo() != null) {
                getCombo().setStore(getStore());
            }
        }
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
     * @return the store
     */
    public ListStore<Grp_grupo_produtoTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Grp_grupo_produtoTGWT> store) {
        this.store = store;
    }

    /**
     * @return the combo
     */
    public ComboBox<Grp_grupo_produtoTGWT> getCombo() {
        return combo;
    }

    /**
     * @param combo the combo to set
     */
    public void setCombo(ComboBox<Grp_grupo_produtoTGWT> combo) {
        this.combo = combo;
    }
}
