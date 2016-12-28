/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.for_fornecedor;

import br.com.easynet.gwt.easyportal.client.ComboboxGeneric;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListUF;
import br.com.easynet.gwt.easyportal.client.Portal2GWT;
import br.com.easynet.gwt.easyportal.client.UFTGWT;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class For_fornecedorUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDeleteGWT.jsp";
    private TextField<String> for_nr_id = new TextField<String>();
    private TextField<String> for_tx_nome = new TextField<String>();
    private TextField<String> for_tx_cnpj = new TextField<String>();
    private TextField<String> for_tx_endereco = new TextField<String>();
    private TextField<String> for_tx_bairro = new TextField<String>();
    private TextField<String> for_tx_cidade = new TextField<String>();
    private ListBox for_tx_uf = new ListBox();
    private TextField<String> for_tx_contato = new TextField<String>();
    private TextField<String> for_tx_telefone = new TextField<String>();
    private TextField<String> for_tx_email = new TextField<String>();
    private For_fornecedorTGWT for_fornecedorTGWT = new For_fornecedorTGWT();
    private For_fornecedorConsultGWT consultGWT = new For_fornecedorConsultGWT();
    private ComboBox<UFTGWT> comboUF = new ComboBox<UFTGWT>();
    ListUF listUF = new ListUF();
    

    public For_fornecedorConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(For_fornecedorConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public void addListBoxUF() {
        ListStore<UFTGWT> storeuf = new ListStore<UFTGWT>();
        storeuf.add(listUF.getList());
        comboUF.setStore(storeuf);
        comboUF.setDisplayField("display");
        comboUF.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public For_fornecedorUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar Fornecedor");

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
                }

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
                comboUF.setValue(listUF.getTreeUF().get(for_fornecedorTGWT.getFor_tx_uf()));
                grid.setWidget(6, 0, new LabelField("UF:"));
                grid.setWidget(6, 1, comboUF);
                comboUF.setAllowBlank(true);

                grid.setWidget(7, 0, new LabelField("Contatos:"));
                grid.setWidget(7, 1, for_tx_contato);
                for_tx_contato.setWidth("400");
                for_tx_contato.setAllowBlank(true);

                grid.setWidget(8, 0, new LabelField("Telefone:"));
                grid.setWidget(8, 1, for_tx_telefone);
                for_tx_telefone.setMaxLength(10);
                for_tx_telefone.setAllowBlank(true);

                grid.setWidget(9, 0, new LabelField("Email:"));
                grid.setWidget(9, 1, for_tx_email);
                for_tx_email.setWidth("400");
                for_tx_email.setAllowBlank(true);
                addListBoxUF();
                getCpMaster().add(grid);
                layout();
            }
        };
        timer.schedule(500);
    }

    public void load(For_fornecedorTGWT for_fornecedorTGWT) {
        try {
            this.for_fornecedorTGWT = for_fornecedorTGWT;
            this.for_nr_id.setValue(for_fornecedorTGWT.getFor_nr_id() + "");

            this.for_tx_nome.setValue(for_fornecedorTGWT.getFor_tx_nome() + "");

            this.for_tx_cnpj.setValue(for_fornecedorTGWT.getFor_tx_cnpj() + "");

            this.for_tx_endereco.setValue(for_fornecedorTGWT.getFor_tx_endereco() + "");

            this.for_tx_bairro.setValue(for_fornecedorTGWT.getFor_tx_bairro() + "");

            this.for_tx_cidade.setValue(for_fornecedorTGWT.getFor_tx_cidade() + "");

            this.for_tx_contato.setValue(for_fornecedorTGWT.getFor_tx_contato() + "");

            this.for_tx_telefone.setValue(for_fornecedorTGWT.getFor_tx_telefone() + "");

            this.for_tx_email.setValue(for_fornecedorTGWT.getFor_tx_email() + "");


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
        if (for_tx_nome.getValue().trim().length() == 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo nome tem preenchimento obrigatório");
        }
        return result;
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("for_fornecedorT.for_nr_id", for_nr_id.getValue());

            param.put("for_fornecedorT.for_tx_nome", for_tx_nome.getValue());

            param.put("for_fornecedorT.for_tx_cnpj", for_tx_cnpj.getValue()+"");

            param.put("for_fornecedorT.for_tx_endereco", for_tx_endereco.getValue()+"");

            param.put("for_fornecedorT.for_tx_bairro", for_tx_bairro.getValue()+"");

            param.put("for_fornecedorT.for_tx_cidade", for_tx_cidade.getValue()+"");

            param.put("for_fornecedorT.for_tx_uf", comboUF.getValue()!= null? comboUF.getValue().getValue():"");

            param.put("for_fornecedorT.for_tx_contato", for_tx_contato.getValue()+"");

            param.put("for_fornecedorT.for_tx_telefone", for_tx_telefone.getValue()+"");

            param.put("for_fornecedorT.for_tx_email", for_tx_email.getValue()+"");

            for_fornecedorTGWT.setFor_tx_nome(for_tx_nome.getValue()+"");
            for_fornecedorTGWT.setFor_tx_cnpj(for_tx_cnpj.getValue()+"");
            for_fornecedorTGWT.setFor_tx_endereco(for_tx_endereco.getValue()+"");
            for_fornecedorTGWT.setFor_tx_bairro(for_tx_bairro.getValue()+"");
            for_fornecedorTGWT.setFor_tx_cidade(for_tx_cidade.getValue()+"");
            for_fornecedorTGWT.setFor_tx_uf(comboUF.getValue().getValue()+"");
            for_fornecedorTGWT.setFor_tx_contato(for_tx_contato.getValue()+"");
            for_fornecedorTGWT.setFor_tx_telefone(for_tx_telefone.getValue()+"");
            for_fornecedorTGWT.setFor_tx_email(for_tx_email.getValue()+"");


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
//            consultGWT.load();
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("for_fornecedorT.for_nr_id", for_nr_id.getValue());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                getShowMsgAlteracao();
                this.close();
                consultGWT.getStore().update(for_fornecedorTGWT);
                consultGWT.getStore().commitChanges();
                //consultGWT.load();
            } else {
                getShowMsgErro(jsonObject.get("resultado").toString());
            }
        }
    }

}

