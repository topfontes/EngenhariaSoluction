/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eqi_equivalencia_insumo;

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
public class Eqi_equivalencia_insumoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/eqi_equivalencia_insumo/eqi_equivalencia_insumoUpdateDeleteGWT.jsp";    

    private TextBox ina_nr_id = new TextBox();

    private TextBox inn_nr_id = new TextBox();


    private Eqi_equivalencia_insumoTGWT eqi_equivalencia_insumoTGWT = new Eqi_equivalencia_insumoTGWT();
private Eqi_equivalencia_insumoConsultGWT consultGWT = new Eqi_equivalencia_insumoConsultGWT();


    public Eqi_equivalencia_insumoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Eqi_equivalencia_insumoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Eqi_equivalencia_insumoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(3, 2);
        grid.setWidget(0, 0, new Label("ina_nr_id:"));
        grid.setWidget(0, 1, ina_nr_id);

        grid.setWidget(1, 0, new Label("inn_nr_id:"));
        grid.setWidget(1, 1, inn_nr_id);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Eqi_equivalencia_insumoTGWT eqi_equivalencia_insumoTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("eqi_equivalencia_insumoT.ina_nr_id", eqi_equivalencia_insumoTGWT.getIna_nr_id() + "");

            param.put("eqi_equivalencia_insumoT.inn_nr_id", eqi_equivalencia_insumoTGWT.getInn_nr_id() + "");


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
            param.put("eqi_equivalencia_insumoT.ina_nr_id", ina_nr_id.getText());

            param.put("eqi_equivalencia_insumoT.inn_nr_id", inn_nr_id.getText());


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
            param.put("eqi_equivalencia_insumoT.ina_nr_id", ina_nr_id.getText());

            param.put("eqi_equivalencia_insumoT.inn_nr_id", inn_nr_id.getText());


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
              JSONObject registro = resultado.get("eqi_equivalencia_insumo").isObject();
            
              int ina_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ina_nr_id").toString()));
            eqi_equivalencia_insumoTGWT.setIna_nr_id(ina_nr_id);
	    this.ina_nr_id.setText(eqi_equivalencia_insumoTGWT.getIna_nr_id() + "");

            int inn_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("inn_nr_id").toString()));
            eqi_equivalencia_insumoTGWT.setInn_nr_id(inn_nr_id);
	    this.inn_nr_id.setText(eqi_equivalencia_insumoTGWT.getInn_nr_id() + "");



	    } catch (Exception e) {}		
        }

    }
}

