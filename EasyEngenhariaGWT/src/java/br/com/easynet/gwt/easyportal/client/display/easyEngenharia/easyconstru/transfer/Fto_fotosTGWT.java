
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
public class Fto_fotosTGWT extends BaseModel{
  public Fto_fotosTGWT() {
  }

  public int getFto_nr_id() {
    return  ((Integer)get("fto_nr_id")).intValue();
//    return get("fto_nr_id");
  }

  public void setFto_nr_id(int fto_nr_id) {
    set("fto_nr_id", fto_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getFto_nr_mes() {
    return  ((Integer)get("fto_nr_mes")).intValue();
//    return get("fto_nr_mes");
  }

  public void setFto_nr_mes(int fto_nr_mes) {
    set("fto_nr_mes", fto_nr_mes);
  }

  public int getFto_nr_ano() {
    return  ((Integer)get("fto_nr_ano")).intValue();
//    return get("fto_nr_ano");
  }

  public void setFto_nr_ano(int fto_nr_ano) {
    set("fto_nr_ano", fto_nr_ano);
  }

  public byte[] getFto_bt_foto() {
    return null;
    
  }

  public void setFto_bt_foto(byte[] fto_bt_foto) {
    set("fto_bt_foto", fto_bt_foto);
  }

public void setFto_tx_nome(String fto_tx_nome){
    set("fto_tx_nome", fto_tx_nome);
}

public String getFto_tx_nome(){
    return get("fto_tx_nome");
}

}

