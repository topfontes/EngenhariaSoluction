/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.graficos;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inc_informacoes_custo.Inc_informacoes_custoConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios.RelatorioBaseGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class CustosMateriasGWT extends RelatorioBaseGWT {

    private final String PAGE_HTML = "./easyEngenharia/easyconstru/graficos/custos_classesGraficos.jsp";
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/graficos/custos_classesGraficos.jsp";
    private ContentPanel cpREL = new ContentPanel(new FillLayout());
    private ListPlc_planoContasGWT listClasse = new ListPlc_planoContasGWT();
    private ComboBox<Plc_plano_contasTGWT> comboClasse = new ComboBox<Plc_plano_contasTGWT>();
    private NumberField qtdeItem = new NumberField();

    public CustosMateriasGWT() {

        this.setHeading("Custos das Principais Classes");
        cpREL.setHeaderVisible(false);
        cpREL.setFrame(false);
        listClasse.povoaSuperClasse();
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
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
    }

    private void addQuantidade() {
//        qtdeItem.setWidth(70);
        Button button = new Button("Informações", ICONS.importation());
        button.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                Inc_informacoes_custoConsultGWT consultGWT = new Inc_informacoes_custoConsultGWT();
                consultGWT.setObr_nr_id(getComboObra().getValue().getObr_nr_id());
                consultGWT.setPlc(comboClasse.getValue().getPlc_nr_id());
                consultGWT.setMes(getComboMes().getValue().getValue());
                consultGWT.setAno(getComboAno().getValue().getValue());
                consultGWT.load();
                consultGWT.show();
            }
        });
        getToolBarMaster().add(button);
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
                    getCpMaster().add(cpREL, new RowData(1, 1));
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public String getParamLocal() {

        String paramLocal = "&classe=" + comboClasse.getValue().getPlc_tx_nome() + "&plc_nr_id=";
        paramLocal += comboClasse.getValue().getPlc_nr_id() + "";
        return paramLocal;
    }

    @Override
    public void filtrar() {
        String paramLocal = "$classe=";
        if (comboClasse.getValue() != null) {
            paramLocal += comboClasse.getValue().getPlc_tx_nome();
            paramLocal += "$plc_nr_id=" + comboClasse.getValue().getPlc_nr_id();
        } else {
            paramLocal += "classe";
            paramLocal += "$plc_nr_id=0";
        }
//        paramLocal += "$qtde_item="+qtdeItem.getValue().intValue();
        String url = Constantes.URL + JSP_VIEW + PAGE_HTML + getParamBaseHTML() + paramLocal + TIPO_HTML;
        //com.google.gwt.user.client.Window.alert(url);
        //MessageBox.alert("", url, null);
        cpREL.setUrl(url);
        cpREL.layout();
        layout();//32523124

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
