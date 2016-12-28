/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ccff_copia_cronograma_fisico_financeiro;

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
public class Ccff_copia_cronograma_fisico_financeiroUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDeleteGWT.jsp";    

    private TextField<String> ccff_nr_id = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> ccff_nr_peso = new TextField<String>();

    private TextField<String> ccff_nr_mes = new TextField<String>();

    private TextField<String> ccff_nr_ano = new TextField<String>();

    private TextField<String> ccff_nr_quantidade = new TextField<String>();

    private TextField<String> ccff_nr_valor = new TextField<String>();


    private Ccff_copia_cronograma_fisico_financeiroTGWT ccff_copia_cronograma_fisico_financeiroTGWT = new Ccff_copia_cronograma_fisico_financeiroTGWT();
private Ccff_copia_cronograma_fisico_financeiroConsultGWT consultGWT = new Ccff_copia_cronograma_fisico_financeiroConsultGWT();


    public Ccff_copia_cronograma_fisico_financeiroConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ccff_copia_cronograma_fisico_financeiroConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Ccff_copia_cronograma_fisico_financeiroUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(9, 2);
        grid.setWidget(0, 0, new Label("ccff_nr_id:"));
        grid.setWidget(0, 1, ccff_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("plco_nr_id:"));
        grid.setWidget(2, 1, plco_nr_id);

        grid.setWidget(3, 0, new Label("ccff_nr_peso:"));
        grid.setWidget(3, 1, ccff_nr_peso);

        grid.setWidget(4, 0, new Label("ccff_nr_mes:"));
        grid.setWidget(4, 1, ccff_nr_mes);

        grid.setWidget(5, 0, new Label("ccff_nr_ano:"));
        grid.setWidget(5, 1, ccff_nr_ano);

        grid.setWidget(6, 0, new Label("ccff_nr_quantidade:"));
        grid.setWidget(6, 1, ccff_nr_quantidade);

        grid.setWidget(7, 0, new Label("ccff_nr_valor:"));
        grid.setWidget(7, 1, ccff_nr_valor);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Ccff_copia_cronograma_fisico_financeiroTGWT ccff_copia_cronograma_fisico_financeiroTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id", ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_id() + "");

            param.put("ccff_copia_cronograma_fisico_financeiroT.obr_nr_id", ccff_copia_cronograma_fisico_financeiroTGWT.getObr_nr_id() + "");

            param.put("ccff_copia_cronograma_fisico_financeiroT.plco_nr_id", ccff_copia_cronograma_fisico_financeiroTGWT.getPlco_nr_id() + "");

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_peso", ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_peso() + "");

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_mes", ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_mes() + "");

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_ano", ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_ano() + "");

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_quantidade", ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_quantidade() + "");

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_valor", ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_valor() + "");


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
            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id", ccff_nr_id.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.obr_nr_id", obr_nr_id.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.plco_nr_id", plco_nr_id.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_peso", ccff_nr_peso.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_mes", ccff_nr_mes.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_ano", ccff_nr_ano.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_quantidade", ccff_nr_quantidade.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_valor", ccff_nr_valor.getValue());


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
            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id", ccff_nr_id.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.obr_nr_id", obr_nr_id.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.plco_nr_id", plco_nr_id.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_peso", ccff_nr_peso.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_mes", ccff_nr_mes.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_ano", ccff_nr_ano.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_quantidade", ccff_nr_quantidade.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_valor", ccff_nr_valor.getValue());


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
              JSONObject registro = resultado.get("ccff_copia_cronograma_fisico_financeiro").isObject();
            
              int ccff_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ccff_nr_id").toString()));
            ccff_copia_cronograma_fisico_financeiroTGWT.setCcff_nr_id(ccff_nr_id);
	    this.ccff_nr_id.setValue(ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            ccff_copia_cronograma_fisico_financeiroTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setValue(ccff_copia_cronograma_fisico_financeiroTGWT.getObr_nr_id() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            ccff_copia_cronograma_fisico_financeiroTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(ccff_copia_cronograma_fisico_financeiroTGWT.getPlco_nr_id() + "");

            int ccff_nr_peso =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ccff_nr_peso").toString()));
            ccff_copia_cronograma_fisico_financeiroTGWT.setCcff_nr_peso(ccff_nr_peso);
	    this.ccff_nr_peso.setValue(ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_peso() + "");

            int ccff_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ccff_nr_mes").toString()));
            ccff_copia_cronograma_fisico_financeiroTGWT.setCcff_nr_mes(ccff_nr_mes);
	    this.ccff_nr_mes.setValue(ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_mes() + "");

            int ccff_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ccff_nr_ano").toString()));
            ccff_copia_cronograma_fisico_financeiroTGWT.setCcff_nr_ano(ccff_nr_ano);
	    this.ccff_nr_ano.setValue(ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_ano() + "");

            float ccff_nr_quantidade =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ccff_nr_quantidade").toString()));
            ccff_copia_cronograma_fisico_financeiroTGWT.setCcff_nr_quantidade(ccff_nr_quantidade);
	    this.ccff_nr_quantidade.setValue(ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_quantidade() + "");

            float ccff_nr_valor =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ccff_nr_valor").toString()));
            ccff_copia_cronograma_fisico_financeiroTGWT.setCcff_nr_valor(ccff_nr_valor);
	    this.ccff_nr_valor.setValue(ccff_copia_cronograma_fisico_financeiroTGWT.getCcff_nr_valor() + "");



	    } catch (Exception e) {}		
        }

    }
}

