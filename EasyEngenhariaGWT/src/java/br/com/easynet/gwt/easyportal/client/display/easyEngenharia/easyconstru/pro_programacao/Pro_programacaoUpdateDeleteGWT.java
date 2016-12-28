/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.pro_programacao;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
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
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Pro_programacaoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/pro_programacao/pro_programacaoUpdateDeleteGWT.jsp";
    private TextBox pro_nr_id = new TextBox();
    private TextBox obr_nr_id = new TextBox();
    private TextBox pro_nr_mes = new TextBox();
    private TextBox pro_nr_ano = new TextBox();
    private DateField pro_dt_coleta_orcamento = new DateField();
    private DateField pro_dt_coleta_rh = new DateField();
    private DateField pro_dt_analise_inicio = new DateField();
    private DateField pro_dt_analise_final = new DateField();
    private DateField pro_dt_reuniao_engenharia = new DateField();
    private DateField pro_dt_reuniao_diretoria = new DateField();
    private DateField pro_dt_reuniao_geral = new DateField();
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Meses> cbMes = new ComboBox<Meses>();
    private ComboBox<Ano> cbAno = new ComboBox<Ano>();
    private DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
    private Pro_programacaoTGWT pro_programacaoTGWT = new Pro_programacaoTGWT();
    private Pro_programacaoConsultGWT consultGWT = new Pro_programacaoConsultGWT();

    public Pro_programacaoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Pro_programacaoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Pro_programacaoUpdateDeleteGWT() {
        this.setHeading("Alterar Programação");
        this.setSize("530", "410");
        listObraGWT.povoar();
        povoaCombo();
        povoaMesAno();

        Grid grid = new Grid(12, 2);

        grid.setWidget(1, 0, new LabelField("Obra:"));
        grid.setWidget(1, 1, cbObra);

        grid.setWidget(2, 0, new LabelField("Mês:"));
        grid.setWidget(2, 1, cbMes);

        grid.setWidget(3, 0, new LabelField("Ano:"));
        grid.setWidget(3, 1, cbAno);

        grid.setWidget(4, 0, new LabelField("Coleta dos dados da obra:"));
        grid.setWidget(4, 1, pro_dt_coleta_orcamento);

        grid.setWidget(5, 0, new LabelField("Coleta dos dados da obra RH:"));
        grid.setWidget(5, 1, pro_dt_coleta_rh);

        grid.setWidget(6, 0, new LabelField("Análise dos dados e possíveis ajustes:"));
        grid.setWidget(6, 1, getcp());

//        grid.setWidget(7, 0, new LabelField("Coleta dos dados provisórios(Final):"));
//        grid.setWidget(7, 1, pro_dt_analise_final);

        grid.setWidget(7, 0, new LabelField("Reunião com a Engenharia:"));
        grid.setWidget(7, 1, pro_dt_reuniao_engenharia);

        grid.setWidget(8, 0, new LabelField("Reunião com a diretoria:"));
        grid.setWidget(8, 1, pro_dt_reuniao_diretoria);

        grid.setWidget(9, 0, new LabelField("Reunião geral da controladoria:"));
        grid.setWidget(9, 1, pro_dt_reuniao_geral);

        getCpMaster().add(grid);
        layout();
    }

    public ContentPanel getcp(){
        TableLayout layout = new TableLayout(3);
        layout.setCellPadding(2);
        ContentPanel cp = new ContentPanel(layout);
        cp.setHeaderVisible(false);
        cp.setBodyBorder(false);
        cp.add(pro_dt_analise_inicio);
        cp.add(new LabelField(" a "));
        cp.add(pro_dt_analise_final);
        return cp;
    }

    public void povoaMesAno() {
        cbMes.setDisplayField("display");
        cbMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbMes.setAllowBlank(false);
        cbMes.setWidth(100);
        ListStore<Meses> stoereMes = new ListStore<Meses>();
        stoereMes.add(listMes_AnoGWT.getMeses());
        cbMes.setStore(stoereMes);

        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(listMes_AnoGWT.getListAno());
        cbAno.setStore(storeAno);
        cbAno.setDisplayField("display");
        cbAno.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbAno.setAllowBlank(false);
        cbAno.setWidth(60);
    }

    public void povoaCombo() {
        cbObra.setWidth(250);
        cbObra.setDisplayField("obr_tx_nome");
        cbObra.setAllowBlank(false);
        cbObra.setTriggerAction(ComboBox.TriggerAction.ALL);
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {
                    ListStore<Obr_obrasTGWT> store = new ListStore<Obr_obrasTGWT>();
                    cbObra.setStore(listObraGWT.getStore());
                    cbObra.getView().setStore(listObraGWT.getStore());
                    cbObra.getView().refresh();
                    cbObra.setValue(listObraGWT.getTreeObra().get(pro_programacaoTGWT.getObr_nr_id()));
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void load(Pro_programacaoTGWT pro_programacaoTGWT) {
        try {
            this.pro_programacaoTGWT = pro_programacaoTGWT;


            cbMes.setValue(listMes_AnoGWT.getTreeMeses().get(pro_programacaoTGWT.getPro_nr_mes()));

            cbAno.setValue(listMes_AnoGWT.getTreeAno().get(pro_programacaoTGWT.getPro_nr_ano()));

            this.pro_nr_ano.setText(pro_programacaoTGWT.getPro_nr_ano() + "");

            this.pro_dt_coleta_orcamento.setValue(pro_programacaoTGWT.getPro_dt_coleta_orcamento());

            this.pro_dt_coleta_rh.setValue(pro_programacaoTGWT.getPro_dt_coleta_rh());

            this.pro_dt_analise_inicio.setValue(pro_programacaoTGWT.getPro_dt_analise_inicio());

            this.pro_dt_analise_final.setValue(pro_programacaoTGWT.getPro_dt_analise_final());

            this.pro_dt_reuniao_engenharia.setValue(pro_programacaoTGWT.getPro_dt_reuniao_engenharia());

            this.pro_dt_reuniao_diretoria.setValue(pro_programacaoTGWT.getPro_dt_reuniao_diretoria());

            this.pro_dt_reuniao_geral.setValue(pro_programacaoTGWT.getPro_dt_reuniao_geral());



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
            param.put("pro_programacaoT.pro_nr_id", pro_programacaoTGWT.getPro_nr_id() + "");

            param.put("pro_programacaoT.obr_nr_id", cbObra.getValue().getObr_nr_id() + "");

            param.put("pro_programacaoT.pro_nr_mes", cbMes.getValue().getValue() + "");

            param.put("pro_programacaoT.pro_nr_ano", cbAno.getValue().getValue() + "");

            param.put("pro_programacaoT.pro_dt_coleta_orcamento", dtf.format(pro_dt_coleta_orcamento.getValue()));

            param.put("pro_programacaoT.pro_dt_coleta_rh", dtf.format(pro_dt_coleta_rh.getValue()));

            param.put("pro_programacaoT.pro_dt_analise_inicio", dtf.format(pro_dt_analise_inicio.getValue()));

            param.put("pro_programacaoT.pro_dt_analise_final", dtf.format(pro_dt_analise_final.getValue()));

            param.put("pro_programacaoT.pro_dt_reuniao_engenharia", dtf.format(pro_dt_reuniao_engenharia.getValue()));

            param.put("pro_programacaoT.pro_dt_reuniao_diretoria", dtf.format(pro_dt_reuniao_diretoria.getValue()));

            param.put("pro_programacaoT.pro_dt_reuniao_geral", dtf.format(pro_dt_reuniao_geral.getValue()));


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
            param.put("pro_programacaoT.pro_nr_id", pro_programacaoTGWT.getPro_nr_id() + "");
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
                if (msg.indexOf("sucesso") > -1) {
                    consultGWT.load();
                    close();
                }
            }
        }

    }
}
