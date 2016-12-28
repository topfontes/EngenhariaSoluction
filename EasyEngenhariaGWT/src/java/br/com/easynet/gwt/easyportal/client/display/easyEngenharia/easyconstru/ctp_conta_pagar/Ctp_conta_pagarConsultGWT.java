/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.ComboboxGeneric;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.extjs.gxt.ui.client.event.ComponentEvent;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.Obr_obrasConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.Plc_plano_contasConsultGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
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
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author geoleite
 */
public class Ctp_conta_pagarConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    final private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Ctp_conta_pagarConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ComboBox<Plc_plano_contasTGWT> ComboSubClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Plc_plano_contasTGWT> ComboClasse = new ComboBox<Plc_plano_contasTGWT>();
    private String status;
    private Button pesquisar = new Button(" Pesquisar ");
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ListPlc_planoContasGWT listSubClasseGWT = new ListPlc_planoContasGWT();
    private ListPlc_planoContasGWT listClasseGWT = new ListPlc_planoContasGWT();
    private LayoutContainer layoutContainer = new LayoutContainer();
    private ToolBar bar = new ToolBar();
    private LayoutContainer containerPeriodo = new LayoutContainer();
    private LayoutContainer containerMes = new LayoutContainer();
    private LayoutContainer containerAno = new LayoutContainer();
    private float total;
    public GroupingStore<Ctp_conta_pagarTGWT> store;
    //FieldSet fsMes = new FieldSet();

    public Ctp_conta_pagarConsultGWT(String status) {
        try {
            listObraGWT.povoar();
            listClasseGWT.povoaSuperClasse();
            listSubClasseGWT.povoa();
            pesquisar.setIcon(ICONS.filter());
            pesquisar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    load();
                }
            });
            this.status = status;
            final String sta = status;
            this.setHeading(status.equalsIgnoreCase("A") ? "Consulta Conta a Pagar" : "Consulta Conta Pagas");
            this.setMaximizable(true);
            getDataNORTH().setSize(27);
            getCpLeft().setVisible(false);
            getDataWEST().setHidden(true);

            getDataEAST().setSize(280);
            getCpRight().setWidth(280);
            getCpRight().setHeading("Opções de Filtro");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Ctp_conta_pagarTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ctp_conta_pagarTGWT>>(currency);

            SummaryColumnConfig<Integer> documento = new SummaryColumnConfig<Integer>("ctp_nr_documento", "Documento", 50);
            SummaryColumnConfig<Float> vencimento = new SummaryColumnConfig<Float>("ctp_dt_vencimento", "Vencimento", 60);
            vencimento.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
            documento.setSummaryType(SummaryType.COUNT);
            documento.setSummaryRenderer(new SummaryRenderer() {

                public String render(Number value, Map<String, Number> data) {
                    return value.intValue() > 1 ? "(" + value.intValue() + " Items)" : "(1 Item)";
                }
            });

            SummaryColumnConfig<Double> classe = new SummaryColumnConfig<Double>("plc_tx_nome_super", "Classe", 50);
            SummaryColumnConfig<Double> fornecedor = new SummaryColumnConfig<Double>("ctp_tx_fornecedor", "Fornecedor", 100);
            SummaryColumnConfig<Double> subclasse = new SummaryColumnConfig<Double>("plc_tx_nome", "Sub-Classe", 100);
            SummaryColumnConfig<Double> columnMes = new SummaryColumnConfig<Double>("ctp_nr_mes", "Mês", 30);
            columnMes.setNumberFormat(NumberFormat.getFormat("00"));
            SummaryColumnConfig<Double> columnAno = new SummaryColumnConfig<Double>("ctp_nr_ano", "Ano", 30);

            columnAno.setAlignment(HorizontalAlignment.LEFT);

            SummaryColumnConfig<Double> valor = new SummaryColumnConfig<Double>("ctp_nr_valor", "Valor", 50);
            valor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
            valor.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
            valor.setAlignment(HorizontalAlignment.RIGHT);
            valor.setSummaryType(SummaryType.SUM);


            configs.add(documento);
            configs.add(vencimento);
            configs.add(classe);
            configs.add(fornecedor);
            configs.add(subclasse);
            configs.add(columnMes);
            configs.add(columnAno);
            configs.add(valor);


            GridCellRenderer<Ctp_conta_pagarTGWT> btnDel = new GridCellRenderer<Ctp_conta_pagarTGWT>() {

                private boolean init;

                public Object render(final Ctp_conta_pagarTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Ctp_conta_pagarTGWT> store, Grid<Ctp_conta_pagarTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Ctp_conta_pagarTGWT>>() {

                            public void handleEvent(GridEvent<Ctp_conta_pagarTGWT> be) {
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
                                param.put("ctp_conta_pagarT.ctp_nr_id", model.getCtp_nr_id() + "");
                                param.put("ctp_conta_pagarT.ctp_tx_status", sta);
                                param.put("id_super_classe", ComboClasse.getValue() == null ? "0" : ComboClasse.getValue().getPlc_nr_id() + "");
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
            SummaryColumnConfig column = null;

            column = new SummaryColumnConfig();
            column.setId("del");
            column.setHeader("");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setRenderer(btnDel);
            configs.add(column);


        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
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
                    Info.display("", "Aguarde !!!");
                    schedule(2000);
                } else {
                    getDataEAST().setSize(280);
                    getCpRight().setWidth(280);
                    povoaComboMes();
                    povoaComboObra();
                    povoaSubClasse();
                    povoaCalsse();
                    povoaAno();
                    montarPanelFiltro();
                    consultGWT.mostrar();
                    consultGWT.layout();
                }
            }
        };
        timer.schedule(2000);
    }

    public void povoaComboMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(store);
        comboMes.setAllowBlank(false);
        comboMes.setDisplayField("display");
        comboMes.setFieldLabel("Mês");
        comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboMes.setWidth(250);
        comboMes.setEmptyText("Selecione o mês");
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
        comboAno.setAllowBlank(false);
        comboAno.setDisplayField("display");
        comboAno.setFieldLabel("Ano");
        comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboAno.setWidth(250);
        comboAno.setEmptyText("Selecione o Ano");
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
        fsMes.setAutoWidth(true);
        fsMes.setCollapsible(true);
        fsMes.setHeading("Período de Referência");
        fsMes.add(getLayoutContainerMes());
        layoutContainer.add(fsMes);

        FieldSet fsClasse = new FieldSet();
        fsClasse.setCollapsible(true);
        fsClasse.setHeading("Sub-Classe");
        fsClasse.add(ComboSubClasse);
        layoutContainer.add(fsClasse);

        FieldSet fsSuperClasse = new FieldSet();
        fsSuperClasse.setCollapsible(true);
        fsSuperClasse.setHeading("Classe");
        fsSuperClasse.add(ComboClasse);
        layoutContainer.add(fsSuperClasse);

        getCpRight().add(layoutContainer);

        bar.add(pesquisar);

        bar.add(new SeparatorToolItem());
        bar.add(new SeparatorToolItem());
        bar.add(new SeparatorToolItem());
        //layoutContainer.add(bar);
        getCpRight().setBottomComponent(bar);

        layout();
    }

    public void clearLancamento() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delconta");
            param.put("ctp_conta_pagarT.ctp_tx_status", "A");
            param.put("ctp_conta_pagarT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        total = 0;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            List<Ctp_conta_pagarTGWT> listCtp = new ArrayList<Ctp_conta_pagarTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Ctp_conta_pagarTGWT ctp_conta_pagarTGWT = new Ctp_conta_pagarTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer ctp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_id").toString()));
                ctp_conta_pagarTGWT.setCtp_nr_id(ctp_nr_id);

                String for_tx_nome = EasyContainer.clearAspas(registro.get("ctp_tx_fornecedor").toString());
                ctp_conta_pagarTGWT.setCtp_tx_fornecedor(for_tx_nome);

                Integer ctp_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_mes").toString()));
                ctp_conta_pagarTGWT.setCtp_nr_mes(ctp_nr_mes);

                Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                ctp_conta_pagarTGWT.setPlc_nr_id(plc_nr_id);

                double ctp_nr_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("ctp_nr_valor").toString()));
                ctp_conta_pagarTGWT.setCtp_nr_valor(ctp_nr_valor);
                total += ctp_nr_valor;

                String ctp_nr_documento = EasyContainer.clearAspas(registro.get("ctp_nr_documento").toString());
                ctp_conta_pagarTGWT.setCtp_nr_documento(ctp_nr_documento);

                String ctp_tx_status = EasyContainer.clearAspas(registro.get("ctp_tx_status").toString());
                ctp_conta_pagarTGWT.setCtp_tx_status(ctp_tx_status);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                ctp_conta_pagarTGWT.setObr_nr_id(obr_nr_id);

                Integer ctp_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_ano").toString()));
                ctp_conta_pagarTGWT.setCtp_nr_ano(ctp_nr_ano);

                String obr_tx_nome = EasyContainer.clearAspas(registro.get("obr_tx_nome").toString());
                ctp_conta_pagarTGWT.setObr_tx_nome(obr_tx_nome);

                String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                ctp_conta_pagarTGWT.setPlc_tx_nome(plc_tx_nome);

                String plc_tx_nome_super = EasyContainer.clearAspas(registro.get("plc_tx_nome_super").toString());
                ctp_conta_pagarTGWT.setPlc_tx_nome_super(plc_tx_nome_super);

                String vencimento = EasyContainer.clearAspas(registro.get("ctp_dt_vencimento").toString());
                if (vencimento.trim().length() > 0) {
                    DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
                    Date dtvencimento = dtf.parse(vencimento);
                    ctp_conta_pagarTGWT.setCtp_dt_vencimento(dtvencimento);
                }

                listCtp.add(ctp_conta_pagarTGWT);
            }

            ColumnModel cm = new ColumnModel(configs);

            GroupSummaryView grupoView = new GroupSummaryView();
            grupoView.setForceFit(true);
            grupoView.setShowGroupedColumn(false);

            PagingModelMemoryProxy memoryProxy = new PagingModelMemoryProxy(listCtp);
            PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(memoryProxy);
            loader.setRemoteSort(true);

            store = new GroupingStore<Ctp_conta_pagarTGWT>(loader);
            store.add(listCtp);
            store.groupBy("plc_tx_nome_super");
            getToolBarPage().setPageSize(20);
            getToolBarPage().bind(loader);
            loader.load(0, 20);

            NumberFormat format = NumberFormat.getFormat("#,##0.00");
            String strTotal = "Total Geral:  " + format.format(total);
            AggregationRowConfig<Vw_equiv_insumo_pmsTGWT> averages = new AggregationRowConfig<Vw_equiv_insumo_pmsTGWT>();
            averages.setHtml("ctp_nr_valor", strTotal);

            averages.setSummaryType("ctp_nr_valor", SummaryType.SUM);
            averages.setSummaryFormat("ctp_nr_valor", NumberFormat.getFormat("#,##0.00"));

            //averages.set
            cm.addAggregationRow(averages);
            EditorGrid<Ctp_conta_pagarTGWT> grid = new EditorGrid<Ctp_conta_pagarTGWT>(store, cm);
            grid.setBorders(true);
            grid.setView(grupoView);
            grid.getView().setShowDirtyCells(false);

            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Ctp_conta_pagarTGWT>>() {

                public void handleEvent(GridEvent<Ctp_conta_pagarTGWT> be) {
                    Ctp_conta_pagarUpdateDeleteGWT ctp_conta_pagarUpdateDeleteGWT = new Ctp_conta_pagarUpdateDeleteGWT(status);
                    ctp_conta_pagarUpdateDeleteGWT.setListObra(listObraGWT);
                    ctp_conta_pagarUpdateDeleteGWT.setListPlc(listSubClasseGWT);
                    For_fornecedorTGWT for_fornecedorTGWT = new For_fornecedorTGWT();
                    Ctp_conta_pagarTGWT ctpT = (Ctp_conta_pagarTGWT) be.getModel();
                    for_fornecedorTGWT.setFor_tx_nome(ctpT.getCtp_tx_fornecedor());
                    for_fornecedorTGWT.setFor_nr_id(0);
                    ctp_conta_pagarUpdateDeleteGWT.getListFornecedorGWT().getStore().add(for_fornecedorTGWT);
                    ctp_conta_pagarUpdateDeleteGWT.load(be.getModel());
                    ctp_conta_pagarUpdateDeleteGWT.setConsultGWT(consultGWT);
                    ctp_conta_pagarUpdateDeleteGWT.show();
                }
            });

            getCpMaster().removeAll();
            grid.setStripeRows(true);
            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Ctp_conta_pagarInsertGWT insert;
        try {
            
            insert = new Ctp_conta_pagarInsertGWT(status);
            insert.addLisClasse(listSubClasseGWT.getStore());
            insert.addlistObra(listObraGWT.getStore());
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
            param.put("ctp_conta_pagarT.ctp_tx_status", this.status);

            if (comboMes.getValue() != null) {
                param.put("ctp_conta_pagarT.ctp_nr_mes", comboMes.getValue().getValue() + "");
            }
            if (ComboSubClasse.getValue() != null) {
                param.put("ctp_conta_pagarT.plc_nr_id", ComboSubClasse.getValue().getPlc_nr_id() + "");
            }

            param.put("id_super_classe", ComboClasse.getValue() == null ? "0" : ComboClasse.getValue().getPlc_nr_id() + "");

            if (comboObra.getValue() != null) {
                param.put("ctp_conta_pagarT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            }

            param.put("ctp_conta_pagarT.ctp_nr_ano", comboAno.getValue().getValue() + "");

            eaurl.accessJSonMap(Constantes.URL + PAGE, param);


            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

