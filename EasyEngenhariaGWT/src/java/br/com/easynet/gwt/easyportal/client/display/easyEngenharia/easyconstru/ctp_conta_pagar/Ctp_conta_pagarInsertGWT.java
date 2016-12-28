/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.for_fornecedor.ListFornecedorGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.AnaliticoFinanceiroContasPagasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.For_fornecedorTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Ctp_conta_pagarInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarInsertGWT.jsp";
    private Ctp_conta_pagarConsultGWT consultGWT;
    private AnaliticoFinanceiroContasPagasGWT financeiroContasPagasGWT;

    public Ctp_conta_pagarConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ctp_conta_pagarConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> ctp_nr_id = new TextField<String>();
    private TextField<String> for_nr_id = new TextField<String>();
    private TextField<String> ctp_nr_mes = new TextField<String>();
    private TextField<String> plc_nr_id = new TextField<String>();
    private NumberField ctp_nr_valor = new NumberField();
    private TextField<String> ctp_nr_documento = new TextField<String>();
    private TextField<String> ctp_tx_status = new TextField<String>();
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
    private ComboBox<For_fornecedorTGWT> comboFornec = new ComboBox<For_fornecedorTGWT>();
    private ListFornecedorGWT listFornecedorGWT = new ListFornecedorGWT();
    private ListStore<For_fornecedorTGWT> storeFor = new ListStore<For_fornecedorTGWT>();
    private TextField<String> tx_locFor = new TextField<String>();

    public Ctp_conta_pagarInsertGWT(String status) {

        this.status = status;
        consultGWT = new Ctp_conta_pagarConsultGWT(status);

        this.setHeading(status.equalsIgnoreCase("A") ? "Cadastro Contas a pagar" : "Cadastro Contas pagas");
        this.ctp_tx_status.setValue(status);
        addListFornec();

        this.setSize(550, 280);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        cpConteudo.setLayout(layout);
        cpConteudo.setHeaderVisible(false);
        if ("A".equalsIgnoreCase(status)) {
            btnLimpartAction(null);
        }

    }

    public void insertFornecedor() {
    }

    @Override
    public void show() {
        addListMes();
        addListAno();
        Ctp_conta_pagarInsertGWT.super.show();
        addToolbarOperacao();

        cpConteudo.add(new LabelField("Sub Classe:"));
        cpConteudo.add(getListClasse());
        cpConteudo.add(new LabelField("Fornecedor:"));
        ContentPanel cp = new ContentPanel(new TableLayout(2));
        cp.setHeaderVisible(false);
        cp.setBodyBorder(false);
        cp.add(getTx_locFor());
        getTx_locFor().setWidth(90);
        cp.add(comboFornec);


        cpConteudo.add(cp);
        ctp_tx_fornecedor.setWidth(300);
        cpConteudo.add(new LabelField("Documento:"));
        cpConteudo.add(getCtp_nr_documento());
        cpConteudo.add(new LabelField("Vencimento:"));
        cpConteudo.add(getCtp_dt_vencimento());
        cpConteudo.add(new LabelField("Valor:"));
        cpConteudo.add(ctp_nr_valor);
        getCpMaster().add(cpConteudo);
        layout();
    }
//99719398

    public void addListFornec() {
        comboFornec.setDisplayField("for_tx_nome");
        comboFornec.setTypeAhead(true);
        comboFornec.setAllowBlank(false);
        comboFornec.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboFornec.setWidth("280");
        KeyListener kl = new KeyListener() {
            @Override
            public void componentKeyPress(ComponentEvent event) {
                if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
                    consultarFornecedor();
                }
            }
        };
        getTx_locFor().setToolTip("Digite parte do nome do fornecedor para filtrar");
        getTx_locFor().addKeyListener(kl);
    }

    public void consultarFornecedor() {
        listFornecedorGWT.consultbyName(getTx_locFor().getValue());
        Timer timer = new Timer() {
            @Override
            public void run() {
                if (!listFornecedorGWT.inserido) {
                    schedule(100);
                } else {
                    storeFor = listFornecedorGWT.getStore();
                    comboFornec.setStore(storeFor);
                    comboFornec.getListView().setStore(storeFor);
                    comboFornec.getListView().refresh();
                    comboFornec.focus();
                    comboFornec.expand();
                }
            }
        };
        timer.schedule(10);
    }

    public void addListMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        getListMes().setStore(store);
        getListMes().setDisplayField("display");
        getListMes().setAllowBlank(false);
        getListMes().setTriggerAction(ComboBox.TriggerAction.ALL);
        getListMes().setWidth("100");
    }

    public void addlistObra(ListStore<Obr_obrasTGWT> list) {
        try {
            getListObra().setStore(list);
            getListObra().setDisplayField("obr_tx_nome");
            getListObra().setAllowBlank(false);
            getListObra().setTriggerAction(ComboBox.TriggerAction.ALL);
            getListObra().setWidth("220");

        } catch (Exception e) {
        }
    }

    public void addLisClasse(ListStore<Plc_plano_contasTGWT> store) {
        try {

            getListClasse().setStore(store);
            getListClasse().setAllowBlank(false);
            getListClasse().setDisplayField("plc_tx_nome");
            getListClasse().setTriggerAction(ComboBox.TriggerAction.ALL);
            getListClasse().setWidth("300");
            getListClasse().getListView().refresh();

        } catch (Exception e) {
        }
    }

    public void setClasse(final int plc_nr_id) {

        listPlc_planoContasGWT.povoa();
        Timer timer = new Timer() {
            @Override
            public void run() {
                Info.display("", "");
                if (!listPlc_planoContasGWT.isInserido()) {
                    schedule(300);
                } else {
                    //listClasse = new ComboBox<Plc_plano_contasTGWT>();                          
                   listClasse.setStore(listPlc_planoContasGWT.getStore());
                    //listClasse.getListView().refresh();
                    Plc_plano_contasTGWT plc_T = listClasse.getStore().findModel("plc_nr_id", plc_nr_id);
                    listClasse.setValue(plc_T);
                    layout();
                }
            }
        };
        timer.schedule(100);



    }

    public void addListAno() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMes_AnoGWT.getListAno());
        getListAno().setStore(store);
        getListAno().setDisplayField("display");
        getListAno().setAllowBlank(false);
        getListAno().setTriggerAction(ComboBox.TriggerAction.ALL);
        getListAno().setWidth(70);
    }

    public void setConfigForm(FormPanel form) {
        form.setFrame(true);
        form.setIconStyle("icon-form");
        form.setCollapsible(true);
        form.setSize(420, -4);
        //form.setButtonAlign(HorizontalAlignment.CENTER);
        form.setLayout(new FlowLayout());
        form.setLabelAlign(FormPanel.LabelAlign.TOP);
    }

    public void addToolbarOperacao() {
        //barOperacao.removeAll();
        barOperacao.add(new LabelToolItem("Obra:"));
        barOperacao.add(getListObra());
        barOperacao.add(new LabelToolItem("Mês:"));
        barOperacao.add(getListMes());
        barOperacao.add(new LabelToolItem("Ano:"));
        barOperacao.add(getListAno());
        cpConteudo.setTopComponent(barOperacao);

    }

    public boolean valido() {
        boolean result = true;
        if (getListMes().getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo mês tem preenchimento obrigatório");
        } else if (ctp_nr_valor.getValue().floatValue() == 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo valor tem preenchimento obrigatório");
        } else if (getListObra().getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo obra tem preenchimento obrigatório");
        } else if (getListAno().getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo ano tem preenchimento obrigatório");
        } else if (comboFornec.getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo fornecedor tem preenchimento obrigatório");
        }
        return result;
    }

    @Override
    public void btnLimpartAction(ButtonEvent ce) {
        getListClasse().setValue(null);
        getCtp_dt_vencimento().setValue(null);
        ctp_nr_valor.setValue(null);
        getCtp_nr_documento().setValue("");
        comboFornec.setValue(null);
    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        if (valido()) {
            btnCadAction(ce);
        }
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();

            param.put("op", "insert");
            //param.put("ctp_conta_pagarT.ctp_nr_id", ctp_nr_id.getValue());

            param.put("ctp_conta_pagarT.ctp_tx_fornecedor", this.comboFornec.getValue().getFor_tx_nome());

            param.put("ctp_conta_pagarT.ctp_nr_mes", getListMes().getValue().getValue() + "");

            param.put("ctp_conta_pagarT.plc_nr_id", getListClasse().getValue().getPlc_nr_id() + "");
            String valor = ctp_nr_valor.getValue().doubleValue() + "";

            param.put("ctp_conta_pagarT.ctp_nr_valor", valor);

            param.put("ctp_conta_pagarT.ctp_nr_documento", getCtp_nr_documento().getValue());

            param.put("ctp_conta_pagarT.ctp_tx_status", this.getStatus());

            param.put("ctp_conta_pagarT.ctp_dt_vencimento", DateTimeFormat.getFormat("dd/MM/yyyy").format(getCtp_dt_vencimento().getValue()));

            param.put("ctp_conta_pagarT.obr_nr_id", getListObra().getValue().getObr_nr_id() + "");

            param.put("ctp_conta_pagarT.ctp_nr_ano", getListAno().getValue().getValue() + "");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);

        } catch (Exception ex) {
        }
    }
    //9955-3100- paulo

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                getMbMaster().alert("IMPORTANTE", "Cadastro efetuado com sucesso!", null);
                btnLimpartAction(null);
                if (consultGWT != null) {
                    consultGWT.load();
                } else {
                    financeiroContasPagasGWT.load();
                }
            } else {
                getShowMsgErro(jsonObject.get("resultado").toString());
            }
        }
    }

    /**
     * @return the listObra
     */
    public ComboBox<Obr_obrasTGWT> getListObra() {
        return listObra;
    }

    /**
     * @param listObra the listObra to set
     */
    public void setListObra(ComboBox<Obr_obrasTGWT> listObra) {
        this.setListObra(listObra);
    }

    /**
     * @return the listObraGWT
     */
    public ListObraGWT getListObraGWT() {
        return listObraGWT;
    }

    /**
     * @param listObraGWT the listObraGWT to set
     */
    public void setListObraGWT(ListObraGWT listObraGWT) {
        this.listObraGWT = listObraGWT;
    }

    /**
     * @return the financeiroContasPagasGWT
     */
    public AnaliticoFinanceiroContasPagasGWT getFinanceiroContasPagasGWT() {
        return financeiroContasPagasGWT;
    }

    /**
     * @param financeiroContasPagasGWT the financeiroContasPagasGWT to set
     */
    public void setFinanceiroContasPagasGWT(AnaliticoFinanceiroContasPagasGWT financeiroContasPagasGWT) {
        this.financeiroContasPagasGWT = financeiroContasPagasGWT;
    }

    /**
     * @return the tx_locFor
     */
    public TextField<String> getTx_locFor() {
        return tx_locFor;
    }

    /**
     * @param tx_locFor the tx_locFor to set
     */
    public void setTx_locFor(TextField<String> tx_locFor) {
        this.tx_locFor = tx_locFor;
    }

    /**
     * @return the ctp_nr_documento
     */
    public TextField<String> getCtp_nr_documento() {
        return ctp_nr_documento;
    }

    /**
     * @param ctp_nr_documento the ctp_nr_documento to set
     */
    public void setCtp_nr_documento(TextField<String> ctp_nr_documento) {
        this.ctp_nr_documento = ctp_nr_documento;
    }

    /**
     * @return the listAno
     */
    public ComboBox<Ano> getListAno() {
        return listAno;
    }

    /**
     * @return the listClasse
     */
    public ComboBox<Plc_plano_contasTGWT> getListClasse() {
        return listClasse;
    }

    /**
     * @param listClasse the listClasse to set
     */
    public void setListClasse(ComboBox<Plc_plano_contasTGWT> listClasse) {
        this.listClasse = listClasse;
    }

    /**
     * @return the listMes
     */
    public ComboBox<Meses> getListMes() {
        return listMes;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the ctp_dt_vencimento
     */
    public DateField getCtp_dt_vencimento() {
        return ctp_dt_vencimento;
    }

    /**
     * @param ctp_dt_vencimento the ctp_dt_vencimento to set
     */
    public void setCtp_dt_vencimento(DateField ctp_dt_vencimento) {
        this.ctp_dt_vencimento = ctp_dt_vencimento;
    }
}
