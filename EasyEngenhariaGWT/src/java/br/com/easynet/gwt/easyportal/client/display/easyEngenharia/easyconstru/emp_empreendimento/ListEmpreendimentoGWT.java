/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.emp_empreendimento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Emp_empreendimentoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.ListBox;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

public class ListEmpreendimentoGWT implements IListenetResponse {

    private List<Emp_empreendimentoTGWT> list;
    private TreeMap<Integer, Emp_empreendimentoTGWT> treeEmp;
    private boolean povoado;

    public void povoa() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSon(Constantes.URL + Emp_empreendimentoConsultGWT.PAGE);
        } catch (Exception e) {
        }

    }

    public void read(JSONValue jsonValue) {
        try {
            setList(new Vector<Emp_empreendimentoTGWT>());
            setTreeEmp(new TreeMap<Integer, Emp_empreendimentoTGWT>());

            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                for (int i = 1; i < resultado.size(); i++) {
                    Emp_empreendimentoTGWT obj = new Emp_empreendimentoTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("emp_nr_id").toString()));
                    obj.setEmp_nr_id(id);
                    String dispaly = EasyContainer.clearAspas(registro.get("emp_tx_nome").toString());
                    obj.setEmp_tx_nome(dispaly);
                    getList().add(obj);
                    getTreeEmp().put(id, obj);

                }
            }
        } catch (Exception e) {
        } finally {
            setPovoado(true);
        }

    }

    /**
     * @return the list
     */
    public List<Emp_empreendimentoTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Emp_empreendimentoTGWT> list) {
        this.list = list;
    }

    /**
     * @return the treeEmp
     */
    public TreeMap<Integer, Emp_empreendimentoTGWT> getTreeEmp() {
        return treeEmp;
    }

    /**
     * @param treeEmp the treeEmp to set
     */
    public void setTreeEmp(TreeMap<Integer, Emp_empreendimentoTGWT> treeEmp) {
        this.treeEmp = treeEmp;
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
}
