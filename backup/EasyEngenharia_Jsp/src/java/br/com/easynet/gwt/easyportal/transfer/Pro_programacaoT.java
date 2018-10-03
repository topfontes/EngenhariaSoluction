package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;
//br.com.easynet.gwt.easyportal.transfer.Pro_programacaoT
public class Pro_programacaoT { 
	 private int pro_nr_id;
	 private int obr_nr_id;
	 private int pro_nr_mes;
	 private int pro_nr_ano;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date pro_dt_coleta_orcamento;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date pro_dt_coleta_rh;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date pro_dt_analise_inicio;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date pro_dt_analise_final;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date pro_dt_reuniao_engenharia;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date pro_dt_reuniao_diretoria;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date pro_dt_reuniao_geral;
	 public void setPro_nr_id(int pro_nr_id) {
		 this.pro_nr_id=pro_nr_id;
	}
 
	 public int getPro_nr_id() {
		 return pro_nr_id;
 	} 
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setPro_nr_mes(int pro_nr_mes) {
		 this.pro_nr_mes=pro_nr_mes;
	}
 
	 public int getPro_nr_mes() {
		 return pro_nr_mes;
 	} 
 	 public void setPro_nr_ano(int pro_nr_ano) {
		 this.pro_nr_ano=pro_nr_ano;
	}
 
	 public int getPro_nr_ano() {
		 return pro_nr_ano;
 	} 
 	 public void setPro_dt_coleta_orcamento(java.util.Date pro_dt_coleta_orcamento) {
		 this.pro_dt_coleta_orcamento=pro_dt_coleta_orcamento;
	}
 
	 public java.util.Date getPro_dt_coleta_orcamento() {
		 return pro_dt_coleta_orcamento;
 	} 
 	 public void setPro_dt_coleta_rh(java.util.Date pro_dt_coleta_rh) {
		 this.pro_dt_coleta_rh=pro_dt_coleta_rh;
	}
 
	 public java.util.Date getPro_dt_coleta_rh() {
		 return pro_dt_coleta_rh;
 	} 
 	 public void setPro_dt_analise_inicio(java.util.Date pro_dt_analise_inicio) {
		 this.pro_dt_analise_inicio=pro_dt_analise_inicio;
	}
 
	 public java.util.Date getPro_dt_analise_inicio() {
		 return pro_dt_analise_inicio;
 	} 
 	 public void setPro_dt_analise_final(java.util.Date pro_dt_analise_final) {
		 this.pro_dt_analise_final=pro_dt_analise_final;
	}
 
	 public java.util.Date getPro_dt_analise_final() {
		 return pro_dt_analise_final;
 	} 
 	 public void setPro_dt_reuniao_engenharia(java.util.Date pro_dt_reuniao_engenharia) {
		 this.pro_dt_reuniao_engenharia=pro_dt_reuniao_engenharia;
	}
 
	 public java.util.Date getPro_dt_reuniao_engenharia() {
		 return pro_dt_reuniao_engenharia;
 	} 
 	 public void setPro_dt_reuniao_diretoria(java.util.Date pro_dt_reuniao_diretoria) {
		 this.pro_dt_reuniao_diretoria=pro_dt_reuniao_diretoria;
	}
 
	 public java.util.Date getPro_dt_reuniao_diretoria() {
		 return pro_dt_reuniao_diretoria;
 	} 
 	 public void setPro_dt_reuniao_geral(java.util.Date pro_dt_reuniao_geral) {
		 this.pro_dt_reuniao_geral=pro_dt_reuniao_geral;
	}
 
	 public java.util.Date getPro_dt_reuniao_geral() {
		 return pro_dt_reuniao_geral;
 	} 
 }