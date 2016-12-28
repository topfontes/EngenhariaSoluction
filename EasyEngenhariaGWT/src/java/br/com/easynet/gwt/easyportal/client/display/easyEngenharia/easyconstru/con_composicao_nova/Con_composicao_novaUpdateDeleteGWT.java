/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.con_composicao_nova;

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
public class Con_composicao_novaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/con_composicao_nova/con_composicao_novaUpdateDeleteGWT.jsp";    

    private TextBox con_nr_id = new TextBox();

    private TextBox con_tx_codigo = new TextBox();

    private TextBox con_tx_descricao = new TextBox();

    private TextBox con_tx_unidade = new TextBox();


    private Con_composicao_novaTGWT con_composicao_novaTGWT = new Con_composicao_novaTGWT();
private Con_composicao_novaConsultGWT consultGWT = new Con_composicao_novaConsultGWT();


    public Con_composicao_novaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Con_composicao_novaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Con_composicao_novaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("con_nr_id:"));
        grid.setWidget(0, 1, con_nr_id);

        grid.setWidget(1, 0, new Label("con_tx_codigo:"));
        grid.setWidget(1, 1, con_tx_codigo);

        grid.setWidget(2, 0, new Label("con_tx_descricao:"));
        grid.setWidget(2, 1, con_tx_descricao);

        grid.setWidget(3, 0, new Label("con_tx_unidade:"));
        grid.setWidget(3, 1, con_tx_unidade);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Con_composicao_novaTGWT con_composicao_novaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("con_composicao_novaT.con_nr_id", con_composicao_novaTGWT.getCon_nr_id() + "");

            param.put("con_composicao_novaT.con_tx_codigo", con_composicao_novaTGWT.getCon_tx_codigo() + "");

            param.put("con_composicao_novaT.con_tx_descricao", con_composicao_novaTGWT.getCon_tx_descricao() + "");

            param.put("con_composicao_novaT.con_tx_unidade", con_composicao_novaTGWT.getCon_tx_unidade() + "");


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
            param.put("con_composicao_novaT.con_nr_id", con_nr_id.getText());

            param.put("con_composicao_novaT.con_tx_codigo", con_tx_codigo.getText());

            param.put("con_composicao_novaT.con_tx_descricao", con_tx_descricao.getText());

            param.put("con_composicao_novaT.con_tx_unidade", con_tx_unidade.getText());


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
            param.put("con_composicao_novaT.con_nr_id", con_nr_id.getText());

            param.put("con_composicao_novaT.con_tx_codigo", con_tx_codigo.getText());

            param.put("con_composicao_novaT.con_tx_descricao", con_tx_descricao.getText());

            param.put("con_composicao_novaT.con_tx_unidade", con_tx_unidade.getText());


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
              JSONObject registro = resultado.get("con_composicao_nova").isObject();
            
              int con_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("con_nr_id").toString()));
            con_composicao_novaTGWT.setCon_nr_id(con_nr_id);
	    this.con_nr_id.setText(con_composicao_novaTGWT.getCon_nr_id() + "");

            String con_tx_codigo =   (EasyContainer.clearAspas(registro.get("con_tx_codigo").toString()));
            con_composicao_novaTGWT.setCon_tx_codigo(con_tx_codigo);
	    this.con_tx_codigo.setText(con_composicao_novaTGWT.getCon_tx_codigo() + "");

            String con_tx_descricao =   (EasyContainer.clearAspas(registro.get("con_tx_descricao").toString()));
            con_composicao_novaTGWT.setCon_tx_descricao(con_tx_descricao);
	    this.con_tx_descricao.setText(con_composicao_novaTGWT.getCon_tx_descricao() + "");

            String con_tx_unidade =   (EasyContainer.clearAspas(registro.get("con_tx_unidade").toString()));
            con_composicao_novaTGWT.setCon_tx_unidade(con_tx_unidade);
	    this.con_tx_unidade.setText(con_composicao_novaTGWT.getCon_tx_unidade() + "");



	    } catch (Exception e) {}		
        }

    }
}

