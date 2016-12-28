/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_insumo_plc_pms;

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
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;

/**
 *
 * @author geoleite
 */
public class Vw_insumo_plc_pmsInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_insumo_plc_pms/vw_insumo_plc_pmsInsertGWT.jsp";   
    private Vw_insumo_plc_pmsConsultGWT consultGWT = new Vw_insumo_plc_pmsConsultGWT("");


    public Vw_insumo_plc_pmsConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_insumo_plc_pmsConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> obr_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id_super = new TextField<String>();

    private TextField<String> plc_tx_nome_super = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> plc_tx_nome = new TextField<String>();

    private TextField<String> ipo_nr_vl_unitario = new TextField<String>();

    private TextField<String> pms_nr_mes = new TextField<String>();

    private TextField<String> pms_nr_ano = new TextField<String>();

    private TextField<String> plco_nr_id = new TextField<String>();

    private TextField<String> perc = new TextField<String>();

    private TextField<String> vl_total = new TextField<String>();

    private TextField<String> vl_executado = new TextField<String>();



    public Vw_insumo_plc_pmsInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(13, 2);
        grid.setWidget(0, 0, new Label("obr_nr_id:"));
        grid.setWidget(0, 1, obr_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id_super:"));
        grid.setWidget(1, 1, plc_nr_id_super);

        grid.setWidget(2, 0, new Label("plc_tx_nome_super:"));
        grid.setWidget(2, 1, plc_tx_nome_super);

        grid.setWidget(3, 0, new Label("plc_nr_id:"));
        grid.setWidget(3, 1, plc_nr_id);

        grid.setWidget(4, 0, new Label("plc_tx_nome:"));
        grid.setWidget(4, 1, plc_tx_nome);

        grid.setWidget(5, 0, new Label("ipo_nr_vl_unitario:"));
        grid.setWidget(5, 1, ipo_nr_vl_unitario);

        grid.setWidget(6, 0, new Label("pms_nr_mes:"));
        grid.setWidget(6, 1, pms_nr_mes);

        grid.setWidget(7, 0, new Label("pms_nr_ano:"));
        grid.setWidget(7, 1, pms_nr_ano);

        grid.setWidget(8, 0, new Label("plco_nr_id:"));
        grid.setWidget(8, 1, plco_nr_id);

        grid.setWidget(9, 0, new Label("perc:"));
        grid.setWidget(9, 1, perc);

        grid.setWidget(10, 0, new Label("vl_total:"));
        grid.setWidget(10, 1, vl_total);

        grid.setWidget(11, 0, new Label("vl_executado:"));
        grid.setWidget(11, 1, vl_executado);





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
            param.put("vw_insumo_plc_pmsT.obr_nr_id", obr_nr_id.getValue());

            param.put("vw_insumo_plc_pmsT.plc_nr_id_super", plc_nr_id_super.getValue());

            param.put("vw_insumo_plc_pmsT.plc_tx_nome_super", plc_tx_nome_super.getValue());

            param.put("vw_insumo_plc_pmsT.plc_nr_id", plc_nr_id.getValue());

            param.put("vw_insumo_plc_pmsT.plc_tx_nome", plc_tx_nome.getValue());

            param.put("vw_insumo_plc_pmsT.ipo_nr_vl_unitario", ipo_nr_vl_unitario.getValue());

            param.put("vw_insumo_plc_pmsT.pms_nr_mes", pms_nr_mes.getValue());

            param.put("vw_insumo_plc_pmsT.pms_nr_ano", pms_nr_ano.getValue());

            param.put("vw_insumo_plc_pmsT.plco_nr_id", plco_nr_id.getValue());

            param.put("vw_insumo_plc_pmsT.perc", perc.getValue());

            param.put("vw_insumo_plc_pmsT.vl_total", vl_total.getValue());

            param.put("vw_insumo_plc_pmsT.vl_executado", vl_executado.getValue());

	
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

