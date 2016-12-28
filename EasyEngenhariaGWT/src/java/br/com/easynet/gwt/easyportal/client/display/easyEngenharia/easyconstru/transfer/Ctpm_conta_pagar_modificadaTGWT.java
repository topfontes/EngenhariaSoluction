
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
public class Ctpm_conta_pagar_modificadaTGWT extends BaseModel{
  public Ctpm_conta_pagar_modificadaTGWT() {
  }

  public int getCtpm_nr_id() {
    return  ((Integer)get("ctpm_nr_id")).intValue();
//    return get("ctpm_nr_id");
  }

  public void setCtpm_nr_id(int ctpm_nr_id) {
    set("ctpm_nr_id", ctpm_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getCtp_nr_id() {
    return  ((Integer)get("ctp_nr_id")).intValue();
//    return get("ctp_nr_id");
  }

  public void setCtp_nr_id(int ctp_nr_id) {
    set("ctp_nr_id", ctp_nr_id);
  }

  public int getCtpm_nr_mes() {
    return  ((Integer)get("ctpm_nr_mes")).intValue();
//    return get("ctpm_nr_mes");
  }

  public void setCtpm_nr_mes(int ctpm_nr_mes) {
    set("ctpm_nr_mes", ctpm_nr_mes);
  }

  public int getCtpm_nr_ano() {
    return  ((Integer)get("ctpm_nr_ano")).intValue();
//    return get("ctpm_nr_ano");
  }

  public void setCtpm_nr_ano(int ctpm_nr_ano) {
    set("ctpm_nr_ano", ctpm_nr_ano);
  }

  public String getCtpm_tx_tipo() {
    return  get("ctpm_tx_tipo");
//    return get("ctpm_tx_tipo");
  }

  public void setCtpm_tx_tipo(String ctpm_tx_tipo) {
    set("ctpm_tx_tipo", ctpm_tx_tipo);
  }



}

