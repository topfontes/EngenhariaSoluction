/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Meses_obrasTGWT;
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

public class ListMeses_obraGWT implements IListenetResponse{
    public static final String PAGE = "easyEngenharia/easyconstru/meses_obra/meses_obraConsultGWT.jsp";

    private List<Meses_obrasTGWT> listMeses = new ArrayList<Meses_obrasTGWT>();
    public boolean valido;
    
    public void povoar(int id_obra){
        try {
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String,String> map = new HashMap<String, String>();
            map.put("obr_obrasT.obr_nr_id", id_obra+"");
            String url = Constantes.URL + PAGE;
            //Window.alert(url);
            valido = false;
            access.accessJSonMap(url,map);
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            listMeses = new ArrayList<Meses_obrasTGWT>();
            JSONArray resultado = jsonObject.get("resultado").isArray();
            for (int i = 1; i < resultado.size(); i++) {
                Meses_obrasTGWT obj = new Meses_obrasTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("mes").toString()));
                obj.setMes(mes);
                Integer ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("ano").toString()));
                obj.setAno(ano);
                String mes_ano = EasyContainer.clearAspas(registro.get("mes_ano").toString());
                obj.setMes_ano(mes_ano);
                listMeses.add(obj);
            }

        }
        valido = true;
    }

    public List<Meses_obrasTGWT> getListMeses() {
        return listMeses;
    }

    public void setListMeses(List<Meses_obrasTGWT> listMeses) {
        this.listMeses = listMeses;
    }

 
}
