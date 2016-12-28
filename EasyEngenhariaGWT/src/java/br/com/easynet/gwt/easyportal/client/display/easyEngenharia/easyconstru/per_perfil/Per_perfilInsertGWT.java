package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.per_perfil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Per_perfilInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/per_perfil/per_perfilInsertGWT.jsp";
    private Per_perfilConsultGWT consultGWT = new Per_perfilConsultGWT();

    public Per_perfilConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Per_perfilConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> per_tx_nome = new TextField<String>();

    public Per_perfilInsertGWT() {
        this.setHeading("Cadastro Perfil");
        this.setSize("40%", "150");
        Grid grid = new Grid(3, 2);

        per_tx_nome.setAllowBlank(false);
        grid.setWidget(1, 0, new LabelField("Nome:"));
        grid.setWidget(1, 1, per_tx_nome);








        getCpMaster().add(grid);
        layout();
    }
//    @Override

    public void btnInsertAction(ButtonEvent ce) {
        if (!isPeenchido()) {
             MessageBox.alert("Result", "preecha todos campos",null);
        }else{
             btnCadAction(ce);
        }

    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");
            param.put("per_perfilT.per_tx_nome", per_tx_nome.getValue());

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);

        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        consultGWT.load();
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            //JSONObject resultado = jsonObject.get("resultado").isObject();
            MessageBox.alert("Result", jsonObject.get("resultado").toString(), null);
//            JSONObject msg = resultado.get("mensagem").isObject();
//            Window.alert("Mensagem " + msg.toString());
        }
    }

    public boolean isPeenchido() {
        return !("".equals(per_tx_nome.getValue()));
    }
}
