/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.grp_grupo_produto;

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
public class Grp_grupo_produtoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoUpdateDeleteGWT.jsp";    

    private TextField<String> grp_nr_id = new TextField<String>();

    private TextField<String> grp_tx_nome = new TextField<String>();


    private Grp_grupo_produtoTGWT grp_grupo_produtoTGWT = new Grp_grupo_produtoTGWT();
private Grp_grupo_produtoConsultGWT consultGWT = new Grp_grupo_produtoConsultGWT();


    public Grp_grupo_produtoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Grp_grupo_produtoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Grp_grupo_produtoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar Grupo Produto");

        Grid grid = new Grid(3, 2);


        grid.setWidget(1, 0, new LabelField("Nome:"));
        grid.setWidget(1, 1, grp_tx_nome);




        getCpMaster().add(grid);
    }

    public void load(Grp_grupo_produtoTGWT grp_grupo_produtoTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("grp_grupo_produtoT.grp_nr_id", grp_grupo_produtoTGWT.getGrp_nr_id() + "");

            param.put("grp_grupo_produtoT.grp_tx_nome", grp_grupo_produtoTGWT.getGrp_tx_nome() + "");


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
            param.put("grp_grupo_produtoT.grp_nr_id", grp_grupo_produtoTGWT.getGrp_nr_id()+"");
            param.put("grp_grupo_produtoT.grp_tx_nome", grp_tx_nome.getValue());
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
            param.put("grp_grupo_produtoT.grp_nr_id", grp_nr_id.getValue());

            param.put("grp_grupo_produtoT.grp_tx_nome", grp_tx_nome.getValue());


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
              JSONObject registro = resultado.get("grp_grupo_produto").isObject();
            
              int grp_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("grp_nr_id").toString()));
            grp_grupo_produtoTGWT.setGrp_nr_id(grp_nr_id);
	    this.grp_nr_id.setValue(grp_grupo_produtoTGWT.getGrp_nr_id() + "");

            String grp_tx_nome =   (EasyContainer.clearAspas(registro.get("grp_tx_nome").toString()));
            grp_grupo_produtoTGWT.setGrp_tx_nome(grp_tx_nome);
	    this.grp_tx_nome.setValue(grp_grupo_produtoTGWT.getGrp_tx_nome() + "");



	    } catch (Exception e) {}		
        }

    }
}

