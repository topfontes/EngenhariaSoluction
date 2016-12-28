
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
public class Cffo_cronograma_fisico_financeiro_origenalTGWT extends BaseModel{
  public Cffo_cronograma_fisico_financeiro_origenalTGWT() {
  }

  public int getCffo_nr_id() {
    return  ((Integer)get("cffo_nr_id")).intValue();
//    return get("cffo_nr_id");
  }

  public void setCffo_nr_id(int cffo_nr_id) {
    set("cffo_nr_id", cffo_nr_id);
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public float getCffo_nr_peso() {
    return  ((Float)get("cffo_nr_peso")).floatValue();
//    return get("cffo_nr_peso");
  }

  public void setCffo_nr_peso(float cffo_nr_peso) {
    set("cffo_nr_peso", cffo_nr_peso);
  }

  public int getCffo_nr_mes() {
    return  ((Integer)get("cffo_nr_mes")).intValue();
//    return get("cffo_nr_mes");
  }

  public void setCffo_nr_mes(int cffo_nr_mes) {
    set("cffo_nr_mes", cffo_nr_mes);
  }

  public int getCffo_nr_ano() {
    return  ((Integer)get("cffo_nr_ano")).intValue();
//    return get("cffo_nr_ano");
  }

  public void setCffo_nr_ano(int cffo_nr_ano) {
    set("cffo_nr_ano", cffo_nr_ano);
  }

  public int getIpo_nr_id_super() {
    return  ((Integer)get("ipo_nr_id_super")).intValue();
//    return get("ccff_nr_ano");
  }

  public void setIpo_nr_id_super(int ipo_nr_id_super) {
    set("ipo_nr_id_super", ipo_nr_id_super);
  }
  public int getIpo_nr_id() {
    return  ((Integer)get("ipo_nr_id")).intValue();
//    return get("ccff_nr_ano");
  }

  public void setIpo_nr_id(int ipo_nr_id) {
    set("ipo_nr_id", ipo_nr_id);
  }

}

