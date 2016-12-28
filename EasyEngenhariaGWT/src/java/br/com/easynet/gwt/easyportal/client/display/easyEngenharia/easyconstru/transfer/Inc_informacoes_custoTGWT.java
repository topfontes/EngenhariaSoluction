
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
public class Inc_informacoes_custoTGWT extends BaseModel{
  public Inc_informacoes_custoTGWT() {
  }

  public int getInc_nr_id() {
    return  ((Integer)get("inc_nr_id")).intValue();
//    return get("inc_nr_id");
  }

  public void setInc_nr_id(int inc_nr_id) {
    set("inc_nr_id", inc_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getInc_nr_mes() {
    return  ((Integer)get("inc_nr_mes")).intValue();
//    return get("inc_nes_nr_id");
  }

  public void setInc_nr_mes(int inc_nr_mes) {
    set("inc_nr_mes", inc_nr_mes);
  }

  public int getInc_nr_ano() {
    return  ((Integer)get("inc_nr_ano")).intValue();
//    return get("inc_nr_ano");
  }

  public void setInc_nr_ano(int inc_nr_ano) {
    set("inc_nr_ano", inc_nr_ano);
  }

  public int getPlc_nr_id() {
    return  ((Integer)get("plc_nr_id")).intValue();
//    return get("plc_nr_id");
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set("plc_nr_id", plc_nr_id);
  }

  public float getInc_tx_custo_acumulado() {
    return  ((Float)get("inc_tx_custo_acumulado")).floatValue();
//    return get("inc_tx_custo_acumulado");
  }

  public void setInc_tx_custo_acumulado(float inc_tx_custo_acumulado) {
    set("inc_tx_custo_acumulado", inc_tx_custo_acumulado);
  }

  public float getInc_nr_custo_periodo() {
    return  ((Float)get("inc_nr_custo_periodo")).floatValue();
//    return get("inc_nr_custo_periodo");
  }

  public void setInc_nr_custo_periodo(float inc_nr_custo_periodo) {
    set("inc_nr_custo_periodo", inc_nr_custo_periodo);
  }

  public String getInc_tx_calsas() {
    return  get("inc_tx_calsas");
//    return get("inc_tx_calsas");
  }

  public void setInc_tx_calsas(String inc_tx_calsas) {
    set("inc_tx_calsas", inc_tx_calsas);
  }

  public String getInc_tx_problemas() {
    return  get("inc_tx_problemas");
//    return get("inc_tx_problemas");
  }

  public void setInc_tx_problemas(String inc_tx_problemas) {
    set("inc_tx_problemas", inc_tx_problemas);
  }

  public String getInc_tx_acoes() {
    return  get("inc_tx_acoes");
//    return get("inc_tx_acoes");
  }

  public void setInc_tx_acoes(String inc_tx_acoes) {
    set("inc_tx_acoes", inc_tx_acoes);
  }

  public String getInc_tx_responsavel() {
    return  get("inc_tx_responsavel");
//    return get("inc_tx_responsavel");
  }

  public void setInc_tx_responsavel(String inc_tx_responsavel) {
    set("inc_tx_responsavel", inc_tx_responsavel);
  }

  public java.util.Date getInc_dt_prazo() {
    return  (Date)get("inc_dt_prazo");
//    return get("inc_dt_prazo");
  }

  public void setInc_dt_prazo(java.util.Date inc_dt_prazo) {
    set("inc_dt_prazo", inc_dt_prazo);
  }



}

