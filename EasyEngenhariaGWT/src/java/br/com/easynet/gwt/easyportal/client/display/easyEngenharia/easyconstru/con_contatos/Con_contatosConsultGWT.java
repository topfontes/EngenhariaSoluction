/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.con_contatos;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.Portal2GWT;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import java.util.Date;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Con_contatosConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/con_contatos/con_contatosConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Con_contatosConsultGWT consultGWT = this;

    public Con_contatosConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Con_contatosTGWT>> numberRenderer = new NumberCellRenderer<Grid<Con_contatosTGWT>>(currency);
            /*
            GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
            public String render(Stock model, String property, ColumnData config, int rowIndex,
            int colIndex, ListStore<Stock> store) {
            double val = (Double) model.get(property);
            String style = val < 0 ? "red" : "green";
            return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
            }
            };
            GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
            public String render(Stock model, String property, ColumnData config, int rowIndex,
            int colIndex, ListStore<Stock> store) {
            return numberRenderer.render(null, property, model.get(property));
            }
            };
             */



            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("con_nr_id");
            column.setHeader("Con_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("cli_nr_id");
            column.setHeader("Cli_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("con_tx_nome");
            column.setHeader("Con_tx_nome");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("set_nr_id");
            column.setHeader("Set_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("con_tx_cargo_exercicio");
            column.setHeader("Con_tx_cargo_exercicio");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("con_tx_telefone");
            column.setHeader("Con_tx_telefone");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("con_tx_telefone2");
            column.setHeader("Con_tx_telefone2");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("con_tx_email");
            column.setHeader("Con_tx_email");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Con_contatosTGWT> btnEdit = new GridCellRenderer<Con_contatosTGWT>() {

                private boolean init;

                public Object render(final Con_contatosTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Con_contatosTGWT> store, Grid<Con_contatosTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Con_contatosTGWT>>() {

                            public void handleEvent(GridEvent<Con_contatosTGWT> be) {
                                for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                    if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                            && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                        ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                    }
                                }
                            }
                        });
                    }
                    com.extjs.gxt.ui.client.widget.button.Button btnCol = new com.extjs.gxt.ui.client.widget.button.Button("", new SelectionListener<ButtonEvent>() {

                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            Con_contatosUpdateDeleteGWT con_contatosUpdateDeleteGWT = new Con_contatosUpdateDeleteGWT();
                            con_contatosUpdateDeleteGWT.load(model);
                            con_contatosUpdateDeleteGWT.setConsultGWT(consultGWT);
                            con_contatosUpdateDeleteGWT.show();
                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };
            GridCellRenderer<Con_contatosTGWT> btnDel = new GridCellRenderer<Con_contatosTGWT>() {

                private boolean init;

                public Object render(final Con_contatosTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Con_contatosTGWT> store, Grid<Con_contatosTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Con_contatosTGWT>>() {

                            public void handleEvent(GridEvent<Con_contatosTGWT> be) {
                                for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                    if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                            && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                        ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                    }
                                }
                            }
                        });
                    }
                    com.extjs.gxt.ui.client.widget.button.Button btnCol = new com.extjs.gxt.ui.client.widget.button.Button("", new SelectionListener<ButtonEvent>() {

                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            try {
                                EasyAccessURL eaurl = new EasyAccessURL(consultGWT);
                                HashMap<String, String> param = new HashMap<String, String>();
                                param.put("op", "delete");
                                param.put("con_contatosT.con_nr_id", model.getCon_nr_id() + "");
                                eaurl.accessJSonMap(Constantes.URL + PAGE, param);

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Deletar");
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

            load();
            layout();
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }

    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Con_contatosTGWT> store = new ListStore<Con_contatosTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Con_contatosTGWT con_contatosTGWT = new Con_contatosTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer con_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("con_nr_id").toString()));
                con_contatosTGWT.setCon_nr_id(con_nr_id);

                Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
                con_contatosTGWT.setCli_nr_id(cli_nr_id);

                String con_tx_nome = EasyContainer.clearAspas(registro.get("con_tx_nome").toString());
                con_contatosTGWT.setCon_tx_nome(con_tx_nome);

                Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
                con_contatosTGWT.setSet_nr_id(set_nr_id);

                String con_tx_cargo_exercicio = EasyContainer.clearAspas(registro.get("con_tx_cargo_exercicio").toString());
                con_contatosTGWT.setCon_tx_cargo_exercicio(con_tx_cargo_exercicio);

                String con_tx_telefone = EasyContainer.clearAspas(registro.get("con_tx_telefone").toString());
                con_contatosTGWT.setCon_tx_telefone(con_tx_telefone);

                String con_tx_telefone2 = EasyContainer.clearAspas(registro.get("con_tx_telefone2").toString());
                con_contatosTGWT.setCon_tx_telefone2(con_tx_telefone2);

                String con_tx_email = EasyContainer.clearAspas(registro.get("con_tx_email").toString());
                con_contatosTGWT.setCon_tx_email(con_tx_email);


                store.add(con_contatosTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Con_contatosTGWT> grid = new Grid<Con_contatosTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Con_contatosInsertGWT insert;
        try {
            insert = new Con_contatosInsertGWT();
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
            eaurl.accessJSon(Constantes.URL + PAGE);//"portalgwt/exemplos/gridexemplo.jsp");
            List list = getCpMaster().getItems();
            if (list.size() > 0) {
                getCpMaster().removeAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

