/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pms_planilha_medicao_servico;

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
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import java.util.HashMap;
/**
 *
 * @author geoleite
 */
public class Pms_planilha_medicao_servicoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Pms_planilha_medicao_servicoConsultGWT consultGWT = this;

    
    public Pms_planilha_medicao_servicoConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Pms_planilha_medicao_servicoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Pms_planilha_medicao_servicoTGWT>>(currency);


            

            ColumnConfig column = null;

	    column = new ColumnConfig();
            column.setId("pms_nr_id");
            column.setHeader("Pms_nr_id");
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
            column.setId("pms_nr_mes");
            column.setHeader("Pms_nr_mes");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("plco_nr_id");
            column.setHeader("Plco_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("pms_nr_quantidade_servico");
            column.setHeader("Pms_nr_quantidade_servico");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);


           GridCellRenderer<Pms_planilha_medicao_servicoTGWT> btnEdit = new GridCellRenderer<Pms_planilha_medicao_servicoTGWT>() {

                private boolean init;

                public Object render(final Pms_planilha_medicao_servicoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Pms_planilha_medicao_servicoTGWT> store, Grid<Pms_planilha_medicao_servicoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Pms_planilha_medicao_servicoTGWT>>() {

                            public void handleEvent(GridEvent<Pms_planilha_medicao_servicoTGWT> be) {
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

				Pms_planilha_medicao_servicoUpdateDeleteGWT pms_planilha_medicao_servicoUpdateDeleteGWT = new Pms_planilha_medicao_servicoUpdateDeleteGWT();
				pms_planilha_medicao_servicoUpdateDeleteGWT.load(model);
				pms_planilha_medicao_servicoUpdateDeleteGWT.setConsultGWT(consultGWT);
				pms_planilha_medicao_servicoUpdateDeleteGWT.show();

                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };
            
            GridCellRenderer<Pms_planilha_medicao_servicoTGWT> btnDel = new GridCellRenderer<Pms_planilha_medicao_servicoTGWT>() {

                private boolean init;

                public Object render(final Pms_planilha_medicao_servicoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Pms_planilha_medicao_servicoTGWT> store, Grid<Pms_planilha_medicao_servicoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Pms_planilha_medicao_servicoTGWT>>() {

                            public void handleEvent(GridEvent<Pms_planilha_medicao_servicoTGWT> be) {
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
                                param.put("Pms_planilha_medicao_servicoTGWT.id", model.getPms_nr_id() + "");
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
            
            ListStore<Pms_planilha_medicao_servicoTGWT> store = new ListStore<Pms_planilha_medicao_servicoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Pms_planilha_medicao_servicoTGWT pms_planilha_medicao_servicoTGWT = new Pms_planilha_medicao_servicoTGWT();
                JSONObject registro = resultado.get(i).isObject();
	                        Integer pms_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("pms_nr_id").toString()));
                pms_planilha_medicao_servicoTGWT.setPms_nr_id(pms_nr_id);

                Integer obr_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                pms_planilha_medicao_servicoTGWT.setObr_nr_id(obr_nr_id);

                Integer pms_nr_mes=Integer.parseInt(EasyContainer.clearAspas(registro.get("pms_nr_mes").toString()));
                pms_planilha_medicao_servicoTGWT.setPms_nr_mes(pms_nr_mes);

                Integer plco_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                pms_planilha_medicao_servicoTGWT.setPlco_nr_id(plco_nr_id);

                float pms_nr_quantidade_servico=Float.parseFloat(EasyContainer.clearAspas(registro.get("pms_nr_quantidade_servico").toString()));
                pms_planilha_medicao_servicoTGWT.setPms_nr_quantidade_servico(pms_nr_quantidade_servico);


                store.add(pms_planilha_medicao_servicoTGWT);
            }

            
            ColumnModel cm = new ColumnModel(configs);

            Grid<Pms_planilha_medicao_servicoTGWT> grid = new Grid<Pms_planilha_medicao_servicoTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Pms_planilha_medicao_servicoConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
	    doLayout();
        }
    }

//    @Override
    public void btnNovoAction(ToolBarEvent be) {
        Pms_planilha_medicao_servicoInsertGWT insert;
        try {
            insert = new Pms_planilha_medicao_servicoInsertGWT();
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

