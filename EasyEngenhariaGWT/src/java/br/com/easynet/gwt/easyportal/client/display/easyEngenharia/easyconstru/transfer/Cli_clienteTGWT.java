
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
public class Cli_clienteTGWT extends BaseModel{
  public Cli_clienteTGWT() {
  }

  public int getCli_nr_id() {
    return  ((Integer)get("cli_nr_id")).intValue();
//    return get("cli_nr_id");
  }

  public void setCli_nr_id(int cli_nr_id) {
    set("cli_nr_id", cli_nr_id);
  }

  public String getCli_tx_nome() {
    return  get("cli_tx_nome");
//    return get("cli_tx_nome");
  }

  public void setCli_tx_nome(String cli_tx_nome) {
    set("cli_tx_nome", cli_tx_nome);
  }

  public String getCli_tx_tipo_pessoa() {
    return  get("cli_tx_tipo_pessoa");
//    return get("cli_tx_tipo_pessoa");
  }

  public void setCli_tx_tipo_pessoa(String cli_tx_tipo_pessoa) {
    set("cli_tx_tipo_pessoa", cli_tx_tipo_pessoa);
  }

  public String getCli_tx_cnpj_cpf() {
    return  get("cli_tx_cnpj_cpf");
//    return get("cli_tx_cnpj_cpf");
  }

  public void setCli_tx_cnpj_cpf(String cli_tx_cnpj_cpf) {
    set("cli_tx_cnpj_cpf", cli_tx_cnpj_cpf);
  }

  public String getCli_tx_endereco() {
    return  get("cli_tx_endereco");
//    return get("cli_tx_endereco");
  }

  public void setCli_tx_endereco(String cli_tx_endereco) {
    set("cli_tx_endereco", cli_tx_endereco);
  }

  public String getCli_tx_bairro() {
    return  get("cli_tx_bairro");
//    return get("cli_tx_bairro");
  }

  public void setCli_tx_bairro(String cli_tx_bairro) {
    set("cli_tx_bairro", cli_tx_bairro);
  }

  public String getCli_tx_cidade() {
    return  get("cli_tx_cidade");
//    return get("cli_tx_cidade");
  }

  public void setCli_tx_cidade(String cli_tx_cidade) {
    set("cli_tx_cidade", cli_tx_cidade);
  }

  public String getCli_tx_telefone() {
    return  get("cli_tx_telefone");
//    return get("cli_tx_telefone");
  }

  public void setCli_tx_telefone(String cli_tx_telefone) {
    set("cli_tx_telefone", cli_tx_telefone);
  }

  public String getCli_tx_fax() {
    return  get("cli_tx_fax");
//    return get("cli_tx_fax");
  }

  public void setCli_tx_fax(String cli_tx_fax) {
    set("cli_tx_fax", cli_tx_fax);
  }

  public String getCli_tx_telefone2() {
    return  get("cli_tx_telefone2");
//    return get("cli_tx_telefone2");
  }

  public void setCli_tx_telefone2(String cli_tx_telefone2) {
    set("cli_tx_telefone2", cli_tx_telefone2);
  }

  public byte[] getCli_by_logomarca() {
    return  null;
    //return ((byte[])get("cli_by_logomarca"));
  }

  public void setCli_by_logomarca(byte[] cli_by_logomarca) {
    set("cli_by_logomarca", cli_by_logomarca);
  }

  public String getCli_tx_email() {
    return  get("cli_tx_email");
//    return get("cli_tx_email");
  }

  public void setCli_tx_email(String cli_tx_email) {
    set("cli_tx_email", cli_tx_email);
  }

    public String getCli_tx_uf() {
    return  get("cli_tx_uf");
//    return get("cli_tx_email");
  }

  public void setCli_tx_uf(String cli_tx_uf) {
    set("cli_tx_uf", cli_tx_uf);
  }
  
 public String getCli_tx_inscricao_estatual(){
     return get("cli_tx_inscricao_estatual");
 }
 public void setCli_tx_inscricao_estatual(String cli_tx_inscricao_estatual){
     set("cli_tx_inscricao_estatual", cli_tx_inscricao_estatual);
 }
 public String getCli_tx_contato(){
     return get("cli_tx_contato");
 }
 
 public void setCli_tx_contato(String cli_tx_contato){
     set("cli_tx_contato", cli_tx_contato);
 }

 public String getcli_tx_celular(){
     return get("cli_tx_celular");
 }
 public void setcli_tx_celular(String cli_tx_celular){
     set("cli_tx_celular", cli_tx_celular);
 }
//
 public String getCli_tx_letra_orcamento_externo(){
     return get("cli_tx_letra_orcamento_externo");
 }
 public void setCli_tx_letra_orcamento_externo(String cli_tx_letra_orcamento_externo){
     set("cli_tx_letra_orcamento_externo", cli_tx_letra_orcamento_externo);
 }
}

