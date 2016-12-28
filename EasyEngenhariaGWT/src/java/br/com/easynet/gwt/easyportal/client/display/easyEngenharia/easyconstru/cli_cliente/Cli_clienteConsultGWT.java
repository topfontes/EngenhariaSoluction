/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cli_cliente;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.extjs.gxt.ui.client.store.Store;

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
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Cli_clienteConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/cli_cliente/cli_clienteConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Cli_clienteConsultGWT consultGWT = this;
    private ToolBar toolBar = new ButtonBar();
    private StoreFilterField<Cli_clienteTGWT> storeFiltro;

    public Cli_clienteConsultGWT() {
        try {
            this.setHeading("Clientes");
            getDataNORTH().setSize(20);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Cli_clienteTGWT>> numberRenderer = new NumberCellRenderer<Grid<Cli_clienteTGWT>>(currency);

            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new LabelToolItem("Nome:"));
            getToolBarMaster().add(new SeparatorToolItem());

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("cli_nr_id");
            column.setHeader("Codigo");
            column.setWidth(50);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("cli_tx_nome");
            column.setHeader("Nome");
            column.setWidth(300);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("cli_tx_cnpj_cpf");
            column.setHeader("CNPJ/CPF");
            column.setWidth(130);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Cli_clienteTGWT> btnDel = new GridCellRenderer<Cli_clienteTGWT>() {

                private boolean init;

                public Object render(final Cli_clienteTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Cli_clienteTGWT> store, Grid<Cli_clienteTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Cli_clienteTGWT>>() {

                            public void handleEvent(GridEvent<Cli_clienteTGWT> be) {
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
                                param.put("cli_clienteT.cli_nr_id", model.getCli_nr_id() + "");
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
            //Window.alert(ex.getMessage());
        }
    }

    public StoreFilterField<Cli_clienteTGWT> getStoreFilter() {
        StoreFilterField<Cli_clienteTGWT> storef;
        if (storeFiltro != null) {
            storef = storeFiltro;
        } else {
            storef = new StoreFilterField<Cli_clienteTGWT>() {
                @Override
                protected boolean doSelect(Store<Cli_clienteTGWT> store, Cli_clienteTGWT parent, Cli_clienteTGWT record, String property, String filter) {
                    String name = record.get("cli_tx_nome");
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

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Cli_clienteTGWT> store = new ListStore<Cli_clienteTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Cli_clienteTGWT cli_clienteTGWT = new Cli_clienteTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
                cli_clienteTGWT.setCli_nr_id(cli_nr_id);

                String cli_tx_nome = EasyContainer.clearAspas(registro.get("cli_tx_nome").toString());
                cli_clienteTGWT.setCli_tx_nome(cli_tx_nome);

                String cli_tx_tipo_pessoa = EasyContainer.clearAspas(registro.get("cli_tx_tipo_pessoa").toString());
                cli_clienteTGWT.setCli_tx_tipo_pessoa(cli_tx_tipo_pessoa);

                String cli_tx_cnpj_cpf = EasyContainer.clearAspas(registro.get("cli_tx_cnpj_cpf").toString());
                cli_clienteTGWT.setCli_tx_cnpj_cpf(cli_tx_cnpj_cpf);

                String cli_tx_endereco = EasyContainer.clearAspas(registro.get("cli_tx_endereco").toString());
                cli_clienteTGWT.setCli_tx_endereco(cli_tx_endereco);

                String cli_tx_bairro = EasyContainer.clearAspas(registro.get("cli_tx_bairro").toString());
                cli_clienteTGWT.setCli_tx_bairro(cli_tx_bairro);

                String cli_tx_cidade = EasyContainer.clearAspas(registro.get("cli_tx_cidade").toString());
                cli_clienteTGWT.setCli_tx_cidade(cli_tx_cidade);

                String cli_tx_telefone = EasyContainer.clearAspas(registro.get("cli_tx_telefone").toString());
                cli_clienteTGWT.setCli_tx_telefone(cli_tx_telefone);

                String cli_tx_fax = EasyContainer.clearAspas(registro.get("cli_tx_fax").toString());
                cli_clienteTGWT.setCli_tx_fax(cli_tx_fax);

                String cli_tx_telefone2 = EasyContainer.clearAspas(registro.get("cli_tx_telefone2").toString());
                cli_clienteTGWT.setCli_tx_telefone2(cli_tx_telefone2);

                String cli_tx_email = EasyContainer.clearAspas(registro.get("cli_tx_email").toString());
                cli_clienteTGWT.setCli_tx_email(cli_tx_email);

                String cli_tx_inscricao = EasyContainer.clearAspas(registro.get("cli_tx_inscricao_estatual").toString());
                cli_clienteTGWT.setCli_tx_inscricao_estatual(cli_tx_inscricao);

                String cli_tx_contato = EasyContainer.clearAspas(registro.get("cli_tx_contato").toString());
                cli_clienteTGWT.setCli_tx_contato(cli_tx_contato);

                String cli_tx_celular = EasyContainer.clearAspas(registro.get("cli_tx_celular").toString());
                cli_clienteTGWT.setcli_tx_celular(cli_tx_celular);

                String cli_tx_letra = EasyContainer.clearAspas(registro.get("cli_tx_letra_orcamento_externo").toString());
                cli_clienteTGWT.setCli_tx_letra_orcamento_externo(cli_tx_letra);
                
                store.add(cli_clienteTGWT);
            }

            storeFiltro = getStoreFilter();
            storeFiltro.setWidth(200);
            storeFiltro.bind(store);
            getToolBarMaster().add(storeFiltro);
            storeFiltro.setEmptyText("Localização pelo nome do cliente");
            //toolBar.add(storefilter);
            ColumnModel cm = new ColumnModel(configs);

            Grid<Cli_clienteTGWT> grid = new Grid<Cli_clienteTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Cli_clienteTGWT>>() {

                public void handleEvent(GridEvent<Cli_clienteTGWT> be) {
                    Cli_clienteUpdateDeleteGWT cli_clienteUpdateDeleteGWT = new Cli_clienteUpdateDeleteGWT(be.getModel().getCli_nr_id());
                    cli_clienteUpdateDeleteGWT.load(be.getModel());
                    cli_clienteUpdateDeleteGWT.setConsultGWT(consultGWT);
                    cli_clienteUpdateDeleteGWT.show();
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
        Cli_clienteInsertGWT insert;
        try {
            insert = new Cli_clienteInsertGWT();
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

