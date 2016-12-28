/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eplc_equivalencia_plano_contas;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Eplc_equivalencia_plano_contasInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasInsertGWT.jsp";
    private Eplc_equivalencia_plano_contasConsultGWT consultGWT = new Eplc_equivalencia_plano_contasConsultGWT();


    public Eplc_equivalencia_plano_contasConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Eplc_equivalencia_plano_contasConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> eplc_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();



    public Eplc_equivalencia_plano_contasInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(4, 2);
        grid.setWidget(0, 0, new Label("eplc_nr_id:"));
        grid.setWidget(0, 1, eplc_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id:"));
        grid.setWidget(1, 1, plc_nr_id);

        grid.setWidget(2, 0, new Label("plco_nr_id:"));
        grid.setWidget(2, 1, plco_nr_id);





        getCpMaster().add(grid);
	layout();
    }
    @Override
    public void btnInsertAction(ButtonEvent ce) {
        btnCadAction(ce);
    }
    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
	    param.put("op", "insert");
            param.put("eplc_equivalencia_plano_contasT.eplc_nr_id", eplc_nr_id.getValue());

            param.put("eplc_equivalencia_plano_contasT.plc_nr_id", plc_nr_id.getValue());

            param.put("eplc_equivalencia_plano_contasT.plco_nr_id", plco_nr_id.getValue());

	
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

