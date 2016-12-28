/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fluxo_caixa;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.flr_fluxo_receita.Flr_fluxo_receitaConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListMeses_obraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Cffo_cronograma_fisico_financeiro_origenalTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Flr_fluxo_receitaTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.FluxoCaixaTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Meses_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Vw_cffo_mesTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.SwallowEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */
public class FluxoCaixa extends ConsultaGWT {

    private Flr_fluxo_receitaTGWT flr_fluxo_receitaTGWT = new Flr_fluxo_receitaTGWT();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private Button btnFiltrar = new Button("Filtrar");
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMeses_obraGWT listMeses_obraGWT = new ListMeses_obraGWT();
    private int id_desp_rec;
    private NumberFormat format = NumberFormat.getFormat("#,##0.00");
    private TreeMap<String, Vw_cffo_mesTGWT> treeCff = new TreeMap<String, Vw_cffo_mesTGWT>();
    private TreeMap<String, Flr_fluxo_receitaTGWT> treeFluxo = new TreeMap<String, Flr_fluxo_receitaTGWT>();
    boolean povoadoCffo;
    boolean povoaFluxo;
    private Vw_cffo_mesTGWT vwLocate;
    private Flr_fluxo_receitaTGWT flrLocate;
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Ano> cbAno = new ComboBox<Ano>();
    private ComboBox<Meses> cbMes = new ComboBox<Meses>();

    public FluxoCaixa() {

        listObraGWT.povoar();
        this.setHeading("Fluxo de Caixa");
        getDataNORTH().setSize(27);
        getDataEAST().setHidden(true);
        getDataWEST().setHidden(true);
        getBtnNovoSuper().setVisible(false);
        setMaximizable(true);

        montarBar();

        btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                load();
            }
        });
        layout();

    }

    @Override
    public void show() {
        super.show();
        maximize();
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
                    cbMes.setEmptyText("Selecione o Obra");
                    getToolBarMaster().add(cbObra);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());

                    ListStore<Meses> storeMes = new ListStore<Meses>();
                    storeMes.add(listMes_AnoGWT.getMeses());
                    cbMes.setStore(storeMes);
                    cbMes.setAllowBlank(false);
                    cbMes.setTriggerAction(ComboBox.TriggerAction.ALL);
                    cbMes.setDisplayField("display");
                    cbMes.setEmptyText("Selecione o mês");
                    cbMes.setWidth(140);
                    getToolBarMaster().add(cbMes);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());

                    ListStore<Ano> storeAno = new ListStore<Ano>();
                    storeAno.add(listMes_AnoGWT.getListAno());
                    cbAno.setStore(storeAno);
                    cbAno.setAllowBlank(false);
                    cbAno.setTriggerAction(ComboBox.TriggerAction.ALL);
                    cbAno.setDisplayField("value");
                    cbAno.setWidth(100);
                    cbAno.setEmptyText("Selecione o ano");
                    getToolBarMaster().add(cbAno);
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

    public void createColumn() {

        configs.clear();
        ColumnConfig column = new ColumnConfig("id", "Código", 40);
        column.setHidden(true);
        configs.add(column);
        column = new ColumnConfig("descricao", "Receita/Despesa", 280);
        configs.add(column);
        column = new ColumnConfig("total", "Total", 100);
        column.setRenderer(getRendererTotal(column));
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setStyle("background-color:#DFE8F6");
        configs.add(column);

        for (Meses_obrasTGWT meses_obrasTGWT : listMeses_obraGWT.getListMeses()) {
            ColumnConfig meses = new ColumnConfig(meses_obrasTGWT.getMes() + "." + meses_obrasTGWT.getAno(), meses_obrasTGWT.getMes_ano(), 80);
            meses.setRenderer(getRenderer(meses));
            meses.setAlignment(HorizontalAlignment.RIGHT);
            configs.add(meses);
        }

        List<FluxoCaixaTGWT> list = new ArrayList<FluxoCaixaTGWT>();
        list.add(povoaFluxocaixa(1, "Desembolso sem Encargos Financeiros"));
        list.add(povoaFluxocaixa(2, "Receitas sem Encargos Financeiros"));
        list.add(povoaFluxocaixa(3, "Receitas - Desembolso sem Encargos Financeiros"));
        list.add(povoaFluxocaixa(4, "Encargoss Financeiro/juros de aplicação"));

        ListStore<FluxoCaixaTGWT> store = new ListStore<FluxoCaixaTGWT>();
        store.add(list);

        ColumnModel cm = new ColumnModel(configs);
        Grid<FluxoCaixaTGWT> grid = new EditorGrid<FluxoCaixaTGWT>(store, cm);
        grid.getSelectionModel().setSelectionMode(SelectionMode.SIMPLE);
        grid.setStripeRows(true);
        getCpMaster().removeAll();
        getCpMaster().add(grid);
        layout();
        doLayout();
    }

    @Override
    public void load() {
        listMeses_obraGWT.povoar(cbObra.getValue().getObr_nr_id());
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listMeses_obraGWT.valido) {
                    schedule(500);
                } else {
                    povoadoCffo = false;
                    povoaFluxo = false;
                    povoaTreeCffo();
                    povoaTreeFluxo();
                    Timer timer = new Timer() {

                        @Override
                        public void run() {
                            if (!povoaFluxo || !povoadoCffo) {
                                schedule(500);
                            } else {
                                createColumn();
                            }
                        }
                    };
                    timer.schedule(500);
                }
            }
        };
        timer.schedule(500);
    }

    public void povoaTreeCffo() {
        try {
            IListenetResponse response = new IListenetResponse() {

                public void read(JSONValue jsonValue) {
                    JSONObject jsonObject;
                    if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                        JSONArray resultado = jsonObject.get("resultado").isArray();
                        treeCff = new TreeMap<String, Vw_cffo_mesTGWT>();
                        for (int i = 1; i < resultado.size(); i++) {
                            Vw_cffo_mesTGWT vw_cffo_mesTGWT = new Vw_cffo_mesTGWT();
                            JSONObject registro = resultado.get(i).isObject();

                            int mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("cffo_nr_mes").toString()));
                            vw_cffo_mesTGWT.setCffo_nr_mes(mes);

                            int ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("cffo_nr_ano").toString()));
                            vw_cffo_mesTGWT.setCffo_nr_ano(ano);

                            float total = Float.parseFloat(EasyContainer.clearAspas(registro.get("total").toString()));
                            vw_cffo_mesTGWT.setTotal(total);

                            vw_cffo_mesTGWT.setKey(vw_cffo_mesTGWT.getCffo_nr_mes() + "." + vw_cffo_mesTGWT.getCffo_nr_ano());
                            treeCff.put(vw_cffo_mesTGWT.getKey(), vw_cffo_mesTGWT);

                        }
                    }
                    povoadoCffo = true;
                }
            };

            String url = Constantes.URL + "easyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesConsultGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("vw_cffo_mesT.obr_nr_id", cbObra.getValue().getObr_nr_id() + "");
            param.put("vw_cffo_mesT.cffo_nr_mes", cbMes.getValue().getValue() + "");
            param.put("vw_cffo_mesT.cffo_nr_ano", cbAno.getValue().getValue() + "");
            EasyAccessURL eaurl = new EasyAccessURL(response);
            eaurl.accessJSonMap(url, param);
        } catch (Exception e) {
            povoadoCffo = true;
            e.printStackTrace();
        }
    }

    public void povoaTreeFluxo() {
        try {
            IListenetResponse response = new IListenetResponse() {

                public void read(JSONValue jsonValue) {
                    JSONObject jsonObject;
                    if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                        JSONArray resultado = jsonObject.get("resultado").isArray();
                        treeFluxo = new TreeMap<String, Flr_fluxo_receitaTGWT>();
                        for (int i = 1; i < resultado.size(); i++) {
                            Flr_fluxo_receitaTGWT fluxoT = new Flr_fluxo_receitaTGWT();
                            JSONObject registro = resultado.get(i).isObject();
                            String key = EasyContainer.clearAspas(registro.get("flr_tx_key").toString());
                            fluxoT.setFlr_tx_key(key);
                            float valorOriginal = Float.parseFloat(EasyContainer.clearAspas(registro.get("flr_nr_original").toString()));
                            fluxoT.setFlr_nr_original(valorOriginal);
                            float valoratual = Float.parseFloat(EasyContainer.clearAspas(registro.get("flr_nr_atual").toString()));
                            fluxoT.setFlr_nr_atual(valoratual);
                            treeFluxo.put(fluxoT.getFlr_tx_key(), fluxoT);
                        }
                    }
                    povoaFluxo = true;
                }
            };

            EasyAccessURL eaurl = new EasyAccessURL(response);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("flr_fluxo_receitaT.obr_nr_id", cbObra.getValue().getObr_nr_id() + "");
            param.put("flr_fluxo_receitaT.flr_nr_mes_ref", cbMes.getValue().getValue() + "");
            param.put("flr_fluxo_receitaT.flr_nr_ano_ref", cbAno.getValue().getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + Flr_fluxo_receitaConsultGWT.PAGE, param);

        } catch (Exception e) {
            povoaFluxo = true;
            e.printStackTrace();
        }

    }

    public GridCellRenderer<FluxoCaixaTGWT> getRenderer(final ColumnConfig meses) {
        final String key = cbMes.getValue().getValue()+"."+cbAno.getValue().getValue()+"-";
        GridCellRenderer gdrMes = new GridCellRenderer<FluxoCaixaTGWT>() {

            public Object render(final FluxoCaixaTGWT model, final String property, ColumnData config, int rowIndex, int colIndex, final ListStore<FluxoCaixaTGWT> store, Grid<FluxoCaixaTGWT> grid) {
                meses.setAlignment(HorizontalAlignment.RIGHT);
                meses.setNumberFormat(format);
                float valor = 0;

                if (model.getId() == 1) {
                    vwLocate = treeCff.get(property);
                    if (vwLocate != null) {
                        valor = vwLocate.getTotal();
                    }

                } else if (model.getId() == 2) {
                    flrLocate = treeFluxo.get(key+property);
                    if (flrLocate != null) {
                        valor = flrLocate.getFlr_nr_atual();
                    }

                } else if (model.getId() == 3) {
                    flrLocate = treeFluxo.get(key+property);
                    if (flrLocate != null) {
                        valor = flrLocate.getFlr_nr_atual();
                    }
                    vwLocate = treeCff.get(property);
                    if (vwLocate != null) {
                        valor -= vwLocate.getTotal();
                    }
                } else if (model.getId() == 4) {
                    flrLocate = treeFluxo.get(key+property);
                    if (flrLocate != null) {
                        valor = flrLocate.getFlr_nr_atual();
                    }
                    vwLocate = treeCff.get(property);
                    if (vwLocate != null) {
                        valor -= vwLocate.getTotal();
                    }

                    if (cbObra.getValue().getObr_nr_encarcos_juros_aplicacao() > 0) {
                        valor = valor * cbObra.getValue().getObr_nr_encarcos_juros_aplicacao() / 100;
                        valor = valor * -1;
                    }

                }
                return valor != 0 ? format.format(valor) : model.get(property);
            }
        };
        return gdrMes;
    }

    public GridCellRenderer<FluxoCaixaTGWT> getRendererTotal(final ColumnConfig meses) {
        GridCellRenderer gdrMes = new GridCellRenderer<FluxoCaixaTGWT>() {

            public Object render(final FluxoCaixaTGWT model, final String property, ColumnData config, int rowIndex, int colIndex, final ListStore<FluxoCaixaTGWT> store, Grid<FluxoCaixaTGWT> grid) {
                meses.setAlignment(HorizontalAlignment.RIGHT);
                meses.setNumberFormat(format);
                float valor = 0;

                if (model.getId() == 1) {
                    valor = TotalCff();
                } else if (model.getId() == 2) {
                    valor = totalFluxo();
                } else if (model.getId() == 3) {
                    valor = totalCalcDesembolso();
                } else if (model.getId() == 4) {
                    valor = totalCalcEncargos();
                }
                return valor != 0 ? format.format(valor) : model.get(property);
            }
        };
        return gdrMes;
    }

    public FluxoCaixaTGWT povoaFluxocaixa(int id, String descricao) {
        FluxoCaixaTGWT fluxoCaixaTGWT = new FluxoCaixaTGWT();
        fluxoCaixaTGWT.setId(id);
        fluxoCaixaTGWT.setDescricao(descricao);
        return fluxoCaixaTGWT;
    }

    public float TotalCff() {
        float valor = 0;
        Set<String> keys = treeCff.keySet();
        for (String key : keys) {
            Vw_cffo_mesTGWT vw_cffo_mesTGWT = treeCff.get(key);
            valor += vw_cffo_mesTGWT.getTotal();
        }

        return valor;
    }

    public float totalFluxo() {
        float valor = 0;
        Set<String> keys = treeFluxo.keySet();
        for (String key : keys) {
            Flr_fluxo_receitaTGWT ftgwt = treeFluxo.get(key);
            valor += ftgwt.getFlr_nr_atual();

        }
        return valor;
    }

    public float totalCalcDesembolso() {
        return totalFluxo() - TotalCff();
    }

    public float totalCalcEncargos() {
        float valor = totalCalcDesembolso();
        valor = valor * cbObra.getValue().getObr_nr_encarcos_juros_aplicacao() / 100;
        return valor;
    }
}
