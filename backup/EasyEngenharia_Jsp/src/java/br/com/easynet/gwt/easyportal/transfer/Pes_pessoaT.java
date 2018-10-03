package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Pes_pessoaT { 
	 private int pes_nr_id;
	 private String pes_tx_nome;
	 private String pes_tx_fone;
	 public void setPes_nr_id(int pes_nr_id) {
		 this.pes_nr_id=pes_nr_id;
	}
 
	 public int getPes_nr_id() {
		 return pes_nr_id;
 	} 
 	 public void setPes_tx_nome(String pes_tx_nome) {
		 this.pes_tx_nome=pes_tx_nome;
	}
 
	 public String getPes_tx_nome() {
		 return pes_tx_nome;
 	} 
 	 public void setPes_tx_fone(String pes_tx_fone) {
		 this.pes_tx_fone=pes_tx_fone;
	}
 
	 public String getPes_tx_fone() {
		 return pes_tx_fone;
 	} 
 }