/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pro_produto;

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
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.grp_grupo_produto.Grp_grupo_produtoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.grp_grupo_produto.ListGrupoProdutoGWT;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class Pro_produtoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pro_produto/pro_produtoInsertGWT.jsp";   
    private Pro_produtoConsultGWT consultGWT = new Pro_produtoConsultGWT();


    public Pro_produtoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Pro_produtoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 


    private TextField<String> pro_nr_id = new TextField<String>();
    private TextField<String> pro_tx_nome = new TextField<String>();
    private TextField<String> grp_nr_id = new TextField<String>();
    private ListBox listGrupo = new ListBox();


   public void addListBoxProduto() throws Exception{
       ListGrupoProdutoGWT grupoProdutoGWT = new ListGrupoProdutoGWT();
       grupoProdutoGWT.setListBox(listGrupo);

       EasyAccessURL eaurl = new EasyAccessURL(grupoProdutoGWT);
       String url = Constantes.URL + Grp_grupo_produtoConsultGWT.PAGE;
       eaurl.accessJSon(url);
       
   }
    public Pro_produtoInsertGWT() throws Exception {
        this.setHeading("Cadastro Produto");
        this.setSize("40%", "30%");
        Grid grid = new Grid(4, 2);
        grid.setWidget(1, 0, new LabelField("Nome:"));
        grid.setWidget(1, 1, pro_tx_nome);
        pro_tx_nome.setWidth("300");
        grid.setWidget(2, 0, new LabelField("Grupo:"));
        grid.setWidget(2, 1, listGrupo);
        getCpMaster().add(grid);
        addListBoxProduto();
        this.layout();
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
            param.put("pro_produtoT.pro_nr_id", pro_nr_id.getValue());
            param.put("pro_produtoT.pro_tx_nome", pro_tx_nome.getValue());
            param.put("pro_produtoT.grp_nr_id", listGrupo.getValue(listGrupo.getSelectedIndex()));
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
	    consultGWT.load();
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            Window.alert("Result " + jsonObject.get("resultado").toString());
        }
    }
}

