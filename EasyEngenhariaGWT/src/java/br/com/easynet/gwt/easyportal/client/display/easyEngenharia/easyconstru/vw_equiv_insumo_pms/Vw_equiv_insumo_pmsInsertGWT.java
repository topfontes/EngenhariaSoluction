/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_equiv_insumo_pms;

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
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
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
public class Vw_equiv_insumo_pmsInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_equiv_insumo_pms/vw_equiv_insumo_pmsInsertGWT.jsp";   
    private Vw_equiv_insumo_pmsConsultGWT consultGWT = new Vw_equiv_insumo_pmsConsultGWT();


    public Vw_equiv_insumo_pmsConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_equiv_insumo_pmsConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextBox obr_nr_id = new TextBox();

    private TextBox plc_nr_id = new TextBox();

    private TextBox plc_tx_nome = new TextBox();

    private TextBox insumo = new TextBox();

    private TextBox ipo_nr_vl_unitario = new TextBox();

    private TextBox pms_nr_mes = new TextBox();

    private TextBox pms_nr_ano = new TextBox();

    private TextBox plco_nr_id = new TextBox();

    private TextBox perc = new TextBox();

    private TextBox vl_total = new TextBox();

    private TextBox vl_executado = new TextBox();



    public Vw_equiv_insumo_pmsInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(12, 2);
        grid.setWidget(0, 0, new Label("obr_nr_id:"));
        grid.setWidget(0, 1, obr_nr_id);

        grid.setWidget(1, 0, new Label("plc_nr_id:"));
        grid.setWidget(1, 1, plc_nr_id);

        grid.setWidget(2, 0, new Label("plc_tx_nome:"));
        grid.setWidget(2, 1, plc_tx_nome);

        grid.setWidget(3, 0, new Label("insumo:"));
        grid.setWidget(3, 1, insumo);

        grid.setWidget(4, 0, new Label("ipo_nr_vl_unitario:"));
        grid.setWidget(4, 1, ipo_nr_vl_unitario);

        grid.setWidget(5, 0, new Label("pms_nr_mes:"));
        grid.setWidget(5, 1, pms_nr_mes);

        grid.setWidget(6, 0, new Label("pms_nr_ano:"));
        grid.setWidget(6, 1, pms_nr_ano);

        grid.setWidget(7, 0, new Label("plco_nr_id:"));
        grid.setWidget(7, 1, plco_nr_id);

        grid.setWidget(8, 0, new Label("perc:"));
        grid.setWidget(8, 1, perc);

        grid.setWidget(9, 0, new Label("vl_total:"));
        grid.setWidget(9, 1, vl_total);

        grid.setWidget(10, 0, new Label("vl_executado:"));
        grid.setWidget(10, 1, vl_executado);





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
            param.put("vw_equiv_insumo_pmsT.obr_nr_id", obr_nr_id.getText());

            param.put("vw_equiv_insumo_pmsT.plc_nr_id", plc_nr_id.getText());

            param.put("vw_equiv_insumo_pmsT.plc_tx_nome", plc_tx_nome.getText());

            param.put("vw_equiv_insumo_pmsT.insumo", insumo.getText());

            param.put("vw_equiv_insumo_pmsT.ipo_nr_vl_unitario", ipo_nr_vl_unitario.getText());

            param.put("vw_equiv_insumo_pmsT.pms_nr_mes", pms_nr_mes.getText());

            param.put("vw_equiv_insumo_pmsT.pms_nr_ano", pms_nr_ano.getText());

            param.put("vw_equiv_insumo_pmsT.plco_nr_id", plco_nr_id.getText());

            param.put("vw_equiv_insumo_pmsT.perc", perc.getText());

            param.put("vw_equiv_insumo_pmsT.vl_total", vl_total.getText());

            param.put("vw_equiv_insumo_pmsT.vl_executado", vl_executado.getText());

	
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

