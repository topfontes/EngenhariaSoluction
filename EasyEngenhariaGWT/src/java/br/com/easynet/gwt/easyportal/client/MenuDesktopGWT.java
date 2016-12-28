/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client;

//import br.com.easynet.gwt.easyportal.client.display.EasyEngenharia.ActionMenu;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.ActionMenu;
import com.extjs.gxt.desktop.client.Desktop; 
import com.extjs.gxt.desktop.client.StartMenu;
import com.extjs.gxt.desktop.client.TaskBar;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author geoleite
 */
public class MenuDesktopGWT implements IListenetResponse {

    private Desktop desktop;
    private MessageBox mbProgress;

    public void loadMenu() {
        try {
            String url = Constantes.URL + "portalgwt/menu.jsp";
            EasyAccessURL eaurl = new EasyAccessURL(this);
            mbProgress = MessageBox.wait("Requisicao", "Solicitando ao Servidor.", "Processo...");
            eaurl.accessJSon(url);
        } catch (Exception ex) {
            Window.alert("Error:" + ex.getMessage());
        }
    }

    public void setMenuTool(StartMenu menu) {

        SelectionListener<MenuEvent> listener = new SelectionListener<MenuEvent>() {

            @Override
            public void componentSelected(MenuEvent ce) {
                com.extjs.gxt.ui.client.widget.Window w = null;
                if (ce instanceof MenuEvent) {
                    MenuEvent me = (MenuEvent) ce;
                    w = me.getItem().getData("window");
                } else {
                    w = ce.getComponent().getData("window");
                }
                if (!desktop.getWindows().contains(w)) {
                    desktop.addWindow(w);
                }
                if (w != null && !w.isVisible()) {
                    w.show();
                } else {
                    w.toFront();
                }
            }
        };

        MenuItem tool = new MenuItem("Alterar Senha");
        tool.setIconStyle("settings");
        tool.addSelectionListener(listener);
        com.extjs.gxt.ui.client.widget.Window win = new com.extjs.gxt.ui.client.widget.Window();
        win.add(new AlterarSenhaGWT());
        win.setSize("300", "250");
        win.setHeaderVisible(true);
        win.setHeading("Alterar Senha");
        win.setClosable(true);
        win.setMinimizable(true);

        tool.setData("window", win);
        menu.addTool(tool);

        menu.addToolSeperator();

        tool = new MenuItem("Sair");
        tool.setIconStyle("logout");
        tool.addSelectionListener(new SelectionListener<MenuEvent>() {

            @Override
            public void componentSelected(MenuEvent ce) {

                MessageBox mb = MessageBox.confirm("Aviso", "Deseja realmente sair?", new Listener<MessageBoxEvent>() {

                    public void handleEvent(MessageBoxEvent be) {
                        if ("yes".equalsIgnoreCase(be.getButtonClicked().getText())) {
                            btnSimAction(be.getButtonClicked());
                        }
                    }
                });

            }
        });

        tool.setData("window", menu);
        menu.addTool(tool);
    }

    public void btnSimAction(Widget sender) {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(new SairIListenerUrl());
            String url = Constantes.URL + "portalgwt/principalpage.jsp?op=sair";
            eaurl.accessJSon(url);
        } catch (Exception e) {
            Window.alert("Problema ao sair do sistema. " + e.getMessage());
        }
    }

    public void read(JSONValue jsonValue) {

        SelectionListener<MenuEvent> listener = new SelectionListener<MenuEvent>() {

            @Override
            public void componentSelected(MenuEvent ce) {
                com.extjs.gxt.ui.client.widget.Window w = null;
                
                if (ce instanceof MenuEvent) {
                    MenuEvent me = (MenuEvent) ce;
                    com.extjs.gxt.ui.client.widget.Window win = null;
                    AMenuDesktop ecm = new ActionMenu();
                    String acao = me.getItem().getData("window");
                    //Window.alert((String) me.item.getData("window"));
                    
                    w = ecm.getWindowAcao(acao);
                    //Window.alert("MenuEvent " + acao);
                } else {
                    w = ce.getComponent().getData("window");
                }
                if (!desktop.getWindows().contains(w)) {
                    desktop.addWindow(w);
                }
                if (w != null && !w.isVisible()) {
                    w.show();
                } else {
                    w.toFront();
                }
            }
        };

        // Monta o menu baseado nas informacoes do servidor

        JSONObject jsonObject;
        mbProgress.close();
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            //Window.alert(resultado.toString());
            JSONArray menuContent = resultado.get("menu").isArray();
            //Window.alert(menuContent.isArray().toString());
            TaskBar taskBar = desktop.getTaskBar();
            StartMenu menuBar = taskBar.getStartMenu();
            //menuBar.addItem(getMenuPadrao());
            //menu.add(getMenuPadrao());
            setMenuTool(menuBar);


            for (int i = 1; i < menuContent.size(); i++) {

                JSONValue menu = menuContent.get(i);
                String nome = menu.isObject().get("nome").toString();
                nome = nome.replace('"', ' ').trim();
                String acao = menu.isObject().get("acao").toString();
                acao = acao.replace('"', ' ').trim();
                String sistema = menu.isObject().get("sistema").toString();
                sistema = sistema.replace('"', ' ').trim();

                //MenuEvento menuEvento = getMenuEvento(sistema);

                //menuEvento.setActionDisplay(acao);

                MenuItem item = new MenuItem(nome);
                getMenuEvento(sistema, acao, item);
                //item.setData("window", getMenuEvento(item));
                item.addSelectionListener(listener);
                menuBar.add(item);
                item.setIconStyle("bogus");
                //menuBar.addItem(item);
                JSONArray submenu = menu.isObject().get("submenu").isArray();
                montaSubMenu(item, listener, submenu);


            //Window.alert("Menu " + item.getText());
            }

        }

    }

    /**
     * Monta recursivamente os submenus
     * @param item
     * @param submenu
     */
    private void montaSubMenu(MenuItem item, SelectionListener<MenuEvent> listener, JSONArray submenu) {

        if (submenu != null && submenu.size() > 1) {
            Menu sub = new Menu();
            item.setSubMenu(sub);
            MenuItem subMenu1 = new MenuItem();
            for (int j = 1; j < submenu.size(); j++) {
                JSONValue sm1 = submenu.get(j);
                String subnome = sm1.isObject().get("nome").toString();
                subnome = subnome.replace('"', ' ').trim();
                String subacao = sm1.isObject().get("acao").toString();
                String sistema = sm1.isObject().get("sistema").toString();
                sistema = sistema.replace('"', ' ').trim();
                subacao = subacao.replace('"', ' ').trim();
                MenuItem subitem = new MenuItem(subnome);
                getMenuEvento(sistema, subacao, subitem);
                subitem.addSelectionListener(listener);
                subitem.setIconStyle("bogus");
                item.getSubMenu().add(subitem);
                JSONArray submenu1 = sm1.isObject().get("submenu").isArray();
                montaSubMenu(subitem, listener, submenu1);

            }

        }
    }

    /**
     * Obtem o tratamento de Eventos do menu pelo nome do Sistema
     * @param sistema
     * @return
     */
    public MenuEventoDesktopGWT getMenuEvento(String sistema, String acao, MenuItem item) {
        MenuEventoDesktopGWT menuEvento = null;
        menuEvento = new MenuEventoDesktopGWT(desktop, item);
        
        if ("Engenharia".equals(sistema)) {
            item.setData("window", acao);
        } else {
            MessageBox.alert("Falha na execução", "Opção ainda não implementada", null);
        }

        return menuEvento;
    }

    /**
     * @return the desktop
     */
    public Desktop getDesktop() {
        return desktop;
    }

    /**
     * @param desktop the desktop to set
     */
    public void setDesktop(Desktop desktop) {
        this.desktop = desktop;
    }
}

class SairIListenerUrl implements IListenetResponse {

    public void read(JSONValue jsonValue) {
        //execute("document.location='index.html?teste=1';");
        //execute("history.go();");
    execute("document.location.reload();");

    //execute("window.location.reload( true );");
    }

    public native static void execute(String command)/*-{
    eval(command);
    }-*/;
}

