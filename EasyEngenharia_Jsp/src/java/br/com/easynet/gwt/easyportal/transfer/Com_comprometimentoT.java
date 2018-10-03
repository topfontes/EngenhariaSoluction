/*    */ package br.com.easynet.gwt.easyportal.transfer;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Com_comprometimentoT
/*    */ {
/*    */   private int com_nr_id;
/*    */   private int plc_nr_id;
/*    */   private double com_nr_valor;
/*    */   private int obr_nr_id;
/*    */   private int com_nr_mes;
/*    */   private int com_nr_ano;
/*    */   private boolean previsto;
/*    */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*    */   private Date com_dt_base;
/*    */   
/*    */   public void setCom_nr_id(int com_nr_id)
/*    */   {
/* 19 */     this.com_nr_id = com_nr_id;
/*    */   }
/*    */   
/*    */   public int getCom_nr_id() {
/* 23 */     return this.com_nr_id;
/*    */   }
/*    */   
/*    */   public void setPlc_nr_id(int plc_nr_id) {
/* 27 */     this.plc_nr_id = plc_nr_id;
/*    */   }
/*    */   
/*    */   public int getPlc_nr_id() {
/* 31 */     return this.plc_nr_id;
/*    */   }
/*    */   
/*    */   public void setCom_nr_valor(double com_nr_valor) {
/* 35 */     this.com_nr_valor = com_nr_valor;
/*    */   }
/*    */   
/*    */   public double getCom_nr_valor() {
/* 39 */     return this.com_nr_valor;
/*    */   }
/*    */   
/*    */   public void setObr_nr_id(int obr_nr_id) {
/* 43 */     this.obr_nr_id = obr_nr_id;
/*    */   }
/*    */   
/*    */   public int getObr_nr_id() {
/* 47 */     return this.obr_nr_id;
/*    */   }
/*    */   
/*    */   public void setCom_nr_mes(int com_nr_mes) {
/* 51 */     this.com_nr_mes = com_nr_mes;
/*    */   }
/*    */   
/*    */   public int getCom_nr_mes() {
/* 55 */     return this.com_nr_mes;
/*    */   }
/*    */   
/*    */   public void setCom_nr_ano(int com_nr_ano) {
/* 59 */     this.com_nr_ano = com_nr_ano;
/*    */   }
/*    */   
/*    */   public int getCom_nr_ano() {
/* 63 */     return this.com_nr_ano;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Date getCom_dt_base()
/*    */   {
/* 70 */     return this.com_dt_base;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setCom_dt_base(Date com_dt_base)
/*    */   {
/* 77 */     this.com_dt_base = com_dt_base;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isPrevisto()
/*    */   {
/* 84 */     return this.previsto;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setPrevisto(boolean previsto)
/*    */   {
/* 91 */     this.previsto = previsto;
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Com_comprometimentoT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */