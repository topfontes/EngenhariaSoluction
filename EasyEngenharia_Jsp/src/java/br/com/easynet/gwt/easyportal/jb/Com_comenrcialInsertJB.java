/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Com_comenrcialDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Com_comenrcialT;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Com_comenrcialInsertJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 17 */   private Com_comenrcialT com_comenrcialT = new Com_comenrcialT();
/*    */   
/*    */   public void setCom_comenrcialT(Com_comenrcialT com_comenrcialT) {
/* 20 */     this.com_comenrcialT = com_comenrcialT;
/*    */   }
/*    */   
/*    */   public Com_comenrcialT getCom_comenrcialT() {
/* 24 */     return this.com_comenrcialT;
/*    */   }
/*    */   
/*    */   public void pageLoad() throws Exception
/*    */   {
/* 29 */     super.pageLoad();
/*    */   }
/*    */   
/*    */   public void insert()
/*    */     throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 37 */       Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/* 38 */       com_comenrcialDAO.insert(this.com_comenrcialT);
/* 39 */       setMsg("msg", "Cadastro efetuado com sucesso!");
/* 40 */       clear();
/*    */     } catch (Exception e) {
/* 42 */       e.printStackTrace();
/* 43 */       setMsg("errorMessage", "Falha ao realizar cadastro!");
/*    */     } finally {
/* 45 */       close();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void clear()
/*    */     throws Exception
/*    */   {
/* 55 */     this.com_comenrcialT = new Com_comenrcialT();
/*    */   }
/*    */   
/*    */   public void cancel() throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 62 */       String page = "com_comenrcialConsult.jsp";
/* 63 */       getResponse().sendRedirect(page);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Com_comenrcialInsertJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */