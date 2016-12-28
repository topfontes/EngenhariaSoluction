
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
public class Vw_curva_abcTGWT extends BaseModel{
  public Vw_curva_abcTGWT() {
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public String getObr_tx_nome() {
    return  get("obr_tx_nome");
//    return get("obr_tx_nome");
  }

  public void setObr_tx_nome(String obr_tx_nome) {
    set("obr_tx_nome", obr_tx_nome);
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }

  public String getPlco_tx_nome() {
    return  get("plco_tx_nome");
//    return get("plco_tx_nome");
  }

  public void setPlco_tx_nome(String plco_tx_nome) {
    set("plco_tx_nome", plco_tx_nome);
  }

  public float getTotal() {
    return  ((Float)get("total")).floatValue();
//    return get("total");
  }

  public void setTotal(float total) {
    set("total", total);
  }



}

