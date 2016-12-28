
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
public class Uno_unidade_obraTGWT extends BaseModel{
  public Uno_unidade_obraTGWT() {
  }

  public int getUno_nr_id() {
    return  ((Integer)get("uno_nr_id")).intValue();
//    return get("uno_nr_id");
  }

  public void setUno_nr_id(int uno_nr_id) {
    set("uno_nr_id", uno_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getUni_nr_id() {
    return ((Integer) get("uni_nr_id")).intValue();
//    return get("uno_tx_nome");
  }

  public void setUni_nr_id(int uni_nr_id) {
    set("uni_nr_id", uni_nr_id);
  }

  public int getUno_nr_quantidade() {
    return  ((Integer)get("uno_nr_quantidade")).intValue();
  }

  public void setUno_nr_quantidade(int uno_nr_quantidade) {
    set("uno_nr_quantidade", uno_nr_quantidade);
  }

  public float getUno_nr_area_construida() {
    return  ((Float)get("uno_nr_area_construida")).floatValue();
//    return get("uno_nr_area_construida");
  }

  public void setUno_nr_area_construida(float uno_nr_area_construida) {
    set("uno_nr_area_construida", uno_nr_area_construida);
  }

  public String getUni_tx_nome() {
    return get("uni_tx_nome");
  }

  public void setUni_tx_nome(String uni_tx_nome) {
    set("uni_tx_nome", uni_tx_nome);
  }
  public String getObr_tx_nome() {
    return get("obr_tx_nome");
  }
 
  public void setObr_tx_nome(String obr_tx_nome) {
    set("obr_tx_nome", obr_tx_nome);
  }
}

