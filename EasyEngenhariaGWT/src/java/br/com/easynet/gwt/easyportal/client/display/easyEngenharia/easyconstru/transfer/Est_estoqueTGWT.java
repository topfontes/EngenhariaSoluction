
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
public class Est_estoqueTGWT extends BaseModel{
  public Est_estoqueTGWT() {
  }

  public int getEst_nr_id() {
    return  ((Integer)get("est_nr_id")).intValue();
//    return get("est_nr_id");
  }

  public void setEst_nr_id(int est_nr_id) {
    set("est_nr_id", est_nr_id);
  }

  public int getEst_nr_mes() {
    return  ((Integer)get("est_nr_mes")).intValue();
//    return get("est_nr_mes");
  }

  public void setEst_nr_mes(int est_nr_mes) {
    set("est_nr_mes", est_nr_mes);
  }

  public int getPlc_nr_id() {
    return  ((Integer)get("plc_nr_id")).intValue();
//    return get("plc_nr_id");
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set("plc_nr_id", plc_nr_id);
  }

  public float getEst_nr_quantidade() {
    return  ((Float)get("est_nr_quantidade")).floatValue();
//    return get("est_nr_quantidade");
  }

  public void setEst_nr_quantidade(float est_nr_quantidade) {
    set("est_nr_quantidade", est_nr_quantidade);
  }

  public float getEst_nr_vl_unitario() {
    return  ((Float)get("est_nr_vl_unitario")).floatValue();
//    return get("est_nr_vl_unitario");
  }

  public void setEst_nr_vl_unitario(float est_nr_vl_unitario) {
    set("est_nr_vl_unitario", est_nr_vl_unitario);
  }

  public float getEst_nr_vl_total() {
    return  ((Float)get("est_nr_vl_total")).floatValue();
//    return get("est_nr_vl_total");
  }

  public void setEst_nr_vl_total(float est_nr_vl_total) {
    set("est_nr_vl_total", est_nr_vl_total);
  }


  public String getPlc_tx_nome() {
    return  get("plc_tx_nome");
//    return get("est_tx_unidade");
  }

  public void setPlc_tx_nome(String plc_tx_nome) {
    set("plc_tx_nome", plc_tx_nome);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }


  public int getEst_nr_ano() {
    return  ((Integer)get("est_nr_ano")).intValue();
  }

  public void setEst_nr_ano(int est_nr_ano) {
    set("est_nr_ano", est_nr_ano);
  }
  public String getEst_tx_unidade() {
    return  get("est_tx_unidade");
//    return get("est_tx_unidade");
  }

  public void setEst_tx_unidade(String est_tx_unidade) {
    set("est_tx_unidade", est_tx_unidade);
  }

  public String getEst_tx_nome() {
    return  get("est_tx_nome");
  }

  public void setEst_tx_nome(String est_tx_nome) {
    set("est_tx_nome", est_tx_nome);
  }


}

