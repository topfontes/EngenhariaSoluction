/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pes_pessoa;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.google.gwt.core.client.JavaScriptObject;
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
import br.com.easynet.gwt.easyportal.client.EasyContainer;

/**
 *
 * @author geoleite
 */
public class Pes_pessoaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pes_pessoa/pes_pessoaInsertGWT.jsp";   
    private Pes_pessoaConsultGWT consultGWT = new Pes_pessoaConsultGWT();


    public Pes_pessoaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Pes_pessoaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox pes_nr_id = new TextBox();

    private TextBox pes_tx_nome = new TextBox();

    private TextBox pes_tx_fone = new TextBox();



    public Pes_pessoaInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(4, 2);
        grid.setWidget(0, 0, new Label("pes_nr_id:"));
        grid.setWidget(0, 1, pes_nr_id);

        grid.setWidget(1, 0, new Label("pes_tx_nome:"));
        grid.setWidget(1, 1, pes_tx_nome);

        grid.setWidget(2, 0, new Label("pes_tx_fone:"));
        grid.setWidget(2, 1, pes_tx_fone);





        getCpMaster().add(grid);
	layout();
    }
//    @Override
    public void btnInsertAction(ButtonEvent ce) {

        btnCadAction(ce);
    }
    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
	    param.put("op", "insert");
            param.put("pes_pessoaT.pes_nr_id", pes_nr_id.getText());

            param.put("pes_pessoaT.pes_tx_nome", pes_tx_nome.getText());

            param.put("pes_pessoaT.pes_tx_fone", pes_tx_fone.getText());

	
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);


            
	    consultGWT.load();
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            //JSONObject resultado = jsonObject.get("resultado").isObject();
            if(("Cadastro efetuado com sucesso!").equalsIgnoreCase(EasyContainer.clearAspas( jsonObject.get("resultado").toString()))){
                pes_tx_fone.setValue("");
                pes_tx_nome.setValue("");
            }
            Window.alert("Result " + jsonObject.get("resultado").toString());

//            JSONObject msg = resultado.get("mensagem").isObject();
//            Window.alert("Mensagem " + msg.toString());
        }
    }
}

