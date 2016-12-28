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
public class Meses_obrasTGWT extends BaseModel {

    public void setMes(int mes){
        set("mes",mes);
    }
    public int getMes(){
      return  ((Integer) get("mes")).intValue();
    }

    public void setAno(int ano){
        set("ano",ano);
    }
    public int getAno(){
        return ((Integer) get("ano")).intValue();
    }

    public void setMes_ano(String mes_ano){
        set("mes_ano",mes_ano);
    }
    
    public String getMes_ano(){
       return get("mes_ano");
    }

    public void setPeso(float peso){
        set("peso",peso);
    }

    public float getPeso(){
        return ((Float) get("peso")).floatValue();
    }
}
