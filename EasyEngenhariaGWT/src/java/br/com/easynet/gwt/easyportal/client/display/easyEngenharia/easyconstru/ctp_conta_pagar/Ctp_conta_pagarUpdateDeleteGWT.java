/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.extjs.gxt.ui.client.event.ComponentEvent;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.for_fornecedor.ListFornecedorGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.AnaliticoFinanceiroContasPagasGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 *
 * @author geoleite
 */
public class Ctp_conta_pagarUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarUpdateDeleteGWT.jsp";
    private TextField<String> ctp_nr_id = new TextField<String>();
    private TextField<String> for_nr_id = new TextField<String>();
    private TextField<String> ctp_nr_mes = new TextField<String>();
    private TextField<String> plc_nr_id = new TextField<String>();
    private NumberField ctp_nr_valor = new NumberField();
    private TextField<String> ctp_nr_documento = new TextField<String>();
    private TextField<String> ctp_tx_status = new TextField<String>();
    private TextField<String> ctp_tx_obs = new TextField<String>();
    private TextField<String> obr_nr_id = new TextField<String>();
    private ComboBox<Ano> listAno = new ComboBox<Ano>();
    private ComboBox<Plc_plano_contasTGWT> listClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Obr_obrasTGWT> listObra = new ComboBox<Obr_obrasTGWT>();
    private TextField<String> ctp_tx_fornecedor = new TextField<String>();
    private ComboBox<Meses> listMes = new ComboBox<Meses>();
    private VerticalPanel vp = new VerticalPanel();
    private String status;
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ToolBar barOperacao = new ToolBar();
    private DateField ctp_dt_vencimento = new DateField();
    private ContentPanel cpConteudo = new ContentPanel();
    private Ctp_conta_pagarTGWT ctp_conta_pagarTGWT;
    private Ctp_conta_pagarConsultGWT consultGWT;
    private AnaliticoFinanceiroContasPagasGWT analiticoFinanceiroContasPagasGWT;
    private ComboBox<For_fornecedorTGWT> comboFornec = new ComboBox<For_fornecedorTGWT>();
    private ListFornecedorGWT listFornecedorGWT = new ListFornecedorGWT();
    private boolean valueFieldDiferente;
    private TextField tx_loc_fornec = new TextField();


    public void setListFornecedorGWT (ListFornecedorGWT listFornecedorGWT){
        this.listFornecedorGWT = listFornecedorGWT;
    }
    public ListFornecedorGWT getListFornecedorGWT(){
        return listFornecedorGWT;
    }

    public Ctp_conta_pagarUpdateDeleteGWT(String status) {
//        listObraGWT.povoar();
//        listPlc_planoContasGWT.povoa();
//        listFornecedorGWT.povoa();

        this.status = status;
        consultGWT = new Ctp_conta_pagarConsultGWT(status);

        this.setHeading(status.equalsIgnoreCase("A") ? "Cadastro Contas a pagar" : "Cadastro Contas pagas");
        this.ctp_tx_status.setValue(status);

        this.setSize(550, 280);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        cpConteudo.setLayout(layout);
        cpConteudo.setHeaderVisible(false);
    }
    public void povoaSubClasses(){

    }

    public void setListPlc(ListPlc_planoContasGWT listPlc_planoContasGWT){
        this.listPlc_planoContasGWT =  listPlc_planoContasGWT;
    }

    public void setListObra(ListObraGWT listObraGWT){
        this.listObraGWT =  listObraGWT;
    }
    
    @Override
    public void show() {
//        Timer timer = new Timer() {
//
//            @Override
//            public void run() {
//                //if (!listPlc_planoContasGWT.isInserido() || !listFornecedorGWT.inserido) {
//                if (!listFornecedorGWT.inserido) {
//                    schedule(5000);
//                } else {

                    addLisClasse();
                    addListMes();
                    addlistObra();
                    addListAno();
                    addListFornec();
                    Ctp_conta_pagarUpdateDeleteGWT.super.show();
                    addToolbarOperacao();

                    cpConteudo.add(new LabelField("Sub Classe:"));
                    cpConteudo.add(listClasse);
                    cpConteudo.add(new LabelField("Fornecedor:"));
//                    comboFornec.setValue(listFornecedorGWT.getStore().findModel("for_tx_nome", ctp_conta_pagarTGWT.getCtp_tx_fornecedor()));
                    cpConteudo.add(getPanelFornec());
                    ctp_tx_fornecedor.setWidth(300);
                    if (comboFornec.getValue() == null){
                        cpConteudo.add(new LabelField("Fornecedor Importação:"));
                        cpConteudo.add(new LabelField(ctp_conta_pagarTGWT.getCtp_tx_fornecedor()));
                        setSize(550, 300);
                    }
                    cpConteudo.add(new LabelField("Documento:"));
                    cpConteudo.add(ctp_nr_documento);
                    cpConteudo.add(new LabelField("Vencimento:"));
                    cpConteudo.add(ctp_dt_vencimento);
                    ctp_dt_vencimento.setWidth(90);
                    cpConteudo.add(new LabelField("Valor:"));
                    cpConteudo.add(ctp_nr_valor);
                    ctp_tx_obs.setWidth(300);
                    cpConteudo.add(new LabelField("Observação:"));
                    cpConteudo.add(ctp_tx_obs);
                    getCpMaster().add(cpConteudo);
                    layout();

//                }
//            }
//        };
//        timer.schedule(10);
    }
    public ContentPanel getPanelFornec(){
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        ContentPanel cp = new ContentPanel(layout);
        cp.setHeaderVisible(false);;
        cp.setBodyBorder(false);
        cp.setFrame(false);
        cp.add(tx_loc_fornec);
        cp.add(comboFornec);
        KeyListener kl = new KeyListener(){

            @Override
            public void componentKeyPress(ComponentEvent event) {
                if(event.getKeyCode() == KeyCodes.KEY_ENTER){
                    locateFornec();
                }
            }

        };
        tx_loc_fornec.addKeyListener(kl);
        return cp;
    }

    public void locateFornec(){

        listFornecedorGWT.consultbyName(tx_loc_fornec.getValue().toString());
        Timer timer = new Timer() {

            @Override
            public void run() {
                if(!listFornecedorGWT.inserido){
                    schedule(200);
                }else{
                    addListFornec();
                    comboFornec.focus();
                    comboFornec.expand();
                }
            }
        };timer.schedule(10);

    };
//88421561
    public void addListFornec() {

        comboFornec.setStore(listFornecedorGWT.getStore());
        comboFornec.setDisplayField("for_tx_nome");
        comboFornec.setTypeAhead(true);
        comboFornec.setAllowBlank(false);
        comboFornec.setTriggerAction(ComboBox.TriggerAction.ALL);
        if(listFornecedorGWT.getStore().getCount() == 1){
            comboFornec.setValue(listFornecedorGWT.getStore().getAt(0));
        }
        comboFornec.getListView().setStore(listFornecedorGWT.getStore());
        comboFornec.getListView().refresh();
        comboFornec.getView().refresh();
        comboFornec.setWidth("300");
//        Window.alert("chegou "+ listFornecedorGWT.getStore().getCount());
    }

    public void addListMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        listMes.setStore(store);
        listMes.setDisplayField("display");
        listMes.setAllowBlank(false);
        listMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        listMes.setWidth("100");
        listMes.setValue(listMes_AnoGWT.getTreeMeses().get(ctp_conta_pagarTGWT.getCtp_nr_mes()));
    }

    public void addlistObra() {
        try {
            listObra.setStore(listObraGWT.getStore());
            listObra.setDisplayField("obr_tx_nome");
            listObra.setAllowBlank(false);
            listObra.setTriggerAction(ComboBox.TriggerAction.ALL);
            listObra.setWidth("220");
            listObra.setValue(listObraGWT.getTreeObra().get(ctp_conta_pagarTGWT.getObr_nr_id()));

        } catch (Exception e) {
        }

    }

    public void addLisClasse() {
        try {
            listClasse.setStore(listPlc_planoContasGWT.getStore());
            listClasse.setAllowBlank(false);
            listClasse.setDisplayField("plc_tx_nome");
            listClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
            listClasse.setWidth("300");
            listClasse.setValue(listPlc_planoContasGWT.getTreePlc().get(ctp_conta_pagarTGWT.getPlc_nr_id()));

        } catch (Exception e) {
        }
    }

    public void addListAno() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMes_AnoGWT.getListAno());
        listAno.setStore(store);
        listAno.setDisplayField("display");
        listAno.setAllowBlank(false);
        listAno.setTriggerAction(ComboBox.TriggerAction.ALL);
        listAno.setWidth(70);
        listAno.setValue(listMes_AnoGWT.getTreeAno().get(ctp_conta_pagarTGWT.getCtp_nr_ano()));


    }

    public void addToolbarOperacao() {
        //barOperacao.removeAll();
        barOperacao.add(new LabelToolItem("Obra:"));
        barOperacao.add(listObra);
        barOperacao.add(new LabelToolItem("Mês:"));
        barOperacao.add(listMes);
        barOperacao.add(new LabelToolItem("Ano:"));
        barOperacao.add(listAno);
        cpConteudo.setTopComponent(barOperacao);

    }

    public void setConfigForm(FormPanel form) {
        form.setFrame(true);
        form.setIconStyle("icon-form");
        form.setCollapsible(true);
        form.setSize(400, -4);
        //form.setButtonAlign(HorizontalAlignment.CENTER);
        form.setLayout(new FlowLayout());
        form.setLabelAlign(FormPanel.LabelAlign.TOP);
    }

    public FormPanel getFormOperacao() {
        FormPanel fp = new FormPanel();
        fp.setHeading("Informações da Obra");

        setConfigForm(fp);

        LayoutContainer container = new LayoutContainer();

        container.setLayout(new ColumnLayout());

        FormLayout layout = new FormLayout();
        layout.setLabelAlign(FormPanel.LabelAlign.TOP);
//         

        LayoutContainer left = new LayoutContainer();
        left.setLayout(layout);
        left.add(new Label("Obra"), new FormData("90%"));
        left.add(listObra, new FormData("90%"));

        LayoutContainer center = new LayoutContainer();

        layout = new FormLayout();
        layout.setLabelAlign(FormPanel.LabelAlign.TOP);
//         

        center.setLayout(layout);
        center.add(new Label("Mês"), new FormData("90%"));
        center.add(listMes, new FormData("90%"));

        LayoutContainer rigth = new LayoutContainer();

        layout = new FormLayout();
        layout.setLabelAlign(FormPanel.LabelAlign.TOP);
//         

        rigth.setLayout(layout);
        Label lbl = new Label("Ano");
        rigth.add(lbl, new FormData("95%"));
        rigth.add(listAno, new FormData("95%"));

        container.add(left, new ColumnData(200));
        container.add(center, new ColumnData(120));
        container.add(rigth, new ColumnData(60));

        fp.add(container);
        return fp;

    }

    public FormPanel getFormPanelInsert() {

        FormLayout layout = new FormLayout();
        layout.setLabelAlign(FormPanel.LabelAlign.TOP);
//         

        FormPanel fp = new FormPanel();

        fp.setHeading("Cadastro");

        setConfigForm(fp);

        LayoutContainer container = new LayoutContainer();

        container.setLayout(new ColumnLayout());
        LayoutContainer left = new LayoutContainer(layout);

        Grid grid = new Grid(4, 2);

        grid.setWidget(0, 0, new LabelField("Sub-Classe:"));
        grid.setWidget(0, 1, listClasse);

        grid.setWidget(1, 0, new LabelField("Fornecedor:"));
        grid.setWidget(1, 1, ctp_tx_fornecedor);

        grid.setWidget(2, 0, new LabelField("Documento:"));
        grid.setWidget(2, 1, ctp_nr_documento);
        left.add(grid, new FormData("100%"));

        grid.setWidget(3, 0, new LabelField("valor:"));
        grid.setWidget(3, 1, ctp_nr_valor);

        container.add(left, new ColumnData(300));
        fp.add(container);

        return fp;
    }

    public void load(Ctp_conta_pagarTGWT ctp_conta_pagarTGWT) {
        try {
            this.ctp_conta_pagarTGWT = ctp_conta_pagarTGWT;
            ctp_dt_vencimento.setValue(ctp_conta_pagarTGWT.getCtp_dt_vencimento());
            ctp_nr_documento.setValue(ctp_conta_pagarTGWT.getCtp_nr_documento());
            ctp_nr_valor.setValue(ctp_conta_pagarTGWT.getCtp_nr_valor());
            ctp_tx_fornecedor.setValue(ctp_conta_pagarTGWT.getCtp_tx_fornecedor());
            ctp_tx_obs.setValue(ctp_conta_pagarTGWT.getCtp_tx_obs());

        } catch (Exception ex) {
        }
    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        if (valido()) {
            btnAltAction(ce);
        }
    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    public boolean valido() {
        boolean result = true;
        if (listMes.getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo mês tem preenchimento obrigatório");
        } else if (ctp_nr_valor.getValue().doubleValue() == 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo valor tem preenchimento obrigatório");
        } else if (listObra.getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo obra tem preenchimento obrigatório");
        } else if (listAno.getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo ano tem preenchimento obrigatório");
        } 
        return result;
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("ctp_conta_pagarT.ctp_nr_id", ctp_conta_pagarTGWT.getCtp_nr_id() + "");
            param.put("ctp_conta_pagarT.ctp_tx_fornecedor", comboFornec.getValue()!= null ? comboFornec.getValue().getFor_tx_nome():ctp_conta_pagarTGWT.getCtp_tx_fornecedor());
            param.put("ctp_conta_pagarT.ctp_nr_mes", listMes.getValue().getValue() + "");
            param.put("ctp_conta_pagarT.plc_nr_id", listClasse.getValue().getPlc_nr_id() + "");
            param.put("ctp_conta_pagarT.ctp_nr_valor", ctp_nr_valor.getValue().doubleValue() + "");
            param.put("ctp_conta_pagarT.ctp_nr_documento", ctp_nr_documento.getValue());
            param.put("ctp_conta_pagarT.ctp_tx_status", ctp_tx_status.getValue());
            param.put("ctp_conta_pagarT.ctp_dt_vencimento", DateTimeFormat.getFormat("dd/MM/yyyy").format(ctp_dt_vencimento.getValue()));
            param.put("ctp_conta_pagarT.obr_nr_id", listObra.getValue().getObr_nr_id() + "");
            param.put("ctp_conta_pagarT.ctp_tx_obs", ctp_tx_obs.getValue() + "");
            param.put("ctp_conta_pagarT.ctp_nr_ano", listAno.getValue().getValue() + "");

            ctp_conta_pagarTGWT.setCtp_tx_fornecedor(comboFornec.getValue()!= null ? comboFornec.getValue().getFor_tx_nome():ctp_conta_pagarTGWT.getCtp_tx_fornecedor());
            ctp_conta_pagarTGWT.setCtp_nr_mes(listMes.getValue().getValue());
            ctp_conta_pagarTGWT.setCtp_nr_ano(listAno.getValue().getValue());
            ctp_conta_pagarTGWT.setPlc_nr_id(listClasse.getValue().getPlc_nr_id());
            ctp_conta_pagarTGWT.setCtp_nr_valor(ctp_nr_valor.getValue().floatValue());
            ctp_conta_pagarTGWT.setCtp_nr_documento(ctp_nr_documento.getValue());
            ctp_conta_pagarTGWT.setCtp_dt_vencimento(ctp_dt_vencimento.getValue());
            ctp_conta_pagarTGWT.setObr_nr_id(listObra.getValue().getObr_nr_id());


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);

        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("ctp_conta_pagarT.ctp_nr_id", ctp_conta_pagarTGWT.getCtp_nr_id() + "");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String msg = EasyContainer.clearAspas(resultado.get("msg").toString());
            if (msg.trim().length() > 0) {
                String resposta = msg.substring(msg.length() - 9, msg.length()).trim();
                if (resposta.equalsIgnoreCase("sucesso!")) {
                    getShowMsgAlteracao();
                    if (getAnaliticoFinanceiroContasPagasGWT() == null) {
                        consultGWT.store.update(ctp_conta_pagarTGWT);
                        //consultGWT.load();
                    }else{
                        getAnaliticoFinanceiroContasPagasGWT().store.update(ctp_conta_pagarTGWT);
                        //getAnaliticoFinanceiroContasPagasGWT().load();
                    }
                    this.close();
                } else {
                    getMbMaster().alert("IMPORTANTE", msg, null);
                }
            }
        }
    }

    /**
     * @return the consultGWT
     */
    public Ctp_conta_pagarConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ctp_conta_pagarConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    /**
     * @return the analiticoFinanceiroContasPagasGWT
     */
    public AnaliticoFinanceiroContasPagasGWT getAnaliticoFinanceiroContasPagasGWT() {
        return analiticoFinanceiroContasPagasGWT;
    }
 
    /**
     * @param analiticoFinanceiroContasPagasGWT the analiticoFinanceiroContasPagasGWT to set
     */
    public void setAnaliticoFinanceiroContasPagasGWT(AnaliticoFinanceiroContasPagasGWT analiticoFinanceiroContasPagasGWT) {
        this.analiticoFinanceiroContasPagasGWT = analiticoFinanceiroContasPagasGWT;
    }
}

