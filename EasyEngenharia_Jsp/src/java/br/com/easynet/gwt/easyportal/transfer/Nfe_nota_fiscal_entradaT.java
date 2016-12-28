package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Nfe_nota_fiscal_entradaT { 
	 private int nfe_nr_id;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date nfe_dt_emissao;
	 private int for_nr_id;
	 private float nfe_nr_valor_nota;
	 public void setNfe_nr_id(int nfe_nr_id) {
		 this.nfe_nr_id=nfe_nr_id;
	}
 
	 public int getNfe_nr_id() {
		 return nfe_nr_id;
 	} 
 	 public void setNfe_dt_emissao(java.util.Date nfe_dt_emissao) {
		 this.nfe_dt_emissao=nfe_dt_emissao;
	}
 
	 public java.util.Date getNfe_dt_emissao() {
		 return nfe_dt_emissao;
 	} 
 	 public void setFor_nr_id(int for_nr_id) {
		 this.for_nr_id=for_nr_id;
	}
 
	 public int getFor_nr_id() {
		 return for_nr_id;
 	} 
 	 public void setNfe_nr_valor_nota(float nfe_nr_valor_nota) {
		 this.nfe_nr_valor_nota=nfe_nr_valor_nota;
	}
 
	 public float getNfe_nr_valor_nota() {
		 return nfe_nr_valor_nota;
 	} 
 }