/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar.Ctp_conta_pagarConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar.Ctp_conta_pagarInsertGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar.Ctp_conta_pagarUpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.for_fornecedor.ListFornecedorGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Ctp_conta_pagarTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.For_fornecedorTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Status;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */
public class AnaliticoFinanceiroContasPagasGWT extends RelatorioBaseGWT implements IListenetResponse {

    private ContentPanel cpREL = new ContentPanel();
    private ListFornecedorGWT listFornecedorGWT = new ListFornecedorGWT();
    private ListPlc_planoContasGWT listClasse = new ListPlc_planoContasGWT();
    private ListPlc_planoContasGWT listSubClasse = new ListPlc_planoContasGWT();
    private ComboBox<For_fornecedorTGWT> comboFornec = new ComboBox<For_fornecedorTGWT>();
    private ComboBox<Plc_plano_contasTGWT> comboClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Plc_plano_contasTGWT> comboSubClasse = new ComboBox<Plc_plano_contasTGWT>();
    private NumberField nfValor = new NumberField();
    public ListStore<Ctp_conta_pagarTGWT> store;
    private double total;
    private PagingToolBar toolBarPage = new PagingToolBar(50);
    final private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private RadioGroup status = new RadioGroup();
    private ToolBar toolBarREL = new ToolBar();
    private TreeMap<Integer, Plc_plano_contasTGWT> treeClasse = new TreeMap<Integer, Plc_plano_contasTGWT>();
    private TreeMap<Integer, Plc_plano_contasTGWT> treeSubClasse = new TreeMap<Integer, Plc_plano_contasTGWT>();
    private TreeMap<String, For_fornecedorTGWT> treeFornec = new TreeMap<String, For_fornecedorTGWT>();
    private TreeMap<Double, Valor> treeValor = new TreeMap<Double, Valor>();
    private ListStore<Plc_plano_contasTGWT> storeClasse = new ListStore<Plc_plano_contasTGWT>();
    private ListStore<Plc_plano_contasTGWT> storeSubClasse = new ListStore<Plc_plano_contasTGWT>();
    private ListStore<For_fornecedorTGWT> storeFornec = new ListStore<For_fornecedorTGWT>();
    private ListStore<Valor> storeValor = new ListStore<Valor>();
    private ComboBox<Valor> comboValor = new ComboBox<Valor>();
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/analiticoFinanceiroContaPagarPagas.jsp";
    final AnaliticoFinanceiroContasPagasGWT analiseCentroCustoDespesasGWT = this;
    private CheckBox acumulado = new CheckBox();
    private ToolBar barTotal = new ToolBar();
    private Status statusTotal = new Status();
    private Status statusTesto = new Status();
    private ContentPanel cpMain = new ContentPanel(new FillLayout());

    public AnaliticoFinanceiroContasPagasGWT() {
        cpMain.setHeaderVisible(false);

        this.setMaximizable(true);

        this.setHeading("Custos Analíticos das Contas Pagas/A Pagar por Fornecedor");

        cpREL.setLayout(new FillLayout());

        statusTesto.setText("Total Geral.:");
        statusTesto.setWidth(150);
        barTotal.add(statusTesto);

        barTotal.add(new FillToolItem());
        statusTotal.setBox(true);
        statusTotal.setWidth(100);

        barTotal.add(statusTotal);
        LabelField lb = new LabelField("Total");
        lb.setVisible(false);
        barTotal.add(lb);

        cpREL.setHeaderVisible(false);
        cpREL.setTopComponent(toolBarREL);
        cpMain.setBottomComponent(barTotal);
        setBottomComponent(toolBarPage);

        getCpMaster().setLayout(new FillLayout());
        cpMain.add(cpREL);
        getCpMaster().add(cpMain);

        createColumn();
        cpMain.layout();
        getCpMaster().layout();

    }

    @Override
    protected void onShow() {

        super.onShow(); //To change body of generated methods, choose Tools | Templates.
        //Window.alert("show");
        getToolBarMaster().removeAll();
        toolBarREL.removeAll();
        cpREL.removeAll();
        montarTelas();
        //Window.alert("show");

    }

//    @Override
//    protected void onHide() {
//        super.onHide();
//        
//        //cpREL.removeAll();
//    }
    public void addClasse() {
        comboClasse.setStore(listClasse.getStore());
        comboClasse.setStore(storeClasse);
        comboClasse.setDisplayField("plc_tx_nome");
        comboClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboClasse.setEmptyText("Selecione a Classe");
        comboClasse.setWidth(250);
        toolBarREL.add(comboClasse);
        toolBarREL.add(new SeparatorToolItem());
        toolBarREL.add(new SeparatorToolItem());
    }

    public void addSubClasse() {
//        comboSubClasse.setStore(listSubClasse.getStore());
        comboSubClasse.setStore(storeSubClasse);

        comboSubClasse.setDisplayField("plc_tx_nome");
        comboSubClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboSubClasse.setEmptyText("Selecione a Sub-Classe");
        comboSubClasse.setWidth(250);
        toolBarREL.add(comboSubClasse);
        toolBarREL.add(new SeparatorToolItem());
        toolBarREL.add(new SeparatorToolItem());
    }

    public void addFornec() {
        comboFornec.setStore(storeFornec);
        comboFornec.setDisplayField("for_tx_nome");
        comboFornec.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboFornec.setEmptyText("Selecione o Fornecedor");
        comboFornec.setWidth(250);
        toolBarREL.add(comboFornec);
        toolBarREL.add(new SeparatorToolItem());
        toolBarREL.add(new SeparatorToolItem());
    }

    public void addValor() {
        comboValor.setStore(storeValor);
        comboValor.setDisplayField("dispaly");
        comboValor.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboValor.setEmptyText("valor");
        comboValor.setWidth(100);
        toolBarREL.add(comboValor);
        toolBarREL.add(new SeparatorToolItem());
        toolBarREL.add(new SeparatorToolItem());
    }

    public void addStatus() {
        Radio apagar = new Radio();
        apagar.setBoxLabel("A Pagar");
        apagar.setValue(true);

        Radio pagas = new Radio();
        pagas.setBoxLabel("Pagas");
        status.add(apagar);
        status.add(pagas);

        getToolBarMaster().add(status);

    }

    private void addCheckBox() {
        acumulado.setBoxLabel("Acumulado");
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(acumulado);
    }

    private void montarTelas() {

        Timer timer = new Timer() {
            @Override
            public void run() {
                if (!getListObraGWT().isMostrar()) {
                    schedule(100);
                } else {

                    addComboObra();

                    addComboMes();

                    addComboAno();

                    addStatus();

                    addCheckBox();

                    addFornec();

                    addClasse();

                    addSubClasse();

                    addValor();

                    toolBarREL.add(new SeparatorToolItem());
                    toolBarREL.add(new SeparatorToolItem());
                    toolBarREL.add(btnFiltrar);
                    toolBarREL.add(new SeparatorToolItem());
                    toolBarREL.add(new SeparatorToolItem());
                    toolBarREL.add(new SeparatorToolItem());
                    toolBarREL.add(getBtnExportar());
                    layout();
                    getComboObra().getListView().refresh();
                    setWidth(getWidth() - 2);
                    layout();
                    setWidth(getWidth() + 2);
                    layout();

                }
            }
        };
        timer.schedule(10);
    }

    @Override
    public void exportarPDF() {
        try {
            String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + getParamLocal() + TIPO_PDF;
            //Window.alert(url);
            download(url);
        } catch (Exception e) {
        }
    }

    @Override
    public void exportarXLS() {
        try {
            String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + getParamLocal() + TIPO_XLS;
            download(url);
        } catch (Exception e) {
        }
    }

    private String getParamLocal() {

        String param = "";
        String filtro = "&";

        String strStattus = status.getValue().getBoxLabel().equalsIgnoreCase("pagas") ? "P" : "A";
        param += "&ctp_conta_pagarT.ctp_tx_status=" + strStattus;
        param += "&ctp_conta_pagarT.ctp_nr_mes=" + getComboMes().getValue().getValue();
        if (comboSubClasse.getValue() != null) {
            param += "&ctp_conta_pagarT.plc_nr_id=" + comboSubClasse.getValue().getPlc_nr_id();
            filtro += "Sub-Classe = " + comboSubClasse.getValue().getPlc_tx_nome();
        }

        if (comboClasse.getValue() != null) {
            param += "&id_super_classe=" + comboClasse.getValue().getPlc_nr_id();
            filtro += ", Classe = " + comboClasse.getValue().getPlc_tx_super();
        }

        param += "&ctp_conta_pagarT.obr_nr_id=" + getComboObra().getValue().getObr_nr_id();

        param += "&ctp_conta_pagarT.ctp_nr_ano=" + getComboAno().getValue().getValue();

        if (comboFornec.getValue() != null) {
            param += "&ctp_conta_pagarT.ctp_tx_fornecedor=" + comboFornec.getValue().getFor_tx_nome();
            filtro += ", Fornecedor = " + comboFornec.getValue().getFor_tx_nome();
        }

        if (comboValor.getValue() != null) {
            param += "&ctp_conta_pagarT.ctp_nr_valor=" + comboValor.getValue().getValue();
            filtro += ", Valor = " + comboValor.getValue().getDisplay();
        }
        param += "&acumulado=" + acumulado.getValue();

        param += filtro;

        return param;
    }

    public void load() {
        try {

            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("ctp_conta_pagarT.ctp_tx_status", status.getValue().getBoxLabel().equalsIgnoreCase("pagas") ? "P" : "A");

            param.put("ctp_conta_pagarT.ctp_nr_mes", getComboMes().getValue().getValue() + "");
            if (comboSubClasse.getValue() != null) {
                param.put("ctp_conta_pagarT.plc_nr_id", comboSubClasse.getValue().getPlc_nr_id() + "");
            }

            param.put("id_super_classe", comboClasse.getValue() == null ? "0" : comboClasse.getValue().getPlc_nr_id() + "");

            param.put("ctp_conta_pagarT.obr_nr_id", getComboObra().getValue().getObr_nr_id() + "");

            param.put("ctp_conta_pagarT.ctp_nr_ano", getComboAno().getValue().getValue() + "");

            if (comboFornec.getValue() != null) {
                param.put("ctp_conta_pagarT.ctp_tx_fornecedor", comboFornec.getValue().getFor_tx_nome());
            }

            if (comboValor.getValue() != null) {
                param.put("ctp_conta_pagarT.ctp_nr_valor", comboValor.getValue().getValue() + "");
            }
            param.put("acumulado", acumulado.getValue() + "");

            //param.put("debug","true");
            //Window.alert(Constantes.URL + Ctp_conta_pagarConsultGWT.PAGE+param.toString());
            eaurl.accessJSonMap(Constantes.URL + Ctp_conta_pagarConsultGWT.PAGE, param);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createColumn() {
        SummaryColumnConfig<Integer> documento = new SummaryColumnConfig<Integer>("ctp_nr_documento", "Documento", 70);
        SummaryColumnConfig<Float> vencimento = new SummaryColumnConfig<Float>("ctp_dt_vencimento", "Vencimento", 70);
        vencimento.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        documento.setSummaryType(SummaryType.COUNT);

        SummaryColumnConfig<Double> classe = new SummaryColumnConfig<Double>("plc_tx_nome_super", "Classe", 250);
        SummaryColumnConfig<Double> fornecedor = new SummaryColumnConfig<Double>("ctp_tx_fornecedor", "Fornecedor", 250);
        SummaryColumnConfig<Double> subclasse = new SummaryColumnConfig<Double>("plc_tx_nome", "Sub-Classe", 250);
        SummaryColumnConfig<Double> columnMes = new SummaryColumnConfig<Double>("ctp_nr_mes", "Mês", 40);
        columnMes.setNumberFormat(NumberFormat.getFormat("00"));
        SummaryColumnConfig<Double> columnAno = new SummaryColumnConfig<Double>("ctp_nr_ano", "Ano", 50);

        columnAno.setAlignment(HorizontalAlignment.LEFT);

        SummaryColumnConfig<Double> valor = new SummaryColumnConfig<Double>("ctp_nr_valor", "Valor", 120);
        valor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        valor.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        valor.setAlignment(HorizontalAlignment.RIGHT);
        valor.setSummaryType(SummaryType.SUM);

        SummaryColumnConfig<Double> rateio = new SummaryColumnConfig<Double>("", "Rateio", 50);
        rateio.setRenderer(new GridCellRenderer<Ctp_conta_pagarTGWT>() {
            public Object render(final Ctp_conta_pagarTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Ctp_conta_pagarTGWT> store, Grid<Ctp_conta_pagarTGWT> grid) {
                Button btnrateio = new Button("", ICONS.add());
                btnrateio.setWidth(30);

                btnrateio.addSelectionListener(new SelectionListener<ButtonEvent>() {
                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        ratear(model);
                    }
                });

                return btnrateio;
            }
        });
        rateio.setAlignment(HorizontalAlignment.CENTER);

        configs.add(documento);
//        configs.add(vencimento);
        configs.add(columnMes);
        configs.add(columnAno);
        configs.add(rateio);
        configs.add(fornecedor);
        configs.add(classe);
        configs.add(subclasse);
        configs.add(valor);
    }

    public void ratear(Ctp_conta_pagarTGWT model) {
        Ctp_conta_pagarInsertGWT ctp_conta_pagarInsertGWT = new Ctp_conta_pagarInsertGWT(status.getValue().getBoxLabel().equalsIgnoreCase("Pagas") ? "P" : "A");
        ctp_conta_pagarInsertGWT.setFinanceiroContasPagasGWT(analiseCentroCustoDespesasGWT);
        ctp_conta_pagarInsertGWT.getTx_locFor().setValue(model.getCtp_tx_fornecedor());
        ctp_conta_pagarInsertGWT.consultarFornecedor();
        ctp_conta_pagarInsertGWT.getListAno().setValue(getComboAno().getValue());
        ctp_conta_pagarInsertGWT.getListMes().setValue(getComboMes().getValue());
        ctp_conta_pagarInsertGWT.addlistObra(getComboObra().getStore());
        ctp_conta_pagarInsertGWT.getListObra().setValue(getComboObra().getValue());

        ctp_conta_pagarInsertGWT.addLisClasse(comboSubClasse.getStore());
        ctp_conta_pagarInsertGWT.getListClasse().setValue(comboSubClasse.getStore().findModel("plc_nr_id", model.getPlc_nr_id()));

        ctp_conta_pagarInsertGWT.getCtp_dt_vencimento().setValue(model.getCtp_dt_vencimento());
        ctp_conta_pagarInsertGWT.getCtp_nr_documento().setValue(model.getCtp_nr_documento());
        ctp_conta_pagarInsertGWT.show();
    }

    @Override
    public void filtrar() {
        load();
    }

    public void addObejtoclasse(int id, String nome) {
        if (treeClasse.get(id) == null) {
            Plc_plano_contasTGWT plc_plano_contasTGWT = new Plc_plano_contasTGWT();
            plc_plano_contasTGWT.setPlc_nr_id(id);
            plc_plano_contasTGWT.setPlc_tx_nome(nome);
            storeClasse.add(plc_plano_contasTGWT);
            treeClasse.put(id, plc_plano_contasTGWT);
        }
    }

    public void addObejtoSubclasse(int id, String nome) {
        if (treeSubClasse.get(id) == null) {
            Plc_plano_contasTGWT plc_plano_contasTGWT = new Plc_plano_contasTGWT();
            plc_plano_contasTGWT.setPlc_nr_id(id);
            plc_plano_contasTGWT.setPlc_tx_nome(nome);
            storeSubClasse.add(plc_plano_contasTGWT);
            treeSubClasse.put(id, plc_plano_contasTGWT);
        }
    }

    public void addObejtoFornec(int id, String nome) {
        if (treeFornec.get(nome) == null) {
            For_fornecedorTGWT for_fornecedorTGWT = new For_fornecedorTGWT();
            for_fornecedorTGWT.setFor_nr_id(id);
            for_fornecedorTGWT.setFor_tx_nome(nome);
            storeFornec.add(for_fornecedorTGWT);
            treeFornec.put(nome, for_fornecedorTGWT);
        }
    }

    public void addObjetoValor(double valor) {
        if (treeValor.get(valor) == null) {
            Valor v = new Valor();
            v.setValue(valor);
            NumberFormat format = NumberFormat.getFormat("#,##0.00");
            v.setDisplay(format.format(valor));
            storeValor.add(v);
            treeValor.put(valor, v);
        }
    }

    public void clearStore() {

        treeClasse.clear();
        treeFornec.clear();
        treeSubClasse.clear();
        treeValor.clear();

        comboClasse.getStore().removeAll();
        comboFornec.getStore().removeAll();
        comboSubClasse.getStore().removeAll();
        comboValor.getStore().removeAll();

    }

    public void read(JSONValue jsonValue) {
//        Window.alert("x");
        int contador = 0;
        try {

            JSONObject jsonObject;
            total = 0;
            clearStore();

            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                JSONArray resultado = jsonObject.get("resultado").isArray();
                List<Ctp_conta_pagarTGWT> listCtp = new ArrayList<Ctp_conta_pagarTGWT>();
                //Window.alert(resultado.size() + "");
                for (int i = 1; i < resultado.size(); i++) {
                    Ctp_conta_pagarTGWT ctp_conta_pagarTGWT = new Ctp_conta_pagarTGWT();
                    JSONObject registro = resultado.get(i).isObject();

                    Integer ctp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_id").toString()));
                    ctp_conta_pagarTGWT.setCtp_nr_id(ctp_nr_id);

                    String for_tx_nome = EasyContainer.clearAspas(registro.get("ctp_tx_fornecedor").toString());
                    ctp_conta_pagarTGWT.setCtp_tx_fornecedor(for_tx_nome);

                    Integer ctp_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_mes").toString()));
                    ctp_conta_pagarTGWT.setCtp_nr_mes(ctp_nr_mes);

                    Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                    ctp_conta_pagarTGWT.setPlc_nr_id(plc_nr_id);

                    Integer plc_nr_id_super = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id_super").toString()));

                    double ctp_nr_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("ctp_nr_valor").toString()));
                    ctp_conta_pagarTGWT.setCtp_nr_valor(ctp_nr_valor);
                    total += Double.parseDouble(EasyContainer.clearAspas(registro.get("ctp_nr_valor").toString()));

                    String ctp_nr_documento = EasyContainer.clearAspas(registro.get("ctp_nr_documento").toString());
                    ctp_conta_pagarTGWT.setCtp_nr_documento(ctp_nr_documento);

                    String ctp_tx_status = EasyContainer.clearAspas(registro.get("ctp_tx_status").toString());
                    ctp_conta_pagarTGWT.setCtp_tx_status(ctp_tx_status);

                    Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                    ctp_conta_pagarTGWT.setObr_nr_id(obr_nr_id);

                    Integer ctp_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_ano").toString()));
                    ctp_conta_pagarTGWT.setCtp_nr_ano(ctp_nr_ano);

                    String obr_tx_nome = EasyContainer.clearAspas(registro.get("obr_tx_nome").toString());
                    ctp_conta_pagarTGWT.setObr_tx_nome(obr_tx_nome);

                    String plc_tx_nome = EasyContainer.clearAspas(registro.get("plc_tx_nome").toString());
                    ctp_conta_pagarTGWT.setPlc_tx_nome(plc_tx_nome);

                    String obs = EasyContainer.clearAspas(registro.get("ctp_tx_obs").toString());
                    ctp_conta_pagarTGWT.setCtp_tx_obs(obs);

                    String plc_tx_nome_super = EasyContainer.clearAspas(registro.get("plc_tx_nome_super").toString());
                    ctp_conta_pagarTGWT.setPlc_tx_nome_super(plc_tx_nome_super);

                    String vencimento = EasyContainer.clearAspas(registro.get("ctp_dt_vencimento").toString());

                    if (vencimento.trim().length() > 0) {
                        DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
                        Date dtvencimento = dtf.parse(vencimento);
                        ctp_conta_pagarTGWT.setCtp_dt_vencimento(dtvencimento);
                    }

                    listCtp.add(ctp_conta_pagarTGWT);
                    addObejtoFornec(i, for_tx_nome);
                    addObejtoSubclasse(plc_nr_id, plc_tx_nome);
                    addObejtoclasse(plc_nr_id_super, plc_tx_nome_super);
                    addObjetoValor(ctp_nr_valor);
                }

                ColumnModel cm = new ColumnModel(configs);

                PagingModelMemoryProxy memoryProxy = new PagingModelMemoryProxy(listCtp);
                PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(memoryProxy);
                loader.setRemoteSort(true);

                store = new ListStore<Ctp_conta_pagarTGWT>(loader);
                store.add(listCtp);
                toolBarPage.setPageSize(50);
                toolBarPage.bind(loader);
                loader.load(0, 50);

                NumberFormat format = NumberFormat.getFormat("#,##0.00");
                String strTotal = format.format(total);

                EditorGrid<Ctp_conta_pagarTGWT> grid = new EditorGrid<Ctp_conta_pagarTGWT>(store, cm);
                grid.setBorders(true);
                grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Ctp_conta_pagarTGWT>>() {
                    public void handleEvent(GridEvent<Ctp_conta_pagarTGWT> be) {
                        String sta = status.getValue().getBoxLabel().equalsIgnoreCase("pagas") ? "P" : "A";
                        final Ctp_conta_pagarUpdateDeleteGWT ctp_conta_pagarUpdateDeleteGWT = new Ctp_conta_pagarUpdateDeleteGWT(sta);
                        ctp_conta_pagarUpdateDeleteGWT.load(be.getModel());

                        ctp_conta_pagarUpdateDeleteGWT.setListObra(getListObraGWT());

                        final ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
                        final Ctp_conta_pagarTGWT ctpT = (Ctp_conta_pagarTGWT) be.getModel();
                        listPlc_planoContasGWT.povoa();
                        Timer timer = new Timer() {
                            @Override
                            public void run() {
                                if (!listPlc_planoContasGWT.isInserido()) {
                                    schedule(200);
                                } else {
                                    ctp_conta_pagarUpdateDeleteGWT.setListPlc(listPlc_planoContasGWT);
                                    For_fornecedorTGWT for_fornecedorTGWT = new For_fornecedorTGWT();
                                    for_fornecedorTGWT.setFor_tx_nome(ctpT.getCtp_tx_fornecedor());
                                    for_fornecedorTGWT.setFor_nr_id(0);
                                    ctp_conta_pagarUpdateDeleteGWT.getListFornecedorGWT().getStore().add(for_fornecedorTGWT);
                                    ctp_conta_pagarUpdateDeleteGWT.setAnaliticoFinanceiroContasPagasGWT(analiseCentroCustoDespesasGWT);
                                    ctp_conta_pagarUpdateDeleteGWT.show();
                                }
                            }
                        };
                        timer.schedule(10);
                    }
                });

                statusTotal.setText(format.format(total));
                cpREL.removeAll();
                grid.setStripeRows(true);
                cpREL.add(grid);

                cpREL.layout();
                cpREL.layout(true);
                getCpMaster().layout();
                cpREL.layout();
                cpMain.layout();
                layout();

            }
        } catch (Exception e) {
            Window.alert(contador + " linha");
        }
    }

    class Valor extends BaseModel {

        public void setValue(double value) {
            set("value", value);
        }

        public double getValue() {
            return ((Double) get("value")).doubleValue();
        }

        public void setDisplay(String display) {
            set("dispaly", display);
        }

        public String getDisplay() {
            return get("dispaly");
        }
    }
}
            //http://eagle990.startdedicated.com:8080/engenharia/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarConsultGWT.jsp?op=consult&ctp_conta_pagarT.ctp_tx_status=P&ctp_conta_pagarT.ctp_nr_mes=5&id_super_classe=0&ctp_conta_pagarT.obr_nr_id=128&ctp_conta_pagarT.ctp_nr_ano=2015&acumulado=false
