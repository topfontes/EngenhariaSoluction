/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.tpms_temporaria_pms;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

/**
 *
 * @author marcos
 */
public class Tpms_GerarXLS_GWT extends Window implements IListenetResponse{
    private static final String PAGE = "easyEngenharia/easyconstru/tpms_temporaria_pms/gerar_xls_pmsGWT.jsp";
    private static final String PAGE_DOWNLOAD = "easyEngenharia/easyconstru/download/download.jsp";
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMeses_obraGWT = new ListMes_AnoGWT();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMeses = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ContentPanel cp = new ContentPanel();
    final Tpms_GerarXLS_GWT gerarXLS_GWT = this;
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private MessageBox mb = new MessageBox();
    private LabelField labelMsg = new LabelField();

    public Tpms_GerarXLS_GWT() {
        this.setHeading("Planilha de Medição de Serviços (PMS)");
        this.setSize(375, 170);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        cp.setLayout(layout);
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

                    cp.add(new LabelField("Obra:"));
                    cp.add(comboObra);
                    cp.add(new LabelField("Mês:"));
                    cp.add(comboMeses);
                    cp.add(new LabelField("Ano:"));
                    cp.add(comboAno);
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
    public void gerarArquivo() {
        try {
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("pms_planilha_medicao_servicoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
            param.put("pms_planilha_medicao_servicoT.pms_nr_mes", comboMeses.getValue().getValue() + "");
            param.put("pms_planilha_medicao_servicoT.pms_nr_ano", comboAno.getValue().getValue() + "");
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
                    };t.schedule(2500);
                }
            }; timer.schedule(100);// espera 3 segundos para poder exibir a janela para download do arquivo
            labelMsg.setText("");
    }
    
    public void addComboObra() {
        comboObra.setStore(listObraGWT.getStore());
        comboObra.setValueField("obr_nr_id");
        comboObra.setDisplayField("obr_tx_nome");
        comboObra.setWidth(300);
        comboObra.setEmptyText("Selecione a obra");
        comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboObra.setAllowBlank(false);
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
        comboMeses.setAllowBlank(false);

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
        comboAno.setAllowBlank(false);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.toString().indexOf("sucesso") > -1){
                //mb.alert("", "Aguarde início do download", null);
                labelMsg.setText("Aguarde tela de download............");
                add(labelMsg);
                download();
            }else{
                mb.alert("", jsonObject.toString(), null);
            }

        }

    }

}
