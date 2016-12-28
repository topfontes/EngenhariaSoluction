package br.com.easynet.gwt.easyportal.client.transfer;

import br.com.easynet.annotation.Conversion;

public class Vw_cffo_mesT { 
	 private int obr_nr_id;
	 private int cffo_nr_mes;
	 private int cffo_nr_ano;
	 private double total;
	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setCffo_nr_mes(int cffo_nr_mes) {
		 this.cffo_nr_mes=cffo_nr_mes;
	}
 
	 public int getCffo_nr_mes() {
		 return cffo_nr_mes;
 	} 
 	 public void setCffo_nr_ano(int cffo_nr_ano) {
		 this.cffo_nr_ano=cffo_nr_ano;
	}
 
	 public int getCffo_nr_ano() {
		 return cffo_nr_ano;
 	} 
 	 public void setTotal(double total) {
		 this.total=total;
	}
 
	 public double getTotal() {
		 return total;
 	} 
 }