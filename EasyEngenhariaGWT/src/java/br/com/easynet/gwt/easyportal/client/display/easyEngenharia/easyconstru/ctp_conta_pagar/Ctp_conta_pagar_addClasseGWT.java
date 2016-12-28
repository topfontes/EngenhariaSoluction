/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.for_fornecedor.For_fornecedorInsertGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.for_fornecedor.ListFornecedorGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Ctp_conta_pagarTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.For_fornecedorTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class Ctp_conta_pagar_addClasseGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarSemVinculo.jsp";
    private ComboBox<Plc_plano_contasTGWT> comboClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ContentPanel cp = new ContentPanel();
    private ListStore<Ctp_conta_pagarTGWT> store = new ListStore<Ctp_conta_pagarTGWT>();
    private ListStore<Plc_plano_contasTGWT> storeClasse = new ListStore<Plc_plano_contasTGWT>();
    final Ctp_conta_pagar_addClasseGWT consultGWT = this;
    ComboBox<Meses> comboMes = new ComboBox<Meses>();
    ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    RadioGroup radioGroup = new RadioGroup();
    private ListFornecedorGWT listFornecedorGWT = new ListFornecedorGWT();
    private ListStore<For_fornecedorTGWT> storeFornec = new ListStore<For_fornecedorTGWT>();
    private Dialog diaFornec = new Dialog();
    private ComboBox<For_fornecedorTGWT> comboFornec = new ComboBox<For_fornecedorTGWT>();
    private Ctp_conta_pagarTGWT ctp_conta_pagarTGWT;
    private String for_tx_nome;
    private EditorGrid<Ctp_conta_pagarTGWT> grid;
    private TableLayout layout = new TableLayout();
    private TextField<String> tx_locFornec = new TextField<String>();

    public Ctp_conta_pagar_addClasseGWT() {
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Ctp_conta_pagarTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ctp_conta_pagarTGWT>>(currency);
        listPlc_planoContasGWT.povoa();
        listObraGWT.povoar();
        layout.setCellPadding(4);
        addListMes();
        addListAno();

        this.setMaximizable(true);
        this.setHeading("Contas Pagas/A Pagas");
        getDataNORTH().setSize(27);
        getDataEAST().setHidden(true);
        getDataWEST().setHidden(true);
        getToolBarMaster().setVisible(false);
        createColumns();
        //store.commitChanges();
        //store.setMonitorChanges(true);

        //tx_locFornec.setAllowBlank(false);
        KeyListener kl = new KeyListener() {

            @Override
            public void componentKeyPress(ComponentEvent event) {
                if (event.getKeyCode() == 13) {
                    refreshCombo();
                    comboFornec.focus();
                }
            }
        };
        tx_locFornec.addKeyListener(kl);
        layout();
    }

    public void refreshCombo() {
        listFornecedorGWT.consultbyName(tx_locFornec.getValue());
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listFornecedorGWT.inserido) {
                    schedule(500);
                } else {

//                    comboFornec = new ComboBox<For_fornecedorTGWT>();
                    comboFornec.setDisplayField("for_tx_nome");
                    comboFornec.setEmptyText("Selecione o fornecedor");
                    comboFornec.setStore(listFornecedorGWT.getStore());
                    comboFornec.getListView().setStore(listFornecedorGWT.getStore());
                    comboFornec.getListView().refresh();
                    
                    comboFornec.focus();
                }
            }
        };
        timer.schedule(500);
    }

    @Override
    protected void onHide() {
        super.onHide();
        getCpMaster().removeAll();
    }

    public void montarCpFornec() {
        final ContentPanel panel = new ContentPanel();
        TableLayout layout = new TableLayout(1);
        layout.setCellPadding(3);
        panel.setLayout(layout);
        panel.setHeaderVisible(false);
        panel.setHeight(70);
        panel.setFrame(true);
        panel.setLayout(layout);
        tx_locFornec.setEmptyText("Loc. Fornecedor");
        diaFornec = new Dialog() {

            @Override
            protected void onShow() {
                super.onShow();
                comboFornec.setStore(null);
                comboFornec.setDisplayField("for_tx_nome");
                comboFornec.setValueField("for_nr_id");
                comboFornec.setWidth(260);
                comboFornec.setEmptyText("Selecione o fornecedor");
                ///comboFornec.setTypeAhead(true);
                comboFornec.setTriggerAction(ComboBox.TriggerAction.ALL);
                panel.add(tx_locFornec);
                panel.add(comboFornec);
                tx_locFornec.focus();
                tx_locFornec.setValue("");
                layout();
                tx_locFornec.focus();
            }

            @Override
            protected void onLoad() {
                super.onLoad();
                tx_locFornec.focus();
            }
        };
        diaFornec.setHeading("Classificar o fornecedor..");
        diaFornec.setButtons(Dialog.OKCANCEL);
        diaFornec.setBodyStyleName("pad-text");
        diaFornec.add(panel);
        diaFornec.setScrollMode(Scroll.AUTO);
        diaFornec.setHideOnButtonClick(true);
        Button yes = diaFornec.getButtonById(diaFornec.OK);

        yes.addSelectionListener(new SelectionListener<ButtonEvent>() {

            public void componentSelected(ButtonEvent be) {
                if (comboFornec.getValue() == null) {
                    for_tx_nome = comboFornec.getRawValue();
                    insertFornec(comboFornec.getRawValue());
                    comboFornec.setRawValue("");
                } else {
                    updateFornecCtp(comboFornec.getValue().getFor_tx_nome());
                    comboFornec.setValue(null);
                }
            }
        });
    }

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
//                                storeFornec = listFornecedorGWT.getStore();
                                montarCpFornec();
                                addPlc();
                                addObra();
                                ToolBar toolBar = new ToolBar();
                                toolBar.add(new LabelToolItem("obra:"));

                                toolBar.add(comboObra);
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(comboMes);
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(comboAno);
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new SeparatorToolItem());

                                toolBar.add(new LabelToolItem("Status:"));
                                Radio todos = new Radio();
                                todos.setBoxLabel("Todos");
                                todos.setValue(true);

                                Radio pagas = new Radio();
                                pagas.setBoxLabel("Pagas");

                                Radio apagar = new Radio();
                                apagar.setBoxLabel("A pagar");

                                radioGroup.add(todos);
                                radioGroup.add(pagas);
                                radioGroup.add(apagar);
                                toolBar.add(radioGroup);

                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(new SeparatorToolItem());

                                Button button = new Button("    Filtar ");
                                button.setIcon(ICONS.filter());
                                button.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                                    public void handleEvent(ButtonEvent be) {
                                        filtrar();
                                    }
                                });
                                toolBar.add(button);
                                getCpTop().setTopComponent(toolBar);
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

    public void update(int ctp_nr_id, int plc_nr_id) {
        try {
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "updateClasse");
            param.put("ctp_conta_pagarT.ctp_nr_id", ctp_nr_id + "");
            param.put("ctp_conta_pagarT.plc_nr_id", plc_nr_id + "");
            ListenerReader lr = new ListenerReader();
            EasyAccessURL eaurl = new EasyAccessURL(lr);
            eaurl.accessJSonMapNoProgress(Constantes.URL + PAGE, param);
        } catch (Exception e) {
        }
    }

    public void insertFornec(String for_tx_nome) {
        try {
            //Window.alert(for_tx_nome);
            if (for_tx_nome.trim().length() > 0) {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("op", "insert");
                param.put("for_fornecedorT.for_tx_nome", for_tx_nome);
                ListenerCadFornec lr = new ListenerCadFornec();
                EasyAccessURL eaurl = new EasyAccessURL(lr);
                eaurl.accessJSonMap(Constantes.URL + For_fornecedorInsertGWT.PAGE, param);
            }

        } catch (Exception e) {
        }
    }

    public void updateFornecCtp(String fornec) {
        try {
            ctp_conta_pagarTGWT.setCtp_tx_fornecedor(fornec);
            DateTimeFormat formatD = DateTimeFormat.getFormat("dd/MM/yyyy");
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("ctp_conta_pagarT.ctp_nr_id", ctp_conta_pagarTGWT.getCtp_nr_id() + "");
            param.put("ctp_conta_pagarT.ctp_tx_fornecedor", ctp_conta_pagarTGWT.getCtp_tx_fornecedor());
            param.put("ctp_conta_pagarT.ctp_nr_mes", ctp_conta_pagarTGWT.getCtp_nr_mes() + "");
            param.put("ctp_conta_pagarT.plc_nr_id", ctp_conta_pagarTGWT.getPlc_nr_id() + "");
            param.put("ctp_conta_pagarT.ctp_nr_valor", ctp_conta_pagarTGWT.getCtp_nr_valor() + "");
            param.put("ctp_conta_pagarT.ctp_nr_documento", ctp_conta_pagarTGWT.getCtp_nr_documento());
            param.put("ctp_conta_pagarT.ctp_tx_status", ctp_conta_pagarTGWT.getCtp_tx_status());
            param.put("ctp_conta_pagarT.ctp_dt_vencimento", formatD.format(ctp_conta_pagarTGWT.getCtp_dt_vencimento()));
            if (ctp_conta_pagarTGWT.getCtp_dt_emissao() != null) {
                param.put("ctp_conta_pagarT.ctp_dt_emissao", formatD.format(ctp_conta_pagarTGWT.getCtp_dt_emissao()));
            }
            param.put("ctp_conta_pagarT.obr_nr_id", ctp_conta_pagarTGWT.getObr_nr_id() + "");
            param.put("ctp_conta_pagarT.ctp_nr_ano", ctp_conta_pagarTGWT.getCtp_nr_ano() + "");
            param.put("ctp_conta_pagarT.ctp_tx_obs", ctp_conta_pagarTGWT.getCtp_nr_ano() + "");
//            Window.alert(param.toString());
            ListenerUpdatectpFornec lr = new ListenerUpdatectpFornec();
            EasyAccessURL eaurl = new EasyAccessURL(lr);
            eaurl.accessJSonMapNoProgress(Constantes.URL + Ctp_conta_pagarUpdateDeleteGWT.PAGE, param);
        } catch (Exception e) {
        }
    }

    private void filtrar() {
        try {
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("ctp_conta_pagarT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");


            if (comboMes.getValue() != null) {
                param.put("ctp_conta_pagarT.ctp_nr_mes", comboMes.getValue().getValue() + "");
            }
            if (comboAno.getValue() != null) {
                param.put("ctp_conta_pagarT.ctp_nr_ano", comboAno.getValue().getValue() + "");
            }
            param.put("status", radioGroup.getValue().getBoxLabel().equalsIgnoreCase("todos") ? "0" : radioGroup.getValue().getBoxLabel().equalsIgnoreCase("pagas") ? "1" : "2");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);

        } catch (Exception e) {
        }
    }

    public void createColumns() {
        configs = new ArrayList<ColumnConfig>();
        ColumnConfig columnConfig = new ColumnConfig("ctp_nr_documento", "Documento", 80);
        configs.add(columnConfig);

        columnConfig = new ColumnConfig("ctp_dt_vencimento", "Vencimento", 80);
        columnConfig.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        configs.add(columnConfig);

        columnConfig = new ColumnConfig("ctp_tx_fornecedor", "Fornecedor", 200);
        configs.add(columnConfig);


        columnConfig = new ColumnConfig("ctp_nr_valor", "Valor", 80);
        columnConfig.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        columnConfig.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(columnConfig);

        columnConfig = new ColumnConfig("ctp_tx_obs", "Histórico", 450);
        configs.add(columnConfig);

        columnConfig = new ColumnConfig();
        columnConfig.setId("plc_nr_id");
        columnConfig.setHeader("Sub-Classe");

        columnConfig = new ColumnConfig("plc_nr_id", "Sub Classe", 310);
//99249525 emanuel.
        GridCellRenderer<Ctp_conta_pagarTGWT> comboPlc = new GridCellRenderer<Ctp_conta_pagarTGWT>() {

            private boolean init;

            public Object render(final Ctp_conta_pagarTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ctp_conta_pagarTGWT> store, Grid<Ctp_conta_pagarTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Ctp_conta_pagarTGWT>>() {

                        public void handleEvent(GridEvent<Ctp_conta_pagarTGWT> be) {
                            for (int i = 0; i
                                    < be.getGrid().getStore().getCount(); i++) {
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
                        update(model.getCtp_nr_id(), se.getSelectedItem().getPlc_nr_id());


                    }
                });



                return combo;


            }
        };
        columnConfig.setRenderer(comboPlc);
        columnConfig.setWidth(310);
        configs.add(columnConfig);


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

            List<Ctp_conta_pagarTGWT> list = new Vector();


            for (int i = 1; i
                    < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Ctp_conta_pagarTGWT ctp_conta_pagarTGWT = new Ctp_conta_pagarTGWT();

                int plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                ctp_conta_pagarTGWT.setPlc_nr_id(plc_nr_id);

                int ctp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_id").toString()));
                ctp_conta_pagarTGWT.setCtp_nr_id(ctp_nr_id);

                int ctp_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_mes").toString()));
                ctp_conta_pagarTGWT.setCtp_nr_mes(ctp_nr_mes);

                int ctp_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_ano").toString()));
                ctp_conta_pagarTGWT.setCtp_nr_ano(ctp_nr_ano);

                int obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                ctp_conta_pagarTGWT.setObr_nr_id(obr_nr_id);

                ctp_conta_pagarTGWT.setCtp_nr_documento(EasyContainer.clearAspas(registro.get("ctp_nr_documento").toString()));

                DateTimeFormat formatD = DateTimeFormat.getFormat("dd/MM/yyyy");

                String ctp_tx_fornecedor = EasyContainer.clearAspas(registro.get("ctp_tx_fornecedor").toString());
                ctp_conta_pagarTGWT.setCtp_tx_fornecedor(ctp_tx_fornecedor);

                String ctp_tx_status = EasyContainer.clearAspas(registro.get("ctp_tx_status").toString());
                ctp_conta_pagarTGWT.setCtp_tx_status(ctp_tx_status);

                ctp_conta_pagarTGWT.setCtp_dt_vencimento(formatD.parse(EasyContainer.clearAspas(registro.get("ctp_dt_vencimento").toString())));

                String dt_emissao = EasyContainer.clearAspas(registro.get("ctp_dt_emissao").toString());


                if (dt_emissao.trim().length() > 0) {
                    ctp_conta_pagarTGWT.setCtp_dt_emissao(formatD.parse(dt_emissao));
                }

                ctp_conta_pagarTGWT.setCtp_tx_obs(EasyContainer.clearAspas(registro.get("ctp_tx_obs").toString()));



                double valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("ctp_nr_valor").toString()));
                ctp_conta_pagarTGWT.setCtp_nr_valor(valor);

                list.add(ctp_conta_pagarTGWT);


            }
            //inicio paginação
            PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list);
            PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
            loader.setRemoteSort(true);

            store = new ListStore<Ctp_conta_pagarTGWT>(loader);
            store.add(list);

            getToolBarPage().setPageSize(18); //quantidade de registro por página
            getToolBarPage().bind(loader);
            loader.load(0, 18);//qual página será visualizada primeiro, e quantos registro irá possuir a pagina.
            //fin paginação

            ColumnModel cm = new ColumnModel(configs);
            grid = new EditorGrid<Ctp_conta_pagarTGWT>(store, cm);
            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Ctp_conta_pagarTGWT>>() {

                public void handleEvent(GridEvent<Ctp_conta_pagarTGWT> be) {
                    ctp_conta_pagarTGWT = be.getModel();
                    diaFornec.show();
                    //showWindow();
                }
            });
            CheckBoxSelectionModel<Ctp_conta_pagarTGWT> sm = new CheckBoxSelectionModel<Ctp_conta_pagarTGWT>();

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.setLoadMask(true);
            grid.setStyleAttribute("borderTop", "none");
            grid.setStripeRows(true);
            grid.setToolTip("Duplo Click abre tela de alterar fornecedor");
            getCpMaster().removeAll();
            grid.setStripeRows(true);
            getCpMaster().add(grid);

            this.layout();
            doLayout();
        }
    }

    public void showWindow() {
        com.extjs.gxt.ui.client.widget.Window window = new com.extjs.gxt.ui.client.widget.Window() {

            @Override
            protected void onShow() {
                super.onShow();
                tx_locFornec.focus();
            }
        };
        window.setModal(true);
        ContentPanel cp = new ContentPanel();
        cp.setHeaderVisible(false);
        TableLayout layout = new TableLayout(1);
        layout.setCellPadding(3);
        cp.setLayout(layout);
        montarCombo();
        cp.add(tx_locFornec);
        cp.add(comboFornec);
        window.add(cp);
        window.show();


    }

    public void montarCombo() {
        comboFornec.setStore(null);
        comboFornec.setDisplayField("for_tx_nome");
        comboFornec.setWidth(260);
        comboFornec.setEmptyText("Selecione o fornecedor");
        ///comboFornec.setTypeAhead(true);
        comboFornec.setTriggerAction(ComboBox.TriggerAction.ALL);
        
    }

    class ListenerReader implements IListenetResponse {

        public void read(JSONValue jsonValue) {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                Info.display("", "Título classificado!");
            }
        }
    }

    class ListenerUpdatectpFornec implements IListenetResponse {

        public void read(JSONValue jsonValue) {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                if (jsonObject.toString().indexOf("sucesso") > -1) {
                    store.getLoader().load();
                    Info.display("", "Alteração realizada com sucesso");
                } else {
                    getShowMsgErro("Erro ao tentar alterar título");
                }
            }
        }
    }

    class ListenerCadFornec implements IListenetResponse {

        public void read(JSONValue jsonValue) {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                JSONObject registro = resultado.get(1).isObject();
                int id = Integer.parseInt(EasyContainer.clearAspas(registro.get("id").toString()));
                if (id > 0) {
                    For_fornecedorTGWT for_fornecedorTGWT = new For_fornecedorTGWT();
                    for_fornecedorTGWT.setFor_nr_id(id);
                    for_fornecedorTGWT.setFor_tx_nome(for_tx_nome);
                    updateFornecCtp(for_tx_nome);
                }
            }
        }
    }
}
