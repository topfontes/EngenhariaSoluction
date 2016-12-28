/*
 * MainEntryPoint.java
 *
 * Created on January 17, 2009, 3:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client;
  
import com.extjs.gxt.desktop.client.Desktop;
import com.extjs.gxt.desktop.client.Shortcut;
import com.extjs.gxt.themes.client.Slate;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.util.Theme;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.ModalPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
 import com.extjs.gxt.ui.client.widget.form.LabelField; 
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class MainEntryPoint implements EntryPoint, IListenetResponse {

    private Desktop desktop = new Desktop();

    /** Creates a new instance of MainEntryPoint */
    public MainEntryPoint() {


    }

    /**
     * The entry point method, called automatically by loading a module
     * that declares an implementing class as an entry-point
     */
    
    public void onModuleLoad() {
        try {

            AuthenticationGWT authentication = new AuthenticationGWT();

            PortalDesktopGWT portal = new PortalDesktopGWT();

            authentication.setPortal(portal);

            authentication.show();
           
            portal.gerarMenu(desktop);
        } catch (Exception ex) {
        }

    }

    public native static Object getJson(String json)/*-{
    return eval("GWT.create(" + json + ")");
    }-*/;

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String valor = resultado.get("autenticacao").toString();
            valor = valor.replace('"', ' ').trim();
            String usuario = resultado.get("usuario").toString();
            usuario = usuario.replace('"', ' ').trim();
            if ("true".equals(valor)) {
                if (AuthenticationGWT.getPortal() == null) {
                    AuthenticationGWT.setPortal(new PortalDesktopGWT());
                } else {
                    //Portal2GWT.tab.removeAll();
                }
            //AuthenticationGWT.portal.panelBase.setVisible(true);

            //AuthenticationGWT.portal.setNomeUsuario(usuario);
            //RootPanel.get().add(AuthenticationGWT.portal);

            } else {
                AuthenticationGWT authentication = GWT.create(br.com.easynet.gwt.easyportal.client.AuthenticationGWT.class);
                RootPanel.get().add(authentication);

            } 


        }
    }
}
