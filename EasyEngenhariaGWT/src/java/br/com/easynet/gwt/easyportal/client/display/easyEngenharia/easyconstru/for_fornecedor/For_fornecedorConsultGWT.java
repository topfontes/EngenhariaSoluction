/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.for_fornecedor;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
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
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;

import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.SwallowEvent;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.CheckBoxListView;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geoleite
 */
public class For_fornecedorConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/for_fornecedor/for_fornecedorConsultGWT.jsp";
    public static final String PAGE_DELETE = "easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDeleteGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final For_fornecedorConsultGWT consultGWT = this;
    private boolean remove = false;
    private ListStore<For_fornecedorTGWT> store;
    private For_fornecedorTGWT for_fornecRemove;
    private Grid<For_fornecedorTGWT> grid;
    private TextField<String> tx_loc = new TextField<String>();
    private Button btnLoc = new Button("Filtrar");
    //private Loader<For_fornecedorTGWT> loader = new Loader<For_fornecedorTGWT>();
    private Button btnexcluir = new Button("Remover duplicidade", ICONS.delete());

    private CheckBoxListView<For_fornecedorTGWT> listView = new CheckBoxListView<For_fornecedorTGWT>();

    public For_fornecedorConsultGWT() {
        try {

            btnexcluir.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    montarTeleExclusao();
                }

            });

            this.setHeading("Fornecedores");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<For_fornecedorTGWT>> numberRenderer = new NumberCellRenderer<Grid<For_fornecedorTGWT>>(currency);
            ColumnConfig column = null;
            column = new ColumnConfig();
            column.setId("for_nr_id");
            column.setHeader("Código");
            column.setWidth(50);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setHidden(true);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("for_tx_nome");
            column.setHeader("Nome");
            column.setWidth(300);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("for_tx_cnpj");
            column.setHeader("CNPJ/CPF");
            column.setWidth(120);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<For_fornecedorTGWT> btnDel = new GridCellRenderer<For_fornecedorTGWT>() {

                private boolean init;

                public Object render(final For_fornecedorTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<For_fornecedorTGWT> store, Grid<For_fornecedorTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<For_fornecedorTGWT>>() {

                            public void handleEvent(GridEvent<For_fornecedorTGWT> be) {
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
                                remove = true;
                                for_fornecRemove = model;
                                EasyAccessURL eaurl = new EasyAccessURL(consultGWT);
                                HashMap<String, String> param = new HashMap<String, String>();
                                param.put("op", "delete");
                                param.put("for_fornecedorT.for_nr_id", model.getFor_nr_id() + "");
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
            btnLoc.setIcon(ICONS.filter());
            btnLoc.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    load();
                }
            });

            KeyListener kl = new KeyListener() {

                @Override
                public void componentKeyPress(ComponentEvent event) {
                    if (event.getKeyCode() == 13) {
                        load();
                    }
                }

            };
            tx_loc.addKeyListener(kl);

            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(tx_loc);
            tx_loc.setAllowBlank(false);
            tx_loc.setEmptyText("parte do nome");
            getToolBarMaster().add(btnLoc);
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(btnexcluir);
            this.layout();
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
    }

    @Override
    protected void onShow() {
        super.onShow();
        this.load();
    }

    @Override
    protected void onHide() {
        super.onHide();
        getCpMaster().removeAll();
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            if (remove & for_fornecRemove != null) {
                if (jsonValue.toString().indexOf("sucesso") > -1) {
                    //Window.alert("delete");
                    getStore().remove(for_fornecRemove);
                    getStore().commitChanges();
                    for_fornecRemove = null;
                    remove = false;
                }
            } else {

                List<For_fornecedorTGWT> list = new Vector();
                for (int i = 1; i < resultado.size(); i++) {
                    For_fornecedorTGWT for_fornecedorTGWT = new For_fornecedorTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer for_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("for_nr_id").toString()));
                    for_fornecedorTGWT.setFor_nr_id(for_nr_id);

                    String for_tx_nome = EasyContainer.clearAspas(registro.get("for_tx_nome").toString());
                    for_fornecedorTGWT.setFor_tx_nome(for_tx_nome);

                    String for_tx_cnpj = EasyContainer.clearAspas(registro.get("for_tx_cnpj").toString());
                    for_fornecedorTGWT.setFor_tx_cnpj(for_tx_cnpj);

                    String for_tx_endereco = EasyContainer.clearAspas(registro.get("for_tx_endereco").toString());
                    for_fornecedorTGWT.setFor_tx_endereco(for_tx_endereco);

                    String for_tx_bairro = EasyContainer.clearAspas(registro.get("for_tx_bairro").toString());
                    for_fornecedorTGWT.setFor_tx_bairro(for_tx_bairro);

                    String for_tx_cidade = EasyContainer.clearAspas(registro.get("for_tx_cidade").toString());
                    for_fornecedorTGWT.setFor_tx_cidade(for_tx_cidade);

                    String for_tx_uf = EasyContainer.clearAspas(registro.get("for_tx_uf").toString());
                    for_fornecedorTGWT.setFor_tx_uf(for_tx_uf);

                    String for_tx_contato = EasyContainer.clearAspas(registro.get("for_tx_contato").toString());
                    for_fornecedorTGWT.setFor_tx_contato(for_tx_contato);

                    String for_tx_telefone = EasyContainer.clearAspas(registro.get("for_tx_telefone").toString());
                    for_fornecedorTGWT.setFor_tx_telefone(for_tx_telefone);

                    String for_tx_email = EasyContainer.clearAspas(registro.get("for_tx_email").toString());
                    for_fornecedorTGWT.setFor_tx_email(for_tx_email);
                    list.add(for_fornecedorTGWT);
                }

                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list);
                PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
                loader.setRemoteSort(true);

                getToolBarPage().setPageSize(30);
                getToolBarPage().bind(loader);
                loader.load(0, 30);

                getToolBarPage().setActivePage(1);
                store = new ListStore<For_fornecedorTGWT>(loader);
                store.add(list);

                ColumnModel cm = new ColumnModel(configs);

                grid = new Grid<For_fornecedorTGWT>(getStore(), cm);
                grid.setLoadMask(true);

                grid.setStyleAttribute("borderTop", "none");

                grid.setBorders(true);

                grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<For_fornecedorTGWT>>() {
                    public void handleEvent(GridEvent<For_fornecedorTGWT> be) {
                        For_fornecedorUpdateDeleteGWT for_fornecedorUpdateDeleteGWT = new For_fornecedorUpdateDeleteGWT();
                        for_fornecedorUpdateDeleteGWT.load(be.getModel());
                        for_fornecedorUpdateDeleteGWT.setConsultGWT(consultGWT);
                        for_fornecedorUpdateDeleteGWT.show();
                    }
                });

                getCpMaster().removeAll();
                getCpMaster().add(grid);

                layout();

                //doLayout();
            }
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        For_fornecedorInsertGWT insert;
        try {
            insert = new For_fornecedorInsertGWT();
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
            if (!tx_loc.getValue().isEmpty()) {
                param.put("for_fornecedorT.for_tx_nome", tx_loc.getValue());
            }
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
            List list = getCpMaster().getItems();
            if (list.size() > 0) {
                getCpMaster().removeAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void montarTeleExclusao() {
        final com.extjs.gxt.ui.client.widget.Window window = new com.extjs.gxt.ui.client.widget.Window();
        window.setHeading("Remover duplicidade");
        window.setModal(true);
        window.setSize(400, 500);
        window.setLayout(new FillLayout());
        window.add(listView);
        if (listView.getStore() != null) {
            listView.getStore().removeAll();
        }
        listView.setStore(grid.getStore());
        listView.setDisplayProperty("for_tx_nome");
        Button button = new Button("Confirma!", ICONS.remover());
        window.addButton(button);
        button.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                IListenetResponse response = new IListenetResponse() {
                    public void read(JSONValue jsonValue) {
                        if (jsonValue.toString().indexOf("sucesso") != -1) {
                            Info.display("Resultado", "Sucesso!");
                        } else {
                            MessageBox.alert("IMPORTANTE", "Erro ao execultar a operação", null);
                        }
                        window.setVisible(false);
                    }
                };
                EasyAccessURL accessURL;
                try {
                    accessURL = new EasyAccessURL(response);
                    HashMap<String, String> param = new HashMap<String, String>();
                    param.put("op", "deleteAll");
                    param.put("ids", getIdsCheckbox());
                    //param.put("debug", "true");
                    //Window.alert(Constantes.URL +PAGE_DELETE+"?"+ param);
                    accessURL.accessJSonMap(Constantes.URL +PAGE_DELETE, param);
                } catch (Exception ex) {
                    Logger.getLogger(For_fornecedorConsultGWT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        window.show();;
        layout();

    }

    public String getIdsCheckbox() {
        String ids = "-1";
        for (For_fornecedorTGWT for_fornecedorTGWT : listView.getChecked()) {
            ids += "," + for_fornecedorTGWT.getFor_nr_id();
        }
        return ids;
    }

    /**
     * @return the store
     */
    public ListStore<For_fornecedorTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<For_fornecedorTGWT> store) {
        this.store = store;
    }
}
