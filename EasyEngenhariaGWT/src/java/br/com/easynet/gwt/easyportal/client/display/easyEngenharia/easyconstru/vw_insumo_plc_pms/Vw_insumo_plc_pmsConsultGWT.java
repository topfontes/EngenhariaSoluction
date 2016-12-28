/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_insumo_plc_pms;

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
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geoleite
 */
public class Vw_insumo_plc_pmsConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_insumo_plc_pms/vw_insumo_plc_pmsConsultGWT.jsp";
    public static final String PAGE_REL = "easyEngenharia/easyconstru/relatorios/custo_plc_pms.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Vw_insumo_plc_pmsConsultGWT consultGWT = this;
    ComboBox<Meses> comboMes = new ComboBox<Meses>();
    ComboBox<Ano> comboAno = new ComboBox<Ano>();
    ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    ListObraGWT listObraGWT = new ListObraGWT();
    ToolBar toolBar = new ToolBar();
    Button b = new Button("Filtrar");
    Button imprimir = new Button("Download");
    CheckBox chkAcumulado = new CheckBox();
    private String tipo;
    private MessageBox mb = new MessageBox();
    private IListenetResponse response;

    public Vw_insumo_plc_pmsConsultGWT(String tipo) {
        this.tipo = tipo;
        try {
            if (tipo.equalsIgnoreCase("plc")) {
                this.setHeading("Custos Previstos por Sub-Classes (PMS)");
                createColumPlc();
            } else {
                this.setHeading("Custo Insumos PMS");
                createColumnPlco();
            }
            getToolBarMaster().setVisible(false);
            getCpTop().setTopComponent(toolBar);
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("750", "500");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Vw_insumo_plc_pmsTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_insumo_plc_pmsTGWT>>(currency);

            b.setIcon(ICONS.filter());
            b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    load();
                }
            });

            imprimir.setIcon(ICONS.download());
            imprimir.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    print();
                }
            });

            chkAcumulado.setBoxLabel("Acumulado");
            chkAcumulado.setValue(false);
            layout();
            listObraGWT.povoar();
            montar();

        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
    }

    public void createColumPlc() {
        SummaryColumnConfig<Integer> plc_tx_nome = new SummaryColumnConfig<Integer>("plc_tx_nome", "Sub Classe", 400);

        if (tipo.equalsIgnoreCase("plc")) {
            plc_tx_nome.setSummaryType(SummaryType.COUNT);
            plc_tx_nome.setSummaryRenderer(new SummaryRenderer() {

                public String render(Number value, Map<String, Number> data) {
                    return value.intValue() > 1 ? "(" + value.intValue() + " Items)" : "(1 Item)";
                }
            });
        }

        configs.add(plc_tx_nome);
        SummaryColumnConfig<Double> plc_tx_nome_super = new SummaryColumnConfig<Double>("plc_tx_nome_super", "Classe", 65);
        configs.add(plc_tx_nome_super);

        SummaryColumnConfig<Double> total = new SummaryColumnConfig<Double>("vl_total", "Total", 150);
        total.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        total.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        total.setAlignment(HorizontalAlignment.RIGHT);
        total.setSummaryType(SummaryType.SUM);

        configs.add(total);

        SummaryColumnConfig qtde = new SummaryColumnConfig<Double>("quantidade", "Quantidade", 150);
        qtde.setWidth(120);
        qtde.setAlignment(HorizontalAlignment.RIGHT);
        qtde.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        configs.add(qtde);

    }

    public void createColumnPlco() {
        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("plc_tx_nome");
        column.setHeader("Sub Classe");
        column.setWidth(400);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("vl_total");
        column.setHeader("Total");
        column.setWidth(120);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        configs.add(column);

        column = new ColumnConfig();
        column.setId("und");
        column.setHeader("UND");
        column.setWidth(50);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("quantidade");
        column.setHeader("Quantidade");
        column.setWidth(120);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        configs.add(column);
    }

    public void print() {
        try {

            mb = MessageBox.wait("Requisicao", "Requisitando a servidor", "Aguarde.......!!!");

            final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
            String url = Constantes.URL + PAGE_REL;
            url += "?op=imprimir";
            url += "&tipo=" + tipo;
            String ac = chkAcumulado.getValue() ? "true" : "false";
            url += "&acumulado=" + ac;
            url += "&vw_insumo_plc_pmsT.obr_nr_id=" + comboObra.getValue().getObr_nr_id();
            url += "&vw_insumo_plc_pmsT.pms_nr_mes=" + comboMes.getValue().getValue();
            url += "&vw_insumo_plc_pmsT.pms_nr_ano=" + comboAno.getValue().getValue();
            winDownload.setSize(100, 100);
            winDownload.setResizable(false);
            winDownload.show();
            layout();
            //winDownload.addText("Agaurde.!!");

            winDownload.setUrl(url);

            response = new IListenetResponse() {

                public void read(JSONValue jsonValue) {
                    JSONObject jsonObject = jsonValue.isObject();

                    String resposta = EasyContainer.clearAspas(jsonObject.get("resultado").toString());
                    boolean fechar = Boolean.parseBoolean(resposta);
                    if (fechar) {                        
                        winDownload.setVisible(false);                        
                        mb.close();                        
                    } else {
                        getResposta();
                    }

                }
            };
            getResposta();

        } catch (Exception e) {
        }

    }

    public void getResposta() {
        try {
            final String url_resposta = Constantes.URL + "responseSession.jsp?op=realizado";
            final EasyAccessURL accessURL = new EasyAccessURL(response);

            Timer t = new Timer() {

                @Override
                public void run() {
                    try {
                        accessURL.accessJSonNoProgress(url_resposta);
                    } catch (Exception ex) {
                        Logger.getLogger(Vw_insumo_plc_pmsConsultGWT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            t.schedule(1000);

        } catch (Exception e) {
        }

    }

    public void montar() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(2000);
                    Info.display("", "Aguarde....!");
                } else {
                    addlistObra();
                    addListAno();
                    addListMes();
                    toolBar.add(new LabelToolItem("Obra:"));
                    toolBar.add(comboObra);
                    toolBar.add(new LabelToolItem("Mês:"));
                    toolBar.add(comboMes);
                    toolBar.add(new LabelToolItem("Ano:"));
                    toolBar.add(comboAno);
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(chkAcumulado);
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(b);
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(imprimir);

                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(2000);
    }

    public void addListAno() {
        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(storeAno);
        comboAno.setDisplayField("display");
        comboAno.setWidth(70);
    }

    public void addListMes() {
        ListStore<Meses> storeMeses = new ListStore<Meses>();
        storeMeses.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(storeMeses);
        comboMes.setDisplayField("display");
        comboMes.setWidth(100);
    }

    public void addlistObra() {
        try {
            ListStore<Obr_obrasTGWT> storeObra = new ListStore<Obr_obrasTGWT>();
            storeObra = listObraGWT.getStore();
            comboObra.setStore(storeObra);
            comboObra.setDisplayField("obr_tx_nome");
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        //getMbMaster().close();
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            List<Vw_insumo_plc_pmsTGWT> list = new Vector();
            for (int i = 1; i < resultado.size(); i++) {
                Vw_insumo_plc_pmsTGWT vw_insumo_plc_pmsTGWT = new Vw_insumo_plc_pmsTGWT();
                JSONObject registro = resultado.get(i).isObject();

                String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                vw_insumo_plc_pmsTGWT.setPlc_tx_nome(plc_tx_nome);

                float vl_total = Float.parseFloat(EasyContainer.clearAspas(registro.get("vl_total").toString()));
                vw_insumo_plc_pmsTGWT.setVl_total(vl_total);

                float qtde = Float.parseFloat(EasyContainer.clearAspas(registro.get("quantidade").toString()));
                vw_insumo_plc_pmsTGWT.setQuantidade(qtde);

                if (tipo.equalsIgnoreCase("plc")) {
                    String plc_tx_nome_super = EasyContainer.clearAspas(registro.get("plc_tx_nome_super").toString());
                    vw_insumo_plc_pmsTGWT.setPlc_tx_nome_super(plc_tx_nome_super);
                }
                String und = EasyContainer.clearAspas(registro.get("und").toString());
                vw_insumo_plc_pmsTGWT.setUnd(und);

                list.add(vw_insumo_plc_pmsTGWT);
            }

            GroupingStore<Vw_insumo_plc_pmsTGWT> storeGroup = null;
            ListStore<Vw_insumo_plc_pmsTGWT> store = null;
            GroupSummaryView summary = null;
            if (tipo.equalsIgnoreCase("plc")) {
                storeGroup = new GroupingStore<Vw_insumo_plc_pmsTGWT>();
                storeGroup.groupBy("plc_tx_nome_super");
                storeGroup.add(list);
                summary = new GroupSummaryView();
                summary.setForceFit(true);
                summary.setShowGroupedColumn(false);
                summary.setShowDirtyCells(true);
            } else {
                store = new ListStore<Vw_insumo_plc_pmsTGWT>();
                store.add(list);
            }

            ColumnModel cm = new ColumnModel(configs);

            AggregationRowConfig<Vw_insumo_plc_pmsTGWT> averages = new AggregationRowConfig<Vw_insumo_plc_pmsTGWT>();
            averages.setHtml("plc_tx_nome", "Total");
            averages.setSummaryType("vl_total", SummaryType.SUM);
            averages.setSummaryFormat("vl_total", NumberFormat.getFormat("#,##0.00"));

            cm.addAggregationRow(averages);
            Grid<Vw_insumo_plc_pmsTGWT> grid = null;
            if (tipo.equalsIgnoreCase("plc")) {
                grid = new Grid<Vw_insumo_plc_pmsTGWT>(storeGroup, cm);
                grid.setView(summary);
                grid.getView().setShowDirtyCells(false);
            } else {
                grid = new Grid<Vw_insumo_plc_pmsTGWT>(store, cm);

            }
            grid.setBorders(true);
            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);
            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.setStripeRows(true);

            getCpMaster().setFrame(true);
            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Vw_insumo_plc_pmsInsertGWT insert;
        try {
            insert = new Vw_insumo_plc_pmsInsertGWT();
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
            param.put("acumulado", chkAcumulado.getValue() ? "true" : "false");
            param.put("tipo", tipo);
            param.put("vw_insumo_plc_pmsT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("vw_insumo_plc_pmsT.pms_nr_mes", comboMes.getValue().getValue() + "");
            param.put("vw_insumo_plc_pmsT.pms_nr_ano", comboAno.getValue().getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
            List list = getCpMaster().getItems();
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
