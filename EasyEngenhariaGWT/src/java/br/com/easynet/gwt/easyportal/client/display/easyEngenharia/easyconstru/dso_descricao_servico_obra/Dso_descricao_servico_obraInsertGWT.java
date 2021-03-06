/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.dso_descricao_servico_obra;

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
public class Dso_descricao_servico_obraInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraInsertGWT.jsp";   
    private Dso_descricao_servico_obraConsultGWT consultGWT = new Dso_descricao_servico_obraConsultGWT();


    public Dso_descricao_servico_obraConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Dso_descricao_servico_obraConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox plco_nr_id = new TextBox();

    private TextBox dso_tx_codigo_externo = new TextBox();

    private TextBox dso_tx_descriaco = new TextBox();

    private TextBox dso_nr_id = new TextBox();



    public Dso_descricao_servico_obraInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("plco_nr_id:"));
        grid.setWidget(0, 1, plco_nr_id);

        grid.setWidget(1, 0, new Label("dso_tx_codigo_externo:"));
        grid.setWidget(1, 1, dso_tx_codigo_externo);

        grid.setWidget(2, 0, new Label("dso_tx_descriaco:"));
        grid.setWidget(2, 1, dso_tx_descriaco);

        grid.setWidget(3, 0, new Label("dso_nr_id:"));
        grid.setWidget(3, 1, dso_nr_id);





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
            param.put("dso_descricao_servico_obraT.plco_nr_id", plco_nr_id.getText());

            param.put("dso_descricao_servico_obraT.dso_tx_codigo_externo", dso_tx_codigo_externo.getText());

            param.put("dso_descricao_servico_obraT.dso_tx_descriaco", dso_tx_descriaco.getText());

            param.put("dso_descricao_servico_obraT.dso_nr_id", dso_nr_id.getText());

	
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

