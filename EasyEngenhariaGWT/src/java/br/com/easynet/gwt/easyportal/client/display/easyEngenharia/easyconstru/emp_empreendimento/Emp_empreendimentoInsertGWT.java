/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.emp_empreendimento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.ComboboxGeneric;
import br.com.easynet.gwt.easyportal.client.ListUF;
import br.com.easynet.gwt.easyportal.client.UFTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cli_cliente.Cli_clienteConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cli_cliente.ListClienteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Cli_clienteTGWT;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class Emp_empreendimentoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoInsertGWT.jsp";
    private Emp_empreendimentoConsultGWT consultGWT = new Emp_empreendimentoConsultGWT();

    public Emp_empreendimentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Emp_empreendimentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> emp_nr_id = new TextField<String>();
    private TextField<String> emp_tx_nome = new TextField<String>();
    private TextField<String> emp_tx_endereco = new TextField<String>();
    private TextField<String> emp_tx_bairro = new TextField<String>();
    private TextField<String> emp_tx_cidade = new TextField<String>();
    private ListBox emp_tx_uf = new ListBox();
    private ListBox cli_nr_id = new ListBox();
    private ComboBox<Cli_clienteTGWT> comboCli = new ComboBox<Cli_clienteTGWT>();
    private ComboBox<UFTGWT> comboUF = new ComboBox<UFTGWT>();
    private ListClienteGWT listClienteGWT = new ListClienteGWT();
    private ListUF listUF = new ListUF();
    private FormPanel formSubmit = new FormPanel();
    private FileUploadField fileupload = new FileUploadField();
    private MessageBox mb;


    public void addListUF() {
        ListStore<UFTGWT> storeUF = new ListStore<UFTGWT>();
        storeUF.add(listUF.getList());
        comboUF.setStore(storeUF);
        comboUF.setDisplayField("display");
        comboUF.setAllowBlank(false);
        comboUF.setTriggerAction(ComboBox.TriggerAction.ALL);

    }

    public void addLisCliente() {
        try {
            ListStore<Cli_clienteTGWT> storeCli = new ListStore<Cli_clienteTGWT>();
            storeCli.add(listClienteGWT.getList());
            comboCli.setStore(storeCli);
            comboCli.setDisplayField("cli_tx_nome");
            comboCli.setAllowBlank(false);
            comboCli.setTriggerAction(ComboBox.TriggerAction.ALL);
            comboCli.setWidth(400);

        } catch (Exception e) {
        }
    }

    public Emp_empreendimentoInsertGWT() throws Exception {
        this.setHeading("Cadastro Empreendimento");
        this.setSize("560", "280");
        listUF.povoa();
        listClienteGWT.povoa();

        getCpMaster().setLayout(new FillLayout());
        getCpMaster().add(formSubmit);

        formSubmit.setHeaderVisible(false);
        formSubmit.setEncoding(FormPanel.Encoding.MULTIPART);
        formSubmit.setAction(Constantes.URL + PAGE);
        
        formSubmit.setMethod(FormPanel.Method.POST);
        formSubmit.addListener(Events.Submit, new Listener<FormEvent>() {

            public void handleEvent(FormEvent be) {
                mb = MessageBox.progress("Inserindo Empreendimento", "Requisitando o servidor!", "");
                JSONValue jSONValue = JSONParser.parse(be.getResultHtml());
                read(jSONValue);
            }
        });
        montarTela();
    }

    public void montarTela() {
        Timer timer = new Timer() {
            @Override
            public void run() {
                if (!listClienteGWT.povoado) {
                    schedule(500);
                } else {
                    addListUF();
                    addLisCliente();
                    Grid grid = new Grid(8, 2);

                    grid.setWidget(0, 0, new LabelField("Empreendimento:"));
                    grid.setWidget(0, 1, emp_tx_nome);
                    emp_tx_nome.setName("emp_empreendimentoT.emp_tx_nome");
                    emp_tx_nome.setWidth("400");
                    emp_tx_nome.setAllowBlank(false);

                    grid.setWidget(1, 0, new LabelField("Endereço:"));
                    grid.setWidget(1, 1, emp_tx_endereco);
                    emp_tx_endereco.setName("emp_empreendimentoT.emp_tx_endereco");
                    emp_tx_endereco.setWidth("400");
                    emp_tx_endereco.setAllowBlank(false);

                    grid.setWidget(2, 0, new LabelField("Bairro:"));
                    emp_tx_bairro.setName("emp_empreendimentoT.emp_tx_bairro");
                    grid.setWidget(2, 1, emp_tx_bairro);
                    emp_tx_bairro.setWidth("400");
                    emp_tx_bairro.setAllowBlank(false);

                    grid.setWidget(3, 0, new LabelField("Cidade:"));
                    emp_tx_cidade.setName("emp_empreendimentoT.emp_tx_cidade");
                    grid.setWidget(3, 1, emp_tx_cidade);
                    emp_tx_cidade.setWidth("400");
                    emp_tx_cidade.setAllowBlank(false);

                    grid.setWidget(4, 0, new LabelField("UF:"));
                    grid.setWidget(4, 1, comboUF);

                    grid.setWidget(5, 0, new LabelField("Cliente:"));
                    grid.setWidget(5, 1, comboCli);

                    grid.setWidget(6, 0, new LabelField("Logomarca:"));
                    grid.setWidget(6, 1, fileupload);
                    fileupload.setName("emp_empreendimentoT.emp_bt_logo");

                    formSubmit.add(grid);
                    layout();

                }
            }
        };
        timer.schedule(500);

    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        if (valido()) {
            btnCadAction(ce);
        }
    }

    public boolean valido() {
        boolean result = true;
        if (emp_tx_nome.getValue().trim().length() == 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo empreendimento tem preenchimento obrigatório");
        } else if (comboCli.getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo cliente tem preenchimento obrigatório");
        }

        return result;
    }

    @Override
    public void btnLimpartAction(ButtonEvent ce) {
        emp_tx_nome.setValue("");
        emp_tx_cidade.setValue("");
        emp_tx_bairro.setValue("");
        emp_tx_endereco.setValue("");
        emp_tx_cidade.setValue("");
        comboUF.setValue(null);
        comboCli.setValue(null);
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            HiddenField<String> hfop = new HiddenField<String>();
            hfop.setName("op");
            hfop.setValue("insert");
            formSubmit.add(hfop);
            HiddenField<String> hf = new HiddenField<String>();
            hf.setName("emp_empreendimentoT.emp_tx_uf");
            hf.setValue(comboUF.getValue().getValue());
            formSubmit.add(hf);
            hf = new HiddenField<String>();
            hf.setName("emp_empreendimentoT.cli_nr_id");
            hf.setValue(comboCli.getValue().getCli_nr_id()+"");
            formSubmit.add(hf);
            formSubmit.layout();
            formSubmit.submit();

        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        mb.close();
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                getShowMsgCadastro();
                consultGWT.load();
                btnLimpartAction(null);
            } else {
                getShowMsgErro(jsonObject.get("resultado").toString());
            }
        }

    }
}

