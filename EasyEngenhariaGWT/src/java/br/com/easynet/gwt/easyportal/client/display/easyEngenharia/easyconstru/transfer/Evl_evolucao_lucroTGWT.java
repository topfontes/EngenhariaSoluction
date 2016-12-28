
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
public class Evl_evolucao_lucroTGWT extends BaseModel{
  public Evl_evolucao_lucroTGWT() {
  }

  public int getEvl_nr_id() {
    return  ((Integer)get("evl_nr_id")).intValue();
//    return get("evl_nr_id");
  }

  public void setEvl_nr_id(int evl_nr_id) {
    set("evl_nr_id", evl_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getEvl_nr_mes() {
    return  ((Integer)get("evl_nr_mes")).intValue();
//    return get("evl_nr_mes");
  }

  public void setEvl_nr_mes(int evl_nr_mes) {
    set("evl_nr_mes", evl_nr_mes);
  }

  public int getEvl_nr_ano() {
    return  ((Integer)get("evl_nr_ano")).intValue();
//    return get("evl_nr_ano");
  }

  public void setEvl_nr_ano(int evl_nr_ano) {
    set("evl_nr_ano", evl_nr_ano);
  }

  public float getEvl_nr_valor() {
    return  ((Float)get("evl_nr_valor")).floatValue();
//    return get("evl_nr_valor");
  }

  public void setEvl_nr_valor(float evl_nr_valor) {
    set("evl_nr_valor", evl_nr_valor);
  }

  public int getEvl_nr_mes_ref() {
    return  ((Integer)get("evl_nr_mes_ref")).intValue();
//    return get("evl_nr_mes_ref");
  }

  public void setEvl_nr_mes_ref(int evl_nr_mes_ref) {
    set("evl_nr_mes_ref", evl_nr_mes_ref);
  }

  public int getEvl_nr_ano_ref() {
    return  ((Integer)get("evl_nr_ano_ref")).intValue();
//    return get("evl_nr_ano_ref");
  }

  public void setEvl_nr_ano_ref(int evl_nr_ano_ref) {
    set("evl_nr_ano_ref", evl_nr_ano_ref);
  }

  public String getEvl_tx_tipo() {
    return  get("evl_tx_tipo");
//    return get("evl_tx_tipo");
  }

  public void setEvl_tx_tipo(String evl_tx_tipo) {
    set("evl_tx_tipo", evl_tx_tipo);
  }



}

