/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uni_unidade;

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
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Uni_unidadeUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/uni_unidade/uni_unidadeUpdateDeleteGWT.jsp";
    private TextField<String> uni_nr_id = new TextField<String>();
    private TextField<String> uni_tx_nome = new TextField<String>();
    private Uni_unidadeTGWT uni_unidadeTGWT = new Uni_unidadeTGWT();
    private Uni_unidadeConsultGWT consultGWT = new Uni_unidadeConsultGWT();

    public Uni_unidadeConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Uni_unidadeConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Uni_unidadeUpdateDeleteGWT() {
        this.setSize("500", "150");
        this.setHeading("Alterar unidades construtivas");

        Grid grid = new Grid(3, 2);
        grid.setWidget(1, 0, new LabelField("Unidade:"));
        grid.setWidget(1, 1, uni_tx_nome);
        uni_tx_nome.setWidth("300");
        uni_tx_nome.setAllowBlank(false);
        getCpMaster().add(grid);
        this.layout();
    }

    public void load(Uni_unidadeTGWT uni_unidadeTGWT) {
        try {
            this.uni_unidadeTGWT = uni_unidadeTGWT;
            uni_tx_nome.setValue(uni_unidadeTGWT.getUni_tx_nome());
        } catch (Exception ex) {
        }
    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        if (valido()) {
            btnAltAction(ce);
        }

    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    public boolean valido() {
        boolean result = true;
        if (uni_tx_nome.getValue().trim().length() == 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo unidade tem preenchimento obrigatório");
        }
        return result;
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("uni_unidadeT.uni_nr_id", uni_unidadeTGWT.getUni_nr_id()+"");
                        param.put("uni_unidadeT.uni_tx_nome", uni_tx_nome.getValue());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            consultGWT.load();
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("uni_unidadeT.uni_nr_id", uni_unidadeTGWT.getUni_nr_id()+"");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String msg = EasyContainer.clearAspas(resultado.get("msg").toString());
            if (msg.trim().length() > 0) {
                if(msg.indexOf("sucesso") != -1){
                   getShowMsgAlteracao();
                   consultGWT.load();
                   this.close();
                }else{
                   getShowMsgErro(msg);
                }

            }
            try {
            } catch (Exception e) {
            }
        }

    }
}

