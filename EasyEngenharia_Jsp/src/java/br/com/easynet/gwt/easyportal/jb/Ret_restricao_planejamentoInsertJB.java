/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Ret_restricao_planejamentoDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Ret_restricao_planejamentoT;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Ret_restricao_planejamentoInsertJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 17 */   private Ret_restricao_planejamentoT ret_restricao_planejamentoT = new Ret_restricao_planejamentoT();
/*    */   
/*    */   public void setRet_restricao_planejamentoT(Ret_restricao_planejamentoT ret_restricao_planejamentoT) {
/* 20 */     this.ret_restricao_planejamentoT = ret_restricao_planejamentoT;
/*    */   }
/*    */   
/*    */   public Ret_restricao_planejamentoT getRet_restricao_planejamentoT() {
/* 24 */     return this.ret_restricao_planejamentoT;
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
/* 37 */       Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/* 38 */       ret_restricao_planejamentoDAO.insert(this.ret_restricao_planejamentoT);
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
/* 55 */     this.ret_restricao_planejamentoT = new Ret_restricao_planejamentoT();
/*    */   }
/*    */   
/*    */   public void cancel() throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 62 */       String page = "ret_restricao_planejamentoConsult.jsp";
/* 63 */       getResponse().sendRedirect(page);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Ret_restricao_planejamentoInsertJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */