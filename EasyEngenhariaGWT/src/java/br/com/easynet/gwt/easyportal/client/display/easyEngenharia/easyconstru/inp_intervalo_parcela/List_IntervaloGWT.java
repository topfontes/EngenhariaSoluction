/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inp_intervalo_parcela;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Inp_intervalo_parcelaTGWT;
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
public class List_IntervaloGWT implements IListenetResponse {

    public boolean povoada;
    private List<Inp_intervalo_parcelaTGWT> list;

    public void povoa(int parcela) throws Exception {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult_IdParcela");
        param.put("inp_intervalo_parcelaT.par_nr_id", parcela + "");
//        Window.alert(Constantes.URL + Inp_intervalo_parcelaConsultGWT.PAGE+"?op=consult_IdParcela&inp_intervalo_parcelaT.par_nr_id="+parcela);
        eaurl.accessJSonMap(Constantes.URL + Inp_intervalo_parcelaConsultGWT.PAGE, param);
    }

    public void read(JSONValue jsonValue) {
        try {
//            Window.alert("read list");
            povoada = false;
            setList(new ArrayList<Inp_intervalo_parcelaTGWT>());
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
//                Window.alert(resultado.toString());
                for (int i = 1; i < resultado.size(); i++) {
                    JSONObject registro = resultado.get(i).isObject();
                    Inp_intervalo_parcelaTGWT obj = new Inp_intervalo_parcelaTGWT();
//Window.alert("inicio");
                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("inp_nr_id").toString()));
                    obj.setInp_nr_id(id);
//Window.alert("1");
                    Integer seq = Integer.parseInt(EasyContainer.clearAspas(registro.get("inp_nr_sequencia").toString()));

                    obj.setInp_nr_sequencia(i);
//Window.alert("2");
                    Integer dias = Integer.parseInt(EasyContainer.clearAspas(registro.get("inp_nr_dias").toString()));
                    obj.setInp_nr_dias(dias);
//                    Window.alert(dias + "");
                    getList().add(obj);
                }

            }
        } catch (Exception e) {
        } finally {
            povoada = true;
        }
    }

    /**
     * @return the list
     */
    public List<Inp_intervalo_parcelaTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Inp_intervalo_parcelaTGWT> list) {
        this.list = list;
    }
}
