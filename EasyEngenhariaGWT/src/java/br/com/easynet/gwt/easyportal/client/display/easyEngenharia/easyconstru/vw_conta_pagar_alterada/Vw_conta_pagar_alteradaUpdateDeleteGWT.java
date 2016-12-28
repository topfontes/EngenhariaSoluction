/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_conta_pagar_alterada;

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
public class Vw_conta_pagar_alteradaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDeleteGWT.jsp";    

    private TextBox ctp_nr_id = new TextBox();

    private TextBox ctp_nr_mes = new TextBox();

    private TextBox ctp_nr_ano = new TextBox();

    private TextBox ctp_nr_documento = new TextBox();

    private TextBox ctp_tx_obs = new TextBox();

    private TextBox ctp_tx_fornecedor = new TextBox();

    private TextBox ctp_nr_valor = new TextBox();

    private TextBox ctpm_nr_mes = new TextBox();

    private TextBox ctpm_nr_ano = new TextBox();


    private Vw_conta_pagar_alteradaTGWT vw_conta_pagar_alteradaTGWT = new Vw_conta_pagar_alteradaTGWT();
private Vw_conta_pagar_alteradaConsultGWT consultGWT = new Vw_conta_pagar_alteradaConsultGWT();


    public Vw_conta_pagar_alteradaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_conta_pagar_alteradaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Vw_conta_pagar_alteradaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(10, 2);
        grid.setWidget(0, 0, new Label("ctp_nr_id:"));
        grid.setWidget(0, 1, ctp_nr_id);

        grid.setWidget(1, 0, new Label("ctp_nr_mes:"));
        grid.setWidget(1, 1, ctp_nr_mes);

        grid.setWidget(2, 0, new Label("ctp_nr_ano:"));
        grid.setWidget(2, 1, ctp_nr_ano);

        grid.setWidget(3, 0, new Label("ctp_nr_documento:"));
        grid.setWidget(3, 1, ctp_nr_documento);

        grid.setWidget(4, 0, new Label("ctp_tx_obs:"));
        grid.setWidget(4, 1, ctp_tx_obs);

        grid.setWidget(5, 0, new Label("ctp_tx_fornecedor:"));
        grid.setWidget(5, 1, ctp_tx_fornecedor);

        grid.setWidget(6, 0, new Label("ctp_nr_valor:"));
        grid.setWidget(6, 1, ctp_nr_valor);

        grid.setWidget(7, 0, new Label("ctpm_nr_mes:"));
        grid.setWidget(7, 1, ctpm_nr_mes);

        grid.setWidget(8, 0, new Label("ctpm_nr_ano:"));
        grid.setWidget(8, 1, ctpm_nr_ano);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Vw_conta_pagar_alteradaTGWT vw_conta_pagar_alteradaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("vw_conta_pagar_alteradaT.ctp_nr_id", vw_conta_pagar_alteradaTGWT.getCtp_nr_id() + "");

            param.put("vw_conta_pagar_alteradaT.ctp_nr_mes", vw_conta_pagar_alteradaTGWT.getCtp_nr_mes() + "");

            param.put("vw_conta_pagar_alteradaT.ctp_nr_ano", vw_conta_pagar_alteradaTGWT.getCtp_nr_ano() + "");

            param.put("vw_conta_pagar_alteradaT.ctp_nr_documento", vw_conta_pagar_alteradaTGWT.getCtp_nr_documento() + "");

            param.put("vw_conta_pagar_alteradaT.ctp_tx_obs", vw_conta_pagar_alteradaTGWT.getCtp_tx_obs() + "");

            param.put("vw_conta_pagar_alteradaT.ctp_tx_fornecedor", vw_conta_pagar_alteradaTGWT.getCtp_tx_fornecedor() + "");

            param.put("vw_conta_pagar_alteradaT.ctp_nr_valor", vw_conta_pagar_alteradaTGWT.getCtp_nr_valor() + "");

            param.put("vw_conta_pagar_alteradaT.ctpm_nr_mes", vw_conta_pagar_alteradaTGWT.getCtpm_nr_mes() + "");

            param.put("vw_conta_pagar_alteradaT.ctpm_nr_ano", vw_conta_pagar_alteradaTGWT.getCtpm_nr_ano() + "");


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
            param.put("vw_conta_pagar_alteradaT.ctp_nr_id", ctp_nr_id.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_mes", ctp_nr_mes.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_ano", ctp_nr_ano.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_documento", ctp_nr_documento.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_tx_obs", ctp_tx_obs.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_tx_fornecedor", ctp_tx_fornecedor.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_valor", ctp_nr_valor.getText());

            param.put("vw_conta_pagar_alteradaT.ctpm_nr_mes", ctpm_nr_mes.getText());

            param.put("vw_conta_pagar_alteradaT.ctpm_nr_ano", ctpm_nr_ano.getText());


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
            param.put("vw_conta_pagar_alteradaT.ctp_nr_id", ctp_nr_id.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_mes", ctp_nr_mes.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_ano", ctp_nr_ano.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_documento", ctp_nr_documento.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_tx_obs", ctp_tx_obs.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_tx_fornecedor", ctp_tx_fornecedor.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_valor", ctp_nr_valor.getText());

            param.put("vw_conta_pagar_alteradaT.ctpm_nr_mes", ctpm_nr_mes.getText());

            param.put("vw_conta_pagar_alteradaT.ctpm_nr_ano", ctpm_nr_ano.getText());


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
              JSONObject registro = resultado.get("vw_conta_pagar_alterada").isObject();
            
              int ctp_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_id").toString()));
            vw_conta_pagar_alteradaTGWT.setCtp_nr_id(ctp_nr_id);
	    this.ctp_nr_id.setText(vw_conta_pagar_alteradaTGWT.getCtp_nr_id() + "");

            int ctp_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_mes").toString()));
            vw_conta_pagar_alteradaTGWT.setCtp_nr_mes(ctp_nr_mes);
	    this.ctp_nr_mes.setText(vw_conta_pagar_alteradaTGWT.getCtp_nr_mes() + "");

            int ctp_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_ano").toString()));
            vw_conta_pagar_alteradaTGWT.setCtp_nr_ano(ctp_nr_ano);
	    this.ctp_nr_ano.setText(vw_conta_pagar_alteradaTGWT.getCtp_nr_ano() + "");

            String ctp_nr_documento =   (EasyContainer.clearAspas(registro.get("ctp_nr_documento").toString()));
            vw_conta_pagar_alteradaTGWT.setCtp_nr_documento(ctp_nr_documento);
	    this.ctp_nr_documento.setText(vw_conta_pagar_alteradaTGWT.getCtp_nr_documento() + "");

            String ctp_tx_obs =   (EasyContainer.clearAspas(registro.get("ctp_tx_obs").toString()));
            vw_conta_pagar_alteradaTGWT.setCtp_tx_obs(ctp_tx_obs);
	    this.ctp_tx_obs.setText(vw_conta_pagar_alteradaTGWT.getCtp_tx_obs() + "");

            String ctp_tx_fornecedor =   (EasyContainer.clearAspas(registro.get("ctp_tx_fornecedor").toString()));
            vw_conta_pagar_alteradaTGWT.setCtp_tx_fornecedor(ctp_tx_fornecedor);
	    this.ctp_tx_fornecedor.setText(vw_conta_pagar_alteradaTGWT.getCtp_tx_fornecedor() + "");

            float ctp_nr_valor =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ctp_nr_valor").toString()));
            vw_conta_pagar_alteradaTGWT.setCtp_nr_valor(ctp_nr_valor);
	    this.ctp_nr_valor.setText(vw_conta_pagar_alteradaTGWT.getCtp_nr_valor() + "");

            int ctpm_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ctpm_nr_mes").toString()));
            vw_conta_pagar_alteradaTGWT.setCtpm_nr_mes(ctpm_nr_mes);
	    this.ctpm_nr_mes.setText(vw_conta_pagar_alteradaTGWT.getCtpm_nr_mes() + "");

            int ctpm_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ctpm_nr_ano").toString()));
            vw_conta_pagar_alteradaTGWT.setCtpm_nr_ano(ctpm_nr_ano);
	    this.ctpm_nr_ano.setText(vw_conta_pagar_alteradaTGWT.getCtpm_nr_ano() + "");



	    } catch (Exception e) {}		
        }

    }
}

