
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
public class Grp_grupo_produtoTGWT extends BaseModel{
  public Grp_grupo_produtoTGWT() {
  }

  public int getGrp_nr_id() {
    return  ((Integer)get("grp_nr_id")).intValue();
//    return get("grp_nr_id");
  }

  public void setGrp_nr_id(int grp_nr_id) {
    set("grp_nr_id", grp_nr_id);
  }

  public String getGrp_tx_nome() {
    return  get("grp_tx_nome");
//    return get("grp_tx_nome");
  }

  public void setGrp_tx_nome(String grp_tx_nome) {
    set("grp_tx_nome", grp_tx_nome);
  }



}

