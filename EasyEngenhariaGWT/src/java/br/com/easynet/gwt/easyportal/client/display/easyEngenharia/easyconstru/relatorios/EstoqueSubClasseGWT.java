/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author marcos
 */
public class EstoqueSubClasseGWT extends RelatorioBaseGWT implements IListenetResponse {

    private final String PAGE_HTML = "./easyEngenharia/easyconstru/relatorios/estoqueSubClasse.jsp";
    private final String PAGE_EXPORT = "easyEngenharia/easyconstru/relatorios/estoqueSubClasse.jsp";
    private ContentPanel cpREL = new ContentPanel(new FillLayout());
    private ListPlc_planoContasGWT listClasse = new ListPlc_planoContasGWT();
    private ComboBox<Plc_plano_contasTGWT> comboClasse = new ComboBox<Plc_plano_contasTGWT>();

    public EstoqueSubClasseGWT() {
        this.setHeading("Estoque");
        cpREL.setHeaderVisible(false);
        cpREL.setFrame(false);
        listClasse.povoaSuperClasse();
        montarTela();
    }

    public void addClasse() {
        comboClasse.setStore(listClasse.getStore());
        comboClasse.setDisplayField("plc_tx_nome");
        comboClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboClasse.setEmptyText("Selecione a Classe");
        comboClasse.setWidth(250);
        comboClasse.setAutoValidate(false);
        comboClasse.setAllowBlank(true);
        getToolBarMaster().add(comboClasse);
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
                    int a = 2;
                    addComboObra();
                    addComboMes();
                    addComboAno();
                    addClasse();

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
        String paramLocal ="";
        if (comboClasse.getValue() != null) {
            paramLocal = "&subClasse=" + comboClasse.getValue().getPlc_tx_nome() + "&plc_nr_id=";
            paramLocal += comboClasse.getValue().getPlc_nr_id();
        }else{
           paramLocal = "&subClasse=Sub Classe" ;
        }
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
            paramLocal += "$plc_nr_id_super=0";
        }
        String url = Constantes.URL + JSP_VIEW + PAGE_HTML + getParamBaseHTML() + paramLocal + TIPO_HTML;
//        Window.alert(url);
        cpREL.setUrl(url);
        layout();//32523124
        doLayout();
    }

    @Override
    public void exportarPDF() {
        try {
//            Window.alert("chegou");
            String url = Constantes.URL + PAGE_EXPORT + getParamBaseExport() + getParamLocal() + TIPO_PDF;
//            Window.alert(url);
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

    public void read(JSONValue jsonValue) {
    }
}
