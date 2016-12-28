/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_importacao_orcamento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Vw_importacao_orcamentoTGWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author marcos
 */
public class List_vw_importacao_orcamentoGWT implements IListenetResponse {

    private List<Vw_importacao_orcamentoTGWT> list ;
    private boolean mostrar;

    public void povoarNivel(int id_obra, int nivel) {
        try {
            mostrar = false;
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("op", "consultNivel");
            map.put("vw_importacao_orcamentoT.obr_nr_id", id_obra + "");
            map.put("vw_importacao_orcamentoT.plco_nr_nivel", nivel + "");
            String url = Constantes.URL + Vw_importacao_orcamentoConsultGWT.PAGE;
            //Window.alert(url+"?op=consultNivel&vw_importacao_orcamentoT.obr_nr_id="+id_obra+"&vw_importacao_orcamentoT.plco_nr_nivel="+nivel);
            access.accessJSonMap(url, map);
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        setMostrar(false);
        try {
            JSONObject jsonObject;
            list = new ArrayList<Vw_importacao_orcamentoTGWT>();
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                //Window.alert(resultado.toString());
                for (int i = 1; i < resultado.size(); i++) {
                    Vw_importacao_orcamentoTGWT obj = new Vw_importacao_orcamentoTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                    obj.setPlco_nr_id(plco_nr_id);
                    Integer ipo_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id").toString()));
                    obj.setIpo_nr_id(ipo_nr_id);
                    String plco_tx_nome = (EasyContainer.clearAspas(registro.get("plco_tx_nome").toString()));
                    obj.setPlco_tx_nome(plco_tx_nome);
                    String plco_tx_cod_externo = (EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString()));
                    obj.setPlco_tx_cod_externo(plco_tx_cod_externo);
                    getList().add(obj);
                }
            }
        } catch (Exception e) {
        } finally {
            setMostrar(true);
        }
    }

    /**
     * @return the list
     */
    public List<Vw_importacao_orcamentoTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Vw_importacao_orcamentoTGWT> list) {
        this.list = list;
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
}
