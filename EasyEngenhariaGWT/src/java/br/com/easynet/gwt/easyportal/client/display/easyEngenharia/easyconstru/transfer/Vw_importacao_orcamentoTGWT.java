
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
public class Vw_importacao_orcamentoTGWT extends BaseModel{
  public Vw_importacao_orcamentoTGWT() {
  }

  public String getPlco_tx_nome() {
    return  get("plco_tx_nome");
//    return get("plco_tx_nome");
  }

  public void setPlco_tx_nome(String plco_tx_nome) {
    set("plco_tx_nome", plco_tx_nome);
  }

  public String getPlco_tx_tipo() {
    return  get("plco_tx_tipo");
//    return get("plco_tx_tipo");
  }

  public void setPlco_tx_tipo(String plco_tx_tipo) {
    set("plco_tx_tipo", plco_tx_tipo);
  }

  public String getPlco_tx_unidade() {
    return  get("plco_tx_unidade");
//    return get("plco_tx_unidade");
  }

  public void setPlco_tx_unidade(String plco_tx_unidade) {
    set("plco_tx_unidade", plco_tx_unidade);
  }

  public float getIpo_nr_quantidade() {
    return  ((Float)get("ipo_nr_quantidade")).floatValue();
//    return get("ipo_nr_quantidade");
  }

  public void setIpo_nr_quantidade(float ipo_nr_quantidade) {
    set("ipo_nr_quantidade", ipo_nr_quantidade);
  }

  public float getIpo_nr_vl_unitario() {
    return  ((Float)get("ipo_nr_vl_unitario")).floatValue();
//    return get("ipo_nr_vl_unitario");
  }

  public void setIpo_nr_vl_unitario(float ipo_nr_vl_unitario) {
    set("ipo_nr_vl_unitario", ipo_nr_vl_unitario);
  }

  public float getIpo_nr_vl_total() {
    return  ((Float)get("ipo_nr_vl_total")).floatValue();
//    return get("ipo_nr_vl_total");
  }

  public void setIpo_nr_vl_total(float ipo_nr_vl_total) {
    set("ipo_nr_vl_total", ipo_nr_vl_total);
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }

  public int getIpo_plc_nr_id_servico() {
    return  ((Integer)get("ipo_plc_nr_id_servico")).intValue();
//    return get("ipo_plc_nr_id_servico");
  }

  public void setIpo_plc_nr_id_servico(int ipo_plc_nr_id_servico) {
    set("ipo_plc_nr_id_servico", ipo_plc_nr_id_servico);
  }

  public String getPlco_tx_cod_externo() {
    return  get("plco_tx_cod_externo");
//    return get("plco_tx_cod_externo");
  }

  public void setPlco_tx_cod_externo(String plco_tx_cod_externo) {
    set("plco_tx_cod_externo", plco_tx_cod_externo);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getPlco_nr_nivel() {
    return  ((Integer)get("plco_nr_nivel")).intValue();
//    return get("plco_nr_nivel");
  }

  public void setPlco_nr_nivel(int plco_nr_nivel) {
    set("plco_nr_nivel", plco_nr_nivel);
  }

  public int getIpo_nr_id() {
    return  ((Integer)get("ipo_nr_id")).intValue();

  }

  public void setIpo_nr_id(int ipo_nr_id) {
    set("ipo_nr_id", ipo_nr_id);
  }


}

