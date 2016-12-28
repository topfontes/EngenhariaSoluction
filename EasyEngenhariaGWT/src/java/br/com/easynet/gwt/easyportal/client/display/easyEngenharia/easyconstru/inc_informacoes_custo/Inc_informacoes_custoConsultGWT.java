/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inc_informacoes_custo;

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
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Inc_informacoes_custoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Inc_informacoes_custoConsultGWT consultGWT = this;
    private int obr_nr_id;
    private int plc;
    private int mes;
    private int ano;

    public Inc_informacoes_custoConsultGWT() {
        try {
            setModal(true);
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Inc_informacoes_custoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Inc_informacoes_custoTGWT>>(currency);

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("inc_tx_problemas");
            column.setHeader("Problemas");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("inc_tx_calsas");
            column.setHeader("Calsas");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("inc_tx_acoes");
            column.setHeader("Ações");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("inc_tx_responsavel");
            column.setHeader("Responsavel");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("inc_dt_prazo");
            column.setHeader("Prazo");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);
            GridCellRenderer<Inc_informacoes_custoTGWT> btnEdit = new GridCellRenderer<Inc_informacoes_custoTGWT>() {

                private boolean init;

                public Object render(final Inc_informacoes_custoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Inc_informacoes_custoTGWT> store, Grid<Inc_informacoes_custoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Inc_informacoes_custoTGWT>>() {

                            public void handleEvent(GridEvent<Inc_informacoes_custoTGWT> be) {
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
                            Inc_informacoes_custoUpdateDeleteGWT inc_informacoes_custoUpdateDeleteGWT = new Inc_informacoes_custoUpdateDeleteGWT();
                            inc_informacoes_custoUpdateDeleteGWT.load(model);
                            inc_informacoes_custoUpdateDeleteGWT.setConsultGWT(consultGWT);
                            inc_informacoes_custoUpdateDeleteGWT.show();

                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };

            GridCellRenderer<Inc_informacoes_custoTGWT> btnDel = new GridCellRenderer<Inc_informacoes_custoTGWT>() {

                private boolean init;

                public Object render(final Inc_informacoes_custoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Inc_informacoes_custoTGWT> store, Grid<Inc_informacoes_custoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Inc_informacoes_custoTGWT>>() {

                            public void handleEvent(GridEvent<Inc_informacoes_custoTGWT> be) {
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
                                param.put("Inc_informacoes_custoTGWT.id", model.getInc_nr_id() + "");
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
            column.setId("edit");
            column.setHeader("");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setRenderer(btnEdit);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("del");
            column.setHeader("");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setRenderer(btnDel);
            configs.add(column);

        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }

    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
//        Window.alert(jsonValue.toString());
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Inc_informacoes_custoTGWT> store = new ListStore<Inc_informacoes_custoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Inc_informacoes_custoTGWT inc_informacoes_custoTGWT = new Inc_informacoes_custoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer inc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("inc_nr_id").toString()));
                inc_informacoes_custoTGWT.setInc_nr_id(inc_nr_id);
                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                inc_informacoes_custoTGWT.setObr_nr_id(obr_nr_id);

                Integer inc_nes_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("inc_nr_mes").toString()));
                inc_informacoes_custoTGWT.setInc_nr_mes(inc_nes_nr_id);

                Integer inc_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("inc_nr_ano").toString()));
                inc_informacoes_custoTGWT.setInc_nr_ano(inc_nr_ano);

                Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                inc_informacoes_custoTGWT.setPlc_nr_id(plc_nr_id);

                float inc_tx_custo_acumulado = Float.parseFloat(EasyContainer.clearAspas(registro.get("inc_tx_custo_acumulado").toString()));
                inc_informacoes_custoTGWT.setInc_tx_custo_acumulado(inc_tx_custo_acumulado);

                float inc_nr_custo_periodo = Float.parseFloat(EasyContainer.clearAspas(registro.get("inc_nr_custo_periodo").toString()));
                inc_informacoes_custoTGWT.setInc_nr_custo_periodo(inc_nr_custo_periodo);

                String inc_tx_calsas = EasyContainer.clearAspas(registro.get("inc_tx_calsas").toString());
                inc_informacoes_custoTGWT.setInc_tx_calsas(inc_tx_calsas);

                String inc_tx_problemas = EasyContainer.clearAspas(registro.get("inc_tx_problemas").toString());
                inc_informacoes_custoTGWT.setInc_tx_problemas(inc_tx_problemas);

                String inc_tx_acoes = EasyContainer.clearAspas(registro.get("inc_tx_acoes").toString());
                inc_informacoes_custoTGWT.setInc_tx_acoes(inc_tx_acoes);

                String inc_tx_responsavel = EasyContainer.clearAspas(registro.get("inc_tx_responsavel").toString());
                inc_informacoes_custoTGWT.setInc_tx_responsavel(inc_tx_responsavel);

                DateTimeFormat dtf11 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date inc_dt_prazo=dtf11.parse(EasyContainer.clearAspas(registro.get("inc_dt_prazo").toString()));
                inc_informacoes_custoTGWT.setInc_dt_prazo(inc_dt_prazo);


                store.add(inc_informacoes_custoTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Inc_informacoes_custoTGWT> grid = new Grid<Inc_informacoes_custoTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

            //final Inc_informacoes_custoConsultGWT consultGWT = this;

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            getCpMaster().removeAll();
            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Inc_informacoes_custoInsertGWT insert;
        try {
            insert = new Inc_informacoes_custoInsertGWT();
            insert.inc_nes_nr_id.setValue(getMes() + "");
            insert.inc_nr_ano.setValue(getAno() + "");
            insert.obr_nr_id.setValue(getObr_nr_id() + "");
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
            param.put("inc_informacoes_custoT.obr_nr_id", getObr_nr_id() + "");
            param.put("inc_informacoes_custoT.plc_nr_id", getPlc() + "");
            param.put("inc_informacoes_custoT.inc_nr_mes", getMes() + "");
            param.put("inc_informacoes_custoT.inc_nr_ano", getAno() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE,param);//"portalgwt/exemplos/gridexemplo.jsp");
//            MessageBox.alert("",Constantes.URL + PAGE + param.toString(),null);
            //easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoConsultGWT.jsp?inc_informacoes_custoT.obr_nr_id=43&inc_informacoes_custoT.plc_nr_id=65&inc_informacoes_custoT.inc_nr_mes=3&inc_informacoes_custoT.inc_nr_ano=2011
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the obr_nr_id
     */
    public int getObr_nr_id() {
        return obr_nr_id;
    }

    /**
     * @param obr_nr_id the obr_nr_id to set
     */
    public void setObr_nr_id(int obr_nr_id) {
        this.obr_nr_id = obr_nr_id;
    }

    /**
     * @return the plc
     */
    public int getPlc() {
        return plc;
    }

    /**
     * @param plc the plc to set
     */
    public void setPlc(int plc) {
        this.plc = plc;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
}
