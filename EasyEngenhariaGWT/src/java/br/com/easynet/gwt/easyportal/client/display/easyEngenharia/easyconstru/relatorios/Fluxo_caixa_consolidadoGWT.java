/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Constantes;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author marcos
 */
public class Fluxo_caixa_consolidadoGWT extends RelatorioBaseGWT {

    final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/fluxo_caixa_consolidado.jsp";
    final String PAGE_HTML = "./easyEngenharia/easyconstru/relatorios/fluxo_caixa_consolidado.jsp";
    private ContentPanel cpREL = new ContentPanel(new FillLayout());

    public Fluxo_caixa_consolidadoGWT() {
        this.setHeading("Fluxo de caixa consolidado");
        cpREL.setHeaderVisible(false);
        cpREL.setFrame(false);
        
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!getListObraGWT().isMostrar()) {
                    schedule(500);
                } else {
                    addComboObra();
                    addComboMes();
                    addComboAno();
                    addBtnFiltrar();
                    addBtnExportar();
                    getCpMaster().add(cpREL);
                    cpREL.setHeight(getCpMaster().getHeight() - 2);
                    cpREL.setWidth(getCpMaster().getWidth() - 2);
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
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
        download(Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_PDF);
    }

    @Override
    public void exportarXLS() {
        download(Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_XLS);
    }
}
