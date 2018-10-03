/*     */ package br.com.easynet.gwt.easyportal.transfer;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Inc_informacoes_custoT {
/*     */   private int inc_nr_id;
/*     */   private int obr_nr_id;
/*     */   private int inc_nr_mes;
/*     */   private int inc_nr_ano;
/*     */   private int plc_nr_id;
/*     */   private float inc_tx_custo_acumulado;
/*     */   private float inc_nr_custo_periodo;
/*     */   private String inc_tx_calsas;
/*     */   private String inc_tx_problemas;
/*     */   private String inc_tx_acoes;
/*     */   private String inc_tx_responsavel;
/*     */   private String inc_tx_custo_eco_excede_periodo;
/*     */   private String inc_tx_custo_eco_excede_acum;
/*     */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date inc_dt_prazo;
/*     */   
/*  22 */   public void setInc_nr_id(int inc_nr_id) { this.inc_nr_id = inc_nr_id; }
/*     */   
/*     */   public int getInc_nr_id()
/*     */   {
/*  26 */     return this.inc_nr_id;
/*     */   }
/*     */   
/*  29 */   public void setObr_nr_id(int obr_nr_id) { this.obr_nr_id = obr_nr_id; }
/*     */   
/*     */   public int getObr_nr_id()
/*     */   {
/*  33 */     return this.obr_nr_id;
/*     */   }
/*     */   
/*  36 */   public void setInc_nr_mes(int inc_nr_mes) { this.inc_nr_mes = inc_nr_mes; }
/*     */   
/*     */   public int getInc_nr_mes()
/*     */   {
/*  40 */     return this.inc_nr_mes;
/*     */   }
/*     */   
/*  43 */   public void setInc_nr_ano(int inc_nr_ano) { this.inc_nr_ano = inc_nr_ano; }
/*     */   
/*     */   public int getInc_nr_ano()
/*     */   {
/*  47 */     return this.inc_nr_ano;
/*     */   }
/*     */   
/*  50 */   public void setPlc_nr_id(int plc_nr_id) { this.plc_nr_id = plc_nr_id; }
/*     */   
/*     */   public int getPlc_nr_id()
/*     */   {
/*  54 */     return this.plc_nr_id;
/*     */   }
/*     */   
/*  57 */   public void setInc_tx_custo_acumulado(float inc_tx_custo_acumulado) { this.inc_tx_custo_acumulado = inc_tx_custo_acumulado; }
/*     */   
/*     */   public float getInc_tx_custo_acumulado()
/*     */   {
/*  61 */     return this.inc_tx_custo_acumulado;
/*     */   }
/*     */   
/*  64 */   public void setInc_nr_custo_periodo(float inc_nr_custo_periodo) { this.inc_nr_custo_periodo = inc_nr_custo_periodo; }
/*     */   
/*     */   public float getInc_nr_custo_periodo()
/*     */   {
/*  68 */     return this.inc_nr_custo_periodo;
/*     */   }
/*     */   
/*  71 */   public void setInc_tx_calsas(String inc_tx_calsas) { this.inc_tx_calsas = inc_tx_calsas; }
/*     */   
/*     */   public String getInc_tx_calsas()
/*     */   {
/*  75 */     return this.inc_tx_calsas;
/*     */   }
/*     */   
/*  78 */   public void setInc_tx_problemas(String inc_tx_problemas) { this.inc_tx_problemas = inc_tx_problemas; }
/*     */   
/*     */   public String getInc_tx_problemas()
/*     */   {
/*  82 */     return this.inc_tx_problemas;
/*     */   }
/*     */   
/*  85 */   public void setInc_tx_acoes(String inc_tx_acoes) { this.inc_tx_acoes = inc_tx_acoes; }
/*     */   
/*     */   public String getInc_tx_acoes()
/*     */   {
/*  89 */     return this.inc_tx_acoes;
/*     */   }
/*     */   
/*  92 */   public void setInc_tx_responsavel(String inc_tx_responsavel) { this.inc_tx_responsavel = inc_tx_responsavel; }
/*     */   
/*     */   public String getInc_tx_responsavel()
/*     */   {
/*  96 */     return this.inc_tx_responsavel;
/*     */   }
/*     */   
/*  99 */   public void setInc_dt_prazo(Date inc_dt_prazo) { this.inc_dt_prazo = inc_dt_prazo; }
/*     */   
/*     */   public Date getInc_dt_prazo()
/*     */   {
/* 103 */     return this.inc_dt_prazo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getInc_tx_custo_eco_excede_periodo()
/*     */   {
/* 110 */     return this.inc_tx_custo_eco_excede_periodo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInc_tx_custo_eco_excede_periodo(String inc_tx_custo_eco_excede_periodo)
/*     */   {
/* 117 */     this.inc_tx_custo_eco_excede_periodo = inc_tx_custo_eco_excede_periodo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getInc_tx_custo_eco_excede_acum()
/*     */   {
/* 124 */     return this.inc_tx_custo_eco_excede_acum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInc_tx_custo_eco_excede_acum(String inc_tx_custo_eco_excede_acum)
/*     */   {
/* 131 */     this.inc_tx_custo_eco_excede_acum = inc_tx_custo_eco_excede_acum;
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Inc_informacoes_custoT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */