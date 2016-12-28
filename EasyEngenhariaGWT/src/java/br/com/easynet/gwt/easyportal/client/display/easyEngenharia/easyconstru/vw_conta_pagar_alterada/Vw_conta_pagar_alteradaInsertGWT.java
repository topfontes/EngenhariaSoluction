/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_conta_pagar_alterada;

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
public class Vw_conta_pagar_alteradaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaInsertGWT.jsp";   
    private Vw_conta_pagar_alteradaConsultGWT consultGWT = new Vw_conta_pagar_alteradaConsultGWT();


    public Vw_conta_pagar_alteradaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_conta_pagar_alteradaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox ctp_nr_id = new TextBox();

    private TextBox ctp_nr_mes = new TextBox();

    private TextBox ctp_nr_ano = new TextBox();

    private TextBox ctp_nr_documento = new TextBox();

    private TextBox ctp_tx_obs = new TextBox();

    private TextBox ctp_tx_fornecedor = new TextBox();

    private TextBox ctp_nr_valor = new TextBox();

    private TextBox ctpm_nr_mes = new TextBox();

    private TextBox ctpm_nr_ano = new TextBox();



    public Vw_conta_pagar_alteradaInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(10, 2);
        grid.setWidget(0, 0, new Label("ctp_nr_id:"));
        grid.setWidget(0, 1, ctp_nr_id);

        grid.setWidget(1, 0, new Label("ctp_nr_mes:"));
        grid.setWidget(1, 1, ctp_nr_mes);

        grid.setWidget(2, 0, new Label("ctp_nr_ano:"));
        grid.setWidget(2, 1, ctp_nr_ano);

        grid.setWidget(3, 0, new Label("ctp_nr_documento:"));
        grid.setWidget(3, 1, ctp_nr_documento);

        grid.setWidget(4, 0, new Label("ctp_tx_obs:"));
        grid.setWidget(4, 1, ctp_tx_obs);

        grid.setWidget(5, 0, new Label("ctp_tx_fornecedor:"));
        grid.setWidget(5, 1, ctp_tx_fornecedor);

        grid.setWidget(6, 0, new Label("ctp_nr_valor:"));
        grid.setWidget(6, 1, ctp_nr_valor);

        grid.setWidget(7, 0, new Label("ctpm_nr_mes:"));
        grid.setWidget(7, 1, ctpm_nr_mes);

        grid.setWidget(8, 0, new Label("ctpm_nr_ano:"));
        grid.setWidget(8, 1, ctpm_nr_ano);





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
            param.put("vw_conta_pagar_alteradaT.ctp_nr_id", ctp_nr_id.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_mes", ctp_nr_mes.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_ano", ctp_nr_ano.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_documento", ctp_nr_documento.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_tx_obs", ctp_tx_obs.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_tx_fornecedor", ctp_tx_fornecedor.getText());

            param.put("vw_conta_pagar_alteradaT.ctp_nr_valor", ctp_nr_valor.getText());

            param.put("vw_conta_pagar_alteradaT.ctpm_nr_mes", ctpm_nr_mes.getText());

            param.put("vw_conta_pagar_alteradaT.ctpm_nr_ano", ctpm_nr_ano.getText());

	
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

