/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ina_insumo_antigo;

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
public class Ina_insumo_antigoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ina_insumo_antigo/ina_insumo_antigoUpdateDeleteGWT.jsp";    

    private TextBox ina_nr_id = new TextBox();

    private TextBox ina_tx_codigo = new TextBox();

    private TextBox ina_tx_descricao = new TextBox();

    private TextBox ina_tx_unidade = new TextBox();


    private Ina_insumo_antigoTGWT ina_insumo_antigoTGWT = new Ina_insumo_antigoTGWT();
private Ina_insumo_antigoConsultGWT consultGWT = new Ina_insumo_antigoConsultGWT();


    public Ina_insumo_antigoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ina_insumo_antigoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Ina_insumo_antigoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("ina_nr_id:"));
        grid.setWidget(0, 1, ina_nr_id);

        grid.setWidget(1, 0, new Label("ina_tx_codigo:"));
        grid.setWidget(1, 1, ina_tx_codigo);

        grid.setWidget(2, 0, new Label("ina_tx_descricao:"));
        grid.setWidget(2, 1, ina_tx_descricao);

        grid.setWidget(3, 0, new Label("ina_tx_unidade:"));
        grid.setWidget(3, 1, ina_tx_unidade);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Ina_insumo_antigoTGWT ina_insumo_antigoTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("ina_insumo_antigoT.ina_nr_id", ina_insumo_antigoTGWT.getIna_nr_id() + "");

            param.put("ina_insumo_antigoT.ina_tx_codigo", ina_insumo_antigoTGWT.getIna_tx_codigo() + "");

            param.put("ina_insumo_antigoT.ina_tx_descricao", ina_insumo_antigoTGWT.getIna_tx_descricao() + "");

            param.put("ina_insumo_antigoT.ina_tx_unidade", ina_insumo_antigoTGWT.getIna_tx_unidade() + "");


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
            param.put("ina_insumo_antigoT.ina_nr_id", ina_nr_id.getText());

            param.put("ina_insumo_antigoT.ina_tx_codigo", ina_tx_codigo.getText());

            param.put("ina_insumo_antigoT.ina_tx_descricao", ina_tx_descricao.getText());

            param.put("ina_insumo_antigoT.ina_tx_unidade", ina_tx_unidade.getText());


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
            param.put("ina_insumo_antigoT.ina_nr_id", ina_nr_id.getText());

            param.put("ina_insumo_antigoT.ina_tx_codigo", ina_tx_codigo.getText());

            param.put("ina_insumo_antigoT.ina_tx_descricao", ina_tx_descricao.getText());

            param.put("ina_insumo_antigoT.ina_tx_unidade", ina_tx_unidade.getText());


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
              JSONObject registro = resultado.get("ina_insumo_antigo").isObject();
            
              int ina_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ina_nr_id").toString()));
            ina_insumo_antigoTGWT.setIna_nr_id(ina_nr_id);
	    this.ina_nr_id.setText(ina_insumo_antigoTGWT.getIna_nr_id() + "");

            String ina_tx_codigo =   (EasyContainer.clearAspas(registro.get("ina_tx_codigo").toString()));
            ina_insumo_antigoTGWT.setIna_tx_codigo(ina_tx_codigo);
	    this.ina_tx_codigo.setText(ina_insumo_antigoTGWT.getIna_tx_codigo() + "");

            String ina_tx_descricao =   (EasyContainer.clearAspas(registro.get("ina_tx_descricao").toString()));
            ina_insumo_antigoTGWT.setIna_tx_descricao(ina_tx_descricao);
	    this.ina_tx_descricao.setText(ina_insumo_antigoTGWT.getIna_tx_descricao() + "");

            String ina_tx_unidade =   (EasyContainer.clearAspas(registro.get("ina_tx_unidade").toString()));
            ina_insumo_antigoTGWT.setIna_tx_unidade(ina_tx_unidade);
	    this.ina_tx_unidade.setText(ina_insumo_antigoTGWT.getIna_tx_unidade() + "");



	    } catch (Exception e) {}		
        }

    }
}

