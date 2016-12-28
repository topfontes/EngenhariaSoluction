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
public class FluxoCaixaTGWT extends BaseModel{

    public void setId(int id){
        set("id",id);
    }
    public int getId(){
        return ((Integer)get("id")).intValue();
    }

    public void setDescricao(String descricao){
        set("descricao",descricao);
    }

    public String getDescricao(){
        return get("descriaco");
    }
}
