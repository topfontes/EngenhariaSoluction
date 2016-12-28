/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.tpms_temporaria_pms;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.Record;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pms_planilha_medicao_servico.Pms_planilha_medicao_servicoInsertGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Popup;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Tpms_temporaria_pmsConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/tpms_temporaria_pms/tpms_temporaria_pmsConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Tpms_temporaria_pmsConsultGWT consultGWT = this;
    private ListBox listAno = new ListBox();
    private ListBox listObra = new ListBox();
    private ListBox listMes = new ListBox();
    ListStore<Tpms_temporaria_pmsTGWT> store;
    CheckColumnConfig checkColumn = new CheckColumnConfig("tpms_bl_servico", "Serviço", 55);
    private List<Tpms_temporaria_pmsTGWT> listTpms;
    String tipoJson = "";
    ComboBox<Meses> comboMes = new ComboBox<Meses>();
    ComboBox<Ano> comboAno = new ComboBox<Ano>();
    ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    ListObraGWT listObraGWT = new ListObraGWT();
    ToolBar toolBar = new ToolBar();
    Button b = new Button("Filtrar");
    public Popup popup = new Popup();
    public ContentPanel cpPopup = new ContentPanel();
    public ContentPanel cpPopup1 = new ContentPanel();
    private NumberFormat number;
    private NumberFormat percent;

    public Tpms_temporaria_pmsConsultGWT() {
        try {
            setAutoHide(false);
            addListMes();
            addListAno();
            addlistObra();

            this.setHeading("Planilha Medição de Serviços (PMS)");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            getToolBarMaster().setVisible(false);

            this.setMaximizable(true);

            number = NumberFormat.getFormat("#,##0.00");
            percent = NumberFormat.getFormat("#,#0%");

            b.setIcon(ICONS.filter());
            b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    load();
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void show() {

        listObraGWT.povoar();
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (listObraGWT.getStore() == null) {
                    schedule(500);

                } else {
                    toolBar.removeAll();
                    comboObra.setDisplayField("obr_tx_nome");
                    comboObra.setValueField("obr_nr_id");
                    comboObra.setWidth(180);

                    comboObra.setEmptyText("Selecione a Obra");
                    comboObra.setStore(listObraGWT.getStore());
                    comboObra.setTypeAhead(true);
                    comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);

                    toolBar.add(new LabelToolItem("Obra:"));
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

                    toolBar.add(b);

                    toolBar.add(new FillToolItem());
                    Button b1 = new Button("Atualizar Cronograma", ICONS.importation());
                    b1.addSelectionListener(new SelectionListener<ButtonEvent>() {

                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            atualizarCronograma();
                        }
                    });

                    toolBar.add(b1);

                    getCpTop().setTopComponent(toolBar);
                    Tpms_temporaria_pmsConsultGWT.super.show();

                    getCpTop().layout();

                    layout();
                    doLayout();

                    Timer timer = new Timer() {

                        @Override
                        public void run() {
                            maximize();
                        }
                    };
                    timer.schedule(1000);
                }
            }
        };
        timer.schedule(500);
    }

    public void atualizarCronograma() {
        try {

            String url = Constantes.URL + Pms_planilha_medicao_servicoInsertGWT.PAGE;
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("op", "atulaizarCronoPms");
            map.put("pms_planilha_medicao_servicoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            IListenetResponse listener = new IListenetResponse() {

                public void read(JSONValue jsonValue) {
                    if (jsonValue.toString().indexOf("sucesso") > -1) {
                        MessageBox box = new MessageBox();
                        box.alert("IMPORTANTE", "Atualização realizada com sucesso", null);
                    } else {
                        MessageBox box = new MessageBox();
                        box.alert("IMPORTANTE", "Atualização realizada com sucesso", null);
                    }
                }
            };
            EasyAccessURL accessURL = new EasyAccessURL(listener);
            accessURL.accessJSonMap(url, map);
        } catch (Exception e) {
        }
    }

    private void changeList() {
        try {
            List<Record> list = store.getModifiedRecords();
            ListenerReader lr = new ListenerReader();
            for (Record record : list) {
                String qtdeMes = record.get("tpms_nr_quantidade").toString().replaceAll(",", ".");

                if (Double.parseDouble(qtdeMes) != 0 & record.get("tpms_tx_unidade").toString().trim().length() > 0) {
                    double acPeriodo = 0;
                    if (record.get("tpms_nr_quantidade_acumulada_ant") != null) {
                        acPeriodo = Double.parseDouble(record.get("tpms_nr_quantidade_acumulada_ant").toString());
                    }

                    String str_totalOrcado = record.get("tpms_nr_quantidade_total").toString();

                    acPeriodo += Double.parseDouble(qtdeMes);

                    Double f_total_orcada = Double.parseDouble(str_totalOrcado);
                    Double saldo = f_total_orcada - acPeriodo;

                    if (saldo >= 0) {
                        Double dif = Double.parseDouble(str_totalOrcado) - Double.parseDouble(qtdeMes);
                        Double perMes = 100 - (dif * 100 / Double.parseDouble(str_totalOrcado));
                        record.set("tpms_nr_percentAcumuladoMes", (perMes));

                        record.set("tpms_nr_quantidade_acumulada_atual", acPeriodo);
                        dif = Double.parseDouble(str_totalOrcado) - acPeriodo;
                        Double perAcum = 100 - (dif * 100 / Double.parseDouble(str_totalOrcado));
                        record.set("tpms_nr_percentAcumuladoPeriodo", (perAcum));

                        record.set("tpms_nr_saldo", saldo);
                        record.set("tpms_nr_percentSaldo", 100 - perAcum);

                        record.set("tpms_nr_oldvalue", Double.parseDouble(qtdeMes));

                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("op", "insert");
                        map.put("pms_planilha_medicao_servicoT.plco_nr_id", record.get("plco_nr_id").toString());
                        map.put("pms_planilha_medicao_servicoT.ipo_nr_id", record.get("ipo_nr_id").toString());
                        map.put("pms_planilha_medicao_servicoT.ipo_nr_id_super", record.get("ipo_nr_id_super").toString());
                        map.put("pms_planilha_medicao_servicoT.pms_nr_quantidade_servico", qtdeMes);
                        map.put("pms_planilha_medicao_servicoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
                        map.put("pms_planilha_medicao_servicoT.pms_nr_mes", comboMes.getValue().getValue() + "");
                        map.put("pms_planilha_medicao_servicoT.pms_nr_ano", comboAno.getValue().getValue() + "");
                        map.put("pms_planilha_medicao_servicoT.pms_nr_percentual", perMes + "");
                        //Window.alert(perMes + "");

                        EasyAccessURL eaurl = new EasyAccessURL(lr);
                        String url = Constantes.URL + Pms_planilha_medicao_servicoInsertGWT.PAGE;
                        eaurl.accessJSonMapNoProgress(url, map);
                    } else {
                        record.set("tpms_nr_quantidade", record.get("tpms_nr_oldvalue"));
                        getMbMaster().alert("ATENÇÃO", " A quantidade informada do mês excede a quantidade orçada", null);
                    }
                } else {
                    record.set("tpms_nr_quantidade", record.get("tpms_tx_unidade").toString().trim().length() == 0 ? "" : 0);
                }
            }
            store.commitChanges();
        } catch (Exception e) {
        }
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

    public void addlistObra() {
        try {
            ListStore<Obr_obrasTGWT> storeObra = new ListStore<Obr_obrasTGWT>();
            storeObra = listObraGWT.getStore();
            comboObra.setStore(storeObra);
            comboObra.setDisplayField("obr_tx_nome");
        } catch (Exception e) {
        }
    }

    public void createColumn() {
        configs = new ArrayList<ColumnConfig>();
        GridCellRenderer<Tpms_temporaria_pmsTGWT> styleColumn = new GridCellRenderer<Tpms_temporaria_pmsTGWT>() {

            public Object render(Tpms_temporaria_pmsTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tpms_temporaria_pmsTGWT> store, Grid<Tpms_temporaria_pmsTGWT> grid) {
                String style = model.getTpms_bl_servico() ? "black;font-weight:normal" : "black;font-weight:bold";
                return "<span style='color:" + style + "'>" + model.get(property) + "</span>";
            }
        };

        GridCellRenderer<Tpms_temporaria_pmsTGWT> styleSaldo = new GridCellRenderer<Tpms_temporaria_pmsTGWT>() {

            public Object render(Tpms_temporaria_pmsTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tpms_temporaria_pmsTGWT> store, Grid<Tpms_temporaria_pmsTGWT> grid) {
                String st = "black;font-weight:normal";

                if (model.get("tpms_tx_unidade").toString().trim().length() > 0) {
                    if (Double.parseDouble(model.get("tpms_nr_saldo").toString()) > 0 & model.getTpms_bl_servico()) {
                        st = "red;font-weight:normal";
                    }
                }

                String style = model.getTpms_bl_servico() ? st : "black;font-weight:bold";
                return "<span style='color:" + style + "'>" + model.get(property) + "</span>";
            }
        };

        GridCellRenderer<Tpms_temporaria_pmsTGWT> styleColumnQtde = new GridCellRenderer<Tpms_temporaria_pmsTGWT>() {

            public Object render(Tpms_temporaria_pmsTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tpms_temporaria_pmsTGWT> store, Grid<Tpms_temporaria_pmsTGWT> grid) {
                String st = "black;font-weight:normal";

                if (model.get("tpms_tx_unidade").toString().trim().length() > 0) {
                    if (Double.parseDouble(model.get("tpms_nr_saldo").toString()) > 0 & model.getTpms_bl_servico()) {
                        st = "red;font-weight:normal";
                    }
                }

                String style = model.getTpms_bl_servico() ? st : "black;font-weight:bold";
                String vl = model.get("tpms_tx_unidade").toString().trim().length() > 0 ? number.format(model.getTpms_nr_quantidade_total()) : "";
                return "<span style='color:" + style + "'>" + vl + "</span>";
            }
        };

        ColumnConfig column = null;

        ColumnConfig ipo_nr_id = new ColumnConfig();
        ipo_nr_id.setId("ipo_nr_id");
        ipo_nr_id.setHeader("ipo");
        ipo_nr_id.setHidden(true);
        ipo_nr_id.setWidth(80);
        ipo_nr_id.setAlignment(HorizontalAlignment.LEFT);
        ipo_nr_id.setRenderer(styleColumn);

        ColumnConfig codigo = new ColumnConfig();
        codigo.setId("tpms_tx_codigo_externo");
        codigo.setHeader("Código");
        codigo.setWidth(80);
        codigo.setAlignment(HorizontalAlignment.LEFT);
        codigo.setRenderer(styleSaldo);

        ColumnConfig servico = new ColumnConfig();
        servico.setId("tpms_tx_conta");
        servico.setHeader("Serviço");
        servico.setWidth(450);
        servico.setAlignment(HorizontalAlignment.LEFT);
        servico.setRenderer(styleSaldo);

        ColumnConfig unidade = new ColumnConfig();
        unidade.setId("tpms_tx_unidade");
        unidade.setHeader("Unidade");
        unidade.setWidth(50);
        unidade.setRenderer(styleSaldo);
        unidade.setAlignment(HorizontalAlignment.LEFT);

        ColumnConfig qtde_total = new ColumnConfig();
        qtde_total.setId("tpms_nr_quantidade_total");
        qtde_total.setHeader("Qtd. Orçada");
        qtde_total.setWidth(100);
        qtde_total.setRenderer(styleColumnQtde);
        qtde_total.setAlignment(HorizontalAlignment.RIGHT);
        qtde_total.setNumberFormat(number);

        ColumnConfig anterior = new ColumnConfig();
        anterior.setId("tpms_nr_quantidade_acumulada_ant");
        anterior.setHeader("Qtd. Acum. Anterior");
        anterior.setWidth(110);
        anterior.setNumberFormat(NumberFormat.getFormat("##,##0.000000"));
        anterior.setAlignment(HorizontalAlignment.RIGHT);

        final ColumnConfig qtde_periodo = new ColumnConfig();
        qtde_periodo.setId("tpms_nr_quantidade");
        qtde_periodo.setHeader("Qtd. Exec. no Mês.");
        qtde_periodo.setWidth(90);
        qtde_periodo.setAlignment(HorizontalAlignment.RIGHT);
        //qtde_periodo.setNumberFormat(number);
        GridCellRenderer renderer = new GridCellRenderer<Tpms_temporaria_pmsTGWT>() {

            public Object render(final Tpms_temporaria_pmsTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tpms_temporaria_pmsTGWT> store, Grid<Tpms_temporaria_pmsTGWT> grid) {
                if (model.getTpms_tx_unidade().trim().length() > 0) {
                    NumberField nf = new NumberField();

                    CellEditor ce = new CellEditor(nf);
                    ce.setToolTip(model.getTpms_tx_codigo_externo());
                    qtde_periodo.setEditor(ce);
                    nf.addListener(Events.Change, new Listener<FieldEvent>() {

                        public void handleEvent(FieldEvent be) {
                            changeList();
                        }
                    });
                }

                return model.get("tpms_nr_quantidade") != null ? number.format(Double.parseDouble(model.get("tpms_nr_quantidade").toString())) : model.get(property);
            }
        };

        qtde_periodo.setRenderer(renderer);

        ColumnConfig percutualMes = new ColumnConfig();
        percutualMes.setId("tpms_nr_percentAcumuladoMes");
        percutualMes.setHeader("% Do Mês");
        percutualMes.setWidth(70);
        percutualMes.setAlignment(HorizontalAlignment.RIGHT);
        percutualMes.setNumberFormat(NumberFormat.getFormat("#,#0%"));
        percutualMes.setRenderer(new GridCellRenderer<Tpms_temporaria_pmsTGWT>() {

            public String render(Tpms_temporaria_pmsTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tpms_temporaria_pmsTGWT> store, Grid<Tpms_temporaria_pmsTGWT> grid) {

                String saldo = "";
                if (model.get("tpms_nr_percentAcumuladoMes") != null) {
                    saldo = number.format(model.getTpms_nr_percentAcumuladoMes()) + "%";
                }
                return saldo;
            }
        });

        ColumnConfig acumulado_periodo = new ColumnConfig();
        acumulado_periodo.setId("tpms_nr_quantidade_acumulada_atual");
        acumulado_periodo.setHeader("Acumulado até Período");
        acumulado_periodo.setWidth(120);
        acumulado_periodo.setAlignment(HorizontalAlignment.RIGHT);
        acumulado_periodo.setNumberFormat(NumberFormat.getFormat("##,##0.000000"));

        ColumnConfig percutualAtePeriodo = new ColumnConfig();
        percutualAtePeriodo.setId("tpms_nr_percentAcumuladoPeriodo");
        percutualAtePeriodo.setHeader("% Até Período");
        percutualAtePeriodo.setWidth(80);
        percutualAtePeriodo.setAlignment(HorizontalAlignment.RIGHT);
        percutualAtePeriodo.setNumberFormat(NumberFormat.getFormat("#,#0%"));
        percutualAtePeriodo.setRenderer(new GridCellRenderer<Tpms_temporaria_pmsTGWT>() {

            public String render(Tpms_temporaria_pmsTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tpms_temporaria_pmsTGWT> store, Grid<Tpms_temporaria_pmsTGWT> grid) {

                String saldo = "";
                if (model.get("tpms_nr_percentAcumuladoPeriodo") != null) {
                    saldo = number.format(model.getTpms_nr_percentAcumuladoPeriodo()) + "%";
                }
                return saldo;
            }
        });

        ColumnConfig saldo = new ColumnConfig();
        saldo.setId("tpms_nr_saldo");
        saldo.setHeader("Saldo");
        saldo.setWidth(100);
        saldo.setAlignment(HorizontalAlignment.RIGHT);
        saldo.setNumberFormat(NumberFormat.getFormat("#,##0.00"));

        ColumnConfig percutualSaldo = new ColumnConfig();
        percutualSaldo.setId("tpms_nr_percentSaldo");
        percutualSaldo.setHeader("% Saldo");
        percutualSaldo.setWidth(60);
        percutualSaldo.setAlignment(HorizontalAlignment.RIGHT);
        //percutualSaldo.setNumberFormat(NumberFormat.getFormat("#,#0%"));
        percutualSaldo.setRenderer(new GridCellRenderer<Tpms_temporaria_pmsTGWT>() {

            public String render(Tpms_temporaria_pmsTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tpms_temporaria_pmsTGWT> store, Grid<Tpms_temporaria_pmsTGWT> grid) {

                String saldo = "";
                if (model.get("tpms_nr_percentSaldo") != null) {
                    saldo = number.format(model.getTpms_nr_percentAcumuladoSaldo()) + "%";
                }
                return saldo;
            }
        });

///
///        
        ColumnConfig oldvalue = new ColumnConfig();
        oldvalue.setId("tpms_nr_oldvalue");
        oldvalue.setHeader("oldvalue");
        oldvalue.setWidth(60);
        oldvalue.setAlignment(HorizontalAlignment.RIGHT);
        oldvalue.setNumberFormat(NumberFormat.getPercentFormat());
        oldvalue.setHidden(true);

        configs.add(ipo_nr_id);
        configs.add(codigo);
        configs.add(servico);
        configs.add(unidade);
        configs.add(qtde_total);
        configs.add(anterior);
        configs.add(qtde_periodo);
        configs.add(percutualMes);
        configs.add(acumulado_periodo);
        configs.add(percutualAtePeriodo);
        configs.add(saldo);
        configs.add(percutualSaldo);

    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;

        createColumn();

        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();
            if (tipoJson.equalsIgnoreCase("consult")) {
                store = new ListStore<Tpms_temporaria_pmsTGWT>();
                listTpms = new ArrayList<Tpms_temporaria_pmsTGWT>();
                for (int i = 1; i < resultado.size(); i++) {
                    Tpms_temporaria_pmsTGWT tpms_temporaria_pmsTGWT = new Tpms_temporaria_pmsTGWT();
                    JSONObject registro = resultado.get(i).isObject();
//                    Window.alert(registro.toString());

                    Integer tmps_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("tmps_nr_id").toString()));
                    tpms_temporaria_pmsTGWT.setTmps_nr_id(tmps_nr_id);

                    Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                    tpms_temporaria_pmsTGWT.setPlco_nr_id(plco_nr_id);

                    Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                    tpms_temporaria_pmsTGWT.setObr_nr_id(obr_nr_id);

                    String tpms_tx_codigo = EasyContainer.clearAspas(registro.get("tpms_tx_codigo_externo").toString());
                    tpms_temporaria_pmsTGWT.setTpms_tx_codigo_externo(tpms_tx_codigo);

                    String tpms_tx_conta = EasyContainer.clearAspas(registro.get("tpms_tx_conta").toString());
                    tpms_temporaria_pmsTGWT.setTpms_tx_conta(tpms_tx_conta);

                    String tpms_tx_unidade = EasyContainer.clearAspas(registro.get("tpms_tx_unidade").toString());
                    tpms_temporaria_pmsTGWT.setTpms_tx_unidade(tpms_tx_unidade);

                    String tpms_bl_servico = EasyContainer.clearAspas(registro.get("tpms_bl_servico").toString());
                    tpms_temporaria_pmsTGWT.setTpms_bl_servico(tpms_bl_servico.equalsIgnoreCase("true") ? true : false);

                    if (tpms_temporaria_pmsTGWT.getTpms_bl_servico()) {

                        double tmps_nr_quantidade_total = Double.parseDouble(EasyContainer.clearAspas(registro.get("tpms_nr_quantidade_total").toString()));
                        tpms_temporaria_pmsTGWT.setTpms_nr_quantidade_total(tmps_nr_quantidade_total);

                        double tmps_nr_quantidade_acumulado_ant = Double.parseDouble(EasyContainer.clearAspas(registro.get("tpms_nr_quantidade_acumulada_ant").toString()));
                        if (tmps_nr_quantidade_acumulado_ant > 0) {
                            tpms_temporaria_pmsTGWT.setTpms_nr_quantidade_acumulada_ant(tmps_nr_quantidade_acumulado_ant);
                        }

                        double tpms_nr_quantidade = Double.parseDouble(EasyContainer.clearAspas(registro.get("tpms_nr_quantidade").toString()));
                        if (tpms_nr_quantidade != 0) {
                            tpms_temporaria_pmsTGWT.setTpms_nr_quantidade(tpms_nr_quantidade);
                            tpms_temporaria_pmsTGWT.setTpms_nr_oldvalue(tpms_nr_quantidade);
                            double tpms_nr_percentAcumuladoMes = Double.parseDouble(EasyContainer.clearAspas(registro.get("tpms_nr_percentAcumuladoMes").toString()));
                            tpms_temporaria_pmsTGWT.setTpms_nr_percentAcumuladoMes(tpms_nr_percentAcumuladoMes);
                        }

                        double tpms_nr_quantidade_acumulada_atual = Double.parseDouble(EasyContainer.clearAspas(registro.get("tpms_nr_quantidade_acumulada_atual").toString()));
                        if (tpms_nr_quantidade_acumulada_atual > 0) {
                            tpms_temporaria_pmsTGWT.setTpms_nr_quantidade_acumulada_atual(tpms_nr_quantidade_acumulada_atual);
                            double tpms_nr_percentAcumuladoPeriodo = Double.parseDouble(EasyContainer.clearAspas(registro.get("tpms_nr_percentAcumuladoPeriodo").toString()));
                            tpms_temporaria_pmsTGWT.setTpms_nr_percentAcumuladoPeriodo(tpms_nr_percentAcumuladoPeriodo);
                        }

                        double tpms_nr_saldo = Double.parseDouble(EasyContainer.clearAspas(registro.get("tpms_nr_saldo").toString()));
                        if (tpms_nr_saldo > 0) {
                            tpms_temporaria_pmsTGWT.setTpms_nr_saldo(tpms_nr_saldo);
                            double tpms_nr_percentSaldo = Double.parseDouble(EasyContainer.clearAspas(registro.get("tpms_nr_percentSaldo").toString()));
                            tpms_temporaria_pmsTGWT.setTpms_nr_percentSaldo(tpms_nr_percentSaldo);
                        } else {
                            tpms_temporaria_pmsTGWT.setTpms_nr_saldo(0);
                            tpms_temporaria_pmsTGWT.setTpms_nr_percentSaldo(0);
                        }
                        int id_super = Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id_super").toString()));
                        tpms_temporaria_pmsTGWT.setIpo_nr_id_super(id_super);

                        int ipo_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id").toString()));
                        tpms_temporaria_pmsTGWT.setIpo_nr_id(ipo_nr_id);
                    }

                    listTpms.add(tpms_temporaria_pmsTGWT);

                }
                store.add(listTpms);
                ColumnModel cm = new ColumnModel(configs);

                EditorGrid<Tpms_temporaria_pmsTGWT> grid = new EditorGrid<Tpms_temporaria_pmsTGWT>(store, cm);
                grid.setBorders(true);
                getCpMaster().removeAll();
                grid.setStripeRows(true);
                grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                getCpMaster().add(grid);
                this.layout();
                doLayout();
            } else {
                Info.display("", resultado.toString());
            }
        }
    }

    public void load() {
        try {
            tipoJson = "consult";
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("pms_planilha_medicao_servicoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("pms_planilha_medicao_servicoT.pms_nr_mes", comboMes.getValue().getValue() + "");
            param.put("pms_planilha_medicao_servicoT.pms_nr_ano", comboAno.getValue().getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
            List list = getCpMaster().getItems();
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
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
//final ColumnConfig column = new ColumnConfig();
//NumberField nf = new NumberField();
//CellEditor ce = new CellEditor(nf);
//column.setEditor(ce);
//nf.addListener(Events.Change, new Listener<FieldEvent>() {
// public void handleEvent(FieldEvent be) {
//  //logica
// }
//});
