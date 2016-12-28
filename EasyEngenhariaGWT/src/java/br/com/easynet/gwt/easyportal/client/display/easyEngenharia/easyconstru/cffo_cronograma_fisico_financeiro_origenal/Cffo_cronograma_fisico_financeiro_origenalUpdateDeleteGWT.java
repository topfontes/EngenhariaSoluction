/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cffo_cronograma_fisico_financeiro_origenal;

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

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Cffo_cronograma_fisico_financeiro_origenalUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalUpdateDeleteGWT.jsp";    

    private TextField<String> cffo_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> cffo_nr_peso = new TextField<String>();

    private TextField<String> cffo_nr_mes = new TextField<String>();

    private TextField<String> cffo_nr_ano = new TextField<String>();


    private Cffo_cronograma_fisico_financeiro_origenalTGWT cffo_cronograma_fisico_financeiro_origenalTGWT = new Cffo_cronograma_fisico_financeiro_origenalTGWT();
private Cffo_cronograma_fisico_financeiro_origenalConsultGWT consultGWT = new Cffo_cronograma_fisico_financeiro_origenalConsultGWT();


    public Cffo_cronograma_fisico_financeiro_origenalConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Cffo_cronograma_fisico_financeiro_origenalConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Cffo_cronograma_fisico_financeiro_origenalUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(7, 2);
        grid.setWidget(0, 0, new Label("cffo_nr_id:"));
        grid.setWidget(0, 1, cffo_nr_id);

        grid.setWidget(1, 0, new Label("plco_nr_id:"));
        grid.setWidget(1, 1, plco_nr_id);

        grid.setWidget(2, 0, new Label("obr_nr_id:"));
        grid.setWidget(2, 1, obr_nr_id);

        grid.setWidget(3, 0, new Label("cffo_nr_peso:"));
        grid.setWidget(3, 1, cffo_nr_peso);

        grid.setWidget(4, 0, new Label("cffo_nr_mes:"));
        grid.setWidget(4, 1, cffo_nr_mes);

        grid.setWidget(5, 0, new Label("cffo_nr_ano:"));
        grid.setWidget(5, 1, cffo_nr_ano);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Cffo_cronograma_fisico_financeiro_origenalTGWT cffo_cronograma_fisico_financeiro_origenalTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id", cffo_cronograma_fisico_financeiro_origenalTGWT.getCffo_nr_id() + "");

            param.put("cffo_cronograma_fisico_financeiro_origenalT.plco_nr_id", cffo_cronograma_fisico_financeiro_origenalTGWT.getPlco_nr_id() + "");

            param.put("cffo_cronograma_fisico_financeiro_origenalT.obr_nr_id", cffo_cronograma_fisico_financeiro_origenalTGWT.getObr_nr_id() + "");

            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_peso", cffo_cronograma_fisico_financeiro_origenalTGWT.getCffo_nr_peso() + "");

            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_mes", cffo_cronograma_fisico_financeiro_origenalTGWT.getCffo_nr_mes() + "");

            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_ano", cffo_cronograma_fisico_financeiro_origenalTGWT.getCffo_nr_ano() + "");


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
            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id", cffo_nr_id.getValue());

            param.put("cffo_cronograma_fisico_financeiro_origenalT.plco_nr_id", plco_nr_id.getValue());

            param.put("cffo_cronograma_fisico_financeiro_origenalT.obr_nr_id", obr_nr_id.getValue());

            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_peso", cffo_nr_peso.getValue());

            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_mes", cffo_nr_mes.getValue());

            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_ano", cffo_nr_ano.getValue());


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
            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id", cffo_nr_id.getValue());

            param.put("cffo_cronograma_fisico_financeiro_origenalT.plco_nr_id", plco_nr_id.getValue());

            param.put("cffo_cronograma_fisico_financeiro_origenalT.obr_nr_id", obr_nr_id.getValue());

            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_peso", cffo_nr_peso.getValue());

            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_mes", cffo_nr_mes.getValue());

            param.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_ano", cffo_nr_ano.getValue());


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
              JSONObject registro = resultado.get("cffo_cronograma_fisico_financeiro_origenal").isObject();
            
              int cffo_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("cffo_nr_id").toString()));
            cffo_cronograma_fisico_financeiro_origenalTGWT.setCffo_nr_id(cffo_nr_id);
	    this.cffo_nr_id.setValue(cffo_cronograma_fisico_financeiro_origenalTGWT.getCffo_nr_id() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            cffo_cronograma_fisico_financeiro_origenalTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(cffo_cronograma_fisico_financeiro_origenalTGWT.getPlco_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            cffo_cronograma_fisico_financeiro_origenalTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setValue(cffo_cronograma_fisico_financeiro_origenalTGWT.getObr_nr_id() + "");

            float cffo_nr_peso =  Float.parseFloat(EasyContainer.clearAspas(registro.get("cffo_nr_peso").toString()));
            cffo_cronograma_fisico_financeiro_origenalTGWT.setCffo_nr_peso(cffo_nr_peso);
	    this.cffo_nr_peso.setValue(cffo_cronograma_fisico_financeiro_origenalTGWT.getCffo_nr_peso() + "");

            int cffo_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("cffo_nr_mes").toString()));
            cffo_cronograma_fisico_financeiro_origenalTGWT.setCffo_nr_mes(cffo_nr_mes);
	    this.cffo_nr_mes.setValue(cffo_cronograma_fisico_financeiro_origenalTGWT.getCffo_nr_mes() + "");

            int cffo_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("cffo_nr_ano").toString()));
            cffo_cronograma_fisico_financeiro_origenalTGWT.setCffo_nr_ano(cffo_nr_ano);
	    this.cffo_nr_ano.setValue(cffo_cronograma_fisico_financeiro_origenalTGWT.getCffo_nr_ano() + "");



	    } catch (Exception e) {}		
        }

    }
}

