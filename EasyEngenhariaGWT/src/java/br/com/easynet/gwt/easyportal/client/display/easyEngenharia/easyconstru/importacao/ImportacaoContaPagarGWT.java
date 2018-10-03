/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.importacao;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.TipoArquivoCtpTGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
//import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ListBox;

/**
 *
 * @author marcos
 */
public class ImportacaoContaPagarGWT extends Window implements IListenetResponse {

    private String page;
    private Button importar = new Button("Importar");
    private ListBox listObra = new ListBox();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<TipoArquivoCtpTGWT> comboTipoArquivo = new ComboBox<TipoArquivoCtpTGWT>();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private FileUploadField uploadField = new FileUploadField();
    private FileUploadField uploadFieldAnexo = new FileUploadField();
    private FormPanel formSubmit = new FormPanel();
    private HiddenField<String> hfOp = new HiddenField<String>();
    private HiddenField<String> idObra = new HiddenField<String>();
    MessageBox mb = new MessageBox();
    final ImportacaoContaPagarGWT importacaoContaPagarGWT = this;
    private RadioGroup radioGroup = new RadioGroup();
    private String tipo;
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private LabelField label_anexo = new LabelField("Anexo:");

    public ImportacaoContaPagarGWT(String tipo) {
        this.tipo = tipo;
        this.setMinimizable(true);
        if (tipo.equalsIgnoreCase("CTP")) {
            this.setHeading("Contas Pagas/A Pagar");
            page = "easyEngenharia/easyconstru/ctp_conta_pagar/importacaoContaPagar.jsp";
        } else {
            this.setHeading("Estoque");
            page = "easyEngenharia/easyconstru/est_estoque/importacaoEstoqueGWT.jsp";
        }
        this.setSize(430, 270);
        formSubmit.setHeaderVisible(false);
        importacaoContaPagarGWT.add(formSubmit);
        listObraGWT.povoar();
        addListMes();
        addListAno();
        addlistObra();
        addTipoArquivo();

        importar.setIcon(ICONS.importation());
        importar.addListener(Events.OnClick, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent be) {
                enviar(formSubmit);
            }
        });

        montar();
        layout();

        formSubmit.addListener(Events.Submit, new Listener<FormEvent>() {
            public void handleEvent(FormEvent be) {
                JSONValue jsonValue = JSONParser.parse(be.getResultHtml());
                read(jsonValue);
            }
        });
    }

    public void montar() {
        Timer timer = new Timer() {
            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {
                    setLayout(new RowLayout(Orientation.VERTICAL));

                    formSubmit.setHeaderVisible(false);

                    //Definindo campos obrigatorios
                    formSubmit.setAction(Constantes.URL + page);
                    formSubmit.setEncoding(FormPanel.Encoding.MULTIPART);
                    formSubmit.setMethod(FormPanel.Method.POST);
                    formSubmit.setFrame(true);
                    formSubmit.add(uploadField);
                    formSubmit.add(uploadFieldAnexo);

                    ContentPanel panel = new ContentPanel();
                    panel.setHeaderVisible(false);
                    panel.setLayout(new FormLayout(LabelAlign.LEFT));
                    panel.setCollapsible(false);
                    //panel.setExpanded(true);

                    VerticalPanel vpUploadFile = new VerticalPanel();
                    listObra.setName("obr_nr_id");
                    Grid gridUpload = new Grid(8, 3);
                    addlistObra();
                    addListMes();
                    addListAno();
                    addTipoArquivo();
                    gridUpload.setWidget(1, 0, new LabelField("Obra:"));
                    gridUpload.setWidget(1, 1, comboObra);

                    gridUpload.setWidget(2, 0, new LabelField("Tipo Arquivo:"));
                    gridUpload.setWidget(2, 1, comboTipoArquivo);

                    gridUpload.setWidget(3, 0, new LabelField("Mês:"));
                    gridUpload.setWidget(3, 1, comboMes);
                    gridUpload.setWidget(4, 0, new LabelField("Ano:"));
                    gridUpload.setWidget(4, 1, comboAno);
                    if (tipo.equalsIgnoreCase("CTP")) {
                        gridUpload.setWidget(5, 0, new LabelField("Status:"));
                        Radio rdpagas = new Radio();
                        rdpagas.setName("status");
                        rdpagas.setBoxLabel("Pagas");
                        rdpagas.setValue(true);

                        Radio rdapagar = new Radio();
                        rdapagar.setName("status");
                        rdapagar.setBoxLabel("A pagar");

                        radioGroup.add(rdpagas);
                        radioGroup.add(rdapagar);
                        gridUpload.setWidget(5, 1, radioGroup);
                    }

                    gridUpload.setWidget(6, 0, new LabelField("Arquivo:"));
                    gridUpload.setWidget(6, 1, uploadField);

                    label_anexo.setVisible(false);
                    gridUpload.setWidget(7, 0, label_anexo);
                    uploadFieldAnexo.setVisible(false);
                    gridUpload.setWidget(7, 1, uploadFieldAnexo);

                    uploadField.setAllowBlank(false);
                    uploadField.setName("arq_arquivoT.arq_bt_arquivo");
                    uploadField.setWidth("300");
                    uploadField.setLabelSeparator("");

                    uploadFieldAnexo.setAllowBlank(false);
                    uploadFieldAnexo.setName("arq_arquivoT.arq_bt_arquivo_anexo");
                    uploadFieldAnexo.setWidth("300");
                    uploadFieldAnexo.setLabelSeparator("");

                    vpUploadFile.add(gridUpload);

                    ToolBar toolBar = new ButtonBar();
                    toolBar.add(importar);
                    toolBar.setAlignment(HorizontalAlignment.CENTER);
                    panel.add(vpUploadFile);

                    panel.setBottomComponent(toolBar);
                    formSubmit.add(panel);

                    layout();
                }
            }
        };
        timer.schedule(500);

        layout();

    }

    public void addListAno() {
        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(storeAno);
        comboAno.setDisplayField("display");
        //comboAno.setName("ctp_conta_pagarT.ctp_nr_ano");
    }

    public void addListMes() {
        ListStore<Meses> storeMeses = new ListStore<Meses>();
        storeMeses.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(storeMeses);
        comboMes.setDisplayField("display");
        //comboMes.setName("ctp_conta_pagarT.ctp_nr_mes");
    }

    public void addlistObra() {
        try {
            ListStore<Obr_obrasTGWT> storeObra = new ListStore<Obr_obrasTGWT>();
            storeObra = listObraGWT.getStore();
            comboObra.setStore(storeObra);
            comboObra.setDisplayField("obr_tx_nome");
            //comboMes.setName("ctp_conta_pagarT.obr_nr_id");
            comboObra.setWidth(300);
        } catch (Exception e) {
        }
    }

    private void enviar(final FormPanel fp) {
//        formSubmit.clear();

        //Definindo campos obrigatorios
        hfOp = new HiddenField<String>();
        hfOp.setName("op");
        hfOp.setValue("importar");
        formSubmit.add(hfOp);

        HiddenField<String> hf = new HiddenField<String>();
        hf.setName(tipo.equalsIgnoreCase("CTP") ? "ctp_conta_pagarT.obr_nr_id" : "est_estoqueT.obr_nr_id");
        hf.setValue(comboObra.getValue().getObr_nr_id() + "");
        formSubmit.add(hf);

        hf = new HiddenField<String>();
        hf.setName(tipo.equalsIgnoreCase("CTP") ? "ctp_conta_pagarT.ctp_nr_mes" : "est_estoqueT.est_nr_mes");
        hf.setValue(comboMes.getValue().getValue() + "");
        formSubmit.add(hf);

        hf = new HiddenField<String>();
        hf.setName(tipo.equalsIgnoreCase("CTP") ? "ctp_conta_pagarT.ctp_nr_ano" : "est_estoqueT.est_nr_ano");
        hf.setValue(comboAno.getValue().getValue() + "");
        formSubmit.add(hf);
        if (tipo.equalsIgnoreCase("CTP")) {
            hf = new HiddenField<String>();
            hf.setName("tipoStatus");
            if (radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Pagas")) {
                hf.setValue(0 + "");
            } else {
                hf.setValue(1 + "");
            }
            formSubmit.add(hf);
        }

        hf = new HiddenField<String>();
        hf.setName("tipoArquivo");
        hf.setValue(comboTipoArquivo.getValue().getValue() + "");
        formSubmit.add(hf);
        formSubmit.layout();
        formSubmit.submit();
        mb = MessageBox.wait("Requisicao", "Requisitando a servidor", "Esperando resposta.");
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        mb.close();
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String msg = EasyContainer.clearAspas(jsonValue.toString());
            msg = msg.substring(13, msg.length());
            msg = msg.replaceAll("}", "");
            if (msg.trim().length() > 0) {
                MessageBox mb = new MessageBox();
                mb.alert("", msg, null);
            }
            this.layout();
            doLayout();
        }
    }

    private void addTipoArquivo() {
        ListStore<TipoArquivoCtpTGWT> list = new ListStore<TipoArquivoCtpTGWT>();

        TipoArquivoCtpTGWT tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(1);
        tipoT.setDisplay("NASSAL");
        list.add(tipoT);

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(2);
        tipoT.setDisplay("L MARQUEZZO");
        list.add(tipoT);

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(3);
        tipoT.setDisplay("AC ENGENHARIA");
        list.add(tipoT);

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(4);
        tipoT.setDisplay("DICOM");
        list.add(tipoT);

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(5);
        tipoT.setDisplay("COMPACTA");
        list.add(tipoT);

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(6);
        tipoT.setDisplay("ENGEB");
        list.add(tipoT);

        if (this.tipo.equalsIgnoreCase("CTP")) {
            tipoT = new TipoArquivoCtpTGWT();
            tipoT.setValue(7);
            tipoT.setDisplay("L MARQUEZZO XLS PAGAS");
            list.add(tipoT);

            tipoT = new TipoArquivoCtpTGWT();
            tipoT.setValue(14);
            tipoT.setDisplay("L MARQUEZZO XLS A PAGAR");
            list.add(tipoT);
        }

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(8);
        tipoT.setDisplay("CELI");
        list.add(tipoT);

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(9);
        tipoT.setDisplay("MODULO");
        list.add(tipoT);

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(10);
        tipoT.setDisplay("ADM");
        list.add(tipoT);

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(11);
        tipoT.setDisplay("OURO NEGRO");
        list.add(tipoT);

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(12);
        tipoT.setDisplay("VIVA SIM");
        list.add(tipoT);

        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(13);
        tipoT.setDisplay("VIDA FELIZ");
        list.add(tipoT);
        
        tipoT = new TipoArquivoCtpTGWT();
        tipoT.setValue(15);
        tipoT.setDisplay("ADM XLS");
        list.add(tipoT);

        comboTipoArquivo.setStore(list);
        comboTipoArquivo.setDisplayField("display");
        comboTipoArquivo.setWidth(300);
        comboTipoArquivo.addSelectionChangedListener(new SelectionChangedListener<TipoArquivoCtpTGWT>() {
            @Override
            public void selectionChanged(SelectionChangedEvent<TipoArquivoCtpTGWT> se) {
                if (tipo.equalsIgnoreCase("CTP")) {
                    if (se.getSelectedItem().getValue() == 8) {
                        uploadFieldAnexo.setVisible(true);
                        label_anexo.setVisible(true);
                    } else {
                        uploadFieldAnexo.setVisible(false);
                        label_anexo.setVisible(false);
                    }
                }
            }
        });

    }
}
