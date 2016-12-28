
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
    public class Ctp_conta_pagarTGWT extends BaseModel{
  public Ctp_conta_pagarTGWT() {
  }

  public int getCtp_nr_id() {
    return  ((Integer)get("ctp_nr_id")).intValue();
  }

  public void setCtp_nr_id(int ctp_nr_id) {
    set("ctp_nr_id", ctp_nr_id);
  }

  public String getCtp_tx_fornecedor() {
    return  get("ctp_tx_fornecedor");
//    return get("for_nr_id");
  }

  public void setCtp_tx_fornecedor(String ctp_tx_fornecedor) {
    set("ctp_tx_fornecedor", ctp_tx_fornecedor);
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
//    return get("ctp_nr_mes");
  }

  public void setCtp_nr_ano(int ctp_nr_ano) {
    set("ctp_nr_ano", ctp_nr_ano);
  }

  public int getPlc_nr_id() {
    return  ((Integer)get("plc_nr_id")).intValue();
//    return get("plc_nr_id");
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set("plc_nr_id", plc_nr_id);
  }

  public double getCtp_nr_valor() {
    return  ((Double)get("ctp_nr_valor")).doubleValue();
//    return get("ctp_nr_valor");
  }

  public void setCtp_nr_valor(double ctp_nr_valor) {
    set("ctp_nr_valor", ctp_nr_valor);
  }

  public String getCtp_nr_documento() {
    return  get("ctp_nr_documento");
//    return get("ctp_nr_documento");
  }

  public void setCtp_nr_documento(String ctp_nr_documento) {
    set("ctp_nr_documento", ctp_nr_documento);
  }

  public String getCtp_tx_status() {
    return  get("ctp_tx_status");
//    return get("ctp_tx_status");
  }

  public void setCtp_tx_status(String ctp_tx_status) {
    set("ctp_tx_status", ctp_tx_status);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public String getObr_tx_nome() {
    return  get("obr_tx_nome");
//    return get("ctp_tx_status");
  }

  public void setObr_tx_nome(String obr_tx_nome) {
    set("obr_tx_nome", obr_tx_nome);
  }

  public String getPlc_tx_nome() {
    return  get("obr_tx_nome");
//    return get("ctp_tx_status");
  }

  public void setPlc_tx_nome(String plc_tx_nome) {
    set("plc_tx_nome", plc_tx_nome);
  }

  public String getPlc_tx_nome_super() {
    return  get("obr_tx_nome_super");
//    return get("ctp_tx_status");
  }

  public void setPlc_tx_nome_super(String plc_tx_nome_super) {
    set("plc_tx_nome_super", plc_tx_nome_super);
  }
  
  public void setCtp_tx_obs(String ctp_tx_obs){
      set("ctp_tx_obs",ctp_tx_obs);
  }
  public String getCtp_tx_obs(){
      return get("ctp_tx_obs");
  }
  public void setCtp_dt_vencimento(Date ctp_dt_vencimento){
      set("ctp_dt_vencimento",ctp_dt_vencimento);
  }
  public Date getCtp_dt_vencimento(){
    return (Date) get("ctp_dt_vencimento");
  }
  public void setCtp_dt_emissao(Date ctp_dt_emissao){
      set("ctp_dt_emissao",ctp_dt_emissao);
  }
  public Date getCtp_dt_emissao(){
    return (Date) get("ctp_dt_emissao");
  }

}

