/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.dso_descricao_servico_obra;

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
public class Dso_descricao_servico_obraUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraUpdateDeleteGWT.jsp";    

    private TextBox plco_nr_id = new TextBox();

    private TextBox dso_tx_codigo_externo = new TextBox();

    private TextBox dso_tx_descriaco = new TextBox();

    private TextBox dso_nr_id = new TextBox();


    private Dso_descricao_servico_obraTGWT dso_descricao_servico_obraTGWT = new Dso_descricao_servico_obraTGWT();
private Dso_descricao_servico_obraConsultGWT consultGWT = new Dso_descricao_servico_obraConsultGWT();


    public Dso_descricao_servico_obraConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Dso_descricao_servico_obraConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Dso_descricao_servico_obraUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("plco_nr_id:"));
        grid.setWidget(0, 1, plco_nr_id);

        grid.setWidget(1, 0, new Label("dso_tx_codigo_externo:"));
        grid.setWidget(1, 1, dso_tx_codigo_externo);

        grid.setWidget(2, 0, new Label("dso_tx_descriaco:"));
        grid.setWidget(2, 1, dso_tx_descriaco);

        grid.setWidget(3, 0, new Label("dso_nr_id:"));
        grid.setWidget(3, 1, dso_nr_id);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Dso_descricao_servico_obraTGWT dso_descricao_servico_obraTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("dso_descricao_servico_obraT.plco_nr_id", dso_descricao_servico_obraTGWT.getPlco_nr_id() + "");

            param.put("dso_descricao_servico_obraT.dso_tx_codigo_externo", dso_descricao_servico_obraTGWT.getDso_tx_codigo_externo() + "");

            param.put("dso_descricao_servico_obraT.dso_tx_descriaco", dso_descricao_servico_obraTGWT.getDso_tx_descriaco() + "");

            param.put("dso_descricao_servico_obraT.dso_nr_id", dso_descricao_servico_obraTGWT.getDso_nr_id() + "");


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
            param.put("dso_descricao_servico_obraT.plco_nr_id", plco_nr_id.getText());

            param.put("dso_descricao_servico_obraT.dso_tx_codigo_externo", dso_tx_codigo_externo.getText());

            param.put("dso_descricao_servico_obraT.dso_tx_descriaco", dso_tx_descriaco.getText());

            param.put("dso_descricao_servico_obraT.dso_nr_id", dso_nr_id.getText());


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
            param.put("dso_descricao_servico_obraT.plco_nr_id", plco_nr_id.getText());

            param.put("dso_descricao_servico_obraT.dso_tx_codigo_externo", dso_tx_codigo_externo.getText());

            param.put("dso_descricao_servico_obraT.dso_tx_descriaco", dso_tx_descriaco.getText());

            param.put("dso_descricao_servico_obraT.dso_nr_id", dso_nr_id.getText());


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
              JSONObject registro = resultado.get("dso_descricao_servico_obra").isObject();
            
              int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            dso_descricao_servico_obraTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setText(dso_descricao_servico_obraTGWT.getPlco_nr_id() + "");

            String dso_tx_codigo_externo =   (EasyContainer.clearAspas(registro.get("dso_tx_codigo_externo").toString()));
            dso_descricao_servico_obraTGWT.setDso_tx_codigo_externo(dso_tx_codigo_externo);
	    this.dso_tx_codigo_externo.setText(dso_descricao_servico_obraTGWT.getDso_tx_codigo_externo() + "");

            String dso_tx_descriaco =   (EasyContainer.clearAspas(registro.get("dso_tx_descriaco").toString()));
            dso_descricao_servico_obraTGWT.setDso_tx_descriaco(dso_tx_descriaco);
	    this.dso_tx_descriaco.setText(dso_descricao_servico_obraTGWT.getDso_tx_descriaco() + "");

            int dso_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("dso_nr_id").toString()));
            dso_descricao_servico_obraTGWT.setDso_nr_id(dso_nr_id);
	    this.dso_nr_id.setText(dso_descricao_servico_obraTGWT.getDso_nr_id() + "");



	    } catch (Exception e) {}		
        }

    }
}

