
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
public class Coa_composicao_anteriorTGWT extends BaseModel{
  public Coa_composicao_anteriorTGWT() {
  }

  public int getCoa_nr_id() {
    return  ((Integer)get("coa_nr_id")).intValue();
//    return get("coa_nr_id");
  }

  public void setCoa_nr_id(int coa_nr_id) {
    set("coa_nr_id", coa_nr_id);
  }

  public String getCoa_tx_codigo() {
    return  get("coa_tx_codigo");
//    return get("coa_tx_codigo");
  }

  public void setCoa_tx_codigo(String coa_tx_codigo) {
    set("coa_tx_codigo", coa_tx_codigo);
  }

  public String getCoa_tx_descricao() {
    return  get("coa_tx_descricao");
//    return get("coa_tx_descricao");
  }

  public void setCoa_tx_descricao(String coa_tx_descricao) {
    set("coa_tx_descricao", coa_tx_descricao);
  }

  public String getCoa_tx_unidade() {
    return  get("coa_tx_unidade");
//    return get("coa_tx_unidade");
  }

  public void setCoa_tx_unidade(String coa_tx_unidade) {
    set("coa_tx_unidade", coa_tx_unidade);
  }



}

