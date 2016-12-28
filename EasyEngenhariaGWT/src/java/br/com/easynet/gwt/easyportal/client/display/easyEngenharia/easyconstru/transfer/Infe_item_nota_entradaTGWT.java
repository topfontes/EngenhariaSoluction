
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
public class Infe_item_nota_entradaTGWT extends BaseModel{
  public Infe_item_nota_entradaTGWT() {
  }

  public int getInfe_nr_id() {
    return  ((Integer)get("infe_nr_id")).intValue();
//    return get("infe_nr_id");
  }

  public void setInfe_nr_id(int infe_nr_id) {
    set("infe_nr_id", infe_nr_id);
  }

  public float getInfe_nr_quantidade() {
    return  ((Float)get("infe_nr_quantidade")).floatValue();
//    return get("infe_nr_quantidade");
  }

  public void setInfe_nr_quantidade(float infe_nr_quantidade) {
    set("infe_nr_quantidade", infe_nr_quantidade);
  }

  public float getInfe_nr_valor_unit() {
    return  ((Float)get("infe_nr_valor_unit")).floatValue();
//    return get("infe_nr_valor_unit");
  }

  public void setInfe_nr_valor_unit(float infe_nr_valor_unit) {
    set("infe_nr_valor_unit", infe_nr_valor_unit);
  }

  public float getInfe_nr_valor_total() {
    return  ((Float)get("infe_nr_valor_total")).floatValue();
//    return get("infe_nr_valor_total");
  }

  public void setInfe_nr_valor_total(float infe_nr_valor_total) {
    set("infe_nr_valor_total", infe_nr_valor_total);
  }

  public int getNfe_nr_id() {
    return  ((Integer)get("nfe_nr_id")).intValue();
//    return get("nfe_nr_id");
  }

  public void setNfe_nr_id(int nfe_nr_id) {
    set("nfe_nr_id", nfe_nr_id);
  }

  public int getPro_nr_id() {
    return  ((Integer)get("pro_nr_id")).intValue();
//    return get("pro_nr_id");
  }

  public void setPro_nr_id(int pro_nr_id) {
    set("pro_nr_id", pro_nr_id);
  }



}

