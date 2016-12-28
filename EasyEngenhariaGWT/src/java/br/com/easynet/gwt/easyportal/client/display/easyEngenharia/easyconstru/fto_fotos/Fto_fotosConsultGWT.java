/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fto_fotos;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.google.gwt.json.client.JSONValue;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.ConsultaGWT;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Fto_fotosConsultGWT extends ConsultaGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/fto_fotos/fto_fotosConsultGWT.jsp";
    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Fto_fotosConsultGWT consultGWT = this;
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private Button btnfil = new Button("Filtrar");
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Meses> cbMes = new ComboBox<Meses>();
    private ComboBox<Ano> cbAno = new ComboBox<Ano>();

    public Fto_fotosConsultGWT() {
        try {
            this.setHeading("Consulta");
            getDataNORTH().setSize(27);
            getDataEAST().setHidden(true);
            getDataWEST().setHidden(true);
            this.setSize("680", "470");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Fto_fotosTGWT>> numberRenderer = new NumberCellRenderer<Grid<Fto_fotosTGWT>>(currency);
            listObraGWT.povoar();
            btnfil.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    load();
                }
            });

            btnfil.setIcon(ICONS.filter());
            getToolBarMaster().add(cbObra);
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(cbMes);
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(cbAno);
            getToolBarMaster().add(new SeparatorToolItem());
            getToolBarMaster().add(new SeparatorToolItem());

            getToolBarMaster().add(btnfil);
            povoaCombo();
            povoaMesAno();

        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }

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

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Fto_fotosTGWT> store = new ListStore<Fto_fotosTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Fto_fotosTGWT fto_fotosTGWT = new Fto_fotosTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer fto_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("fto_nr_id").toString()));
                fto_fotosTGWT.setFto_nr_id(fto_nr_id);

                Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                fto_fotosTGWT.setObr_nr_id(obr_nr_id);

                Integer fto_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("fto_nr_mes").toString()));
                fto_fotosTGWT.setFto_nr_mes(fto_nr_mes);

                String fto_tx_nome = EasyContainer.clearAspas(registro.get("fto_tx_nome").toString());
                fto_fotosTGWT.setFto_tx_nome(fto_tx_nome);

                Integer fto_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("fto_nr_ano").toString()));
                fto_fotosTGWT.setFto_nr_ano(fto_nr_ano);
                store.add(fto_fotosTGWT);
            }
            TableLayout layout = new TableLayout(store.getCount());
            layout.setCellPadding(3);
            getCpMaster().setLayout(layout);
            for (Fto_fotosTGWT fotoT : store.getModels()) {
                String url = Constantes.URL + PAGE + "?op=downloadImage&fto_fotosT.fto_nr_id=" + fotoT.getFto_nr_id() + "&fileName=" + fotoT.getFto_tx_nome() + "&width=300&height=300";
                //Window.alert(url);
                Image image = new Image(url);
                image.setSize("300", "300");
                getCpMaster().add(montarPanelImage(image,fotoT));
            }

            getCpMaster().layout();
            layout();
            //doLayout();
        }
    }

    public ContentPanel montarPanelImage(Image image,final Fto_fotosTGWT fto_fotoT) {
        ContentPanel cp = new ContentPanel();
        cp.setHeaderVisible(false);
        cp.setSize(300, 330);
        ToolBar bar = new ToolBar();
        bar.setAlignment(HorizontalAlignment.CENTER);
        Button b = new Button("Deletar", ICONS.delete());
        b.setToolTip("Delatar imagem");
        bar.add(b);
        cp.setTopComponent(new LabelField(fto_fotoT.getFto_tx_nome()));
        cp.setBottomComponent(bar);
        cp.add(image);

        b.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                deleteFoto(fto_fotoT);
            }
        });

        return cp;
    }

    public void deleteFoto(Fto_fotosTGWT ftoT) {
        try {
            IListenetResponse response = new IListenetResponse() {

                public void read(JSONValue jsonValue) {
                    if (jsonValue.toString().indexOf("sucesso") > -1) {
                        Info.display("Importante", "Exclusão efetuada com sucesso");
                        load();
                    } else {
                        MessageBox.alert("ATENÇÃO", jsonValue.toString(), null);
                    }
                }
            };
            String url = Constantes.URL + Fto_fotosUpdateDeleteGWT.PAGE + "?op=delete&fto_fotosT.fto_nr_id=" + ftoT.getFto_nr_id();
            Window.alert(url);
            EasyAccessURL eaurl = new EasyAccessURL(response);
            eaurl.accessJSon(url);
        } catch (Exception e) {
        }
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Fto_fotosInsertGWT insert;
        try {
            insert = new Fto_fotosInsertGWT();
            insert.setConsultGWT(consultGWT);
            insert.setModal(true);
            insert.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("fto_fotosT.obr_nr_id", cbObra.getValue().getObr_nr_id() + "");
            param.put("fto_fotosT.fto_nr_mes", cbMes.getValue().getValue() + "");
            param.put("fto_fotosT.fto_nr_ano", cbAno.getValue().getValue() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
            List list = getCpMaster().getItems();
            getCpMaster().removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
