/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.con_contatos;

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
public class Con_contatosUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDeleteGWT.jsp";    

    private TextField<String> con_nr_id = new TextField<String>();

    private TextField<String> cli_nr_id = new TextField<String>();

    private TextField<String> con_tx_nome = new TextField<String>();

    private TextField<String> set_nr_id = new TextField<String>();

    private TextField<String> con_tx_cargo_exercicio = new TextField<String>();

    private TextField<String> con_tx_telefone = new TextField<String>();

    private TextField<String> con_tx_telefone2 = new TextField<String>();

    private TextField<String> con_tx_email = new TextField<String>();


    private Con_contatosTGWT con_contatosTGWT = new Con_contatosTGWT();
private Con_contatosConsultGWT consultGWT = new Con_contatosConsultGWT();


    public Con_contatosConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Con_contatosConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Con_contatosUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(9, 2);
        grid.setWidget(0, 0, new LabelField("con_nr_id:"));
        grid.setWidget(0, 1, con_nr_id);

        grid.setWidget(1, 0, new LabelField("cli_nr_id:"));
        grid.setWidget(1, 1, cli_nr_id);

        grid.setWidget(2, 0, new LabelField("con_tx_nome:"));
        grid.setWidget(2, 1, con_tx_nome);

        grid.setWidget(3, 0, new LabelField("set_nr_id:"));
        grid.setWidget(3, 1, set_nr_id);

        grid.setWidget(4, 0, new LabelField("con_tx_cargo_exercicio:"));
        grid.setWidget(4, 1, con_tx_cargo_exercicio);

        grid.setWidget(5, 0, new LabelField("con_tx_telefone:"));
        grid.setWidget(5, 1, con_tx_telefone);

        grid.setWidget(6, 0, new LabelField("con_tx_telefone2:"));
        grid.setWidget(6, 1, con_tx_telefone2);

        grid.setWidget(7, 0, new LabelField("con_tx_email:"));
        grid.setWidget(7, 1, con_tx_email);




        getCpMaster().add(grid);
    }

    public void load(Con_contatosTGWT con_contatosTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("con_contatosT.con_nr_id", con_contatosTGWT.getCon_nr_id() + "");

            param.put("con_contatosT.cli_nr_id", con_contatosTGWT.getCli_nr_id() + "");

            param.put("con_contatosT.con_tx_nome", con_contatosTGWT.getCon_tx_nome() + "");

            param.put("con_contatosT.set_nr_id", con_contatosTGWT.getSet_nr_id() + "");

            param.put("con_contatosT.con_tx_cargo_exercicio", con_contatosTGWT.getCon_tx_cargo_exercicio() + "");

            param.put("con_contatosT.con_tx_telefone", con_contatosTGWT.getCon_tx_telefone() + "");

            param.put("con_contatosT.con_tx_telefone2", con_contatosTGWT.getCon_tx_telefone2() + "");

            param.put("con_contatosT.con_tx_email", con_contatosTGWT.getCon_tx_email() + "");


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
            param.put("con_contatosT.con_nr_id", con_nr_id.getValue());

            param.put("con_contatosT.cli_nr_id", cli_nr_id.getValue());

            param.put("con_contatosT.con_tx_nome", con_tx_nome.getValue());

            param.put("con_contatosT.set_nr_id", set_nr_id.getValue());

            param.put("con_contatosT.con_tx_cargo_exercicio", con_tx_cargo_exercicio.getValue());

            param.put("con_contatosT.con_tx_telefone", con_tx_telefone.getValue());

            param.put("con_contatosT.con_tx_telefone2", con_tx_telefone2.getValue());

            param.put("con_contatosT.con_tx_email", con_tx_email.getValue());


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
            param.put("con_contatosT.con_nr_id", con_nr_id.getValue());

            param.put("con_contatosT.cli_nr_id", cli_nr_id.getValue());

            param.put("con_contatosT.con_tx_nome", con_tx_nome.getValue());

            param.put("con_contatosT.set_nr_id", set_nr_id.getValue());

            param.put("con_contatosT.con_tx_cargo_exercicio", con_tx_cargo_exercicio.getValue());

            param.put("con_contatosT.con_tx_telefone", con_tx_telefone.getValue());

            param.put("con_contatosT.con_tx_telefone2", con_tx_telefone2.getValue());

            param.put("con_contatosT.con_tx_email", con_tx_email.getValue());


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
              JSONObject registro = resultado.get("con_contatos").isObject();
            
              int con_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("con_nr_id").toString()));
            con_contatosTGWT.setCon_nr_id(con_nr_id);
	    this.con_nr_id.setValue(con_contatosTGWT.getCon_nr_id() + "");

            int cli_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
            con_contatosTGWT.setCli_nr_id(cli_nr_id);
	    this.cli_nr_id.setValue(con_contatosTGWT.getCli_nr_id() + "");

            String con_tx_nome =   (EasyContainer.clearAspas(registro.get("con_tx_nome").toString()));
            con_contatosTGWT.setCon_tx_nome(con_tx_nome);
	    this.con_tx_nome.setValue(con_contatosTGWT.getCon_tx_nome() + "");

            int set_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
            con_contatosTGWT.setSet_nr_id(set_nr_id);
	    this.set_nr_id.setValue(con_contatosTGWT.getSet_nr_id() + "");

            String con_tx_cargo_exercicio =   (EasyContainer.clearAspas(registro.get("con_tx_cargo_exercicio").toString()));
            con_contatosTGWT.setCon_tx_cargo_exercicio(con_tx_cargo_exercicio);
	    this.con_tx_cargo_exercicio.setValue(con_contatosTGWT.getCon_tx_cargo_exercicio() + "");

            String con_tx_telefone =   (EasyContainer.clearAspas(registro.get("con_tx_telefone").toString()));
            con_contatosTGWT.setCon_tx_telefone(con_tx_telefone);
	    this.con_tx_telefone.setValue(con_contatosTGWT.getCon_tx_telefone() + "");

            String con_tx_telefone2 =   (EasyContainer.clearAspas(registro.get("con_tx_telefone2").toString()));
            con_contatosTGWT.setCon_tx_telefone2(con_tx_telefone2);
	    this.con_tx_telefone2.setValue(con_contatosTGWT.getCon_tx_telefone2() + "");

            String con_tx_email =   (EasyContainer.clearAspas(registro.get("con_tx_email").toString()));
            con_contatosTGWT.setCon_tx_email(con_tx_email);
	    this.con_tx_email.setValue(con_contatosTGWT.getCon_tx_email() + "");



	    } catch (Exception e) {}		
        }

    }
}

