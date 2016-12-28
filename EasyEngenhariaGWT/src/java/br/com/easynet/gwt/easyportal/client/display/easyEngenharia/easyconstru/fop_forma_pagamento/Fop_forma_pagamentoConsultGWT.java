/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fop_forma_pagamento;

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
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.GridEvent;

import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Fop_forma_pagamentoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Fop_forma_pagamentoConsultGWT consultGWT = this;

    public Fop_forma_pagamentoConsultGWT() {
        try {
            this.setHeading("Consiçoes de Pagamento");

            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Fop_forma_pagamentoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Fop_forma_pagamentoTGWT>>(currency);
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
            column.setId("fop_nr_id");
            column.setHeader("Código");
            column.setWidth(50);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("fop_tx_nome");
            column.setHeader("Nome");
            column.setWidth(370);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);


            GridCellRenderer<Fop_forma_pagamentoTGWT> btnEdit = new GridCellRenderer<Fop_forma_pagamentoTGWT>() {
                private boolean init;
                public Object render(final Fop_forma_pagamentoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Fop_forma_pagamentoTGWT> store, Grid<Fop_forma_pagamentoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Fop_forma_pagamentoTGWT>>() {

                            public void handleEvent(GridEvent<Fop_forma_pagamentoTGWT> be) {
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
                               Fop_forma_pagamentoUpdateDeleteGWT fop_forma_pagamentoUpdateDeleteGWT = new Fop_forma_pagamentoUpdateDeleteGWT();
                               fop_forma_pagamentoUpdateDeleteGWT.load(model);
                               fop_forma_pagamentoUpdateDeleteGWT.setConsultGWT(consultGWT);
                               fop_forma_pagamentoUpdateDeleteGWT.show();
                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };
            GridCellRenderer<Fop_forma_pagamentoTGWT> btnDel = new GridCellRenderer<Fop_forma_pagamentoTGWT>() {
                private boolean init;
                public Object render(final Fop_forma_pagamentoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Fop_forma_pagamentoTGWT> store, Grid<Fop_forma_pagamentoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Fop_forma_pagamentoTGWT>>() {

                            public void handleEvent(GridEvent<Fop_forma_pagamentoTGWT> be) {
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
                                HashMap<String,String> param = new HashMap<String, String>();
                                param.put("op", "delete");
                                param.put("fop_forma_pagamentoT.fop_nr_id", model.getFop_nr_id()+"");
                                eaurl.accessJSonMap(Constantes.URL +PAGE, param);

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
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Fop_forma_pagamentoTGWT> store = new ListStore<Fop_forma_pagamentoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Fop_forma_pagamentoTGWT fop_forma_pagamentoTGWT = new Fop_forma_pagamentoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer fop_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("fop_nr_id").toString()));
                fop_forma_pagamentoTGWT.setFop_nr_id(fop_nr_id);
                String fop_tx_nome = EasyContainer.clearAspas(registro.get("fop_tx_nome").toString());
                fop_forma_pagamentoTGWT.setFop_tx_nome(fop_tx_nome);
                String fop_tx_avista = EasyContainer.clearAspas(registro.get("fop_tx_avista").toString());
                fop_forma_pagamentoTGWT.setFop_tx_avista(fop_tx_avista);
                store.add(fop_forma_pagamentoTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Fop_forma_pagamentoTGWT> grid = new Grid<Fop_forma_pagamentoTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);
            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Fop_forma_pagamentoInsertGWT insert;
        try {
            insert = new Fop_forma_pagamentoInsertGWT();
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
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

