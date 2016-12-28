/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.htf_horas_trabalha_folha;

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
public class Htf_horas_trabalha_folhaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaInsertGWT.jsp";   
    private Htf_horas_trabalha_folhaConsultGWT consultGWT = new Htf_horas_trabalha_folhaConsultGWT();


    public Htf_horas_trabalha_folhaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Htf_horas_trabalha_folhaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox htf_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox htf_nr_mes = new TextBox();

    private TextBox htf_nr_ano = new TextBox();

    private TextBox htf_nr_horas_trabalhada = new TextBox();



    public Htf_horas_trabalha_folhaInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(6, 2);
        grid.setWidget(0, 0, new Label("htf_nr_id:"));
        grid.setWidget(0, 1, htf_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("htf_nr_mes:"));
        grid.setWidget(2, 1, htf_nr_mes);

        grid.setWidget(3, 0, new Label("htf_nr_ano:"));
        grid.setWidget(3, 1, htf_nr_ano);

        grid.setWidget(4, 0, new Label("htf_nr_horas_trabalhada:"));
        grid.setWidget(4, 1, htf_nr_horas_trabalhada);





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
            param.put("htf_horas_trabalha_folhaT.htf_nr_id", htf_nr_id.getText());

            param.put("htf_horas_trabalha_folhaT.obr_nr_id", obr_nr_id.getText());

            param.put("htf_horas_trabalha_folhaT.htf_nr_mes", htf_nr_mes.getText());

            param.put("htf_horas_trabalha_folhaT.htf_nr_ano", htf_nr_ano.getText());

            param.put("htf_horas_trabalha_folhaT.htf_nr_horas_trabalhada", htf_nr_horas_trabalhada.getText());

	
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
          //  Window.alert("Result " + jsonObject.get("resultado").toString());
//            JSONObject msg = resultado.get("mensagem").isObject();
//            Window.alert("Mensagem " + msg.toString());
        }
    }
}

