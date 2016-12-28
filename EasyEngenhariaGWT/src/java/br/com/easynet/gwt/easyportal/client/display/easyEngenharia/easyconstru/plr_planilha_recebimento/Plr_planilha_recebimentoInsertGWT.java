/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plr_planilha_recebimento;

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
public class Plr_planilha_recebimentoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plr_planilha_recebimento/plr_planilha_recebimentoInsertGWT.jsp";
    private Plr_planilha_recebimentoConsultGWT consultGWT = new Plr_planilha_recebimentoConsultGWT();


    public Plr_planilha_recebimentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Plr_planilha_recebimentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox plr_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox plr_nr_mes_ref = new TextBox();

    private TextBox plr_nr_ano_ref = new TextBox();

    private TextBox plr_nr_mes = new TextBox();

    private TextBox plr_nr_ano = new TextBox();

    private TextBox plr_nr_efetuado_pj = new TextBox();

    private TextBox plr_nr_realizado_pf = new TextBox();

    private TextBox plr_nr_realizado_pou = new TextBox();



    public Plr_planilha_recebimentoInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(10, 2);
        grid.setWidget(0, 0, new Label("plr_nr_id:"));
        grid.setWidget(0, 1, plr_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("plr_nr_mes_ref:"));
        grid.setWidget(2, 1, plr_nr_mes_ref);

        grid.setWidget(3, 0, new Label("plr_nr_ano_ref:"));
        grid.setWidget(3, 1, plr_nr_ano_ref);

        grid.setWidget(4, 0, new Label("plr_nr_mes:"));
        grid.setWidget(4, 1, plr_nr_mes);

        grid.setWidget(5, 0, new Label("plr_nr_ano:"));
        grid.setWidget(5, 1, plr_nr_ano);

        grid.setWidget(6, 0, new Label("plr_nr_efetuado_pj:"));
        grid.setWidget(6, 1, plr_nr_efetuado_pj);

        grid.setWidget(7, 0, new Label("plr_nr_realizado_pf:"));
        grid.setWidget(7, 1, plr_nr_realizado_pf);

        grid.setWidget(8, 0, new Label("plr_nr_realizado_pou:"));
        grid.setWidget(8, 1, plr_nr_realizado_pou);





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
            param.put("plr_planilha_permutaT.plr_nr_id", plr_nr_id.getText());

            param.put("plr_planilha_permutaT.obr_nr_id", obr_nr_id.getText());

            param.put("plr_planilha_permutaT.plr_nr_mes_ref", plr_nr_mes_ref.getText());

            param.put("plr_planilha_permutaT.plr_nr_ano_ref", plr_nr_ano_ref.getText());

            param.put("plr_planilha_permutaT.plr_nr_mes", plr_nr_mes.getText());

            param.put("plr_planilha_permutaT.plr_nr_ano", plr_nr_ano.getText());

            param.put("plr_planilha_permutaT.plr_nr_efetuado_pj", plr_nr_efetuado_pj.getText());

            param.put("plr_planilha_permutaT.plr_nr_realizado_pf", plr_nr_realizado_pf.getText());

            param.put("plr_planilha_permutaT.plr_nr_realizado_pou", plr_nr_realizado_pou.getText());

	
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
            //Window.alert("Result " + jsonObject.get("resultado").toString());
//            JSONObject msg = resultado.get("mensagem").isObject();
//            Window.alert("Mensagem " + msg.toString());
        }
    }
}

