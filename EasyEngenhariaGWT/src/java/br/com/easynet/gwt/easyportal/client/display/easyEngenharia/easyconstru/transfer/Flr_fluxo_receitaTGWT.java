
/*
 * EasyNet JDragon
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Flr_fluxo_receitaTGWT extends BaseModel{
  public Flr_fluxo_receitaTGWT() {
  }


  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("flr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getFlr_nr_id() {
    return  ((Integer)get("flr_nr_id")).intValue();
//    return get("flr_nr_id");
  }

  public void setFlr_nr_id(int flr_nr_id) {
    set("flr_nr_id", flr_nr_id);
  }

  public int getFlr_nr_mes() {
    return  ((Integer)get("flr_nr_mes")).intValue();
//    return get("flr_nr_mes");
  }

  public void setFlr_nr_mes(int flr_nr_mes) {
    set("flr_nr_mes", flr_nr_mes);
  }

  public int getFlr_nr_ano() {
    return  ((Integer)get("flr_nr_ano")).intValue();
//    return get("flr_nr_ano");
  }

  public void setFlr_nr_ano(int flr_nr_ano) {
    set("flr_nr_ano", flr_nr_ano);
  }

  public float getFlr_nr_original() {
    return  ((Float)get("flr_nr_original")).floatValue();
//    return get("flr_nr_original");
  }

  public void setFlr_nr_original(float flr_nr_original) {
    set("flr_nr_original", flr_nr_original);
  }

  public float getFlr_nr_atual() {
    return  ((Float)get("flr_nr_atual")).floatValue();
//    return get("flr_nr_atual");
  }

  public void setFlr_nr_atual(float flr_nr_atual) {
    set("flr_nr_atual", flr_nr_atual);
  }

  public String getFlr_tx_key() {
    return  get("flr_tx_key");
//    return get("flr_tx_key");
  }

  public void setFlr_tx_key(String flr_tx_key) {
    set("flr_tx_key", flr_tx_key);
  }

  public String getDescColumn() {
    return  get("desc");
//    return get("flr_tx_key");
  }

  public void setDescColumn(String desc) {
    set("desc", desc);
  }

}

