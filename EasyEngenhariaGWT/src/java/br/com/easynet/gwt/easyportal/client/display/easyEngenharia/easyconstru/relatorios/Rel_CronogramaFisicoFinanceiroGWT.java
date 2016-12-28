package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fat_fator.Fat_fatorInsertGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fat_fator.ListFatoresCalculadosGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fat_fator.ObjetoSessionGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Valores_Calculo_FatorTGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
//import com.google.gwt.i18n.client.impl.CurrencyData;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Rel_CronogramaFisicoFinanceiroGWT extends Window implements IListenetResponse {

    public String PAGE = "";//= "easyEngenharia/easyconstru/relatorios/cronograma_fisico_fin_origenal.jsp";
    private ContentPanel cpMaster = new ContentPanel();
    private ComboBox<Obr_obrasTGWT> comoObra = new ComboBox<Obr_obrasTGWT>();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private ListObraGWT listObraGWT = new ListObraGWT();
    private BorderLayoutData blLeft = new BorderLayoutData(LayoutRegion.WEST, 300);
    private ContentPanel cpLeft = new ContentPanel();
    private ContentPanel cpCenter = new ContentPanel();
    private String op;
    private ComboBox<Meses> combomes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ListFatoresCalculadosGWT fatoresCalculadosGWT = new ListFatoresCalculadosGWT();
    private ObjetoSessionGWT objetoSessionGWT = new ObjetoSessionGWT();
    private ListStore<Valores_Calculo_FatorTGWT> storeFator;
    private ToolBar toolBar = new ToolBar();
    private Button btnVisualizar = new Button("Visualizar");
    private Button btnPrint = new Button("imprimir");
    private BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
    private String TIPO;
    private Menu menu = new Menu();
    private MessageBox mb = new MessageBox();
    private NumberFormat format;

    public Rel_CronogramaFisicoFinanceiroGWT(String op) {

        final NumberFormat format = NumberFormat.getFormat("0.00");
        GridCellRenderer<Valores_Calculo_FatorTGWT> change = new GridCellRenderer<Valores_Calculo_FatorTGWT>() {

            public Object render(Valores_Calculo_FatorTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Valores_Calculo_FatorTGWT> store, Grid<Valores_Calculo_FatorTGWT> grid) {
                double val = model.getFator_projetado();
                String style = val < 0 ? "red" : "green";
                return "<span style='color:" + style + "'>" + format.format(val) + "</span>";
            }
        };


        format.getFormat("#,##0.000");
        listObraGWT.povoar();
        this.op = op;
        TIPO = "&";
        setLayout(new BorderLayout());
        blLeft.setSplit(true);
        blLeft.setCollapsible(true);
        blLeft.setMargins(new Margins(5));
        cpLeft.setLayout(new FillLayout());
        add(cpLeft, blLeft);
        centerData.setMargins(new Margins(5));
        cpCenter.setHeaderVisible(false);
        add(cpCenter, centerData);
//        cpCenter.setScrollMode(Style.Scroll.AUTO);

        blLeft.setHidden(true);
        cpLeft.setVisible(false);

        createMenu();
        btnVisualizar.setMenu(menu);
        layout();

        if (op.equalsIgnoreCase("CFF")) {
            setHeading("Cronograma Físico-Financeiro por Regime de Competência");
        } else if (op.equalsIgnoreCase("CDRCP")) {
            setHeading("Cronograma Físico-Financeiro Previsto por Regime de Caixa");
        } else {
            setHeading("Cronograma Físico-Financeiro por Regime de Caixa Realizado + Projetado");
            preencherReferencia();
        }

        btnVisualizar.setIcon(ICONS.filter());
        btnPrint.setIcon(ICONS.find());
        btnPrint.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                //visualizarFatores();
            }
        });

        cpCenter.layout();

//        cpFator.setHeaderVisible(false);
//        cpFator.setBodyBorder(true);
//        cpFator.setLayout(new FillLayout());

        layout();
    }

    public void preencherReferencia() {
        ListStore<Meses> storeMes = new ListStore<Meses>();
        storeMes.add(listMes_AnoGWT.getMeses());
        combomes.setStore(storeMes);
        combomes.setDisplayField("display");
        combomes.setValueField("value");
        comboAno.setWidth(85);

        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(storeAno);
        comboAno.setDisplayField("display");
        comboAno.setValueField("value");
        comboAno.setWidth(70);
        blLeft.setHidden(false);
        cpLeft.setVisible(true);
        layout();
    }

    public void createMenu() {
        MenuItem menuItem_orig = new MenuItem("Original");
        menuItem_orig.addSelectionListener(new SelectionListener<MenuEvent>() {

            @Override
            public void componentSelected(MenuEvent ce) {
                visualizar("O");
            }
        });

        MenuItem menuItem_rep = new MenuItem("Reprogramado");
        menuItem_rep.addSelectionListener(new SelectionListener<MenuEvent>() {

            @Override
            public void componentSelected(MenuEvent ce) {
                visualizar("R");
            }
        });


        MenuItem menuItem_dif = new MenuItem("Original X Reprogramado");
        menuItem_dif.addSelectionListener(new SelectionListener<MenuEvent>() {

            public void componentSelected(MenuEvent be) {
                visualizar("D");
            }
        });

        menu.add(menuItem_orig);
        menu.add(menuItem_rep);
        if (op.equalsIgnoreCase("CFF")) {
            menu.add(menuItem_dif);
        }
    }

    @Override
    public void show() {
        toolBar.removeAll();
        cpMaster.removeAll();
        cpLeft.removeAll();
        cpCenter.removeAll();

        montarTela();
        super.show();
        maximize();
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {
                    ListStore<Obr_obrasTGWT> store = new ListStore<Obr_obrasTGWT>();
                    store = listObraGWT.getStore();
                    comoObra.setStore(store);
                    comoObra.setDisplayField("obr_tx_nome");
                    comoObra.setEmptyText("Selecione a obra");
                    comoObra.setWidth(160);

                    setMaximizable(true);
                    cpMaster.setHeaderVisible(false);
                    toolBar.add(new LabelToolItem("Obra:"));
                    toolBar.add(comoObra);
                    if (op.equalsIgnoreCase("CDRCA")) {
                        toolBar.add(new SeparatorToolItem());
                        toolBar.add(new LabelToolItem("Mês:"));
                        toolBar.add(combomes);
                        toolBar.add(new SeparatorToolItem());
                        toolBar.add(new LabelToolItem("Ano:"));
                        toolBar.add(comboAno);
                    }
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(btnVisualizar);

                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(new SeparatorToolItem());
                    toolBar.add(btnPrint);
                    cpMaster.setTopComponent(toolBar);
                    cpCenter.add(cpMaster);
                    cpMaster.setSize(cpCenter.getWidth(), cpCenter.getHeight());
                    cpMaster.layout();

                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public void setPage(String tp) {
        if (op.equalsIgnoreCase("CFF")) {
            if (tp.equalsIgnoreCase("O")) {
                PAGE = "easyEngenharia/easyconstru/relatorios/cronograma_fisico_fin_original.jsp";
            } else {
                if (tp.equalsIgnoreCase("R")) {
                    PAGE = "easyEngenharia/easyconstru/relatorios/cronograma_fisico_fin_atualizado.jsp";
                } else {
                    PAGE = "easyEngenharia/easyconstru/relatorios/cronograma_fisico_fin_diferenca.jsp";
                }
            }
        } else if (op.equalsIgnoreCase("CDRCP")) {
            PAGE = "easyEngenharia/easyconstru/relatorios/cronograma_desembolso.jsp";
        } else if (op.equalsIgnoreCase("CDRCA")) {
            PAGE = "easyEngenharia/easyconstru/relatorios/cronogramaDesembolsoSubClasseReprog.jsp";
        }

    }

    public void visualizar(String tipo) {


        objetoSessionGWT.setSessionExiste(false);
        cpLeft.removeAll();
        String param = "&";
        cpMaster.removeAll();

        setPage(tipo);

        if (op.equalsIgnoreCase("CDRCA")) {
            param += "mesRef=" + combomes.getValue().getValue() + "&anoRef=" + comboAno.getValue().getValue();
        }
        if (!op.equalsIgnoreCase("CFF")) {
            TIPO = "&tipo=" + tipo;
        }

        String url = Constantes.URL + PAGE + "?op=consult&vw_importacao_orcamentoT.obr_nr_id=" + comoObra.getValue().getObr_nr_id() + param + TIPO;
        cpMaster.setUrl(url);

        if (op.equalsIgnoreCase("CDRCA")) {
            visualizarFatores();
        }
        layout();
        doLayout();
    }

    private void visualizarFatores() {
        objetoSessionGWT.setSessionExiste(false);

        mb = MessageBox.progress("Requisitando Servidor", "Processando", "Aguarde..!");
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!objetoSessionGWT.isSessionExiste()) {
                    objetoSessionGWT.consultSession();
                    schedule(500);
                } else {
                    montarTelaFator();
                    mb.close();
                }
            }
        };
        timer.schedule(500);
    }

    public void montarTelaFator() {
        try {
            fatoresCalculadosGWT.povoa();
            Timer timer = new Timer() {

                @Override
                public void run() {
                    if (!fatoresCalculadosGWT.isMostrar()) {
                        schedule(500);
                    } else {
                        storeFator = new ListStore<Valores_Calculo_FatorTGWT>();
                        storeFator.add(fatoresCalculadosGWT.getList());
                        List<ColumnConfig> listColumnfator = new Vector();
                        ColumnConfig column = null;

                        column = new ColumnConfig("obr_nr_id", "obra", 150);
                        column.setHidden(true);
                        listColumnfator.add(column);

                        column = new ColumnConfig("plc_tx_nome", "Sub Classe", 150);
                        listColumnfator.add(column);
                        column = new ColumnConfig("fator_Atual", "Fator Atual", 60);
                        column.setAlignment(HorizontalAlignment.RIGHT);
                        column.setNumberFormat(NumberFormat.getFormat("#,##0.000"));
                        listColumnfator.add(column);
                        final ColumnConfig columnFProj = new ColumnConfig("fator_projetado", "Fator Proj.", 60);
                        columnFProj.setAlignment(HorizontalAlignment.RIGHT);
                        //columnFProj.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
                        GridCellRenderer renderer = new GridCellRenderer<Valores_Calculo_FatorTGWT>() {

                            public Object render(Valores_Calculo_FatorTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Valores_Calculo_FatorTGWT> store, Grid<Valores_Calculo_FatorTGWT> grid) {
                                final NumberField nf = new NumberField();
                                nf.setFormat(NumberFormat.getFormat("#,##0.00"));
                                CellEditor editor = new CellEditor(nf);
                                columnFProj.setEditor(editor);
                                String t = model.getPlc_tx_nome();

                                if (store.getModifiedRecords().size() > 0) {
                                    gravarFatorProjetado();
                                }
                                double val = 0;
                                if (model.get(property) != null) {
                                    val = Double.parseDouble(model.get(property).toString());
                                }
//                                return model.get(property);

                                String style = val < 0 ? "red" : "green";
                                return "<span style='color:" + style + "'>" + model.get(property) + "</span>";
                            }
                        };

                        columnFProj.setRenderer(renderer);
                        listColumnfator.add(columnFProj);
                        EditorGrid<Valores_Calculo_FatorTGWT> grid = new EditorGrid<Valores_Calculo_FatorTGWT>(storeFator, new ColumnModel(listColumnfator));
                        grid.setStripeRows(true);

                        cpLeft.removeAll();
//                        cpFator.setHeight(cpLeft.getHeight());
                        cpLeft.add(grid);
                        cpLeft.layout();
                        layout();
                    }
                }
            };
            timer.schedule(500);
        } catch (Exception ex) {
        }
    }

    public void gravarFatorProjetado() {
        try {

            List<Record> list = storeFator.getModifiedRecords();
            storeFator.commitChanges();
            for (Record record : list) {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("op", "insert");
                param.put("fat_fatorT.obr_nr_id", record.get("obr_nr_id").toString());
                param.put("fat_fatorT.plc_nr_id", record.get("plc_nr_id").toString());
                param.put("fat_fatorT.fat_nr_mes", record.get("mes").toString());
                param.put("fat_fatorT.fat_nr_ano", record.get("ano").toString());
                param.put("fat_fatorT.fat_nr_fator_projetado", record.get("fator_projetado").toString());
                param.put("fat_fatorT.fat_nr_fator_Atual", record.get("fator_Atual").toString());
                EasyAccessURL eaurl = new EasyAccessURL(this);
                eaurl.accessJSonMap(Constantes.URL + Fat_fatorInsertGWT.PAGE, param);
            }

        } catch (Exception e) {
        }

    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String msg = EasyContainer.clearAspas(jsonValue.toString());
            msg = msg.substring(13, msg.length());
            msg = msg.replaceAll("}", "");
            if (msg.trim().length() > 0) {
                Info.display("", msg);
            }

        }
    }
}
