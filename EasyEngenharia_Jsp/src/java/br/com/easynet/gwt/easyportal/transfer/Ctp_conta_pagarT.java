/*     */ package br.com.easynet.gwt.easyportal.transfer;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Ctp_conta_pagarT {
/*     */   private int ctp_nr_id;
/*     */   private String ctp_tx_fornecedor;
/*     */   private int ctp_nr_mes;
/*     */   private int plc_nr_id;
/*     */   private double ctp_nr_valor;
/*     */   private String ctp_nr_documento;
/*     */   private String ctp_tx_status;
/*     */   private int obr_nr_id;
/*     */   private int ctp_nr_ano;
/*     */   private String ctp_tx_obs;
/*     */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date ctp_dt_vencimento;
/*     */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date ctp_dt_emissao;
/*     */   
/*     */   public void setCtp_nr_id(int ctp_nr_id) {
/*  22 */     this.ctp_nr_id = ctp_nr_id;
/*     */   }
/*     */   
/*     */   public int getCtp_nr_id() {
/*  26 */     return this.ctp_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCtp_tx_fornecedor(String ctp_tx_fornecedor)
/*     */   {
/*  37 */     this.ctp_tx_fornecedor = ctp_tx_fornecedor.replace("€", "Ç");
/*     */   }
/*     */   
/*     */   public String getCtp_tx_fornecedor() {
/*  41 */     return this.ctp_tx_fornecedor;
/*     */   }
/*     */   
/*     */   public void setCtp_nr_mes(int ctp_nr_mes) {
/*  45 */     this.ctp_nr_mes = ctp_nr_mes;
/*     */   }
/*     */   
/*     */   public int getCtp_nr_mes() {
/*  49 */     return this.ctp_nr_mes;
/*     */   }
/*     */   
/*  52 */   public void setPlc_nr_id(int plc_nr_id) { this.plc_nr_id = plc_nr_id; }
/*     */   
/*     */   public int getPlc_nr_id()
/*     */   {
/*  56 */     return this.plc_nr_id;
/*     */   }
/*     */   
/*  59 */   public void setCtp_nr_valor(double ctp_nr_valor) { this.ctp_nr_valor = ctp_nr_valor; }
/*     */   
/*     */   public double getCtp_nr_valor()
/*     */   {
/*  63 */     return this.ctp_nr_valor;
/*     */   }
/*     */   
/*  66 */   public void setCtp_nr_documento(String ctp_nr_documento) { this.ctp_nr_documento = ctp_nr_documento; }
/*     */   
/*     */   public String getCtp_nr_documento()
/*     */   {
/*  70 */     return this.ctp_nr_documento;
/*     */   }
/*     */   
/*  73 */   public void setCtp_tx_status(String ctp_tx_status) { this.ctp_tx_status = ctp_tx_status; }
/*     */   
/*     */   public String getCtp_tx_status()
/*     */   {
/*  77 */     return this.ctp_tx_status;
/*     */   }
/*     */   
/*  80 */   public void setObr_nr_id(int obr_nr_id) { this.obr_nr_id = obr_nr_id; }
/*     */   
/*     */   public int getObr_nr_id()
/*     */   {
/*  84 */     return this.obr_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCtp_nr_ano()
/*     */   {
/*  91 */     return this.ctp_nr_ano;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCtp_nr_ano(int ctp_nr_ano)
/*     */   {
/*  98 */     this.ctp_nr_ano = ctp_nr_ano;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCtp_tx_obs()
/*     */   {
/* 105 */     return this.ctp_tx_obs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCtp_tx_obs(String ctp_tx_obs)
/*     */   {
/* 112 */     this.ctp_tx_obs = ctp_tx_obs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCtp_dt_vencimento()
/*     */   {
/* 119 */     return this.ctp_dt_vencimento;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCtp_dt_vencimento(Date ctp_dt_vencimento)
/*     */   {
/* 126 */     this.ctp_dt_vencimento = ctp_dt_vencimento;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCtp_dt_emissao()
/*     */   {
/* 133 */     return this.ctp_dt_emissao;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCtp_dt_emissao(Date ctp_dt_emissao)
/*     */   {
/* 140 */     this.ctp_dt_emissao = ctp_dt_emissao;
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Ctp_conta_pagarT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */