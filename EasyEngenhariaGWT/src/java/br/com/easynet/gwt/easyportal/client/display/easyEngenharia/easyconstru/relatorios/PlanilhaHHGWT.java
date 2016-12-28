/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.Meses;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author marcos
 */
public class PlanilhaHHGWT extends RelatorioBaseGWT {

    private ContentPanel cpREL = new ContentPanel(new FillLayout());
    private final String PAGE_HTML = "./easyEngenharia/easyconstru/relatorios/planilhaHH.jsp";
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/planilhaHH.jsp";
    int i = 0;

    public PlanilhaHHGWT() {

        this.setHeading("Planilha HH");
        cpREL.setHeaderVisible(false);
        cpREL.setFrame(false);
        montarTela();
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!getListObraGWT().isMostrar()) {
                    schedule(500);
                    //Info.display("sim", "");
                } else {
                    //Window.alert("passou");
                    addComboObraLoc();
                    addComboMesLoc();
                    addComboAnoLoc();
                    addBtnFiltrarLoc();
                    addBtnExportarLoc();
                    getCpMaster().add(cpREL);
                    cpREL.setHeight(getCpMaster().getHeight() - 2);
                    cpREL.setWidth(getCpMaster().getWidth() - 2);
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void addComboObraLoc() {
        getComboObra().setStore(getListObraGWT().getStore());
        getComboObra().setDisplayField("obr_tx_nome");
        getComboObra().setAllowBlank(false);
        getComboObra().setTriggerAction(ComboBox.TriggerAction.ALL);
        getComboObra().setEmptyText("Selecione a Obra");
        getComboObra().setWidth(250);
        getToolBarMaster().add(getComboObra());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().setSpacing(3);
    }

    public void addComboMesLoc() {

        ListStore<Meses> store = new ListStore<Meses>();
        store.add(getListMesAno().getMeses());
        getComboMes().setStore(store);
        getComboMes().setDisplayField("display");
        getComboMes().setAllowBlank(false);
        getComboMes().setTriggerAction(ComboBox.TriggerAction.ALL);
        getComboMes().setEmptyText("Mês");
        getComboMes().setWidth(100);
        getToolBarMaster().add(getComboMes());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());

        getToolBarMaster().setPosition(10, 1);
    }

    public void addComboAnoLoc() {
        ListStore<Ano> store = new ListStore<Ano>();
        store.add(getListMesAno().getListAno());
        getComboAno().setStore(store);
        getComboAno().setDisplayField("display");
        getComboAno().setAllowBlank(false);
        getComboAno().setTriggerAction(ComboBox.TriggerAction.ALL);
        getComboAno().setEmptyText("Ano");
        getComboAno().setWidth(70);
        getToolBarMaster().add(getComboAno());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().setSpacing(3);
    }

    public void addBtnFiltrarLoc() {
        getToolBarMaster().add(btnFiltrar);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().setSpacing(3);
    }

    public void addBtnExportarLoc() {
        getToolBarMaster().add(getBtnExportar());
    }

    @Override
    public void filtrar() {
        String url = Constantes.URL + JSP_VIEW + PAGE_HTML + getParamBaseHTML() + TIPO_HTML;
        cpREL.setUrl(url);
        layout();
        doLayout();
    }

    @Override
    public void exportarPDF() {
        String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_PDF;
        download(url);
    }

    @Override
    public void exportarXLS() {
        String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_XLS;
        download(url);
    }
}
