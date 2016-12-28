/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.evl_evolucao_lucro;

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
public class Evl_evolucao_lucroUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDeleteGWT.jsp";    

    private TextBox evl_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox evl_nr_mes = new TextBox();

    private TextBox evl_nr_ano = new TextBox();

    private TextBox evl_nr_valor = new TextBox();

    private TextBox evl_nr_mes_ref = new TextBox();

    private TextBox evl_nr_ano_ref = new TextBox();

    private TextBox evl_tx_tipo = new TextBox();


    private Evl_evolucao_lucroTGWT evl_evolucao_lucroTGWT = new Evl_evolucao_lucroTGWT();
private Evl_evolucao_lucroConsultGWT consultGWT = new Evl_evolucao_lucroConsultGWT();


    public Evl_evolucao_lucroConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Evl_evolucao_lucroConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Evl_evolucao_lucroUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(9, 2);
        grid.setWidget(0, 0, new Label("evl_nr_id:"));
        grid.setWidget(0, 1, evl_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("evl_nr_mes:"));
        grid.setWidget(2, 1, evl_nr_mes);

        grid.setWidget(3, 0, new Label("evl_nr_ano:"));
        grid.setWidget(3, 1, evl_nr_ano);

        grid.setWidget(4, 0, new Label("evl_nr_valor:"));
        grid.setWidget(4, 1, evl_nr_valor);

        grid.setWidget(5, 0, new Label("evl_nr_mes_ref:"));
        grid.setWidget(5, 1, evl_nr_mes_ref);

        grid.setWidget(6, 0, new Label("evl_nr_ano_ref:"));
        grid.setWidget(6, 1, evl_nr_ano_ref);

        grid.setWidget(7, 0, new Label("evl_tx_tipo:"));
        grid.setWidget(7, 1, evl_tx_tipo);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Evl_evolucao_lucroTGWT evl_evolucao_lucroTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("evl_evolucao_lucroT.evl_nr_id", evl_evolucao_lucroTGWT.getEvl_nr_id() + "");

            param.put("evl_evolucao_lucroT.obr_nr_id", evl_evolucao_lucroTGWT.getObr_nr_id() + "");

            param.put("evl_evolucao_lucroT.evl_nr_mes", evl_evolucao_lucroTGWT.getEvl_nr_mes() + "");

            param.put("evl_evolucao_lucroT.evl_nr_ano", evl_evolucao_lucroTGWT.getEvl_nr_ano() + "");

            param.put("evl_evolucao_lucroT.evl_nr_valor", evl_evolucao_lucroTGWT.getEvl_nr_valor() + "");

            param.put("evl_evolucao_lucroT.evl_nr_mes_ref", evl_evolucao_lucroTGWT.getEvl_nr_mes_ref() + "");

            param.put("evl_evolucao_lucroT.evl_nr_ano_ref", evl_evolucao_lucroTGWT.getEvl_nr_ano_ref() + "");

            param.put("evl_evolucao_lucroT.evl_tx_tipo", evl_evolucao_lucroTGWT.getEvl_tx_tipo() + "");


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
            param.put("evl_evolucao_lucroT.evl_nr_id", evl_nr_id.getText());

            param.put("evl_evolucao_lucroT.obr_nr_id", obr_nr_id.getText());

            param.put("evl_evolucao_lucroT.evl_nr_mes", evl_nr_mes.getText());

            param.put("evl_evolucao_lucroT.evl_nr_ano", evl_nr_ano.getText());

            param.put("evl_evolucao_lucroT.evl_nr_valor", evl_nr_valor.getText());

            param.put("evl_evolucao_lucroT.evl_nr_mes_ref", evl_nr_mes_ref.getText());

            param.put("evl_evolucao_lucroT.evl_nr_ano_ref", evl_nr_ano_ref.getText());

            param.put("evl_evolucao_lucroT.evl_tx_tipo", evl_tx_tipo.getText());


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
            param.put("evl_evolucao_lucroT.evl_nr_id", evl_nr_id.getText());

            param.put("evl_evolucao_lucroT.obr_nr_id", obr_nr_id.getText());

            param.put("evl_evolucao_lucroT.evl_nr_mes", evl_nr_mes.getText());

            param.put("evl_evolucao_lucroT.evl_nr_ano", evl_nr_ano.getText());

            param.put("evl_evolucao_lucroT.evl_nr_valor", evl_nr_valor.getText());

            param.put("evl_evolucao_lucroT.evl_nr_mes_ref", evl_nr_mes_ref.getText());

            param.put("evl_evolucao_lucroT.evl_nr_ano_ref", evl_nr_ano_ref.getText());

            param.put("evl_evolucao_lucroT.evl_tx_tipo", evl_tx_tipo.getText());


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
              JSONObject registro = resultado.get("evl_evolucao_lucro").isObject();
            
              int evl_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("evl_nr_id").toString()));
            evl_evolucao_lucroTGWT.setEvl_nr_id(evl_nr_id);
	    this.evl_nr_id.setText(evl_evolucao_lucroTGWT.getEvl_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            evl_evolucao_lucroTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setText(evl_evolucao_lucroTGWT.getObr_nr_id() + "");

            int evl_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("evl_nr_mes").toString()));
            evl_evolucao_lucroTGWT.setEvl_nr_mes(evl_nr_mes);
	    this.evl_nr_mes.setText(evl_evolucao_lucroTGWT.getEvl_nr_mes() + "");

            int evl_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("evl_nr_ano").toString()));
            evl_evolucao_lucroTGWT.setEvl_nr_ano(evl_nr_ano);
	    this.evl_nr_ano.setText(evl_evolucao_lucroTGWT.getEvl_nr_ano() + "");

            float evl_nr_valor =  Float.parseFloat(EasyContainer.clearAspas(registro.get("evl_nr_valor").toString()));
            evl_evolucao_lucroTGWT.setEvl_nr_valor(evl_nr_valor);
	    this.evl_nr_valor.setText(evl_evolucao_lucroTGWT.getEvl_nr_valor() + "");

            int evl_nr_mes_ref =  Integer.parseInt(EasyContainer.clearAspas(registro.get("evl_nr_mes_ref").toString()));
            evl_evolucao_lucroTGWT.setEvl_nr_mes_ref(evl_nr_mes_ref);
	    this.evl_nr_mes_ref.setText(evl_evolucao_lucroTGWT.getEvl_nr_mes_ref() + "");

            int evl_nr_ano_ref =  Integer.parseInt(EasyContainer.clearAspas(registro.get("evl_nr_ano_ref").toString()));
            evl_evolucao_lucroTGWT.setEvl_nr_ano_ref(evl_nr_ano_ref);
	    this.evl_nr_ano_ref.setText(evl_evolucao_lucroTGWT.getEvl_nr_ano_ref() + "");

            String evl_tx_tipo =   (EasyContainer.clearAspas(registro.get("evl_tx_tipo").toString()));
            evl_evolucao_lucroTGWT.setEvl_tx_tipo(evl_tx_tipo);
	    this.evl_tx_tipo.setText(evl_evolucao_lucroTGWT.getEvl_tx_tipo() + "");



	    } catch (Exception e) {}		
        }

    }
}

