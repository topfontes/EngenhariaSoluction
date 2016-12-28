
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
public class Obr_obrasTGWT extends BaseModel{
  public Obr_obrasTGWT() {
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public String getObr_tx_nome() {
    return  get("obr_tx_nome");
//    return get("obr_tx_nome");
  }

  public void setObr_tx_nome(String obr_tx_nome) {
    set("obr_tx_nome", obr_tx_nome);
  }

  public String getObr_tx_endereco() {
    return  get("obr_tx_endereco");
//    return get("obr_tx_endereco");
  }

  public void setObr_tx_endereco(String obr_tx_endereco) {
    set("obr_tx_endereco", obr_tx_endereco);
  }

  public String getObr_tx_bairro() {
    return  get("obr_tx_bairro");
//    return get("obr_tx_bairro");
  }

  public void setObr_tx_bairro(String obr_tx_bairro) {
    set("obr_tx_bairro", obr_tx_bairro);
  }

  public String getObr_tx_cidade() {
    return  get("obr_tx_cidade");
//    return get("obr_tx_cidade");
  }

  public void setObr_tx_cidade(String obr_tx_cidade) {
    set("obr_tx_cidade", obr_tx_cidade);
  }

  public String getObr_tx_uf() {
    return  get("obr_tx_uf");
//    return get("obr_tx_uf");
  }

  public void setObr_tx_uf(String obr_tx_uf) {
    set("obr_tx_uf", obr_tx_uf);
  }

  public int getEmp_nr_id() {
    return  ((Integer)get("emp_nr_id")).intValue();
//    return get("emp_nr_id");
  }

  public void setEmp_nr_id(int emp_nr_id) {
    set("emp_nr_id", emp_nr_id);
  }

  public float getObr_nr_area_construida_total() {
    return  ((Float)get("obr_nr_area_construida_total")).floatValue();
//    return get("obr_nr_area_construida_total");
  }

  public void setObr_nr_area_construida_total(float obr_nr_area_construida_total) {
    set("obr_nr_area_construida_total", obr_nr_area_construida_total);
  }

  public float getObr_nr_area_privativa_total() {
    return  ((Float)get("obr_nr_area_privativa_total")).floatValue();
//    return get("obr_nr_area_construida_total");
  }

  public void setObr_nr_area_privativa_total(float obr_nr_area_privativa_total) {
    set("obr_nr_area_privativa_total", obr_nr_area_privativa_total);
  }
//obr_nr_area_privativa_total
  public java.util.Date getObr_dt_inicio() {
    return  (Date)get("obr_dt_inicio");
//    return get("obr_dt_inicio");
  }

  public void setObr_dt_inicio(java.util.Date obr_dt_inicio) {
    set("obr_dt_inicio", obr_dt_inicio);
  }

  public java.util.Date getObr_dt_fim() {
    return  (Date)get("obr_dt_fim");
//    return get("obr_dt_fim");
  }

  public void setObr_dt_fim(java.util.Date obr_dt_fim) {
    set("obr_dt_fim", obr_dt_fim);
  }

  public java.util.Date getObr_dt_inicio_controle() {
    return  (Date)get("obr_dt_inicio_controle");
//    return get("obr_dt_inicio_controle");
  }

  public void setObr_dt_inicio_controle(java.util.Date obr_dt_inicio_controle) {
    set("obr_dt_inicio_controle", obr_dt_inicio_controle);
  }

  public java.util.Date getObr_dt_termino_controle() {
    return  (Date)get("obr_dt_termino_controle");
//    return get("obr_dt_termino_controle");
  }

  public void setObr_dt_termino_controle(java.util.Date obr_dt_termino_controle) {
    set("obr_dt_termino_controle", obr_dt_termino_controle);
  }


  public String getEmp_tx_nome() {
    return  get("emp_tx_nome");
//    return get("obr_tx_cidade");
  }

  public void setEmp_tx_nome(String emp_tx_nome) {
    set("emp_tx_nome", emp_tx_nome);
  }

  public void setObr_nr_id_plc_mdo_direta(int obr_nr_id_plc_mdo_direta){
      set("obr_nr_id_plc_mdo_direta",obr_nr_id_plc_mdo_direta);
  }
  public int getObr_nr_id_plc_mdo_direta(){
      return ((Integer)get("obr_nr_id_plc_mdo_direta")).intValue();
  }

  public void setObr_nr_id_plc_mdo_indireta(int obr_nr_id_plc_mdo_indireta){
      set("obr_nr_id_plc_mdo_indireta",obr_nr_id_plc_mdo_indireta);
  }
  public int getobr_nr_id_plc_mdo_indireta(){
      return ((Integer)get("obr_nr_id_plc_mdo_indireta")).intValue();
  }

  public void setObr_nr_percent_mdo_direta(float obr_nr_percent_mdo_direta){
      set("obr_nr_percent_mdo_direta",obr_nr_percent_mdo_direta);
  }
  public float getObr_nr_percent_mdo_direta(){
      return ((Float)get("obr_nr_percent_mdo_direta")).floatValue();
  }
  public void setObr_nr_percent_mdo_indireta(float obr_nr_percent_mdo_indireta){
      set("obr_nr_percent_mdo_indireta",obr_nr_percent_mdo_indireta);
  }
  public float getObr_nr_percent_mdo_indireta(){
      return ((Float)get("obr_nr_percent_mdo_indireta")).floatValue();
  }


  public void setObr_nr_valor_permutado(float obr_nr_valor_permutado){
      set("obr_nr_valor_permutado",obr_nr_valor_permutado);
  }
  public float getObr_nr_valor_permutado(){
      return ((Float)get("obr_nr_valor_permutado")).floatValue();
  }

  public void setObr_nr_valor_vgv(float obr_nr_valor_vgv){
      set("obr_nr_valor_vgv",obr_nr_valor_vgv);
  }
  public float getObr_nr_valor_vgv(){
      return ((Float)get("obr_nr_valor_vgv")).floatValue();
  }


  public void setObr_nr_encarcos_juros_aplicacao(float obr_nr_encarcos_juros_aplicacao){
      set("obr_nr_encarcos_juros_aplicacao",obr_nr_encarcos_juros_aplicacao);
  }
  public float getObr_nr_encarcos_juros_aplicacao(){
      return ((Float)get("obr_nr_encarcos_juros_aplicacao")).floatValue();
  }



  public java.util.Date getObr_dt_inicio_real() {
    return  (Date)get("obr_dt_inicio_real");
//    return get("obr_dt_inicio");
  }

  public void setObr_dt_inicio_real(java.util.Date obr_dt_inicio_real) {
    set("obr_dt_inicio_real", obr_dt_inicio_real);
  }

  public java.util.Date getObr_dt_final_real() {
    return  (Date)get("obr_dt_final_real");
//    return get("obr_dt_fim");
  }

  public void setObr_dt_final_real(java.util.Date obr_dt_final_real) {
    set("obr_dt_final_real", obr_dt_final_real);
  }

  
}

