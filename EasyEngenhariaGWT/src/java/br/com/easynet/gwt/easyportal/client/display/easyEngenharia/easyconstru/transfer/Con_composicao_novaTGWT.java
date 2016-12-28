
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
public class Con_composicao_novaTGWT extends BaseModel{
  public Con_composicao_novaTGWT() {
  }

  public int getCon_nr_id() {
    return  ((Integer)get("con_nr_id")).intValue();
//    return get("con_nr_id");
  }

  public void setCon_nr_id(int con_nr_id) {
    set("con_nr_id", con_nr_id);
  }

  public String getCon_tx_codigo() {
    return  get("con_tx_codigo");
//    return get("con_tx_codigo");
  }

  public void setCon_tx_codigo(String con_tx_codigo) {
    set("con_tx_codigo", con_tx_codigo);
  }

  public String getCon_tx_descricao() {
    return  get("con_tx_descricao");
//    return get("con_tx_descricao");
  }

  public void setCon_tx_descricao(String con_tx_descricao) {
    set("con_tx_descricao", con_tx_descricao);
  }

  public String getCon_tx_unidade() {
    return  get("con_tx_unidade");
//    return get("con_tx_unidade");
  }

  public void setCon_tx_unidade(String con_tx_unidade) {
    set("con_tx_unidade", con_tx_unidade);
  }



}

