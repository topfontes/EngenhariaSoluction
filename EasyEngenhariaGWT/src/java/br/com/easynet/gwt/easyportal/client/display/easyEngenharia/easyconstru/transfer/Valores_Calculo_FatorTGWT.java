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
public class Valores_Calculo_FatorTGWT extends BaseModel{

    public int getObr_nr_id(){
        return ((Integer)get("obr_nr_id")).intValue();
    }

    public void setObr_nr_id(int obr_nr_id){
        set("obr_nr_id",obr_nr_id);
    }

    public int getPlc_nr_id(){
        return ((Integer)get("plc_nr_id")).intValue();
    }

    public void setPlc_nr_id(int plc_nr_id){
        set("plc_nr_id",plc_nr_id);
    }

    public int getMes(){
        return ((Integer)get("mes")).intValue();
    }

    public void setMes(int mes){
        set("mes",mes);
    }

    public int getAno(){
        return ((Integer)get("ano")).intValue();
    }

    public void setAno(int ano){
        set("ano",ano);
    }



    public String getPlc_tx_nome(){
        return get("plc_tx_nome");
    }
    
    public void setPlc_tx_nome(String plc_tx_nome){
        set("plc_tx_nome",plc_tx_nome);
    }

    public float getFator_Atual(){
        return ((Float) get("fator_Atual")).floatValue();
    }
    
    public void setFator_Atual(Float fator_Atual){
        set("fator_Atual",fator_Atual);
    }

    public double getFator_projetado(){
        return ((Double)get("fator_projetado")).floatValue();
    }

    public void setFator_projetado(double fator_projetado){
       set("fator_projetado",fator_projetado);
    }

}
