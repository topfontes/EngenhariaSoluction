/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_curva_abc_equivalencia;

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
public class Vw_curva_abc_equivalenciaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaInsertGWT.jsp";   
    private Vw_curva_abc_equivalenciaConsultGWT consultGWT = new Vw_curva_abc_equivalenciaConsultGWT();


    public Vw_curva_abc_equivalenciaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_curva_abc_equivalenciaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> plc_tx_nome = new TextField<String>();

    private TextField<String> total = new TextField<String>();



    public Vw_curva_abc_equivalenciaInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(5, 2);
        grid.setWidget(0, 0, new Label("obr_nr_id:"));
        grid.setWidget(0, 1, obr_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id:"));
        grid.setWidget(1, 1, plc_nr_id);

        grid.setWidget(2, 0, new Label("plc_tx_nome:"));
        grid.setWidget(2, 1, plc_tx_nome);

        grid.setWidget(3, 0, new Label("total:"));
        grid.setWidget(3, 1, total);





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
            param.put("vw_curva_abc_equivalenciaT.obr_nr_id", obr_nr_id.getValue());

            param.put("vw_curva_abc_equivalenciaT.plc_nr_id", plc_nr_id.getValue());

            param.put("vw_curva_abc_equivalenciaT.plc_tx_nome", plc_tx_nome.getValue());

            param.put("vw_curva_abc_equivalenciaT.total", total.getValue());

	
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

