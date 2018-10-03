/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Rep_resumo_planejamentoDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Rep_resumo_planejamentoT;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Rep_resumo_planejamentoInsertJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 17 */   private Rep_resumo_planejamentoT rep_resumo_planejamentoT = new Rep_resumo_planejamentoT();
/*    */   
/*    */   public void setRep_resumo_planejamentoT(Rep_resumo_planejamentoT rep_resumo_planejamentoT) {
/* 20 */     this.rep_resumo_planejamentoT = rep_resumo_planejamentoT;
/*    */   }
/*    */   
/*    */   public Rep_resumo_planejamentoT getRep_resumo_planejamentoT() {
/* 24 */     return this.rep_resumo_planejamentoT;
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
/* 37 */       Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/* 38 */       rep_resumo_planejamentoDAO.insert(this.rep_resumo_planejamentoT);
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
/* 55 */     this.rep_resumo_planejamentoT = new Rep_resumo_planejamentoT();
/*    */   }
/*    */   
/*    */   public void cancel() throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 62 */       String page = "rep_resumo_planejamentoConsult.jsp";
/* 63 */       getResponse().sendRedirect(page);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Rep_resumo_planejamentoInsertJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */