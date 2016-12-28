/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.coa_composicao_anterior;

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
public class Coa_composicao_anteriorUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/coa_composicao_anterior/coa_composicao_anteriorUpdateDeleteGWT.jsp";    

    private TextBox coa_nr_id = new TextBox();

    private TextBox coa_tx_codigo = new TextBox();

    private TextBox coa_tx_descricao = new TextBox();

    private TextBox coa_tx_unidade = new TextBox();


    private Coa_composicao_anteriorTGWT coa_composicao_anteriorTGWT = new Coa_composicao_anteriorTGWT();
private Coa_composicao_anteriorConsultGWT consultGWT = new Coa_composicao_anteriorConsultGWT();


    public Coa_composicao_anteriorConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Coa_composicao_anteriorConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Coa_composicao_anteriorUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("coa_nr_id:"));
        grid.setWidget(0, 1, coa_nr_id);

        grid.setWidget(1, 0, new Label("coa_tx_codigo:"));
        grid.setWidget(1, 1, coa_tx_codigo);

        grid.setWidget(2, 0, new Label("coa_tx_descricao:"));
        grid.setWidget(2, 1, coa_tx_descricao);

        grid.setWidget(3, 0, new Label("coa_tx_unidade:"));
        grid.setWidget(3, 1, coa_tx_unidade);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Coa_composicao_anteriorTGWT coa_composicao_anteriorTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("coa_composicao_anteriorT.coa_nr_id", coa_composicao_anteriorTGWT.getCoa_nr_id() + "");

            param.put("coa_composicao_anteriorT.coa_tx_codigo", coa_composicao_anteriorTGWT.getCoa_tx_codigo() + "");

            param.put("coa_composicao_anteriorT.coa_tx_descricao", coa_composicao_anteriorTGWT.getCoa_tx_descricao() + "");

            param.put("coa_composicao_anteriorT.coa_tx_unidade", coa_composicao_anteriorTGWT.getCoa_tx_unidade() + "");


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
            param.put("coa_composicao_anteriorT.coa_nr_id", coa_nr_id.getText());

            param.put("coa_composicao_anteriorT.coa_tx_codigo", coa_tx_codigo.getText());

            param.put("coa_composicao_anteriorT.coa_tx_descricao", coa_tx_descricao.getText());

            param.put("coa_composicao_anteriorT.coa_tx_unidade", coa_tx_unidade.getText());


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
            param.put("coa_composicao_anteriorT.coa_nr_id", coa_nr_id.getText());

            param.put("coa_composicao_anteriorT.coa_tx_codigo", coa_tx_codigo.getText());

            param.put("coa_composicao_anteriorT.coa_tx_descricao", coa_tx_descricao.getText());

            param.put("coa_composicao_anteriorT.coa_tx_unidade", coa_tx_unidade.getText());


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
              JSONObject registro = resultado.get("coa_composicao_anterior").isObject();
            
              int coa_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("coa_nr_id").toString()));
            coa_composicao_anteriorTGWT.setCoa_nr_id(coa_nr_id);
	    this.coa_nr_id.setText(coa_composicao_anteriorTGWT.getCoa_nr_id() + "");

            String coa_tx_codigo =   (EasyContainer.clearAspas(registro.get("coa_tx_codigo").toString()));
            coa_composicao_anteriorTGWT.setCoa_tx_codigo(coa_tx_codigo);
	    this.coa_tx_codigo.setText(coa_composicao_anteriorTGWT.getCoa_tx_codigo() + "");

            String coa_tx_descricao =   (EasyContainer.clearAspas(registro.get("coa_tx_descricao").toString()));
            coa_composicao_anteriorTGWT.setCoa_tx_descricao(coa_tx_descricao);
	    this.coa_tx_descricao.setText(coa_composicao_anteriorTGWT.getCoa_tx_descricao() + "");

            String coa_tx_unidade =   (EasyContainer.clearAspas(registro.get("coa_tx_unidade").toString()));
            coa_composicao_anteriorTGWT.setCoa_tx_unidade(coa_tx_unidade);
	    this.coa_tx_unidade.setText(coa_composicao_anteriorTGWT.getCoa_tx_unidade() + "");



	    } catch (Exception e) {}		
        }

    }
}

