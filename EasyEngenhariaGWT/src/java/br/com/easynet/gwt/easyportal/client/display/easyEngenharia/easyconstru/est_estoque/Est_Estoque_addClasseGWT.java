/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.est_estoque;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Ctp_conta_pagarTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Est_estoqueTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ChangeEvent;
import com.extjs.gxt.ui.client.data.ChangeListener;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid.ClicksToEdit;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class Est_Estoque_addClasseGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/est_estoque/est_estoqueConsultGWT.jsp";
    private ComboBox<Plc_plano_contasTGWT> comboClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ContentPanel cp = new ContentPanel();
    private ListStore<Plc_plano_contasTGWT> storeClasse = new ListStore<Plc_plano_contasTGWT>();
    final Est_Estoque_addClasseGWT consultGWT = this;
    ComboBox<Meses> comboMes = new ComboBox<Meses>();
    ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private int est_nr_id;
    private int plc_nr_id_old = 0;
    private ListStore<Est_estoqueTGWT> store;
    ToolBar toolBar = new ToolBar();
    Button button = new Button("Filtar");

    public Est_Estoque_addClasseGWT() {
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Ctp_conta_pagarTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ctp_conta_pagarTGWT>>(currency);

        listPlc_planoContasGWT.povoa();
        listObraGWT.povoar();

        addListMes();
        addListAno();

        this.setMaximizable(true);
        this.setHeading("Estoque");
        getDataNORTH().setSize(27);
        getDataEAST().setHidden(true);
        getDataWEST().setHidden(true);
        getToolBarMaster().setVisible(false);
        getCpTop().setTopComponent(toolBar);
        
        button.setIcon(ICONS.filter());
        button.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                filtrar();
            }
        });

        layout();
    }

//    @Override
//    protected void onHide() {
//        super.onHide();
//        getCpMaster().removeAll();
//    }
    public void addListAno() {
        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(storeAno);
        comboAno.setDisplayField("display");
    }

    public void addListMes() {
        ListStore<Meses> storeMeses = new ListStore<Meses>();
        storeMeses.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(storeMeses);
        comboMes.setDisplayField("display");
    }

    private void mostrar() {
        super.show();
        maximize();
    }

    public void show() {
        getCpMaster().removeAll();
        toolBar.removeAll();

        getCpTop().removeAll();

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listPlc_planoContasGWT.isInserido()) {
                    schedule(500);
                } else {
                    Timer timer = new Timer() {

                        @Override
                        public void run() {
                            if (!listObraGWT.isMostrar()) {
                                schedule(200);
                            } else {

                                addPlc();
                                addObra();

                                toolBar.add(new LabelToolItem("obra:"));

                                toolBar.add(comboObra);
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new LabelToolItem("Mês:"));
                                toolBar.add(comboMes);
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new LabelToolItem("Ano:"));
                                toolBar.add(comboAno);

                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new SeparatorToolItem());


                                toolBar.add(button);

                                consultGWT.mostrar();
                                consultGWT.layout();
                            }
                        }
                    };
                    timer.schedule(200);
                }
            }
        };
        timer.schedule(500);
    }

    public void update(int id_est, int plc_nr_id) {
        try {
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("est_estoqueT.est_nr_id", id_est + "");
            param.put("est_estoqueT.plc_nr_id", plc_nr_id + "");
            param.put("addSubClasse", "true");
            ListenerReader lr = new ListenerReader();
//            Window.alert(param.toString());
            EasyAccessURL eaurl = new EasyAccessURL(lr);
            eaurl.accessJSonMapNoProgress(Constantes.URL + Est_estoqueUpdateDeleteGWT.PAGE, param);

        } catch (Exception e) {
        }

    }

    private void filtrar() {
        try {
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("classificar", "true");
            param.put("est_estoqueT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            if (comboMes.getValue() != null) {
                param.put("est_estoqueT.est_nr_mes", comboMes.getValue().getValue() + "");
            }
            if (comboAno.getValue() != null) {
                param.put("est_estoqueT.est_nr_ano", comboAno.getValue().getValue() + "");
            }
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception e) {
        }
    }

    public void createColumns() {
        configs = new ArrayList<ColumnConfig>();

        ColumnConfig columnConfig = null;

        columnConfig = new ColumnConfig("est_tx_nome", "Descrição", 400);
        configs.add(columnConfig);

        columnConfig = new ColumnConfig("est_tx_unidade", "Unidade", 60);
        configs.add(columnConfig);

        columnConfig = new ColumnConfig("est_nr_vl_unitario", "Valor Unit.", 80);
        columnConfig.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        columnConfig.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(columnConfig);

        columnConfig = new ColumnConfig("est_nr_quantidade", "Estoque", 80);
        columnConfig.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        columnConfig.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(columnConfig);

        columnConfig = new ColumnConfig("est_nr_vl_total", "Vl. Total", 80);
        columnConfig.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        columnConfig.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(columnConfig);

//        columnConfig = new ColumnConfig("plc_nr_id", "classe.", 100);
//        columnConfig.setRenderer(getGridCellRenderer(columnConfig));
//        configs.add(columnConfig);

        columnConfig = new ColumnConfig("est_nr_id", "Sub-Classe", 320);
        columnConfig.setRenderer(comboRedere());
        configs.add(columnConfig);
    }

    public GridCellRenderer<Est_estoqueTGWT> getGridCellRenderer(final ColumnConfig coluna) {

        GridCellRenderer gdr = new GridCellRenderer<Est_estoqueTGWT>() {

            int d = 0;

            public String render(final Est_estoqueTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Est_estoqueTGWT> lisstore, final Grid<Est_estoqueTGWT> grid) {
                est_nr_id = model.getEst_nr_id();
                int i = model.getEst_nr_id();

                final ComboBox<Plc_plano_contasTGWT> combo = new ComboBox<Plc_plano_contasTGWT>();
                combo.setStore(storeClasse);
                combo.setEmptyText("Selecione a sub claase");
                combo.setDisplayField("plc_tx_nome");
                combo.setValueField("plc_nr_id");
                combo.setForceSelection(true);
                combo.setTriggerAction(ComboBox.TriggerAction.ALL);
                final CellEditor ce = new CellEditor(combo) {

                    public Object preProcessValue(Object value) {
                        if (value == null) {
                            return value;
                        }
                        Plc_plano_contasTGWT model = storeClasse.findModel("plc_nr_id", value);
                        combo.setValue(model);
                        return model;
                    }

                    public Object postProcessValue(Object value) {
                        if (value == null) {
                            return value;
                        }
                        return ((Plc_plano_contasTGWT) value).get("plc_nr_id");
                    }
                };


                coluna.setEditor(ce);

//                combo.addSelectionChangedListener(new SelectionChangedListener<Plc_plano_contasTGWT>() {
//
//                    @Override
//                    public void selectionChanged(SelectionChangedEvent<Plc_plano_contasTGWT> se) {
//                        if (store.getModifiedRecords().size() > 0) {
//                            Window.alert("modeificado" + store.getModifiedRecords().get(0).get("est_nr_id"));
//                        }
//                        store.commitChanges();
//                    }
//                });

//                combo.setSelection(storeClasse.getModels());
                combo.addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<Plc_plano_contasTGWT>>() {

                    public void handleEvent(SelectionChangedEvent<Plc_plano_contasTGWT> es) {
                        //Window.alert("sele" + store.getModifiedRecords().get(0).get("est_nr_id"));
//                        Window.alert(model.get("est_nr_id").toString());
                        store.commitChanges();
                    }
                });
                est_nr_id = model.getEst_nr_id();


                return storeClasse.findModel("plc_nr_id", model.get(property)).get("plc_tx_nome");

            }
        };

        return gdr;

    }

    public GridCellRenderer<Est_estoqueTGWT> comboRedere() {
        GridCellRenderer<Est_estoqueTGWT> rendererCombo = new GridCellRenderer<Est_estoqueTGWT>() {

            private boolean init;

            public Object render(final Est_estoqueTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Est_estoqueTGWT> store, Grid<Est_estoqueTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Est_estoqueTGWT>>() {

                        public void handleEvent(GridEvent<Est_estoqueTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }
                ComboBox<Plc_plano_contasTGWT> combo = new ComboBox<Plc_plano_contasTGWT>();
                combo.setStore(storeClasse);
                combo.setEmptyText("Selecione a sub claase");
                combo.setDisplayField("plc_tx_nome");
                combo.setValueField("plc_nr_id");
                combo.setForceSelection(true);
                combo.setHeight(15);
                combo.setWidth(300);
                combo.setTriggerAction(ComboBox.TriggerAction.ALL);
                combo.addSelectionChangedListener(new SelectionChangedListener<Plc_plano_contasTGWT>() {

                    @Override
                    public void selectionChanged(SelectionChangedEvent<Plc_plano_contasTGWT> se) {
                        update(model.getEst_nr_id(), se.getSelectedItem().getPlc_nr_id());
                    }
                });

                return combo;
            }
        };
        return rendererCombo;

    }

    public void addObra() {
        List<Obr_obrasTGWT> list = new ArrayList<Obr_obrasTGWT>();
        comboObra.setStore(listObraGWT.getStore());
        comboObra.setDisplayField("obr_tx_nome");
    }

    public void addPlc() {
        storeClasse = listPlc_planoContasGWT.getStore();
        comboClasse.setStore(listPlc_planoContasGWT.getStore());
        comboClasse.setDisplayField("plc_tx_nome");
        comboClasse.setValueField("plc_nr_id");
        comboClasse.setForceSelection(true);
        comboClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            List<Est_estoqueTGWT> listEstoque = new ArrayList<Est_estoqueTGWT>();
            //Window.alert("Chegou");
            for (int i = 1; i < resultado.size(); i++) {
                Est_estoqueTGWT est_estoqueTGWT = new Est_estoqueTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer est_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("est_nr_id").toString()));
                est_estoqueTGWT.setEst_nr_id(est_nr_id);

                Integer est_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("est_nr_mes").toString()));
                est_estoqueTGWT.setEst_nr_mes(est_nr_mes);

                Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                est_estoqueTGWT.setPlc_nr_id(plc_nr_id);

                float est_nr_quantidade = Float.parseFloat(EasyContainer.clearAspas(registro.get("est_nr_quantidade").toString()));
                est_estoqueTGWT.setEst_nr_quantidade(est_nr_quantidade);

                float est_nr_vl_unitario = Float.parseFloat(EasyContainer.clearAspas(registro.get("est_nr_vl_unitario").toString()));
                est_estoqueTGWT.setEst_nr_vl_unitario(est_nr_vl_unitario);

                float est_nr_vl_total = Float.parseFloat(EasyContainer.clearAspas(registro.get("est_nr_vl_total").toString()));
                est_estoqueTGWT.setEst_nr_vl_total(est_nr_vl_total);

                String est_tx_unidade = EasyContainer.clearAspas(registro.get("est_tx_unidade").toString());
                est_estoqueTGWT.setEst_tx_unidade(est_tx_unidade);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                est_estoqueTGWT.setObr_nr_id(obr_nr_id);

                Integer est_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("est_nr_ano").toString()));
                est_estoqueTGWT.setEst_nr_ano(est_nr_ano);

                String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                est_estoqueTGWT.setPlc_tx_nome(plc_tx_nome);

                String est_tx_nome = EasyContainer.clearAspas(registro.get("est_tx_nome").toString());
                est_estoqueTGWT.setEst_tx_nome(est_tx_nome);

                listEstoque.add(est_estoqueTGWT);
            }
//            Window.alert("passou");

            createColumns();

            PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(listEstoque);
            PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
            loader.setRemoteSort(true);
            store = new ListStore<Est_estoqueTGWT>(loader);
            store.add(listEstoque);
            getToolBarPage().bind(loader);
            getToolBarPage().setPageSize(20); //quantidade de registro por página
            getToolBarPage().bind(loader);
            loader.load(0, 20);//qual página será visualizada primeiro, e quantos registro irá possuir a pagina.



            ColumnModel cm = new ColumnModel(configs);
            EditorGrid<Est_estoqueTGWT> grid = new EditorGrid<Est_estoqueTGWT>(store, cm);
            grid.setBorders(true);

            grid.setStripeRows(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            getCpMaster().removeAll();
            getCpMaster().add(grid);

            this.layout();
            this.doLayout();
        }
    }
}

class ListenerReader implements IListenetResponse {

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            Info.display("", jsonObject.get("resultado").toString());
        }
    }
}
