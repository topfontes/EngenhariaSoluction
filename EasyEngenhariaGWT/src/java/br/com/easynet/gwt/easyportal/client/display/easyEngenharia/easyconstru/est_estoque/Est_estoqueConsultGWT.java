/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.est_estoque;

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
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

import java.util.HashMap;
import java.util.Map;

import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Status;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Est_estoqueConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/est_estoque/est_estoqueConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Est_estoqueConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ComboBox<Plc_plano_contasTGWT> ComboSubClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Plc_plano_contasTGWT> ComboClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ListPlc_planoContasGWT listSubClasseGWT = new ListPlc_planoContasGWT();
    private ListPlc_planoContasGWT listClasseGWT = new ListPlc_planoContasGWT();
    private LayoutContainer layoutContainer = new LayoutContainer();
    private ToolBar bar = new ToolBar();
    private LayoutContainer containerPeriodo = new LayoutContainer();
    private LayoutContainer containerMes = new LayoutContainer();
    private LayoutContainer containerAno = new LayoutContainer();
    FieldSet fsMes = new FieldSet();
    private Button pesquisar = new Button("  pesquisar  ");
    private Status displayTotal = new Status();
    private Status valueTotal = new Status();
    private ToolBar toolbarTotal = new ToolBar();
    private GroupingStore<Est_estoqueTGWT> store;

    public void povoaComboMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(store);
        comboMes.setDisplayField("display");
        comboMes.setFieldLabel("Mês");
        comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboMes.setWidth("250");

    }

    public void povoaComboObra() {
        try {
            comboObra.setStore(listObraGWT.getStore());
            comboObra.setDisplayField("obr_tx_nome");
            comboObra.setAllowBlank(false);
            comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
            comboObra.setWidth("250");
        } catch (Exception e) {
        }
    }

    public void povoaSubClasse() {
        try {
            ComboSubClasse.setStore(listSubClasseGWT.getStore());
            ComboSubClasse.setDisplayField("plc_tx_nome");
            ComboSubClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
            ComboSubClasse.setWidth("250");
        } catch (Exception e) {
        }
    }

    public void povoaCalsse() {
        try {
            ComboClasse.setStore(listClasseGWT.getStore());
            ComboClasse.setDisplayField("plc_tx_nome");
            ComboClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
            ComboClasse.setWidth("250");
        } catch (Exception e) {
        }
    }

    public void povoaAno() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(store);
        comboAno.setDisplayField("display");
        comboAno.setFieldLabel("Ano");
        comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboAno.setWidth("250");
    }

    private void mostrar() {
        super.show();
        maximize();
    }

    @Override
    protected void onHide() {
        super.onHide();
        getCpMaster().removeAll();
        getCpRight().removeAll();

    }


    @Override
    public void show() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listSubClasseGWT.isInserido()) {
                    schedule(2000);
                } else {
                    getDataEAST().setSize(280);
                    getCpRight().setWidth(280);
                    povoaComboMes();
                    povoaComboObra();
                    povoaSubClasse();
                    povoaAno();
                    montarPanelFiltro();
                    consultGWT.mostrar();
                    consultGWT.layout();
                }
            }
        };
        timer.schedule(2000);
    }

    public Est_estoqueConsultGWT() {
        try {
            this.setHeading("Estoque");
            getDataNORTH().setSize(27);
            getCpLeft().setVisible(false);
            getDataWEST().setHidden(true);
            displayTotal.setText("Total Geral:");
            valueTotal.setText("0,00");
            //valueTotal.setWidth(100);
            valueTotal.setBox(true);

            listObraGWT.povoar();
            listSubClasseGWT.povoa();

            pesquisar.setIcon(ICONS.filter());
            pesquisar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    load();
                }
            });

            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Est_estoqueTGWT>> numberRenderer = new NumberCellRenderer<Grid<Est_estoqueTGWT>>(currency);

            SummaryColumnConfig column;

            SummaryColumnConfig est_tx_nome = new SummaryColumnConfig("est_tx_nome", "Descrição", 150);
            SummaryColumnConfig grupo = new SummaryColumnConfig("plc_tx_nome", "Sub-Classe", 100);
            SummaryColumnConfig mes = new SummaryColumnConfig("est_nr_mes", "Mês", 17);
            mes.setNumberFormat(NumberFormat.getFormat("00"));

            SummaryColumnConfig ano = new SummaryColumnConfig("est_nr_ano", "Ano", 17);
            ano.setSummaryType(SummaryType.COUNT);
            ano.setSummaryRenderer(new SummaryRenderer() {

                public String render(Number value, Map<String, Number> data) {
                    return value.intValue() > 1 ? "(" + value.intValue() + " Itens)" : "(1 Item)";
                }
            });

            SummaryColumnConfig unidade = new SummaryColumnConfig("est_tx_unidade", "Unidade", 17);
            SummaryColumnConfig Quantidade = new SummaryColumnConfig("est_nr_quantidade", "Quant", 18);

//            Quantidade.setSummaryType(SummaryType.SUM);
//            Quantidade.setAlignment(HorizontalAlignment.RIGHT);

            SummaryColumnConfig vlUnit = new SummaryColumnConfig("est_nr_vl_unitario", "Vl. Unitário", 30);
            vlUnit.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
            vlUnit.setAlignment(HorizontalAlignment.RIGHT);
//            vlUnit.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
//            vlUnit.setSummaryType(SummaryType.AVG);

            SummaryColumnConfig total = new SummaryColumnConfig("est_nr_vl_total", "Total", 30);
            total.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
            total.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
            total.setAlignment(HorizontalAlignment.RIGHT);
            total.setSummaryType(SummaryType.SUM);



            GridCellRenderer<Est_estoqueTGWT> btnDel = new GridCellRenderer<Est_estoqueTGWT>() {

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
                    Button btnCol = new Button("", new SelectionListener<ButtonEvent>() {

                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            try {
                                EasyAccessURL eaurl = new EasyAccessURL(consultGWT);
                                HashMap<String, String> param = new HashMap<String, String>();
                                param.put("op", "delete");
                                param.put("est_estoqueT.est_nr_id", model.getEst_nr_id() + "");
                                eaurl.accessJSonMap(Constantes.URL + PAGE, param);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Deletar");
                    btnCol.setIcon(ICONS.del());

                    return btnCol;
                }
            };

            SummaryColumnConfig delete = new SummaryColumnConfig();
            delete.setId("del");
            delete.setHeader("");
            delete.setWidth(30);
            delete.setAlignment(HorizontalAlignment.LEFT);
            delete.setRenderer(btnDel);

            configs.add(est_tx_nome);
            configs.add(grupo);
            configs.add(unidade);
            configs.add(mes);
            configs.add(ano);
            configs.add(Quantidade);
            configs.add(vlUnit);
            configs.add(total);
//            configs.add(delete);


            layout();
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
    }

    public void montarPanelFiltro() {
        bar.removeAll();
        getCpRight().removeAll();
        layoutContainer.removeAll();

        layoutContainer.setLayout(new FormLayout());
        FormLayout formLayout = new FormLayout();
        formLayout.setLabelAlign(LabelAlign.TOP);

        layoutContainer.setLayout(formLayout);

        FieldSet fsObra = new FieldSet();
        fsObra.setCollapsible(true);
        fsObra.setHeading("Obra");
        fsObra.add(comboObra);
        layoutContainer.add(fsObra);

        FieldSet fsMes = new FieldSet();
        //fsMes.removeAll();
        fsMes.setAutoWidth(true);
        fsMes.setCollapsible(true);
        fsMes.setHeading("Mês de Referência");
        fsMes.add(getLayoutContainerMes());
        layoutContainer.add(fsMes);

        FieldSet fsClasse = new FieldSet();
        fsClasse.setCollapsible(true);
        fsClasse.setHeading("Sub-Classe");
        fsClasse.add(ComboSubClasse);
        layoutContainer.add(fsClasse);

        getCpRight().add(layoutContainer);

        bar.add(pesquisar);
        bar.add(new SeparatorToolItem());
        bar.add(displayTotal);
        bar.add(new LabelToolItem(""));
        bar.add(valueTotal);
        //layoutContainer.add(bar);
        getCpRight().setBottomComponent(bar);

        layout();
    }

    public LayoutContainer getLayoutContainerMes() {


        TableLayout tlayout = new TableLayout(1);
        tlayout.setCellPadding(7);
        containerAno.removeAll();
        containerPeriodo = new LayoutContainer();
        containerPeriodo.setLayout(tlayout);

        containerPeriodo.add(comboMes);
        containerPeriodo.add(comboAno);

        return containerPeriodo;
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        float total = 0;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            //ListStore<Est_estoqueTGWT> store = new ListStore<Est_estoqueTGWT>();

            List<Est_estoqueTGWT> listEstoque = new ArrayList<Est_estoqueTGWT>();
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
                total += est_nr_vl_total;

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                est_estoqueTGWT.setObr_nr_id(obr_nr_id);

                Integer est_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("est_nr_ano").toString()));
                est_estoqueTGWT.setEst_nr_ano(est_nr_ano);

                String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                est_estoqueTGWT.setPlc_tx_nome(plc_tx_nome);

                String est_tx_unidade = EasyContainer.clearAspas(registro.get("est_tx_unidade").toString());
                est_estoqueTGWT.setEst_tx_unidade(est_tx_unidade);

                String est_tx_nome = EasyContainer.clearAspas(registro.get("est_tx_nome").toString());
                est_estoqueTGWT.setEst_tx_nome(est_tx_nome);

                listEstoque.add(est_estoqueTGWT);

            }


            setStore(new GroupingStore<Est_estoqueTGWT>());
            getStore().groupBy("plc_tx_nome");
            getStore().add(listEstoque);

            ColumnModel cm = new ColumnModel(configs);
            GroupSummaryView grupoView = new GroupSummaryView();
            grupoView.setForceFit(true);
            grupoView.setShowGroupedColumn(false);

            Grid<Est_estoqueTGWT> grid = new Grid<Est_estoqueTGWT>(getStore(), cm);
            grid.setBorders(true);
            grid.setView(grupoView);
            grid.getView().setShowDirtyCells(false);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Est_estoqueTGWT>>() {

                public void handleEvent(GridEvent<Est_estoqueTGWT> be) {
                    Est_estoqueUpdateDeleteGWT est_estoqueUpdateDeleteGWT = new Est_estoqueUpdateDeleteGWT();
                    est_estoqueUpdateDeleteGWT.load(be.getModel());
                    est_estoqueUpdateDeleteGWT.setConsultGWT(consultGWT);
                    est_estoqueUpdateDeleteGWT.show();
                }
            });

            getCpMaster().removeAll();
            getCpMaster().add(grid);
            valueTotal.setText(NumberFormat.getFormat("#,##0.00").format(total));
            this.layout();
            this.doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Est_estoqueInsertGWT insert;
        try {
            insert = new Est_estoqueInsertGWT();
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

            if (comboMes.getValue() != null) {
                param.put("est_estoqueT.est_nr_mes", comboMes.getValue().getValue() + "");
            }
            if (ComboSubClasse.getValue() != null) {
                param.put("est_estoqueT.plc_nr_id", ComboSubClasse.getValue().getPlc_nr_id() + "");
            }
            if (comboObra.getValue() != null) {
                param.put("est_estoqueT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            }
            param.put("est_estoqueT.est_nr_ano", comboAno.getValue().getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");

            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the store
     */
    public GroupingStore<Est_estoqueTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(GroupingStore<Est_estoqueTGWT> store) {
        this.store = store;
    }
}

