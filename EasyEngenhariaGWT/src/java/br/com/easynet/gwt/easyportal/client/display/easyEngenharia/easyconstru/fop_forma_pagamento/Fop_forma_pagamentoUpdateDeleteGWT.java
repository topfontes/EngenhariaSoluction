/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fop_forma_pagamento;

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
import com.google.gwt.user.client.ui.CheckBox;

/**
 *
 * @author geoleite
 */
public class Fop_forma_pagamentoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoUpdateDeleteGWT.jsp";
    private TextField<String> fop_nr_id = new TextField<String>();
    private TextField<String> fop_tx_nome = new TextField<String>();
    private TextField<String> fop_tx_avista = new TextField<String>();
    private CheckBox avista = new CheckBox("Avista");
    private Fop_forma_pagamentoTGWT fop_forma_pagamentoTGWT = new Fop_forma_pagamentoTGWT();
    private Fop_forma_pagamentoConsultGWT consultGWT = new Fop_forma_pagamentoConsultGWT();

    public Fop_forma_pagamentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Fop_forma_pagamentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Fop_forma_pagamentoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar Forma Pagamento");
        Grid grid = new Grid(4, 2);
        grid.setWidget(1, 0, new LabelField("Nome:"));
        grid.setWidget(1, 1, fop_tx_nome);
        grid.setWidget(3, 1, avista);
        getCpMaster().add(grid);
    }

    public void load(Fop_forma_pagamentoTGWT fop_forma_pagamentoTGWT) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("fop_forma_pagamentoT.fop_nr_id", fop_forma_pagamentoTGWT.getFop_nr_id() + "");
            param.put("fop_forma_pagamentoT.fop_tx_nome", fop_forma_pagamentoTGWT.getFop_tx_nome() + "");
            param.put("fop_forma_pagamentoT.fop_tx_avista", fop_forma_pagamentoTGWT.getFop_tx_avista() + "");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
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
        if (fop_tx_nome.getValue().trim().length() == 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo nome tem preenchimento obrigatório");
        }
        return result;
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("fop_forma_pagamentoT.fop_nr_id", fop_nr_id.getValue());
            param.put("fop_forma_pagamentoT.fop_tx_nome", fop_tx_nome.getValue());
            param.put("fop_forma_pagamentoT.fop_tx_avista", avista.getValue() ? "S" : "N");
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
            param.put("fop_forma_pagamentoT.fop_nr_id", fop_nr_id.getValue());
            param.put("fop_forma_pagamentoT.fop_tx_nome", fop_tx_nome.getValue());
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
                MessageBox mb = new MessageBox();
                mb.alert("", msg, null);
            }
            try {
                JSONObject registro = resultado.get("fop_forma_pagamento").isObject();

                int fop_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("fop_nr_id").toString()));
                fop_forma_pagamentoTGWT.setFop_nr_id(fop_nr_id);
                this.fop_nr_id.setValue(fop_forma_pagamentoTGWT.getFop_nr_id() + "");

                String fop_tx_nome = (EasyContainer.clearAspas(registro.get("fop_tx_nome").toString()));
                fop_forma_pagamentoTGWT.setFop_tx_nome(fop_tx_nome);
                this.fop_tx_nome.setValue(fop_forma_pagamentoTGWT.getFop_tx_nome() + "");

                String fop_tx_avista = (EasyContainer.clearAspas(registro.get("fop_tx_avista").toString()));
                fop_forma_pagamentoTGWT.setFop_tx_avista(fop_tx_avista);
                this.fop_tx_avista.setValue(fop_forma_pagamentoTGWT.getFop_tx_avista() + "");
                this.avista.setChecked(fop_forma_pagamentoTGWT.getFop_tx_avista().equalsIgnoreCase("S"));

            } catch (Exception e) {
            }
        }

    }
}

