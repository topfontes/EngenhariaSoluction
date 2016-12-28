/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cli_cliente;

import br.com.easynet.gwt.easyportal.client.ComboboxGeneric;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListUF;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;



import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class Cli_clienteUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDeleteGWT.jsp";
    private TextField<String> cli_nr_id = new TextField<String>();
    private TextField<String> cli_tx_nome = new TextField<String>();
    private ListBox cli_tx_tipo_pessoa = new ListBox();
    private NumberField cli_tx_cnpj_cpf = new NumberField();
    private TextField<String> cli_tx_endereco = new TextField<String>();
    private TextField<String> cli_tx_bairro = new TextField<String>();
    private TextField<String> cli_tx_cidade = new TextField<String>();
    private NumberField cli_tx_telefone = new NumberField();
    private NumberField cli_tx_fax = new NumberField();
    private NumberField cli_tx_telefone2 = new NumberField();
    private FileUploadField cli_by_logomarca = new FileUploadField();
    private ListBox cli_tx_uf = new ListBox();
    private TextField<String> cli_tx_email = new TextField<String>();
    private Cli_clienteTGWT cli_clienteTGWT = new Cli_clienteTGWT();
    private Cli_clienteConsultGWT consultGWT = new Cli_clienteConsultGWT();
    private FormPanel formSubmit = new FormPanel();
    private Image logo = new Image();
    private NumberField cli_tx_inscricao = new NumberField();
    private TextField<String> cli_tx_contato = new TextField<String>();
    private NumberField cli_tx_celular = new NumberField();
    private TextField<String> cli_tx_letra = new TextField<String>();

    public Cli_clienteConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void addListTipoPessoa() {
        String[] value = {"F", "J"};
        String[] Display = {"Fisica", "Juridica"};
        ComboboxGeneric generic = new ComboboxGeneric(value, Display);
        generic.setListBox(cli_tx_tipo_pessoa);
        generic.getResult();
    }

    public void addListUF() {
        ListUF listUF = new ListUF();
        ComboboxGeneric generic = new ComboboxGeneric(listUF.getValor(), listUF.getValor());
        generic.setListBox(cli_tx_uf);
        generic.getResult();
    }

    public void setConsultGWT(Cli_clienteConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Cli_clienteUpdateDeleteGWT(int id) {

        formSubmit.setHeaderVisible(false);
        this.setHeading("Alterar Clientes");
        this.setSize("610", "530");

        TableLayout layout = new TableLayout(2);
        layout.setCellSpacing(3);
        formSubmit.setLayout(layout);

//        formSubmit.add(new LabelField("id:"));
//        cli_nr_id.setName("cli_clienteT.cli_nr_id");
//        formSubmit.add(cli_nr_id);
//        cli_tx_nome.setWidth("100");


        formSubmit.add(new LabelField("Nome:"));
        cli_tx_nome.setName("cli_clienteT.cli_tx_nome");
        formSubmit.add(cli_tx_nome);
        cli_tx_nome.setWidth("400");
        cli_tx_nome.setAllowBlank(false);

        formSubmit.add(new LabelField("Pessoa:"));
        formSubmit.add(cli_tx_tipo_pessoa);
        cli_tx_tipo_pessoa.setName("cli_clienteT.cli_tx_tipo_pessoa");

        formSubmit.add(new LabelField("CPF/CNPJ:"));
        formSubmit.add(cli_tx_cnpj_cpf);
        cli_tx_cnpj_cpf.setName("cli_clienteT.cli_tx_cnpj_cpf");
        cli_tx_cnpj_cpf.setMaxLength(14);
        cli_tx_cnpj_cpf.setAllowBlank(false);

        formSubmit.add(new LabelField("Inscrição Estadual:"));
        formSubmit.add(cli_tx_inscricao);
        cli_tx_inscricao.setName("cli_clienteT.cli_tx_inscricao_estatual");
        cli_tx_inscricao.setMaxLength(14);
        cli_tx_inscricao.setAllowBlank(false);

        formSubmit.add(new LabelField("Endereço:"));
        formSubmit.add(cli_tx_endereco);
        cli_tx_endereco.setName("cli_clienteT.cli_tx_endereco");
        cli_tx_endereco.setWidth("400");
        cli_tx_endereco.setAllowBlank(false);

        formSubmit.add(new LabelField("Bairro:"));
        formSubmit.add(cli_tx_bairro);
        cli_tx_bairro.setName("cli_clienteT.cli_tx_bairro");
        cli_tx_bairro.setWidth("400");
        cli_tx_bairro.setAllowBlank(false);

        formSubmit.add(new LabelField("Cidade:"));
        formSubmit.add(cli_tx_cidade);
        cli_tx_cidade.setName("cli_clienteT.cli_tx_cidade");
        cli_tx_cidade.setWidth("400");
        cli_tx_cidade.setAllowBlank(false);

        formSubmit.add(new LabelField("UF:"));
        formSubmit.add(cli_tx_uf);
        cli_tx_uf.setName("cli_clienteT.cli_tx_uf");
        cli_tx_uf.setWidth("70");

        formSubmit.add(new LabelField("Telefone:"));
        formSubmit.add(cli_tx_telefone);
        cli_tx_telefone.setName("cli_clienteT.cli_tx_telefone");
        cli_tx_telefone.setMaxLength(10);
        cli_tx_telefone.setAllowBlank(false);

        formSubmit.add(new LabelField("Telefone 2:"));
        formSubmit.add(cli_tx_telefone2);
        cli_tx_telefone2.setName("cli_clienteT.cli_tx_telefone2");
        cli_tx_fax.setMaxLength(11);

        formSubmit.add(new LabelField("Fax:"));
        formSubmit.add(cli_tx_fax);
        cli_tx_fax.setName("cli_clienteT.cli_tx_fax");
        cli_tx_telefone2.setMaxLength(11);

        formSubmit.add(new LabelField("Logomarca:"));
        formSubmit.add(cli_by_logomarca);
        cli_by_logomarca.setName("cli_clienteT.cli_by_logomarca");
        cli_by_logomarca.setAllowBlank(true);
        cli_by_logomarca.setWidth("400");

        formSubmit.add(new LabelField("Email:"));
        formSubmit.add(cli_tx_email);
        cli_tx_email.setName("cli_clienteT.cli_tx_email");
        cli_tx_email.setWidth("400");

        formSubmit.add(new LabelField("Contato:"));
        formSubmit.add(cli_tx_contato);
        cli_tx_contato.setName("cli_clienteT.cli_tx_contato");
        cli_tx_contato.setWidth("400");

        formSubmit.add(new LabelField("Celular Contato:"));
        formSubmit.add(cli_tx_celular);
        cli_tx_celular.setName("cli_clienteT.cli_tx_celular");

        cli_tx_letra.setMaxLength(1);
        formSubmit.add(new LabelField("Letra Cód. Orcamento Externo:"));
        cli_tx_letra.setWidth(50);
//        cli_tx_letra.setEnabled(false);
        formSubmit.add(cli_tx_letra);
        cli_tx_letra.setName("cli_clienteT.cli_tx_letra_orcamento_externo");

        HiddenField<String> hfOp = new HiddenField<String>();
        hfOp.setName("op");
        hfOp.setValue("update");
        formSubmit.add(hfOp);

        hfOp = new HiddenField<String>();
        hfOp.setName("cli_clienteT.cli_nr_id");
        hfOp.setValue(id + "");
        formSubmit.add(hfOp);

        addListTipoPessoa();
        addListUF();
        formSubmit.setAction(Constantes.URL + PAGE);
        formSubmit.setEncoding(FormPanel.Encoding.MULTIPART);
        formSubmit.setMethod(FormPanel.Method.POST);
        formSubmit.setFrame(true);

        getCpMaster().add(formSubmit);
        formSubmit.addListener(Events.Submit, new Listener<FormEvent>() {

            public void handleEvent(FormEvent be) {
                JSONValue jsonValue = JSONParser.parse(be.getResultHtml());
                read(jsonValue);
                for (int i = 0; i < formSubmit.getItemCount(); i++) {
                    formSubmit.getItems().get(i).clearState();
                }
            }
        });
    }

    public void load(Cli_clienteTGWT cli_clienteTGWT) {
        try {
            this.cli_clienteTGWT = cli_clienteTGWT;
            this.cli_nr_id.setValue(cli_clienteTGWT.getCli_nr_id() + "");
            this.cli_tx_nome.setValue(cli_clienteTGWT.getCli_tx_nome() + "");

            this.cli_tx_tipo_pessoa.setSelectedIndex(getkeyValue(this.cli_tx_tipo_pessoa, cli_clienteTGWT.getCli_tx_tipo_pessoa()));

            this.cli_tx_cnpj_cpf.setValue(Float.parseFloat(cli_clienteTGWT.getCli_tx_cnpj_cpf()));

            this.cli_tx_endereco.setValue(cli_clienteTGWT.getCli_tx_endereco() + "");
            this.cli_tx_bairro.setValue(cli_clienteTGWT.getCli_tx_bairro() + "");
            this.cli_tx_cidade.setValue(cli_clienteTGWT.getCli_tx_cidade() + "");

            if (cli_clienteTGWT.getCli_tx_telefone().trim().length() > 0) {
                this.cli_tx_telefone.setValue(Float.parseFloat(cli_clienteTGWT.getCli_tx_telefone()));
            }
            if (cli_clienteTGWT.getCli_tx_telefone2().trim().length() > 0) {
                this.cli_tx_telefone2.setValue(Float.parseFloat(cli_clienteTGWT.getCli_tx_telefone2()));
            }
            if (cli_clienteTGWT.getCli_tx_fax().trim().length() > 0) {
                this.cli_tx_fax.setValue(Float.parseFloat(cli_clienteTGWT.getCli_tx_fax()));
            }
            if (cli_clienteTGWT.getCli_tx_telefone2().trim().length() > 0) {
                this.cli_tx_telefone2.setValue(Float.parseFloat(cli_clienteTGWT.getCli_tx_telefone2()));
            }
            this.cli_tx_email.setValue(cli_clienteTGWT.getCli_tx_email());
            if (cli_clienteTGWT.getCli_tx_inscricao_estatual().trim().length() > 0) {
                this.cli_tx_inscricao.setValue(Float.parseFloat(cli_clienteTGWT.getCli_tx_inscricao_estatual()));
            }
            this.cli_tx_contato.setValue(cli_clienteTGWT.getCli_tx_contato());
            if (cli_clienteTGWT.getcli_tx_celular() != null & cli_clienteTGWT.getcli_tx_celular().trim().length() > 0) {
                this.cli_tx_celular.setValue(Float.parseFloat(cli_clienteTGWT.getcli_tx_celular()));
            }
            this.cli_tx_letra.setValue(cli_clienteTGWT.getCli_tx_letra_orcamento_externo());
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

    private void enviar(final FormPanel fp) {

        fp.submit();
    }

    private void btnAltAction(ButtonEvent sender) {
        enviar(formSubmit);
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
//            url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("cli_clienteT.cli_nr_id", cli_clienteTGWT.getCli_nr_id() + "");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public boolean valido() {
        boolean result = true;
        //com.google.gwt.user.client.Window.alert(" " + cli_tx_nome.getValue().trim().length());
        if (cli_tx_nome.getValue().trim().length() == 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo nome tem preenchimento obrigatório");
        }
        return result;
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                getShowMsgAlteracao();
                this.close();
                consultGWT.load();
            } else {
                getShowMsgErro(jsonObject.get("resultado").toString());
            }
        }

    }
}
