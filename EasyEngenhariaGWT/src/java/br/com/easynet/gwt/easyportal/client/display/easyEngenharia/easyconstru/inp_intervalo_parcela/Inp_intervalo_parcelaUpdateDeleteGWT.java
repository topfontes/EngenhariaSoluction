/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inp_intervalo_parcela;

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


import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Inp_intervalo_parcelaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaUpdateDeleteGWT.jsp";    

    private TextField<String> inp_nr_id = new TextField<String>();

    private TextField<String> par_nr_id = new TextField<String>();

    private TextField<String> inp_nr_dias = new TextField<String>();

    private TextField<String> inp_nr_per = new TextField<String>();


    private Inp_intervalo_parcelaTGWT inp_intervalo_parcelaTGWT = new Inp_intervalo_parcelaTGWT();
private Inp_intervalo_parcelaConsultGWT consultGWT = new Inp_intervalo_parcelaConsultGWT();


    public Inp_intervalo_parcelaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Inp_intervalo_parcelaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Inp_intervalo_parcelaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("inp_nr_id:"));
        grid.setWidget(0, 1, inp_nr_id);

        grid.setWidget(1, 0, new Label("par_nr_id:"));
        grid.setWidget(1, 1, par_nr_id);

        grid.setWidget(2, 0, new Label("inp_nr_dias:"));
        grid.setWidget(2, 1, inp_nr_dias);

        grid.setWidget(3, 0, new Label("inp_nr_per:"));
        grid.setWidget(3, 1, inp_nr_per);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Inp_intervalo_parcelaTGWT inp_intervalo_parcelaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("inp_intervalo_parcelaT.inp_nr_id", inp_intervalo_parcelaTGWT.getInp_nr_id() + "");

            param.put("inp_intervalo_parcelaT.par_nr_id", inp_intervalo_parcelaTGWT.getPar_nr_id() + "");

            param.put("inp_intervalo_parcelaT.inp_nr_dias", inp_intervalo_parcelaTGWT.getInp_nr_dias() + "");

            param.put("inp_intervalo_parcelaT.inp_nr_per", inp_intervalo_parcelaTGWT.getInp_nr_per() + "");


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
            param.put("inp_intervalo_parcelaT.inp_nr_id", inp_nr_id.getValue());

            param.put("inp_intervalo_parcelaT.par_nr_id", par_nr_id.getValue());

            param.put("inp_intervalo_parcelaT.inp_nr_dias", inp_nr_dias.getValue());

            param.put("inp_intervalo_parcelaT.inp_nr_per", inp_nr_per.getValue());


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
            param.put("inp_intervalo_parcelaT.inp_nr_id", inp_nr_id.getValue());

            param.put("inp_intervalo_parcelaT.par_nr_id", par_nr_id.getValue());

            param.put("inp_intervalo_parcelaT.inp_nr_dias", inp_nr_dias.getValue());

            param.put("inp_intervalo_parcelaT.inp_nr_per", inp_nr_per.getValue());


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
              JSONObject registro = resultado.get("inp_intervalo_parcela").isObject();
            
              int inp_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("inp_nr_id").toString()));
            inp_intervalo_parcelaTGWT.setInp_nr_id(inp_nr_id);
	    this.inp_nr_id.setValue(inp_intervalo_parcelaTGWT.getInp_nr_id() + "");

            int par_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("par_nr_id").toString()));
            inp_intervalo_parcelaTGWT.setPar_nr_id(par_nr_id);
	    this.par_nr_id.setValue(inp_intervalo_parcelaTGWT.getPar_nr_id() + "");

            int inp_nr_dias =  Integer.parseInt(EasyContainer.clearAspas(registro.get("inp_nr_dias").toString()));
            inp_intervalo_parcelaTGWT.setInp_nr_dias(inp_nr_dias);
	    this.inp_nr_dias.setValue(inp_intervalo_parcelaTGWT.getInp_nr_dias() + "");

            float inp_nr_per =  Float.parseFloat(EasyContainer.clearAspas(registro.get("inp_nr_per").toString()));
            inp_intervalo_parcelaTGWT.setInp_nr_per(inp_nr_per);
	    this.inp_nr_per.setValue(inp_intervalo_parcelaTGWT.getInp_nr_per() + "");



	    } catch (Exception e) {}		
        }

    }
}

