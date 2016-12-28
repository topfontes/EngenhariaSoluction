
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
public class Ina_insumo_antigoTGWT extends BaseModel{
  public Ina_insumo_antigoTGWT() {
  }

  public int getIna_nr_id() {
    return  ((Integer)get("ina_nr_id")).intValue();
//    return get("ina_nr_id");
  }

  public void setIna_nr_id(int ina_nr_id) {
    set("ina_nr_id", ina_nr_id);
  }

  public String getIna_tx_codigo() {
    return  get("ina_tx_codigo");
//    return get("ina_tx_codigo");
  }

  public void setIna_tx_codigo(String ina_tx_codigo) {
    set("ina_tx_codigo", ina_tx_codigo);
  }

  public String getIna_tx_descricao() {
    return  get("ina_tx_descricao");
//    return get("ina_tx_descricao");
  }

  public void setIna_tx_descricao(String ina_tx_descricao) {
    set("ina_tx_descricao", ina_tx_descricao);
  }

  public String getIna_tx_unidade() {
    return  get("ina_tx_unidade");
//    return get("ina_tx_unidade");
  }

  public void setIna_tx_unidade(String ina_tx_unidade) {
    set("ina_tx_unidade", ina_tx_unidade);
  }



}

