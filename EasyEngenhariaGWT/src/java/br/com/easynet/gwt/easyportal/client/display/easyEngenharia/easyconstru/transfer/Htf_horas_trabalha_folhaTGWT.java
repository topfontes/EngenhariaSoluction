
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
public class Htf_horas_trabalha_folhaTGWT extends BaseModel{
  public Htf_horas_trabalha_folhaTGWT() {
  }

  public int getHtf_nr_id() {
    return  ((Integer)get("htf_nr_id")).intValue();
//    return get("htf_nr_id");
  }

  public void setHtf_nr_id(int htf_nr_id) {
    set("htf_nr_id", htf_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getHtf_nr_mes() {
    return  ((Integer)get("htf_nr_mes")).intValue();
//    return get("htf_nr_mes");
  }

  public void setHtf_nr_mes(int htf_nr_mes) {
    set("htf_nr_mes", htf_nr_mes);
  }

  public int getHtf_nr_ano() {
    return  ((Integer)get("htf_nr_ano")).intValue();
//    return get("htf_nr_ano");
  }

  public void setHtf_nr_ano(int htf_nr_ano) {
    set("htf_nr_ano", htf_nr_ano);
  }

  public float getHtf_nr_horas_trabalhada() {
    return  ((Float)get("htf_nr_horas_trabalhada")).floatValue();
//    return get("htf_nr_horas_trabalhada");
  }

  public void setHtf_nr_horas_trabalhada(float htf_nr_horas_trabalhada) {
    set("htf_nr_horas_trabalhada", htf_nr_horas_trabalhada);
  }



}

