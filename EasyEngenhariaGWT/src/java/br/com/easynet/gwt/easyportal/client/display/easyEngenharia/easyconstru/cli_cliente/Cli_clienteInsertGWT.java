/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cli_cliente;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.ComboboxGeneric;
import br.com.easynet.gwt.easyportal.client.ListUF;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class Cli_clienteInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/cli_cliente/cli_clienteInsertGWT.jsp";
    private Cli_clienteConsultGWT consultGWT = new Cli_clienteConsultGWT();

    public Cli_clienteConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Cli_clienteConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
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
    private TextField<String> cli_tx_inscricao = new TextField<String>();
    private TextField<String> cli_tx_contato = new TextField<String>();
    private NumberField cli_tx_celular = new NumberField();
    private TextField<String> cli_tx_letra = new TextField<String>();
    private FormPanel formSubmit = new FormPanel();

    public void addListTipoPessoa() {
        String[] value = {"F", "J"};
        String[] Display = {"Física", "Jurídica"};
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

    public Cli_clienteInsertGWT() {
        formSubmit.setHeaderVisible(false);
        this.setHeading("Cadastrar Clientes");
        this.setSize("610", "530");

        TableLayout layout = new TableLayout(2);
        layout.setCellSpacing(3);
        formSubmit.setLayout(layout);

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
        formSubmit.add(cli_tx_letra);
        cli_tx_letra.setName("cli_clienteT.cli_tx_letra_orcamento_externo");

        HiddenField<String> hfOp = new HiddenField<String>();
        hfOp.setName("op");
        hfOp.setValue("insert");
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

    @Override
    public void btnLimpartAction(ButtonEvent ce) {
    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        if (valido()) {
            btnCadAction(ce);
        }
    }

    private void enviar(final FormPanel fp) {
        fp.submit();
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            enviar(formSubmit);
        } catch (Exception ex) {
        }
    }

    public boolean valido() {
        boolean result = true;
        if (cli_tx_nome.getValue().trim().length() == 0) {
            result = false;
            getMbMaster().alert("IMPORTANTE", "O campo nome tem preenchimento obrigatório", null);
        }
        return result;
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                getShowMsgCadastro();
                consultGWT.load();
                for (int i = 0; i < formSubmit.getItemCount(); i++) {
                    if (formSubmit.getItems().get(i) instanceof TextField) {
                        TextField<String> field = (TextField<String>) formSubmit.getItems().get(i);
                    }
                    if (formSubmit.getItems().get(i) instanceof NumberField) {
                        NumberField field = (NumberField) formSubmit.getItems().get(i);
                        field.setValue(null);
                    } else if (formSubmit.getItems().get(i) instanceof TextField) {
                        TextField<String> field = (TextField<String>) formSubmit.getItems().get(i);
                        field.setValue("");
                    }else if(formSubmit.getItems().get(i) instanceof FileUploadField){
                        FileUploadField file = (FileUploadField) formSubmit.getItems().get(i);
                        file.setValue("");
                    }
                }
            }else{
                getShowMsgErro(jsonObject.get("resultado").toString());
            }
        }
    }
}

