/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_equiv_insumo_pms;

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
public class Vw_equiv_insumo_pmsUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsUpdateDeleteGWT.jsp";    

    private TextBox obr_nr_id = new TextBox();

    private TextBox plc_nr_id = new TextBox();

    private TextBox plc_tx_nome = new TextBox();

    private TextBox insumo = new TextBox();

    private TextBox ipo_nr_vl_unitario = new TextBox();

    private TextBox pms_nr_mes = new TextBox();

    private TextBox pms_nr_ano = new TextBox();

    private TextBox plco_nr_id = new TextBox();

    private TextBox perc = new TextBox();

    private TextBox vl_total = new TextBox();

    private TextBox vl_executado = new TextBox();


    private Vw_equiv_insumo_pmsTGWT vw_equiv_insumo_pmsTGWT = new Vw_equiv_insumo_pmsTGWT();
private Vw_equiv_insumo_pmsConsultGWT consultGWT = new Vw_equiv_insumo_pmsConsultGWT();


    public Vw_equiv_insumo_pmsConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_equiv_insumo_pmsConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Vw_equiv_insumo_pmsUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(12, 2);
        grid.setWidget(0, 0, new Label("obr_nr_id:"));
        grid.setWidget(0, 1, obr_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id:"));
        grid.setWidget(1, 1, plc_nr_id);

        grid.setWidget(2, 0, new Label("plc_tx_nome:"));
        grid.setWidget(2, 1, plc_tx_nome);

        grid.setWidget(3, 0, new Label("insumo:"));
        grid.setWidget(3, 1, insumo);

        grid.setWidget(4, 0, new Label("ipo_nr_vl_unitario:"));
        grid.setWidget(4, 1, ipo_nr_vl_unitario);

        grid.setWidget(5, 0, new Label("pms_nr_mes:"));
        grid.setWidget(5, 1, pms_nr_mes);

        grid.setWidget(6, 0, new Label("pms_nr_ano:"));
        grid.setWidget(6, 1, pms_nr_ano);

        grid.setWidget(7, 0, new Label("plco_nr_id:"));
        grid.setWidget(7, 1, plco_nr_id);

        grid.setWidget(8, 0, new Label("perc:"));
        grid.setWidget(8, 1, perc);

        grid.setWidget(9, 0, new Label("vl_total:"));
        grid.setWidget(9, 1, vl_total);

        grid.setWidget(10, 0, new Label("vl_executado:"));
        grid.setWidget(10, 1, vl_executado);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Vw_equiv_insumo_pmsTGWT vw_equiv_insumo_pmsTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("vw_equiv_insumo_pmsT.obr_nr_id", vw_equiv_insumo_pmsTGWT.getObr_nr_id() + "");

            param.put("vw_equiv_insumo_pmsT.plc_nr_id", vw_equiv_insumo_pmsTGWT.getPlc_nr_id() + "");

            param.put("vw_equiv_insumo_pmsT.plc_tx_nome", vw_equiv_insumo_pmsTGWT.getPlc_tx_nome() + "");

            param.put("vw_equiv_insumo_pmsT.insumo", vw_equiv_insumo_pmsTGWT.getInsumo() + "");

            param.put("vw_equiv_insumo_pmsT.ipo_nr_vl_unitario", vw_equiv_insumo_pmsTGWT.getIpo_nr_vl_unitario() + "");

            param.put("vw_equiv_insumo_pmsT.pms_nr_mes", vw_equiv_insumo_pmsTGWT.getPms_nr_mes() + "");

            param.put("vw_equiv_insumo_pmsT.pms_nr_ano", vw_equiv_insumo_pmsTGWT.getPms_nr_ano() + "");

            param.put("vw_equiv_insumo_pmsT.plco_nr_id", vw_equiv_insumo_pmsTGWT.getPlco_nr_id() + "");

            param.put("vw_equiv_insumo_pmsT.perc", vw_equiv_insumo_pmsTGWT.getPerc() + "");

            param.put("vw_equiv_insumo_pmsT.vl_total", vw_equiv_insumo_pmsTGWT.getVl_total() + "");

            param.put("vw_equiv_insumo_pmsT.vl_executado", vw_equiv_insumo_pmsTGWT.getVl_executado() + "");


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
            param.put("vw_equiv_insumo_pmsT.obr_nr_id", obr_nr_id.getText());

            param.put("vw_equiv_insumo_pmsT.plc_nr_id", plc_nr_id.getText());

            param.put("vw_equiv_insumo_pmsT.plc_tx_nome", plc_tx_nome.getText());

            param.put("vw_equiv_insumo_pmsT.insumo", insumo.getText());

            param.put("vw_equiv_insumo_pmsT.ipo_nr_vl_unitario", ipo_nr_vl_unitario.getText());

            param.put("vw_equiv_insumo_pmsT.pms_nr_mes", pms_nr_mes.getText());

            param.put("vw_equiv_insumo_pmsT.pms_nr_ano", pms_nr_ano.getText());

            param.put("vw_equiv_insumo_pmsT.plco_nr_id", plco_nr_id.getText());

            param.put("vw_equiv_insumo_pmsT.perc", perc.getText());

            param.put("vw_equiv_insumo_pmsT.vl_total", vl_total.getText());

            param.put("vw_equiv_insumo_pmsT.vl_executado", vl_executado.getText());


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
            param.put("vw_equiv_insumo_pmsT.obr_nr_id", obr_nr_id.getText());

            param.put("vw_equiv_insumo_pmsT.plc_nr_id", plc_nr_id.getText());

            param.put("vw_equiv_insumo_pmsT.plc_tx_nome", plc_tx_nome.getText());

            param.put("vw_equiv_insumo_pmsT.insumo", insumo.getText());

            param.put("vw_equiv_insumo_pmsT.ipo_nr_vl_unitario", ipo_nr_vl_unitario.getText());

            param.put("vw_equiv_insumo_pmsT.pms_nr_mes", pms_nr_mes.getText());

            param.put("vw_equiv_insumo_pmsT.pms_nr_ano", pms_nr_ano.getText());

            param.put("vw_equiv_insumo_pmsT.plco_nr_id", plco_nr_id.getText());

            param.put("vw_equiv_insumo_pmsT.perc", perc.getText());

            param.put("vw_equiv_insumo_pmsT.vl_total", vl_total.getText());

            param.put("vw_equiv_insumo_pmsT.vl_executado", vl_executado.getText());


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
              JSONObject registro = resultado.get("vw_equiv_insumo_pms").isObject();
            
              int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            vw_equiv_insumo_pmsTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setText(vw_equiv_insumo_pmsTGWT.getObr_nr_id() + "");

            int plc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
            vw_equiv_insumo_pmsTGWT.setPlc_nr_id(plc_nr_id);
	    this.plc_nr_id.setText(vw_equiv_insumo_pmsTGWT.getPlc_nr_id() + "");

            String plc_tx_nome =   (EasyContainer.clearAspas(registro.get("plc_tx_nome").toString()));
            vw_equiv_insumo_pmsTGWT.setPlc_tx_nome(plc_tx_nome);
	    this.plc_tx_nome.setText(vw_equiv_insumo_pmsTGWT.getPlc_tx_nome() + "");

            String insumo =   (EasyContainer.clearAspas(registro.get("insumo").toString()));
            vw_equiv_insumo_pmsTGWT.setInsumo(insumo);
	    this.insumo.setText(vw_equiv_insumo_pmsTGWT.getInsumo() + "");

            float ipo_nr_vl_unitario =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_unitario").toString()));
            vw_equiv_insumo_pmsTGWT.setIpo_nr_vl_unitario(ipo_nr_vl_unitario);
	    this.ipo_nr_vl_unitario.setText(vw_equiv_insumo_pmsTGWT.getIpo_nr_vl_unitario() + "");

            int pms_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("pms_nr_mes").toString()));
            vw_equiv_insumo_pmsTGWT.setPms_nr_mes(pms_nr_mes);
	    this.pms_nr_mes.setText(vw_equiv_insumo_pmsTGWT.getPms_nr_mes() + "");

            int pms_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("pms_nr_ano").toString()));
            vw_equiv_insumo_pmsTGWT.setPms_nr_ano(pms_nr_ano);
	    this.pms_nr_ano.setText(vw_equiv_insumo_pmsTGWT.getPms_nr_ano() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            vw_equiv_insumo_pmsTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setText(vw_equiv_insumo_pmsTGWT.getPlco_nr_id() + "");

            float perc =  Float.parseFloat(EasyContainer.clearAspas(registro.get("perc").toString()));
            vw_equiv_insumo_pmsTGWT.setPerc(perc);
	    this.perc.setText(vw_equiv_insumo_pmsTGWT.getPerc() + "");

            float vl_total =  Float.parseFloat(EasyContainer.clearAspas(registro.get("vl_total").toString()));
            vw_equiv_insumo_pmsTGWT.setVl_total(vl_total);
	    this.vl_total.setText(vw_equiv_insumo_pmsTGWT.getVl_total() + "");

            float vl_executado =  Float.parseFloat(EasyContainer.clearAspas(registro.get("vl_executado").toString()));
            vw_equiv_insumo_pmsTGWT.setVl_executado(vl_executado);
	    this.vl_executado.setText(vw_equiv_insumo_pmsTGWT.getVl_executado() + "");



	    } catch (Exception e) {}		
        }

    }
}

