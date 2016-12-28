/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.uni_unidade;

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
public class Uni_unidadeInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/uni_unidade/uni_unidadeInsertGWT.jsp";
    private Uni_unidadeConsultGWT consultGWT = new Uni_unidadeConsultGWT();

    public Uni_unidadeConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Uni_unidadeConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> uni_nr_id = new TextField<String>();
    private TextField<String> uni_tx_nome = new TextField<String>();

    public Uni_unidadeInsertGWT() {
        this.setHeading("Cadastro Unidades obra");
        this.setSize("500", "150");
        Grid grid = new Grid(3, 2);

        grid.setWidget(1, 0, new LabelField("Unidade:"));
        grid.setWidget(1, 1, uni_tx_nome);
        uni_tx_nome.setWidth("300");
        uni_tx_nome.setAllowBlank(false);
        getCpMaster().removeAll();
        getCpMaster().add(grid);
        layout();
    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
            btnCadAction(ce);
    }

    @Override
    public void btnLimpartAction(ButtonEvent ce) {
        uni_tx_nome.setValue("");
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");
            param.put("uni_unidadeT.uni_tx_nome", uni_tx_nome.getValue());
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

