/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fat_fator;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.HashMap;

/**
 *
 * @author marcos
 */
public class ObjetoSessionGWT implements IListenetResponse {

    private boolean sessionExiste;

    public void consultSession() {
        try {
            //sessionExiste = false;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            String page = "easyEngenharia/easyconstru/relatorios/sessionExiste.jsp";
            eaurl.accessJSonMapNoProgress(Constantes.URL + page, param);
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        try {
           if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                JSONObject registro = resultado.get(1).isObject();
                String msg = EasyContainer.clearAspas(registro.get("resposta").toString());
                if (msg.equalsIgnoreCase("True")) {
                    sessionExiste = true;
                }
            }

        } catch (Exception e) {
        } finally {
        }

    }

    /**
     * @return the sessionExiste
     */
    public boolean isSessionExiste() {
        return sessionExiste;
    }

    /**
     * @param sessionExiste the sessionExiste to set
     */
    public void setSessionExiste(boolean sessionExiste) {
        this.sessionExiste = sessionExiste;
    }
}
