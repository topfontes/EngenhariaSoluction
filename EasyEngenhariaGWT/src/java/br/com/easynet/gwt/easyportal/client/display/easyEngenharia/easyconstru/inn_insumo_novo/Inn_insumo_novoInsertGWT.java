/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inn_insumo_novo;

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
public class Inn_insumo_novoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/inn_insumo_novo/inn_insumo_novoInsertGWT.jsp";   
    private Inn_insumo_novoConsultGWT consultGWT = new Inn_insumo_novoConsultGWT();


    public Inn_insumo_novoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Inn_insumo_novoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox inn_nr_id = new TextBox();

    private TextBox inn_tx_codigo = new TextBox();

    private TextBox inn_tx_descricao = new TextBox();

    private TextBox inn_tx_unidade = new TextBox();



    public Inn_insumo_novoInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("inn_nr_id:"));
        grid.setWidget(0, 1, inn_nr_id);

        grid.setWidget(1, 0, new Label("inn_tx_codigo:"));
        grid.setWidget(1, 1, inn_tx_codigo);

        grid.setWidget(2, 0, new Label("inn_tx_descricao:"));
        grid.setWidget(2, 1, inn_tx_descricao);

        grid.setWidget(3, 0, new Label("inn_tx_unidade:"));
        grid.setWidget(3, 1, inn_tx_unidade);





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
            param.put("inn_insumo_novoT.inn_nr_id", inn_nr_id.getText());

            param.put("inn_insumo_novoT.inn_tx_codigo", inn_tx_codigo.getText());

            param.put("inn_insumo_novoT.inn_tx_descricao", inn_tx_descricao.getText());

            param.put("inn_insumo_novoT.inn_tx_unidade", inn_tx_unidade.getText());

	
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

