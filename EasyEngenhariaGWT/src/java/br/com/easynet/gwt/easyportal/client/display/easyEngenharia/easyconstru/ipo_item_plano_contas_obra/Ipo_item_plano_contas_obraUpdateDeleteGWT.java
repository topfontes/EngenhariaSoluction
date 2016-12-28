/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ipo_item_plano_contas_obra;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Ipo_item_plano_contas_obraUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraUpdateDeleteGWT.jsp";

    private TextField<String> ipo_nr_id = new TextField<String>();

    private TextField<String> ipo_nr_quantidade = new TextField<String>();

    private TextField<String> ipo_nr_vl_unitario = new TextField<String>();

    private TextField<String> ipo_nr_vl_total = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();


    private Ipo_item_plano_contas_obraTGWT ipo_item_plano_contas_obraTGWT = new Ipo_item_plano_contas_obraTGWT();
private Ipo_item_plano_contas_obraConsultGWT consultGWT = new Ipo_item_plano_contas_obraConsultGWT();


    public Ipo_item_plano_contas_obraConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ipo_item_plano_contas_obraConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Ipo_item_plano_contas_obraUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(7, 2);
        grid.setWidget(0, 0, new Label("ipo_nr_id:"));
        grid.setWidget(0, 1, ipo_nr_id);

        grid.setWidget(1, 0, new Label("ipo_nr_quantidade:"));
        grid.setWidget(1, 1, ipo_nr_quantidade);

        grid.setWidget(2, 0, new Label("ipo_nr_vl_unitario:"));
        grid.setWidget(2, 1, ipo_nr_vl_unitario);

        grid.setWidget(3, 0, new Label("ipo_nr_vl_total:"));
        grid.setWidget(3, 1, ipo_nr_vl_total);

        grid.setWidget(4, 0, new Label("obr_nr_id:"));
        grid.setWidget(4, 1, obr_nr_id);

        grid.setWidget(5, 0, new Label("plco_nr_id:"));
        grid.setWidget(5, 1, plco_nr_id);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Ipo_item_plano_contas_obraTGWT ipo_item_plano_contas_obraTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("ipo_item_plano_contas_obraT.ipo_nr_id", ipo_item_plano_contas_obraTGWT.getIpo_nr_id() + "");

            param.put("ipo_item_plano_contas_obraT.ipo_nr_quantidade", ipo_item_plano_contas_obraTGWT.getIpo_nr_quantidade() + "");

            param.put("ipo_item_plano_contas_obraT.ipo_nr_vl_unitario", ipo_item_plano_contas_obraTGWT.getIpo_nr_vl_unitario() + "");

            param.put("ipo_item_plano_contas_obraT.ipo_nr_vl_total", ipo_item_plano_contas_obraTGWT.getIpo_nr_vl_total() + "");

            param.put("ipo_item_plano_contas_obraT.obr_nr_id", ipo_item_plano_contas_obraTGWT.getObr_nr_id() + "");

            param.put("ipo_item_plano_contas_obraT.plco_nr_id", ipo_item_plano_contas_obraTGWT.getPlco_nr_id() + "");


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        btnAltAction(ce);
    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("ipo_item_plano_contas_obraT.ipo_nr_id", ipo_nr_id.getValue());

            param.put("ipo_item_plano_contas_obraT.ipo_nr_quantidade", ipo_nr_quantidade.getValue());

            param.put("ipo_item_plano_contas_obraT.ipo_nr_vl_unitario", ipo_nr_vl_unitario.getValue());

            param.put("ipo_item_plano_contas_obraT.ipo_nr_vl_total", ipo_nr_vl_total.getValue());

            param.put("ipo_item_plano_contas_obraT.obr_nr_id", obr_nr_id.getValue());

            param.put("ipo_item_plano_contas_obraT.plco_nr_id", plco_nr_id.getValue());


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
            param.put("ipo_item_plano_contas_obraT.ipo_nr_id", ipo_nr_id.getValue());

            param.put("ipo_item_plano_contas_obraT.ipo_nr_quantidade", ipo_nr_quantidade.getValue());

            param.put("ipo_item_plano_contas_obraT.ipo_nr_vl_unitario", ipo_nr_vl_unitario.getValue());

            param.put("ipo_item_plano_contas_obraT.ipo_nr_vl_total", ipo_nr_vl_total.getValue());

            param.put("ipo_item_plano_contas_obraT.obr_nr_id", obr_nr_id.getValue());

            param.put("ipo_item_plano_contas_obraT.plco_nr_id", plco_nr_id.getValue());


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
              JSONObject registro = resultado.get("ipo_item_plano_contas_obra").isObject();
            
              int ipo_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id").toString()));
            ipo_item_plano_contas_obraTGWT.setIpo_nr_id(ipo_nr_id);
	    this.ipo_nr_id.setValue(ipo_item_plano_contas_obraTGWT.getIpo_nr_id() + "");

            float ipo_nr_quantidade =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_quantidade").toString()));
            ipo_item_plano_contas_obraTGWT.setIpo_nr_quantidade(ipo_nr_quantidade);
	    this.ipo_nr_quantidade.setValue(ipo_item_plano_contas_obraTGWT.getIpo_nr_quantidade() + "");

            float ipo_nr_vl_unitario =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_unitario").toString()));
            ipo_item_plano_contas_obraTGWT.setIpo_nr_vl_unitario(ipo_nr_vl_unitario);
	    this.ipo_nr_vl_unitario.setValue(ipo_item_plano_contas_obraTGWT.getIpo_nr_vl_unitario() + "");

            float ipo_nr_vl_total =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_total").toString()));
            ipo_item_plano_contas_obraTGWT.setIpo_nr_vl_total(ipo_nr_vl_total);
	    this.ipo_nr_vl_total.setValue(ipo_item_plano_contas_obraTGWT.getIpo_nr_vl_total() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            ipo_item_plano_contas_obraTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setValue(ipo_item_plano_contas_obraTGWT.getObr_nr_id() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            ipo_item_plano_contas_obraTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(ipo_item_plano_contas_obraTGWT.getPlco_nr_id() + "");



	    } catch (Exception e) {}		
        }

    }
}

