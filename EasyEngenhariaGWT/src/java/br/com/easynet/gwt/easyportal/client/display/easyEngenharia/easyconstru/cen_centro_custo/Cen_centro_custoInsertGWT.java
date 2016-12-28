/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cen_centro_custo;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
 import com.extjs.gxt.ui.client.widget.form.LabelField; 
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.TextField;


/**
 *
 * @author geoleite
 */
public class Cen_centro_custoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoInsertGWT.jsp";   
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
    private TextField<String> cen_tx_nome = new TextField<String>();

    public Cen_centro_custoInsertGWT() {
        this.setSize(500,150);
        this.setHeading("Cadastro Natureza dos Custos");
        Grid grid = new Grid(3, 2);
        grid.setWidget(1, 0, new LabelField("Natureza dos Custos:"));
        grid.setWidget(1, 1, cen_tx_nome);
        cen_tx_nome.setWidth("300");
        getCpMaster().add(grid);
        cen_tx_nome.setAutoValidate(true);
        cen_tx_nome.setAllowBlank(false);
    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        if(cen_tx_nome.getValue().trim().length() == 0){
            getMbMaster().alert("IMPORTANTE", "O campo centro de custo tem preenchimento obrigatório!", null);
        } else{
            btnCadAction(ce);
        }
    }
    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
	    param.put("op", "insert");
            param.put("cen_centro_custoT.cen_tx_nome", cen_tx_nome.getValue());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            consultGWT.load();
            cen_tx_nome.setValue("");
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                getMbMaster().alert("IMPORTANTE", "Cadastro efetuado com sucesso!", null);
                btnLimpartAction(null);
                consultGWT.load();
            } else {
                getShowMsgErro(jsonObject.get("resultado").toString());
            }
        }
    }
}

