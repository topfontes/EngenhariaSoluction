/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_importacao_orcamento;

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
public class Vw_importacao_orcamentoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Vw_importacao_orcamentoConsultGWT consultGWT = this;

    
    public Vw_importacao_orcamentoConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Vw_importacao_orcamentoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_importacao_orcamentoTGWT>>(currency);
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
            column.setId("plco_tx_nome");
            column.setHeader("Plco_tx_nome");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("plco_tx_tipo");
            column.setHeader("Plco_tx_tipo");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("plco_tx_unidade");
            column.setHeader("Plco_tx_unidade");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("ipo_nr_quantidade");
            column.setHeader("Ipo_nr_quantidade");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("ipo_nr_vl_unitario");
            column.setHeader("Ipo_nr_vl_unitario");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("ipo_nr_vl_total");
            column.setHeader("Ipo_nr_vl_total");
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
            column.setId("ipo_plc_nr_id_servico");
            column.setHeader("Ipo_plc_nr_id_servico");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("plco_tx_cod_externo");
            column.setHeader("Plco_tx_cod_externo");
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
            column.setId("plco_nr_nivel");
            column.setHeader("Plco_nr_nivel");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);





            GridCellRenderer<Vw_importacao_orcamentoTGWT> btnEdit = new GridCellRenderer<Vw_importacao_orcamentoTGWT>() {

                private boolean init;

                public Object render(final Vw_importacao_orcamentoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Vw_importacao_orcamentoTGWT> store, Grid<Vw_importacao_orcamentoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_importacao_orcamentoTGWT>>() {

                            public void handleEvent(GridEvent<Vw_importacao_orcamentoTGWT> be) {
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

				Vw_importacao_orcamentoUpdateDeleteGWT vw_importacao_orcamentoUpdateDeleteGWT = new Vw_importacao_orcamentoUpdateDeleteGWT();
				vw_importacao_orcamentoUpdateDeleteGWT.load(model);
				vw_importacao_orcamentoUpdateDeleteGWT.setConsultGWT(consultGWT);
				vw_importacao_orcamentoUpdateDeleteGWT.show();

                        }
                    });
                    btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                    btnCol.setToolTip("Alterar");
                    btnCol.setIcon(ICONS.edit());
                    btnCol.setBorders(false);

                    return btnCol;
                }
            };
            
            GridCellRenderer<Vw_importacao_orcamentoTGWT> btnDel = new GridCellRenderer<Vw_importacao_orcamentoTGWT>() {

                private boolean init;

                public Object render(final Vw_importacao_orcamentoTGWT model, String property, ColumnData config, final int rowIndex,
                        final int colIndex, ListStore<Vw_importacao_orcamentoTGWT> store, Grid<Vw_importacao_orcamentoTGWT> grid) {
                    if (!init) {
                        init = true;
                        grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_importacao_orcamentoTGWT>>() {

                            public void handleEvent(GridEvent<Vw_importacao_orcamentoTGWT> be) {
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
                                param.put("Vw_importacao_orcamentoTGWT.id", model.getPlco_nr_id() + "");
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
            
            ListStore<Vw_importacao_orcamentoTGWT> store = new ListStore<Vw_importacao_orcamentoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Vw_importacao_orcamentoTGWT vw_importacao_orcamentoTGWT = new Vw_importacao_orcamentoTGWT();
                JSONObject registro = resultado.get(i).isObject();
	                        String plco_tx_nome=EasyContainer.clearAspas(registro.get("plco_tx_nome").toString());
                vw_importacao_orcamentoTGWT.setPlco_tx_nome(plco_tx_nome);

                String plco_tx_tipo=EasyContainer.clearAspas(registro.get("plco_tx_tipo").toString());
                vw_importacao_orcamentoTGWT.setPlco_tx_tipo(plco_tx_tipo);

                String plco_tx_unidade=EasyContainer.clearAspas(registro.get("plco_tx_unidade").toString());
                vw_importacao_orcamentoTGWT.setPlco_tx_unidade(plco_tx_unidade);

                float ipo_nr_quantidade=Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_quantidade").toString()));
                vw_importacao_orcamentoTGWT.setIpo_nr_quantidade(ipo_nr_quantidade);

                float ipo_nr_vl_unitario=Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_unitario").toString()));
                vw_importacao_orcamentoTGWT.setIpo_nr_vl_unitario(ipo_nr_vl_unitario);

                float ipo_nr_vl_total=Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_total").toString()));
                vw_importacao_orcamentoTGWT.setIpo_nr_vl_total(ipo_nr_vl_total);

                Integer plco_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                vw_importacao_orcamentoTGWT.setPlco_nr_id(plco_nr_id);

                Integer ipo_plc_nr_id_servico=Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_plc_nr_id_servico").toString()));
                vw_importacao_orcamentoTGWT.setIpo_plc_nr_id_servico(ipo_plc_nr_id_servico);

                String plco_tx_cod_externo=EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString());
                vw_importacao_orcamentoTGWT.setPlco_tx_cod_externo(plco_tx_cod_externo);

                Integer obr_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                vw_importacao_orcamentoTGWT.setObr_nr_id(obr_nr_id);

                Integer plco_nr_nivel=Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_nivel").toString()));
                vw_importacao_orcamentoTGWT.setPlco_nr_nivel(plco_nr_nivel);

                store.add(vw_importacao_orcamentoTGWT);
            }

            
            ColumnModel cm = new ColumnModel(configs);

            Grid<Vw_importacao_orcamentoTGWT> grid = new Grid<Vw_importacao_orcamentoTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Vw_importacao_orcamentoConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
	    doLayout();
        }
    }

//    @Override
    public void btnNovoAction(ToolBarEvent be) {
        Vw_importacao_orcamentoInsertGWT insert;
        try {
            insert = new Vw_importacao_orcamentoInsertGWT();
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

