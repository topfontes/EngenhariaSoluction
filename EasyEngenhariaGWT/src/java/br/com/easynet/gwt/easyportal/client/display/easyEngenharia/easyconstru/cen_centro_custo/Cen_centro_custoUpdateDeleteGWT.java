/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cen_centro_custo;

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

import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.Image;
import javax.management.MBeanAttributeInfo;

/**
 *
 * @author geoleite
 */
public class Cen_centro_custoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoUpdateDeleteGWT.jsp";
    private TextField<String> cen_nr_id = new TextField<String>();
    private TextField<String> cen_tx_nome = new TextField<String>();
    private Cen_centro_custoTGWT cen_centro_custoTGWT = new Cen_centro_custoTGWT();
    private Cen_centro_custoConsultGWT consultGWT = new Cen_centro_custoConsultGWT();

    public Cen_centro_custoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Cen_centro_custoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Cen_centro_custoUpdateDeleteGWT() {
        this.setSize(500, 150);
        this.setHeading("Alterar Natureza dos Custos");
        Grid grid = new Grid(3, 2);
        grid.setWidget(1, 0, new LabelField("Natureza dos Custos:"));
        grid.setWidget(1, 1, cen_tx_nome);
        cen_tx_nome.setWidth("300");
        getCpMaster().add(grid);
        cen_tx_nome.setEmptyText("Campo obrigatório!");
        cen_tx_nome.setAllowBlank(false);

        layout();
    }

    public void load(Cen_centro_custoTGWT cen_centro_custoTGWT) {
        try {

            this.cen_centro_custoTGWT = cen_centro_custoTGWT;
            cen_tx_nome.setValue(cen_centro_custoTGWT.getCen_tx_nome());
        } catch (Exception ex) {
        }
    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        if (cen_tx_nome.getValue().trim().length() == 0) {
            getMbMaster().alert("IMPORTANTE", "O campo centro de custo tem preenchimento obrigatório!", null);
        } else {
            btnAltAction(ce);
        }
    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("cen_centro_custoT.cen_nr_id", cen_centro_custoTGWT.getCen_nr_id()+"");
            param.put("cen_centro_custoT.cen_tx_nome", cen_tx_nome.getValue());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("cen_centro_custoT.cen_nr_id", cen_centro_custoTGWT.getCen_nr_id()+"");
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
                String resposta = msg.substring(msg.length() - 9, msg.length()).trim();
                if (resposta.equalsIgnoreCase("sucesso!")) {
                    getMbMaster().alert("", msg, null);
                    consultGWT.load();
                    this.close();
                }else{
                    getMbMaster().alert("IMPORTANTE", msg, null);
                }
            }
        }

    }
}

