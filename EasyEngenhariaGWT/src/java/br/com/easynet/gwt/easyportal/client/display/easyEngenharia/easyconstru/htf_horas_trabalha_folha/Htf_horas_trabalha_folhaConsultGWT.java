/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.htf_horas_trabalha_folha;

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
public class Htf_horas_trabalha_folhaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Htf_horas_trabalha_folhaConsultGWT consultGWT = this;

    
    public Htf_horas_trabalha_folhaConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Htf_horas_trabalha_folhaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Htf_horas_trabalha_folhaTGWT>>(currency);
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
            column.setId("htf_nr_id");
            column.setHeader("Htf_nr_id");
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
            column.setId("htf_nr_mes");
            column.setHeader("Htf_nr_mes");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("htf_nr_ano");
            column.setHeader("Htf_nr_ano");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("htf_nr_horas_trabalhada");
            column.setHeader("Htf_nr_horas_trabalhada");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);





            GridCellRenderer<Htf_horas_trabalha_folhaTGWT> btnEdit = new GridCellRenderer<Htf_horas_trabalha_folhaTGWT>() {

                private boolean init;

                public Object render(final Htf_horas_trabalha_folhaTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Htf_horas_trabalha_folhaTGWT> store, Grid<Htf_horas_trabalha_folhaTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Htf_horas_trabalha_folhaTGWT>>() {

                            public void handleEvent(GridEvent<Htf_horas_trabalha_folhaTGWT> be) {
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

				Htf_horas_trabalha_folhaUpdateDeleteGWT htf_horas_trabalha_folhaUpdateDeleteGWT = new Htf_horas_trabalha_folhaUpdateDeleteGWT();
				htf_horas_trabalha_folhaUpdateDeleteGWT.load(model);
				htf_horas_trabalha_folhaUpdateDeleteGWT.setConsultGWT(consultGWT);
				htf_horas_trabalha_folhaUpdateDeleteGWT.show();

                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };
            
            GridCellRenderer<Htf_horas_trabalha_folhaTGWT> btnDel = new GridCellRenderer<Htf_horas_trabalha_folhaTGWT>() {

                private boolean init;

                public Object render(final Htf_horas_trabalha_folhaTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Htf_horas_trabalha_folhaTGWT> store, Grid<Htf_horas_trabalha_folhaTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Htf_horas_trabalha_folhaTGWT>>() {

                            public void handleEvent(GridEvent<Htf_horas_trabalha_folhaTGWT> be) {
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
                                param.put("Htf_horas_trabalha_folhaTGWT.id", model.getHtf_nr_id() + "");
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
            
            ListStore<Htf_horas_trabalha_folhaTGWT> store = new ListStore<Htf_horas_trabalha_folhaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Htf_horas_trabalha_folhaTGWT htf_horas_trabalha_folhaTGWT = new Htf_horas_trabalha_folhaTGWT();
                JSONObject registro = resultado.get(i).isObject();
	                        Integer htf_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("htf_nr_id").toString()));
                htf_horas_trabalha_folhaTGWT.setHtf_nr_id(htf_nr_id);

                Integer obr_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                htf_horas_trabalha_folhaTGWT.setObr_nr_id(obr_nr_id);

                Integer htf_nr_mes=Integer.parseInt(EasyContainer.clearAspas(registro.get("htf_nr_mes").toString()));
                htf_horas_trabalha_folhaTGWT.setHtf_nr_mes(htf_nr_mes);

                Integer htf_nr_ano=Integer.parseInt(EasyContainer.clearAspas(registro.get("htf_nr_ano").toString()));
                htf_horas_trabalha_folhaTGWT.setHtf_nr_ano(htf_nr_ano);

                float htf_nr_horas_trabalhada=Float.parseFloat(EasyContainer.clearAspas(registro.get("htf_nr_horas_trabalhada").toString()));
                htf_horas_trabalha_folhaTGWT.setHtf_nr_horas_trabalhada(htf_nr_horas_trabalhada);


                store.add(htf_horas_trabalha_folhaTGWT);
            }

            
            ColumnModel cm = new ColumnModel(configs);

            Grid<Htf_horas_trabalha_folhaTGWT> grid = new Grid<Htf_horas_trabalha_folhaTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Htf_horas_trabalha_folhaConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
	    doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Htf_horas_trabalha_folhaInsertGWT insert;
        try {
            insert = new Htf_horas_trabalha_folhaInsertGWT();
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

