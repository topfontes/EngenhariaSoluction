/*     */ package br.com.easynet.gwt.easyportal.transfer;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Rep_resumo_planejamentoT
/*     */ {
/*     */   private int rep_nr_id;
/*     */   private int obr_nr_id;
/*     */   private int rep_nr_mes;
/*     */   private int rep_nr_ano;
/*     */   private String rep_tx_etapa;
/*     */   private String rep_tx_local;
/*     */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date rep_dt_termino_banco;
/*     */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date rep_dt_termino_cliente;
/*     */   private float rep_nr_duracao_linha_base;
/*     */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date rep_dt_inicio_linha_base;
/*     */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date rep_dt_termino_linha_base;
/*     */   private float rep_nr_duracao;
/*     */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date rep_dt_inicio;
/*     */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date rep_dt_termino;
/*     */   private float rep_nr_trab_acum_realizado;
/*     */   private float rep_nr_trab_acum_previsto;
/*     */   
/*     */   public void setRep_nr_id(int rep_nr_id) {
/*  31 */     this.rep_nr_id = rep_nr_id;
/*     */   }
/*     */   
/*     */   public int getRep_nr_id() {
/*  35 */     return this.rep_nr_id;
/*     */   }
/*     */   
/*     */   public void setObr_nr_id(int obr_nr_id) {
/*  39 */     this.obr_nr_id = obr_nr_id;
/*     */   }
/*     */   
/*     */   public int getObr_nr_id() {
/*  43 */     return this.obr_nr_id;
/*     */   }
/*     */   
/*     */   public void setRep_nr_mes(int rep_nr_mes) {
/*  47 */     this.rep_nr_mes = rep_nr_mes;
/*     */   }
/*     */   
/*     */   public int getRep_nr_mes() {
/*  51 */     return this.rep_nr_mes;
/*     */   }
/*     */   
/*     */   public void setRep_nr_ano(int rep_nr_ano) {
/*  55 */     this.rep_nr_ano = rep_nr_ano;
/*     */   }
/*     */   
/*     */   public int getRep_nr_ano() {
/*  59 */     return this.rep_nr_ano;
/*     */   }
/*     */   
/*     */   public void setRep_tx_etapa(String rep_tx_etapa) {
/*  63 */     this.rep_tx_etapa = rep_tx_etapa;
/*     */   }
/*     */   
/*     */   public String getRep_tx_etapa() {
/*  67 */     return this.rep_tx_etapa;
/*     */   }
/*     */   
/*     */   public void setRep_tx_local(String rep_tx_local) {
/*  71 */     this.rep_tx_local = rep_tx_local;
/*     */   }
/*     */   
/*     */   public String getRep_tx_local() {
/*  75 */     return this.rep_tx_local;
/*     */   }
/*     */   
/*     */   public void setRep_dt_termino_banco(Date rep_dt_termino_banco) {
/*  79 */     this.rep_dt_termino_banco = rep_dt_termino_banco;
/*     */   }
/*     */   
/*     */   public Date getRep_dt_termino_banco() {
/*  83 */     return this.rep_dt_termino_banco;
/*     */   }
/*     */   
/*     */   public void setRep_dt_termino_cliente(Date rep_dt_termino_cliente) {
/*  87 */     this.rep_dt_termino_cliente = rep_dt_termino_cliente;
/*     */   }
/*     */   
/*     */   public Date getRep_dt_termino_cliente() {
/*  91 */     return this.rep_dt_termino_cliente;
/*     */   }
/*     */   
/*     */   public void setRep_nr_duracao_linha_base(float rep_nr_duracao_linha_base) {
/*  95 */     this.rep_nr_duracao_linha_base = rep_nr_duracao_linha_base;
/*     */   }
/*     */   
/*     */   public float getRep_nr_duracao_linha_base() {
/*  99 */     return this.rep_nr_duracao_linha_base;
/*     */   }
/*     */   
/*     */   public void setRep_dt_inicio_linha_base(Date rep_dt_inicio_linha_base) {
/* 103 */     this.rep_dt_inicio_linha_base = rep_dt_inicio_linha_base;
/*     */   }
/*     */   
/*     */   public Date getRep_dt_inicio_linha_base() {
/* 107 */     return this.rep_dt_inicio_linha_base;
/*     */   }
/*     */   
/*     */   public void setRep_dt_termino_linha_base(Date rep_dt_termino_linha_base) {
/* 111 */     this.rep_dt_termino_linha_base = rep_dt_termino_linha_base;
/*     */   }
/*     */   
/*     */   public Date getRep_dt_termino_linha_base() {
/* 115 */     return this.rep_dt_termino_linha_base;
/*     */   }
/*     */   
/*     */   public void setRep_nr_duracao(float rep_nr_duracao) {
/* 119 */     this.rep_nr_duracao = rep_nr_duracao;
/*     */   }
/*     */   
/*     */   public float getRep_nr_duracao() {
/* 123 */     return this.rep_nr_duracao;
/*     */   }
/*     */   
/*     */   public void setRep_dt_inicio(Date rep_dt_inicio) {
/* 127 */     this.rep_dt_inicio = rep_dt_inicio;
/*     */   }
/*     */   
/*     */   public Date getRep_dt_inicio() {
/* 131 */     return this.rep_dt_inicio;
/*     */   }
/*     */   
/*     */   public void setRep_dt_termino(Date rep_dt_termino) {
/* 135 */     this.rep_dt_termino = rep_dt_termino;
/*     */   }
/*     */   
/*     */   public Date getRep_dt_termino() {
/* 139 */     return this.rep_dt_termino;
/*     */   }
/*     */   
/*     */   public void setRep_nr_trab_acum_realizado(float rep_nr_trab_acum_realizado) {
/* 143 */     this.rep_nr_trab_acum_realizado = rep_nr_trab_acum_realizado;
/*     */   }
/*     */   
/*     */   public float getRep_nr_trab_acum_realizado() {
/* 147 */     return this.rep_nr_trab_acum_realizado;
/*     */   }
/*     */   
/*     */   public void setRep_nr_trab_acum_previsto(float rep_nr_trab_acum_previsto) {
/* 151 */     this.rep_nr_trab_acum_previsto = rep_nr_trab_acum_previsto;
/*     */   }
/*     */   
/*     */   public float getRep_nr_trab_acum_previsto() {
/* 155 */     return this.rep_nr_trab_acum_previsto;
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Rep_resumo_planejamentoT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */