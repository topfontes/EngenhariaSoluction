/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pro_produto;

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
public class Pro_produtoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pro_produto/pro_produtoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Pro_produtoConsultGWT consultGWT = this;

    public Pro_produtoConsultGWT() {
        try {
            this.setHeading("Consulta Produto");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("600", "300");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Pro_produtoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Pro_produtoTGWT>>(currency);


            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("pro_nr_id");
            column.setHeader("Código");
            column.setWidth(50);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_tx_nome");
            column.setHeader("Nome");
            column.setWidth(300);
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
           JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Pro_produtoTGWT> store = new ListStore<Pro_produtoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Pro_produtoTGWT pro_produtoTGWT = new Pro_produtoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer pro_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_id").toString()));
                pro_produtoTGWT.setPro_nr_id(pro_nr_id);
                String pro_tx_nome = EasyContainer.clearAspas(registro.get("pro_tx_nome").toString());
                pro_produtoTGWT.setPro_tx_nome(pro_tx_nome);
                Integer grp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("grp_nr_id").toString()));
                pro_produtoTGWT.setGrp_nr_id(grp_nr_id);
                store.add(pro_produtoTGWT);
            }

            ColumnModel cm = new ColumnModel(configs);
            Grid<Pro_produtoTGWT> grid = new Grid<Pro_produtoTGWT>(store, cm);
            grid.setLoadMask(true);
            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);
            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.getSelectionModel().addListener(Events.SelectionChange,
                    new Listener<SelectionChangedEvent>() {
                        public void handleEvent(SelectionChangedEvent be) {
                            if (be.getSelection().size() > 0) {
                                Pro_produtoTGWT pro_produtoTGWT = (Pro_produtoTGWT) be.getSelection().get(0);
                                Pro_produtoUpdateDeleteGWT pro_produtoUpdateDeleteGWT = new Pro_produtoUpdateDeleteGWT();
                                pro_produtoUpdateDeleteGWT.load(pro_produtoTGWT);
                                pro_produtoUpdateDeleteGWT.setConsultGWT(consultGWT);
                                pro_produtoUpdateDeleteGWT.show();
                            }
                        }
                    });
            getCpMaster().add(grid);
            this.layout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Pro_produtoInsertGWT insert;
        try {
            insert = new Pro_produtoInsertGWT();
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
            getCpMaster().removeAll();
            eaurl.accessJSon(Constantes.URL + PAGE);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

