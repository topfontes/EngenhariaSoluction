/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plco_plano_contas_orcamentoTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Vw_cffo_mesTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author marcos
 */
public class PlcoConsult implements IListenetResponse {

    private ListStore<Plco_plano_contas_orcamentoTGWT> store;
    private List<Plco_plano_contas_orcamentoTGWT> list;
    private boolean povoado = false;

    public void consultarNivel(int nivel) {
        try {
            povoado = false;
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultNivel");
            param.put("nivel", "" + nivel);
            String url = Constantes.URL + Plco_plano_contas_orcamentoConsultGWT.PAGE;
            access.accessJSonMap(url, param);
        } catch (Exception e) {
        }
    }
    public void consultarMDO() {
        try {
            povoado = false;
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultNivel");
            param.put("mdo", "true");
            param.put("nivel", "5");
            String url = Constantes.URL + Plco_plano_contas_orcamentoConsultGWT.PAGE;
            access.accessJSonMap(url, param);
        } catch (Exception e) {
        }
    }

    public void povoarSemEquivalencia() {
        try {
            povoado = false;
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "semEquivalencia");
            String url = Constantes.URL + Plco_plano_contas_orcamentoConsultGWT.PAGE;
            access.accessJSonMap(url, param);
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        povoado = false;
        try {
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
                    obj.setPlco_nr_id(id);
                    String dispaly = EasyContainer.clearAspas(registro.get("plco_tx_nome").toString());
                    obj.setPlco_tx_nome(dispaly);
                    String cod_externo = EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString());
                    obj.setPlco_tx_cod_externo(cod_externo);
                    String plco_tx_unidade = EasyContainer.clearAspas(registro.get("plco_tx_unidade").toString());
                    obj.setPlco_tx_unidade(plco_tx_unidade);
                    String plco_tx_tipo = EasyContainer.clearAspas(registro.get("plco_tx_tipo").toString());
                    obj.setPlco_tx_tipo(plco_tx_tipo);
                    list.add(obj);
                    store.add(obj);
                }
            }
        } catch (Exception e) {
        }finally{
            povoado = true;
        }

    }

    /**
     * @return the store
     */
    public ListStore<Plco_plano_contas_orcamentoTGWT> getStore() {
        return store;
    }

   public ListStore<Plco_plano_contas_orcamentoTGWT> getStoreFormatado() {
       ListStore<Plco_plano_contas_orcamentoTGWT> list = new ListStore<Plco_plano_contas_orcamentoTGWT>();
       for (Plco_plano_contas_orcamentoTGWT wT : store.getModels()) {
           wT.setPlco_tx_nome(wT.getPlco_tx_nome()+" - "+wT.getPlco_tx_unidade());
           list.add(wT);
       }
        return list;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Plco_plano_contas_orcamentoTGWT> store) {
        this.store = store;
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
