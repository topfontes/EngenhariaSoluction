/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar;

import br.com.easynet.gwt.easyportal.client.Ano; 
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListMeses_obraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Grid;
import java.util.HashMap;

/**
 *
 * @author marcos
 */
public class Ctp_conta_pagar_GerarXLS_GWT extends Window implements IListenetResponse {

    private static final String PAGE = "easyEngenharia/easyconstru/ctp_conta_pagar/gerar_xls_conta_pagar.jsp";
    private static final String PAGE_DOWNLOAD = "easyEngenharia/easyconstru/download/download.jsp";
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMeses_obraGWT = new ListMes_AnoGWT();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMeses = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ContentPanel cp = new ContentPanel();
    private RadioGroup radioGroup = new RadioGroup();
    final Ctp_conta_pagar_GerarXLS_GWT gerarXLS_GWT = this;
    private CheckBox chkAcumulado = new CheckBox();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    final Ctp_conta_pagar_GerarXLS_GWT ctp = this;

    public Ctp_conta_pagar_GerarXLS_GWT() {
        this.setHeading("Conta Pagas/A Pagar");
        this.setSize(375, 205);
        listObraGWT.povoar();
        cp.setHeaderVisible(false);
        montar();
    }

    private void montar() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(300);
                } else {
                    addComboAno();
                    addComboObra();
                    addComboMes();
                    Grid grid = new Grid(6, 2);
                    grid.setWidget(1, 0, new LabelField("Obra:"));
                    grid.setWidget(1, 1, comboObra);
                    grid.setWidget(2, 0, new LabelField("Mês:"));
                    grid.setWidget(2, 1, comboMeses);
                    grid.setWidget(3, 0, new LabelField("Ano:"));
                    grid.setWidget(3, 1, comboAno);
                    grid.setWidget(4, 0, null);
                    Radio pagas = new Radio();
                    pagas.setBoxLabel("Pagas");
                    pagas.setValue(true);
                    Radio apagar = new Radio();
                    apagar.setBoxLabel("A pagar");

                    radioGroup.add(pagas);
                    radioGroup.add(apagar);
                    grid.setWidget(4, 1, radioGroup);
                    chkAcumulado.setBoxLabel("Acumulado");
                    chkAcumulado.setValue(true);
                    grid.setWidget(5, 1,chkAcumulado);
                    cp.add(grid);
                    ToolBar bar = new ToolBar();
                    bar.setAlignment(HorizontalAlignment.CENTER);
                    Button b = new Button("Download Arquivo");
                    b.addListener(Events.OnClick, new Listener<ButtonEvent>() {
                        public void handleEvent(ButtonEvent be) {
                            gerarArquivo();
                        }
                    });
                    b.setIcon(ICONS.download());
                    bar.add(b);
                    cp.setBottomComponent(bar);
                    gerarXLS_GWT.add(cp);
                    gerarXLS_GWT.layout();
                }

            }
        };
        timer.schedule(300);
    }

    public void addComboObra() {
        comboObra.setStore(listObraGWT.getStore());
        comboObra.setValueField("obr_nr_id");
        comboObra.setDisplayField("obr_tx_nome");
        comboObra.setWidth(300);
        comboObra.setEmptyText("Selecione a obra");
        comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void addComboMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMeses_obraGWT.getMeses());
        comboMeses.setStore(store);
        comboMeses.setValueField("value");
        comboMeses.setDisplayField("display");
        comboMeses.setWidth(300);
        comboMeses.setEmptyText("Selecione o mês");
        comboMeses.setTriggerAction(ComboBox.TriggerAction.ALL);

    }

    public void addComboAno() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMeses_obraGWT.getListAno());
        comboAno.setStore(store);
        comboAno.setValueField("value");
        comboAno.setDisplayField("display");
        comboAno.setWidth(300);
        comboAno.setEmptyText("Selecione o ano");
        comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void gerarArquivo() {
        try {
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("ctp_conta_pagarT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("ctp_conta_pagarT.ctp_nr_mes", comboMeses.getValue().getValue() + "");
            param.put("ctp_conta_pagarT.ctp_nr_ano", comboAno.getValue().getValue() + "");
            param.put("ctp_conta_pagarT.ctp_tx_status", "Pagas".equalsIgnoreCase(radioGroup.getValue().getBoxLabel()) ? "P" : "A");
            param.put("acumulado", chkAcumulado.getValue()?"1":"0");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception e) {
        }
    }
    public void download(){
            Timer timer = new Timer() {
                @Override
                public void run() {
                    final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
                    winDownload.setUrl(Constantes.URL + PAGE_DOWNLOAD);
                    winDownload.setSize(1, 1);
                    winDownload.setResizable(false);
                    winDownload.show();
                    Timer t = new Timer() {
                        @Override
                        public void run() {
                            winDownload.setVisible(false);
                        }
                    };
                    t.schedule(2500);
                }
            };
            timer.schedule(5000);// espera 3 segundos para poder exibir a janela para download do arquivo
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            JSONObject registro = resultado.get(0).isObject();
            String msg = EasyContainer.clearAspas(registro.get("msg").toString());
            if (msg.trim().length() > 0) {
                MessageBox mb = new MessageBox();
                msg +=", Aguarde a tela de download";
                mb.alert("", msg, null);
                download();
            }
        }

    }
}
