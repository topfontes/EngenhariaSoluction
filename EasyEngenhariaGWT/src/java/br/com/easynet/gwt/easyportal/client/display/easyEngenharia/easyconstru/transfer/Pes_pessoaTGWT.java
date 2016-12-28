
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
public class Pes_pessoaTGWT extends BaseModel{
  public Pes_pessoaTGWT() {
  }

  public int getPes_nr_id() {
    return  ((Integer)get("pes_nr_id")).intValue();
//    return get("pes_nr_id");
  }

  public void setPes_nr_id(int pes_nr_id) {
    set("pes_nr_id", pes_nr_id);
  }

  public String getPes_tx_nome() {
    return  get("pes_tx_nome");
//    return get("pes_tx_nome");
  }

  public void setPes_tx_nome(String pes_tx_nome) {
    set("pes_tx_nome", pes_tx_nome);
  }

  public String getPes_tx_fone() {
    return  get("pes_tx_fone");
//    return get("pes_tx_fone");
  }

  public void setPes_tx_fone(String pes_tx_fone) {
    set("pes_tx_fone", pes_tx_fone);
  }



}

