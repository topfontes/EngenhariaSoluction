/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fat_fator;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Valores_Calculo_FatorTGWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class ListFatoresCalculadosGWT implements IListenetResponse {

    private List<Valores_Calculo_FatorTGWT> list = new Vector();
    private boolean mostrar;

    public void povoa() throws Exception{
        mostrar = false;
        list.clear();
        EasyAccessURL eaurl = new EasyAccessURL(this);
        String page = "easyEngenharia/easyconstru/relatorios/list_fatores_plc.jsp";
        eaurl.accessJSonNoProgress(Constantes.URL+page);
    }

    public void read(JSONValue jsonValue) {
        try {
            list = new Vector();
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                for (int i = 1; i < resultado.size(); i++) {
                    Valores_Calculo_FatorTGWT obj = new Valores_Calculo_FatorTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer id_obra = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                    obj.setObr_nr_id(id_obra);

                    Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                    obj.setPlc_nr_id(id);

                    Integer mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("mes").toString()));
                    obj.setMes(mes);

                    Integer ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("ano").toString()));
                    obj.setAno(ano);

                    String dispaly = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                    obj.setPlc_tx_nome(dispaly);
                    float fator_atual = Float.parseFloat(EasyContainer.clearAspas(registro.get("fator_Atual").toString()));
                    obj.setFator_Atual(fator_atual);

                    float fator_proj = Float.parseFloat(EasyContainer.clearAspas(registro.get("fator_projetado").toString()));
                    obj.setFator_projetado(fator_proj);
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
    public List<Valores_Calculo_FatorTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Valores_Calculo_FatorTGWT> list) {
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
