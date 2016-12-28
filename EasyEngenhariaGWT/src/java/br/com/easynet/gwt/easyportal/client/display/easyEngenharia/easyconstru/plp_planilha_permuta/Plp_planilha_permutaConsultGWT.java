/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plp_planilha_permuta;

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
public class Plp_planilha_permutaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plp_planilha_permuta/plp_planilha_permutaConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Plp_planilha_permutaConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private Button btnFiltrar = new Button("Filtrar");
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMeses_obraGWT listMeses_obraGWT = new ListMeses_obraGWT();
    private TreeMap<String, Plp_planilha_permutaTGWT> treePlanilha;
    private ListStore<Plp_planilha_permutaTGWT> newstore;
    private Plp_planilha_permutaTGWT valorPlanilha;
    private String key;
    private NumberFormat format = NumberFormat.getFormat("00");
    private Plp_planilha_permutaTGWT planilhaCompare = new Plp_planilha_permutaTGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private Button btnCarregar = new Button("Add. Último Mês", ICONS.plugin());

    public Plp_planilha_permutaConsultGWT() {
        try {
            listObraGWT.povoar();
            this.setHeading("Planilha Permuta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            getBtnNovoSuper().setVisible(false);

            this.setSize("700", "500");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Plp_planilha_permutaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Plp_planilha_permutaTGWT>>(currency);
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

            String url = Constantes.URL + Plp_planilha_permutaInsertGWT.PAGE + "?op=insert&insertValorMesAnt=true&plp_planilha_permutaT.plp_nr_mes_ref=" + comboMes.getValue().getValue() + "&plp_planilha_permutaT.plp_nr_ano_ref=" + comboAno.getValue().getValue() + "&plp_planilha_permutaT.obr_nr_id=" + cbObra.getValue().getObr_nr_id();
            EasyAccessURL eaurl = new EasyAccessURL(response);
            eaurl.accessJSon(url);

        } catch (Exception e) {
        }
    }

    public void montarGrid() {

        newstore = new ListStore<Plp_planilha_permutaTGWT>();
        List<Plp_planilha_permutaTGWT> list = new ArrayList<Plp_planilha_permutaTGWT>();
        for (Meses_obrasTGWT mesT : listMeses_obraGWT.getListMeses()) {
            Plp_planilha_permutaTGWT planilha = new Plp_planilha_permutaTGWT();
            planilha.setPlp_nr_mes(mesT.getMes());
            planilha.setPlp_nr_ano(mesT.getAno());
            planilha.setObr_nr_id(cbObra.getValue().getObr_nr_id());
            planilha.setDesc(mesT.getMes_ano());
            String key = planilha.getPlp_nr_mes() + "." + planilha.getPlp_nr_ano();
            valorPlanilha = treePlanilha.get(key);
            if (valorPlanilha != null) {
                planilha.setPlp_nr_previsto(valorPlanilha.getPlp_nr_previsto());
                planilha.setPlp_nr_realizado(valorPlanilha.getPlp_nr_realizado());
            }

            list.add(planilha);
        }

        newstore.add(list);
        ColumnConfig column = null;

        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

        column = new ColumnConfig("desc", "Meses", 80);
        configs.add(column);


        ColumnConfig original = new ColumnConfig("plp_nr_previsto", "Qtde. Prevista", 130);
        original.setAlignment(HorizontalAlignment.RIGHT);
        //original.setNumberFormat(format);
        original.setRenderer(getCellRenderer(original));
        configs.add(original);

        final ColumnConfig atual = new ColumnConfig("plp_nr_realizado", "Qtde. Realizada/Projetada", 130);
        atual.setAlignment(HorizontalAlignment.RIGHT);
        //atual.setNumberFormat(format);
        atual.setRenderer(getCellRenderer(atual));
        configs.add(atual);

        ColumnModel cm = new ColumnModel(configs);
        AggregationRowConfig<Plp_planilha_permutaTGWT> rowConfig = new AggregationRowConfig<Plp_planilha_permutaTGWT>();

        rowConfig.setSummaryFormat("plp_nr_previsto", format);
        rowConfig.setSummaryType("plp_nr_previsto", SummaryType.SUM);

        rowConfig.setSummaryFormat("plp_nr_realizado", format);
        rowConfig.setSummaryType("plp_nr_realizado", SummaryType.SUM);

        cm.addAggregationRow(rowConfig);

        EditorGrid<Plp_planilha_permutaTGWT> grid = new EditorGrid<Plp_planilha_permutaTGWT>(newstore, cm);
        grid.setStripeRows(true);
        grid.setBorders(true);
        grid.getView().setEmptyText("Não existe itens!");
        grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        getCpMaster().removeAll();
        getCpMaster().add(grid);
        layout();
    }

    public GridCellRenderer<Plp_planilha_permutaTGWT> getCellRenderer(final ColumnConfig column) {
        GridCellRenderer renderer = new GridCellRenderer<Plp_planilha_permutaTGWT>() {

            public Object render(Plp_planilha_permutaTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Plp_planilha_permutaTGWT> store, Grid<Plp_planilha_permutaTGWT> grid) {
                NumberField nf = new NumberField();
                nf.setFormat(format);
                CellEditor ce = new CellEditor(nf);
                column.setEditor(ce);
                key = model.getPlp_nr_mes() + "." + model.getPlp_nr_ano();
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
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();
            treePlanilha = new TreeMap<String, Plp_planilha_permutaTGWT>();

            ListStore<Plp_planilha_permutaTGWT> store = new ListStore<Plp_planilha_permutaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Plp_planilha_permutaTGWT plp_planilha_permutaTGWT = new Plp_planilha_permutaTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer plp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_id").toString()));
                plp_planilha_permutaTGWT.setPlp_nr_id(plp_nr_id);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                plp_planilha_permutaTGWT.setObr_nr_id(obr_nr_id);

                Integer plp_nr_mes_ref = Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_mes_ref").toString()));
                plp_planilha_permutaTGWT.setPlp_nr_mes_ref(plp_nr_mes_ref);

                Integer plp_nr_ano_ref = Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_ano_ref").toString()));
                plp_planilha_permutaTGWT.setPlp_nr_ano_ref(plp_nr_ano_ref);

                Integer plp_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_mes").toString()));
                plp_planilha_permutaTGWT.setPlp_nr_mes(plp_nr_mes);

                Integer plp_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_ano").toString()));
                plp_planilha_permutaTGWT.setPlp_nr_ano(plp_nr_ano);

                Integer plp_nr_previsto = Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_previsto").toString()));
                plp_planilha_permutaTGWT.setPlp_nr_previsto(plp_nr_previsto);

                Integer plp_nr_realizado = Integer.parseInt(EasyContainer.clearAspas(registro.get("plp_nr_realizado").toString()));
                plp_planilha_permutaTGWT.setPlp_nr_realizado(plp_nr_realizado);


                String key = plp_nr_mes + "." + plp_nr_ano;
                treePlanilha.put(key, plp_planilha_permutaTGWT);
                store.add(plp_planilha_permutaTGWT);
            }
            povoarListMeses();
            btnCarregar.setEnabled(store.getCount() == 0);

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
        Plp_planilha_permutaInsertGWT insert;
        try {
            insert = new Plp_planilha_permutaInsertGWT();
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
            param.put("plp_planilha_permutaT.obr_nr_id", cbObra.getValue().getObr_nr_id() + "");
            param.put("plp_planilha_permutaT.plp_nr_mes_ref", comboMes.getValue().getValue() + "");
            param.put("plp_planilha_permutaT.plp_nr_ano_ref", comboAno.getValue().getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
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
                param.put("plp_planilha_permutaT.plp_nr_mes_ref", comboMes.getValue().getValue() + "");
                param.put("plp_planilha_permutaT.plp_nr_ano_ref", comboAno.getValue().getValue() + "");
                param.put("plp_planilha_permutaT.plp_nr_mes", record.get("plp_nr_mes").toString());
                param.put("plp_planilha_permutaT.plp_nr_ano", record.get("plp_nr_ano").toString());
                param.put("plp_planilha_permutaT.obr_nr_id", record.get("obr_nr_id").toString());
                String key = record.get("plp_nr_mes").toString() + "." + record.get("plp_nr_ano").toString();
                boolean valido = false;
                if (record.get("plp_nr_previsto") != null) {
                    param.put("plp_planilha_permutaT.plp_nr_previsto", record.get("plp_nr_previsto").toString());

                    planilhaCompare = treePlanilha.get(key);
                    if (planilhaCompare == null) {
                        valido = true;
                    } else if (planilhaCompare.getPlp_nr_previsto() != Float.parseFloat(record.get("plp_nr_previsto").toString())) {
                        valido = true;
                    }
                }

                if (record.get("plp_nr_realizado") != null) {
                    param.put("plp_planilha_permutaT.plp_nr_realizado", record.get("plp_nr_realizado").toString());
                    if (!valido) {
                        planilhaCompare = treePlanilha.get(key);
                        if (planilhaCompare == null) {
                            valido = true;
                        } else if (planilhaCompare.getPlp_nr_realizado() != Float.parseFloat(record.get("plp_nr_realizado").toString())) {
                            valido = true;
                        }
                    }
                }
                if (valido) {
                    EasyAccessURL eaurl = new EasyAccessURL(response);
                    eaurl.accessJSonMapNoProgress(Constantes.URL + Plp_planilha_permutaInsertGWT.PAGE, param);
                }
                newstore.commitChanges();
            }
            //newstore.commitChanges();

        } catch (Exception e) {
        }
    }
}
