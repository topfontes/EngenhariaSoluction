/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cli_cliente;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Cli_clienteTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class ListClienteGWT implements IListenetResponse {

    private List<Cli_clienteTGWT> list;
    private ComboBox<Cli_clienteTGWT> combo;
    private ListBox listBox;
    public boolean povoado;
    private TreeMap<Integer, Cli_clienteTGWT> treeCliente;

    public void povoa(){
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSon(Constantes.URL + Cli_clienteConsultGWT.PAGE);
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        povoado = false;
        try {
            treeCliente = new TreeMap<Integer, Cli_clienteTGWT>();
            list = new Vector<Cli_clienteTGWT>();
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                for (int i = 1; i < resultado.size(); i++) {
                    Cli_clienteTGWT obj = new Cli_clienteTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
                    obj.setCli_nr_id(id);
                    String dispaly = EasyContainer.clearAspas(registro.get("cli_tx_nome").toString());
                    obj.setCli_tx_nome(dispaly);
                    list.add(obj);
                    treeCliente.put(obj.getCli_nr_id(), obj);
                }
            }
        } catch (Exception e) {
        } finally {
            povoado = true;
        }

    }

    /**
     * @return the combo
     */
    public ComboBox<Cli_clienteTGWT> getCombo() {
        return combo;
    }

    /**
     * @param combo the combo to set
     */
    public void setCombo(ComboBox<Cli_clienteTGWT> combo) {
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
    public List<Cli_clienteTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Cli_clienteTGWT> list) {
        this.list = list;
    }

    /**
     * @return the treeCliente
     */
    public TreeMap<Integer, Cli_clienteTGWT> getTreeCliente() {
        return treeCliente;
    }

    /**
     * @param treeCliente the treeCliente to set
     */
    public void setTreeCliente(TreeMap<Integer, Cli_clienteTGWT> treeCliente) {
        this.treeCliente = treeCliente;
    }
}
