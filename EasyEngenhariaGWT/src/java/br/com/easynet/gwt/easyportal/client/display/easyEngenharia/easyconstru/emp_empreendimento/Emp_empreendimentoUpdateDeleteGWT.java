/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.emp_empreendimento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListUF;
import br.com.easynet.gwt.easyportal.client.UFTGWT;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cli_cliente.ListClienteGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.user.client.ui.ListBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.List;

/** 
 *
 * @author geoleite
 */
public class Emp_empreendimentoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoUpdateDeleteGWT.jsp";
    
    private TextField<String> emp_nr_id = new TextField<String>();
    private TextField<String> emp_tx_nome = new TextField<String>();
    private TextField<String> emp_tx_endereco = new TextField<String>();
    private TextField<String> emp_tx_bairro = new TextField<String>();
    private TextField<String> emp_tx_cidade = new TextField<String>();
    private ListBox emp_tx_uf = new ListBox();
    private ListBox cli_nr_id = new ListBox();
    private Emp_empreendimentoTGWT emp_empreendimentoTGWT = new Emp_empreendimentoTGWT();
    private Emp_empreendimentoConsultGWT consultGWT = new Emp_empreendimentoConsultGWT();
    private ComboBox<Cli_clienteTGWT> comboCli = new ComboBox<Cli_clienteTGWT>();
    private ComboBox<UFTGWT> comboUF = new ComboBox<UFTGWT>();
    private ListClienteGWT listClienteGWT = new ListClienteGWT();
    private ListUF listUF = new ListUF();
    private FormPanel formSubmit = new FormPanel();
    private FileUploadField fileupload = new FileUploadField();
    private MessageBox mb;

    public Emp_empreendimentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Emp_empreendimentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public void addListUF() {
        ListStore<UFTGWT> storeUF = new ListStore<UFTGWT>();
        storeUF.add(listUF.getList());
        comboUF.setStore(storeUF);
        comboUF.setDisplayField("display");
        comboUF.setAllowBlank(false);
        comboUF.setTriggerAction(ComboBox.TriggerAction.ALL);
        if (emp_empreendimentoTGWT != null) {
            comboUF.setValue(listUF.getTreeUF().get(emp_empreendimentoTGWT.getEmp_tx_uf()));
        }

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
            if (emp_empreendimentoTGWT != null) {
                comboCli.setValue(listClienteGWT.getTreeCliente().get(emp_empreendimentoTGWT.getCli_nr_id()));
            }

        } catch (Exception e) {
        }
    }

    public Emp_empreendimentoUpdateDeleteGWT() {
        this.setSize("560", "280");
        this.setHeading("Alterar Empreendimentos");
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
                mb = MessageBox.progress("Atualizando Empreendimento", "Requisitando o servidor!", "");
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
                    Grid grid = new Grid(7, 2);

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
                    fileupload.setWidth(300);
                    fileupload.setName("emp_empreendimentoT.emp_bt_logo");

                    formSubmit.add(grid);
                    layout();

                }
            }
        };
        timer.schedule(500);

    }

    public void load(Emp_empreendimentoTGWT emp_empreendimentoTGWT) {
        try {
            this.emp_empreendimentoTGWT = emp_empreendimentoTGWT;
            this.emp_nr_id.setValue(emp_empreendimentoTGWT.getEmp_nr_id() + "");
            this.emp_tx_nome.setValue(emp_empreendimentoTGWT.getEmp_tx_nome() + "");
            this.emp_tx_endereco.setValue(emp_empreendimentoTGWT.getEmp_tx_endereco() + "");
            this.emp_tx_bairro.setValue(emp_empreendimentoTGWT.getEmp_tx_bairro() + "");
            this.emp_tx_cidade.setValue(emp_empreendimentoTGWT.getEmp_tx_cidade() + "");
            comboUF.setValue(listUF.getTreeUF().get(emp_empreendimentoTGWT.getEmp_tx_uf()));
            comboCli.setValue(listClienteGWT.getTreeCliente().get(emp_empreendimentoTGWT.getCli_nr_id()));
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
        if (emp_tx_nome.getValue().trim().length() == 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo empreendimento tem preenchimento obrigatório");
        } else if (comboCli.getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo cliente tem preenchimento obrigatório");
        }

        return result;
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            HiddenField<String> hfop = new HiddenField<String>();
            hfop.setName("op");
            hfop.setValue("update");
            formSubmit.add(hfop);

            HiddenField<String> hfid = new HiddenField<String>();
            hfid.setName("emp_empreendimentoT.emp_nr_id");
            hfid.setValue(emp_empreendimentoTGWT.getEmp_nr_id() + "");
            formSubmit.add(hfid);

            HiddenField<String> hf = new HiddenField<String>();
            hf.setName("emp_empreendimentoT.emp_tx_uf");
            hf.setValue(comboUF.getValue().getValue());
            formSubmit.add(hf);
            hf = new HiddenField<String>();
            hf.setName("emp_empreendimentoT.cli_nr_id");
            hf.setValue(comboCli.getValue().getCli_nr_id() + "");
            formSubmit.add(hf);

            formSubmit.layout();

            formSubmit.submit();
           
            Window.alert(formSubmit.getAction()+formSubmit.getFields());


        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("emp_empreendimentoT.emp_nr_id", emp_nr_id.getValue());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    @Override
    public void btnClearAction(ButtonEvent ce) {
        List<Component> list = getCpMaster().getItems();
        for (Component component : list) {
            if (component instanceof NumberField) {
                NumberField comp = (NumberField) component;
                comp.setValue(null);
            } else if (component instanceof ComboBox) {
                ComboBox comp = (ComboBox) component;
                comp.setValue(null);
            } else if (component instanceof FileUploadField) {
                FileUploadField comp = (FileUploadField) component;
                comp.setValue("");
            } else if (component instanceof com.extjs.gxt.ui.client.widget.form.TextField) {
                com.extjs.gxt.ui.client.widget.form.TextField comp = (com.extjs.gxt.ui.client.widget.form.TextField) component;
            }
        }

    }

    public void read(JSONValue jsonValue) {
        mb.close();
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String msg = EasyContainer.clearAspas(resultado.get("msg").toString());
            if (msg.trim().length() > 0) {
                if (msg.indexOf("sucesso") > -1) {
                    getShowMsgAlteracao();
                    consultGWT.load();
                    this.close();
                } else {
                    MessageBox mb = new MessageBox();
                    mb.alert("", msg, null);
                }
            }

        }

    }
}
