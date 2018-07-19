/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Com_comenrcialDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Com_comenrcialT;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Com_comenrcialConsultJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 17 */   private Com_comenrcialT com_comenrcialT = new Com_comenrcialT();
/*    */   private List<Com_comenrcialT> list;
/*    */   
/* 20 */   public void setCom_comenrcialT(Com_comenrcialT com_comenrcialT) { this.com_comenrcialT = com_comenrcialT; }
/*    */   
/*    */   public Com_comenrcialT getCom_comenrcialT()
/*    */   {
/* 24 */     return this.com_comenrcialT;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Com_comenrcialT> getList()
/*    */   {
/* 32 */     return this.list;
/*    */   }
/*    */   
/*    */   public void setList(List<Com_comenrcialT> list) {
/* 36 */     this.list = list;
/*    */   }
/*    */   
/*    */   public void pageLoad() throws Exception {
/* 40 */     super.pageLoad();
/* 41 */     consult();
/*    */   }
/*    */   
/*    */   public void consult() throws Exception {
/*    */     try {
/* 46 */       Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/* 47 */       this.list = com_comenrcialDAO.getAll(this.obr_nr_id, this.mes, this.ano);
/*    */     } catch (Exception e) {
/* 49 */       e.printStackTrace();
/* 50 */       setMsg("errorMessage", "Falha ao realizar consulta!");
/*    */     } finally {
/* 52 */       close();
/*    */     }
/*    */   }
/*    */   
/*    */   public void delete() throws Exception {
/*    */     try {
/* 58 */       Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/* 59 */       com_comenrcialDAO.delete(this.com_comenrcialT);
/* 60 */       setMsg("Exclusao efetuada com sucesso!");
/* 61 */       this.com_comenrcialT = new Com_comenrcialT();
/* 62 */       consult();
/*    */     } catch (Exception e) {
/* 64 */       e.printStackTrace();
/* 65 */       setMsg("errorMessage", "Falha ao realizar exclusao!");
/*    */     } finally {
/* 67 */       close();
/*    */     }
/*    */   }
/*    */   
/*    */   public void insert() throws Exception
/*    */   {
/*    */     try {
/* 74 */       String page = "com_comenrcialInsert.jsp";
/* 75 */       getResponse().sendRedirect(page);
/*    */     } catch (Exception localException) {}
/*    */   }
/*    */   
/*    */   public void cancel() throws Exception {
/*    */     try {
/* 81 */       String page = "";
/* 82 */       getResponse().sendRedirect(page);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Com_comenrcialConsultJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */