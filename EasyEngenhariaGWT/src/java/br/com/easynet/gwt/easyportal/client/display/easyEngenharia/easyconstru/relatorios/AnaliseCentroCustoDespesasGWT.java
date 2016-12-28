/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Constantes;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author marcos
 */
public class AnaliseCentroCustoDespesasGWT extends RelatorioBaseGWT {

    private ContentPanel cpREL = new ContentPanel(new FillLayout());
    private final String PAGE_HTML = "./easyEngenharia/easyconstru/relatorios/analiseporCentrodeCustoDespesa.jsp";
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/analiseporCentrodeCustoDespesa.jsp";
    private CheckBox acumulado = new CheckBox();
    private NumberField menorque = new NumberField();
    private NumberField maiorque = new NumberField();

    public AnaliseCentroCustoDespesasGWT() {
        this.setHeading("Custos por Centro de Despesas");
        cpREL.setHeaderVisible(false);
        cpREL.setFrame(false);
        acumulado.setBoxLabel("Acumulado");
        acumulado.setValue(true);
        montarTela();
        layout();
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
                    addFiltro();
                    addAcumulado();
                    addBtnFiltrar();
                    addBtnExportar();
                    
                    getCpMaster().add(cpREL);
                    cpREL.setHeight(getCpMaster().getHeight() - 1);
                    cpREL.setWidth(getCpMaster().getWidth() - 1);
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public void addFiltro() {
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new LabelToolItem("menor que:"));
        menorque.setWidth(90);
        maiorque.setWidth(90);
        getToolBarMaster().add(menorque);
        getToolBarMaster().add(new LabelToolItem("maior que:"));
        getToolBarMaster().add(maiorque);
    }

    private void addAcumulado() {
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(acumulado);
    }

    public String getvalueFiltro(){
        double menor = menorque.getValue()!= null ? menorque.getValue().doubleValue(): 0;
        double maior = maiorque.getValue()!= null ? maiorque.getValue().doubleValue(): 0;
        return "$menor="+menor+"$maior="+maior;
    }

    @Override
    public void filtrar() {
        String url = Constantes.URL + JSP_VIEW + PAGE_HTML + getParamBaseHTML() + "$acumulado=" + acumulado.getValue() + "" + TIPO_HTML + getvalueFiltro();
        MessageBox.alert("",url,null);
        cpREL.setUrl(url);
        layout();
        doLayout();
    }

    @Override
    public void exportarPDF() {
        String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + "&acumulado=" + acumulado.getValue() + "" + TIPO_PDF + getvalueFiltro().replace("$", "&");
        download(url);
    }

    @Override
    public void exportarXLS() {
        String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + "&acumulado=" + acumulado.getValue() + "" + TIPO_XLS + getvalueFiltro().replace("$", "&");
        download(url);
    }
}
