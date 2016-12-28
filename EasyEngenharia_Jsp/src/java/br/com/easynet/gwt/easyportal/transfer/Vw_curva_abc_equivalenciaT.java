package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Vw_curva_abc_equivalenciaT { 
	 private int obr_nr_id;
	 private int plc_nr_id;
	 private String plc_tx_nome;
	 private float total;
	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setPlc_nr_id(int plc_nr_id) {
		 this.plc_nr_id=plc_nr_id;
	}
 
	 public int getPlc_nr_id() {
		 return plc_nr_id;
 	} 
 	 public void setPlc_tx_nome(String plc_tx_nome) {
		 this.plc_tx_nome=plc_tx_nome;
	}
 
	 public String getPlc_tx_nome() {
		 return plc_tx_nome;
 	} 
 	 public void setTotal(float total) {
		 this.total=total;
	}
 
	 public float getTotal() {
		 return total;
 	} 
 }