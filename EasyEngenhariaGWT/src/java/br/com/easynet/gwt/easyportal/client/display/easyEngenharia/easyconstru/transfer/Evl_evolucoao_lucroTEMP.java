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
public class Evl_evolucoao_lucroTEMP extends BaseModel{

  public void setMesAno(String mesAno){
      set("mesAno",mesAno);
  }

  public String getMesAno(){
      return get("mesAno");
  }
  
  public double getOriginal() {
    return  ((Float)get("original")).doubleValue();
//    return get("evl_nr_valor");
  }

  public void setOriginal(double original) {
    set("original", original);
  }

  public double getMeta() {
    return  ((Float)get("meta")).doubleValue();
  }

  public void setMeta(double meta) {
    set("meta", meta);
  }

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
    public void setObr_nr_id(int obr_nr_id){
        set("obr_nr_id",obr_nr_id);
    }
    public int getObr_nr_id(){
        return ((Integer) get("obr_nr_id")).intValue();
    }
}
