/*    */ package br.com.easynet.gwt.easyportal.transfer;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Pro_programacaoT {
/*    */   private int pro_nr_id;
/*    */   private int obr_nr_id;
/*    */   private int pro_nr_mes;
/*    */   private int pro_nr_ano;
/*    */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*    */   private Date pro_dt_coleta_orcamento;
/*    */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*    */   private Date pro_dt_coleta_rh;
/*    */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*    */   private Date pro_dt_analise_inicio;
/*    */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*    */   private Date pro_dt_analise_final;
/*    */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*    */   private Date pro_dt_reuniao_engenharia;
/*    */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*    */   private Date pro_dt_reuniao_diretoria;
/*    */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*    */   private Date pro_dt_reuniao_geral;
/*    */   
/* 25 */   public void setPro_nr_id(int pro_nr_id) { this.pro_nr_id = pro_nr_id; }
/*    */   
/*    */   public int getPro_nr_id()
/*    */   {
/* 29 */     return this.pro_nr_id;
/*    */   }
/*    */   
/* 32 */   public void setObr_nr_id(int obr_nr_id) { this.obr_nr_id = obr_nr_id; }
/*    */   
/*    */   public int getObr_nr_id()
/*    */   {
/* 36 */     return this.obr_nr_id;
/*    */   }
/*    */   
/* 39 */   public void setPro_nr_mes(int pro_nr_mes) { this.pro_nr_mes = pro_nr_mes; }
/*    */   
/*    */   public int getPro_nr_mes()
/*    */   {
/* 43 */     return this.pro_nr_mes;
/*    */   }
/*    */   
/* 46 */   public void setPro_nr_ano(int pro_nr_ano) { this.pro_nr_ano = pro_nr_ano; }
/*    */   
/*    */   public int getPro_nr_ano()
/*    */   {
/* 50 */     return this.pro_nr_ano;
/*    */   }
/*    */   
/* 53 */   public void setPro_dt_coleta_orcamento(Date pro_dt_coleta_orcamento) { this.pro_dt_coleta_orcamento = pro_dt_coleta_orcamento; }
/*    */   
/*    */   public Date getPro_dt_coleta_orcamento()
/*    */   {
/* 57 */     return this.pro_dt_coleta_orcamento;
/*    */   }
/*    */   
/* 60 */   public void setPro_dt_coleta_rh(Date pro_dt_coleta_rh) { this.pro_dt_coleta_rh = pro_dt_coleta_rh; }
/*    */   
/*    */   public Date getPro_dt_coleta_rh()
/*    */   {
/* 64 */     return this.pro_dt_coleta_rh;
/*    */   }
/*    */   
/* 67 */   public void setPro_dt_analise_inicio(Date pro_dt_analise_inicio) { this.pro_dt_analise_inicio = pro_dt_analise_inicio; }
/*    */   
/*    */   public Date getPro_dt_analise_inicio()
/*    */   {
/* 71 */     return this.pro_dt_analise_inicio;
/*    */   }
/*    */   
/* 74 */   public void setPro_dt_analise_final(Date pro_dt_analise_final) { this.pro_dt_analise_final = pro_dt_analise_final; }
/*    */   
/*    */   public Date getPro_dt_analise_final()
/*    */   {
/* 78 */     return this.pro_dt_analise_final;
/*    */   }
/*    */   
/* 81 */   public void setPro_dt_reuniao_engenharia(Date pro_dt_reuniao_engenharia) { this.pro_dt_reuniao_engenharia = pro_dt_reuniao_engenharia; }
/*    */   
/*    */   public Date getPro_dt_reuniao_engenharia()
/*    */   {
/* 85 */     return this.pro_dt_reuniao_engenharia;
/*    */   }
/*    */   
/* 88 */   public void setPro_dt_reuniao_diretoria(Date pro_dt_reuniao_diretoria) { this.pro_dt_reuniao_diretoria = pro_dt_reuniao_diretoria; }
/*    */   
/*    */   public Date getPro_dt_reuniao_diretoria()
/*    */   {
/* 92 */     return this.pro_dt_reuniao_diretoria;
/*    */   }
/*    */   
/* 95 */   public void setPro_dt_reuniao_geral(Date pro_dt_reuniao_geral) { this.pro_dt_reuniao_geral = pro_dt_reuniao_geral; }
/*    */   
/*    */   public Date getPro_dt_reuniao_geral()
/*    */   {
/* 99 */     return this.pro_dt_reuniao_geral;
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Pro_programacaoT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */