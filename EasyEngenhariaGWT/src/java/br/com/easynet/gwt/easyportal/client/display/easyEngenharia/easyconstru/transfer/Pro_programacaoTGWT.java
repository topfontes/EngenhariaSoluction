
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
public class Pro_programacaoTGWT extends BaseModel{
  public Pro_programacaoTGWT() {
  }

  public int getPro_nr_id() {
    return  ((Integer)get("pro_nr_id")).intValue();
//    return get("pro_nr_id");
  }

  public void setPro_nr_id(int pro_nr_id) {
    set("pro_nr_id", pro_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("obr_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getPro_nr_mes() {
    return  ((Integer)get("pro_nr_mes")).intValue();
//    return get("pro_nr_mes");
  }

  public void setPro_nr_mes(int pro_nr_mes) {
    set("pro_nr_mes", pro_nr_mes);
  }

  public int getPro_nr_ano() {
    return  ((Integer)get("pro_nr_ano")).intValue();
//    return get("pro_nr_ano");
  }

  public void setPro_nr_ano(int pro_nr_ano) {
    set("pro_nr_ano", pro_nr_ano);
  }

  public java.util.Date getPro_dt_coleta_orcamento() {
    return  (Date)get("pro_dt_coleta_orcamento");
//    return get("pro_dt_coleta_orcamento");
  }

  public void setPro_dt_coleta_orcamento(java.util.Date pro_dt_coleta_orcamento) {
    set("pro_dt_coleta_orcamento", pro_dt_coleta_orcamento);
  }

  public java.util.Date getPro_dt_coleta_rh() {
    return  (Date)get("pro_dt_coleta_rh");
//    return get("pro_dt_coleta_rh");
  }

  public void setPro_dt_coleta_rh(java.util.Date pro_dt_coleta_rh) {
    set("pro_dt_coleta_rh", pro_dt_coleta_rh);
  }

  public java.util.Date getPro_dt_analise_inicio() {
    return  (Date)get("pro_dt_analise_inicio");
//    return get("pro_dt_analise_inicio");
  }

  public void setPro_dt_analise_inicio(java.util.Date pro_dt_analise_inicio) {
    set("pro_dt_analise_inicio", pro_dt_analise_inicio);
  }

  public java.util.Date getPro_dt_analise_final() {
    return  (Date)get("pro_dt_analise_final");
//    return get("pro_dt_analise_final");
  }

  public void setPro_dt_analise_final(java.util.Date pro_dt_analise_final) {
    set("pro_dt_analise_final", pro_dt_analise_final);
  }

  public java.util.Date getPro_dt_reuniao_engenharia() {
    return  (Date)get("pro_dt_reuniao_engenharia");
//    return get("pro_dt_reuniao_engenharia");
  }

  public void setPro_dt_reuniao_engenharia(java.util.Date pro_dt_reuniao_engenharia) {
    set("pro_dt_reuniao_engenharia", pro_dt_reuniao_engenharia);
  }

  public java.util.Date getPro_dt_reuniao_diretoria() {
    return  (Date)get("pro_dt_reuniao_diretoria");
//    return get("pro_dt_reuniao_diretoria");
  }

  public void setPro_dt_reuniao_diretoria(java.util.Date pro_dt_reuniao_diretoria) {
    set("pro_dt_reuniao_diretoria", pro_dt_reuniao_diretoria);
  }

  public java.util.Date getPro_dt_reuniao_geral() {
    return  (Date)get("pro_dt_reuniao_geral");
//    return get("pro_dt_reuniao_geral");
  }

  public void setPro_dt_reuniao_geral(java.util.Date pro_dt_reuniao_geral) {
    set("pro_dt_reuniao_geral", pro_dt_reuniao_geral);
  }



}

