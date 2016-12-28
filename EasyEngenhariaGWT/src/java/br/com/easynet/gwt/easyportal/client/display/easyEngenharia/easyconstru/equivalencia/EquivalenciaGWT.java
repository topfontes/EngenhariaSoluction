/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento.List_plco_plano_contas_orcamentoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento.PlcoConsult;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plco_plano_contas_orcamentoTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Vw_equivalenciaTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_equivalencia.Vw_equivalenciaConsultGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.dnd.GridDragSource;
import com.extjs.gxt.ui.client.dnd.GridDropTarget;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
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
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
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
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
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
public class EquivalenciaGWT extends Window implements IListenetResponse {
 
    private ListBox listSubClasse = new ListBox();
    private LayoutContainer container = new LayoutContainer();
    private List<Plco_plano_contas_orcamentoTGWT> listPlco = new ArrayList<Plco_plano_contas_orcamentoTGWT>();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private ListBox listPlc = new ListBox();
    final ComboBox<Plc_plano_contasTGWT> comboPlc = new ComboBox<Plc_plano_contasTGWT>();
    private List<Plc_plano_contasTGWT> listaPlc = new ArrayList<Plc_plano_contasTGWT>();
    ListStore<Plc_plano_contasTGWT> storeCombo = new ListStore<Plc_plano_contasTGWT>();
    private GridDropTarget target;
    private GridDropTarget target2;
    ContentPanel cpBotton = new ContentPanel();
    ContentPanel cpResult = new ContentPanel();
    final EquivalenciaGWT consultGWT = this;
    HashMap<String, String> mapEquivalencia;
    List_plco_plano_contas_orcamentoGWT list_plco_plano_contas_orcamentoGWT = new List_plco_plano_contas_orcamentoGWT();
    PlcoConsult plcoConsult = new PlcoConsult();
    ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    final ListStore<Plco_plano_contas_orcamentoTGWT> store2 = new ListStore<Plco_plano_contas_orcamentoTGWT>();
    ContentPanel cpPlco = new ContentPanel();
    Grid<Plco_plano_contas_orcamentoTGWT> grid;
    private ComboBox<Plc_plano_contasTGWT> comboFilterPlc = new ComboBox<Plc_plano_contasTGWT>();
    private ListStore<Plco_plano_contas_orcamentoTGWT> store = new ListStore<Plco_plano_contas_orcamentoTGWT>();
    private StoreFilterField<Plco_plano_contas_orcamentoTGWT> storefilter;
    private ToolBar toolBarTop = new ToolBar();
    private FormPanel formbinding = new FormPanel();
    private TextArea areaplco = new TextArea();

    public EquivalenciaGWT() {
        this.setHeading("Equivalêcias");
        plcoConsult.povoarSemEquivalencia();
        listPlc_planoContasGWT.povoa();
        setSize(750, 490);
        mapEquivalencia = new HashMap<String, String>();

        storefilter = new StoreFilterField<Plco_plano_contas_orcamentoTGWT>() {

            @Override
            protected boolean doSelect(Store<Plco_plano_contas_orcamentoTGWT> store, Plco_plano_contas_orcamentoTGWT parent, Plco_plano_contas_orcamentoTGWT record, String property, String filter) {
                String name = record.get("plco_tx_nome");
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

        areaplco.setName("plco_tx_nome");
        formbinding.add(areaplco);

        montar();
    }

    public void montar() {
        if (this.getItems().size() > 0) {
            this.removeAll();
        }
        Timer timer = new Timer() {

            @Override
            public void run() {
                //listPlco = plcoConsult.getList();
                if (!plcoConsult.isPovoado()) {
                    schedule(500);
                } else {
                    Timer timerPlc = new Timer() {

                        @Override
                        public void run() {
                            if (listPlc_planoContasGWT.getStore() == null) {
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

                                comboFilterPlc.setStore(listPlc_planoContasGWT.getStore());
                                comboFilterPlc.setDisplayField("plc_tx_nome");
                                comboFilterPlc.setTriggerAction(ComboBox.TriggerAction.ALL);
                                comboFilterPlc.setWidth(300);
                                ToolBar bar = new ToolBar();
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

                                cpPlco.setSize(350, 180);
                                cpPlco.setHeaderVisible(false);

                                atualizarCpPlco();

                                container.add(cpPlco);

                                Grid<Plco_plano_contas_orcamentoTGWT> grid2 = new Grid<Plco_plano_contas_orcamentoTGWT>(store2, createColumnModel());
                                grid2.setBorders(true);
                                grid2.getColumnModel().getColumn(0).setHeader("Insumos da controladoria");

                                ContentPanel cp2 = new ContentPanel();

                                cp2.setLayout(new FillLayout());
                                cp2.setSize(350, 180);
                                cp2.setHeaderVisible(false);
                                ToolBar toolBar = new ToolBar();

                                storeCombo = listPlc_planoContasGWT.getStore();

                                comboPlc.setStore(storeCombo);
                                comboPlc.setDisplayField("plc_tx_nome");
                                comboPlc.setWidth(260);
                                comboPlc.setEmptyText("Selecione a sub classe");
                                comboPlc.setTypeAhead(true);
                                comboPlc.setTriggerAction(ComboBox.TriggerAction.ALL);

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
                                        for (Plco_plano_contas_orcamentoTGWT plco : store2.getModels()) {
                                            param += "idsPlco=" + plco.getPlco_nr_id() + "&";
                                        }
                                        addEquivalencia(param);
                                        store2.getModels().clear();
                                        store2.removeAll();
                                        comboPlc.clearSelections();
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
        store.add(plcoConsult.getList());

        grid = new Grid<Plco_plano_contas_orcamentoTGWT>(store, createColumnModel());
        grid.setStripeRows(true);

        grid.setBorders(false);
        grid.setAutoExpandColumn("plco_tx_nome");
        grid.setBorders(true);
        grid.setToolTip("Click e arraste para lista a direita, assim poderá realizar equivalência");
//        grid.getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<Plco_plano_contas_orcamentoTGWT>>() {
//
//            public void handleEvent(SelectionChangedEvent<Plco_plano_contas_orcamentoTGWT> be) {
//                areaplco.setValue(be.getSelectedItem().getPlco_tx_nome());
//            }
//        });

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
        comboPlc.setDisplayField("plc_tx_nome");
        comboPlc.setWidth(260);
        comboPlc.setEmptyText("Selecione a sub classe");
    }

    public void load() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("vw_equivalenciaT.plc_nr_id", comboFilterPlc.getValue().getPlc_nr_id() + "");
            eaurl.accessJSonMap(Constantes.URL + Vw_equivalenciaConsultGWT.PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEquivalencia(String param) {
        try {
            param += "idPlc=" + comboPlc.getValue().getPlc_nr_id() + "&";
            retornoEquiv retorno = new retornoEquiv();
            EasyAccessURL eaurl = new EasyAccessURL(retorno);
            eaurl.accessJSon(Constantes.URL + Vw_equivalenciaConsultGWT.PAGE + param);
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
        column.setId("plco_tx_cod_externo");
        column.setHeader("Codigo");
        column.setWidth(70);
        column.setHidden(true);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_tx_nome");
        column.setHeader("Insumos");
        column.setWidth(300);

        configs.add(column);
        return new ColumnModel(configs);
    }

    private List<ColumnConfig> getConfig() {

        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("plco_tx_cod_externo");
        column.setHeader("Código");
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_tx_nome");
        column.setHeader("Insumos");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plc_tx_nome");
        column.setHeader("Sub Classe");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_tx_tipo");
        column.setHeader("Tipo");
        column.setWidth(40);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_tx_unidade");
        column.setHeader("Unidade");
        column.setWidth(40);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        GridCellRenderer<Vw_equivalenciaTGWT> btnDel = new GridCellRenderer<Vw_equivalenciaTGWT>() {

            private boolean init;

            public Object render(final Vw_equivalenciaTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_equivalenciaTGWT> store, Grid<Vw_equivalenciaTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_equivalenciaTGWT>>() {

                        public void handleEvent(GridEvent<Vw_equivalenciaTGWT> be) {
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
                            param.put("eplc_equivalencia_plano_contasT.eplc_nr_id", model.getEplc_nr_id() + "");
                            eaurl.accessJSonMap(Constantes.URL + Vw_equivalenciaConsultGWT.PAGE, param);
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

            GroupingStore<Vw_equivalenciaTGWT> store = new GroupingStore<Vw_equivalenciaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Vw_equivalenciaTGWT vw_equivalenciaTGWT = new Vw_equivalenciaTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer eplc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("eplc_nr_id").toString()));
                vw_equivalenciaTGWT.setEplc_nr_id(eplc_nr_id);
                Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                vw_equivalenciaTGWT.setPlc_nr_id(plc_nr_id);
                Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                vw_equivalenciaTGWT.setPlco_nr_id(plco_nr_id);
                String plco_tx_nome = EasyContainer.clearAspas(registro.get("plco_tx_nome").toString());
                vw_equivalenciaTGWT.setPlco_tx_nome(plco_tx_nome);
                String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                vw_equivalenciaTGWT.setPlc_tx_nome(plc_tx_nome);
                String plco_tx_tipo = EasyContainer.clearAspas(registro.get("plco_tx_tipo").toString());
                vw_equivalenciaTGWT.setPlco_tx_tipo(plco_tx_tipo);
                String plco_tx_cod_externo = EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString());
                vw_equivalenciaTGWT.setPlco_tx_cod_externo(plco_tx_cod_externo);
                String plco_tx_unidade = EasyContainer.clearAspas(registro.get("plco_tx_unidade").toString());
                vw_equivalenciaTGWT.setPlco_tx_unidade(plco_tx_unidade);
                store.add(vw_equivalenciaTGWT);
            }
            GroupingStore<Vw_equivalenciaTGWT> storeEquivalencia = new GroupingStore<Vw_equivalenciaTGWT>();

            store.groupBy("plc_tx_nome");
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
                plcoConsult.povoarSemEquivalencia();
                Timer timer = new Timer() {

                    @Override
                    public void run() {
                        if (!plcoConsult.isPovoado()) {
                            schedule(500);
                        } else {
                            atualizarCpPlco();
                            load();
                        }
                    }
                };
                timer.schedule(500);

            }
        }
    }
}
 
class retornoEquiv implements IListenetResponse {

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.toString().indexOf("sucesso") < 0) {
                Info.display("", "Equivalência efetuada com sucesso!");
            }
        }
    }
}

