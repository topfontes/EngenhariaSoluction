/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.equivalencia;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class Arquivo_XLS_TempGWT extends Window {
    private String page="";
    private ComboBox<Obr_obrasTGWT> cbobra = new ComboBox<Obr_obrasTGWT>();
    private LabelField field = new LabelField();
    ContentPanel cp = new ContentPanel();

    public Arquivo_XLS_TempGWT() {
        this.setSize(300, 100);
        this.setLayout(new FillLayout());
        cp.setHeaderVisible(false);
        add(cp);

        cbobra.setDisplayField("obr_tx_nome");
        cbobra.setTriggerAction(ComboBox.TriggerAction.ALL);
        final ToolBar bar = new ToolBar();
        cp.setTopComponent(bar);
       

        final ListObraGWT listObraGWT = new ListObraGWT();
        listObraGWT.povoar();
        Timer timer = new Timer() {

            @Override
            public void run() {
              if(!listObraGWT.isMostrar()){
                  schedule(200);
                }else{

                 cbobra.setStore(listObraGWT.getStore());
                 cbobra.getListView().refresh();
                 bar.add(cbobra);
                 layout();
              }
            }
        };timer.schedule(10);


        cbobra.addSelectionChangedListener(new SelectionChangedListener<Obr_obrasTGWT>() {

            @Override
            public void selectionChanged(SelectionChangedEvent<Obr_obrasTGWT> se) {
                setPage();
            }
        });

        field.setText("<a href =" + page + "> Download <a/>");
        cp.add(field);
        layout();
        show();
    }

    public void setPage(){
        page = Constantes.URL + "easyEngenharia/easyconstru/ort_orcamento_temporario/gerar_xlsOrtTemp.jsp?op=gerarArquivoXls&obr_nr_id="+cbobra.getValue().getObr_nr_id();
        field.setText("<a href =" + page + "> Download <a/>");
        com.google.gwt.user.client.Window.alert(page);
    }
}
