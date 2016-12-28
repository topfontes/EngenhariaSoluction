/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.opm_met_ope_per;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Opm_met_ope_perTGWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.HashMap;

/**
 *
 * @author I9
 */
public class AdicionarRemoverOpm_met_ope_perGWT implements IListenetResponse {
    public static final String PAGE = "easyEngenharia/easyconstru/opm_met_ope_per/opm_met_ope_perUpdateDeleteGWT.jsp";
    private boolean preechido;
    private String msg = "";

    public String adicionarOpm_met_ope_per(Opm_met_ope_perTGWT opm_met_ope_perTGWT){

        try {
            preechido = false;
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "adicionarOpm_met_ope_per");
            param.put("op_ope_perT.per_nr_id", opm_met_ope_perTGWT.getPer_nr_id()+"");
            param.put("op_ope_perT.ope_nr_id", opm_met_ope_perTGWT.getOpe_nr_id()+"");
            param.put("op_ope_perT.sis_nr_id", opm_met_ope_perTGWT.getSis_nr_id()+"");
            param.put("op_ope_perT.met_nr_id", opm_met_ope_perTGWT.getMet_nr_id()+"");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
            esperandoResposta();
        } catch (Exception ex) {
            Window.alert("erro "+ex.getMessage());

        }
        return msg;
    }

    

    public String removerOpm_met_ope_per(Opm_met_ope_perTGWT opm_met_ope_perTGWT){
        try {
            preechido = false;
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "removerOpm_met_ope_per");
            param.put("op_ope_perT.per_nr_id", opm_met_ope_perTGWT.getPer_nr_id()+"");
            param.put("op_ope_perT.ope_nr_id", opm_met_ope_perTGWT.getOpe_nr_id()+"");
            param.put("op_ope_perT.sis_nr_id", opm_met_ope_perTGWT.getSis_nr_id()+"");
            param.put("op_ope_perT.met_nr_id", opm_met_ope_perTGWT.getMet_nr_id()+"");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
            esperandoResposta();
        } catch (Exception ex) {
               Window.alert("erro "+ex.getMessage());
        }
        return msg;
    }

    public void esperandoResposta(){
        try {
            Timer timer = new Timer() {

            @Override
            public void run() {
               if (!preechido) {
                    schedule(500);
                    Window.alert("esperando");
               }else{
                  Window.alert("saiu");
               }
            }
         };
         timer.schedule(500);
        } catch (Exception e) {
        }
         
    }




    public void read(JSONValue jsonValue) {
        try {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                //Set<String> keys = jsonObject.keySet();
                //Window.alert(usuario);
                //JSONObject resultado = jsonObject.get("resultado").isObject();
                 msg =  (EasyContainer.clearAspas(jsonObject.get("resultado").toString()));
                 Window.alert(msg);
            }
        } catch (Exception e) {
        }finally{
            preechido = true;
        }
        
    }

    /**
     * @return the preechido
     */
    public boolean isPreechido() {
        return preechido;
    }

    /**
     * @param preechido the preechido to set
     */
    public void setPreechido(boolean preechido) {
        this.preechido = preechido;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
