/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fol_folha_pagamento;

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
public class Fol_folha_pagamentoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDeleteGWT.jsp";    

    private TextBox fol_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox plc_nr_id = new TextBox();

    private TextBox fol_nr_mes = new TextBox();

    private TextBox fol_nr_ano = new TextBox();

    private TextBox fol_tx_funcao = new TextBox();

    private TextBox fol_nr_salario_bruto_oficial = new TextBox();

    private TextBox fol_nr_adiantamento_oficial = new TextBox();

    private TextBox fol_nr_horas_extra_oficial = new TextBox();

    private TextBox fol_nr_salario_bruto_nao_oficial = new TextBox();

    private TextBox fol_nr_adiantamento_nao_oficial = new TextBox();

    private TextBox fol_nr_horas_extra_nao_oficial = new TextBox();

    private TextBox fol_nr_numero_funcionario = new TextBox();


    private Fol_folha_pagamentoTGWT fol_folha_pagamentoTGWT = new Fol_folha_pagamentoTGWT();
private Fol_folha_pagamentoConsultGWT consultGWT = new Fol_folha_pagamentoConsultGWT();


    public Fol_folha_pagamentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Fol_folha_pagamentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Fol_folha_pagamentoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(14, 2);
        grid.setWidget(0, 0, new Label("fol_nr_id:"));
        grid.setWidget(0, 1, fol_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("plc_nr_id:"));
        grid.setWidget(2, 1, plc_nr_id);

        grid.setWidget(3, 0, new Label("fol_nr_mes:"));
        grid.setWidget(3, 1, fol_nr_mes);

        grid.setWidget(4, 0, new Label("fol_nr_ano:"));
        grid.setWidget(4, 1, fol_nr_ano);

        grid.setWidget(5, 0, new Label("fol_tx_funcao:"));
        grid.setWidget(5, 1, fol_tx_funcao);

        grid.setWidget(6, 0, new Label("fol_nr_salario_bruto_oficial:"));
        grid.setWidget(6, 1, fol_nr_salario_bruto_oficial);

        grid.setWidget(7, 0, new Label("fol_nr_adiantamento_oficial:"));
        grid.setWidget(7, 1, fol_nr_adiantamento_oficial);

        grid.setWidget(8, 0, new Label("fol_nr_horas_extra_oficial:"));
        grid.setWidget(8, 1, fol_nr_horas_extra_oficial);

        grid.setWidget(9, 0, new Label("fol_nr_salario_bruto_nao_oficial:"));
        grid.setWidget(9, 1, fol_nr_salario_bruto_nao_oficial);

        grid.setWidget(10, 0, new Label("fol_nr_adiantamento_nao_oficial:"));
        grid.setWidget(10, 1, fol_nr_adiantamento_nao_oficial);

        grid.setWidget(11, 0, new Label("fol_nr_horas_extra_nao_oficial:"));
        grid.setWidget(11, 1, fol_nr_horas_extra_nao_oficial);

        grid.setWidget(12, 0, new Label("fol_nr_numero_funcionario:"));
        grid.setWidget(12, 1, fol_nr_numero_funcionario);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Fol_folha_pagamentoTGWT fol_folha_pagamentoTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("fol_folha_pagamentoT.fol_nr_id", fol_folha_pagamentoTGWT.getFol_nr_id() + "");

            param.put("fol_folha_pagamentoT.obr_nr_id", fol_folha_pagamentoTGWT.getObr_nr_id() + "");

            param.put("fol_folha_pagamentoT.plc_nr_id", fol_folha_pagamentoTGWT.getPlc_nr_id() + "");

            param.put("fol_folha_pagamentoT.fol_nr_mes", fol_folha_pagamentoTGWT.getFol_nr_mes() + "");

            param.put("fol_folha_pagamentoT.fol_nr_ano", fol_folha_pagamentoTGWT.getFol_nr_ano() + "");

            param.put("fol_folha_pagamentoT.fol_tx_funcao", fol_folha_pagamentoTGWT.getFol_tx_funcao() + "");

            param.put("fol_folha_pagamentoT.fol_nr_salario_bruto_oficial", fol_folha_pagamentoTGWT.getFol_nr_salario_bruto_oficial() + "");

            param.put("fol_folha_pagamentoT.fol_nr_adiantamento_oficial", fol_folha_pagamentoTGWT.getFol_nr_adiantamento_oficial() + "");

            param.put("fol_folha_pagamentoT.fol_nr_horas_extra_oficial", fol_folha_pagamentoTGWT.getFol_nr_horas_extra_oficial() + "");

            param.put("fol_folha_pagamentoT.fol_nr_salario_bruto_nao_oficial", fol_folha_pagamentoTGWT.getFol_nr_salario_bruto_nao_oficial() + "");

            param.put("fol_folha_pagamentoT.fol_nr_adiantamento_nao_oficial", fol_folha_pagamentoTGWT.getFol_nr_adiantamento_nao_oficial() + "");

            param.put("fol_folha_pagamentoT.fol_nr_horas_extra_nao_oficial", fol_folha_pagamentoTGWT.getFol_nr_horas_extra_nao_oficial() + "");

            param.put("fol_folha_pagamentoT.fol_nr_numero_funcionario", fol_folha_pagamentoTGWT.getFol_nr_numero_funcionario() + "");


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
            param.put("fol_folha_pagamentoT.fol_nr_id", fol_nr_id.getText());

            param.put("fol_folha_pagamentoT.obr_nr_id", obr_nr_id.getText());

            param.put("fol_folha_pagamentoT.plc_nr_id", plc_nr_id.getText());

            param.put("fol_folha_pagamentoT.fol_nr_mes", fol_nr_mes.getText());

            param.put("fol_folha_pagamentoT.fol_nr_ano", fol_nr_ano.getText());

            param.put("fol_folha_pagamentoT.fol_tx_funcao", fol_tx_funcao.getText());

            param.put("fol_folha_pagamentoT.fol_nr_salario_bruto_oficial", fol_nr_salario_bruto_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_adiantamento_oficial", fol_nr_adiantamento_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_horas_extra_oficial", fol_nr_horas_extra_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_salario_bruto_nao_oficial", fol_nr_salario_bruto_nao_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_adiantamento_nao_oficial", fol_nr_adiantamento_nao_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_horas_extra_nao_oficial", fol_nr_horas_extra_nao_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_numero_funcionario", fol_nr_numero_funcionario.getText());


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
            param.put("fol_folha_pagamentoT.fol_nr_id", fol_nr_id.getText());

            param.put("fol_folha_pagamentoT.obr_nr_id", obr_nr_id.getText());

            param.put("fol_folha_pagamentoT.plc_nr_id", plc_nr_id.getText());

            param.put("fol_folha_pagamentoT.fol_nr_mes", fol_nr_mes.getText());

            param.put("fol_folha_pagamentoT.fol_nr_ano", fol_nr_ano.getText());

            param.put("fol_folha_pagamentoT.fol_tx_funcao", fol_tx_funcao.getText());

            param.put("fol_folha_pagamentoT.fol_nr_salario_bruto_oficial", fol_nr_salario_bruto_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_adiantamento_oficial", fol_nr_adiantamento_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_horas_extra_oficial", fol_nr_horas_extra_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_salario_bruto_nao_oficial", fol_nr_salario_bruto_nao_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_adiantamento_nao_oficial", fol_nr_adiantamento_nao_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_horas_extra_nao_oficial", fol_nr_horas_extra_nao_oficial.getText());

            param.put("fol_folha_pagamentoT.fol_nr_numero_funcionario", fol_nr_numero_funcionario.getText());


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
              JSONObject registro = resultado.get("fol_folha_pagamento").isObject();
            
              int fol_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_id").toString()));
            fol_folha_pagamentoTGWT.setFol_nr_id(fol_nr_id);
	    this.fol_nr_id.setText(fol_folha_pagamentoTGWT.getFol_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            fol_folha_pagamentoTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setText(fol_folha_pagamentoTGWT.getObr_nr_id() + "");

            int plc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
            fol_folha_pagamentoTGWT.setPlc_nr_id(plc_nr_id);
	    this.plc_nr_id.setText(fol_folha_pagamentoTGWT.getPlc_nr_id() + "");

            int fol_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_mes").toString()));
            fol_folha_pagamentoTGWT.setFol_nr_mes(fol_nr_mes);
	    this.fol_nr_mes.setText(fol_folha_pagamentoTGWT.getFol_nr_mes() + "");

            int fol_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_ano").toString()));
            fol_folha_pagamentoTGWT.setFol_nr_ano(fol_nr_ano);
	    this.fol_nr_ano.setText(fol_folha_pagamentoTGWT.getFol_nr_ano() + "");

            String fol_tx_funcao =   (EasyContainer.clearAspas(registro.get("fol_tx_funcao").toString()));
            fol_folha_pagamentoTGWT.setFol_tx_funcao(fol_tx_funcao);
	    this.fol_tx_funcao.setText(fol_folha_pagamentoTGWT.getFol_tx_funcao() + "");

            float fol_nr_salario_bruto_oficial =  Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_salario_bruto_oficial").toString()));
            fol_folha_pagamentoTGWT.setFol_nr_salario_bruto_oficial(fol_nr_salario_bruto_oficial);
	    this.fol_nr_salario_bruto_oficial.setText(fol_folha_pagamentoTGWT.getFol_nr_salario_bruto_oficial() + "");

            float fol_nr_adiantamento_oficial =  Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_adiantamento_oficial").toString()));
            fol_folha_pagamentoTGWT.setFol_nr_adiantamento_oficial(fol_nr_adiantamento_oficial);
	    this.fol_nr_adiantamento_oficial.setText(fol_folha_pagamentoTGWT.getFol_nr_adiantamento_oficial() + "");

            float fol_nr_horas_extra_oficial =  Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_horas_extra_oficial").toString()));
            fol_folha_pagamentoTGWT.setFol_nr_horas_extra_oficial(fol_nr_horas_extra_oficial);
	    this.fol_nr_horas_extra_oficial.setText(fol_folha_pagamentoTGWT.getFol_nr_horas_extra_oficial() + "");

            float fol_nr_salario_bruto_nao_oficial =  Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_salario_bruto_nao_oficial").toString()));
            fol_folha_pagamentoTGWT.setFol_nr_salario_bruto_nao_oficial(fol_nr_salario_bruto_nao_oficial);
	    this.fol_nr_salario_bruto_nao_oficial.setText(fol_folha_pagamentoTGWT.getFol_nr_salario_bruto_nao_oficial() + "");

            float fol_nr_adiantamento_nao_oficial =  Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_adiantamento_nao_oficial").toString()));
            fol_folha_pagamentoTGWT.setFol_nr_adiantamento_nao_oficial(fol_nr_adiantamento_nao_oficial);
	    this.fol_nr_adiantamento_nao_oficial.setText(fol_folha_pagamentoTGWT.getFol_nr_adiantamento_nao_oficial() + "");

            float fol_nr_horas_extra_nao_oficial =  Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_horas_extra_nao_oficial").toString()));
            fol_folha_pagamentoTGWT.setFol_nr_horas_extra_nao_oficial(fol_nr_horas_extra_nao_oficial);
	    this.fol_nr_horas_extra_nao_oficial.setText(fol_folha_pagamentoTGWT.getFol_nr_horas_extra_nao_oficial() + "");

            int fol_nr_numero_funcionario =  Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_numero_funcionario").toString()));
            fol_folha_pagamentoTGWT.setFol_nr_numero_funcionario(fol_nr_numero_funcionario);
	    this.fol_nr_numero_funcionario.setText(fol_folha_pagamentoTGWT.getFol_nr_numero_funcionario() + "");



	    } catch (Exception e) {}		
        }

    }
}

