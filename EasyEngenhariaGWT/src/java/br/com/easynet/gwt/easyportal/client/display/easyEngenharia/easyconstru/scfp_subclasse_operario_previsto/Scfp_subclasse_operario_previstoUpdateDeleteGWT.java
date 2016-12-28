/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.scfp_subclasse_operario_previsto;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.Portal2GWT;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;

/**
 *
 * @author geoleite
 */
public class Scfp_subclasse_operario_previstoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoUpdateDeleteGWT.jsp";    

    private TextBox scfp_nr_id = new TextBox();

    private TextBox plc_nr_id = new TextBox();


    private Scfp_subclasse_operario_previstoTGWT scfp_subclasse_operario_previstoTGWT = new Scfp_subclasse_operario_previstoTGWT();
private Scfp_subclasse_operario_previstoConsultGWT consultGWT = new Scfp_subclasse_operario_previstoConsultGWT();


    public Scfp_subclasse_operario_previstoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Scfp_subclasse_operario_previstoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Scfp_subclasse_operario_previstoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(3, 2);
        grid.setWidget(0, 0, new Label("scfp_nr_id:"));
        grid.setWidget(0, 1, scfp_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id:"));
        grid.setWidget(1, 1, plc_nr_id);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Scfp_subclasse_operario_previstoTGWT scfp_subclasse_operario_previstoTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("scfp_subclasse_operario_previstoT.scfp_nr_id", scfp_subclasse_operario_previstoTGWT.getScfp_nr_id() + "");

            param.put("scfp_subclasse_operario_previstoT.plco_nr_id", scfp_subclasse_operario_previstoTGWT.getPlco_nr_id() + "");


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

//    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        btnAltAction(ce);
    }

//    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("scfp_subclasse_operario_previstoT.scfp_nr_id", scfp_nr_id.getText());

            param.put("scfp_subclasse_operario_previstoT.plc_nr_id", plc_nr_id.getText());


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
            param.put("scfp_subclasse_operario_previstoT.scfp_nr_id", scfp_nr_id.getText());

            param.put("scfp_subclasse_operario_previstoT.plc_nr_id", plc_nr_id.getText());


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
              JSONObject registro = resultado.get("scfp_subclasse_operario_previsto").isObject();
            
              int scfp_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("scfp_nr_id").toString()));
            scfp_subclasse_operario_previstoTGWT.setScfp_nr_id(scfp_nr_id);
	    this.scfp_nr_id.setText(scfp_subclasse_operario_previstoTGWT.getScfp_nr_id() + "");

            int plc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
            scfp_subclasse_operario_previstoTGWT.setPlco_nr_id(plc_nr_id);
	    this.plc_nr_id.setText(scfp_subclasse_operario_previstoTGWT.getPlco_nr_id() + "");



	    } catch (Exception e) {}		
        }

    }
}

