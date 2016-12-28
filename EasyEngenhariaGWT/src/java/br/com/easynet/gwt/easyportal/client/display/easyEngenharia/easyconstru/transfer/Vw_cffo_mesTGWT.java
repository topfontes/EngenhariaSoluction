
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
public class Vw_cffo_mesTGWT extends BaseModel{
  public Vw_cffo_mesTGWT() {
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
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

  public float getTotal() {
    return  ((Float)get("total")).floatValue();
//    return get("total");
  }

  public void setTotal(float total) {
    set("total", total);
  }

  public void setKey(String key){
      set("key",key);
  }

  public String getKey(){
      return get("key");
  }

}

