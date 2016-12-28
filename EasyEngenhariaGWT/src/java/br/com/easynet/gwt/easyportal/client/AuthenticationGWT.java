/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client;
 
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.desktop.client.StartMenu;
import com.extjs.gxt.desktop.client.TaskBar;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.form.LabelField; 
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.core.client.GWT;
import java.util.HashMap; 

/**
 *
 * @author geoleite
 */
public class AuthenticationGWT extends com.extjs.gxt.ui.client.widget.Window implements IListenetResponse {

    /**
     * @return the portal
     */
    public static PortalDesktopGWT getPortal() {
        return portal;
    }

    /** 
     * @param aPortal the portal to set
     */
    public static void setPortal(PortalDesktopGWT aPortal) {
        portal = aPortal;
    }

    //private TextField txtUserName;
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private TextField<String> txtUserName = new TextField<String>();;
    private LabelField lblUserName = new LabelField("Login:");
    private LabelField lblPassword = new LabelField("Senha:");
    private TextField<String> ptbPassword = new TextField<String>();;
    private Button btnEntrar = new Button("Entrar");
    private MessageBox mbProgress;
    private static PortalDesktopGWT portal = null ;
    
    public AuthenticationGWT () {

        setIcon(ICONS.chave());
        setResizable(false);
        setModal(true);
        setClosable(false);
        setLayout(new FitLayout());
        setSize(227, 115);
        ptbPassword.setPassword(true);
        setHeaderVisible(true);
        setHeading("Login");
        setLayout(new TableLayout(2));
        add(lblUserName);
        add(txtUserName);
        add(lblPassword);
        add(ptbPassword);
        addButton(btnEntrar);

        KeyEvento eventoKey = new KeyEvento();
        eventoKey.setAuthenticationGWT(this);
        txtUserName.addKeyListener(eventoKey);
        ptbPassword.addKeyListener(eventoKey);
        btnEntrar.setIconAlign(IconAlign.LEFT);
        
        btnEntrar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                logar();
            }
        });
        //txtUserName.setFocus(true);
    }



    public void logar() {
        try {
            EasyAccessURL access = new EasyAccessURL(this);
            String url = Constantes.URL + "portalgwt/authentication.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "autenticar");//op=autenticar
            param.put("usu_usuarioT.usu_tx_login", txtUserName.getValue());
            param.put("usu_usuarioT.usu_tx_senha", ptbPassword.getValue());
            mbProgress = MessageBox.wait("Requisicao", "Realizando autenticacao.", "Processo...");
            access.accessJSonMap(url, param);
        } catch (Exception ex) {
        }

    }

    public void read(JSONValue jsonValue) {
        
        mbProgress.close();
        JSONObject jsonObject;
        //Window.alert("aqui");
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONObject resultado = jsonObject.get("resultado").isObject();
            //Window.alert(resultado.toString());
            String valor = resultado.get("autenticacao").toString();
            valor = valor.replace('"', ' ').trim();
            String usuario = resultado.get("usuario").toString();
            usuario = usuario.replace('"', ' ').trim();
            if ("true".equals(valor)) {
                this.setVisible(false);
                MenuDesktopGWT menu = new MenuDesktopGWT();
                TaskBar taskBar = getPortal().getDesktop().getTaskBar();
                StartMenu menuDesktop = taskBar.getStartMenu();
                menuDesktop.setHeading(usuario);
                menu.setDesktop(getPortal().getDesktop());
                menu.loadMenu();
            } else {
                MessageBox mb = new MessageBox();
                String valorMsg = "Usuario ou senha invalidos!";
                mb.alert("Falha ao efetuar login.", valorMsg, null);
            }
        }
        mbProgress.close();
    }
}


class KeyEvento extends KeyListener {

    private AuthenticationGWT authenticationGWT;

    /**
     * Fires on key down.
     *
     * @param event the component event
     */
    public void componentKeyDown(ComponentEvent event) {
    }

    /**
     * Fires on key press.
     *
     * @param event the component event
     */
    public void componentKeyPress(ComponentEvent event) {
    }

    /**
     * Fires on key up.
     *
     * @param event the component event
     */
    public void componentKeyUp(ComponentEvent event) {
        if (event.getKeyCode() == 13) {// enter
            authenticationGWT.logar();
        }
    }

    /**
     * @param authenticationGWT the authenticationGWT to set
     */
    public void setAuthenticationGWT(AuthenticationGWT authenticationGWT) {
        this.authenticationGWT = authenticationGWT;
    }
}

