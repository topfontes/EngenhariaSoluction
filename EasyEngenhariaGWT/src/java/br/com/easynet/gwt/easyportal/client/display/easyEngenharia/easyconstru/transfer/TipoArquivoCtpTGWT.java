/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 *
 * @author marcos
 */
public class TipoArquivoCtpTGWT extends BaseModel{

    public void setValue(int value){
        set("value",value);
    }
    public int getValue(){
        return ((Integer) get("value")).intValue();
    }

    public void setDisplay(String display){
        set("display",display);
    }

    public String getDisplay(){
        return get("display");
    }

}
