/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.car_carro;

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

/**
 *
 * @author geoleite
 */
public class Car_carroUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/car_carro/car_carroUpdateDeleteGWT.jsp";    

    private TextBox car_nr_id = new TextBox();

    private TextBox car_tx_nome = new TextBox();

    private TextBox car_tx_marca = new TextBox();


    private Car_carroTGWT car_carroTGWT = new Car_carroTGWT();
private Car_carroConsultGWT consultGWT = new Car_carroConsultGWT();


    public Car_carroConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Car_carroConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Car_carroUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(4, 2);
        grid.setWidget(0, 0, new Label("car_nr_id:"));
        grid.setWidget(0, 1, car_nr_id);

        grid.setWidget(1, 0, new Label("car_tx_nome:"));
        grid.setWidget(1, 1, car_tx_nome);

        grid.setWidget(2, 0, new Label("car_tx_marca:"));
        grid.setWidget(2, 1, car_tx_marca);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Car_carroTGWT car_carroTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("car_carroT.car_nr_id", car_carroTGWT.getCar_nr_id() + "");

            param.put("car_carroT.car_tx_nome", car_carroTGWT.getCar_tx_nome() + "");

            param.put("car_carroT.car_tx_marca", car_carroTGWT.getCar_tx_marca() + "");


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

//    @Override
    public void btnUpdateAction(ToolBarEvent ce) {
        btnAltAction(ce);
    }

//    @Override
    public void btnDeltAction(ToolBarEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ToolBarEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("car_carroT.car_nr_id", car_nr_id.getText());

            param.put("car_carroT.car_tx_nome", car_tx_nome.getText());

            param.put("car_carroT.car_tx_marca", car_tx_marca.getText());


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
	    consultGWT.load();
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ToolBarEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
//            url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("car_carroT.car_nr_id", car_nr_id.getText());

            param.put("car_carroT.car_tx_nome", car_tx_nome.getText());

            param.put("car_carroT.car_tx_marca", car_tx_marca.getText());


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
              JSONObject registro = resultado.get("car_carro").isObject();
            
              int car_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("car_nr_id").toString()));
            car_carroTGWT.setCar_nr_id(car_nr_id);
	    this.car_nr_id.setText(car_carroTGWT.getCar_nr_id() + "");

            String car_tx_nome =   (EasyContainer.clearAspas(registro.get("car_tx_nome").toString()));
            car_carroTGWT.setCar_tx_nome(car_tx_nome);
	    this.car_tx_nome.setText(car_carroTGWT.getCar_tx_nome() + "");

            String car_tx_marca =   (EasyContainer.clearAspas(registro.get("car_tx_marca").toString()));
            car_carroTGWT.setCar_tx_marca(car_tx_marca);
	    this.car_tx_marca.setText(car_carroTGWT.getCar_tx_marca() + "");



	    } catch (Exception e) {}		
        }

    }
}

