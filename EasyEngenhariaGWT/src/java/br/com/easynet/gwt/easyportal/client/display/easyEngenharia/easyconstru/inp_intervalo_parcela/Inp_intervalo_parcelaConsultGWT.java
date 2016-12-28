/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inp_intervalo_parcela;

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
public class Inp_intervalo_parcelaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Inp_intervalo_parcelaConsultGWT consultGWT = this;

    
    public Inp_intervalo_parcelaConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Inp_intervalo_parcelaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Inp_intervalo_parcelaTGWT>>(currency);
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
            column.setId("inp_nr_id");
            column.setHeader("Inp_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("par_nr_id");
            column.setHeader("Par_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("inp_nr_dias");
            column.setHeader("Inp_nr_dias");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("inp_nr_per");
            column.setHeader("Inp_nr_per");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);





            GridCellRenderer<Inp_intervalo_parcelaTGWT> btnEdit = new GridCellRenderer<Inp_intervalo_parcelaTGWT>() {

                private boolean init;

                public Object render(final Inp_intervalo_parcelaTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Inp_intervalo_parcelaTGWT> store, Grid<Inp_intervalo_parcelaTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Inp_intervalo_parcelaTGWT>>() {

                            public void handleEvent(GridEvent<Inp_intervalo_parcelaTGWT> be) {
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

				Inp_intervalo_parcelaUpdateDeleteGWT inp_intervalo_parcelaUpdateDeleteGWT = new Inp_intervalo_parcelaUpdateDeleteGWT();
				inp_intervalo_parcelaUpdateDeleteGWT.load(model);
				inp_intervalo_parcelaUpdateDeleteGWT.setConsultGWT(consultGWT);
				inp_intervalo_parcelaUpdateDeleteGWT.show();

                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };
            
            GridCellRenderer<Inp_intervalo_parcelaTGWT> btnDel = new GridCellRenderer<Inp_intervalo_parcelaTGWT>() {

                private boolean init;

                public Object render(final Inp_intervalo_parcelaTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Inp_intervalo_parcelaTGWT> store, Grid<Inp_intervalo_parcelaTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Inp_intervalo_parcelaTGWT>>() {

                            public void handleEvent(GridEvent<Inp_intervalo_parcelaTGWT> be) {
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
                                param.put("Inp_intervalo_parcelaTGWT.id", model.getInp_nr_id() + "");
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
            
            ListStore<Inp_intervalo_parcelaTGWT> store = new ListStore<Inp_intervalo_parcelaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Inp_intervalo_parcelaTGWT inp_intervalo_parcelaTGWT = new Inp_intervalo_parcelaTGWT();
                JSONObject registro = resultado.get(i).isObject();
	                        Integer inp_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("inp_nr_id").toString()));
                inp_intervalo_parcelaTGWT.setInp_nr_id(inp_nr_id);

                Integer par_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("par_nr_id").toString()));
                inp_intervalo_parcelaTGWT.setPar_nr_id(par_nr_id);

                Integer inp_nr_dias=Integer.parseInt(EasyContainer.clearAspas(registro.get("inp_nr_dias").toString()));
                inp_intervalo_parcelaTGWT.setInp_nr_dias(inp_nr_dias);

                float inp_nr_per=Float.parseFloat(EasyContainer.clearAspas(registro.get("inp_nr_per").toString()));
                inp_intervalo_parcelaTGWT.setInp_nr_per(inp_nr_per);


                store.add(inp_intervalo_parcelaTGWT);
            }

            
            ColumnModel cm = new ColumnModel(configs);

            Grid<Inp_intervalo_parcelaTGWT> grid = new Grid<Inp_intervalo_parcelaTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Inp_intervalo_parcelaConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
	    doLayout();
        }
    }

//    @Override
    public void btnNovoAction(ToolBarEvent be) {
        Inp_intervalo_parcelaInsertGWT insert;
        try {
            insert = new Inp_intervalo_parcelaInsertGWT();
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
            eaurl.accessJSon(Constantes.URL + PAGE);//"portalgwt/exemplos/gridexemplo.jsp");
            List list = getCpMaster().getItems();
                getCpMaster().removeAll();
    } catch (Exception e) {
        e.printStackTrace();
    }

}
}

