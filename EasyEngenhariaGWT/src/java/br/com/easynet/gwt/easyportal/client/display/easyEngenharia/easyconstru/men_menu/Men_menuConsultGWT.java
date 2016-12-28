/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.men_menu;

import br.com.easynet.gwt.easyportal.client.BaseBorderLayoutGWT;
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
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.dnd.GridDragSource;
import com.extjs.gxt.ui.client.dnd.GridDropTarget;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.DNDEvent;
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

import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author geoleitejjjjjjjjjjjjjjjjjjjjjjjjjjjj
 */
public class Men_menuConsultGWT extends BaseBorderLayoutGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/mep_men_per/mep_men_perUpdateDeleteGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Men_menuConsultGWT consultGWT = this;
    private Per_perfilTGWT per_perfilTGWT = new Per_perfilTGWT();
    ListaMenuGWT listMenuVinc = new ListaMenuGWT();
    ListaMenuGWT listMenuNotVinc = new ListaMenuGWT();

    private GridDropTarget targetVinc;
    private GridDropTarget targetNotVinc;

    public Men_menuConsultGWT() {
        try {
            this.setSize(510, 250);
            getDataEAST().setSize(240);
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Men_menuTGWT>> numberRenderer = new NumberCellRenderer<Grid<Men_menuTGWT>>(currency);

        } catch (Exception ex) {
        }

    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.get("resultado").toString().indexOf("Falha") > 0) {
                //com.google.gwt.user.client.Window.alert(EasyContainer.clearAspas(jsonObject.get("resultado").toString()));
                load(per_perfilTGWT);
            }
        }
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listMenuNotVinc.preechido || !listMenuVinc.preechido) {
                    schedule(500);
                } else {
                    ListStore<Men_menuTGWT> storevinc = new ListStore<Men_menuTGWT>();
                    storevinc.add(listMenuVinc.getList());

                    ListStore<Men_menuTGWT> storenotvinc = new ListStore<Men_menuTGWT>();
                    storenotvinc.add(listMenuNotVinc.getList());

                    ColumnModel cmnotvinc = new ColumnModel(createConfig());

                    Grid<Men_menuTGWT> grid_notvinc = new Grid<Men_menuTGWT>(storenotvinc, cmnotvinc);
                    grid_notvinc.setLoadMask(true);
                    grid_notvinc.setAutoExpandMin(200);
                    grid_notvinc.setBorders(true);
                    grid_notvinc.setStripeRows(true);
                    getCpMaster().add(grid_notvinc);

                    final ColumnModel cmvinc = new ColumnModel(createConfig());
                    Grid<Men_menuTGWT> grid_vinc = new Grid<Men_menuTGWT>(storevinc, cmvinc);


                    grid_vinc.setLoadMask(true);
                    grid_vinc.setBorders(true);
                    grid_vinc.setStripeRows(true);
                    getCpRight().add(grid_vinc);

                    GridDragSource gridSourceVinc = new GridDragSource(grid_vinc);
                    GridDragSource gridSourceNotVinc = new GridDragSource(grid_notvinc);

                    GridDropTarget targetVinc = new GridDropTarget(grid_vinc) {
                        protected void onDragDrop(DNDEvent event) {

                            List<Men_menuTGWT> lis = event.getData();
                            if (!lis.isEmpty()) {
                                for (Men_menuTGWT men_menuTGWT : lis) {
                                    adionarMenuAoPerfil(men_menuTGWT);
                                }
                            }
                            super.onDragDrop(event);
                        }
                    };
                    targetVinc.setAllowSelfAsSource(false);

                    GridDropTarget targetNotVinc = new GridDropTarget(grid_notvinc) {
                        protected void onDragDrop(DNDEvent event) {
                            List<Men_menuTGWT> lis = event.getData();
                            if (!lis.isEmpty()) {
                                for (Men_menuTGWT men_menuTGWT : lis) {
                                    removerMenuAoPerfil(men_menuTGWT);
                                }
                            }
                            super.onDragDrop(event);
                        }
                    };

                    targetNotVinc.setAllowSelfAsSource(false);

                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public void load(Per_perfilTGWT per_perfilTGWT) {
        try {
            listMenuVinc.povoaMenuVinculado(per_perfilTGWT);
            listMenuNotVinc.povoaMenuNaoVinculado(per_perfilTGWT);
            this.per_perfilTGWT = per_perfilTGWT;
            setHeading("Menus do Perfil "+per_perfilTGWT.getPer_tx_nome());
            montarTela();
            layout();
            doLayout();
        } catch (Exception e) {
        }
    }

    public List<ColumnConfig> createConfig() {
        List<ColumnConfig> config = new Vector();
        ColumnConfig column = new ColumnConfig("men_nr_id", "id", 20);
        column.setHidden(true);
        config.add(column);
        column = new ColumnConfig("men_tx_nome", "nome", 200);
        config.add(column);
        return config;
    }

    public void adionarMenuAoPerfil(Men_menuTGWT men_menuTGWT) {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();

            param.put("op", "adicionarUsuarioPerfil");
            param.put("mep_men_perT.per_nr_id", per_perfilTGWT.getPer_nr_id() + "");
            param.put("mep_men_perT.men_nr_id", men_menuTGWT.getMen_nr_id() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);

        } catch (Exception ex) {
        }
    }

    public void removerMenuAoPerfil(Men_menuTGWT men_menuTGWT) {
        try {

            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();

            param.put("op", "removerUsuarioPerfil");
            param.put("mep_men_perT.per_nr_id", per_perfilTGWT.getPer_nr_id() + "");
            param.put("mep_men_perT.men_nr_id", men_menuTGWT.getMen_nr_id() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);

        } catch (Exception ex) {
        }
    }
}

 