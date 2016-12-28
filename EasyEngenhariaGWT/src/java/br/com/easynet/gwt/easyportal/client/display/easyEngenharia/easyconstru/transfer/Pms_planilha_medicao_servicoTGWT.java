
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
public class Pms_planilha_medicao_servicoTGWT extends BaseModel{
  public Pms_planilha_medicao_servicoTGWT() {
  }

  public int getPms_nr_id() {
    return  ((Integer)get("pms_nr_id")).intValue();
//    return get("pms_nr_id");
  }

  public void setPms_nr_id(int pms_nr_id) {
    set("pms_nr_id", pms_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getPms_nr_mes() {
    return  ((Integer)get("pms_nr_mes")).intValue();
//    return get("pms_nr_mes");
  }

  public void setPms_nr_mes(int pms_nr_mes) {
    set("pms_nr_mes", pms_nr_mes);
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }

  public int getIpo_nr_id() {
    return  ((Integer)get("ipo_nr_id")).intValue();
  }

  public void setIpo_nr_id(int ipo_nr_id) {
    set("ipo_nr_id", ipo_nr_id);
  }

  public float getPms_nr_quantidade_servico() {
    return  ((Float)get("pms_nr_quantidade_servico")).floatValue();
//    return get("pms_nr_quantidade_servico");
  }

  public void setPms_nr_quantidade_servico(float pms_nr_quantidade_servico) {
    set("pms_nr_quantidade_servico", pms_nr_quantidade_servico);
  }//tpms_nr_percentual
  
  public void setPms_nr_percentual(float pms_nr_percentual){
      set("pms_nr_percentual",pms_nr_percentual);
  }

  public float getPms_nr_percentual(){
      return ((Float)get("pms_nr_percentual")).floatValue();
  }


}

