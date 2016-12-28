/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.usuario_sistema;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Usuario_sistemaTGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author I9
 */
public class Usuario_sistemaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/usuario_sistema/usuario_sistemaUpdateDeleteGWT.jsp";
    private TextBox usu_tx_nome = new TextBox();
    private TextBox usu_tx_status = new TextBox();
    private TextBox usu_tx_email = new TextBox();
    private RadioGroup radioGroup = new RadioGroup();
    private Radio ativo = new Radio();
    private Radio inativo = new Radio();
    private Usuario_sistemaConsultGWT consultGWT = new Usuario_sistemaConsultGWT();
    private Usuario_sistemaTGWT usuario_sistemaTGWT = new Usuario_sistemaTGWT();
    private Usuario_sistemaUpdateDeleteGWT updateDeleteGWT = this;

    public Usuario_sistemaUpdateDeleteGWT() {
        this.setSize("40%", "270");
        this.setHeading("Alterar Usuário");


        Grid grid = new Grid(4, 2);
        grid.setWidget(0, 0, new LabelField("Nome:"));
        grid.setWidget(0, 1, usu_tx_nome);

        ativo.setBoxLabel("Ativo");
        radioGroup.add(ativo);
        inativo.setBoxLabel("Inativo");
        radioGroup.add(inativo);
        grid.setWidget(1, 0, new LabelField("Status:"));
        grid.setWidget(1, 1, radioGroup);

        grid.setWidget(2, 0, new LabelField("E_mail:"));
        grid.setWidget(2, 1, usu_tx_email);

        getCpMaster().add(grid);

    }

    public void load(Usuario_sistemaTGWT usuario_sistemaTGWT) {
        try {
            this.usuario_sistemaTGWT = usuario_sistemaTGWT;
            usu_tx_nome.setValue(usuario_sistemaTGWT.getUsu_tx_nome());
            usu_tx_email.setValue(usuario_sistemaTGWT.getUsu_tx_email());
            if (usuario_sistemaTGWT.getUsu_tx_status().equalsIgnoreCase("A")) {
                ativo.setValue(true);
            } else {
                inativo.setValue(true);
            }

        } catch (Exception e) {
        }

    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {

        if (isPreenchido()) {
            btnAltAction(ce);
        } else {
            MessageBox.alert("Result", "preecha todos campos!",null);
        }


    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {


        btnDelAction(ce);

    }

    public boolean valido() {
        boolean result = true;
        return result;
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("usu_usuarioT.usu_tx_nome", usu_tx_nome.getValue());
            param.put("usu_usuarioT.usu_tx_email", usu_tx_email.getValue());
            param.put("usu_usuarioT.usu_tx_status", radioGroup.getValue().getBoxLabel().equalsIgnoreCase("ativo") ? "A" : "I");
            param.put("usu_usuarioT.usu_nr_id", usuario_sistemaTGWT.getUsu_nr_id() + "");
            param.put("usu_usuarioT.usu_tx_login", usuario_sistemaTGWT.getUsu_tx_login() + "");
            param.put("usu_usuarioT.usu_tx_senha", usuario_sistemaTGWT.getUsu_tx_senha() + "");
            // param.put("usu_usuarioT.usu_nr_id", usuario_sistemaTGWT.getUsu_+"");

            eaurl.accessJSonMap(Constantes.URL + PAGE, param);


        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {

            EasyAccessURL eaurl = new EasyAccessURL(this);

            HashMap<String, String> param = new HashMap<String, String>();

            param.put("op", "delete");

            param.put("usu_usuarioT.usu_nr_id", usuario_sistemaTGWT.getUsu_nr_id() + "");


            // param.put("usu_usuarioT.usu_nr_id", usuario_sistemaTGWT.getUsu_+"");

            eaurl.accessJSonMap(Constantes.URL + PAGE, param);



        } catch (Exception ex) {
        }
    }

    /**
     * @return the consultGWT
     */
    public Usuario_sistemaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Usuario_sistemaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public void read(JSONValue jsonValue) {
        consultGWT.load();
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            //JSONObject resultado = jsonObject.get("resultado").isObject();
            MessageBox.alert("Result", jsonObject.get("resultado").toString(),null);
        }
    }

    public boolean isPreenchido() {
        return !(("".equals(usu_tx_email.getValue()))
                || ("".equals(usu_tx_nome.getValue())));
    }
}
