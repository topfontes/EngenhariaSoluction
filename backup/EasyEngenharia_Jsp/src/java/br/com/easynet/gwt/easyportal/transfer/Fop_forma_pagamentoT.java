package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Fop_forma_pagamentoT { 
	 private int fop_nr_id;
	 private String fop_tx_nome;
	 private String fop_tx_avista;
	 public void setFop_nr_id(int fop_nr_id) {
		 this.fop_nr_id=fop_nr_id;
	}
 
	 public int getFop_nr_id() {
		 return fop_nr_id;
 	} 
 	 public void setFop_tx_nome(String fop_tx_nome) {
		 this.fop_tx_nome=fop_tx_nome;
	}
 
	 public String getFop_tx_nome() {
		 return fop_tx_nome;
 	} 
 	 public void setFop_tx_avista(String fop_tx_avista) {
		 this.fop_tx_avista=fop_tx_avista;
	}
 
	 public String getFop_tx_avista() {
		 return fop_tx_avista;
 	} 
 }