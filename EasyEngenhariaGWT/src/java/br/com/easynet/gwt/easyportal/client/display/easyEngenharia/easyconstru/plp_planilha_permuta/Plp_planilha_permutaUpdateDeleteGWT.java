/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plp_planilha_permuta;

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
public class Plp_planilha_permutaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plp_planilha_permuta/plp_planilha_permutaUpdateDeleteGWT.jsp";    

    private TextBox plp_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox plp_nr_mes_ref = new TextBox();

    private TextBox plp_nr_ano_ref = new TextBox();

    private TextBox plp_nr_mes = new TextBox();

    private TextBox plp_nr_ano = new TextBox();

    private TextBox plp_nr_previsto = new TextBox();

    private TextBox plp_nr_realizado = new TextBox();


    private Plp_planilha_permutaTGWT plp_planilha_permutaTGWT = new Plp_planilha_permutaTGWT();
private Plp_planilha_permutaConsultGWT consultGWT = new Plp_planilha_permutaConsultGWT();


    public Plp_planilha_permutaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Plp_planilha_permutaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Plp_planilha_permutaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(9, 2);
        grid.setWidget(0, 0, new Label("plp_nr_id:"));
        grid.setWidget(0, 1, plp_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("plp_nr_mes_ref:"));
        grid.setWidget(2, 1, plp_nr_mes_ref);

        grid.setWidget(3, 0, new Label("plp_nr_ano_ref:"));
        grid.setWidget(3, 1, plp_nr_ano_ref);

        grid.setWidget(4, 0, new Label("plp_nr_mes:"));
        grid.setWidget(4, 1, plp_nr_mes);

        grid.setWidget(5, 0, new Label("plp_nr_ano:"));
        grid.setWidget(5, 1, plp_nr_ano);

        grid.setWidget(6, 0, new Label("plp_nr_previsto:"));
        grid.setWidget(6, 1, plp_nr_previsto);

        grid.setWidget(7, 0, new Label("plp_nr_realizado:"));
        grid.setWidget(7, 1, plp_nr_realizado);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Plp_planilha_permutaTGWT plp_planilha_permutaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("plp_planilha_permutaT.plp_nr_id", plp_planilha_permutaTGWT.getPlp_nr_id() + "");

            param.put("plp_planilha_permutaT.obr_nr_id", plp_planilha_permutaTGWT.getObr_nr_id() + "");

            param.put("plp_planilha_permutaT.plp_nr_mes_ref", plp_planilha_permutaTGWT.getPlp_nr_mes_ref() + "");

            param.put("plp_planilha_permutaT.plp_nr_ano_ref", plp_planilha_permutaTGWT.getPlp_nr_ano_ref() + "");

            param.put("plp_planilha_permutaT.plp_nr_mes", plp_planilha_permutaTGWT.getPlp_nr_mes() + "");

            param.put("plp_planilha_permutaT.plp_nr_ano", plp_planilha_permutaTGWT.getPlp_nr_ano() + "");

            param.put("plp_planilha_permutaT.plp_nr_previsto", plp_planilha_permutaTGWT.getPlp_nr_previsto() + "");

            param.put("plp_planilha_permutaT.plp_nr_realizado", plp_planilha_permutaTGWT.getPlp_nr_realizado() + "");


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
            param.put("plp_planilha_permutaT.plp_nr_id", plp_nr_id.getText());

            param.put("plp_planilha_permutaT.obr_nr_id", obr_nr_id.getText());

            param.put("plp_planilha_permutaT.plp_nr_mes_ref", plp_nr_mes_ref.getText());

            param.put("plp_planilha_permutaT.plp_nr_ano_ref", plp_nr_ano_ref.getText());

            param.put("plp_planilha_permutaT.plp_nr_mes", plp_nr_mes.getText());

            param.put("plp_planilha_permutaT.plp_nr_ano", plp_nr_ano.getText());

            param.put("plp_planilha_permutaT.plp_nr_previsto", plp_nr_previsto.getText());

            param.put("plp_planilha_permutaT.plp_nr_realizado", plp_nr_realizado.getText());


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
            param.put("plp_planilha_permutaT.plp_nr_id", plp_nr_id.getText());

            param.put("plp_planilha_permutaT.obr_nr_id", obr_nr_id.getText());

            param.put("plp_planilha_permutaT.plp_nr_mes_ref", plp_nr_mes_ref.getText());

            param.put("plp_planilha_permutaT.plp_nr_ano_ref", plp_nr_ano_ref.getText());

            param.put("plp_planilha_permutaT.plp_nr_mes", plp_nr_mes.getText());

            param.put("plp_planilha_permutaT.plp_nr_ano", plp_nr_ano.getText());

            param.put("plp_planilha_permutaT.plp_nr_previsto", plp_nr_previsto.getText());

            param.put("plp_planilha_permutaT.plp_nr_realizado", plp_nr_realizado.getText());


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
              JSONObject registro = resultado.get("plp_planilha_permuta").isObject();
            
              int plp_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_id").toString()));
            plp_planilha_permutaTGWT.setPlp_nr_id(plp_nr_id);
	    this.plp_nr_id.setText(plp_planilha_permutaTGWT.getPlp_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            plp_planilha_permutaTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setText(plp_planilha_permutaTGWT.getObr_nr_id() + "");

            int plp_nr_mes_ref =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_mes_ref").toString()));
            plp_planilha_permutaTGWT.setPlp_nr_mes_ref(plp_nr_mes_ref);
	    this.plp_nr_mes_ref.setText(plp_planilha_permutaTGWT.getPlp_nr_mes_ref() + "");

            int plp_nr_ano_ref =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_ano_ref").toString()));
            plp_planilha_permutaTGWT.setPlp_nr_ano_ref(plp_nr_ano_ref);
	    this.plp_nr_ano_ref.setText(plp_planilha_permutaTGWT.getPlp_nr_ano_ref() + "");

            int plp_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_mes").toString()));
            plp_planilha_permutaTGWT.setPlp_nr_mes(plp_nr_mes);
	    this.plp_nr_mes.setText(plp_planilha_permutaTGWT.getPlp_nr_mes() + "");

            int plp_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_ano").toString()));
            plp_planilha_permutaTGWT.setPlp_nr_ano(plp_nr_ano);
	    this.plp_nr_ano.setText(plp_planilha_permutaTGWT.getPlp_nr_ano() + "");

            int plp_nr_previsto =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_previsto").toString()));
            plp_planilha_permutaTGWT.setPlp_nr_previsto(plp_nr_previsto);
	    this.plp_nr_previsto.setText(plp_planilha_permutaTGWT.getPlp_nr_previsto() + "");

            int plp_nr_realizado =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_realizado").toString()));
            plp_planilha_permutaTGWT.setPlp_nr_realizado(plp_nr_realizado);
	    this.plp_nr_realizado.setText(plp_planilha_permutaTGWT.getPlp_nr_realizado() + "");



	    } catch (Exception e) {}		
        }

    }
}

