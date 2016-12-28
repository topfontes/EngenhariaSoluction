/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.ui.client.widget.Window;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public abstract class AMenuDesktop {
    protected static final HashMap<String, Window> janelas = new HashMap<String, Window>();
    public abstract Window getWindowAcao(String acao);
}
 