/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fol_folha_pagamento;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.htf_horas_trabalha_folha.Htf_horas_trabalha_folhaInsertGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento.PlcoConsult;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.grid.RowEditor;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class Fol_folha_pagamentoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoInsertGWT.jsp";
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
    private TextField<String> fol_tx_funcao = new TextField<String>();
    private NumberField fol_nr_salario_bruto_oficial = new NumberField();
    private NumberField fol_nr_adiantamento_oficial = new NumberField();
    private NumberField fol_nr_horas_extra_oficial = new NumberField();
    private NumberField fol_nr_salario_bruto_nao_oficial = new NumberField();
    private NumberField fol_nr_adiantamento_nao_oficial = new NumberField();
    private NumberField fol_nr_horas_extra_nao_oficial = new NumberField();
    private NumberField fol_nr_numero_funcionario = new NumberField();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    //private ComboBox<Plc_plano_contasTGWT> comboSubClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Plco_plano_contas_orcamentoTGWT> comboFuncao = new ComboBox<Plco_plano_contas_orcamentoTGWT>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ListPlc_planoContasGWT listSubClasseGWT = new ListPlc_planoContasGWT();
    private NumberFormat numberFormat;
//    private FormPanel cpcadastro = new FormPanel();
    private ContentPanel cpcadastro = new ContentPanel();
    private ToolBar barOperacao = new ToolBar();
    private LayoutContainer containerOficial = new LayoutContainer();
    private LayoutContainer containerNaoOficial = new LayoutContainer();
    private FormData formData = new FormData("-50");
    private ListStore<Fol_folha_pagamentoTGWT> store;
    private RowEditor<Fol_folha_pagamentoTGWT> rowEdit;
    private com.extjs.gxt.ui.client.widget.button.Button btNew = new com.extjs.gxt.ui.client.widget.button.Button("Novo item");
    private ListStore<Plc_plano_contasTGWT> storeClasse = new ListStore<Plc_plano_contasTGWT>();
    private NumberFormat formatValue;
    private NumberFormat formatInt;
    private Fol_folha_pagamentoTGWT folhaGWTInsert;
    private Fol_folha_pagamentoTGWT fol_folha_pagamentoTGWT;
    private boolean update = false;
    private Button btnHoras = new Button("Gravar");
    private NumberField horasTrab = new NumberField();
    private Fol_Folha_pagamentoDAO ffdao = new Fol_Folha_pagamentoDAO();
    private PlcoConsult plcoConsult = new PlcoConsult();
    private boolean newInsert = false;
    private Grid<Fol_folha_pagamentoTGWT> grid;
    private ColumnModel cm;

    public Fol_folha_pagamentoInsertGWT() {
        formatValue = NumberFormat.getFormat("#,##0.00");
        formatInt = NumberFormat.getFormat("0");
        this.setHeading("Cadastro Folha Pagamento.");
        this.setWidth(1150);
        this.setHeight(400);

        getDataSOUTH().setHidden(true);

        //this.setMaximizable(true);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);

        containerOficial.setLayout(new ColumnLayout());
        containerNaoOficial.setLayout(new ColumnLayout());

        cpcadastro.setHeaderVisible(false);
        //cpcadastro.setBodyBorder(true);

        cpcadastro.setLayout(new FitLayout());

        numberFormat = NumberFormat.getFormat("#,##0.00");

        plcoConsult.consultarMDO();
        listObraGWT.povoar();
//        listSubClasseGWT.povoa();

        btNew.setIcon(ICONS.novo());
        btNew.setEnabled(false);
        btNew.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                newRow();
            }
        });

        btnHoras.setIcon(ICONS.aplicar());
        btnHoras.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                insertHorasTrabalhadas();
            }
        });


//Button deleteButton =
//new Button("Delete Selected", new SelectionListener<ButtonEvent>(){
//public void componentSelected(ButtonEvent ce) {
//rowEditor.stopEditing(false);
//rowEditor.clearState();
//BeanModel model = grid.getSelectionModel().getSelectedItem();
//if (model != null) {
//grid.getStore().remove(model);
//}
//}

//});
        createToolBar();
        createColumn();
        layout();
    }

    public void insertHorasTrabalhadas() {
        try {
            RetornoHorasTrab rht = new RetornoHorasTrab();
            EasyAccessURL eaurl = new EasyAccessURL(rht);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");
            param.put("htf_horas_trabalha_folhaT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("htf_horas_trabalha_folhaT.htf_nr_mes", comboMes.getValue().getValue() + "");
            param.put("htf_horas_trabalha_folhaT.htf_nr_ano", comboAno.getValue().getValue() + "");
            param.put("htf_horas_trabalha_folhaT.htf_nr_horas_trabalhada", horasTrab.getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + Htf_horas_trabalha_folhaInsertGWT.PAGE, param);
        } catch (Exception e) {
        }
    }

    public void addToolbarOperacao() {
        //barOperacao.removeAll();
        //this.maximize();

        barOperacao.add(new LabelToolItem("Obra:"));
        barOperacao.add(comboObra);
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new LabelToolItem("Mês:"));
        barOperacao.add(comboMes);
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new LabelToolItem("Ano:"));
        barOperacao.add(comboAno);
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        com.extjs.gxt.ui.client.widget.button.Button pesquisar = new com.extjs.gxt.ui.client.widget.button.Button("Pesquisar");
        pesquisar.setIcon(ICONS.find());
        pesquisar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                if (comboObra.getValue() != null & comboMes.getValue() != null & comboMes.getValue() != null) {
                    pesquizar(comboObra.getValue().getObr_nr_id(), comboMes.getValue().getValue(), comboAno.getValue().getValue());
                }
            }
        });

        barOperacao.add(pesquisar);
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(btNew);
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new LabelToolItem("Horas Trabalhadas no Período:"));
        horasTrab.setFormat(formatValue);
        horasTrab.setEnabled(false);
        horasTrab.addListener(Events.Change, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                btnHoras.setEnabled(true);
            }
        });
        barOperacao.add(horasTrab);
        btnHoras.setEnabled(false);
        barOperacao.add(btnHoras);
    }

    public void newRow() {

        layout();
        doLayout();
        folhaGWTInsert = new Fol_folha_pagamentoTGWT();
        folhaGWTInsert.setPlco_nr_id(0);
        folhaGWTInsert.setFol_nr_id(0);
        folhaGWTInsert.setFol_nr_numero_funcionario(1);
        rowEdit.stopEditing(false);

        store.insert(folhaGWTInsert, 0);

        rowEdit.startEditing(store.indexOf(folhaGWTInsert), true);

        newInsert = true;
    }

    @Override
    protected void onHide() {
        super.onHide();
        cpcadastro.removeAll();
    }

    public void createColumn() {
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

        ColumnConfig funcao = new ColumnConfig("plco_nr_id", "Função", 250);

        final CellEditor ceFun = new CellEditor(comboFuncao) {

            public Object preProcessValue(Object value) {
                if (value == null) {
                    return value;
                }
                Plco_plano_contas_orcamentoTGWT model = plcoConsult.getStore().findModel("plco_nr_id", value);
                comboFuncao.setValue(model);
                return model;
            }

            public Object postProcessValue(Object value) {
                if (value == null) {
                    return value;
                }
                return ((Plco_plano_contas_orcamentoTGWT) value).get("plco_nr_id");
            }
        };

        funcao.setEditor(ceFun);
        funcao.setRenderer(new GridCellRenderer() {

            public String render(ModelData model, String property, com.extjs.gxt.ui.client.widget.grid.ColumnData config, int rowIndex, int colIndex, ListStore store, Grid grid) {
                String valor = "";
                if (Integer.parseInt(model.get(property).toString()) > 0) {
                    valor = plcoConsult.getStore().findModel("plco_nr_id", model.get(property)).get("plco_tx_nome");
                }
                return valor;
            }
        });

        ColumnConfig numeroFun = new ColumnConfig("fol_nr_numero_funcionario", "N. Func.", 60);
        numeroFun.setEditor(new CellEditor(new NumberField()));
        numeroFun.setAlignment(HorizontalAlignment.RIGHT);

        ColumnConfig salarioOficial = new ColumnConfig("fol_nr_salario_bruto_oficial", "Salário", 120);
        salarioOficial.setNumberFormat(formatValue);
        salarioOficial.setEditor(new CellEditor(new NumberField()));
        salarioOficial.setAlignment(HorizontalAlignment.RIGHT);

        ColumnConfig adiantamentoOficial = new ColumnConfig("fol_nr_adiantamento_oficial", "Adiantamento não comp.", 140);
        adiantamentoOficial.setNumberFormat(formatValue);
        adiantamentoOficial.setEditor(new CellEditor(new NumberField()));
        adiantamentoOficial.setAlignment(HorizontalAlignment.RIGHT);

        ColumnConfig horaExtraOficial = new ColumnConfig("fol_nr_horas_extra_oficial", "Hr. Extra", 120);
        horaExtraOficial.setNumberFormat(formatValue);
        horaExtraOficial.setEditor(new CellEditor(new NumberField()));
        horaExtraOficial.setAlignment(HorizontalAlignment.RIGHT);

        ColumnConfig salarioNaoOficial = new ColumnConfig("fol_nr_salario_bruto_nao_oficial", "Salário", 120);
        salarioNaoOficial.setNumberFormat(formatValue);
        salarioNaoOficial.setEditor(new CellEditor(new NumberField()));
        salarioNaoOficial.setAlignment(HorizontalAlignment.RIGHT);

        ColumnConfig adiantamentoNaoOficial = new ColumnConfig("fol_nr_adiantamento_nao_oficial", "Adiantamento não comp.", 140);
        adiantamentoNaoOficial.setNumberFormat(formatValue);
        adiantamentoNaoOficial.setEditor(new CellEditor(new NumberField()));
        adiantamentoNaoOficial.setAlignment(HorizontalAlignment.RIGHT);

        ColumnConfig horaExtraNaoOficial = new ColumnConfig("fol_nr_horas_extra_nao_oficial", "Hr. Extra", 120);
        horaExtraNaoOficial.setNumberFormat(formatValue);
        horaExtraNaoOficial.setEditor(new CellEditor(new NumberField()));
        horaExtraNaoOficial.setAlignment(HorizontalAlignment.RIGHT);

        configs.add(funcao);
        configs.add(numeroFun);
        configs.add(salarioOficial);
        configs.add(adiantamentoOficial);
        configs.add(horaExtraOficial);
        configs.add(salarioNaoOficial);
        configs.add(adiantamentoNaoOficial);
        configs.add(horaExtraNaoOficial);
        cm = new ColumnModel(configs);

        cm.addHeaderGroup(0, 5, new HeaderGroupConfig("Não Oficial", 1, 3));
        cm.addHeaderGroup(0, 2, new HeaderGroupConfig("Oficial", 1, 3));



    }

    public void createToolBar() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar() || !plcoConsult.isPovoado()) {
                    schedule(500);
                } else {
                    povoaComboMes();
                    povoaComboObra();
//                    povoaSubClasse();
                    povoaFuncao();

                    povoaAno();
                    addToolbarOperacao();
                    cpcadastro.setTopComponent(barOperacao);
                    getCpMaster().add(cpcadastro);
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void povoarGrid(List<Fol_folha_pagamentoTGWT> list) {
        if (store != null) {
            store.removeAll();
            store.commitChanges();
        }

        store = new ListStore<Fol_folha_pagamentoTGWT>();
        store.add(list);

        //create
        //Window.alert("lista "+list.size());
        grid = new Grid<Fol_folha_pagamentoTGWT>(store, cm);

        rowEdit = new RowEditor<Fol_folha_pagamentoTGWT>() {

            @Override
            public void stopEditing(boolean saveChanges) {
                super.stopEditing(saveChanges);
                if (saveChanges) {
                    insertFolha();
                } else {
                    if (newInsert) {
                        store.remove(folhaGWTInsert);
                    }
                    store.commitChanges();
                }
            }
        };

        rowEdit.layout();

        horasTrab.setValue(ffdao.getQtdHoras());

        horasTrab.setEnabled(true);

        btNew.setEnabled(true);

        grid.addPlugin(rowEdit);
        grid.setStripeRows(true);
        grid.setBorders(true);
        grid.setAutoExpandColumn("subClasse");

        cpcadastro.removeAll();
        cpcadastro.layout();
        layout();
        cpcadastro.add(grid);
        cpcadastro.layout();
        layout();
        doLayout();


    }

    public void pesquizar(int obr_nr_id, int mes, int ano) {
        ffdao.getAll(obr_nr_id, mes, ano);
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!ffdao.isPovoado()) {
                    schedule(1000);
                } else {
                    povoarGrid(ffdao.getList());
                }
            }
        };
        timer.schedule(500);
    }

    public void povoaComboMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(store);
        comboMes.setDisplayField("display");
        comboMes.setFieldLabel("Mês");
        comboMes.setAllowBlank(true);
        comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboMes.setWidth(100);
    }

    public void povoaAno() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(store);
        comboAno.setAllowBlank(true);
        comboAno.setDisplayField("display");
        comboAno.setFieldLabel("Ano");
        comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboAno.setWidth(80);
    }

    public void povoaComboObra() {
        try {
            comboObra.setStore(listObraGWT.getStore());
            comboObra.setDisplayField("obr_tx_nome");
            comboObra.setAllowBlank(true);
            comboObra.setAllowBlank(false);
            comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
            comboObra.setWidth("250");
        } catch (Exception e) {
        }
    }

//    public void povoaSubClasse() {
//        try {
//            comboSubClasse.setStore(listSubClasseGWT.getStore());
//            comboSubClasse.setAllowBlank(true);
//            comboSubClasse.setDisplayField("plc_tx_nome");
//            comboSubClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
//            comboSubClasse.setWidth(150);
//        } catch (Exception e) {
//        }
//    }
    public void povoaFuncao() {
        try {
            comboFuncao.setStore(plcoConsult.getStoreFormatado());
            comboFuncao.setAllowBlank(true);
            comboFuncao.setDisplayField("plco_tx_nome");
            comboFuncao.setTriggerAction(ComboBox.TriggerAction.ALL);
            comboFuncao.setWidth(248);
            ///comboFuncao.setTemplate(getTemplate());
            //comboFuncao.seta
        } catch (Exception e) {
        }
    }

    private native String getTemplate() /*-{
    return [
    '<tpl for="."><div>',
    '<h3><span>{plco_tx_nome}<br /></span></h3>',
    '</div></tpl>'
    ].join("");
    }-*/;

    private boolean folhaValida(List<Record> list) {
        boolean res = true;
        float total = 0;

        Fol_folha_pagamentoTGWT fol_folha_TGWT = (Fol_folha_pagamentoTGWT) list.get(0).getModel();
        if (list.get(0).get("plco_nr_id") == null) {
            res = false;
            getShowMsgErro("O campo Função tem preenchimento obrigatório");
        } else if (list.get(0).get("fol_nr_numero_funcionario") == null) {
            res = false;
            getShowMsgErro("O campo N° de Funcionários tem preenchimento obrigatório!");
        } else {

            if (store.getModifiedRecords().get(0).getModel().get("fol_nr_salario_bruto_oficial") != null) {
                total += Float.parseFloat(list.get(0).get("fol_nr_salario_bruto_oficial").toString());
            }

            if (store.getModifiedRecords().get(0).getModel().get("fol_nr_adiantamento_oficial") != null) {
                total += Float.parseFloat(list.get(0).get("fol_nr_adiantamento_oficial").toString());
            }

            if (store.getModifiedRecords().get(0).getModel().get("fol_nr_horas_extra_oficial") != null) {
                total += Float.parseFloat(list.get(0).get("fol_nr_horas_extra_oficial").toString());
            }

            if (store.getModifiedRecords().get(0).getModel().get("fol_nr_salario_bruto_nao_oficial") != null) {
                total += Float.parseFloat(list.get(0).get("fol_nr_salario_bruto_nao_oficial").toString());
            }

            if (store.getModifiedRecords().get(0).getModel().get("fol_nr_adiantamento_nao_oficial") != null) {
                total += Float.parseFloat(list.get(0).get("fol_nr_adiantamento_nao_oficial").toString());
            }

            if (store.getModifiedRecords().get(0).getModel().get("fol_nr_horas_extra_nao_oficial") != null) {
                total += Float.parseFloat(list.get(0).get("fol_nr_horas_extra_nao_oficial").toString());
            }
            if (total == 0) {
                res = false;
                getShowMsgErro("A soma dos salarios adiantamentos e Hrs. extras está zerado");
            }

        }
        return res;
    }

    private void insertFolha() {
        try {
            HashMap<String, String> param = new HashMap<String, String>();
            String operacao = "insert";
            fol_folha_pagamentoTGWT = new Fol_folha_pagamentoTGWT();
            update = false;
            newInsert = false;

            if (store.getModifiedRecords() != null) {
                if (folhaValida(store.getModifiedRecords())) {
                    fol_folha_pagamentoTGWT = (Fol_folha_pagamentoTGWT) store.getModifiedRecords().get(0).getModel();

                    if (fol_folha_pagamentoTGWT.getFol_nr_id() > 0) {
                        param.put("fol_folha_pagamentoT.fol_nr_id", fol_folha_pagamentoTGWT.getFol_nr_id() + "");
                        update = true;
                        operacao = "update";
                    }

                    if (store.getModifiedRecords().get(0).getModel().get("fol_nr_numero_funcionario") != null) {
                        param.put("fol_folha_pagamentoT.fol_nr_numero_funcionario", store.getModifiedRecords().get(0).getModel().get("fol_nr_numero_funcionario").toString());
                    } 

                    if (store.getModifiedRecords().get(0).getModel().get("fol_nr_salario_bruto_oficial") != null) {
                        param.put("fol_folha_pagamentoT.fol_nr_salario_bruto_oficial", store.getModifiedRecords().get(0).getModel().get("fol_nr_salario_bruto_oficial").toString());
                    }

                    if (store.getModifiedRecords().get(0).getModel().get("fol_nr_adiantamento_oficial") != null) {
                        param.put("fol_folha_pagamentoT.fol_nr_adiantamento_oficial", store.getModifiedRecords().get(0).getModel().get("fol_nr_adiantamento_oficial").toString());
                    }

                    if (store.getModifiedRecords().get(0).getModel().get("fol_nr_horas_extra_oficial") != null) {
                        param.put("fol_folha_pagamentoT.fol_nr_horas_extra_oficial", store.getModifiedRecords().get(0).getModel().get("fol_nr_horas_extra_oficial").toString());
                    }

                    if (store.getModifiedRecords().get(0).getModel().get("fol_nr_salario_bruto_nao_oficial") != null) {
                        param.put("fol_folha_pagamentoT.fol_nr_salario_bruto_nao_oficial", store.getModifiedRecords().get(0).getModel().get("fol_nr_salario_bruto_nao_oficial").toString());
                    }

                    if (store.getModifiedRecords().get(0).getModel().get("fol_nr_adiantamento_nao_oficial") != null) {
                        param.put("fol_folha_pagamentoT.fol_nr_adiantamento_nao_oficial", store.getModifiedRecords().get(0).getModel().get("fol_nr_adiantamento_nao_oficial").toString());
                    }

                    if (store.getModifiedRecords().get(0).getModel().get("fol_nr_horas_extra_nao_oficial") != null) {
                        param.put("fol_folha_pagamentoT.fol_nr_horas_extra_nao_oficial", store.getModifiedRecords().get(0).getModel().get("fol_nr_horas_extra_nao_oficial").toString());
                    }
                    String url = Constantes.URL + PAGE;
                    if (update) {
                        url = Constantes.URL + Fol_folha_pagamentoUpdateDeleteGWT.PAGE;//"portalgwt/exemplos/cadastro.jsp";
                    }
                    param.put("op", operacao);
                    param.put("fol_folha_pagamentoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
                    param.put("fol_folha_pagamentoT.plco_nr_id", fol_folha_pagamentoTGWT.getPlco_nr_id() + "");
                    param.put("fol_folha_pagamentoT.fol_nr_mes", comboMes.getValue().getValue() + "");
                    param.put("fol_folha_pagamentoT.fol_nr_ano", comboAno.getValue().getValue() + "");

                    Retorno r = new Retorno();
                    EasyAccessURL eaurl = new EasyAccessURL(r);
                    eaurl.accessJSonMap(url, param);
                } else {
                    if (!update) {
                        store.remove(folhaGWTInsert);
                        store.commitChanges();
                    } else {
                        store.commitChanges();
                    }
                }
            }

        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            Window.alert("Result " + jsonObject.get("resultado").toString());
        }
    }

    class Retorno implements IListenetResponse {

        private JSONObject jsonObject;

        public void read(JSONValue jsonValue) {
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                //folhaGWTInsert = null;
                if (jsonValue.toString().indexOf("sucesso") > -1) {
                    Info.display("", "Operação efetuado com sucesso");
                    if (!update) {
                        JSONArray resultado = jsonObject.get("resultado").isArray();
                        JSONObject registro = resultado.get(1).isObject();
                        int id = Integer.parseInt(EasyContainer.clearAspas(registro.get("id").toString()));
//                        Window.alert(id +" id");

                        fol_folha_pagamentoTGWT.setFol_nr_id(id);
                        newInsert = false;
                        update = false;
                        rowEdit.layout();
                        store.commitChanges();
                        newRow();
                    } else {
                        store.commitChanges();
                    }
                    layout();
                    doLayout();
                }
            }
        }
    }

    class RetornoHorasTrab implements IListenetResponse {

        private JSONObject jsonObject;

        public void read(JSONValue jsonValue) {
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                if (jsonValue.toString().indexOf("sucesso") > -1) {
                    getShowMsgCadastro();
                } else {
                    getShowMsgErro("Erro ao realizar a operação");
                }
            }
        }
    }
}
