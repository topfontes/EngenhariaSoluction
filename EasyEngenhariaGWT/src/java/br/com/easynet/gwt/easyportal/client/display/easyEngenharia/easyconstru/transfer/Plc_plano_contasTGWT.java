
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
public class Plc_plano_contasTGWT extends BaseModel{
  public Plc_plano_contasTGWT() {
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

  public int getPlc_nr_id_super() {
    return  ((Integer)get("plc_nr_id_super")).intValue();
//    return get("plc_nr_id_super");
  }

  public void setPlc_nr_id_super(int plc_nr_id_super) {
    set("plc_nr_id_super", plc_nr_id_super);
  }

  public String getPlc_tx_caixa_banco() {
    return  get("plc_tx_caixa_banco");
//    return get("plc_tx_caixa_banco");
  }

  public void setPlc_tx_caixa_banco(String plc_tx_caixa_banco) {
    set("plc_tx_caixa_banco", plc_tx_caixa_banco);
  }

  public boolean getPlc_bl_caixa_banco() {
    return (Boolean)get("plc_bl_caixa_banco");
  }

  public void setPlc_bl_caixa_banco(boolean plc_bl_caixa_banco) {
    set("plc_bl_caixa_banco", plc_bl_caixa_banco);
  }

  public String getPlc_tx_centro_custo() {
    return  get("plc_tx_centro_custo");
//    return get("plc_tx_nome");
  }

  public void setPlc_tx_centro_custo(String plc_tx_centro_custo) {
    set("plc_tx_centro_custo", plc_tx_centro_custo);
  }

  public String getPlc_tx_super() {
    return  get("plc_tx_super");
//    return get("plc_tx_nome");
  }

  public void setPlc_tx_super(String plc_tx_super) {
    set("plc_tx_super", plc_tx_super);
  }

    public int getCen_nr_id() {
    return  ((Integer)get("cen_nr_id")).intValue();
//    return get("plc_nr_id_super");
  }

  public void setCen_nr_id(int cen_nr_id) {
    set("cen_nr_id", cen_nr_id);
  }
    public int getPar_nr_id() {
    return  ((Integer)get("par_nr_id")).intValue();
//    return get("plc_nr_id_super");
  }

  public void setPar_nr_id(int par_nr_id) {
    set("par_nr_id", par_nr_id);
  }

  public String getpar_tx_nome() {
    return  get("par_tx_nome");
//    return get("plc_tx_nome");
  }

  public void setPar_tx_nome(String par_tx_nome) {
    set("par_tx_nome", par_tx_nome);
  }

}

