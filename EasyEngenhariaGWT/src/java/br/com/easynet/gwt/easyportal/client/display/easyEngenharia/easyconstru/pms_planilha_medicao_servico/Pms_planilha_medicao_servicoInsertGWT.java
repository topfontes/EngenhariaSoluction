/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pms_planilha_medicao_servico;

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
public class Pms_planilha_medicao_servicoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoInsertGWT.jsp";   
    private Pms_planilha_medicao_servicoConsultGWT consultGWT = new Pms_planilha_medicao_servicoConsultGWT();


    public Pms_planilha_medicao_servicoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Pms_planilha_medicao_servicoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> pms_nr_id = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> pms_nr_mes = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> pms_nr_quantidade_servico = new TextField<String>();



    public Pms_planilha_medicao_servicoInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(6, 2);
        grid.setWidget(0, 0, new Label("pms_nr_id:"));
        grid.setWidget(0, 1, pms_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("pms_nr_mes:"));
        grid.setWidget(2, 1, pms_nr_mes);

        grid.setWidget(3, 0, new Label("plco_nr_id:"));
        grid.setWidget(3, 1, plco_nr_id);

        grid.setWidget(4, 0, new Label("pms_nr_quantidade_servico:"));
        grid.setWidget(4, 1, pms_nr_quantidade_servico);





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
            param.put("pms_planilha_medicao_servicoT.pms_nr_id", pms_nr_id.getValue());

            param.put("pms_planilha_medicao_servicoT.obr_nr_id", obr_nr_id.getValue());

            param.put("pms_planilha_medicao_servicoT.pms_nr_mes", pms_nr_mes.getValue());

            param.put("pms_planilha_medicao_servicoT.plco_nr_id", plco_nr_id.getValue());

            param.put("pms_planilha_medicao_servicoT.pms_nr_quantidade_servico", pms_nr_quantidade_servico.getValue());

	
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

