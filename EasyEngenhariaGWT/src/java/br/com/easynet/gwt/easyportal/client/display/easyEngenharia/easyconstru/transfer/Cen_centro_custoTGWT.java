
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
public class Cen_centro_custoTGWT extends BaseModel{
  public Cen_centro_custoTGWT() {
  }

  public int getCen_nr_id() {
    return  ((Integer)get("cen_nr_id")).intValue();
//    return get("cen_nr_id");
  }

  public void setCen_nr_id(int cen_nr_id) {
    set("cen_nr_id", cen_nr_id);
  }

  public String getCen_tx_nome() {
    return  get("cen_tx_nome");
//    return get("cen_tx_nome");
  }

  public void setCen_tx_nome(String cen_tx_nome) {
    set("cen_tx_nome", cen_tx_nome);
  }



}

