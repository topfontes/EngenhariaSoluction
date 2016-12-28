
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
public class Plv_planilha_vendasTGWT extends BaseModel{
  public Plv_planilha_vendasTGWT() {
  }

  public int getPlv_nr_id() {
    return  ((Integer)get("plv_nr_id")).intValue();
//    return get("plv_nr_id");
  }

  public void setPlv_nr_id(int plv_nr_id) {
    set("plv_nr_id", plv_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getPlv_nr_mes_ref() {
    return  ((Integer)get("plv_nr_mes_ref")).intValue();
//    return get("plv_nr_mes_ref");
  }

  public void setPlv_nr_mes_ref(int plv_nr_mes_ref) {
    set("plv_nr_mes_ref", plv_nr_mes_ref);
  }

  public int getPlv_nr_ano_ref() {
    return  ((Integer)get("plv_nr_ano_ref")).intValue();
//    return get("plv_nr_ano_ref");
  }

  public void setPlv_nr_ano_ref(int plv_nr_ano_ref) {
    set("plv_nr_ano_ref", plv_nr_ano_ref);
  }

  public int getPlv_nr_mes() {
    return  ((Integer)get("plv_nr_mes")).intValue();
//    return get("plv_nr_mes");
  }

  public void setPlv_nr_mes(int plv_nr_mes) {
    set("plv_nr_mes", plv_nr_mes);
  }

  public int getPlv_nr_ano() {
    return  ((Integer)get("plv_nr_ano")).intValue();
//    return get("plv_nr_ano");
  }

  public void setPlv_nr_ano(int plv_nr_ano) {
    set("plv_nr_ano", plv_nr_ano);
  }

  public int getPlv_nr_previsto() {
    return  ((Integer)get("plv_nr_previsto")).intValue();
//    return get("plv_nr_previsto");
  }

  public void setPlv_nr_previsto(int plv_nr_previsto) {
    set("plv_nr_previsto", plv_nr_previsto);
  }

  public int getPlv_nr_realizado() {
    return  ((Integer)get("plv_nr_realizado")).intValue();
//    return get("plv_nr_realizado");
  }

  public void setPlv_nr_realizado(int plv_nr_realizado) {
    set("plv_nr_realizado", plv_nr_realizado);
  }

  public String getDesc() {
    return  get("desc");
//    return get("flr_tx_key");
  }

  public void setDesc(String desc) {
    set("desc", desc);
  }

}

