
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
public class Tpms_temporaria_pmsTGWT extends BaseModel{
  public Tpms_temporaria_pmsTGWT() {
  }

  public int getTmps_nr_id() {
    return  ((Integer)get("tmps_nr_id")).intValue();
//    return get("tmps_nr_id");
  }

  public void setTmps_nr_id(int tmps_nr_id) {
    set("tmps_nr_id", tmps_nr_id);
  }

  public int getPlco_nr_id() {
    return  ((Integer)get("plco_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setObr_nr_id(int obr_nr_id) {
    set("obr_nr_id", obr_nr_id);
  }

  public int getObr_nr_id() {
    return  ((Integer)get("obr_nr_id")).intValue();
//    return get("plco_nr_id");
  }

  public void setPlco_nr_id(int plco_nr_id) {
    set("plco_nr_id", plco_nr_id);
  }

  public double getTpms_nr_quantidade() {
    return  ((Double)get("tpms_nr_quantidade")).doubleValue();

  }

  public void setTpms_nr_quantidade(double tpms_nr_quantidade) {
    set("tpms_nr_quantidade", tpms_nr_quantidade);
  }

  public boolean getTpms_bl_servico() {
    return ((Boolean)get("tpms_bl_servico")).booleanValue();
//    return get("tpms_bl_servico");
  }

  public void setTpms_bl_servico(boolean tpms_bl_servico) {
    set("tpms_bl_servico", tpms_bl_servico);
  }

  public String getTpms_tx_conta() {
    return get("tpms_tx_conta");
  }

  public void setTpms_tx_conta(String tpms_tx_conta) {
    set("tpms_tx_conta", tpms_tx_conta);
  }


    public  String getTpms_tx_codigo_externo(){
        return get("Tpms_tx_codigo_externo");
    }
    public  void setTpms_tx_codigo_externo(String tpms_tx_codigo_externo){
        set("tpms_tx_codigo_externo",tpms_tx_codigo_externo);
    }

    public String getTpms_tx_unidade(){
        return get("tpms_tx_unidade");
    }
    public void setTpms_tx_unidade(String tpms_tx_unidade){
        set("tpms_tx_unidade", tpms_tx_unidade);
    }

    public double getTpms_nr_quantidade_total(){
        return ((Double) get("tpms_nr_quantidade_total")).doubleValue();
    }
    public void setTpms_nr_quantidade_total(double tpms_nr_quantidade_total){
        set("tpms_nr_quantidade_total",tpms_nr_quantidade_total);
    }

    public double getTpms_nr_quantidade_acumulada_ant(){
        return ((Double) get("tpms_nr_quantidade_acumulada_ant")).doubleValue();
    }
    
    public void setTpms_nr_quantidade_acumulada_ant(double tpms_nr_quantidade_acumulada_ant){
        set("tpms_nr_quantidade_acumulada_ant",tpms_nr_quantidade_acumulada_ant);
    }
    public double getTpms_nr_quantidade_acumulada_atual(){
        return ((Double) get("tpms_nr_quantidade_acumulada_atual")).doubleValue();
    }

    public void setTpms_nr_quantidade_acumulada_atual(double tpms_nr_quantidade_acumulada_atual){
        set("tpms_nr_quantidade_acumulada_atual",tpms_nr_quantidade_acumulada_atual);
    }

    public double getTpms_nr_saldo(){
        return ((Double) get("tpms_nr_saldo")).doubleValue();
    }
    
    public void setTpms_nr_saldo(double tpms_nr_saldo){
        set("tpms_nr_saldo",tpms_nr_saldo);
    }
  public int getIpo_nr_id_super() {
    return  ((Integer)get("ipo_nr_id_super")).intValue();
//    return get("plco_nr_nivel");
  }

  public void setIpo_nr_id_super(int ipo_nr_id_super) {
    set("ipo_nr_id_super", ipo_nr_id_super);
  }

  public int getIpo_nr_id() {
    return  ((Integer)get("ipo_nr_id")).intValue();
  }

  public void setIpo_nr_id(int ipo_nr_id) {
    set("ipo_nr_id", ipo_nr_id);
  }

    public double getTpms_nr_percentAcumuladoMes(){
        return ((Double) get("tpms_nr_percentAcumuladoMes")).doubleValue();
    }

    public void setTpms_nr_percentAcumuladoMes(double tpms_nr_percentAcumuladoMes){
        set("tpms_nr_percentAcumuladoMes",tpms_nr_percentAcumuladoMes);
    }

    public double getTpms_nr_percentAcumuladoPeriodo(){
        return ((Double) get("tpms_nr_percentAcumuladoPeriodo")).doubleValue();
    }

    public void setTpms_nr_percentAcumuladoPeriodo(double tpms_nr_percentAcumuladoPeriodo){
        set("tpms_nr_percentAcumuladoPeriodo",tpms_nr_percentAcumuladoPeriodo);
    }

    public double getTpms_nr_percentAcumuladoSaldo(){
        return ((Double) get("tpms_nr_percentSaldo")).doubleValue();
    }

    public void setTpms_nr_percentSaldo(double tpms_nr_percentSaldo){
        set("tpms_nr_percentSaldo",tpms_nr_percentSaldo);
    }

    public void setTpms_nr_percentual(double tpms_nr_percentual){
        set("tpms_nr_percentual",tpms_nr_percentual);
    }
    public double getTpms_nr_percentual(){
        return((Double)get("tpms_nr_percentual")).doubleValue();
    }

    public void setTpms_nr_oldvalue(double tpms_nr_oldvalue){
        set("tpms_nr_percentual",tpms_nr_oldvalue);
    }
    public double getTpms_nr_oldvalue(){
        return((Double)get("tpms_nr_oldvalue")).doubleValue();
    }
}

