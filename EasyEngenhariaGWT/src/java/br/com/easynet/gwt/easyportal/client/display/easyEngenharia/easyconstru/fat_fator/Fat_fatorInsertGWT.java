/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fat_fator;

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
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Fat_fatorInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fat_fator/fat_fatorInsertGWT.jsp";   
    private Fat_fatorConsultGWT consultGWT = new Fat_fatorConsultGWT();


    public Fat_fatorConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Fat_fatorConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> fat_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> fat_nr_fator_atual = new TextField<String>();

    private TextField<String> fat_nr_fator_projetado = new TextField<String>();

    private TextField<String> fat_nr_mes = new TextField<String>();

    private TextField<String> fat_nr_ano = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();



    public Fat_fatorInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(8, 2);
        grid.setWidget(0, 0, new Label("fat_nr_id:"));
        grid.setWidget(0, 1, fat_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id:"));
        grid.setWidget(1, 1, plc_nr_id);

        grid.setWidget(2, 0, new Label("fat_nr_fator_atual:"));
        grid.setWidget(2, 1, fat_nr_fator_atual);

        grid.setWidget(3, 0, new Label("fat_nr_fator_projetado:"));
        grid.setWidget(3, 1, fat_nr_fator_projetado);

        grid.setWidget(4, 0, new Label("fat_nr_mes:"));
        grid.setWidget(4, 1, fat_nr_mes);

        grid.setWidget(5, 0, new Label("fat_nr_ano:"));
        grid.setWidget(5, 1, fat_nr_ano);

        grid.setWidget(6, 0, new Label("obr_nr_id:"));
        grid.setWidget(6, 1, obr_nr_id);





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
            param.put("fat_fatorT.fat_nr_id", fat_nr_id.getValue());

            param.put("fat_fatorT.plc_nr_id", plc_nr_id.getValue());

            param.put("fat_fatorT.fat_nr_fator_atual", fat_nr_fator_atual.getValue());

            param.put("fat_fatorT.fat_nr_fator_projetado", fat_nr_fator_projetado.getValue());

            param.put("fat_fatorT.fat_nr_mes", fat_nr_mes.getValue());

            param.put("fat_fatorT.fat_nr_ano", fat_nr_ano.getValue());

            param.put("fat_fatorT.obr_nr_id", obr_nr_id.getValue());

	
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

