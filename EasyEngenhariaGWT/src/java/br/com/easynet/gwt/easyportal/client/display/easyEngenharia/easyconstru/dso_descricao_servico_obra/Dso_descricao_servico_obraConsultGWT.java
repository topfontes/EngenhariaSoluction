/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.dso_descricao_servico_obra;

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
public class Dso_descricao_servico_obraConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Dso_descricao_servico_obraConsultGWT consultGWT = this;

    
    public Dso_descricao_servico_obraConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Dso_descricao_servico_obraTGWT>> numberRenderer = new NumberCellRenderer<Grid<Dso_descricao_servico_obraTGWT>>(currency);
         

            ColumnConfig column = null;

	    column = new ColumnConfig();
            column.setId("plco_nr_id");
            column.setHeader("Plco_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("dso_tx_codigo_externo");
            column.setHeader("Dso_tx_codigo_externo");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("dso_tx_descriaco");
            column.setHeader("Dso_tx_descriaco");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("dso_nr_id");
            column.setHeader("Dso_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);


            GridCellRenderer<Dso_descricao_servico_obraTGWT> btnEdit = new GridCellRenderer<Dso_descricao_servico_obraTGWT>() {

                private boolean init;

                public Object render(final Dso_descricao_servico_obraTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Dso_descricao_servico_obraTGWT> store, Grid<Dso_descricao_servico_obraTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Dso_descricao_servico_obraTGWT>>() {

                            public void handleEvent(GridEvent<Dso_descricao_servico_obraTGWT> be) {
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

				Dso_descricao_servico_obraUpdateDeleteGWT dso_descricao_servico_obraUpdateDeleteGWT = new Dso_descricao_servico_obraUpdateDeleteGWT();
				dso_descricao_servico_obraUpdateDeleteGWT.load(model);
				dso_descricao_servico_obraUpdateDeleteGWT.setConsultGWT(consultGWT);
				dso_descricao_servico_obraUpdateDeleteGWT.show();

                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };
            
            GridCellRenderer<Dso_descricao_servico_obraTGWT> btnDel = new GridCellRenderer<Dso_descricao_servico_obraTGWT>() {

                private boolean init;

                public Object render(final Dso_descricao_servico_obraTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Dso_descricao_servico_obraTGWT> store, Grid<Dso_descricao_servico_obraTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Dso_descricao_servico_obraTGWT>>() {

                            public void handleEvent(GridEvent<Dso_descricao_servico_obraTGWT> be) {
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
                                param.put("Dso_descricao_servico_obraTGWT.id", model.getDso_nr_id() + "");
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
            
            ListStore<Dso_descricao_servico_obraTGWT> store = new ListStore<Dso_descricao_servico_obraTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Dso_descricao_servico_obraTGWT dso_descricao_servico_obraTGWT = new Dso_descricao_servico_obraTGWT();
                JSONObject registro = resultado.get(i).isObject();
	                        Integer plco_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                dso_descricao_servico_obraTGWT.setPlco_nr_id(plco_nr_id);

                String dso_tx_codigo_externo=EasyContainer.clearAspas(registro.get("dso_tx_codigo_externo").toString());
                dso_descricao_servico_obraTGWT.setDso_tx_codigo_externo(dso_tx_codigo_externo);

                String dso_tx_descriaco=EasyContainer.clearAspas(registro.get("dso_tx_descriaco").toString());
                dso_descricao_servico_obraTGWT.setDso_tx_descriaco(dso_tx_descriaco);

                Integer dso_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("dso_nr_id").toString()));
                dso_descricao_servico_obraTGWT.setDso_nr_id(dso_nr_id);


                store.add(dso_descricao_servico_obraTGWT);
            }

            
            ColumnModel cm = new ColumnModel(configs);

            Grid<Dso_descricao_servico_obraTGWT> grid = new Grid<Dso_descricao_servico_obraTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Dso_descricao_servico_obraConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
	    doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Dso_descricao_servico_obraInsertGWT insert;
        try {
            insert = new Dso_descricao_servico_obraInsertGWT();
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

