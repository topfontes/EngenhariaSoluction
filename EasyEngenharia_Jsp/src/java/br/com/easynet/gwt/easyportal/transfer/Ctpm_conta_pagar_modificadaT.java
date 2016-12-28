package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Ctpm_conta_pagar_modificadaT { 
	 private int ctpm_nr_id;
	 private int obr_nr_id;
	 private int ctp_nr_id;
	 private int ctpm_nr_mes;
	 private int ctpm_nr_ano;
	 private String ctpm_tx_tipo;
	 public void setCtpm_nr_id(int ctpm_nr_id) {
		 this.ctpm_nr_id=ctpm_nr_id;
	}
 
	 public int getCtpm_nr_id() {
		 return ctpm_nr_id;
 	} 
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setCtp_nr_id(int ctp_nr_id) {
		 this.ctp_nr_id=ctp_nr_id;
	}
 
	 public int getCtp_nr_id() {
		 return ctp_nr_id;
 	} 
 	 public void setCtpm_nr_mes(int ctpm_nr_mes) {
		 this.ctpm_nr_mes=ctpm_nr_mes;
	}
 
	 public int getCtpm_nr_mes() {
		 return ctpm_nr_mes;
 	} 
 	 public void setCtpm_nr_ano(int ctpm_nr_ano) {
		 this.ctpm_nr_ano=ctpm_nr_ano;
	}
 
	 public int getCtpm_nr_ano() {
		 return ctpm_nr_ano;
 	} 
 	 public void setCtpm_tx_tipo(String ctpm_tx_tipo) {
		 this.ctpm_tx_tipo=ctpm_tx_tipo;
	}
 
	 public String getCtpm_tx_tipo() {
		 return ctpm_tx_tipo;
 	} 
 }