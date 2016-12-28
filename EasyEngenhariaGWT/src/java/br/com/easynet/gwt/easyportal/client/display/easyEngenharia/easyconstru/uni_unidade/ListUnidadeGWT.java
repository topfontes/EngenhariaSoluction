/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uni_unidade;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Ume_unidade_medidaTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Uni_unidadeTGWT;
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
public class ListUnidadeGWT implements IListenetResponse {

    private List<Uni_unidadeTGWT> list;
    private TreeMap<Integer, Uni_unidadeTGWT> treeUnidade;
    public boolean povoado;

    public void povoa() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonNoProgress(Constantes.URL + Uni_unidadeConsultGWT.PAGE);
        } catch (Exception e) {
        }

    }

    public void read(JSONValue jsonValue) {
        try {
            setList(new Vector<Uni_unidadeTGWT>());
            setTreeUnidade(new TreeMap<Integer, Uni_unidadeTGWT>());
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                for (int i = 1; i < resultado.size(); i++) {
                    Uni_unidadeTGWT obj = new Uni_unidadeTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("uni_nr_id").toString()));
                    obj.setUni_nr_id(id);
                    String dispaly = EasyContainer.clearAspas(registro.get("uni_tx_nome").toString());
                    obj.setUni_tx_nome(dispaly);
                    getList().add(obj);
                    getTreeUnidade().put(id, obj);
                }

            }
        } catch (Exception e) {
        } finally {
            povoado = true;
        }
    }

    /**
     * @return the list
     */
    public List<Uni_unidadeTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Uni_unidadeTGWT> list) {
        this.list = list;
    }

    /**
     * @return the treeUnidade
     */
    public TreeMap<Integer, Uni_unidadeTGWT> getTreeUnidade() {
        return treeUnidade;
    }

    /**
     * @param treeUnidade the treeUnidade to set
     */
    public void setTreeUnidade(TreeMap<Integer, Uni_unidadeTGWT> treeUnidade) {
        this.treeUnidade = treeUnidade;
    }
}
