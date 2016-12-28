
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
public class Plr_planilha_recebimentoTGWT extends BaseModel{
  public Plr_planilha_recebimentoTGWT() {
  }

  public int getPlr_nr_id() {
    return  ((Integer)get("plr_nr_id")).intValue();
//    return get("plr_nr_id");
  }

  public void setPlr_nr_id(int plr_nr_id) {
    set("plr_nr_id", plr_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getPlr_nr_mes_ref() {
    return  ((Integer)get("plr_nr_mes_ref")).intValue();
//    return get("plr_nr_mes_ref");
  }

  public void setPlr_nr_mes_ref(int plr_nr_mes_ref) {
    set("plr_nr_mes_ref", plr_nr_mes_ref);
  }

  public int getPlr_nr_ano_ref() {
    return  ((Integer)get("plr_nr_ano_ref")).intValue();
//    return get("plr_nr_ano_ref");
  }

  public void setPlr_nr_ano_ref(int plr_nr_ano_ref) {
    set("plr_nr_ano_ref", plr_nr_ano_ref);
  }

  public int getPlr_nr_mes() {
    return  ((Integer)get("plr_nr_mes")).intValue();
//    return get("plr_nr_mes");
  }

  public void setPlr_nr_mes(int plr_nr_mes) {
    set("plr_nr_mes", plr_nr_mes);
  }

  public int getPlr_nr_ano() {
    return  ((Integer)get("plr_nr_ano")).intValue();
//    return get("plr_nr_ano");
  }

  public void setPlr_nr_ano(int plr_nr_ano) {
    set("plr_nr_ano", plr_nr_ano);
  }

  public double getPlr_nr_efetuado_pj() {
    return  ((Double)get("plr_nr_efetuado_pj")).floatValue();
//    return get("plr_nr_efetuado_pj");
  }

  public void setPlr_nr_efetuado_pj(double plr_nr_efetuado_pj) {
    set("plr_nr_efetuado_pj", plr_nr_efetuado_pj);
  }

  public float getPlr_nr_realizado_pf() {
    return  ((Double)get("plr_nr_realizado_pf")).floatValue();
//    return get("plr_nr_realizado_pf");
  }

  public void setPlr_nr_realizado_pf(double plr_nr_realizado_pf) {
    set("plr_nr_realizado_pf", plr_nr_realizado_pf);
  }

  public double getPlr_nr_realizado_pou() {
    return  ((Double)get("plr_nr_realizado_pou")).floatValue();
//    return get("plr_nr_realizado_pou");
  }

  public void setPlr_nr_realizado_pou(double plr_nr_realizado_pou) {
    set("plr_nr_realizado_pou", plr_nr_realizado_pou);
  }
  public String getDesc() {
    return  get("desc");
//    return get("flr_tx_key");
  }

  public void setDesc(String desc) {
    set("desc", desc);
  }


}

