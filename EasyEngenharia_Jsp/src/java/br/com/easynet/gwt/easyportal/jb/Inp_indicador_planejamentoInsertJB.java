/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Inp_indicador_planejamentoDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Inp_indicador_planejamentoT;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Inp_indicador_planejamentoInsertJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 17 */   private Inp_indicador_planejamentoT inp_indicador_planejamentoT = new Inp_indicador_planejamentoT();
/*    */   
/*    */   public void setInp_indicador_planejamentoT(Inp_indicador_planejamentoT inp_indicador_planejamentoT) {
/* 20 */     this.inp_indicador_planejamentoT = inp_indicador_planejamentoT;
/*    */   }
/*    */   
/*    */   public Inp_indicador_planejamentoT getInp_indicador_planejamentoT() {
/* 24 */     return this.inp_indicador_planejamentoT;
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
/* 37 */       Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/* 38 */       inp_indicador_planejamentoDAO.insert(this.inp_indicador_planejamentoT);
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
/* 55 */     this.inp_indicador_planejamentoT = new Inp_indicador_planejamentoT();
/*    */   }
/*    */   
/*    */   public void cancel() throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 62 */       String page = "inp_indicador_planejamentoConsult.jsp";
/* 63 */       getResponse().sendRedirect(page);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Inp_indicador_planejamentoInsertJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */