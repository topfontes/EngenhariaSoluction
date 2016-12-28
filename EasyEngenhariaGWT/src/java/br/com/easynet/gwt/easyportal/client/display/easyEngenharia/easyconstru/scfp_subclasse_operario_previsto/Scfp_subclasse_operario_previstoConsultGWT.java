/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.scfp_subclasse_operario_previsto;

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
public class Scfp_subclasse_operario_previstoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Scfp_subclasse_operario_previstoConsultGWT consultGWT = this;
    ListStore<Scfp_subclasse_operario_previstoTGWT> store;
    private Scfp_subclasse_operario_previstoTGWT scfp_subclasse_operario_previstoTGWT;

    public Scfp_subclasse_operario_previstoConsultGWT() {
        try {
            this.setHeading("Funções Mensalistas");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("500", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Scfp_subclasse_operario_previstoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Scfp_subclasse_operario_previstoTGWT>>(currency);


            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("subClasse");
            column.setHeader("Sub-Classe");
            column.setWidth(420);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Scfp_subclasse_operario_previstoTGWT> btnDel = new GridCellRenderer<Scfp_subclasse_operario_previstoTGWT>() {

                private boolean init;

                public Object render(final Scfp_subclasse_operario_previstoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Scfp_subclasse_operario_previstoTGWT> store, Grid<Scfp_subclasse_operario_previstoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Scfp_subclasse_operario_previstoTGWT>>() {

                            public void handleEvent(GridEvent<Scfp_subclasse_operario_previstoTGWT> be) {
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
                                RetornoDel rd = new RetornoDel();
                                EasyAccessURL eaurl = new EasyAccessURL(rd);
                                HashMap<String, String> param = new HashMap<String, String>();
                                param.put("op", "delete");
                                param.put("Scfp_subclasse_operario_previstoTGWT.scfp_nr_id", model.getScfp_nr_id() + "");
                                scfp_subclasse_operario_previstoTGWT = model;
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

            load();
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            store = new ListStore<Scfp_subclasse_operario_previstoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                
                Scfp_subclasse_operario_previstoTGWT scfp_subclasse_operario_previstoTGWT = new Scfp_subclasse_operario_previstoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                
                Integer id = Integer.parseInt(EasyContainer.clearAspas(registro.get("scfp_nr_id").toString()));
                scfp_subclasse_operario_previstoTGWT.setScfp_nr_id(id);

                String subClasse = EasyContainer.clearAspas(registro.get("subClasse").toString());
                scfp_subclasse_operario_previstoTGWT.setSubClasse(subClasse);
                store.add(scfp_subclasse_operario_previstoTGWT);
            }

            ColumnModel cm = new ColumnModel(configs);

            Grid<Scfp_subclasse_operario_previstoTGWT> grid = new Grid<Scfp_subclasse_operario_previstoTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");

            grid.setBorders(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            getCpMaster().removeAll();
            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Scfp_subclasse_operario_previstoInsertGWT insert;
        try {
            insert = new Scfp_subclasse_operario_previstoInsertGWT();
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
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    class RetornoDel implements IListenetResponse{
        public void read(JSONValue jsonValue) {
            if(jsonValue.toString().indexOf("sucesso")>-1){
                store.remove(scfp_subclasse_operario_previstoTGWT);
                store.commitChanges();
            }
        }

    }
}

