/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.com_comprometimento;

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
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Com_comprometimentoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoUpdateDeleteGWT.jsp";    

    private TextField<String> com_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> com_nr_valor = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> com_nr_mes = new TextField<String>();

    private TextField<String> com_nr_ano = new TextField<String>();


    private Com_comprometimentoTGWT com_comprometimentoTGWT = new Com_comprometimentoTGWT();
private Com_comprometimentoConsultGWT consultGWT = new Com_comprometimentoConsultGWT();


    public Com_comprometimentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Com_comprometimentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Com_comprometimentoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(7, 2);
        grid.setWidget(0, 0, new Label("com_nr_id:"));
        grid.setWidget(0, 1, com_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id:"));
        grid.setWidget(1, 1, plc_nr_id);

        grid.setWidget(2, 0, new Label("com_nr_valor:"));
        grid.setWidget(2, 1, com_nr_valor);

        grid.setWidget(3, 0, new Label("obr_nr_id:"));
        grid.setWidget(3, 1, obr_nr_id);

        grid.setWidget(4, 0, new Label("com_nr_mes:"));
        grid.setWidget(4, 1, com_nr_mes);

        grid.setWidget(5, 0, new Label("com_nr_ano:"));
        grid.setWidget(5, 1, com_nr_ano);

        getCpMaster().add(grid);
	layout();
    }

    public void load(Com_comprometimentoTGWT com_comprometimentoTGWT) {
        try {
            this.com_comprometimentoTGWT = com_comprometimentoTGWT;
            
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
            param.put("com_comprometimentoT.com_nr_id", com_nr_id.getValue());

            param.put("com_comprometimentoT.plc_nr_id", plc_nr_id.getValue());

            param.put("com_comprometimentoT.com_nr_valor", com_nr_valor.getValue());

            param.put("com_comprometimentoT.obr_nr_id", obr_nr_id.getValue());

            param.put("com_comprometimentoT.com_nr_mes", com_nr_mes.getValue());

            param.put("com_comprometimentoT.com_nr_ano", com_nr_ano.getValue());


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
            param.put("com_comprometimentoT.com_nr_id", com_nr_id.getValue());

            param.put("com_comprometimentoT.plc_nr_id", plc_nr_id.getValue());

            param.put("com_comprometimentoT.com_nr_valor", com_nr_valor.getValue());

            param.put("com_comprometimentoT.obr_nr_id", obr_nr_id.getValue());

            param.put("com_comprometimentoT.com_nr_mes", com_nr_mes.getValue());

            param.put("com_comprometimentoT.com_nr_ano", com_nr_ano.getValue());


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
              JSONObject registro = resultado.get("com_comprometimento").isObject();
            
              int com_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("com_nr_id").toString()));
            com_comprometimentoTGWT.setCom_nr_id(com_nr_id);
	    this.com_nr_id.setValue(com_comprometimentoTGWT.getCom_nr_id() + "");

            int plc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
            com_comprometimentoTGWT.setPlc_nr_id(plc_nr_id);
	    this.plc_nr_id.setValue(com_comprometimentoTGWT.getPlc_nr_id() + "");

            float com_nr_valor =  Float.parseFloat(EasyContainer.clearAspas(registro.get("com_nr_valor").toString()));
            com_comprometimentoTGWT.setCom_nr_valor(com_nr_valor);
	    this.com_nr_valor.setValue(com_comprometimentoTGWT.getCom_nr_valor() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            com_comprometimentoTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setValue(com_comprometimentoTGWT.getObr_nr_id() + "");

            int com_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("com_nr_mes").toString()));
            com_comprometimentoTGWT.setCom_nr_mes(com_nr_mes);
	    this.com_nr_mes.setValue(com_comprometimentoTGWT.getCom_nr_mes() + "");

            int com_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("com_nr_ano").toString()));
            com_comprometimentoTGWT.setCom_nr_ano(com_nr_ano);
	    this.com_nr_ano.setValue(com_comprometimentoTGWT.getCom_nr_ano() + "");



	    } catch (Exception e) {}		
        }

    }
}

