/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_conta_pagar_alterada;

import br.com.easynet.gwt.easyportal.client.Ano;
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
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
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
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Vw_conta_pagar_alteradaConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Vw_conta_pagar_alteradaConsultGWT consultGWT = this;
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT lisMesAno = new ListMes_AnoGWT();
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> cbMeses = new ComboBox<Meses>();
    private ComboBox<Ano> cbAno = new ComboBox<Ano>();
    private Button btnExecutar = new Button("Filtrar");

    @Override
    protected void onShow() {
        super.onShow();
        this.maximize();
    }

    public void createComboObra() {
        listObraGWT.povoar();
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(200);
                } else {
                    cbObra.setStore(listObraGWT.getStore());
                    cbObra.getListView().setStore(listObraGWT.getStore());
                    cbObra.setDisplayField("obr_tx_nome");
                    cbObra.setAllowBlank(false);
                    cbObra.setTriggerAction(ComboBox.TriggerAction.ALL);
                    cbObra.setEmptyText("Selecione a Obra");
                    cbObra.setWidth(250);
                    cbObra.getListView().refresh();

                    getToolBarMaster().add(cbObra);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(cbMeses);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(cbAno);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(btnExecutar);

                    btnExecutar.addSelectionListener(new SelectionListener<ButtonEvent>() {

                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            load();
                        }
                    });

                    
                    getDataNORTH().setSize(27);
                    getDataEAST().setHidden(true);
                    getDataWEST().setHidden(true);
                    setMaximizable(true);

                    getBtnNovoSuper().setVisible(false);

                    final NumberFormat currency = NumberFormat.getCurrencyFormat();
                    final NumberFormat number = NumberFormat.getFormat("0.00");
                    final NumberCellRenderer<Grid<Vw_conta_pagar_alteradaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_conta_pagar_alteradaTGWT>>(currency);

                    ColumnConfig column = null;

                    column = new ColumnConfig();
                    column.setId("ctp_nr_id");
                    column.setHeader("Ctp_nr_id");
                    column.setHidden(true);
                    column.setWidth(200);
                    column.setAlignment(HorizontalAlignment.LEFT);
                    configs.add(column);

                    column = new ColumnConfig();
                    column.setId("ctpm_tx_tipo");
                    column.setHeader("Operação");
                    column.setWidth(90);
                    column.setAlignment(HorizontalAlignment.LEFT);
                    configs.add(column);

                    column = new ColumnConfig();
                    column.setId("ctp_nr_mes");
                    column.setHeader("Mês Entrada");
                    column.setWidth(100);
                    column.setAlignment(HorizontalAlignment.RIGHT);
                    column.setAlignment(HorizontalAlignment.LEFT);
                    configs.add(column);

                    column = new ColumnConfig();
                    column.setId("ctp_nr_ano");
                    column.setAlignment(HorizontalAlignment.RIGHT);
                    column.setHeader("Ano Entrada.");
                    column.setWidth(100);
                    column.setAlignment(HorizontalAlignment.LEFT);
                    configs.add(column);

                    column = new ColumnConfig();
                    column.setId("ctp_nr_documento");
                    column.setHeader("Documento");
                    column.setWidth(100);
                    column.setAlignment(HorizontalAlignment.LEFT);
                    configs.add(column);

                    column = new ColumnConfig();
                    column.setId("ctp_tx_obs");
                    column.setHeader("Obs");
                    column.setHidden(true);
                    column.setWidth(300);
                    column.setAlignment(HorizontalAlignment.LEFT);
                    configs.add(column);

                    column = new ColumnConfig();
                    column.setId("ctp_tx_fornecedor");
                    column.setHeader("Fornecedor");
                    column.setWidth(200);
                    column.setAlignment(HorizontalAlignment.LEFT);
                    configs.add(column);

                    column = new ColumnConfig();
                    column.setId("ctp_nr_valor");
                    column.setHeader("Valor");
                    column.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
                    column.setAlignment(HorizontalAlignment.RIGHT);
                    column.setWidth(100);
                    column.setAlignment(HorizontalAlignment.LEFT);
                    configs.add(column);

                    layout();
                }
            }
        };
        timer.schedule(10);
    }

    public void createComboMesAno() {
        cbMeses.setDisplayField("display");
        cbMeses.setEmptyText("Selecione o mês");
        cbMeses.setWidth(100);
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(lisMesAno.getMeses());
        cbMeses.setStore(store);
        cbMeses.getListView().refresh();

        cbAno.setDisplayField("display");
        cbMeses.setEmptyText("Selecione o ano");
        cbAno.setWidth(100);
        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(lisMesAno.getListAno());
        cbAno.setStore(storeAno);   
        cbAno.getListView().refresh();

    }

    public Vw_conta_pagar_alteradaConsultGWT() {
        try {
            this.setHeading("Consulta Contas Pagas Ateradas ou excluidas");
            
            createComboMesAno();
            createComboObra();

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

            ListStore<Vw_conta_pagar_alteradaTGWT> store = new ListStore<Vw_conta_pagar_alteradaTGWT>();
            int j =0;
            for (int i = 1; i < resultado.size(); i++) {
                j++;
                Vw_conta_pagar_alteradaTGWT vw_conta_pagar_alteradaTGWT = new Vw_conta_pagar_alteradaTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer ctp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_id").toString()));
                vw_conta_pagar_alteradaTGWT.setCtp_nr_id(ctp_nr_id);

                Integer ctp_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_mes").toString()));
                vw_conta_pagar_alteradaTGWT.setCtp_nr_mes(ctp_nr_mes);

                Integer ctp_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_ano").toString()));
                vw_conta_pagar_alteradaTGWT.setCtp_nr_ano(ctp_nr_ano);

                String ctp_nr_documento = EasyContainer.clearAspas(registro.get("ctp_nr_documento").toString());
                vw_conta_pagar_alteradaTGWT.setCtp_nr_documento(ctp_nr_documento);

                String ctp_tx_obs = EasyContainer.clearAspas(registro.get("ctp_tx_obs").toString());
                vw_conta_pagar_alteradaTGWT.setCtp_tx_obs(ctp_tx_obs);

                String ctp_tx_fornecedor = EasyContainer.clearAspas(registro.get("ctp_tx_fornecedor").toString());
                vw_conta_pagar_alteradaTGWT.setCtp_tx_fornecedor(ctp_tx_fornecedor);

                String ctpm_tx_tipo = EasyContainer.clearAspas(registro.get("ctpm_tx_tipo").toString());
                vw_conta_pagar_alteradaTGWT.setCtpm_tx_tipo(ctpm_tx_tipo);

                float ctp_nr_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("ctp_nr_valor").toString()));
                vw_conta_pagar_alteradaTGWT.setCtp_nr_valor(ctp_nr_valor);

                Integer ctpm_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctpm_nr_mes").toString()));
                vw_conta_pagar_alteradaTGWT.setCtpm_nr_mes(ctpm_nr_mes);

                Integer ctpm_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctpm_nr_ano").toString()));
                vw_conta_pagar_alteradaTGWT.setCtpm_nr_ano(ctpm_nr_ano);
//
//                if(j < 5){
//                    Window.alert(vw_conta_pagar_alteradaTGWT.getCtp_nr_documento()+" - "+ ctp_nr_documento);
//                }
                store.add(vw_conta_pagar_alteradaTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Vw_conta_pagar_alteradaTGWT> grid = new Grid<Vw_conta_pagar_alteradaTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Vw_conta_pagar_alteradaInsertGWT insert;
        try {
            insert = new Vw_conta_pagar_alteradaInsertGWT();
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
            HashMap<String, String> op = new HashMap<String, String>();
            op.put("op", "consult");
            op.put("vw_conta_pagar_alteradaT.obr_nr_id", cbObra.getValue().getObr_nr_id() + "");
            op.put("vw_conta_pagar_alteradaT.ctpm_nr_mes", cbMeses.getValue().getValue() + "");
            op.put("vw_conta_pagar_alteradaT.ctpm_nr_ano", cbAno.getValue().getValue() + "");
            //easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaConsultGWT.jsp?op=consult&vw_conta_pagar_alteradaT.obr_nr_id=1&vw_conta_pagar_alteradaT.ctpm_nr_mes=8&vw_conta_pagar_alteradaT.ctpm_nr_ano=2012
            eaurl.accessJSonMap(Constantes.URL + PAGE, op);
            List list = getCpMaster().getItems();
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
