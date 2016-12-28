/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pes_pessoa;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.event.ButtonEvent;
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
 * @author geoleitejjjjjjjjjjjjjjjjjjjjjjjjjjjj
 */
public class Pes_pessoaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pes_pessoa/pes_pessoaConsultGWT.jsp";    

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Pes_pessoaConsultGWT consultGWT = this;

    
    public Pes_pessoaConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Pes_pessoaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Pes_pessoaTGWT>>(currency);
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
            column.setId("pes_nr_id");
            column.setHeader("Pes_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("pes_tx_nome");
            column.setHeader("Pes_tx_nome");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("pes_tx_fone");
            column.setHeader("Pes_tx_fone");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
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
            
            ListStore<Pes_pessoaTGWT> store = new ListStore<Pes_pessoaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
Pes_pessoaTGWT pes_pessoaTGWT = new Pes_pessoaTGWT();
                JSONObject registro = resultado.get(i).isObject();
	                        Integer pes_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("pes_nr_id").toString()));
                pes_pessoaTGWT.setPes_nr_id(pes_nr_id);

                String pes_tx_nome=EasyContainer.clearAspas(registro.get("pes_tx_nome").toString());
                pes_pessoaTGWT.setPes_tx_nome(pes_tx_nome);

                String pes_tx_fone=EasyContainer.clearAspas(registro.get("pes_tx_fone").toString());
                pes_pessoaTGWT.setPes_tx_fone(pes_tx_fone);


                store.add(pes_pessoaTGWT);
            }

            
            ColumnModel cm = new ColumnModel(configs);

            Grid<Pes_pessoaTGWT> grid = new Grid<Pes_pessoaTGWT>(store, cm);
            grid.setLoadMask(true);  

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

	    //final Pes_pessoaConsultGWT consultGWT = this;	

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().removeAll();
            getCpMaster().add(grid);
            this.layout();
	    doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Pes_pessoaInsertGWT insert;
        try {
            insert = new Pes_pessoaInsertGWT();
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

