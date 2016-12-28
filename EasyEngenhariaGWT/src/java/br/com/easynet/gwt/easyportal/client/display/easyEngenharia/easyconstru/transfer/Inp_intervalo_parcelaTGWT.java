
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
public class Inp_intervalo_parcelaTGWT extends BaseModel{
  public Inp_intervalo_parcelaTGWT() {
  }

  public int getInp_nr_id() {
    return  ((Integer)get("inp_nr_id")).intValue();
//    return get("inp_nr_id");
  }

  public void setInp_nr_id(int inp_nr_id) {
    set("inp_nr_id", inp_nr_id);
  }

  public int getPar_nr_id() {
    return  ((Integer)get("par_nr_id")).intValue();
//    return get("par_nr_id");
  }

  public void setPar_nr_id(int par_nr_id) {
    set("par_nr_id", par_nr_id);
  }

  public int getInp_nr_dias() {
    return  ((Integer)get("inp_nr_dias")).intValue();
//    return get("inp_nr_dias");
  }

  public void setInp_nr_dias(int inp_nr_dias) {
    set("inp_nr_dias", inp_nr_dias);
  }

  public float getInp_nr_per() {
    return  ((Float)get("inp_nr_per")).floatValue();
//    return get("inp_nr_per");
  }

  public void setInp_nr_per(float inp_nr_per) {
    set("inp_nr_per", inp_nr_per);
  }
  public float getInp_nr_sequencia() {
    return  ((Float)get("inp_nr_sequencia")).floatValue();
//    return get("inp_nr_per");
  }

  public void setInp_nr_sequencia(float inp_nr_sequencia) {
    set("inp_nr_sequencia", inp_nr_sequencia);
  }



}

