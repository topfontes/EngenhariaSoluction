/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eqi_equivalencia_insumo.Eqi_equivalencia_insumoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eqi_equivalencia_insumo.Eqi_equivalencia_insumoInsertGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eqi_equivalencia_insumo.Eqi_equivalencia_insumoUpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ina_insumo_antigo.Ina_insumo_antigoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento.List_plco_plano_contas_orcamentoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento.PlcoConsult;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Eqi_equivalencia_insumoTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Ina_insumo_antigoTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Inn_insumo_novoTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plco_plano_contas_orcamentoTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Vw_equivalenciaTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_equivalencia.Vw_equivalenciaConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_equivalencia.Vw_equivalenciaInsertGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.dnd.GridDragSource;
import com.extjs.gxt.ui.client.dnd.GridDropTarget;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.ListBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author marcos
 */
public class EquivalenciaInsumoGWT extends Window implements IListenetResponse {

    private ListBox listSubClasse = new ListBox();
    private LayoutContainer container = new LayoutContainer();
    private List<Plco_plano_contas_orcamentoTGWT> listPlco = new ArrayList<Plco_plano_contas_orcamentoTGWT>();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private ListBox listPlc = new ListBox();
    final ComboBox<Inn_insumo_novoTGWT> comboPlc = new ComboBox<Inn_insumo_novoTGWT>();
    private List<Inn_insumo_novoTGWT> listaPlc = new ArrayList<Inn_insumo_novoTGWT>();
    ListStore<Inn_insumo_novoTGWT> storeCombo = new ListStore<Inn_insumo_novoTGWT>();
    private GridDropTarget target;
    private GridDropTarget target2;
    ContentPanel cpBotton = new ContentPanel();
    ContentPanel cpResult = new ContentPanel();
    final EquivalenciaInsumoGWT consultGWT = this;
    HashMap<String, String> mapEquivalencia;
    List_plco_plano_contas_orcamentoGWT list_plco_plano_contas_orcamentoGWT = new List_plco_plano_contas_orcamentoGWT();
    PlcoConsult plcoConsult = new PlcoConsult();
    ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    final ListStore<Ina_insumo_antigoTGWT> store2 = new ListStore<Ina_insumo_antigoTGWT>();
    ContentPanel cpPlco = new ContentPanel();
    Grid<Ina_insumo_antigoTGWT> grid;
    private ComboBox<Inn_insumo_novoTGWT> comboFilterPlc = new ComboBox<Inn_insumo_novoTGWT>();
    private ListStore<Ina_insumo_antigoTGWT> store = new ListStore<Ina_insumo_antigoTGWT>();
    private StoreFilterField<Ina_insumo_antigoTGWT> storefilter;
    private ToolBar toolBarTop = new ToolBar();
    private FormPanel formbinding = new FormPanel();
    private TextArea areaplco = new TextArea();
    listInaGWT inaDaoGWT = new listInaGWT();
//    ListInnGWT listInnDaoGWT = new ListInnGWT();
    private TextField<String> tx_locate = new TextField<String>();
    private TextField<String> tx_locate2 = new TextField<String>();

    public EquivalenciaInsumoGWT() {
        this.setHeading("Equivalêcias");

        inaDaoGWT.povoa();

//        listInnDaoGWT.povoa();
        setSize(950, 490);
        mapEquivalencia = new HashMap<String, String>();

        storefilter = new StoreFilterField<Ina_insumo_antigoTGWT>() {

            @Override
            protected boolean doSelect(Store<Ina_insumo_antigoTGWT> store, Ina_insumo_antigoTGWT parent, Ina_insumo_antigoTGWT record, String property, String filter) {
                String name = record.get("ina_tx_descricao");
                name = name.toLowerCase();
                layout();
                if (name.startsWith(filter.toLowerCase())) {
                    return true;
                }
                return false;

            }
        };
        storefilter.setWidth(200);
        storefilter.bind(store);

        toolBarTop.add(new LabelToolItem("Filtrar"));
        toolBarTop.add(storefilter);
        toolBarTop.add(new FillToolItem());
        Button button = new Button("Download", ICONS.download());
        button.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                Window window = new Window();
                window.setSize(100, 100);
                LabelField label = new LabelField();
                String page = Constantes.URL+"easyEngenharia/easyconstru/ina_insumo_antigo/gerar_xlsinsumo.jsp?op=gerarArquivoXls";
                label.setText("<a href ="+page+"> Download <a/>");
                window.add(label);
                window.show();

            }
        });
        toolBarTop.add(button);

        areaplco.setName("ina_tx_descricao");
        formbinding.add(areaplco);

        KeyListener kl = new KeyListener() {

            @Override
            public void componentKeyPress(ComponentEvent event) {
                if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
                    if (tx_locate.getValue() != null & tx_locate.getValue().length() > 1) {
                        loadInn(tx_locate.getValue());
                    }
                }
            }
        };
        tx_locate.setEmptyText("Inf. parte do nome");
        tx_locate.setWidth(80);
        tx_locate.addKeyListener(kl);

        KeyListener kl2 = new KeyListener() {

            @Override
            public void componentKeyPress(ComponentEvent event) {
                if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
                    if (tx_locate2.getValue() != null & tx_locate2.getValue().length() > 3) {
                        loadInn2(tx_locate2.getValue());
                    }
                }
            }
        };
        tx_locate2.setEmptyText("Inf. parte do nome");
        tx_locate2.setWidth(80);
        tx_locate2.addKeyListener(kl2);


        montar();
    }

    public void loadInn(String descricao) {
        final ListInnGWT listInnDaoGWT = new ListInnGWT();
        listInnDaoGWT.povoa(descricao);
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listInnDaoGWT.povoado) {
                    schedule(500);
                } else {
                    comboPlc.setEmptyText("selecione insumo");
                    comboPlc.getStore().removeAll();
                    comboPlc.getListView().getStore().removeAll();
                    comboPlc.getListView().getStore().add(listInnDaoGWT.list);
                    comboPlc.getListView().refresh();
                    if (listInnDaoGWT.list.size() == 1) {
                        comboPlc.setValue(listInnDaoGWT.list.get(0));
                    } else {
                        comboPlc.setExpanded(true);
                        comboPlc.expand();
                    }
                    comboPlc.focus();
                }
            }
        };
        timer.schedule(10);
    }
 
    public void loadInn2(String descricao) {
        final ListInnGWT listInnDaoGWT = new ListInnGWT();
        listInnDaoGWT.povoa(descricao);
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listInnDaoGWT.povoado) {
                    schedule(500);
                } else {

                    comboFilterPlc.setEmptyText("ver equivalencia do insumo");
                    comboFilterPlc.getStore().removeAll();
                    comboFilterPlc.getStore().add(listInnDaoGWT.list);
                    comboFilterPlc.getListView().refresh();
                    comboFilterPlc.getListView().getStore().removeAll();
                    comboFilterPlc.getListView().getStore().add(listInnDaoGWT.list);
                    //com.google.gwt.user.client.Window.alert(""+listInnDaoGWT.list.size());
                    if (listInnDaoGWT.list.size() == 1) {
                        comboFilterPlc.setValue(listInnDaoGWT.list.get(0));
                    } else {
                        comboFilterPlc.setExpanded(true);
                        comboFilterPlc.expand();
                    }
                    comboFilterPlc.focus();
                }
            }
        };
        timer.schedule(10);
    }

    public void montar() {
        if (this.getItems().size() > 0) {
            this.removeAll();
        }
        final boolean vali = true;
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!inaDaoGWT.povoado) {
                    schedule(500);
                } else {
                    Timer timerPlc = new Timer() {

                        @Override
                        public void run() {
                            if (!vali) {
                                schedule(500);
                            } else {
                                TableLayout tableLayout = new TableLayout(2);
                                tableLayout.setCellSpacing(10);
                                container.setLayout(tableLayout);

                                cpResult.setLayout(new FillLayout());

                                cpResult.setSize(350, 200);
                                cpResult.setHeaderVisible(false);

                                cpBotton.setHeaderVisible(true);
                                cpBotton.setScrollMode(Scroll.AUTOX);
                                cpBotton.setHeading("Consulta Equivalências Realizadas");
                                ListStore<Inn_insumo_novoTGWT> list = new ListStore<Inn_insumo_novoTGWT>();
                                //list.add(listInnDaoGWT.list);
                                comboFilterPlc.setStore(list);
                                comboFilterPlc.setDisplayField("inn_tx_descricao");
                                comboFilterPlc.setTriggerAction(ComboBox.TriggerAction.ALL);
                                comboFilterPlc.setWidth(300);
                                ToolBar bar = new ToolBar();
                                bar.add(tx_locate2);
                                bar.add(new SeparatorToolItem());
                                bar.add(comboFilterPlc);
                                bar.add(new SeparatorToolItem());
                                Button btnfilterPlc = new Button("Filtrar");
                                btnfilterPlc.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                                    public void handleEvent(ButtonEvent be) {
                                        load();
                                    }
                                });

                                btnfilterPlc.setIcon(ICONS.filter());
                                bar.add(btnfilterPlc);
                                cpBotton.setTopComponent(bar);
                                cpBotton.setLayout(new FillLayout());
                                cpBotton.setHeight(210);

                                cpBotton.setStyleAttribute("margin", "10px");

                                cpPlco.setLayout(new FitLayout());

                                cpPlco.setSize(420, 180);
                                cpPlco.setHeaderVisible(false);

                                atualizarCpPlco();

                                container.add(cpPlco);

                                Grid<Ina_insumo_antigoTGWT> grid2 = new Grid<Ina_insumo_antigoTGWT>(store2, createColumnModel());
                                grid2.setBorders(true);
                                grid2.getColumnModel().getColumn(0).setHeader("Insumos da controladoria");

                                ContentPanel cp2 = new ContentPanel();

                                cp2.setLayout(new FillLayout());
                                cp2.setSize(530, 180);
                                cp2.setHeaderVisible(false);
                                ToolBar toolBar = new ToolBar();

                                storeCombo = new ListStore<Inn_insumo_novoTGWT>();

//                                storeCombo.add(listInnDaoGWT.list);

                                comboPlc.setStore(storeCombo);
                                comboPlc.setDisplayField("inn_tx_descricao");
                                comboPlc.setWidth(300);
                                comboPlc.setEmptyText("Selecione o insumo");
                                comboPlc.setTypeAhead(true);
                                comboPlc.setTriggerAction(ComboBox.TriggerAction.ALL);

                                toolBar.add(tx_locate);
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(comboPlc);

                                Button button = new Button("  Gerar");
                                button.setToolTip("Gerar Equivalência");
                                button.setIcon(ICONS.aplicar());
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(button);
                                button.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                                    public void handleEvent(ButtonEvent be) {
                                        String param = "?op=addEquivalencia&";
                                        for (Ina_insumo_antigoTGWT inaT : store2.getModels()) {
                                            param += "idsIna=" + inaT.getIna_nr_id() + "&";
                                        }
                                        addEquivalencia(param);
                                        store2.getModels().clear();
                                        store2.removeAll();
                                        comboPlc.clearSelections();
                                        tx_locate.setValue(null);
                                    }
                                });

                                cp2.add(grid2);
                                cp2.setBottomComponent(toolBar);

                                container.add(cp2);
                                new GridDragSource(grid2);
                                target2 = new GridDropTarget(grid2);
                                target2.setAllowSelfAsSource(false);

                                setStyleAttribute("margin", "10px");
                                cpPlco.layout(true);
                                cp2.layout(true);

                                add(container);
                                //add(formbinding);
                                add(cpBotton);
                                layout();
                                doLayout();
                            }
                        }
                    };
                    timerPlc.schedule(500);
                }
            }
        };
        timer.schedule(500);
        this.layout();
    }

    @Override
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
    }

    private void atualizarCpPlco() {
        cpPlco.removeAll();
        store.removeAll();
        store.add(inaDaoGWT.list);

        grid = new Grid<Ina_insumo_antigoTGWT>(store, createColumnModel());
        grid.setStripeRows(true);

        grid.setBorders(false);
        grid.setAutoExpandColumn("ina_tx_descricao");
        grid.setBorders(true);
        grid.setToolTip("Click e arraste para lista a direita, assim poderá realizar equivalência");


        new GridDragSource(grid);
        target = new GridDropTarget(grid);
        target.setAllowSelfAsSource(false);

        cpPlco.add(grid);

        cpPlco.setTopComponent(toolBarTop);
        cpPlco.layout();

        storefilter.recalculate();

        layout();
        doLayout();
    }

    private void configureComboPlc() {
        comboPlc.setStore(storeCombo);
        comboPlc.setDisplayField("inn_tx_descricao");
        comboPlc.setWidth(260);
        comboPlc.setEmptyText("Selecione a sub classe");
    }

    public void load() {
        try {
            final listInaGWT inaGWT = new listInaGWT();
            inaGWT.povoaEquiv(comboFilterPlc.getValue().getInn_nr_id());
            Timer timer = new Timer() {

                @Override
                public void run() {
                    if (!inaGWT.povoado) {
                        schedule(300);
                    } else {
                        final ColumnModel cm = new ColumnModel(getConfig());
                        ListStore<Ina_insumo_antigoTGWT> store = new ListStore<Ina_insumo_antigoTGWT>();
                        store.add(inaGWT.list);
                        Grid<Ina_insumo_antigoTGWT> gridEquivalencia = new Grid<Ina_insumo_antigoTGWT>(store, cm);
                        gridEquivalencia.setLoadMask(true);
                        gridEquivalencia.setStyleAttribute("borderTop", "none");

                        gridEquivalencia.setHeight(200);
                        gridEquivalencia.setBorders(true);
                        cpBotton.removeAll();
                        cpBotton.add(gridEquivalencia);
                        cpBotton.layout();
                    }
                }
            };
            timer.schedule(10);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEquivalencia(String param) {
        try {
            param += "idInn=" + comboPlc.getValue().getInn_nr_id() + "&";
            retornoEquivalencia2 retorno2 = new retornoEquivalencia2();
            EasyAccessURL eaurl = new EasyAccessURL(retorno2);
            eaurl.accessJSon(Constantes.URL + Eqi_equivalencia_insumoInsertGWT.PAGE + param);
        } catch (Exception e) {
        }
    }

    public boolean equivalenciaValida(String param) {
        boolean result = true;
        if (param.equalsIgnoreCase("?op=addEquivalencia&")) {
            result = false;
            com.google.gwt.user.client.Window.alert("Não existe sub classes do orçamento para efetuar a equivalência!!");
        } else if (comboPlc.getValue() == null) {
            result = false;
            com.google.gwt.user.client.Window.alert("Não existe sub classes para associar a equivalência!!");
        }
        return result;

    }

    private ColumnModel createColumnModel() {
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
        ColumnConfig column = new ColumnConfig();
        column.setId("ina_tx_codigo");
        column.setHeader("Codigo");
        column.setWidth(70);
        column.setHidden(true);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ina_tx_descricao");
        column.setHeader("Insumos");
        column.setWidth(300);

        configs.add(column);
        return new ColumnModel(configs);
    }

    private List<ColumnConfig> getConfig() {

        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("ina_tx_codigo");
        column.setHeader("Código");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ina_tx_descricao");
        column.setHeader("Insumos");
        column.setWidth(400);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

//        column = new ColumnConfig();
//        column.setId("plc_tx_nome");
//        column.setHeader("Sub Classe");
//        column.setWidth(200);
//        column.setAlignment(HorizontalAlignment.LEFT);
//        configs.add(column);



//        column = new ColumnConfig();
//        column.setId("coa_tx_unidade");
//        column.setHeader("Unidade");
//        column.setWidth(40);
//        column.setAlignment(HorizontalAlignment.LEFT);
//        configs.add(column);

        GridCellRenderer<Ina_insumo_antigoTGWT> btnDel = new GridCellRenderer<Ina_insumo_antigoTGWT>() {

            private boolean init;

            public Object render(final Ina_insumo_antigoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ina_insumo_antigoTGWT> store, Grid<Ina_insumo_antigoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Ina_insumo_antigoTGWT>>() {

                        public void handleEvent(GridEvent<Ina_insumo_antigoTGWT> be) {
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
                            retornoDelEquivalencia delEquivalencia = new retornoDelEquivalencia();
                            EasyAccessURL eaurl = new EasyAccessURL(delEquivalencia);
                            HashMap<String, String> param = new HashMap<String, String>();
                            param.put("op", "delete");
                            param.put("eqi_equivalencia_insumoT.ina_nr_id", model.getIna_nr_id() + "");
                            eaurl.accessJSonMap(Constantes.URL + Eqi_equivalencia_insumoUpdateDeleteGWT.PAGE, param);
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

        column = new ColumnConfig();
        column.setId("del");
        column.setHeader("");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setRenderer(btnDel);
        configs.add(column);

        return configs;
    }

    public void read(JSONValue jsonValue) {
        //com.google.gwt.user.client.Window.alert("2222");
        JSONObject jsonObject;
        final ColumnModel cm = new ColumnModel(getConfig());
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Vw_equivalenciaTGWT> store = new ListStore<Vw_equivalenciaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Vw_equivalenciaTGWT vw_equivalenciaTGWT = new Vw_equivalenciaTGWT();
                JSONObject registro = resultado.get(i).isObject();
            }
            GroupingStore<Vw_equivalenciaTGWT> storeEquivalencia = new GroupingStore<Vw_equivalenciaTGWT>();

            //store.groupBy("plc_tx_nome");
            Grid<Vw_equivalenciaTGWT> gridEquivalencia = new Grid<Vw_equivalenciaTGWT>(store, cm);
            gridEquivalencia.setLoadMask(true);
            gridEquivalencia.setStyleAttribute("borderTop", "none");

            GroupingView view = new GroupingView();
            view.setShowGroupedColumn(false);
            view.setForceFit(true);
            view.setGroupRenderer(new GridGroupRenderer() {

                public String render(GroupColumnData data) {
                    String f = cm.getColumnById(data.field).getHeader();
                    String l = data.models.size() == 1 ? "Item" : "Items";
                    return data.group + " (" + data.models.size() + " " + l + ")";
                }
            });
            gridEquivalencia.setView(view);
//            gridEquivalencia.setLoadMask(true);
//            gridEquivalencia.setStyleAttribute("borderTop", "none");
            gridEquivalencia.setHeight(200);
            gridEquivalencia.setBorders(true);
            cpBotton.removeAll();
            cpBotton.add(gridEquivalencia);
        }
        layout();
        doLayout();
    }

    class retornoDelEquivalencia implements IListenetResponse {

        public void read(JSONValue jsonValue) {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                Info.display("", "Exclusão efetuada com sucesso!");
                final listInaGWT inaDaoGWT = new listInaGWT();
                inaDaoGWT.povoa();
                Timer timer = new Timer() {

                    @Override
                    public void run() {
                        if (!inaDaoGWT.povoado) {
                            schedule(500);
                        } else {
                            load();
                            atualizarCpPlco();
                        }
                    }
                };
                timer.schedule(500);
            }
        }
    }
}

class retornoEquivalencia2 implements IListenetResponse {

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.toString().indexOf("sucesso") < 0) {
                Info.display("", "Equivalência efetuada com sucesso!");

            }
        }
    }
}
