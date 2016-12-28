/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.infe_item_nota_entrada;

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
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
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

/**
 *
 * @author geoleite
 */
public class Infe_item_nota_entradaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Infe_item_nota_entradaConsultGWT consultGWT = this;

    
    public Infe_item_nota_entradaConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Infe_item_nota_entradaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Infe_item_nota_entradaTGWT>>(currency);
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
            column.setId("infe_nr_id");
            column.setHeader("Infe_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("infe_nr_quantidade");
            column.setHeader("Infe_nr_quantidade");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("infe_nr_valor_unit");
            column.setHeader("Infe_nr_valor_unit");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("infe_nr_valor_total");
            column.setHeader("Infe_nr_valor_total");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("nfe_nr_id");
            column.setHeader("Nfe_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("pro_nr_id");
            column.setHeader("Pro_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);



            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSon(Constantes.URL + PAGE);//"portalgwt/exemplos/gridexemplo.jsp");
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
            
            ListStore<Infe_item_nota_entradaTGWT> store = new ListStore<Infe_item_nota_entradaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Infe_item_nota_entradaTGWT infe_item_nota_entradaTGWT = new Infe_item_nota_entradaTGWT();
                JSONObject registro = resultado.get(i).isObject();
	        Integer infe_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("infe_nr_id").toString()));
                infe_item_nota_entradaTGWT.setInfe_nr_id(infe_nr_id);

                float infe_nr_quantidade=Float.parseFloat(EasyContainer.clearAspas(registro.get("infe_nr_quantidade").toString()));
                infe_item_nota_entradaTGWT.setInfe_nr_quantidade(infe_nr_quantidade);

                float infe_nr_valor_unit=Float.parseFloat(EasyContainer.clearAspas(registro.get("infe_nr_valor_unit").toString()));
                infe_item_nota_entradaTGWT.setInfe_nr_valor_unit(infe_nr_valor_unit);

                float infe_nr_valor_total=Float.parseFloat(EasyContainer.clearAspas(registro.get("infe_nr_valor_total").toString()));
                infe_item_nota_entradaTGWT.setInfe_nr_valor_total(infe_nr_valor_total);

                Integer nfe_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("nfe_nr_id").toString()));
                infe_item_nota_entradaTGWT.setNfe_nr_id(nfe_nr_id);

                Integer pro_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_id").toString()));
                infe_item_nota_entradaTGWT.setPro_nr_id(pro_nr_id);


                store.add(infe_item_nota_entradaTGWT);
            }

            
            ColumnModel cm = new ColumnModel(configs);

            Grid<Infe_item_nota_entradaTGWT> grid = new Grid<Infe_item_nota_entradaTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Infe_item_nota_entradaConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.getSelectionModel().addListener(Events.SelectionChange,
                    new Listener<SelectionChangedEvent>() {

                        public void handleEvent(SelectionChangedEvent be) {
                            //Window.alert(" selecionando " + be.getSelection);
                            if (be.getSelection().size() > 0) {
                                Infe_item_nota_entradaTGWT infe_item_nota_entradaTGWT = (Infe_item_nota_entradaTGWT) be.getSelection().get(0);
				Infe_item_nota_entradaUpdateDeleteGWT infe_item_nota_entradaUpdateDeleteGWT = new Infe_item_nota_entradaUpdateDeleteGWT();

				infe_item_nota_entradaUpdateDeleteGWT.load(infe_item_nota_entradaTGWT);
				infe_item_nota_entradaUpdateDeleteGWT.setConsultGWT(consultGWT);
				infe_item_nota_entradaUpdateDeleteGWT.show();

                            }
                        }
                    });

            getCpMaster().add(grid);
            this.layout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Infe_item_nota_entradaInsertGWT insert;
        try {
            insert = new Infe_item_nota_entradaInsertGWT();
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
            if (list.size() > 0) {
                getCpMaster().removeAll();
            }
    } catch (Exception e) {
        e.printStackTrace();
    }

}
}

