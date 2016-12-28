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
public class UFTGWT extends BaseModel{
    public void setValue(String value){
        set("value",value);
    }
    public String getValue(){
        return get("value");
    }

    public void setDisplay(String display){
        set("display",display);
    }
    public String getDispaly(){
        return get("display");
    }
    
}
