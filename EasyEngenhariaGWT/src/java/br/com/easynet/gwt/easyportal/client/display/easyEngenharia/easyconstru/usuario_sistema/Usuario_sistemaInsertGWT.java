/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.usuario_sistema;

import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.car_carro.Car_carroConsultGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import java.util.HashMap;

/**
 *
 * @author I9
 */
public class Usuario_sistemaInsertGWT extends CadastroGWT implements IListenetResponse{

    public static final String PAGE = "easyEngenharia/easyconstru/usuario_sistema/usuario_sistemaInsertGWT.jsp";
    private Usuario_sistemaConsultGWT consultGWT = new Usuario_sistemaConsultGWT();

    private TextField<String> usu_tx_nome = new TextField<String>();
    private TextField<String> usu_tx_login = new TextField<String>();
    private TextField<String> usu_tx_email = new TextField<String>();
    private PasswordTextBox usu_tx_senha = new PasswordTextBox();
    private PasswordTextBox confirmacaoSenha = new PasswordTextBox();
    public Usuario_sistemaInsertGWT() {
         this.setHeading("Cadastro Usuário");

        this.setSize("40%", "270");
        //usu_tx_nome
        usu_tx_email.setAllowBlank(false);
        usu_tx_login.setAllowBlank(false);
        usu_tx_nome.setAllowBlank(false);

        Grid grid = new Grid(7, 2);
        grid.setWidget(1, 0, new LabelField("Nome:"));
        grid.setWidget(1, 1, usu_tx_nome);
        grid.setWidget(2, 0, new LabelField("E_mail:"));
        grid.setWidget(2, 1, usu_tx_email);
        grid.setWidget(3, 0, new LabelField("Login:"));
        grid.setWidget(3, 1, usu_tx_login);
        grid.setWidget(4, 0, new LabelField("Senha:"));
        grid.setWidget(4, 1, usu_tx_senha);
        grid.setWidget(5, 0, new LabelField("Confirmação da senha:"));
        grid.setWidget(5, 1, confirmacaoSenha);
        getCpMaster().add(grid);
        layout();
    }

    /**
     * @return the consultGWT
     */
    public Usuario_sistemaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Usuario_sistemaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    @Override
    public void btnInsertAction(ButtonEvent ce) {
        if(!(usu_tx_senha.getText().equals(confirmacaoSenha.getText()))){
            MessageBox.alert("Result", "Senhas incorretas!",null);
        }else if ((isPreenchido()) && (usu_tx_senha.getText().equals(confirmacaoSenha.getText()))) {
            btnCadAction(ce);
        }else{
            MessageBox.alert("Result", "preecha todos campos!",null);
        }

    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");


            param.put("usu_usuarioT.usu_tx_nome", usu_tx_nome.getValue());

            param.put("usu_usuarioT.usu_tx_login", usu_tx_login.getValue());
            param.put("usu_usuarioT.usu_tx_email", usu_tx_email.getValue());
            param.put("usu_usuarioT.usu_tx_senha", usu_tx_senha.getText());

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);


        } catch (Exception ex) {
        }
    }

    public void clear(){
//        car_tx_nome.setValue("");
//        car_tx_marca.setValue("");
    }

    public void read(JSONValue jsonValue) {
        consultGWT.load();
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            //JSONObject resultado = jsonObject.get("resultado").isObject();
            MessageBox.alert("Result", jsonObject.get("resultado").toString(),null);
            if("Cadastro efetuado com sucesso!".equalsIgnoreCase(EasyContainer.clearAspas(jsonObject.get("resultado").toString()))){
                clear();
            }


//            JSONObject msg = resultado.get("mensagem").isObject();
//            Window.alert("Mensagem " + msg.toString());
        }
    }
    public boolean isPreenchido(){
        return !(("".equals(usu_tx_email.getValue()))
                ||("".equals(usu_tx_login.getValue()))
                ||("".equals(usu_tx_nome.getValue()))
                ||("".equals(usu_tx_senha.getValue()))
                ||("".equals(confirmacaoSenha.getValue())));
    }
}
