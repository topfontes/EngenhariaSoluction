/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras;

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
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uno_unidade_obra.Uno_unidade_obraUpdateDeleteGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.ModelData;
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
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;

import com.extjs.gxt.ui.client.event.GridEvent;

import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import java.util.AbstractList;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class Obr_obrasConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/obr_obras/obr_obrasConsultGWT.jsp";
    public static final String PAGE_COMP_OBRA = "easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Obr_obrasConsultGWT consultGWT = this;
    private FormBinding binding;

    public Obr_obrasConsultGWT() {
        try {
            this.setHeading("Obras");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(false);
            getDataEAST().setSize(270);

            getCpRight().setHeading("Composição da Obra");
            getDataWEST().setHidden(true);
            this.setSize("1050", "500");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Obr_obrasTGWT>> numberRenderer = new NumberCellRenderer<Grid<Obr_obrasTGWT>>(currency);

            GridCellRenderer<Obr_obrasTGWT> change = new GridCellRenderer<Obr_obrasTGWT>() {

                public Object render(Obr_obrasTGWT model, String property, ColumnData config,
                        int rowIndex, int colIndex, ListStore<Obr_obrasTGWT> store, Grid<Obr_obrasTGWT> grid) {

                    return null;
                }
            };
            /*
            GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
            public String render(Stock model, String property, ColumnData config, int rowIndex,
            int colIndex, ListStore<Stock> store) {
            return numberRenderer.render(null, property, model.get(property));
            }
            };
             */



            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("obr_nr_id");
            column.setHeader("Codigo");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setHidden(true);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("obr_tx_nome");
            column.setHeader("Obra");
            column.setWidth(200);
            column.setStyle("produto");
            //~CellEditor cellEditor = new CellEditor(null);

            //column.setEditor(cellEditor);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("obr_nr_area_privativa_total");
            column.setHeader("Area Priv.");
            column.setWidth(40);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("obr_nr_area_construida_total");
            column.setHeader("Area Con.");
            column.setWidth(40);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("obr_dt_inicio");
            column.setHeader("Inicio Obra");
            column.setWidth(42);
            column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("obr_dt_fim");
            column.setHeader("Fim Obra");
            column.setWidth(42);
            column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("obr_dt_inicio_controle");
            column.setHeader("Inicio Const.");
            column.setWidth(42);
            column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("obr_dt_termino_controle");
            column.setHeader("Termino Const.");
            column.setWidth(42);
            column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("emp_tx_nome");
            column.setHeader("Empreendimento");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            GridCellRenderer<Obr_obrasTGWT> btnDel = new GridCellRenderer<Obr_obrasTGWT>() {

                private boolean init;

                public Object render(final Obr_obrasTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Obr_obrasTGWT> store, Grid<Obr_obrasTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Obr_obrasTGWT>>() {

                            public void handleEvent(GridEvent<Obr_obrasTGWT> be) {
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
                                param.put("obr_obrasT.obr_nr_id", model.getObr_nr_id() + "");
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

            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();
            //Window.alert(resultado.toString());
            GroupingStore<Obr_obrasTGWT> store = new GroupingStore<Obr_obrasTGWT>();
            store.groupBy("emp_tx_nome");
            List<Obr_obrasTGWT> listObr = new ArrayList<Obr_obrasTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Obr_obrasTGWT obr_obrasTGWT = new Obr_obrasTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                obr_obrasTGWT.setObr_nr_id(obr_nr_id);

                String obr_tx_nome = EasyContainer.clearAspas(registro.get("obr_tx_nome").toString());
                obr_obrasTGWT.setObr_tx_nome(obr_tx_nome);

                Integer emp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("emp_nr_id").toString()));
                obr_obrasTGWT.setEmp_nr_id(emp_nr_id);

                float obr_nr_area_construida_total = Float.parseFloat(EasyContainer.clearAspas(registro.get("obr_nr_area_construida_total").toString()));
                obr_obrasTGWT.setObr_nr_area_construida_total(obr_nr_area_construida_total);

                float obr_nr_area_privativa_total = Float.parseFloat(EasyContainer.clearAspas(registro.get("obr_nr_area_privativa_total").toString()));
                obr_obrasTGWT.setObr_nr_area_privativa_total(obr_nr_area_privativa_total);

                DateTimeFormat dtf8 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date obr_dt_inicio = dtf8.parse(EasyContainer.clearAspas(registro.get("obr_dt_inicio").toString()));
                obr_obrasTGWT.setObr_dt_inicio(obr_dt_inicio);

                DateTimeFormat dtf9 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date obr_dt_fim = dtf9.parse(EasyContainer.clearAspas(registro.get("obr_dt_fim").toString()));
                obr_obrasTGWT.setObr_dt_fim(obr_dt_fim);

                DateTimeFormat dtf10 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date obr_dt_inicio_controle = dtf10.parse(EasyContainer.clearAspas(registro.get("obr_dt_inicio_controle").toString()));
                obr_obrasTGWT.setObr_dt_inicio_controle(obr_dt_inicio_controle);

                DateTimeFormat dtf11 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date obr_dt_termino_controle = dtf11.parse(EasyContainer.clearAspas(registro.get("obr_dt_termino_controle").toString()));
                obr_obrasTGWT.setObr_dt_termino_controle(obr_dt_termino_controle);

                if (EasyContainer.clearAspas(registro.get("obr_dt_inicio_real").toString()).length() > 0) {
                    DateTimeFormat dtf12 = DateTimeFormat.getFormat("dd/MM/yyyy");
                    Date obr_dt_inicio_real = dtf12.parse(EasyContainer.clearAspas(registro.get("obr_dt_inicio_real").toString()));
                    obr_obrasTGWT.setObr_dt_inicio_real(obr_dt_inicio_real);
                    DateTimeFormat dtf13 = DateTimeFormat.getFormat("dd/MM/yyyy");
                    Date obr_dt_final_real = dtf13.parse(EasyContainer.clearAspas(registro.get("obr_dt_final_real").toString()));
                    obr_obrasTGWT.setObr_dt_final_real(obr_dt_final_real);
                }

                String emp_tx_nome = EasyContainer.clearAspas(registro.get("emp_tx_nome").toString());
                obr_obrasTGWT.setEmp_tx_nome(emp_tx_nome);

                String mdoDireta = EasyContainer.clearAspas(registro.get("obr_nr_id_plc_mdo_direta").toString());
                if (mdoDireta.trim().length() > 0) {
                    obr_obrasTGWT.setObr_nr_id_plc_mdo_direta(Integer.parseInt(mdoDireta));
                }

                String mdoIndireta = EasyContainer.clearAspas(registro.get("obr_nr_id_plc_mdo_indireta").toString());
                if (mdoIndireta.trim().length() > 0) {
                    obr_obrasTGWT.setObr_nr_id_plc_mdo_indireta(Integer.parseInt(mdoIndireta));
                }

                String percDireta = EasyContainer.clearAspas(registro.get("obr_nr_percent_mdo_direta").toString());
                if (percDireta.trim().length() > 0) {
                    obr_obrasTGWT.setObr_nr_percent_mdo_direta(Float.parseFloat(percDireta));
                }

                String percIndireta = EasyContainer.clearAspas(registro.get("obr_nr_percent_mdo_indireta").toString());
                if (percIndireta.trim().length() > 0) {
                    obr_obrasTGWT.setObr_nr_percent_mdo_indireta(Float.parseFloat(percIndireta));
                }

                String obr_nr_valor_permutado = EasyContainer.clearAspas(registro.get("obr_nr_valor_permutado").toString());
                if (obr_nr_valor_permutado.trim().length() > 0) {
                    obr_obrasTGWT.setObr_nr_valor_permutado(Float.parseFloat(obr_nr_valor_permutado));
                }

                String obr_nr_valor_vgv = EasyContainer.clearAspas(registro.get("obr_nr_valor_vgv").toString());
                if (obr_nr_valor_vgv.trim().length() > 0) {
                    obr_obrasTGWT.setObr_nr_valor_vgv(Float.parseFloat(obr_nr_valor_vgv));
                }

                String obr_nr_encarcos_juros_aplicacao = EasyContainer.clearAspas(registro.get("obr_nr_encarcos_juros_aplicacao").toString());
                if (obr_nr_encarcos_juros_aplicacao.trim().length() > 0) {
                    obr_obrasTGWT.setObr_nr_encarcos_juros_aplicacao(Float.parseFloat(obr_nr_encarcos_juros_aplicacao));
                }

                listObr.add(obr_obrasTGWT);

            }

            store.add(listObr);
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

            Grid<Obr_obrasTGWT> grid = new Grid<Obr_obrasTGWT>(store, cm);
            grid.setView(view);
            grid.setLoadMask(true);
            grid.setStyleAttribute("borderTop", "none");

            grid.setBorders(true);


            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Obr_obrasTGWT>>() {

                public void handleEvent(GridEvent<Obr_obrasTGWT> be) {
                    Obr_obrasUpdateDeleteGWT obra = new Obr_obrasUpdateDeleteGWT(be.getModel());
                    obra.load(be.getModel());
                    obra.setConsultGWT(consultGWT);
                    obra.show();
                }
            });

            grid.getSelectionModel().addListener(Events.SelectionChange,
                    new Listener<SelectionChangedEvent<Obr_obrasTGWT>>() {

                        public void handleEvent(SelectionChangedEvent<Obr_obrasTGWT> be) {
                            if (be.getSelection().size() > 0) {
                                povoaComposicao(be.getSelection().get(0).getObr_nr_id());
                            }
                        }
                    });

            grid.setStripeRows(true);
            getCpMaster().removeAll();
            getCpMaster().add(grid);
            this.layout();
            doLayout();

            povoaComposicao(999999);

        }
    }

    public void povoaComposicao(int obr_nr_id) {
        try {
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("uno_unidade_obraT.obr_nr_id", obr_nr_id + "");
            Resposta resposta = new Resposta();
            EasyAccessURL eaurl = new EasyAccessURL(resposta);
            eaurl.accessJSonMapNoProgress(Constantes.URL + PAGE_COMP_OBRA, param);
            layout();
            doLayout();


        } catch (Exception e) {
        }

    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Obr_obrasInsertGWT insert;


        try {
            insert = new Obr_obrasInsertGWT();
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


            if (list.size() > 0) {
                getCpMaster().removeAll();


            }
        } catch (Exception e) {
            e.printStackTrace();






        }

    }

    public class Resposta implements IListenetResponse {

        public List<ColumnConfig> getColumn() {
            List<ColumnConfig> listcolCcs = new Vector<ColumnConfig>();

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("uni_tx_nome");
            column.setHeader("Unidade Construtiva");
            column.setWidth(130);
            column.setAlignment(HorizontalAlignment.LEFT);
            listcolCcs.add(column);

            column = new ColumnConfig();
            column.setId("uno_nr_quantidade");
            column.setHeader("Qtde.");
            column.setWidth(60);
            column.setAlignment(HorizontalAlignment.LEFT);
            listcolCcs.add(column);

            column = new ColumnConfig();
            column.setId("uno_nr_area_construida");
            column.setHeader("A. Constru.");
            column.setWidth(70);
            column.setAlignment(HorizontalAlignment.LEFT);
            listcolCcs.add(column);
            return listcolCcs;

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

                ListStore<Uno_unidade_obraTGWT> storeCObra = new ListStore<Uno_unidade_obraTGWT>();
                storeCObra.add(listUno);
                final ColumnModel cm = new ColumnModel(getColumn());
                Grid<Uno_unidade_obraTGWT> grid = new Grid<Uno_unidade_obraTGWT>(storeCObra, cm);
                grid.setLoadMask(true);
                grid.setStyleAttribute("borderTop", "none");
                grid.setBorders(true);
                grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                getCpRight().removeAll();
                grid.setStripeRows(true);
                getCpRight().add(grid);
                consultGWT.layout();
                consultGWT.doLayout();
            }
        }
    }
}
