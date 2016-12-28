
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
public class Nfe_nota_fiscal_entradaTGWT extends BaseModel{
  public Nfe_nota_fiscal_entradaTGWT() {
  }

  public int getNfe_nr_id() {
    return  ((Integer)get("nfe_nr_id")).intValue();
//    return get("nfe_nr_id");
  }

  public void setNfe_nr_id(int nfe_nr_id) {
    set("nfe_nr_id", nfe_nr_id);
  }

  public java.util.Date getNfe_dt_emissao() {
    return  (Date)get("nfe_dt_emissao");
//    return get("nfe_dt_emissao");
  }

  public void setNfe_dt_emissao(java.util.Date nfe_dt_emissao) {
    set("nfe_dt_emissao", nfe_dt_emissao);
  }

  public int getFor_nr_id() {
    return  ((Integer)get("for_nr_id")).intValue();
//    return get("for_nr_id");
  }

  public void setFor_nr_id(int for_nr_id) {
    set("for_nr_id", for_nr_id);
  }

  public float getNfe_nr_valor_nota() {
    return  ((Float)get("nfe_nr_valor_nota")).floatValue();
//    return get("nfe_nr_valor_nota");
  }

  public void setNfe_nr_valor_nota(float nfe_nr_valor_nota) {
    set("nfe_nr_valor_nota", nfe_nr_valor_nota);
  }



}

