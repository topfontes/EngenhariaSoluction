/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;

/**
 *
 * @author marcos
 */
public class RelatorioBaseGWT extends Window {

    private ContentPanel cpMaster = new ContentPanel();
    private ToolBar toolBarMaster = new ToolBar();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMesAno = new ListMes_AnoGWT();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    protected Button btnFiltrar = new Button("Filtrar");
    private Button btnExportar = new Button("Exportar");
    private Menu menu = new Menu();
    private String paramBase;
    //public final String TIPO_HTML = "$tipo=HTML";
    public final String TIPO_HTML = "$tipo=PDF";//nova alteração
    public final String TIPO_XLS = "&tipo=XLS";
    public final String TIPO_PDF = "&tipo=PDF";
    public final String JSP_VIEW = "viewer.jsp?url=";
    private MessageBox mb = new MessageBox();

    public RelatorioBaseGWT() {
        setLayout(new FillLayout());
        
        cpMaster.setHeaderVisible(false);
        FillLayout layout = new FillLayout();
        cpMaster.setLayout(layout);

        listObraGWT.povoar();

        this.setMaximizable(true);

        btnFiltrar.setIcon(ICONS.filter());
        btnExportar.setIcon(ICONS.download());
        btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                filtrar();
            }
        });

        cpMaster.setTopComponent(toolBarMaster);

        montarMenu();
        btnExportar.setMenu(menu);
        add(cpMaster);
        layout();
    }

    @Override
    protected void onShow() {
        super.onShow();
        maximize();
    }

    public void addComboObra() {
        
        comboObra.setStore(listObraGWT.getStore());
        comboObra.setDisplayField("obr_tx_nome");
        comboObra.setAllowBlank(false);
        comboObra.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboObra.setEmptyText("Selecione a Obra");
        comboObra.setWidth(250);
        toolBarMaster.add(comboObra);
        toolBarMaster.add(new SeparatorToolItem());
        toolBarMaster.add(new SeparatorToolItem());
    }

    public void addComboMes() {
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMesAno.getMeses());
        comboMes.setStore(store);
        comboMes.setDisplayField("display");
        comboMes.setAllowBlank(false);
        comboMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboMes.setEmptyText("Mês");
        comboMes.setWidth(100);
        toolBarMaster.add(comboMes);
        toolBarMaster.add(new SeparatorToolItem());
        toolBarMaster.add(new SeparatorToolItem());
    }

    public void addComboAno() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(listMesAno.getListAno());
        comboAno.setStore(store);
        comboAno.setDisplayField("display");
        comboAno.setAllowBlank(false);
        comboAno.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboAno.setEmptyText("Ano");
        comboAno.setWidth(70);
        toolBarMaster.add(comboAno);
        toolBarMaster.add(new SeparatorToolItem());
        toolBarMaster.add(new SeparatorToolItem());
        toolBarMaster.setSpacing(3);
    }

    public void addBtnFiltrar() {
        toolBarMaster.add(btnFiltrar);
        toolBarMaster.add(new SeparatorToolItem());
        toolBarMaster.add(new SeparatorToolItem());
        //toolBarMaster.setSpacing(3);
    }

    public void addBtnExportar() {
        toolBarMaster.add(getBtnExportar());
        toolBarMaster.add(new SeparatorToolItem());
        toolBarMaster.add(new SeparatorToolItem());

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
        getMenu().add(itemXLS);
        getMenu().add(itemPDF);
    }

    public void filtrar() {
    }

    public void exportarPDF() {
    }

    public void exportarXLS() {
    }

    public void download(final String url_download) {

        final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();


        winDownload.setHeading("Download do arquivo");
        LabelField txtDownload = new LabelField("<a href=\"" + url_download + "\"> DOWNLOAD </a>");
        //winDownload.setUrl(url);
        winDownload.setLayout(new CenterLayout());
        winDownload.add(txtDownload);
        winDownload.setSize(100, 50);
        winDownload.setVisible(true);
    }

    /**
     * @return the cpMaster
     */
    public ContentPanel getCpMaster() {
        return cpMaster;
    }

    /**
     * @param cpMaster the cpMaster to set
     */
    public void setCpMaster(ContentPanel cpMaster) {
        this.cpMaster = cpMaster;
    }

    /**
     * @return the toolBarMaster
     */
    public ToolBar getToolBarMaster() {
        return toolBarMaster;
    }

    /**
     * @param toolBarMaster the toolBarMaster to set
     */
    public void setToolBarMaster(ToolBar toolBarMaster) {
        this.toolBarMaster = toolBarMaster;
    }

    /**
     * @return the listObraGWT
     */
    public ListObraGWT getListObraGWT() {
        return listObraGWT;
    }

    /**
     * @param listObraGWT the listObraGWT to set
     */
    public void setListObraGWT(ListObraGWT listObraGWT) {
        this.listObraGWT = listObraGWT;
    }

    /**
     * @return the listMesAno
     */
    public ListMes_AnoGWT getListMesAno() {
        return listMesAno;
    }

    /**
     * @param listMesAno the listMesAno to set
     */
    public void setListMesAno(ListMes_AnoGWT listMesAno) {
        this.listMesAno = listMesAno;
    }

    /**
     * @return the comboObra
     */
    public ComboBox<Obr_obrasTGWT> getComboObra() {
        return comboObra;
    }

    /**
     * @param comboObra the comboObra to set
     */
    public void setComboObra(ComboBox<Obr_obrasTGWT> comboObra) {
        this.comboObra = comboObra;
    }

    /**
     * @return the comboMes
     */
    public ComboBox<Meses> getComboMes() {
        return comboMes;
    }

    /**
     * @param comboMes the comboMes to set
     */
    public void setComboMes(ComboBox<Meses> comboMes) {
        this.comboMes = comboMes;
    }

    /**
     * @return the comboAno
     */
    public ComboBox<Ano> getComboAno() {
        return comboAno;
    }

    /**
     * @param comboAno the comboAno to set
     */
    public void setComboAno(ComboBox<Ano> comboAno) {
        this.comboAno = comboAno;
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * @return the paramBase
     */
    public String getParamBaseHTML() {
        return "|op=imprimir$obr_obrasT.obr_nr_id=" + comboObra.getValue().getObr_nr_id() + "$meo_meses_obraT.mes=" + comboMes.getValue().getValue() + "$meo_meses_obraT.ano=" + comboAno.getValue().getValue();
    }

    public String getParamBaseExport() {
        return "?op=imprimir&obr_obrasT.obr_nr_id=" + comboObra.getValue().getObr_nr_id() + "&meo_meses_obraT.mes=" + comboMes.getValue().getValue() + "&meo_meses_obraT.ano=" + comboAno.getValue().getValue();
    }

    /**
     * @param paramBase the paramBase to set
     */
    public void setParamBase(String paramBase) {
        this.paramBase = paramBase;
    }

    /**
     * @return the btnExportar
     */
    public Button getBtnExportar() {
        return btnExportar;
    }

    /**
     * @param btnExportar the btnExportar to set
     */
    public void setBtnExportar(Button btnExportar) {
        this.btnExportar = btnExportar;
    }
}
