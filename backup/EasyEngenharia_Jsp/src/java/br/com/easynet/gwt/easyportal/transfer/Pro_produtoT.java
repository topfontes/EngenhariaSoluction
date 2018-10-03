package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Pro_produtoT { 
	 private int pro_nr_id;
	 private String pro_tx_nome;
	 private int grp_nr_id;
	 public void setPro_nr_id(int pro_nr_id) {
		 this.pro_nr_id=pro_nr_id;
	}
 
	 public int getPro_nr_id() {
		 return pro_nr_id;
 	} 
 	 public void setPro_tx_nome(String pro_tx_nome) {
		 this.pro_tx_nome=pro_tx_nome;
	}
 
	 public String getPro_tx_nome() {
		 return pro_tx_nome;
 	} 
 	 public void setGrp_nr_id(int grp_nr_id) {
		 this.grp_nr_id=grp_nr_id;
	}
 
	 public int getGrp_nr_id() {
		 return grp_nr_id;
 	} 
 }