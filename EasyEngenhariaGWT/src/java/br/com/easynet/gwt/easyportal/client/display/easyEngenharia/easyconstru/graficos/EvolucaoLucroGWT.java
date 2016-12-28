/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.graficos;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.RelatorioBaseGWT;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos 
 */
public class EvolucaoLucroGWT extends RelatorioBaseGWT{
    private final String PAGE_HTML = "./easyEngenharia/easyconstru/graficos/evolucaoLucros.jsp";
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/graficos/evolucaoLucros.jsp";
    private ContentPanel cpREL = new ContentPanel(new FillLayout());

    public EvolucaoLucroGWT() {

        this.setHeading("Evolução dos Lucros");
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
                    addComboObra();
                    addComboMes();
                    addComboAno();
                    addBtnFiltrar();
                    addBtnExportar();
                    getCpMaster().add(cpREL,new RowData(1, 1));
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
        String paramLocal = "";

        String url = Constantes.URL + JSP_VIEW + PAGE_HTML + getParamBaseHTML() + paramLocal + TIPO_HTML;
        //com.google.gwt.user.client.Window.alert(url);
        cpREL.setUrl(url);
        layout();//32523124
        doLayout();
    }

    @Override
    public void exportarPDF() {
        try {
            String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + getParamLocal() + TIPO_PDF;
            download(url);
        } catch (Exception e) {
        }
    }

    @Override
    public void exportarXLS() {
        try {
            String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + getParamLocal() + TIPO_XLS;
            download(url);
        } catch (Exception e) {
        }
    }



}
