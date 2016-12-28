/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.ui.client.widget.button.Button;

/**
 *
 * @author geoleite
 */
public class TesteGWT extends EasyContainer {
    public TesteGWT() {
        Button btn = new Button();
        btn.setText("Teste");
        this.add(btn);
    }
}
