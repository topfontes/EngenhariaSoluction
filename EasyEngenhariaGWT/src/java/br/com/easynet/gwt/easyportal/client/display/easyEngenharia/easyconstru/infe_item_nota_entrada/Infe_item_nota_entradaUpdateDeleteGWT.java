/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.infe_item_nota_entrada;

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
 import com.extjs.gxt.ui.client.widget.form.LabelField; 

import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;

/**
 *
 * @author geoleite
 */
public class Infe_item_nota_entradaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaUpdateDeleteGWT.jsp";    

    private TextField<String> infe_nr_id = new TextField<String>();

    private TextField<String> infe_nr_quantidade = new TextField<String>();

    private TextField<String> infe_nr_valor_unit = new TextField<String>();

    private TextField<String> infe_nr_valor_total = new TextField<String>();

    private TextField<String> nfe_nr_id = new TextField<String>();

    private TextField<String> pro_nr_id = new TextField<String>();


    private Infe_item_nota_entradaTGWT infe_item_nota_entradaTGWT = new Infe_item_nota_entradaTGWT();
private Infe_item_nota_entradaConsultGWT consultGWT = new Infe_item_nota_entradaConsultGWT();


    public Infe_item_nota_entradaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Infe_item_nota_entradaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Infe_item_nota_entradaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(7, 2);
        grid.setWidget(0, 0, new LabelField("infe_nr_id:"));
        grid.setWidget(0, 1, infe_nr_id);

        grid.setWidget(1, 0, new LabelField("infe_nr_quantidade:"));
        grid.setWidget(1, 1, infe_nr_quantidade);

        grid.setWidget(2, 0, new LabelField("infe_nr_valor_unit:"));
        grid.setWidget(2, 1, infe_nr_valor_unit);

        grid.setWidget(3, 0, new LabelField("infe_nr_valor_total:"));
        grid.setWidget(3, 1, infe_nr_valor_total);

        grid.setWidget(4, 0, new LabelField("nfe_nr_id:"));
        grid.setWidget(4, 1, nfe_nr_id);

        grid.setWidget(5, 0, new LabelField("pro_nr_id:"));
        grid.setWidget(5, 1, pro_nr_id);




        getCpMaster().add(grid);
    }

    public void load(Infe_item_nota_entradaTGWT infe_item_nota_entradaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("infe_item_nota_entradaT.infe_nr_id", infe_item_nota_entradaTGWT.getInfe_nr_id() + "");

            param.put("infe_item_nota_entradaT.infe_nr_quantidade", infe_item_nota_entradaTGWT.getInfe_nr_quantidade() + "");

            param.put("infe_item_nota_entradaT.infe_nr_valor_unit", infe_item_nota_entradaTGWT.getInfe_nr_valor_unit() + "");

            param.put("infe_item_nota_entradaT.infe_nr_valor_total", infe_item_nota_entradaTGWT.getInfe_nr_valor_total() + "");

            param.put("infe_item_nota_entradaT.nfe_nr_id", infe_item_nota_entradaTGWT.getNfe_nr_id() + "");

            param.put("infe_item_nota_entradaT.pro_nr_id", infe_item_nota_entradaTGWT.getPro_nr_id() + "");


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
            param.put("infe_item_nota_entradaT.infe_nr_id", infe_nr_id.getValue());

            param.put("infe_item_nota_entradaT.infe_nr_quantidade", infe_nr_quantidade.getValue());

            param.put("infe_item_nota_entradaT.infe_nr_valor_unit", infe_nr_valor_unit.getValue());

            param.put("infe_item_nota_entradaT.infe_nr_valor_total", infe_nr_valor_total.getValue());

            param.put("infe_item_nota_entradaT.nfe_nr_id", nfe_nr_id.getValue());

            param.put("infe_item_nota_entradaT.pro_nr_id", pro_nr_id.getValue());


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
            param.put("infe_item_nota_entradaT.infe_nr_id", infe_nr_id.getValue());

            param.put("infe_item_nota_entradaT.infe_nr_quantidade", infe_nr_quantidade.getValue());

            param.put("infe_item_nota_entradaT.infe_nr_valor_unit", infe_nr_valor_unit.getValue());

            param.put("infe_item_nota_entradaT.infe_nr_valor_total", infe_nr_valor_total.getValue());

            param.put("infe_item_nota_entradaT.nfe_nr_id", nfe_nr_id.getValue());

            param.put("infe_item_nota_entradaT.pro_nr_id", pro_nr_id.getValue());


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
              JSONObject registro = resultado.get("infe_item_nota_entrada").isObject();
            
              int infe_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("infe_nr_id").toString()));
            infe_item_nota_entradaTGWT.setInfe_nr_id(infe_nr_id);
	    this.infe_nr_id.setValue(infe_item_nota_entradaTGWT.getInfe_nr_id() + "");

            float infe_nr_quantidade =  Float.parseFloat(EasyContainer.clearAspas(registro.get("infe_nr_quantidade").toString()));
            infe_item_nota_entradaTGWT.setInfe_nr_quantidade(infe_nr_quantidade);
	    this.infe_nr_quantidade.setValue(infe_item_nota_entradaTGWT.getInfe_nr_quantidade() + "");

            float infe_nr_valor_unit =  Float.parseFloat(EasyContainer.clearAspas(registro.get("infe_nr_valor_unit").toString()));
            infe_item_nota_entradaTGWT.setInfe_nr_valor_unit(infe_nr_valor_unit);
	    this.infe_nr_valor_unit.setValue(infe_item_nota_entradaTGWT.getInfe_nr_valor_unit() + "");

            float infe_nr_valor_total =  Float.parseFloat(EasyContainer.clearAspas(registro.get("infe_nr_valor_total").toString()));
            infe_item_nota_entradaTGWT.setInfe_nr_valor_total(infe_nr_valor_total);
	    this.infe_nr_valor_total.setValue(infe_item_nota_entradaTGWT.getInfe_nr_valor_total() + "");

            int nfe_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("nfe_nr_id").toString()));
            infe_item_nota_entradaTGWT.setNfe_nr_id(nfe_nr_id);
	    this.nfe_nr_id.setValue(infe_item_nota_entradaTGWT.getNfe_nr_id() + "");

            int pro_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_id").toString()));
            infe_item_nota_entradaTGWT.setPro_nr_id(pro_nr_id);
	    this.pro_nr_id.setValue(infe_item_nota_entradaTGWT.getPro_nr_id() + "");



	    } catch (Exception e) {}		
        }

    }
}

