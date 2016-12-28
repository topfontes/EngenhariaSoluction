/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

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
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
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
public class Rel_cronograma_desemb_regime_competenciaGWT extends Window implements IListenetResponse{

    public String PAGE = "easyEngenharia/easyconstru/relatorios/relatorio_regime_competencia.jsp";
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private ContentPanel contentPanel = new ContentPanel();
    private ToolBar toolBar = new ToolBar();

    public Rel_cronograma_desemb_regime_competenciaGWT() {
        this.setSize(354, 163);
        this.setHeading("Relatório Cronograma Desembolso por Regime de Competencia");
        TableLayout layout = new TableLayout(2);
        layout.setCellSpacing(5);
        contentPanel.setLayout(layout);
        contentPanel.setHeaderVisible(false);
        listObraGWT.povoar();
        add(contentPanel);
        toolBar.setAlignment(HorizontalAlignment.CENTER);
        setBottomComponent(toolBar);
        montarTela();
        layout();

    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {
                    contentPanel.add(new LabelField("Obra:"));
                    ListStore<Obr_obrasTGWT> storeobra = listObraGWT.getStore();
                    comboObra.setStore(storeobra);
                    comboObra.setDisplayField("obr_tx_nome");
                    comboObra.setAllowBlank(false);
                    comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboObra.setWidth(250);
                    contentPanel.add(comboObra);

                    contentPanel.add(new LabelField("Mês:"));
                    ListStore<Meses> storemes = new ListStore<Meses>();
                    storemes.add(listMes_AnoGWT.getMeses());
                    comboMes.setStore(storemes);
                    comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboMes.setDisplayField("display");
                    comboMes.setAllowBlank(false);
                    comboMes.setWidth(250);
                    contentPanel.add(comboMes);

                    contentPanel.add(new LabelField("Ano:"));
                    ListStore<Ano> storeAno = new ListStore<Ano>();
                    storeAno.add(listMes_AnoGWT.getListAno());
                    comboAno.setStore(storeAno);
                    comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboAno.setDisplayField("display");
                    comboAno.setAllowBlank(false);
                    comboAno.setWidth(250);
                    contentPanel.add(comboAno);

                    ToolBar bar = new ToolBar();
                    ToolBar bar1 = new ToolBar();
                    Button button = new Button("Imprimir");
                    button.setIcon(ICONS.aplicar());
                    button.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                        public void handleEvent(ButtonEvent be) {
                            imprimir();
                        }
                    });
                    toolBar.add(button);
                    
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    private void imprimir() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String,String> param = new HashMap<String, String>();
            param.put("op", "imprimir");
            param.put("obr_nr_id", comboObra.getValue().getObr_nr_id()+"");
            param.put("mes", comboMes.getValue().getValue()+"");
            param.put("ano", comboAno.getValue().getValue()+"");
            //com.google.gwt.user.client.Window.alert(getWidth()+" - "+getHeight());
            //com.google.gwt.user.client.Window.alert(Constantes.URL+PAGE);
            eaurl.accessJSonMap(Constantes.URL+PAGE, param);
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }


}
