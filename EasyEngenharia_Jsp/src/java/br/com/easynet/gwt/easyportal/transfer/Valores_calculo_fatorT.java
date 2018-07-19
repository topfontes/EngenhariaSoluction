/*     */ package br.com.easynet.gwt.easyportal.transfer;
/*     */ 
/*     */ 
/*     */ public class Valores_calculo_fatorT
/*     */ {
/*     */   private int obr_nr_id;
/*     */   
/*     */   private int plc_nr_id;
/*     */   
/*     */   private int mes;
/*     */   private int ano;
/*     */   private String plc_tx_nome;
/*     */   private String plc_tx_super;
/*     */   private float valor_pago_acumulado;
/*     */   private float valor_apagar_geral;
/*     */   private float valor_comp_periodo;
/*     */   private float valor_comp_mes_anterior;
/*     */   private float valor_est_periodo;
/*     */   private float valor_est_mes_anterior;
/*     */   private float valor_prev_pms_acumulado;
/*     */   private float fator_Atual;
/*     */   private float fator_projetado;
/*     */   
/*     */   public int getPlc_nr_id()
/*     */   {
/*  26 */     return this.plc_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlc_nr_id(int plc_nr_id)
/*     */   {
/*  33 */     this.plc_nr_id = plc_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getValor_pago_acumulado()
/*     */   {
/*  40 */     return this.valor_pago_acumulado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setValor_pago_acumulado(float valor_pago_acumulado)
/*     */   {
/*  47 */     this.valor_pago_acumulado = valor_pago_acumulado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getValor_apagar_geral()
/*     */   {
/*  54 */     return this.valor_apagar_geral;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setValor_apagar_geral(float valor_apagar_geral)
/*     */   {
/*  61 */     this.valor_apagar_geral = valor_apagar_geral;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getValor_comp_periodo()
/*     */   {
/*  68 */     return this.valor_comp_periodo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setValor_comp_periodo(float valor_comp_periodo)
/*     */   {
/*  75 */     this.valor_comp_periodo = valor_comp_periodo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getValor_comp_mes_anterior()
/*     */   {
/*  82 */     return this.valor_comp_mes_anterior;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setValor_comp_mes_anterior(float valor_comp_mes_anterior)
/*     */   {
/*  89 */     this.valor_comp_mes_anterior = valor_comp_mes_anterior;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getValor_est_periodo()
/*     */   {
/*  96 */     return this.valor_est_periodo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setValor_est_periodo(float valor_est_periodo)
/*     */   {
/* 103 */     this.valor_est_periodo = valor_est_periodo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getValor_est_mes_anterior()
/*     */   {
/* 110 */     return this.valor_est_mes_anterior;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setValor_est_mes_anterior(float valor_est_mes_anterior)
/*     */   {
/* 117 */     this.valor_est_mes_anterior = valor_est_mes_anterior;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getValor_prev_pms_acumulado()
/*     */   {
/* 124 */     return this.valor_prev_pms_acumulado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setValor_prev_pms_acumulado(float valor_prev_pms_acumulado)
/*     */   {
/* 131 */     this.valor_prev_pms_acumulado = valor_prev_pms_acumulado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getFator_Atual()
/*     */   {
/* 138 */     return this.fator_Atual;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFator_Atual(float fator_Atual)
/*     */   {
/* 145 */     this.fator_Atual = fator_Atual;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPlc_tx_nome()
/*     */   {
/* 152 */     return this.plc_tx_nome;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlc_tx_nome(String plc_tx_nome)
/*     */   {
/* 159 */     this.plc_tx_nome = plc_tx_nome;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getFator_projetado()
/*     */   {
/* 166 */     return this.fator_projetado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFator_projetado(float fator_projetado)
/*     */   {
/* 173 */     this.fator_projetado = fator_projetado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPlc_tx_super()
/*     */   {
/* 180 */     return this.plc_tx_super;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlc_tx_super(String plc_tx_super)
/*     */   {
/* 187 */     this.plc_tx_super = plc_tx_super;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getObr_nr_id()
/*     */   {
/* 194 */     return this.obr_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_nr_id(int obr_nr_id)
/*     */   {
/* 201 */     this.obr_nr_id = obr_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMes()
/*     */   {
/* 208 */     return this.mes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMes(int mes)
/*     */   {
/* 215 */     this.mes = mes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAno()
/*     */   {
/* 222 */     return this.ano;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAno(int ano)
/*     */   {
/* 229 */     this.ano = ano;
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Valores_calculo_fatorT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */