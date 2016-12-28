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
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class ComprometimentoGWT extends RelatorioBaseGWT{

    private ContentPanel cpREL = new ContentPanel(new FillLayout());
    private final String PAGE_HTML = "./easyEngenharia/easyconstru/relatorios/comprometimento.jsp";
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/comprometimento.jsp";
    private RadioGroup radioGroup = new RadioGroup();

    public ComprometimentoGWT() {
        this.setHeading("Comprometimento");
        cpREL.setHeaderVisible(false);
        cpREL.setFrame(false);
        Radio previsto = new Radio();
        previsto.setBoxLabel("Previsto");
        previsto.setValue(true);

        Radio realizado = new Radio();
        realizado.setBoxLabel("Realizado");

        radioGroup.add(previsto);
        radioGroup.add(realizado);

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
                    addradioGroup();
                    addBtnFiltrar();
                    addBtnExportar();
                    getCpMaster().add(cpREL);
                    cpREL.setHeight(getCpMaster().getHeight() - 2);
                    cpREL.setWidth(getCpMaster().getWidth() - 2);
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void addradioGroup(){
        getToolBarMaster().add(radioGroup);
//        getToolBarMaster().setPagePosition(10, 2);
    }

    public String getPrevisto(){
       String param = radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Previsto")?"true":"false";
       param = "previsto="+param;
        return param;
    }

    @Override
    public void filtrar() {
        String url = Constantes.URL + JSP_VIEW + PAGE_HTML + getParamBaseHTML() + TIPO_HTML+"$"+getPrevisto();
        cpREL.setUrl(url);
        layout();
        doLayout();
    }

    @Override
    public void exportarPDF() {
        String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_PDF+"&"+getPrevisto();
        download(url);
    }

    @Override
    public void exportarXLS() {
        String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + TIPO_XLS+"&"+getPrevisto();
        download(url);
    }




}
