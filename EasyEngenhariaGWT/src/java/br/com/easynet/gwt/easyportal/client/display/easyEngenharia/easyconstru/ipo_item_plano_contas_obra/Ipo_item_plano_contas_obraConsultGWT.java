/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ipo_item_plano_contas_obra;

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
public class Ipo_item_plano_contas_obraConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Ipo_item_plano_contas_obraConsultGWT consultGWT = this;

    public Ipo_item_plano_contas_obraConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Ipo_item_plano_contas_obraTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ipo_item_plano_contas_obraTGWT>>(currency);
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
            column.setId("ipo_nr_id");
            column.setHeader("Ipo_nr_id");
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
            column.setId("obr_nr_id");
            column.setHeader("Obr_nr_id");
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

            ListStore<Ipo_item_plano_contas_obraTGWT> store = new ListStore<Ipo_item_plano_contas_obraTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Ipo_item_plano_contas_obraTGWT ipo_item_plano_contas_obraTGWT = new Ipo_item_plano_contas_obraTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer ipo_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_nr_id").toString()));
                ipo_item_plano_contas_obraTGWT.setIpo_nr_id(ipo_nr_id);

                float ipo_nr_quantidade = Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_quantidade").toString()));
                ipo_item_plano_contas_obraTGWT.setIpo_nr_quantidade(ipo_nr_quantidade);

                float ipo_nr_vl_unitario = Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_unitario").toString()));
                ipo_item_plano_contas_obraTGWT.setIpo_nr_vl_unitario(ipo_nr_vl_unitario);

                float ipo_nr_vl_total = Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_total").toString()));
                ipo_item_plano_contas_obraTGWT.setIpo_nr_vl_total(ipo_nr_vl_total);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                ipo_item_plano_contas_obraTGWT.setObr_nr_id(obr_nr_id);

                Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                ipo_item_plano_contas_obraTGWT.setPlco_nr_id(plco_nr_id);


                store.add(ipo_item_plano_contas_obraTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Ipo_item_plano_contas_obraTGWT> grid = new Grid<Ipo_item_plano_contas_obraTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

            //final Ipo_item_plano_contas_obraConsultGWT consultGWT = this;

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Ipo_item_plano_contas_obraInsertGWT insert;
        try {
            insert = new Ipo_item_plano_contas_obraInsertGWT();
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

