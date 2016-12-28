/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plv_planilha_vendas;

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
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListMeses_obraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
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
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author geoleite
 */
public class Plv_planilha_vendasConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Plv_planilha_vendasConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private Button btnFiltrar = new Button("Filtrar");
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMeses_obraGWT listMeses_obraGWT = new ListMeses_obraGWT();
    private TreeMap<String, Plv_planilha_vendasTGWT> treePlanilha;
    private ListStore<Plv_planilha_vendasTGWT> newstore;
    private Plv_planilha_vendasTGWT valorplanilha;
    private String key;
    private NumberFormat format = NumberFormat.getFormat("00");
    private Plv_planilha_vendasTGWT planilhaCompare = new Plv_planilha_vendasTGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private Button btnCarregar = new Button("Add. Último Mês", ICONS.plugin());

    public Plv_planilha_vendasConsultGWT() {
        try {
            listObraGWT.povoar();
            this.setHeading("Velocidade de Vendas");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("700", "550");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Plv_planilha_vendasTGWT>> numberRenderer = new NumberCellRenderer<Grid<Plv_planilha_vendasTGWT>>(currency);
            getBtnNovoSuper().setVisible(false);
            montarBar();

            btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    load();
                }
            });

            btnCarregar.setEnabled(false);
            btnCarregar.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    MessageBox mb = MessageBox.confirm("Aviso", "Deseja importar os dados do mês anterior ?", new Listener<MessageBoxEvent>() {

                        public void handleEvent(MessageBoxEvent be) {
                            if ("yes".equalsIgnoreCase(be.getButtonClicked().getText()) || "Sim".equalsIgnoreCase(be.getButtonClicked().getText())) {
                                carregarValorUtimoMes();
                            }
                        }
                    });
                }
            });

        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }

    }

    private void carregarValorUtimoMes() {
        try {
            IListenetResponse response = new IListenetResponse() {

                public void read(JSONValue jsonValue) {
                    if (jsonValue.toString().indexOf("sucesso") > -1) {
                        load();
                    } else {
                        MessageBox.alert("ATENÇÃO", "Ainda não foi digitado nenhum mês", null);
                    }
                }
            };

            String url = Constantes.URL + Plv_planilha_vendasInsertGWT.PAGE + "?op=insert&insertValorMesAnt=true&plv_planilha_vendasT.plv_nr_mes_ref=" + comboMes.getValue().getValue() + "&plv_planilha_vendasT.plv_nr_ano_ref=" + comboAno.getValue().getValue() + "&plv_planilha_vendasT.obr_nr_id=" + cbObra.getValue().getObr_nr_id();
            EasyAccessURL eaurl = new EasyAccessURL(response);
            eaurl.accessJSon(url);

        } catch (Exception e) {
        }
    }

    public void montarGrid() {

        List<Plv_planilha_vendasTGWT> list = new ArrayList<Plv_planilha_vendasTGWT>();
        for (Meses_obrasTGWT mesT : listMeses_obraGWT.getListMeses()) {
            Plv_planilha_vendasTGWT planilha = new Plv_planilha_vendasTGWT();
            planilha.setPlv_nr_mes(mesT.getMes());
            planilha.setPlv_nr_ano(mesT.getAno());
//            fluxo.setFlr_tx_key(comboMes.getValue().getValue() + "." + comboAno.getValue().getValue() + "-" + mesT.getMes() + "." + mesT.getAno());
            planilha.setDesc(mesT.getMes_ano());
            planilha.setObr_nr_id(cbObra.getValue().getObr_nr_id());

            String key = planilha.getPlv_nr_mes() + "." + planilha.getPlv_nr_ano();
            valorplanilha = treePlanilha.get(key);
            if (valorplanilha != null) {
                planilha.setPlv_nr_previsto(valorplanilha.getPlv_nr_previsto());
                planilha.setPlv_nr_realizado(valorplanilha.getPlv_nr_realizado());
            }

            list.add(planilha);
        }

        newstore = new ListStore<Plv_planilha_vendasTGWT>();
        newstore.add(list);
        ColumnConfig column = null;

        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

        column = new ColumnConfig("desc", "Meses", 80);
        configs.add(column);

        ColumnConfig original = new ColumnConfig("plv_nr_previsto", "Qtde. Prevista", 130);
        original.setAlignment(HorizontalAlignment.RIGHT);

        original.setRenderer(getCellRenderer(original));
        configs.add(original);

        final ColumnConfig atual = new ColumnConfig("plv_nr_realizado", "Qtde. Realizada/Projetada", 130);
        atual.setAlignment(HorizontalAlignment.RIGHT);

        atual.setRenderer(getCellRenderer(atual));
        configs.add(atual);

        ColumnModel cm = new ColumnModel(configs);
        AggregationRowConfig<Plv_planilha_vendasTGWT> rowConfig = new AggregationRowConfig<Plv_planilha_vendasTGWT>();

        rowConfig.setSummaryFormat("plv_nr_previsto", format);
        rowConfig.setSummaryType("plv_nr_previsto", SummaryType.SUM);

        rowConfig.setSummaryFormat("plv_nr_realizado", format);
        rowConfig.setSummaryType("plv_nr_realizado", SummaryType.SUM);

        cm.addAggregationRow(rowConfig);

        EditorGrid<Plv_planilha_vendasTGWT> grid = new EditorGrid<Plv_planilha_vendasTGWT>(newstore, cm);
        grid.setStripeRows(true);
        grid.setBorders(true);
        grid.getView().setEmptyText("Não existe itens!");
        grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        getCpMaster().removeAll();
        getCpMaster().add(grid);
        layout();
    }

    public GridCellRenderer<Plv_planilha_vendasTGWT> getCellRenderer(final ColumnConfig column) {
        GridCellRenderer renderer = new GridCellRenderer<Plv_planilha_vendasTGWT>() {

            public Object render(Plv_planilha_vendasTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Plv_planilha_vendasTGWT> store, Grid<Plv_planilha_vendasTGWT> grid) {
                NumberField nf = new NumberField();
                nf.setFormat(format);
                CellEditor ce = new CellEditor(nf);
                column.setEditor(ce);
                key = model.getPlv_nr_mes() + "." + model.getPlv_nr_ano();
                if (store.getModifiedRecords().size() > 0) {
                    changeList();
                }
                return model.get(property) != null ? format.format(Double.parseDouble(model.get(property).toString())) : model.get(property);
            }
        };
        return renderer;
    }

    public void montarBar() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {
                    cbObra.setStore(listObraGWT.getStore());
                    cbObra.setAllowBlank(false);
                    cbObra.setTriggerAction(ComboBox.TriggerAction.ALL);
                    cbObra.setDisplayField("obr_tx_nome");
                    cbObra.setWidth(280);

                    ListStore<Meses> storeMes = new ListStore<Meses>();
                    storeMes.add(listMes_AnoGWT.getMeses());
                    comboMes.setStore(storeMes);
                    comboMes.setDisplayField("display");
                    comboMes.setAllowBlank(false);
                    comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboMes.setWidth(100);

                    ListStore<Ano> storeAno = new ListStore<Ano>();
                    storeAno.add(listMes_AnoGWT.getListAno());
                    comboAno.setStore(storeAno);
                    comboAno.setDisplayField("display");
                    comboAno.setAllowBlank(false);
                    comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboAno.setWidth(70);

                    getToolBarMaster().add(cbObra);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(comboMes);

                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(comboAno);

                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());

                    getToolBarMaster().add(btnFiltrar);
                    btnFiltrar.setIcon(ICONS.filter());

                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(btnCarregar);
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

            JSONArray resultado = jsonObject.get("resultado").isArray();
            treePlanilha = new TreeMap<String, Plv_planilha_vendasTGWT>();

            ListStore<Plv_planilha_vendasTGWT> store = new ListStore<Plv_planilha_vendasTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Plv_planilha_vendasTGWT plv_planilha_vendasTGWT = new Plv_planilha_vendasTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer plv_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_id").toString()));
                plv_planilha_vendasTGWT.setPlv_nr_id(plv_nr_id);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                plv_planilha_vendasTGWT.setObr_nr_id(obr_nr_id);

                Integer plv_nr_mes_ref = Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_mes_ref").toString()));
                plv_planilha_vendasTGWT.setPlv_nr_mes_ref(plv_nr_mes_ref);

                Integer plv_nr_ano_ref = Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_ano_ref").toString()));
                plv_planilha_vendasTGWT.setPlv_nr_ano_ref(plv_nr_ano_ref);

                Integer plv_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_mes").toString()));
                plv_planilha_vendasTGWT.setPlv_nr_mes(plv_nr_mes);

                Integer plv_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_ano").toString()));
                plv_planilha_vendasTGWT.setPlv_nr_ano(plv_nr_ano);

                Integer plv_nr_previsto = Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_previsto").toString()));
                plv_planilha_vendasTGWT.setPlv_nr_previsto(plv_nr_previsto);

                Integer plv_nr_realizado = Integer.parseInt(EasyContainer.clearAspas(registro.get("plv_nr_realizado").toString()));
                plv_planilha_vendasTGWT.setPlv_nr_realizado(plv_nr_realizado);
                store.add(plv_planilha_vendasTGWT);
                String key = plv_nr_mes + "." + plv_nr_ano;
                treePlanilha.put(key, plv_planilha_vendasTGWT);
            }

            btnCarregar.setEnabled(store.getCount() == 0);

            povoarListMeses();
            this.layout();
            doLayout();
        }
    }

    public void povoarListMeses() {

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (listMeses_obraGWT.getListMeses() == null) {
                    schedule(500);
                } else {
                    montarGrid();
                }
            }
        };
        timer.schedule(500);
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Plv_planilha_vendasInsertGWT insert;
        try {
            insert = new Plv_planilha_vendasInsertGWT();
            insert.setConsultGWT(consultGWT);
            insert.setModal(true);
            insert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            listMeses_obraGWT.povoar(cbObra.getValue().getObr_nr_id());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("plv_planilha_vendasT.plv_nr_mes_ref", comboMes.getValue().getValue() + "");
            param.put("plv_planilha_vendasT.plv_nr_ano_ref", comboAno.getValue().getValue() + "");
            param.put("plv_planilha_vendasT.obr_nr_id", cbObra.getValue().getObr_nr_id() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
            List list = getCpMaster().getItems();
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeList() {
        try {
            IListenetResponse response = new IListenetResponse() {

                public void read(JSONValue jsonValue) {
                    JSONObject jsonObject;
                    if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                        if (jsonValue.toString().indexOf("sucesso") > 0) {
                            Info.display("", "Operação realizado com sucesso!");
                            newstore.commitChanges();
                        } else {
                            MessageBox.alert("ATENÇÃO", "Erro ao tentar realizar a operação", null);
                        }
                    }
                }
            };
//
            List<Record> list = newstore.getModifiedRecords();

            for (Record record : list) {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("op", "insert");
                param.put("plv_planilha_vendasT.plv_nr_mes_ref", comboMes.getValue().getValue() + "");
                param.put("plv_planilha_vendasT.plv_nr_ano_ref", comboAno.getValue().getValue() + "");
                param.put("plv_planilha_vendasT.plv_nr_mes", record.get("plv_nr_mes").toString());
                param.put("plv_planilha_vendasT.plv_nr_ano", record.get("plv_nr_ano").toString());
                param.put("plv_planilha_vendasT.obr_nr_id", record.get("obr_nr_id").toString());
                boolean valido = false;
                if (record.get("plv_nr_previsto") != null) {
                    param.put("plv_planilha_vendasT.plv_nr_previsto", record.get("plv_nr_previsto").toString());
                    String key = record.get("plv_nr_mes").toString() + "." + record.get("plv_nr_mes").toString();
                    planilhaCompare = treePlanilha.get(key);
                    if (planilhaCompare == null) {
                        valido = true;
                    } else if (planilhaCompare.getPlv_nr_previsto() != Float.parseFloat(record.get("plv_nr_previsto").toString())) {
                        valido = true;
                    }
                }

                if (record.get("plv_nr_realizado") != null) {
                    param.put("plv_planilha_vendasT.plv_nr_realizado", record.get("plv_nr_realizado").toString());
                    String key = record.get("plv_nr_mes").toString() + "." + record.get("plv_nr_mes").toString();
                    planilhaCompare = treePlanilha.get(key);
                    if (planilhaCompare == null) {
                        valido = true;
                    } else if (planilhaCompare.getPlv_nr_previsto() != Float.parseFloat(record.get("plv_nr_realizado").toString())) {
                        valido = true;
                    }
                }
                if (valido) {
                    EasyAccessURL eaurl = new EasyAccessURL(response);
                    eaurl.accessJSonMapNoProgress(Constantes.URL + Plv_planilha_vendasInsertGWT.PAGE, param);
                }
                newstore.commitChanges();
            }
            //newstore.commitChanges();

        } catch (Exception e) {
        }
    }
}
