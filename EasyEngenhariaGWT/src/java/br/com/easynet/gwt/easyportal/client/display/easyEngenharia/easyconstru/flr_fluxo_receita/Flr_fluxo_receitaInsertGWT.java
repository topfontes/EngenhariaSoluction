/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.flr_fluxo_receita;

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
public class Flr_fluxo_receitaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaInsertGWT.jsp";   
    private Flr_fluxo_receitaConsultGWT consultGWT = new Flr_fluxo_receitaConsultGWT();


    public Flr_fluxo_receitaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Flr_fluxo_receitaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox flr_nr_id = new TextBox();

    private TextBox flr_nr_mes = new TextBox();

    private TextBox flr_nr_ano = new TextBox();

    private TextBox flr_nr_original = new TextBox();

    private TextBox flr_nr_atual = new TextBox();

    private TextBox flr_tx_key = new TextBox();



    public Flr_fluxo_receitaInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(7, 2);
        grid.setWidget(0, 0, new Label("flr_nr_id:"));
        grid.setWidget(0, 1, flr_nr_id);

        grid.setWidget(1, 0, new Label("flr_nr_mes:"));
        grid.setWidget(1, 1, flr_nr_mes);

        grid.setWidget(2, 0, new Label("flr_nr_ano:"));
        grid.setWidget(2, 1, flr_nr_ano);

        grid.setWidget(3, 0, new Label("flr_nr_original:"));
        grid.setWidget(3, 1, flr_nr_original);

        grid.setWidget(4, 0, new Label("flr_nr_atual:"));
        grid.setWidget(4, 1, flr_nr_atual);

        grid.setWidget(5, 0, new Label("flr_tx_key:"));
        grid.setWidget(5, 1, flr_tx_key);





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
            param.put("flr_fluxo_receitaT.flr_nr_id", flr_nr_id.getText());

            param.put("flr_fluxo_receitaT.flr_nr_mes", flr_nr_mes.getText());

            param.put("flr_fluxo_receitaT.flr_nr_ano", flr_nr_ano.getText());

            param.put("flr_fluxo_receitaT.flr_nr_original", flr_nr_original.getText());

            param.put("flr_fluxo_receitaT.flr_nr_atual", flr_nr_atual.getText());

            param.put("flr_fluxo_receitaT.flr_tx_key", flr_tx_key.getText());

	
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

