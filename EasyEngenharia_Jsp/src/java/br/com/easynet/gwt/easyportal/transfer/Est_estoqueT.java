/*     */ package br.com.easynet.gwt.easyportal.transfer;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Est_estoqueT {
/*     */   private int est_nr_id;
/*     */   private int est_nr_mes;
/*     */   private int plc_nr_id;
/*     */   private float est_nr_quantidade;
/*     */   private float est_nr_vl_unitario;
/*     */   private float est_nr_vl_total;
/*     */   private String est_tx_unidade;
/*     */   private int obr_nr_id;
/*     */   private int est_nr_ano;
/*     */   private String est_tx_key;
/*     */   private String est_tx_nome;
/*     */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date est_dt_base;
/*     */   
/*     */   public void setEst_nr_id(int est_nr_id) {
/*  21 */     this.est_nr_id = est_nr_id;
/*     */   }
/*     */   
/*     */   public int getEst_nr_id() {
/*  25 */     return this.est_nr_id;
/*     */   }
/*     */   
/*  28 */   public void setEst_nr_mes(int est_nr_mes) { this.est_nr_mes = est_nr_mes; }
/*     */   
/*     */   public int getEst_nr_mes()
/*     */   {
/*  32 */     return this.est_nr_mes;
/*     */   }
/*     */   
/*  35 */   public void setPlc_nr_id(int plc_nr_id) { this.plc_nr_id = plc_nr_id; }
/*     */   
/*     */   public int getPlc_nr_id()
/*     */   {
/*  39 */     return this.plc_nr_id;
/*     */   }
/*     */   
/*  42 */   public void setEst_nr_quantidade(float est_nr_quantidade) { this.est_nr_quantidade = est_nr_quantidade; }
/*     */   
/*     */   public float getEst_nr_quantidade()
/*     */   {
/*  46 */     return this.est_nr_quantidade;
/*     */   }
/*     */   
/*  49 */   public void setEst_nr_vl_unitario(float est_nr_vl_unitario) { this.est_nr_vl_unitario = est_nr_vl_unitario; }
/*     */   
/*     */   public float getEst_nr_vl_unitario()
/*     */   {
/*  53 */     return this.est_nr_vl_unitario;
/*     */   }
/*     */   
/*  56 */   public void setEst_nr_vl_total(float est_nr_vl_total) { this.est_nr_vl_total = est_nr_vl_total; }
/*     */   
/*     */   public float getEst_nr_vl_total()
/*     */   {
/*  60 */     return this.est_nr_vl_total;
/*     */   }
/*     */   
/*  63 */   public void setObr_nr_id(int obr_nr_id) { this.obr_nr_id = obr_nr_id; }
/*     */   
/*     */   public int getObr_nr_id()
/*     */   {
/*  67 */     return this.obr_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getEst_nr_ano()
/*     */   {
/*  74 */     return this.est_nr_ano;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEst_nr_ano(int est_nr_ano)
/*     */   {
/*  81 */     this.est_nr_ano = est_nr_ano;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getEst_tx_unidade()
/*     */   {
/*  88 */     return this.est_tx_unidade;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEst_tx_unidade(String est_tx_unidade)
/*     */   {
/*  95 */     this.est_tx_unidade = est_tx_unidade;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEst_dt_base()
/*     */   {
/* 102 */     return this.est_dt_base;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEst_dt_base(Date est_dt_base)
/*     */   {
/* 109 */     this.est_dt_base = est_dt_base;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getEst_tx_key()
/*     */   {
/* 116 */     return this.est_tx_key;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEst_tx_key(String est_tx_key)
/*     */   {
/* 123 */     this.est_tx_key = est_tx_key;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getEst_tx_nome()
/*     */   {
/* 130 */     return this.est_tx_nome;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEst_tx_nome(String est_tx_nome)
/*     */   {
/* 137 */     this.est_tx_nome = est_tx_nome;
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Est_estoqueT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */