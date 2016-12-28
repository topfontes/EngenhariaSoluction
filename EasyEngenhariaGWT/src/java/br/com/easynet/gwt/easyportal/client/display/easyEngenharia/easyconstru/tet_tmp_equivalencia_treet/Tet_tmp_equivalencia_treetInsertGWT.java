/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.tet_tmp_equivalencia_treet;

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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;

/**
 *
 * @author geoleite
 */
public class Tet_tmp_equivalencia_treetInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetInsertGWT.jsp";   
    private Tet_tmp_equivalencia_treetConsultGWT consultGWT = new Tet_tmp_equivalencia_treetConsultGWT();


    public Tet_tmp_equivalencia_treetConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Tet_tmp_equivalencia_treetConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> tet_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> plco_tx_nome = new TextField<String>();

    private TextField<String> plc_tx_nome = new TextField<String>();



    public Tet_tmp_equivalencia_treetInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(6, 2);
        grid.setWidget(0, 0, new Label("tet_nr_id:"));
        grid.setWidget(0, 1, tet_nr_id);

        grid.setWidget(1, 0, new Label("plco_nr_id:"));
        grid.setWidget(1, 1, plco_nr_id);

        grid.setWidget(2, 0, new Label("plc_nr_id:"));
        grid.setWidget(2, 1, plc_nr_id);

        grid.setWidget(3, 0, new Label("plco_tx_nome:"));
        grid.setWidget(3, 1, plco_tx_nome);

        grid.setWidget(4, 0, new Label("plc_tx_nome:"));
        grid.setWidget(4, 1, plc_tx_nome);





        getCpMaster().add(grid);
	layout();
    }
//    @Override
    public void btnInsertAction(ToolBarEvent ce) {
        btnCadAction(ce);
    }
    private void btnCadAction(ToolBarEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
	    param.put("op", "insert");
            param.put("tet_tmp_equivalencia_treetT.tet_nr_id", tet_nr_id.getValue());

            param.put("tet_tmp_equivalencia_treetT.plco_nr_id", plco_nr_id.getValue());

            param.put("tet_tmp_equivalencia_treetT.plc_nr_id", plc_nr_id.getValue());

            param.put("tet_tmp_equivalencia_treetT.plco_tx_nome", plco_tx_nome.getValue());

            param.put("tet_tmp_equivalencia_treetT.plc_tx_nome", plc_tx_nome.getValue());

	
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
           // Window.alert("Result " + jsonObject.get("resultado").toString());
//            JSONObject msg = resultado.get("mensagem").isObject();
//            Window.alert("Mensagem " + msg.toString());
        }
    }
}

