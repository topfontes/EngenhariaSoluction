/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inp_intervalo_parcela;

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

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Inp_intervalo_parcelaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaInsertGWT.jsp";   
    private Inp_intervalo_parcelaConsultGWT consultGWT = new Inp_intervalo_parcelaConsultGWT();


    public Inp_intervalo_parcelaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Inp_intervalo_parcelaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> inp_nr_id = new TextField<String>();

    private TextField<String> par_nr_id = new TextField<String>();

    private TextField<String> inp_nr_dias = new TextField<String>();

    private TextField<String> inp_nr_per = new TextField<String>();



    public Inp_intervalo_parcelaInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("inp_nr_id:"));
        grid.setWidget(0, 1, inp_nr_id);

        grid.setWidget(1, 0, new Label("par_nr_id:"));
        grid.setWidget(1, 1, par_nr_id);

        grid.setWidget(2, 0, new Label("inp_nr_dias:"));
        grid.setWidget(2, 1, inp_nr_dias);

        grid.setWidget(3, 0, new Label("inp_nr_per:"));
        grid.setWidget(3, 1, inp_nr_per);





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
            param.put("inp_intervalo_parcelaT.inp_nr_id", inp_nr_id.getValue());

            param.put("inp_intervalo_parcelaT.par_nr_id", par_nr_id.getValue());

            param.put("inp_intervalo_parcelaT.inp_nr_dias", inp_nr_dias.getValue());

            param.put("inp_intervalo_parcelaT.inp_nr_per", inp_nr_per.getValue());

	
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

