/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ume_unidade_medida;

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

import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Ume_unidade_medidaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Ume_unidade_medidaConsultGWT consultGWT = this;

    public Ume_unidade_medidaConsultGWT() {
        try {
            this.setHeading("Unidade Medida");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Ume_unidade_medidaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ume_unidade_medidaTGWT>>(currency);
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
            column.setId("ume_nr_id");
            column.setHeader("Codigo");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setHidden(true);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("ume_tx_nome");
            column.setHeader("Unidade Medida");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Ume_unidade_medidaTGWT> btnDel = new GridCellRenderer<Ume_unidade_medidaTGWT>() {

                private boolean init;

                public Object render(final Ume_unidade_medidaTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Ume_unidade_medidaTGWT> store, Grid<Ume_unidade_medidaTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Ume_unidade_medidaTGWT>>() {

                            public void handleEvent(GridEvent<Ume_unidade_medidaTGWT> be) {
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
                                param.put("ume_unidade_medidaT.ume_nr_id", model.getUme_nr_id() + "");
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

            ListStore<Ume_unidade_medidaTGWT> store = new ListStore<Ume_unidade_medidaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Ume_unidade_medidaTGWT ume_unidade_medidaTGWT = new Ume_unidade_medidaTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer ume_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ume_nr_id").toString()));
                ume_unidade_medidaTGWT.setUme_nr_id(ume_nr_id);

                String ume_tx_nome = EasyContainer.clearAspas(registro.get("ume_tx_nome").toString());
                ume_unidade_medidaTGWT.setUme_tx_nome(ume_tx_nome);


                store.add(ume_unidade_medidaTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Ume_unidade_medidaTGWT> grid = new Grid<Ume_unidade_medidaTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

            //final Ume_unidade_medidaConsultGWT consultGWT = this;

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Ume_unidade_medidaTGWT>>() {
                public void handleEvent(GridEvent<Ume_unidade_medidaTGWT> be) {
                    Ume_unidade_medidaUpdateDeleteGWT update = new Ume_unidade_medidaUpdateDeleteGWT();
                    update.load(be.getModel());
                    update.setConsultGWT(consultGWT);
                    update.show();
                }
            });
            grid.setStripeRows(true);
            getCpMaster().removeAll();
            getCpMaster().add(grid);
            this.layout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Ume_unidade_medidaInsertGWT insert;
        try {
            insert = new Ume_unidade_medidaInsertGWT();
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

