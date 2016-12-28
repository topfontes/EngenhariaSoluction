/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plv_planilha_vendas;

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
public class Plv_planilha_vendasInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasInsertGWT.jsp";   
    private Plv_planilha_vendasConsultGWT consultGWT = new Plv_planilha_vendasConsultGWT();


    public Plv_planilha_vendasConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Plv_planilha_vendasConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox plv_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox plv_nr_mes_ref = new TextBox();

    private TextBox plv_nr_ano_ref = new TextBox();

    private TextBox plv_nr_mes = new TextBox();

    private TextBox plv_nr_ano = new TextBox();

    private TextBox plv_nr_previsto = new TextBox();

    private TextBox plv_nr_realizado = new TextBox();



    public Plv_planilha_vendasInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(9, 2);
        grid.setWidget(0, 0, new Label("plv_nr_id:"));
        grid.setWidget(0, 1, plv_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("plv_nr_mes_ref:"));
        grid.setWidget(2, 1, plv_nr_mes_ref);

        grid.setWidget(3, 0, new Label("plv_nr_ano_ref:"));
        grid.setWidget(3, 1, plv_nr_ano_ref);

        grid.setWidget(4, 0, new Label("plv_nr_mes:"));
        grid.setWidget(4, 1, plv_nr_mes);

        grid.setWidget(5, 0, new Label("plv_nr_ano:"));
        grid.setWidget(5, 1, plv_nr_ano);

        grid.setWidget(6, 0, new Label("plv_nr_previsto:"));
        grid.setWidget(6, 1, plv_nr_previsto);

        grid.setWidget(7, 0, new Label("plv_nr_realizado:"));
        grid.setWidget(7, 1, plv_nr_realizado);





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
            param.put("plv_planilha_vendasT.plv_nr_id", plv_nr_id.getText());

            param.put("plv_planilha_vendasT.obr_nr_id", obr_nr_id.getText());

            param.put("plv_planilha_vendasT.plv_nr_mes_ref", plv_nr_mes_ref.getText());

            param.put("plv_planilha_vendasT.plv_nr_ano_ref", plv_nr_ano_ref.getText());

            param.put("plv_planilha_vendasT.plv_nr_mes", plv_nr_mes.getText());

            param.put("plv_planilha_vendasT.plv_nr_ano", plv_nr_ano.getText());

            param.put("plv_planilha_vendasT.plv_nr_previsto", plv_nr_previsto.getText());

            param.put("plv_planilha_vendasT.plv_nr_realizado", plv_nr_realizado.getText());

	
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

