/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class AnaliseCustosMateriaisGWT extends RelatorioBaseGWT {

    private final String PAGE_HTML = "./easyEngenharia/easyconstru/relatorios/analise_custos_materiais.jsp";
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/analise_custos_materiais.jsp";
    private ContentPanel cpREL = new ContentPanel(new FillLayout());
    private ListPlc_planoContasGWT listClasse = new ListPlc_planoContasGWT();
    private ComboBox<Plc_plano_contasTGWT> comboClasse = new ComboBox<Plc_plano_contasTGWT>();
    private CheckBox acumulado = new CheckBox();
    private NumberField qtdeItem = new NumberField();

    public AnaliseCustosMateriaisGWT() {

        this.setHeading("Custos Analíticos dos Materiais");
        cpREL.setHeaderVisible(false);
        cpREL.setFrame(false);
        listClasse.povoaSuperClasse();
        acumulado.setValue(true);
        acumulado.setBoxLabel("Acumulado");
        qtdeItem.setFormat(NumberFormat.getFormat("0"));
        qtdeItem.setAllowBlank(false);
        montarTela();
    }

    public void addClasse() {
        comboClasse.setStore(listClasse.getStore());
        comboClasse.setDisplayField("plc_tx_nome");
        comboClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboClasse.setEmptyText("Selecione a Classe");
        comboClasse.setWidth(250);
        comboClasse.setAllowBlank(false);
        getToolBarMaster().add(comboClasse);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
    }

    private void addAcumulado() {
        getToolBarMaster().add(acumulado);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
    }

    private void addQuantidade() {
        qtdeItem.setWidth(70);
        getToolBarMaster().add(new LabelToolItem("Qtde. Itens:"));
        getToolBarMaster().add(qtdeItem);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
    }

    private void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!getListObraGWT().isMostrar() || !listClasse.isInserido()) {
                    schedule(500);
                } else {
                    addComboObra();
                    addComboMes();
                    addComboAno();
                    addClasse();
                    addAcumulado();
                    addQuantidade();

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

        String paramLocal = "&subClasse=" + comboClasse.getValue().getPlc_tx_nome() + "&plc_nr_id=";
        paramLocal += comboClasse.getValue().getPlc_nr_id() + "";
        paramLocal += "&acumulado=" + acumulado.getValue() + "";
        paramLocal += "&qtde_item="+qtdeItem.getValue().intValue();

        return paramLocal;
    }

    @Override
    public void filtrar() {
        String paramLocal = "$subClasse=";
        if (comboClasse.getValue() != null) {
            paramLocal += comboClasse.getValue().getPlc_tx_nome();
            paramLocal += "$plc_nr_id=" + comboClasse.getValue().getPlc_nr_id();
        } else {
            paramLocal += "Sub Classe";
            paramLocal += "$plc_nr_id=0";
        }

        paramLocal += "$acumulado=" + acumulado.getValue() + "";
        paramLocal += "$qtde_item="+qtdeItem.getValue().intValue();
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
