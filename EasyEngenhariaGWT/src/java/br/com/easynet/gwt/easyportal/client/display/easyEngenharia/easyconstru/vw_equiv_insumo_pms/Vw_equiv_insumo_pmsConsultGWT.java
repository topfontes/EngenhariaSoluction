/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_equiv_insumo_pms;

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
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Frame;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Vw_equiv_insumo_pmsConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE =     "easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsConsultGWT.jsp";
    public static final String PAGE_REL = "easyEngenharia/easyconstru/relatorios/vw_equiv_insumo_pmsPrint.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs;
    final Vw_equiv_insumo_pmsConsultGWT consultGWT = this;
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ToolBar toolBar = new ToolBar();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Plc_plano_contasTGWT> comboPlc = new ComboBox<Plc_plano_contasTGWT>();
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ContentPanel cpTool = new ContentPanel();
    private ToolBar toolCpTool = new ToolBar();
    private NumberFormat number;
    private Button b = new Button("Filtrar");
    private Button download = new Button("Download");
    private CheckBox chkAcumulado = new CheckBox();
    private MessageBox mb = new MessageBox();

    public Vw_equiv_insumo_pmsConsultGWT() {
        try {
            listObraGWT.povoar();
            listPlc_planoContasGWT.povoa();

            this.setHeading("Custos Previstos por Insumos (PMS)");
            getToolBarMaster().setVisible(false);

            getCpTop().setTopComponent(toolCpTool);

            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("750", "350");

            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            number = NumberFormat.getFormat("#,##0.00");
            final NumberCellRenderer<Grid<Vw_equiv_insumo_pmsTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_equiv_insumo_pmsTGWT>>(currency);
            
            configs = new ArrayList<ColumnConfig>();
            ColumnConfig column = null;

            column = new ColumnConfig();

            column = new ColumnConfig();
            column.setId("plc_nr_id");
            column.setHeader("Plc_nr_id");
            column.setWidth(200);
            column.setHidden(true);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("insumo");
            column.setHeader("Insumo");
            column.setWidth(400);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("ipo_nr_vl_unitario");
            column.setHeader("Valor Unitário");
            column.setWidth(100);
            column.setAlignment(HorizontalAlignment.RIGHT);
            column.setNumberFormat(number);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("plco_nr_id");
            column.setHeader("Plco_nr_id");
            column.setWidth(100);
            column.setHidden(true);
            column.setAlignment(HorizontalAlignment.LEFT);

            configs.add(column);

            column = new ColumnConfig();
            column.setId("vl_executado");
            column.setHeader("Total");
            column.setWidth(110);
            column.setAlignment(HorizontalAlignment.RIGHT);
            column.setNumberFormat(number);
            configs.add(column);

            b.setIcon(ICONS.filter());
            b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    load();
                }
            });
            chkAcumulado.setBoxLabel("Acumulado");
            download.setIcon(ICONS.download());
            download.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    print();
                }
            });
            getCpMaster().setTopComponent(toolBar);


        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
    }

    public void print() {
        mb = MessageBox.wait("Requisicao", "Requisitando a servidor", "Aguarde.......!!!");
        Timer timer = new Timer() {

            @Override
            public void run() {
                final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
                String url = Constantes.URL + PAGE_REL;
                url += "?op=imprimir";
                String ac = chkAcumulado.getValue() ? "true" : "false";
                url += "&acumulado=" + ac;
                url += "&vw_equiv_insumo_pmsT.obr_nr_id=" + comboObra.getValue().getObr_nr_id();
                url += "&vw_equiv_insumo_pmsT.pms_nr_mes=" + comboMes.getValue().getValue();
                url += "&vw_equiv_insumo_pmsT.pms_nr_ano=" + comboAno.getValue().getValue();
                url += "&vw_equiv_insumo_pmsT.plc_nr_id=" + comboPlc.getValue().getPlc_nr_id();
                url += "&subClasse=" + comboPlc.getValue().getPlc_tx_nome();
                winDownload.setUrl(url);
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
                t.schedule(2500);
            }
        };

        timer.schedule(500);// espera 5 segundos para poder exibir a janela para download do arquivo
        //mb.close();
    }

    @Override
    protected void onHide() {
        super.onHide();
        getCpMaster().removeAll();
        toolBar.removeAll();
        comboObra.setValue(null);
        toolCpTool.removeAll();
    }

    private void mostrar() {
        super.show();
    }

    /**
     * Maximizar Janela
     */
    public void show() {

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listPlc_planoContasGWT.isInserido()) {
                    schedule(500);
                } else {
                    Timer t = new Timer() {

                        @Override
                        public void run() {
                            if (!listObraGWT.isMostrar()) {
                                schedule(2000);
                            } else {

                                toolBar.removeAll();
                                comboObra.setDisplayField("obr_tx_nome");
                                comboObra.setValueField("obr_nr_id");
                                comboObra.setWidth(257);
                                comboObra.setEmptyText("Selecione a Obra");
                                comboObra.setStore(listObraGWT.getStore());
                                comboObra.setAllowBlank(false);
                                comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
                                toolCpTool.add(new LabelToolItem("Obra:"));
                                toolCpTool.add(comboObra);

                                comboPlc.setStore(listPlc_planoContasGWT.getStore());
                                comboPlc.setDisplayField("plc_tx_nome");
                                comboPlc.setAllowBlank(false);
                                comboPlc.setTriggerAction(ComboBox.TriggerAction.ALL);
                                comboPlc.setWidth(230);

                                toolBar.add(new LabelToolItem("Sub Classe:"));
                                toolBar.add(comboPlc);

                                toolBar.add(new SeparatorToolItem());

                                ListStore storeMes = new ListStore();
                                storeMes.add(listMes_AnoGWT.getMeses());
                                comboMes.setStore(storeMes);
                                comboMes.setDisplayField("display");
                                comboMes.setAllowBlank(false);
                                comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
                                toolBar.add(new LabelToolItem("Mês:"));
                                comboMes.setWidth(80);
                                toolBar.add(comboMes);

                                toolBar.add(new SeparatorToolItem());

                                ListStore storeAno = new ListStore();
                                storeAno.add(listMes_AnoGWT.getListAno());
                                comboAno.setStore(storeAno);
                                comboAno.setDisplayField("display");
                                comboAno.setAllowBlank(false);
                                comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
                                toolBar.add(new LabelToolItem("Ano:"));
                                comboAno.setWidth(50);
                                toolBar.add(comboAno);
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(chkAcumulado);
                                toolBar.add(new SeparatorToolItem());

                                toolBar.add(b);
                                toolBar.add(new SeparatorToolItem());
                                toolBar.add(download);
                                consultGWT.mostrar();
                                consultGWT.layout();
                                doLayout();
                            }
                        }
                    };
                    t.schedule(2000);
                }
            }
        };
        timer.schedule(500);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Vw_equiv_insumo_pmsTGWT> store = new ListStore<Vw_equiv_insumo_pmsTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Vw_equiv_insumo_pmsTGWT vw_equiv_insumo_pmsTGWT = new Vw_equiv_insumo_pmsTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                vw_equiv_insumo_pmsTGWT.setObr_nr_id(obr_nr_id);

                Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                vw_equiv_insumo_pmsTGWT.setPlc_nr_id(plc_nr_id);

                String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                vw_equiv_insumo_pmsTGWT.setPlc_tx_nome(plc_tx_nome);

                String insumo = EasyContainer.clearAspas(registro.get("insumo").toString());
                vw_equiv_insumo_pmsTGWT.setInsumo(insumo);

                float ipo_nr_vl_unitario = Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_unitario").toString()));
                vw_equiv_insumo_pmsTGWT.setIpo_nr_vl_unitario(ipo_nr_vl_unitario);

                Integer pms_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("pms_nr_mes").toString()));
                vw_equiv_insumo_pmsTGWT.setPms_nr_mes(pms_nr_mes);

                Integer pms_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("pms_nr_ano").toString()));
                vw_equiv_insumo_pmsTGWT.setPms_nr_ano(pms_nr_ano);

                Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                vw_equiv_insumo_pmsTGWT.setPlco_nr_id(plco_nr_id);

                float vl_executado = Float.parseFloat(EasyContainer.clearAspas(registro.get("vl_executado").toString()));
                vw_equiv_insumo_pmsTGWT.setVl_executado(vl_executado);


                store.add(vw_equiv_insumo_pmsTGWT);
            }

            ColumnModel cm = new ColumnModel(configs);

            AggregationRowConfig<Vw_equiv_insumo_pmsTGWT> averages = new AggregationRowConfig<Vw_equiv_insumo_pmsTGWT>();
            averages.setHtml("insumo", "Total");
            averages.setSummaryType("vl_executado", SummaryType.SUM);
            averages.setSummaryFormat("vl_executado", number);

            cm.addAggregationRow(averages);

            Grid<Vw_equiv_insumo_pmsTGWT> grid = new Grid<Vw_equiv_insumo_pmsTGWT>(store, cm);
            grid.setLoadMask(true);
            grid.setStripeRows(true);

            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);

            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Vw_equiv_insumo_pmsInsertGWT insert;
        try {
            insert = new Vw_equiv_insumo_pmsInsertGWT();
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
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("vw_equiv_insumo_pmsT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("vw_equiv_insumo_pmsT.pms_nr_mes", comboMes.getValue().getValue() + "");
            param.put("vw_equiv_insumo_pmsT.pms_nr_ano", comboAno.getValue().getValue() + "");
            param.put("vw_equiv_insumo_pmsT.plc_nr_id", comboPlc.getValue().getPlc_nr_id() + "");
            param.put("acumulado", chkAcumulado.getValue() ? "true" : "false");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

