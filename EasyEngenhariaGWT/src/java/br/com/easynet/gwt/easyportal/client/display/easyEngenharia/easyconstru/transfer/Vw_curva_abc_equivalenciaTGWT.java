
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
public class Vw_curva_abc_equivalenciaTGWT extends BaseModel{
  public Vw_curva_abc_equivalenciaTGWT() {
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getPlc_nr_id() {
    return  ((Integer)get("plc_nr_id")).intValue();
//    return get("plc_nr_id");
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set("plc_nr_id", plc_nr_id);
  }

  public String getPlc_tx_nome() {
    return  get("plc_tx_nome");
//    return get("plc_tx_nome");
  }

  public void setPlc_tx_nome(String plc_tx_nome) {
    set("plc_tx_nome", plc_tx_nome);
  }

  public float getTotal() {
    return  ((Float)get("total")).floatValue();
//    return get("total");
  }

  public void setTotal(float total) {
    set("total", total);
  }



}

