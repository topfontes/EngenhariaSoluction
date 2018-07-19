/*    */ package br.com.easynet.gwt.easyportal.transfer;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Csg_curva_s_geralT {
/*    */   private int csg_nr_id;
/*    */   private int obr_nr_id;
/*    */   private int csg_nr_mes;
/*    */   private int csg_nr_ano;
/*    */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*    */   private Date csg_nr_mes_plan;
/*    */   private float csg_nr_acumulado_plan_po;
/*    */   private float csg_nr_fisico_acumulado_panejado_base;
/*    */   private float csg_nr_fisico_acumulado_trab_atual;
/*    */   private float csg_nr_fisico_acumulado_trab_projetado;
/*    */   private float csg_nr_fisico_acumulado_atual_projetado;
/*    */   
/*    */   public void setCsg_nr_id(int csg_nr_id) {
/* 19 */     this.csg_nr_id = csg_nr_id;
/*    */   }
/*    */   
/*    */   public int getCsg_nr_id() {
/* 23 */     return this.csg_nr_id;
/*    */   }
/*    */   
/* 26 */   public void setObr_nr_id(int obr_nr_id) { this.obr_nr_id = obr_nr_id; }
/*    */   
/*    */   public int getObr_nr_id()
/*    */   {
/* 30 */     return this.obr_nr_id;
/*    */   }
/*    */   
/* 33 */   public void setCsg_nr_mes(int csg_nr_mes) { this.csg_nr_mes = csg_nr_mes; }
/*    */   
/*    */   public int getCsg_nr_mes()
/*    */   {
/* 37 */     return this.csg_nr_mes;
/*    */   }
/*    */   
/* 40 */   public void setCsg_nr_ano(int csg_nr_ano) { this.csg_nr_ano = csg_nr_ano; }
/*    */   
/*    */   public int getCsg_nr_ano()
/*    */   {
/* 44 */     return this.csg_nr_ano;
/*    */   }
/*    */   
/* 47 */   public void setCsg_nr_mes_plan(Date csg_nr_mes_plan) { this.csg_nr_mes_plan = csg_nr_mes_plan; }
/*    */   
/*    */   public Date getCsg_nr_mes_plan()
/*    */   {
/* 51 */     return this.csg_nr_mes_plan;
/*    */   }
/*    */   
/*    */   public void setCsg_nr_acumulado_plan_po(float csg_nr_acumulado_plan_po) {
/* 55 */     this.csg_nr_acumulado_plan_po = csg_nr_acumulado_plan_po;
/*    */   }
/*    */   
/*    */   public float getCsg_nr_acumulado_plan_po() {
/* 59 */     return this.csg_nr_acumulado_plan_po;
/*    */   }
/*    */   
/* 62 */   public void setCsg_nr_fisico_acumulado_panejado_base(float csg_nr_fisico_acumulado_panejado_base) { this.csg_nr_fisico_acumulado_panejado_base = csg_nr_fisico_acumulado_panejado_base; }
/*    */   
/*    */   public float getCsg_nr_fisico_acumulado_panejado_base()
/*    */   {
/* 66 */     return this.csg_nr_fisico_acumulado_panejado_base;
/*    */   }
/*    */   
/* 69 */   public void setCsg_nr_fisico_acumulado_trab_atual(float csg_nr_fisico_acumulado_trab_atual) { this.csg_nr_fisico_acumulado_trab_atual = csg_nr_fisico_acumulado_trab_atual; }
/*    */   
/*    */   public float getCsg_nr_fisico_acumulado_trab_atual()
/*    */   {
/* 73 */     return this.csg_nr_fisico_acumulado_trab_atual;
/*    */   }
/*    */   
/* 76 */   public void setCsg_nr_fisico_acumulado_trab_projetado(float csg_nr_fisico_acumulado_trab_projetado) { this.csg_nr_fisico_acumulado_trab_projetado = csg_nr_fisico_acumulado_trab_projetado; }
/*    */   
/*    */   public float getCsg_nr_fisico_acumulado_trab_projetado()
/*    */   {
/* 80 */     return this.csg_nr_fisico_acumulado_trab_projetado;
/*    */   }
/*    */   
/* 83 */   public void setCsg_nr_fisico_acumulado_atual_projetado(float csg_nr_fisico_acumulado_atual_projetado) { this.csg_nr_fisico_acumulado_atual_projetado = csg_nr_fisico_acumulado_atual_projetado; }
/*    */   
/*    */   public float getCsg_nr_fisico_acumulado_atual_projetado()
/*    */   {
/* 87 */     return this.csg_nr_fisico_acumulado_atual_projetado;
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Csg_curva_s_geralT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */