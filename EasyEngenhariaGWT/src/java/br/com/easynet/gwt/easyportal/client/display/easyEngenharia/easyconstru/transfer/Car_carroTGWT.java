
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
public class Car_carroTGWT extends BaseModel{
  public Car_carroTGWT() {
  }

  public int getCar_nr_id() {
    return  ((Integer)get("car_nr_id")).intValue();
//    return get("car_nr_id");
  }

  public void setCar_nr_id(int car_nr_id) {
    set("car_nr_id", car_nr_id);
  }

  public String getCar_tx_nome() {
    return  get("car_tx_nome");
//    return get("car_tx_nome");
  }

  public void setCar_tx_nome(String car_tx_nome) {
    set("car_tx_nome", car_tx_nome);
  }

  public String getCar_tx_marca() {
    return  get("car_tx_marca");
//    return get("car_tx_marca");
  }

  public void setCar_tx_marca(String car_tx_marca) {
    set("car_tx_marca", car_tx_marca);
  }



}

