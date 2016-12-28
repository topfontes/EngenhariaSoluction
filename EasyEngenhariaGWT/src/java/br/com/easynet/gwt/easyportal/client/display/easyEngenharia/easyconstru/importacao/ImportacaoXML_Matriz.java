/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.importacao;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.Obr_obrasConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ListBox;
import java.util.HashMap;

/**
 *
 * @author marcos
 */
public class ImportacaoXML_Matriz extends Window implements IListenetResponse {

    private String page = "xml.jsp";
    private Button importar = new Button("Importar");
    private ListBox listObra = new ListBox();
    private FileUploadField uploadField = new FileUploadField();
    private FormPanel formSubmit = new FormPanel();
    private HiddenField<String> hfOp = new HiddenField<String>();
    private HiddenField<String> idObra = new HiddenField<String>();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private MessageBox mb = new MessageBox();
    private HiddenField<String> hfFile = new HiddenField<String>();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);

    public ImportacaoXML_Matriz() {
        listObraGWT.povoar();
        this.setMinimizable(true);
        this.setHeading("XML Matriz");
        this.setSize(450, 210);
        montarTela();
        layout();
    }

    private void montarTela() {
        Timer timer = new Timer() {
            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {
                    hfOp = new HiddenField<String>();

                    hfOp.setName("op");
                    hfOp.setValue("gerarArquivoXls");
                    formSubmit.add(hfOp);
                    formSubmit.add(hfFile);
                            
                    formSubmit.setHeaderVisible(false);


                    //Definindo campos obrigatorios
                    formSubmit.setAction(Constantes.URL + page);
                    formSubmit.setEncoding(FormPanel.Encoding.MULTIPART);
                    formSubmit.setMethod(FormPanel.Method.POST);
                    formSubmit.setFrame(true);
                    formSubmit.add(uploadField);

                    ContentPanel panel = new ContentPanel();
                    panel.setHeaderVisible(false);
                    panel.setLayout(new FormLayout(LabelAlign.LEFT));
                    panel.setCollapsible(false);
                    //panel.setExpanded(true);

                    VerticalPanel vpUploadFile = new VerticalPanel();

                    povoarComboObra();
                    Grid gridUpload = new Grid(5, 3);

                    gridUpload.setWidget(1, 0, new LabelField("Obra:"));
                    gridUpload.setWidget(1, 1, comboObra);
                    gridUpload.setWidget(2, 0, new LabelField("Arquivo:"));
                    gridUpload.setWidget(2, 1, uploadField);

                    uploadField.setAllowBlank(false);
                    uploadField.setName("arq_arquivoT.arq_bt_arquivo");
                    uploadField.setWidth("300");
                    uploadField.setLabelSeparator("");

                    vpUploadFile.add(gridUpload);

                    ToolBar toolBar = new ButtonBar();
                    toolBar.add(importar);
                    toolBar.setAlignment(HorizontalAlignment.CENTER);
                    panel.add(vpUploadFile);
                    panel.setBottomComponent(toolBar);

                    importar.setIcon(ICONS.exportation());

                    formSubmit.add(panel);
                    add(formSubmit);

                    importar.addListener(Events.OnClick, new Listener<ButtonEvent>() {
                        public void handleEvent(ButtonEvent be) {
                            enviar();
                        }
                    });

                    formSubmit.addListener(Events.Submit, new Listener<FormEvent>() {
                        public void handleEvent(FormEvent be) {
                            com.google.gwt.user.client.Window.alert(be.getResultHtml());
                            JSONValue jsonValue = JSONParser.parse(be.getResultHtml());
                            mb.close();
                            read(jsonValue);
                        }
                    });

                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    private void povoarComboObra() {
        comboObra.setStore(listObraGWT.getStore());
        comboObra.setDisplayField("obr_tx_nome");
        comboObra.setValueField("obr_nr_id");
        comboObra.setAllowBlank(true);
        comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboObra.setWidth(300);
    }

    
    private void enviar() {
        formSubmit.layout();
        hfFile.setName("fileName");
        hfFile.setValue(comboObra.getValue().getObr_tx_nome());

//        mb = MessageBox.wait("Requisicao", "Requisitando a servidor", "Esperando resposta.");
        formSubmit.layout();
        formSubmit.submit();

    }

    public void addlistObra() {
        try {
            ListObraGWT listObraGWT = new ListObraGWT();
            listObraGWT.setListBox(listObra);
            EasyAccessURL eaurl = new EasyAccessURL(listObraGWT);
            eaurl.accessJSon(Constantes.URL + Obr_obrasConsultGWT.PAGE);
            listObra.setWidth("300");
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        mb.close();
        this.layout();
        doLayout();
    }
}
