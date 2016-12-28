/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_curva_abc;

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
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
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
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */

public class Vw_curva_abcConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcConsultGWT.jsp";
    public static final String PAGE_EXPORT = "easyEngenharia/easyconstru/vw_curva_abc/exportarCurvaABCInsumos.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Vw_curva_abcConsultGWT consultGWT = this;
    final ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    final ComboBox<Obr_obrasTGWT> combo = new ComboBox<Obr_obrasTGWT>();
    //private ListStore<Obr_obrasTGWT> storeObra;
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ToolBar toolBar = new ToolBar();
    private Button b = new Button("Filtrar");
    private Button btnExportar = new Button("Exportar para XLS");
    private MessageBox mb;

    public Vw_curva_abcConsultGWT(int v) {
        try {
            listObraGWT.povoar();

            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Vw_curva_abcTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_curva_abcTGWT>>(currency);
            getCpTop().setTopComponent(toolBar);


            b.setIcon(ICONS.filter());
            b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    load();
                }
            });
            btnExportar.setIcon(ICONS.download());
            btnExportar.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    exportar();
                }
            });

        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
    }

    public void exportar() {
        final String url = Constantes.URL + PAGE_EXPORT + "?op=consult&vw_curva_abcT.obr_nr_id=" + comboObra.getValue().getObr_nr_id() + "&exportar=true";
        mb = MessageBox.wait("Requisicao", "Requisitando a servidor", "Aguarde.......!!!");
        Timer timer = new Timer() {

            @Override
            public void run() {
                final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
                winDownload.setUrl(url);
                winDownload.setSize(1, 1);
                winDownload.setResizable(false);
                winDownload.show();
                Timer t = new Timer() {

                    @Override
                    public void run() {
                        winDownload.setVisible(false);
                        mb.close();
                    }
                };
                t.schedule(5000);
            }
        };
        timer.schedule(5000);// espera 3 segundos para poder exibir a janela para download do arquivo

    }

    public void montarTela() {
        this.setHeading("Consulta Curva ABC");
        this.setSize("600", "300");
        getDataNORTH().setSize(26);
        getDataEAST().setHidden(true);
        getDataWEST().setHidden(true);
        getToolBarMaster().setVisible(false);
        super.show();
    }

    @Override
    public void close() {
        toolBar.removeAll();
        getCpMaster().removeAll();
        super.close();
    }

    @Override
    public void show() {
        Timer timer = new Timer() {

            public void run() {
                if (listObraGWT.getStore() == null) {
                    schedule(500);
                } else {
                    toolBar.removeAll();
                    getCpMaster().removeAll();
                    comboObra.setStore(listObraGWT.getStore());
                    comboObra.setDisplayField("obr_tx_nome");
                    comboObra.setWidth(260);
                    comboObra.setEmptyText("Selecione a Obra");
                    comboObra.setTypeAhead(true);

                    toolBar.add(new LabelToolItem("Obra : "));
                    toolBar.add(comboObra);
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(new SeparatorToolItem());

                    toolBar.add(b);
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(new SeparatorToolItem());

                    toolBar.add(btnExportar);

                    ColumnConfig column = null;
                    column = new ColumnConfig();
                    column.setId("plco_tx_nome");
                    column.setHeader("Insumos");
                    column.setWidth(450);
                    column.setAlignment(HorizontalAlignment.LEFT);
                    configs.add(column);

                    ColumnConfig columnTotal = new ColumnConfig();
                    columnTotal.setId("total");
                    columnTotal.setHeader("Total");
                    columnTotal.setWidth(80);
                    columnTotal.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
                    columnTotal.setAlignment(HorizontalAlignment.RIGHT);
                    configs.add(columnTotal);
                    consultGWT.montarTela();
                    consultGWT.layout();

                }
            }
        };
        timer.schedule(500);
    }

    public void configCombobox() {
        //Window.alert("conf");
    }

    public void read(JSONValue jsonValue) {
        //Window.alert("chegou");
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Vw_curva_abcTGWT> store = new ListStore<Vw_curva_abcTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Vw_curva_abcTGWT vw_curva_abcTGWT = new Vw_curva_abcTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                vw_curva_abcTGWT.setObr_nr_id(obr_nr_id);

                String obr_tx_nome = EasyContainer.clearAspas(registro.get("obr_tx_nome").toString());
                vw_curva_abcTGWT.setObr_tx_nome(obr_tx_nome);

                Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                vw_curva_abcTGWT.setPlco_nr_id(plco_nr_id);

                String plco_tx_nome = EasyContainer.clearAspas(registro.get("plco_tx_nome").toString());
                vw_curva_abcTGWT.setPlco_tx_nome(plco_tx_nome);

                float total = Float.parseFloat(EasyContainer.clearAspas(registro.get("total").toString()));
                vw_curva_abcTGWT.setTotal(total);
                store.add(vw_curva_abcTGWT);
            }
            //Window.alert("passou");

            ColumnModel cm = new ColumnModel(configs);
            AggregationRowConfig<Vw_curva_abcTGWT> averages = new AggregationRowConfig<Vw_curva_abcTGWT>();
            averages.setHtml("plco_tx_nome", "Total");
            averages.setSummaryType("total", SummaryType.SUM);
            averages.setSummaryFormat("total", NumberFormat.getFormat("#,##0.00"));

            cm.addAggregationRow(averages);
            EditorGrid<Vw_curva_abcTGWT> grid = new EditorGrid<Vw_curva_abcTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setBorders(true);
            grid.setStripeRows(true);
            getCpMaster().removeAll();

            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

//    @Override
    public void btnNovoAction(ToolBarEvent be) {
        Vw_curva_abcInsertGWT insert;
        try {
            insert = new Vw_curva_abcInsertGWT();
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
            param.put("vw_curva_abcT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("op", "consult");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

