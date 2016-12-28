/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.tpms_temporaria_pms;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;

/**
 *
 * @author geoleite
 */
public class Tpms_temporaria_pmsInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsInsertGWT.jsp";   
    private Tpms_temporaria_pmsConsultGWT consultGWT = new Tpms_temporaria_pmsConsultGWT();


    public Tpms_temporaria_pmsConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Tpms_temporaria_pmsConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> tmps_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> tmps_nr_quantidade = new TextField<String>();

    private TextField<String> tpms_bl_servico = new TextField<String>();



    public Tpms_temporaria_pmsInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("tmps_nr_id:"));
        grid.setWidget(0, 1, tmps_nr_id);

        grid.setWidget(1, 0, new Label("plco_nr_id:"));
        grid.setWidget(1, 1, plco_nr_id);

        grid.setWidget(2, 0, new Label("tmps_nr_quantidade:"));
        grid.setWidget(2, 1, tmps_nr_quantidade);

        grid.setWidget(3, 0, new Label("tpms_bl_servico:"));
        grid.setWidget(3, 1, tpms_bl_servico);





        getCpMaster().add(grid);
	layout();
    }
//    @Override
    public void btnInsertAction(ToolBarEvent ce) {
        btnCadAction(ce);
    }
    private void btnCadAction(ToolBarEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
	    param.put("op", "insert");
            param.put("tpms_temporaria_pmsT.tmps_nr_id", tmps_nr_id.getValue());

            param.put("tpms_temporaria_pmsT.plco_nr_id", plco_nr_id.getValue());

            param.put("tpms_temporaria_pmsT.tmps_nr_quantidade", tmps_nr_quantidade.getValue());

            param.put("tpms_temporaria_pmsT.tpms_bl_servico", tpms_bl_servico.getValue());

	
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
	    consultGWT.load();
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            //JSONObject resultado = jsonObject.get("resultado").isObject();
          //  Window.alert("Result " + jsonObject.get("resultado").toString());
//            JSONObject msg = resultado.get("mensagem").isObject();
//            Window.alert("Mensagem " + msg.toString());
        }
    }
}

