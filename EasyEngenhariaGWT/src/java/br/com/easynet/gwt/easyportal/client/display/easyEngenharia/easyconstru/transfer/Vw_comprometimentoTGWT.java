
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
public class Vw_comprometimentoTGWT extends BaseModel{
  public Vw_comprometimentoTGWT() {
  }

  public int getCom_nr_id() {
    return  ((Integer)get("com_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setCom_nr_id(int com_nr_id) {
    set("com_nr_id", com_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getCom_nr_mes() {
    return  ((Integer)get("com_nr_mes")).intValue();
//    return get("com_nr_mes");
  }

  public void setCom_nr_mes(int com_nr_mes) {
    set("com_nr_mes", com_nr_mes);
  }

  public int getCom_nr_ano() {
    return  ((Integer)get("com_nr_ano")).intValue();
//    return get("com_nr_ano");
  }

  public void setCom_nr_ano(int com_nr_ano) {
    set("com_nr_ano", com_nr_ano);
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

  public double getCom_nr_valor() {
    return  ((Double)get("com_nr_valor")).doubleValue();
//    return get("com_nr_valor");
  }

  public void setCom_nr_valor(double com_nr_valor) {
    set("com_nr_valor", com_nr_valor);
  }

  public String getPlc_tx_nome_super() {
    return  get("plc_tx_nome_super");
//    return get("plc_tx_nome");
  }

  public void setPlc_tx_nome_super(String plc_tx_nome_super) {
    set("plc_tx_nome_super", plc_tx_nome_super);
  }

}

