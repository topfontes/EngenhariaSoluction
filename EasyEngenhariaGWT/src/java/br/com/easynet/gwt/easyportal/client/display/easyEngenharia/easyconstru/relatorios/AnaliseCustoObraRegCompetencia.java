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
public class AnaliseCustoObraRegCompetencia extends RelatorioBaseGWT {

    private ContentPanel cpREL = new ContentPanel(new FillLayout());
    private final String PAGE_HTML = "./easyEngenharia/easyconstru/relatorios/analise_classe_obra_reg_comp.jsp";
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/analise_classe_obra_reg_comp.jsp";

    public AnaliseCustoObraRegCompetencia() {
        this.setHeading("ANALISE CUSTOS OBRA POR REGIME DE COMPETÊNCIA");
        cpREL.setHeaderVisible(false);
        montarTela();
    }
    
    public void montarTela() {
        Timer timer = new Timer() {
            @Override
            public void run() {
                if (!getListObraGWT().isMostrar()) {
                    schedule(500);
                } else {
                    int a =1;
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
        MessageBox.alert("",url, null);
        layout();
        doLayout();
    }

    @Override
    public void exportarPDF() {
        String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_PDF;
        //Window.alert(url);
        download(url);
    }

    @Override
    public void exportarXLS() {
        String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_XLS;
        download(url);
    }

}
