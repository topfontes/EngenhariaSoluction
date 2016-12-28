
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
public class Vw_conta_pagar_alteradaTGWT extends BaseModel{
  public Vw_conta_pagar_alteradaTGWT() {
  }

  public int getCtp_nr_id() {
    return  ((Integer)get("ctp_nr_id")).intValue();
//    return get("ctp_nr_id");
  }

  public void setCtp_nr_id(int ctp_nr_id) {
    set("ctp_nr_id", ctp_nr_id);
  }

  public int getCtp_nr_mes() {
    return  ((Integer)get("ctp_nr_mes")).intValue();
//    return get("ctp_nr_mes");
  }

  public void setCtp_nr_mes(int ctp_nr_mes) {
    set("ctp_nr_mes", ctp_nr_mes);
  }

  public int getCtp_nr_ano() {
    return  ((Integer)get("ctp_nr_ano")).intValue();
//    return get("ctp_nr_ano");
  }

  public void setCtp_nr_ano(int ctp_nr_ano) {
    set("ctp_nr_ano", ctp_nr_ano);
  }

  public String getCtp_nr_documento() {
    return  get("ctp_nr_documento");
//    return get("ctp_nr_documento");
  }

  public void setCtp_nr_documento(String ctp_nr_documento) {
    set("ctp_nr_documento", ctp_nr_documento);
  }

  public String getCtpm_tx_tipo() {
    return  get("ctpm_tx_tipo");
//    return get("ctp_nr_documento");
  }

  public void setCtpm_tx_tipo(String ctpm_tx_tipo) {
    set("ctpm_tx_tipo", ctpm_tx_tipo);
  }


  public String getCtp_tx_obs() {
    return  get("ctp_tx_obs");
//    return get("ctp_tx_obs");
  }

  public void setCtp_tx_obs(String ctp_tx_obs) {
    set("ctp_tx_obs", ctp_tx_obs);
  }

  public String getCtp_tx_fornecedor() {
    return  get("ctp_tx_fornecedor");
//    return get("ctp_tx_fornecedor");
  }

  public void setCtp_tx_fornecedor(String ctp_tx_fornecedor) {
    set("ctp_tx_fornecedor", ctp_tx_fornecedor);
  }

  public float getCtp_nr_valor() {
    return  ((Float)get("ctp_nr_valor")).floatValue();
//    return get("ctp_nr_valor");
  }

  public void setCtp_nr_valor(float ctp_nr_valor) {
    set("ctp_nr_valor", ctp_nr_valor);
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



}

