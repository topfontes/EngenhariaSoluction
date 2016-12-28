/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plr_planilha_recebimento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.Portal2GWT;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;

/**
 *
 * @author geoleite
 */
public class Plr_planilha_recebimentoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDeleteGWT.jsp";    

    private TextBox plr_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox plr_nr_mes_ref = new TextBox();

    private TextBox plr_nr_ano_ref = new TextBox();

    private TextBox plr_nr_mes = new TextBox();

    private TextBox plr_nr_ano = new TextBox();

    private TextBox plr_nr_efetuado_pj = new TextBox();

    private TextBox plr_nr_realizado_pf = new TextBox();

    private TextBox plr_nr_realizado_pou = new TextBox();


    private Plr_planilha_recebimentoTGWT plr_planilha_permutaTGWT = new Plr_planilha_recebimentoTGWT();
private Plr_planilha_recebimentoConsultGWT consultGWT = new Plr_planilha_recebimentoConsultGWT();


    public Plr_planilha_recebimentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Plr_planilha_recebimentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Plr_planilha_recebimentoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(10, 2);
        grid.setWidget(0, 0, new Label("plr_nr_id:"));
        grid.setWidget(0, 1, plr_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("plr_nr_mes_ref:"));
        grid.setWidget(2, 1, plr_nr_mes_ref);

        grid.setWidget(3, 0, new Label("plr_nr_ano_ref:"));
        grid.setWidget(3, 1, plr_nr_ano_ref);

        grid.setWidget(4, 0, new Label("plr_nr_mes:"));
        grid.setWidget(4, 1, plr_nr_mes);

        grid.setWidget(5, 0, new Label("plr_nr_ano:"));
        grid.setWidget(5, 1, plr_nr_ano);

        grid.setWidget(6, 0, new Label("plr_nr_efetuado_pj:"));
        grid.setWidget(6, 1, plr_nr_efetuado_pj);

        grid.setWidget(7, 0, new Label("plr_nr_realizado_pf:"));
        grid.setWidget(7, 1, plr_nr_realizado_pf);

        grid.setWidget(8, 0, new Label("plr_nr_realizado_pou:"));
        grid.setWidget(8, 1, plr_nr_realizado_pou);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Plr_planilha_recebimentoTGWT plr_planilha_permutaTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("plr_planilha_permutaT.plr_nr_id", plr_planilha_permutaTGWT.getPlr_nr_id() + "");

            param.put("plr_planilha_permutaT.obr_nr_id", plr_planilha_permutaTGWT.getObr_nr_id() + "");

            param.put("plr_planilha_permutaT.plr_nr_mes_ref", plr_planilha_permutaTGWT.getPlr_nr_mes_ref() + "");

            param.put("plr_planilha_permutaT.plr_nr_ano_ref", plr_planilha_permutaTGWT.getPlr_nr_ano_ref() + "");

            param.put("plr_planilha_permutaT.plr_nr_mes", plr_planilha_permutaTGWT.getPlr_nr_mes() + "");

            param.put("plr_planilha_permutaT.plr_nr_ano", plr_planilha_permutaTGWT.getPlr_nr_ano() + "");

            param.put("plr_planilha_permutaT.plr_nr_efetuado_pj", plr_planilha_permutaTGWT.getPlr_nr_efetuado_pj() + "");

            param.put("plr_planilha_permutaT.plr_nr_realizado_pf", plr_planilha_permutaTGWT.getPlr_nr_realizado_pf() + "");

            param.put("plr_planilha_permutaT.plr_nr_realizado_pou", plr_planilha_permutaTGWT.getPlr_nr_realizado_pou() + "");


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

//    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        btnAltAction(ce);
    }

//    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("plr_planilha_permutaT.plr_nr_id", plr_nr_id.getText());

            param.put("plr_planilha_permutaT.obr_nr_id", obr_nr_id.getText());

            param.put("plr_planilha_permutaT.plr_nr_mes_ref", plr_nr_mes_ref.getText());

            param.put("plr_planilha_permutaT.plr_nr_ano_ref", plr_nr_ano_ref.getText());

            param.put("plr_planilha_permutaT.plr_nr_mes", plr_nr_mes.getText());

            param.put("plr_planilha_permutaT.plr_nr_ano", plr_nr_ano.getText());

            param.put("plr_planilha_permutaT.plr_nr_efetuado_pj", plr_nr_efetuado_pj.getText());

            param.put("plr_planilha_permutaT.plr_nr_realizado_pf", plr_nr_realizado_pf.getText());

            param.put("plr_planilha_permutaT.plr_nr_realizado_pou", plr_nr_realizado_pou.getText());


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
	    consultGWT.load();
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
//            url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("plr_planilha_permutaT.plr_nr_id", plr_nr_id.getText());

            param.put("plr_planilha_permutaT.obr_nr_id", obr_nr_id.getText());

            param.put("plr_planilha_permutaT.plr_nr_mes_ref", plr_nr_mes_ref.getText());

            param.put("plr_planilha_permutaT.plr_nr_ano_ref", plr_nr_ano_ref.getText());

            param.put("plr_planilha_permutaT.plr_nr_mes", plr_nr_mes.getText());

            param.put("plr_planilha_permutaT.plr_nr_ano", plr_nr_ano.getText());

            param.put("plr_planilha_permutaT.plr_nr_efetuado_pj", plr_nr_efetuado_pj.getText());

            param.put("plr_planilha_permutaT.plr_nr_realizado_pf", plr_nr_realizado_pf.getText());

            param.put("plr_planilha_permutaT.plr_nr_realizado_pou", plr_nr_realizado_pou.getText());


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONObject resultado = jsonObject.get("resultado").isObject();
//            Window.alert("Result " + resultado.toString());
            String msg = EasyContainer.clearAspas(resultado.get("msg").toString());
            if (msg.trim().length() > 0) {
                MessageBox mb = new MessageBox();
                mb.alert("", msg, null);
            }
	    try {
              JSONObject registro = resultado.get("plr_planilha_permuta").isObject();
            
              int plr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plr_nr_id").toString()));
            plr_planilha_permutaTGWT.setPlr_nr_id(plr_nr_id);
	    this.plr_nr_id.setText(plr_planilha_permutaTGWT.getPlr_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            plr_planilha_permutaTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setText(plr_planilha_permutaTGWT.getObr_nr_id() + "");

            int plr_nr_mes_ref =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plr_nr_mes_ref").toString()));
            plr_planilha_permutaTGWT.setPlr_nr_mes_ref(plr_nr_mes_ref);
	    this.plr_nr_mes_ref.setText(plr_planilha_permutaTGWT.getPlr_nr_mes_ref() + "");

            int plr_nr_ano_ref =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plr_nr_ano_ref").toString()));
            plr_planilha_permutaTGWT.setPlr_nr_ano_ref(plr_nr_ano_ref);
	    this.plr_nr_ano_ref.setText(plr_planilha_permutaTGWT.getPlr_nr_ano_ref() + "");

            int plr_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plr_nr_mes").toString()));
            plr_planilha_permutaTGWT.setPlr_nr_mes(plr_nr_mes);
	    this.plr_nr_mes.setText(plr_planilha_permutaTGWT.getPlr_nr_mes() + "");

            int plr_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plr_nr_ano").toString()));
            plr_planilha_permutaTGWT.setPlr_nr_ano(plr_nr_ano);
	    this.plr_nr_ano.setText(plr_planilha_permutaTGWT.getPlr_nr_ano() + "");

            float plr_nr_efetuado_pj =  Float.parseFloat(EasyContainer.clearAspas(registro.get("plr_nr_efetuado_pj").toString()));
            plr_planilha_permutaTGWT.setPlr_nr_efetuado_pj(plr_nr_efetuado_pj);
	    this.plr_nr_efetuado_pj.setText(plr_planilha_permutaTGWT.getPlr_nr_efetuado_pj() + "");

            float plr_nr_realizado_pf =  Float.parseFloat(EasyContainer.clearAspas(registro.get("plr_nr_realizado_pf").toString()));
            plr_planilha_permutaTGWT.setPlr_nr_realizado_pf(plr_nr_realizado_pf);
	    this.plr_nr_realizado_pf.setText(plr_planilha_permutaTGWT.getPlr_nr_realizado_pf() + "");

            float plr_nr_realizado_pou =  Float.parseFloat(EasyContainer.clearAspas(registro.get("plr_nr_realizado_pou").toString()));
            plr_planilha_permutaTGWT.setPlr_nr_realizado_pou(plr_nr_realizado_pou);
	    this.plr_nr_realizado_pou.setText(plr_planilha_permutaTGWT.getPlr_nr_realizado_pou() + "");



	    } catch (Exception e) {}		
        }

    }
}

