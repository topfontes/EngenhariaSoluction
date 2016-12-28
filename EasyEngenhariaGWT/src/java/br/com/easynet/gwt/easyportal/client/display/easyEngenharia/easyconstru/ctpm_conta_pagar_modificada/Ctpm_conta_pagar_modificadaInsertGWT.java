/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctpm_conta_pagar_modificada;

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
public class Ctpm_conta_pagar_modificadaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaInsertGWT.jsp";   
    private Ctpm_conta_pagar_modificadaConsultGWT consultGWT = new Ctpm_conta_pagar_modificadaConsultGWT();


    public Ctpm_conta_pagar_modificadaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ctpm_conta_pagar_modificadaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox ctpm_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox ctp_nr_id = new TextBox();

    private TextBox ctpm_nr_mes = new TextBox();

    private TextBox ctpm_nr_ano = new TextBox();

    private TextBox ctpm_tx_tipo = new TextBox();



    public Ctpm_conta_pagar_modificadaInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(7, 2);
        grid.setWidget(0, 0, new Label("ctpm_nr_id:"));
        grid.setWidget(0, 1, ctpm_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("ctp_nr_id:"));
        grid.setWidget(2, 1, ctp_nr_id);

        grid.setWidget(3, 0, new Label("ctpm_nr_mes:"));
        grid.setWidget(3, 1, ctpm_nr_mes);

        grid.setWidget(4, 0, new Label("ctpm_nr_ano:"));
        grid.setWidget(4, 1, ctpm_nr_ano);

        grid.setWidget(5, 0, new Label("ctpm_tx_tipo:"));
        grid.setWidget(5, 1, ctpm_tx_tipo);





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
            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_id", ctpm_nr_id.getText());

            param.put("ctpm_conta_pagar_modificadaT.obr_nr_id", obr_nr_id.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctp_nr_id", ctp_nr_id.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_mes", ctpm_nr_mes.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctpm_nr_ano", ctpm_nr_ano.getText());

            param.put("ctpm_conta_pagar_modificadaT.ctpm_tx_tipo", ctpm_tx_tipo.getText());

	
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

