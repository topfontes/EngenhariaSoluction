/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pms_planilha_medicao_servico;

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
public class Pms_planilha_medicao_servicoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoUpdateDeleteGWT.jsp";    

    private TextField<String> pms_nr_id = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> pms_nr_mes = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> pms_nr_quantidade_servico = new TextField<String>();


    private Pms_planilha_medicao_servicoTGWT pms_planilha_medicao_servicoTGWT = new Pms_planilha_medicao_servicoTGWT();
private Pms_planilha_medicao_servicoConsultGWT consultGWT = new Pms_planilha_medicao_servicoConsultGWT();


    public Pms_planilha_medicao_servicoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Pms_planilha_medicao_servicoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Pms_planilha_medicao_servicoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(6, 2);
        grid.setWidget(0, 0, new Label("pms_nr_id:"));
        grid.setWidget(0, 1, pms_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("pms_nr_mes:"));
        grid.setWidget(2, 1, pms_nr_mes);

        grid.setWidget(3, 0, new Label("plco_nr_id:"));
        grid.setWidget(3, 1, plco_nr_id);

        grid.setWidget(4, 0, new Label("pms_nr_quantidade_servico:"));
        grid.setWidget(4, 1, pms_nr_quantidade_servico);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Pms_planilha_medicao_servicoTGWT pms_planilha_medicao_servicoTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("pms_planilha_medicao_servicoT.pms_nr_id", pms_planilha_medicao_servicoTGWT.getPms_nr_id() + "");

            param.put("pms_planilha_medicao_servicoT.obr_nr_id", pms_planilha_medicao_servicoTGWT.getObr_nr_id() + "");

            param.put("pms_planilha_medicao_servicoT.pms_nr_mes", pms_planilha_medicao_servicoTGWT.getPms_nr_mes() + "");

            param.put("pms_planilha_medicao_servicoT.plco_nr_id", pms_planilha_medicao_servicoTGWT.getPlco_nr_id() + "");

            param.put("pms_planilha_medicao_servicoT.pms_nr_quantidade_servico", pms_planilha_medicao_servicoTGWT.getPms_nr_quantidade_servico() + "");


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
            param.put("pms_planilha_medicao_servicoT.pms_nr_id", pms_nr_id.getValue());

            param.put("pms_planilha_medicao_servicoT.obr_nr_id", obr_nr_id.getValue());

            param.put("pms_planilha_medicao_servicoT.pms_nr_mes", pms_nr_mes.getValue());

            param.put("pms_planilha_medicao_servicoT.plco_nr_id", plco_nr_id.getValue());

            param.put("pms_planilha_medicao_servicoT.pms_nr_quantidade_servico", pms_nr_quantidade_servico.getValue());


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
            param.put("pms_planilha_medicao_servicoT.pms_nr_id", pms_nr_id.getValue());

            param.put("pms_planilha_medicao_servicoT.obr_nr_id", obr_nr_id.getValue());

            param.put("pms_planilha_medicao_servicoT.pms_nr_mes", pms_nr_mes.getValue());

            param.put("pms_planilha_medicao_servicoT.plco_nr_id", plco_nr_id.getValue());

            param.put("pms_planilha_medicao_servicoT.pms_nr_quantidade_servico", pms_nr_quantidade_servico.getValue());


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
              JSONObject registro = resultado.get("pms_planilha_medicao_servico").isObject();
            
              int pms_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("pms_nr_id").toString()));
            pms_planilha_medicao_servicoTGWT.setPms_nr_id(pms_nr_id);
	    this.pms_nr_id.setValue(pms_planilha_medicao_servicoTGWT.getPms_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            pms_planilha_medicao_servicoTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setValue(pms_planilha_medicao_servicoTGWT.getObr_nr_id() + "");

            int pms_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("pms_nr_mes").toString()));
            pms_planilha_medicao_servicoTGWT.setPms_nr_mes(pms_nr_mes);
	    this.pms_nr_mes.setValue(pms_planilha_medicao_servicoTGWT.getPms_nr_mes() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            pms_planilha_medicao_servicoTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(pms_planilha_medicao_servicoTGWT.getPlco_nr_id() + "");

            float pms_nr_quantidade_servico =  Float.parseFloat(EasyContainer.clearAspas(registro.get("pms_nr_quantidade_servico").toString()));
            pms_planilha_medicao_servicoTGWT.setPms_nr_quantidade_servico(pms_nr_quantidade_servico);
	    this.pms_nr_quantidade_servico.setValue(pms_planilha_medicao_servicoTGWT.getPms_nr_quantidade_servico() + "");



	    } catch (Exception e) {}		
        }

    }
}

