/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.htf_horas_trabalha_folha;

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
public class Htf_horas_trabalha_folhaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaUpdateDeleteGWT.jsp";    

    private TextBox htf_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox htf_nr_mes = new TextBox();

    private TextBox htf_nr_ano = new TextBox();

    private TextBox htf_nr_horas_trabalhada = new TextBox();


    private Htf_horas_trabalha_folhaTGWT htf_horas_trabalha_folhaTGWT = new Htf_horas_trabalha_folhaTGWT();
private Htf_horas_trabalha_folhaConsultGWT consultGWT = new Htf_horas_trabalha_folhaConsultGWT();


    public Htf_horas_trabalha_folhaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Htf_horas_trabalha_folhaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Htf_horas_trabalha_folhaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(6, 2);
        grid.setWidget(0, 0, new Label("htf_nr_id:"));
        grid.setWidget(0, 1, htf_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("htf_nr_mes:"));
        grid.setWidget(2, 1, htf_nr_mes);

        grid.setWidget(3, 0, new Label("htf_nr_ano:"));
        grid.setWidget(3, 1, htf_nr_ano);

        grid.setWidget(4, 0, new Label("htf_nr_horas_trabalhada:"));
        grid.setWidget(4, 1, htf_nr_horas_trabalhada);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Htf_horas_trabalha_folhaTGWT htf_horas_trabalha_folhaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("htf_horas_trabalha_folhaT.htf_nr_id", htf_horas_trabalha_folhaTGWT.getHtf_nr_id() + "");

            param.put("htf_horas_trabalha_folhaT.obr_nr_id", htf_horas_trabalha_folhaTGWT.getObr_nr_id() + "");

            param.put("htf_horas_trabalha_folhaT.htf_nr_mes", htf_horas_trabalha_folhaTGWT.getHtf_nr_mes() + "");

            param.put("htf_horas_trabalha_folhaT.htf_nr_ano", htf_horas_trabalha_folhaTGWT.getHtf_nr_ano() + "");

            param.put("htf_horas_trabalha_folhaT.htf_nr_horas_trabalhada", htf_horas_trabalha_folhaTGWT.getHtf_nr_horas_trabalhada() + "");


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
            param.put("htf_horas_trabalha_folhaT.htf_nr_id", htf_nr_id.getText());

            param.put("htf_horas_trabalha_folhaT.obr_nr_id", obr_nr_id.getText());

            param.put("htf_horas_trabalha_folhaT.htf_nr_mes", htf_nr_mes.getText());

            param.put("htf_horas_trabalha_folhaT.htf_nr_ano", htf_nr_ano.getText());

            param.put("htf_horas_trabalha_folhaT.htf_nr_horas_trabalhada", htf_nr_horas_trabalhada.getText());


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
            param.put("htf_horas_trabalha_folhaT.htf_nr_id", htf_nr_id.getText());

            param.put("htf_horas_trabalha_folhaT.obr_nr_id", obr_nr_id.getText());

            param.put("htf_horas_trabalha_folhaT.htf_nr_mes", htf_nr_mes.getText());

            param.put("htf_horas_trabalha_folhaT.htf_nr_ano", htf_nr_ano.getText());

            param.put("htf_horas_trabalha_folhaT.htf_nr_horas_trabalhada", htf_nr_horas_trabalhada.getText());


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
              JSONObject registro = resultado.get("htf_horas_trabalha_folha").isObject();
            
              int htf_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("htf_nr_id").toString()));
            htf_horas_trabalha_folhaTGWT.setHtf_nr_id(htf_nr_id);
	    this.htf_nr_id.setText(htf_horas_trabalha_folhaTGWT.getHtf_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            htf_horas_trabalha_folhaTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setText(htf_horas_trabalha_folhaTGWT.getObr_nr_id() + "");

            int htf_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("htf_nr_mes").toString()));
            htf_horas_trabalha_folhaTGWT.setHtf_nr_mes(htf_nr_mes);
	    this.htf_nr_mes.setText(htf_horas_trabalha_folhaTGWT.getHtf_nr_mes() + "");

            int htf_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("htf_nr_ano").toString()));
            htf_horas_trabalha_folhaTGWT.setHtf_nr_ano(htf_nr_ano);
	    this.htf_nr_ano.setText(htf_horas_trabalha_folhaTGWT.getHtf_nr_ano() + "");

            float htf_nr_horas_trabalhada =  Float.parseFloat(EasyContainer.clearAspas(registro.get("htf_nr_horas_trabalhada").toString()));
            htf_horas_trabalha_folhaTGWT.setHtf_nr_horas_trabalhada(htf_nr_horas_trabalhada);
	    this.htf_nr_horas_trabalhada.setText(htf_horas_trabalha_folhaTGWT.getHtf_nr_horas_trabalhada() + "");



	    } catch (Exception e) {}		
        }

    }
}

