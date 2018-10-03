/*    */ package br.com.easynet.gwt.easyportal.transfer;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Nfe_nota_fiscal_entradaT {
/*    */   private int nfe_nr_id;
/*    */   @br.com.easynet.annotation.Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*    */   private Date nfe_dt_emissao;
/*    */   private int for_nr_id;
/*    */   private float nfe_nr_valor_nota;
/*    */   
/* 12 */   public void setNfe_nr_id(int nfe_nr_id) { this.nfe_nr_id = nfe_nr_id; }
/*    */   
/*    */   public int getNfe_nr_id()
/*    */   {
/* 16 */     return this.nfe_nr_id;
/*    */   }
/*    */   
/* 19 */   public void setNfe_dt_emissao(Date nfe_dt_emissao) { this.nfe_dt_emissao = nfe_dt_emissao; }
/*    */   
/*    */   public Date getNfe_dt_emissao()
/*    */   {
/* 23 */     return this.nfe_dt_emissao;
/*    */   }
/*    */   
/* 26 */   public void setFor_nr_id(int for_nr_id) { this.for_nr_id = for_nr_id; }
/*    */   
/*    */   public int getFor_nr_id()
/*    */   {
/* 30 */     return this.for_nr_id;
/*    */   }
/*    */   
/* 33 */   public void setNfe_nr_valor_nota(float nfe_nr_valor_nota) { this.nfe_nr_valor_nota = nfe_nr_valor_nota; }
/*    */   
/*    */   public float getNfe_nr_valor_nota()
/*    */   {
/* 37 */     return this.nfe_nr_valor_nota;
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Nfe_nota_fiscal_entradaT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */