package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Vw_curva_abcT { 
	 private int obr_nr_id;
	 private String obr_tx_nome;
	 private int plco_nr_id;
	 private String plco_tx_nome;
	 private float total;
	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setObr_tx_nome(String obr_tx_nome) {
		 this.obr_tx_nome=obr_tx_nome;
	}
 
	 public String getObr_tx_nome() {
		 return obr_tx_nome;
 	} 
 	 public void setPlco_nr_id(int plco_nr_id) {
		 this.plco_nr_id=plco_nr_id;
	}
 
	 public int getPlco_nr_id() {
		 return plco_nr_id;
 	} 
 	 public void setPlco_tx_nome(String plco_tx_nome) {
		 this.plco_tx_nome=plco_tx_nome;
	}
 
	 public String getPlco_tx_nome() {
		 return plco_tx_nome;
 	} 
 	 public void setTotal(float total) {
		 this.total=total;
	}
 
	 public float getTotal() {
		 return total;
 	} 
 }