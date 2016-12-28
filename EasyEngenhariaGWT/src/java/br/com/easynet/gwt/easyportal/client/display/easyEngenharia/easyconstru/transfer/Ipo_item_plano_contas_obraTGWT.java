
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
public class Ipo_item_plano_contas_obraTGWT extends BaseModel{
  public Ipo_item_plano_contas_obraTGWT() {
  }

  public int getIpo_nr_id() {
    return  ((Integer)get("ipo_nr_id")).intValue();
//    return get("ipo_nr_id");
  }

  public void setIpo_nr_id(int ipo_nr_id) {
    set("ipo_nr_id", ipo_nr_id);
  }

  public float getIpo_nr_quantidade() {
    return  ((Float)get("ipo_nr_quantidade")).floatValue();
//    return get("ipo_nr_quantidade");
  }

  public void setIpo_nr_quantidade(float ipo_nr_quantidade) {
    set("ipo_nr_quantidade", ipo_nr_quantidade);
  }

  public float getIpo_nr_vl_unitario() {
    return  ((Float)get("ipo_nr_vl_unitario")).floatValue();
//    return get("ipo_nr_vl_unitario");
  }

  public void setIpo_nr_vl_unitario(float ipo_nr_vl_unitario) {
    set("ipo_nr_vl_unitario", ipo_nr_vl_unitario);
  }

  public float getIpo_nr_vl_total() {
    return  ((Float)get("ipo_nr_vl_total")).floatValue();
//    return get("ipo_nr_vl_total");
  }

  public void setIpo_nr_vl_total(float ipo_nr_vl_total) {
    set("ipo_nr_vl_total", ipo_nr_vl_total);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }



}

