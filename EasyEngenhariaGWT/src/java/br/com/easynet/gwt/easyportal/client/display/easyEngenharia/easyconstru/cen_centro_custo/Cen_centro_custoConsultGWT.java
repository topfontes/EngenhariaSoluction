/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cen_centro_custo;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Cen_centro_custoTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
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
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import java.util.HashMap;
//import com.extjs.gxt.ui.client.widget.button.Button;

/**
 *
 * @author geoleite
 */
public class Cen_centro_custoConsultGWT extends ConsultaGWT implements IListenetResponse {
                                       
    public static final String PAGE = "easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Cen_centro_custoConsultGWT consultGWT = this;

    public Cen_centro_custoConsultGWT() {
        try {
            this.setHeading("Natureza dos Custos");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Cen_centro_custoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Cen_centro_custoTGWT>>(currency);

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("cen_nr_id");
            column.setHeader("Código");
            column.setWidth(70);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();

            column.setId("cen_tx_nome");
            column.setHeader("Centro Custo");
            column.setWidth(400);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

//            GridCellRenderer<Cen_centro_custoTGWT> btnEdit = new GridCellRenderer<Cen_centro_custoTGWT>() {
//
//                private boolean init;
//
//                public Object render(final Cen_centro_custoTGWT model, String property, ColumnData config, final int rowIndex,
//                        final int colIndex, ListStore<Cen_centro_custoTGWT> store, Grid<Cen_centro_custoTGWT> grid) {
//                    if (!init) {
//                        init = true;
//                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Cen_centro_custoTGWT>>() {
//
//                            public void handleEvent(GridEvent<Cen_centro_custoTGWT> be) {
//                                for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
//                                    if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
//                                            && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
//                                        ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
//                                    }
//                                }
//                            }
//                        });
//                    }
//                    Button btnCol = new Button("", new SelectionListener<ButtonEvent>() {
//
//                        @Override
//                        public void componentSelected(ButtonEvent ce) {
//                            Cen_centro_custoUpdateDeleteGWT cen_centro_custoUpdateDeleteGWT = new Cen_centro_custoUpdateDeleteGWT();
//                            cen_centro_custoUpdateDeleteGWT.load(model);
//                            cen_centro_custoUpdateDeleteGWT.setConsultGWT(consultGWT);
//                            cen_centro_custoUpdateDeleteGWT.show();
//                        }
//                    });
//                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
//                    btnCol.setToolTip("Alterar");
//                    btnCol.setIcon(ICONS.edit());
//                    btnCol.setBorders(false);
//
//                    return btnCol;
//                }
//            };

            GridCellRenderer<Cen_centro_custoTGWT> btnDel = new GridCellRenderer<Cen_centro_custoTGWT>() {

                private boolean init;

                public Object render(final Cen_centro_custoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Cen_centro_custoTGWT> store, Grid<Cen_centro_custoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Cen_centro_custoTGWT>>() {

                            public void handleEvent(GridEvent<Cen_centro_custoTGWT> be) {
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
                                param.put("cen_centro_custoT.cen_nr_id", model.getCen_nr_id() + "");
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

//            column = new ColumnConfig();
//            column.setId("edit");
//            column.setHeader("");
//            column.setWidth(30);
//            column.setAlignment(HorizontalAlignment.LEFT);
//            column.setRenderer(btnEdit);
//            configs.add(column);

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
        TextField<String> box = new TextField<String>();

        //final Cen_centro_custoConsultGWT consultGWT = this;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            List<Cen_centro_custoTGWT> listCentro = new ArrayList<Cen_centro_custoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Cen_centro_custoTGWT cen_centro_custoTGWT = new Cen_centro_custoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer cen_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cen_nr_id").toString()));
                cen_centro_custoTGWT.setCen_nr_id(cen_nr_id);
                String cen_tx_nome = EasyContainer.clearAspas(registro.get("cen_tx_nome").toString());
                cen_centro_custoTGWT.setCen_tx_nome(cen_tx_nome);
                //store.add(cen_centro_custoTGWT);
                listCentro.add(cen_centro_custoTGWT);
            }

            ListStore<Cen_centro_custoTGWT> store = new ListStore<Cen_centro_custoTGWT>();

            store.add(listCentro);

            ColumnModel cm = new ColumnModel(configs);
            Grid<Cen_centro_custoTGWT> grid = new Grid<Cen_centro_custoTGWT>(store, cm);

            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Cen_centro_custoTGWT>>() {
                public void handleEvent(GridEvent<Cen_centro_custoTGWT> be) {
                    Cen_centro_custoUpdateDeleteGWT cen_centro_custoUpdateDeleteGWT = new Cen_centro_custoUpdateDeleteGWT();
                    cen_centro_custoUpdateDeleteGWT.load(be.getModel());
                    cen_centro_custoUpdateDeleteGWT.setConsultGWT(consultGWT);
                    cen_centro_custoUpdateDeleteGWT.show();
                }
            });


            grid.setLoadMask(true);
            grid.setStyleAttribute("borderTop", "none");
            grid.setStripeRows(true);

            getCpMaster().removeAll();
            getCpMaster().add(grid);
            consultGWT.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Cen_centro_custoInsertGWT insert;
        try {
            //final Cen_centro_custoConsultGWT consultGWT = this;
            insert = new Cen_centro_custoInsertGWT();
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
            //if (list != null) {
            getCpMaster().removeAll();
            this.layout();
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

