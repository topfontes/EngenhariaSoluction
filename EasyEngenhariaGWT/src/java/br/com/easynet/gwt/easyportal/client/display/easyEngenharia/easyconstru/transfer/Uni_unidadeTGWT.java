
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
public class Uni_unidadeTGWT extends BaseModel{
  public Uni_unidadeTGWT() {
  }

  public int getUni_nr_id() {
    return  ((Integer)get("uni_nr_id")).intValue();
//    return get("uni_nr_id");
  }

  public void setUni_nr_id(int uni_nr_id) {
    set("uni_nr_id", uni_nr_id);
  }

  public String getUni_tx_nome() {
    return  get("uni_tx_nome");
//    return get("uni_tx_nome");
  }

  public void setUni_tx_nome(String uni_tx_nome) {
    set("uni_tx_nome", uni_tx_nome);
  }



}

