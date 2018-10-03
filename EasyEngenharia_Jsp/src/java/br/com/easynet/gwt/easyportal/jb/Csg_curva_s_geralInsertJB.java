/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Csg_curva_s_geralDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Csg_curva_s_geralT;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Csg_curva_s_geralInsertJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 17 */   private Csg_curva_s_geralT csg_curva_s_geralT = new Csg_curva_s_geralT();
/*    */   
/*    */   public void setCsg_curva_s_geralT(Csg_curva_s_geralT csg_curva_s_geralT) {
/* 20 */     this.csg_curva_s_geralT = csg_curva_s_geralT;
/*    */   }
/*    */   
/*    */   public Csg_curva_s_geralT getCsg_curva_s_geralT() {
/* 24 */     return this.csg_curva_s_geralT;
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
/* 37 */       Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/* 38 */       csg_curva_s_geralDAO.insert(this.csg_curva_s_geralT);
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
/* 55 */     this.csg_curva_s_geralT = new Csg_curva_s_geralT();
/*    */   }
/*    */   
/*    */   public void cancel() throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 62 */       String page = "csg_curva_s_geralConsult.jsp";
/* 63 */       getResponse().sendRedirect(page);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Csg_curva_s_geralInsertJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */