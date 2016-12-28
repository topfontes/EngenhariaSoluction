/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_importacao_orcamento;

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

import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;

/**
 *
 * @author geoleite
 */
public class Vw_importacao_orcamentoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDeleteGWT.jsp";    

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


    private Vw_importacao_orcamentoTGWT vw_importacao_orcamentoTGWT = new Vw_importacao_orcamentoTGWT();
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


    public Vw_importacao_orcamentoUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

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

    public void load(Vw_importacao_orcamentoTGWT vw_importacao_orcamentoTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("vw_importacao_orcamentoT.plco_tx_nome", vw_importacao_orcamentoTGWT.getPlco_tx_nome() + "");

            param.put("vw_importacao_orcamentoT.plco_tx_tipo", vw_importacao_orcamentoTGWT.getPlco_tx_tipo() + "");

            param.put("vw_importacao_orcamentoT.plco_tx_unidade", vw_importacao_orcamentoTGWT.getPlco_tx_unidade() + "");

            param.put("vw_importacao_orcamentoT.ipo_nr_quantidade", vw_importacao_orcamentoTGWT.getIpo_nr_quantidade() + "");

            param.put("vw_importacao_orcamentoT.ipo_nr_vl_unitario", vw_importacao_orcamentoTGWT.getIpo_nr_vl_unitario() + "");

            param.put("vw_importacao_orcamentoT.ipo_nr_vl_total", vw_importacao_orcamentoTGWT.getIpo_nr_vl_total() + "");

            param.put("vw_importacao_orcamentoT.plco_nr_id", vw_importacao_orcamentoTGWT.getPlco_nr_id() + "");

            param.put("vw_importacao_orcamentoT.ipo_plc_nr_id_servico", vw_importacao_orcamentoTGWT.getIpo_plc_nr_id_servico() + "");

            param.put("vw_importacao_orcamentoT.plco_tx_cod_externo", vw_importacao_orcamentoTGWT.getPlco_tx_cod_externo() + "");

            param.put("vw_importacao_orcamentoT.obr_nr_id", vw_importacao_orcamentoTGWT.getObr_nr_id() + "");

            param.put("vw_importacao_orcamentoT.plco_nr_nivel", vw_importacao_orcamentoTGWT.getPlco_nr_nivel() + "");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

//    @Override
    public void btnUpdateAction(ToolBarEvent ce) {
        btnAltAction(ce);
    }

//    @Override
    public void btnDeltAction(ToolBarEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ToolBarEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
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

    private void btnDelAction(ToolBarEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
//            url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
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
              JSONObject registro = resultado.get("vw_importacao_orcamento").isObject();
            
              String plco_tx_nome =   (EasyContainer.clearAspas(registro.get("plco_tx_nome").toString()));
            vw_importacao_orcamentoTGWT.setPlco_tx_nome(plco_tx_nome);
	    this.plco_tx_nome.setValue(vw_importacao_orcamentoTGWT.getPlco_tx_nome() + "");

            String plco_tx_tipo =   (EasyContainer.clearAspas(registro.get("plco_tx_tipo").toString()));
            vw_importacao_orcamentoTGWT.setPlco_tx_tipo(plco_tx_tipo);
	    this.plco_tx_tipo.setValue(vw_importacao_orcamentoTGWT.getPlco_tx_tipo() + "");

            String plco_tx_unidade =   (EasyContainer.clearAspas(registro.get("plco_tx_unidade").toString()));
            vw_importacao_orcamentoTGWT.setPlco_tx_unidade(plco_tx_unidade);
	    this.plco_tx_unidade.setValue(vw_importacao_orcamentoTGWT.getPlco_tx_unidade() + "");

            float ipo_nr_quantidade =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_quantidade").toString()));
            vw_importacao_orcamentoTGWT.setIpo_nr_quantidade(ipo_nr_quantidade);
	    this.ipo_nr_quantidade.setValue(vw_importacao_orcamentoTGWT.getIpo_nr_quantidade() + "");

            float ipo_nr_vl_unitario =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_unitario").toString()));
            vw_importacao_orcamentoTGWT.setIpo_nr_vl_unitario(ipo_nr_vl_unitario);
	    this.ipo_nr_vl_unitario.setValue(vw_importacao_orcamentoTGWT.getIpo_nr_vl_unitario() + "");

            float ipo_nr_vl_total =  Float.parseFloat(EasyContainer.clearAspas(registro.get("ipo_nr_vl_total").toString()));
            vw_importacao_orcamentoTGWT.setIpo_nr_vl_total(ipo_nr_vl_total);
	    this.ipo_nr_vl_total.setValue(vw_importacao_orcamentoTGWT.getIpo_nr_vl_total() + "");

            int plco_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
            vw_importacao_orcamentoTGWT.setPlco_nr_id(plco_nr_id);
	    this.plco_nr_id.setValue(vw_importacao_orcamentoTGWT.getPlco_nr_id() + "");

            int ipo_plc_nr_id_servico =  Integer.parseInt(EasyContainer.clearAspas(registro.get("ipo_plc_nr_id_servico").toString()));
            vw_importacao_orcamentoTGWT.setIpo_plc_nr_id_servico(ipo_plc_nr_id_servico);
	    this.ipo_plc_nr_id_servico.setValue(vw_importacao_orcamentoTGWT.getIpo_plc_nr_id_servico() + "");

            String plco_tx_cod_externo =   (EasyContainer.clearAspas(registro.get("plco_tx_cod_externo").toString()));
            vw_importacao_orcamentoTGWT.setPlco_tx_cod_externo(plco_tx_cod_externo);
	    this.plco_tx_cod_externo.setValue(vw_importacao_orcamentoTGWT.getPlco_tx_cod_externo() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            vw_importacao_orcamentoTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setValue(vw_importacao_orcamentoTGWT.getObr_nr_id() + "");

            int plco_nr_nivel =  Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_nivel").toString()));
            vw_importacao_orcamentoTGWT.setPlco_nr_nivel(plco_nr_nivel);
	    this.plco_nr_nivel.setValue(vw_importacao_orcamentoTGWT.getPlco_nr_nivel() + "");



	    } catch (Exception e) {}		
        }

    }
}

