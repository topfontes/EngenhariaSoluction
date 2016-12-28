/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_insumo_plc_pms;

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
import com.extjs.gxt.ui.client.event.ButtonEvent;

/**
 *
 * @author geoleite
 */
public class Vw_insumo_plc_pmsUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_insumo_plc_pms/vw_insumo_plc_pmsUpdateDeleteGWT.jsp";    

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id_super = new TextField<String>();

    private TextField<String> plc_tx_nome_super = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> plc_tx_nome = new TextField<String>();

    private TextField<String> ipo_nr_vl_unitario = new TextField<String>();

    private TextField<String> pms_nr_mes = new TextField<String>();

    private TextField<String> pms_nr_ano = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> perc = new TextField<String>();

    private TextField<String> vl_total = new TextField<String>();

    private TextField<String> vl_executado = new TextField<String>();


    private Vw_insumo_plc_pmsTGWT vw_insumo_plc_pmsTGWT = new Vw_insumo_plc_pmsTGWT();
private Vw_insumo_plc_pmsConsultGWT consultGWT = new Vw_insumo_plc_pmsConsultGWT("");


    public Vw_insumo_plc_pmsConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_insumo_plc_pmsConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Vw_insumo_plc_pmsUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(13, 2);
        grid.setWidget(0, 0, new Label("obr_nr_id:"));
        grid.setWidget(0, 1, obr_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id_super:"));
        grid.setWidget(1, 1, plc_nr_id_super);

        grid.setWidget(2, 0, new Label("plc_tx_nome_super:"));
        grid.setWidget(2, 1, plc_tx_nome_super);

        grid.setWidget(3, 0, new Label("plc_nr_id:"));
        grid.setWidget(3, 1, plc_nr_id);

        grid.setWidget(4, 0, new Label("plc_tx_nome:"));
        grid.setWidget(4, 1, plc_tx_nome);

        grid.setWidget(5, 0, new Label("ipo_nr_vl_unitario:"));
        grid.setWidget(5, 1, ipo_nr_vl_unitario);

        grid.setWidget(6, 0, new Label("pms_nr_mes:"));
        grid.setWidget(6, 1, pms_nr_mes);

        grid.setWidget(7, 0, new Label("pms_nr_ano:"));
        grid.setWidget(7, 1, pms_nr_ano);

        grid.setWidget(8, 0, new Label("plco_nr_id:"));
        grid.setWidget(8, 1, plco_nr_id);

        grid.setWidget(9, 0, new Label("perc:"));
        grid.setWidget(9, 1, perc);

        grid.setWidget(10, 0, new Label("vl_total:"));
        grid.setWidget(10, 1, vl_total);

        grid.setWidget(11, 0, new Label("vl_executado:"));
        grid.setWidget(11, 1, vl_executado);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Vw_insumo_plc_pmsTGWT vw_insumo_plc_pmsTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("vw_insumo_plc_pmsT.obr_nr_id", vw_insumo_plc_pmsTGWT.getObr_nr_id() + "");

            param.put("vw_insumo_plc_pmsT.plc_nr_id_super", vw_insumo_plc_pmsTGWT.getPlc_nr_id_super() + "");

            param.put("vw_insumo_plc_pmsT.plc_tx_nome_super", vw_insumo_plc_pmsTGWT.getPlc_tx_nome_super() + "");

            param.put("vw_insumo_plc_pmsT.plc_nr_id", vw_insumo_plc_pmsTGWT.getPlc_nr_id() + "");

            param.put("vw_insumo_plc_pmsT.plc_tx_nome", vw_insumo_plc_pmsTGWT.getPlc_tx_nome() + "");

            param.put("vw_insumo_plc_pmsT.ipo_nr_vl_unitario", vw_insumo_plc_pmsTGWT.getIpo_nr_vl_unitario() + "");

            param.put("vw_insumo_plc_pmsT.pms_nr_mes", vw_insumo_plc_pmsTGWT.getPms_nr_mes() + "");

            param.put("vw_insumo_plc_pmsT.pms_nr_ano", vw_insumo_plc_pmsTGWT.getPms_nr_ano() + "");

            param.put("vw_insumo_plc_pmsT.plco_nr_id", vw_insumo_plc_pmsTGWT.getPlco_nr_id() + "");

            param.put("vw_insumo_plc_pmsT.perc", vw_insumo_plc_pmsTGWT.getPerc() + "");

            param.put("vw_insumo_plc_pmsT.vl_total", vw_insumo_plc_pmsTGWT.getVl_total() + "");

            param.put("vw_insumo_plc_pmsT.vl_executado", vw_insumo_plc_pmsTGWT.getVl_executado() + "");


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
            param.put("vw_insumo_plc_pmsT.obr_nr_id", obr_nr_id.getValue());

            param.put("vw_insumo_plc_pmsT.plc_nr_id_super", plc_nr_id_super.getValue());

            param.put("vw_insumo_plc_pmsT.plc_tx_nome_super", plc_tx_nome_super.getValue());

            param.put("vw_insumo_plc_pmsT.plc_nr_id", plc_nr_id.getValue());

            param.put("vw_insumo_plc_pmsT.plc_tx_nome", plc_tx_nome.getValue());

            param.put("vw_insumo_plc_pmsT.ipo_nr_vl_unitario", ipo_nr_vl_unitario.getValue());

            param.put("vw_insumo_plc_pmsT.pms_nr_mes", pms_nr_mes.getValue());

            param.put("vw_insumo_plc_pmsT.pms_nr_ano", pms_nr_ano.getValue());

            param.put("vw_insumo_plc_pmsT.plco_nr_id", plco_nr_id.getValue());

            param.put("vw_insumo_plc_pmsT.perc", perc.getValue());

            param.put("vw_insumo_plc_pmsT.vl_total", vl_total.getValue());

            param.put("vw_insumo_plc_pmsT.vl_executado", vl_executado.getValue());


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
            param.put("vw_insumo_plc_pmsT.obr_nr_id", obr_nr_id.getValue());

            param.put("vw_insumo_plc_pmsT.plc_nr_id_super", plc_nr_id_super.getValue());

            param.put("vw_insumo_plc_pmsT.plc_tx_nome_super", plc_tx_nome_super.getValue());

            param.put("vw_insumo_plc_pmsT.plc_nr_id", plc_nr_id.getValue());

            param.put("vw_insumo_plc_pmsT.plc_tx_nome", plc_tx_nome.getValue());

            param.put("vw_insumo_plc_pmsT.ipo_nr_vl_unitario", ipo_nr_vl_unitario.getValue());

            param.put("vw_insumo_plc_pmsT.pms_nr_mes", pms_nr_mes.getValue());

            param.put("vw_insumo_plc_pmsT.pms_nr_ano", pms_nr_ano.getValue());

            param.put("vw_insumo_plc_pmsT.plco_nr_id", plco_nr_id.getValue());

            param.put("vw_insumo_plc_pmsT.perc", perc.getValue());

            param.put("vw_insumo_plc_pmsT.vl_total", vl_total.getValue());

            param.put("vw_insumo_plc_pmsT.vl_executado", vl_executado.getValue());


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
              JSONObject registro = resultado.get("vw_insumo_plc_pms").isObject();
            
              int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            vw_insumo_plc_pmsTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setValue(vw_insumo_plc_pmsTGWT.getObr_nr_id() + "");

            int plc_nr_id_super =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id_super").toString()));
            vw_insumo_plc_pmsTGWT.setPlc_nr_id_super(plc_nr_id_super);
	    this.plc_nr_id_super.setValue(vw_insumo_plc_pmsTGWT.getPlc_nr_id_super() + "");

            String plc_tx_nome_super =   (EasyContainer.clearAspas(registro.get("plc_tx_nome_super").toString()));
            vw_insumo_plc_pmsTGWT.setPlc_tx_nome_super(plc_tx_nome_super);
	    this.plc_tx_nome_super.setValue(vw_insumo_plc_pmsTGWT.getPlc_tx_nome_super() + "");

            int plc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
            vw_insumo_plc_pmsTGWT.setPlc_nr_id(plc_nr_id);
	    this.plc_nr_id.setValue(vw_insumo_plc_pmsTGWT.getPlc_nr_id() + "");

            String plc_tx_nome =   (EasyContainer.clearAspas(registro.get("plc_tx_nome").toString()));
            vw_insumo_plc_pmsTGWT.setPlc_tx_nome(plc_tx_nome);
	    this.plc_tx_nome.setValue(vw_insumo_plc_pmsTGWT.getPlc_tx_nome() + "");

            float ipo_nr_vl_unitario =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_unitario").toString()));
            vw_insumo_plc_pmsTGWT.setIpo_nr_vl_unitario(ipo_nr_vl_unitario);
	    this.ipo_nr_vl_unitario.setValue(vw_insumo_plc_pmsTGWT.getIpo_nr_vl_unitario() + "");

            int pms_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("pms_nr_mes").toString()));
            vw_insumo_plc_pmsTGWT.setPms_nr_mes(pms_nr_mes);
	    this.pms_nr_mes.setValue(vw_insumo_plc_pmsTGWT.getPms_nr_mes() + "");

            int pms_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("pms_nr_ano").toString()));
            vw_insumo_plc_pmsTGWT.setPms_nr_ano(pms_nr_ano);
	    this.pms_nr_ano.setValue(vw_insumo_plc_pmsTGWT.getPms_nr_ano() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            vw_insumo_plc_pmsTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(vw_insumo_plc_pmsTGWT.getPlco_nr_id() + "");

            float perc =  Float.parseFloat(EasyContainer.clearAspas(registro.get("perc").toString()));
            vw_insumo_plc_pmsTGWT.setPerc(perc);
	    this.perc.setValue(vw_insumo_plc_pmsTGWT.getPerc() + "");

            float vl_total =  Float.parseFloat(EasyContainer.clearAspas(registro.get("vl_total").toString()));
            vw_insumo_plc_pmsTGWT.setVl_total(vl_total);
	    this.vl_total.setValue(vw_insumo_plc_pmsTGWT.getVl_total() + "");

            float vl_executado =  Float.parseFloat(EasyContainer.clearAspas(registro.get("vl_executado").toString()));
            vw_insumo_plc_pmsTGWT.setVl_executado(vl_executado);
	    this.vl_executado.setValue(vw_insumo_plc_pmsTGWT.getVl_executado() + "");



	    } catch (Exception e) {}		
        }

    }
}

