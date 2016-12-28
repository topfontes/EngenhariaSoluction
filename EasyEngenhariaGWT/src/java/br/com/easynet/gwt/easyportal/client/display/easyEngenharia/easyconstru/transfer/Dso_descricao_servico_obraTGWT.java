
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
public class Dso_descricao_servico_obraTGWT extends BaseModel{
  public Dso_descricao_servico_obraTGWT() {
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }

  public String getDso_tx_codigo_externo() {
    return  get("dso_tx_codigo_externo");
//    return get("dso_tx_codigo_externo");
  }

  public void setDso_tx_codigo_externo(String dso_tx_codigo_externo) {
    set("dso_tx_codigo_externo", dso_tx_codigo_externo);
  }

  public String getDso_tx_descriaco() {
    return  get("dso_tx_descriaco");
//    return get("dso_tx_descriaco");
  }

  public void setDso_tx_descriaco(String dso_tx_descriaco) {
    set("dso_tx_descriaco", dso_tx_descriaco);
  }

  public int getDso_nr_id() {
    return  ((Integer)get("dso_nr_id")).intValue();
//    return get("dso_nr_id");
  }

  public void setDso_nr_id(int dso_nr_id) {
    set("dso_nr_id", dso_nr_id);
  }



}

