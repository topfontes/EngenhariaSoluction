/*
 * EasyNet JDragon
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eplc_equivalencia_plano_contas;

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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;

/**
 *
 * @author geoleite
 */
public class Eplc_equivalencia_plano_contasConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Eplc_equivalencia_plano_contasConsultGWT consultGWT = this;

    public Eplc_equivalencia_plano_contasConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Eplc_equivalencia_plano_contasTGWT>> numberRenderer = new NumberCellRenderer<Grid<Eplc_equivalencia_plano_contasTGWT>>(currency);
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
            column.setId("eplc_nr_id");
            column.setHeader("Eplc_nr_id");
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
            column.setId("plco_nr_id");
            column.setHeader("Plco_nr_id");
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

            ListStore<Eplc_equivalencia_plano_contasTGWT> store = new ListStore<Eplc_equivalencia_plano_contasTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Eplc_equivalencia_plano_contasTGWT eplc_equivalencia_plano_contasTGWT = new Eplc_equivalencia_plano_contasTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer eplc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("eplc_nr_id").toString()));
                eplc_equivalencia_plano_contasTGWT.setEplc_nr_id(eplc_nr_id);

                Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                eplc_equivalencia_plano_contasTGWT.setPlc_nr_id(plc_nr_id);

                Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                eplc_equivalencia_plano_contasTGWT.setPlco_nr_id(plco_nr_id);


                store.add(eplc_equivalencia_plano_contasTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Eplc_equivalencia_plano_contasTGWT> grid = new Grid<Eplc_equivalencia_plano_contasTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

            //final Eplc_equivalencia_plano_contasConsultGWT consultGWT = this;

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Eplc_equivalencia_plano_contasInsertGWT insert;
        try {
            insert = new Eplc_equivalencia_plano_contasInsertGWT();
            insert.setConsultGWT(consultGWT);
            insert.setModal(true);
            insert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSon(Constantes.URL + PAGE);//"portalgwt/exemplos/gridexemplo.jsp");
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

