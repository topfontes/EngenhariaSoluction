/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eplc_equivalencia_plano_contas;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Eplc_equivalencia_plano_contasUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasUpdateDeleteGWT.jsp";

    private TextField<String> eplc_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();


    private Eplc_equivalencia_plano_contasTGWT eplc_equivalencia_plano_contasTGWT = new Eplc_equivalencia_plano_contasTGWT();
private Eplc_equivalencia_plano_contasConsultGWT consultGWT = new Eplc_equivalencia_plano_contasConsultGWT();


    public Eplc_equivalencia_plano_contasConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Eplc_equivalencia_plano_contasConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Eplc_equivalencia_plano_contasUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(4, 2);
        grid.setWidget(0, 0, new Label("eplc_nr_id:"));
        grid.setWidget(0, 1, eplc_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id:"));
        grid.setWidget(1, 1, plc_nr_id);

        grid.setWidget(2, 0, new Label("plco_nr_id:"));
        grid.setWidget(2, 1, plco_nr_id);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Eplc_equivalencia_plano_contasTGWT eplc_equivalencia_plano_contasTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("eplc_equivalencia_plano_contasT.eplc_nr_id", eplc_equivalencia_plano_contasTGWT.getEplc_nr_id() + "");

            param.put("eplc_equivalencia_plano_contasT.plc_nr_id", eplc_equivalencia_plano_contasTGWT.getPlc_nr_id() + "");

            param.put("eplc_equivalencia_plano_contasT.plco_nr_id", eplc_equivalencia_plano_contasTGWT.getPlco_nr_id() + "");


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        btnAltAction(ce);
    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("eplc_equivalencia_plano_contasT.eplc_nr_id", eplc_nr_id.getValue());

            param.put("eplc_equivalencia_plano_contasT.plc_nr_id", plc_nr_id.getValue());

            param.put("eplc_equivalencia_plano_contasT.plco_nr_id", plco_nr_id.getValue());


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
	    consultGWT.load();
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
//            url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("eplc_equivalencia_plano_contasT.eplc_nr_id", eplc_nr_id.getValue());

            param.put("eplc_equivalencia_plano_contasT.plc_nr_id", plc_nr_id.getValue());

            param.put("eplc_equivalencia_plano_contasT.plco_nr_id", plco_nr_id.getValue());


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONObject resultado = jsonObject.get("resultado").isObject();
//            Window.alert("Result " + resultado.toString());
            String msg = EasyContainer.clearAspas(resultado.get("msg").toString());
            if (msg.trim().length() > 0) {
                MessageBox mb = new MessageBox();
                mb.alert("", msg, null);
            }
	    try {
              JSONObject registro = resultado.get("eplc_equivalencia_plano_contas").isObject();
            
              int eplc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("eplc_nr_id").toString()));
            eplc_equivalencia_plano_contasTGWT.setEplc_nr_id(eplc_nr_id);
	    this.eplc_nr_id.setValue(eplc_equivalencia_plano_contasTGWT.getEplc_nr_id() + "");

            int plc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
            eplc_equivalencia_plano_contasTGWT.setPlc_nr_id(plc_nr_id);
	    this.plc_nr_id.setValue(eplc_equivalencia_plano_contasTGWT.getPlc_nr_id() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            eplc_equivalencia_plano_contasTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(eplc_equivalencia_plano_contasTGWT.getPlco_nr_id() + "");



	    } catch (Exception e) {}		
        }

    }
}

