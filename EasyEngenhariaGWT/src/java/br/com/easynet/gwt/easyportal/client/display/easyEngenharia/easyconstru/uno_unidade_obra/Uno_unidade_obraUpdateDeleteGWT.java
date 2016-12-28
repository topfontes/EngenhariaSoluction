/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uno_unidade_obra;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import com.extjs.gxt.ui.client.widget.form.TextField;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.Obr_obrasConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uni_unidade.ListUnidadeGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uni_unidade.Uni_unidadeConsultGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class Uno_unidade_obraUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraUpdateDeleteGWT.jsp";
    private TextField<String> uno_nr_id = new TextField<String>();
    private ListBox listObra = new ListBox();
    private ListBox listUnidade = new ListBox();
    private NumberField uno_nr_quantidade = new NumberField();
    private NumberField uno_nr_area_construida = new NumberField();
    private Uno_unidade_obraTGWT uno_unidade_obraTGWT = new Uno_unidade_obraTGWT();
    private Uno_unidade_obraConsultGWT consultGWT = new Uno_unidade_obraConsultGWT();

    public Uno_unidade_obraConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Uno_unidade_obraConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public void addlistObra() {
        try {
            ListObraGWT listObraGWT = new ListObraGWT();
            listObraGWT.setListBox(listObra);
            EasyAccessURL eaurl = new EasyAccessURL(listObraGWT);
            eaurl.accessJSon(Constantes.URL + Obr_obrasConsultGWT.PAGE);
            listObra.setWidth("200");
        } catch (Exception e) {
        }

    }

    public void addlistUnidade() {
        try {
            ListUnidadeGWT unidadeGWT = new ListUnidadeGWT();
            //unidadeGWT.setListBox(listUnidade);
            EasyAccessURL eaurl = new EasyAccessURL(unidadeGWT);
            eaurl.accessJSon(Constantes.URL + Uni_unidadeConsultGWT.PAGE);
            listUnidade.setWidth("200");
        } catch (Exception e) {
        }
    }

    public Uno_unidade_obraUpdateDeleteGWT() {

        this.setHeading("Alterar Unidade Obra");
        this.setSize(400, 210);
        Grid grid = new Grid(6, 2);


        grid.setWidget(1, 0, new LabelField("Obra:"));
        grid.setWidget(1, 1, listObra);

        grid.setWidget(2, 0, new LabelField("Unidade:"));
        grid.setWidget(2, 1, listUnidade);

        grid.setWidget(3, 0, new LabelField("Quantidade:"));
        grid.setWidget(3, 1, uno_nr_quantidade);

        grid.setWidget(4, 0, new LabelField("Area construida:"));
        grid.setWidget(4, 1, uno_nr_area_construida);

        getCpMaster().add(grid);

        addlistObra();
        addlistUnidade();

        layout();
    }

    public void load(Uno_unidade_obraTGWT uno_unidade_obraTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("uno_unidade_obraT.uno_nr_id", uno_unidade_obraTGWT.getUno_nr_id() + "");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        if (valido()) {
            btnAltAction(ce);
        }
    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    public boolean valido() {
        boolean result = true;
        if (listObra.getSelectedIndex() < 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo obra tem preenchimento obrigatório");
        } else if (listUnidade.getSelectedIndex() < 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo unidade tem preenchimento obrigatório");
        } else if (uno_nr_quantidade.getValue().floatValue() <= 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo quantidade tem preenchimento obrigatório");
        }
        return result;
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("uno_unidade_obraT.uno_nr_id", uno_nr_id.getValue());
            param.put("uno_unidade_obraT.obr_nr_id", listObra.getValue(listObra.getSelectedIndex()));
            param.put("uno_unidade_obraT.uni_nr_id", listUnidade.getValue(listUnidade.getSelectedIndex()));
            param.put("uno_unidade_obraT.uno_nr_quantidade", uno_nr_quantidade.getValue() + "");
            param.put("uno_unidade_obraT.uno_nr_area_construida", uno_nr_area_construida.getValue() + "");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            consultGWT.load();
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("uno_unidade_obraT.uno_nr_id", uno_nr_id.getValue());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String msg = EasyContainer.clearAspas(resultado.get("msg").toString());
            if (msg.trim().length() > 0) {
                MessageBox mb = new MessageBox();
                mb.alert("", msg, null);
            }
            try {
                JSONObject registro = resultado.get("uno_unidade_obra").isObject();

                int uno_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("uno_nr_id").toString()));
                uno_unidade_obraTGWT.setUno_nr_id(uno_nr_id);
                this.uno_nr_id.setValue(uno_unidade_obraTGWT.getUno_nr_id() + "");

                int obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                uno_unidade_obraTGWT.setObr_nr_id(obr_nr_id);
                this.listObra.setSelectedIndex(getkeyValue(listObra, uno_unidade_obraTGWT.getObr_nr_id() + ""));

                String uni_nr_id = (EasyContainer.clearAspas(registro.get("uni_nr_id").toString()));
                uno_unidade_obraTGWT.setUni_nr_id(Integer.parseInt(uni_nr_id));
                this.listUnidade.setSelectedIndex(getkeyValue(listUnidade, uni_nr_id + ""));

                int uno_nr_quantidade = Integer.parseInt(EasyContainer.clearAspas(registro.get("uno_nr_quantidade").toString()));
                uno_unidade_obraTGWT.setUno_nr_quantidade(uno_nr_quantidade);
                this.uno_nr_quantidade.setValue(uno_unidade_obraTGWT.getUno_nr_quantidade());

                float uno_nr_area_construida = Float.parseFloat(EasyContainer.clearAspas(registro.get("uno_nr_area_construida").toString()));
                uno_unidade_obraTGWT.setUno_nr_area_construida(uno_nr_area_construida);
                this.uno_nr_area_construida.setValue(uno_unidade_obraTGWT.getUno_nr_area_construida());


            } catch (Exception e) {
            }
        }

    }
}

