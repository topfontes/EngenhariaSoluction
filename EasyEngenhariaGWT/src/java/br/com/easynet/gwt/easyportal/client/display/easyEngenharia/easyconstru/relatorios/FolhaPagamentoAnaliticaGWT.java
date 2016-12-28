/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Constantes;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author marcos
 */
public class FolhaPagamentoAnaliticaGWT extends RelatorioBaseGWT {

    private ContentPanel cpREL = new ContentPanel(new FillLayout());
    private final String PAGE_HTML = "./easyEngenharia/easyconstru/relatorios/folha_pagamento_analitica.jsp";
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/folha_pagamento_analitica.jsp";

    public FolhaPagamentoAnaliticaGWT() {
        this.setHeading("Folha de Pagamento Analítica");

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
                } else {
                    addComboObra();
                    addComboMes();
                    addComboAno();
                    addBtnFiltrar();
                    addBtnExportar();
                    getCpMaster().add(cpREL);
                    cpREL.setHeight(getCpMaster().getHeight() - 1);
                    cpREL.setWidth(getCpMaster().getWidth() - 1);
                }
            }
        };
        timer.schedule(500);
    }

    @Override
    public void filtrar() {
        String url = Constantes.URL + JSP_VIEW + PAGE_HTML + getParamBaseHTML() + TIPO_HTML;
//        Window.alert(url);
        cpREL.setUrl(url);
        layout();
        doLayout();
    }

    
    @Override
    public void exportarPDF() {
        String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport()+ TIPO_PDF;
        download(url);
    }

    @Override
    public void exportarXLS() {
        String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport()+ TIPO_XLS;
        download(url);
    }
}
