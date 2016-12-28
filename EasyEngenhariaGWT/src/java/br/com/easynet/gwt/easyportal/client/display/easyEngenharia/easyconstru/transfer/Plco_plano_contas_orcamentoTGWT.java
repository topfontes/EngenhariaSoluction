
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
public class Plco_plano_contas_orcamentoTGWT extends BaseModel{
  public Plco_plano_contas_orcamentoTGWT() {
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }

  public int getPlco_nr_nivel() {
    return  ((Integer)get("plco_nr_nivel")).intValue();
  }

  public void setPlco_nr_nivel(int plco_nr_nivel) {
    set("plco_nr_nivel", plco_nr_nivel);
  }

  public String getPlco_tx_nome() {
    return  get("plco_tx_nome");
//    return get("plco_tx_nome");
  }

  public void setPlco_tx_nome(String plco_tx_nome) {
    set("plco_tx_nome", plco_tx_nome);
  }

  public String getPlco_bl_equivalencia() {
    return  get("plco_bl_equivalencia");
//    return get("plco_tx_nome");
  }

  public void setPlco_bl_equivalencia(String plco_bl_equivalencia) {
    set("plco_bl_equivalencia", plco_bl_equivalencia);
  }


  public String getPlco_tx_tipo() {
    return  get("plco_tx_tipo");
//    return get("plco_tx_tipo");
  }

  public void setPlco_tx_tipo(String plco_tx_tipo) {
    set("plco_tx_tipo", plco_tx_tipo);
  }

  public String getPlco_tx_cod_externo() {
    return  get("plco_tx_cod_externo");
//    return get("plco_tx_cod_externo");
  }

  public void setPlco_tx_cod_externo(String plco_tx_cod_externo) {
    set("plco_tx_cod_externo", plco_tx_cod_externo);
  }

  public String getPlco_tx_unidade() {
    return  get("plco_tx_unidade");
//    return get("plco_tx_unidade");
  }

  public void setPlco_tx_unidade(String plco_tx_unidade) {
    set("plco_tx_unidade", plco_tx_unidade);
  }

  public int getPlco_nr_id_super() {
    return  ((Integer)get("plco_nr_id_super")).intValue();
//    return get("plco_nr_id_super");
  }

  public void setPlco_nr_id_super(int plco_nr_id_super) {
    set("plco_nr_id_super", plco_nr_id_super);
  }

  public int getPar_nr_id() {
    return  ((Integer)get("par_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPar_nr_id(int par_nr_id) {
    set("par_nr_id", par_nr_id);
  }

}

