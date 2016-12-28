/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.ListUF;
import br.com.easynet.gwt.easyportal.client.UFTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.emp_empreendimento.ListEmpreendimentoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uni_unidade.ListUnidadeGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uno_unidade_obra.Uno_unidade_obraInsertGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.ListBox;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class Obr_obrasInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/obr_obras/obr_obrasInsertGWT.jsp";
    private Obr_obrasConsultGWT consultGWT = new Obr_obrasConsultGWT();

    public Obr_obrasConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Obr_obrasConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> obr_nr_id = new TextField<String>();
    private TextField<String> obr_tx_nome = new TextField<String>();
    private TextField<String> obr_tx_endereco = new TextField<String>();
    private TextField<String> obr_tx_bairro = new TextField<String>();
    private TextField<String> obr_tx_cidade = new TextField<String>();
    private ListBox obr_tx_uf = new ListBox();
    private ListBox emp_nr_id = new ListBox();
    private NumberField obr_nr_area_construida_total = new NumberField();
    private NumberField obr_nr_area_privativa_total = new NumberField();
    private DateField obr_dt_inicio = new DateField();
    private DateField obr_dt_fim = new DateField();
    private DateField obr_dt_inicio_controle = new DateField();
    private DateField obr_dt_termino_controle = new DateField();

    private DateField obr_dt_inicio_real = new DateField();
    private DateField obr_dt_final_real = new DateField();

    private ListEmpreendimentoGWT listEmpreend = new ListEmpreendimentoGWT();
    private ComboBox<Emp_empreendimentoTGWT> comboEmp = new ComboBox<Emp_empreendimentoTGWT>();
    private ListUF listUF = new ListUF();
    private ComboBox<UFTGWT> comboUf = new ComboBox<UFTGWT>();
    private ContentPanel cp_Top = new ContentPanel();
    //private ContentPanel cp_Center = new ContentPanel();
    private ComboBox<Uni_unidadeTGWT> comboUni = new ComboBox<Uni_unidadeTGWT>();
    private ListUnidadeGWT listUnidadeGWT = new ListUnidadeGWT();
    private NumberField uno_nr_quantidade = new NumberField();
    private NumberField uno_nr_area_construida = new NumberField();
    private ListStore<Uno_unidade_obraTGWT> storeUnidade = new ListStore<Uno_unidade_obraTGWT>();
    final Obr_obrasInsertGWT insertGWT = this;
    private ComboBox<Plc_plano_contasTGWT> comboClasseDireta = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Plc_plano_contasTGWT> comboClasseInDireta = new ComboBox<Plc_plano_contasTGWT>();
    private ListPlc_planoContasGWT listPlc = new ListPlc_planoContasGWT();
    private NumberField percMdoDireta = new NumberField();
    private NumberField percMdoIndireta = new NumberField();
    private int id_obra;
    private NumberField obr_nr_valor_permutado = new NumberField();
    private NumberField obr_nr_valor_vgv = new NumberField();
    private NumberField obr_nr_encarcos_juros_aplicacao = new NumberField();

    public void formatDate(DateField dataDf) {
    }

    public void addComboUnidade() {
        ListStore<Uni_unidadeTGWT> storeUni = new ListStore<Uni_unidadeTGWT>();
        storeUni.add(listUnidadeGWT.getList());
        comboUni.setStore(storeUni);
        comboUni.setDisplayField("uni_tx_nome");
        comboUni.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboUni.setWidth(220);

    }

    public void addListUF() {
        ListStore<UFTGWT> storesuf = new ListStore<UFTGWT>();
        storesuf.add(listUF.getList());
        comboUf.setStore(storesuf);
        comboUf.setDisplayField("display");
        comboUf.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void addComboEmp() {
        try {
            ListStore<Emp_empreendimentoTGWT> storeemp = new ListStore<Emp_empreendimentoTGWT>();
            storeemp.add(listEmpreend.getList());
            comboEmp.setStore(storeemp);
            comboEmp.setAllowBlank(false);
            comboEmp.setTriggerAction(ComboBox.TriggerAction.ALL);
            comboEmp.setDisplayField("emp_tx_nome");
            comboEmp.setValueField("emp_nr_id");
            comboEmp.setWidth(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Obr_obrasInsertGWT() {
        this.setHeading("Cadastro de Obra");
        this.setSize("840", "420");
        getDataEAST().setHidden(false);
        getDataEAST().setSize(340);
        cp_Top.setHeaderVisible(false);
        cp_Top.setHeight(70);

        listPlc.povoaSuperClasse();

        getCpRight().setScrollMode(Scroll.AUTOX);
        getCpRight().setLayout(new FillLayout());
        getCpRight().setHeaderVisible(false);
        getCpRight().setVisible(true);

        getCpRight().setTopComponent(cp_Top);

        obr_nr_valor_permutado.setFormat(NumberFormat.getFormat("#,##0.00"));
        obr_nr_valor_vgv.setFormat(NumberFormat.getFormat("#,##0.00"));
        obr_nr_encarcos_juros_aplicacao.setFormat(NumberFormat.getFormat("#,##0.00"));

        listUnidadeGWT.povoa();
        listEmpreend.povoa();
        montarTela();
    }

    public void povoaComboMDO() {
        comboClasseDireta.setStore(listPlc.getStore());
        comboClasseDireta.setValueField("plc_nr_id");
        comboClasseDireta.setDisplayField("plc_tx_nome");
        comboClasseDireta.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboClasseDireta.setWidth(250);
        percMdoDireta.setWidth(40);

        comboClasseInDireta.setStore(listPlc.getStore());
        comboClasseInDireta.setValueField("plc_nr_id");
        comboClasseInDireta.setDisplayField("plc_tx_nome");
        comboClasseInDireta.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboClasseInDireta.setWidth(250);
        percMdoIndireta.setWidth(40);

    }

    @Override
    protected void onShow() {
        super.onShow();
        maximize();
    }


    public void montarTela() {

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listEmpreend.isPovoado() || !listPlc.isInserido()) {
                    schedule(500);
                } else {
                    povoaComboMDO();
                    Grid grid = new Grid(11, 2);
                    grid.setWidget(0, 0, new LabelField("Nome:"));
                    grid.setWidget(0, 1, obr_tx_nome);
                    obr_tx_nome.setWidth("300");
                    obr_tx_nome.setAllowBlank(false);

                    addComboEmp();
                    grid.setWidget(1, 0, new LabelField("Empreendimento:"));
                    grid.setWidget(1, 1, comboEmp);

                    grid.setWidget(2, 0, new LabelField("Total Area Privativa:"));
                    grid.setWidget(2, 1, obr_nr_area_privativa_total);
                    obr_nr_area_privativa_total.setEnabled(false);
                    obr_nr_area_privativa_total.setAllowBlank(false);

                    grid.setWidget(3, 0, new LabelField("Total Area Construida:"));
                    grid.setWidget(3, 1, obr_nr_area_construida_total);
                    obr_nr_area_construida_total.setAllowBlank(false);


                    grid.setWidget(4, 0, new LabelField("Inicio Previsto obra :"));
                    grid.setWidget(4, 1, obr_dt_inicio);
                    obr_dt_inicio.setAllowBlank(false);

                    grid.setWidget(5, 0, new LabelField("Termino Previsto Obra:"));
                    grid.setWidget(5, 1, obr_dt_fim);
                    obr_dt_fim.setAllowBlank(false);

                    grid.setWidget(6, 0, new LabelField("Inicio Controle:"));
                    grid.setWidget(6, 1, obr_dt_inicio_controle);
                    obr_dt_inicio_controle.setAllowBlank(false);

                    grid.setWidget(7, 0, new LabelField("Termino Controle:"));
                    grid.setWidget(7, 1, obr_dt_termino_controle);
                    obr_dt_termino_controle.setAllowBlank(false);

                    grid.setWidget(8, 0, new LabelField("Início Real da Obra:"));
                    grid.setWidget(8, 1, obr_dt_inicio_real);
                    obr_dt_inicio_real.setAllowBlank(false);

                    grid.setWidget(9, 0, new LabelField("Término Real da Obra:"));
                    grid.setWidget(9, 1, obr_dt_final_real);
                    obr_dt_final_real.setAllowBlank(false);

                    ContentPanel panel = new ContentPanel(new FillLayout());
                    panel.setHeaderVisible(false);
                    panel.add(grid);
                    getCpMaster().add(panel);

                    ContentPanel cpBotton = new ContentPanel();
                    cpBotton.setHeaderVisible(false);
                    cpBotton.setBodyBorder(true);
                    cpBotton.setHeight(140);
                    final ContentPanel cp = new ContentPanel();
                    cp.setBodyBorder(true);
                    cp.setHeight(100);
                    cp.setHeading("Encargos Sociais");
                    TableLayout lay = new TableLayout(4);
                    lay.setCellPadding(3);
                    cp.setLayout(lay);
                    cp.add(new LabelField("MDO Direta:"));
                    cp.add(comboClasseDireta);
                    cp.add(new LabelField("Percentual:"));
                    cp.add(percMdoDireta);
                    cp.add(new LabelField("MDO Indireta:"));
                    cp.add(comboClasseInDireta);
                    cp.add(new LabelField("Percentual:"));
                    cp.add(percMdoIndireta);
                    cpBotton.add(cp);

                    ContentPanel cpvgv = new ContentPanel();
                    cpvgv.setHeight(33);
                    cpvgv.setHeaderVisible(false);
                    cpvgv.setBodyBorder(true);
                    TableLayout layvgv = new TableLayout(4);
                    layvgv.setCellPadding(3);
                    cpvgv.setLayout(layvgv);
                    cpvgv.add(new LabelField("Valor Permutado - Orc. (R$)"));
                    obr_nr_valor_permutado.setWidth(70);
                    cpvgv.add(obr_nr_valor_permutado);
//                    cpvgv.add(new LabelField("VGV - Orçamento"));
//                    obr_nr_valor_vgv.setWidth(70);
//                    cpvgv.add(obr_nr_valor_vgv);
                    obr_nr_encarcos_juros_aplicacao.setWidth(70);
                    cpvgv.add(new LabelField("Encargos Fin./Juros Aplicações (% a.m.) "));
                    cpvgv.add(obr_nr_encarcos_juros_aplicacao);

                    cpBotton.add(cpvgv);

                    panel.setBottomComponent(cpBotton);

                    layout();
                    addUnidadeObra();
                    layout();

                }
            }
        };
        timer.schedule(500);
    }

    public void addUnidadeObra() {
        if (cp_Top.getItemCount() > 0) {
            cp_Top.removeAll();
        }
        Grid grid = new Grid(6, 2);
        addComboUnidade();
        grid.setWidget(0, 0, new LabelField("Unidade:"));
        grid.setWidget(0, 1, comboUni);
        grid.setWidget(1, 0, new LabelField("Qtde.:"));
        Grid grid2 = new Grid(1, 4);
        uno_nr_quantidade.setWidth(60);
        uno_nr_quantidade.setAllowBlank(false);
        uno_nr_area_construida.setAllowBlank(false);
        grid2.setWidget(0, 0, uno_nr_quantidade);
        grid2.setWidget(0, 1, new LabelField("Area Privativa:"));
        uno_nr_area_construida.setWidth(60);
        grid2.setWidget(0, 2, uno_nr_area_construida);
        Button b = new Button("Add");
        b.setIcon(ICONS.formAdd());
        b.addListener(Events.OnClick, new com.extjs.gxt.ui.client.event.Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                addCompList();
            }
        });
        grid2.setWidget(0, 3, b);
        grid.setWidget(1, 1, grid2);
        cp_Top.add(grid);
        cp_Top.layout(true);
        cp_Top.layout();
        this.layout();
        doLayout();
    }

    public void addCompList() {
        Uno_unidade_obraTGWT uno_unidade_obraTGWT = new Uno_unidade_obraTGWT();
        uno_unidade_obraTGWT.setUni_nr_id(comboUni.getValue().getUni_nr_id());
        uno_unidade_obraTGWT.setUni_tx_nome(comboUni.getValue().getUni_tx_nome());
        uno_unidade_obraTGWT.setUno_nr_area_construida(uno_nr_area_construida.getValue().floatValue());
        uno_unidade_obraTGWT.setUno_nr_quantidade(uno_nr_quantidade.getValue().intValue());
        float total = 0;
        if (obr_nr_area_privativa_total.getValue() != null) {
            total = obr_nr_area_privativa_total.getValue().floatValue();
        }
        obr_nr_area_privativa_total.setValue(total + uno_nr_area_construida.getValue().floatValue() * uno_nr_quantidade.getValue().intValue());
        storeUnidade.add(uno_unidade_obraTGWT);
        comboUni.setValue(null);
        uno_nr_area_construida.setValue(null);
        uno_nr_quantidade.setValue(null);
        comboUni.setForceSelection(true);
        montarGrid();
    }

    public void montarGrid() {
        ColumnModel cm = new ColumnModel(getColumn());
        com.extjs.gxt.ui.client.widget.grid.Grid<Uno_unidade_obraTGWT> grid = new com.extjs.gxt.ui.client.widget.grid.Grid<Uno_unidade_obraTGWT>(storeUnidade, cm);
        if (getCpRight().getItemCount() > 0) {
            getCpRight().removeAll();
        }
        grid.setStripeRows(true);
        grid.setLoadMask(true);
        grid.setBorders(true);
        grid.addListener(Events.OnDoubleClick, new Listener<GridEvent<Uno_unidade_obraTGWT>>() {

            public void handleEvent(GridEvent<Uno_unidade_obraTGWT> be) {
                uno_nr_area_construida.setValue(be.getModel().getUno_nr_area_construida());
                uno_nr_quantidade.setValue(be.getModel().getUno_nr_quantidade());
                comboUni.setValue(listUnidadeGWT.getTreeUnidade().get(be.getModel().getUni_nr_id()));
                storeUnidade.remove(be.getModel());
                layout();
            }
        });
        getCpRight().add(grid);
        layout();
        doLayout();

    }

    public List<ColumnConfig> getColumn() {
        List<ColumnConfig> listcolCcs = new Vector<ColumnConfig>();

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("uni_tx_nome");
        column.setHeader("Unidade Construtiva");
        column.setWidth(130);
        column.setAlignment(HorizontalAlignment.LEFT);
        listcolCcs.add(column);

        column = new ColumnConfig();
        column.setId("uno_nr_quantidade");
        column.setHeader("Qtde.");
        column.setWidth(60);
        column.setAlignment(HorizontalAlignment.LEFT);
        listcolCcs.add(column);

        column = new ColumnConfig();
        column.setId("uno_nr_area_construida");
        column.setHeader("A. Priv.");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.LEFT);
        listcolCcs.add(column);

        GridCellRenderer<Uno_unidade_obraTGWT> btnDel = new GridCellRenderer<Uno_unidade_obraTGWT>() {

            private boolean init;

            public Object render(final Uno_unidade_obraTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Uno_unidade_obraTGWT> store, com.extjs.gxt.ui.client.widget.grid.Grid<Uno_unidade_obraTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Uno_unidade_obraTGWT>>() {

                        public void handleEvent(GridEvent<Uno_unidade_obraTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }
                Button btnCol = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        try {
                            obr_nr_area_privativa_total.setValue(obr_nr_area_privativa_total.getValue().floatValue() - model.getUno_nr_quantidade() * model.getUno_nr_area_construida());
                            storeUnidade.remove(model);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                btnCol.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                btnCol.setHeight(25);
                btnCol.setToolTip("Deletar");
                btnCol.setIcon(ICONS.del());

                return btnCol;
            }
        };
        column = new ColumnConfig();
        column.setId("del");
        column.setHeader("");
        column.setWidth(25);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setRenderer(btnDel);
        listcolCcs.add(column);

        return listcolCcs;

    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        if (valido()) {
            btnCadAction(ce);
        }
    }

    @Override
    public void btnLimpartAction(ButtonEvent ce) {
    }

    public boolean valido() {
        boolean result = true;
        if (obr_tx_nome.getValue().trim().length() == 0) {
            result = false;
            getMbMaster().alert("ATENÇÃO", "O campo nome tem preenchimento obrigatório", null);
        } else if (obr_dt_inicio.getValue() == null) {
            result = false;
            getMbMaster().alert("ATENÇÃO", "O campo data início da obra tem preenchimento obrigatório", null);
        } else if (obr_dt_fim.getValue() == null) {
            result = false;
            getMbMaster().alert("ATENÇÃO", "O campo data final da obra tem preenchimento obrigatório", null);
        } else if (obr_dt_inicio_controle.getValue() == null) {
            result = false;
            getMbMaster().alert("ATENÇÃO", "O campo data início do controle tem preenchimento obrigatório", null);
        } else if (obr_dt_termino_controle.getValue() == null) {
            result = false;
            getMbMaster().alert("ATENÇÃO", "O campo data termino do controle tem preenchimento obrigatório", null);
        } else if (comboEmp.getValue() == null) {
            result = false;
            getMbMaster().alert("ATENÇÃO", "O campo empreendimento tem preenchimento obrigatório", null);
        } else if (getVetores().trim().length() == 0) {
            getMbMaster().alert("ATENÇÃO", "Falta o preenchimento da composição da obra", null);
        }

        return result;
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");
            param.put("obr_obrasT.obr_tx_nome", obr_tx_nome.getValue());

            param.put("obr_obrasT.emp_nr_id", comboEmp.getValue().getEmp_nr_id() + "");
            param.put("obr_obrasT.obr_nr_area_construida_total", obr_nr_area_construida_total.getValue() != null ? obr_nr_area_construida_total.getValue() + "" : "0");
            param.put("obr_obrasT.obr_nr_area_privativa_total", obr_nr_area_privativa_total.getValue() != null ? obr_nr_area_privativa_total.getValue() + "" : "0");

            param.put("obr_obrasT.obr_dt_inicio", DateTimeFormat.getFormat("dd/MM/yyyy").format(obr_dt_inicio.getValue()));
            param.put("obr_obrasT.obr_dt_fim", DateTimeFormat.getFormat("dd/MM/yyyy").format(obr_dt_fim.getValue()));
            param.put("obr_obrasT.obr_dt_inicio_controle", DateTimeFormat.getFormat("dd/MM/yyyy").format(obr_dt_inicio_controle.getValue()));
            param.put("obr_obrasT.obr_dt_termino_controle", DateTimeFormat.getFormat("dd/MM/yyyy").format(obr_dt_termino_controle.getValue()));

            param.put("obr_obrasT.obr_dt_inicio_real", DateTimeFormat.getFormat("dd/MM/yyyy").format(obr_dt_inicio_real.getValue()));
            param.put("obr_obrasT.obr_dt_final_real", DateTimeFormat.getFormat("dd/MM/yyyy").format(obr_dt_final_real.getValue()));

            if (obr_nr_valor_permutado.getValue() != null) {
                param.put("obr_obrasT.obr_nr_valor_permutado", obr_nr_valor_permutado.getValue() + "");
            }
            if (obr_nr_valor_vgv.getValue() != null) {
                param.put("obr_obrasT.obr_nr_valor_vgv", obr_nr_valor_vgv.getValue() + "");
            }

            if (comboClasseDireta.getValue() != null) {
                param.put("obr_obrasT.obr_nr_id_plc_mdo_direta", comboClasseDireta.getValue().getPlc_nr_id() + "");
            }
            if (comboClasseInDireta.getValue() != null) {
                param.put("obr_obrasT.obr_nr_id_plc_mdo_indireta", comboClasseInDireta.getValue().getPlc_nr_id() + "");
            }
            if (percMdoDireta.getValue() != null) {
                param.put("obr_obrasT.obr_nr_percent_mdo_direta", percMdoDireta.getValue() + "");
            }
            if (percMdoIndireta.getValue() != null) {
                param.put("obr_obrasT.obr_nr_percent_mdo_indireta", percMdoIndireta.getValue() + "");
            }
            if (obr_nr_encarcos_juros_aplicacao.getValue() != null) {
                param.put("obr_obrasT.obr_nr_encarcos_juros_aplicacao", obr_nr_encarcos_juros_aplicacao.getValue() + "");
            }
//            Window.alert(param.toString());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void clearFields() {
        obr_tx_nome.setValue("");
        comboEmp.setValue(null);
        obr_dt_fim.setValue(null);
        obr_dt_inicio.setValue(null);
        obr_dt_inicio_controle.setValue(null);
        obr_dt_termino_controle.setValue(null);
        obr_nr_area_construida_total.setValue(0);
        obr_nr_area_privativa_total.setValue(0);
    }

    public void read(JSONValue jsonValue) {
        id_obra = 0;
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

            if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                try {
                    JSONArray resultado = jsonObject.get("resultado").isArray();
                    JSONObject registro = resultado.get(1).isObject();
                    id_obra = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                    if (id_obra > 0) {
                        Resposta resposta = new Resposta();
                        EasyAccessURL eaurl = new EasyAccessURL(resposta);
                        String param = "?op=insert&uno_unidade_obraT.obr_nr_id=" + id_obra;
                        param += getVetores();
                        eaurl.accessJSonNoProgress(Constantes.URL + Uno_unidade_obraInsertGWT.PAGE + param);
                    }
                } catch (Exception e) {
                    
                }

            } else {
                getShowMsgErro(jsonObject.get("resultado").toString());
            }
        }
    }

    public String getVetores() {
        String vet = "";
        List<Uno_unidade_obraTGWT> list = storeUnidade.getModels();
        for (Uno_unidade_obraTGWT uno_unidade_obraTGWT : list) {
            vet += "&vet_uni_nr_id=" + uno_unidade_obraTGWT.getUni_nr_id();
            vet += "&vet_quant=" + uno_unidade_obraTGWT.getUno_nr_quantidade();
            vet += "&vet_area=" + uno_unidade_obraTGWT.getUno_nr_area_construida();
        }
        return vet;
    }

    public class Resposta implements IListenetResponse {

        public void read(JSONValue jsonValue) {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                    getShowMsgCadastro();
                    clearFields();
                    storeUnidade.removeAll();
                    consultGWT.load();
                } else {
                    if (id_obra > 0) {
                        getShowMsgErro("Obra Cadastrada com sucesso!, Erro ao tentar cadastrar composição da obra");
                        clearFields();
                    } else {
                        getShowMsgErro(jsonObject.get("resultado").toString());
                        insertGWT.close();
                    }
                }
            }
        }
    }
}
