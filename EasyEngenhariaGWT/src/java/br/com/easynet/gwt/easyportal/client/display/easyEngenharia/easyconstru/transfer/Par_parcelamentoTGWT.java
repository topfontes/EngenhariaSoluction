
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
public class Par_parcelamentoTGWT extends BaseModel{
  public Par_parcelamentoTGWT() {
  }

  public int getPar_nr_id() {
    return  ((Integer)get("par_nr_id")).intValue();
//    return get("par_nr_id");
  }

  public void setPar_nr_id(int par_nr_id) {
    set("par_nr_id", par_nr_id);
  }

  public String getPar_tx_nome() {
    return  get("par_tx_nome");
//    return get("par_tx_nome");
  }

  public void setPar_tx_nome(String par_tx_nome) {
    set("par_tx_nome", par_tx_nome);
  }

  public int getPar_nr_parcelas() {
    return  ((Integer)get("par_nr_parcelas")).intValue();
//    return get("par_nr_parcelas");
  }

  public void setPar_nr_parcelas(int par_nr_parcelas) {
    set("par_nr_parcelas", par_nr_parcelas);
  }

  public int getPar_nr_intervalo_dias() {
    return  ((Integer)get("par_nr_intervalo_dias")).intValue();
//    return get("par_nr_intervalo_dias");
  }

  public void setPar_nr_intervalo_dias(int par_nr_intervalo_dias) {
    set("par_nr_intervalo_dias", par_nr_intervalo_dias);
  }



}

