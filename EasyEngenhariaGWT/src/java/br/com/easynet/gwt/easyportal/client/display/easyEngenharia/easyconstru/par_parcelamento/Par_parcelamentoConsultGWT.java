/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.par_parcelamento;

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
public class Par_parcelamentoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Par_parcelamentoConsultGWT consultGWT = this;

    public Par_parcelamentoConsultGWT() {
        try {
            this.setHeading("Condições de Pagamento");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Par_parcelamentoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Par_parcelamentoTGWT>>(currency);

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("par_nr_id");
            column.setHeader("Código");
            column.setWidth(50);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("par_tx_nome");
            column.setHeader("Nome");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("par_nr_parcelas");
            column.setHeader("N. Parcelas");
            column.setWidth(65);
            column.setAlignment(HorizontalAlignment.RIGHT);
            configs.add(column);

            GridCellRenderer<Par_parcelamentoTGWT> btnDel = new GridCellRenderer<Par_parcelamentoTGWT>() {
                private boolean init;
                public Object render(final Par_parcelamentoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Par_parcelamentoTGWT> store, Grid<Par_parcelamentoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Par_parcelamentoTGWT>>() {

                            public void handleEvent(GridEvent<Par_parcelamentoTGWT> be) {
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
                                param.put("par_parcelamentoT.par_nr_id", model.getPar_nr_id()+"");
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
            ListStore<Par_parcelamentoTGWT> store = new ListStore<Par_parcelamentoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Par_parcelamentoTGWT par_parcelamentoTGWT = new Par_parcelamentoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer par_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("par_nr_id").toString()));
                par_parcelamentoTGWT.setPar_nr_id(par_nr_id);

                String par_tx_nome = EasyContainer.clearAspas(registro.get("par_tx_nome").toString());
                par_parcelamentoTGWT.setPar_tx_nome(par_tx_nome);

                Integer par_nr_parcelas = Integer.parseInt(EasyContainer.clearAspas(registro.get("par_nr_parcelas").toString()));
                par_parcelamentoTGWT.setPar_nr_parcelas(par_nr_parcelas);

                Integer par_nr_intervalo_dias = Integer.parseInt(EasyContainer.clearAspas(registro.get("par_nr_intervalo_dias").toString()));
                par_parcelamentoTGWT.setPar_nr_intervalo_dias(par_nr_intervalo_dias);
                store.add(par_parcelamentoTGWT);
            }

            ColumnModel cm = new ColumnModel(configs);
            Grid<Par_parcelamentoTGWT> grid = new Grid<Par_parcelamentoTGWT>(store, cm);
            grid.setLoadMask(true);
            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Par_parcelamentoTGWT>>() {
                public void handleEvent(GridEvent<Par_parcelamentoTGWT> be) {
                    Par_parcelamentoUpdateDeleteGWT par_parcelamentoUpdateDeleteGWT = new Par_parcelamentoUpdateDeleteGWT();
                    par_parcelamentoUpdateDeleteGWT.load(be.getModel());
                    par_parcelamentoUpdateDeleteGWT.setConsultGWT(consultGWT);
                    par_parcelamentoUpdateDeleteGWT.show();
                }
            });
            getCpMaster().removeAll();
            getCpMaster().add(grid);
            this.layout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Par_parcelamentoInsertGWT insert;
        try {
            insert = new Par_parcelamentoInsertGWT();
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
            eaurl.accessJSonMap(Constantes.URL + PAGE,param);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

