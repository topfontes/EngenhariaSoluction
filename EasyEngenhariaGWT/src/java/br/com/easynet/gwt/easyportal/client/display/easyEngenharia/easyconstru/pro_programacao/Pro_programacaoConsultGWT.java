/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pro_programacao;

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
import com.extjs.gxt.ui.client.data.ModelData;
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
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Pro_programacaoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pro_programacao/pro_programacaoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Pro_programacaoConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private Button btnFiltrar = new Button("Filtrar");
    private DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");

    public Pro_programacaoConsultGWT() {
        try {
            btnFiltrar.setIcon(ICONS.filter());
            btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    load();
                }
            });
            this.setMaximizable(true);

            povoaCombo();
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(cbObra);
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(btnFiltrar);

            listObraGWT.povoar();
            this.setHeading("Programação");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Pro_programacaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Pro_programacaoTGWT>>(currency);

            ColumnConfig column = null;
            column = new ColumnConfig();
            column.setId("pro_nr_mes");
            column.setHeader("Mês");
            column.setWidth(70);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_nr_ano");
            column.setHeader("Ano");
            column.setWidth(60);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_coleta_orcamento");
            column.setHeader("Dt. Coleta Orçamento");
            column.setDateTimeFormat(dtf);
            column.setWidth(150);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_coleta_rh");
            column.setHeader("Dt. Coleta RH");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_analise_inicio");
            column.setHeader("Dt. Início Análise");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_analise_final");
            column.setHeader("Dt. Final Análise");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_reuniao_engenharia");
            column.setHeader("Dt. Reunião Engenharia");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_reuniao_diretoria");
            column.setHeader("Dt. Reunião Diretoria");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_reuniao_geral");
            column.setHeader("Dt. Reunião Geral");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Pro_programacaoTGWT> btnEdit = new GridCellRenderer<Pro_programacaoTGWT>() {

                private boolean init;

                public Object render(final Pro_programacaoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Pro_programacaoTGWT> store, Grid<Pro_programacaoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Pro_programacaoTGWT>>() {

                            public void handleEvent(GridEvent<Pro_programacaoTGWT> be) {
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

                        //@Override
                        public void componentSelected(ButtonEvent ce) {
                            download(model);
                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Download");
                    btnCol.setIcon(ICONS.download());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };

            GridCellRenderer<Pro_programacaoTGWT> btnDel = new GridCellRenderer<Pro_programacaoTGWT>() {

                private boolean init;

                public Object render(final Pro_programacaoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Pro_programacaoTGWT> store, Grid<Pro_programacaoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Pro_programacaoTGWT>>() {

                            public void handleEvent(GridEvent<Pro_programacaoTGWT> be) {
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
                                param.put("Pro_programacaoTGWT.id", model.getPro_nr_mes() + "");
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

            column = new ColumnConfig();
            column.setId("edit");
            column.setHeader("");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setRenderer(btnEdit);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("del");
            column.setHeader("");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setRenderer(btnDel);
            configs.add(column);

        } catch (Exception ex) {
            Window.alert(ex.getMessage()+" nn");
        }
    }


    public Pro_programacaoConsultGWT(boolean visibleButton) {
        try {
            btnFiltrar.setIcon(ICONS.filter());
            btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    load();
                }
            });
            this.setMaximizable(true);

            btnFiltrar.setVisible(visibleButton);
            povoaCombo();
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(cbObra);
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(btnFiltrar);

            listObraGWT.povoar();
            this.setHeading("Programação");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Pro_programacaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Pro_programacaoTGWT>>(currency);

            ColumnConfig column = null;
            column = new ColumnConfig();
            column.setId("pro_nr_mes");
            column.setHeader("Mês");
            column.setWidth(70);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_nr_ano");
            column.setHeader("Ano");
            column.setWidth(60);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_coleta_orcamento");
            column.setHeader("Dt. Coleta Orçamento");
            column.setDateTimeFormat(dtf);
            column.setWidth(150);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_coleta_rh");
            column.setHeader("Dt. Coleta RH");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_analise_inicio");
            column.setHeader("Dt. Início Análise");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_analise_final");
            column.setHeader("Dt. Final Análise");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_reuniao_engenharia");
            column.setHeader("Dt. Reunião Engenharia");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_reuniao_diretoria");
            column.setHeader("Dt. Reunião Diretoria");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_reuniao_geral");
            column.setHeader("Dt. Reunião Geral");
            column.setWidth(150);
            column.setDateTimeFormat(dtf);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Pro_programacaoTGWT> btnEdit = new GridCellRenderer<Pro_programacaoTGWT>() {

                private boolean init;

                public Object render(final Pro_programacaoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Pro_programacaoTGWT> store, Grid<Pro_programacaoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Pro_programacaoTGWT>>() {

                            public void handleEvent(GridEvent<Pro_programacaoTGWT> be) {
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

                        //@Override
                        public void componentSelected(ButtonEvent ce) {
                            download(model);
                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Download");
                    btnCol.setIcon(ICONS.download());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };

            GridCellRenderer<Pro_programacaoTGWT> btnDel = new GridCellRenderer<Pro_programacaoTGWT>() {

                private boolean init;

                public Object render(final Pro_programacaoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Pro_programacaoTGWT> store, Grid<Pro_programacaoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Pro_programacaoTGWT>>() {

                            public void handleEvent(GridEvent<Pro_programacaoTGWT> be) {
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
                                param.put("Pro_programacaoTGWT.id", model.getPro_nr_mes() + "");
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

            column = new ColumnConfig();
            column.setId("edit");
            column.setHeader("");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setRenderer(btnEdit);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("del");
            column.setHeader("");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setRenderer(btnDel);
            configs.add(column);

        } catch (Exception ex) {
            Window.alert(ex.getMessage()+" nn");
        }
    }

    @Override
    protected void onShow() {
        super.onShow();
        maximize();
    }

    public void download(Pro_programacaoTGWT pro_programacaoT){

       final String url_download = Constantes.URL+ "easyEngenharia/easyconstru/relatorios/programacao.jsp" + getParamBaseExport(pro_programacaoT);
       final MessageBox mb = MessageBox.wait("Requisição", "Gerando Arquivo....", "Aguarde.......!!!");
        Timer timer = new Timer() {

            @Override
            public void run() {
                final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
                winDownload.setUrl(url_download);
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
                t.schedule(8000);
            }
        };
        timer.schedule(100);//
        
    }

    public String getParamBaseExport(Pro_programacaoTGWT pro_programacaoT) {
        return "?op=imprimir&obr_obrasT.obr_nr_id=" + pro_programacaoT.getObr_nr_id() + "&meo_meses_obraT.mes=" + pro_programacaoT.getPro_nr_mes() + "&meo_meses_obraT.ano=" + pro_programacaoT.getPro_nr_ano()+"&tipo=PDF";
    }

    public void povoaCombo(){
        cbObra.setWidth(250);
        cbObra.setDisplayField("obr_tx_nome");
        cbObra.setAllowBlank(false);
        cbObra.setTriggerAction(ComboBox.TriggerAction.ALL);
        Timer timer = new Timer() {

            @Override
            public void run() {
                if(! listObraGWT.isMostrar()){
                    schedule(500);
                }else{
                    ListStore<Obr_obrasTGWT> store = new ListStore<Obr_obrasTGWT>();
                    cbObra.setStore(listObraGWT.getStore());
                    cbObra.getView().setStore(listObraGWT.getStore());
                    cbObra.getView().refresh();
                }
            }
        };timer.schedule(500);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Pro_programacaoTGWT> store = new ListStore<Pro_programacaoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Pro_programacaoTGWT pro_programacaoTGWT = new Pro_programacaoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer pro_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_id").toString()));
                pro_programacaoTGWT.setPro_nr_id(pro_nr_id);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                pro_programacaoTGWT.setObr_nr_id(obr_nr_id);

                Integer pro_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_mes").toString()));
                pro_programacaoTGWT.setPro_nr_mes(pro_nr_mes);

                Integer pro_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_ano").toString()));
                pro_programacaoTGWT.setPro_nr_ano(pro_nr_ano);

                DateTimeFormat dtf4 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date pro_dt_coleta_orcamento = dtf4.parse(EasyContainer.clearAspas(registro.get("pro_dt_coleta_orcamento").toString()));
                pro_programacaoTGWT.setPro_dt_coleta_orcamento(pro_dt_coleta_orcamento);

                DateTimeFormat dtf5 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date pro_dt_coleta_rh = dtf5.parse(EasyContainer.clearAspas(registro.get("pro_dt_coleta_rh").toString()));
                pro_programacaoTGWT.setPro_dt_coleta_rh(pro_dt_coleta_rh);

                DateTimeFormat dtf6 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date pro_dt_analise_inicio = dtf6.parse(EasyContainer.clearAspas(registro.get("pro_dt_analise_inicio").toString()));
                pro_programacaoTGWT.setPro_dt_analise_inicio(pro_dt_analise_inicio);

                DateTimeFormat dtf7 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date pro_dt_analise_final = dtf7.parse(EasyContainer.clearAspas(registro.get("pro_dt_analise_final").toString()));
                pro_programacaoTGWT.setPro_dt_analise_final(pro_dt_analise_final);

                DateTimeFormat dtf8 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date pro_dt_reuniao_engenharia = dtf8.parse(EasyContainer.clearAspas(registro.get("pro_dt_reuniao_engenharia").toString()));
                pro_programacaoTGWT.setPro_dt_reuniao_engenharia(pro_dt_reuniao_engenharia);

                DateTimeFormat dtf9 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date pro_dt_reuniao_diretoria = dtf9.parse(EasyContainer.clearAspas(registro.get("pro_dt_reuniao_diretoria").toString()));
                pro_programacaoTGWT.setPro_dt_reuniao_diretoria(pro_dt_reuniao_diretoria);

                DateTimeFormat dtf10 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date pro_dt_reuniao_geral = dtf10.parse(EasyContainer.clearAspas(registro.get("pro_dt_reuniao_geral").toString()));
                pro_programacaoTGWT.setPro_dt_reuniao_geral(pro_dt_reuniao_geral);


                store.add(pro_programacaoTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Pro_programacaoTGWT> grid = new Grid<Pro_programacaoTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

            //final Pro_programacaoConsultGWT consultGWT = this;

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                        grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Pro_programacaoTGWT>>() {

                public void handleEvent(GridEvent<Pro_programacaoTGWT> be) {
                    Pro_programacaoUpdateDeleteGWT pro_programacaoUpdateDeleteGWT = new Pro_programacaoUpdateDeleteGWT();
                    pro_programacaoUpdateDeleteGWT.load(be.getModel());
                    pro_programacaoUpdateDeleteGWT.setConsultGWT(consultGWT);
                    pro_programacaoUpdateDeleteGWT.show();
                }
            });

            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Pro_programacaoInsertGWT insert;
        try {
            insert = new Pro_programacaoInsertGWT();
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
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("pro_programacaoT.obr_nr_id",cbObra.getValue().getObr_nr_id()+"" );
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the btnFiltrar
     */
    public Button getBtnFiltrar() {
        return btnFiltrar;
    }

    /**
     * @param btnFiltrar the btnFiltrar to set
     */
    public void setBtnFiltrar(Button btnFiltrar) {
        this.btnFiltrar = btnFiltrar;
    }
}

