/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fat_fator;

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
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.scfp_subclasse_operario_previsto.Scfp_subclasse_operario_previstoConsultGWT;
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
public class Fat_fatorConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fat_fator/fat_fatorConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Fat_fatorConsultGWT consultGWT = this;

    
    public Fat_fatorConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Fat_fatorTGWT>> numberRenderer = new NumberCellRenderer<Grid<Fat_fatorTGWT>>(currency);
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
            column.setId("fat_nr_id");
            column.setHeader("Fat_nr_id");
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
            column.setId("fat_nr_fator_atual");
            column.setHeader("Fat_nr_fator_atual");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("fat_nr_fator_projetado");
            column.setHeader("Fat_nr_fator_projetado");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("fat_nr_mes");
            column.setHeader("Fat_nr_mes");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("fat_nr_ano");
            column.setHeader("Fat_nr_ano");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("obr_nr_id");
            column.setHeader("Obr_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);





            GridCellRenderer<Fat_fatorTGWT> btnEdit = new GridCellRenderer<Fat_fatorTGWT>() {

                private boolean init;

                public Object render(final Fat_fatorTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Fat_fatorTGWT> store, Grid<Fat_fatorTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Fat_fatorTGWT>>() {

                            public void handleEvent(GridEvent<Fat_fatorTGWT> be) {
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

				Fat_fatorUpdateDeleteGWT fat_fatorUpdateDeleteGWT = new Fat_fatorUpdateDeleteGWT();
				fat_fatorUpdateDeleteGWT.load(model);
				fat_fatorUpdateDeleteGWT.setConsultGWT(consultGWT);
				fat_fatorUpdateDeleteGWT.show();

                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };
            
            GridCellRenderer<Fat_fatorTGWT> btnDel = new GridCellRenderer<Fat_fatorTGWT>() {

                private boolean init;

                public Object render(final Fat_fatorTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Fat_fatorTGWT> store, Grid<Fat_fatorTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Fat_fatorTGWT>>() {

                            public void handleEvent(GridEvent<Fat_fatorTGWT> be) {
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
                                param.put("Fat_fatorTGWT.id", model.getFat_nr_id() + "");
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
            
            ListStore<Fat_fatorTGWT> store = new ListStore<Fat_fatorTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Fat_fatorTGWT fat_fatorTGWT = new Fat_fatorTGWT();
                JSONObject registro = resultado.get(i).isObject();
	                        Integer fat_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("fat_nr_id").toString()));
                fat_fatorTGWT.setFat_nr_id(fat_nr_id);

                Integer plc_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                fat_fatorTGWT.setPlc_nr_id(plc_nr_id);

                float fat_nr_fator_atual=Float.parseFloat(EasyContainer.clearAspas(registro.get("fat_nr_fator_atual").toString()));
                fat_fatorTGWT.setFat_nr_fator_atual(fat_nr_fator_atual);

                float fat_nr_fator_projetado=Float.parseFloat(EasyContainer.clearAspas(registro.get("fat_nr_fator_projetado").toString()));
                fat_fatorTGWT.setFat_nr_fator_projetado(fat_nr_fator_projetado);

                Integer fat_nr_mes=Integer.parseInt(EasyContainer.clearAspas(registro.get("fat_nr_mes").toString()));
                fat_fatorTGWT.setFat_nr_mes(fat_nr_mes);

                Integer fat_nr_ano=Integer.parseInt(EasyContainer.clearAspas(registro.get("fat_nr_ano").toString()));
                fat_fatorTGWT.setFat_nr_ano(fat_nr_ano);

                Integer obr_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                fat_fatorTGWT.setObr_nr_id(obr_nr_id);


                store.add(fat_fatorTGWT);
            }

            
            ColumnModel cm = new ColumnModel(configs);

            Grid<Fat_fatorTGWT> grid = new Grid<Fat_fatorTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Fat_fatorConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
	    doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Fat_fatorInsertGWT insert;
        try {
            insert = new Fat_fatorInsertGWT();
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

