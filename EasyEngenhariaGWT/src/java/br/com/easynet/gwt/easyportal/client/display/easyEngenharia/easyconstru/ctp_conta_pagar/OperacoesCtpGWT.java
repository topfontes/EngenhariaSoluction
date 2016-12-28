/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ctp_conta_pagar;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

/**
 *
 * @author marcos
 */
public class OperacoesCtpGWT extends Window implements IListenetResponse {

    private final String PAGE = "easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarUpdateDeleteGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private TabPanel tabPanel = new TabPanel();
    private RadioGroup statusOrigen = new RadioGroup();
    private RadioGroup status = new RadioGroup();
    private ComboBox<Obr_obrasTGWT> comboObraOrig = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMesOrig = new ComboBox<Meses>();
    private ComboBox<Ano> comboAnoOrig = new ComboBox<Ano>();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private Button btnDel = new Button("Limpar");
    private Button btnAlter = new Button("Subistituir");
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private TableLayout layout = new TableLayout(1);
    private TableLayout layoutOrig = new TableLayout(1);

    public OperacoesCtpGWT() {
        this.setHeading("Ooperações Conta A Pagar/Pagas");
        this.setSize(300, 350);
        listObraGWT.povoar();

        layout.setCellPadding(4);
        layoutOrig.setCellPadding(4);
        cp.setHeading("Dados Original");
        cp.setLayout(layoutOrig);
        montarTela();
        btnAlter.setIcon(ICONS.update());
        btnDel.setIcon(ICONS.del());

        btnAlter.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                MessageBox mb = MessageBox.confirm("Aviso", "Deseja atualizar os itens informados?", new Listener<MessageBoxEvent>() {

                    public void handleEvent(MessageBoxEvent be) {
                        if ("yes".equalsIgnoreCase(be.getButtonClicked().getText()) || "Sim".equalsIgnoreCase(be.getButtonClicked().getText())) {
                            update();
                        }
                    }
                });
            }
        });

        btnDel.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                MessageBox mb = MessageBox.confirm("Aviso", "Deseja Apagar os itens informados ?", new Listener<MessageBoxEvent>() {

                    public void handleEvent(MessageBoxEvent be) {
                        if ("yes".equalsIgnoreCase(be.getButtonClicked().getText()) || "Sim".equalsIgnoreCase(be.getButtonClicked().getText())) {
                            delete();
                        }
                    }
                });
            }
        });


    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {
                    povoaComboObraOrig();
                    povoaComboMesOrig();
                    povoaAnoOrig();
                    povoaComboObra();
                    povoaComboMes();
                    povoaAno();
                    cp.add(comboObraOrig);
                    cp.add(comboMesOrig);
                    cp.add(comboAnoOrig);

                    Radio apagarOrig = new Radio();
                    apagarOrig.setBoxLabel("A Pagar");
                    apagarOrig.setValue(true);
                    Radio pagasOrig = new Radio();
                    pagasOrig.setBoxLabel("Pagas");
                    statusOrigen.add(pagasOrig);
                    statusOrigen.add(apagarOrig);
                    cp.add(statusOrigen);
                    ToolBar bar = new ButtonBar();
                    bar.setAlignment(HorizontalAlignment.CENTER);
                    bar.add(btnDel);
                    cp.setBottomComponent(bar);
                    add(cp);

                    ContentPanel panel = new ContentPanel(layout);
                    panel.setHeading("Substituir por:");
                    panel.add(comboObra);
                    panel.add(comboMes);
                    panel.add(comboAno);
                    Radio apagar = new Radio();
                    apagar.setBoxLabel("A Pagar");
                    apagar.setValue(true);
                    Radio pagas = new Radio();
                    pagas.setBoxLabel("Pagas");
                    status.add(pagas);
                    status.add(apagar);
                    panel.add(status);
                    ToolBar bar1 = new ButtonBar();
                    bar1.setAlignment(HorizontalAlignment.CENTER);
                    bar1.add(btnAlter);

                    panel.setBottomComponent(bar1);
                    add(panel);
                    layout();
                    doLayout();

                }
            }
        };
        timer.schedule(500);
    }

    public void povoaComboMesOrig() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        comboMesOrig.setStore(store);
        comboMesOrig.setDisplayField("display");
        comboMesOrig.setFieldLabel("Mês");
        comboMesOrig.setAllowBlank(false);
        comboMesOrig.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboMesOrig.setEmptyText("Selecione a Mês");
        comboMesOrig.setWidth(250);
    }

    public void povoaAnoOrig() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMes_AnoGWT.getListAno());
        comboAnoOrig.setStore(store);
        comboAnoOrig.setAllowBlank(false);
        comboAnoOrig.setDisplayField("display");
        comboAnoOrig.setFieldLabel("Ano");
        comboAnoOrig.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboAnoOrig.setEmptyText("Selecione a Ano");
        comboAnoOrig.setWidth(250);
    }

    public void povoaComboObraOrig() {
        try {
            comboObraOrig.setStore(listObraGWT.getStore());
            comboObraOrig.setDisplayField("obr_tx_nome");
            comboObraOrig.setAllowBlank(true);
            comboObraOrig.setAllowBlank(false);
            comboObraOrig.setTriggerAction(ComboBox.TriggerAction.ALL);
            comboObraOrig.setEmptyText("Selecione a Obra");
            comboObraOrig.setWidth(250);
        } catch (Exception e) {
        }
    }

    public void povoaComboMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(store);
        comboMes.setDisplayField("display");
        comboMes.setFieldLabel("Mês");
        //comboMes.setAllowBlank(false);
        comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboMes.setEmptyText("Selecione a Mês");
        comboMes.setWidth(250);
    }

    public void povoaAno() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(store);
        //comboAno.setAllowBlank(false);
        comboAno.setDisplayField("display");
        comboAno.setFieldLabel("Ano");
        comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboAno.setEmptyText("Selecione a Ano");
        comboAno.setWidth(250);
    }

    public void povoaComboObra() {
        try {
            comboObra.setStore(listObraGWT.getStore());
            comboObra.setDisplayField("obr_tx_nome");
            //comboObra.setAllowBlank(true);
          //  comboObra.setAllowBlank(false);
            comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
            comboObra.setEmptyText("Selecione a Obra");
            comboObra.setWidth(250);
        } catch (Exception e) {
        }
    }

    public void delete() {
        String strStstusOrig = statusOrigen.getValue().getBoxLabel().equalsIgnoreCase("pagas") ? "P" : "A";

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "deleteAllObra");
        param.put("ctp_conta_pagarTOrig.obr_nr_id", comboObraOrig.getValue().getObr_nr_id() + "");
        param.put("ctp_conta_pagarTOrig.ctp_nr_mes", comboMesOrig.getValue().getValue() + "");
        param.put("ctp_conta_pagarTOrig.ctp_nr_ano", comboAnoOrig.getValue().getValue() + "");
        param.put("ctp_conta_pagarTOrig.ctp_tx_status", strStstusOrig);
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception e) {
        }

    }

    public void update() {
        String strStstusOrig = statusOrigen.getValue().getBoxLabel().equalsIgnoreCase("pagas") ? "P" : "A";
        String strStstus = status.getValue().getBoxLabel().equalsIgnoreCase("pagas") ? "P" : "A";
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "updateObraMesAno");
        param.put("ctp_conta_pagarTOrig.obr_nr_id", comboObraOrig.getValue().getObr_nr_id() + "");
        param.put("ctp_conta_pagarTOrig.ctp_nr_mes", comboMesOrig.getValue().getValue() + "");
        param.put("ctp_conta_pagarTOrig.ctp_nr_ano", comboAnoOrig.getValue().getValue() + "");
        param.put("ctp_conta_pagarTOrig.ctp_tx_status", strStstusOrig);

        param.put("ctp_conta_pagarT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
        param.put("ctp_conta_pagarT.ctp_nr_mes", comboMes.getValue().getValue() + "");
        param.put("ctp_conta_pagarT.ctp_nr_ano", comboAno.getValue().getValue() + "");
        param.put("ctp_conta_pagarT.ctp_tx_status", strStstus);
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception e) {
        }

    }

    public void read(JSONValue jsonValue) {
        if (jsonValue.toString().indexOf("sucesso") > - 1) {
            MessageBox mb = new MessageBox();
            mb.alert("", "Operação efetuada com sucesso !!!!", null);
            comboAno.setValue(null);
            comboAnoOrig.setValue(null);
            comboMes.setValue(null);
            comboMesOrig.setValue(null);
            comboObra.setValue(null);
            comboObraOrig.setValue(null);

        } else {
            com.google.gwt.user.client.Window.alert("Erro ao tentar executar a operação");
        }
    }
}
