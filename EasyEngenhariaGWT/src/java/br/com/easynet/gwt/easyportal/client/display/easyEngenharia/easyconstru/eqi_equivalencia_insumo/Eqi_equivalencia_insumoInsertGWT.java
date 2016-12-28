/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eqi_equivalencia_insumo;

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
public class Eqi_equivalencia_insumoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/eqi_equivalencia_insumo/eqi_equivalencia_insumoInsertGWT.jsp";   
    private Eqi_equivalencia_insumoConsultGWT consultGWT = new Eqi_equivalencia_insumoConsultGWT();


    public Eqi_equivalencia_insumoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Eqi_equivalencia_insumoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox ina_nr_id = new TextBox();

    private TextBox inn_nr_id = new TextBox();



    public Eqi_equivalencia_insumoInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(3, 2);
        grid.setWidget(0, 0, new Label("ina_nr_id:"));
        grid.setWidget(0, 1, ina_nr_id);

        grid.setWidget(1, 0, new Label("inn_nr_id:"));
        grid.setWidget(1, 1, inn_nr_id);





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
            param.put("eqi_equivalencia_insumoT.ina_nr_id", ina_nr_id.getText());

            param.put("eqi_equivalencia_insumoT.inn_nr_id", inn_nr_id.getText());

	
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
       //     Window.alert("Result " + jsonObject.get("resultado").toString());
//            JSONObject msg = resultado.get("mensagem").isObject();
//            Window.alert("Mensagem " + msg.toString());
        }
    }
}

