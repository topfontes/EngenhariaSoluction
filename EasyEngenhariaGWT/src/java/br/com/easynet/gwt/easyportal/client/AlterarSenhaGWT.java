/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormSubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormSubmitEvent;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.extjs.gxt.ui.client.widget.form.LabelField;

/**
 *
 * @author geoleite
 */
public class AlterarSenhaGWT extends EasyContainer implements IListenetResponse {

    private LabelField lblSenha = new LabelField("Senha:");
    private LabelField lblSenhaNew = new LabelField("Nova Senha:");
    private LabelField lblSenhaConfirm = new LabelField("Confirme Senha:");
    private PasswordTextBox pass = new PasswordTextBox();
    private PasswordTextBox passNew = new PasswordTextBox();
    private PasswordTextBox passConfirm = new PasswordTextBox();
    private Button btnOk = new Button("Alterar");
    private MessageBox mbProgress = new MessageBox();
    private AlterarSenhaGWT alsgwt = this;

    public AlterarSenhaGWT() {

        ContentPanel cp = new ContentPanel() ;
        //cp.setHeading("Alterar Senha");
        cp.setHeaderVisible(false);
        cp.setAnimCollapse(false);
        cp.setCollapsible(false);
        cp.setFrame(true);
        cp.setSize("100%", "100%");


        setLayout(new RowLayout(Orientation.VERTICAL));
        setSize("100%", "100%");
        Grid grid = new Grid(4, 2);
        grid.setWidget(0, 0, lblSenha);
        grid.setWidget(0, 1, pass);

        grid.setWidget(1, 0, lblSenhaNew);
        grid.setWidget(1, 1, passNew);

        grid.setWidget(2, 0, lblSenhaConfirm);
        grid.setWidget(2, 1, passConfirm);
        grid.setWidget(3, 0, btnOk);


        btnOk.addClickListener(new ClickListener() {

            public void onClick(Widget sender) {
                try {
                    //mbProgress = MessageBox.wait("Requisicao", "Solicitando ao Servidor.", "Processo...");

                    btnOkAction(sender);

                } catch (Exception e) {
                    Window.alert(e.getMessage());
                }

            }
        });


        //add(grid);
        cp.add(grid);

        add(cp);
        cp.show();

    }

    public void btnOkAction(Widget sender) {
        try {
            String url = Constantes.URL + "portalgwt/alterarsenha.jsp?op=alterarSenha&senhaatual=" +
                    pass.getText() + "&confnovasenha=" + passConfirm.getText() + "&novasenha=" + passNew.getText();

            EasyAccessURL eaurl = new EasyAccessURL(this);

            eaurl.accessJSon(url);
        } catch (Exception e) {
            Window.alert(e.getMessage());
        }
    }

    public void read(JSONValue jsonValue) {
        //mbProgress.close();
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String valor = resultado.get("mensagem").toString();
            valor = valor.replace('"', ' ').trim();
            String result = resultado.get("result").toString();
            result = result.replace('"', ' ').trim();
            if ("true".equals(result)) {
                //Operacao executadao com sucesso.
                Info.display("Resultado da Operacao.", valor);

                TabItem ti = Portal2GWT.tab.getItemByItemId("Alterar Senha");
                Portal2GWT.tab.remove(ti);
            } else {
                MessageBox mb = new MessageBox();
                mb.alert("Falha ao executar operacao.", valor, null);

            }

        }
    }
}
