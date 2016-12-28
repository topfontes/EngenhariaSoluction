/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.infe_item_nota_entrada;

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
import com.extjs.gxt.ui.client.widget.form.LabelField; 
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Infe_item_nota_entradaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaInsertGWT.jsp";   
    private Infe_item_nota_entradaConsultGWT consultGWT = new Infe_item_nota_entradaConsultGWT();


    public Infe_item_nota_entradaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Infe_item_nota_entradaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> infe_nr_id = new TextField<String>();

    private TextField<String> infe_nr_quantidade = new TextField<String>();

    private TextField<String> infe_nr_valor_unit = new TextField<String>();

    private TextField<String> infe_nr_valor_total = new TextField<String>();

    private TextField<String> nfe_nr_id = new TextField<String>();

    private TextField<String> pro_nr_id = new TextField<String>();



    public Infe_item_nota_entradaInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(7, 2);
        grid.setWidget(0, 0, new LabelField("infe_nr_id:"));
        grid.setWidget(0, 1, infe_nr_id);

        grid.setWidget(1, 0, new LabelField("infe_nr_quantidade:"));
        grid.setWidget(1, 1, infe_nr_quantidade);

        grid.setWidget(2, 0, new LabelField("infe_nr_valor_unit:"));
        grid.setWidget(2, 1, infe_nr_valor_unit);

        grid.setWidget(3, 0, new LabelField("infe_nr_valor_total:"));
        grid.setWidget(3, 1, infe_nr_valor_total);

        grid.setWidget(4, 0, new LabelField("nfe_nr_id:"));
        grid.setWidget(4, 1, nfe_nr_id);

        grid.setWidget(5, 0, new LabelField("pro_nr_id:"));
        grid.setWidget(5, 1, pro_nr_id);

        getCpMaster().add(grid);
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
            param.put("infe_item_nota_entradaT.infe_nr_id", infe_nr_id.getValue());

            param.put("infe_item_nota_entradaT.infe_nr_quantidade", infe_nr_quantidade.getValue());

            param.put("infe_item_nota_entradaT.infe_nr_valor_unit", infe_nr_valor_unit.getValue());

            param.put("infe_item_nota_entradaT.infe_nr_valor_total", infe_nr_valor_total.getValue());

            param.put("infe_item_nota_entradaT.nfe_nr_id", nfe_nr_id.getValue());

            param.put("infe_item_nota_entradaT.pro_nr_id", pro_nr_id.getValue());

	
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

