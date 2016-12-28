/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.frd_faturamento_rec_devolucao;

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
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Frd_faturamento_rec_devolucaoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Frd_faturamento_rec_devolucaoConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ToolBar bar = new ToolBar();
    private Button btnCarregar = new Button("Add. Último Mês", ICONS.plugin());
//    private Button btn

    public Frd_faturamento_rec_devolucaoConsultGWT() {
        try {
            listObraGWT.povoar();
            this.setHeading("Faturamento / Recebimento /Devolução");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("670", "300");
            final NumberFormat currency = NumberFormat.getFormat("#,##0.00");
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Frd_faturamento_rec_devolucaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Frd_faturamento_rec_devolucaoTGWT>>(currency);

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("frd_nr_id");
            column.setHeader("id");
            column.setHidden(true);
            column.setWidth(100);
            column.setNumberFormat(currency);
            column.setAlignment(HorizontalAlignment.RIGHT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("frd_nr_valor_permutado");
            column.setHeader("Valor Permultado Acum.");
            column.setWidth(100);
            column.setNumberFormat(currency);
            column.setAlignment(HorizontalAlignment.RIGHT);
            configs.add(column);

//            column = new ColumnConfig();
//            column.setId("frd_nr_vgv");
//            column.setHeader("Valor VGV");
//            column.setWidth(100);
//            column.setNumberFormat(currency);
//            column.setAlignment(HorizontalAlignment.RIGHT);
//            configs.add(column);

            column = new ColumnConfig();
            column.setId("frd_nr_valor_devolucao");
            column.setHeader("Valor Devolução Acum.");
            column.setWidth(100);
            column.setNumberFormat(currency);
            column.setAlignment(HorizontalAlignment.RIGHT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("frd_nr_valor_faturamento");
            column.setHeader("Valor Faturamento Acum.");
            column.setWidth(100);
            column.setNumberFormat(currency);
            column.setAlignment(HorizontalAlignment.RIGHT);
            configs.add(column);

//            column = new ColumnConfig();
//            column.setId("frd_nr_valor_recebimento");
//            column.setHeader("Valor Recebimento");
//            column.setWidth(100);
//            column.setNumberFormat(currency);
//            column.setAlignment(HorizontalAlignment.RIGHT);
//            configs.add(column);

            column = new ColumnConfig();
            column.setId("frd_nr_valor_permutas");
            column.setHeader("Valor Permutas Acum.");
            column.setWidth(100);
            column.setNumberFormat(currency);
            column.setAlignment(HorizontalAlignment.RIGHT);
            configs.add(column);

            GridCellRenderer<Frd_faturamento_rec_devolucaoTGWT> btnDel = new GridCellRenderer<Frd_faturamento_rec_devolucaoTGWT>() {

                private boolean init;

                public Object render(final Frd_faturamento_rec_devolucaoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Frd_faturamento_rec_devolucaoTGWT> store, Grid<Frd_faturamento_rec_devolucaoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Frd_faturamento_rec_devolucaoTGWT>>() {

                            public void handleEvent(GridEvent<Frd_faturamento_rec_devolucaoTGWT> be) {
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
                                param.put("frd_faturamento_rec_devolucaoT.frd_nr_id", model.getFrd_nr_id() + "");
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
            column.setId("del");
            column.setHeader("");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setRenderer(btnDel);
            configs.add(column);

            getCpMaster().setTopComponent(bar);

            addCompToolbar();

            layout();

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

            String url = Constantes.URL + Frd_faturamento_rec_devolucaoInsertGWT.PAGE + "?op=insert&insertValorMesAnt=true&frd_faturamento_rec_devolucaoT.frd_nr_mes=" + comboMes.getValue().getValue() + "&frd_faturamento_rec_devolucaoT.frd_nr_ano=" + comboAno.getValue().getValue() + "&frd_faturamento_rec_devolucaoT.obr_nr_id=" + comboObra.getValue().getObr_nr_id();
            EasyAccessURL eaurl = new EasyAccessURL(response);
            eaurl.accessJSon(url);

        } catch (Exception e) {
        }
    }

    public void addCompToolbar() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {

                    bar.add(new LabelToolItem("Obra:"));
                    comboObra.setStore(listObraGWT.getStore());
                    comboObra.setValueField("obr_nr_id");
                    comboObra.setDisplayField("obr_tx_nome");
                    comboObra.setEmptyText("Selecione a obra");
                    bar.add(comboObra);
                    bar.add(new SeparatorToolItem());

                    bar.add(new LabelToolItem("Mês:"));
                    ListStore<Meses> storemeses = new ListStore<Meses>();
                    storemeses.add(listMes_AnoGWT.getMeses());
                    comboMes.setStore(storemeses);
                    comboMes.setDisplayField("display");
                    comboMes.setEmptyText("Selecione o Mês");
                    bar.add(comboMes);
                    bar.add(new SeparatorToolItem());

                    bar.add(new LabelToolItem("Ano:"));
                    ListStore<Ano> storeAno = new ListStore<Ano>();
                    storeAno.add(listMes_AnoGWT.getListAno());
                    comboAno.setStore(storeAno);
                    comboAno.setDisplayField("display");
                    comboAno.setEmptyText("Selecione o Ano");
                    comboAno.setWidth(80);
                    bar.add(comboAno);

                    bar.add(new SeparatorToolItem());
                    bar.add(new SeparatorToolItem());
                    bar.add(new SeparatorToolItem());
                    Button button = new Button("Filtrar");
                    button.setIcon(ICONS.filter());
                    button.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                        public void handleEvent(ButtonEvent be) {
                            load();
                        }
                    });
                    bar.add(button);
                    bar.add(new SeparatorToolItem());
                    bar.add(new SeparatorToolItem());
                    bar.add(btnCarregar);

                    bar.layout();
                    btnCarregar.addSelectionListener(new SelectionListener<ButtonEvent>() {

                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            carregarValorUtimoMes();
                        }
                    });
                    getCpMaster().layout();
                    layout();
                }
            }
        };
        timer.schedule(500);
        layout();
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Frd_faturamento_rec_devolucaoTGWT> store = new ListStore<Frd_faturamento_rec_devolucaoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Frd_faturamento_rec_devolucaoTGWT frd_faturamento_rec_devolucaoTGWT = new Frd_faturamento_rec_devolucaoTGWT();
                JSONObject registro = resultado.get(i).isObject();

                Integer frd_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("frd_nr_id").toString()));
                frd_faturamento_rec_devolucaoTGWT.setFrd_nr_id(frd_nr_id);

                float frd_nr_valor_permutado = Float.parseFloat(EasyContainer.clearAspas(registro.get("frd_nr_valor_permutado").toString()));
                frd_faturamento_rec_devolucaoTGWT.setFrd_nr_valor_permutado(frd_nr_valor_permutado);

//                float frd_nr_vgv = Float.parseFloat(EasyContainer.clearAspas(registro.get("frd_nr_vgv").toString()));
//                frd_faturamento_rec_devolucaoTGWT.setFrd_nr_vgv(frd_nr_vgv);

                float frd_nr_valor_devolucao = Float.parseFloat(EasyContainer.clearAspas(registro.get("frd_nr_valor_devolucao").toString()));
                frd_faturamento_rec_devolucaoTGWT.setFrd_nr_valor_devolucao(frd_nr_valor_devolucao);

                float frd_nr_valor_faturamento = Float.parseFloat(EasyContainer.clearAspas(registro.get("frd_nr_valor_faturamento").toString()));
                frd_faturamento_rec_devolucaoTGWT.setFrd_nr_valor_faturamento(frd_nr_valor_faturamento);

//                float frd_nr_valor_recebimento = Float.parseFloat(EasyContainer.clearAspas(registro.get("frd_nr_valor_recebimento").toString()));
//                frd_faturamento_rec_devolucaoTGWT.setFrd_nr_valor_recebimento(frd_nr_valor_recebimento);

                float frd_nr_valor_permutas = Float.parseFloat(EasyContainer.clearAspas(registro.get("frd_nr_valor_permutas").toString()));
                frd_faturamento_rec_devolucaoTGWT.setFrd_nr_valor_permutas(frd_nr_valor_permutas);

                int obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                frd_faturamento_rec_devolucaoTGWT.setObr_nr_id(obr_nr_id);

                int frd_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("frd_nr_mes").toString()));
                frd_faturamento_rec_devolucaoTGWT.setFrd_nr_mes(frd_nr_mes);

                int frd_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("frd_nr_ano").toString()));
                frd_faturamento_rec_devolucaoTGWT.setFrd_nr_ano(frd_nr_ano);

                store.add(frd_faturamento_rec_devolucaoTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Frd_faturamento_rec_devolucaoTGWT> grid = new Grid<Frd_faturamento_rec_devolucaoTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");

            grid.setBorders(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Frd_faturamento_rec_devolucaoTGWT>>() {

                public void handleEvent(GridEvent<Frd_faturamento_rec_devolucaoTGWT> be) {

                    Frd_faturamento_rec_devolucaoUpdateDeleteGWT frd_faturamento_rec_devolucaoUpdateDeleteGWT = new Frd_faturamento_rec_devolucaoUpdateDeleteGWT();
                    frd_faturamento_rec_devolucaoUpdateDeleteGWT.load(be.getModel());
                    frd_faturamento_rec_devolucaoUpdateDeleteGWT.setConsultGWT(consultGWT);
                    frd_faturamento_rec_devolucaoUpdateDeleteGWT.show();
                }
            });
            getCpMaster().removeAll();
            getCpMaster().add(grid);
            btnCarregar.setEnabled(store.getCount() == 0);
            this.layout();

        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Frd_faturamento_rec_devolucaoInsertGWT insert;
        try {
            insert = new Frd_faturamento_rec_devolucaoInsertGWT();
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
            HashMap param = new HashMap();
            param.put("op", "consult");
            param.put("frd_faturamento_rec_devolucaoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("frd_faturamento_rec_devolucaoT.frd_nr_mes", comboMes.getValue().getValue() + "");
            param.put("frd_faturamento_rec_devolucaoT.frd_nr_ano", comboAno.getValue().getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
