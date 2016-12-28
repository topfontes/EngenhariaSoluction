/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.nfe_nota_fiscal_entrada;

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
public class Nfe_nota_fiscal_entradaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaInsertGWT.jsp";   
    private Nfe_nota_fiscal_entradaConsultGWT consultGWT = new Nfe_nota_fiscal_entradaConsultGWT();


    public Nfe_nota_fiscal_entradaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Nfe_nota_fiscal_entradaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> nfe_nr_id = new TextField<String>();

    private TextField<String> nfe_dt_emissao = new TextField<String>();

    private TextField<String> for_nr_id = new TextField<String>();

    private TextField<String> nfe_nr_valor_nota = new TextField<String>();



    public Nfe_nota_fiscal_entradaInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new LabelField("nfe_nr_id:"));
        grid.setWidget(0, 1, nfe_nr_id);

        grid.setWidget(1, 0, new LabelField("nfe_dt_emissao:"));
        grid.setWidget(1, 1, nfe_dt_emissao);

        grid.setWidget(2, 0, new LabelField("for_nr_id:"));
        grid.setWidget(2, 1, for_nr_id);

        grid.setWidget(3, 0, new LabelField("nfe_nr_valor_nota:"));
        grid.setWidget(3, 1, nfe_nr_valor_nota);





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
            param.put("nfe_nota_fiscal_entradaT.nfe_nr_id", nfe_nr_id.getValue());

            param.put("nfe_nota_fiscal_entradaT.nfe_dt_emissao", nfe_dt_emissao.getValue());

            param.put("nfe_nota_fiscal_entradaT.for_nr_id", for_nr_id.getValue());

            param.put("nfe_nota_fiscal_entradaT.nfe_nr_valor_nota", nfe_nr_valor_nota.getValue());

	
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

