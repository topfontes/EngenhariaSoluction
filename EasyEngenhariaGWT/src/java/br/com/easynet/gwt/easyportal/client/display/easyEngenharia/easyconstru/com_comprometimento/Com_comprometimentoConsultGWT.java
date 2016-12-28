/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.com_comprometimento;

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
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import java.util.HashMap;
/**
 *
 * @author geoleite
 */
public class Com_comprometimentoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Com_comprometimentoConsultGWT consultGWT = this;

    
    public Com_comprometimentoConsultGWT() {
        try {
            this.setHeading("Comprometimentos");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Com_comprometimentoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Com_comprometimentoTGWT>>(currency);
            /*
            GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
            public String render(Stock model, String property, ColumnData config, int rowIndex,
            int colIndex, ListStore<Stock> store) {
            double val = (Double) model.get(property);
            String style = val < 0 ? "red" : "green";
            return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
            }
            };
            GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
            public String render(Stock model, String property, ColumnData config, int rowIndex,
            int colIndex, ListStore<Stock> store) {
            return numberRenderer.render(null, property, model.get(property));
            }
            };
             */

            

            ColumnConfig column = null;

	    column = new ColumnConfig();
            column.setId("com_nr_id");
            column.setHeader("Com_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("plc_nr_id");
            column.setHeader("Plc_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("com_nr_valor");
            column.setHeader("Com_nr_valor");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("obr_nr_id");
            column.setHeader("Obr_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("com_nr_mes");
            column.setHeader("Com_nr_mes");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("com_nr_ano");
            column.setHeader("Com_nr_ano");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);





            GridCellRenderer<Com_comprometimentoTGWT> btnEdit = new GridCellRenderer<Com_comprometimentoTGWT>() {

                private boolean init;

                public Object render(final Com_comprometimentoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Com_comprometimentoTGWT> store, Grid<Com_comprometimentoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Com_comprometimentoTGWT>>() {

                            public void handleEvent(GridEvent<Com_comprometimentoTGWT> be) {
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

				Com_comprometimentoUpdateDeleteGWT com_comprometimentoUpdateDeleteGWT = new Com_comprometimentoUpdateDeleteGWT();
				com_comprometimentoUpdateDeleteGWT.load(model);
				com_comprometimentoUpdateDeleteGWT.setConsultGWT(consultGWT);
				com_comprometimentoUpdateDeleteGWT.show();

                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };
            
            GridCellRenderer<Com_comprometimentoTGWT> btnDel = new GridCellRenderer<Com_comprometimentoTGWT>() {

                private boolean init;

                public Object render(final Com_comprometimentoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Com_comprometimentoTGWT> store, Grid<Com_comprometimentoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Com_comprometimentoTGWT>>() {

                            public void handleEvent(GridEvent<Com_comprometimentoTGWT> be) {
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
                                param.put("Com_comprometimentoTGWT.id", model.getCom_nr_id() + "");
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

     	    load();
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }

    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();
            
            ListStore<Com_comprometimentoTGWT> store = new ListStore<Com_comprometimentoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Com_comprometimentoTGWT com_comprometimentoTGWT = new Com_comprometimentoTGWT();
                JSONObject registro = resultado.get(i).isObject();
	                        Integer com_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("com_nr_id").toString()));
                com_comprometimentoTGWT.setCom_nr_id(com_nr_id);

                Integer plc_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                com_comprometimentoTGWT.setPlc_nr_id(plc_nr_id);

                float com_nr_valor=Float.parseFloat(EasyContainer.clearAspas(registro.get("com_nr_valor").toString()));
                com_comprometimentoTGWT.setCom_nr_valor(com_nr_valor);

                Integer obr_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                com_comprometimentoTGWT.setObr_nr_id(obr_nr_id);

                Integer com_nr_mes=Integer.parseInt(EasyContainer.clearAspas(registro.get("com_nr_mes").toString()));
                com_comprometimentoTGWT.setCom_nr_mes(com_nr_mes);

                Integer com_nr_ano=Integer.parseInt(EasyContainer.clearAspas(registro.get("com_nr_ano").toString()));
                com_comprometimentoTGWT.setCom_nr_ano(com_nr_ano);


                store.add(com_comprometimentoTGWT);
            }

            ColumnModel cm = new ColumnModel(configs);
            AggregationRowConfig<Vw_comprometimentoTGWT> aGtotal = new AggregationRowConfig<Vw_comprometimentoTGWT>();
            aGtotal.setSummaryFormat("com_nr_valor", NumberFormat.getFormat("#,##0.00"));
            aGtotal.setSummaryType("com_nr_valor",SummaryType.SUM);
            aGtotal.setHtml("com_nr_valor", "com_nr_valor");
            cm.addAggregationRow(aGtotal);

            Grid<Com_comprometimentoTGWT> grid = new Grid<Com_comprometimentoTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Com_comprometimentoConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
	    doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Com_comprometimentoInsertGWT insert;
        try {
            insert = new Com_comprometimentoInsertGWT();
            insert.setConsultGWT(consultGWT);
            insert.setModal(true);
            insert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

public void load(){
    try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
            List list = getCpMaster().getItems();
             getCpMaster().removeAll();
    } catch (Exception e) {
        e.printStackTrace();
    }

}
}

