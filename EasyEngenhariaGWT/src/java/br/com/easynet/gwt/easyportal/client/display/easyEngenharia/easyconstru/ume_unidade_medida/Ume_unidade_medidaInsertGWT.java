/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ume_unidade_medida;

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
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import com.extjs.gxt.ui.client.widget.Info;

/**
 *
 * @author geoleite
 */
public class Ume_unidade_medidaInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaInsertGWT.jsp";
    private Ume_unidade_medidaConsultGWT consultGWT = new Ume_unidade_medidaConsultGWT();

    public Ume_unidade_medidaConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Ume_unidade_medidaConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> ume_nr_id = new TextField<String>();
    private TextField<String> ume_tx_nome = new TextField<String>();

    public Ume_unidade_medidaInsertGWT() {
        this.setHeading("Cadastro");
        this.setSize("500", "150");
        Grid grid = new Grid(3, 2);

        grid.setWidget(1, 0, new LabelField("Cadastro Unidade Médida:"));
        grid.setWidget(1, 1, ume_tx_nome);
        ume_tx_nome.setWidth("300");
        ume_tx_nome.setAllowBlank(false);
        ume_tx_nome.setAllowBlank(false);

        getCpMaster().add(grid);
        this.layout();
    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        if (valido()) {
            btnCadAction(ce);
        }
    }

    @Override
    public void btnLimpartAction(ButtonEvent ce) {
        ume_tx_nome.setValue("");
    }


    public boolean valido() {
        boolean result = true;
        if (ume_tx_nome.getValue().trim().length() == 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo unidade tem preenchimento obrigatório");
        }
        return result;
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");
            param.put("ume_unidade_medidaT.ume_tx_nome", ume_tx_nome.getValue());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            consultGWT.load();
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                getShowMsgCadastro();
                btnLimpartAction(null);
                consultGWT.load();
            } else {
                getShowMsgErro(jsonObject.get("resultado").toString());
            }
        }
    }
}

