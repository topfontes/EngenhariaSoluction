
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
public class Vw_insumo_plc_pmsTGWT extends BaseModel{
  public Vw_insumo_plc_pmsTGWT() {
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getPlc_nr_id_super() {
    return  ((Integer)get("plc_nr_id_super")).intValue();
//    return get("plc_nr_id_super");
  }

  public void setPlc_nr_id_super(int plc_nr_id_super) {
    set("plc_nr_id_super", plc_nr_id_super);
  }

  public String getPlc_tx_nome_super() {
    return  get("plc_tx_nome_super");
//    return get("plc_tx_nome_super");
  }

  public void setPlc_tx_nome_super(String plc_tx_nome_super) {
    set("plc_tx_nome_super", plc_tx_nome_super);
  }

  public String getUnd() {
    return  get("und");
//    return get("plc_tx_nome_super");
  }

  public void setUnd(String und) {
    set("und", und);
  }


  public int getPlc_nr_id() {
    return  ((Integer)get("plc_nr_id")).intValue();
//    return get("plc_nr_id");
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set("plc_nr_id", plc_nr_id);
  }

  public String getPlc_tx_nome() {
    return  get("plc_tx_nome");
//    return get("plc_tx_nome");
  }

  public void setPlc_tx_nome(String plc_tx_nome) {
    set("plc_tx_nome", plc_tx_nome);
  }

  public float getIpo_nr_vl_unitario() {
    return  ((Float)get("ipo_nr_vl_unitario")).floatValue();
//    return get("ipo_nr_vl_unitario");
  }

  public void setIpo_nr_vl_unitario(float ipo_nr_vl_unitario) {
    set("ipo_nr_vl_unitario", ipo_nr_vl_unitario);
  }

  public int getPms_nr_mes() {
    return  ((Integer)get("pms_nr_mes")).intValue();
//    return get("pms_nr_mes");
  }

  public void setPms_nr_mes(int pms_nr_mes) {
    set("pms_nr_mes", pms_nr_mes);
  }

  public int getPms_nr_ano() {
    return  ((Integer)get("pms_nr_ano")).intValue();
//    return get("pms_nr_ano");
  }

  public void setPms_nr_ano(int pms_nr_ano) {
    set("pms_nr_ano", pms_nr_ano);
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }

  public float getPerc() {
    return  ((Float)get("perc")).floatValue();
//    return get("perc");
  }

  public void setPerc(float perc) {
    set("perc", perc);
  }

  public float getVl_total() {
    return  ((Float)get("vl_total")).floatValue();
//    return get("vl_total");
  }

  public void setVl_total(float vl_total) {
    set("vl_total", vl_total);
  }
 
  public float getVl_executado() {
    return  ((Float)get("vl_executado")).floatValue();
//    return get("vl_executado");
  }

  public void setVl_executado(float vl_executado) {
    set("vl_executado", vl_executado);
  }

  public float getQuantidade() {
    return  ((Float)get("quantidade")).floatValue();
//    return get("vl_executado");
  }

  public void setQuantidade(float quantidade) {
    set("quantidade", quantidade);
  }


}

