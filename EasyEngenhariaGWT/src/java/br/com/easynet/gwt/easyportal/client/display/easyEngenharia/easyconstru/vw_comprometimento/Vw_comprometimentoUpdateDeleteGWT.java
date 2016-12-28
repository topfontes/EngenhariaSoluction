/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_comprometimento;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
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
import com.extjs.gxt.ui.client.widget.form.TextField;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.com_comprometimento.Com_comprometimentoUpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Vw_comprometimentoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_comprometimento/vw_comprometimentoUpdateDeleteGWT.jsp";
    private TextField<String> obr_nr_id = new TextField<String>();
    private TextField<String> com_nr_mes = new TextField<String>();
    private TextField<String> com_nr_ano = new TextField<String>();
    private TextField<String> plc_nr_id = new TextField<String>();
    private TextField<String> plc_tx_nome = new TextField<String>();
    private NumberField com_nr_valor = new NumberField();
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Plc_plano_contasTGWT> comboPlc = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    ToolBar toolBar = new ToolBar();
    private Vw_comprometimentoTGWT vw_comprometimentoTGWT = new Vw_comprometimentoTGWT();
    private Vw_comprometimentoConsultGWT consultGWT = new Vw_comprometimentoConsultGWT(false);
    private boolean previsto;

    public Vw_comprometimentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_comprometimentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Vw_comprometimentoUpdateDeleteGWT(boolean previsto) {
        this.previsto = previsto;
        this.setSize("40%", "30%");
        String txt = previsto == true ? " Previsto" : " Realizado";
        this.setHeading("Alterar Comprometimento" + txt);
        this.setSize(550, 200);
        listObraGWT.povoar();
        listPlc_planoContasGWT.povoa();
        getCpMaster().setTopComponent(toolBar);
//        com_nr_valor.setFormat(NumberFormat.getFormat("#.##0.00"));

        montarTela();

        layout();
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(300);
                } else {

                    addCompToolBar();

                    Grid grid = new Grid(4, 2);

                    ListStore<Plc_plano_contasTGWT> storePlc = new ListStore<Plc_plano_contasTGWT>();

                    storePlc.add(listPlc_planoContasGWT.getList());

                    comboPlc.setStore(storePlc);

                    comboPlc.setDisplayField("plc_tx_nome");

                    comboPlc.setEmptyText("Selecione a Sub Classe");

                    comboPlc.setWidth(300);

                    comboPlc.setValue(listPlc_planoContasGWT.getTreePlc().get(vw_comprometimentoTGWT.getPlc_nr_id()));

                    grid.setWidget(1, 0, new LabelField("Sub Classe:"));

                    grid.setWidget(1, 1, comboPlc);

                    grid.setWidget(2, 0, new LabelField("Valor:"));

                    grid.setWidget(2, 1, com_nr_valor);

                    getCpMaster().add(grid);
                    layout();
                    doLayout();

                }
            }
        };
        timer.schedule(300);
        layout();

    }

    public void addCompToolBar() {

        toolBar.add(new LabelToolItem("Obra:"));
        comboObra.setStore(listObraGWT.getStore());
        comboObra.setValueField("obr_nr_id");
        comboObra.setDisplayField("obr_tx_nome");
        comboObra.setEmptyText("Selecione a obra");
        toolBar.add(comboObra);
        comboObra.setValue(listObraGWT.getTreeObra().get(vw_comprometimentoTGWT.getObr_nr_id()));
        toolBar.add(new SeparatorToolItem());

        toolBar.add(new LabelToolItem("Mês:"));
        ListStore<Meses> storemeses = new ListStore<Meses>();
        storemeses.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(storemeses);
        comboMes.setDisplayField("display");
        comboMes.setEmptyText("Selecione o Mês");
        comboMes.setWidth(110);
        comboMes.setValue(listMes_AnoGWT.getTreeMeses().get(vw_comprometimentoTGWT.getCom_nr_mes()));
        toolBar.add(comboMes);
        toolBar.add(new SeparatorToolItem());

        toolBar.add(new LabelToolItem("Ano:"));
        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(storeAno);
        comboAno.setDisplayField("display");
        comboAno.setEmptyText("Selecione o Ano");
        comboAno.setWidth(80);
        comboAno.setValue(listMes_AnoGWT.getTreeAno().get(vw_comprometimentoTGWT.getCom_nr_ano()));
        toolBar.add(comboAno);
        layout();
    }

    public void load(Vw_comprometimentoTGWT vw_comprometimentoTGWT) {
        try {
            this.vw_comprometimentoTGWT = vw_comprometimentoTGWT;
            com_nr_valor.setValue(vw_comprometimentoTGWT.getCom_nr_valor());

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
            String url = Constantes.URL + Com_comprometimentoUpdateDeleteGWT.PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");

            param.put("com_comprometimentoT.com_nr_id", vw_comprometimentoTGWT.getCom_nr_id() + "");

            param.put("com_comprometimentoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");

            param.put("com_comprometimentoT.com_nr_mes", comboMes.getValue().getValue() + "");

            param.put("com_comprometimentoT.com_nr_ano", comboAno.getValue().getValue() + "");

            param.put("com_comprometimentoT.plc_nr_id", comboPlc.getValue().getPlc_nr_id() + "");

            param.put("com_comprometimentoT.com_nr_valor", com_nr_valor.getValue() + "");

            param.put("com_comprometimentoT.previsto", previsto + "");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            //consultGWT.load();
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + Com_comprometimentoUpdateDeleteGWT.PAGE;

            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("com_comprometimentoT.com_nr_id", vw_comprometimentoTGWT.getCom_nr_id() + "");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                if (jsonValue.toString().indexOf("sucesso") > -1) {
                    getShowMsgAlteracao();
                    consultGWT.load();
                    this.close();
                }else{
                    getShowMsgErro("Erro ao tentar executar a operação");
                }
            
        }

    }
}

