/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctpm_conta_pagar_modificada;

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
public class Ctpm_conta_pagar_modificadaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Ctpm_conta_pagar_modificadaConsultGWT consultGWT = this;

    
    public Ctpm_conta_pagar_modificadaConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Ctpm_conta_pagar_modificadaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ctpm_conta_pagar_modificadaTGWT>>(currency);
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
            column.setId("ctpm_nr_id");
            column.setHeader("Ctpm_nr_id");
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
            column.setId("ctp_nr_id");
            column.setHeader("Ctp_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("ctpm_nr_mes");
            column.setHeader("Ctpm_nr_mes");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("ctpm_nr_ano");
            column.setHeader("Ctpm_nr_ano");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("ctpm_tx_tipo");
            column.setHeader("Ctpm_tx_tipo");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);





            GridCellRenderer<Ctpm_conta_pagar_modificadaTGWT> btnEdit = new GridCellRenderer<Ctpm_conta_pagar_modificadaTGWT>() {

                private boolean init;

                public Object render(final Ctpm_conta_pagar_modificadaTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Ctpm_conta_pagar_modificadaTGWT> store, Grid<Ctpm_conta_pagar_modificadaTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Ctpm_conta_pagar_modificadaTGWT>>() {

                            public void handleEvent(GridEvent<Ctpm_conta_pagar_modificadaTGWT> be) {
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

				Ctpm_conta_pagar_modificadaUpdateDeleteGWT ctpm_conta_pagar_modificadaUpdateDeleteGWT = new Ctpm_conta_pagar_modificadaUpdateDeleteGWT();
				ctpm_conta_pagar_modificadaUpdateDeleteGWT.load(model);
				ctpm_conta_pagar_modificadaUpdateDeleteGWT.setConsultGWT(consultGWT);
				ctpm_conta_pagar_modificadaUpdateDeleteGWT.show();

                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };
            
            GridCellRenderer<Ctpm_conta_pagar_modificadaTGWT> btnDel = new GridCellRenderer<Ctpm_conta_pagar_modificadaTGWT>() {

                private boolean init;

                public Object render(final Ctpm_conta_pagar_modificadaTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Ctpm_conta_pagar_modificadaTGWT> store, Grid<Ctpm_conta_pagar_modificadaTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Ctpm_conta_pagar_modificadaTGWT>>() {

                            public void handleEvent(GridEvent<Ctpm_conta_pagar_modificadaTGWT> be) {
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
                                param.put("Ctpm_conta_pagar_modificadaTGWT.id", model.getCtpm_nr_id() + "");
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
            
            ListStore<Ctpm_conta_pagar_modificadaTGWT> store = new ListStore<Ctpm_conta_pagar_modificadaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Ctpm_conta_pagar_modificadaTGWT ctpm_conta_pagar_modificadaTGWT = new Ctpm_conta_pagar_modificadaTGWT();
                JSONObject registro = resultado.get(i).isObject();
	                        Integer ctpm_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("ctpm_nr_id").toString()));
                ctpm_conta_pagar_modificadaTGWT.setCtpm_nr_id(ctpm_nr_id);

                Integer obr_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                ctpm_conta_pagar_modificadaTGWT.setObr_nr_id(obr_nr_id);

                Integer ctp_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_id").toString()));
                ctpm_conta_pagar_modificadaTGWT.setCtp_nr_id(ctp_nr_id);

                Integer ctpm_nr_mes=Integer.parseInt(EasyContainer.clearAspas(registro.get("ctpm_nr_mes").toString()));
                ctpm_conta_pagar_modificadaTGWT.setCtpm_nr_mes(ctpm_nr_mes);

                Integer ctpm_nr_ano=Integer.parseInt(EasyContainer.clearAspas(registro.get("ctpm_nr_ano").toString()));
                ctpm_conta_pagar_modificadaTGWT.setCtpm_nr_ano(ctpm_nr_ano);

                String ctpm_tx_tipo=EasyContainer.clearAspas(registro.get("ctpm_tx_tipo").toString());
                ctpm_conta_pagar_modificadaTGWT.setCtpm_tx_tipo(ctpm_tx_tipo);


                store.add(ctpm_conta_pagar_modificadaTGWT);
            }

            
            ColumnModel cm = new ColumnModel(configs);

            Grid<Ctpm_conta_pagar_modificadaTGWT> grid = new Grid<Ctpm_conta_pagar_modificadaTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Ctpm_conta_pagar_modificadaConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
	    doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Ctpm_conta_pagar_modificadaInsertGWT insert;
        try {
            insert = new Ctpm_conta_pagar_modificadaInsertGWT();
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

