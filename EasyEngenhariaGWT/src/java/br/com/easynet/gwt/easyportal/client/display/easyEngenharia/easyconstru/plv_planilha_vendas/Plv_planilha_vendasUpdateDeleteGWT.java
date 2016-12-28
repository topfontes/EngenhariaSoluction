/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plv_planilha_vendas;

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
public class Plv_planilha_vendasUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDeleteGWT.jsp";    

    private TextBox plv_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox plv_nr_mes_ref = new TextBox();

    private TextBox plv_nr_ano_ref = new TextBox();

    private TextBox plv_nr_mes = new TextBox();

    private TextBox plv_nr_ano = new TextBox();

    private TextBox plv_nr_previsto = new TextBox();

    private TextBox plv_nr_realizado = new TextBox();


    private Plv_planilha_vendasTGWT plv_planilha_vendasTGWT = new Plv_planilha_vendasTGWT();
private Plv_planilha_vendasConsultGWT consultGWT = new Plv_planilha_vendasConsultGWT();


    public Plv_planilha_vendasConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Plv_planilha_vendasConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Plv_planilha_vendasUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(9, 2);
        grid.setWidget(0, 0, new Label("plv_nr_id:"));
        grid.setWidget(0, 1, plv_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("plv_nr_mes_ref:"));
        grid.setWidget(2, 1, plv_nr_mes_ref);

        grid.setWidget(3, 0, new Label("plv_nr_ano_ref:"));
        grid.setWidget(3, 1, plv_nr_ano_ref);

        grid.setWidget(4, 0, new Label("plv_nr_mes:"));
        grid.setWidget(4, 1, plv_nr_mes);

        grid.setWidget(5, 0, new Label("plv_nr_ano:"));
        grid.setWidget(5, 1, plv_nr_ano);

        grid.setWidget(6, 0, new Label("plv_nr_previsto:"));
        grid.setWidget(6, 1, plv_nr_previsto);

        grid.setWidget(7, 0, new Label("plv_nr_realizado:"));
        grid.setWidget(7, 1, plv_nr_realizado);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Plv_planilha_vendasTGWT plv_planilha_vendasTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("plv_planilha_vendasT.plv_nr_id", plv_planilha_vendasTGWT.getPlv_nr_id() + "");

            param.put("plv_planilha_vendasT.obr_nr_id", plv_planilha_vendasTGWT.getObr_nr_id() + "");

            param.put("plv_planilha_vendasT.plv_nr_mes_ref", plv_planilha_vendasTGWT.getPlv_nr_mes_ref() + "");

            param.put("plv_planilha_vendasT.plv_nr_ano_ref", plv_planilha_vendasTGWT.getPlv_nr_ano_ref() + "");

            param.put("plv_planilha_vendasT.plv_nr_mes", plv_planilha_vendasTGWT.getPlv_nr_mes() + "");

            param.put("plv_planilha_vendasT.plv_nr_ano", plv_planilha_vendasTGWT.getPlv_nr_ano() + "");

            param.put("plv_planilha_vendasT.plv_nr_previsto", plv_planilha_vendasTGWT.getPlv_nr_previsto() + "");

            param.put("plv_planilha_vendasT.plv_nr_realizado", plv_planilha_vendasTGWT.getPlv_nr_realizado() + "");


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
            param.put("plv_planilha_vendasT.plv_nr_id", plv_nr_id.getText());

            param.put("plv_planilha_vendasT.obr_nr_id", obr_nr_id.getText());

            param.put("plv_planilha_vendasT.plv_nr_mes_ref", plv_nr_mes_ref.getText());

            param.put("plv_planilha_vendasT.plv_nr_ano_ref", plv_nr_ano_ref.getText());

            param.put("plv_planilha_vendasT.plv_nr_mes", plv_nr_mes.getText());

            param.put("plv_planilha_vendasT.plv_nr_ano", plv_nr_ano.getText());

            param.put("plv_planilha_vendasT.plv_nr_previsto", plv_nr_previsto.getText());

            param.put("plv_planilha_vendasT.plv_nr_realizado", plv_nr_realizado.getText());


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
            param.put("plv_planilha_vendasT.plv_nr_id", plv_nr_id.getText());

            param.put("plv_planilha_vendasT.obr_nr_id", obr_nr_id.getText());

            param.put("plv_planilha_vendasT.plv_nr_mes_ref", plv_nr_mes_ref.getText());

            param.put("plv_planilha_vendasT.plv_nr_ano_ref", plv_nr_ano_ref.getText());

            param.put("plv_planilha_vendasT.plv_nr_mes", plv_nr_mes.getText());

            param.put("plv_planilha_vendasT.plv_nr_ano", plv_nr_ano.getText());

            param.put("plv_planilha_vendasT.plv_nr_previsto", plv_nr_previsto.getText());

            param.put("plv_planilha_vendasT.plv_nr_realizado", plv_nr_realizado.getText());


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
              JSONObject registro = resultado.get("plv_planilha_vendas").isObject();
            
              int plv_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_id").toString()));
            plv_planilha_vendasTGWT.setPlv_nr_id(plv_nr_id);
	    this.plv_nr_id.setText(plv_planilha_vendasTGWT.getPlv_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            plv_planilha_vendasTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setText(plv_planilha_vendasTGWT.getObr_nr_id() + "");

            int plv_nr_mes_ref =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_mes_ref").toString()));
            plv_planilha_vendasTGWT.setPlv_nr_mes_ref(plv_nr_mes_ref);
	    this.plv_nr_mes_ref.setText(plv_planilha_vendasTGWT.getPlv_nr_mes_ref() + "");

            int plv_nr_ano_ref =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_ano_ref").toString()));
            plv_planilha_vendasTGWT.setPlv_nr_ano_ref(plv_nr_ano_ref);
	    this.plv_nr_ano_ref.setText(plv_planilha_vendasTGWT.getPlv_nr_ano_ref() + "");

            int plv_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_mes").toString()));
            plv_planilha_vendasTGWT.setPlv_nr_mes(plv_nr_mes);
	    this.plv_nr_mes.setText(plv_planilha_vendasTGWT.getPlv_nr_mes() + "");

            int plv_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_ano").toString()));
            plv_planilha_vendasTGWT.setPlv_nr_ano(plv_nr_ano);
	    this.plv_nr_ano.setText(plv_planilha_vendasTGWT.getPlv_nr_ano() + "");

            int plv_nr_previsto =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_previsto").toString()));
            plv_planilha_vendasTGWT.setPlv_nr_previsto(plv_nr_previsto);
	    this.plv_nr_previsto.setText(plv_planilha_vendasTGWT.getPlv_nr_previsto() + "");

            int plv_nr_realizado =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_realizado").toString()));
            plv_planilha_vendasTGWT.setPlv_nr_realizado(plv_nr_realizado);
	    this.plv_nr_realizado.setText(plv_planilha_vendasTGWT.getPlv_nr_realizado() + "");



	    } catch (Exception e) {}		
        }

    }
}

