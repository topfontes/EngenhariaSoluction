/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 *
 * @author marcos
 */
public class Ano extends BaseModel{

    public void setValue(int value){
        set("value", value);
    }
    public int getValue(){
        return ((Integer)get("value")).intValue();
    }
    public void setDisplay(int display){
        set("display", display);
    }

    public int getDisplay(){
        return ((Integer)get("display")).intValue();
    }

}
