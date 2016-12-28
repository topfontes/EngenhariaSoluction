/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.for_fornecedor;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.ListUF;
import br.com.easynet.gwt.easyportal.client.UFTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class For_fornecedorInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/for_fornecedor/for_fornecedorInsertGWT.jsp";
    private For_fornecedorConsultGWT consultGWT = new For_fornecedorConsultGWT();

    public For_fornecedorConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(For_fornecedorConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> for_nr_id = new TextField<String>();
    private TextField<String> for_tx_nome = new TextField<String>();
    private NumberField for_tx_cnpj = new NumberField();
    private TextField<String> for_tx_endereco = new TextField<String>();
    private TextField<String> for_tx_bairro = new TextField<String>();
    private TextField<String> for_tx_cidade = new TextField<String>();
    private ListBox for_tx_uf = new ListBox();
    private TextField<String> for_tx_contato = new TextField<String>();
    private TextField<String> for_tx_telefone = new TextField<String>();
    private TextField<String> for_tx_email = new TextField<String>();
    private ComboBox<UFTGWT> comboUF = new ComboBox<UFTGWT>();
    ListUF listUF = new ListUF();

    public void addListBoxUF() {
        ListStore<UFTGWT> storeuf = new ListStore<UFTGWT>();
        storeuf.add(listUF.getList());
        comboUF.setStore(storeuf);
        comboUF.setDisplayField("display");
        comboUF.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public For_fornecedorInsertGWT() {
        this.setHeading("Cadastro Fornecedores");
        this.setSize("600", "350");
        listUF.povoa();
        montarTela();
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (listUF.getList() == null) {
                    schedule(500);
                } else {
                    Grid grid = new Grid(11, 2);

                    grid.setWidget(1, 0, new LabelField("Nome:"));
                    grid.setWidget(1, 1, for_tx_nome);
                    for_tx_nome.setWidth("400");
                    for_tx_nome.setAllowBlank(false);

                    grid.setWidget(2, 0, new LabelField("CNPJ/CPF:"));
                    grid.setWidget(2, 1, for_tx_cnpj);
                    for_tx_cnpj.setMaxLength(14);
                    for_tx_cnpj.setAllowBlank(true);

                    grid.setWidget(3, 0, new LabelField("Endereço:"));
                    grid.setWidget(3, 1, for_tx_endereco);
                    for_tx_endereco.setWidth("400");
                    for_tx_endereco.setMaxLength(100);
                    for_tx_endereco.setAllowBlank(true);

                    grid.setWidget(4, 0, new LabelField("Bairro:"));
                    grid.setWidget(4, 1, for_tx_bairro);
                    for_tx_bairro.setWidth("400");
                    for_tx_bairro.setAllowBlank(true);

                    grid.setWidget(5, 0, new LabelField("Cidade:"));
                    grid.setWidget(5, 1, for_tx_cidade);
                    for_tx_cidade.setWidth("400");
                    for_tx_cidade.setAllowBlank(true);

                    addListBoxUF();
                    grid.setWidget(6, 0, new LabelField("UF:"));
                    grid.setWidget(6, 1, comboUF);
                    comboUF.setAllowBlank(true);

                    grid.setWidget(7, 0, new LabelField("Contatos:"));
                    grid.setWidget(7, 1, for_tx_contato);
                    for_tx_contato.setWidth("400");
                    for_tx_contato.setAllowBlank(true);

                    grid.setWidget(8, 0, new LabelField("Telefone:"));
                    grid.setWidget(8, 1, for_tx_telefone);
                    for_tx_telefone.setAllowBlank(true);

                    grid.setWidget(9, 0, new LabelField("Email:"));
                    grid.setWidget(9, 1, for_tx_email);
                    for_tx_email.setWidth("400");
                    for_tx_email.setAllowBlank(true);

                    addListBoxUF();
                    getCpMaster().add(grid);
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

    @Override
    public void btnLimpartAction(ButtonEvent ce) {

        for_tx_nome.setValue("");
        for_tx_cnpj.setValue(null);
        for_tx_endereco.setValue("");
        for_tx_bairro.setValue("");
        for_tx_cidade.setValue("");
        comboUF.setValue(null);
        for_tx_contato.setValue("");
        for_tx_telefone.setValue("");
        for_tx_email.setValue("");
    }

    public boolean valido() {
        boolean result = true;
        if (for_tx_nome.getValue().trim().length() == 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo nome tem preenchimento obrigatório");
        }
        return result;
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            
            param.put("op", "insert");

            param.put("for_fornecedorT.for_tx_nome", for_tx_nome.getValue());

            param.put("for_fornecedorT.for_tx_cnpj", for_tx_cnpj.getValue() + "");

            param.put("for_fornecedorT.for_tx_endereco", for_tx_endereco.getValue()+"");

            param.put("for_fornecedorT.for_tx_bairro", for_tx_bairro.getValue()+"");

            param.put("for_fornecedorT.for_tx_cidade", for_tx_cidade.getValue()+"");

            param.put("for_fornecedorT.for_tx_uf", comboUF.getValue()!= null ? comboUF.getValue().getValue():"");

            param.put("for_fornecedorT.for_tx_contato", for_tx_contato.getValue()+"");

            param.put("for_fornecedorT.for_tx_telefone", for_tx_telefone.getValue()+"");

            param.put("for_fornecedorT.for_tx_email", for_tx_email.getValue()+"");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            
            //consultGWT.load();

        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                getShowMsgCadastro();
                btnLimpartAction(null);
                consultGWT.load();
            } else {
                getShowMsgErro(jsonObject.get("resultado").toString());
            }
        }
    }
}

