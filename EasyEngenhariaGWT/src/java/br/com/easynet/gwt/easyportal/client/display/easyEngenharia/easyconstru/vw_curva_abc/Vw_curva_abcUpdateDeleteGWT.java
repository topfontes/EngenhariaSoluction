/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_curva_abc;

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
public class Vw_curva_abcUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcUpdateDeleteGWT.jsp";    

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> obr_tx_nome = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> plco_tx_nome = new TextField<String>();

    private TextField<String> total = new TextField<String>();


    private Vw_curva_abcTGWT vw_curva_abcTGWT = new Vw_curva_abcTGWT();
private Vw_curva_abcConsultGWT consultGWT = new Vw_curva_abcConsultGWT(0);


    public Vw_curva_abcConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_curva_abcConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Vw_curva_abcUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(6, 2);
        grid.setWidget(0, 0, new Label("obr_nr_id:"));
        grid.setWidget(0, 1, obr_nr_id);

        grid.setWidget(1, 0, new Label("obr_tx_nome:"));
        grid.setWidget(1, 1, obr_tx_nome);

        grid.setWidget(2, 0, new Label("plco_nr_id:"));
        grid.setWidget(2, 1, plco_nr_id);

        grid.setWidget(3, 0, new Label("plco_tx_nome:"));
        grid.setWidget(3, 1, plco_tx_nome);

        grid.setWidget(4, 0, new Label("total:"));
        grid.setWidget(4, 1, total);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Vw_curva_abcTGWT vw_curva_abcTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("vw_curva_abcT.obr_nr_id", vw_curva_abcTGWT.getObr_nr_id() + "");

            param.put("vw_curva_abcT.obr_tx_nome", vw_curva_abcTGWT.getObr_tx_nome() + "");

            param.put("vw_curva_abcT.plco_nr_id", vw_curva_abcTGWT.getPlco_nr_id() + "");

            param.put("vw_curva_abcT.plco_tx_nome", vw_curva_abcTGWT.getPlco_tx_nome() + "");

            param.put("vw_curva_abcT.total", vw_curva_abcTGWT.getTotal() + "");


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
            param.put("vw_curva_abcT.obr_nr_id", obr_nr_id.getValue());

            param.put("vw_curva_abcT.obr_tx_nome", obr_tx_nome.getValue());

            param.put("vw_curva_abcT.plco_nr_id", plco_nr_id.getValue());

            param.put("vw_curva_abcT.plco_tx_nome", plco_tx_nome.getValue());

            param.put("vw_curva_abcT.total", total.getValue());


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
            param.put("vw_curva_abcT.obr_nr_id", obr_nr_id.getValue());

            param.put("vw_curva_abcT.obr_tx_nome", obr_tx_nome.getValue());

            param.put("vw_curva_abcT.plco_nr_id", plco_nr_id.getValue());

            param.put("vw_curva_abcT.plco_tx_nome", plco_tx_nome.getValue());

            param.put("vw_curva_abcT.total", total.getValue());


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
              JSONObject registro = resultado.get("vw_curva_abc").isObject();
            
              int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            vw_curva_abcTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setValue(vw_curva_abcTGWT.getObr_nr_id() + "");

            String obr_tx_nome =   (EasyContainer.clearAspas(registro.get("obr_tx_nome").toString()));
            vw_curva_abcTGWT.setObr_tx_nome(obr_tx_nome);
	    this.obr_tx_nome.setValue(vw_curva_abcTGWT.getObr_tx_nome() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            vw_curva_abcTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(vw_curva_abcTGWT.getPlco_nr_id() + "");

            String plco_tx_nome =   (EasyContainer.clearAspas(registro.get("plco_tx_nome").toString()));
            vw_curva_abcTGWT.setPlco_tx_nome(plco_tx_nome);
	    this.plco_tx_nome.setValue(vw_curva_abcTGWT.getPlco_tx_nome() + "");

            float total =  Float.parseFloat(EasyContainer.clearAspas(registro.get("total").toString()));
            vw_curva_abcTGWT.setTotal(total);
	    this.total.setValue(vw_curva_abcTGWT.getTotal() + "");



	    } catch (Exception e) {}		
        }

    }
}

