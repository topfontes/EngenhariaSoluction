/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.car_carro;

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
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import com.extjs.gxt.ui.client.event.ButtonEvent;

/**
 *
 * @author geoleite
 */
public class Car_carroInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/car_carro/car_carroInsertGWT.jsp";
    private Car_carroConsultGWT consultGWT = new Car_carroConsultGWT();

    public Car_carroConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Car_carroConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    private TextBox car_tx_nome = new TextBox();
    private TextBox car_tx_marca = new TextBox();

    public Car_carroInsertGWT() {
        
        this.setHeading("Cadastro");

        this.setSize("40%", "30%");
        Grid grid = new Grid(4, 2);
        grid.setWidget(1, 0, new Label("nome:"));
        grid.setWidget(1, 1, car_tx_nome);
        grid.setWidget(2, 0, new Label("marca:"));
        grid.setWidget(2, 1, car_tx_marca);
        getCpMaster().add(grid);
        layout();
    }
    //@Override
    public void btnInsertAction(ButtonEvent ce) {
        btnCadAction(ce);
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");


            param.put("car_carroT.car_tx_nome", car_tx_nome.getText());

            param.put("car_carroT.car_tx_marca", car_tx_marca.getText());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);

            consultGWT.load();
        } catch (Exception ex) {
        }
    }
    
    public void clear(){
        car_tx_nome.setValue("");
        car_tx_marca.setValue("");
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            //JSONObject resultado = jsonObject.get("resultado").isObject();
            Window.alert("Result " + jsonObject.get("resultado").toString());
            if("Cadastro efetuado com sucesso!".equalsIgnoreCase(EasyContainer.clearAspas(jsonObject.get("resultado").toString()))){
                clear();
            }


//            JSONObject msg = resultado.get("mensagem").isObject();
//            Window.alert("Mensagem " + msg.toString());
        }
    }
}
