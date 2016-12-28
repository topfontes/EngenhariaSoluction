/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.tet_tmp_equivalencia_treet;

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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;

/**
 *
 * @author geoleite
 */
public class Tet_tmp_equivalencia_treetUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetUpdateDeleteGWT.jsp";    

    private TextField<String> tet_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> plco_tx_nome = new TextField<String>();

    private TextField<String> plc_tx_nome = new TextField<String>();


    private Tet_tmp_equivalencia_treetTGWT tet_tmp_equivalencia_treetTGWT = new Tet_tmp_equivalencia_treetTGWT();
private Tet_tmp_equivalencia_treetConsultGWT consultGWT = new Tet_tmp_equivalencia_treetConsultGWT();


    public Tet_tmp_equivalencia_treetConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Tet_tmp_equivalencia_treetConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Tet_tmp_equivalencia_treetUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(6, 2);
        grid.setWidget(0, 0, new Label("tet_nr_id:"));
        grid.setWidget(0, 1, tet_nr_id);

        grid.setWidget(1, 0, new Label("plco_nr_id:"));
        grid.setWidget(1, 1, plco_nr_id);

        grid.setWidget(2, 0, new Label("plc_nr_id:"));
        grid.setWidget(2, 1, plc_nr_id);

        grid.setWidget(3, 0, new Label("plco_tx_nome:"));
        grid.setWidget(3, 1, plco_tx_nome);

        grid.setWidget(4, 0, new Label("plc_tx_nome:"));
        grid.setWidget(4, 1, plc_tx_nome);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Tet_tmp_equivalencia_treetTGWT tet_tmp_equivalencia_treetTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("tet_tmp_equivalencia_treetT.tet_nr_id", tet_tmp_equivalencia_treetTGWT.getTet_nr_id() + "");

            param.put("tet_tmp_equivalencia_treetT.plco_nr_id", tet_tmp_equivalencia_treetTGWT.getPlco_nr_id() + "");

            param.put("tet_tmp_equivalencia_treetT.plc_nr_id", tet_tmp_equivalencia_treetTGWT.getPlc_nr_id() + "");

            param.put("tet_tmp_equivalencia_treetT.plco_tx_nome", tet_tmp_equivalencia_treetTGWT.getPlco_tx_nome() + "");

            param.put("tet_tmp_equivalencia_treetT.plc_tx_nome", tet_tmp_equivalencia_treetTGWT.getPlc_tx_nome() + "");


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

//    @Override
    public void btnUpdateAction(ToolBarEvent ce) {
        btnAltAction(ce);
    }

  //  @Override
    public void btnDeltAction(ToolBarEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ToolBarEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("tet_tmp_equivalencia_treetT.tet_nr_id", tet_nr_id.getValue());

            param.put("tet_tmp_equivalencia_treetT.plco_nr_id", plco_nr_id.getValue());

            param.put("tet_tmp_equivalencia_treetT.plc_nr_id", plc_nr_id.getValue());

            param.put("tet_tmp_equivalencia_treetT.plco_tx_nome", plco_tx_nome.getValue());

            param.put("tet_tmp_equivalencia_treetT.plc_tx_nome", plc_tx_nome.getValue());


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
            param.put("tet_tmp_equivalencia_treetT.tet_nr_id", tet_nr_id.getValue());

            param.put("tet_tmp_equivalencia_treetT.plco_nr_id", plco_nr_id.getValue());

            param.put("tet_tmp_equivalencia_treetT.plc_nr_id", plc_nr_id.getValue());

            param.put("tet_tmp_equivalencia_treetT.plco_tx_nome", plco_tx_nome.getValue());

            param.put("tet_tmp_equivalencia_treetT.plc_tx_nome", plc_tx_nome.getValue());


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
              JSONObject registro = resultado.get("tet_tmp_equivalencia_treet").isObject();
            
              int tet_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("tet_nr_id").toString()));
            tet_tmp_equivalencia_treetTGWT.setTet_nr_id(tet_nr_id);
	    this.tet_nr_id.setValue(tet_tmp_equivalencia_treetTGWT.getTet_nr_id() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            tet_tmp_equivalencia_treetTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(tet_tmp_equivalencia_treetTGWT.getPlco_nr_id() + "");

            int plc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
            tet_tmp_equivalencia_treetTGWT.setPlc_nr_id(plc_nr_id);
	    this.plc_nr_id.setValue(tet_tmp_equivalencia_treetTGWT.getPlc_nr_id() + "");

            String plco_tx_nome =   (EasyContainer.clearAspas(registro.get("plco_tx_nome").toString()));
            tet_tmp_equivalencia_treetTGWT.setPlco_tx_nome(plco_tx_nome);
	    this.plco_tx_nome.setValue(tet_tmp_equivalencia_treetTGWT.getPlco_tx_nome() + "");

            String plc_tx_nome =   (EasyContainer.clearAspas(registro.get("plc_tx_nome").toString()));
            tet_tmp_equivalencia_treetTGWT.setPlc_tx_nome(plc_tx_nome);
	    this.plc_tx_nome.setValue(tet_tmp_equivalencia_treetTGWT.getPlc_tx_nome() + "");



	    } catch (Exception e) {}		
        }

    }
}

