
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
public class Tet_tmp_equivalencia_treetTGWT extends BaseModel{
  public Tet_tmp_equivalencia_treetTGWT() {
  }

  public int getTet_nr_id() {
    return  ((Integer)get("tet_nr_id")).intValue();
//    return get("tet_nr_id");
  }

  public void setTet_nr_id(int tet_nr_id) {
    set("tet_nr_id", tet_nr_id);
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }

  public int getPlc_nr_id() {
    return  ((Integer)get("plc_nr_id")).intValue();
//    return get("plc_nr_id");
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set("plc_nr_id", plc_nr_id);
  }

  public String getPlco_tx_nome() {
    return  get("plco_tx_nome");
//    return get("plco_tx_nome");
  }

  public void setPlco_tx_nome(String plco_tx_nome) {
    set("plco_tx_nome", plco_tx_nome);
  }

  public String getPlc_tx_nome() {
    return  get("plc_tx_nome");
//    return get("plc_tx_nome");
  }

  public void setPlc_tx_nome(String plc_tx_nome) {
    set("plc_tx_nome", plc_tx_nome);
  }



}

