/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.nfe_nota_fiscal_entrada;

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

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Nfe_nota_fiscal_entradaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaUpdateDeleteGWT.jsp";    

    private TextField<String> nfe_nr_id = new TextField<String>();

    private TextField<String> nfe_dt_emissao = new TextField<String>();

    private TextField<String> for_nr_id = new TextField<String>();

    private TextField<String> nfe_nr_valor_nota = new TextField<String>();


    private Nfe_nota_fiscal_entradaTGWT nfe_nota_fiscal_entradaTGWT = new Nfe_nota_fiscal_entradaTGWT();
private Nfe_nota_fiscal_entradaConsultGWT consultGWT = new Nfe_nota_fiscal_entradaConsultGWT();


    public Nfe_nota_fiscal_entradaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Nfe_nota_fiscal_entradaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Nfe_nota_fiscal_entradaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new LabelField("nfe_nr_id:"));
        grid.setWidget(0, 1, nfe_nr_id);

        grid.setWidget(1, 0, new LabelField("nfe_dt_emissao:"));
        grid.setWidget(1, 1, nfe_dt_emissao);

        grid.setWidget(2, 0, new LabelField("for_nr_id:"));
        grid.setWidget(2, 1, for_nr_id);

        grid.setWidget(3, 0, new LabelField("nfe_nr_valor_nota:"));
        grid.setWidget(3, 1, nfe_nr_valor_nota);




        getCpMaster().add(grid);
    }

    public void load(Nfe_nota_fiscal_entradaTGWT nfe_nota_fiscal_entradaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("nfe_nota_fiscal_entradaT.nfe_nr_id", nfe_nota_fiscal_entradaTGWT.getNfe_nr_id() + "");

            param.put("nfe_nota_fiscal_entradaT.nfe_dt_emissao", nfe_nota_fiscal_entradaTGWT.getNfe_dt_emissao() + "");

            param.put("nfe_nota_fiscal_entradaT.for_nr_id", nfe_nota_fiscal_entradaTGWT.getFor_nr_id() + "");

            param.put("nfe_nota_fiscal_entradaT.nfe_nr_valor_nota", nfe_nota_fiscal_entradaTGWT.getNfe_nr_valor_nota() + "");


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
            param.put("nfe_nota_fiscal_entradaT.nfe_nr_id", nfe_nr_id.getValue());

            param.put("nfe_nota_fiscal_entradaT.nfe_dt_emissao", nfe_dt_emissao.getValue());

            param.put("nfe_nota_fiscal_entradaT.for_nr_id", for_nr_id.getValue());

            param.put("nfe_nota_fiscal_entradaT.nfe_nr_valor_nota", nfe_nr_valor_nota.getValue());


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
            param.put("nfe_nota_fiscal_entradaT.nfe_nr_id", nfe_nr_id.getValue());

            param.put("nfe_nota_fiscal_entradaT.nfe_dt_emissao", nfe_dt_emissao.getValue());

            param.put("nfe_nota_fiscal_entradaT.for_nr_id", for_nr_id.getValue());

            param.put("nfe_nota_fiscal_entradaT.nfe_nr_valor_nota", nfe_nr_valor_nota.getValue());


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
              JSONObject registro = resultado.get("nfe_nota_fiscal_entrada").isObject();
            
              int nfe_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("nfe_nr_id").toString()));
            nfe_nota_fiscal_entradaTGWT.setNfe_nr_id(nfe_nr_id);
	    this.nfe_nr_id.setValue(nfe_nota_fiscal_entradaTGWT.getNfe_nr_id() + "");

            DateTimeFormat dtf1 = DateTimeFormat.getFormat("dd/MM/yyyy");
java.util.Date  nfe_dt_emissao = dtf1.parse(EasyContainer.clearAspas(registro.get("nfe_dt_emissao").toString()));
            nfe_nota_fiscal_entradaTGWT.setNfe_dt_emissao(nfe_dt_emissao);
	    this.nfe_dt_emissao.setValue(nfe_nota_fiscal_entradaTGWT.getNfe_dt_emissao() + "");

            int for_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("for_nr_id").toString()));
            nfe_nota_fiscal_entradaTGWT.setFor_nr_id(for_nr_id);
	    this.for_nr_id.setValue(nfe_nota_fiscal_entradaTGWT.getFor_nr_id() + "");

            float nfe_nr_valor_nota =  Float.parseFloat(EasyContainer.clearAspas(registro.get("nfe_nr_valor_nota").toString()));
            nfe_nota_fiscal_entradaTGWT.setNfe_nr_valor_nota(nfe_nr_valor_nota);
	    this.nfe_nr_valor_nota.setValue(nfe_nota_fiscal_entradaTGWT.getNfe_nr_valor_nota() + "");



	    } catch (Exception e) {}		
        }

    }
}

