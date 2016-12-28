/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_equivalencia;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.event.Events;
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
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import java.util.HashMap;
//--

/**
 *
 * @author geoleite
 */
public class Vw_equivalenciaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Vw_equivalenciaConsultGWT consultGWT = this;

    public Vw_equivalenciaConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Vw_equivalenciaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_equivalenciaTGWT>>(currency);
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
            column.setId("eplc_nr_id");
            column.setHeader("Eplc_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plc_nr_id");
            column.setHeader("Plc_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plco_nr_id");
            column.setHeader("Plco_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plco_tx_nome");
            column.setHeader("Plco_tx_nome");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plc_tx_nome");
            column.setHeader("Plc_tx_nome");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plco_tx_tipo");
            column.setHeader("Plco_tx_tipo");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plco_tx_cod_externo");
            column.setHeader("Plco_tx_cod_externo");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plco_tx_unidade");
            column.setHeader("Plco_tx_unidade");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);


            GridCellRenderer<Vw_equivalenciaTGWT> btnEdit = new GridCellRenderer<Vw_equivalenciaTGWT>() {

                private boolean init;

                public Object render(final Vw_equivalenciaTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Vw_equivalenciaTGWT> store, Grid<Vw_equivalenciaTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_equivalenciaTGWT>>() {

                            public void handleEvent(GridEvent<Vw_equivalenciaTGWT> be) {
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
                            Vw_equivalenciaUpdateDeleteGWT vw_equivalenciaUpdateDeleteGWT = new Vw_equivalenciaUpdateDeleteGWT();
                            vw_equivalenciaUpdateDeleteGWT.load(model);
                            vw_equivalenciaUpdateDeleteGWT.setConsultGWT(consultGWT);
                            vw_equivalenciaUpdateDeleteGWT.show();
                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };

            GridCellRenderer<Vw_equivalenciaTGWT> btnDel = new GridCellRenderer<Vw_equivalenciaTGWT>() {

                private boolean init;

                public Object render(final Vw_equivalenciaTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Vw_equivalenciaTGWT> store, Grid<Vw_equivalenciaTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_equivalenciaTGWT>>() {

                            public void handleEvent(GridEvent<Vw_equivalenciaTGWT> be) {
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
                                param.put("cen_centro_custoT.cen_nr_id", model.getEplc_nr_id() + "");
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

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSon(Constantes.URL + PAGE);//"portalgwt/exemplos/gridexemplo.jsp");
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

            GroupingStore<Vw_equivalenciaTGWT> store = new GroupingStore<Vw_equivalenciaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Vw_equivalenciaTGWT vw_equivalenciaTGWT = new Vw_equivalenciaTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer eplc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("eplc_nr_id").toString()));
                vw_equivalenciaTGWT.setEplc_nr_id(eplc_nr_id);

                Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                vw_equivalenciaTGWT.setPlc_nr_id(plc_nr_id);

                Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                vw_equivalenciaTGWT.setPlco_nr_id(plco_nr_id);

                String plco_tx_nome = EasyContainer.clearAspas(registro.get("plco_tx_nome").toString());
                vw_equivalenciaTGWT.setPlco_tx_nome(plco_tx_nome);

                String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                vw_equivalenciaTGWT.setPlc_tx_nome(plc_tx_nome);

                String plco_tx_tipo = EasyContainer.clearAspas(registro.get("plco_tx_tipo").toString());
                vw_equivalenciaTGWT.setPlco_tx_tipo(plco_tx_tipo);

                String plco_tx_cod_externo = EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString());
                vw_equivalenciaTGWT.setPlco_tx_cod_externo(plco_tx_cod_externo);

                String plco_tx_unidade = EasyContainer.clearAspas(registro.get("plco_tx_unidade").toString());
                vw_equivalenciaTGWT.setPlco_tx_unidade(plco_tx_unidade);
                store.add(vw_equivalenciaTGWT);
            }

            store.groupBy("plc_tx_nome");

            final ColumnModel cm = new ColumnModel(configs);
            GroupingView view = new GroupingView();
            view.setShowGroupedColumn(false);
            view.setForceFit(true);
            view.setGroupRenderer(new GridGroupRenderer() {
                public String render(GroupColumnData data) {
                    String f = cm.getColumnById(data.field).getHeader();
                    String l = data.models.size() == 1 ? "Item" : "Items";
                    return f + ": " + data.group + " (" + data.models.size() + " " + l + ")";
                }
            });
            Grid<Vw_equivalenciaTGWT> grid = new Grid<Vw_equivalenciaTGWT>(store, cm);
            grid.setView(view);
            grid.setLoadMask(true);
            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);

            getCpMaster().removeAll();
            getCpMaster().add(grid);
            consultGWT.layout();
            doLayout();
        }

    }

//    @Override
    public void btnNovoAction(ToolBarEvent be) {
        Vw_equivalenciaInsertGWT insert;
        try {
            insert = new Vw_equivalenciaInsertGWT();
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

