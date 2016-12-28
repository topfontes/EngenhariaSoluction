/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.nfe_nota_fiscal_entrada;

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
public class Nfe_nota_fiscal_entradaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Nfe_nota_fiscal_entradaConsultGWT consultGWT = this;

    
    public Nfe_nota_fiscal_entradaConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Nfe_nota_fiscal_entradaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Nfe_nota_fiscal_entradaTGWT>>(currency);
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
            column.setId("nfe_nr_id");
            column.setHeader("Nfe_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("nfe_dt_emissao");
            column.setHeader("Nfe_dt_emissao");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("for_nr_id");
            column.setHeader("For_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("nfe_nr_valor_nota");
            column.setHeader("Nfe_nr_valor_nota");
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
            
            ListStore<Nfe_nota_fiscal_entradaTGWT> store = new ListStore<Nfe_nota_fiscal_entradaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Nfe_nota_fiscal_entradaTGWT nfe_nota_fiscal_entradaTGWT = new Nfe_nota_fiscal_entradaTGWT();
                JSONObject registro = resultado.get(i).isObject();
	                        Integer nfe_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("nfe_nr_id").toString()));
                nfe_nota_fiscal_entradaTGWT.setNfe_nr_id(nfe_nr_id);

                DateTimeFormat dtf1 = DateTimeFormat.getFormat("dd/MM/yyyy");
Date nfe_dt_emissao=dtf1.parse(EasyContainer.clearAspas(registro.get("nfe_dt_emissao").toString()));
                nfe_nota_fiscal_entradaTGWT.setNfe_dt_emissao(nfe_dt_emissao);

                Integer for_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("for_nr_id").toString()));
                nfe_nota_fiscal_entradaTGWT.setFor_nr_id(for_nr_id);

                float nfe_nr_valor_nota=Float.parseFloat(EasyContainer.clearAspas(registro.get("nfe_nr_valor_nota").toString()));
                nfe_nota_fiscal_entradaTGWT.setNfe_nr_valor_nota(nfe_nr_valor_nota);


                store.add(nfe_nota_fiscal_entradaTGWT);
            }

            
            ColumnModel cm = new ColumnModel(configs);

            Grid<Nfe_nota_fiscal_entradaTGWT> grid = new Grid<Nfe_nota_fiscal_entradaTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Nfe_nota_fiscal_entradaConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Nfe_nota_fiscal_entradaInsertGWT insert;
        try {
            insert = new Nfe_nota_fiscal_entradaInsertGWT();
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

