
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
public class Eqi_equivalencia_insumoTGWT extends BaseModel{
  public Eqi_equivalencia_insumoTGWT() {
  }

  public int getIna_nr_id() {
    return  ((Integer)get("ina_nr_id")).intValue();
//    return get("ina_nr_id");
  }

  public void setIna_nr_id(int ina_nr_id) {
    set("ina_nr_id", ina_nr_id);
  }

  public int getInn_nr_id() {
    return  ((Integer)get("inn_nr_id")).intValue();
//    return get("inn_nr_id");
  }

  public void setInn_nr_id(int inn_nr_id) {
    set("inn_nr_id", inn_nr_id);
  }



}

