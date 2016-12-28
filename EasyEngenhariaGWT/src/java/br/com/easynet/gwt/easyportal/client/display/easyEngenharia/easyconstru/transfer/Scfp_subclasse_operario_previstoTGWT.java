
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
public class Scfp_subclasse_operario_previstoTGWT extends BaseModel{
  public Scfp_subclasse_operario_previstoTGWT() {
  }

  public int getScfp_nr_id() {
    return  ((Integer)get("scfp_nr_id")).intValue();
//    return get("scfp_nr_id");
  }

  public void setScfp_nr_id(int scfp_nr_id) {
    set("scfp_nr_id", scfp_nr_id);
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plc_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }
  public void setSubClasse(String subClasse){
      set("subClasse",subClasse);
  }
  public String getSubClasse(){
      return get("subClasse");
  }



}

