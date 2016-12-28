/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.con_contatos;

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

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Con_contatosInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/con_contatos/con_contatosInsertGWT.jsp";   
    private Con_contatosConsultGWT consultGWT = new Con_contatosConsultGWT();


    public Con_contatosConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Con_contatosConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> con_nr_id = new TextField<String>();

    private TextField<String> cli_nr_id = new TextField<String>();

    private TextField<String> con_tx_nome = new TextField<String>();

    private TextField<String> set_nr_id = new TextField<String>();

    private TextField<String> con_tx_cargo_exercicio = new TextField<String>();

    private TextField<String> con_tx_telefone = new TextField<String>();

    private TextField<String> con_tx_telefone2 = new TextField<String>();

    private TextField<String> con_tx_email = new TextField<String>();



    public Con_contatosInsertGWT() {
                this.setHeading("Cadastro");
        this.setSize("40%", "30%");
        Grid grid = new Grid(9, 2);
        grid.setWidget(0, 0, new LabelField("con_nr_id:"));
        grid.setWidget(0, 1, con_nr_id);

        grid.setWidget(1, 0, new LabelField("cli_nr_id:"));
        grid.setWidget(1, 1, cli_nr_id);

        grid.setWidget(2, 0, new LabelField("con_tx_nome:"));
        grid.setWidget(2, 1, con_tx_nome);

        grid.setWidget(3, 0, new LabelField("set_nr_id:"));
        grid.setWidget(3, 1, set_nr_id);

        grid.setWidget(4, 0, new LabelField("con_tx_cargo_exercicio:"));
        grid.setWidget(4, 1, con_tx_cargo_exercicio);

        grid.setWidget(5, 0, new LabelField("con_tx_telefone:"));
        grid.setWidget(5, 1, con_tx_telefone);

        grid.setWidget(6, 0, new LabelField("con_tx_telefone2:"));
        grid.setWidget(6, 1, con_tx_telefone2);

        grid.setWidget(7, 0, new LabelField("con_tx_email:"));
        grid.setWidget(7, 1, con_tx_email);





        getCpMaster().add(grid);
    }
    @Override
    public void btnInsertAction(ButtonEvent ce) {
        btnCadAction(ce);
    }
    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
	    param.put("op", "insert");
            param.put("con_contatosT.con_nr_id", con_nr_id.getValue());

            param.put("con_contatosT.cli_nr_id", cli_nr_id.getValue());

            param.put("con_contatosT.con_tx_nome", con_tx_nome.getValue());

            param.put("con_contatosT.set_nr_id", set_nr_id.getValue());

            param.put("con_contatosT.con_tx_cargo_exercicio", con_tx_cargo_exercicio.getValue());

            param.put("con_contatosT.con_tx_telefone", con_tx_telefone.getValue());

            param.put("con_contatosT.con_tx_telefone2", con_tx_telefone2.getValue());

            param.put("con_contatosT.con_tx_email", con_tx_email.getValue());

	
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

