/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inc_informacoes_custo;

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
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;

/**
 *
 * @author geoleite
 */
public class Inc_informacoes_custoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDeleteGWT.jsp";
    private TextField<String> inc_nr_id = new TextField<String>();
    public TextField<String> obr_nr_id = new TextField<String>();
    public TextField<String> inc_nes_nr_id = new TextField<String>();
    public TextField<String> inc_nr_ano = new TextField<String>();
    public TextField<String> plc_nr_id = new TextField<String>();
    private TextField<String> inc_tx_custo_acumulado = new TextField<String>();
    private TextField<String> inc_nr_custo_periodo = new TextField<String>();
    private TextField<String> inc_tx_calsas = new TextField<String>();
    private TextField<String> inc_tx_problemas = new TextField<String>();
    private TextField<String> inc_tx_acoes = new TextField<String>();
    private TextField<String> inc_tx_responsavel = new TextField<String>();
    private DateField inc_dt_prazo = new DateField();
    DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
    private Inc_informacoes_custoTGWT inc_informacoes_custoTGWT = new Inc_informacoes_custoTGWT();
    private Inc_informacoes_custoConsultGWT consultGWT = new Inc_informacoes_custoConsultGWT();

    public Inc_informacoes_custoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Inc_informacoes_custoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Inc_informacoes_custoUpdateDeleteGWT() {
        this.setSize(500, 230);
        this.setHeading("Alterar informações custos");
        this.setSize(500, 300);

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(4);
        getCpMaster().setLayout(layout);

        getCpMaster().add(new LabelField("Calsas:"));
        getCpMaster().add(inc_tx_calsas);
        inc_tx_calsas.setWidth("300");

        getCpMaster().add(new LabelField("Problemas:"));
        getCpMaster().add(inc_tx_problemas);
        inc_tx_problemas.setWidth("300");

        getCpMaster().add(new LabelField("Ações:"));
        getCpMaster().add(inc_tx_acoes);
        inc_tx_acoes.setWidth("300");

        getCpMaster().add(new LabelField("Responsável:"));
        getCpMaster().add(inc_tx_responsavel);
        inc_tx_responsavel.setWidth("300");

        getCpMaster().add(new LabelField("Prazo:"));
        getCpMaster().add(inc_dt_prazo);
        layout();
    }

    public void load(Inc_informacoes_custoTGWT inc_informacoes_custoTGWT) {
        try {
            this.obr_nr_id.setValue(inc_informacoes_custoTGWT.getObr_nr_id() + "");

            this.inc_nes_nr_id.setValue(inc_informacoes_custoTGWT.getInc_nr_mes() + "");

            this.inc_nr_ano.setValue(inc_informacoes_custoTGWT.getInc_nr_ano() + "");

            this.plc_nr_id.setValue(inc_informacoes_custoTGWT.getPlc_nr_id() + "");

            this.inc_tx_custo_acumulado.setValue(inc_informacoes_custoTGWT.getInc_tx_custo_acumulado() + "");

            this.inc_nr_custo_periodo.setValue(inc_informacoes_custoTGWT.getInc_nr_custo_periodo() + "");

            this.inc_tx_calsas.setValue(inc_informacoes_custoTGWT.getInc_tx_calsas() + "");

            this.inc_tx_problemas.setValue(inc_informacoes_custoTGWT.getInc_tx_problemas() + "");

            this.inc_tx_acoes.setValue(inc_informacoes_custoTGWT.getInc_tx_acoes() + "");

            this.inc_tx_responsavel.setValue(inc_informacoes_custoTGWT.getInc_tx_responsavel() + "");

            this.inc_dt_prazo.setValue(inc_informacoes_custoTGWT.getInc_dt_prazo());

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
            param.put("inc_informacoes_custoT.inc_nr_id", inc_informacoes_custoTGWT.getInc_nr_id()+"");

            param.put("inc_informacoes_custoT.obr_nr_id", obr_nr_id.getValue());

            param.put("inc_informacoes_custoT.inc_nes_nr_id", inc_nes_nr_id.getValue());

            param.put("inc_informacoes_custoT.inc_nr_ano", inc_nr_ano.getValue());

            param.put("inc_informacoes_custoT.plc_nr_id", plc_nr_id.getValue());

            param.put("inc_informacoes_custoT.inc_tx_custo_acumulado", inc_tx_custo_acumulado.getValue());

            param.put("inc_informacoes_custoT.inc_nr_custo_periodo", inc_nr_custo_periodo.getValue());

            param.put("inc_informacoes_custoT.inc_tx_calsas", inc_tx_calsas.getValue());

            param.put("inc_informacoes_custoT.inc_tx_problemas", inc_tx_problemas.getValue());

            param.put("inc_informacoes_custoT.inc_tx_acoes", inc_tx_acoes.getValue());

            param.put("inc_informacoes_custoT.inc_tx_responsavel", inc_tx_responsavel.getValue());

            param.put("inc_informacoes_custoT.inc_dt_prazo", dtf.format(inc_dt_prazo.getValue()));

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
            param.put("inc_informacoes_custoT.inc_nr_id", inc_nr_id.getValue());

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
                consultGWT.load();
                close();
            }
            try {
            } catch (Exception e) {
            }
        }

    }
}
