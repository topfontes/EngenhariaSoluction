/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inn_insumo_novo;

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
public class Inn_insumo_novoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/inn_insumo_novo/inn_insumo_novoUpdateDeleteGWT.jsp";    

    private TextBox inn_nr_id = new TextBox();

    private TextBox inn_tx_codigo = new TextBox();

    private TextBox inn_tx_descricao = new TextBox();

    private TextBox inn_tx_unidade = new TextBox();


    private Inn_insumo_novoTGWT inn_insumo_novoTGWT = new Inn_insumo_novoTGWT();
private Inn_insumo_novoConsultGWT consultGWT = new Inn_insumo_novoConsultGWT();


    public Inn_insumo_novoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Inn_insumo_novoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Inn_insumo_novoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("inn_nr_id:"));
        grid.setWidget(0, 1, inn_nr_id);

        grid.setWidget(1, 0, new Label("inn_tx_codigo:"));
        grid.setWidget(1, 1, inn_tx_codigo);

        grid.setWidget(2, 0, new Label("inn_tx_descricao:"));
        grid.setWidget(2, 1, inn_tx_descricao);

        grid.setWidget(3, 0, new Label("inn_tx_unidade:"));
        grid.setWidget(3, 1, inn_tx_unidade);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Inn_insumo_novoTGWT inn_insumo_novoTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("inn_insumo_novoT.inn_nr_id", inn_insumo_novoTGWT.getInn_nr_id() + "");

            param.put("inn_insumo_novoT.inn_tx_codigo", inn_insumo_novoTGWT.getInn_tx_codigo() + "");

            param.put("inn_insumo_novoT.inn_tx_descricao", inn_insumo_novoTGWT.getInn_tx_descricao() + "");

            param.put("inn_insumo_novoT.inn_tx_unidade", inn_insumo_novoTGWT.getInn_tx_unidade() + "");


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
            param.put("inn_insumo_novoT.inn_nr_id", inn_nr_id.getText());

            param.put("inn_insumo_novoT.inn_tx_codigo", inn_tx_codigo.getText());

            param.put("inn_insumo_novoT.inn_tx_descricao", inn_tx_descricao.getText());

            param.put("inn_insumo_novoT.inn_tx_unidade", inn_tx_unidade.getText());


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
            param.put("inn_insumo_novoT.inn_nr_id", inn_nr_id.getText());

            param.put("inn_insumo_novoT.inn_tx_codigo", inn_tx_codigo.getText());

            param.put("inn_insumo_novoT.inn_tx_descricao", inn_tx_descricao.getText());

            param.put("inn_insumo_novoT.inn_tx_unidade", inn_tx_unidade.getText());


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
              JSONObject registro = resultado.get("inn_insumo_novo").isObject();
            
              int inn_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("inn_nr_id").toString()));
            inn_insumo_novoTGWT.setInn_nr_id(inn_nr_id);
	    this.inn_nr_id.setText(inn_insumo_novoTGWT.getInn_nr_id() + "");

            String inn_tx_codigo =   (EasyContainer.clearAspas(registro.get("inn_tx_codigo").toString()));
            inn_insumo_novoTGWT.setInn_tx_codigo(inn_tx_codigo);
	    this.inn_tx_codigo.setText(inn_insumo_novoTGWT.getInn_tx_codigo() + "");

            String inn_tx_descricao =   (EasyContainer.clearAspas(registro.get("inn_tx_descricao").toString()));
            inn_insumo_novoTGWT.setInn_tx_descricao(inn_tx_descricao);
	    this.inn_tx_descricao.setText(inn_insumo_novoTGWT.getInn_tx_descricao() + "");

            String inn_tx_unidade =   (EasyContainer.clearAspas(registro.get("inn_tx_unidade").toString()));
            inn_insumo_novoTGWT.setInn_tx_unidade(inn_tx_unidade);
	    this.inn_tx_unidade.setText(inn_insumo_novoTGWT.getInn_tx_unidade() + "");



	    } catch (Exception e) {}		
        }

    }
}

