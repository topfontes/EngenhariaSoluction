/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fat_fator;

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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Fat_fatorUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDeleteGWT.jsp";    

    private TextField<String> fat_nr_id = new TextField<String>();

    private TextField<String> plc_nr_id = new TextField<String>();

    private TextField<String> fat_nr_fator_atual = new TextField<String>();

    private TextField<String> fat_nr_fator_projetado = new TextField<String>();

    private TextField<String> fat_nr_mes = new TextField<String>();

    private TextField<String> fat_nr_ano = new TextField<String>();

    private TextField<String> obr_nr_id = new TextField<String>();


    private Fat_fatorTGWT fat_fatorTGWT = new Fat_fatorTGWT();
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


    public Fat_fatorUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

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

    public void load(Fat_fatorTGWT fat_fatorTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("fat_fatorT.fat_nr_id", fat_fatorTGWT.getFat_nr_id() + "");

            param.put("fat_fatorT.plc_nr_id", fat_fatorTGWT.getPlc_nr_id() + "");

            param.put("fat_fatorT.fat_nr_fator_atual", fat_fatorTGWT.getFat_nr_fator_atual() + "");

            param.put("fat_fatorT.fat_nr_fator_projetado", fat_fatorTGWT.getFat_nr_fator_projetado() + "");

            param.put("fat_fatorT.fat_nr_mes", fat_fatorTGWT.getFat_nr_mes() + "");

            param.put("fat_fatorT.fat_nr_ano", fat_fatorTGWT.getFat_nr_ano() + "");

            param.put("fat_fatorT.obr_nr_id", fat_fatorTGWT.getObr_nr_id() + "");


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

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
//            url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("fat_fatorT.fat_nr_id", fat_nr_id.getValue());

            param.put("fat_fatorT.plc_nr_id", plc_nr_id.getValue());

            param.put("fat_fatorT.fat_nr_fator_atual", fat_nr_fator_atual.getValue());

            param.put("fat_fatorT.fat_nr_fator_projetado", fat_nr_fator_projetado.getValue());

            param.put("fat_fatorT.fat_nr_mes", fat_nr_mes.getValue());

            param.put("fat_fatorT.fat_nr_ano", fat_nr_ano.getValue());

            param.put("fat_fatorT.obr_nr_id", obr_nr_id.getValue());


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
              JSONObject registro = resultado.get("fat_fator").isObject();
            
              int fat_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("fat_nr_id").toString()));
            fat_fatorTGWT.setFat_nr_id(fat_nr_id);
	    this.fat_nr_id.setValue(fat_fatorTGWT.getFat_nr_id() + "");

            int plc_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
            fat_fatorTGWT.setPlc_nr_id(plc_nr_id);
	    this.plc_nr_id.setValue(fat_fatorTGWT.getPlc_nr_id() + "");

            float fat_nr_fator_atual =  Float.parseFloat(EasyContainer.clearAspas(registro.get("fat_nr_fator_atual").toString()));
            fat_fatorTGWT.setFat_nr_fator_atual(fat_nr_fator_atual);
	    this.fat_nr_fator_atual.setValue(fat_fatorTGWT.getFat_nr_fator_atual() + "");

            float fat_nr_fator_projetado =  Float.parseFloat(EasyContainer.clearAspas(registro.get("fat_nr_fator_projetado").toString()));
            fat_fatorTGWT.setFat_nr_fator_projetado(fat_nr_fator_projetado);
	    this.fat_nr_fator_projetado.setValue(fat_fatorTGWT.getFat_nr_fator_projetado() + "");

            int fat_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("fat_nr_mes").toString()));
            fat_fatorTGWT.setFat_nr_mes(fat_nr_mes);
	    this.fat_nr_mes.setValue(fat_fatorTGWT.getFat_nr_mes() + "");

            int fat_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("fat_nr_ano").toString()));
            fat_fatorTGWT.setFat_nr_ano(fat_nr_ano);
	    this.fat_nr_ano.setValue(fat_fatorTGWT.getFat_nr_ano() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            fat_fatorTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setValue(fat_fatorTGWT.getObr_nr_id() + "");



	    } catch (Exception e) {}		
        }

    }
}

