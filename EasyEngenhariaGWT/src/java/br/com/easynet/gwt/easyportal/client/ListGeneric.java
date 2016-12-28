/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */

public class ListGeneric extends BaseModel{

    public String getValue() {
        return get("value");
    }


    public void setValue(String value) {
        set("value",value);
    }


    public String getDisplay() {
        return get("display");
    }


    public void setDisplay(String display) {
        set("display",display);
    }



}
