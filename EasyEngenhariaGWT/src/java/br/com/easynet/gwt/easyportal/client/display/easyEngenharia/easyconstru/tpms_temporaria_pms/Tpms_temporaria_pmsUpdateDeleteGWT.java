/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.tpms_temporaria_pms;

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
import com.extjs.gxt.ui.client.widget.form.CheckBox;

/**
 *
 * @author geoleite
 */
public class Tpms_temporaria_pmsUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsUpdateDeleteGWT.jsp";    

    private TextField<String> tmps_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> tpms_nr_quantidade = new TextField<String>();

    private CheckBox tpms_bl_servico = new CheckBox();


    private Tpms_temporaria_pmsTGWT tpms_temporaria_pmsTGWT = new Tpms_temporaria_pmsTGWT();
private Tpms_temporaria_pmsConsultGWT consultGWT = new Tpms_temporaria_pmsConsultGWT();


    public Tpms_temporaria_pmsConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Tpms_temporaria_pmsConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Tpms_temporaria_pmsUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("tmps_nr_id:"));
        grid.setWidget(0, 1, tmps_nr_id);

        grid.setWidget(1, 0, new Label("plco_nr_id:"));
        grid.setWidget(1, 1, plco_nr_id);

        grid.setWidget(2, 0, new Label("tmps_nr_quantidade:"));
        grid.setWidget(2, 1, tpms_nr_quantidade);

        grid.setWidget(3, 0, new Label("tpms_bl_servico:"));
        grid.setWidget(3, 1, tpms_bl_servico);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Tpms_temporaria_pmsTGWT tpms_temporaria_pmsTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("tpms_temporaria_pmsT.tmps_nr_id", tpms_temporaria_pmsTGWT.getTmps_nr_id() + "");

            param.put("tpms_temporaria_pmsT.plco_nr_id", tpms_temporaria_pmsTGWT.getPlco_nr_id() + "");

            param.put("tpms_temporaria_pmsT.tpms_nr_quantidade", tpms_temporaria_pmsTGWT.getTpms_nr_quantidade() + "");

            param.put("tpms_temporaria_pmsT.tpms_bl_servico", tpms_temporaria_pmsTGWT.getTpms_bl_servico() + "");


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
            param.put("tpms_temporaria_pmsT.tmps_nr_id", tmps_nr_id.getValue());

            param.put("tpms_temporaria_pmsT.plco_nr_id", plco_nr_id.getValue());

            param.put("tpms_temporaria_pmsT.tmps_nr_quantidade", tpms_nr_quantidade.getValue());

            param.put("tpms_temporaria_pmsT.tpms_bl_servico", tpms_bl_servico.getValue()?"true":"false");

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
            param.put("tpms_temporaria_pmsT.tmps_nr_id", tmps_nr_id.getValue());

            param.put("tpms_temporaria_pmsT.plco_nr_id", plco_nr_id.getValue());

            param.put("tpms_temporaria_pmsT.tpms_nr_quantidade", tpms_nr_quantidade.getValue());

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
              JSONObject registro = resultado.get("tpms_temporaria_pms").isObject();
            
              int tmps_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("tmps_nr_id").toString()));
            tpms_temporaria_pmsTGWT.setTmps_nr_id(tmps_nr_id);
	    this.tmps_nr_id.setValue(tpms_temporaria_pmsTGWT.getTmps_nr_id() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            tpms_temporaria_pmsTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(tpms_temporaria_pmsTGWT.getPlco_nr_id() + "");

            float tpms_nr_quantidade =  Float.parseFloat(EasyContainer.clearAspas(registro.get("tpms_nr_quantidade").toString()));
            tpms_temporaria_pmsTGWT.setTpms_nr_quantidade(tpms_nr_quantidade);
	    this.tpms_nr_quantidade.setValue(tpms_temporaria_pmsTGWT.getTpms_nr_quantidade() + "");

            String tpms_bl_servico =   (EasyContainer.clearAspas(registro.get("tpms_bl_servico").toString()));
            tpms_temporaria_pmsTGWT.setTpms_bl_servico(tpms_bl_servico.equalsIgnoreCase("true")?true:false);
	    this.tpms_bl_servico.setValue(tpms_temporaria_pmsTGWT.getTpms_bl_servico());



	    } catch (Exception e) {}		
        }

    }
}

