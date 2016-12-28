/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.flr_fluxo_receita;

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
public class Flr_fluxo_receitaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaUpdateDeleteGWT.jsp";    

    private TextBox flr_nr_id = new TextBox();

    private TextBox flr_nr_mes = new TextBox();

    private TextBox flr_nr_ano = new TextBox();

    private TextBox flr_nr_original = new TextBox();

    private TextBox flr_nr_atual = new TextBox();

    private TextBox flr_tx_key = new TextBox();


    private Flr_fluxo_receitaTGWT flr_fluxo_receitaTGWT = new Flr_fluxo_receitaTGWT();
private Flr_fluxo_receitaConsultGWT consultGWT = new Flr_fluxo_receitaConsultGWT();


    public Flr_fluxo_receitaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Flr_fluxo_receitaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Flr_fluxo_receitaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(7, 2);
        grid.setWidget(0, 0, new Label("flr_nr_id:"));
        grid.setWidget(0, 1, flr_nr_id);

        grid.setWidget(1, 0, new Label("flr_nr_mes:"));
        grid.setWidget(1, 1, flr_nr_mes);

        grid.setWidget(2, 0, new Label("flr_nr_ano:"));
        grid.setWidget(2, 1, flr_nr_ano);

        grid.setWidget(3, 0, new Label("flr_nr_original:"));
        grid.setWidget(3, 1, flr_nr_original);

        grid.setWidget(4, 0, new Label("flr_nr_atual:"));
        grid.setWidget(4, 1, flr_nr_atual);

        grid.setWidget(5, 0, new Label("flr_tx_key:"));
        grid.setWidget(5, 1, flr_tx_key);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Flr_fluxo_receitaTGWT flr_fluxo_receitaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("flr_fluxo_receitaT.flr_nr_id", flr_fluxo_receitaTGWT.getFlr_nr_id() + "");

            param.put("flr_fluxo_receitaT.flr_nr_mes", flr_fluxo_receitaTGWT.getFlr_nr_mes() + "");

            param.put("flr_fluxo_receitaT.flr_nr_ano", flr_fluxo_receitaTGWT.getFlr_nr_ano() + "");

            param.put("flr_fluxo_receitaT.flr_nr_original", flr_fluxo_receitaTGWT.getFlr_nr_original() + "");

            param.put("flr_fluxo_receitaT.flr_nr_atual", flr_fluxo_receitaTGWT.getFlr_nr_atual() + "");

            param.put("flr_fluxo_receitaT.flr_tx_key", flr_fluxo_receitaTGWT.getFlr_tx_key() + "");


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
            param.put("flr_fluxo_receitaT.flr_nr_id", flr_nr_id.getText());

            param.put("flr_fluxo_receitaT.flr_nr_mes", flr_nr_mes.getText());

            param.put("flr_fluxo_receitaT.flr_nr_ano", flr_nr_ano.getText());

            param.put("flr_fluxo_receitaT.flr_nr_original", flr_nr_original.getText());

            param.put("flr_fluxo_receitaT.flr_nr_atual", flr_nr_atual.getText());

            param.put("flr_fluxo_receitaT.flr_tx_key", flr_tx_key.getText());


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
            param.put("flr_fluxo_receitaT.flr_nr_id", flr_nr_id.getText());

            param.put("flr_fluxo_receitaT.flr_nr_mes", flr_nr_mes.getText());

            param.put("flr_fluxo_receitaT.flr_nr_ano", flr_nr_ano.getText());

            param.put("flr_fluxo_receitaT.flr_nr_original", flr_nr_original.getText());

            param.put("flr_fluxo_receitaT.flr_nr_atual", flr_nr_atual.getText());

            param.put("flr_fluxo_receitaT.flr_tx_key", flr_tx_key.getText());


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
              JSONObject registro = resultado.get("flr_fluxo_receita").isObject();
            
              int flr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("flr_nr_id").toString()));
            flr_fluxo_receitaTGWT.setFlr_nr_id(flr_nr_id);
	    this.flr_nr_id.setText(flr_fluxo_receitaTGWT.getFlr_nr_id() + "");

            int flr_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("flr_nr_mes").toString()));
            flr_fluxo_receitaTGWT.setFlr_nr_mes(flr_nr_mes);
	    this.flr_nr_mes.setText(flr_fluxo_receitaTGWT.getFlr_nr_mes() + "");

            int flr_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("flr_nr_ano").toString()));
            flr_fluxo_receitaTGWT.setFlr_nr_ano(flr_nr_ano);
	    this.flr_nr_ano.setText(flr_fluxo_receitaTGWT.getFlr_nr_ano() + "");

            float flr_nr_original =  Float.parseFloat(EasyContainer.clearAspas(registro.get("flr_nr_original").toString()));
            flr_fluxo_receitaTGWT.setFlr_nr_original(flr_nr_original);
	    this.flr_nr_original.setText(flr_fluxo_receitaTGWT.getFlr_nr_original() + "");

            float flr_nr_atual =  Float.parseFloat(EasyContainer.clearAspas(registro.get("flr_nr_atual").toString()));
            flr_fluxo_receitaTGWT.setFlr_nr_atual(flr_nr_atual);
	    this.flr_nr_atual.setText(flr_fluxo_receitaTGWT.getFlr_nr_atual() + "");

            String flr_tx_key =   (EasyContainer.clearAspas(registro.get("flr_tx_key").toString()));
            flr_fluxo_receitaTGWT.setFlr_tx_key(flr_tx_key);
	    this.flr_tx_key.setText(flr_fluxo_receitaTGWT.getFlr_tx_key() + "");



	    } catch (Exception e) {}		
        }

    }
}

