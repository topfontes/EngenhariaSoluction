/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.emp_empreendimento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.Portal2GWT;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.com_comprometimento.Com_comprometimentoUpdateDeleteGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import java.util.Date;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;


import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Emp_empreendimentoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Emp_empreendimentoConsultGWT consultGWT = this;

    public Emp_empreendimentoConsultGWT() {
        try {
            this.setHeading("Empreendimento");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Emp_empreendimentoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Emp_empreendimentoTGWT>>(currency);

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("emp_nr_id");
            column.setHeader("Codigo");
            column.setWidth(50);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setHidden(true);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("emp_tx_nome");
            column.setHeader("Nome");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("cliente");
            column.setHeader("Cliente");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Emp_empreendimentoTGWT> btnDel = new GridCellRenderer<Emp_empreendimentoTGWT>() {

                private boolean init;

                public Object render(final Emp_empreendimentoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Emp_empreendimentoTGWT> store, Grid<Emp_empreendimentoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Emp_empreendimentoTGWT>>() {

                            public void handleEvent(GridEvent<Emp_empreendimentoTGWT> be) {
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
                                HashMap<String, String> param = new HashMap<String, String>();
                                param.put("op", "delete");
                                param.put("emp_empreendimentoT.emp_nr_id", model.getEmp_nr_id() + "");
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
            List<Emp_empreendimentoTGWT> listEmpree = new ArrayList<Emp_empreendimentoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Emp_empreendimentoTGWT emp_empreendimentoTGWT = new Emp_empreendimentoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer emp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("emp_nr_id").toString()));
                emp_empreendimentoTGWT.setEmp_nr_id(emp_nr_id);

                String emp_tx_nome = EasyContainer.clearAspas(registro.get("emp_tx_nome").toString());
                emp_empreendimentoTGWT.setEmp_tx_nome(emp_tx_nome);

                String emp_tx_bairro = EasyContainer.clearAspas(registro.get("emp_tx_bairro").toString());
                emp_empreendimentoTGWT.setEmp_tx_bairro(emp_tx_bairro);

                String emp_tx_endereco = EasyContainer.clearAspas(registro.get("emp_tx_endereco").toString());
                emp_empreendimentoTGWT.setEmp_tx_endereco(emp_tx_endereco);

                String emp_tx_cidade = EasyContainer.clearAspas(registro.get("emp_tx_cidade").toString());
                emp_empreendimentoTGWT.setEmp_tx_cidade(emp_tx_cidade);

                String emp_tx_uf = EasyContainer.clearAspas(registro.get("emp_tx_uf").toString());
                emp_empreendimentoTGWT.setEmp_tx_uf(emp_tx_uf);

                Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
                emp_empreendimentoTGWT.setCli_nr_id(cli_nr_id);
                String cli_tx_nome = EasyContainer.clearAspas(registro.get("cli_tx_nome").toString());
                emp_empreendimentoTGWT.setCliente(cli_tx_nome);
                listEmpree.add(emp_empreendimentoTGWT);

                //store.add(emp_empreendimentoTGWT);
            }
            GroupingStore<Emp_empreendimentoTGWT> store = new GroupingStore<Emp_empreendimentoTGWT>();
            store.add(listEmpree);
            store.groupBy("cliente");
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

            Grid<Emp_empreendimentoTGWT> grid = new Grid<Emp_empreendimentoTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setView(view);
            grid.setLoadMask(true);
            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Emp_empreendimentoTGWT>>() {
                public void handleEvent(GridEvent<Emp_empreendimentoTGWT> be) {
                    Emp_empreendimentoUpdateDeleteGWT emp_empreendimentoUpdateDeleteGWT  = new Emp_empreendimentoUpdateDeleteGWT();
                    emp_empreendimentoUpdateDeleteGWT.load(be.getModel());
                    emp_empreendimentoUpdateDeleteGWT.setConsultGWT(consultGWT);
                    emp_empreendimentoUpdateDeleteGWT.show();
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
        Emp_empreendimentoInsertGWT insert;
        try {
            insert = new Emp_empreendimentoInsertGWT();
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

