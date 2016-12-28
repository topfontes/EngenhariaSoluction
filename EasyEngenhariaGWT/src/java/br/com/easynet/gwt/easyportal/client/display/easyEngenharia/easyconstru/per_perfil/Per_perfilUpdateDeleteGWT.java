package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.per_perfil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.Portal2GWT;



import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import com.extjs.gxt.ui.client.event.ButtonEvent;

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
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Per_perfilTGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class Per_perfilUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/per_perfil/per_perfilUpdateDeleteGWT.jsp";

    private Per_perfilConsultGWT consultGWT = new Per_perfilConsultGWT();
    private Per_perfilTGWT per_perfilTGWT = new Per_perfilTGWT();
    private Per_perfilUpdateDeleteGWT updateDeleteGWT = this;
    

    private TextField<String> per_tx_nome = new TextField<String>();
    

    private RadioGroup radioGroup = new RadioGroup();
    private Radio ativo = new Radio();
    private Radio inativo = new Radio();


    
    


    public Per_perfilConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Per_perfilConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Per_perfilUpdateDeleteGWT() {
        this.setSize("40%", "150");
        this.setHeading("Alterar Perfil");

        Grid grid = new Grid(5, 2);

        ativo.setBoxLabel("Ativo");
        radioGroup.add(ativo);
        inativo.setBoxLabel("Inativo");
        radioGroup.add(inativo);
        per_tx_nome.setAllowBlank(false);

        grid.setWidget(1, 0, new Label("Nome:"));
        grid.setWidget(1, 1, per_tx_nome);

        grid.setWidget(2, 0, new Label("Status:"));
        grid.setWidget(2, 1, radioGroup);





        getCpMaster().add(grid);
	layout();
    }

    public void load(Per_perfilTGWT per_perfilTGWT) {
        try {
            per_tx_nome.setValue(per_perfilTGWT.getPer_tx_nome());
            this.per_perfilTGWT.setPer_nr_id(per_perfilTGWT.getPer_nr_id());
            this.per_perfilTGWT.setPer_tx_class(per_perfilTGWT.getPer_tx_class());

            if (per_perfilTGWT.getPer_tx_status().equalsIgnoreCase("A")){
                ativo.setValue(true);
            }else
                inativo.setValue(true);
        } catch (Exception ex) {
        }
    }

//    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        if(!isPeenchido()){
            MessageBox.alert("Result", "preencha todos os campos",null );
        }else{
            btnAltAction(ce);
        }
        
    }

//    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDelAction(ce);
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
                       String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
//            url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");

            param.put("per_perfilT.per_nr_id",per_perfilTGWT.getPer_nr_id()+"");

            param.put("per_perfilT.per_tx_nome", per_tx_nome.getValue());
            param.put("per_perfilT.per_tx_status",radioGroup.getValue().getBoxLabel().equalsIgnoreCase("ativo")?"A":"I");
//            param.put("per_perfilT.per_tx_status", per_tx_status.getText());

           param.put("per_perfilT.per_tx_class", per_perfilTGWT.getPer_tx_class());


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);








           
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {

             String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();

            param.put("op", "delete");
            param.put("per_perfilT.per_nr_id", per_perfilTGWT.getPer_nr_id()+"");

 //           param.put("per_perfilT.per_tx_nome", per_tx_nome.getText());

//            param.put("per_perfilT.per_tx_status", per_tx_status.getText());

//            param.put("per_perfilT.per_tx_class", per_tx_class.getText());


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);

        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
      JSONObject jsonObject;
      consultGWT.load();
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            //JSONObject resultado = jsonObject.get("resultado").isObject();
            MessageBox.alert("Result",  jsonObject.get("resultado").toString(),null);
        }
    }

    public boolean isPeenchido() {
        return !("".equals(per_tx_nome.getValue()));
    }
}

