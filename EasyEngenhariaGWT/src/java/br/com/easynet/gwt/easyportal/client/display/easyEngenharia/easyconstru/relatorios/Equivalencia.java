/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Vw_equivalenciaTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_equivalencia.Vw_equivalenciaConsultGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Equivalencia extends Window implements IListenetResponse {

    public Button visualizar = new Button("Visualizar");
    public Button Exportar = new Button("Exportar PDF");
    ContentPanel cp = new ContentPanel();
    private MessageBox mb = new MessageBox();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
 

    public Equivalencia() {
        this.setHeading("Equivalência");
        setLayout(new FillLayout());
        FillLayout layout = new FillLayout();
        cp.setLayout(layout);
        visualizar.setIcon(ICONS.filter());
        Exportar.setIcon(ICONS.download());
        ToolBar bar = new ToolBar();
        bar.add(visualizar);
        bar.add(new SeparatorToolItem());
        bar.add(new SeparatorToolItem());
        bar.add(new SeparatorToolItem());
        bar.add(Exportar);
        bar.setAlignment(HorizontalAlignment.CENTER);

        visualizar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                visualizar();
            }
        });
        
        Exportar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                exportar();
            }
        });
        
        cp.setTopComponent(bar);
        cp.setHeaderVisible(false);
        add(cp);
    }

    @Override
    protected void onShow() {
        super.onShow();
        maximize();
    }

    @Override
    protected void onHide() {
        super.onHide();
        cp.removeAll();
    }

    private void visualizar() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            eaurl.accessJSonMap(Constantes.URL + Vw_equivalenciaConsultGWT.PAGE, param);
        } catch (Exception e) {
        }
    }

    private void exportar() {
        try {

        mb = MessageBox.wait("Requisição", "Gerando Arquivo....", "Aguarde.......!!!");
        //com.google.gwt.user.client.Window.alert("Chegou");
            Timer timer = new Timer() {
                @Override
                public void run() {
                    final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
                    String page = "easyEngenharia/easyconstru/relatorios/equivalencia.jsp?op=imprimir&tipo=PDF";
                    winDownload.setUrl(Constantes.URL + page);
                    winDownload.setSize(1, 1);
                    winDownload.setResizable(false);
                    winDownload.show();
                    Timer t = new Timer() {
                        @Override
                        public void run() {
                            winDownload.setVisible(false);
                            mb.close();
                        }
                    };
                    t.schedule(15000);
                }
            };
            timer.schedule(10000);
        } catch (Exception e) {
        }

    }

    private List<ColumnConfig> getConfig() {

        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("plco_tx_cod_externo");
        column.setHeader("Código");
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_tx_nome");
        column.setHeader("Insumos");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plc_tx_nome");
        column.setHeader("Sub Classe");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_tx_tipo");
        column.setHeader("Tipo");
        column.setWidth(40);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plco_tx_unidade");
        column.setHeader("Unidade");
        column.setWidth(40);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        return configs;
    }

    public void read(JSONValue jsonValue) {
        //com.google.gwt.user.client.Window.alert("2222");
        JSONObject jsonObject;
        final ColumnModel cm = new ColumnModel(getConfig());
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            GroupingStore<Vw_equivalenciaTGWT> store = new GroupingStore<Vw_equivalenciaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Vw_equivalenciaTGWT vw_equivalenciaTGWT = new Vw_equivalenciaTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer eplc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("eplc_nr_id").toString()));
                vw_equivalenciaTGWT.setEplc_nr_id(eplc_nr_id);
                Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                vw_equivalenciaTGWT.setPlc_nr_id(plc_nr_id);
                Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                vw_equivalenciaTGWT.setPlco_nr_id(plco_nr_id);
                String plco_tx_nome = EasyContainer.clearAspas(registro.get("plco_tx_nome").toString());
                vw_equivalenciaTGWT.setPlco_tx_nome(plco_tx_nome);
                String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                vw_equivalenciaTGWT.setPlc_tx_nome(plc_tx_nome);
                String plco_tx_tipo = EasyContainer.clearAspas(registro.get("plco_tx_tipo").toString());
                vw_equivalenciaTGWT.setPlco_tx_tipo(plco_tx_tipo);
                String plco_tx_cod_externo = EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString());
                vw_equivalenciaTGWT.setPlco_tx_cod_externo(plco_tx_cod_externo);
                String plco_tx_unidade = EasyContainer.clearAspas(registro.get("plco_tx_unidade").toString());
                vw_equivalenciaTGWT.setPlco_tx_unidade(plco_tx_unidade);
                store.add(vw_equivalenciaTGWT);
            }
            GroupingStore<Vw_equivalenciaTGWT> storeEquivalencia = new GroupingStore<Vw_equivalenciaTGWT>();

            store.groupBy("plc_tx_nome");
            Grid<Vw_equivalenciaTGWT> gridEquivalencia = new Grid<Vw_equivalenciaTGWT>(store, cm);
            gridEquivalencia.setLoadMask(true);
            gridEquivalencia.setStyleAttribute("borderTop", "none");

            GroupingView view = new GroupingView();
            view.setShowGroupedColumn(false);
            view.setForceFit(true);
            view.setGroupRenderer(new GridGroupRenderer() {

                public String render(GroupColumnData data) {
                    String f = cm.getColumnById(data.field).getHeader();
                    String l = data.models.size() == 1 ? "Item" : "Items";
                    return data.group + " (" + data.models.size() + " " + l + ")";
                }
            });
            gridEquivalencia.setAutoExpandColumn("plc_tx_nome");
            gridEquivalencia.setView(view);
//            gridEquivalencia.setLoadMask(true);
//            gridEquivalencia.setStyleAttribute("borderTop", "none");
//            gridEquivalencia.setHeight(200);
            gridEquivalencia.setBorders(true);
            cp.removeAll();
            cp.add(gridEquivalencia);
        }
        layout();
        doLayout();
    }
}
