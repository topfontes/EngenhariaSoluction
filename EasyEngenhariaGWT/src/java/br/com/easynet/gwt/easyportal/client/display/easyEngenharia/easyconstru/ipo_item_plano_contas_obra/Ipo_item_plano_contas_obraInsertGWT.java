/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ipo_item_plano_contas_obra;

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
public class Ipo_item_plano_contas_obraInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraInsertGWT.jsp";
    private Ipo_item_plano_contas_obraConsultGWT consultGWT = new Ipo_item_plano_contas_obraConsultGWT();


    public Ipo_item_plano_contas_obraConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ipo_item_plano_contas_obraConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> ipo_nr_id = new TextField<String>();

    private TextField<String> ipo_nr_quantidade = new TextField<String>();

    private TextField<String> ipo_nr_vl_unitario = new TextField<String>();

    private TextField<String> ipo_nr_vl_total = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();



    public Ipo_item_plano_contas_obraInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(7, 2);
        grid.setWidget(0, 0, new Label("ipo_nr_id:"));
        grid.setWidget(0, 1, ipo_nr_id);

        grid.setWidget(1, 0, new Label("ipo_nr_quantidade:"));
        grid.setWidget(1, 1, ipo_nr_quantidade);

        grid.setWidget(2, 0, new Label("ipo_nr_vl_unitario:"));
        grid.setWidget(2, 1, ipo_nr_vl_unitario);

        grid.setWidget(3, 0, new Label("ipo_nr_vl_total:"));
        grid.setWidget(3, 1, ipo_nr_vl_total);

        grid.setWidget(4, 0, new Label("obr_nr_id:"));
        grid.setWidget(4, 1, obr_nr_id);

        grid.setWidget(5, 0, new Label("plco_nr_id:"));
        grid.setWidget(5, 1, plco_nr_id);
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
            param.put("ipo_item_plano_contas_obraT.ipo_nr_id", ipo_nr_id.getValue());

            param.put("ipo_item_plano_contas_obraT.ipo_nr_quantidade", ipo_nr_quantidade.getValue());

            param.put("ipo_item_plano_contas_obraT.ipo_nr_vl_unitario", ipo_nr_vl_unitario.getValue());

            param.put("ipo_item_plano_contas_obraT.ipo_nr_vl_total", ipo_nr_vl_total.getValue());

            param.put("ipo_item_plano_contas_obraT.obr_nr_id", obr_nr_id.getValue());

            param.put("ipo_item_plano_contas_obraT.plco_nr_id", plco_nr_id.getValue());

	
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

