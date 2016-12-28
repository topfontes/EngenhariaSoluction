/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.est_estoque;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Ume_unidade_medidaTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ume_unidade_medida.ListUnidadeMedidaGWT;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author geoleite
 */
public class Est_estoqueInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/est_estoque/est_estoqueInsertGWT.jsp";
    private Est_estoqueConsultGWT consultGWT = new Est_estoqueConsultGWT();

    public Est_estoqueConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Est_estoqueConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> est_nr_id = new TextField<String>();
    private TextField<String> est_nr_mes = new TextField<String>();
    private TextField<String> est_tx_nome = new TextField<String>();
    private TextField<String> plc_nr_id = new TextField<String>();
    private TextField<String> est_tx_unidade = new TextField<String>();
    private NumberField est_nr_quantidade = new NumberField();
    private NumberField est_nr_vl_unitario = new NumberField();
    private NumberField est_nr_vl_total = new NumberField();
    private ListBox listUniMedida = new ListBox();
    private TextField<String> obr_nr_id = new TextField<String>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ComboBox<Plc_plano_contasTGWT> comboSubClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ComboBox<Ume_unidade_medidaTGWT> comboUnidade = new ComboBox<Ume_unidade_medidaTGWT>();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ListUnidadeMedidaGWT listUnidadeMedidaGWT = new ListUnidadeMedidaGWT();
    private VerticalPanel vp = new VerticalPanel();
    private ToolBar barOperacao = new ToolBar();
    private ContentPanel cpConteudo = new ContentPanel();


    public Est_estoqueInsertGWT() {
        this.setHeading("Entrada de Estoque");
        this.setSize(446, 355);

        listObraGWT.povoar();
        listPlc_planoContasGWT.povoa();
        listUnidadeMedidaGWT.povoa();

        this.setSize(550, 280);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        cpConteudo.setLayout(layout);
        cpConteudo.setHeaderVisible(false);

        est_nr_quantidade.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                calcularTotal();
            }
        });

        est_nr_vl_unitario.addListener(Events.Change, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                calcularTotal();
            }
        });
    }


    public void addListMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(store);
        comboMes.setDisplayField("display");
        comboMes.setAllowBlank(false);
        comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboMes.setWidth("100");
    }

    public void addlistObra() {
        try {
            comboObra.setStore(listObraGWT.getStore());
            comboObra.setDisplayField("obr_tx_nome");
            comboObra.setAllowBlank(false);
            comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
            comboObra.setWidth("220");

        } catch (Exception e) {
        }
    }

    public void addLisClasse() {
        try {
            comboSubClasse.setStore(listPlc_planoContasGWT.getStore());
            comboSubClasse.setAllowBlank(false);
            comboSubClasse.setDisplayField("plc_tx_nome");
            comboSubClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
            comboSubClasse.setWidth("300");
        } catch (Exception e) {
        }
    }

    public void addListAno() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(store);
        comboAno.setDisplayField("display");
        comboAno.setAllowBlank(false);
        comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboAno.setWidth(70);
    }

    public void addlistUnidadeMedida() {
        try {
            comboUnidade.setStore(listUnidadeMedidaGWT.getStore());
            comboUnidade.setDisplayField("ume_tx_nome");
            comboUnidade.setValueField("ume_nr_id");
            comboUnidade.setAllowBlank(false);
            comboUnidade.setTriggerAction(ComboBox.TriggerAction.ALL);
        } catch (Exception e) {
        }
    }

    @Override
    protected void onShow() {
        Timer timer = new Timer() {
            @Override
            public void run() {
                if (!listPlc_planoContasGWT.isInserido()) {
                    schedule(3000);
                } else {
                    addLisClasse();
                    addListMes();
                    addListAno();
                    addlistObra();
                    addlistUnidadeMedida();
                    addToolbarOperacao();
                    cpConteudo.add(new LabelField("Sub Classe:"));
                    cpConteudo.add(comboSubClasse);
                    est_tx_nome.setAllowBlank(false);
                    cpConteudo.add(new LabelField("Nome:"));
                    est_tx_nome.setWidth(220);
                    cpConteudo.add(est_tx_nome);
                    cpConteudo.add(new LabelField("Unidade:"));
                    cpConteudo.add(est_tx_unidade);
                    cpConteudo.add(new LabelField("Quantidade:"));
                    cpConteudo.add(est_nr_quantidade);
                    est_nr_quantidade.setAllowBlank(false);
                    cpConteudo.add(new LabelField("Valor Unitário:"));
                    cpConteudo.add(est_nr_vl_unitario);
                    est_nr_vl_unitario.setAllowBlank(false);
                    cpConteudo.add(new LabelField("Total"));
                    cpConteudo.add(est_nr_vl_total);
                    est_nr_vl_total.setEnabled(false);
                    est_nr_vl_total.setFormat(NumberFormat.getFormat("#,##0.00"));
                    getCpMaster().add(cpConteudo);
                    layout();
                }
            }
        };
        timer.schedule(3000);
    }

    public void addToolbarOperacao() {
        //barOperacao.removeAll();
        barOperacao.add(new LabelToolItem("Obra:"));
        barOperacao.add(comboObra);
        barOperacao.add(new LabelToolItem("Mês:"));
        barOperacao.add(comboMes);
        barOperacao.add(new LabelToolItem("Ano:"));
        barOperacao.add(comboAno);
        cpConteudo.setTopComponent(barOperacao);

    }

    public void calcularTotal() {

        float qtd = 0;
        float vl = 0;

        if (est_nr_quantidade.getValue() != null) {
            qtd = est_nr_quantidade.getValue().floatValue();
        }
        if (est_nr_vl_unitario.getValue() != null) {
            vl = est_nr_vl_unitario.getValue().floatValue();
        }
        est_nr_vl_total.setValue(qtd * vl);
        layout();

    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        if (valido()) {
            btnCadAction(ce);
        }
    }

    public boolean valido() {
        boolean result = true;
        if (comboMes.getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo mês tem preenchimento obrigatório");
        } else if (comboObra.getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo obra tem preenchimento obrigatório");
        } else if (comboSubClasse.getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo sub-classe tem preenchimento obrigatório");
        } else if (comboAno.getValue() == null) {
            result = false;
            Info.display("IMPORTANTE", "O campo ano tem preenchimento obrigatório");
        } else if (est_nr_quantidade.getValue().floatValue() <= 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo quantidade tem preenchimento obrigatório");
        } else if (est_nr_vl_unitario.getValue().floatValue() <= 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo valor unitário tem preenchimento obrigatório");
        } else if (est_nr_vl_total.getValue().floatValue() <= 0) {
            result = false;
            Info.display("IMPORTANTE", "O campo total tem preenchimento obrigatório");
        }

        return result;
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");

            param.put("est_estoqueT.est_nr_mes", comboMes.getValue().getValue()+"");

            param.put("est_estoqueT.plc_nr_id", comboSubClasse.getValue().getPlc_nr_id()+"");

            param.put("est_estoqueT.est_nr_quantidade", est_nr_quantidade.getValue() + "");

            param.put("est_estoqueT.est_nr_vl_unitario", est_nr_vl_unitario.getValue() + "");

            param.put("est_estoqueT.est_nr_vl_total", est_nr_vl_total.getValue() + "");

            param.put("est_estoqueT.est_tx_unidade", est_tx_unidade.getValue());

            param.put("est_estoqueT.obr_nr_id", comboObra.getValue().getObr_nr_id()+"");

            param.put("est_estoqueT.est_nr_ano", comboAno.getValue().getValue()+"");

            param.put("est_estoqueT.est_tx_nome", est_tx_nome.getValue());

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);

        } catch (Exception ex) {
        }
    }

    @Override
    public void btnLimpartAction(ButtonEvent ce) {
        est_nr_quantidade.setValue(null);
        est_nr_vl_total.setValue(null);
        est_nr_vl_unitario.setValue(null);
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

