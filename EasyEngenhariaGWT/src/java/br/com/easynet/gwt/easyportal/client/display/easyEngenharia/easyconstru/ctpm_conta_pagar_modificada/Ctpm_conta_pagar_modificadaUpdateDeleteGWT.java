/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctpm_conta_pagar_modificada;

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
public class Ctpm_conta_pagar_modificadaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaUpdateDeleteGWT.jsp";    

    private TextBox ctpm_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox ctp_nr_id = new TextBox();

    private TextBox ctpm_nr_mes = new TextBox();

    private TextBox ctpm_nr_ano = new TextBox();

    private TextBox ctpm_tx_tipo = new TextBox();


    private Ctpm_conta_pagar_modificadaTGWT ctpm_conta_pagar_modificadaTGWT = new Ctpm_conta_pagar_modificadaTGWT();
private Ctpm_conta_pagar_modificadaConsultGWT consultGWT = new Ctpm_conta_pagar_modificadaConsultGWT();


    public Ctpm_conta_pagar_modificadaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ctpm_conta_pagar_modificadaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Ctpm_conta_pagar_modificadaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(7, 2);
        grid.setWidget(0, 0, new Label("ctpm_nr_id:"));
        grid.setWidget(0, 1, ctpm_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("ctp_nr_id:"));
        grid.setWidget(2, 1, ctp_nr_id);

        grid.setWidget(3, 0, new Label("ctpm_nr_mes:"));
        grid.setWidget(3, 1, ctpm_nr_mes);

        grid.setWidget(4, 0, new Label("ctpm_nr_ano:"));
        grid.setWidget(4, 1, ctpm_nr_ano);

        grid.setWidget(5, 0, new Label("ctpm_tx_tipo:"));
        grid.setWidget(5, 1, ctpm_tx_tipo);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Ctpm_conta_pagar_modificadaTGWT ctpm_conta_pagar_modificadaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_id", ctpm_conta_pagar_modificadaTGWT.getCtpm_nr_id() + "");

            param.put("ctpm_conta_pagar_modificadaT.obr_nr_id", ctpm_conta_pagar_modificadaTGWT.getObr_nr_id() + "");

            param.put("ctpm_conta_pagar_modificadaT.ctp_nr_id", ctpm_conta_pagar_modificadaTGWT.getCtp_nr_id() + "");

            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_mes", ctpm_conta_pagar_modificadaTGWT.getCtpm_nr_mes() + "");

            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_ano", ctpm_conta_pagar_modificadaTGWT.getCtpm_nr_ano() + "");

            param.put("ctpm_conta_pagar_modificadaT.ctpm_tx_tipo", ctpm_conta_pagar_modificadaTGWT.getCtpm_tx_tipo() + "");


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
            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_id", ctpm_nr_id.getText());

            param.put("ctpm_conta_pagar_modificadaT.obr_nr_id", obr_nr_id.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctp_nr_id", ctp_nr_id.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_mes", ctpm_nr_mes.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_ano", ctpm_nr_ano.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctpm_tx_tipo", ctpm_tx_tipo.getText());


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
            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_id", ctpm_nr_id.getText());

            param.put("ctpm_conta_pagar_modificadaT.obr_nr_id", obr_nr_id.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctp_nr_id", ctp_nr_id.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_mes", ctpm_nr_mes.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_ano", ctpm_nr_ano.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctpm_tx_tipo", ctpm_tx_tipo.getText());


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
              JSONObject registro = resultado.get("ctpm_conta_pagar_modificada").isObject();
            
              int ctpm_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ctpm_nr_id").toString()));
            ctpm_conta_pagar_modificadaTGWT.setCtpm_nr_id(ctpm_nr_id);
	    this.ctpm_nr_id.setText(ctpm_conta_pagar_modificadaTGWT.getCtpm_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            ctpm_conta_pagar_modificadaTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setText(ctpm_conta_pagar_modificadaTGWT.getObr_nr_id() + "");

            int ctp_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_id").toString()));
            ctpm_conta_pagar_modificadaTGWT.setCtp_nr_id(ctp_nr_id);
	    this.ctp_nr_id.setText(ctpm_conta_pagar_modificadaTGWT.getCtp_nr_id() + "");

            int ctpm_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ctpm_nr_mes").toString()));
            ctpm_conta_pagar_modificadaTGWT.setCtpm_nr_mes(ctpm_nr_mes);
	    this.ctpm_nr_mes.setText(ctpm_conta_pagar_modificadaTGWT.getCtpm_nr_mes() + "");

            int ctpm_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ctpm_nr_ano").toString()));
            ctpm_conta_pagar_modificadaTGWT.setCtpm_nr_ano(ctpm_nr_ano);
	    this.ctpm_nr_ano.setText(ctpm_conta_pagar_modificadaTGWT.getCtpm_nr_ano() + "");

            String ctpm_tx_tipo =   (EasyContainer.clearAspas(registro.get("ctpm_tx_tipo").toString()));
            ctpm_conta_pagar_modificadaTGWT.setCtpm_tx_tipo(ctpm_tx_tipo);
	    this.ctpm_tx_tipo.setText(ctpm_conta_pagar_modificadaTGWT.getCtpm_tx_tipo() + "");



	    } catch (Exception e) {}		
        }

    }
}

