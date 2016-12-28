/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ume_unidade_medida;

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

import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;

/**
 *
 * @author geoleite
 */
public class Ume_unidade_medidaUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaUpdateDeleteGWT.jsp";
    private TextField<String> ume_nr_id = new TextField<String>();
    private TextField<String> ume_tx_nome = new TextField<String>();
    private Ume_unidade_medidaTGWT ume_unidade_medidaTGWT = new Ume_unidade_medidaTGWT();
    private Ume_unidade_medidaConsultGWT consultGWT = new Ume_unidade_medidaConsultGWT();

    public Ume_unidade_medidaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ume_unidade_medidaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Ume_unidade_medidaUpdateDeleteGWT() {
        this.setSize("500", "150");
        this.setHeading("Alterar Unidade Medida");
        Grid grid = new Grid(3, 2);

        grid.setWidget(1, 0, new LabelField("Unidade Medida:"));
        grid.setWidget(1, 1, ume_tx_nome);
        ume_tx_nome.setWidth("300");
        ume_tx_nome.setAllowBlank(true);

        getCpMaster().add(grid);
    }

    public void load(Ume_unidade_medidaTGWT ume_unidade_medidaTGWT) {
        try {
            this.ume_unidade_medidaTGWT = ume_unidade_medidaTGWT;
            this.ume_nr_id.setValue(ume_unidade_medidaTGWT.getUme_nr_id() + "");
            this.ume_tx_nome.setValue(ume_unidade_medidaTGWT.getUme_tx_nome() + "");
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
        if (ume_tx_nome.getValue().trim().length() == 0) {
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
            param.put("ume_unidade_medidaT.ume_nr_id", ume_unidade_medidaTGWT.getUme_nr_id()+"");

            param.put("ume_unidade_medidaT.ume_tx_nome", ume_tx_nome.getValue());


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
            param.put("ume_unidade_medidaT.ume_nr_id", ume_unidade_medidaTGWT.getUme_nr_id()+"");

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

