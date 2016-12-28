/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cffo_cronograma_fisico_financeiro_origenal;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.extjs.gxt.ui.client.data.ModelData;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListMeses_obraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_importacao_orcamento.List_vw_importacao_orcamentoGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class Cffo_cronograma_fisico_financeiro_origenalConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalConsultGWT.jsp";
    public static final String PAGE_TEMP = "easyEngenharia/easyconstru/tes_temporaria_servico/tes_temporaria_servicoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Cffo_cronograma_fisico_financeiro_origenalConsultGWT consultGWT = this;
    private ListStore<Tes_temporaria_servicoGWT> storeTes;
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMeses_obraGWT listMeses_obraGWT = new ListMeses_obraGWT();
    final ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ListenerReader lr = new ListenerReader();
    private List<Meses_obrasTGWT> listMeses;
    private List<Meses_obrasTGWT> listMesesResultado = new ArrayList<Meses_obrasTGWT>();
    private List<Cffo_cronograma_fisico_financeiro_origenalTGWT> listCffo;
    List_Cronograma_fisico_financeiroGWT listCronograma = new List_Cronograma_fisico_financeiroGWT();
    List_vw_importacao_orcamentoGWT listImpportacaogwt = new List_vw_importacao_orcamentoGWT();
    private Cffo_cronograma_fisico_financeiro_origenalTGWT cffo = new Cffo_cronograma_fisico_financeiro_origenalTGWT();
    private boolean exibir = false;
    private float vlchange = 0;
    private int id_servico;
    private int id_obra;
    private int ipo_nr_id_super;
    private int ipo_nr_id;
    private String mesAnoColumn;
    private ToolBar toolBar = new ToolBar();
    private NumberFormat percent;
    private NumberFormat number;
    private String unid;
    private int nivel_plco;
    private int id_nivel;
    private EditorGrid<Tes_temporaria_servicoGWT> grid;
    private Tes_temporaria_servicoGWT tesmodel;
    private MessageBox mb = new MessageBox();
    private int qtItensEnviado, qtItensRecebidos;
    private NumberFormat format;
    private boolean globalizando = false;

    public Cffo_cronograma_fisico_financeiro_origenalConsultGWT() {
        try {
            format.getFormat("#,##0.00");
            listObraGWT.povoar();
            this.setHeading("Cronograma Físico-Finaceiro Original por Regime de Competência");
            getDataNORTH().setHidden(true);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(false);
            getDataWEST().setSize(250);

            getToolBarMaster().setVisible(false);
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            number = NumberFormat.getFormat("#,##0.00");
            percent = NumberFormat.getFormat("#,##0.00");

        } catch (Exception ex) {
        }
    }

    private void mostrar() {
        super.show();
        maximize();

    }

    @Override
    public void close() {
        //Window.alert("passou");
        getCpMaster().removeAll();
        getCpLeft().removeAll();
        comboObra.setValue(null);
        super.close();
    }

    /**
     * Maximizar Janela
     */
    public void show() {

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (listObraGWT.getStore() == null) {
                    schedule(500);
                } else {
                    comboObra.setDisplayField("obr_tx_nome");
                    comboObra.setValueField("obr_nr_id");
                    comboObra.setWidth(215);
                    comboObra.setEmptyText("Selecione a Obra");
                    comboObra.setStore(listObraGWT.getStore());
                    comboObra.setTypeAhead(true);
                    comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboObra.addSelectionChangedListener(new SelectionChangedListener<Obr_obrasTGWT>() {

                        @Override
                        public void selectionChanged(SelectionChangedEvent<Obr_obrasTGWT> se) {
                            getCpMaster().removeAll();
                            getCpLeft().removeAll();
                            preencherNivel_1();
                        }
                    });

                    toolBar.removeAll();
                    toolBar.add(new LabelToolItem("Obra:"));
                    toolBar.add(comboObra);
                    getCpLeft().setTopComponent(toolBar);
                    consultGWT.mostrar();
                    consultGWT.layout();
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public void preencherNivel_1() {
        listImpportacaogwt.povoarNivel(comboObra.getValue().getObr_nr_id(), 1);
        Timer timer = new Timer() {

            public void run() {
                if (!listImpportacaogwt.isMostrar()) {
                    schedule(500);
                } else {
                    getCpLeft().removeAll();
                    final ListStore<Vw_importacao_orcamentoTGWT> store_vw_import = new ListStore<Vw_importacao_orcamentoTGWT>();
                    store_vw_import.add(listImpportacaogwt.getList());
                    List<ColumnConfig> listColumnConf = new ArrayList<ColumnConfig>();
                    GridCellRenderer<Vw_importacao_orcamentoTGWT> styleColumn = new GridCellRenderer<Vw_importacao_orcamentoTGWT>() {

                        public Object render(Vw_importacao_orcamentoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Vw_importacao_orcamentoTGWT> store, Grid<Vw_importacao_orcamentoTGWT> grid) {
                            String style = "black;font-weight:bold";
                            return "<span style='color:" + style + "'>" + model.get(property) + "</span>";
                        }
                    };

                    ColumnConfig column = null;
                    column = new ColumnConfig("plco_tx_cod_externo", "Código", 40);
                    column.setRenderer(styleColumn);
                    listColumnConf.add(column);
                    column = new ColumnConfig("plco_tx_nome", "Nome", 200);
                    column.setRenderer(styleColumn);
                    listColumnConf.add(column);
                    ColumnModel cm = new ColumnModel(listColumnConf);
                    Grid<Vw_importacao_orcamentoTGWT> grid = new Grid<Vw_importacao_orcamentoTGWT>(store_vw_import, cm);

                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    grid.getSelectionModel().addListener(Events.SelectionChange,
                            new Listener<SelectionChangedEvent>() {

                                public void handleEvent(SelectionChangedEvent be) {
                                    if (be.getSelection().size() > 0) {
                                        Vw_importacao_orcamentoTGWT vtgwt = (Vw_importacao_orcamentoTGWT) be.getSelection().get(0);
                                        try {
                                            id_nivel = vtgwt.getIpo_nr_id();
                                            load(vtgwt.getIpo_nr_id());
                                        } catch (Exception e) {
                                        }
                                    }
                                }
                            });
                    grid.setStripeRows(true);
                    getCpLeft().add(grid);
                    consultGWT.layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public void createColumn() {

        GridCellRenderer<Tes_temporaria_servicoGWT> styleColumn = new GridCellRenderer<Tes_temporaria_servicoGWT>() {

            public Object render(Tes_temporaria_servicoGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tes_temporaria_servicoGWT> store, Grid<Tes_temporaria_servicoGWT> grid) {
                float total = 0;
                String st = "black;font-weight:normal";
                String style = model.getPlco_nr_nivel() == 4 ? st : "black;font-weight:bold";
                return "<span style='color:" + style + "'>" + model.get(property) + "</span>";
            }
        };

        GridCellRenderer<Tes_temporaria_servicoGWT> styleColumnSaldo = new GridCellRenderer<Tes_temporaria_servicoGWT>() {

            public Object render(Tes_temporaria_servicoGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tes_temporaria_servicoGWT> store, Grid<Tes_temporaria_servicoGWT> grid) {
                float total = 0;
                for (Meses_obrasTGWT meses_obrasT : listMeses) {
                    String colun = meses_obrasT.getMes() + "-" + meses_obrasT.getAno();
                    total += getvalueCelula(model, colun);
                }

                String st = "black;font-weight:normal";
                if (total != 100 & model.getPlco_nr_nivel() == 4) {
                    st = "red;font-weight:bold";
                }
                String style = model.getPlco_nr_nivel() == 4 ? st : "black;font-weight:bold";
                return "<span style='color:" + style + "'>" + model.get(property) + "</span>";
            }
        };

        GridCellRenderer<Tes_temporaria_servicoGWT> styleColumnQtde = new GridCellRenderer<Tes_temporaria_servicoGWT>() {

            public Object render(Tes_temporaria_servicoGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tes_temporaria_servicoGWT> store, Grid<Tes_temporaria_servicoGWT> grid) {
                float total = 0;
                for (Meses_obrasTGWT meses_obrasT : listMeses) {
                    String colun = meses_obrasT.getMes() + "-" + meses_obrasT.getAno();
                    total += getvalueCelula(model, colun);
                }

                String st = "black;font-weight:normal";
                if (total != 100 & model.getPlco_nr_nivel() == 4) {
                    st = "red;font-weight:bold";
                }
                String style = model.getPlco_nr_nivel() == 4 ? st : "black;font-weight:bold";
                String val = model.getPlco_nr_quantidade() > 0 ? number.format(model.getPlco_nr_quantidade()) : "";
                return "<span style='color:" + style + "'>" + val + "</span>";
            }
        };

        configs.clear();

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("plco_nr_nivel");
        column.setHeader("plco_nr_nivel");
        column.setWidth(90);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setHidden(true);
        column.setRenderer(styleColumnSaldo);

        configs.add(column);

        column = new ColumnConfig();
        column.setId("obr_nr_id");
        column.setHeader("obra");
        column.setWidth(90);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setHidden(true);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_tx_cod_externo");
        column.setHeader("Código");
        column.setWidth(90);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setRenderer(styleColumnSaldo);

        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_tx_nome");
        column.setHeader("Serviço");
        column.setWidth(400);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setRenderer(styleColumnSaldo);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_tx_unidade");
        column.setHeader("Unidade");
        column.setWidth(60);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setRenderer(styleColumnSaldo);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_nr_quantidade");
        column.setHeader("Quantidade");
        column.setWidth(80);
        column.setRenderer(styleColumnQtde);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        configs.add(column);
        listMeses = listMeses_obraGWT.getListMeses();

        final String calc_Saldo = "";
        for (Meses_obrasTGWT meses_obrasTGWT : listMeses) {
            final ColumnConfig meses = new ColumnConfig(meses_obrasTGWT.getMes() + "-" + meses_obrasTGWT.getAno(), meses_obrasTGWT.getMes_ano(), 70);
            meses.setAlignment(HorizontalAlignment.RIGHT);
            GridCellRenderer gdrMes = new GridCellRenderer<Tes_temporaria_servicoGWT>() {

                public Object render(Tes_temporaria_servicoGWT model, final String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tes_temporaria_servicoGWT> store, final Grid<Tes_temporaria_servicoGWT> grid) {

                    //verifica se a conta é um serviço.

                    //meses.setNumberFormat(percent);
                    exibir = true;
                    final NumberField nf = new NumberField();
                    nf.setFormat(format);
                    final CellEditor ce = new CellEditor(nf);
                    meses.setEditor(ce);
                    id_servico = model.getPlco_nr_id();
                    ipo_nr_id_super = model.getIpo_nr_id_super();
                    ipo_nr_id = model.getIpo_nr_id();
                    mesAnoColumn = property;
                    id_obra = model.getObr_nr_id();
                    unid = model.get("plco_tx_unidade");
                    nivel_plco = model.getPlco_nr_nivel();
                    tesmodel = model;
                    if (!globalizando) {
                        if (store.getModifiedRecords().size() > 0) {
                            if (unid.length() > 0) {
                                vlchange = 0;
                                gravarCelulas(property, 0, 0, 0, 0, 0);
                                //store.commitChanges();
                            } else if (nivel_plco == 3) {
                                String field = getFieldModificado(store);
                                float valor = Float.parseFloat(model.get(field).toString());
                                globalizando = true;
                                globalizar(store, field, valor, ipo_nr_id);
                                store.commitChanges();
                            } else {
                                store.commitChanges();
                            }
                        }
                    }

                    if (unid.length() > 0) {
                        vlchange = getvalueCelula(model, property);
                        nf.setValue(vlchange);
                        model.set(property, vlchange);
                        return vlchange > 0 ? percent.format(vlchange) + "%" : "";
                    } else {
                        model.set(property, null);
                        return null;
                    }
                }
            };
            meses.setRenderer(gdrMes);
            configs.add(meses);
        }

        column = new ColumnConfig("plco_nr_vl_total", "Total", 60);
        column.setNumberFormat(percent);
        column.setRenderer(new GridCellRenderer<Tes_temporaria_servicoGWT>() {

            public Object render(Tes_temporaria_servicoGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tes_temporaria_servicoGWT> store, Grid<Tes_temporaria_servicoGWT> grid) {
                if (model.getPlco_tx_unidade().trim().length() > 0) {
                    float soma = 0;
                    for (Meses_obrasTGWT meses_obrasT : listMeses) {
                        String colun = meses_obrasT.getMes() + "-" + meses_obrasT.getAno();
                        soma += getvalueCelula(model, colun);
                    }
                    return percent.format(soma) + "%";
                }
                return model.get(property);
            }
        });
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);
    }

    public String getFieldModificado(ListStore<Tes_temporaria_servicoGWT> list) {
        List<Record> listreg = list.getModifiedRecords();
        Record record = listreg.get(0);
        String field = "";
        Set<String> key = record.getChanges().keySet();
        for (Iterator<String> it = key.iterator(); it.hasNext();) {
            field = it.next();
        }
        record.commit(true);
        return field;
    }

    public boolean globalizacaoValida(ListStore<Tes_temporaria_servicoGWT> liststore, int idsuper, String column, float valor) {
        String msg = "";
        boolean resultado = true;
        for (int i = 0; i < liststore.getCount(); i++) {
            if (idsuper == liststore.getAt(i).getIpo_nr_id_super()) {
                Record record = liststore.getRecord(liststore.getAt(i));
                record.beginEdit();
                record.set(column, valor);
                boolean res = isTotalValido(record);
                if (!res) {
                    //record.cancelEdit();
                    msg += "** " + liststore.getAt(i).getPlco_tx_nome() + "<br/>";
                    resultado = false;
                    //record.reject(true);
                } else {
                    //record.commit(true);
                }
            }
        }
        if (!resultado) {
            MessageBox.alert("Itens que a soma excedem a 100%", msg, null);
        }
        return resultado;
    }

    public void globalizar(final ListStore<Tes_temporaria_servicoGWT> liststore, final String column, final float vlColums, final int id_super) {
        try {
//            if (globalizacaoValida(liststore, id_super, column, vlColums)) {
                mb = MessageBox.wait("Requisicao", "Aguarde...........", "Globalizando.");
                qtItensEnviado = 0;
                qtItensRecebidos = 0;
                for (int i = 0; i < liststore.getCount(); i++) {
                    final int index = i;
                    if (liststore.getAt(i).getIpo_nr_id_super() == id_super) {
                        liststore.getAt(i).set(column, vlColums);
                        final int ind = i;
                        Record record = liststore.getRecord(liststore.getAt(i));
                        if (isTotalValido(record)) {
                            Timer timer = new Timer() {

                                @Override
                                public void run() {
                                    Tes_temporaria_servicoGWT tempT = liststore.getAt(index);
                                    gravarItemGlobal(liststore.getRecord(tempT), column, vlColums);
//                            gravarCelulas(column, vlColums, liststore.getAt(index).getPlco_nr_id(), liststore.getAt(index).getObr_nr_id(), id_super, liststore.getAt(index).getIpo_nr_id());
                                }
                            };
                            timer.schedule(100);
                            qtItensEnviado++;
                        }else{
                            MessageBox.alert("ATENÇÃO", "a Soma dos meses excedi a 100% do serviço"+liststore.getAt(i).getPlco_tx_nome(), null);
                        }
                    }
                }

                Timer t = new Timer() {

                    @Override
                    public void run() {
                        if (qtItensEnviado != qtItensRecebidos) {
//                        Info.display(qtItensEnviado + " enviados", qtItensRecebidos + " recebidos");
                            schedule(500);
                        } else {
                            liststore.commitChanges();
                            liststore.getLoader().load();
//                        getToolBarPage().refresh();
                            globalizando = false;
                            mb.close();
                            doLayout();
                        }
                    }
                };
                t.schedule(500);
//            } else {
//                Window.alert("rollback");
//                liststore.commitChanges();
//                //liststore.rejectChanges();
//            }
        } catch (Exception e) {
        }
    }

    public float getvalueCelula(ModelData md, String property) {
        float valor = 0;
        int plco_nr_id = Integer.parseInt(md.get("plco_nr_id").toString());
        int obr_nr_id = Integer.parseInt(md.get("obr_nr_id").toString());
        int ipo_id_super = Integer.parseInt(md.get("ipo_nr_id_super").toString());
        int ipo_nr_id = Integer.parseInt(md.get("ipo_nr_id").toString());
        String opm = property.substring(0, property.indexOf("-"));
        String opa = property.substring((property.indexOf("-") + 1), property.length());
        int mes = Integer.parseInt(opm);
        int ano = Integer.parseInt(opa);
        String key = obr_nr_id + "." + plco_nr_id + "." + mes + "." + ano + "." + ipo_id_super + "." + ipo_nr_id;
        cffo = listCronograma.getTreeCffo().get(key);

        if (cffo != null) {
            valor = cffo.getCffo_nr_peso();
        }
        return valor;
    }

    public boolean isTotalValido(Record record) {
        double val = 0;
        for (Meses_obrasTGWT mesT : listMeses) {
            String key = mesT.getMes() + "-" + mesT.getAno();
            if (record.get(key) != null) {
                val += Double.parseDouble(record.get(key).toString());
            }
        }
        NumberFormat format = NumberFormat.getFormat("000");
        int perc = Integer.parseInt(format.format(val));
        if (perc <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public void gravarCelulas(String property1, float peso1, int id_servico1, int id_obra1, int ipo_nr_id_supe1r, int ipo_nr_id1) {
        try {
            List<Record> list = storeTes.getModifiedRecords();
            boolean totalValido = isTotalValido(list.get(0));
            if (totalValido) {
                for (Record record : list) {
                    id_servico = Integer.parseInt(record.get("plco_nr_id").toString());
                    ipo_nr_id_super = Integer.parseInt(record.get("ipo_nr_id_super").toString());
                    ipo_nr_id = Integer.parseInt(record.get("ipo_nr_id").toString());
                    id_obra = Integer.parseInt(record.get("obr_nr_id").toString());
                    Map<String, Object> mapField = record.getChanges();
                    Set<String> key = mapField.keySet();
                    for (Iterator<String> it = key.iterator(); it.hasNext();) {
                        String chave = it.next();
                        //String field = (String) mapField.get(chave);

                        String opm = chave.substring(0, chave.indexOf("-"));
                        String opa = chave.substring((chave.indexOf("-") + 1), chave.length());
                        int mes = Integer.parseInt(opm);
                        int ano = Integer.parseInt(opa);
                        String newkey = id_obra + "." + id_servico + "." + mes + "." + ano + "." + ipo_nr_id_super + "." + ipo_nr_id;
                        float valor = 0;
                        if (record.get(chave) != null) {
                            valor = Float.parseFloat(record.get(chave).toString());
                        }
                        EasyAccessURL eaurl = new EasyAccessURL(lr);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("op", "insert");
                        map.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_mes", mes + "");
                        map.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_ano", ano + "");
                        map.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_peso", valor + "");
                        map.put("cffo_cronograma_fisico_financeiro_origenalT.obr_nr_id", id_obra + "");
                        map.put("cffo_cronograma_fisico_financeiro_origenalT.plco_nr_id", id_servico + "");
                        map.put("cffo_cronograma_fisico_financeiro_origenalT.ipo_nr_id_super", ipo_nr_id_super + "");
                        map.put("cffo_cronograma_fisico_financeiro_origenalT.ipo_nr_id", ipo_nr_id + "");
                        eaurl.accessJSonMapNoProgress(Constantes.URL + Cffo_cronograma_fisico_financeiro_origenalInsertGWT.PAGE, map);
                        insertList(mes, ano, valor);
                    }

//                record.commit(true);
                    //Window.alert("ok");
                }
            } else {
                MessageBox.alert("ATENÇÃO", "valor informado excedi a 100% na soma dos meses!", null);
            }
            storeTes.commitChanges();

        } catch (Exception ex) {
        }
    }

    public void gravarItemGlobal(Record record, String propert, float valor) {
        try {
            //Window.alert(property);
            id_servico = Integer.parseInt(record.get("plco_nr_id").toString());
            ipo_nr_id_super = Integer.parseInt(record.get("ipo_nr_id_super").toString());
            ipo_nr_id = Integer.parseInt(record.get("ipo_nr_id").toString());
            id_obra = Integer.parseInt(record.get("obr_nr_id").toString());

            String opm = propert.substring(0, propert.toString().indexOf("-"));
            String opa = propert.substring((propert.indexOf("-") + 1), propert.length());
            //Window.alert(opm + " - " + opa);
            int mes = Integer.parseInt(opm);
            int ano = Integer.parseInt(opa);
            String newkey = id_obra + "." + id_servico + "." + mes + "." + ano + "." + ipo_nr_id_super + "." + ipo_nr_id;

            EasyAccessURL eaurl = new EasyAccessURL(lr);
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("op", "insert");
            map.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_mes", mes + "");
            map.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_ano", ano + "");
            map.put("cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_peso", valor + "");
            map.put("cffo_cronograma_fisico_financeiro_origenalT.obr_nr_id", id_obra + "");
            map.put("cffo_cronograma_fisico_financeiro_origenalT.plco_nr_id", id_servico + "");
            map.put("cffo_cronograma_fisico_financeiro_origenalT.ipo_nr_id_super", ipo_nr_id_super + "");
            map.put("cffo_cronograma_fisico_financeiro_origenalT.ipo_nr_id", ipo_nr_id + "");
            eaurl.accessJSonMapNoProgress(Constantes.URL + Cffo_cronograma_fisico_financeiro_origenalInsertGWT.PAGE, map);
            record.commit(true);
            insertList(mes, ano, valor);
            storeTes.commitChanges();
        } catch (Exception ex) {
        }
    }

    public void insertList(int mes, int ano, float peso) {

        String key = id_obra + "." + id_servico + "." + mes + "." + ano + "." + ipo_nr_id_super + "." + ipo_nr_id;
        cffo = listCronograma.getTreeCffo().get(key);
        if (cffo != null) {
            cffo.setCffo_nr_peso(peso);
        } else {
            Cffo_cronograma_fisico_financeiro_origenalTGWT cffoInsert = new Cffo_cronograma_fisico_financeiro_origenalTGWT();
            cffoInsert.setCffo_nr_ano(ano);
            cffoInsert.setCffo_nr_mes(mes);
            cffoInsert.setCffo_nr_peso(peso);
            cffoInsert.setIpo_nr_id(ipo_nr_id);
            cffoInsert.setIpo_nr_id_super(ipo_nr_id_super);
            cffoInsert.setObr_nr_id(ipo_nr_id);
            cffoInsert.setPlco_nr_id(id_servico);
            listCronograma.getTreeCffo().put(key, cffoInsert);
        }
    }

    public void read(final JSONValue jsonValue) {

        Timer timerListCffo = new Timer() {

            @Override
            public void run() {
                if (listCronograma.getList() == null) {
                    schedule(500);
                } else {

                    listCffo = listCronograma.getList();
                    Timer timeMes = new Timer() {

                        @Override
                        public void run() {
                            if (listMeses_obraGWT.getListMeses() == null) {
                                schedule(500);
                            } else {

                                JSONObject jsonObject;
                                createColumn();
                                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                                    //Set<String> keys = jsonObject.keySet();
                                    //Window.alert(usuario);
                                    JSONArray resultado = jsonObject.get("resultado").isArray();
                                    List<Tes_temporaria_servicoGWT> list = new Vector();
                                    for (int i = 1; i < resultado.size(); i++) {

                                        Tes_temporaria_servicoGWT tes_temporaria_servicoGWT = new Tes_temporaria_servicoGWT();
                                        JSONObject registro = resultado.get(i).isObject();

                                        Integer plco_nr_nivel = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_nivel").toString()));
                                        tes_temporaria_servicoGWT.setPlco_nr_nivel(plco_nr_nivel);

                                        String plco_tx_nome = EasyContainer.clearAspas(registro.get("plco_tx_nome").toString());
                                        tes_temporaria_servicoGWT.setPlco_tx_nome(plco_tx_nome);

                                        String plco_tx_unidade = EasyContainer.clearAspas(registro.get("plco_tx_unidade").toString());
                                        tes_temporaria_servicoGWT.setPlco_tx_unidade(plco_tx_unidade);
                                        tes_temporaria_servicoGWT.setPlco_nr_quantidade(0);
                                        if (plco_tx_unidade.trim().length() > 0) {
                                            float plco_nr_quantidade = Float.parseFloat(EasyContainer.clearAspas(registro.get("plco_nr_quantidade").toString()));
                                            tes_temporaria_servicoGWT.setPlco_nr_quantidade(plco_nr_quantidade);
                                        }

//                                        float plco_nr_vl_unitario = Float.parseFloat(EasyContainer.clearAspas(registro.get("plco_nr_vl_unitario").toString()));
//                                        tes_temporaria_servicoGWT.setPlco_nr_vl_unitario(plco_nr_vl_unitario);

                                        if (plco_tx_unidade.trim().length() > 0) {
                                            float plco_nr_vl_total = Float.parseFloat(EasyContainer.clearAspas(registro.get("plco_nr_vl_total").toString()));
                                            tes_temporaria_servicoGWT.setPlco_nr_vl_total(0);
                                        }
                                        Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                                        tes_temporaria_servicoGWT.setPlco_nr_id(plco_nr_id);

                                        String plco_tx_cod_externo = EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString());
                                        tes_temporaria_servicoGWT.setPlco_tx_cod_externo(plco_tx_cod_externo);

                                        Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                                        tes_temporaria_servicoGWT.setObr_nr_id(obr_nr_id);

                                        int id_super = Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id_super").toString()));
                                        tes_temporaria_servicoGWT.setIpo_nr_id_super(id_super);
                                        int ipo_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id").toString()));
                                        tes_temporaria_servicoGWT.setIpo_nr_id(ipo_nr_id);
                                        list.add(tes_temporaria_servicoGWT);
                                    }

                                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list);
                                    PagingLoader<PagingLoadResult<Tes_temporaria_servicoGWT>> loader = new BasePagingLoader<PagingLoadResult<Tes_temporaria_servicoGWT>>(proxy);
                                    loader.setRemoteSort(false);

                                    storeTes = new ListStore<Tes_temporaria_servicoGWT>(loader);
                                    storeTes.add(list);

//                                    getToolBarPage().setPageSize(100); //quantidade de registro por página
//                                    getToolBarPage().bind(loader);
//                                    loader.load(0, 100);//qual página será visualizada primeiro, e quantos registro irá possuir a pagina.
//                                    //fin paginação

                                    ColumnModel cm = new ColumnModel(configs);

                                    grid = new EditorGrid<Tes_temporaria_servicoGWT>(storeTes, cm);
                                    grid.setLoadMask(true);

                                    grid.setStyleAttribute("borderTop", "none");
                                    grid.setBorders(true);

                                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                                    grid.setStripeRows(true);
                                    getCpMaster().removeAll();
                                    getCpMaster().add(grid);
                                    consultGWT.layout();
                                    doLayout();
                                }
                            }
                        }
                    };
                    timeMes.schedule(500);
                }
            }
        };
        timerListCffo.schedule(500);
    }

    public void load(int id_super) throws Exception {
        try {

            listCronograma.povoaSuper(comboObra.getValue().getObr_nr_id(), id_super);
            //listCffo = listCronograma.getList();
            listMeses_obraGWT.povoar(comboObra.getValue().getObr_nr_id());

            EasyAccessURL eaurl = new EasyAccessURL(consultGWT);
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("vw_importacao_orcamentoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            map.put("vw_importacao_orcamentoT.ipo_nr_id_nivel_1", id_super + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE_TEMP, map);
            //Window.alert(Constantes.URL + PAGE_TEMP+"?vw_importacao_orcamentoT.obr_nr_id=43&vw_importacao_orcamentoT.ipo_nr_id_nivel_1=30562");
            //List list = getCpMaster().getItems();
            getCpMaster().removeAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ListenerReader implements IListenetResponse {

        public void read(JSONValue jsonValue) {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                Info.display("", jsonObject.get("resultado").toString());
                qtItensRecebidos = qtItensRecebidos + 1;
                //Info.display("",qtItensRecebidos+"");
            }
        }
    }
}
