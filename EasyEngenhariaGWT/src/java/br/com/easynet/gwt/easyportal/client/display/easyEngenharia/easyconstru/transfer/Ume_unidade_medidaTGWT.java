
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
public class Ume_unidade_medidaTGWT extends BaseModel{
  public Ume_unidade_medidaTGWT() {
  }

  public int getUme_nr_id() {
    return  ((Integer)get("ume_nr_id")).intValue();
//    return get("ume_nr_id");
  }

  public void setUme_nr_id(int ume_nr_id) {
    set("ume_nr_id", ume_nr_id);
  }

  public String getUme_tx_nome() {
    return  get("ume_tx_nome");
//    return get("ume_tx_nome");
  }

  public void setUme_tx_nome(String ume_tx_nome) {
    set("ume_tx_nome", ume_tx_nome);
  }



}

