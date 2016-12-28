/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ccff_copia_cronograma_fisico_financeiro;

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
public class Ccff_copia_cronograma_fisico_financeiroInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroInsertGWT.jsp";   
    private Ccff_copia_cronograma_fisico_financeiroConsultGWT consultGWT = new Ccff_copia_cronograma_fisico_financeiroConsultGWT();


    public Ccff_copia_cronograma_fisico_financeiroConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ccff_copia_cronograma_fisico_financeiroConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> ccff_nr_id = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> ccff_nr_peso = new TextField<String>();

    private TextField<String> ccff_nr_mes = new TextField<String>();

    private TextField<String> ccff_nr_ano = new TextField<String>();

    private TextField<String> ccff_nr_quantidade = new TextField<String>();

    private TextField<String> ccff_nr_valor = new TextField<String>();



    public Ccff_copia_cronograma_fisico_financeiroInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(9, 2);
        grid.setWidget(0, 0, new Label("ccff_nr_id:"));
        grid.setWidget(0, 1, ccff_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("plco_nr_id:"));
        grid.setWidget(2, 1, plco_nr_id);

        grid.setWidget(3, 0, new Label("ccff_nr_peso:"));
        grid.setWidget(3, 1, ccff_nr_peso);

        grid.setWidget(4, 0, new Label("ccff_nr_mes:"));
        grid.setWidget(4, 1, ccff_nr_mes);

        grid.setWidget(5, 0, new Label("ccff_nr_ano:"));
        grid.setWidget(5, 1, ccff_nr_ano);

        grid.setWidget(6, 0, new Label("ccff_nr_quantidade:"));
        grid.setWidget(6, 1, ccff_nr_quantidade);

        grid.setWidget(7, 0, new Label("ccff_nr_valor:"));
        grid.setWidget(7, 1, ccff_nr_valor);





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
            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id", ccff_nr_id.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.obr_nr_id", obr_nr_id.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.plco_nr_id", plco_nr_id.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_peso", ccff_nr_peso.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_mes", ccff_nr_mes.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_ano", ccff_nr_ano.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_quantidade", ccff_nr_quantidade.getValue());

            param.put("ccff_copia_cronograma_fisico_financeiroT.ccff_nr_valor", ccff_nr_valor.getValue());

	
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

