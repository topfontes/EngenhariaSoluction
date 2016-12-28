/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_comprometimento;

import br.com.easynet.gwt.easyportal.client.Ano;
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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.com_comprometimento.Com_comprometimentoInsertGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Vw_comprometimentoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/vw_comprometimento/vw_comprometimentoInsertGWT.jsp";
    private Vw_comprometimentoConsultGWT consultGWT = new Vw_comprometimentoConsultGWT(false);
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();

    public Vw_comprometimentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Vw_comprometimentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> obr_nr_id = new TextField<String>();
    private TextField<String> com_nr_mes = new TextField<String>();
    private TextField<String> com_nr_ano = new TextField<String>();
    private TextField<String> plc_nr_id = new TextField<String>();
    private TextField<String> plc_tx_nome = new TextField<String>();
    private NumberField com_nr_valor = new NumberField();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Plc_plano_contasTGWT> comboPlc = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    ToolBar toolBar = new ToolBar();
    private boolean previsto;

    public Vw_comprometimentoInsertGWT(boolean previsto) {
        this.previsto = previsto;
        String txt = previsto == true ? " Previsto" : " Realizado";
        this.setHeading("Cadastro comprometimento" + txt);
        this.setSize(550, 200);
        listObraGWT.povoar();
        listPlc_planoContasGWT.povoa();
        getCpMaster().setTopComponent(toolBar);
        montarTela();
        layout();
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(300);
                } else {
                    addCompToolBar();
                    Grid grid = new Grid(4, 2);

                    ListStore<Plc_plano_contasTGWT> storePlc = new ListStore<Plc_plano_contasTGWT>();
                    storePlc.add(listPlc_planoContasGWT.getList());
                    comboPlc.setStore(storePlc);
                    comboPlc.setDisplayField("plc_tx_nome");
                    comboPlc.setEmptyText("Selecione a Sub Classe");
                    comboPlc.setWidth(300);
                    grid.setWidget(1, 0, new LabelField("Sub Classe:"));
                    grid.setWidget(1, 1, comboPlc);
                    grid.setWidget(2, 0, new LabelField("Valor:"));
                    grid.setWidget(2, 1, com_nr_valor);
                    getCpMaster().add(grid);
                    getCpMaster().layout();
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(300);
    }

    public void addCompToolBar() {

        toolBar.add(new LabelToolItem("Obra:"));
        comboObra.setStore(listObraGWT.getStore());
        comboObra.setValueField("obr_nr_id");
        comboObra.setDisplayField("obr_tx_nome");
        comboObra.setEmptyText("Selecione a obra");
        toolBar.add(comboObra);
        toolBar.add(new SeparatorToolItem());

        toolBar.add(new LabelToolItem("Mês:"));
        ListStore<Meses> storemeses = new ListStore<Meses>();
        storemeses.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(storemeses);
        comboMes.setDisplayField("display");
        comboMes.setEmptyText("Selecione o Mês");
        comboMes.setWidth(110);
        toolBar.add(comboMes);
        toolBar.add(new SeparatorToolItem());

        toolBar.add(new LabelToolItem("Ano:"));
        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(storeAno);
        comboAno.setDisplayField("display");
        comboAno.setEmptyText("Selecione o Ano");
        comboAno.setWidth(80);
        toolBar.add(comboAno);

        layout();
    }

//    @Override
    public void btnInsertAction(ButtonEvent ce) {
        btnCadAction(ce);
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + Com_comprometimentoInsertGWT.PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");
            param.put("com_comprometimentoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");

            param.put("com_comprometimentoT.com_nr_mes", comboMes.getValue().getValue() + "");

            param.put("com_comprometimentoT.com_nr_ano", comboAno.getValue().getValue() + "");

            param.put("com_comprometimentoT.plc_nr_id", comboPlc.getValue().getPlc_nr_id() + "");

            param.put("com_comprometimentoT.com_nr_valor", com_nr_valor.getValue() + "");

            param.put("com_comprometimentoT.previsto", previsto + "");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            consultGWT.load();
        } catch (Exception ex) {
        }
    }

    @Override
    public void btnLimpartAction(ButtonEvent ce) {
        comboPlc.setValue(null);
        com_nr_valor.setValue(null);
        comboPlc.focus();
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

