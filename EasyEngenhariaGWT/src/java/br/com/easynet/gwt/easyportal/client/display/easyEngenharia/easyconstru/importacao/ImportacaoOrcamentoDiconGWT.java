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
public class ImportacaoOrcamentoDiconGWT extends Window implements IListenetResponse {

    private String page = "easyEngenharia/easyconstru/plco_plano_contas_orcamento/importacaoNassalGWT.jsp";
    private Button importar = new Button("Importar");
    private ListBox listObra = new ListBox();
    private FileUploadField uploadField = new FileUploadField();
    private FileUploadField uploadFieldPDF = new FileUploadField();
    private FormPanel formSubmit = new FormPanel();
    private HiddenField<String> hfOp = new HiddenField<String>();
    private HiddenField<String> idObra = new HiddenField<String>();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private MessageBox mb = new MessageBox();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private boolean gerado;

    public ImportacaoOrcamentoDiconGWT() {

        listObraGWT.povoar();
        this.setMinimizable(true);
        this.setHeading("Orçamento");
        this.setSize(470, 210);
        //chkExterno.setId("externo");

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
                    hfOp.setValue("findImport");
                    formSubmit.add(hfOp);
                    formSubmit.setHeaderVisible(false);

                    //Definindo campos obrigatorios
                    formSubmit.setAction(Constantes.URL + page);
                    formSubmit.setEncoding(FormPanel.Encoding.MULTIPART);
                    formSubmit.setMethod(FormPanel.Method.POST);
                    formSubmit.setFrame(true);
//                    formSubmit.add(uploadField);
//                    formSubmit.add(uploadFieldPDF);

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
                    gridUpload.setWidget(2, 0, new LabelField("Orçamento sintético EXCEL:"));
                    gridUpload.setWidget(2, 1, uploadField);
                    gridUpload.setWidget(3, 0, new LabelField("Orçamento Analítico em PDF:"));
                    gridUpload.setWidget(3, 1, uploadFieldPDF);

                    uploadFieldPDF.setAllowBlank(false);
                    uploadFieldPDF.setName("arq_arquivoTPDF.arq_bt_arquivo");
                    uploadFieldPDF.setWidth("300");
                    uploadFieldPDF.setLabelSeparator("");

                    uploadField.setAllowBlank(false);
                    uploadField.setName("arq_arquivoT.arq_bt_arquivo");
                    uploadField.setWidth("300");
                    uploadField.setLabelSeparator("");

                    vpUploadFile.add(gridUpload);

                    ToolBar toolBar = new ToolBar();
                    toolBar.add(importar);
                    toolBar.setAlignment(HorizontalAlignment.CENTER);
                    panel.add(vpUploadFile);
                    panel.setBottomComponent(toolBar);

                    importar.setIcon(ICONS.exportation());

                    formSubmit.add(panel);
                    add(formSubmit);

                    importar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                        public void handleEvent(ButtonEvent be) {
                            if (gerado) {
                                hfOp.setName("op");
                                hfOp.setValue("findImport");
                            }
                            enviar();

                        }
                    });

                    formSubmit.addListener(Events.Submit, new Listener<FormEvent>() {

                        public void handleEvent(FormEvent be) {
                            //mb.close();
                            //com.google.gwt.user.client.Window.alert(be.getResultHtml());
                            JSONValue jsonValue = JSONParser.parse(be.getResultHtml());
                            read(jsonValue);
                            for (int i = 0; i < formSubmit.getItemCount(); i++) {
                                formSubmit.getItems().get(i).clearState();
                            }
                        }
                    });

                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void setOp(String op) {
        formSubmit.remove(hfOp);
        hfOp = new HiddenField<String>();
        hfOp.setName("op");
        hfOp.setValue(op);
        formSubmit.add(hfOp);

    }

    private void enviar() {
        gerado = true;
        formSubmit.layout();
        HiddenField<String> hfObra = new HiddenField<String>();
        hfObra.setName("obr_nr_id");
        hfObra.setValue(comboObra.getValue().getObr_nr_id() + "");
        formSubmit.add(hfObra);
        mb = MessageBox.wait("Requisicao", "Requisitando a servidor", "Esperando resposta.");
        formSubmit.layout();
        formSubmit.submit();

    }

    private void povoarComboObra() {
        comboObra.setStore(listObraGWT.getStore());
        comboObra.setDisplayField("obr_tx_nome");
        comboObra.setValueField("obr_nr_id");
        comboObra.setAllowBlank(true);
        comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboObra.setWidth(300);
    }

//    public void importFile() {
//        try {
//            String arquivo = "";
//            EasyAccessURL eaurl = new EasyAccessURL(this);
//            HashMap<String, String> param = new HashMap<String, String>();
//            param.put("op", "findImportacao");
//            param.put("arquivo", uploadField.getName());
//            param.put("ipo_item_plano_contas_obraT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
//            eaurl.accessJSonMap(Constantes.URL + page, param);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
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
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            JSONObject registro = resultado.get(0).isObject();
            String qtde = EasyContainer.clearAspas(registro.get("registro").toString());
            registro = resultado.get(1).isObject();
            String status = EasyContainer.clearAspas(registro.get("status").toString());
            if ("ok".equalsIgnoreCase(status)) {
                com.google.gwt.user.client.Window.alert(qtde + " Arquivos importados com sucesso!!");
            } else if ("find".equalsIgnoreCase(status)) {
                MessageBox mb = MessageBox.confirm("Aviso", "Já existe Orçamentos para esta obra, Deseja apaga-los e importa-los novamente ?", new Listener<MessageBoxEvent>() {

                    public void handleEvent(MessageBoxEvent be) {
                        if ("yes".equalsIgnoreCase(be.getButtonClicked().getText()) || "Sim".equalsIgnoreCase(be.getButtonClicked().getText())) {
                            delete();
                        }
                    }
                });
            } else {
                com.google.gwt.user.client.Window.alert(" Erro durante a importação");
            }
        }
        mb.close();
        this.layout();
        doLayout();
    }

    public void delete() {
        try {
            setOp("deleteImportacao");
            formSubmit.layout();
            enviar();
//            String arquivo = "";
//            EasyAccessURL eaurl = new EasyAccessURL(this);
//            HashMap<String, String> param = new HashMap<String, String>();
//            param.put("op", "deleteImportacao");
//            param.put("ipo_item_plano_contas_obraT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
//            param.put("obr_nr_id", comboObra.getValue().getObr_nr_id() + "");
//            mb = MessageBox.wait("Requisicao", "Requisitando a servidor", "Esperando resposta.");
//            eaurl.accessJSonMapNoProgress(Constantes.URL + page, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
