/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uno_unidade_obra;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Uno_unidade_obraTGWT;
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
public class ListUnidadeObra implements IListenetResponse {

    private List<Uno_unidade_obraTGWT> list;
    private boolean povoado;

    public void povoa(int obr_nr_id) {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("uno_unidade_obraT.obr_nr_id",obr_nr_id + "");
            eaurl.accessJSonMapNoProgress(Constantes.URL + Uno_unidade_obraConsultGWT.PAGE,param);

        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        try {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                setList(new ArrayList<Uno_unidade_obraTGWT>());
                for (int i = 1; i < resultado.size(); i++) {
                    Uno_unidade_obraTGWT uno_unidade_obraTGWT = new Uno_unidade_obraTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer uno_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("uno_nr_id").toString()));
                    uno_unidade_obraTGWT.setUno_nr_id(uno_nr_id);
                    Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                    uno_unidade_obraTGWT.setObr_nr_id(obr_nr_id);
                    String uni_nr_id = EasyContainer.clearAspas(registro.get("uni_nr_id").toString());
                    uno_unidade_obraTGWT.setUni_nr_id(Integer.parseInt(uni_nr_id));
                    Integer uno_nr_quantidade = Integer.parseInt(EasyContainer.clearAspas(registro.get("uno_nr_quantidade").toString()));
                    uno_unidade_obraTGWT.setUno_nr_quantidade(uno_nr_quantidade);

                    float uno_nr_area_construida = Float.parseFloat(EasyContainer.clearAspas(registro.get("uno_nr_area_construida").toString()));
                    uno_unidade_obraTGWT.setUno_nr_area_construida(uno_nr_area_construida);

                    String uni_tx_nome = EasyContainer.clearAspas(registro.get("uni_tx_nome").toString());
                    uno_unidade_obraTGWT.setUni_tx_nome(uni_tx_nome);
                    String obr_tx_nome = EasyContainer.clearAspas(registro.get("obr_tx_nome").toString());
                    uno_unidade_obraTGWT.setObr_tx_nome(obr_tx_nome);

                    getList().add(uno_unidade_obraTGWT);
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
    public List<Uno_unidade_obraTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Uno_unidade_obraTGWT> list) {
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
