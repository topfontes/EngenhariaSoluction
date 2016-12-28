/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fto_fotos;

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

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;

/**
 *
 * @author geoleite
 */
public class Fto_fotosUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fto_fotos/fto_fotosUpdateDeleteGWT.jsp";    

    private TextBox fto_nr_id = new TextBox();

    private TextBox obr_nr_id = new TextBox();

    private TextBox fto_nr_mes = new TextBox();

    private TextBox fto_nr_ano = new TextBox();

    private TextBox fto_bt_foto = new TextBox();


    private Fto_fotosTGWT fto_fotosTGWT = new Fto_fotosTGWT();
private Fto_fotosConsultGWT consultGWT = new Fto_fotosConsultGWT();


    public Fto_fotosConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Fto_fotosConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Fto_fotosUpdateDeleteGWT() {
        this.setSize("40%", "30%");
        this.setHeading("Alterar");

        Grid grid = new Grid(6, 2);
        grid.setWidget(0, 0, new Label("fto_nr_id:"));
        grid.setWidget(0, 1, fto_nr_id);

        grid.setWidget(1, 0, new Label("obr_nr_id:"));
        grid.setWidget(1, 1, obr_nr_id);

        grid.setWidget(2, 0, new Label("fto_nr_mes:"));
        grid.setWidget(2, 1, fto_nr_mes);

        grid.setWidget(3, 0, new Label("fto_nr_ano:"));
        grid.setWidget(3, 1, fto_nr_ano);

        grid.setWidget(4, 0, new Label("fto_bt_foto:"));
        grid.setWidget(4, 1, fto_bt_foto);




        getCpMaster().add(grid);
	layout();
    }

    public void load(Fto_fotosTGWT fto_fotosTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("fto_fotosT.fto_nr_id", fto_fotosTGWT.getFto_nr_id() + "");

            param.put("fto_fotosT.obr_nr_id", fto_fotosTGWT.getObr_nr_id() + "");

            param.put("fto_fotosT.fto_nr_mes", fto_fotosTGWT.getFto_nr_mes() + "");

            param.put("fto_fotosT.fto_nr_ano", fto_fotosTGWT.getFto_nr_ano() + "");

            param.put("fto_fotosT.fto_bt_foto", fto_fotosTGWT.getFto_bt_foto() + "");


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
            param.put("fto_fotosT.fto_nr_id", fto_nr_id.getText());

            param.put("fto_fotosT.obr_nr_id", obr_nr_id.getText());

            param.put("fto_fotosT.fto_nr_mes", fto_nr_mes.getText());

            param.put("fto_fotosT.fto_nr_ano", fto_nr_ano.getText());

            param.put("fto_fotosT.fto_bt_foto", fto_bt_foto.getText());


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
            param.put("fto_fotosT.fto_nr_id", fto_nr_id.getText());

            param.put("fto_fotosT.obr_nr_id", obr_nr_id.getText());

            param.put("fto_fotosT.fto_nr_mes", fto_nr_mes.getText());

            param.put("fto_fotosT.fto_nr_ano", fto_nr_ano.getText());

            param.put("fto_fotosT.fto_bt_foto", fto_bt_foto.getText());


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
              JSONObject registro = resultado.get("fto_fotos").isObject();
            
            int fto_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("fto_nr_id").toString()));
            fto_fotosTGWT.setFto_nr_id(fto_nr_id);
	    this.fto_nr_id.setText(fto_fotosTGWT.getFto_nr_id() + "");

            int obr_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
            fto_fotosTGWT.setObr_nr_id(obr_nr_id);
	    this.obr_nr_id.setText(fto_fotosTGWT.getObr_nr_id() + "");

            int fto_nr_mes =  Integer.parseInt(EasyContainer.clearAspas(registro.get("fto_nr_mes").toString()));
            fto_fotosTGWT.setFto_nr_mes(fto_nr_mes);
	    this.fto_nr_mes.setText(fto_fotosTGWT.getFto_nr_mes() + "");

            int fto_nr_ano =  Integer.parseInt(EasyContainer.clearAspas(registro.get("fto_nr_ano").toString()));
            fto_fotosTGWT.setFto_nr_ano(fto_nr_ano);
	    this.fto_nr_ano.setText(fto_fotosTGWT.getFto_nr_ano() + "");

//            Object  fto_bt_foto =   (EasyContainer.clearAspas(registro.get("fto_bt_foto").toString()));
//            fto_fotosTGWT.setFto_bt_foto(fto_bt_foto);
//	    this.fto_bt_foto.setText(fto_fotosTGWT.getFto_bt_foto() + "");



	    } catch (Exception e) {}		
        }

    }
}

