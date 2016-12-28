/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.con_composicao_nova;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
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
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;

/**
 *
 * @author geoleite
 */
public class Con_composicao_novaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/con_composicao_nova/con_composicao_novaInsertGWT.jsp";   
    private Con_composicao_novaConsultGWT consultGWT = new Con_composicao_novaConsultGWT();


    public Con_composicao_novaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Con_composicao_novaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox con_nr_id = new TextBox();

    private TextBox con_tx_codigo = new TextBox();

    private TextBox con_tx_descricao = new TextBox();

    private TextBox con_tx_unidade = new TextBox();



    public Con_composicao_novaInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("con_nr_id:"));
        grid.setWidget(0, 1, con_nr_id);

        grid.setWidget(1, 0, new Label("con_tx_codigo:"));
        grid.setWidget(1, 1, con_tx_codigo);

        grid.setWidget(2, 0, new Label("con_tx_descricao:"));
        grid.setWidget(2, 1, con_tx_descricao);

        grid.setWidget(3, 0, new Label("con_tx_unidade:"));
        grid.setWidget(3, 1, con_tx_unidade);





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
            param.put("con_composicao_novaT.con_nr_id", con_nr_id.getText());

            param.put("con_composicao_novaT.con_tx_codigo", con_tx_codigo.getText());

            param.put("con_composicao_novaT.con_tx_descricao", con_tx_descricao.getText());

            param.put("con_composicao_novaT.con_tx_unidade", con_tx_unidade.getText());

	
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
            Window.alert("Result " + jsonObject.get("resultado").toString());
//            JSONObject msg = resultado.get("mensagem").isObject();
//            Window.alert("Mensagem " + msg.toString());
        }
    }
}

