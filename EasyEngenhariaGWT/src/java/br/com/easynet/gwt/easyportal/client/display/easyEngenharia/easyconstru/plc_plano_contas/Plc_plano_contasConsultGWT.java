/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
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
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;

import com.extjs.gxt.ui.client.event.GridEvent;

import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.event.dom.client.ClickEvent;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Plc_plano_contasConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private int nivel;
    final Plc_plano_contasConsultGWT consultGWT = this;
    CheckBox box = new CheckBox();
    private StoreFilterField<Plc_plano_contasTGWT> storeFiltro;

    public Plc_plano_contasConsultGWT(int nivel) {
        try {
            final int niv = nivel;
            this.nivel = nivel;
            this.setHeading(nivel == 1 ? "Classes" : "Sub-Classes");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "500");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Plc_plano_contasTGWT>> numberRenderer = new NumberCellRenderer<Grid<Plc_plano_contasTGWT>>(currency);

            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new LabelToolItem(this.nivel ==1?"Classe:":"Sub Classe"));
            getToolBarMaster().add(new SeparatorToolItem());

            ColumnConfig column = null;

            column = new ColumnConfig("plc_nr_id", "Código", 10);
            configs.add(column);
            column.setHidden(true);

            column = new ColumnConfig("plc_tx_nome", nivel == 1 ? "Classe" : "Sub Classe", 80);
            configs.add(column);

            if (getNivel() == 1) {
                column = new ColumnConfig("plc_tx_centro_custo", "Centro Custo", 110);
                configs.add(column);
            } else {
                column = new ColumnConfig("plc_tx_super", "Classe", 80);
                configs.add(column);
                column = new ColumnConfig("par_tx_nome", "Condição Pgto.", 50);
                configs.add(column);
            }

            GridCellRenderer<Plc_plano_contasTGWT> btnDel = new GridCellRenderer<Plc_plano_contasTGWT>() {

                private boolean init;

                public Object render(final Plc_plano_contasTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Plc_plano_contasTGWT> store, Grid<Plc_plano_contasTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Plc_plano_contasTGWT>>() {

                            public void handleEvent(GridEvent<Plc_plano_contasTGWT> be) {
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
                                Resposta resposta = new Resposta();
                                EasyAccessURL eaurl = new EasyAccessURL(resposta);
                                HashMap<String, String> param = new HashMap<String, String>();
                                param.put("op", "delete");
                                param.put("plc_plano_contasT.plc_nr_id", model.getPlc_nr_id() + "");
                                eaurl.accessJSonMap(Constantes.URL + Plc_plano_contasUpdateDeleteGWT.PAGE, param);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Deletar");
                    btnCol.setIcon(ICONS.del());
                    btnCol.setWidth(20);

                    return btnCol;
                }
            };

            column = new ColumnConfig();
            column.setId("del");
            column.setHeader("");
            column.setWidth(10);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setRenderer(btnDel);
            configs.add(column);

            this.load();
            this.layout();

        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            List<Plc_plano_contasTGWT> listplc = new ArrayList<Plc_plano_contasTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Plc_plano_contasTGWT plc_plano_contasTGWT = new Plc_plano_contasTGWT();
                JSONObject registro = resultado.get(i).isObject();

                Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                plc_plano_contasTGWT.setPlc_nr_id(plc_nr_id);

                String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                plc_plano_contasTGWT.setPlc_tx_nome(plc_tx_nome);

                Integer plc_nr_id_super = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id_super").toString()));
                plc_plano_contasTGWT.setPlc_nr_id_super(plc_nr_id_super);

                String plc_tx_super = EasyContainer.clearAspas(registro.get("plc_tx_super").toString());
                plc_plano_contasTGWT.setPlc_tx_super(plc_tx_super);

                String cen_nr_id = EasyContainer.clearAspas(registro.get("cen_nr_id").toString());
                plc_plano_contasTGWT.setCen_nr_id(cen_nr_id.trim().length() > 0 ? Integer.parseInt(cen_nr_id) : 0);

                String plc_tx_centro_custo = EasyContainer.clearAspas(registro.get("plc_tx_centro_custo").toString());
                plc_plano_contasTGWT.setPlc_tx_centro_custo(plc_tx_centro_custo);

                String par_tx_nome = EasyContainer.clearAspas(registro.get("par_tx_nome").toString());
                plc_plano_contasTGWT.setPar_tx_nome(par_tx_nome);


                if (getNivel() == 1 && plc_nr_id_super == 0) {
                    listplc.add(plc_plano_contasTGWT);
                } else if (getNivel() == 2 && plc_nr_id_super > 0) {
                    String par_nr_id = EasyContainer.clearAspas(registro.get("par_nr_id").toString());
                    if (par_nr_id.trim().length() > 0) {
                        plc_plano_contasTGWT.setPar_nr_id(Integer.parseInt(par_nr_id));
                    }
                    listplc.add(plc_plano_contasTGWT);
                }
            }

            PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(listplc);
            PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
            loader.setRemoteSort(true);
            
            GroupingStore<Plc_plano_contasTGWT> store = new GroupingStore<Plc_plano_contasTGWT>(loader);

            store.add(listplc);
            storeFiltro = getStoreFilter();
            storeFiltro.setWidth(200);
            storeFiltro.bind(store);
            getToolBarMaster().add(storeFiltro);
            storeFiltro.setEmptyText("Localização pelo nome do cliente");
            getToolBarPage().setPageSize(25);
            getToolBarPage().bind(loader);
            loader.load(0, 25);


            if (getNivel() == 1) {
                store.groupBy("plc_tx_centro_custo");
            } else {
                store.groupBy("plc_tx_super");
            }

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
            final int niv = this.nivel;
            Grid<Plc_plano_contasTGWT> grid = new Grid<Plc_plano_contasTGWT>(store, cm);
            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Plc_plano_contasTGWT>>() {

                public void handleEvent(GridEvent<Plc_plano_contasTGWT> be) {
                    if (be != null) {
                        Plc_plano_contasUpdateDeleteGWT plc_plano_contasUpdateDeleteGWT = new Plc_plano_contasUpdateDeleteGWT(niv);
                        plc_plano_contasUpdateDeleteGWT.load(be.getModel());
                        plc_plano_contasUpdateDeleteGWT.setConsultGWT(consultGWT);
                        plc_plano_contasUpdateDeleteGWT.show();
                    }
                }
            });
            grid.setView(view);
            grid.setLoadMask(true);
            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);

            getCpMaster().removeAll();
            grid.setToolTip("Duplo click altera o registro");
            getCpMaster().add(grid);
            consultGWT.layout();
            doLayout();
            //Window.alert("Chegou");
        }
    }
    public StoreFilterField<Plc_plano_contasTGWT> getStoreFilter() {
        StoreFilterField<Plc_plano_contasTGWT> storef;
        if (storeFiltro != null) {
            storef = storeFiltro;
        } else {
            storef = new StoreFilterField<Plc_plano_contasTGWT>() {
                @Override
                protected boolean doSelect(Store<Plc_plano_contasTGWT> store, Plc_plano_contasTGWT parent, Plc_plano_contasTGWT record, String property, String filter) {
                    String name = record.get("plc_tx_nome");
                    name = name.toLowerCase();
                    if (name.startsWith(filter.toLowerCase())) {
                        return true;
                    }
                    return false;
                }
            };
        }
        return storef;
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Plc_plano_contasInsertGWT insert;
        try {
            insert = new Plc_plano_contasInsertGWT(nivel);
            insert.setConsultGWT(consultGWT);
            insert.setModal(true);
            insert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            getCpMaster().removeAll();
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", this.nivel == 1 ? "consultSuper" : "consultSubClasse");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setClasseSuper(List<Plc_plano_contasTGWT> list) {

        for (Plc_plano_contasTGWT classe : list) {
            if (classe.getPlc_nr_id_super() == 0) {
                classe.setPlc_tx_super("Classes Sintética");
            } else {
                classe.setPlc_tx_super(locateClasse(list, classe.getPlc_nr_id_super()));
            }
        }
    }

    public String locateClasse(List<Plc_plano_contasTGWT> list, int idsuper) {
        for (int i = 0; i < list.size(); i++) {
            Plc_plano_contasTGWT plc_plano = list.get(i);
            if (plc_plano.getPlc_nr_id() == idsuper) {
                return plc_plano.getPlc_tx_nome();
            }
        }
        return null;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    } 

    class Resposta implements IListenetResponse{

        public void read(JSONValue jsonValue) {
            if(jsonValue.toString().indexOf("sucesso") > -1){
                getShowMsgExclusao();
                load();
            }else{
                getShowMsgErro(EasyContainer.clearAspas(jsonValue.toString()));
            }
        }

    }
}

