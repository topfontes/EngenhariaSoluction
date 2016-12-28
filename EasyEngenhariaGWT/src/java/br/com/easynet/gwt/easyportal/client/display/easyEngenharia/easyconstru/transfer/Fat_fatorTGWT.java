
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
public class Fat_fatorTGWT extends BaseModel{
  public Fat_fatorTGWT() {
  }

  public int getFat_nr_id() {
    return  ((Integer)get("fat_nr_id")).intValue();
//    return get("fat_nr_id");
  }

  public void setFat_nr_id(int fat_nr_id) {
    set("fat_nr_id", fat_nr_id);
  }

  public int getPlc_nr_id() {
    return  ((Integer)get("plc_nr_id")).intValue();
//    return get("plc_nr_id");
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set("plc_nr_id", plc_nr_id);
  }

  public float getFat_nr_fator_atual() {
    return  ((Float)get("fat_nr_fator_atual")).floatValue();
//    return get("fat_nr_fator_atual");
  }

  public void setFat_nr_fator_atual(float fat_nr_fator_atual) {
    set("fat_nr_fator_atual", fat_nr_fator_atual);
  }

  public float getFat_nr_fator_projetado() {
    return  ((Float)get("fat_nr_fator_projetado")).floatValue();
//    return get("fat_nr_fator_projetado");
  }

  public void setFat_nr_fator_projetado(float fat_nr_fator_projetado) {
    set("fat_nr_fator_projetado", fat_nr_fator_projetado);
  }

  public int getFat_nr_mes() {
    return  ((Integer)get("fat_nr_mes")).intValue();
//    return get("fat_nr_mes");
  }

  public void setFat_nr_mes(int fat_nr_mes) {
    set("fat_nr_mes", fat_nr_mes);
  }

  public int getFat_nr_ano() {
    return  ((Integer)get("fat_nr_ano")).intValue();
//    return get("fat_nr_ano");
  }

  public void setFat_nr_ano(int fat_nr_ano) {
    set("fat_nr_ano", fat_nr_ano);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }



}

