/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uno_unidade_obra;

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
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;

import com.extjs.gxt.ui.client.event.GridEvent;

import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Uno_unidade_obraConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Uno_unidade_obraConsultGWT consultGWT = this;

    public Uno_unidade_obraConsultGWT() {
        try {
            this.setHeading("Unidade Construtiva");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Uno_unidade_obraTGWT>> numberRenderer = new NumberCellRenderer<Grid<Uno_unidade_obraTGWT>>(currency);

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("obr_tx_nome");
            column.setHeader("Obra");
            column.setWidth(200);
            column.setHidden(true);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("uni_tx_nome");
            column.setHeader("Unidade Construtiva");
            column.setWidth(100);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("uno_nr_quantidade");
            column.setHeader("Qauntidade");
            column.setWidth(60);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("uno_nr_area_construida");
            column.setHeader("A. Construida");
            column.setWidth(70);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Uno_unidade_obraTGWT> btnDel = new GridCellRenderer<Uno_unidade_obraTGWT>() {

                private boolean init;

                public Object render(final Uno_unidade_obraTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Uno_unidade_obraTGWT> store, Grid<Uno_unidade_obraTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Uno_unidade_obraTGWT>>() {

                            public void handleEvent(GridEvent<Uno_unidade_obraTGWT> be) {
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
                                param.put("uno_unidade_obraT.uno_nr_id", model.getUno_nr_id() + "");
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

            JSONArray resultado = jsonObject.get("resultado").isArray();
            List<Uno_unidade_obraTGWT> listUno = new ArrayList<Uno_unidade_obraTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Uno_unidade_obraTGWT uno_unidade_obraTGWT = new Uno_unidade_obraTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer uno_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("uno_nr_id").toString()));
                uno_unidade_obraTGWT.setUno_nr_id(uno_nr_id);
                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                uno_unidade_obraTGWT.setObr_nr_id(obr_nr_id);
                String uni_nr_id = EasyContainer.clearAspas(registro.get("uni_nr_id").toString());
                uno_unidade_obraTGWT.setUni_nr_id(Integer.parseInt(uni_nr_id));
                Integer uno_nr_quantidade = Integer.parseInt(EasyContainer.clearAspas(registro.get("uno_nr_quantidade").toString()));
                uno_unidade_obraTGWT.setUno_nr_quantidade(uno_nr_quantidade);

                float uno_nr_area_construida = Float.parseFloat(EasyContainer.clearAspas(registro.get("uno_nr_area_construida").toString()));
                uno_unidade_obraTGWT.setUno_nr_area_construida(uno_nr_area_construida);

                String uni_tx_nome = EasyContainer.clearAspas(registro.get("uni_tx_nome").toString());
                uno_unidade_obraTGWT.setUni_tx_nome(uni_tx_nome);
                String obr_tx_nome = EasyContainer.clearAspas(registro.get("obr_tx_nome").toString());
                uno_unidade_obraTGWT.setObr_tx_nome(obr_tx_nome);

                listUno.add(uno_unidade_obraTGWT);
            }

            GroupingStore<Uno_unidade_obraTGWT> store = new GroupingStore<Uno_unidade_obraTGWT>();
            store.add(listUno);
            store.groupBy("obr_tx_nome");

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

            Grid<Uno_unidade_obraTGWT> grid = new Grid<Uno_unidade_obraTGWT>(store, cm);
            grid.setView(view);
            grid.setLoadMask(true);
            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Uno_unidade_obraTGWT>>() {

                public void handleEvent(GridEvent<Uno_unidade_obraTGWT> be) {
                    Uno_unidade_obraUpdateDeleteGWT uno_unidade_obraUpdateDeleteGWT = new Uno_unidade_obraUpdateDeleteGWT();
                    uno_unidade_obraUpdateDeleteGWT.load(be.getModel());
                    uno_unidade_obraUpdateDeleteGWT.setConsultGWT(consultGWT);
                    uno_unidade_obraUpdateDeleteGWT.show();
                }
            });
            getCpMaster().removeAll();
            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Uno_unidade_obraInsertGWT insert;
        try {
            insert = new Uno_unidade_obraInsertGWT();
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
            eaurl.accessJSon(Constantes.URL + PAGE);
            getCpMaster().removeAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

