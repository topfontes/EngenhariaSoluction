/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_comprometimento;

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
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.com_comprometimento.Com_comprometimentoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.com_comprometimento.Com_comprometimentoUpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.BaseEvent;
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
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class Vw_comprometimentoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_comprometimento/vw_comprometimentoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Vw_comprometimentoConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Plc_plano_contasTGWT> comboPlc = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ToolBar bar = new ToolBar();
    ContentPanel panel = new ContentPanel();
    private boolean previsto;

    public Vw_comprometimentoConsultGWT(boolean previsto) {
        try {

            this.previsto = previsto;
            String txt = previsto == true ? "Previsto" : "Realizado";

            this.setHeading("Comprometimento " + txt);

            listPlc_planoContasGWT.povoa();

            listObraGWT.povoar();

            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize(600, 600);
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Vw_comprometimentoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_comprometimentoTGWT>>(currency);

            getCpMaster().setTopComponent(bar);

            addCompToolbar();

            layout();

        } catch (Exception ex) {
            Window.alert("Erro " + ex.getMessage());
        }
    }

    public void createColumn() {
        configs = new ArrayList<ColumnConfig>();
        ColumnConfig column = null;

        SummaryColumnConfig<Double> plc_tx_nome_super = new SummaryColumnConfig<Double>("plc_tx_nome_super", "Classe", 200);
        SummaryColumnConfig<Double> plc_tx_nome = new SummaryColumnConfig<Double>("plc_tx_nome", "Sub-Classe", 200);
        SummaryColumnConfig<Double> mes = new SummaryColumnConfig<Double>("com_nr_mes", "Mês", 50);
        mes.setAlignment(HorizontalAlignment.RIGHT);

        SummaryColumnConfig<Double> ano = new SummaryColumnConfig<Double>("com_nr_ano", "Ano", 50);
        ano.setAlignment(HorizontalAlignment.RIGHT);

        SummaryColumnConfig<Double> valor = new SummaryColumnConfig<Double>("com_nr_valor", "Valor", 100);
        valor.setAlignment(HorizontalAlignment.RIGHT);
        valor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        valor.setSummaryType(SummaryType.SUM);
        valor.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        valor.setSummaryRenderer(new SummaryRenderer() {
            public String render(Number value, Map<String, Number> data) {
                return "Sub Total";
            }
        });

        configs.add(plc_tx_nome_super);
        configs.add(plc_tx_nome);
        configs.add(mes);
        configs.add(ano);
        configs.add(valor);


        GridCellRenderer<Vw_comprometimentoTGWT> btnDel = new GridCellRenderer<Vw_comprometimentoTGWT>() {

            private boolean init;

            public Object render(final Vw_comprometimentoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_comprometimentoTGWT> store, Grid<Vw_comprometimentoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_comprometimentoTGWT>>() {

                        public void handleEvent(GridEvent<Vw_comprometimentoTGWT> be) {
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
                            param.put("com_comprometimentoT.com_nr_id", model.getCom_nr_id() + "");
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

        SummaryColumnConfig<Double> edit = new SummaryColumnConfig<Double>("del", "", 30);
        edit.setRenderer(btnDel);
        configs.add(edit);
    }

    public void addCompToolbar() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {
                    createColumn();
                    bar.add(new LabelToolItem("Obra:"));
                    comboObra.setStore(listObraGWT.getStore());
                    comboObra.setValueField("obr_nr_id");
                    comboObra.setDisplayField("obr_tx_nome");
                    comboObra.setEmptyText("Selecione a obra");
                    bar.add(comboObra);
                    bar.add(new SeparatorToolItem());

                    bar.add(new LabelToolItem("Mês:"));
                    ListStore<Meses> storemeses = new ListStore<Meses>();
                    storemeses.add(listMes_AnoGWT.getMeses());
                    comboMes.setStore(storemeses);
                    comboMes.setDisplayField("display");
                    comboMes.setEmptyText("Selecione o Mês");
                    bar.add(comboMes);
                    bar.add(new SeparatorToolItem());

                    bar.add(new LabelToolItem("Ano:"));
                    ListStore<Ano> storeAno = new ListStore<Ano>();
                    storeAno.add(listMes_AnoGWT.getListAno());
                    comboAno.setStore(storeAno);
                    comboAno.setDisplayField("display");
                    comboAno.setEmptyText("Selecione o Ano");
                    comboAno.setWidth(80);
                    bar.add(comboAno);

                    bar.add(new SeparatorToolItem());
                    bar.add(new SeparatorToolItem());
                    bar.add(new SeparatorToolItem());
                    Button button = new Button("Filtrar");
                    button.setIcon(ICONS.filter());
                    button.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                        public void handleEvent(ButtonEvent be) {
                            load();
                        }
                    });
                    bar.add(button);
                    layout();
//                    setHeight(getHeight()+1);
                    layout();
//                    doLayout();
                }
            }
        };
        timer.schedule(500);
        //this.setHeight(this.getHeight()+1);
        layout();
        //doLayout();
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            List<Vw_comprometimentoTGWT> list = new Vector();
            
            for (int i = 1; i < resultado.size(); i++) {

                Vw_comprometimentoTGWT vw_comprometimentoTGWT = new Vw_comprometimentoTGWT();
                JSONObject registro = resultado.get(i).isObject();

                Integer com_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("com_nr_id").toString()));
                vw_comprometimentoTGWT.setCom_nr_id(com_nr_id);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                vw_comprometimentoTGWT.setObr_nr_id(obr_nr_id);

                Integer com_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("com_nr_mes").toString()));
                vw_comprometimentoTGWT.setCom_nr_mes(com_nr_mes);

                Integer com_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("com_nr_ano").toString()));
                vw_comprometimentoTGWT.setCom_nr_ano(com_nr_ano);

                Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                vw_comprometimentoTGWT.setPlc_nr_id(plc_nr_id);

                String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                vw_comprometimentoTGWT.setPlc_tx_nome(plc_tx_nome);

                String plc_tx_nome_super = EasyContainer.clearAspas(registro.get("plc_tx_nome_super").toString());
                vw_comprometimentoTGWT.setPlc_tx_nome_super(plc_tx_nome_super);

                double com_nr_valor = Double.parseDouble(EasyContainer.clearAspas(registro.get("com_nr_valor").toString()));
                vw_comprometimentoTGWT.setCom_nr_valor(com_nr_valor);
                list.add(vw_comprometimentoTGWT);
            }

            GroupingStore<Vw_comprometimentoTGWT> store = new GroupingStore<Vw_comprometimentoTGWT>();
            store.add(list);
            store.groupBy("plc_tx_nome_super");

            GroupSummaryView view = new GroupSummaryView();
            view.setForceFit(true);
            view.setShowGroupedColumn(false);
            
            ColumnModel cm = new ColumnModel(configs);
            AggregationRowConfig<Vw_comprometimentoTGWT> aGtotal = new AggregationRowConfig<Vw_comprometimentoTGWT>();
            aGtotal.setSummaryType("com_nr_valor", SummaryType.SUM);
            aGtotal.setSummaryFormat("com_nr_valor", NumberFormat.getFormat("#,##0.00"));

            cm.addAggregationRow(aGtotal);

            Grid<Vw_comprometimentoTGWT> grid = new Grid<Vw_comprometimentoTGWT>(store, cm);
            grid.setLoadMask(true);
            grid.setView(view);

            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Vw_comprometimentoTGWT>>() {

                public void handleEvent(GridEvent<Vw_comprometimentoTGWT> be) {
                    Vw_comprometimentoUpdateDeleteGWT vw_comprometimentoUpdateDeleteGWT = new Vw_comprometimentoUpdateDeleteGWT(previsto);
                    vw_comprometimentoUpdateDeleteGWT.load(be.getModel());
                    vw_comprometimentoUpdateDeleteGWT.setConsultGWT(consultGWT);
                    vw_comprometimentoUpdateDeleteGWT.show();
                }
            });

            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);
            getCpMaster().removeAll();
            getCpMaster().add(grid);
            this.layout();
            this.doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Vw_comprometimentoInsertGWT insert;
        try {
            insert = new Vw_comprometimentoInsertGWT(previsto);
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
            param.put("vw_comprometimentoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("vw_comprometimentoT.com_nr_mes", comboMes.getValue().getValue() + "");
            param.put("vw_comprometimentoT.com_nr_ano", comboAno.getValue().getValue() + "");
            param.put("previsto", previsto + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
            List list = getCpMaster().getItems();
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
