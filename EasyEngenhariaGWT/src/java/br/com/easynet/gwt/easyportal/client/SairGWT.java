/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Grid;
 import com.extjs.gxt.ui.client.widget.form.LabelField; 
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author geoleite
 */
public class SairGWT extends EasyContainer implements IListenetResponse {

    private LabelField lblMensagem = new LabelField("Tem certeza que deseja sair do sistema?");
    private Button btnSim = new Button("Sim");
    private Button btnNao = new Button("Nao");

    public SairGWT() {
/*        setLayout(new RowLayout(Orientation.VERTICAL));
        Grid grid = new Grid(2, 2);
        grid.setWidget(0, 0, lblMensagem);
        grid.setWidget(1, 0, btnSim);
        grid.setWidget(1, 1, btnNao);


        btnSim.addClickListener(new ClickListener() {

            public void onClick(Widget sender) {
                btnSimAction(sender);
            }
        });
        btnNao.addClickListener(new ClickListener() {

            public void onClick(Widget sender) {
                btnNaoAction(sender);
            }
        });
        add(grid);
*/
            MessageBox mb = MessageBox.confirm("Aviso", "Deseja realmente sair?", new Listener<MessageBoxEvent>() {

                public void handleEvent(MessageBoxEvent be) {
                    if ("yes".equalsIgnoreCase(be.getButtonClicked().getText())) {
                        btnSimAction(be.getButtonClicked());
                    }
                    
                }
            });

    }

    public void btnSimAction(Widget sender) {
        try {
            

            EasyAccessURL eaurl = new EasyAccessURL(this);
            String url = Constantes.URL + "portalgwt/principalpage.jsp?op=sair";
            eaurl.accessJSon(url);
        } catch (Exception e) {
            Window.alert("Problema ao sair do sistema. " + e.getMessage());
        }
    }

    /**
     * Fecha a aba da tela de sair
     * @param sender
     */
    public void btnNaoAction(Widget sender) {
        TabItem ti = Portal2GWT.tab.getItemByItemId("Sair");
        Portal2GWT.tab.remove(ti);

    }

    public void read(JSONValue jsonValue) {
        Portal2GWT.panelBase.setVisible(false);
        AuthenticationGWT authentication = new AuthenticationGWT();
        RootPanel.get().add(authentication);

    }
}
