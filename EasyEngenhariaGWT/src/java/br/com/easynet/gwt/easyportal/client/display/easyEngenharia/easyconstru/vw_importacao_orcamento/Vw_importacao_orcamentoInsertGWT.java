/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_importacao_orcamento;

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
public class Vw_importacao_orcamentoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoInsertGWT.jsp";   
    private Vw_importacao_orcamentoConsultGWT consultGWT = new Vw_importacao_orcamentoConsultGWT();


    public Vw_importacao_orcamentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_importacao_orcamentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> plco_tx_nome = new TextField<String>();

    private TextField<String> plco_tx_tipo = new TextField<String>();

    private TextField<String> plco_tx_unidade = new TextField<String>();

    private TextField<String> ipo_nr_quantidade = new TextField<String>();

    private TextField<String> ipo_nr_vl_unitario = new TextField<String>();

    private TextField<String> ipo_nr_vl_total = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> ipo_plc_nr_id_servico = new TextField<String>();

    private TextField<String> plco_tx_cod_externo = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> plco_nr_nivel = new TextField<String>();



    public Vw_importacao_orcamentoInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(12, 2);
        grid.setWidget(0, 0, new Label("plco_tx_nome:"));
        grid.setWidget(0, 1, plco_tx_nome);

        grid.setWidget(1, 0, new Label("plco_tx_tipo:"));
        grid.setWidget(1, 1, plco_tx_tipo);

        grid.setWidget(2, 0, new Label("plco_tx_unidade:"));
        grid.setWidget(2, 1, plco_tx_unidade);

        grid.setWidget(3, 0, new Label("ipo_nr_quantidade:"));
        grid.setWidget(3, 1, ipo_nr_quantidade);

        grid.setWidget(4, 0, new Label("ipo_nr_vl_unitario:"));
        grid.setWidget(4, 1, ipo_nr_vl_unitario);

        grid.setWidget(5, 0, new Label("ipo_nr_vl_total:"));
        grid.setWidget(5, 1, ipo_nr_vl_total);

        grid.setWidget(6, 0, new Label("plco_nr_id:"));
        grid.setWidget(6, 1, plco_nr_id);

        grid.setWidget(7, 0, new Label("ipo_plc_nr_id_servico:"));
        grid.setWidget(7, 1, ipo_plc_nr_id_servico);

        grid.setWidget(8, 0, new Label("plco_tx_cod_externo:"));
        grid.setWidget(8, 1, plco_tx_cod_externo);

        grid.setWidget(9, 0, new Label("obr_nr_id:"));
        grid.setWidget(9, 1, obr_nr_id);

        grid.setWidget(10, 0, new Label("plco_nr_nivel:"));
        grid.setWidget(10, 1, plco_nr_nivel);





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
            param.put("vw_importacao_orcamentoT.plco_tx_nome", plco_tx_nome.getValue());

            param.put("vw_importacao_orcamentoT.plco_tx_tipo", plco_tx_tipo.getValue());

            param.put("vw_importacao_orcamentoT.plco_tx_unidade", plco_tx_unidade.getValue());

            param.put("vw_importacao_orcamentoT.ipo_nr_quantidade", ipo_nr_quantidade.getValue());

            param.put("vw_importacao_orcamentoT.ipo_nr_vl_unitario", ipo_nr_vl_unitario.getValue());

            param.put("vw_importacao_orcamentoT.ipo_nr_vl_total", ipo_nr_vl_total.getValue());

            param.put("vw_importacao_orcamentoT.plco_nr_id", plco_nr_id.getValue());

            param.put("vw_importacao_orcamentoT.ipo_plc_nr_id_servico", ipo_plc_nr_id_servico.getValue());

            param.put("vw_importacao_orcamentoT.plco_tx_cod_externo", plco_tx_cod_externo.getValue());

            param.put("vw_importacao_orcamentoT.obr_nr_id", obr_nr_id.getValue());

            param.put("vw_importacao_orcamentoT.plco_nr_nivel", plco_nr_nivel.getValue());

	
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

