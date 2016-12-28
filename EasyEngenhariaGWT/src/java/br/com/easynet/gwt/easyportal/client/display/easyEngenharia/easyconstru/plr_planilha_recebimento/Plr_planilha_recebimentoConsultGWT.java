/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plr_planilha_recebimento;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.Style.SelectionMode;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListMeses_obraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author geoleite
 */
public class Plr_planilha_recebimentoConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plr_planilha_recebimento/plr_planilha_recebimentoConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Plr_planilha_recebimentoConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private Button btnFiltrar = new Button("Filtrar");
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMeses_obraGWT listMeses_obraGWT = new ListMeses_obraGWT();
    private TreeMap<String, Plr_planilha_recebimentoTGWT> treePlanilha;
    private ListStore<Plr_planilha_recebimentoTGWT> newstore;
    private Plr_planilha_recebimentoTGWT valorRecebimento;
    private String key;
    private NumberFormat format = NumberFormat.getFormat("#,##0.00");
    private Plr_planilha_recebimentoTGWT planilhaCompare = new Plr_planilha_recebimentoTGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();

    public Plr_planilha_recebimentoConsultGWT() {
        try {
            this.setSize("600", "500");
            listObraGWT.povoar();
            this.setHeading("Planilha Recebimento");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);

            getBtnNovoSuper().setVisible(false);
            montarBar();

            btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    load();
                }
            });

        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }

    }

    public void montarGrid() {


        List<Plr_planilha_recebimentoTGWT> list = new ArrayList<Plr_planilha_recebimentoTGWT>();
        for (Meses_obrasTGWT mesT : listMeses_obraGWT.getListMeses()) {
            Plr_planilha_recebimentoTGWT planilha = new Plr_planilha_recebimentoTGWT();
            planilha.setPlr_nr_mes(mesT.getMes());
            planilha.setPlr_nr_ano(mesT.getAno());
            planilha.setObr_nr_id(cbObra.getValue().getObr_nr_id());
            planilha.setDesc(mesT.getMes_ano());
            String key = planilha.getPlr_nr_mes() + "." + planilha.getPlr_nr_ano();
            valorRecebimento = treePlanilha.get(key);
            if (valorRecebimento != null) {
                planilha.setPlr_nr_efetuado_pj(valorRecebimento.getPlr_nr_efetuado_pj());
                planilha.setPlr_nr_realizado_pf(valorRecebimento.getPlr_nr_realizado_pf());
                planilha.setPlr_nr_realizado_pou(valorRecebimento.getPlr_nr_realizado_pou());
            }

            list.add(planilha);
        }
        newstore = new ListStore<Plr_planilha_recebimentoTGWT>();
        newstore.add(list);
        ColumnConfig column = null;

        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

        column = new ColumnConfig("desc", "Meses", 80);
        configs.add(column);

        //plr_nr_realizado_pou,plr_nr_efetuado_pj.plr_nr_realizado_pf

        ColumnConfig pj = new ColumnConfig("plr_nr_efetuado_pj", "Rec. Efetuado/Proj. (PJ)", 150);
        pj.setAlignment(HorizontalAlignment.RIGHT);
        pj.setRenderer(getCellRenderer(pj));
        configs.add(pj);

        final ColumnConfig pf = new ColumnConfig("plr_nr_realizado_pf", "Rec. Efetuado/proj. (PF)", 150);
        pf.setAlignment(HorizontalAlignment.RIGHT);
        pf.setRenderer(getCellRenderer(pf));
        configs.add(pf);

        final ColumnConfig pou = new ColumnConfig("plr_nr_realizado_pou", "Rec. Efetuado/Proj. (Poupança)", 150);
        pou.setAlignment(HorizontalAlignment.RIGHT);
        pou.setRenderer(getCellRenderer(pou));
        configs.add(pou);

        ColumnModel cm = new ColumnModel(configs);
        AggregationRowConfig<Plr_planilha_recebimentoTGWT> rowConfig = new AggregationRowConfig<Plr_planilha_recebimentoTGWT>();

        rowConfig.setSummaryFormat("plr_nr_efetuado_pj", format);
        rowConfig.setSummaryType("plr_nr_efetuado_pj", SummaryType.SUM);

        rowConfig.setSummaryFormat("plr_nr_realizado_pf", format);
        rowConfig.setSummaryType("plr_nr_realizado_pf", SummaryType.SUM);

        rowConfig.setSummaryFormat("plr_nr_realizado_pou", format);
        rowConfig.setSummaryType("plr_nr_realizado_pou", SummaryType.SUM);

        cm.addAggregationRow(rowConfig);

        EditorGrid<Plr_planilha_recebimentoTGWT> grid = new EditorGrid<Plr_planilha_recebimentoTGWT>(newstore, cm);
        grid.setStripeRows(true);
        grid.setBorders(true);
        grid.getView().setEmptyText("Não existe itens!");
        grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        getCpMaster().removeAll();
        getCpMaster().add(grid);
        layout();
    }

    public GridCellRenderer<Plr_planilha_recebimentoTGWT> getCellRenderer(final ColumnConfig column) {
        GridCellRenderer renderer = new GridCellRenderer<Plr_planilha_recebimentoTGWT>() {

            public Object render(Plr_planilha_recebimentoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Plr_planilha_recebimentoTGWT> store, Grid<Plr_planilha_recebimentoTGWT> grid) {
                NumberField nf = new NumberField();
                nf.setFormat(format);
                CellEditor ce = new CellEditor(nf);
                column.setEditor(ce);
                key = model.getPlr_nr_mes() + "." + model.getPlr_nr_ano();
                if (store.getModifiedRecords().size() > 0) {
                    changeList();
                }
                return model.get(property) != null ? format.format(Double.parseDouble(model.get(property).toString())) : model.get(property);
            }
        };
        return renderer;
    }

    public void montarBar() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {
                    cbObra.setStore(listObraGWT.getStore());
                    cbObra.setAllowBlank(false);
                    cbObra.setTriggerAction(ComboBox.TriggerAction.ALL);
                    cbObra.setDisplayField("obr_tx_nome");
                    cbObra.setWidth(280);

                    ListStore<Meses> storeMes = new ListStore<Meses>();
                    storeMes.add(listMes_AnoGWT.getMeses());
                    comboMes.setStore(storeMes);
                    comboMes.setDisplayField("display");
                    comboMes.setAllowBlank(false);
                    comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboMes.setWidth(100);

                    ListStore<Ano> storeAno = new ListStore<Ano>();
                    storeAno.add(listMes_AnoGWT.getListAno());
                    comboAno.setStore(storeAno);
                    comboAno.setDisplayField("display");
                    comboAno.setAllowBlank(false);
                    comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboAno.setWidth(70);

                    getToolBarMaster().add(cbObra);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(comboMes);

                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(comboAno);

                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());

                    getToolBarMaster().add(btnFiltrar);
                    btnFiltrar.setIcon(ICONS.filter());
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

            JSONArray resultado = jsonObject.get("resultado").isArray();
            treePlanilha = new TreeMap<String, Plr_planilha_recebimentoTGWT>();

            ListStore<Plr_planilha_recebimentoTGWT> store = new ListStore<Plr_planilha_recebimentoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Plr_planilha_recebimentoTGWT plr_planilha_recebimentoTGWT = new Plr_planilha_recebimentoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer plr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plr_nr_id").toString()));
                plr_planilha_recebimentoTGWT.setPlr_nr_id(plr_nr_id);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                plr_planilha_recebimentoTGWT.setObr_nr_id(obr_nr_id);

                Integer plr_nr_mes_ref = Integer.parseInt(EasyContainer.clearAspas(registro.get("plr_nr_mes_ref").toString()));
                plr_planilha_recebimentoTGWT.setPlr_nr_mes_ref(plr_nr_mes_ref);

                Integer plr_nr_ano_ref = Integer.parseInt(EasyContainer.clearAspas(registro.get("plr_nr_ano_ref").toString()));
                plr_planilha_recebimentoTGWT.setPlr_nr_ano_ref(plr_nr_ano_ref);

                Integer plr_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("plr_nr_mes").toString()));
                plr_planilha_recebimentoTGWT.setPlr_nr_mes(plr_nr_mes);

                Integer plr_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("plr_nr_ano").toString()));
                plr_planilha_recebimentoTGWT.setPlr_nr_ano(plr_nr_ano);

                float plr_nr_efetuado_pj = Float.parseFloat(EasyContainer.clearAspas(registro.get("plr_nr_efetuado_pj").toString()));
                plr_planilha_recebimentoTGWT.setPlr_nr_efetuado_pj(plr_nr_efetuado_pj);

                float plr_nr_realizado_pf = Float.parseFloat(EasyContainer.clearAspas(registro.get("plr_nr_realizado_pf").toString()));
                plr_planilha_recebimentoTGWT.setPlr_nr_realizado_pf(plr_nr_realizado_pf);

                float plr_nr_realizado_pou = Float.parseFloat(EasyContainer.clearAspas(registro.get("plr_nr_realizado_pou").toString()));
                plr_planilha_recebimentoTGWT.setPlr_nr_realizado_pou(plr_nr_realizado_pou);
                String key = plr_nr_mes + "." + plr_nr_ano;
                treePlanilha.put(key, plr_planilha_recebimentoTGWT);
                store.add(plr_planilha_recebimentoTGWT);
            }
            povoarListMeses();
            this.layout();
            doLayout();
        }
    }

    public void povoarListMeses() {

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (listMeses_obraGWT.getListMeses() == null) {
                    schedule(500);
                } else {
                    montarGrid();
                }
            }
        };
        timer.schedule(500);
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Plr_planilha_recebimentoInsertGWT insert;
        try {
            insert = new Plr_planilha_recebimentoInsertGWT();
            insert.setConsultGWT(consultGWT);
            insert.setModal(true);
            insert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            listMeses_obraGWT.povoar(cbObra.getValue().getObr_nr_id());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("plr_planilha_recebimentoT.plr_nr_mes_ref", comboMes.getValue().getValue() + "");
            param.put("plr_planilha_recebimentoT.plr_nr_ano_ref", comboAno.getValue().getValue() + "");
            param.put("plr_planilha_recebimentoT.obr_nr_id", cbObra.getValue().getObr_nr_id()+"");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
            List list = getCpMaster().getItems();
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void changeList() {
        try {
            IListenetResponse response = new IListenetResponse() {

                public void read(JSONValue jsonValue) {
                    JSONObject jsonObject;
                    if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                        if (jsonValue.toString().indexOf("sucesso") > 0) {
                            Info.display("", "Operação realizado com sucesso!");
                            newstore.commitChanges();
                        } else {
                            MessageBox.alert("ATENÇÃO", "Erro ao tentar realizar a operação", null);
                        }
                    }
                }
            };
//
            List<Record> list = newstore.getModifiedRecords();

            for (Record record : list) {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("op", "insert");
                param.put("plr_planilha_recebimentoT.plr_nr_mes_ref", comboMes.getValue().getValue() + "");
                param.put("plr_planilha_recebimentoT.plr_nr_ano_ref", comboAno.getValue().getValue() + "");
                param.put("plr_planilha_recebimentoT.plr_nr_mes", record.get("plr_nr_mes").toString());
                param.put("plr_planilha_recebimentoT.plr_nr_ano", record.get("plr_nr_ano").toString());
                param.put("plr_planilha_recebimentoT.obr_nr_id", record.get("obr_nr_id").toString());
                boolean valido = false;
                String key = record.get("plr_nr_mes").toString() + "." + record.get("plr_nr_ano").toString();
                if (record.get("plr_nr_efetuado_pj") != null) {
                    param.put("plr_planilha_recebimentoT.plr_nr_efetuado_pj", record.get("plr_nr_efetuado_pj").toString());
                    planilhaCompare = treePlanilha.get(key);
                    if (planilhaCompare == null) {
                        valido = true;
                    } else if (planilhaCompare.getPlr_nr_efetuado_pj() != Float.parseFloat(record.get("plr_nr_efetuado_pj").toString())) {
                        valido = true;
                    }
                }
                if (record.get("plr_nr_realizado_pf") != null) {
                    param.put("plr_planilha_recebimentoT.plr_nr_realizado_pf", record.get("plr_nr_realizado_pf").toString());
                    planilhaCompare = treePlanilha.get(key);
                    if (planilhaCompare == null) {
                        valido = true;
                    } else if (planilhaCompare.getPlr_nr_realizado_pf() != Float.parseFloat(record.get("plr_nr_realizado_pf").toString())) {
                        valido = true;
                    }
                }
                if (record.get("plr_nr_realizado_pou") != null) {
                    param.put("plr_planilha_recebimentoT.plr_nr_realizado_pou", record.get("plr_nr_realizado_pou").toString());
                    planilhaCompare = treePlanilha.get(key);
                    if (planilhaCompare == null) {
                        valido = true;
                    } else if (planilhaCompare.getPlr_nr_realizado_pou() != Float.parseFloat(record.get("plr_nr_realizado_pou").toString())) {
                        valido = true;
                    }
                }

                if (valido) {
                    EasyAccessURL eaurl = new EasyAccessURL(response);
                    eaurl.accessJSonMapNoProgress(Constantes.URL + Plr_planilha_recebimentoInsertGWT.PAGE, param);
                }
                newstore.commitChanges();
            }
            //newstore.commitChanges();

        } catch (Exception e) {
        }
    }
}
