package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Par_parcelamentoT { 
	 private int par_nr_id;
	 private String par_tx_nome;
	 private int par_nr_parcelas;
	 private int par_nr_intervalo_dias;
	 public void setPar_nr_id(int par_nr_id) {
		 this.par_nr_id=par_nr_id;
	}
 
	 public int getPar_nr_id() {
		 return par_nr_id;
 	} 
 	 public void setPar_tx_nome(String par_tx_nome) {
		 this.par_tx_nome=par_tx_nome;
	}
 
	 public String getPar_tx_nome() {
		 return par_tx_nome;
 	} 
 	 public void setPar_nr_parcelas(int par_nr_parcelas) {
		 this.par_nr_parcelas=par_nr_parcelas;
	}
 
	 public int getPar_nr_parcelas() {
		 return par_nr_parcelas;
 	} 
 	 public void setPar_nr_intervalo_dias(int par_nr_intervalo_dias) {
		 this.par_nr_intervalo_dias=par_nr_intervalo_dias;
	}
 
	 public int getPar_nr_intervalo_dias() {
		 return par_nr_intervalo_dias;
 	} 
 }