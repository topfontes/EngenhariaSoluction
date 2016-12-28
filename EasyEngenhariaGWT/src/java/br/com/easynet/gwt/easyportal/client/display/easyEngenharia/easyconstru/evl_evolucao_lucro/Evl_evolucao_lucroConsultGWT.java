/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.evl_evolucao_lucro;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.Style.SelectionMode;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListMeses_obraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
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
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class Evl_evolucao_lucroConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Evl_evolucao_lucroConsultGWT consultGWT = this;
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Plc_plano_contasTGWT> comboPlc = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    ToolBar toolBar = new ToolBar();
    private Button btnFiltrar = new Button("Filtrar");
    private TreeMap<String, Evl_evolucao_lucroTGWT> treeMeta = new TreeMap<String, Evl_evolucao_lucroTGWT>();
    private TreeMap<String, Evl_evolucao_lucroTGWT> treeOrig = new TreeMap<String, Evl_evolucao_lucroTGWT>();
    private ListMeses_obraGWT listMeses_obraGWT = new ListMeses_obraGWT();
    EditorGrid<Evl_evolucoao_lucroTEMP> grid;
    private ListStore<Evl_evolucoao_lucroTEMP> store = new ListStore<Evl_evolucoao_lucroTEMP>();
    private NumberFormat format = NumberFormat.getFormat("#,##0.00");
    private Button btnCarregar = new Button("Add. Último Mês", ICONS.plugin());

    public Evl_evolucao_lucroConsultGWT() {
        try {
            //setMaximizable(true);
            getToolBarMaster().setVisible(false);
            getDataNORTH().setHidden(true);
            this.setHeading("Evolução Lucro");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("650", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Evl_evolucao_lucroTGWT>> numberRenderer = new NumberCellRenderer<Grid<Evl_evolucao_lucroTGWT>>(currency);
            getCpMaster().setTopComponent(toolBar);
            listObraGWT.povoar();
            montarTela();

            btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    load();
                    btnCarregar.setEnabled(true);
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
            comboAno.addSelectionChangedListener(new SelectionChangedListener<Ano>() {

                @Override
                public void selectionChanged(SelectionChangedEvent<Ano> se) {
                    btnCarregar.setEnabled(false);
                }
            });

            comboMes.addSelectionChangedListener(new SelectionChangedListener<Meses>() {

                @Override
                public void selectionChanged(SelectionChangedEvent<Meses> se) {
                    btnCarregar.setEnabled(false);
                }
            });

            comboObra.addSelectionChangedListener(new SelectionChangedListener<Obr_obrasTGWT>() {

                @Override
                public void selectionChanged(SelectionChangedEvent<Obr_obrasTGWT> se) {
                    btnCarregar.setEnabled(false);
                }
            });


            createColumn();
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

            String url = Constantes.URL + Evl_evolucao_lucroInsertGWT.PAGE + "?op=insert&insertValorMesAnt=true&evl_evolucao_lucroT.evl_nr_mes_ref=" + comboMes.getValue().getValue() + "&evl_evolucao_lucroT.evl_nr_ano_ref=" + comboAno.getValue().getValue() + "&evl_evolucao_lucroT.obr_nr_id=" + comboObra.getValue().getObr_nr_id();
            EasyAccessURL eaurl = new EasyAccessURL(response);
            eaurl.accessJSon(url);

        } catch (Exception e) {

        }
    }

    @Override
    protected void onShow() {
        super.onShow();
        this.setWidth(getWidth() + 2);
    }

    public void createColumn() {

        ColumnConfig column = null;

        ColumnConfig mesano = new ColumnConfig("mesAno", "Mês/Ano", 80);
        configs.add(mesano);
        ColumnConfig original = new ColumnConfig("original", "% Original", 100);
        configs.add(original);
        ColumnConfig meta = new ColumnConfig("meta", "% Meta", 100);
        configs.add(meta);

        original.setRenderer(getRendere(original, "O"));
        meta.setRenderer(getRendere(meta, "M"));

    }

    public GridCellRenderer<Evl_evolucoao_lucroTEMP> getRendere(final ColumnConfig column, final String tipo) {
        return new GridCellRenderer<Evl_evolucoao_lucroTEMP>() {

            public Object render(Evl_evolucoao_lucroTEMP model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Evl_evolucoao_lucroTEMP> store, Grid<Evl_evolucoao_lucroTEMP> grid) {
                NumberField nf = new NumberField();
                nf.setFormat(format);
                CellEditor ce = new CellEditor(nf);
                column.setEditor(ce);
                if (store.getModifiedRecords().size() > 0) {
                    chengeList(tipo);
                }
                return model.get(property) != null ? format.format(Double.parseDouble(model.get(property).toString())) : model.get(property);
            }
        };

    }

    public void chengeList(String tipo) {
        try {
            IListenetResponse response = new IListenetResponse() {

                public void read(JSONValue jsonValue) {
                    JSONObject jsonObject;
                    if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                        if (jsonValue.toString().indexOf("sucesso") > 0) {
                            Info.display("", "Operação realizado com sucesso!");
                            store.commitChanges();
                        } else {
                            MessageBox.alert("ATENÇÃO", "Erro ao tentar realizar a operação", null);
                        }
                    }
                }
            };

            List<Record> list = store.getModifiedRecords();

            for (Record record : list) {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("op", "insert");
                param.put("evl_evolucao_lucroT.evl_nr_mes_ref", comboMes.getValue().getValue() + "");
                param.put("evl_evolucao_lucroT.evl_nr_ano_ref", comboAno.getValue().getValue() + "");
                param.put("evl_evolucao_lucroT.evl_nr_mes", record.get("mes").toString());
                param.put("evl_evolucao_lucroT.evl_nr_ano", record.get("ano").toString());
                param.put("evl_evolucao_lucroT.obr_nr_id", record.get("obr_nr_id").toString());
                param.put("evl_evolucao_lucroT.evl_tx_tipo", tipo);
                if (tipo.equalsIgnoreCase("O")) {
                    param.put("evl_evolucao_lucroT.evl_nr_valor", record.get("original").toString());
                } else {
                    param.put("evl_evolucao_lucroT.evl_nr_valor", record.get("meta").toString());
                }
                EasyAccessURL eaurl = new EasyAccessURL(response);
                eaurl.accessJSonMapNoProgress(Constantes.URL + Evl_evolucao_lucroInsertGWT.PAGE, param);
            }
        } catch (Exception e) {
        }
    }

    void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(300);
                } else {
                    addCompToolBar();
                    getCpMaster().layout();
                    layout();
                }
            }
        };
        timer.schedule(300);
    }

    public void addCompToolBar() {

        toolBar.add(new LabelToolItem("Obra:"));
        comboObra.setStore(listObraGWT.getStore());
        comboObra.setValueField("obr_nr_id");
        comboObra.setDisplayField("obr_tx_nome");
        comboObra.setEmptyText("Selecione a obra");
        toolBar.add(comboObra);
        toolBar.add(new SeparatorToolItem());

        toolBar.add(new LabelToolItem("Mês:"));
        ListStore<Meses> storemeses = new ListStore<Meses>();
        storemeses.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(storemeses);
        comboMes.setDisplayField("display");
        comboMes.setEmptyText("Selecione o Mês");
        comboMes.setWidth(110);
        toolBar.add(comboMes);
        toolBar.add(new SeparatorToolItem());

        toolBar.add(new LabelToolItem("Ano:"));
        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(storeAno);
        comboAno.setDisplayField("display");
        comboAno.setEmptyText("Selecione o Ano");
        comboAno.setWidth(80);
        toolBar.add(comboAno);
        btnFiltrar.setIcon(ICONS.filter());
        toolBar.add(btnFiltrar);
        toolBar.add(new SeparatorToolItem());
        toolBar.add(btnCarregar);

        layout();
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();
            treeMeta.clear();
            treeOrig.clear();
            store.removeAll();
            for (int i = 1; i < resultado.size(); i++) {
                Evl_evolucao_lucroTGWT evl_evolucao_lucroTGWT = new Evl_evolucao_lucroTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer evl_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("evl_nr_id").toString()));
                evl_evolucao_lucroTGWT.setEvl_nr_id(evl_nr_id);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                evl_evolucao_lucroTGWT.setObr_nr_id(obr_nr_id);

                Integer evl_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("evl_nr_mes").toString()));
                evl_evolucao_lucroTGWT.setEvl_nr_mes(evl_nr_mes);

                Integer evl_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("evl_nr_ano").toString()));
                evl_evolucao_lucroTGWT.setEvl_nr_ano(evl_nr_ano);

                float evl_nr_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("evl_nr_valor").toString()));
                evl_evolucao_lucroTGWT.setEvl_nr_valor(evl_nr_valor);

                Integer evl_nr_mes_ref = Integer.parseInt(EasyContainer.clearAspas(registro.get("evl_nr_mes_ref").toString()));
                evl_evolucao_lucroTGWT.setEvl_nr_mes_ref(evl_nr_mes_ref);

                Integer evl_nr_ano_ref = Integer.parseInt(EasyContainer.clearAspas(registro.get("evl_nr_ano_ref").toString()));
                evl_evolucao_lucroTGWT.setEvl_nr_ano_ref(evl_nr_ano_ref);

                String evl_tx_tipo = EasyContainer.clearAspas(registro.get("evl_tx_tipo").toString());
                evl_evolucao_lucroTGWT.setEvl_tx_tipo(evl_tx_tipo);
                if (evl_tx_tipo.equalsIgnoreCase("M")) {
                    treeMeta.put(evl_nr_mes + "." + evl_nr_ano, evl_evolucao_lucroTGWT);
                } else {
                    treeOrig.put(evl_nr_mes + "." + evl_nr_ano, evl_evolucao_lucroTGWT);
                }
            }

            store = new ListStore<Evl_evolucoao_lucroTEMP>();
            povoarStore();
            ColumnModel cm = new ColumnModel(configs);

            grid = new EditorGrid<Evl_evolucoao_lucroTEMP>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);
            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().removeAll();
            getCpMaster().add(grid);
            getCpMaster().layout();
            this.layout();
            doLayout();
        }
    }

    public void povoarStore() {
        List<Evl_evolucoao_lucroTEMP> list = new Vector();
        listMeses_obraGWT.povoar(comboObra.getValue().getObr_nr_id());
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listMeses_obraGWT.valido) {
                    schedule(500);
                } else {
                    List<Evl_evolucoao_lucroTEMP> list = new Vector();
                    for (Meses_obrasTGWT meses_obrasTGWT : listMeses_obraGWT.getListMeses()) {
                        Evl_evolucoao_lucroTEMP etemp = new Evl_evolucoao_lucroTEMP();
                        etemp.setMes(meses_obrasTGWT.getMes());
                        etemp.setAno(meses_obrasTGWT.getAno());
                        etemp.setMesAno(meses_obrasTGWT.getMes_ano());
                        etemp.setObr_nr_id(comboObra.getValue().getObr_nr_id());
                        String key = etemp.getMes() + "." + etemp.getAno();
                        Evl_evolucao_lucroTGWT evl = treeMeta.get(key);
                        if (evl != null) {
                            etemp.setMeta(evl.getEvl_nr_valor());
                        }
                        evl = treeOrig.get(key);
                        if (evl != null) {
                            etemp.setOriginal(evl.getEvl_nr_valor());
                        }
                        list.add(etemp);
                    }
                    store.add(list);
                    grid.getView().refresh(true);
                }
            }
        };
        timer.schedule(500);
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Evl_evolucao_lucroInsertGWT insert;
        try {
            insert = new Evl_evolucao_lucroInsertGWT();
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
            param.put("evl_evolucao_lucroT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("evl_evolucao_lucroT.evl_nr_mes_ref", comboMes.getValue().getValue() + "");
            param.put("evl_evolucao_lucroT.evl_nr_ano_ref", comboAno.getValue().getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
