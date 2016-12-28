
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
public class Emp_empreendimentoTGWT extends BaseModel{
  public Emp_empreendimentoTGWT() {
  }

  public int getEmp_nr_id() {
    return  ((Integer)get("emp_nr_id")).intValue();
//    return get("emp_nr_id");
  }

  public void setEmp_nr_id(int emp_nr_id) {
    set("emp_nr_id", emp_nr_id);
  }

  public String getEmp_tx_nome() {
    return  get("emp_tx_nome");
  }

  public void setEmp_tx_nome(String emp_tx_nome) {
    set("emp_tx_nome", emp_tx_nome);
  }


  public String getEmp_tx_endereco() {
    return  get("emp_tx_endereco");
  }

  public void setEmp_tx_endereco(String emp_tx_endereco) {
    set("emp_tx_endereco", emp_tx_endereco);
  }

  public String getEmp_tx_bairro() {
    return  get("emp_tx_bairro");
  }

  public void setEmp_tx_bairro(String emp_tx_bairro) {
    set("emp_tx_bairro", emp_tx_bairro);
  }

  public String getEmp_tx_cidade() {
    return  get("emp_tx_cidade");
//    return get("emp_tx_cidade");
  }

  public void setEmp_tx_cidade(String emp_tx_cidade) {
    set("emp_tx_cidade", emp_tx_cidade);
  }

  public String getEmp_tx_uf() {
    return  get("emp_tx_uf");
//    return get("emp_tx_uf");
  }

  public void setEmp_tx_uf(String emp_tx_uf) {
    set("emp_tx_uf", emp_tx_uf);
  }

  public int getCli_nr_id() {
    return  ((Integer)get("cli_nr_id")).intValue();
//    return get("cli_nr_id");
  }

  public void setCli_nr_id(int cli_nr_id) {
    set("cli_nr_id", cli_nr_id);
  }

  public String getCliente() {
    return  get("cliente");
  }

  public void setCliente(String cliente) {
    set("cliente", cliente);
  }

}

