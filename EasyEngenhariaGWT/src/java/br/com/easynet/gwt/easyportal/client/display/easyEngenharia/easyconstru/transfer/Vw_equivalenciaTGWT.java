
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
public class Vw_equivalenciaTGWT extends BaseModel{
  public Vw_equivalenciaTGWT() {
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

  public String getPlco_tx_tipo() {
    return  get("plco_tx_tipo");
//    return get("plco_tx_tipo");
  }

  public void setPlco_tx_tipo(String plco_tx_tipo) {
    set("plco_tx_tipo", plco_tx_tipo);
  }

  public String getPlco_tx_cod_externo() {
    return  get("plco_tx_cod_externo");
//    return get("plco_tx_cod_externo");
  }

  public void setPlco_tx_cod_externo(String plco_tx_cod_externo) {
    set("plco_tx_cod_externo", plco_tx_cod_externo);
  }

  public String getPlco_tx_unidade() {
    return  get("plco_tx_unidade");
//    return get("plco_tx_unidade");
  }

  public void setPlco_tx_unidade(String plco_tx_unidade) {
    set("plco_tx_unidade", plco_tx_unidade);
  }



}

