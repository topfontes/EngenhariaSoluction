/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fol_folha_pagamento;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class Fol_folha_pagamentoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Fol_folha_pagamentoConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ToolBar barOperacao = new ToolBar();
    private NumberField horasTrab = new NumberField();

    public Fol_folha_pagamentoConsultGWT() {
        try {
            listObraGWT.povoar();
            this.setHeading("Folha de Pagamento");
            cp.setHeaderVisible(false);
            cp.setLayout(new FillLayout());
            this.setMaximizable(true);
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("#,##0.00");
            final NumberCellRenderer<Grid<Fol_folha_pagamentoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Fol_folha_pagamentoTGWT>>(currency);

            horasTrab.setFormat(number);
            ColumnConfig column = null;

            SummaryColumnConfig<Double> subClasse = new SummaryColumnConfig<Double>("subClasse", "Sub-Classe", 200);
            SummaryColumnConfig<Double> funcao = new SummaryColumnConfig<Double>("fol_tx_funcao", "Funcão", 200);

            SummaryColumnConfig<Integer> n_funcionario = new SummaryColumnConfig<Integer>("fol_nr_numero_funcionario", "N. Funcionários", 70);
            n_funcionario.setSummaryType(SummaryType.COUNT);
            n_funcionario.setAlignment(HorizontalAlignment.RIGHT);
            n_funcionario.setSummaryRenderer(new SummaryRenderer() {

                public String render(Number value, Map<String, Number> data) {
                    return value.intValue() > 1 ? "(" + value.intValue() + " Items) Sub Total" : "(1 Item) Sub Total";
                }
            });

            SummaryColumnConfig<Double> salario_ofi = new SummaryColumnConfig<Double>("fol_nr_salario_bruto_oficial", "Salário", 75);
            salario_ofi.setSummaryType(SummaryType.SUM);
            salario_ofi.setNumberFormat(number);
            salario_ofi.setAlignment(HorizontalAlignment.RIGHT);
            salario_ofi.setSummaryFormat(number);

            SummaryColumnConfig<Double> adinatamento_ofi = new SummaryColumnConfig<Double>("fol_nr_adiantamento_oficial", "Adiantamento não comp.", 100);
            adinatamento_ofi.setSummaryType(SummaryType.SUM);
            adinatamento_ofi.setNumberFormat(number);
            adinatamento_ofi.setAlignment(HorizontalAlignment.RIGHT);
            adinatamento_ofi.setSummaryFormat(number);

            SummaryColumnConfig<Double> hora_extra_ofi = new SummaryColumnConfig<Double>("fol_nr_horas_extra_oficial", "Hr. Extra", 75);
            hora_extra_ofi.setSummaryType(SummaryType.SUM);
            hora_extra_ofi.setNumberFormat(number);
            hora_extra_ofi.setSummaryFormat(number);
            hora_extra_ofi.setAlignment(HorizontalAlignment.RIGHT);

            SummaryColumnConfig<Double> salario_n_ofi = new SummaryColumnConfig<Double>("fol_nr_salario_bruto_nao_oficial", "Salário", 75);
            salario_n_ofi.setSummaryType(SummaryType.SUM);
            salario_n_ofi.setNumberFormat(number);
            salario_n_ofi.setAlignment(HorizontalAlignment.RIGHT);
            salario_n_ofi.setSummaryFormat(number);

            SummaryColumnConfig<Double> adiantamento_n_ofi = new SummaryColumnConfig<Double>("fol_nr_adiantamento_nao_oficial", "Adiantamento não comp.", 100);
            adiantamento_n_ofi.setSummaryType(SummaryType.SUM);
            adiantamento_n_ofi.setNumberFormat(number);
            adiantamento_n_ofi.setAlignment(HorizontalAlignment.RIGHT);
            adiantamento_n_ofi.setSummaryFormat(number);

            SummaryColumnConfig<Double> hora_extra_n_ofi = new SummaryColumnConfig<Double>("fol_nr_horas_extra_nao_oficial", "Hr. Extra", 75);
            hora_extra_n_ofi.setSummaryType(SummaryType.SUM);
            hora_extra_n_ofi.setNumberFormat(number);
            hora_extra_n_ofi.setAlignment(HorizontalAlignment.RIGHT);
            hora_extra_n_ofi.setSummaryFormat(number);


            GridCellRenderer<Fol_folha_pagamentoTGWT> btnDel = new GridCellRenderer<Fol_folha_pagamentoTGWT>() {

                private boolean init;

                public Object render(final Fol_folha_pagamentoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Fol_folha_pagamentoTGWT> store, Grid<Fol_folha_pagamentoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Fol_folha_pagamentoTGWT>>() {

                            public void handleEvent(GridEvent<Fol_folha_pagamentoTGWT> be) {
                                for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                    if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                            && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                        ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                    }
                                }
                            }
                        });
                    }

                    Button btnCol = new Button("", new SelectionListener<ButtonEvent>() {

                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            try {
                                EasyAccessURL eaurl = new EasyAccessURL(consultGWT);
                                HashMap<String, String> param = new HashMap<String, String>();
                                param.put("op", "delete");
                                param.put("fol_folha_pagamentoT.fol_nr_id", model.getFol_nr_id() + "");
                                eaurl.accessJSonMap(Constantes.URL + PAGE, param);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });

                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Deletar");
                    btnCol.setBorders(false);
                    btnCol.setBounds(0, 0, 0, 0);
                    btnCol.setIcon(ICONS.del());
                    return btnCol;
                }
            };

            configs.add(subClasse);
            configs.add(funcao);
            configs.add(n_funcionario);
            configs.add(salario_ofi);
            configs.add(adinatamento_ofi);
            configs.add(hora_extra_ofi);
            configs.add(salario_n_ofi);
            configs.add(adiantamento_n_ofi);
            configs.add(hora_extra_n_ofi);

            SummaryColumnConfig<Double> del = new SummaryColumnConfig<Double>();
            del.setId("del");
            del.setHeader("");
            del.setWidth(30);
            del.setAlignment(HorizontalAlignment.LEFT);
            del.setRenderer(btnDel);
            configs.add(del);

            montarTela();
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
    }

    @Override
    protected void onHide() {
        super.onHide();
        cp.removeAll();

    }

    public void montarTela() {
        com.google.gwt.user.client.Timer t = new com.google.gwt.user.client.Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(1000);
                } else {
                    povoaComboObra();
                    povoaComboMes();
                    povoaAno();
                    addToolbarOperacao();
                    cp.setTopComponent(barOperacao);
                    getCpMaster().add(cp);
                    maximize();
                    layout();
                    doLayout();
                }

            }
        };
        t.schedule(1000);
    }

    public void povoaComboMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(store);
        comboMes.setDisplayField("display");
        comboMes.setFieldLabel("Mês");
        comboMes.setAllowBlank(false);
        comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboMes.setWidth(100);
    }

    public void povoaAno() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(store);
        comboAno.setAllowBlank(false);
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

    public void addToolbarOperacao() {
        //barOperacao.removeAll();
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
        pesquisar.setIcon(ICONS.filter());
        pesquisar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                if (comboObra.getValue() != null & comboMes.getValue() != null & comboMes.getValue() != null) {
                    load();
                }
            }
        });

        barOperacao.add(pesquisar);
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new SeparatorToolItem());
        barOperacao.add(new LabelToolItem("Horas Trabalhadas no Período:"));
        barOperacao.add(horasTrab);
        horasTrab.setEnabled(false);


    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            List<Fol_folha_pagamentoTGWT> list = new Vector();
            for (int i = 1; i < resultado.size() - 1; i++) {
                Fol_folha_pagamentoTGWT fol_folha_pagamentoTGWT = new Fol_folha_pagamentoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer fol_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_id").toString()));
                fol_folha_pagamentoTGWT.setFol_nr_id(fol_nr_id);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                fol_folha_pagamentoTGWT.setObr_nr_id(obr_nr_id);

                Integer fol_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_mes").toString()));
                fol_folha_pagamentoTGWT.setFol_nr_mes(fol_nr_mes);

                Integer fol_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_ano").toString()));
                fol_folha_pagamentoTGWT.setFol_nr_ano(fol_nr_ano);

                String fol_tx_funcao = EasyContainer.clearAspas(registro.get("fol_tx_funcao").toString());
                fol_folha_pagamentoTGWT.setFol_tx_funcao(fol_tx_funcao);

                String classe = EasyContainer.clearAspas(registro.get("classe").toString());
                fol_folha_pagamentoTGWT.setClasse(classe);

                String subClasse = EasyContainer.clearAspas(registro.get("subClasse").toString());
                fol_folha_pagamentoTGWT.setSubClasse(subClasse);


                float fol_nr_salario_bruto_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_salario_bruto_oficial").toString()));
                if (fol_nr_salario_bruto_oficial > 0) {
                    fol_folha_pagamentoTGWT.setFol_nr_salario_bruto_oficial(fol_nr_salario_bruto_oficial);
                }

                float fol_nr_adiantamento_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_adiantamento_oficial").toString()));
                if (fol_nr_adiantamento_oficial > 0) {
                    fol_folha_pagamentoTGWT.setFol_nr_adiantamento_oficial(fol_nr_adiantamento_oficial);
                }

                float fol_nr_horas_extra_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_horas_extra_oficial").toString()));
                if (fol_nr_horas_extra_oficial > 0) {
                    fol_folha_pagamentoTGWT.setFol_nr_horas_extra_oficial(fol_nr_horas_extra_oficial);
                }

                float fol_nr_salario_bruto_nao_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_salario_bruto_nao_oficial").toString()));
                if (fol_nr_salario_bruto_nao_oficial > 0) {
                    fol_folha_pagamentoTGWT.setFol_nr_salario_bruto_nao_oficial(fol_nr_salario_bruto_nao_oficial);
                }

                float fol_nr_adiantamento_nao_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_adiantamento_nao_oficial").toString()));
                if (fol_nr_adiantamento_nao_oficial > 0) {
                    fol_folha_pagamentoTGWT.setFol_nr_adiantamento_nao_oficial(fol_nr_adiantamento_nao_oficial);
                }

                float fol_nr_horas_extra_nao_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_horas_extra_nao_oficial").toString()));
                if (fol_nr_horas_extra_nao_oficial > 0) {
                    fol_folha_pagamentoTGWT.setFol_nr_horas_extra_nao_oficial(fol_nr_horas_extra_nao_oficial);
                }

                Integer fol_nr_numero_funcionario = Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_numero_funcionario").toString()));
                if (fol_nr_numero_funcionario > 0) {
                    fol_folha_pagamentoTGWT.setFol_nr_numero_funcionario(fol_nr_numero_funcionario);
                }
                list.add(fol_folha_pagamentoTGWT);
            }
            JSONObject registro = resultado.get(resultado.size() - 1).isObject();
            horasTrab.setValue(Float.parseFloat(EasyContainer.clearAspas(registro.get("horas").toString())));


            ColumnModel cm = new ColumnModel(configs);

            GroupingStore<Fol_folha_pagamentoTGWT> store = new GroupingStore<Fol_folha_pagamentoTGWT>();
            store.add(list);
            store.groupBy("subClasse");

            GroupSummaryView view = new GroupSummaryView();
            view.setForceFit(true);
            view.setShowGroupedColumn(false);

            AggregationRowConfig<Fol_folha_pagamentoTGWT> agg_Salario_ofi = new AggregationRowConfig<Fol_folha_pagamentoTGWT>();
            agg_Salario_ofi.setSummaryType("fol_nr_salario_bruto_oficial", SummaryType.SUM);
            agg_Salario_ofi.setSummaryFormat("fol_nr_salario_bruto_oficial", NumberFormat.getFormat("#,##0.00"));
            cm.addAggregationRow(agg_Salario_ofi);

            agg_Salario_ofi.setSummaryType("fol_nr_adiantamento_oficial", SummaryType.SUM);
            agg_Salario_ofi.setSummaryFormat("fol_nr_adiantamento_oficial", NumberFormat.getFormat("#,##0.00"));

            agg_Salario_ofi.setSummaryType("fol_nr_horas_extra_oficial", SummaryType.SUM);
            agg_Salario_ofi.setSummaryFormat("fol_nr_horas_extra_oficial", NumberFormat.getFormat("#,##0.00"));

            agg_Salario_ofi.setSummaryType("fol_nr_salario_bruto_nao_oficial", SummaryType.SUM);
            agg_Salario_ofi.setSummaryFormat("fol_nr_salario_bruto_na_oficial", NumberFormat.getFormat("#,##0.00"));

            agg_Salario_ofi.setSummaryType("fol_nr_salario_bruto_nao_oficial", SummaryType.SUM);
            agg_Salario_ofi.setSummaryFormat("fol_nr_salario_bruto_nao_oficial", NumberFormat.getFormat("#,##0.00"));

            agg_Salario_ofi.setSummaryType("fol_nr_horas_extra_nao_oficial", SummaryType.SUM);
            agg_Salario_ofi.setSummaryFormat("fol_nr_horas_extra_nao_oficial", NumberFormat.getFormat("#,##0.00"));


            cm.addHeaderGroup(0, 6, new HeaderGroupConfig("Não Oficial", 1, 3));
            cm.addHeaderGroup(0, 3, new HeaderGroupConfig("Oficial", 1, 3));

            Grid<Fol_folha_pagamentoTGWT> grid = new Grid<Fol_folha_pagamentoTGWT>(store, cm);
            grid.setView(view);
            grid.setLoadMask(true);
            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);
            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            cp.removeAll();
            cp.add(grid);

            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Fol_folha_pagamentoInsertGWT insert;
        try {
            insert = new Fol_folha_pagamentoInsertGWT();
            insert.setConsultGWT(consultGWT);
            insert.setModal(true);
            insert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("fol_folha_pagamentoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("fol_folha_pagamentoT.fol_nr_mes", comboMes.getValue().getValue() + "");
            param.put("fol_folha_pagamentoT.fol_nr_ano", comboAno.getValue().getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);

            cp.removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

