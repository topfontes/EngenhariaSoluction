
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
public class Pro_produtoTGWT extends BaseModel{
  public Pro_produtoTGWT() {
  }

  public int getPro_nr_id() {
    return  ((Integer)get("pro_nr_id")).intValue();
//    return get("pro_nr_id");
  }

  public void setPro_nr_id(int pro_nr_id) {
    set("pro_nr_id", pro_nr_id);
  }

  public String getPro_tx_nome() {
    return  get("pro_tx_nome");
//    return get("pro_tx_nome");
  }

  public void setPro_tx_nome(String pro_tx_nome) {
    set("pro_tx_nome", pro_tx_nome);
  }

  public int getGrp_nr_id() {
    return  ((Integer)get("grp_nr_id")).intValue();
//    return get("grp_nr_id");
  }

  public void setGrp_nr_id(int grp_nr_id) {
    set("grp_nr_id", grp_nr_id);
  }



}

