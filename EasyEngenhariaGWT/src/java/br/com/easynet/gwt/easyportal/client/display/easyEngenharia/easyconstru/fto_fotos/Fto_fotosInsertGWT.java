/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fto_fotos;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TextBox;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;

/**
 *
 * @author geoleite
 */
public class Fto_fotosInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fto_fotos/fto_fotosInsertGWT.jsp";
    private Fto_fotosConsultGWT consultGWT = new Fto_fotosConsultGWT();

    public Fto_fotosConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Fto_fotosConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextBox fto_nr_id = new TextBox();
    private TextBox obr_nr_id = new TextBox();
    private TextBox fto_nr_mes = new TextBox();
    private TextBox fto_nr_ano = new TextBox();
    private TextBox fto_bt_foto = new TextBox();
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Meses> cbMes = new ComboBox<Meses>();
    private ComboBox<Ano> cbAno = new ComboBox<Ano>();
    private ToolBar bar = new ToolBar();
    //private FileUploadField uploadField = new FileUploadField();
    private FormPanel formPanel = new FormPanel();
    private Image image = new Image();
    private String urlPage;
    private HiddenField<String> hdop = new HiddenField<String>();
    private boolean urlImage;
    private String fileName;
    private FileUploadField fileUpload = new FileUploadField();
    private MessageBox mb = new MessageBox();
    private TextField<String> fto_tx_nome = new TextField<String>();

    public Fto_fotosInsertGWT() {
        this.setHeading("Cadastro de Fotos");
        this.setSize("510", "540");
        listObraGWT.povoar();
        povoaCombo();
        povoaMesAno();

        bar.add(cbObra);
        bar.add(new SeparatorToolItem());
        bar.add(new SeparatorToolItem());
        bar.add(cbMes);
        bar.add(new SeparatorToolItem());
        bar.add(new SeparatorToolItem());
        bar.add(cbAno);
        getCpMaster().setTopComponent(bar);

        formPanel.setHeight(63);
        formPanel.setHeaderVisible(false);
        formPanel.setBodyBorder(false);
        formPanel.setFrame(false);
//        uploadField.setFieldLabel("Arquivo da Foto");
//        uploadField.setFieldLabel("Foto");
//        uploadField.setName("fto_fotosT.fto_bt_foto");
        //formPanel.add(uploadField);


        hdop.setName("op");
        hdop.setValue("insert");
        formPanel.add(hdop);

        urlPage = Constantes.URL + PAGE;
        formPanel.setAction(urlPage);
        formPanel.setEncoding(FormPanel.Encoding.MULTIPART);
        formPanel.setMethod(FormPanel.Method.POST);

        formPanel.addListener(Events.Submit, new Listener<FormEvent>() {

            public void handleEvent(FormEvent be) {
                JSONValue jsonValue = JSONParser.parse(be.getResultHtml());
                read(jsonValue);
                for (int i = 0; i < formPanel.getItemCount(); i++) {
                    formPanel.getItems().get(i).clearState();
                }
            }
        });


        fileUpload = new FileUploadField() {

            @Override
            protected void onChange(ComponentEvent ce) {
                setName("fto_fotosT.fto_bt_foto");
                final String fullPath = getFileInput().getValue();
                final int lastIndex = fullPath.lastIndexOf('\\');
                fileName = fullPath.substring(lastIndex + 1);
                setValue(fileName);
                layout();
                setUrlpageImage();
                formPanel.setAction(urlPage);
                formPanel.submit();
                //image.setSize("300", "300");

            }
        };
        //getCpMaster().setLayout(new TableLayout(1));
        ContentPanel contentPanel = new ContentPanel();
        contentPanel.setHeaderVisible(false);

        getCpMaster().add(contentPanel);
        fileUpload.setFieldLabel("Imagem");
        formPanel.add(fileUpload);
        fto_tx_nome.setWidth(200);
        fto_tx_nome.setEmptyText("informe a legenda");
        fto_tx_nome.setAllowBlank(false);
        formPanel.add(fto_tx_nome);
        fto_tx_nome.setFieldLabel("Legenda");
        contentPanel.add(formPanel);
        contentPanel.add(image, new RowData(1, 1));

        layout();
    }

    public void setUrlpageImage() {
        urlImage = true;
        hdop.setValue("insert_sessao");
        urlPage = Constantes.URL + Fto_fotosUpdateDeleteGWT.PAGE;
    }

    public void setUrlpageInsert() {
        urlImage = false;
        hdop.setValue("insert");
        urlPage = Constantes.URL + PAGE;
    }

    public void povoaMesAno() {
        cbMes.setDisplayField("display");
        cbMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbMes.setAllowBlank(false);
        cbMes.setValueField("value");
        //cbMes.setName("fto_fotosT.fto_nr_mes");
        cbMes.setWidth(100);
        ListStore<Meses> stoereMes = new ListStore<Meses>();
        stoereMes.add(listMes_AnoGWT.getMeses());
        cbMes.setStore(stoereMes);

        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(listMes_AnoGWT.getListAno());
        cbAno.setStore(storeAno);
        cbAno.setValueField("value");
        //cbAno.setName("fto_fotosT.fto_nr_ano");
        cbAno.setDisplayField("display");
        cbAno.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbAno.setAllowBlank(false);
        cbAno.setWidth(60);
    }

    public void povoaCombo() {
        cbObra.setWidth(250);
        cbObra.setDisplayField("obr_tx_nome");
        cbObra.setValueField("obr_nr_id");
        //cbObra.setName("fto_fotosT.obr_nr_id");
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
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

//    @Override
    public void btnInsertAction(ButtonEvent ce) {
        btnCadAction(ce);
    }

    private void btnCadAction(ButtonEvent sender) {
        try {

            setUrlpageInsert();
            //Window.alert(urlPage);
            formPanel.setAction(urlPage);

            HiddenField<String> hdobra = new HiddenField<String>();
            hdobra.setName("fto_fotosT.obr_nr_id");
            hdobra.setValue(cbObra.getValue().getObr_nr_id() + "");
            formPanel.add(hdobra);

            HiddenField<String> hdNome = new HiddenField<String>();
            hdNome.setName("fto_fotosT.fto_tx_nome");
            hdNome.setValue(fto_tx_nome.getValue());
            formPanel.add(hdNome);

            HiddenField<String> hdmes = new HiddenField<String>();
            hdmes.setName("fto_fotosT.fto_nr_mes");
            hdmes.setValue(cbMes.getValue().getValue() + "");
            formPanel.add(hdmes);
            HiddenField<String> hdAno = new HiddenField<String>();
            hdAno.setName("fto_fotosT.fto_nr_ano");
            hdAno.setValue(cbAno.getValue().getValue() + "");
            formPanel.add(hdAno);
            formPanel.layout();
            formPanel.submit();
            mb = MessageBox.wait("Requisitando o Servidor", "Salvando a imagem aguarde!!", "Salvando");
            fto_tx_nome.setValue(null);

            formPanel.addListener(Events.Submit, new Listener<FormEvent>() {

                public void handleEvent(FormEvent be) {
                    JSONValue jsonValue = JSONParser.parse(be.getResultHtml());
                    read(jsonValue);
                    for (int i = 0; i < formPanel.getItemCount(); i++) {
                        formPanel.getItems().get(i).clearState();
                    }
                }
            });


        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (!urlImage) {
                if (jsonObject.toString().indexOf("sucesso") > -1) {
                    mb.close();
                    Info.display("", "Cadastro efetuado com sucesso!");
                    fileUpload.setValue(null);
                    image.setUrl("./teste");
                    layout();
                } else {
                   // Window.alert("Result " + jsonObject.get("resultado").toString());
                }
            } else {
                int altura = getCpMaster().getHeight() - 50;
                int tam = getCpMaster().getWidth();
                String url = Constantes.URL + Fto_fotosUpdateDeleteGWT.PAGE + "?op=downloadImageThumb&fileName=" + fileName + "&width=" + tam + "&height=" + altura;
                image.setUrl(url);
            }
        }
    }
}
