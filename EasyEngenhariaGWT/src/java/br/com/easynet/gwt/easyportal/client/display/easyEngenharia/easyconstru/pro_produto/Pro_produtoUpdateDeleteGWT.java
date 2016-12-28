/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pro_produto;

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
 import com.extjs.gxt.ui.client.widget.form.LabelField; 

import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.grp_grupo_produto.Grp_grupo_produtoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.grp_grupo_produto.ListGrupoProdutoGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class Pro_produtoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pro_produto/pro_produtoUpdateDeleteGWT.jsp";    

    private TextField<String> pro_nr_id = new TextField<String>();

    private TextField<String> pro_tx_nome = new TextField<String>();

    private TextField<String> grp_nr_id = new TextField<String>();
    private Pro_produtoTGWT pro_produtoTGWT = new Pro_produtoTGWT();
private Pro_produtoConsultGWT consultGWT = new Pro_produtoConsultGWT();

    private ListBox listGrupo = new ListBox();


   public void addListBoxProduto(){
       try {

       ListGrupoProdutoGWT grupoProdutoGWT = new ListGrupoProdutoGWT();
       grupoProdutoGWT.setListBox(listGrupo);

       EasyAccessURL eaurl = new EasyAccessURL(grupoProdutoGWT);
       String url = Constantes.URL + Grp_grupo_produtoConsultGWT.PAGE;
       eaurl.accessJSon(url);
       } catch (Exception e) {
           e.printStackTrace();
       }

   }


    public Pro_produtoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Pro_produtoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }


    public Pro_produtoUpdateDeleteGWT(){
        this.setSize("40%", "30%");
        this.setHeading("Alterar Produto");
        Grid grid = new Grid(4, 2);

        grid.setWidget(1, 0, new LabelField("Nome:"));
        grid.setWidget(1, 1, pro_tx_nome);
        pro_tx_nome.setWidth("300");

        grid.setWidget(2, 0, new LabelField("Grupo:"));
        grid.setWidget(2, 1, listGrupo);
        getCpMaster().add(grid);

        addListBoxProduto();
    }


    public void load(Pro_produtoTGWT pro_produtoTGWT) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("pro_produtoT.pro_nr_id", pro_produtoTGWT.getPro_nr_id() + "");
            param.put("pro_produtoT.pro_tx_nome", pro_produtoTGWT.getPro_tx_nome() + "");
            param.put("pro_produtoT.grp_nr_id", pro_produtoTGWT.getGrp_nr_id() + "");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        btnAltAction(ce);
    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("pro_produtoT.pro_nr_id", pro_nr_id.getValue());
            param.put("pro_produtoT.pro_tx_nome", pro_tx_nome.getValue());
            param.put("pro_produtoT.grp_nr_id", listGrupo.getValue(listGrupo.getSelectedIndex()));


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
            param.put("pro_produtoT.pro_nr_id", pro_nr_id.getValue());

            param.put("pro_produtoT.pro_tx_nome", pro_tx_nome.getValue());

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
              JSONObject registro = resultado.get("pro_produto").isObject();
            
            int pro_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_id").toString()));
            pro_produtoTGWT.setPro_nr_id(pro_nr_id);
	    this.pro_nr_id.setValue(pro_produtoTGWT.getPro_nr_id() + "");
            String pro_tx_nome =   (EasyContainer.clearAspas(registro.get("pro_tx_nome").toString()));
            pro_produtoTGWT.setPro_tx_nome(pro_tx_nome);
	    this.pro_tx_nome.setValue(pro_produtoTGWT.getPro_tx_nome() + "");
            int grp_nr_id =  Integer.parseInt(EasyContainer.clearAspas(registro.get("grp_nr_id").toString()));
            pro_produtoTGWT.setGrp_nr_id(grp_nr_id);
	    this.grp_nr_id.setValue(pro_produtoTGWT.getGrp_nr_id() + "");
            listGrupo.getValue(getkeyValue(listGrupo, grp_nr_id+""));

	    } catch (Exception e) {}		
        }

    }
}

