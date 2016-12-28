/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.car_carro;

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
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Car_carroConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/car_carro/car_carroConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Car_carroConsultGWT consultGWT = this;

    public Car_carroConsultGWT() {
        try {
            this.setHeading("Consulta carros");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Car_carroTGWT>> numberRenderer = new NumberCellRenderer<Grid<Car_carroTGWT>>(currency);
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
            column.setId("car_tx_nome");
            column.setHeader("nome");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("car_tx_marca");
            column.setHeader("marca");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Car_carroTGWT> btnEdit = new GridCellRenderer<Car_carroTGWT>() {

                private boolean init;

                public Object render(final Car_carroTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Car_carroTGWT> store, Grid<Car_carroTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Car_carroTGWT>>() {

                            public void handleEvent(GridEvent<Car_carroTGWT> be) {
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

                            Car_carroUpdateDeleteGWT car_carroUpdateDeleteGWT = new Car_carroUpdateDeleteGWT();
                            car_carroUpdateDeleteGWT.load(model);
                            car_carroUpdateDeleteGWT.setConsultGWT(consultGWT);
                            car_carroUpdateDeleteGWT.show();

                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };

            GridCellRenderer<Car_carroTGWT> btnDel = new GridCellRenderer<Car_carroTGWT>() {

                private boolean init;

                public Object render(final Car_carroTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Car_carroTGWT> store, Grid<Car_carroTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Car_carroTGWT>>() {

                            public void handleEvent(GridEvent<Car_carroTGWT> be) {
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
                                param.put("Car_carroTGWT.id", model.getCar_nr_id() + "");
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
           column=new ColumnConfig();
           column.setHeader("");
           column.setRenderer(btnEdit);
           configs.add(column);
           column.setWidth(30);

           column=new ColumnConfig();
           column.setHeader("");
           column.setRenderer(btnDel);
           configs.add(column);
           column.setWidth(30);

            load();
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

            ListStore<Car_carroTGWT> store = new ListStore<Car_carroTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Car_carroTGWT car_carroTGWT = new Car_carroTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer car_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("car_nr_id").toString()));
                car_carroTGWT.setCar_nr_id(car_nr_id);

                String car_tx_nome = EasyContainer.clearAspas(registro.get("car_tx_nome").toString());
                car_carroTGWT.setCar_tx_nome(car_tx_nome);

                String car_tx_marca = EasyContainer.clearAspas(registro.get("car_tx_marca").toString());
                car_carroTGWT.setCar_tx_marca(car_tx_marca);


                store.add(car_carroTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Car_carroTGWT> grid = new Grid<Car_carroTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

            //final Car_carroConsultGWT consultGWT = this;

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            getCpMaster().removeAll();
            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Car_carroInsertGWT insert;
        try {
            insert = new Car_carroInsertGWT();
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
