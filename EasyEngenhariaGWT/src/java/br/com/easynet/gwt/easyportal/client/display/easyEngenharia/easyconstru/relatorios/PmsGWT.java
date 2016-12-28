/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class PmsGWT extends Window {

    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    private Button exportar = new Button("Exportar");
    private ContentPanel cp = new ContentPanel();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private RelatorioBaseGWT relatorioBaseGWT = new RelatorioBaseGWT();
    private Menu menu = new Menu();

    public PmsGWT() {
        listObraGWT.povoar();
        exportar.setIcon(ICONS.download());

        this.setSize(300, 170);
        this.setHeading("PMS C/CUSTOS ORÇADOS");
        cp.setHeaderVisible(false);
        //this.add(cp);

        TableLayout layout = new TableLayout();
        layout.setCellPadding(5);
        cp.setLayout(layout);
        montarMenu();
        exportar.setMenu(menu);
        montarTela();
        layout();
    }

    public void addListMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(store);
        comboMes.setDisplayField("display");
        comboMes.setEmptyText("Selecione o mês");
        comboMes.setAllowBlank(false);
        comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboMes.setWidth(250);
    }

    public void addListAno() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(store);
        comboAno.setDisplayField("display");
        comboAno.setEmptyText("Selecione o ano");
        comboAno.setAllowBlank(false);
        comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboAno.setWidth(250);
    }


    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(500);
                } else {
                    comboObra.setAllowBlank(false);
                    comboObra.setDisplayField("obr_tx_nome");
                    comboObra.setStore(listObraGWT.getStore());
                    comboObra.setEmptyText("Selecione a Obra");
                    comboObra.setWidth(250);
                    addListMes();
                    addListAno();
                    cp.add(comboObra);
                    cp.add(comboMes);
                    cp.add(comboAno);
                    ToolBar bar = new ToolBar();
                    bar.setAlignment(HorizontalAlignment.CENTER);
                    bar.add(exportar);
                    cp.setBottomComponent(bar);
                    cp.setHeight(140);
                    add(cp);
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public String getParam(){
        String param = "&pms.pms_nr_mes="+comboMes.getValue().getValue();
        param += "&pms.pms_nr_ano="+comboAno.getValue().getValue();
        return param;
    }
    
    public void exportarPDF() {
        String url = Constantes.URL+"easyEngenharia/easyconstru/relatorios/pms.jsp?op=imprimir&obr_obrasT.obr_nr_id="+comboObra.getValue().getObr_nr_id()+"&tipo=PDF"+getParam();
        relatorioBaseGWT.download(url);
    }

    public void exportarXLS() {
        String url = Constantes.URL+"easyEngenharia/easyconstru/relatorios/pms.jsp?op=imprimir&obr_obrasT.obr_nr_id="+comboObra.getValue().getObr_nr_id()+"&tipo=XLS"+getParam();
        relatorioBaseGWT.download(url);
    }

    public void montarMenu() {
        MenuItem itemPDF = new MenuItem("PDF");
        itemPDF.addSelectionListener(new SelectionListener<MenuEvent>() {
            @Override
            public void componentSelected(MenuEvent ce) {
                exportarPDF();
            }
        });

        MenuItem itemXLS = new MenuItem("XLS");
        itemXLS.addSelectionListener(new SelectionListener<MenuEvent>() {

            @Override
            public void componentSelected(MenuEvent ce) {
                exportarXLS();
            }
        });
        menu.add(itemXLS);
        menu.add(itemPDF);
    }

}
