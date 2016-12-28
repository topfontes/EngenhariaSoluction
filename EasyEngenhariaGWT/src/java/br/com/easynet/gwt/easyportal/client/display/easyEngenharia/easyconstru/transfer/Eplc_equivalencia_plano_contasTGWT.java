
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
public class Eplc_equivalencia_plano_contasTGWT extends BaseModel{
  public Eplc_equivalencia_plano_contasTGWT() {
  }

  public int getEplc_nr_id() {
    return  ((Integer)get("eplc_nr_id")).intValue();
//    return get("eplc_nr_id");
  }

  public void setEplc_nr_id(int eplc_nr_id) {
    set("eplc_nr_id", eplc_nr_id);
  }

  public int getPlc_nr_id() {
    return  ((Integer)get("plc_nr_id")).intValue();
//    return get("plc_nr_id");
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set("plc_nr_id", plc_nr_id);
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }



}

