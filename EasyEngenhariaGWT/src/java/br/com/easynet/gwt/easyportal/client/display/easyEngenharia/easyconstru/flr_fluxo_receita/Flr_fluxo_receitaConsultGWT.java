/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.flr_fluxo_receita;

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
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.FieldEvent;
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
import com.extjs.gxt.ui.client.util.SwallowEvent;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author geoleite
 */
public class Flr_fluxo_receitaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Flr_fluxo_receitaConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private Button btnFiltrar = new Button("Filtrar");
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMeses_obraGWT listMeses_obraGWT = new ListMeses_obraGWT();
    private TreeMap<String, Flr_fluxo_receitaTGWT> treeFluxo;
    private ListStore<Flr_fluxo_receitaTGWT> newstore;
    private Flr_fluxo_receitaTGWT valorFluxo;
    private String key;
    private NumberFormat format = NumberFormat.getFormat("#,##0.00");
    private Flr_fluxo_receitaTGWT fluxoCompare = new Flr_fluxo_receitaTGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private Button btnCarregar = new Button("Add. Último Mês", ICONS.plugin());

    public Flr_fluxo_receitaConsultGWT() {
        try {
            listObraGWT.povoar();
            this.setHeading("Fluxo de Receita");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            getBtnNovoSuper().setVisible(false);

            this.setSize("600", "500");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Flr_fluxo_receitaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Flr_fluxo_receitaTGWT>>(currency);

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

            String url = Constantes.URL + Flr_fluxo_receitaInsertGWT.PAGE + "?op=insert&insertValorMesAnt=true&flr_fluxo_receitaT.flr_nr_mes_ref=" + comboMes.getValue().getValue() + "&flr_fluxo_receitaT.flr_nr_ano_ref=" + comboAno.getValue().getValue() + "&flr_fluxo_receitaT.obr_nr_id=" + cbObra.getValue().getObr_nr_id();
            EasyAccessURL eaurl = new EasyAccessURL(response);
            eaurl.accessJSon(url);

        } catch (Exception e) {
        }
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
            treeFluxo = new TreeMap<String, Flr_fluxo_receitaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Flr_fluxo_receitaTGWT flr_fluxo_receitaTGWT = new Flr_fluxo_receitaTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer flr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("flr_nr_id").toString()));
                flr_fluxo_receitaTGWT.setFlr_nr_id(flr_nr_id);

                Integer flr_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("flr_nr_mes").toString()));
                flr_fluxo_receitaTGWT.setFlr_nr_mes(flr_nr_mes);

                Integer flr_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("flr_nr_ano").toString()));
                flr_fluxo_receitaTGWT.setFlr_nr_ano(flr_nr_ano);

                float flr_nr_original = Float.parseFloat(EasyContainer.clearAspas(registro.get("flr_nr_original").toString()));
                flr_fluxo_receitaTGWT.setFlr_nr_original(flr_nr_original);

                float flr_nr_atual = Float.parseFloat(EasyContainer.clearAspas(registro.get("flr_nr_atual").toString()));
                flr_fluxo_receitaTGWT.setFlr_nr_atual(flr_nr_atual);

                String flr_tx_key = EasyContainer.clearAspas(registro.get("flr_tx_key").toString());
                flr_fluxo_receitaTGWT.setFlr_tx_key(flr_tx_key);
                treeFluxo.put(flr_tx_key, flr_fluxo_receitaTGWT);
            }
            povoarListMeses();
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

    public void montarGrid() {

        newstore = new ListStore<Flr_fluxo_receitaTGWT>();
        List<Flr_fluxo_receitaTGWT> list = new ArrayList<Flr_fluxo_receitaTGWT>();
        for (Meses_obrasTGWT mesT : listMeses_obraGWT.getListMeses()) {
            Flr_fluxo_receitaTGWT fluxo = new Flr_fluxo_receitaTGWT();
            fluxo.setFlr_nr_mes(mesT.getMes());
            fluxo.setFlr_nr_ano(mesT.getAno());
            fluxo.setFlr_tx_key(comboMes.getValue().getValue() + "." + comboAno.getValue().getValue() + "-" + mesT.getMes() + "." + mesT.getAno());
            fluxo.setDescColumn(mesT.getMes_ano());
            fluxo.setObr_nr_id(cbObra.getValue().getObr_nr_id());

            valorFluxo = treeFluxo.get(fluxo.getFlr_tx_key());
            if (valorFluxo != null) {
                fluxo.setFlr_nr_original(valorFluxo.getFlr_nr_original());
                fluxo.setFlr_nr_atual(valorFluxo.getFlr_nr_atual());
            }

            list.add(fluxo);
        }

        newstore.add(list);
        ColumnConfig column = null;

        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

        column = new ColumnConfig("desc", "Meses", 80);
        configs.add(column);


        ColumnConfig original = new ColumnConfig("flr_nr_original", "Receita Bruta Original", 130);
        original.setAlignment(HorizontalAlignment.RIGHT);
        //original.setNumberFormat(format);
        original.setRenderer(getCellRenderer(original));
        configs.add(original);

        final ColumnConfig atual = new ColumnConfig("flr_nr_atual", "Receita Bruta Atual", 130);
        atual.setAlignment(HorizontalAlignment.RIGHT);
        //atual.setNumberFormat(format);
        atual.setRenderer(getCellRenderer(atual));
        configs.add(atual);

        ColumnModel cm = new ColumnModel(configs);
        AggregationRowConfig<Flr_fluxo_receitaTGWT> rowConfig = new AggregationRowConfig<Flr_fluxo_receitaTGWT>();

        rowConfig.setSummaryFormat("flr_nr_original", format);
        rowConfig.setSummaryType("flr_nr_original", SummaryType.SUM);

        rowConfig.setSummaryFormat("flr_nr_atual", format);
        rowConfig.setSummaryType("flr_nr_atual", SummaryType.SUM);

        cm.addAggregationRow(rowConfig);

        EditorGrid<Flr_fluxo_receitaTGWT> grid = new EditorGrid<Flr_fluxo_receitaTGWT>(newstore, cm);
        grid.setStripeRows(true);
        grid.setBorders(true);
        grid.getView().setEmptyText("Não existe itens!");
        grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        getCpMaster().removeAll();
        getCpMaster().add(grid);
        layout();
    }
 
    public void load() {
        try {
            listMeses_obraGWT.povoar(cbObra.getValue().getObr_nr_id());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("flr_fluxo_receitaT.obr_nr_id", cbObra.getValue().getObr_nr_id() + "");
            param.put("flr_fluxo_receitaT.flr_nr_mes_ref", comboMes.getValue().getValue() + "");
            param.put("flr_fluxo_receitaT.flr_nr_ano_ref", comboAno.getValue().getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GridCellRenderer<Flr_fluxo_receitaTGWT> getCellRenderer(final ColumnConfig column) {
        GridCellRenderer renderer = new GridCellRenderer<Flr_fluxo_receitaTGWT>() {

            public Object render(Flr_fluxo_receitaTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Flr_fluxo_receitaTGWT> store, Grid<Flr_fluxo_receitaTGWT> grid) {
                NumberField nf = new NumberField();
                nf.setFormat(format);
                CellEditor ce = new CellEditor(nf);
                column.setEditor(ce);
                key = model.getFlr_tx_key();
                if (store.getModifiedRecords().size() > 0) {
                    changeList();
                }
                return model.get(property) != null ? format.format(Double.parseDouble(model.get(property).toString())) : model.get(property);
            }
        };
        return renderer;
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
                param.put("flr_fluxo_receitaT.flr_nr_mes_ref", comboMes.getValue().getValue()+"");
                param.put("flr_fluxo_receitaT.flr_nr_ano_ref", comboAno.getValue().getValue()+"");
                param.put("flr_fluxo_receitaT.flr_nr_mes", record.get("flr_nr_mes").toString());
                param.put("flr_fluxo_receitaT.flr_nr_ano", record.get("flr_nr_ano").toString());
                param.put("flr_fluxo_receitaT.obr_nr_id", record.get("obr_nr_id").toString());
                boolean valido = false;
                if (record.get("flr_nr_original") != null) {
                    param.put("flr_fluxo_receitaT.flr_nr_original", record.get("flr_nr_original").toString());
                    fluxoCompare = treeFluxo.get(record.get("flr_nr_original"));
                    if (fluxoCompare == null) {
                        valido = true;
                    } else if (fluxoCompare.getFlr_nr_original() != Float.parseFloat(record.get("flr_nr_original").toString())) {
                        valido = true;
                    }
                }
                
                if (record.get("flr_nr_atual") != null) {
                    param.put("flr_fluxo_receitaT.flr_nr_atual", record.get("flr_nr_atual").toString());
                    if (!valido) {
                        fluxoCompare = treeFluxo.get(record.get("flr_nr_atual"));
                        if (fluxoCompare == null) {
                            valido = true;
                        } else if (fluxoCompare.getFlr_nr_atual() != Float.parseFloat(record.get("flr_nr_atual").toString())) {
                            valido = true;
                        }
                    }
                }
                if (valido) {
                    EasyAccessURL eaurl = new EasyAccessURL(response);
                    eaurl.accessJSonMapNoProgress(Constantes.URL + Flr_fluxo_receitaInsertGWT.PAGE, param);
                }
                newstore.commitChanges();
            }
            //newstore.commitChanges();

        } catch (Exception e) {
        }
    }
}

