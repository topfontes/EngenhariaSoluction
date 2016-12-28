/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Constantes;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class FotosGWT extends RelatorioBaseGWT {

    private final String PAGE_HTML = "./easyEngenharia/easyconstru/relatorios/fotos.jsp";
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/fotos.jsp";
    private ContentPanel cpREL = new ContentPanel(new FillLayout());

    public FotosGWT() {
        this.setHeading("Estoque por Sub-Classe / Insumos");
        cpREL.setHeaderVisible(false);
        cpREL.setFrame(false);
        montarTela();
    }

    private void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!getListObraGWT().isMostrar()) {
                    schedule(500);
                } else {
                    int a = 2;
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

    public String getParamLocal() {
        String paramLocal = "";
        return paramLocal;
    }

    @Override
    public void filtrar() {
        String url = Constantes.URL + JSP_VIEW + PAGE_HTML + getParamBaseHTML() + TIPO_HTML;
//        Window.alert(url);
        cpREL.setUrl(url);
        layout();//32523124
        doLayout();
    }

    @Override
    public void exportarPDF() {
        try {
            String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_PDF;
            download(url);
        } catch (Exception e) {
        }
    }

    @Override
    public void exportarXLS() {
        try {
            String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_XLS;
            download(url);
        } catch (Exception e) {
        }
    }
}
