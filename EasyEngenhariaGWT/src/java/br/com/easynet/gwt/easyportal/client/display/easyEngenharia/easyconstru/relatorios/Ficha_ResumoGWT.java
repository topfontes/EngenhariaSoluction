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
public class Ficha_ResumoGWT extends RelatorioBaseGWT{

    final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/ficha_resumo.jsp";
    final String PAGE_HTML = "./easyEngenharia/easyconstru/relatorios/ficha_resumo.jsp";
    private ContentPanel cpREL = new ContentPanel(new FillLayout());

    public Ficha_ResumoGWT() {
        this.setHeading("Ficha Resumo");
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
        //MessageBox.alert("",url,null);
        cpREL.setUrl(url);
        cpREL.layout();
        layout();
    }

    @Override
    public void exportarPDF() {
        //MessageBox.alert("",Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_PDF,null);
        download(Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_PDF);
    }

    @Override
    public void exportarXLS() {
        download(Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_XLS);
    }

}
