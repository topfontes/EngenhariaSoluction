
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
public class Plp_planilha_permutaTGWT extends BaseModel{
  public Plp_planilha_permutaTGWT() {
  }

  public int getPlp_nr_id() {
    return  ((Integer)get("plp_nr_id")).intValue();
//    return get("plp_nr_id");
  }

  public void setPlp_nr_id(int plp_nr_id) {
    set("plp_nr_id", plp_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getPlp_nr_mes_ref() {
    return  ((Integer)get("plp_nr_mes_ref")).intValue();
//    return get("plp_nr_mes_ref");
  }

  public void setPlp_nr_mes_ref(int plp_nr_mes_ref) {
    set("plp_nr_mes_ref", plp_nr_mes_ref);
  }

  public int getPlp_nr_ano_ref() {
    return  ((Integer)get("plp_nr_ano_ref")).intValue();
//    return get("plp_nr_ano_ref");
  }

  public void setPlp_nr_ano_ref(int plp_nr_ano_ref) {
    set("plp_nr_ano_ref", plp_nr_ano_ref);
  }

  public int getPlp_nr_mes() {
    return  ((Integer)get("plp_nr_mes")).intValue();
//    return get("plp_nr_mes");
  }

  public void setPlp_nr_mes(int plp_nr_mes) {
    set("plp_nr_mes", plp_nr_mes);
  }

  public int getPlp_nr_ano() {
    return  ((Integer)get("plp_nr_ano")).intValue();
//    return get("plp_nr_ano");
  }

  public void setPlp_nr_ano(int plp_nr_ano) {
    set("plp_nr_ano", plp_nr_ano);
  }

  public int getPlp_nr_previsto() {
    return  ((Integer)get("plp_nr_previsto")).intValue();
//    return get("plp_nr_previsto");
  }

  public void setPlp_nr_previsto(int plp_nr_previsto) {
    set("plp_nr_previsto", plp_nr_previsto);
  }

  public int getPlp_nr_realizado() {
    return  ((Integer)get("plp_nr_realizado")).intValue();
//    return get("plp_nr_realizado");
  }

  public void setPlp_nr_realizado(int plp_nr_realizado) {
    set("plp_nr_realizado", plp_nr_realizado);
  }

  public String getDesc() {
    return  get("desc");
//    return get("flr_tx_key");
  }

  public void setDesc(String desc) {
    set("desc", desc);
  }

}

