
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
public class Inn_insumo_novoTGWT extends BaseModel{
  public Inn_insumo_novoTGWT() {
  }

  public int getInn_nr_id() {
    return  ((Integer)get("inn_nr_id")).intValue();
//    return get("inn_nr_id");
  }

  public void setInn_nr_id(int inn_nr_id) {
    set("inn_nr_id", inn_nr_id);
  }

  public String getInn_tx_codigo() {
    return  get("inn_tx_codigo");
//    return get("inn_tx_codigo");
  }

  public void setInn_tx_codigo(String inn_tx_codigo) {
    set("inn_tx_codigo", inn_tx_codigo);
  }

  public String getInn_tx_descricao() {
    return  get("inn_tx_descricao");
//    return get("inn_tx_descricao");
  }

  public void setInn_tx_descricao(String inn_tx_descricao) {
    set("inn_tx_descricao", inn_tx_descricao);
  }

  public String getInn_tx_unidade() {
    return  get("inn_tx_unidade");
//    return get("inn_tx_unidade");
  }

  public void setInn_tx_unidade(String inn_tx_unidade) {
    set("inn_tx_unidade", inn_tx_unidade);
  }



}

