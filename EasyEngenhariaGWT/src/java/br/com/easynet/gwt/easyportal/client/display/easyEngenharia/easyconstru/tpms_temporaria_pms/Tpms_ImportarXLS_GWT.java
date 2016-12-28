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
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

/**
 *
 * @author marcos
 */
public class Tpms_ImportarXLS_GWT extends Window implements IListenetResponse {

    private static final String PAGE = "easyEngenharia/easyconstru/tpms_temporaria_pms/importar_xls_pmsGWT.jsp";
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMeses_obraGWT = new ListMes_AnoGWT();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMeses = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    final Tpms_ImportarXLS_GWT importarXLS_GWT = this;
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private MessageBox mb = new MessageBox();
    private LabelField labelMsg = new LabelField();
    private FileUploadField fileUploadField = new FileUploadField();
    private FormPanel frmSubmit = new FormPanel();
    private ComboBox<ModelData> combo = new ComboBox<ModelData>();

    public Tpms_ImportarXLS_GWT() {
        this.setHeading("PMS em Excel");
        this.setSize(415, 215);
        TableLayout layout = new TableLayout(2);
        frmSubmit.setLayout(layout);
        frmSubmit.setHeaderVisible(false);
        layout.setCellPadding(3);
        listObraGWT.povoar();

        frmSubmit.addListener(Events.Submit, new Listener<FormEvent>() {

            public void handleEvent(FormEvent be) {
                JSONValue jsonValue = JSONParser.parse(be.getResultHtml());
                read(jsonValue);
                mb.close();
                for (int i = 0; i < frmSubmit.getItemCount(); i++) {
                    frmSubmit.getItems().get(i).clearState();
                }
            }
        });

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

                    frmSubmit.setAction(Constantes.URL + PAGE);
                    frmSubmit.setEncoding(FormPanel.Encoding.MULTIPART);
                    frmSubmit.setMethod(FormPanel.Method.POST);
                    frmSubmit.setFrame(true);
                    
                    frmSubmit.add(new LabelField("Obra:"));
                    frmSubmit.add(comboObra);
                    frmSubmit.add(new LabelField("Mês:"));
                    frmSubmit.add(comboMeses);
                    frmSubmit.add(new LabelField("Ano:"));
                    frmSubmit.add(comboAno);
                    frmSubmit.add(new LabelField("Arquivo:"));

                    fileUploadField.setWidth("300");
                    fileUploadField.setName("arq_arquivoT.arq_bt_arquivo");
                    fileUploadField.setAllowBlank(false);
                    frmSubmit.add(fileUploadField);

                    ToolBar bar = new ToolBar();
                    bar.setAlignment(HorizontalAlignment.CENTER);
                    Button b = new Button("Importar Arquivo");
                    b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                        public void handleEvent(ButtonEvent be) {
                            importar();
                        }
                    });
                    b.setIcon(ICONS.importation());
                    bar.add(b);
                    frmSubmit.setBottomComponent(bar);
                    importarXLS_GWT.add(frmSubmit);
                    importarXLS_GWT.layout();
                    importarXLS_GWT.doLayout();
                }
            }
        };
        timer.schedule(300);
    }

    public void importar() {
        try {

            HiddenField<String> obra = new HiddenField<String>();
            obra.setName("pms_planilha_medicao_servicoT.obr_nr_id");
            obra.setValue(comboObra.getValue().getObr_nr_id() + "");
            frmSubmit.add(obra);

            HiddenField<String> mes = new HiddenField<String>();
            mes.setName("pms_planilha_medicao_servicoT.pms_nr_mes");
            mes.setValue(comboMeses.getValue().getValue() + "");
            frmSubmit.add(mes);

            HiddenField<String> ano = new HiddenField<String>();
            ano.setName("pms_planilha_medicao_servicoT.pms_nr_ano");
            ano.setValue(comboAno.getValue().getValue() + "");
            frmSubmit.add(ano);

            HiddenField<String> param = new HiddenField<String>();
            param.setName("op");
            param.setValue("importar");
            frmSubmit.add(param);
            frmSubmit.layout();

            frmSubmit.submit();
            mb = MessageBox.wait("Requisicao", "Requisitando a servidor", "Esperando resposta.");
            
        } catch (Exception e) {
        }
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
            if (jsonObject.toString().indexOf("sucesso") > -1) {
                mb.alert("", "Importação efetuada com sucesso!", null);
            } else {
                mb.alert("", jsonObject.toString(), null);
            }
        }
    }
}
