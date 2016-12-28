/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eqc_equivalencia_composicao;

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
public class Eqc_equivalencia_composicaoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/eqc_equivalencia_composicao/eqc_equivalencia_composicaoUpdateDeleteGWT.jsp";    

    private TextBox coa_nr_id = new TextBox();

    private TextBox con_nr_id = new TextBox();


    private Eqc_equivalencia_composicaoTGWT eqc_equivalencia_composicaoTGWT = new Eqc_equivalencia_composicaoTGWT();
private Eqc_equivalencia_composicaoConsultGWT consultGWT = new Eqc_equivalencia_composicaoConsultGWT();


    public Eqc_equivalencia_composicaoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Eqc_equivalencia_composicaoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Eqc_equivalencia_composicaoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(3, 2);
        grid.setWidget(0, 0, new Label("coa_nr_id:"));
        grid.setWidget(0, 1, coa_nr_id);

        grid.setWidget(1, 0, new Label("con_nr_id:"));
        grid.setWidget(1, 1, con_nr_id);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Eqc_equivalencia_composicaoTGWT eqc_equivalencia_composicaoTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("eqc_equivalencia_composicaoT.coa_nr_id", eqc_equivalencia_composicaoTGWT.getCoa_nr_id() + "");

            param.put("eqc_equivalencia_composicaoT.con_nr_id", eqc_equivalencia_composicaoTGWT.getCon_nr_id() + "");


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
            param.put("eqc_equivalencia_composicaoT.coa_nr_id", coa_nr_id.getText());

            param.put("eqc_equivalencia_composicaoT.con_nr_id", con_nr_id.getText());


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
            param.put("eqc_equivalencia_composicaoT.coa_nr_id", coa_nr_id.getText());

            param.put("eqc_equivalencia_composicaoT.con_nr_id", con_nr_id.getText());


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
              JSONObject registro = resultado.get("eqc_equivalencia_composicao").isObject();
            
              int coa_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("coa_nr_id").toString()));
            eqc_equivalencia_composicaoTGWT.setCoa_nr_id(coa_nr_id);
	    this.coa_nr_id.setText(eqc_equivalencia_composicaoTGWT.getCoa_nr_id() + "");

            int con_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("con_nr_id").toString()));
            eqc_equivalencia_composicaoTGWT.setCon_nr_id(con_nr_id);
	    this.con_nr_id.setText(eqc_equivalencia_composicaoTGWT.getCon_nr_id() + "");



	    } catch (Exception e) {}		
        }

    }
}

