/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_equivalencia;

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
public class Vw_equivalenciaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaUpdateDeleteGWT.jsp";    

    private TextField<String> eplc_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> plco_tx_nome = new TextField<String>();

    private TextField<String> plc_tx_nome = new TextField<String>();

    private TextField<String> plco_tx_tipo = new TextField<String>();

    private TextField<String> plco_tx_cod_externo = new TextField<String>();

    private TextField<String> plco_tx_unidade = new TextField<String>();


    private Vw_equivalenciaTGWT vw_equivalenciaTGWT = new Vw_equivalenciaTGWT();
private Vw_equivalenciaConsultGWT consultGWT = new Vw_equivalenciaConsultGWT();


    public Vw_equivalenciaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_equivalenciaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Vw_equivalenciaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(9, 2);
        grid.setWidget(0, 0, new Label("eplc_nr_id:"));
        grid.setWidget(0, 1, eplc_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id:"));
        grid.setWidget(1, 1, plc_nr_id);

        grid.setWidget(2, 0, new Label("plco_nr_id:"));
        grid.setWidget(2, 1, plco_nr_id);

        grid.setWidget(3, 0, new Label("plco_tx_nome:"));
        grid.setWidget(3, 1, plco_tx_nome);

        grid.setWidget(4, 0, new Label("plc_tx_nome:"));
        grid.setWidget(4, 1, plc_tx_nome);

        grid.setWidget(5, 0, new Label("plco_tx_tipo:"));
        grid.setWidget(5, 1, plco_tx_tipo);

        grid.setWidget(6, 0, new Label("plco_tx_cod_externo:"));
        grid.setWidget(6, 1, plco_tx_cod_externo);

        grid.setWidget(7, 0, new Label("plco_tx_unidade:"));
        grid.setWidget(7, 1, plco_tx_unidade);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Vw_equivalenciaTGWT vw_equivalenciaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("vw_equivalenciaT.eplc_nr_id", vw_equivalenciaTGWT.getEplc_nr_id() + "");

            param.put("vw_equivalenciaT.plc_nr_id", vw_equivalenciaTGWT.getPlc_nr_id() + "");

            param.put("vw_equivalenciaT.plco_nr_id", vw_equivalenciaTGWT.getPlco_nr_id() + "");

            param.put("vw_equivalenciaT.plco_tx_nome", vw_equivalenciaTGWT.getPlco_tx_nome() + "");

            param.put("vw_equivalenciaT.plc_tx_nome", vw_equivalenciaTGWT.getPlc_tx_nome() + "");

            param.put("vw_equivalenciaT.plco_tx_tipo", vw_equivalenciaTGWT.getPlco_tx_tipo() + "");

            param.put("vw_equivalenciaT.plco_tx_cod_externo", vw_equivalenciaTGWT.getPlco_tx_cod_externo() + "");

            param.put("vw_equivalenciaT.plco_tx_unidade", vw_equivalenciaTGWT.getPlco_tx_unidade() + "");


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

//    @Override
    public void btnUpdateAction(ToolBarEvent ce) {
        btnAltAction(ce);
    }

    //@Override
    public void btnDeltAction(ToolBarEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ToolBarEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("vw_equivalenciaT.eplc_nr_id", eplc_nr_id.getValue());

            param.put("vw_equivalenciaT.plc_nr_id", plc_nr_id.getValue());

            param.put("vw_equivalenciaT.plco_nr_id", plco_nr_id.getValue());

            param.put("vw_equivalenciaT.plco_tx_nome", plco_tx_nome.getValue());

            param.put("vw_equivalenciaT.plc_tx_nome", plc_tx_nome.getValue());

            param.put("vw_equivalenciaT.plco_tx_tipo", plco_tx_tipo.getValue());

            param.put("vw_equivalenciaT.plco_tx_cod_externo", plco_tx_cod_externo.getValue());

            param.put("vw_equivalenciaT.plco_tx_unidade", plco_tx_unidade.getValue());


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
            param.put("vw_equivalenciaT.eplc_nr_id", eplc_nr_id.getValue());

            param.put("vw_equivalenciaT.plc_nr_id", plc_nr_id.getValue());

            param.put("vw_equivalenciaT.plco_nr_id", plco_nr_id.getValue());

            param.put("vw_equivalenciaT.plco_tx_nome", plco_tx_nome.getValue());

            param.put("vw_equivalenciaT.plc_tx_nome", plc_tx_nome.getValue());

            param.put("vw_equivalenciaT.plco_tx_tipo", plco_tx_tipo.getValue());

            param.put("vw_equivalenciaT.plco_tx_cod_externo", plco_tx_cod_externo.getValue());

            param.put("vw_equivalenciaT.plco_tx_unidade", plco_tx_unidade.getValue());


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
              JSONObject registro = resultado.get("vw_equivalencia").isObject();
            
              int eplc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("eplc_nr_id").toString()));
            vw_equivalenciaTGWT.setEplc_nr_id(eplc_nr_id);
	    this.eplc_nr_id.setValue(vw_equivalenciaTGWT.getEplc_nr_id() + "");

            int plc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
            vw_equivalenciaTGWT.setPlc_nr_id(plc_nr_id);
	    this.plc_nr_id.setValue(vw_equivalenciaTGWT.getPlc_nr_id() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            vw_equivalenciaTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(vw_equivalenciaTGWT.getPlco_nr_id() + "");

            String plco_tx_nome =   (EasyContainer.clearAspas(registro.get("plco_tx_nome").toString()));
            vw_equivalenciaTGWT.setPlco_tx_nome(plco_tx_nome);
	    this.plco_tx_nome.setValue(vw_equivalenciaTGWT.getPlco_tx_nome() + "");

            String plc_tx_nome =   (EasyContainer.clearAspas(registro.get("plc_tx_nome").toString()));
            vw_equivalenciaTGWT.setPlc_tx_nome(plc_tx_nome);
	    this.plc_tx_nome.setValue(vw_equivalenciaTGWT.getPlc_tx_nome() + "");

            String plco_tx_tipo =   (EasyContainer.clearAspas(registro.get("plco_tx_tipo").toString()));
            vw_equivalenciaTGWT.setPlco_tx_tipo(plco_tx_tipo);
	    this.plco_tx_tipo.setValue(vw_equivalenciaTGWT.getPlco_tx_tipo() + "");

            String plco_tx_cod_externo =   (EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString()));
            vw_equivalenciaTGWT.setPlco_tx_cod_externo(plco_tx_cod_externo);
	    this.plco_tx_cod_externo.setValue(vw_equivalenciaTGWT.getPlco_tx_cod_externo() + "");

            String plco_tx_unidade =   (EasyContainer.clearAspas(registro.get("plco_tx_unidade").toString()));
            vw_equivalenciaTGWT.setPlco_tx_unidade(plco_tx_unidade);
	    this.plco_tx_unidade.setValue(vw_equivalenciaTGWT.getPlco_tx_unidade() + "");



	    } catch (Exception e) {}		
        }

    }
}

