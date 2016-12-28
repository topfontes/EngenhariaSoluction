/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_curva_abc_equivalencia;

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
public class Vw_curva_abc_equivalenciaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaUpdateDeleteGWT.jsp";    

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> plc_tx_nome = new TextField<String>();

    private TextField<String> total = new TextField<String>();


    private Vw_curva_abc_equivalenciaTGWT vw_curva_abc_equivalenciaTGWT = new Vw_curva_abc_equivalenciaTGWT();
private Vw_curva_abc_equivalenciaConsultGWT consultGWT = new Vw_curva_abc_equivalenciaConsultGWT();


    public Vw_curva_abc_equivalenciaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_curva_abc_equivalenciaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Vw_curva_abc_equivalenciaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("obr_nr_id:"));
        grid.setWidget(0, 1, obr_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id:"));
        grid.setWidget(1, 1, plc_nr_id);

        grid.setWidget(2, 0, new Label("plc_tx_nome:"));
        grid.setWidget(2, 1, plc_tx_nome);

        grid.setWidget(3, 0, new Label("total:"));
        grid.setWidget(3, 1, total);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Vw_curva_abc_equivalenciaTGWT vw_curva_abc_equivalenciaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("vw_curva_abc_equivalenciaT.obr_nr_id", vw_curva_abc_equivalenciaTGWT.getObr_nr_id() + "");

            param.put("vw_curva_abc_equivalenciaT.plc_nr_id", vw_curva_abc_equivalenciaTGWT.getPlc_nr_id() + "");

            param.put("vw_curva_abc_equivalenciaT.plc_tx_nome", vw_curva_abc_equivalenciaTGWT.getPlc_tx_nome() + "");

            param.put("vw_curva_abc_equivalenciaT.total", vw_curva_abc_equivalenciaTGWT.getTotal() + "");


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
            param.put("vw_curva_abc_equivalenciaT.obr_nr_id", obr_nr_id.getValue());

            param.put("vw_curva_abc_equivalenciaT.plc_nr_id", plc_nr_id.getValue());

            param.put("vw_curva_abc_equivalenciaT.plc_tx_nome", plc_tx_nome.getValue());

            param.put("vw_curva_abc_equivalenciaT.total", total.getValue());


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
            param.put("vw_curva_abc_equivalenciaT.obr_nr_id", obr_nr_id.getValue());

            param.put("vw_curva_abc_equivalenciaT.plc_nr_id", plc_nr_id.getValue());

            param.put("vw_curva_abc_equivalenciaT.plc_tx_nome", plc_tx_nome.getValue());

            param.put("vw_curva_abc_equivalenciaT.total", total.getValue());


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
              JSONObject registro = resultado.get("vw_curva_abc_equivalencia").isObject();
            
              int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            vw_curva_abc_equivalenciaTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setValue(vw_curva_abc_equivalenciaTGWT.getObr_nr_id() + "");

            int plc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
            vw_curva_abc_equivalenciaTGWT.setPlc_nr_id(plc_nr_id);
	    this.plc_nr_id.setValue(vw_curva_abc_equivalenciaTGWT.getPlc_nr_id() + "");

            String plc_tx_nome =   (EasyContainer.clearAspas(registro.get("plc_tx_nome").toString()));
            vw_curva_abc_equivalenciaTGWT.setPlc_tx_nome(plc_tx_nome);
	    this.plc_tx_nome.setValue(vw_curva_abc_equivalenciaTGWT.getPlc_tx_nome() + "");

            float total =  Float.parseFloat(EasyContainer.clearAspas(registro.get("total").toString()));
            vw_curva_abc_equivalenciaTGWT.setTotal(total);
	    this.total.setValue(vw_curva_abc_equivalenciaTGWT.getTotal() + "");



	    } catch (Exception e) {}		
        }

    }
}

