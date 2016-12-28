/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pes_pessoa;

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

import com.extjs.gxt.ui.client.event.ButtonEvent;

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

/**
 *
 * @author geoleite
 */
public class Pes_pessoaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pes_pessoa/pes_pessoaUpdateDeleteGWT.jsp";    

    private TextBox pes_nr_id = new TextBox();

    private TextBox pes_tx_nome = new TextBox();

    private TextBox pes_tx_fone = new TextBox();


    private Pes_pessoaTGWT pes_pessoaTGWT = new Pes_pessoaTGWT();
private Pes_pessoaConsultGWT consultGWT = new Pes_pessoaConsultGWT();


    public Pes_pessoaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Pes_pessoaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Pes_pessoaUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(4, 2);
        grid.setWidget(0, 0, new Label("pes_nr_id:"));
        grid.setWidget(0, 1, pes_nr_id);

        grid.setWidget(1, 0, new Label("pes_tx_nome:"));
        grid.setWidget(1, 1, pes_tx_nome);

        grid.setWidget(2, 0, new Label("pes_tx_fone:"));
        grid.setWidget(2, 1, pes_tx_fone);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Pes_pessoaTGWT pes_pessoaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("pes_pessoaT.pes_nr_id", pes_pessoaTGWT.getPes_nr_id() + "");

            param.put("pes_pessoaT.pes_tx_nome", pes_pessoaTGWT.getPes_tx_nome() + "");

            param.put("pes_pessoaT.pes_tx_fone", pes_pessoaTGWT.getPes_tx_fone() + "");


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
            param.put("pes_pessoaT.pes_nr_id", pes_nr_id.getText());

            param.put("pes_pessoaT.pes_tx_nome", pes_tx_nome.getText());

            param.put("pes_pessoaT.pes_tx_fone", pes_tx_fone.getText());


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
            param.put("pes_pessoaT.pes_nr_id", pes_nr_id.getText());

            param.put("pes_pessoaT.pes_tx_nome", pes_tx_nome.getText());

            param.put("pes_pessoaT.pes_tx_fone", pes_tx_fone.getText());


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
              JSONObject registro = resultado.get("pes_pessoa").isObject();
            
              int pes_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("pes_nr_id").toString()));
            pes_pessoaTGWT.setPes_nr_id(pes_nr_id);
	    this.pes_nr_id.setText(pes_pessoaTGWT.getPes_nr_id() + "");

            String pes_tx_nome =   (EasyContainer.clearAspas(registro.get("pes_tx_nome").toString()));
            pes_pessoaTGWT.setPes_tx_nome(pes_tx_nome);
	    this.pes_tx_nome.setText(pes_pessoaTGWT.getPes_tx_nome() + "");

            String pes_tx_fone =   (EasyContainer.clearAspas(registro.get("pes_tx_fone").toString()));
            pes_pessoaTGWT.setPes_tx_fone(pes_tx_fone);
	    this.pes_tx_fone.setText(pes_pessoaTGWT.getPes_tx_fone() + "");



	    } catch (Exception e) {}		
        }

    }
}

