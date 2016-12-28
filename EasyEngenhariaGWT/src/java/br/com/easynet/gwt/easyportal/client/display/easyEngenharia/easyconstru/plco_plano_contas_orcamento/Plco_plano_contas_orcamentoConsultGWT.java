/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
//br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
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
import com.extjs.gxt.ui.client.event.ButtonEvent;
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
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;

import com.extjs.gxt.ui.client.event.GridEvent;

import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class Plco_plano_contas_orcamentoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Plco_plano_contas_orcamentoConsultGWT consultGWT = this;
    private PlcoConsult plcoConsult = new PlcoConsult();
    private boolean valido;
    private int cont = 1;
    private ListStore<Plco_plano_contas_orcamentoTGWT> listNivel1, listNivel2, listNivel3;
    private ListStore<Plco_plano_contas_orcamentoTGWT> store;

    public Plco_plano_contas_orcamentoConsultGWT() {
        try {
            this.setHeading("Funções/Insumos");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("770", "500");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Plco_plano_contas_orcamentoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Plco_plano_contas_orcamentoTGWT>>(currency);

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("plco_tx_cod_externo");
            column.setHeader("Código");
            column.setWidth(100);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plco_tx_nome");
            column.setHeader("Função/Insumo");
            column.setWidth(380);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plco_tx_tipo");
            column.setHeader("Classificação");
            column.setWidth(100);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plco_tx_unidade");
            column.setHeader("Unidade");
            column.setWidth(70);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Plco_plano_contas_orcamentoTGWT> btnDel = new GridCellRenderer<Plco_plano_contas_orcamentoTGWT>() {

                private boolean init;

                public Object render(final Plco_plano_contas_orcamentoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Plco_plano_contas_orcamentoTGWT> store, Grid<Plco_plano_contas_orcamentoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Plco_plano_contas_orcamentoTGWT>>() {

                            public void handleEvent(GridEvent<Plco_plano_contas_orcamentoTGWT> be) {
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
                                param.put("plco_plano_contas_orcamentoT.plco_nr_id", model.getPlco_nr_id() + "");
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
            
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
    }

    @Override
    protected void onShow() {
        super.onShow();
        
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            List<Plco_plano_contas_orcamentoTGWT> list = new Vector();
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Plco_plano_contas_orcamentoTGWT plco_plano_contas_orcamentoTGWT = new Plco_plano_contas_orcamentoTGWT();
                Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                plco_plano_contas_orcamentoTGWT.setPlco_nr_id(plco_nr_id);

                Integer plco_nr_nivel = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_nivel").toString()));
                plco_plano_contas_orcamentoTGWT.setPlco_nr_nivel(plco_nr_nivel);

                String plco_tx_nome = EasyContainer.clearAspas(registro.get("plco_tx_nome").toString());
                plco_plano_contas_orcamentoTGWT.setPlco_tx_nome(plco_tx_nome);

                String plco_tx_tipo = EasyContainer.clearAspas(registro.get("plco_tx_tipo").toString());
                plco_plano_contas_orcamentoTGWT.setPlco_tx_tipo(plco_tx_tipo);

                String plco_tx_cod_externo = EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString());
                plco_plano_contas_orcamentoTGWT.setPlco_tx_cod_externo(plco_tx_cod_externo);

                String plco_tx_unidade = EasyContainer.clearAspas(registro.get("plco_tx_unidade").toString());
                plco_plano_contas_orcamentoTGWT.setPlco_tx_unidade(plco_tx_unidade);
                
                String plco_bl_equivalencia = EasyContainer.clearAspas(registro.get("plco_bl_equivalencia").toString());
                plco_plano_contas_orcamentoTGWT.setPlco_bl_equivalencia(plco_bl_equivalencia);

                list.add(plco_plano_contas_orcamentoTGWT);
            }

            ColumnModel cm = new ColumnModel(configs);

            PagingModelMemoryProxy memoryProxy = new PagingModelMemoryProxy(list);
            PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(memoryProxy);
            store =  new ListStore<Plco_plano_contas_orcamentoTGWT>(loader);
            store.add(list);
            loader.load(0, 100);

            getToolBarPage().setPageSize(100);
            getToolBarPage().bind(loader);
            loader.load(0, 100);
            Grid<Plco_plano_contas_orcamentoTGWT> grid = new Grid<Plco_plano_contas_orcamentoTGWT>(getStore(),cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Plco_plano_contas_orcamentoTGWT>>() {

                public void handleEvent(GridEvent<Plco_plano_contas_orcamentoTGWT> be) {
                    Plco_plano_contas_orcamentoUpdateDeleteGWT updateDeleteGWT = new Plco_plano_contas_orcamentoUpdateDeleteGWT();
                    updateDeleteGWT.setConsultGWT(consultGWT);
                    updateDeleteGWT.load(be.getModel());
                    updateDeleteGWT.show();
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
        Plco_plano_contas_orcamentoInsertGWT insert;
        try {
            insert = new Plco_plano_contas_orcamentoInsertGWT();
            insert.setConsultGWT(consultGWT);
            insert.setModal(true);
            insert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        cont = 1;
        valido = true;
    }

    public void load() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(consultGWT);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultNivel");
            param.put("mdo", "true");
            param.put("nivel", "" + 5);
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the store
     */
    public ListStore<Plco_plano_contas_orcamentoTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Plco_plano_contas_orcamentoTGWT> store) {
        this.store = store;
    }
}

