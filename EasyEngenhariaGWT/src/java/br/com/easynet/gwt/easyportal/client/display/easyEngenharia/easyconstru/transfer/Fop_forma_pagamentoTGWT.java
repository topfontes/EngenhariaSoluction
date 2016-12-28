
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
public class Fop_forma_pagamentoTGWT extends BaseModel{
  public Fop_forma_pagamentoTGWT() {
  }

  public int getFop_nr_id() {
    return  ((Integer)get("fop_nr_id")).intValue();
//    return get("fop_nr_id");
  }

  public void setFop_nr_id(int fop_nr_id) {
    set("fop_nr_id", fop_nr_id);
  }

  public String getFop_tx_nome() {
    return  get("fop_tx_nome");
//    return get("fop_tx_nome");
  }

  public void setFop_tx_nome(String fop_tx_nome) {
    set("fop_tx_nome", fop_tx_nome);
  }

  public String getFop_tx_avista() {
    return  get("fop_tx_avista");
//    return get("fop_tx_avista");
  }

  public void setFop_tx_avista(String fop_tx_avista) {
    set("fop_tx_avista", fop_tx_avista);
  }



}

