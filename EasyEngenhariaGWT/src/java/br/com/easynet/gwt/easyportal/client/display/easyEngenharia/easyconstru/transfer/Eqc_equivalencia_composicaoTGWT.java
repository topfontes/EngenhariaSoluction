
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
public class Eqc_equivalencia_composicaoTGWT extends BaseModel{
  public Eqc_equivalencia_composicaoTGWT() {
  }

  public int getCoa_nr_id() {
    return  ((Integer)get("coa_nr_id")).intValue();
//    return get("coa_nr_id");
  }

  public void setCoa_nr_id(int coa_nr_id) {
    set("coa_nr_id", coa_nr_id);
  }

  public int getCon_nr_id() {
    return  ((Integer)get("con_nr_id")).intValue();
//    return get("con_nr_id");
  }

  public void setCon_nr_id(int con_nr_id) {
    set("con_nr_id", con_nr_id);
  }



}

