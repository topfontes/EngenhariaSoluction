/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.TextField;

/**
 *
 * @author geoleite
 */
public class MaskKeyListener extends KeyListener {
    private String mask="";
    public void componentKeyPress(ComponentEvent event) {
        TextField<String> tf = (TextField<String>)event.getSource();
        MessageBox.info("KeyPress", tf.getValue(), null);
    }

    public void componentKeyUp(ComponentEvent event) {
        TextField<String> tf = (TextField<String>)event.getSource();
        MessageBox.info("KeyPressUp", tf.getValue(), null);
    }

    /**
     * @return the mask
     */
    public String getMask() {
        return mask;
    }

    /**
     * @param mask the mask to set
     */
    public void setMask(String mask) {
        this.mask = mask;
    }
}
