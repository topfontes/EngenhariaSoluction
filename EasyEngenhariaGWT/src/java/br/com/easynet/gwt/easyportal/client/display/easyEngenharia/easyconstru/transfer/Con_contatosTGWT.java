
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
public class Con_contatosTGWT extends BaseModel{
  public Con_contatosTGWT() {
  }

  public int getCon_nr_id() {
    return  ((Integer)get("con_nr_id")).intValue();
//    return get("con_nr_id");
  }

  public void setCon_nr_id(int con_nr_id) {
    set("con_nr_id", con_nr_id);
  }

  public int getCli_nr_id() {
    return  ((Integer)get("cli_nr_id")).intValue();
//    return get("cli_nr_id");
  }

  public void setCli_nr_id(int cli_nr_id) {
    set("cli_nr_id", cli_nr_id);
  }

  public String getCon_tx_nome() {
    return  get("con_tx_nome");
//    return get("con_tx_nome");
  }

  public void setCon_tx_nome(String con_tx_nome) {
    set("con_tx_nome", con_tx_nome);
  }

  public int getSet_nr_id() {
    return  ((Integer)get("set_nr_id")).intValue();
//    return get("set_nr_id");
  }

  public void setSet_nr_id(int set_nr_id) {
    set("set_nr_id", set_nr_id);
  }

  public String getCon_tx_cargo_exercicio() {
    return  get("con_tx_cargo_exercicio");
//    return get("con_tx_cargo_exercicio");
  }

  public void setCon_tx_cargo_exercicio(String con_tx_cargo_exercicio) {
    set("con_tx_cargo_exercicio", con_tx_cargo_exercicio);
  }

  public String getCon_tx_telefone() {
    return  get("con_tx_telefone");
//    return get("con_tx_telefone");
  }

  public void setCon_tx_telefone(String con_tx_telefone) {
    set("con_tx_telefone", con_tx_telefone);
  }

  public String getCon_tx_telefone2() {
    return  get("con_tx_telefone2");
//    return get("con_tx_telefone2");
  }

  public void setCon_tx_telefone2(String con_tx_telefone2) {
    set("con_tx_telefone2", con_tx_telefone2);
  }

  public String getCon_tx_email() {
    return  get("con_tx_email");
//    return get("con_tx_email");
  }

  public void setCon_tx_email(String con_tx_email) {
    set("con_tx_email", con_tx_email);
  }



}

